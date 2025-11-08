package com.github.kright.pga3d.codegen.cpp.ops

import com.github.kright.pga3d.codegen.common.FileContent
import com.github.kright.pga3d.codegen.cpp.{CppCodeBuilder, CppCodeGenerator, CppSubclass, CppSubclasses, Pga3dCodeGenCpp}

class ToStreamOpGenerator extends CppCodeGenerator {

  override def generateFiles(codeGen: Pga3dCodeGenCpp): Seq[FileContent] = {
    val code = CppCodeBuilder()

    code.myHeader(Seq("#include <ostream>"), getClass.getName)
    
    code.namespace(codeGen.namespace) {
      for (cls <- CppSubclasses.all if cls.shouldBeGenerated) {
        code(s"inline std::ostream &operator<<(std::ostream &os, const ${cls.name} &v) {")
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

    Seq(FileContent(codeGen.directory.resolve("opsStr.h"), code.toString))
  }
}
