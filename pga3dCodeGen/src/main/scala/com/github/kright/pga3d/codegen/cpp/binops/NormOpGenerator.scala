package com.github.kright.pga3d.codegen.cpp.binops

import com.github.kright.pga3d.codegen.common.FileContent
import com.github.kright.pga3d.codegen.cpp.{CppCodeGen, CppSubclass, CppSubclasses, Pga3dCodeGenCpp}
import com.github.kright.symbolic.Sym
import scala.math.Numeric.Implicits.infixNumericOps

class NormOpGenerator extends BinOpCodeGen {
  override def generateBinopCode(codeGen: Pga3dCodeGenCpp): FileContent = {
    val code = CppCodeGen()

    code.pragmaOnce()
    code("#include <cmath>")
    code.apply(s"#include \"${codeGen.Headers.types}\"")
    code.apply(s"#include \"opsArithmetic.h\"")

    code.apply("")
    code.generatedBy(getClass.getName)

    code.namespace(codeGen.namespace) {
      for (cls <- CppSubclasses.all if cls.shouldBeGenerated) {
        // Common result type for normalization by scalar
        val a = cls.makeSymbolic("a")
        val scaled = a * Sym("b")
        val resultCls = CppSubclasses.findMatchingClass(scaled)

        // normSquare over all coefficients
        val coeffs: Seq[Sym] = cls.self.values.values.toSeq
        if (coeffs.nonEmpty) {
          val normSqExpr: Sym = coeffs.map(c => c * c).reduce(_ + _)
          code(s"constexpr double ${cls.name}::normSquare() const noexcept { return ${normSqExpr.toString}; }")
          code(s"inline double ${cls.name}::norm() const noexcept { return std::sqrt(normSquare()); }")
          if (resultCls != CppSubclasses.zeroCls) {
            code(s"inline ${resultCls.name} ${cls.name}::normalizedByNorm() const noexcept { return *this / norm(); }")
          }
          code("")
        }

        // bulkNormSquare over bulk coefficients only
        val bulkCoeffs: Seq[Sym] = cls.self.bulk.values.values.toSeq
        if (bulkCoeffs.nonEmpty) {
          val bulkNormSqExpr: Sym = bulkCoeffs.map(c => c * c).reduce(_ + _)
          code(s"constexpr double ${cls.name}::bulkNormSquare() const noexcept { return ${bulkNormSqExpr.toString}; }")
          code(s"inline double ${cls.name}::bulkNorm() const noexcept { return std::sqrt(bulkNormSquare()); }")
          if (resultCls != CppSubclasses.zeroCls) {
            code(s"inline ${resultCls.name} ${cls.name}::normalizedByBulk() const noexcept { return *this / bulkNorm(); }")
          }
          code("")
        }

        // weightNormSquare over weight coefficients only
        val weightCoeffs: Seq[Sym] = cls.self.weight.values.values.toSeq
        if (weightCoeffs.nonEmpty) {
          val weightNormSqExpr: Sym = weightCoeffs.map(c => c * c).reduce(_ + _)
          code(s"constexpr double ${cls.name}::weightNormSquare() const noexcept { return ${weightNormSqExpr.toString}; }")
          code(s"inline double ${cls.name}::weightNorm() const noexcept { return std::sqrt(weightNormSquare()); }")
          if (resultCls != CppSubclasses.zeroCls) {
            code(s"inline ${resultCls.name} ${cls.name}::normalizedByWeight() const noexcept { return *this / weightNorm(); }")
          }
          code("")
        }
      }
    }

    FileContent(codeGen.directory.resolve("opsNorm.h"), code.toString)
  }

  override def structCode(cls: CppSubclass): String = {
    val a = cls.makeSymbolic("a")
    val scaled = a * Sym("b")
    val resultCls = CppSubclasses.findMatchingClass(scaled)

    val bulkHas = cls.self.bulk.values.nonEmpty
    val weightHas = cls.self.weight.values.nonEmpty

    val normalizedByNormDecl = if (resultCls == CppSubclasses.zeroCls) "" else s"[[nodiscard]] inline ${resultCls.name} normalizedByNorm() const noexcept;"
    val normalizedByBulkDecl = if (bulkHas && resultCls != CppSubclasses.zeroCls) s"[[nodiscard]] inline ${resultCls.name} normalizedByBulk() const noexcept;" else ""
    val normalizedByWeightDecl = if (weightHas && resultCls != CppSubclasses.zeroCls) s"[[nodiscard]] inline ${resultCls.name} normalizedByWeight() const noexcept;" else ""

    val bulkDecls = if (bulkHas) Some(
      "[[nodiscard]] constexpr double bulkNormSquare() const noexcept;\n[[nodiscard]] inline double bulkNorm() const noexcept;"
    ) else None

    val weightDecls = if (weightHas) Some(
      "[[nodiscard]] constexpr double weightNormSquare() const noexcept;\n[[nodiscard]] inline double weightNorm() const noexcept;"
    ) else None

    // norm is always declared (as before)
    val parts = Seq(
      "[[nodiscard]] constexpr double normSquare() const noexcept;",
      "[[nodiscard]] inline double norm() const noexcept;",
      normalizedByNormDecl,
      bulkDecls.getOrElse(""),
      normalizedByBulkDecl,
      weightDecls.getOrElse(""),
      normalizedByWeightDecl
    ).filter(_.nonEmpty)

    parts.mkString("\n")
  }
}
