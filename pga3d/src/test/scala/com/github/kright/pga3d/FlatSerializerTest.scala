package com.github.kright.pga3d

import com.github.kright.math.FlatSerializer
import org.scalacheck.Gen
import org.scalatest.funsuite.AnyFunSuiteLike
import org.scalatestplus.scalacheck.ScalaCheckPropertyChecks

class FlatSerializerTest extends AnyFunSuiteLike with ScalaCheckPropertyChecks:

  test("check sizes") {
    assert(FlatSerializer.getSize[Pga3dBivector] == Pga3dBivector.componentsCount)
    assert(FlatSerializer.getSize[Pga3dVector] == Pga3dVector.componentsCount)
    assert(FlatSerializer.getSize[Pga3dTrivector] == Pga3dTrivector.componentsCount)
    assert(FlatSerializer.getSize[Pga3dQuaternion] == Pga3dQuaternion.componentsCount)
    assert(FlatSerializer.getSize[Pga3dPlane] == Pga3dPlane.componentsCount)
    assert(FlatSerializer.getSize[Pga3dPlaneIdeal] == Pga3dPlaneIdeal.componentsCount)
    assert(FlatSerializer.getSize[Pga3dTranslator] == Pga3dTranslator.componentsCount)
    assert(FlatSerializer.getSize[Pga3dBivectorWeight] == Pga3dBivectorWeight.componentsCount)
    assert(FlatSerializer.getSize[Pga3dBivectorBulk] == Pga3dBivectorBulk.componentsCount)
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
    myCheck(Pga3dGenerators.points)
    myCheck(Pga3dGenerators.bivectors)
    myCheck(Pga3dGenerators.vectors)
    myCheck(Pga3dGenerators.quaternions)
    myCheck(Pga3dGenerators.normalizedQuaternions)
    myCheck(Pga3dGenerators.inertiaGen.map(_.localInertia))
    myCheck(Pga3dGenerators.inertiaGen.map(_.toSummable))
  }
