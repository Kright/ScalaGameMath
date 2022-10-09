package com.kright.math

import org.scalacheck.Gen
import org.scalatest.funsuite.AnyFunSuite
import org.scalatestplus.scalacheck.ScalaCheckPropertyChecks

class QuaternionTest extends AnyFunSuite with ScalaCheckPropertyChecks {
  private val gaussian = Gen.gaussian(mean = 0, stdDev = 1)

  private val normalizedQuaternions: Gen[Quaternion] =
    for (w <- gaussian;
         x <- gaussian;
         y <- gaussian;
         z <- gaussian)
      yield Quaternion(w, x, y, z).safeNormalized()

  test("quaternion pow") {
    forAll(normalizedQuaternions) { q =>
      assert((q * q).isEquals(q ^ 2))
      assert((q * q * q).isEquals(q ^ 3))

      val halfQ = q ^ 0.5
      assert(q.isEquals(halfQ * halfQ))

      assert((halfQ.getLog() * 2).isEquals(q.getLog()))

      assert(q.conjugated().isEquals(q ^ -1))
      assert(Quaternion().isEquals(q ^ 0.0))
    }
  }

  test("quaternion slerp and lerp") {
    forAll(normalizedQuaternions, normalizedQuaternions) { case (first, second) =>
      val lerp = Quaternion.lerp(first, second, 0.5).normalize()
      val slerp = Quaternion.slerp(first, second, 0.5)

      val groundTruth = first * (((first ^ -1) * second) ^ 0.5)

      assert(lerp.isEquals(groundTruth))
      assert(slerp.isEquals(groundTruth))
    }
  }

  test("quaternion log exp") {
    forAll(normalizedQuaternions) { q =>
      val exp = q.getLog()
      val q2 = Quaternion().setFromExp(exp)
      assert(q.isEquals(q2))
    }
  }

  test("quaternion slerp") {
    forAll(normalizedQuaternions, normalizedQuaternions, Gen.double) { case (first, second, t) =>
      val slerp = Quaternion.slerp(first, second, t)
      val groundTruth = first * (((first ^ -1) * second) ^ t)
      assert(slerp.isEquals(groundTruth))
    }
  }

  test("get rotation axis and angle") {
    forAll(normalizedQuaternions) { q =>
      val axis = q.getRotationAxis()
      val angle = q.rotationAngleRadians()
      val reconstructed = Quaternion() := (angle, axis)
      assert(reconstructed.isEquals(q))
    }
  }
}
