package com.github.kright.pga3d.codegen.cpp.struct

import com.github.kright.pga3d.codegen.cpp.{CppCodeGen, CppSubclass, CppSubclasses}

class StructStaticConstructorGenerator extends StructCodeGenerator {

  override def structCode(cls: CppSubclass): String =
    val code = new CppCodeGen()

    if (Set(CppSubclasses.quaternion, CppSubclasses.motor).contains(cls)) {
      code(s"[[nodiscard]] static constexpr ${cls.name} id() noexcept { return {.s = 1.0}; }")
    }

    if (CppSubclasses.projectivePoint == cls) {
      code(s"[[nodiscard]] static constexpr ${cls.name} blade3(double wxy = 0.0, double wxz = 0.0, double wyz = 0.0, double xyz = 0.0) noexcept { return {.x = -wyz, .y = wxz, .z = -wxy, .w = xyz}; }")
    }

    if (Set(CppSubclasses.point, CppSubclasses.vector).contains(cls)) {
      code(s"[[nodiscard]] static constexpr ${cls.name} blade3(double wxy = 0.0, double wxz = 0.0, double wyz = 0.0) noexcept { return {.x = -wyz, .y = wxz, .z = -wxy}; }")
    }

    code.toString()
}
