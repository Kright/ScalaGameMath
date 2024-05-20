package com.github.kright.pga3d.codegen

import com.github.kright.pga3d.codegen.MultivectorSubClass.{*, given}

import java.io.File
import java.nio.charset.StandardCharsets
import java.nio.file.{Files, StandardOpenOption}


@main
def main(): Unit = {
  for (cls <- pgaClasses if cls.shouldBeGenerated) {
    val code = cls.generateCode(unaryOperations, binaryOperations)
    val dir = new File("pga3d/src/main/scala/com/github/kright/pga3d")

    assert(dir.exists())

    val clsFile = File(dir, s"${cls.name}.scala")
    Files.write(clsFile.toPath, code.getBytes(StandardCharsets.UTF_8),
      StandardOpenOption.CREATE, StandardOpenOption.WRITE, StandardOpenOption.TRUNCATE_EXISTING)

    println(s"class generated = ${clsFile}, linesCount = ${code.lines().count()}")
  }
}