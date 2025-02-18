package com.github.kright.pga3d.codegen

import com.github.kright.ga.PGA3

class SerializerCodeGen extends CodeGenClass:
  private given ga: PGA3 = MultivectorSubClass.pga3

  override def name: String = "Pga3dSerializer"

  override def isObject: Boolean = true

  override def generateCode(): String = {
    val code = CodeGen()

    code(s"case object ${name}:".stripMargin)

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

  def generateMethodsForInertia(code: CodeGen): Unit = {
    val inertia = InertiaLocalCodeGen()
    code("")
    code(s"def load${inertia.typeNameWithoutPrefix}(arr: Array[Double], offset: Int): ${inertia.typeName} =")
    code.block {
      code(s"${inertia.typeName}(")
      code.block {
        inertia.fields.zipWithIndex.foreach { (field, i) =>
          code(s"${field} = arr(offset + ${i}),")
        }
      }
      code(")")
    }

    code("")
    code(s"def store(v: ${inertia.typeName}, arr: Array[Double], offset: Int): Unit =")
    code.block {
      for ((field, i) <- inertia.fields.zipWithIndex) {
        code(s"arr(offset + ${i}) = v.${field}")
      }
    }
  }
