package com.github.kright.pga3d.codegen.cpp.binops

import com.github.kright.pga3d.codegen.common.FileWriterTask
import com.github.kright.pga3d.codegen.cpp.{CppCodeGen, CppSubclass, CppSubclasses, Pga3dCodeGenCpp}

class PointOpsGenerator extends BinOpCodeGen {

  override def structCode(cls: CppSubclass): String = {
    if (cls == CppSubclasses.point) {
      s"""[[nodiscard]] inline double distanceTo(const ${CppSubclasses.point.name}& other) const noexcept;
         |
         |[[nodiscard]] inline ${CppSubclasses.point.name} min(const ${CppSubclasses.point.name}& other) const noexcept;
         |[[nodiscard]] inline ${CppSubclasses.point.name} max(const ${CppSubclasses.point.name}& other) const noexcept;
         |[[nodiscard]] inline ${CppSubclasses.point.name} clamp(const ${CppSubclasses.point.name}& minV, const ${CppSubclasses.point.name}& maxV) const noexcept;""".stripMargin
    } else ""
  }

  override def generateBinopCode(codeGen: Pga3dCodeGenCpp): FileWriterTask = {
    val code = new CppCodeGen()

    code.pragmaOnce()
    code.apply("#include <algorithm>")
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
           |
           |[[nodiscard]] inline ${CppSubclasses.point.name} ${CppSubclasses.point.name}::min(const ${CppSubclasses.point.name}& other) const noexcept {
           |    return ${CppSubclasses.point.name}{
           |        .x = std::min(x, other.x),
           |        .y = std::min(y, other.y),
           |        .z = std::min(z, other.z),
           |    };
           |}
           |
           |[[nodiscard]] inline ${CppSubclasses.point.name} ${CppSubclasses.point.name}::max(const ${CppSubclasses.point.name}& other) const noexcept {
           |    return ${CppSubclasses.point.name}{
           |        .x = std::max(x, other.x),
           |        .y = std::max(y, other.y),
           |        .z = std::max(z, other.z),
           |    };
           |}
           |
           |[[nodiscard]] inline ${CppSubclasses.point.name} ${CppSubclasses.point.name}::clamp(const ${CppSubclasses.point.name}& minV, const ${CppSubclasses.point.name}& maxV) const noexcept {
           |    return ${CppSubclasses.point.name}{
           |        .x = std::clamp(x, minV.x, maxV.x),
           |        .y = std::clamp(y, minV.y, maxV.y),
           |        .z = std::clamp(z, minV.z, maxV.z),
           |    };
           |}
           |""".stripMargin)
    }

    FileWriterTask(codeGen.directory.resolve("ops_Point.h"), code.toString)
  }
}
