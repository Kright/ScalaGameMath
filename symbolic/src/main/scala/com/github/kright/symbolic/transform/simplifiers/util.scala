package com.github.kright.symbolic.transform.simplifiers

import com.github.kright.symbolic.Symbolic.Func
import com.github.kright.symbolic.SymbolicStr

def makeProductOrSimplify(elems: Seq[SymbolicStr]): SymbolicStr =
  require(elems.nonEmpty)
  if (elems.size == 1) return elems.head
  Func("*", elems)