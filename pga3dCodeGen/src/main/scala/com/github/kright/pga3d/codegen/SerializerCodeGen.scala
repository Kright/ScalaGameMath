package com.github.kright.pga3d.codegen

import com.github.kright.ga.PGA3
import com.github.kright.pga3d.codegen.inertia.{InertiaLocalCodeGen, InertiaSummableCodeGen}

class SerializerCodeGen extends CodeGenClass:
  private given ga: PGA3 = MultivectorSubClass.pga3

  override def name: String = "Pga3dSerializer"

  override def isObject: Boolean = true

  override def generateCode(): String = {
    val code = CodeGen()

    code(s"object ${name}:".stripMargin)

    code.block {
      for (pgaClass <- MultivectorSubClass.pgaClasses) {
        if (pgaClass != MultivectorSubClass.zeroCls &&
          pgaClass != MultivectorSubClass.scalar &&
          pgaClass.variableFields.nonEmpty) {

          code("")
          code(s"def load${pgaClass.typeNameWithoutPrefix.capitalize}(arr: Array[Double], offset: Int): ${pgaClass.typeName} =")
          code.block {
            code(s"${pgaClass.typeName}(")
            code.block {
              pgaClass.variableFields.zipWithIndex.foreach { (field, i) =>
                code(s"${field.name} = arr(offset + ${i}),")
              }
            }
            code(")")
          }
          code("")
          code(s"def store(v: ${pgaClass.typeName}, arr: Array[Double], offset: Int): Unit =")
          code.block {
            for ((field, i) <- pgaClass.variableFields.zipWithIndex) {
              code(s"arr(offset + ${i}) = v.${field.name}")
            }
          }
        }
      }

      generateMethodsForInertia(code)
    }

    code.toString
  }

  private def generateMethodsForClass(code: CodeGen,
                                      typeNameWithoutPrefix: String,
                                      typeName: String,
                                      fields: Seq[String]): Unit = {
    code("")
    code(s"def load${typeNameWithoutPrefix}(arr: Array[Double], offset: Int): ${typeName} =")
    code.block {
      code(s"${typeName}(")
      code.block {
        fields.zipWithIndex.foreach { (field, i) =>
          code(s"${field} = arr(offset + ${i}),")
        }
      }
      code(")")
    }

    code("")
    code(s"def store(v: ${typeName}, arr: Array[Double], offset: Int): Unit =")
    code.block {
      for ((field, i) <- fields.zipWithIndex) {
        code(s"arr(offset + ${i}) = v.${field}")
      }
    }
  }

  def generateMethodsForInertia(code: CodeGen): Unit = {
    val inertia = InertiaLocalCodeGen()
    generateMethodsForClass(code, inertia.typeNameWithoutPrefix, inertia.typeName, inertia.fields)
    val inertiaSummable = InertiaSummableCodeGen()
    generateMethodsForClass(code, inertiaSummable.typeNameWithoutPrefix, inertiaSummable.typeName, inertiaSummable.fields)
  }
