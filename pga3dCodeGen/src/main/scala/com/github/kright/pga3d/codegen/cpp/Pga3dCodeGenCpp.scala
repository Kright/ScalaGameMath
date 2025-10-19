package com.github.kright.pga3d.codegen.cpp

import com.github.kright.pga3d.codegen.common.FileWriterTask
import com.github.kright.pga3d.codegen.cpp.binops.*
import com.github.kright.pga3d.codegen.cpp.struct.*

import java.nio.file.{Files, Path}


class Pga3dCodeGenCpp(val directory: Path,
                      val namespace: String) {
  assert(Files.exists(directory))

  object Headers {
    val typesForward = "types_forward.h"
    val types = "types.h"
    val pga3d = "pga3d.h"
  }

  private val structCodeGenerators = Seq(
    new StructFieldsGenerator,
    new StructStaticConstructorGenerator,
  )

  private val binopCodeGenerators = Seq(
    new DualOpGenerator,
    new WeightOpGenerator,
    new BulkOpGenerator,
    new ConversionOpGenerator,
    new ArithmeticsGenerator,
    new ToStreamOpGenerator,
  )

  def generateAll(): Unit = {
    generateStructForwardDeclarations().write()
    generateStructHeadersAggregation().write()

    for (cls <- CppSubclasses.all if cls.shouldBeGenerated) {
      val code = generateStructHeader(cls)
      Files.writeString(directory.resolve(s"${cls.name}.h"), code)
    }

    val ops = binopCodeGenerators.map(_.generateBinopCode(this))
    ops.foreach(_.write())
    generatePga3d(ops).write()
  }

  private def generateStructForwardDeclarations(): FileWriterTask = {
    val codeGen = new CppCodeGen()

    codeGen("#pragma once")
    codeGen("")
    codeGen.namespace(namespace) {
      for (cls <- CppSubclasses.all if cls.shouldBeGenerated) {
        codeGen(s"struct ${cls.name};")
      }
    }

    FileWriterTask(directory.resolve(Headers.typesForward), codeGen.toString)
  }

  private def generatePga3d(ops: Seq[FileWriterTask]): FileWriterTask = {
    val code = new CppCodeGen()

    code.pragmaOnce()
    code.generatedBy(getClass.getName)
    code("#include \"types.h\"")
    code("")
    ops.foreach{ op =>
      code(s"#include \"${op.path.getFileName}\"")
    }
    code("")

    FileWriterTask(directory.resolve(Headers.pga3d), code.toString)
  }

  private def generateStructHeadersAggregation(): FileWriterTask = {
    val codeGen = new CppCodeGen()

    codeGen("#pragma once")
    codeGen("")

    for (cls <- CppSubclasses.all if cls.shouldBeGenerated) {
      codeGen(s"#include \"${cls.name}.h\"")
    }

    FileWriterTask(directory.resolve(Headers.types), codeGen.toString)
  }

  private def generateStructHeader(cls: CppSubclass): String = {
    val codeGen = new CppCodeGen()

    codeGen(
      """#pragma once
        |
        |#include <type_traits>
        |#include "types_forward.h"
        |
        |// This code is generated, see com.github.kright.pga3d.codegen.cpp.CppCodeGen
        |""".stripMargin)
    codeGen("")

    codeGen.namespace(namespace) {
      codeGen.struct(cls.name) {
        codeGen((structCodeGenerators ++ binopCodeGenerators).map(_.structCode(cls)).filter(_.nonEmpty).mkString("\n\n"))
      }

      codeGen("")
      codeGen(s"static_assert(std::is_trivially_copyable_v<${cls.name}>);")

      if (cls.variableFields.nonEmpty) {
        codeGen(s"static_assert(sizeof(${cls.name}) == 8 * ${cls.variableFields.size}, \"ProjectivePoint must be exactly ${8 * cls.variableFields.size} bytes\");")
      }
    }

    codeGen.toString()
  }
}


@main
def main(): Unit = {
  new Pga3dCodeGenCpp(
    directory = Path.of("cpp/pga3d"),
    namespace = "pga3d",
  ).generateAll()
}
