package com.github.kright.pga3d.codegen.cpp.binops

import com.github.kright.pga3d.codegen.common.FileWriterTask
import com.github.kright.pga3d.codegen.cpp.{CppCodeGen, CppSubclass, CppSubclasses, Pga3dCodeGenCpp}

class MotorOpsGenerator extends BinOpCodeGen {

  override def includes(cls: CppSubclass): Seq[String] = {
    if (cls == CppSubclasses.bivector) {
      Seq("<utility>")
    } else {
      Seq()
    }
  }

  // No declarations yet. Ready to add methods in the future.
  override def structCode(cls: CppSubclass): String = {
    if (cls != CppSubclasses.motor) return ""

    val code = new CppCodeGen()
    code(s"[[nodiscard]] static constexpr ${CppSubclasses.motor.name} id() noexcept { return { .s = 1.0 }; };")
    code("")
    code(s"[[nodiscard]] static constexpr ${CppSubclasses.motor.name} addVector(const ${CppSubclasses.vector.name}& v) noexcept;")
    code("")
    code(s"[[nodiscard]] inline ${CppSubclasses.bivector.name} log() const noexcept;")
    code("")
    code(s"[[nodiscard]] inline ${CppSubclasses.vector.name} toVector() const noexcept;")
    code("")
    code(s"[[nodiscard]] constexpr std::pair<${CppSubclasses.quaternion.name}, ${CppSubclasses.translator.name}> toQuaternionAndTranslator() const noexcept;")
    code(s"[[nodiscard]] constexpr std::pair<${CppSubclasses.translator.name}, ${CppSubclasses.quaternion.name}> toTranslatorAndQuaternion() const noexcept;")
    code("")
    code(s"[[nodiscard]] inline ${CppSubclasses.motor.name} renormalized() const noexcept;")
    code("")
    QuaternionAndMotorAxes.makeDeclaration(code, cls)

    code.toString
  }

  override def generateBinopCode(codeGen: Pga3dCodeGenCpp): FileWriterTask = {
    val code = new CppCodeGen()

    code.pragmaOnce()
    // Keep includes minimal; types aggregation is enough for method declarations/definitions
    code.apply(s"#include <cmath>")
    code.apply(s"#include \"${codeGen.Headers.types}\"")
    code.apply(s"#include \"opsArithmetic.h\"")
    code.apply("")
    code.generatedBy(getClass.getName)

    code.namespace(codeGen.namespace) {
      // Intentionally left empty. This header is reserved for future Motor methods implementations.
      code(
        s"""
           |[[nodiscard]] constexpr ${CppSubclasses.motor.name} ${CppSubclasses.motor.name}::addVector(const ${CppSubclasses.vector.name}& v) noexcept { return {.s = 1.0, .wx = v.x, .wy = v.y, .wz = v.z}; }""".stripMargin)

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

      code(
        s"""
           |[[nodiscard]] constexpr std::pair<${CppSubclasses.quaternion.name}, ${CppSubclasses.translator.name}> ${CppSubclasses.motor.name}::toQuaternionAndTranslator() const noexcept {
           |    const Quaternion q = toQuaternionUnsafe();
           |    const Motor t = q.reverse().geometric(*this);
           |    return { q, t.toTranslatorUnsafe() };
           |}
           |""".stripMargin)

      code(
        s"""
           |[[nodiscard]] constexpr std::pair<${CppSubclasses.translator.name}, ${CppSubclasses.quaternion.name}> ${CppSubclasses.motor.name}::toTranslatorAndQuaternion() const noexcept {
           |    const Quaternion q = toQuaternionUnsafe();
           |    const Motor t = geometric(q.reverse());
           |    return { t.toTranslatorUnsafe(), q };
           |}
           |""".stripMargin)

      code(
        s"""
           |/**
           | * see [[https://arxiv.org/abs/2206.07496]], page 14
           | * and [[https://https://bivector.net/PGAdyn.pdf.net/PGAdyn.pdf]], page 42
           | */
           |[[nodiscard]] inline ${CppSubclasses.motor.name} ${CppSubclasses.motor.name}::renormalized() const noexcept {
           |    const double a2 = 1.0 / (s * s + xy * xy + xz * xz + yz * yz);
           |    const double a = std::sqrt(a2);
           |    const double b = (s * i - wx * yz + wy * xz - wz * xy) * a * a2;
           |    return ${CppSubclasses.motor.name} {
           |        .s = a * s,
           |        .wx = a * wx + b * yz,
           |        .wy = a * wy - b * xz,
           |        .wz = a * wz + b * xy,
           |        .xy = a * xy,
           |        .xz = a * xz,
           |        .yz = a * yz,
           |        .i = a * i - b * s,
           |    };
           |}
           |""".stripMargin)

      code("")
      QuaternionAndMotorAxes.makeForMotor(code)
    }

    FileWriterTask(codeGen.directory.resolve("opsMotor.h"), code.toString)
  }
}
