package com.github.kright.pga3d.codegen.cpp.binops

import com.github.kright.pga3d.codegen.common.FileContent
import com.github.kright.pga3d.codegen.cpp.{CppCodeGen, CppSubclass, CppSubclasses, Pga3dCodeGenCpp}

class ReverseOpGenerator extends BinOpCodeGen {
  override def generateBinopCode(codeGen: Pga3dCodeGenCpp): FileContent = {
    val code = CppCodeGen()

    code.myHeader(Seq(s"#include \"${codeGen.Headers.types}\""), getClass.getName)

    code.namespace(codeGen.namespace) {
      for (cls <- CppSubclasses.all if cls.shouldBeGenerated) {
        val result = cls.self.reverse
        val target = CppSubclasses.findMatchingClass(result)
        if (target != CppSubclasses.zeroCls) {
          code(s"constexpr ${target.name} ${cls.name}::reverse() const noexcept { return ${target.makeBracesInit(result)}; }")
        }
      }
    }

    FileContent(codeGen.directory.resolve("opsReverse.h"), code.toString)
  }

  override def structCode(cls: CppSubclass): String = {
    val result = cls.self.reverse
    val target = CppSubclasses.findMatchingClass(result)
    if (target == CppSubclasses.zeroCls) "" else s"[[nodiscard]] constexpr ${target.name} reverse() const noexcept;"
  }
}
