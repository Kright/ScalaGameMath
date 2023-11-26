package com.kright.physics3d

import com.kright.math.VectorMathGenerators.*
import com.kright.math.{DifferentialSolvers, Vector3d, VectorMathGenerators}
import com.kright.physics3d.PhysicsGenerators.*
import org.scalactic.{Equality, TolerantNumerics}
import org.scalatest.funsuite.AnyFunSuite
import org.scalatestplus.scalacheck.ScalaCheckPropertyChecks

class InertiaTest extends AnyFunSuite with ScalaCheckPropertyChecks:
  test("localI to globalI conversion") {
    forAll(inertiaMoments, normalizedQuaternions, vectors3InCube) { (I, rot, rotVelocity) =>
      val inertia = Inertia3d(1.0, I)

      val localRotVelocity = rot.conjugated() * rotVelocity

      val L1 = rot * (inertia.localI * localRotVelocity)
      val L2 = inertia.getGlobalI(rot) * rotVelocity
      val L3 = inertia.getL(rot, rotVelocity)

      assert(L1.isEquals(L2))
      assert(L1.isEquals(L3))
    }
  }

  test("get energy by different ways") {
    forAll(bodies) { (inertia, state) =>
      state.velocity.linear := (0, 0, 0)

      val w = state.velocity.angular

      val explicitEnergy = inertia.getEnergy(state)
      // E = 1/2 * w dot L
      val energyWdotL = 0.5 * (w dot inertia.getL(state))
      val energyWdotIW = 0.5 * (w dot (inertia.getGlobalI(state) * state.velocity.angular))

      implicit val doubleEquality: Equality[Double] = TolerantNumerics.tolerantDoubleEquality(1e-6)
      assert(explicitEnergy === energyWdotL)
      assert(explicitEnergy === energyWdotIW)
    }
  }

  test("energy and impulse are constant during rotation") {
    forAll(inertiaMoments, states) { (I, s) =>

      for (solverType <- Seq(SolverType.Euler2, SolverType.RK2, SolverType.RK4Incorrect, SolverType.RK4)) {
        val body = Inertia3d(1.0, I)
        val initialImpulse = body.getImpulse(s)
        val initialE = body.getEnergy(s)
        val zeroForce = Force3d()

        for (_ <- 0 until 1000) {
          val dt = 0.001
          updateFreeBody(solverType, body, s, dt, zeroForce)
          val currentImpulse = body.getImpulse(s)
          val currentE = body.getEnergy(s)

          assert(Math.abs(currentE - initialE) < 0.001, s"solver $solverType failed")
          assert(currentImpulse.linear.distance(initialImpulse.linear) < 0.001, s"solver $solverType failed")
          assert(currentImpulse.angular.distance(initialImpulse.angular) < 0.001, s"solver $solverType failed")
        }
      }
    }
  }

  test("add impulse by force") {
    forAll(inertia3d, states, vectors3InCube, vectors3InCube) { (body, state, force, torque) =>
      for (solverType <- Seq(SolverType.Euler2, SolverType.RK2, SolverType.RK4Incorrect, SolverType.RK4)) {
        val initialImpulse = body.getImpulse(state)
        val forces = Force3d().addForce(force).addTorque(torque)
        var t = 0.0

        for (_ <- 0 until 1000) {
          val dt = 0.001
          updateFreeBody(solverType, body, state, dt, forces)
          t += dt
          val currentImpulse = body.getImpulse(state)

          assert(currentImpulse.linear.distance(initialImpulse.linear + forces.linear * t) < 0.001, s"solver $solverType failed")
          assert(currentImpulse.angular.distance(initialImpulse.angular + forces.torque * t) < 0.001, s"solver $solverType failed")
        }
      }
    }
  }

  /**
   */
  private def updateFreeBody(solver: SolverType, body: Inertia3d, state: State3d, dt: Double, force: Force3d): Unit =
    val newState =
      solver match
        case SolverType.RK4 =>
          val (k1, k2, k3, k4) = DifferentialSolvers.rungeKutta4K(state, time = 0.0, dt,
            getDerivative = (state, time) => State3dDerivative(state, body, force),
            nextState = (state, derivative, dt) => state.copy().madd(derivative, dt).normalize(),
          )
          state.copy()
            .madd(k1, dt * (1.0 / 6.0))
            .madd(k2, dt * (2.0 / 6.0))
            .madd(k3, dt * (2.0 / 6.0))
            .madd(k4, dt * (1.0 / 6.0))
            .normalize()
        case SolverType.RK4Incorrect =>
          // actually it has second order of precision, like RK2.
          // Because true derivative of quaternion is a quaternion, not a vector of angular speed.
          DifferentialSolvers.rungeKutta4(state, time = 0.0, dt,
            getDerivative = (state, time) => body.getDerivative(state, force),
            nextState = (state, derivative, dt) => state.copy().madd(derivative, dt),
            newZeroDerivative = () => State3dDerivative(),
            madd = (acc, d, m) => acc.madd(d, m)
          )
        case SolverType.RK2 =>
          DifferentialSolvers.rungeKutta2(state, time = 0.0, dt,
            getDerivative = (state, time) => body.getDerivative(state, force),
            nextState = (state, derivative, dt) => state.copy().madd(derivative, dt),
          )
        case SolverType.Euler2 =>
          DifferentialSolvers.euler2(state, time = 0.0, dt,
            getDerivative = (state, time) => body.getDerivative(state, force),
            nextState = (state, derivative, dt) => state.copy().madd(derivative, dt),
            newZeroDerivative = () => State3dDerivative(),
            madd = (acc, d, m) => acc.madd(d, m)
          )
    state := newState

  test("get L for symmetric body") {
    val m = 3.0
    val body = Inertia3d(m, Vector3d(m, m, m))

    forAll(normalizedQuaternions, vectors3InCube) { (rot, w) =>
      val expectedL = w * m
      val L = body.getL(rot, w)
      assert(L.isEquals(expectedL))
    }
  }

  test("add impulse") {
    forAll(inertia3d, states, vectors3InCube, vectors3InCube) { (body, state, linear, angular) =>
      val addImpulse = Impulse3d(linear, angular)
      val initialImpulse = body.getImpulse(state)
      val newState = state.updated(body, addImpulse)
      val newImpulse = body.getImpulse(newState)

      assert(newImpulse.linear.isEquals(initialImpulse.linear + addImpulse.linear))
      assert(newImpulse.angular.isEquals(initialImpulse.angular + addImpulse.angular))
    }
  }

  test("Precision of Euler2") {
    val (de, dl) = getMaxRelativeErrors(SolverType.Euler2, 0.01, 10000)
    assert(de <= 0.0001)
    assert(dl <= 0.0001)
  }

  test("Precision of RK2") {
    val (de, dl) = getMaxRelativeErrors(SolverType.RK2, 0.01, 10000)
    assert(de <= 0.0001)
    assert(dl <= 0.0001)
  }

  test("Precision of RK4 incorrect") {
    val (de, dl) = getMaxRelativeErrors(SolverType.RK4Incorrect, 0.01, 10000)
    assert(de <= 0.0001)
    assert(dl <= 0.0001)
  }

  test("Precision of RK4") {
    val (de, dl) = getMaxRelativeErrors(SolverType.RK4, 0.01, 10000)
    assert(de <= 0.000_000_01)
    assert(dl <= 0.000_000_01)
  }

  private def getMaxRelativeErrors(solverType: SolverType, dt: Double, stepsCount: Int): (Double, Double) =
    val body: Inertia3d = new Inertia3d(1.0, Vector3d(3.0, 2.0, 1.0))
    val initialState: State3d = new State3d()
    initialState.velocity.angular := (1.0, 1.0, 1.0)

    val initialE = body.getEnergy(initialState)
    val initialL = body.getL(initialState)

    val zeroForce = Force3d()
    val currentState = State3d() := initialState

    var errorE = 0.0
    var errorL = 0.0

    for (_ <- 0 until stepsCount) {
      updateFreeBody(solverType, body, currentState, dt, zeroForce)

      val currentE = body.getEnergy(initialState)
      val currentL = body.getL(initialState)

      errorE = math.max(errorE, math.abs(currentE - initialE) / initialE)
      errorL = math.max(errorL, (currentL - initialL).mag / initialL.mag)
    }

    (errorE, errorL)

private enum SolverType:
  case Euler2, RK2, RK4Incorrect, RK4