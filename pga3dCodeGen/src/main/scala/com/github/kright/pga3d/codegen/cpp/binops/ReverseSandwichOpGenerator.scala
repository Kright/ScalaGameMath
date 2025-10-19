package com.github.kright.pga3d.codegen.cpp.binops

import com.github.kright.ga.MultiVector
import com.github.kright.symbolic.Sym

class ReverseSandwichOpGenerator extends BinaryMethodCodeGen(
  methodName = "reverseSandwich",
  fileName = "ops_reverseSandwich.h",
  op = (a: MultiVector[Sym], b: MultiVector[Sym]) => a.reverse.sandwich(b)
)
