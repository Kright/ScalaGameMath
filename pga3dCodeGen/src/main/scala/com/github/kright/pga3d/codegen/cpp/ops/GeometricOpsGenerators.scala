package com.github.kright.pga3d.codegen.cpp.ops

import com.github.kright.ga.MultiVector
import com.github.kright.pga3d.codegen.common.FileContent
import com.github.kright.pga3d.codegen.cpp.*
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



/**
 * Generalized binary-method code generator for PGA3D C++ bindings.
 * Reuses the same emission pattern for methods like geometric and dot.
 *
 * Simplifications:
 *  - Skip scalar and zero classes entirely
 *  - Multivector interacts only with Multivector
 *  - No X op Multivector for X != Multivector
 *  - Skip emission when result resolves to Zero class
 */
private class BinaryMethodCodeGen(val methodName: String,
                          val fileName: String,
                          val op: (MultiVector[Sym], MultiVector[Sym]) => MultiVector[Sym]) extends CppCodeGenerator:

  override def generateFiles(codeGen: Pga3dCodeGenCpp): Seq[FileContent] =
    val code = CppCodeBuilder()

    code.myHeader(Seq(s"#include \"${codeGen.Headers.types}\""), getClass.getName)

    code.namespace(codeGen.namespace) {
      for (left <- CppSubclasses.all if left.shouldBeGenerated) {
        for (right <- CppSubclasses.all if right.shouldBeGenerated) {
          val skipRight = right == CppSubclasses.scalar || right == CppSubclasses.zeroCls
          val skipLeft = left == CppSubclasses.scalar || left == CppSubclasses.zeroCls
          if !skipLeft && !skipRight then
            val pairAllowed =
              if left == CppSubclasses.multivector then right == CppSubclasses.multivector
              else right != CppSubclasses.multivector

            if pairAllowed then
              val result = op(left.self, right.makeSymbolic("b"))
              val target = CppSubclasses.findMatchingClass(result)
              if target != CppSubclasses.zeroCls then
                code(s"constexpr ${target.name} ${left.name}::${methodName}(const ${right.name}& b) const noexcept { return ${target.makeBracesInit(result)}; }")
        }
        code("")
      }
    }

    Seq(FileContent(codeGen.directory.resolve(fileName), code.toString))

  override def generateStructBody(cls: CppSubclass): Seq[StructBodyPart] =
    val decls =
      for
        right <- CppSubclasses.all
        if right.shouldBeGenerated
        if right != CppSubclasses.scalar && right != CppSubclasses.zeroCls
        if (if cls == CppSubclasses.multivector then right == CppSubclasses.multivector else right != CppSubclasses.multivector)
      yield
        val result = op(cls.self, right.makeSymbolic("b"))
        val target = CppSubclasses.findMatchingClass(result)
        if target == CppSubclasses.zeroCls then ""
        else s"[[nodiscard]] constexpr ${target.name} ${methodName}(const ${right.name}& b) const noexcept;"

    val result = decls.filter(_.nonEmpty).mkString("\n")

    structBodyPart(result)
