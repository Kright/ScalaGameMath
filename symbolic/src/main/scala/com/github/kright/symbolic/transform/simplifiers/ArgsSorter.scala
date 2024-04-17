package com.github.kright.symbolic.transform.simplifiers

import com.github.kright.symbolic.Symbolic.{Func, Symbol}
import com.github.kright.symbolic.SymbolicStr

import scala.math.Ordering

class ArgsSorter(val ordering: Ordering[SymbolicStr],
                 isCommutative: String => Boolean,
                 isKnown: String => Boolean) extends SymbolicStrTransformDepthFirst({
  case Symbol(_) => None
  case f@Func(name, elems) =>
    if (isCommutative(name)) {
      val sortedElems = elems.sorted(using ordering)
      if (sortedElems != elems) {
        Option(Func(name, sortedElems))
      } else None
    } else {
      require(isKnown(name), s"unknown function: ${f}")
      None
    }
})
