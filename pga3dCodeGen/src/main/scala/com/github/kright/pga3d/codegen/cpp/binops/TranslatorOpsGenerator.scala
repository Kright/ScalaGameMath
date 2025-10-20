package com.github.kright.pga3d.codegen.cpp.binops

import com.github.kright.pga3d.codegen.common.FileWriterTask
import com.github.kright.pga3d.codegen.cpp.{CppCodeGen, CppSubclass, CppSubclasses, Pga3dCodeGenCpp}

/**
 * Generates simple operations for Translator similar to QuaternionOpsGenerator but only log().
 */
class TranslatorOpsGenerator extends BinOpCodeGen {

  override def structCode(cls: CppSubclass): String = {
    if (cls != CppSubclasses.translator) return ""

    val code = new CppCodeGen()

    code(s"[[nodiscard]] static constexpr ${cls.name} id() noexcept { return {}; }")
    code(s"[[nodiscard]] static constexpr ${cls.name} addVector(const ${CppSubclasses.vector.name}& v) noexcept;")
    code(s"")
    code(s"[[nodiscard]] constexpr ${CppSubclasses.bivectorWeight.name} log() const noexcept;")

    code.toString()
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
           |[[nodiscard]] constexpr Translator Translator::addVector(const Vector& v) noexcept { return {.wx = v.x, .wy = v.y, .wz = v.z}; }
           |""".stripMargin)

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
