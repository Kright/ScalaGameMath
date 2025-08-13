package com.github.kright.pga3d.codegen.ops

import com.github.kright.ga.PGA3
import com.github.kright.pga3d.codegen.MultivectorSubClass.{point, quaternion, translator}
import com.github.kright.pga3d.codegen.{GeneratedCode, MultivectorUnaryOp}

object DefZeroObjectMethods:
  def apply()(using pga3: PGA3): MultivectorUnaryOp =
    MultivectorUnaryOp { (cls, v) =>
      GeneratedCode { code =>
        if (cls != point && cls != quaternion && cls != translator) {
          code("")
          code(s"val zero: ${cls.typeName} = ${cls.typeName}(${cls.variableFields.map(_ => "0.0").mkString(", ")})")
        }
      }
    }
