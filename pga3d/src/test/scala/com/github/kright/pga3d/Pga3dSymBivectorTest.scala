package com.github.kright.pga3d

import com.github.kright.pga3d.GeneratorsPga3d.{normalizedQuaternions, vectors}
import org.scalacheck.Gen
import org.scalacheck.rng.Seed
import org.scalatest.funsuite.AnyFunSuiteLike
import org.scalatestplus.scalacheck.ScalaCheckPropertyChecks

class Pga3dSymBivectorTest extends AnyFunSuiteLike with ScalaCheckPropertyChecks:
  private val shifts: Seq[Pga3dVector] = Seq(
    Pga3dVector(0.0, 0.0, 0.0),
    Pga3dVector(1.0, 0.0, 0.0),
    Pga3dVector(0.0, 1.0, 0.0),
    Pga3dVector(0.0, 0.0, 1.0),
    Pga3dVector(1.0, 1.0, 1.0),
  )

  def p(p: Pga3dSymBivector): Unit =
    println(p.str)
    println(p)
    println()

  def assertEq(a: Pga3dSymBivector, b: Pga3dSymBivector, eps: Double = 1e-9): Unit = {
    val n = (a - b).norm
    assert(n < eps)
  }

  test("center of mass") {
    for (mass <- Seq(0.1, 1.0, 2.0);
         shift <- shifts) {
      val point = shift.toPointUnsafe
      val centerOfMass = new Pga3dSymBivector(point, m = mass).centerOfMass

      println(s"shift = $shift, mass = $mass, centerOfMass = $centerOfMass")

      assert(centerOfMass.w == mass)
      assert((centerOfMass.toPoint - point).norm < 1e-9)
    }
  }

  test("shift") {
    val p1 = Pga3dPoint(-1.0, 0.0, 0.0)
    val p2 = Pga3dPoint(1.0, 0.0, 0.0)
    val sum = new Pga3dSymBivector(p1, m = 1.0) + new Pga3dSymBivector(p2, m = 3.0)

    shifts.foreach { shift =>
      val shiftedSum = new Pga3dSymBivector(p1 + shift, m = 1.0) + new Pga3dSymBivector(p2 + shift, m = 3.0)
      assertEq(Pga3dTranslator.addVector(shift).sandwich(sum), shiftedSum)
      assertEq(Pga3dTranslator.addVector(shift).toMotor.sandwich(sum), shiftedSum)
    }
  }

  test("rotate") {
    val p1 = Pga3dPoint(-1.0, 0.0, 0.0)
    val p2 = Pga3dPoint(1.0, 0.0, 0.0)
    val sum = new Pga3dSymBivector(p1, m = 1.0) + new Pga3dSymBivector(p2, m = 3.0)

    forAll(normalizedQuaternions) { q =>
      val rotatedSum = new Pga3dSymBivector(q.sandwich(p1).toPoint, m = 1.0) + new Pga3dSymBivector(q.sandwich(p2).toPoint, m = 3.0)

      assertEq(q.sandwich(sum), rotatedSum)
      assertEq(q.toMotor.sandwich(sum), rotatedSum)
    }
  }

  test("apply motor") {
    val p1 = Pga3dPoint(-1.0, 0.0, 0.0)
    val p2 = Pga3dPoint(1.0, 0.0, 0.0)
    val sum = new Pga3dSymBivector(p1, m = 1.0) + new Pga3dSymBivector(p2, m = 3.0)

    forAll(normalizedQuaternions(Gen.Parameters.default, Seed(12345L)).get, vectors) { (q, shift) =>
      val motor = q.geometric(Pga3dTranslator.addVector(shift))
      val movedSum = motor.sandwich(sum)

      assertEq(motor.sandwich(sum), movedSum)
    }
  }

  test("apply bivector") {
    val p1 = Pga3dPoint(-2.0, 0.0, 0.0)
    val p2 = Pga3dPoint(2.0, 0.0, 0.0)
//    val sum = new Pga3dSymBivector(p1, m = 1) + new Pga3dSymBivector(p2, m = 3)
    val sum = new Pga3dSymBivector(p1, m = 1) + new Pga3dSymBivector(p2, m = 7)
    // (3^2 * 1 + 1^2 * 3)
    val b = Pga3dBivector(0.0, 1.0, 0.0)

    val shifted = Pga3dTranslator.addVector(-sum.centerOfMass.toPoint.toVectorUnsafe).sandwich(sum)

    println(shifted.strMatrix)

    println(sum.actOnBivectorAsInertia(b))
    println(sum.actOnBivectorAsInertia2(b))
  }
