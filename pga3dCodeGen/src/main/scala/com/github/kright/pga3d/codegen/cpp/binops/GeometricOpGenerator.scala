package com.github.kright.pga3d.codegen.cpp.binops

import com.github.kright.ga.MultiVector
import com.github.kright.symbolic.Sym

class GeometricOpGenerator extends BinaryMethodCodeGen(
  methodName = "geometric",
  fileName = "ops_geometric.h",
  op = (a: MultiVector[Sym], b: MultiVector[Sym]) => a.geometric(b)
)
