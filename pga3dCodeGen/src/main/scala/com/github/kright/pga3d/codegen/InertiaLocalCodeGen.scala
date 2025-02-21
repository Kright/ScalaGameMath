package com.github.kright.pga3d.codegen

import com.github.kright.ga.{MultiVector, PGA3}
import com.github.kright.pga3d.codegen.MultivectorSubClass.bivector
import com.github.kright.symbolic.Sym

class InertiaLocalCodeGen extends CodeGenClass:
  private given ga: PGA3 = MultivectorSubClass.pga3

  override def name: String = "Pga3dInertiaLocal"

  override def isObject: Boolean = false

  val fields: Seq[String] = Seq("mass", "mryz", "mrxz", "mrxy")

  override def generateCode(): String = {
    val code = CodeGen()

    val pad = " ".repeat(name.length - 4 - 3)

    code(
      s"""final case class ${name}(mass: Double,
         |                         ${pad}mryz: Double,
         |                         ${pad}mrxz: Double,
         |                         ${pad}mrxy: Double):""".stripMargin
    )

    code.block {
      generateToStringMethod(code)
      generateApplyMethod(code)
      generateInvertMethod(code)
      generateGetAcceleration(code)
    }

    code(
      s"""
         |
         |object ${name}:
         |""".stripMargin)
    code.block {
      code("")
      code(s"inline val componentsCount = ${fields.length}")
      code("")
      code(generateCubeCode())
    }

    code.toString
  }

  private val massMult = MultiVector(
    "wx" -> Sym("mass"),
    "wy" -> Sym("mass"),
    "wz" -> Sym("mass"),
    "yz" -> Sym("mryz"),
    "xz" -> Sym("mrxz"),
    "xy" -> Sym("mrxy"),
  )

  private def generateToStringMethod(code: CodeGen): Unit = {
    code(
      s"""
         |override def toString: String =
         |  s"${typeName}(${fields.map(f => s"${f} = ${"$" + f}").mkString(", ")})"""".stripMargin)
  }

  private def generateApplyMethod(code: CodeGen): Unit = {
    val localB = bivector.makeSymbolic("localB")
    val result = localB.multiplyElementwise(massMult).dual

    code(s"\ndef apply(localB: ${MultivectorSubClass.bivector.name}): ${MultivectorSubClass.bivector.name} =")
    code.block {
      code(bivector.makeConstructor(result))
    }
  }

  private def generateInvertMethod(code: CodeGen): Unit = {
    val localInertia = bivector.makeSymbolic("localInertia")
    val result = localInertia.dual.map((b, s) => Sym(s"$s / ${massMult(b)}"))

    code(s"\ndef invert(localInertia: ${MultivectorSubClass.bivector.name}): ${MultivectorSubClass.bivector.name} =")
    code.block {
      code(bivector.makeConstructor(result))
    }
  }

  private def generateGetAcceleration(code: CodeGen): Unit = {
    // def getAcceleration(localB: Bivector, localForque: Bivector): Bivector =
    //    invert(localB.cross(apply(localB)) + localForque)

    val localB = bivector.makeSymbolic("localB")
    val localForque = bivector.makeSymbolic("localForque")
    val applied = localB.multiplyElementwise(massMult).dual
    val combo = localB.crossX2(applied) * Sym(0.5) + localForque
    val result = combo.dual.map((b, s) => Sym(s"$s / ${massMult(b)}"))
    require(result.toMultilineString ==
      s"""MultiVector(
         |"s" -> 0.0 / 0.0
         |"wx" -> (localForque.yz + localB.wy * localB.xy * mass + localB.wz * localB.xz * mass) / mass
         |"wy" -> (-localForque.xz + localB.wz * localB.yz * mass - localB.wx * localB.xy * mass) / mass
         |"wz" -> (localForque.xy - localB.wx * localB.xz * mass - localB.wy * localB.yz * mass) / mass
         |"xy" -> (localForque.wz + localB.xz * localB.yz * mrxz - localB.xz * localB.yz * mryz) / mrxy
         |"xz" -> (-localForque.wy + localB.xy * localB.yz * mryz - localB.xy * localB.yz * mrxy) / mrxz
         |"yz" -> (localForque.wx + localB.xy * localB.xz * mrxy - localB.xy * localB.xz * mrxz) / mryz
         |"i" -> 0.0 / 0.0
         |)""".stripMargin, s"result.toMultilineString = '''\n${result.toMultilineString}\n'''")

    code(
      s"""
         |/** invert(localB.cross(apply(localB)) + localForque) */
         |def getAcceleration(localB: ${MultivectorSubClass.bivector.name}, localForque: ${MultivectorSubClass.bivector.name}): ${MultivectorSubClass.bivector.name} =
         |""".stripMargin
    )
    code.block {
      code(s"${MultivectorSubClass.bivector.name}(")
      code.block {
        code("wx = localForque.yz / mass + localB.wy * localB.xy + localB.wz * localB.xz,")
        code("wy = -localForque.xz / mass + localB.wz * localB.yz - localB.wx * localB.xy,")
        code("wz = localForque.xy / mass - localB.wx * localB.xz - localB.wy * localB.yz,")
        code("xy = (localForque.wz + localB.xz * localB.yz * mrxz - localB.xz * localB.yz * mryz) / mrxy,")
        code("xz = (-localForque.wy + localB.xy * localB.yz * mryz - localB.xy * localB.yz * mrxy) / mrxz,")
        code("yz = (localForque.wx + localB.xy * localB.xz * mrxy - localB.xy * localB.xz * mrxz) / mryz,")
      }
      code(")")
    }
  }

  private def generateCubeCode(): String =
    s"""def cube(mass: Double, rx: Double, ry: Double, rz: Double): ${name} =
       |  val rx2 = rx * rx
       |  val ry2 = ry * ry
       |  val rz2 = rz * rz
       |  ${name}(
       |    mass,
       |    mryz = (ry2 + rz2) * mass / 3,
       |    mrxz = (rx2 + rz2) * mass / 3,
       |    mrxy = (rx2 + ry2) * mass / 3,
       |  )
       |""".stripMargin
