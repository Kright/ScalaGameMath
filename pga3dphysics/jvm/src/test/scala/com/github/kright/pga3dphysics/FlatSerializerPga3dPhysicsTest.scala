package com.github.kright.pga3dphysics

import com.github.kright.math.FlatSerializer
import com.github.kright.pga3d.*
import org.scalacheck.Gen
import org.scalatest.funsuite.AnyFunSuiteLike
import org.scalatestplus.scalacheck.ScalaCheckPropertyChecks

class FlatSerializerPga3dPhysicsTest extends AnyFunSuiteLike with ScalaCheckPropertyChecks:

  test("check sizes") {
    assert(FlatSerializer.getSize[Pga3dInertiaLocal] == Pga3dInertiaLocal.componentsCount)
    assert(FlatSerializer.getSize[Pga3dInertiaSummable] == Pga3dInertiaSummable.componentsCount)
    assert(FlatSerializer.getSize[Pga3dPoint] == Pga3dPoint.componentsCount)
  }

  inline def myCheck[T](gen: Gen[T]): Unit = {
    forAll(gen, gen) { (a, b) =>
      val size = FlatSerializer.getSize[T]
      val arr = new Array[Double](size * 2)
      FlatSerializer.write(a, arr, offset = 0)
      FlatSerializer.write(b, arr, offset = size)
      val ar = FlatSerializer.read[T](arr, offset = 0)
      val br = FlatSerializer.read[T](arr, offset = size)
      assert(a == ar)
      assert(b == br)
    }
  }

  test("check serialization and deserialization") {
    myCheck(Pga3dInertiaGenerators.inertiaMovedLocal.map(_.localInertia))
    myCheck(Pga3dInertiaGenerators.inertiaMovedLocal.map(_.toSummable))
  }

object FlatSerializerPga3dPhysicsTest:
  inline def myCheck[T](gen: Gen[T]): Unit =
    FlatSerializerPga3dTest.myCheck(gen)
