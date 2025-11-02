package com.github.kright.pga3d.codegen.cpp.binops

import com.github.kright.pga3d.codegen.common.FileContent
import com.github.kright.pga3d.codegen.cpp.{CppCodeGen, CppSubclass, CppSubclasses, Pga3dCodeGenCpp}

class ProjectionOpsGenerator extends BinOpCodeGen:
  private val pointClasses = Set(
    CppSubclasses.projectivePoint,
    CppSubclasses.point,
    CppSubclasses.pointCenter,
  )

  override def structCode(cls: CppSubclass): String = {
    val code = CppCodeGen()

    if (cls == CppSubclasses.bivector) {
      val line = cls.self

      for (planeClass <- Seq(CppSubclasses.plane, CppSubclasses.planeIdeal)) {
        code(s"[[nodiscard]] constexpr ${cls.name} projectOntoPlane(const ${planeClass.name}& plane) const noexcept;")
      }
    }

    if (pointClasses.contains(cls)) {
      for (planeClass <- Seq(CppSubclasses.plane, CppSubclasses.planeIdeal)) {
        code(s"[[nodiscard]] constexpr ${CppSubclasses.projectivePoint.name} projectOntoPlane(const ${planeClass.name}& plane) const noexcept;")
      }

      code(s"[[nodiscard]] constexpr ${CppSubclasses.projectivePoint.name} projectOntoLine(const ${CppSubclasses.bivector.name}& line) const noexcept;")
    }

    code.toString
  }

  override def generateBinopCode(codeGen: Pga3dCodeGenCpp): FileContent = {
    val code = CppCodeGen()

    code.pragmaOnce()
    code(s"#include \"${codeGen.Headers.types}\"")
    code(s"#include \"opsGeometric.h\"")
    code(s"#include \"opsDot.h\"")
    code("")
    code.generatedBy(getClass.getName)

    code.namespace(codeGen.namespace) {
      for (planeClass <- Seq(CppSubclasses.plane, CppSubclasses.planeIdeal)) {
        code(s"[[nodiscard]] constexpr ${CppSubclasses.bivector.name} ${CppSubclasses.bivector.name}::projectOntoPlane(const ${planeClass.name}& plane) const noexcept { return -plane.dot(*this).geometric(plane).toBivectorUnsafe(); }")
      }

      for(pointClass <- pointClasses) {
        for (planeClass <- Seq(CppSubclasses.plane, CppSubclasses.planeIdeal)) {
          code(s"[[nodiscard]] constexpr ${CppSubclasses.projectivePoint.name} ${pointClass.name}::projectOntoPlane(const ${planeClass.name}& plane) const noexcept { return plane.dot(*this).geometric(plane).toProjectivePointUnsafe(); };")
        }

        code(s"[[nodiscard]] constexpr ${CppSubclasses.projectivePoint.name} ${pointClass.name}::projectOntoLine(const ${CppSubclasses.bivector.name}& line) const noexcept { return -line.dot(*this).geometric(line).toProjectivePointUnsafe(); };")
      }
    }

    FileContent(codeGen.directory.resolve("opsProject.h"), code.toString)
  }
