package com.kright.physics3d

import com.kright.math.{Quaternion, Vector3d}
import com.kright.physics3d.PhysicsGenerators.*
import org.scalactic.{Equality, TolerantNumerics}
import org.scalatest.funsuite.AnyFunSuite
import org.scalatestplus.scalacheck.ScalaCheckPropertyChecks

class AngularSpring3dTest extends AnyFunSuite with ScalaCheckPropertyChecks:
  test("rotate force unit test") {
    val eps = 1e-6
    implicit val doubleEquality: Equality[Double] = TolerantNumerics.tolerantDoubleEquality(eps)

    assertBalancedForces { (force1, force2) =>
      val angularSpring = AngularSpring3d(
        localPos1 = Transform3d(Vector3d(), Quaternion.id),
        localPos2 = Transform3d(Vector3d(), Quaternion.id),
        k1 = 2.7,
        k2 = 0,
      )

      angularSpring.addForces(
        firstBody = State3d(Transform3d(Vector3d(0, 0, 0), Quaternion.id), Velocity3d()),
        secondBody = State3d(Transform3d(Vector3d(1, 1, 0), Quaternion.id), Velocity3d()),
        force1,
        force2
      )

      val angle = Math.PI / 4 // 45 degrees because of Vector3d(1, 1, 0)

      val expectedTorque: Vector3d = angularSpring.k1 * angle * Vector3d(0, 0, 1)
      assert(force1.torque.mag === angularSpring.k1 * angle)
      assert(force1.torque.isEquals(expectedTorque), s"got ${force1.torque} instead of ${expectedTorque}")
    }
  }

  test("rotate force invariant to transform") {
    val eps = 1e-6
    implicit val doubleEquality: Equality[Double] = TolerantNumerics.tolerantDoubleEquality(eps)

    forAll(transforms) { tr =>
      assertBalancedForces { (force1, force2) =>
        val angularSpring = AngularSpring3d(
          localPos1 = Transform3d(Vector3d(), Quaternion.id),
          localPos2 = Transform3d(Vector3d(), Quaternion.id),
          k1 = 2.7,
          k2 = 1.5,
        )

        angularSpring.addForces(
          firstBody = State3d(tr.local2global(Transform3d(Vector3d(0, 0, 0), Quaternion.id)), Velocity3d()),
          secondBody = State3d(tr.local2global(Transform3d(Vector3d(1, 1, 0), Quaternion.id)), Velocity3d()),
          force1,
          force2
        )

        val angle = Math.PI / 4 // 45 degrees because of Vector3d(1, 1, 0)

        val expectedTorque1: Vector3d = angularSpring.k1 * angle * (tr.q * Vector3d(0, 0, 1))
        assert(force1.torque.mag === angularSpring.k1 * angle)
        assert(force1.torque.isEquals(expectedTorque1), s"got ${force1.torque} instead of ${expectedTorque1}")

        val expectedTorque2: Vector3d = angularSpring.k2 * angle * (tr.q * Vector3d(0, 0, 1))
        assert(force2.torque.mag === angularSpring.k2 * angle)
        assert(force1.torque.cos(force2.torque) === 1.0)
      }
    }
  }
