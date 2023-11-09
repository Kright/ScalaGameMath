package com.kright.physics3d

import com.kright.math.Vector3d
import com.kright.math.VectorMathGenerators.vectors3InCube
import org.scalatest.funsuite.AnyFunSuite
import org.scalatestplus.scalacheck.ScalaCheckPropertyChecks

class AngularFriction3dTest extends AnyFunSuite with ScalaCheckPropertyChecks:
  test("addTwistFriction unit test") {
    assertBalancedForces { (force1, force2) =>
      AngularFriction3d.addTwistFriction(Vector3d(1, 0, 0), Friction.linear(1.1), Vector3d(1, 0, 0), Vector3d(-1, 0, 0),
        force1, force2)

      assert(force1.linear.isEquals(Vector3d()))
      assert(force1.torque.isEquals(Vector3d(-1.1, 0, 0)), s"got ${force1.torque}")
      assert(force1.torque.isEquals(-force2.torque))
    }
  }

  test("addTwistFriction torque parallel to r12") {
    val eps = 1e-6
    forAll(vectors3InCube.filter(_.mag > eps), vectors3InCube, vectors3InCube) { (r12, w1, w2) =>
      assertBalancedForces { (force1, force2) =>
        val k = 1.1
        AngularFriction3d.addTwistFriction(r12, Friction.linear(k), w1, w2, force1, force2)

        assert(force1.linear.isEquals(Vector3d()))
        assert(force1.torque.isEquals(-force2.torque))
        assert(force1.torque.unprojected(r12).isEquals(Vector3d()))

        assert(force1.torque.projected(r12).isEquals((w2.projected(r12) - w1.projected(r12)) * k * 0.5))
      }
    }
  }

  test("addBallJointPerpendicularFriction unit test") {
    val eps = 1e-6
    assertBalancedForces { (force1, force2) =>
      val k = 1.1
      AngularFriction3d.addBallJointPerpendicularFriction(Vector3d(1, 0, 0), Vector3d(0, 1, 0), Friction.linear(k),
        Vector3d(), Vector3d(), Vector3d(), force1, force2)

      assert(force1.linear.isEquals(Vector3d(0, 0, -k)))
      assert(force1.torque.isEquals(Vector3d(0, k, 0)))
      assert(force2.torque.isEquals(Vector3d()))
    }
  }

  test("addBallJointPerpendicularFriction torque perpendicular to r12") {
    val eps = 1e-6
    forAll(vectors3InCube.filter(_.mag > eps), vectors3InCube, vectors3InCube) { (r12, v12, w1) =>
      assertBalancedForces { (force1, force2) =>
        val wJointP = Joint3d.getWJointP(r12, v12)

        val k = 1.1
        AngularFriction3d.addBallJointPerpendicularFriction(r12, wJointP, Friction.linear(k),
          w1, Vector3d(), Vector3d(), force1, force2)

        assert(force1.torque.projected(r12).isEquals(Vector3d()), s"wat ${force1.torque}, ${r12}")
      }
    }
  }