package com.github.kright.pga3d

import org.scalatest.funsuite.AnyFunSuiteLike

class TranslatorTest extends AnyFunSuiteLike:
  test("translator for vector") {
    val v = Pga3dVector(1, 2, 3)
    val tr = Pga3dTranslator.addVector(v)
    val point = Pga3dPoint(10, 20, 30, 1.0)

    val b1 = point + v
    val b2 = tr.sandwich(point)
    assert((b1 - b2).norm < 2e-16)
  }
