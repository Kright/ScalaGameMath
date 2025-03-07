package com.github.kright.pga3d

import com.github.kright.math.EqualityEps
import org.scalactic.{Equality, TolerantNumerics}
import org.scalatest.funsuite.AnyFunSuiteLike
import org.scalatestplus.scalacheck.ScalaCheckPropertyChecks

class Pga3dInertiaLocalTest extends AnyFunSuiteLike with ScalaCheckPropertyChecks:
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

//    println(maxError)

    assert(maxError < Pga3dOneBodyWithInertiaLocal.Error(errorE = 6e-11, errorL = 1e-9))
  }

  test("calculate free rotation body precession for RK4 v2") {
    val stepsCount = 1000
    val forque = Pga3dBivector()

    val motors = Seq(
      Pga3dMotor.id,
      Pga3dTranslator.addVector(Pga3dVector(1, 0, 0)).toMotor,
      Pga3dTranslator.addVector(Pga3dVector(0, 1, 0)).toMotor,
      Pga3dTranslator.addVector(Pga3dVector(0, 0, 1)).toMotor,
      Pga3dTranslator.addVector(Pga3dVector(1, 2, 3)).toMotor,
      Pga3dQuaternion.rotation(Pga3dVector(1, 0, 0), Pga3dVector(0, 1, 0)).toMotor,
      Pga3dQuaternion.rotation(Pga3dVector(1, 0, 0), Pga3dVector(0, 1, 1)).toMotor,
      Pga3dQuaternion.rotation(Pga3dVector(1, 0, 0), Pga3dVector(0, 1, 1)).geometric(Pga3dTranslator.addVector(Pga3dVector(1, 2, 3)).toMotor),
    )

    for (motor <- motors) {
      val maxError = testOneBodySimple123v2(motor, stepsCount, body => {
        body.doStepRK4(dt = 0.01, forque)
        body.getError()
      }).reduce(_ max _)

//      println(s"maxError = $maxError, motor = $motor")
      assert(maxError < Pga3dOneBodyWithInertiaLocal.Error(errorE = 6e-11, errorL = 1e-9))
    }
  }


  test("getAcceleration test") {
    val localB = Pga3dBivector(0.1, 0.2, 0.3, 0.4, 0.5, 0.6)
    val localForque = Pga3dBivector(0.7, 0.8, 0.9, 1.0, 1.1, 1.2)

    val err0 = {
      val body = Pga3dOneBodyWithInertiaLocal.simple123()
      val acc = body.inertia.getAcceleration(localB, localForque)
      val accNaive = body.inertia.invert(localB.cross(body.inertia(localB)) + localForque)
      val err = (acc - accNaive).norm
      assert(err < 2e-16)
      err
    }

    val err1 = {
      val body = Pga3dOneBodyWithInertia.simple123(Pga3dMotor.id)
      val acc = body.inertia.getAcceleration(localB, localForque)
      val accNaive = body.inertia.invert(localB.cross(body.inertia(localB)) + localForque)
      val err = (acc - accNaive).norm
      assert(err < 2e-16)
      err
    }

    assert(err0 == err1)
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

  private def testOneBodySimple123[T](stepsCount: Int, doStep: Pga3dOneBodyWithInertiaLocal => T): Iterable[T] = {
    val body = Pga3dOneBodyWithInertiaLocal.simple123()

    assert(body.initialE == 3.0)
    assert(body.initialL == Pga3dBivector(wx = 3.0, wy = 2.0, wz = 1.0))

    for (_ <- 0 until stepsCount)
      yield doStep(body)
  }

  private def testOneBodySimple123v2[T](motor: Pga3dMotor, stepsCount: Int, doStep: Pga3dOneBodyWithInertia => T): Iterable[T] = {
    val body = Pga3dOneBodyWithInertia.simple123(motor)

    assert(Math.abs(body.initialE - 3.0) < 1e-14, s"initialE = ${body.initialL}")
    assert((body.initialL - Pga3dBivector(wx = 3.0, wy = 2.0, wz = 1.0)).norm < 3e-15, s"initialL = ${body.initialL}")

    for (_ <- 0 until stepsCount)
      yield doStep(body)
  }

  test("calculate energy accumulation for linear force during rotation") {
    val dt = 0.01
    val stepsCount = 100

    val forceDirection = Pga3dPlaneIdeal(x = 1.0, y = 0, z = 0)
    val body = Pga3dOneBodyWithInertiaLocal.simple123()

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

      val err = Pga3dOneBodyWithInertiaLocal.Error(errorE = math.abs(expectedEnergy - body.getEnergy()), errorL = (accumulatedL - body.getL()).norm)
      err
    }

    val maxError = errors.reduce(_ max _)
    assert(maxError < Pga3dOneBodyWithInertiaLocal.Error(2e-9, 4e-9))

    val endPoint = body.state.center
    val expectedPoint = Pga3dPlane(w = 1.0, x = 0.5).dual

    assert((endPoint - expectedPoint).norm < 2e-9)
  }

  test("calculate energy accumulation for linear spring") {
    val dt = 0.01
    val stepsCount = 1000

    val mass = 10.0

    val body = new Pga3dOneBodyWithInertiaLocal(
      Pga3dInertiaLocal(mass, 1.0, 1.0, 1.0),
      Pga3dState.zero,
    )

    val springCenter = Pga3dPlane(3.0, 4.0, w = 1).dual // len 5
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
          val localForque = (Pga3dPoint() v localSpringPos) * springK
          localForque
        }
        assert((localForque1 - localForque2).norm < 1e-10)

        localForque1
      })

      val expectedPos = springCenter - (springCenter.weight * Math.cos(t * Math.sqrt(springK / mass))).toTrivector

      val dE = math.abs(initialEnergy - getEnergy()) / initialEnergy
      val dPos = (expectedPos - body.state.center).norm

      assert(dE <= 1.2e-10)
      assert(dPos <= 2.4e-8)
    }
  }
