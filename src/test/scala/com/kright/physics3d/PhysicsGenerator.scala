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
    
  val inertia3d: Gen[Inertia3d] =
    for(mass <- Gen.double;
        inertia <- inertiaMoment) 
      yield Inertia3d(mass + 0.01, inertia)

  val transform: Gen[Transform3d] =
    for(linear <- vectors3InCube;
        rot <- normalizedQuaternions)
      yield Transform3d(linear, rot)

  val velocity: Gen[Velocity3d] =
    for(linear <- vectors3InCube;
        w <- vectors3InCube)
      yield Velocity3d(linear, w)

  val state: Gen[State3d] =
    for(t <- transform;
        v <- velocity)
      yield State3d(t, v)
