package com.github.kright.pga3d

import org.scalatest.funsuite.AnyFunSuiteLike
import org.scalatestplus.scalacheck.ScalaCheckPropertyChecks

class Pga3dMotorTest extends AnyFunSuiteLike with ScalaCheckPropertyChecks:
  test("motor renormalization") {
    val one = Pga3dMotor(s = 1.0)

    forAll(Pga3dGenerators.anyMotors.filter(_.bulkNorm > 0.01).map(_.renormalized), MinSuccessful(1000)) { renormalized =>
      val mm = renormalized.geometric(renormalized.reverse)
      assert((mm - one).norm < 3e-15, s"mm = ${mm}")
    }
  }
