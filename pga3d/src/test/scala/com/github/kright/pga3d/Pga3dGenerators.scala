package com.github.kright.pga3d

import com.github.kright.math.VectorMathGenerators
import com.github.kright.matrix.Matrix
import org.scalacheck.Gen

object Pga3dGenerators:
  private def makeGenT[T](elemsCount: Int, factory: (Array[Double], Int) => T): Gen[T] =
    Gen.containerOfN[Array, Double](elemsCount, VectorMathGenerators.double1)
      .map(arr => factory(arr, 0))

  val bivectors: Gen[Pga3dBivector] =
    makeGenT(6, Pga3dSerializer.loadBivector)

  val bivectorProbes: Seq[Pga3dBivector] = Seq(
    Pga3dBivector(1, 0, 0, 0, 0, 0),
    Pga3dBivector(0, 1, 0, 0, 0, 0),
    Pga3dBivector(0, 0, 1, 0, 0, 0),
    Pga3dBivector(0, 0, 0, 1, 0, 0),
    Pga3dBivector(0, 0, 0, 0, 1, 0),
    Pga3dBivector(0, 0, 0, 0, 0, 1),
  )

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

  def inertiaLocal(minMass: Double, maxMass: Double, minR: Double, maxR: Double): Gen[Pga3dInertiaLocal] =
    for {
      mass <- VectorMathGenerators.doubleInRange(minMass, maxMass)
      rx <- VectorMathGenerators.doubleInRange(minR, maxR)
      ry <- VectorMathGenerators.doubleInRange(minR, maxR)
      rz <- VectorMathGenerators.doubleInRange(minR, maxR)
    } yield Pga3dInertiaLocal.cube(mass, rx, ry, rz)

  val summableInertiaProbes = Seq(
    Pga3dInertiaSummable(1, 0, 0, 0, 0, 0, 0, 0, 0, 0),
    Pga3dInertiaSummable(0, 1, 0, 0, 0, 0, 0, 0, 0, 0),
    Pga3dInertiaSummable(0, 0, 1, 0, 0, 0, 0, 0, 0, 0),
    Pga3dInertiaSummable(0, 0, 0, 1, 0, 0, 0, 0, 0, 0),
    Pga3dInertiaSummable(0, 0, 0, 0, 1, 0, 0, 0, 0, 0),
    Pga3dInertiaSummable(0, 0, 0, 0, 0, 1, 0, 0, 0, 0),
    Pga3dInertiaSummable(0, 0, 0, 0, 0, 0, 1, 0, 0, 0),
    Pga3dInertiaSummable(0, 0, 0, 0, 0, 0, 0, 1, 0, 0),
    Pga3dInertiaSummable(0, 0, 0, 0, 0, 0, 0, 0, 1, 0),
    Pga3dInertiaSummable(0, 0, 0, 0, 0, 0, 0, 0, 0, 1),
  )

  val inertiaGen: Gen[Pga3dInertia] = for {
    inertiaLocal <- Pga3dGenerators.inertiaLocal(0.1, 10.0, 0.1, 10.0)
    q <- Pga3dGenerators.normalizedQuaternions
    shift <- Pga3dGenerators.vectors
    motor = Pga3dTranslator.addVector(shift).geometric(q)
  } yield Pga3dInertia(motor, inertiaLocal)

  def matrices(h: Int, w: Int): Gen[Matrix] =
    Gen.containerOfN[Array, Double](h * w, VectorMathGenerators.double1).map(arr => Matrix.fromValues(h, w)(arr *))
