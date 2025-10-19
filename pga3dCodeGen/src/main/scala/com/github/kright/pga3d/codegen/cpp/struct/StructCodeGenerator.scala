package com.github.kright.pga3d.codegen.cpp.struct

import com.github.kright.pga3d.codegen.cpp.CppSubclass

trait StructCodeGenerator:
  def structCode(cls: CppSubclass): String
