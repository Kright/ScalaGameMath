package com.github.kright.pga3d.codegen.cpp.binops

import com.github.kright.ga.MultiVector
import com.github.kright.symbolic.Sym

class AntiGeometricOpGenerator extends BinaryMethodCodeGen(
  methodName = "antiGeometric",
  fileName = "ops_antiGeometric.h",
  op = (a: MultiVector[Sym], b: MultiVector[Sym]) => a.antiGeometric(b)
)
