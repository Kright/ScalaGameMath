package com.github.kright.pga3d

import com.github.kright.math.VectorMathGenerators
import org.scalatest.funsuite.AnyFunSuiteLike
import org.scalatestplus.scalacheck.ScalaCheckPropertyChecks

class BivectorExponentTest extends AnyFunSuiteLike with ScalaCheckPropertyChecks:
  test("exp for bivector") {
    forAll(Pga3dGenerators.bivectors) { bivector =>
      assert((bivector.exp() - bivector.exp(1.0)).norm < 1e-15)
      assert((bivector.bulk.exp() - bivector.bulk.exp(1.0)).norm < 1e-15)
      assert((bivector.weight.exp() - bivector.weight.exp(1.0)).norm < 1e-15)
    }
  }

  test("exp for full with t") {
    forAll(Pga3dGenerators.bivectors, VectorMathGenerators.double1) { (bivector, t) =>
      assert(((bivector * t).exp() - bivector.exp(t)).norm < 1e-15)
      assert(((bivector.bulk * t).exp() - bivector.bulk.exp(t)).norm < 1e-15)
      assert(((bivector.weight * t).exp() - bivector.weight.exp(t)).norm < 1e-15)
    }
  }

  test("log is inverse of exp") {
    forAll(Pga3dGenerators.bivectors) { bivector =>
      val restored =
        assert((bivector - bivector.exp().log()).norm < 1e-14)
      assert((bivector.bulk - bivector.bulk.exp().log()).norm < 1e-14)
      assert((bivector.weight - bivector.weight.exp().log()).norm < 1e-14)
    }
  }

  test("bivector split") {
    forAll(Pga3dGenerators.bivectors.filter(_.bulkNorm > 1e-6)) { bivector =>
      val (line, shift) = bivector.split()

      assert(math.abs(line.weight.dual.dot(line.bulk)) < 1e-15)
    }
  }
