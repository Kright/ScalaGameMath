package com.github.kright.pga3d.codegen.cpp.binops

import com.github.kright.pga3d.codegen.common.FileWriterTask
import com.github.kright.pga3d.codegen.cpp.{CppCodeGen, CppSubclass, CppSubclasses, Pga3dCodeGenCpp}

class MotorOpsGenerator extends BinOpCodeGen {

  // No declarations yet. Ready to add methods in the future.
  override def structCode(cls: CppSubclass): String = {
    if (cls == CppSubclasses.motor) {
      s"[[nodiscard]] inline ${CppSubclasses.bivector.name} log() const noexcept;"
    } else ""
  }

  override def generateBinopCode(codeGen: Pga3dCodeGenCpp): FileWriterTask = {
    val code = new CppCodeGen()

    code.pragmaOnce()
    // Keep includes minimal; types aggregation is enough for method declarations/definitions
    code.apply(s"#include <cmath>")
    code.apply(s"#include \"${codeGen.Headers.types}\"")
    code.apply(s"#include \"ops_arithmetic.h\"")
    code.apply("")
    code.generatedBy(getClass.getName)

    code.namespace(codeGen.namespace) {
      // Intentionally left empty. This header is reserved for future Motor methods implementations.

      code(
        s"""
          |[[nodiscard]] inline ${CppSubclasses.bivector.name} ${CppSubclasses.motor.name}::log() const noexcept {
          |    const double scalar = s;
          |    if (s < 0.0) return (-(*this)).log();
          |
          |    const double lenXYZ = std::sqrt(xy * xy + xz * xz + yz * yz);
          |    const double angle = std::atan2(lenXYZ, scalar);
          |
          |    // 1 / sin^2
          |    const double a = 1.0 / (1.0 - scalar * scalar);
          |
          |    // angle / sin(angle)
          |    const double b = (std::abs(angle) > 1e-5)
          |        ? (angle * std::sqrt(a))
          |        : (1.0 + angle * angle / 6.0);
          |
          |    const double c = (std::abs(angle) > 1e-5)
          |        ? (a * i * (1.0 - scalar * b))
          |        : ((1.0 + angle * angle / 2.0) * i / 3.0);
          |
          |    return ${CppSubclasses.bivector.name} {
          |        .wx = (b * wx + c * yz),
          |        .wy = (b * wy - c * xz),
          |        .wz = (b * wz + c * xy),
          |        .xy = b * xy,
          |        .xz = b * xz,
          |        .yz = b * yz,
          |    };
          |}
          |""".stripMargin)

    }

    FileWriterTask(codeGen.directory.resolve("ops_Motor.h"), code.toString)
  }
}
