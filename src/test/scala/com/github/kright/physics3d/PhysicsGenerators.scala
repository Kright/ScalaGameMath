package com.github.kright.physics3d

import com.github.kright.math.VectorMathGenerators.*
import com.github.kright.math.{Matrix3d, Vector3d, VectorMathGenerators}
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

  val linearFriction: Gen[Friction] =
    for (k <- Gen.oneOf(Gen.double, Gen.const(0.0));
         maxForce <- Gen.oneOf(Gen.double, Gen.const(Double.MaxValue)))
    yield Friction.linear(k, maxForce)

  val quadraticFriction: Gen[Friction] =
    for (k2 <- Gen.oneOf(Gen.double, Gen.const(0.0));
         maxForce <- Gen.oneOf(Gen.double, Gen.const(Double.MaxValue)))
    yield Friction.quadratic(k2, maxForce)

  val zeroFriction: Gen[Friction] =
    Gen.const(Friction.zero)

  val anyFriction: Gen[Friction] =
    Gen.oneOf(zeroFriction, linearFriction, quadraticFriction)

  val spring3dNoFriction: Gen[Spring3d] =
    for (dr1local <- vectors3InCube;
         dr2local <- vectors3InCube;
         k <- Gen.double.map(_ + 0.1);
         r0 <- Gen.double.map(_ + 0.1))
    yield Spring3d(dr1local, dr2local, r0, k, Friction.zero)

  val angularSpring3dNoFriction: Gen[AngularSpring3d] =
    for (t1 <- transforms;
         t2 <- transforms;
         k1 <- Gen.double.map(_ + 0.1);
         k2 <- Gen.double.map(_ + 0.1))
    yield AngularSpring3d(t1, t2, k1, k2)

  private val emptyBodySystem: Gen[BodySystemT] = Gen.const(new BodySystem())

  def bodySystems(bodiesCount: Int): Gen[BodySystemT] =
    require(bodiesCount >= 0)
    var result: Gen[BodySystemT] = emptyBodySystem.map(_.copy())
    for (_ <- 0 until bodiesCount) {
      result = for {
        bs <- result
        (mass, state) <- bodies
        _ = bs.addBody(mass, state)
      } yield bs
    }
    result
