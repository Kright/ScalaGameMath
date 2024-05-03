package com.github.kright.ga

import com.github.kright.ga.PGA3.point
import com.github.kright.math.VectorMathGenerators
import org.scalacheck.Gen

object PGA3Generator:
  def planeGen(using ga: PGA3): Gen[MultiVector[Double]] =
    for (
      normal <- VectorMathGenerators.vectors3normalized;
      d <- VectorMathGenerators.double1
    ) yield PGA3.plane(normal.x, normal.y, normal.z, d)

  def pointGen(using ga: PGA3): Gen[MultiVector[Double]] =
    VectorMathGenerators.vectors3InCube.map { p =>
      PGA3.point(p.x, p.y, p.z)
    }
