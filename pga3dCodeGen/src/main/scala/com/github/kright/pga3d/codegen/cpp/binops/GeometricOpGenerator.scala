package com.github.kright.pga3d.codegen.cpp.binops

import com.github.kright.pga3d.codegen.common.FileWriterTask
import com.github.kright.pga3d.codegen.cpp.{CppCodeGen, CppSubclass, CppSubclasses, Pga3dCodeGenCpp}

class GeometricOpGenerator extends BinOpCodeGen {
  override def generateBinopCode(codeGen: Pga3dCodeGenCpp): FileWriterTask = {
    val code = CppCodeGen()

    code.pragmaOnce()
    code.apply(s"#include \"${codeGen.Headers.types}\"")
    code.apply("")
    code.generatedBy(getClass.getName)

    code.namespace(codeGen.namespace) {
      for (left <- CppSubclasses.all if left.shouldBeGenerated) {
        for (right <- CppSubclasses.all if right.shouldBeGenerated) {
          // Skip scalar or zero classes entirely
          val skipRight = right == CppSubclasses.scalar || right == CppSubclasses.zeroCls
          val skipLeft = left == CppSubclasses.scalar || left == CppSubclasses.zeroCls
          if (!skipLeft && !skipRight) {
            // Simplification rules:
            // - Multivector geometric only with Multivector
            // - No X geometric Multivector for X != Multivector
            val pairAllowed =
              if (left == CppSubclasses.multivector) right == CppSubclasses.multivector
              else right != CppSubclasses.multivector

            if (pairAllowed) {
              val result = left.self.geometric(right.makeSymbolic("b"))
              val target = CppSubclasses.findMatchingClass(result)
              if (target != CppSubclasses.zeroCls) {
                code(s"constexpr ${target.name} ${left.name}::geometric(const ${right.name}& b) const noexcept { return ${target.makeBracesInit(result)}; }")
              }
            }
          }
        }
        code("")
      }
    }

    FileWriterTask(codeGen.directory.resolve("ops_geometric.h"), code.toString)
  }

  override def structCode(cls: CppSubclass): String = {
    val decls =
      for {
        right <- CppSubclasses.all
        if right.shouldBeGenerated
        if right != CppSubclasses.scalar && right != CppSubclasses.zeroCls
        // Simplification rules matching implementation
        if (
          if (cls == CppSubclasses.multivector) right == CppSubclasses.multivector
          else right != CppSubclasses.multivector
        )
      } yield {
        val result = cls.self.geometric(right.makeSymbolic("b"))
        val target = CppSubclasses.findMatchingClass(result)
        if (target == CppSubclasses.zeroCls) ""
        else s"[[nodiscard]] constexpr ${target.name} geometric(const ${right.name}& b) const noexcept;"
      }

    decls.filter(_.nonEmpty).mkString("\n")
  }
}
