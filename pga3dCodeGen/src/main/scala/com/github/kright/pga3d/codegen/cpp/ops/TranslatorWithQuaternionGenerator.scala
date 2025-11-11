package com.github.kright.pga3d.codegen.cpp.ops

import com.github.kright.pga3d.codegen.common.FileContent
import com.github.kright.pga3d.codegen.cpp.ops.TranslatorWithQuaternionGenerator.{quaternionWithTranslator, translatorWithQuaternion}
import com.github.kright.pga3d.codegen.cpp.{CppCodeBuilder, CppCodeGenerator, CppSubclass, CppSubclasses, Pga3dCodeGenCpp, StructBodyPart}

class TranslatorWithQuaternionGenerator extends CppCodeGenerator {
  override def generateFiles(codeGen: Pga3dCodeGenCpp): Seq[FileContent] = {
    val code = CppCodeBuilder()

    code.myHeader(
      Seq(
        s"#include \"${CppSubclasses.motor.name}.h\"",
        s"#include \"${CppSubclasses.quaternion.name}.h\"",
        s"#include \"${CppSubclasses.translator.name}.h\"",
      ),
      getClass.getName)


    val impl = CppCodeBuilder()

    code.namespace(codeGen.namespace) {
      for (translatorFirst <- Seq(true, false)) {
        val structName = if (translatorFirst) translatorWithQuaternion else quaternionWithTranslator
        val otherName = if (translatorFirst) quaternionWithTranslator else translatorWithQuaternion

        code("")
        code.struct(structName) {
          val fieldClasses =
            if (translatorFirst) Seq(CppSubclasses.translator, CppSubclasses.quaternion)
            else Seq(CppSubclasses.quaternion, CppSubclasses.translator)

          for (field <- fieldClasses) {
            code(s"${field.name} ${field.name.toLowerCase}{};")
          }

          code("")
          code(s"[[nodiscard]] constexpr ${CppSubclasses.motor.name} to${CppSubclasses.motor.name}() const noexcept { return ${fieldClasses.head.name.toLowerCase}.geometric(${fieldClasses.last.name.toLowerCase}); }")

          code("")
          code(s"[[nodiscard]] constexpr ${if (translatorFirst) quaternionWithTranslator else translatorWithQuaternion} reverse() const noexcept;")
          impl(s"[[nodiscard]] constexpr ${otherName} ${structName}::reverse() const noexcept { return { ${
            fieldClasses.reverse.map(f => s".${f.name.toLowerCase()} = ${f.name.toLowerCase()}.reverse()").mkString(", ")
          } }; }")

          code("")
          code(s"[[nodiscard]] constexpr $otherName to${otherName}() const noexcept;")
          impl(s"[[nodiscard]] constexpr ${otherName} ${structName}::to${otherName}() const noexcept { return ${
            if (translatorFirst) s"{ .quaternion = quaternion, .translator = quaternion.reverse().sandwich(translator).toTranslator() }"
            else s"{ .translator = quaternion.sandwich(translator).toTranslator(), .quaternion = quaternion }"
          }; };")


          code("")
          code(s"[[nodiscard]] static constexpr $structName id() noexcept { ${
            fieldClasses.map(f => s".${f.name.toLowerCase()} = ${s"${f.name}::id()"}")
              .mkString("return { ", ", ", " };")
          } }")
        }
      }

      code("")
      code(impl.toString)
    }

    Seq(FileContent(codeGen.directory.resolve(translatorWithQuaternion + ".h"), code.toString))
  }

  override def generateStructBody(cls: CppSubclass): Seq[StructBodyPart] = {
    if (cls != CppSubclasses.motor) return Seq()

    val code = CppCodeBuilder()


    structBodyPart(code.toString)
  }
}

object TranslatorWithQuaternionGenerator:
  val translatorWithQuaternion = s"${CppSubclasses.translator.name}With${CppSubclasses.quaternion.name}"
  val quaternionWithTranslator = s"${CppSubclasses.quaternion.name}With${CppSubclasses.translator.name}"
