package com.github.kright.pga3d.codegen.cpp.binops

import com.github.kright.pga3d.codegen.common.FileContent
import com.github.kright.pga3d.codegen.cpp.{CppCodeGen, CppSubclass, CppSubclasses, Pga3dCodeGenCpp}

class ConversionOpGenerator extends BinOpCodeGen:
  override def structCode(cls: CppSubclass): String = {
    val code = CppCodeGen()

    for (target <- CppSubclasses.all if cls != target && target.shouldBeGenerated && target != CppSubclasses.pseudoScalar) {
      if (target.isMatching(cls.self)) {
        code(s"[[nodiscard]] constexpr ${target.name} to${target.name}() const noexcept;")
      } else {
        val simplifiedSelf = cls.self.filter((blade, _) => target.variableFields.exists(_.basisBlade == blade))
        if (simplifiedSelf.values.nonEmpty) {
          code(s"[[nodiscard]] constexpr ${target.name} to${target.name}Unsafe() const noexcept;")
        }
      }
    }

    if (cls == CppSubclasses.projectivePoint) {
      val point = CppSubclasses.point
      code(s"[[nodiscard]] constexpr ${point.name} to${point.name}() const noexcept;")
    }

    code.toString
  }

  override def generateBinopCode(codeGen: Pga3dCodeGenCpp): FileContent = {
    val code = CppCodeGen()

    code.myHeader(Seq(s"#include \"${codeGen.Headers.types}\""), getClass.getName)

    code.namespace(codeGen.namespace) {
      for (cls <- CppSubclasses.all if cls.shouldBeGenerated) {
        for (target <- CppSubclasses.all if cls != target && target.shouldBeGenerated && target != CppSubclasses.pseudoScalar) {
          if (target.isMatching(cls.self)) {
            code(s"constexpr ${target.name} ${cls.name}::to${target.name}() const noexcept { return ${target.makeBracesInit(cls.self)}; }")
          } else {
            val simplifiedSelf = cls.self.filter((blade, _) => target.variableFields.exists(_.basisBlade == blade))
            if (simplifiedSelf.values.nonEmpty) {
              code(s"constexpr ${target.name} ${cls.name}::to${target.name}Unsafe() const noexcept { return ${target.makeBracesInit(simplifiedSelf)}; }")
            }
          }
        }
        code("")

        if (cls == CppSubclasses.projectivePoint) {
          val point = CppSubclasses.point
          code(s"constexpr ${point.name} ${cls.name}::to${point.name}() const noexcept { const double inv = 1.0 / w; return { .x = x * inv, .y = y * inv, .z = z * inv }; }")
        }
      }
    }

    FileContent(codeGen.directory.resolve("opsTo.h"), code.toString)
  }
