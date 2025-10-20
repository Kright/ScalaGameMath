package com.github.kright.pga3d.codegen.cpp.struct

import com.github.kright.pga3d.codegen.cpp.CppSubclass

trait StructCodeGenerator:
  def includes(cls: CppSubclass): Seq[String] = Seq()
  
  def structCode(cls: CppSubclass): String
