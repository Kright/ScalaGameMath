package com.github.kright.pga3d.codegen.cpp.binops

import com.github.kright.ga.MultiVector
import com.github.kright.symbolic.Sym

class DotOpGenerator extends BinaryMethodCodeGen(
  methodName = "dot",
  fileName = "ops_dot.h",
  op = (a: MultiVector[Sym], b: MultiVector[Sym]) => a.dot(b)
)
