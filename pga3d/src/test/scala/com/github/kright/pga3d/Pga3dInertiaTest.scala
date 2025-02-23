package com.github.kright.pga3d

import com.github.kright.matrix.MatrixPrinter
import com.github.kright.pga3d.Pga3dGenerators.{normalizedQuaternions, vectors}
import org.scalacheck.Gen
import org.scalacheck.rng.Seed
import org.scalactic.anyvals.PosInt
import org.scalatest.funsuite.AnyFunSuiteLike
import org.scalatestplus.scalacheck.ScalaCheckPropertyChecks

class Pga3dInertiaTest extends AnyFunSuiteLike with ScalaCheckPropertyChecks:
  extension (p: Pga3dInertiaSummable)
    def str: String =
      s"""Pga3dSymBivector(ww = ${p.ww},
         |                 wx = ${p.wx}, wy = ${p.wy}, wz = ${p.wz},
         |                 xx = ${p.xx}, yy = ${p.yy}, zz = ${p.zz},
         |                 xy = ${p.xy}, xz = ${p.xz}, yz = ${p.yz})""".stripMargin


  private val shifts: Seq[Pga3dVector] = Seq(
    Pga3dVector(0.0, 0.0, 0.0),
    Pga3dVector(1.0, 0.0, 0.0),
    Pga3dVector(0.0, 1.0, 0.0),
    Pga3dVector(0.0, 0.0, 1.0),
    Pga3dVector(1.0, 1.0, 1.0),
  )

  def p(p: Pga3dInertiaSummable): Unit =
    println(p.str)
    println(p)
    println()

  def assertEq(a: Pga3dInertiaSummable, b: Pga3dInertiaSummable, eps: Double = 1e-9): Unit = {
    val n = (a - b).norm
    assert(n < eps)
  }

  test("center of mass") {
    for (mass <- Seq(0.1, 1.0, 2.0);
         shift <- shifts) {
      val point = shift.toPointUnsafe
      val centerOfMass = Pga3dInertiaSummable.point(point, mass).centerOfMassTrivector
      assert(centerOfMass.w == mass)
      assert((centerOfMass.toPoint - point).norm < 1e-9)
    }
  }

  test("shift") {
    val p1 = Pga3dPoint(-1.0, 0.0, 0.0)
    val p2 = Pga3dPoint(1.0, 0.0, 0.0)
    val sum = Pga3dInertiaSummable.point(p1, mass = 1.0) + Pga3dInertiaSummable.point(p2, mass = 3.0)
    shifts.foreach { shift =>
      val shiftedSum = Pga3dInertiaSummable.point(p1 + shift, mass = 1.0) + Pga3dInertiaSummable.point(p2 + shift, mass = 3.0)
      assertEq(Pga3dTranslator.addVector(shift).sandwich(sum), shiftedSum)
      assertEq(Pga3dTranslator.addVector(shift).toMotor.sandwich(sum), shiftedSum)
    }
  }

  test("rotate") {
    val p1 = Pga3dPoint(-1.0, 0.0, 0.0)
    val p2 = Pga3dPoint(1.0, 0.0, 0.0)
    val sum = Pga3dInertiaSummable.point(p1, mass = 1.0) + Pga3dInertiaSummable.point(p2, mass = 3.0)
    forAll(normalizedQuaternions) { q =>
      val rotatedSum = Pga3dInertiaSummable.point(q.sandwich(p1).toPoint, mass = 1.0) + Pga3dInertiaSummable.point(q.sandwich(p2).toPoint, mass = 3.0)
      assertEq(q.sandwich(sum), rotatedSum)
      assertEq(q.toMotor.sandwich(sum), rotatedSum)
    }
  }

  test("apply motor") {
    val p1 = Pga3dPoint(-1.0, 0.0, 0.0)
    val p2 = Pga3dPoint(1.0, 0.0, 0.0)
    val sum = Pga3dInertiaSummable.point(p1, mass = 1.0) + Pga3dInertiaSummable.point(p2, mass = 3.0)
    forAll(normalizedQuaternions(Gen.Parameters.default, Seed(12345L)).get, vectors) { (q, shift) =>
      val motor = q.geometric(Pga3dTranslator.addVector(shift))
      val movedSum = motor.sandwich(sum)
      assertEq(motor.sandwich(sum), movedSum)
    }
  }

  test("apply bivector") {
    val p1 = Pga3dPoint(-2.0, 0.0, 0.0)
    val p2 = Pga3dPoint(2.0, 0.0, 0.0)
    //    val sum = new Pga3dInertia(p1, mass = 1) + new Pga3dInertia(p2, mass = 3)
    val sum = Pga3dInertiaSummable.point(p1, mass = 1) + Pga3dInertiaSummable.point(p2, mass = 7)
    // (3^2 * 1 + 1^2 * 3)
    val b = Pga3dBivector(0.0, 1.0, 0.0)
    val shifted = Pga3dTranslator.addVector(-sum.centerOfMass.toVectorUnsafe).sandwich(sum)
    //    println(shifted.toMatrixString)
    //    println(sum.actOnBivectorAsInertia(b))
    //    println(sum.actOnBivectorAsInertia2(b))
  }

  test("inertia of eight points in cube") {
    val localInertia = Pga3dInertiaLocal(mass = 1.0, mryz = 1 + 1, mrxz = 1 + 1, mrxy = 1 + 1)

    var sumOfPoints = Pga3dInertiaSummable.zero
    for (z <- Seq(-1, 1); y <- Seq(-1, 1); x <- Seq(-1, 1)) {
      sumOfPoints += Pga3dInertiaSummable.point(Pga3dPoint(x, y, z), mass = 1.0 / 8.0)
    }

    assertEq(sumOfPoints, localInertia.toSummable)

    assert(sumOfPoints.toString ==
      "Pga3dInertia(ww=1.0, wx=0.0, wy=0.0, wz=0.0, xx=1.0, yy=1.0, zz=1.0, xy=0.0, yz=0.0, xz=0.0)")
  }

  test(s"inertia of eight points in cube for non-even mass and size") {
    val mass = 7.0
    val rx = 3.0
    val ry = 4.0
    val rz = 5.0

    val rx2 = rx * rx
    val ry2 = ry * ry
    val rz2 = rz * rz

    val localInertia = Pga3dInertiaLocal(
      mass,
      mryz = mass * (ry2 + rz2),
      mrxz = mass * (rx2 + rz2),
      mrxy = mass * (rx2 + ry2),
    )

    var sumOfPoints = Pga3dInertiaSummable.zero
    for (z <- Seq(-rz, rz); y <- Seq(-ry, ry); x <- Seq(-rx, rx)) {
      sumOfPoints += Pga3dInertiaSummable.point(Pga3dPoint(x, y, z), mass = mass / 8.0)
    }

    assertEq(sumOfPoints, localInertia.toSummable)

    val bvv = Seq(
      Pga3dBivector(1, 0, 0, 0, 0, 0),
      Pga3dBivector(0, 1, 0, 0, 0, 0),
      Pga3dBivector(0, 0, 1, 0, 0, 0),
      Pga3dBivector(0, 0, 0, 1, 0, 0),
      Pga3dBivector(0, 0, 0, 0, 1, 0),
      Pga3dBivector(0, 0, 0, 0, 0, 1),
    )

    //    for (bv <- bvv) {
    //      println(localInertia.apply(bv))
    //      println(sumOfPoints.actOnBivectorAsInertia(bv.dual))
    //      println(sumOfPoints.apply(bv))
    //    }
  }

  private def getMainAxesSorted(inertia: Pga3dInertia): Seq[Double] =
    val local = inertia.local
    Seq(local.mryz, local.mrxz, local.mrxy).sorted

  private def maxDiff(lstA: Seq[Double], lstB: Seq[Double]): Double =
    lstA.zip(lstB).map((a, b) => Math.abs(a - b)).max

  private val inertiaGen: Gen[Pga3dInertia] = for {
    inertiaLocal <- Pga3dGenerators.inertiaLocal(0.1, 10.0, 0.1, 10.0)
    q <- Pga3dGenerators.normalizedQuaternions
    shift <- Pga3dGenerators.vectors
    motor = Pga3dTranslator.addVector(shift).geometric(q)
  } yield Pga3dInertia(motor, inertiaLocal)

  test("inertia diagonalization preservers summableInertia") {
    val toStr = MatrixPrinter.squarePrinter5f.copy(elemToStr = _.toString)

    forAll(inertiaGen, MinSuccessful(100)) { inertiaInitial =>
      val summableInertia = inertiaInitial.toSummable
      val inertiaRestored = summableInertia.toInertia()
      val summableRestored = inertiaRestored.toSummable

      val diff = (summableInertia - summableRestored).norm
      assert(diff < 1e-9,
        s"""diff = ${diff}
           |summableInertia = ${toStr(summableInertia.toMatrixXYZW)}
           |summableRestored = ${toStr(summableInertia.toMatrixXYZW)}
           |""".stripMargin)
    }
  }

  test("inertia diagonalization preservers main axes") {
    forAll(inertiaGen, MinSuccessful(100)) { inertiaInitial =>
      val summableInertia = inertiaInitial.toSummable
      val inertiaRestored = summableInertia.toInertia()
      val summableRestored = inertiaRestored.toSummable

      val sortedAxesInitial = getMainAxesSorted(inertiaInitial)
      val sortedAxesRestored = getMainAxesSorted(inertiaRestored)

      assert(maxDiff(sortedAxesInitial, sortedAxesRestored) < 1e-13 * inertiaInitial.mass,
        s"""diff = ${sortedAxesInitial.zip(sortedAxesRestored).map((a, b) => Math.abs(a - b)).mkString(", ")}
           |sortedAxesInitial = ${sortedAxesInitial}
           |sortedAxesRestored = ${sortedAxesRestored}""".stripMargin)
    }
  }

  test("inertia .toSummable.toInertia() preserves mass") {
    forAll(inertiaGen, MinSuccessful(100)) { inertiaInitial =>
      val inertiaRestored = inertiaInitial.toSummable.toInertia()

      assert(Math.abs(inertiaInitial.mass - inertiaRestored.mass) < 1e-13,
        s"""diff = ${Math.abs(inertiaInitial.mass - inertiaRestored.mass)}
           |initialMass = ${inertiaRestored.mass}
           |restoredMass = ${inertiaRestored.mass}""".stripMargin)
    }
  }
