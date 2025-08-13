package com.github.kright.pga3d.codegen.ops

import com.github.kright.ga.PGA3
import com.github.kright.pga3d.codegen.MultivectorSubClass.pointCenter
import com.github.kright.pga3d.codegen.{GeneratedCode, MultivectorUnaryOp}

object DefToString:
  def apply()(using pga3: PGA3): MultivectorUnaryOp =
    MultivectorUnaryOp { (cls, v) =>
      if (cls.variableFields.nonEmpty) {
        GeneratedCode { code =>
          code(
            s"""
               |override def toString: String =
               |  s"${cls.name}(${cls.variableFields.map(f => s"${f.name} = ${"$" + f.name}").mkString(", ")})"""".stripMargin)
        }
      } else if (cls == pointCenter) {
        GeneratedCode { code =>
          code(
            s"""
               |override def toString: String =
               |  "${cls.name}"""".stripMargin)
        }
      } else {
        assert(false, s"unknown class ${cls}")
      }
    }
