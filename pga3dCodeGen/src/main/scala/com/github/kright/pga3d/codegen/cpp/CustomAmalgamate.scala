package com.github.kright.pga3d.codegen.cpp

import com.github.kright.pga3d.codegen.common.FileContent

import java.nio.file.{Files, Path}
import scala.collection.mutable
import scala.jdk.CollectionConverters.*

@main
def mergeFiles(): Unit = {
  CustomAmalgamate.fuse()
}

private class CustomAmalgamate(val files: Map[String, FileContent]) {
  val result = new StringBuilder()
  val includedFiles = new mutable.HashSet[String]()

  def getStdIncludes(code: Seq[String]): Seq[String] = {
    code
      .flatMap(_.strip().split("\n"))
      .filter(_.startsWith("#include <"))
      .distinct
  }

  def fuse(text: String): String = {
    val includes = getStdIncludes(Seq(text) ++ files.values.map(_.content))

    result.append("#pragma once\n\n")
    for (include <- includes) {
      result.append(include).append("\n")
    }

    fuse(text, None, 0)

    {
      val missedFiles = files.keySet -- includedFiles
      require(missedFiles.isEmpty, missedFiles.mkString(", "))
    }

    result.toString()
  }

  private def fuse(text: String, fileName: Option[String], level: Int): Unit = {
    println(s"${"  " * level}${fileName.getOrElse("root")}")

    val lines = text.strip().split("\n")
    val lastIncludeLine: Int = lines.zipWithIndex.filter(_._1.startsWith("#include")).map(_._2).maxOption.getOrElse(-1)

    var printedName = false

    for ((line, i) <- lines.zipWithIndex) {
      if (line.startsWith("#")) {
        if (line.startsWith("#include")) {
          if (line.startsWith("#include <")) {
            // skip, all such includes gathered at the file beginning
          } else {
            require(line.startsWith("#include \""))
            val includePath = line.strip().stripPrefix("#include \"").stripSuffix("\"")
            val fileName = Path.of(includePath).getFileName.toString
            if (!includedFiles.contains(fileName)) {
              includedFiles.add(fileName)
              fuse(files(fileName).content, Option(fileName), level + 1)
            }
          }
        } else if (line.startsWith("#pragma once")) {
          require(line == "#pragma once") // skip
        } else {
          require(false, "unknown directive: " + line)
        }
      } else {
        if (i >= lastIncludeLine + 1 && !printedName) {
          fileName.foreach { name =>
            result.append(s"\n// ${name}\n\n")
          }
          printedName = true
        }

        result.append(line).append("\n")
      }
    }
  }
}

private object CustomAmalgamate {
  def fuse(): Unit = {
    val initial =
      """
        |#include "pga3d.h"
        |#include "pga3dphysics.h"""".stripMargin
    val amalgamate = new CustomAmalgamate(getFiles())
    amalgamate.fuse(initial)
    val code = amalgamate.result.toString
    FileContent(Path.of("cpp/fused/pga3dphysics.h"), code).write()
  }

  private def getFiles(): Map[String, FileContent] = {
    val dirs = Seq(
      Path.of("cpp/pga3d"),
      Path.of("cpp/pga3dphysics"),
    )
    val files = dirs.flatMap(dir => Files.list(dir).iterator().asScala)

    require(files.map(_.getFileName.toString).toSet.size == files.size)

    files.map(FileContent.load).map(f => f.path.getFileName.toString -> f).toMap
  }
}
