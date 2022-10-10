package com.kright.math

import org.scalatest.Assertions._
import org.scalatest.funsuite.AnyFunSuite
import org.scalatestplus.scalacheck.ScalaCheckPropertyChecks
import VectorMathGenerators.{eulerAngles, gaussianQuaternions, normalizedQuaternions, vectors3InCube}

import org.scalacheck.Gen
import org.scalactic.{Equality, TolerantNumerics}

class EulerAnglesTest extends AnyFunSuite with ScalaCheckPropertyChecks:
  test("euler to quaternion conversion") {
    forAll(eulerAngles) { euler =>
      val q = Quaternion() := euler

      val qYaw = Quaternion() := (euler.yaw, Vector3d(0, 0, 1))
      val qPitch = Quaternion() := (euler.pitch, Vector3d(0, 1, 0))
      val qRoll = Quaternion() := (euler.roll, Vector3d(1, 0, 0))

      val qqq = qYaw * qPitch * qRoll
      assert(q.isEquals(qqq))
    }
  }

  test("matrix to quaternion conversion") {
    forAll(eulerAngles) { euler =>
      val m = Matrix3d() := euler

      val mYaw = Matrix3d() := (Quaternion() := (euler.yaw, Vector3d(0, 0, 1)))
      val mPitch = Matrix3d() := (Quaternion() := (euler.pitch, Vector3d(0, 1, 0)))
      val mRoll = Matrix3d() := (Quaternion() := (euler.roll, Vector3d(1, 0, 0)))

      val mmm = mYaw * mPitch * mRoll
      assert(m.isEquals(mmm))
    }
  }

  test("euler matrix quaternion correspondence") {
    forAll(eulerAngles) { euler =>
      val ma = Matrix3d() := euler
      val mb = Matrix3d() := (Quaternion() := euler)
      assert(ma.isEquals(mb))
      assert((Matrix4d() := euler).isEquals(Matrix4d() := mb))
    }
  }

