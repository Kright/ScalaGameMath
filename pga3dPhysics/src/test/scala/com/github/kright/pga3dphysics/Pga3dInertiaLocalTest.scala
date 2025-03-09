package com.github.kright.pga3dphysics

import com.github.kright.math.EqualityEps
import com.github.kright.pga3d.*
import org.scalactic.{Equality, TolerantNumerics}
import org.scalatest.funsuite.AnyFunSuiteLike
import org.scalatestplus.scalacheck.ScalaCheckPropertyChecks

class Pga3dInertiaLocalTest extends AnyFunSuiteLike with ScalaCheckPropertyChecks:
  private val eps = 1e-12

  private given doubleEquality: Equality[Double] = TolerantNumerics.tolerantDoubleEquality(eps)

  private given equalityEps: EqualityEps = EqualityEps(eps)

  test("calculate free rotation body precession for RK4 v3") {
    val stepsCount = 1000
    val dt = 0.01
    val forque = Pga3dBivector()

    val system = Pga3dPhysicsSystem(Array(Pga3dPhysicsSystem.simpleBody(Pga3dMotor.id)), Pga3dPhysicsSolverRK4)

    assert(system.initialE == 3.0)
    assert(system.initialL == Pga3dBivector(wx = 3.0, wy = 2.0, wz = 1.0))

    val errors = for (_ <- 0 until stepsCount)
      yield {
        system.doStep(dt, _ => ())
        system.getError()
      }

    val maxError = errors.reduce(_ max _)

    assert(maxError < ErrorOfEnergyAndMomentum(errorE = 6e-11, errorL = 1e-9))
  }

  test("calculate free rotation body precession for RK4 for different orientation") {
    val stepsCount = 1000
    val dt = 0.01
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
      val body = Pga3dPhysicsSystem.simpleBody(motor)
      val system = Pga3dPhysicsSystem(Array(body), Pga3dPhysicsSolverRK4)

      val maxError = (for (_ <- 0 until stepsCount) yield {
        system.doStep(dt, _ => ())
        system.getError()
      }).reduce(_ max _)

      assert(maxError < ErrorOfEnergyAndMomentum(errorE = 6e-11, errorL = 1e-9))
    }
  }

  test("getAcceleration test") {
    val localB = Pga3dBivector(0.1, 0.2, 0.3, 0.4, 0.5, 0.6)
    val localForque = Pga3dBivector(0.7, 0.8, 0.9, 1.0, 1.1, 1.2)
    val body = Pga3dPhysicsSystem.simpleBody(Pga3dMotor.id)
    val system = Pga3dPhysicsSystem(Array(body), Pga3dPhysicsSolverRK4)
    val acc = body.inertia.getAcceleration(localB, localForque)
    val accNaive = body.inertia.invert(localB.cross(body.inertia(localB)) + localForque)
    val err = (acc - accNaive).norm
    assert(err < 2e-16)
    assert(err == 0.0) // It could be higher, but test fixes current behavior
  }

  test("calculate performance") {
    if (false) {
      val stepsCount = 10_000_000

      val body = Pga3dPhysicsSystem.simpleBody(Pga3dMotor.id)
      val system = Pga3dPhysicsSystem(Array(body), Pga3dPhysicsSolverRK4)

      assert(system.initialE == 3.0)
      assert(system.initialL == Pga3dBivector(wx = 3.0, wy = 2.0, wz = 1.0))

      val start = System.nanoTime()
      for (_ <- 0 until stepsCount) {
        system.doStep(dt = 0.001, _ => ())
      }
      val end = System.nanoTime()
      println(s"dt = ${(end - start) / stepsCount}ns")
      println(system.state.head)
    }
  }

  test("calculate energy accumulation for linear force during rotation") {
    val dt = 0.01
    val stepsCount = 100

    val forceDirection = Pga3dPlaneIdeal(x = 1.0, y = 0, z = 0)
    val body = Pga3dPhysicsSystem.simpleBody(Pga3dMotor.id)
    val system = Pga3dPhysicsSystem(Array(body), Pga3dPhysicsSolverRK4)

    assert(system.initialE == 3.0)
    assert(system.initialL == Pga3dBivector(wx = 3.0, wy = 2.0, wz = 1.0))

    var accumulatedL = system.initialL

    val errors = for (step <- 1 to stepsCount) yield {
      val t = step * dt

      val bodyCenter = system.state.head.globalCenter
      val globalForque = bodyCenter.dot(forceDirection)
      system.doStep(dt, _ => system.state.head.addGlobalForque(globalForque))

      val expectedEnergy = system.initialE + 0.5 * forceDirection.normSquare * t * t / body.inertia.mass
      accumulatedL += globalForque * dt

      val err = ErrorOfEnergyAndMomentum(errorE = math.abs(expectedEnergy - system.getKineticEnergy()), errorL = (accumulatedL - system.getL()).norm)
      err
    }

    val maxError = errors.reduce(_ max _)
    assert(maxError < ErrorOfEnergyAndMomentum(2e-9, 4e-9))

    val endPoint = system.state.head.globalCenter
    val expectedPoint = Pga3dPlane(w = 1.0, x = 0.5).dual

    assert((endPoint - expectedPoint).norm < 2e-9)
  }

  test("calculate energy accumulation for linear spring") {
    val dt = 0.01
    val stepsCount = 1000
    val mass = 10.0

    val body = Pga3dPhysicsBody.motionless(
      Pga3dInertiaLocal(mass, 1.0, 1.0, 1.0),
      Pga3dMotor.id,
    )

    val system = Pga3dPhysicsSystem(Array(body), Pga3dPhysicsSolverRK4)

    val springCenter = Pga3dPlane(3.0, 4.0, w = 1).dual // len 5
    val springK = 20

    def getEnergy(): Double =
      (system.state.head.globalCenter - springCenter).normSquare * 0.5 * springK + system.getKineticEnergy()

    val initialEnergy = getEnergy()

    for (step <- 1 to stepsCount) {
      val t = step * dt

      system.doStep(dt, _ => {
        val globalForque = (system.state.head.globalCenter v springCenter) * springK
        system.state.head.addGlobalForque(globalForque)
      })

      val expectedPos = springCenter - (springCenter.weight * Math.cos(t * Math.sqrt(springK / mass))).toTrivector

      val dE = math.abs(initialEnergy - getEnergy()) / initialEnergy
      val dPos = (expectedPos - system.state.head.globalCenter).norm

      assert(dE <= 1.2e-10)
      assert(dPos <= 2.4e-8)
    }
  }
