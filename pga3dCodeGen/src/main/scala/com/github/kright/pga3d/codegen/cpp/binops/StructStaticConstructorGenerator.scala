package com.github.kright.pga3d.codegen.cpp.binops

import com.github.kright.pga3d.codegen.common.FileWriterTask
import com.github.kright.pga3d.codegen.cpp.struct.StructCodeGenerator
import com.github.kright.pga3d.codegen.cpp.{CppCodeGen, CppSubclass, CppSubclasses, Pga3dCodeGenCpp}

class StructStaticConstructorGenerator extends StructCodeGenerator {

  override def structCode(cls: CppSubclass): String =
    val code = new CppCodeGen()

    if (Set(CppSubclasses.quaternion).contains(cls)) {
      code(s"[[nodiscard]] static constexpr ${cls.name} id() noexcept { return {.s = 1.0}; }")
    }

    if (CppSubclasses.projectivePoint == cls) {
      code(s"[[nodiscard]] static constexpr ${cls.name} blade3(double wxy = 0.0, double wxz = 0.0, double wyz = 0.0, double xyz = 0.0) noexcept { return {.x = -wyz, .y = wxz, .z = -wxy, .w = xyz}; }")
      code(s"[[nodiscard]] static constexpr ${cls.name} interpolate(const ${cls.name}& a, const ${cls.name}& b, double t) noexcept { return {.x = a.x * (1.0 - t) + b.x * t, .y = a.y * (1.0 - t) + b.y * t, .z = a.z * (1.0 - t) + b.z * t, .w = a.w * (1.0 - t) + b.w * t}; }")
      code(s"[[nodiscard]] static constexpr ${cls.name} mid(const ${cls.name}& a, const ${cls.name}& b) noexcept { return {.x = 0.5 * (a.x + b.x), .y = 0.5 * (a.y + b.y), .z = 0.5 * (a.z + b.z), .w = 0.5 * (a.w + b.w)}; }")
      code(s"[[nodiscard]] static constexpr ${cls.name} mid(const ${cls.name}& a, const ${cls.name}& b, const ${cls.name}& c) noexcept { return {.x = (1.0 / 3.0) * (a.x + b.x + c.x), .y = (1.0 / 3.0) * (a.y + b.y + c.y), .z = (1.0 / 3.0) * (a.z + b.z + c.z), .w = (1.0 / 3.0) * (a.w + b.w + c.w)}; }")
    }

    if (Set(CppSubclasses.point, CppSubclasses.vector).contains(cls)) {
      code(s"[[nodiscard]] static constexpr ${cls.name} blade3(double wxy = 0.0, double wxz = 0.0, double wyz = 0.0) noexcept { return {.x = -wyz, .y = wxz, .z = -wxy}; }")
      code(s"[[nodiscard]] static constexpr ${cls.name} interpolate(const ${cls.name}& a, const ${cls.name}& b, double t) noexcept { return {.x = a.x * (1.0 - t) + b.x * t, .y = a.y * (1.0 - t) + b.y * t, .z = a.z * (1.0 - t) + b.z * t}; }")
      code(s"[[nodiscard]] static constexpr ${cls.name} mid(const ${cls.name}& a, const ${cls.name}& b) noexcept { return {.x = 0.5 * (a.x + b.x), .y = 0.5 * (a.y + b.y), .z = 0.5 * (a.z + b.z)}; }")
      code(s"[[nodiscard]] static constexpr ${cls.name} mid(const ${cls.name}& a, const ${cls.name}& b, const ${cls.name}& c) noexcept { return {.x = (1.0 / 3.0) * (a.x + b.x + c.x), .y = (1.0 / 3.0) * (a.y + b.y + c.y), .z = (1.0 / 3.0) * (a.z + b.z + c.z)}; }")
    }

    code.toString()
}
