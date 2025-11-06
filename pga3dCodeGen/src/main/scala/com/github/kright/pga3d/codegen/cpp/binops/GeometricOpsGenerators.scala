package com.github.kright.pga3d.codegen.cpp.binops

import com.github.kright.ga.MultiVector
import com.github.kright.pga3d.codegen.cpp.CppCodeGeneratorSum
import com.github.kright.symbolic.Sym


class GeometricOpsGenerator extends CppCodeGeneratorSum(
  Seq(
    new GeometricOpGenerator(),
    new AntiGeometricOpGenerator(),

    new DotOpGenerator(),
    new AntiDotOpGenerator(),

    new WedgeOpGenerator(),
    new AntiWedgeOpGenerator(),

    new SandwichOpGenerator(),
    new ReverseSandwichOpGenerator(),

    new CrossOpGenerator(),
  )
)


class GeometricOpGenerator extends BinaryMethodCodeGen(
  methodName = "geometric",
  fileName = "opsGeometric.h",
  op = (a: MultiVector[Sym], b: MultiVector[Sym]) => a.geometric(b)
)

class AntiGeometricOpGenerator extends BinaryMethodCodeGen(
  methodName = "antiGeometric",
  fileName = "opsAntiGeometric.h",
  op = (a: MultiVector[Sym], b: MultiVector[Sym]) => a.antiGeometric(b)
)


class DotOpGenerator extends BinaryMethodCodeGen(
  methodName = "dot",
  fileName = "opsDot.h",
  op = (a: MultiVector[Sym], b: MultiVector[Sym]) => a.dot(b)
)

class AntiDotOpGenerator extends BinaryMethodCodeGen(
  methodName = "antiDot",
  fileName = "opsAntiDot.h",
  op = (a: MultiVector[Sym], b: MultiVector[Sym]) => a.antiDot(b)
)


class WedgeOpGenerator extends BinaryMethodCodeGen(
  methodName = "wedge",
  fileName = "opsWedge.h",
  op = (a: MultiVector[Sym], b: MultiVector[Sym]) => a.wedge(b)
)

class AntiWedgeOpGenerator extends BinaryMethodCodeGen(
  methodName = "antiWedge",
  fileName = "opsAntiWedge.h",
  op = (a: MultiVector[Sym], b: MultiVector[Sym]) => a.antiWedge(b)
)


class SandwichOpGenerator extends BinaryMethodCodeGen(
  methodName = "sandwich",
  fileName = "opsSandwich.h",
  op = (a: MultiVector[Sym], b: MultiVector[Sym]) => a.sandwich(b)
)

class ReverseSandwichOpGenerator extends BinaryMethodCodeGen(
  methodName = "reverseSandwich",
  fileName = "opsReverseSandwich.h",
  op = (a: MultiVector[Sym], b: MultiVector[Sym]) => a.reverse.sandwich(b)
)


class CrossOpGenerator extends BinaryMethodCodeGen(
  methodName = "cross",
  fileName = "opsCross.h",
  op = (a: MultiVector[Sym], b: MultiVector[Sym]) => a.crossX2(b) * Sym(0.5)
)