package com.github.kright.pga3d.codegen.cpp.binops

import com.github.kright.pga3d.codegen.common.FileContent
import com.github.kright.pga3d.codegen.cpp.{CppCodeGen, CppSubclass, CppSubclasses, Pga3dCodeGenCpp}

class BulkOpGenerator extends BinOpCodeGen {
  override def generateBinopCode(codeGen: Pga3dCodeGenCpp): FileContent = {
    val code = CppCodeGen()

    code.pragmaOnce()
    code.apply(s"#include \"${codeGen.Headers.types}\"")
    code.apply("")
    code.generatedBy(getClass.getName)

    code.namespace(codeGen.namespace) {
      for (cls <- CppSubclasses.all if cls.shouldBeGenerated) {
        val result = cls.self.bulk
        val target = CppSubclasses.findMatchingClass(result)
        if (target != CppSubclasses.zeroCls) {
          code(s"constexpr ${target.name} ${cls.name}::bulk() const noexcept { return ${target.makeBracesInit(result)}; }")
        }
      }
    }

    FileContent(codeGen.directory.resolve("opsBulk.h"), code.toString)
  }

  override def structCode(cls: CppSubclass): String = {
    val result = cls.self.bulk
    val target = CppSubclasses.findMatchingClass(result)
    if (target == CppSubclasses.zeroCls) "" else s"[[nodiscard]] constexpr ${target.name} bulk() const noexcept;"
  }
}
