package com.github.kright.pga3d

import org.scalatest.funsuite.AnyFunSuiteLike

class ForqueTest extends AnyFunSuiteLike:
  test("force and momentum") {
    val px: Double = 1.0
    val py: Double = 2.0
    val pz: Double = 3.0

    val f1 = Point.fromDual(0, 1, 0, 1) v Vector.fromDual(1, 0, 0)
    val f2 = Point.fromDual(0, -1, 0, 1) v Vector.fromDual(-1, 0, 0)

    assert((Vector.fromDual(0, 0, 2) v Point.fromDual(0, 0, 0, 1)).dual === (f1 + f2))
    assert((Point.fromDual(0, 0, 0, 1) v Vector.fromDual(0, 0, 2)).dual * -1 === (f1 + f2))
  }
