package com.github.kright.pga3d.codegen.cpp.binops

import com.github.kright.pga3d.codegen.common.FileWriterTask
import com.github.kright.pga3d.codegen.cpp.{CppCodeGen, CppSubclass, CppSubclasses, Pga3dCodeGenCpp}

/**
 * Generates simple operations for Translator similar to QuaternionOpsGenerator but only log().
 */
class TranslatorOpsGenerator extends BinOpCodeGen {

  override def structCode(cls: CppSubclass): String = {
    if (cls == CppSubclasses.translator) {
      s"[[nodiscard]] constexpr ${CppSubclasses.bivectorWeight.name} log() const noexcept;"
    } else ""
  }

  override def generateBinopCode(codeGen: Pga3dCodeGenCpp): FileWriterTask = {
    val code = new CppCodeGen()

    code.pragmaOnce()
    code.apply(s"#include \"${codeGen.Headers.types}\"")
    code.apply("")
    code.generatedBy(getClass.getName)

    val cls = CppSubclasses.translator

    code.namespace(codeGen.namespace) {
      code(
        s"""
           |[[nodiscard]] constexpr ${CppSubclasses.bivectorWeight.name} ${cls.name}::log() const noexcept {
           |    return ${CppSubclasses.bivectorWeight.name} {
           |        .wx = wx,
           |        .wy = wy,
           |        .wz = wz,
           |    };
           |}
           |""".stripMargin)
    }

    FileWriterTask(codeGen.directory.resolve("opsTranslator.h"), code.toString)
  }
}
