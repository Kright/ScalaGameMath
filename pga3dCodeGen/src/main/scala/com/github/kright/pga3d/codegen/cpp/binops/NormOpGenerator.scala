package com.github.kright.pga3d.codegen.cpp.binops

import com.github.kright.pga3d.codegen.common.FileWriterTask
import com.github.kright.pga3d.codegen.cpp.{CppCodeGen, CppSubclass, CppSubclasses, Pga3dCodeGenCpp}
import com.github.kright.symbolic.Sym
import scala.math.Numeric.Implicits.infixNumericOps

class NormOpGenerator extends BinOpCodeGen {
  override def generateBinopCode(codeGen: Pga3dCodeGenCpp): FileWriterTask = {
    val code = CppCodeGen()

    code.pragmaOnce()
    code("#include <cmath>")
    code.apply(s"#include \"${codeGen.Headers.types}\"")
    code.apply("")
    code.generatedBy(getClass.getName)

    code.namespace(codeGen.namespace) {
      for (cls <- CppSubclasses.all if cls.shouldBeGenerated) {
        // normSquare
        val coeffs: Seq[Sym] = cls.self.values.values.toSeq

        if (coeffs.nonEmpty) {
          val normSqExpr: Sym = coeffs.map(c => c * c).reduce(_ + _)
          code(s"constexpr double ${cls.name}::normSquare() const noexcept { return ${normSqExpr.toString}; }")

          // norm
          code(s"double ${cls.name}::norm() const noexcept { return std::sqrt(normSquare()); }")

          // normalizedByNorm uses division by scalar from ops_arithmetic.h
          val a = cls.makeSymbolic("a")
          val scaled = a * Sym("b")
          val resultCls = CppSubclasses.findMatchingClass(scaled)
          if (resultCls != CppSubclasses.zeroCls) {
            code(s"${resultCls.name} ${cls.name}::normalizedByNorm() const noexcept { return *this / norm(); }")
          }

          code("")
        }
      }
    }

    FileWriterTask(codeGen.directory.resolve("ops_norm.h"), code.toString)
  }

  override def structCode(cls: CppSubclass): String = {
    val a = cls.makeSymbolic("a")
    val scaled = a * Sym("b")
    val resultCls = CppSubclasses.findMatchingClass(scaled)
    val normalizedDecl = if (resultCls == CppSubclasses.zeroCls) "" else s"[[nodiscard]] ${resultCls.name} normalizedByNorm() const noexcept;"
    s"""[[nodiscard]] constexpr double normSquare() const noexcept;
       |[[nodiscard]] double norm() const noexcept;
       |$normalizedDecl""".stripMargin.trim
  }
}
