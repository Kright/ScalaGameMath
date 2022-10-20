package com.kright.physics3d

import com.kright.math.{Matrix3d, Quaternion, VectorMathGenerators, Vector3d}
import com.kright.math.VectorMathGenerators.{angleRadians, matrices2, matrices3, matrices4, normalizedQuaternions, vectors2InCube, vectors3InCube}
import org.scalacheck.Gen

object PhysicsGenerator:
  val inertiaMoment: Gen[Matrix3d] =
    for (vec <- vectors3InCube;
         rotation <- normalizedQuaternions;
         positiveVec = Vector3d(10, 10, 10) + vec * 9;
         diagMatrix = Matrix3d().setScale(positiveVec))
      yield (Matrix3d() := rotation) * diagMatrix * (Matrix3d() := rotation.conjugated())  
