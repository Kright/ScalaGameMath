package com.github.kright.math

import org.scalacheck.Gen

object VectorMathGenerators:
  val gaussian: Gen[Double] = Gen.gaussian(mean = 0, stdDev = 1)
  val double1: Gen[Double] = Gen.double.map(_ * 2.0 - 1.0)

  val angleRadians: Gen[Double] = Gen.double.map(2.0 * Math.PI * _)

  val vectors2InCube: Gen[Vector2d] =
    for (x <- double1;
         y <- double1)
    yield Vector2d(x, y)

  val vectors3InCube: Gen[Vector3d] =
    for (x <- double1;
         y <- double1;
         z <- double1)
    yield Vector3d(x, y, z)

  val vectors3normalized: Gen[Vector3d] =
    vectors3InCube.filter(_.mag > 1e-12).map(_.normalized())

  val vectors4InCube: Gen[Vector4d] =
    for (x <- double1;
         y <- double1;
         z <- double1;
         w <- double1)
    yield Vector4d(x, y, z, w)
