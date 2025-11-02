package com.github.kright.pga3d.codegen.cpp.binops

import com.github.kright.pga3d.codegen.common.FileContent
import com.github.kright.pga3d.codegen.cpp.{CppCodeGen, CppSubclass, CppSubclasses, Pga3dCodeGenCpp}

class BivectorWeightOpsGenerator extends BinOpCodeGen {

  override def structCode(cls: CppSubclass): String = {
    if (cls == CppSubclasses.bivectorWeight) {
      s"""[[nodiscard]] inline ${CppSubclasses.translator.name} exp() const noexcept;"""
    } else ""
  }

  override def generateBinopCode(codeGen: Pga3dCodeGenCpp): FileContent = {
    val code = new CppCodeGen()

    code.pragmaOnce()
    code.apply(s"#include \"${codeGen.Headers.types}\"")
    code.apply("")
    code.generatedBy(getClass.getName)

    code.namespace(codeGen.namespace) {
      code(
        s"""
           |[[nodiscard]] inline ${CppSubclasses.translator.name} ${CppSubclasses.bivectorWeight.name}::exp() const noexcept {
           |    return ${CppSubclasses.translator.name}{
           |        .wx = wx,
           |        .wy = wy,
           |        .wz = wz,
           |    };
           |}
           |""".stripMargin)
    }

    FileContent(codeGen.directory.resolve("opsBivectorWeight.h"), code.toString)
  }
}
