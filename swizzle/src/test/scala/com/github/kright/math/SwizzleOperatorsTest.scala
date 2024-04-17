package com.github.kright.math

import org.scalatest.funsuite.AnyFunSuite

class SwizzleOperatorsTest extends AnyFunSuite {
  private given equalityEps: EqualityEps = EqualityEps(1e-12)

  test("swizzle operators for Vector2d") {
    val v = Vector2d(1, 2)
    assert(Vector2d(2, 1) === v.yx)

    v.yx = v
    assert(Vector2d(2, 1) === v)

    v.yx = Vector2d(1, 2)
    assert(Vector2d(2, 1) === v)
  }

  test("swizzle operators for Vector4d") {
    val v = Vector4d(1, 2, 3, 4)

    v.yz = Vector4d(5, 6, 7, 8).yz
    assert(Vector4d(1, 6, 7, 4) === v)

    v.wzyx = v
    assert(Vector4d(4, 7, 6, 1) === v)

    v.wzyx = Vector4d(1, 6, 7, 4)
    assert(Vector4d(4, 7, 6, 1) === v)
  }
}
