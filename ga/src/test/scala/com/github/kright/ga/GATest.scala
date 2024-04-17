package com.github.kright.ga

import org.scalatest.funsuite.AnyFunSuiteLike
import org.scalatestplus.scalacheck.ScalaCheckPropertyChecks

class GATest extends AnyFunSuiteLike with ScalaCheckPropertyChecks:
  test("dual is inverse of dual") {
    for (ga <- Seq(
      PGA2(GARepresentationConfig.e0123(Signature.pga2)),
      PGA3(GARepresentationConfig.e0123(Signature.pga3)),
      GA.pga2,
      GA.pga3,
      GA.ga2,
      GA.ga3,
      GA.ga4
    )) {
      ga.use {
        val v = Sym.multiVector("v")
        assert(v === v.dual.dual)
      }
    }
  }

  test("rightComplement is inversion of leftComplement") {
    GAGenerator.forAnyGA {
      val a = Sym.multiVector("a")
      assert(a === a.leftComplement.rightComplement)
      assert(a === a.rightComplement.leftComplement)
    }
  }

  test("rightComplement power 4 is id") {
    GAGenerator.forAnyGA {
      val a = Sym.multiVector("a")
      assert(a === a.rightComplement.rightComplement.rightComplement.rightComplement)
    }
  }
