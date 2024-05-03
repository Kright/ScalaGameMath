package com.github.kright.physics3d

import com.github.kright.math.MathGenerators.*
import com.github.kright.math.VectorMathGenerators.*
import com.github.kright.math.{Matrix3d, Vector3d, VectorMathGenerators}
import com.github.kright.physics3d.InertiaTest.SolverType
import org.scalacheck.Gen

object PhysicsGenerators:
  /**
   * it's easy to mutate state and get strange errors in scalacheck
   * factory will preserve original state and will produce copies of it
   */
  trait Factory[T] extends (() => T):
    override def toString(): String = apply().toString

  val solvers: Gen[PhysicsSolver] =
    Gen.oneOf(PhysicsSolver.all)

  val solverTypes: Gen[InertiaTest.SolverType] = Gen.oneOf(
    Seq(SolverType.Euler2, SolverType.RK2, SolverType.RK4Incorrect, SolverType.RK4)
  )

  def inertiaMomentsDiag(minR: Double, maxR: Double): Gen[Matrix3d] =
    vectorInAABB(Vector3d(minR, minR, minR), Vector3d(maxR, maxR, maxR)).map { r =>
      val rr = r * r
      Matrix3d.id.setScale(Vector3d(rr.y + rr.z, rr.x + rr.z, rr.x + rr.y))
    }

  def inertiaMoments(minR: Double, maxR: Double): Gen[Matrix3d] =
    for (diagMatrix <- inertiaMomentsDiag(minR, maxR);
         rotation <- normalizedQuaternions)
    yield (Matrix3d() := rotation) * diagMatrix * (Matrix3d() := rotation.conjugated())

  val inertia3d01 = inertia3d(
    minMass = 0.1, maxMass = 1.0,
    minR = 0.1, maxR = 1.0
  )

  def inertia3d(minMass: Double, maxMass: Double, minR: Double, maxR: Double): Gen[Inertia3d] =
    for (mass <- doubleInRange(minMass, maxMass);
         inertia <- inertiaMoments(minR, maxR))
    yield Inertia3d(mass, inertia * mass)

  val transforms: Gen[Transform3d] =
    for (linear <- vectors3InCube;
         rot <- normalizedQuaternions)
    yield Transform3d(linear, rot)

  val velocities: Gen[Velocity3d] =
    for (linear <- vectors3InCube;
         w <- vectors3InCube)
    yield Velocity3d(linear, w)

  val states: Gen[Factory[State3d]] =
    for (t <- transforms;
         v <- velocities)
    yield () => State3d(t.copy(), v.copy())

  val bodies: Gen[Factory[(Inertia3d, State3d)]] =
    for (inertia <- inertia3d(minMass = 0.1, maxMass = 1.0, minR = 0.1, maxR = 1.0);
         stateFactory <- states)
    yield () => (inertia, stateFactory())

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

  def bodySystems(bodiesCount: Int): Gen[Factory[BodySystemT]] =
    require(bodiesCount >= 0)

    Gen.containerOfN[Seq, Factory[(Inertia3d, State3d)]](bodiesCount, bodies)
      .map { factoriesList =>
        () => {
          val bs = new BodySystem()
          for (factory <- factoriesList) {
            val (mass, state) = factory()
            bs.addBody(mass, state)
          }
          bs
        }
      }
