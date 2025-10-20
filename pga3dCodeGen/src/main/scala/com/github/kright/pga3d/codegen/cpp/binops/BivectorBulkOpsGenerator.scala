package com.github.kright.pga3d.codegen.cpp.binops

import com.github.kright.pga3d.codegen.common.FileWriterTask
import com.github.kright.pga3d.codegen.cpp.{CppCodeGen, CppSubclass, CppSubclasses, Pga3dCodeGenCpp}

class BivectorBulkOpsGenerator extends BinOpCodeGen {

  override def structCode(cls: CppSubclass): String = {
    if (cls == CppSubclasses.bivectorBulk) {
      s"""[[nodiscard]] inline ${CppSubclasses.quaternion.name} exp() const noexcept;"""
    } else ""
  }

  override def generateBinopCode(codeGen: Pga3dCodeGenCpp): FileWriterTask = {
    val code = new CppCodeGen()

    code.pragmaOnce()
    code.apply("#include <cmath>")
    code.apply(s"#include \"${codeGen.Headers.types}\"")
    code.apply("#include \"ops_norm.h\"")
    code.apply("")
    code.generatedBy(getClass.getName)

    code.namespace(codeGen.namespace) {
      code(
        s"""
           |[[nodiscard]] inline ${CppSubclasses.quaternion.name} ${CppSubclasses.bivectorBulk.name}::exp() const noexcept {
           |    const double len = bulkNorm();
           |    const double cos = std::cos(len);
           |
           |    const double sinDivLen = (len > 1e-5)
           |        ? (std::sin(len) / len)
           |        : (1.0 - (len * len) / 6.0);
           |
           |    return ${CppSubclasses.quaternion.name}{
           |        .s = cos,
           |        .xy = sinDivLen * xy,
           |        .xz = sinDivLen * xz,
           |        .yz = sinDivLen * yz,
           |    };
           |}
           |""".stripMargin)
    }

    FileWriterTask(codeGen.directory.resolve("ops_BivectorBulk.h"), code.toString)
  }
}
