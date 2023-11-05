package com.kright.physics3d

import com.kright.math.VectorMathGenerators.{normalizedQuaternions, vectors3InCube}
import com.kright.math.{IVector3d, Quaternion, Vector3d}
import com.kright.physics3d.Invariants.{Impulse3dAccumulator, MassAndCenter}
import com.kright.physics3d.PhysicsGenerators.{bodies, inertia3d, states, transforms}
import org.scalatest.funsuite.AnyFunSuite
import org.scalatestplus.scalacheck.ScalaCheckPropertyChecks

class InvariantsTest extends AnyFunSuite with ScalaCheckPropertyChecks:
  test("mass and center") {
    val massAndCenter = MassAndCenter()
    massAndCenter.add(1, Vector3d(-1, 0, 0))
    massAndCenter.add(0.5, Vector3d(2, 0, 0))

    massAndCenter.add(2, Vector3d(0, -2, 0))
    massAndCenter.add(1, Vector3d(0, 2, 0))
    massAndCenter.add(1, Vector3d(0, 2, 0))

    assert(math.abs(massAndCenter.mass - 5.5) < 1e-6)
    assert(massAndCenter.center.isEquals(Vector3d()))
  }

  test("two bodies rotate around common center") {
    val accumulator = Impulse3dAccumulator()

    val inertia = Inertia3d(1, Vector3d(1, 1, 1))
    accumulator.add(inertia, State3d(Transform3d(Vector3d(1, 0, 0), Quaternion.id), Velocity3d(Vector3d(0, 1, 0), Vector3d())))
    accumulator.add(inertia, State3d(Transform3d(Vector3d(-1, 0, 0), Quaternion.id), Velocity3d(Vector3d(0, -1, 0), Vector3d())))

    assert(accumulator.mass == 2.0)
    assert(accumulator.center.isEquals(Vector3d()))
    assert(accumulator.linearImpulse.isEquals(Vector3d()))
    assert(accumulator.angularImpulse.isEquals(Vector3d(0, 0, 2)))
  }

  test("mass and center for translate and rotation") {
    forAll(bodies, bodies, bodies, transforms) {
      (b1, b2, b3, transform) =>
        val bodies = Seq(b1, b2, b3)

        val accumulator = Impulse3dAccumulator()
        val transformedAccumulator = Impulse3dAccumulator()

        for (body <- bodies) {
          val (inertia, state) = body
          val mass = inertia.mass
          val position: IVector3d = state.transform.position

          accumulator.add(inertia, state)
          transformedAccumulator.add(inertia,
            State3d(
              Transform3d(transform.global2local(state.transform.position), transform.rotation.conjugated() * state.transform.rotation),
              Velocity3d(transform.rotation.conjugated() * state.velocity.linear, transform.rotation.conjugated() * state.velocity.angular)
            )
          )
        }

        assert(accumulator.mass == bodies.map(_._1.mass).sum)
        assert(accumulator.mass == transformedAccumulator.mass)
        assert(accumulator.center.isEquals(transform.local2global(transformedAccumulator.center)))
        assert(accumulator.linearImpulse.isEquals(transform.rotation * transformedAccumulator.linearImpulse))
        assert(accumulator.angularImpulse.isEquals(transform.rotation * transformedAccumulator.angularImpulse))
    }
  }

  private def assertAllZeros(accumulator: Impulse3dAccumulator): Unit = {
    assert(accumulator.massAndCenter.mass == 0.0)
    assert(accumulator.massAndCenter.center.isEquals(Vector3d()))
    assert(accumulator.linearImpulse.isEquals(Vector3d()))
    assert(accumulator.angularImpulse.isEquals(Vector3d()))
  }

  test("trivial case with no bodies") {
    val accumulator = Impulse3dAccumulator()
    assertAllZeros(accumulator)
  }

  test("reset after one body") {
    forAll(bodies) { (inertia, state) =>
      val accumulator = Impulse3dAccumulator()
      accumulator.add(inertia, state)
      accumulator.reset()
      assertAllZeros(accumulator)
    }
  }

  test("add one body") {
    forAll(bodies) { (inertia, state) =>
      val accumulator = Impulse3dAccumulator()
      accumulator.add(inertia, state)

      val mass = inertia.mass
      assert(accumulator.mass == mass)
      assert(accumulator.center.isEquals(state.transform.position))
      assert(accumulator.linearImpulse.isEquals(state.velocity.linear * mass))
      assert(accumulator.angularImpulse.isEquals(inertia.getL(state)))
    }
  }
