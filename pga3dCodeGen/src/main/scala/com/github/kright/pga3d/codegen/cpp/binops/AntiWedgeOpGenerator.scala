package com.github.kright.pga3d.codegen.cpp.binops

import com.github.kright.ga.MultiVector
import com.github.kright.symbolic.Sym

class AntiWedgeOpGenerator extends BinaryMethodCodeGen(
  methodName = "antiWedge",
  fileName = "opsAntiWedge.h",
  op = (a: MultiVector[Sym], b: MultiVector[Sym]) => a.antiWedge(b)
)
