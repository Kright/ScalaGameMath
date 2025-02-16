package com.github.kright.pga3d

import org.scalatest.funsuite.AnyFunSuiteLike

class ForqueTest extends AnyFunSuiteLike:
  test("force and torque") {
    val torque = (Pga3dPoint(0, 1, 0) v Pga3dVector(1, 0, 0)) + (Pga3dPoint(0, -1, 0) v Pga3dVector(-1, 0, 0))
    val force = (Pga3dPoint(0, 1, 0) v Pga3dVector(1, 0, 0)) + (Pga3dPoint(0, -1, 0) v Pga3dVector(1, 0, 0))

    assert(force === Pga3dBivector(0, 0, 0, 0, 0, 2))
    assert(torque === Pga3dBivector(0, 0, -2, 0, 0, 0))
  }
