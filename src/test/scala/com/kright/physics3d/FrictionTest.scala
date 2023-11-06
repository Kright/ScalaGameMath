package com.kright.physics3d

import com.kright.math.{Vector2d, Vector3d, VectorMathGenerators}
import com.kright.physics3d.Friction
import org.scalacheck.Gen
import org.scalactic.{Equality, TolerantNumerics}
import org.scalatest.Inspectors.forAll
import org.scalatest.funsuite.AnyFunSuite
import org.scalatestplus.scalacheck.ScalaCheckPropertyChecks

class FrictionTest extends AnyFunSuite with ScalaCheckPropertyChecks:
  test("magnitude of vector matches with scalar") {
    implicit val doubleEquality: Equality[Double] = TolerantNumerics.tolerantDoubleEquality(1e-6)
    val eps = 1e-6
    org.scalatest.Inspectors.forAll(allFrictions()) { friction =>
      forAll(VectorMathGenerators.vectors3InCube.filter(_.mag > eps)) { speed =>
        val forceVec3d = friction(speed)
        val forceScalar = friction(speed.mag)
        assert(forceScalar.abs === forceVec3d.mag)
      }
    }
  }

  test("friction force is opposite to speed") {
    val eps = 1e-6
    org.scalatest.Inspectors.forAll(allFrictions()) { friction =>
      forAll(VectorMathGenerators.double1) { velocity =>
        val force = friction(velocity)
        if (velocity > 0) assert(force <= 0)
        if (velocity < 0) assert(force >= 0)
        if (velocity == 0) assert(force == 0)
      }

      forAll(VectorMathGenerators.vectors3InCube.filter(_.mag > eps)) { velocity =>
        val force = friction(velocity)
        assert(force.projected(velocity).isEquals(force, eps))
        assert(force.dot(velocity) <= 0.0) // could be 0 if when force = 0
      }

      forAll(VectorMathGenerators.vectors2InCube.filter(_.mag > eps)) { velocity =>
        val force = friction(velocity)
        assert(force.projected(velocity).isEquals(force, eps))
        assert(force.dot(velocity) <= 0.0) // could be 0 if when force = 0
      }
    }
  }

  test("force for zero speed should be zero") {
    org.scalatest.Inspectors.forAll(allFrictions()) { friction =>
      val forceScalar = friction(0.0)
      val force2dVec = friction(Vector2d(0.0, 0.0))
      val force3dVec = friction(Vector3d(0.0, 0.0, 0.0))

      assert(forceScalar == 0.0)
      assert(force2dVec.x == 0.0 && force2dVec.y == 0.0)
      assert(force3dVec.x == 0.0 && force3dVec.y == 0.0 && force3dVec.z == 0.0)
    }
  }

  test("friction is antisymmetric") {
    org.scalatest.Inspectors.forAll(allFrictions()) { friction =>
      forAll(VectorMathGenerators.double1) { velocity =>
        assert(friction(velocity) == -friction(-velocity))
      }
    }
  }

  test("linear friction is ok") {
    val friction = Friction.linear(2.0, 10.0)

    assert(friction.apply(1) == -2)
    assert(friction.apply(2) == -4)
    assert(friction.apply(5) == -10)
    assert(friction.apply(6) == -10)
  }

  test("quadratic friction is ok") {
    val friction = Friction.quadratic(5.0, 100.0)

    assert(friction.apply(1) == -5)
    assert(friction.apply(2) == -20)
    assert(friction.apply(4) == -80)
    assert(friction.apply(5) == -100)
  }

  private def allFrictions(): Seq[Friction] =
    Seq(
      Friction.linear(k = 0.1, maxForce = 2),
      Friction.linear(k = 0.3),
      Friction.quadratic(k2 = 0.2, maxForce = 2),
      Friction.zero,
      Friction.const(minVelocity = 0.3, maxForce = 0.4),
    )
