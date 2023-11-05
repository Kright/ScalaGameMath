package com.kright.physics3d

import com.kright.math.VectorMathGenerators.*
import com.kright.math.{Matrix3d, Quaternion, Vector3d, VectorMathGenerators}
import org.scalacheck.Gen

object PhysicsGenerators:
  val inertiaMoments: Gen[Matrix3d] =
    for (vec <- vectors3InCube;
         rotation <- normalizedQuaternions;
         positiveVec = Vector3d(10, 10, 10) + vec * 9;
         diagMatrix = Matrix3d().setScale(positiveVec))
    yield (Matrix3d() := rotation) * diagMatrix * (Matrix3d() := rotation.conjugated())

  val inertia3d: Gen[Inertia3d] =
    for (mass <- Gen.double;
         inertia <- inertiaMoments)
    yield Inertia3d(mass + 0.01, inertia)

  val transforms: Gen[Transform3d] =
    for (linear <- vectors3InCube;
         rot <- normalizedQuaternions)
    yield Transform3d(linear, rot)

  val velocities: Gen[Velocity3d] =
    for (linear <- vectors3InCube;
         w <- vectors3InCube)
    yield Velocity3d(linear, w)

  val states: Gen[State3d] =
    for (t <- transforms;
         v <- velocities)
    yield State3d(t, v)

  val bodies: Gen[(Inertia3d, State3d)] =
    for (inertia <- inertia3d;
         state <- states)
    yield (inertia, state)
