package com.github.kright.pga3d.codegen.cpp.struct

import com.github.kright.pga3d.codegen.cpp.Pga3dProvider.pga3
import com.github.kright.pga3d.codegen.cpp.{CppCodeGen, CppSubclass, CppSubclasses}

class StructFieldsGenerator extends StructCodeGenerator:
  override def structCode(cls: CppSubclass): String =
    val code = new CppCodeGen()

    cls.variableFields.foreach { field =>
      code(s"double ${field.name} = 0.0;")
    }

    code("")
    code(s"static constexpr int componentsCount = ${cls.variableFields.size};")

    if (cls.constantFields.nonEmpty) {
      code("")
      cls.constantFields.foreach { (field, constValue) =>
        code(s"[[nodiscard]] constexpr double ${field.name}() const noexcept { return ${constValue}; }")
      }
    }

    if (Set(CppSubclasses.vector, CppSubclasses.point, CppSubclasses.projectivePoint, CppSubclasses.pointCenter).contains(cls)) {
      code("")

      cls.self.values.foreach { (b, sym) =>
        val fName = s"${pga3.representation(b)}"

        code(s"[[nodiscard]] constexpr double ${fName}() const noexcept { return ${sym}; }")
      }
    }

    code.toString()
