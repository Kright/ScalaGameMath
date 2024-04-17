package com.github.kright.symbolic.transform.simplifiers

import com.github.kright.symbolic.SymbolicStr
import com.github.kright.symbolic.SymbolicStr.given
import org.scalatest.funsuite.AnyFunSuiteLike

import scala.math.Numeric.Implicits.infixNumericOps

class ArgsSorterTest extends AnyFunSuiteLike:
  test("check order") {
    val argsSorted = SymbolicStrSimplifier.sortArgs()
    assert(argsSorted.transform(SymbolicStr("x") + SymbolicStr(2.0)) == SymbolicStr(2.0) + SymbolicStr("x"))
  }
