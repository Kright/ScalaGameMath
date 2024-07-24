package com.github.kright.pga3d.codegen.ops

import com.github.kright.ga.PGA3
import com.github.kright.pga3d.codegen.{GeneratedCode, MultivectorSubClass, MultivectorUnaryOp}
import com.github.kright.symbolic.Sym

object DefDivideByScalar:
  def apply()(using pga3: PGA3): MultivectorUnaryOp = MultivectorUnaryOp { (cls, s) =>
    GeneratedCode { code =>
      val v = Sym("v")
      val result = cls.self * v
      val resultCls = MultivectorSubClass.findMatchingClass(result)
      code(s"\ninline def /(v: Double): ${resultCls.typeName} =")
      code.block {
        code("this * (1.0 / v)")
      }
    }
  }
