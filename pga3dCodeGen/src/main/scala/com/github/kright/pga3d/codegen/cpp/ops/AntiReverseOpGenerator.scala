package com.github.kright.pga3d.codegen.cpp.ops

import com.github.kright.pga3d.codegen.common.FileContent
import com.github.kright.pga3d.codegen.cpp.{CppCodeBuilder, CppCodeGenerator, CppSubclass, CppSubclasses, Pga3dCodeGenCpp, StructBodyPart}

class AntiReverseOpGenerator extends CppCodeGenerator {
  override def generateFiles(codeGen: Pga3dCodeGenCpp): Seq[FileContent] = {
    val code = CppCodeBuilder()

    code.myHeader(Seq(s"#include \"${codeGen.Headers.types}\""), getClass.getName)

    code.namespace(codeGen.namespace) {
      for (cls <- CppSubclasses.all if cls.shouldBeGenerated) {
        val result = cls.self.antiReverse
        val target = CppSubclasses.findMatchingClass(result)
        if (target != CppSubclasses.zeroCls) {
          code(s"constexpr ${target.name} ${cls.name}::antiReversed() const noexcept { return ${target.makeBracesInit(result)}; }")
        }
      }
    }

    Seq(FileContent(codeGen.directory.resolve("opsAntiReverse.h"), code.toString))
  }

  override def generateStructBody(cls: CppSubclass): Seq[StructBodyPart] = {
    val result = cls.self.antiReverse
    val target = CppSubclasses.findMatchingClass(result)
    val code =
      if (target == CppSubclasses.zeroCls) ""
      else s"[[nodiscard]] constexpr ${target.name} antiReversed() const noexcept;"

    structBodyPart(code)
  }
}
