package com.github.kright.pga3d.codegen.cpp.binops

import com.github.kright.pga3d.codegen.common.FileContent
import com.github.kright.pga3d.codegen.cpp.{CppCodeGen, CppCodeGenerator, CppSubclass, CppSubclasses, Pga3dCodeGenCpp, StructBodyPart}

class VectorOpsGenerator extends CppCodeGenerator {

  override def generateStructBody(cls: CppSubclass): Seq[StructBodyPart] = {
    if (cls == CppSubclasses.vector) {
      structBodyPart(
        s"""[[nodiscard]] inline ${CppSubclasses.vector.name} min(const ${CppSubclasses.vector.name}& other) const noexcept;
           |[[nodiscard]] inline ${CppSubclasses.vector.name} max(const ${CppSubclasses.vector.name}& other) const noexcept;
           |[[nodiscard]] inline ${CppSubclasses.vector.name} clamp(const ${CppSubclasses.vector.name}& minV, const ${CppSubclasses.vector.name}& maxV) const noexcept;""".stripMargin
      )
    } else Seq()
  }

  override def generateFiles(codeGen: Pga3dCodeGenCpp): Seq[FileContent] = {
    val code = new CppCodeGen()

    code.myHeader(
      Seq(
        "#include <algorithm>",
        s"#include \"Vector.h\"",
      ),
      getClass.getName)

    code.namespace(codeGen.namespace) {
      code(
        s"""
           |[[nodiscard]] inline ${CppSubclasses.vector.name} ${CppSubclasses.vector.name}::min(const ${CppSubclasses.vector.name}& other) const noexcept {
           |    return ${CppSubclasses.vector.name}{
           |        .x = std::min(x, other.x),
           |        .y = std::min(y, other.y),
           |        .z = std::min(z, other.z),
           |    };
           |}
           |
           |[[nodiscard]] inline ${CppSubclasses.vector.name} ${CppSubclasses.vector.name}::max(const ${CppSubclasses.vector.name}& other) const noexcept {
           |    return ${CppSubclasses.vector.name}{
           |        .x = std::max(x, other.x),
           |        .y = std::max(y, other.y),
           |        .z = std::max(z, other.z),
           |    };
           |}
           |
           |[[nodiscard]] inline ${CppSubclasses.vector.name} ${CppSubclasses.vector.name}::clamp(const ${CppSubclasses.vector.name}& minV, const ${CppSubclasses.vector.name}& maxV) const noexcept {
           |    return ${CppSubclasses.vector.name}{
           |        .x = std::clamp(x, minV.x, maxV.x),
           |        .y = std::clamp(y, minV.y, maxV.y),
           |        .z = std::clamp(z, minV.z, maxV.z),
           |    };
           |}
           |""".stripMargin)
    }

    Seq(FileContent(codeGen.directory.resolve("opsVector.h"), code.toString))
  }
}
