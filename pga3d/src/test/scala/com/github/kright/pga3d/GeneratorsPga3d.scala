package com.github.kright.pga3d

import com.github.kright.math.VectorMathGenerators
import org.scalacheck.Gen

object GeneratorsPga3d:
  private def makeGenT[T](elemsCount: Int, factory: (Array[Double], Int) => T): Gen[T] = 
    Gen.containerOfN[Array, Double](elemsCount, VectorMathGenerators.double1)
      .map(arr => factory(arr, 0))

  val bivectors: Gen[Pga3dBivector] =
    makeGenT(6, Pga3dSerializer.loadBivector)

  val bivectorBulks: Gen[Pga3dBivectorBulk] =
    makeGenT(3, Pga3dSerializer.loadBivectorBulk)

  val bivectorWeight: Gen[Pga3dBivectorWeight] =
    makeGenT(3, Pga3dSerializer.loadBivectorWeight)

  val quaternions: Gen[Pga3dQuaternion] =
    makeGenT(4, Pga3dSerializer.loadQuaternion)

  val normalizedQuaternions: Gen[Pga3dQuaternion] =
    quaternions.filter(_.norm > 1e-40).map(_.normalizedByNorm)

  val points: Gen[Pga3dPoint] =
    makeGenT(3, Pga3dSerializer.loadPoint)

  val vectors: Gen[Pga3dVector] =
    makeGenT(3, Pga3dSerializer.loadVector)