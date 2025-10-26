package com.github.kright.pga3d.codegen.cpp.binops

import com.github.kright.ga.MultiVector
import com.github.kright.pga3d.codegen.common.FileWriterTask
import com.github.kright.pga3d.codegen.cpp.{CppCodeGen, CppSubclass, CppSubclasses, Pga3dCodeGenCpp}
import com.github.kright.symbolic.Sym

class ArithmeticsGenerator extends BinOpCodeGen:
  override def generateBinopCode(codeGen: Pga3dCodeGenCpp): FileWriterTask = {
    val code = CppCodeGen()

    code.pragmaOnce()
    code.apply("#include <cmath>")
    code.apply(s"#include \"${codeGen.Headers.types}\"")
    code.apply("")
    code.generatedBy(getClass.getName)

    code.namespace(codeGen.namespace) {
      plusMinus(code)
      code("")
      unaryMinus(code)
      code("")
      code("")
      multiplyOrDivideByScalar(code)
      code("")
      madd(code)
    }

    FileWriterTask(codeGen.directory.resolve("opsArithmetic.h"), code.toString)
  }

  private def multiplyOrDivideByScalar(code: CppCodeGen): Unit = {
    import com.github.kright.symbolic.Sym

    for (cls <- CppSubclasses.all if cls.shouldBeGenerated) {
      val a = cls.makeSymbolic("a")
      val result = a * Sym("d")
      val resultCls = CppSubclasses.findMatchingClass(result)
      code(s"[[nodiscard]] constexpr ${resultCls.name} operator*(const ${cls.name}& a, double d) noexcept { return ${resultCls.makeBracesInit(result)}; }")
      code(s"[[nodiscard]] constexpr ${resultCls.name} operator*(double d, const ${cls.name}& a) noexcept { return ${resultCls.makeBracesInit(result)}; }")
      code(s"[[nodiscard]] constexpr ${resultCls.name} operator/(const ${cls.name}& a, double d) noexcept { return a * (1.0 / d); }")

      if (resultCls == cls) {
        code(s"constexpr ${resultCls.name}& operator*=(${cls.name}& a, double d) noexcept { a = a * d; return a; }")
        code(s"constexpr ${resultCls.name}& operator/=(${cls.name}& a, double d) noexcept { a = a / d; return a; }")
      }

      code("")
    }
  }

  private def unaryMinus(code: CppCodeGen): Unit = {
    for (cls <- CppSubclasses.all if cls.shouldBeGenerated) {
      val a = cls.makeSymbolic("a")
      val result = -a
      val resultCls = CppSubclasses.findMatchingClass(result)
      if (resultCls != CppSubclasses.zeroCls) {
        code(s"[[nodiscard]] constexpr ${resultCls.name} operator-(const ${cls.name}& a) noexcept { return ${resultCls.makeBracesInit(result)}; }")
      }
    }
  }

  private def plusMinus(code: CppCodeGen): Unit = {

    def makeMethod(left: CppSubclass, right: CppSubclass, operatorName: String, op: (MultiVector[Sym], MultiVector[Sym]) => MultiVector[Sym]): Unit = {
      val a = left.makeSymbolic("a")
      val b = right.makeSymbolic("b")
      val result = op(a, b)
      val resultCls = CppSubclasses.findMatchingClass(result)
      if (resultCls != CppSubclasses.zeroCls) {
        code(s"[[nodiscard]] constexpr ${resultCls.name} operator${operatorName}(const ${left.name}& a, const ${right.name}& b) noexcept { return ${resultCls.makeBracesInit(result)}; }")
      }
      if (resultCls == left) {
        code(s"constexpr ${resultCls.name}& operator${operatorName}=(${left.name}& a, const ${right.name}& b) noexcept { a = a ${operatorName} b; return a; }")
      }
    }

    val points = Set(CppSubclasses.projectivePoint, CppSubclasses.point, CppSubclasses.vector)
    val bivectors = Set(CppSubclasses.bivector, CppSubclasses.bivectorBulk, CppSubclasses.bivectorWeight)

    for (cls <- CppSubclasses.all if cls.shouldBeGenerated) {
      val self = cls.self

      if (points.contains(cls)) {
        for (pClass <- points) {
          makeMethod(cls, pClass, "+", _ + _)
          makeMethod(cls, pClass, "-", _ - _)
        }
      } else if (bivectors.contains(cls)) {
        for (pClass <- bivectors) {
          makeMethod(cls, pClass, "+", _ + _)
          makeMethod(cls, pClass, "-", _ - _)
        }
      } else {
        makeMethod(cls, cls, "+", _ + _)
        makeMethod(cls, cls, "-", _ - _)
      }
      code("")
    }
  }

  private def madd(code: CppCodeGen): Unit = {
    // Generate member method implementations using std::fma only when result type equals the class itself
    for (cls <- CppSubclasses.all if cls.shouldBeGenerated) {
      val selfMv = cls.self

      // Case 1: same-type madd
      val otherMvSame = cls.makeSymbolic("other")
      val trialSame = selfMv + otherMvSame * Sym("mult")
      val resultClsSame = CppSubclasses.findMatchingClass(trialSame)
      if (resultClsSame == cls && cls.variableFields.nonEmpty) {
        // Build initialization list with fma for each variable field
        val selfGrouped = selfMv.mapValues(_.groupMultipliers())
        val otherGrouped = otherMvSame.mapValues(_.groupMultipliers())
        val fieldsInit = cls.variableFields.map { f =>
          val selfExpr = selfGrouped.values.getOrElse(f.basisBlade, Sym.zero).toString
          val otherExpr = otherGrouped.values.getOrElse(f.basisBlade, Sym.zero).toString
          val sExprFinal = if (selfExpr.startsWith("--")) selfExpr.drop(2) else selfExpr
          val oExprFinal = if (otherExpr.startsWith("--")) otherExpr.drop(2) else otherExpr
          s".${f.name} = std::fma(${oExprFinal}, mult, ${sExprFinal})"
        }.mkString("{", ", ", "}")
        code(s"constexpr ${cls.name} ${cls.name}::madd(const ${cls.name}& other, double mult) const noexcept { return ${fieldsInit}; }")
      }

      // Case 2: Point + Vector * mult -> Point
      if (cls == CppSubclasses.point && cls.variableFields.nonEmpty) {
        val otherMvVec = CppSubclasses.vector.makeSymbolic("other")
        val trialPV = selfMv + otherMvVec * Sym("mult")
        val resultClsPV = CppSubclasses.findMatchingClass(trialPV)
        if (resultClsPV == CppSubclasses.point) {
          val selfGrouped = selfMv.mapValues(_.groupMultipliers())
          val otherGrouped = otherMvVec.mapValues(_.groupMultipliers())
          val fieldsInit = cls.variableFields.map { f =>
            val selfExpr = selfGrouped.values.getOrElse(f.basisBlade, Sym.zero).toString
            val otherExpr = otherGrouped.values.getOrElse(f.basisBlade, Sym.zero).toString
            val sExprFinal = if (selfExpr.startsWith("--")) selfExpr.drop(2) else selfExpr
            val oExprFinal = if (otherExpr.startsWith("--")) otherExpr.drop(2) else otherExpr
            s".${f.name} = std::fma(${oExprFinal}, mult, ${sExprFinal})"
          }.mkString("{", ", ", "}")
          code(s"constexpr ${cls.name} ${cls.name}::madd(const ${CppSubclasses.vector.name}& other, double mult) const noexcept { return ${fieldsInit}; }")
        }
      }
    }
  }

  override def structCode(cls: CppSubclass): String = {
    val a = cls.makeSymbolic("a")
    val b = cls.makeSymbolic("b")
    val trialSame = a + b * Sym("mult")
    val resultClsSame = CppSubclasses.findMatchingClass(trialSame)

    val sameTypeDecl = if (resultClsSame == cls && cls.variableFields.nonEmpty) s"[[nodiscard]] constexpr ${cls.name} madd(const ${cls.name}& other, double mult) const noexcept;" else ""

    // Special overload for Point + Vector * mult -> Point
    val pointVectorDecl =
      if (cls == CppSubclasses.point && cls.variableFields.nonEmpty) {
        val otherV = CppSubclasses.vector.makeSymbolic("b")
        val trialPV = a + otherV * Sym("mult")
        val resultPV = CppSubclasses.findMatchingClass(trialPV)
        if (resultPV == CppSubclasses.point) s"[[nodiscard]] constexpr ${cls.name} madd(const ${CppSubclasses.vector.name}& other, double mult) const noexcept;" else ""
      } else ""

    Seq(sameTypeDecl, pointVectorDecl).filter(_.nonEmpty).mkString("\n")
  }
