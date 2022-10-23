package com.kright.physics3d

import com.kright.math.{DifferentialSolvers, VectorMathGenerators}
import com.kright.math.VectorMathGenerators.*
import com.kright.physics3d.PhysicsGenerator.*
import org.scalatest.funsuite.AnyFunSuite
import org.scalatestplus.scalacheck.ScalaCheckPropertyChecks

class InertiaTest extends AnyFunSuite with ScalaCheckPropertyChecks :
  test("localI to globalI conversion") {
    forAll(inertiaMoment, normalizedQuaternions, vectors3InCube) { (I, rot, rotVelocity) =>
      val inertia = Inertia3d(1.0, I)

      val localRotVelocity = rot.conjugated() * rotVelocity

      val L1 = rot * (inertia.localI * localRotVelocity)
      val L2 = inertia.getGlobalI(rot) * rotVelocity
      val L3 = inertia.getL(rot, rotVelocity)

      assert(L1.isEquals(L2))
      assert(L1.isEquals(L3))
    }
  }

  test("energy and impulse are constant during rotation") {
    forAll(inertiaMoment, state) { (I, s) =>

      for(solverName <- Seq("RK4", "RK2", "Euler2")) {
        val body = Inertia3d(1.0, I)
        val initialImpulse = body.getImpulse(s)
        val initialE = body.getEnergy(s)
        val zeroForce = Force3d()

        for (_ <- 0 until 1000) {
          val dt = 0.001
          updateFreeBody(solverName, body, s, dt, zeroForce)
          val currentImpulse = body.getImpulse(s)
          val currentE = body.getEnergy(s)

          assert(Math.abs(currentE - initialE) < 0.001, s"solver $solverName failed")
          assert(currentImpulse.linear.distance(initialImpulse.linear) < 0.001, s"solver $solverName failed")
          assert(currentImpulse.angular.distance(initialImpulse.angular) < 0.001, s"solver $solverName failed")
        }
      }
    }
  }

  test("add impulse") {
    forAll(inertiaMoment, state, vectors3InCube, vectors3InCube) { (I, state, force, torque) =>
      for (solverName <- Seq("RK4", "RK2", "Euler2")) {
        val body = Inertia3d(1.0, I)
        val initialImpulse = body.getImpulse(state)
        val initialE = body.getEnergy(state)
        val forces = Force3d().addForce(force).addTorque(torque)
        var t = 0.0

        for (_ <- 0 until 1000) {
          val dt = 0.001
          updateFreeBody(solverName, body, state, dt, forces)
          t += dt
          val currentImpulse = body.getImpulse(state)

          assert(currentImpulse.linear.distance(initialImpulse.linear + forces.linear * t) < 0.001, s"solver $solverName failed")
          assert(currentImpulse.angular.distance(initialImpulse.angular + forces.torque * t) < 0.001, s"solver $solverName failed")
        }
      }
    }
  }

  /**
   */
  private def updateFreeBody(solverName: String, body: Inertia3d, state: State3d, dt: Double, force: Force3d): Unit =
    val newState =
      solverName match
        case "RK4" =>
          DifferentialSolvers.rungeKutta4(state, time=0.0, dt,
            getDerivative = (state, time) => body.getDerivative(state, force),
            nextState = (state, derivative, dt) => state.updated(derivative, dt),
            newZeroDerivative = () => new State3dDerivative(),
            madd = (acc, d, m) => acc.madd(d, m)
          )
        case "RK2" =>
          DifferentialSolvers.rungeKutta2(state, time = 0.0, dt,
            getDerivative = (state, time) => body.getDerivative(state, force),
            nextState = (state, derivative, dt) => state.updated(derivative, dt),
          )
        case "Euler2" =>
          DifferentialSolvers.euler2(state, time = 0.0, dt,
            getDerivative = (state, time) => body.getDerivative(state, force),
            nextState = (state, derivative, dt) => state.updated(derivative, dt),
            newZeroDerivative = () => new State3dDerivative(),
            madd = (acc, d, m) => acc.madd(d, m)
          )
    state := newState
