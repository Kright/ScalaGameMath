package com.github.kright.pga3d

import com.github.kright.math.VectorMathGenerators
import org.scalacheck.Gen

object GeneratorsPGA3d:
  val bivectors: Gen[Pga3dBivector] =
    Gen.containerOfN[Seq, Double](6, VectorMathGenerators.double1)
      .map(lst => Pga3dBivector(lst(0), lst(1), lst(2), lst(3), lst(4), lst(5)))

  val bivectorBulks: Gen[Pga3dBivectorBulk] =
    Gen.containerOfN[Seq, Double](3, VectorMathGenerators.double1)
      .map(lst => Pga3dBivectorBulk(lst(0), lst(1), lst(2)))

  val bivectorWeight: Gen[Pga3dBivectorWeight] =
    Gen.containerOfN[Seq, Double](3, VectorMathGenerators.double1)
      .map(lst => Pga3dBivectorWeight(lst(0), lst(1), lst(2)))
