package com.github.kright.symbolic.transform.simplifiers

import com.github.kright.symbolic.SymbolicStr.*
import com.github.kright.symbolic.transform.PartialTransform
import com.github.kright.symbolic.{Symbolic, SymbolicStr}


object SymbolicStrSimplifier:
  def simplify(maxRepeatCount: Int = 16, argsSorter: ArgsSorter = sortArgs()): PartialTransform[SymbolicStr] =
    PartialTransform.any(
      SumFlattener(),
      ProductFlattener(),

      ProductOfNumbersSimplifier(),
      CombineElemsInSum(argsSorter),

      ProductOfSumToSumOfProducts(),
    ).repeat(maxRepeatCount)

  def sortArgs(commutativeFuncs: Set[String] = Set("+", "*"),
               knownFuncs: Set[String] = Set("/")): ArgsSorter =
    new ArgsSorter(
      SymbolicStr.ordering,
      isCommutative = commutativeFuncs.contains,
      isKnown = knownFuncs.contains,
    )
