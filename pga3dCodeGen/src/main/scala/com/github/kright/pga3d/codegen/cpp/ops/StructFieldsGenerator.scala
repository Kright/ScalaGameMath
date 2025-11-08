package com.github.kright.pga3d.codegen.cpp.ops

import com.github.kright.pga3d.codegen.cpp.Pga3dProvider.pga3
import com.github.kright.pga3d.codegen.cpp.*

class StructFieldsGenerator extends CppCodeGenerator:
  override def generateStructBody(cls: CppSubclass): Seq[StructBodyPart] =
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

    if (cls.variableFields.nonEmpty) {
      code("")
      code(s"[[nodiscard]] constexpr std::array<double, componentsCount> toArray() const noexcept { return { ${cls.variableFields.map(_.name).mkString(", ")} }; }")
      code(s"[[nodiscard]] static constexpr ${cls.name} from(const std::span<double, componentsCount>& values) noexcept { return { ${cls.variableFields.zipWithIndex.map((f, i) => s".${f.name} = values[$i]").mkString(", ")} }; }")
    }

    val includes =
      if (cls.variableFields.nonEmpty) Seq("<array>", "<span>")
      else Seq()

    structBodyPart(
      code.toString,
      includes,
    )
