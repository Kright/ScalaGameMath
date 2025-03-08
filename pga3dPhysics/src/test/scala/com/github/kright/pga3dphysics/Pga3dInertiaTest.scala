package com.github.kright.pga3dphysics

import com.github.kright.matrix.{Matrix, MatrixPrinter}
import com.github.kright.pga3d.Pga3dGenerators.{normalizedQuaternions, vectors}
import com.github.kright.pga3d.*
import com.github.kright.pga3dphysics.Pga3dPhysicsGenerators.inertiaGen
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
      "Pga3dInertiaSummable(ww=1.0, wx=0.0, wy=0.0, wz=0.0, xx=1.0, yy=1.0, zz=1.0, xy=0.0, yz=0.0, xz=0.0)")
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
  }

  private def getMainAxesSorted(inertia: Pga3dInertia): Seq[Double] =
    val local = inertia.localInertia
    Seq(local.mryz, local.mrxz, local.mrxy).sorted

  private def maxDiff(lstA: Seq[Double], lstB: Seq[Double]): Double =
    lstA.zip(lstB).map((a, b) => Math.abs(a - b)).max

  test("inertia diagonalization preservers summableInertia") {
    val toStr = MatrixPrinter.squarePrinter5f.copy(elemToStr = _.toString)

    forAll(inertiaGen, MinSuccessful(100)) { inertiaInitial =>
      val summableInertia = inertiaInitial.toSummable
      val inertiaRestored = summableInertia.toInertia
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
      val inertiaRestored = summableInertia.toInertia
      val summableRestored = inertiaRestored.toSummable

      val sortedAxesInitial = getMainAxesSorted(inertiaInitial)
      val sortedAxesRestored = getMainAxesSorted(inertiaRestored)

      assert(maxDiff(sortedAxesInitial, sortedAxesRestored) < 1e-13 * inertiaInitial.mass,
        s"""diff = ${sortedAxesInitial.zip(sortedAxesRestored).map((a, b) => Math.abs(a - b)).mkString(", ")}
           |sortedAxesInitial = ${sortedAxesInitial}
           |sortedAxesRestored = ${sortedAxesRestored}""".stripMargin)
    }
  }

  test("inertia .toSummable.toInertia preserves mass") {
    forAll(inertiaGen, MinSuccessful(1000)) { inertiaInitial =>
      val inertiaRestored = inertiaInitial.toSummable.toInertia

      assert(Math.abs(inertiaInitial.mass - inertiaRestored.mass) < 1e-13,
        s"""diff = ${Math.abs(inertiaInitial.mass - inertiaRestored.mass)}
           |initialMass = ${inertiaRestored.mass}
           |restoredMass = ${inertiaRestored.mass}""".stripMargin)
    }
  }

  test("inertia toSummable.toInertia and back applied in the same way") {
    forAll(inertiaGen, Pga3dGenerators.bivectors, MinSuccessful(1000)) { (inertia, bivector) =>
      val inertia2 = inertia.toSummable.toInertia

      val applied1 = inertia(bivector)
      val applied2 = inertia2(bivector)

      assert((applied1 - applied2).norm < 1e-9)
    }
  }

  test("inertia sum") {
    forAll(inertiaGen, inertiaGen, Pga3dGenerators.bivectors, MinSuccessful(1000)) { (inertia1, inertia2, bivector) =>

      val inertiaSum = (inertia1.toSummable + inertia2.toSummable).toInertia

      val applied1 = inertia1(bivector) + inertia2(bivector)
      val applied2 = inertiaSum(bivector)

      assert((applied1 - applied2).norm < 1e-9)
    }
  }

  test("inertia toSummable applied in the same way") {
    forAll(inertiaGen, Pga3dGenerators.bivectors, MinSuccessful(1000)) { (inertia, bivector) =>
      val applied1 = inertia(bivector)
      val applied2 = inertia.toSummable(bivector)

      assert((applied1 - applied2).norm < 1e-9)
    }
  }

  test("inertia .toInertia() acts the same way") {
    val probes = Seq(
      Pga3dBivector(1, 0, 0, 0, 0, 0),
      Pga3dBivector(0, 1, 0, 0, 0, 0),
      Pga3dBivector(0, 0, 1, 0, 0, 0),
      Pga3dBivector(0, 0, 0, 1, 0, 0),
      Pga3dBivector(0, 0, 0, 0, 1, 0),
      Pga3dBivector(0, 0, 0, 0, 0, 1),
    )

    val inertiaProbes = Seq(
      Pga3dInertiaSummable(1, 1, 0, 0, 0, 0, 0, 0, 0, 0),
      Pga3dInertiaSummable(1, 0, 1, 0, 0, 0, 0, 0, 0, 0),
      Pga3dInertiaSummable(1, 0, 0, 1, 0, 0, 0, 0, 0, 0),
      Pga3dInertiaSummable(1, 0, 0, 0, 1, 0, 0, 0, 0, 0),
      Pga3dInertiaSummable(1, 0, 0, 0, 0, 1, 0, 0, 0, 0),
      Pga3dInertiaSummable(1, 0, 0, 0, 0, 0, 1, 0, 0, 0),
      Pga3dInertiaSummable(1, 0, 0, 0, 0, 0, 0, 1, 0, 0),
      Pga3dInertiaSummable(1, 0, 0, 0, 0, 0, 0, 0, 1, 0),
      Pga3dInertiaSummable(1, 0, 0, 0, 0, 0, 0, 0, 0, 1),
    )

    for (summable <- inertiaProbes) {
      for (probe <- probes) {
//        println(s"probe = $probe")
//        println(s"inertia = ${summable}")
//        println(s"inertiaLocal(probe) = ${summable.toInertia.apply(probe)}")
//        println(s"inertiaGlobl(probe) = ${summable.apply(probe)}")
        assert((summable.toInertia.apply(probe) - summable.apply(probe)).norm < 1e-9)
      }
    }
  }

