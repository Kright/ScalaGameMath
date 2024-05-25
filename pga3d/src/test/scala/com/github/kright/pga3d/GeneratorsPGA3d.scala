package com.github.kright.pga3d

import com.github.kright.math.VectorMathGenerators
import org.scalacheck.Gen

object GeneratorsPGA3d:
  val bivectors: Gen[Bivector] =
    Gen.containerOfN[Seq, Double](6, VectorMathGenerators.double1)
      .map(lst => Bivector(lst(0), lst(1), lst(2), lst(3), lst(4), lst(5)))

  val bivectorBulks: Gen[BivectorBulk] =
    Gen.containerOfN[Seq, Double](3, VectorMathGenerators.double1)
      .map(lst => BivectorBulk(lst(0), lst(1), lst(2)))

  val bivectorWeight: Gen[BivectorWeight] =
    Gen.containerOfN[Seq, Double](3, VectorMathGenerators.double1)
      .map(lst => BivectorWeight(lst(0), lst(1), lst(2)))
