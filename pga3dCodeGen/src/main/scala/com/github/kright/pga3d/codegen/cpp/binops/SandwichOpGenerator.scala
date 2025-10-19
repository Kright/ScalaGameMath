package com.github.kright.pga3d.codegen.cpp.binops

import com.github.kright.ga.MultiVector
import com.github.kright.symbolic.Sym

class SandwichOpGenerator extends BinaryMethodCodeGen(
  methodName = "sandwich",
  fileName = "ops_sandwich.h",
  op = (a: MultiVector[Sym], b: MultiVector[Sym]) => a.sandwich(b)
)
