package com.github.kright.pga3d.codegen.cpp.binops

import com.github.kright.pga3d.codegen.common.FileWriterTask
import com.github.kright.pga3d.codegen.cpp.{CppCodeGen, CppSubclass, CppSubclasses, Pga3dCodeGenCpp}

class PointOpsGenerator extends BinOpCodeGen {

  override def structCode(cls: CppSubclass): String = {
    if (cls == CppSubclasses.point) {
      s"""[[nodiscard]] inline double distanceTo(const ${CppSubclasses.point.name}& other) const noexcept;"""
    } else ""
  }

  override def generateBinopCode(codeGen: Pga3dCodeGenCpp): FileWriterTask = {
    val code = new CppCodeGen()

    code.pragmaOnce()
    code.apply(s"#include \"${codeGen.Headers.types}\"")
    code.apply("#include \"ops_arithmetic.h\"")
    code.apply("#include \"ops_norm.h\"")
    code.apply("")
    code.generatedBy(getClass.getName)

    code.namespace(codeGen.namespace) {
      code(
        s"""
           |[[nodiscard]] inline double ${CppSubclasses.point.name}::distanceTo(const ${CppSubclasses.point.name}& other) const noexcept {
           |    return ((*this) - other).norm();
           |}
           |""".stripMargin)
    }

    FileWriterTask(codeGen.directory.resolve("ops_Point.h"), code.toString)
  }
}
