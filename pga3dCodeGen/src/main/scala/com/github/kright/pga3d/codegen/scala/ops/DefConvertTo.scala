package com.github.kright.pga3d.codegen.scala.ops

import com.github.kright.ga.PGA3
import com.github.kright.pga3d.codegen.scala.{GeneratedCode, ScalaMultivectorSubClass, MultivectorUnaryOp}
import com.github.kright.symbolic.Sym

object DefConvertTo:
  def apply()(using pga3: PGA3): MultivectorUnaryOp =
    MultivectorUnaryOp { (cls, v) =>
      GeneratedCode { code =>
        for (target <- ScalaMultivectorSubClass.pgaClasses if target != cls) {
          if (target.isMatching(cls.self)) {
            code(s"\ndef to${target.typeNameWithoutPrefix}: ${target.typeName} =")
            code.block {
              code(target.makeConstructor(cls.self))
            }
          } else if (target != ScalaMultivectorSubClass.scalar && target != ScalaMultivectorSubClass.pseudoScalar) {
            val simplifiedSelf = cls.self.filter((blade, _) => target.variableFields.exists(_.basisBlade == blade))
            if (simplifiedSelf.values.nonEmpty) {
              code(s"\ndef to${target.typeNameWithoutPrefix}Unsafe: ${target.typeName} =")
              code.block {
                code(target.makeConstructor(cls.self))
              }
            }
          }
        }

        if (cls == ScalaMultivectorSubClass.projectivePoint) {
          val target = ScalaMultivectorSubClass.point
          val xyzBlade = pga3.representation.basisBladeWithSign("xyz").basisBlade
          val xyz = cls.self("xyz")
          val r = cls.self.filter((b, _) => b != xyzBlade).map((_, s) => Sym(s"${s} / ${xyz}"))
          code(s"\ndef to${target.typeNameWithoutPrefix}: ${target.typeName} =")
          code.block {
            code(target.makeConstructor(r))
          }
        }
      }
    }
