package com.github.kright.pga3d.codegen.cpp.binops

import com.github.kright.ga.MultiVector
import com.github.kright.pga3d.codegen.common.FileContent
import com.github.kright.pga3d.codegen.cpp.{CppCodeGen, CppCodeGenerator, CppSubclass, CppSubclasses, Pga3dCodeGenCpp, StructBodyPart}
import com.github.kright.symbolic.Sym

/**
 * Generalized binary-method code generator for PGA3D C++ bindings.
 * Reuses the same emission pattern for methods like geometric and dot.
 *
 * Simplifications:
 *  - Skip scalar and zero classes entirely
 *  - Multivector interacts only with Multivector
 *  - No X op Multivector for X != Multivector
 *  - Skip emission when result resolves to Zero class
 */
class BinaryMethodCodeGen(val methodName: String,
                          val fileName: String,
                          val op: (MultiVector[Sym], MultiVector[Sym]) => MultiVector[Sym]) extends CppCodeGenerator:

  override def generateFiles(codeGen: Pga3dCodeGenCpp): Seq[FileContent] =
    val code = CppCodeGen()

    code.myHeader(Seq(s"#include \"${codeGen.Headers.types}\""), getClass.getName)

    code.namespace(codeGen.namespace) {
      for (left <- CppSubclasses.all if left.shouldBeGenerated) {
        for (right <- CppSubclasses.all if right.shouldBeGenerated) {
          val skipRight = right == CppSubclasses.scalar || right == CppSubclasses.zeroCls
          val skipLeft = left == CppSubclasses.scalar || left == CppSubclasses.zeroCls
          if !skipLeft && !skipRight then
            val pairAllowed =
              if left == CppSubclasses.multivector then right == CppSubclasses.multivector
              else right != CppSubclasses.multivector

            if pairAllowed then
              val result = op(left.self, right.makeSymbolic("b"))
              val target = CppSubclasses.findMatchingClass(result)
              if target != CppSubclasses.zeroCls then
                code(s"constexpr ${target.name} ${left.name}::${methodName}(const ${right.name}& b) const noexcept { return ${target.makeBracesInit(result)}; }")
        }
        code("")
      }
    }

    Seq(FileContent(codeGen.directory.resolve(fileName), code.toString))

  override def generateStructBody(cls: CppSubclass): Seq[StructBodyPart] =
    val decls =
      for
        right <- CppSubclasses.all
        if right.shouldBeGenerated
        if right != CppSubclasses.scalar && right != CppSubclasses.zeroCls
        if (if cls == CppSubclasses.multivector then right == CppSubclasses.multivector else right != CppSubclasses.multivector)
      yield
        val result = op(cls.self, right.makeSymbolic("b"))
        val target = CppSubclasses.findMatchingClass(result)
        if target == CppSubclasses.zeroCls then ""
        else s"[[nodiscard]] constexpr ${target.name} ${methodName}(const ${right.name}& b) const noexcept;"

    val result = decls.filter(_.nonEmpty).mkString("\n")

    structBodyPart(result)
