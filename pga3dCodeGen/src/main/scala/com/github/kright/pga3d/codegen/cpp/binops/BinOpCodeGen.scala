package com.github.kright.pga3d.codegen.cpp.binops

import com.github.kright.pga3d.codegen.common.FileContent
import com.github.kright.pga3d.codegen.cpp.Pga3dCodeGenCpp
import com.github.kright.pga3d.codegen.cpp.struct.StructCodeGenerator

trait BinOpCodeGen extends StructCodeGenerator:

  def generateBinopCode(codeGen: Pga3dCodeGenCpp): FileContent

