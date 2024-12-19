package com.github.kright.pga3d

import com.github.kright.math.EqualityEps
import org.scalactic.{Equality, TolerantNumerics}
import org.scalatest.funsuite.AnyFunSuiteLike
import org.scalatestplus.scalacheck.ScalaCheckPropertyChecks

class PGA3DInertiaTest extends AnyFunSuiteLike with ScalaCheckPropertyChecks:
  private val eps = 1e-12

  private given doubleEquality: Equality[Double] = TolerantNumerics.tolerantDoubleEquality(eps)

  private given equalityEps: EqualityEps = EqualityEps(eps)

  test("calculate free rotation body precession for RK4") {
    val stepsCount = 1000
    val forque = Pga3dBivector()

    val maxError = testOneBodySimple123(stepsCount, body => {
      body.doStepRK4(dt = 0.01, forque)
      body.getError()
    }).reduce(_ max _)

    assert(maxError < PGA3OneBody.Error(errorE = 6e-11, errorL = 1e-9))
  }

  test("getAcceleration test") {
    val body = PGA3OneBody.simple123()

    val localB = Pga3dBivector(0.1, 0.2, 0.3, 0.4, 0.5, 0.6)
    val localForque = Pga3dBivector(0.7, 0.8, 0.9, 1.0, 1.1, 1.2)

    val acc = body.inertia.getAcceleration(localB, localForque)
    val accNaive = body.inertia.invert(localB.cross(body.inertia(localB)) + localForque)

    assert((acc - accNaive).norm < 2e-16)
  }

  //  test("calculate performance") {
  //    val stepsCount = 10_000_000
  //    val forque = Bivector()
  //
  //    val body = PGA3OneBody.simple123()
  //
  //    assert(body.initialE == 3.0)
  //    assert(body.initialL == Bivector(wx = 3.0, wy = 2.0, wz = 1.0))
  //
  //    val start = System.nanoTime()
  //    for (_ <- 0 until stepsCount) {
  //      body.doStepRK4(dt = 0.001, forque)
  //    }
  //    val end = System.nanoTime()
  //    println(s"dt = ${(end - start) / stepsCount}ns")
  //  }

  private def testOneBodySimple123[T](stepsCount: Int, doStep: PGA3OneBody => T): Iterable[T] = {
    val body = PGA3OneBody.simple123()

    assert(body.initialE == 3.0)
    assert(body.initialL == Pga3dBivector(wx = 3.0, wy = 2.0, wz = 1.0))

    for (_ <- 0 until stepsCount)
      yield doStep(body)
  }

  test("calculate energy accumulation for linear force during rotation") {
    val dt = 0.01
    val stepsCount = 100

    val forceDirection = Pga3dPlaneIdeal(x = 1.0, y = 0, z = 0)
    val body = PGA3OneBody.simple123()

    assert(body.initialE == 3.0)
    assert(body.initialL == Pga3dBivector(wx = 3.0, wy = 2.0, wz = 1.0))

    var accumulatedL = body.initialL

    val errors = for (step <- 1 to stepsCount) yield {
      val t = step * dt

      val bodyCenter = body.state.center
      val globalForque = bodyCenter.dot(forceDirection)
      body.doStepRK4(dt, globalForque)

      val expectedEnergy = body.initialE + 0.5 * forceDirection.normSquare * t * t / body.inertia.mass
      accumulatedL += globalForque * dt

      val err = PGA3OneBody.Error(errorE = math.abs(expectedEnergy - body.getEnergy()), errorL = (accumulatedL - body.getL()).norm)
      err
    }

    val maxError = errors.reduce(_ max _)
    assert(maxError < PGA3OneBody.Error(2e-9, 4e-9))

    val endPoint = body.state.center
    val expectedPoint = Pga3dPlane(w = 1.0, x = 0.5).dual

    assert((endPoint - expectedPoint).norm < 2e-9)
  }

  test("calculate energy accumulation for linear spring") {
    val dt = 0.01
    val stepsCount = 1000

    val mass = 10.0

    val body = new PGA3OneBody(
      Pga3dInertia(mass, 1.0, 1.0, 1.0),
      PGA3State.zero,
    )

    val springCenter = Pga3dPlane(w = 1, 3.0, 4.0).dual // len 5
    val springK = 20

    def getEnergy(): Double = (body.state.center - springCenter).normSquare * 0.5 * springK + body.getEnergy()

    val initialEnergy = getEnergy()

    for (step <- 1 to stepsCount) {
      val t = step * dt

      body.doStepRK4F(dt, getLocalForque = (state, time) => {
        val localForque1 = {
          val bodyCenter = state.center
          val globalForque = (bodyCenter v springCenter) * springK
          val localForque = state.motor.reverse.sandwich(globalForque)
          localForque
        }
        val localForque2 = {
          val localSpringPos = state.motor.reverse.sandwich(springCenter)
          val localForque = (Pga3dPointNormalized() v localSpringPos) * springK
          localForque
        }
        assert((localForque1 - localForque2).norm < 1e-10)

        localForque1
      })

      val expectedPos = springCenter - (springCenter.weight * Math.cos(t * Math.sqrt(springK / mass))).toPoint

      val dE = math.abs(initialEnergy - getEnergy()) / initialEnergy
      val dPos = (expectedPos - body.state.center).norm

      assert(dE <= 1.2e-10)
      assert(dPos <= 2.4e-8)
    }
  }
