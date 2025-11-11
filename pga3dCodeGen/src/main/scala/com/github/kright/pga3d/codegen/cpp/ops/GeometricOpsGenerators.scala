package com.github.kright.pga3d.codegen.cpp.ops

import com.github.kright.ga.MultiVector
import com.github.kright.math.Sign
import com.github.kright.math.Sign.Positive
import com.github.kright.pga3d.codegen.common.FileContent
import com.github.kright.pga3d.codegen.cpp.*
import com.github.kright.symbolic.Sym

import scala.+:


class GeometricOpsGenerator extends CppCodeGeneratorSum(
  Seq(
    new GeometricOpGenerator(),
    new AntiGeometricOpGenerator(),

    new DotOpGenerator(),
    new AntiDotOpGenerator(),

    new WedgeOpGenerator(),
    new AntiWedgeOpGenerator(),

    new SandwichOpGenerator(),
    new SandwichAsMatrix(),
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
                code(s"constexpr ${target.name} ${left.name}::${methodName}(const ${right.name}& b) const noexcept { return ${target.makeBracesInit(result, multiline = true)}; }")
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


class SandwichAsMatrix extends CppCodeGenerator {

  private def motorClasses: Seq[CppSubclass] =
    Seq(CppSubclasses.motor, CppSubclasses.quaternion)

  private def elemClasses: Seq[CppSubclass] =
    Seq(CppSubclasses.projectivePoint, CppSubclasses.vector, CppSubclasses.bivector, CppSubclasses.plane)

  private def generateCode(anyMotor: CppSubclass, element: CppSubclass): DeclarationWithImplementation = {
    val decl = CppCodeBuilder()
    val impl = CppCodeBuilder()

    val result = anyMotor.self.sandwich(element.self)
    val resultType = CppSubclasses.findMatchingClass(result)
    require(resultType == element)

    val size = element.variableFields.size
    val matrixSize = size * size

    import Pga3dProvider.pga3

    val probes = element.variableFields.map { f =>
      MultiVector[Sym](
        Seq(
          (f.basisBlade, if (f.sign == Positive) Sym(1) else Sym(-1))
        )
      )
    }

    val mappedProbes = probes.map { p => anyMotor.self.sandwich(p) }

    val arrayElements = element.variableFields.flatMap { f =>
      mappedProbes.map { p =>
        p.get(f.basisBladeWithSign).getOrElse(Sym(0.0))
      }
    }

    decl(s"[[nodiscard]] constexpr std::array<double, $matrixSize> sandwichAsMatrixFor${element.name}() const noexcept;")
    impl(
      s"""constexpr std::array<double, $matrixSize> ${anyMotor.name}::sandwichAsMatrixFor${element.name}() const noexcept {
         |    return {
         |        ${arrayElements.grouped(size).map(_.mkString(", ")).mkString(",\n" + " " * 8)}
         |    };
         |}
         |""".stripMargin)

    DeclarationWithImplementation(decl.toString, impl.toString)
  }

  override def generateStructBody(cls: CppSubclass): Seq[StructBodyPart] = {
    if (!Set(CppSubclasses.motor, CppSubclasses.quaternion).contains(cls)) return Seq()

    val code = CppCodeBuilder()

    for (elem <- elemClasses) {
      code(generateCode(cls, elem).declaration)
    }

    structBodyPart(code.toString, includes = Seq("<array>"))
  }

  override def generateFiles(codeGen: Pga3dCodeGenCpp): Seq[FileContent] = {
    val code = CppCodeBuilder()

    code.myHeader(
      Seq(
        s"\"${CppSubclasses.motor.name}.h\"",
        s"\"${CppSubclasses.quaternion.name}.h\"",
      ),
      this.getClass.getName
    )

    code.namespace(codeGen.namespace) {
      val impls = motorClasses.flatMap { motor =>
        elemClasses.map { elem =>
          generateCode(motor, elem).implementation
        }
      }

      code(impls.mkString("\n\n"))
    }

    Seq(FileContent(codeGen.directory.resolve("opsSandwichAsMatrix.h"), code.toString))
  }
}

private class DeclarationWithImplementation(val declaration: String, val implementation: String)