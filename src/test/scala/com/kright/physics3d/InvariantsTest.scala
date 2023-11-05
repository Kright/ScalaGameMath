package com.kright.physics3d

import com.kright.math.VectorMathGenerators.{normalizedQuaternions, vectors3InCube}
import com.kright.math.{IVector3d, Vector3d}
import com.kright.physics3d.Invariants.MassAndCenter
import com.kright.physics3d.PhysicsGenerators.{bodies, inertia3d, transforms}
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

  test("mass and center for translate and rotation") {
    forAll(bodies, bodies, bodies, transforms) {
      (b1, b2, b3, transform) =>
        val bodies = Seq(b1, b2, b3)

        val massAndCenter = MassAndCenter()
        val transformedMassAndCenter = MassAndCenter()

        for (body <- bodies) {
          val (state, inertia) = body
          val mass = inertia.mass
          val position: IVector3d = state.transform.position

          massAndCenter.add(inertia.mass, position)
          transformedMassAndCenter.add(mass, transform.global2local(position))
        }

        assert(massAndCenter.mass == transformedMassAndCenter.mass)
        assert(massAndCenter.center.isEquals(transform.local2global(transformedMassAndCenter.center)))
        assert(massAndCenter.mass == bodies.map(_._2.mass).sum)
    }
  }
