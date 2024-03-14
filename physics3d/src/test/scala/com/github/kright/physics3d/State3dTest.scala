package com.github.kright.physics3d

import com.github.kright.math.Vector3d
import com.github.kright.math.VectorMathGenerators.vectors3InCube
import com.github.kright.physics3d.PhysicsGenerators.states
import org.scalatest.funsuite.AnyFunSuite
import org.scalatestplus.scalacheck.ScalaCheckPropertyChecks

class State3dTest extends AnyFunSuite with ScalaCheckPropertyChecks:
  test("getGlobalVelocity when point in body origin") {
    forAll(states) { state =>
      val velocity = state.getGlobalVelocity(Vector3d())
      assert(velocity.isEquals(state.velocity.linear))
    }
  }

  test("getGlobalVelocity equals to first order derivative of pos") {
    val dt = 1e-6
    forAll(states, vectors3InCube) { (initialState, localPos) =>
      val nextState = new State3d(initialState.transform.copy().update(initialState.velocity, dt), initialState.velocity)

      val initialGlobalPos = initialState.transform.local2global(localPos)
      val nextGlobalPos = nextState.transform.local2global(localPos)

      val expectedGlobalVelocity = (nextGlobalPos - initialGlobalPos) / dt
      val globalVelocity = initialState.getGlobalVelocity(localPos)

      assert(globalVelocity.isEquals(expectedGlobalVelocity, eps = 1e-3), s"${globalVelocity} != ${expectedGlobalVelocity}")
    }
  }
