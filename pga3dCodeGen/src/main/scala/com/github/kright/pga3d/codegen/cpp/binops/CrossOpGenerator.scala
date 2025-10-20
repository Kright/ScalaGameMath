package com.github.kright.pga3d.codegen.cpp.binops

import com.github.kright.ga.MultiVector
import com.github.kright.symbolic.Sym

class CrossOpGenerator extends BinaryMethodCodeGen(
  methodName = "cross",
  fileName = "opsCross.h",
  op = (a: MultiVector[Sym], b: MultiVector[Sym]) => a.crossX2(b) * Sym(0.5)
)
