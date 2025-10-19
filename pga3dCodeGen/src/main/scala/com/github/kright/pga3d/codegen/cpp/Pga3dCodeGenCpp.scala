package com.github.kright.pga3d.codegen.cpp

import java.nio.file.{Files, Path}

@main
def main(): Unit = {
  val cppDir = Path.of("cpp")
  assert(Files.exists(cppDir))
}
