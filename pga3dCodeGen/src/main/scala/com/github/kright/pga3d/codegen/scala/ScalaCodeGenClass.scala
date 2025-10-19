package com.github.kright.pga3d.codegen.scala

import com.github.kright.pga3d.codegen.common.FileWriter

import java.nio.charset.StandardCharsets
import java.nio.file.{Files, Path, StandardOpenOption}

trait ScalaCodeGenClass:
  def name: String

  def isObject: Boolean

  def typeName: String =
    if (isObject) s"${name}.type"
    else name

  def typeNameWithoutPrefix: String =
    if (typeName.startsWith("Pga3d")) typeName.drop(5).capitalize
    else typeName.capitalize

  def generateImports(): String = ""

  def generateCode(): String

  def writeToFile(packageDir: Path): Unit =
    require(Files.exists(packageDir))

    val clsPath = packageDir.resolve(s"${name}.scala")

    val code =
      s"""package com.github.kright.pga3d
         |
         |${generateImports()}
         |/** this code is generated, see com.github.kright.pga3d.codegen.CodeGenClass */
         |${generateCode()}""".stripMargin

    val writeNew = FileWriter.writeToFile(clsPath, code)
    if (!writeNew) {
      println(s"class is up-to-date = ${clsPath}, linesCount = ${code.lines().count()}")
    }

    println(s"class generated = ${clsPath}, linesCount = ${code.lines().count()}")
