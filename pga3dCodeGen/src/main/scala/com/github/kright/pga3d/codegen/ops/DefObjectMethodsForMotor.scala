package com.github.kright.pga3d.codegen.ops

import com.github.kright.ga.PGA3
import com.github.kright.pga3d.codegen.MultivectorSubClass.{motor, translator, vector}
import com.github.kright.pga3d.codegen.{GeneratedCode, MultivectorUnaryOp}

object DefObjectMethodsForMotor:
  def apply()(using pga3: PGA3): MultivectorUnaryOp =
    MultivectorUnaryOp { (cls, v) =>
      GeneratedCode { code =>
        if (cls == motor) {
          code(
            s"""
               |val id: ${cls.typeName} = ${cls.typeName}(1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0)
               |
               |def addVector(v: ${vector.typeName}): ${cls.typeName} = ${translator.name}.addVector(v).toMotor""".stripMargin)
        }
      }
    }
