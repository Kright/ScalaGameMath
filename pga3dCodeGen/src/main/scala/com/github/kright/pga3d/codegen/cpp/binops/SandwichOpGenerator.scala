package com.github.kright.pga3d.codegen.cpp.binops

import com.github.kright.ga.MultiVector
import com.github.kright.symbolic.Sym

class SandwichOpGenerator extends BinaryMethodCodeGen(
  methodName = "sandwich",
  fileName = "opsSandwich.h",
  op = (a: MultiVector[Sym], b: MultiVector[Sym]) => a.sandwich(b)
)
