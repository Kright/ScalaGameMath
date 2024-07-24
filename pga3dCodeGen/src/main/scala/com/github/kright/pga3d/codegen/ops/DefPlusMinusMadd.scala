package com.github.kright.pga3d.codegen.ops

import com.github.kright.ga.{MultiVector, PGA3}
import com.github.kright.pga3d.codegen.MultivectorSubClass.*
import com.github.kright.pga3d.codegen.{GeneratedCode, MultivectorSubClass, MultivectorUnaryOp}
import com.github.kright.symbolic.Sym

object DefPlusMinusMadd:
  def apply()(using pga3: PGA3): MultivectorUnaryOp = MultivectorUnaryOp { (cls, s) =>
    GeneratedCode { code =>
      def makeMethod(result: MultiVector[Sym], firstLine: String): Unit = {
        val resultCls = MultivectorSubClass.findMatchingClass(result)
        if (resultCls != zeroCls) {
          code("")
          code(firstLine + s": ${resultCls.typeName} =")
          code.block {
            code(resultCls.makeConstructor(result))
          }
        }
      }

      val self = cls.self
      val points = Set(point, pointNormalized, vector)
      val bivectors = Set(bivector, bivectorBulk, bivectorWeight)
      if (points.contains(cls)) {
        for (pClass <- points) {
          val v = pClass.makeSymbolic("v")
          makeMethod(self + v, s"def +(v: ${pClass.typeName})")
          makeMethod(self - v, s"def -(v: ${pClass.typeName})")
          makeMethod(self + v * Sym("mult"), s"def madd(v: ${pClass.typeName}, mult: Double)")
        }
      } else if (bivectors.contains(cls)) {
        for (pClass <- bivectors) {
          val v = pClass.makeSymbolic("v")
          makeMethod(self + v, s"def +(v: ${pClass.typeName})")
          makeMethod(self - v, s"def -(v: ${pClass.typeName})")
          makeMethod(self + v * Sym("mult"), s"def madd(v: ${pClass.typeName}, mult: Double)")
        }
      } else {
        val v = cls.makeSymbolic("v")
        makeMethod(self + v, s"def +(v: ${cls.typeName})")
        makeMethod(self - v, s"def -(v: ${cls.typeName})")
        makeMethod(self + v * Sym("mult"), s"def madd(v: ${cls.typeName}, mult: Double)")
      }

      makeMethod(self.multiplyElementwise(cls.makeSymbolic("v")), s"def multiplyElementwise(v: ${cls.typeName})")
    }
  }
