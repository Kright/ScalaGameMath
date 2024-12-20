package com.github.kright.pga3d

import org.scalatest.funsuite.AnyFunSuiteLike

class ForqueTest extends AnyFunSuiteLike:
  test("force and momentum") {
    val px: Double = 1.0
    val py: Double = 2.0
    val pz: Double = 3.0

    val f1 = Pga3dPoint(0, 1, 0, 1) v Pga3dVector(1, 0, 0)
    val f2 = Pga3dPoint(0, -1, 0, 1) v Pga3dVector(-1, 0, 0)

    assert((Pga3dVector(0, 0, 2) v Pga3dPoint(0, 0, 0, 1)).dual === (f1 + f2))
    assert((Pga3dPoint(0, 0, 0, 1) v Pga3dVector(0, 0, 2)).dual * -1 === (f1 + f2))
  }
