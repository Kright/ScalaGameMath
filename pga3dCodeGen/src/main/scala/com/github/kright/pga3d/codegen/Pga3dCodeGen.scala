package com.github.kright.pga3d.codegen

import com.github.kright.pga3d.codegen.MultivectorSubClass.pgaClasses

import java.io.File


@main
def main(): Unit = {
  val packageDir = new File("pga3d/shared/src/main/scala/com/github/kright/pga3d")
  assert(packageDir.exists())

  for (cls <- pgaClasses if cls.shouldBeGenerated) {
    cls.writeToFile(packageDir)
  }

  MatrixCodeGen().writeToFile(packageDir)
}