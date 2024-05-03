package com.github.kright.physics3d

import com.github.kright.math.Vector3d
import com.github.kright.math.VectorMathGenerators.vectors3InCube
import com.github.kright.physics3d.PhysicsGenerators.states
import org.scalatest.funsuite.AnyFunSuite
import org.scalatestplus.scalacheck.ScalaCheckPropertyChecks

class State3dTest extends AnyFunSuite with ScalaCheckPropertyChecks:
  test("getGlobalVelocity when point in body origin") {
    forAll(states) { stateFactory =>
      val state = stateFactory()
      val velocity = state.getGlobalVelocity(Vector3d())
      assert(velocity.isEquals(state.velocity.linear, 1e-12))
    }
  }

  test("getGlobalVelocity equals to first order derivative of pos") {
    val dt = 1e-6
    forAll(states, vectors3InCube, MinSuccessful(1_000)) { (stateFactory, localPos) =>
      val state = stateFactory()
      val nextState = new State3d(state.transform.copy().update(state.velocity, dt), state.velocity)

      val initialGlobalPos = state.transform.local2global(localPos)
      val nextGlobalPos = nextState.transform.local2global(localPos)

      val expectedGlobalVelocity = (nextGlobalPos - initialGlobalPos) / dt
      val globalVelocity = state.getGlobalVelocity(localPos)

      assert(globalVelocity.isEquals(expectedGlobalVelocity, eps = 1e-3), s"${globalVelocity} != ${expectedGlobalVelocity}")
    }
  }
