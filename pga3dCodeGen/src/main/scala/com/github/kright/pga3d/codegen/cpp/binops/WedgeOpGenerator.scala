package com.github.kright.pga3d.codegen.cpp.binops

import com.github.kright.ga.MultiVector
import com.github.kright.symbolic.Sym

class WedgeOpGenerator extends BinaryMethodCodeGen(
  methodName = "wedge",
  fileName = "ops_wedge.h",
  op = (a: MultiVector[Sym], b: MultiVector[Sym]) => a.wedge(b)
)
