package com.github.kright.math

import com.github.kright.math.VectorMathGenerators.*
import org.scalatest.funsuite.AnyFunSuite
import org.scalatestplus.scalacheck.ScalaCheckPropertyChecks

class VectorTest extends AnyFunSuite with ScalaCheckPropertyChecks:
  implicit val eps: EqualityEps = EqualityEps(1e-12)

  test("projected and unprojected") {
    forAll(vectors2InCube, vectors2InCube) { (v1, axis) =>
      if (axis.mag > 0.000001) {
        assert(v1 === (v1.projected(axis) + v1.rejected(axis)))
      }
    }

    forAll(vectors3InCube, vectors3InCube) { (v1, axis) =>
      if (axis.mag > 0.000001) {
        assert(v1 === (v1.projected(axis) + v1.rejected(axis)))
      }
    }

    forAll(vectors4InCube, vectors4InCube) { (v1, axis) =>
      if (axis.mag > 0.000001) {
        assert(v1 === (v1.projected(axis) + v1.rejected(axis)))
      }
    }
  }

  test("cross product") {
    assert(Vector3d(1.0, 0.0, 0.0).cross(Vector3d(0.0, 1.0, 0.0)) === Vector3d(0.0, 0.0, 1.0))
  }
