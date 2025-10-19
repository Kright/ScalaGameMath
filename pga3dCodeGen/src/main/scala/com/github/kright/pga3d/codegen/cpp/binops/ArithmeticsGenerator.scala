package com.github.kright.pga3d.codegen.cpp.binops

import com.github.kright.ga.MultiVector
import com.github.kright.pga3d.codegen.common.FileWriterTask
import com.github.kright.pga3d.codegen.cpp.{CppCodeGen, CppSubclass, CppSubclasses, Pga3dCodeGenCpp}
import com.github.kright.symbolic.Sym

class ArithmeticsGenerator extends BinOpCodeGen:
  override def generateBinopCode(codeGen: Pga3dCodeGenCpp): FileWriterTask = {
    val code = CppCodeGen()

    code.pragmaOnce()
    code.apply(s"#include \"${codeGen.Headers.types}\"")
    code.apply("")
    code.generatedBy(getClass.getName)

    code.namespace(codeGen.namespace) {
      plusMinus(code)
    }

    FileWriterTask(codeGen.directory.resolve("ops_arithmetic.h"), code.toString)
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

  override def structCode(cls: CppSubclass): String = ""
