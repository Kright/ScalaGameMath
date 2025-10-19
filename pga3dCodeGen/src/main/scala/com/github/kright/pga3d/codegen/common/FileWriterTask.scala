package com.github.kright.pga3d.codegen.common

import java.nio.file.Path

case class FileWriterTask(path: Path, content: String):
  def write(): Unit =
    FileWriter.writeToFile(path, content)
