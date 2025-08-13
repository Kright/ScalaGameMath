package com.github.kright.pga3d.codegen.ops

import com.github.kright.ga.{MultiVector, PGA3}
import com.github.kright.pga3d.codegen.MultivectorSubClass.{translator, vector}
import com.github.kright.pga3d.codegen.{GeneratedCode, MultivectorUnaryOp}
import com.github.kright.symbolic.Sym

object DefObjectMethodsForTranslator:
  def apply()(using pga3: PGA3): MultivectorUnaryOp =
    MultivectorUnaryOp { (cls, v) =>
      GeneratedCode { code =>
        if (cls == translator) {
          code(
            s"""
               |val id: ${cls.typeName} = ${cls.typeName}(0.0, 0.0, 0.0)""".stripMargin)
          code("")
          code(s"def addVector(v: ${vector.typeName}): ${cls.typeName} =")
          code.block {
            val vv = vector.makeSymbolic("v")
            val mult = MultiVector("w" -> Sym(-0.5))
            code(cls.makeConstructor(mult.geometric(vv.dual)))
          }
        }
      }
    }
