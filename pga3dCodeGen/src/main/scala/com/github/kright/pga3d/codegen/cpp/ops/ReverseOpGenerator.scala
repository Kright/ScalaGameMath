package com.github.kright.pga3d.codegen.cpp.ops

import com.github.kright.pga3d.codegen.common.FileContent
import com.github.kright.pga3d.codegen.cpp.{CppCodeBuilder, CppCodeGenerator, CppSubclass, CppSubclasses, Pga3dCodeGenCpp, StructBodyPart}

class ReverseOpGenerator extends CppCodeGenerator {
  override def generateFiles(codeGen: Pga3dCodeGenCpp): Seq[FileContent] = {
    val code = CppCodeBuilder()

    code.myHeader(Seq(s"#include \"${codeGen.Headers.types}\""), getClass.getName)

    code.namespace(codeGen.namespace) {
      for (cls <- CppSubclasses.all if cls.shouldBeGenerated) {
        val result = cls.self.reverse
        val target = CppSubclasses.findMatchingClass(result)
        if (target != CppSubclasses.zeroCls) {
          code(s"constexpr ${target.name} ${cls.name}::reversed() const noexcept { return ${target.makeBracesInit(result)}; }")
        }
      }
    }

    Seq(FileContent(codeGen.directory.resolve("opsReverse.h"), code.toString))
  }

  override def generateStructBody(cls: CppSubclass): Seq[StructBodyPart] = {
    val result = cls.self.reverse
    val target = CppSubclasses.findMatchingClass(result)
    if (target == CppSubclasses.zeroCls) Seq() 
    else structBodyPart(s"[[nodiscard]] constexpr ${target.name} reversed() const noexcept;")
  }
}
