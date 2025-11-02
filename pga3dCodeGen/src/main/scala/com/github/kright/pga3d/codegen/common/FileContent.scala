package com.github.kright.pga3d.codegen.common

import java.nio.file.{Files, Path}

case class FileContent(path: Path, content: String):
  def write(): Unit =
    FileWriter.writeToFile(path, content, createDirs = true)


object FileContent:
  def load(path: Path): FileContent =
    FileContent(path, Files.readString(path))