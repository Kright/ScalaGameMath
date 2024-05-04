package com.github.kright.math

import com.github.kright.math.MathUtils.*
import org.scalatest.funsuite.AnyFunSuite

class MathUtilsTest extends AnyFunSuite:
  test("clamp") {
    val lower = -1.1
    val upper = 2.2

    assert(0.0.clamp(lower, upper) == 0.0)
    assert(-3.0.clamp(lower, upper) == lower)
    assert(3.0.clamp(lower, upper) == upper)
    assert(upper.clamp(lower, upper) == upper)
    assert(lower.clamp(lower, upper) == lower)
  }

  test("sign") {
    assert(0.0.sign == 0.0)
    assert(5.0.sign == 1.0)
    assert(-10.0.sign == -1.0)
  }

  test("pow") {
    assert(MathUtils.pow(2, 10, _ * _) == 1024)
    assert(MathUtils.pow(1, 100, _ + _) == 100)
  }
