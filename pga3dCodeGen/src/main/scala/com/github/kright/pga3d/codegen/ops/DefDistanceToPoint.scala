package com.github.kright.pga3d.codegen.ops

import com.github.kright.ga.PGA3
import com.github.kright.pga3d.codegen.{GeneratedCode, MultivectorSubClass, MultivectorUnaryOp}

object DefDistanceToPoint:
  def apply()(using pga3: PGA3): MultivectorUnaryOp =
    val pointClass = MultivectorSubClass.point

    MultivectorUnaryOp { (cls, v) =>
      if (cls == pointClass) {
        GeneratedCode { code =>
          code(
            s"""
               |def distanceTo(point: ${pointClass.typeName}): Double =
               |  (this - point).norm""".stripMargin)
        }
      } else None
    }