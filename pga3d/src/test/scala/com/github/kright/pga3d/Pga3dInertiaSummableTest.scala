package com.github.kright.pga3d

import org.scalacheck.Gen
import org.scalatest.funsuite.AnyFunSuiteLike
import org.scalatestplus.scalacheck.ScalaCheckPropertyChecks

class Pga3dInertiaSummableTest extends AnyFunSuiteLike with ScalaCheckPropertyChecks:
  test("point mass") {
    forAll(Pga3dGenerators.points, Gen.double.map(_ + 0.1)) { (point, mass) =>
      val summable0 = Pga3dInertiaSummable.point(point, mass)
      val summable1 = Pga3dInertiaSummable.symmetricProduct(point.toTrivector, point * mass)
      assert((summable0 - summable1).norm < 1e-15)
    }
  }

  test("center and mass of point mass") {
    forAll(Pga3dGenerators.points, Gen.double.map(_ + 0.1)) { (point, mass) =>
      val summable = Pga3dInertiaSummable.point(point, mass)
      assert(Math.abs(summable.mass - mass) < 1e-15)
      assert((summable.centerOfMass - point).norm < 1e-15)
      assert((summable.centerOfMassTrivector.w - mass) < 1e-15)
    }
  }

//  test("inertia apply method") {
//    val inertia = Pga3dInertiaSummable(ww = 3, wx = 3, wy = 6, wz = 9, xx = 4, yy = 14, zz = 29, xy = 7, yz = 18, xz = 10)
//    println(inertia.toInertia)
//
//    val str = MatrixPrinter.squarePrinter5f
//
//    Pga3dGenerators.summableInertiaProbes.map(_ * 0.01).map { dI =>
//      val inertia2 = inertia + dI
//      println(s"inertia2 = \n${str(inertia2.toMatrixXYZW)}")
//
//      Pga3dGenerators.bivectorProbes.foreach { b =>
//        println(s"probe = ${b}")
//        val r1 = inertia.toInertia.apply(b)
//        val r2 = inertia2.toInertia.apply(b)
//        println(s"diff = ${r2 - r1}")
//      }
//    }
//  }
