package com.github.kright.pga3d.codegen.cpp.binops

import com.github.kright.ga.MultiVector
import com.github.kright.symbolic.Sym

class AntiDotOpGenerator extends BinaryMethodCodeGen(
  methodName = "antiDot",
  fileName = "opsAntiDot.h",
  op = (a: MultiVector[Sym], b: MultiVector[Sym]) => a.antiDot(b)
)
