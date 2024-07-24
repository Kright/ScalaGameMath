package com.github.kright.pga3d.codegen

import com.github.kright.ga.MultiVector
import com.github.kright.symbolic.Sym

object GeneratedCode:
  def apply(f: CodeGen => Unit): Option[String] = {
    val codeGen = CodeGen()
    f(codeGen)
    Option(codeGen.toString).filter(_ != "")
  }

object GeneratedValue:
  def apply(cls: MultivectorSubClass, name: String, result: MultiVector[Sym]): Option[String] = {
    val resultCls = MultivectorSubClass.findMatchingClass(result)
    if (resultCls == MultivectorSubClass.zeroCls) {
      None
    } else {
      GeneratedCode { code =>
        code(s"\ndef $name: ${resultCls.typeName} =")
        code.block {
          if (result == cls.self && resultCls == cls) {
            code("this")
          } else if (result == -cls.self && resultCls == cls && name != "unary_- ") {
            code("-this")
          } else {
            code(resultCls.makeConstructor(result))
          }
        }
      }
    }
  }
