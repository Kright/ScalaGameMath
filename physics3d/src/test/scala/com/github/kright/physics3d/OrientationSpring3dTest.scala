package com.github.kright.physics3d

import com.github.kright.math.VectorMathGenerators.*
import com.github.kright.physics3d.PhysicsGenerators.*
import org.scalacheck.Gen
import org.scalactic.{Equality, TolerantNumerics}
import org.scalatest.funsuite.AnyFunSuite
import org.scalatestplus.scalacheck.ScalaCheckPropertyChecks

class OrientationSpring3dTest extends AnyFunSuite with ScalaCheckPropertyChecks:
  test("initial doesn't have forces and energy") {
    val eps = 1e-12
    implicit val doubleEquality: Equality[Double] = TolerantNumerics.tolerantDoubleEquality(1e-6)

    forAll(transforms, transforms, Gen.double, anyFriction) { (t1, t2, k, friction) =>
      val state1 = State3d(t1, Velocity3d())
      val state2 = State3d(t2, Velocity3d())

      val spring = OrientationSpring3d(state1.q, state2.q, k, friction)

      val force1 = Force3d()
      val force2 = Force3d()

      spring.addForces(state1, state2, force1, force2)
      assert(force1.isEquals(Force3d(), eps))
      assert(force2.isEquals(Force3d(), eps))
      assert(spring.getPotentialEnergy(state1, state2) === 0.0)
    }
  }
