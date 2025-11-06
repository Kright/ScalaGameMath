package com.github.kright.pga3d.codegen

import com.github.kright.pga3d.codegen.scala.runScalaCodeGen
import com.github.kright.pga3d.codegen.cpp.runCppCodeGen

@main
def runCodeGen(): Unit = {
  runScalaCodeGen()
  runCppCodeGen()
}
