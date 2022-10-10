package com.kright.math

import org.scalatest.funsuite.AnyFunSuite
import org.scalatestplus.scalacheck.ScalaCheckPropertyChecks

import VectorMathGenerators._

class VectorTest extends AnyFunSuite with ScalaCheckPropertyChecks:
  test("projected and unprojected") {
    forAll(vectors2InCube, vectors2InCube) { (v1, axis) =>
      if (axis.mag > 0.000001) {
        assert(v1.isEquals(v1.projected(axis) + v1.unprojected(axis)))
      }
    }

    forAll(vectors3InCube, vectors3InCube) { (v1, axis) =>
      if (axis.mag > 0.000001) {
        assert(v1.isEquals(v1.projected(axis) + v1.unprojected(axis)))
      }
    }

    forAll(vectors4InCube, vectors4InCube) { (v1, axis) =>
      if (axis.mag > 0.000001) {
        assert(v1.isEquals(v1.projected(axis) + v1.unprojected(axis)))
      }
    }
  }

  test("cross product") {
    assert(Vector3d(x=1.0).cross(Vector3d(y=1.0)).isEquals(Vector3d(z=1.0)))
  }
