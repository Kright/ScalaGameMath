package com.kright.physics3d

import com.kright.math.{Quaternion, Vector3d}
import org.scalatest.funsuite.AnyFunSuite
import org.scalatestplus.scalacheck.ScalaCheckPropertyChecks
import com.kright.math.VectorMathGenerators.vectors3InCube
import com.kright.math.VectorMathGenerators.normalizedQuaternions
import com.kright.physics3d.PhysicsGenerator.transform

class Transform3dTest extends AnyFunSuite with ScalaCheckPropertyChecks:
  test("local2global is inversion of global2local") {
    forAll(transform, vectors3InCube) { (transform, localPos) =>
      val global = transform.local2global(localPos)
      val restoredLocalPos = transform.global2local(global)
      assert(restoredLocalPos.isEquals(restoredLocalPos))
    }
  }

  test("local2global when localPos in body origin") {
    forAll(transform) { transform =>
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
