package com.github.kright.pga3d.codegen.ops

import com.github.kright.ga.PGA3
import com.github.kright.pga3d.codegen.MultivectorSubClass.{bivector, bivectorBulk, bivectorWeight}
import com.github.kright.pga3d.codegen.{GeneratedCode, MultivectorSubClass, MultivectorUnaryOp}
import com.github.kright.symbolic.Sym

object DefLogForMotor:
  def apply()(using pga3: PGA3): MultivectorUnaryOp = MultivectorUnaryOp { (cls, v) =>
    GeneratedCode { code =>
      val self = cls.self

      if (cls == MultivectorSubClass.motor) {
        val vb = self.grade(2)
        val result = vb * Sym("b") + vb.bulk.dual * Sym("c")

        code(s"\ndef log(): ${bivector.typeName} =")
        code.block {
          code(
            s"""val scalar = s
               |val lenXYZ = Math.sqrt(xy * xy + xz * xz + yz * yz)
               |val angle = Math.atan2(lenXYZ, scalar)
               |
               |val a = 1.0 / (1.0 - scalar * scalar) // 1 / sin^2
               |
               |val b = if (Math.abs(angle) > 1e-5) { // angle / sin(angle)
               |  angle * Math.sqrt(a)
               |} else {
               |  1.0 + angle * angle / 6.0
               |}
               |
               |val c = if (Math.abs(angle) > 1e-5) {
               |  a * i * (1.0 - scalar * b)
               |} else {
               |  (1.0 + angle * angle / 2.0) * i / 3.0
               |}
               |
               |${bivector.makeConstructor(result)}
               |""".stripMargin)
        }
      }
      if (cls == MultivectorSubClass.translator) {
        code(s"\ndef log(): ${bivectorWeight.typeName} =")
        code.block {
          code(bivectorWeight.makeConstructor(self.weight))
        }
      }
      if (cls == MultivectorSubClass.quaternion) {
        val vb = self.grade(2)
        val result = vb * Sym("b")

        code(s"\ndef log(): ${bivectorBulk.typeName} =")
        code.block {
          code(
            s"""val scalar = s
               |val lenXYZ = Math.sqrt(xy * xy + xz * xz + yz * yz)
               |val angle = Math.atan2(lenXYZ, scalar)
               |
               |val a = 1.0 / (1.0 - scalar * scalar) // 1 / sin^2
               |
               |val b = if (Math.abs(angle) > 1e-5) { // angle / sin(angle)
               |  angle * Math.sqrt(a)
               |} else {
               |  1.0 + angle * angle / 6.0
               |}
               |
               |${bivectorBulk.makeConstructor(result)}
               |""".stripMargin)
        }
      }
    }
  }
