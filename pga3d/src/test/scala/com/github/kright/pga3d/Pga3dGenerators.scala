package com.github.kright.pga3d

import com.github.kright.math.{FlatSerializer, VectorMathGenerators}
import com.github.kright.matrix.Matrix
import org.scalacheck.Gen

object Pga3dGenerators:
  private def makeGenT[T](elemsCount: Int, factory: (Array[Double], Int) => T): Gen[T] =
    Gen.containerOfN[Array, Double](elemsCount, VectorMathGenerators.double1)
      .map(arr => factory(arr, 0))

  val bivectors: Gen[Pga3dBivector] =
    makeGenT(6, FlatSerializer.read[Pga3dBivector])

  val bivectorProbes: Seq[Pga3dBivector] = Seq(
    Pga3dBivector(1, 0, 0, 0, 0, 0),
    Pga3dBivector(0, 1, 0, 0, 0, 0),
    Pga3dBivector(0, 0, 1, 0, 0, 0),
    Pga3dBivector(0, 0, 0, 1, 0, 0),
    Pga3dBivector(0, 0, 0, 0, 1, 0),
    Pga3dBivector(0, 0, 0, 0, 0, 1),
  )

  val bivectorBulks: Gen[Pga3dBivectorBulk] =
    makeGenT(3, FlatSerializer.read[Pga3dBivectorBulk])

  val bivectorWeight: Gen[Pga3dBivectorWeight] =
    makeGenT(3, FlatSerializer.read[Pga3dBivectorWeight])

  val quaternions: Gen[Pga3dQuaternion] =
    makeGenT(4, FlatSerializer.read[Pga3dQuaternion])

  val normalizedQuaternions: Gen[Pga3dQuaternion] =
    quaternions.filter(_.norm > 1e-40).map(_.normalizedByNorm)

  val points: Gen[Pga3dPoint] =
    makeGenT(3, FlatSerializer.read[Pga3dPoint])

  val vectors: Gen[Pga3dVector] =
    makeGenT(3, FlatSerializer.read[Pga3dVector])

  def matrices(h: Int, w: Int): Gen[Matrix] =
    Gen.containerOfN[Array, Double](h * w, VectorMathGenerators.double1).map(arr => Matrix.fromValues(h, w)(arr *))
