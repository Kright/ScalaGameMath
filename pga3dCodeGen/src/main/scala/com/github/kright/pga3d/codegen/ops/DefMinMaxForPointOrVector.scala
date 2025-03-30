package com.github.kright.pga3d.codegen.ops

import com.github.kright.ga.PGA3
import com.github.kright.pga3d.codegen.{GeneratedCode, MultivectorSubClass, MultivectorUnaryOp}

object DefMinMaxForPointOrVector:
  def apply()(using pga3: PGA3): MultivectorUnaryOp = MultivectorUnaryOp { (cls, s) =>
    GeneratedCode { code =>
      if (cls == MultivectorSubClass.point || cls == MultivectorSubClass.vector) {
        code(
          s"""
             |infix def min(other: ${cls.typeName}): ${cls.typeName} =
             |  ${cls.typeName}(Math.min(x, other.x), Math.min(y, other.y), Math.min(z, other.z))
             |
             |infix def max(other: ${cls.typeName}): ${cls.typeName} = 
             |  ${cls.typeName}(Math.max(x, other.x), Math.max(y, other.y), Math.max(z, other.z))
             |""".stripMargin
        )
      }
    }
  }
