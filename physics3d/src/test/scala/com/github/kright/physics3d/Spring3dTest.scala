package com.github.kright.physics3d

import com.github.kright.math.VectorMathGenerators.*
import com.github.kright.math.{EqualityEps, Vector3d}
import org.scalactic.{Equality, TolerantNumerics}
import org.scalatest.funsuite.AnyFunSuite
import org.scalatestplus.scalacheck.ScalaCheckPropertyChecks

class Spring3dTest extends AnyFunSuite with ScalaCheckPropertyChecks:
  private val eps = 1e-6
  private implicit val doubleEquality: Equality[Double] = TolerantNumerics.tolerantDoubleEquality(eps)
  private implicit val equalityEps: EqualityEps = EqualityEps(eps)

  test("addSpring pull unit test") {
    assertBalancedForces { (force1, force2) =>
      Spring3d.addSpring(Vector3d(2, 0, 0), k = 3, r0 = 1, Vector3d(), Vector3d(), force1, force2)
      assert(force1.linear === Vector3d(3, 0, 0), s"got ${force1.linear}")
    }
  }

  test("addSpring push unit test") {
    assertBalancedForces { (force1, force2) =>
      Spring3d.addSpring(Vector3d(0, 1, 0), k = 5, r0 = 2, Vector3d(), Vector3d(), force1, force2)
      assert(force1.linear === Vector3d(0, -5, 0), s"got ${force1.linear}")
    }
  }

  test("addSpring") {
    forAll(vectors3InCube.filter(_.mag > eps), vectors3InCube, vectors3InCube) { (r12, dr1global, dr2global) =>
      assertBalancedForces { (force1, force2) =>
        val k = 3
        val r0 = 0.5
        Spring3d.addSpring(r12, k, r0, dr1global, dr2global, force1, force2)

        assert(force1.linear.rejected(r12) === Vector3d())
        assert(force1.linear.mag === k * math.abs(r12.mag - r0))

        if (r12.mag + eps < r0) {
          assert(force1.linear.dot(r12) < 0.0)
        }
        else if (r12.mag - eps > r0) {
          assert(force1.linear.dot(r12) > 0.0)
        }
      }
    }
  }

  test("addLinearFriction pull unit test") {
    assertBalancedForces { (force1, force2) =>
      Spring3d.addLinearFriction(Vector3d(0, 1, 0), Vector3d(0.7, 1.2, 0), Friction.linear(2),
        Vector3d(), Vector3d(), force1, force2)

      assert(force1.linear === (Vector3d(0, 2.4, 0)))
    }
  }

  test("addLinearFriction push unit test") {
    assertBalancedForces { (force1, force2) =>
      Spring3d.addLinearFriction(Vector3d(0, 0, 0.5), Vector3d(0.1, 0.2, -0.3), Friction.linear(0.7),
        Vector3d(), Vector3d(), force1, force2)

      assert(force1.linear === (Vector3d(0, 0, -0.3 * 0.7)))
    }
  }

  test("addLinearFriction is along r12 and doesn't add energy") {
    forAll(
      vectors3InCube.filter(_.mag > eps),
      vectors3InCube.filter(_.mag > eps),
      vectors3InCube,
      vectors3InCube
    ) { (r12, v12, dr1global, dr2global) =>
      assertBalancedForces { (force1, force2) =>
        Spring3d.addLinearFriction(r12, v12, Friction.linear(3), dr1global, dr2global, force1, force2)

        assert(force1.linear.rejected(r12) === (Vector3d()))
        assert(force1.linear.dot(v12) > -eps)
      }
    }
  }
