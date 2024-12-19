package com.github.kright.pga3d.codegen.ops

import com.github.kright.ga.{MultiVector, PGA3}
import com.github.kright.pga3d.codegen.MultivectorSubClass.{bivector, bivectorWeight}
import com.github.kright.pga3d.codegen.{GeneratedCode, MultivectorSubClass, MultivectorUnaryOp}
import com.github.kright.symbolic.Sym

import scala.math.Numeric.Implicits.infixNumericOps

object DefBivectorSplit:
  def apply()(using pga3: PGA3): MultivectorUnaryOp = MultivectorUnaryOp { (cls, v) =>
    if (cls == bivector) {
      GeneratedCode { code =>
        val self = cls.self
        code(s"\ndef split(): (${MultivectorSubClass.bivector.name}, ${MultivectorSubClass.bivectorWeight.name}) =")
        code.block {
          code(
            s"""val div = bulkNormSquare
               |if (div < 1e-100) {
               |  return (${MultivectorSubClass.bivector.name}(0.0, 0.0, 0.0, xy, xz, yz), ${MultivectorSubClass.bivectorWeight.name}(wx, wy, wz))
               |}
               |
               |// val shiftAlongLine = this.geometric((this ^ this.reverse) / div / 2.0)
               |// pseudoScalar = this ^ this.reverse
               |
               |val pseudoScalar = ${(self ^ self.reverse).pseudoScalar * Sym(0.5)} / div
               |val shiftAlongLine = ${bivectorWeight.makeConstructor(self.geometric(MultiVector("i" -> Sym("pseudoScalar"))))}
               |
               |val line = this - shiftAlongLine
               |(line, shiftAlongLine)
               |""".stripMargin
          )
        }
      }
    } else None
  }
