package com.github.kright.pga3d

import org.scalatest.funsuite.AnyFunSuiteLike

class TranslatorTest extends AnyFunSuiteLike:
  test("translator for vector") {
    val v = Vector(1, 2, 3)
    val tr = Translator.addVector(v)
    val point = Point.fromDual(10, 20, 30, 1.0)

    val b1 = point + v
    val b2 = tr.sandwich(point)
    assert((b1 - b2).norm < 2e-16)
  }
