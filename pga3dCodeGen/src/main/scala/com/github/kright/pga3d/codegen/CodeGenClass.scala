package com.github.kright.pga3d.codegen

import java.io.File
import java.nio.charset.StandardCharsets
import java.nio.file.{Files, StandardOpenOption}

trait CodeGenClass:
  def name: String

  def isObject: Boolean

  def typeName: String =
    if (isObject) s"${name}.type"
    else name

  def generateCode(): String

  def writeToFile(packageDir: File): Unit =
    require(packageDir.exists())

    val clsFile = File(packageDir, s"${name}.scala")

    val code =
      s"""package com.github.kright.pga3d
         |
         |/** this code is generated, see com.github.kright.pga3d.codegen.CodeGenClass */
         |${generateCode()}""".stripMargin

    Files.write(clsFile.toPath, code.getBytes(StandardCharsets.UTF_8),
      StandardOpenOption.CREATE,
      StandardOpenOption.WRITE,
      StandardOpenOption.TRUNCATE_EXISTING,
    )

    println(s"class generated = ${clsFile}, linesCount = ${code.lines().count()}")
