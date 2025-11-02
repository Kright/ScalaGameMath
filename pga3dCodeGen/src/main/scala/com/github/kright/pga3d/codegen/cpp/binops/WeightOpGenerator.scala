package com.github.kright.pga3d.codegen.cpp.binops

import com.github.kright.pga3d.codegen.common.FileContent
import com.github.kright.pga3d.codegen.cpp.{CppCodeGen, CppSubclass, CppSubclasses, Pga3dCodeGenCpp}

class WeightOpGenerator extends BinOpCodeGen {
  override def generateBinopCode(codeGen: Pga3dCodeGenCpp): FileContent = {
    val code = CppCodeGen()

    code.pragmaOnce()
    code.apply(s"#include \"${codeGen.Headers.types}\"")
    code.apply("")
    code.generatedBy(getClass.getName)

    code.namespace(codeGen.namespace) {
      for (cls <- CppSubclasses.all if cls.shouldBeGenerated) {
        val result = cls.self.weight
        val target = CppSubclasses.findMatchingClass(result)
        if (target != CppSubclasses.zeroCls) {
          code(s"constexpr ${target.name} ${cls.name}::weight() const noexcept { return ${target.makeBracesInit(result)}; }")
        }
      }
    }

    FileContent(codeGen.directory.resolve("opsWeight.h"), code.toString)
  }

  override def structCode(cls: CppSubclass): String = {
    val result = cls.self.weight
    val target = CppSubclasses.findMatchingClass(result)
    if (target == CppSubclasses.zeroCls) ""
    else s"[[nodiscard]] constexpr ${target.name} weight() const noexcept;"
  }
}
