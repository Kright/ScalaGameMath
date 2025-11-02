package com.github.kright.pga3d.codegen.cpp.binops

import com.github.kright.pga3d.codegen.common.FileContent
import com.github.kright.pga3d.codegen.cpp.{CppCodeGen, CppSubclass, CppSubclasses, Pga3dCodeGenCpp}

class BivectorOpsGenerator extends BinOpCodeGen {

  override def generateBinopCode(codeGen: Pga3dCodeGenCpp): FileContent = {
    val code = new CppCodeGen()

    code.myHeader(
      Seq(
        "#include <cmath>",
        s"#include \"${codeGen.Headers.types}\"",
        s"#include \"opsArithmetic.h\"",
        s"#include \"opsNorm.h\""
      ),
      getClass.getName
    )

    code.namespace(codeGen.namespace) {
      val bivector = CppSubclasses.bivector
      val bivectorWeight = CppSubclasses.bivectorWeight

      code(
        s"""
           |inline std::pair<${bivector.name}, ${bivectorWeight.name}> ${bivector.name}::split() const noexcept {
           |    const double div = bulkNormSquare();
           |    if (div < 1e-100) {
           |        return {
           |            ${bivector.name}{ .wx = 0.0, .wy = 0.0, .wz = 0.0, .xy = xy, .xz = xz, .yz = yz },
           |            ${bivectorWeight.name}{ .wx = wx, .wy = wy, .wz = wz }
           |        };
           |    }
           |
           |    const double pseudoScalar = (wy * xz - wx * yz - wz * xy) / div;
           |    const ${bivectorWeight.name} shiftAlongLine{
           |        .wx = -pseudoScalar * yz,
           |        .wy = pseudoScalar * xz,
           |        .wz = -pseudoScalar * xy
           |    };
           |
           |    const ${bivector.name} line = (*this) - shiftAlongLine;
           |    return {line, shiftAlongLine};
           |}
           |
           |inline ${CppSubclasses.motor.name} ${bivector.name}::exp() const noexcept {
           |    const double len = bulkNorm();
           |    const double cos = std::cos(len);
           |
           |    const double sinDivLen = (len > 1e-5) ?
           |        (std::sin(len) / len) :
           |        (1.0 - (len * len) / 6.0);
           |
           |    const double sinMinusCosDivLen2 = (len > 1e-5) ?
           |        (sinDivLen - cos) / (len * len) :
           |        (1.0 / 3.0) * (1.0 + 0.8 * len * len);
           |
           |    return ${CppSubclasses.motor.name} {
           |      .s = cos,
           |      .wx = (sinDivLen * wx + sinMinusCosDivLen2 * yz * (wy * xz - wx * yz - wz * xy)),
           |      .wy = (sinDivLen * wy + sinMinusCosDivLen2 * xz * (wx * yz + wz * xy - wy * xz)),
           |      .wz = (sinDivLen * wz + sinMinusCosDivLen2 * xy * (wy * xz - wx * yz - wz * xy)),
           |      .xy = sinDivLen * xy,
           |      .xz = sinDivLen * xz,
           |      .yz = sinDivLen * yz,
           |      .i = sinDivLen * (wx * yz + wz * xy - wy * xz),
           |    };
           |}
           |""".stripMargin
      )
    }

    FileContent(codeGen.directory.resolve("opsBivector.h"), code.toString)
  }

  override def structCode(cls: CppSubclass): String = {
    if (cls == CppSubclasses.bivector) {
      s"""[[nodiscard]] inline std::pair<${cls.name}, ${CppSubclasses.bivectorWeight.name}> split() const noexcept;
         |
         |[[nodiscard]] inline ${CppSubclasses.motor.name} exp() const noexcept;""".stripMargin
    } else ""
  }

  override def includes(cls: CppSubclass): Seq[String] = {
    if (cls == CppSubclasses.bivector) {
      Seq("<utility>")
    } else {
      Seq()
    }
  }
}
