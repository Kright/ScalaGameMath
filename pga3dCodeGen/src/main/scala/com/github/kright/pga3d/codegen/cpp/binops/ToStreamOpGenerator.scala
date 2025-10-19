package com.github.kright.pga3d.codegen.cpp.binops

import com.github.kright.pga3d.codegen.common.FileWriterTask
import com.github.kright.pga3d.codegen.cpp.{CppCodeGen, CppSubclass, CppSubclasses, Pga3dCodeGenCpp}

class ToStreamOpGenerator extends BinOpCodeGen {

  override def generateBinopCode(codeGen: Pga3dCodeGenCpp): FileWriterTask = {
    val code = CppCodeGen()

    code.pragmaOnce()
    code("#include <ostream>")
    code("")
    code.namespace(codeGen.namespace) {
      for (cls <- CppSubclasses.all if cls.shouldBeGenerated) {
        code(s"constexpr std::ostream &operator<<(std::ostream &os, const ${cls.name} &v) {")
        code.block {
          if (cls.variableFields.nonEmpty) {
            code(s"return os << \"${cls.name}{\" << ${cls.variableFields.map(f => s"\".${f.name} = \" << v.${f.name}").mkString(" << \", \"")} << \"}\";")
          } else {
            code(s"return os << \"${cls.name}{}\";")
          }
        }
        code.apply("}")
      }
    }

    FileWriterTask(codeGen.directory.resolve("ops_str.h"), code.toString)
  }

  override def structCode(cls: CppSubclass): String = ""
}
