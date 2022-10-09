package com.kright.math

import org.scalacheck.Gen

object VectorMathGenerators:
  val gaussian: Gen[Double] = Gen.gaussian(mean = 0, stdDev = 1)
  val double1: Gen[Double] = Gen.double.map(_ * 2.0 - 1.0)

  val gaussianQuaternions: Gen[Quaternion] =
    for (w <- gaussian;
         x <- gaussian;
         y <- gaussian;
         z <- gaussian)
    yield Quaternion(w, x, y, z)
  
  val normalizedQuaternions: Gen[Quaternion] =
    gaussianQuaternions.map(_.safeNormalized())

  val vectorsInCube: Gen[Vector3d] =
    for (x <- double1;
         y <- double1;
         z <- double1)
    yield Vector3d(x, y, z)
    
  val matrices: Gen[Matrix3d] =
    for(vx <- vectorsInCube;
        vy <- vectorsInCube;
        vz <- vectorsInCube) 
      yield Matrix3d().setRows(vx, vy, vz)