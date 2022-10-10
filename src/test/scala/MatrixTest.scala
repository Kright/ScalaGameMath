package com.kright.math

import org.scalatest.funsuite.AnyFunSuite
import org.scalatestplus.scalacheck.ScalaCheckPropertyChecks
import VectorMathGenerators.{angleRadians, matrices2, matrices3, matrices4, normalizedQuaternions, vectors2InCube, vectors3InCube}

import org.scalactic.{Equality, TolerantNumerics}

class MatrixTest extends AnyFunSuite with ScalaCheckPropertyChecks:
  test("matrix and quaternion multiplication consistency") {
    forAll(normalizedQuaternions, vectors3InCube) { case (q, v) =>
      val mat3 = Matrix3d() := q
      val mat4 = Matrix4d() := q
      assert((mat3 * v).isEquals(q * v))
      assert((mat4 * v).isEquals(q * v))

      mat3.setRows(q.getX(), q.getY(), q.getZ())
      assert((mat3 * v).isEquals(q * v))
    }
  }

  test("matrix and quaternion same multiplication order") {
    forAll(normalizedQuaternions, normalizedQuaternions) { case (q1, q2) =>
      val ma = Matrix3d() := (q1 * q2)
      val mb = (Matrix3d() := q1) * (Matrix3d() := q2)
      assert(ma.isEquals(mb))
    }
  }

  test("matrix associativity") {
    forAll(matrices2, matrices2, matrices2) { (a, b, c) =>
      val m1 = (a * b) * c
      val m2 = a * (b * c)
      assert(m1.isEquals(m2))
    }

    forAll(matrices3, matrices3, matrices3) { (a, b, c) =>
      val m1 = (a * b) * c
      val m2 = a * (b * c)
      assert(m1.isEquals(m2))
    }

    forAll(matrices4, matrices4, matrices4) { (a, b, c) =>
      val m1 = (a * b) * c
      val m2 = a * (b * c)
      assert(m1.isEquals(m2))
    }
  }

  test("matrix transpose") {
    forAll(matrices2, matrices2) { (a, b) =>
      assert((a * b).transposed().isEquals(b.transposed() * a.transposed()))
    }

    forAll(matrices3, matrices3) { (a, b) =>
      assert((a * b).transposed().isEquals(b.transposed() * a.transposed()))
    }

    forAll(matrices4, matrices4) { (a, b) =>
      assert((a * b).transposed().isEquals(b.transposed() * a.transposed()))
    }
  }

  test("identity matrix") {
    implicit val doubleEquality: Equality[Double] = TolerantNumerics.tolerantDoubleEquality(0.000001)

    val id2 = Matrix2d().setIdentity()
    assert(id2.isEquals(id2 * id2))
    assert(id2.det() === 1.0)

    val id3 = Matrix3d().setIdentity()
    assert(id3.isEquals(id3 * id3))
    assert(id3.det() === 1.0)

    val id4 = Matrix4d().setIdentity()
    assert(id4.isEquals(id4 * id4))
    assert(id4.det() === 1.0)
  }

  test("multiplication of determinants") {
    implicit val doubleEquality: Equality[Double] = TolerantNumerics.tolerantDoubleEquality(0.000001)
    forAll(matrices2, matrices2) { (m1, m2) =>
      assert((m1 * m2).det() === m1.det() * m2.det())
    }

    forAll(matrices3, matrices3) { (m1, m2) =>
      assert((m1 * m2).det() === m1.det() * m2.det())
    }

    forAll(matrices4, matrices4) { (m1, m2) =>
      assert((m1 * m2).det() === m1.det() * m2.det())
    }
  }

  test("transposed rotation is inverse rotation") {
    forAll(angleRadians) { angle =>
      val m = Matrix2d().set2dRotation(angle)
      val mTr = m.transposed()
      val mInv = m.inverted()
      assert(mTr.isEquals(mInv))
    }

    forAll(normalizedQuaternions) { q =>
      val m = Matrix3d() := q
      val mTr = m.transposed()
      val mInv = m.inverted()
      assert(mTr.isEquals(mInv))
    }

    forAll(normalizedQuaternions) { q =>
      val m = Matrix4d() := q
      val mTr = m.transposed()
      val mInv = m.inverted()
      assert(mTr.isEquals(mInv))
    }
  }

  test("matrix inversion") {
    forAll(matrices2) { m =>
      if (Math.abs(m.det()) > 0.000001) {
        val inverted = m.inverted()
        val id = Matrix2d().setIdentity()

        assert(id.isEquals(m * inverted))
        assert(id.isEquals(inverted * m))
      }
    }

    forAll(matrices3) { m =>
      if (Math.abs(m.det()) > 0.000001) {
        val inverted = m.inverted()
        val id = Matrix3d().setIdentity()

        assert(id.isEquals(m * inverted))
        assert(id.isEquals(inverted * m))
      }
    }

    forAll(matrices4) { m =>
      if (Math.abs(m.det()) > 0.000001) {
        val inverted = m.inverted()
        val id = Matrix4d().setIdentity()

        assert(id.isEquals(m * inverted))
        assert(id.isEquals(inverted * m))
      }
    }
  }

  test("2d rotation") {
    forAll(angleRadians) { angle =>
      val ma = Matrix3d().set2dRotation(angle)
      val mb = Matrix3d() := (Quaternion() := (angle, Vector3d(0, 0, 1)))
      val mc = Matrix3d() := Matrix2d().set2dRotation(angle)
      assert(ma.isEquals(mb))
      assert(ma.isEquals(mc))
    }
  }

  test("2d vec * matrix3d") {
    implicit val doubleEquality: Equality[Double] = TolerantNumerics.tolerantDoubleEquality(0.000001)
    forAll(vectors2InCube, matrices3) { (v, m) =>
      val v2 = m * v
      val v3 = m * Vector3d(v.x, v.y, 1.0)
      assert(v2.x === v3.x)
      assert(v2.y === v3.y)
    }
  }

  test("Matrix234d multiplication correspondence") {
    forAll(matrices2, matrices2) { (left, right) =>
      val r1 = Matrix3d() := (left * right)
      val r2 = (Matrix3d() := left) * (Matrix3d() := right)
      assert(r1.isEquals(r2))
    }

    forAll(matrices3, matrices3) { (left, right) =>
      val r1 = Matrix4d() := (left * right)
      val r2 = (Matrix4d() := left) * (Matrix4d() := right)
      assert(r1.isEquals(r2))
    }
  }
