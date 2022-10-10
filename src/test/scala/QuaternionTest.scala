package com.kright.math

import org.scalatest.Assertions._
import org.scalatest.funsuite.AnyFunSuite
import org.scalatestplus.scalacheck.ScalaCheckPropertyChecks
import VectorMathGenerators.{eulerAngles, gaussianQuaternions, normalizedQuaternions, vectors3InCube}

import org.scalacheck.Gen
import org.scalactic.{Equality, TolerantNumerics}

class QuaternionTest extends AnyFunSuite with ScalaCheckPropertyChecks:
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
    forAll(normalizedQuaternions, normalizedQuaternions) { (first, second) =>
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
    forAll(normalizedQuaternions, normalizedQuaternions, Gen.double) { (first, second, t) =>
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

  test("vector multiply by math definition") {
    forAll(normalizedQuaternions, vectors3InCube) { (q, v) =>
      val r1 = {
        val qqq = q * Quaternion(0.0, v.x, v.y, v.z) * q.conjugated()
        Vector3d(qqq.x, qqq.y, qqq.z)
      }

      val r2 = q * v
      assert(r1.isEquals(r2))
    }
  }

  test("magnitude multiplication") {
    implicit val doubleEquality: Equality[Double] = TolerantNumerics.tolerantDoubleEquality(0.000001)
    forAll(gaussianQuaternions, gaussianQuaternions) { (q0, q1) =>
      assert(q0.mag * q1.mag === (q0 * q1).mag)
    }
  }

  test("multiplication associativity") {
    forAll(normalizedQuaternions, normalizedQuaternions, normalizedQuaternions) { (first, second, third) =>
      val a = (first * second) * third
      val b = first * (second * third)
      assert(a.isEquals(b))
    }
  }

  test("multiplication on vector associativity") {
    forAll(normalizedQuaternions, normalizedQuaternions, vectors3InCube) { (first, second, vec) =>
      val a = (first * second) * vec
      val b = first * (second * vec)
      assert(a.isEquals(b))
    }
  }
