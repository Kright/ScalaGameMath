package com.github.kright.math

import com.github.kright.math.MathUtil.*
import org.scalatest.funsuite.AnyFunSuite

class MathUtilTest extends AnyFunSuite:
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
    assert(MathUtil.pow(2, 10, _ * _) == 1024)
    assert(MathUtil.pow(1, 100, _ + _) == 100)
  }
