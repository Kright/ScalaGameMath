package com.github.kright.symbolic

import com.github.kright.symbolic.SymbolicStr.{*, given}
import org.scalatest.funsuite.AnyFunSuiteLike

import scala.math.Numeric.Implicits.infixNumericOps


class SymbolicToPrettyStringTest extends AnyFunSuiteLike:
  test("test + -") {
    assert(SymbolicToPrettyString(SymbolicStr("x") + (SymbolicStr("y"))) == "(x + y)")
    assert(SymbolicToPrettyString(SymbolicStr("x") + SymbolicStr("y") + SymbolicStr("z")) == "((x + y) + z)")
  }
