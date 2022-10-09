package com.kright.math

import org.scalatest.funsuite.AnyFunSuite
import org.scalatestplus.scalacheck.ScalaCheckPropertyChecks
import VectorMathGenerators.normalizedQuaternions
import VectorMathGenerators.vectorsInCube
import VectorMathGenerators.matrices

import org.scalactic.{Equality, TolerantNumerics}

class MatrixTest extends AnyFunSuite with ScalaCheckPropertyChecks:
  test("matrix and quaternion multiplication consistency") {
    forAll(normalizedQuaternions, vectorsInCube) { case (q, v) =>
      val matrix = Matrix3d() := q
      assert((matrix * v).isEquals(q * v))

      matrix.setRows(q.getX(), q.getY(), q.getZ())
      assert((matrix * v).isEquals(q * v))
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
    forAll(matrices, matrices, matrices) { (a, b, c) =>
      val m1 = (a * b) * c
      val m2 = a * (b * c)
      assert(m1.isEquals(m2))
    }
  }

  test("identity matrix") {
    implicit val doubleEquality: Equality[Double] = TolerantNumerics.tolerantDoubleEquality(0.01)
    val id = Matrix3d().setIdentity()
    assert(id.isEquals(id * id))
    assert(id.det() === 1.0)
  }

  test("multiplication of determinants") {
    implicit val doubleEquality: Equality[Double] = TolerantNumerics.tolerantDoubleEquality(0.01)
    forAll(matrices, matrices) { (m1, m2) =>
      assert((m1 * m2).det() === m1.det() * m2.det())
      assert((m2 * m1).det() === m1.det() * m2.det())
    }
  }

  test("transposed rotation is inverse rotation") {
    forAll(normalizedQuaternions) { q =>
      val m = Matrix3d() := q
      val mTr = m.transposed()
      val mInv = m.inverted()
      assert(mTr.isEquals(mInv))
    }
  }

  test("matrix inversion") {
    forAll(matrices) { m =>
      if (Math.abs(m.det()) > 0.001) {
        val inverted = m.inverted()
        val id = Matrix3d().setIdentity()

        assert(id.isEquals(m * inverted))
        assert(id.isEquals(inverted * m))
      }
    }
  }
