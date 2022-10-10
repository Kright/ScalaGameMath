package com.kright.math

import org.scalacheck.Gen

object VectorMathGenerators:
  val gaussian: Gen[Double] = Gen.gaussian(mean = 0, stdDev = 1)
  val double1: Gen[Double] = Gen.double.map(_ * 2.0 - 1.0)
  
  val angleRadians: Gen[Double] = Gen.double.map(2.0 * Math.PI * _)

  val gaussianQuaternions: Gen[Quaternion] =
    for (w <- gaussian;
         x <- gaussian;
         y <- gaussian;
         z <- gaussian)
    yield Quaternion(w, x, y, z)
  
  val normalizedQuaternions: Gen[Quaternion] =
    gaussianQuaternions.map(_.safeNormalized())

  val vectors2InCube: Gen[Vector2d] =
    for (x <- double1;
         y <- double1)
    yield Vector2d(x, y)
  
  val vectors3InCube: Gen[Vector3d] =
    for (x <- double1;
         y <- double1;
         z <- double1)
    yield Vector3d(x, y, z)

  val vectors4InCube: Gen[Vector4d] =
    for (x <- double1;
         y <- double1;
         z <- double1;
         w <- double1)
    yield Vector4d(x, y, z, w)
    
  val eulerAngles: Gen[EulerAngles] =
    for(yaw <- double1;
        pitch <- double1;
        roll <- double1) 
      yield new EulerAngles((yaw - 0.5) * 2.0 * Math.PI, (pitch - 0.5) * Math.PI, (roll - 0.5) * 2.0 * Math.PI)
  
  val matrices3: Gen[Matrix3d] =
    for(vx <- vectors3InCube;
        vy <- vectors3InCube;
        vz <- vectors3InCube)
      yield Matrix3d().setRows(vx, vy, vz)

  val matrices2: Gen[Matrix2d] =
    for (m00 <- double1; m01 <- double1;
         m10 <- double1; m11 <- double1)
    yield new Matrix2d(m00, m01, m10, m11)  

  val matrices4: Gen[Matrix4d] =
    for(vx <- vectors4InCube;
        vy <- vectors4InCube;
        vz <- vectors4InCube;
        vw <- vectors4InCube)
      yield Matrix4d().setRows(vx, vy, vz, vw)
