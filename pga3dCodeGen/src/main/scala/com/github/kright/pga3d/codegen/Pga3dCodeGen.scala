package com.github.kright.pga3d.codegen

import com.github.kright.pga3d.codegen.MultivectorSubClass.pgaClasses

import java.nio.file.{Files, Path}


@main
def main(): Unit = {
  val packageDir = Path.of("pga3d/shared/src/main/scala/com/github/kright/pga3d")
  assert(Files.exists(packageDir))

  for (cls <- pgaClasses if cls.shouldBeGenerated) {
    cls.writeToFile(packageDir)
  }

  MatrixCodeGen().writeToFile(packageDir)
}