package com.kright.physics3d

import com.kright.math.{IVector3d, Quaternion, Vector3d}
import com.kright.physics3d.PhysicsGenerators.*
import org.scalactic.{Equality, TolerantNumerics}
import org.scalatest.funsuite.AnyFunSuite
import org.scalatestplus.scalacheck.ScalaCheckPropertyChecks

class StatsAccumulatorTest extends AnyFunSuite with ScalaCheckPropertyChecks:
  implicit val doubleEquality: Equality[Double] = TolerantNumerics.tolerantDoubleEquality(1e-6)

  test("mass and center") {
    val acc = StatsAccumulator { acc =>
      acc.add(pointBody(1), stateWithPos(Vector3d(-1, 0, 0)))
      acc.add(pointBody(0.5), stateWithPos(Vector3d(2, 0, 0)))
      acc.add(pointBody(2), stateWithPos(Vector3d(0, -2, 0)))
      acc.add(pointBody(1), stateWithPos(Vector3d(0, 2, 0)))
      acc.add(pointBody(1), stateWithPos(Vector3d(0, 2, 0)))
    }

    assert(acc.mass === 5.5)
    assert(acc.center.isEquals(Vector3d()))
  }

  private def pointBody(mass: Double): Inertia3d =
    Inertia3d(mass, Vector3d())

  private def stateWithPos(pos: Vector3d): State3d =
    State3d(Transform3d(pos, Quaternion.id), Velocity3d())

  test("two bodies rotate around common center") {


    val inertia = Inertia3d(1, Vector3d(1, 1, 1))
    val state1 = State3d(Transform3d(Vector3d(1, 0, 0), Quaternion.id), Velocity3d(Vector3d(0, 1, 0), Vector3d()))
    val state2 = State3d(Transform3d(Vector3d(-1, 0, 0), Quaternion.id), Velocity3d(Vector3d(0, -1, 0), Vector3d()))

    val accumulator = StatsAccumulator { acc =>
      acc.add(inertia, state1)
      acc.add(inertia, state2)
    }

    assert(accumulator.mass == 2.0)
    assert(accumulator.center.isEquals(Vector3d()))
    assert(accumulator.linearImpulse.isEquals(Vector3d()))
    assert(accumulator.angularImpulse.isEquals(Vector3d(0, 0, 2)))
    assert(accumulator.kineticEnergy === inertia.getEnergy(state1) + inertia.getEnergy(state2))
  }

  test("mass and center for translate and rotation") {
    forAll(bodies, bodies, bodies, transforms) {
      (b1, b2, b3, transform) =>
        val bodies = Seq(b1, b2, b3)

        val accumulator = StatsAccumulator()
        val transformedAccumulator = StatsAccumulator()

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
        assert(accumulator.kineticEnergy === transformedAccumulator.kineticEnergy)
        assert(accumulator.center.isEquals(transform.local2global(transformedAccumulator.center)))
        assert(accumulator.linearImpulse.isEquals(transform.rotation * transformedAccumulator.linearImpulse))
        assert(accumulator.angularImpulse.isEquals(transform.rotation * transformedAccumulator.angularImpulse))
    }
  }

  private def assertAllZeros(accumulator: StatsAccumulator): Unit = {
    assert(accumulator.mass == 0.0)
    assert(accumulator.kineticEnergy == 0.0)
    assert(accumulator.center.isEquals(Vector3d()))
    assert(accumulator.linearImpulse.isEquals(Vector3d()))
    assert(accumulator.angularImpulse.isEquals(Vector3d()))
  }

  test("trivial case with no bodies") {
    val accumulator = StatsAccumulator()
    assertAllZeros(accumulator)
  }

  test("reset after one body") {
    forAll(bodies) { (inertia, state) =>
      val accumulator = StatsAccumulator()
      accumulator.add(inertia, state)
      accumulator.reset()
      assertAllZeros(accumulator)
    }
  }

  test("add one body") {
    forAll(bodies) { (inertia, state) =>
      val accumulator = StatsAccumulator()
      accumulator.add(inertia, state)

      val mass = inertia.mass
      assert(accumulator.mass == mass)
      assert(accumulator.center.isEquals(state.transform.position))
      assert(accumulator.linearImpulse.isEquals(state.velocity.linear * mass))
      assert(accumulator.angularImpulse.isEquals(inertia.getL(state)))
      assert(accumulator.kineticEnergy === inertia.getEnergy(state))
    }
  }
