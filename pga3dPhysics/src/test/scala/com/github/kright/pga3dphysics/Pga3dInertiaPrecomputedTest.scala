package com.github.kright.pga3dphysics

import com.github.kright.pga3d.Pga3dGenerators
import org.scalatest.funsuite.AnyFunSuiteLike
import org.scalatestplus.scalacheck.ScalaCheckPropertyChecks

class Pga3dInertiaPrecomputedTest extends AnyFunSuiteLike with ScalaCheckPropertyChecks:

  test("test precomputed apply method") {
    forAll(Pga3dPhysicsGenerators.inertiaGen, Pga3dGenerators.bivectors, MinSuccessful(100)) { (inertia, b) =>
      val r1 = inertia.apply(b)
      val r2 = inertia.toPrecomputed.apply(b)
      assert((r1 - r2).norm < 2e-13)
    }
  }

  test("test precomputed invert method") {
    forAll(Pga3dPhysicsGenerators.inertiaGen, Pga3dGenerators.bivectors, MinSuccessful(100)) { (inertia, b) =>
      val r1 = inertia.invert(b)
      val r2 = inertia.toPrecomputed.invert(b)
      assert((r1 - r2).norm < 1e-12)
    }
  }

  test("test precomputed get acceleration method") {
    forAll(Pga3dPhysicsGenerators.inertiaGen, Pga3dGenerators.bivectors, Pga3dGenerators.bivectors, MinSuccessful(100)) { (inertia, b, f) =>
      val r1 = inertia.getAcceleration(b, f)
      val r2 = inertia.toPrecomputed.getAcceleration(b, f)
      assert((r1 - r2).norm < 1e-11)
    }
  }