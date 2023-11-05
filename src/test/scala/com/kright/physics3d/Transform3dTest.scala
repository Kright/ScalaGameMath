package com.kright.physics3d

import com.kright.math.VectorMathGenerators.{normalizedQuaternions, vectors3InCube}
import com.kright.math.{Quaternion, Vector3d}
import com.kright.physics3d.PhysicsGenerators.transforms
import org.scalatest.funsuite.AnyFunSuite
import org.scalatestplus.scalacheck.ScalaCheckPropertyChecks

class Transform3dTest extends AnyFunSuite with ScalaCheckPropertyChecks:
  private def assertEq(first: Transform3d, second: Transform3d): Unit =
    assert(first.position.isEquals(second.position))
    assert(first.rotation.isEquals(second.rotation))

  test("local2global is inversion of global2local") {
    forAll(transforms, transforms) { (transform, local) =>
      val localPos = local.position

      val global = transform.local2global(localPos)
      val restoredLocalPos = transform.global2local(global)
      assert(restoredLocalPos.isEquals(restoredLocalPos))

      val globalTransform = transform.local2global(local)
      val restoredLocal = transform.global2local(globalTransform)
      assertEq(local, restoredLocal)
    }
  }

  test("transforms associativity") {
    forAll(transforms, transforms, transforms) { (t1, t2, t3) =>
      val first = t1.local2global(t2.local2global(t3))
      val second = t1.local2global(t2).local2global(t3)
      assertEq(first, second)

      val pos = t3.position
      assert(t1.local2global(t2.local2global(pos)).isEquals(t1.local2global(t2).local2global(pos)))
    }
  }

  test("local2global when localPos in body origin") {
    forAll(transforms) { transform =>
      val global = transform.local2global(Vector3d())
      assert(global.isEquals(transform.position))
    }
  }

  test("local2global shifts point when no rotation") {
    forAll(vectors3InCube, vectors3InCube) { (bodyPosition, localPos) =>
      val transform = new Transform3d(bodyPosition, Quaternion.id)
      val global = transform.local2global(localPos)
      assert(global.isEquals(bodyPosition + localPos))
    }
  }
