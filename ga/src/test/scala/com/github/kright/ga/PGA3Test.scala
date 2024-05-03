package com.github.kright.ga

import com.github.kright.ga.PGA3.*
import com.github.kright.math.{EqualityEps, Vector3d, VectorMathGenerators}
import org.scalactic.{Equality, TolerantNumerics}
import org.scalatest.funsuite.AnyFunSuiteLike
import org.scalatestplus.scalacheck.ScalaCheckPropertyChecks

import scala.math.Numeric.Implicits.infixNumericOps

class PGA3Test extends AnyFunSuiteLike with ScalaCheckPropertyChecks:
  private given ga: PGA3 = GA.pga3

  private val eps = 1e-12

  private given doubleEquality: Equality[Double] = TolerantNumerics.tolerantDoubleEquality(eps)

  private given equalityEps: EqualityEps = EqualityEps(eps)

  test("point is intersection of three planes") {
    val num = summon[Numeric[Sym]]
    val one = num.one
    val zero = num.zero

    val x = Sym("x")
    val y = Sym("y")
    val z = Sym("z")

    val px = plane(one, zero, zero, -x)
    val py = plane(zero, one, zero, -y)
    val pz = plane(zero, zero, one, -z)

    val p = point(x, y, z)
    val intersectionPoint = (px ^ py ^ pz)

    assert(p === intersectionPoint, s"\n${p.toMultilineString} != ${intersectionPoint.toMultilineString}")
  }

  test("planeX mirrors points") {
    val p = point(Sym("p.x"), Sym("p.y"), Sym("p.z"))
    val plane = Sym.planeX()

    val mirrored = plane.sandwich(p).withoutZeros
    val expected = point(-Sym("p.x"), Sym("p.y"), Sym("p.z"))

    assert(mirrored == expected, s"\n${mirrored.toMultilineString} != ${expected.toMultilineString}")
  }

  private def getVector(v: MultiVector[Double]): Vector3d =
    Vector3d(v("x"), v("y"), v("z"))

  test("plane mirrors points") {
    forAll(PGA3Generator.planeGen, PGA3Generator.pointGen) { (plane, point) =>
      val mirrored = plane.sandwich(point)

      val planeNormal = getVector(plane)
      val pointVec = getVector(point.dual)
      val mirroredVec = getVector(mirrored.dual)

      val pointD = planeNormal.dot(pointVec)
      val mirroredD = planeNormal.dot(mirroredVec)

      assert(planeNormal.mag === 1.0)
      assert((0.5 * (pointVec + mirroredVec)).dot(planeNormal) === -plane("w"))
      assert((pointVec - mirroredVec).rejected(axis = planeNormal) === Vector3d.zero)
    }
  }

  test("line defined by two points and by intersection are equal") {
    val planeX = plane(1.0, 0.0, 0.0, 0.0)
    val planeY = plane(0.0, 1.0, 0.0, 0.0)
    val pointCenter = point(0.0, 0.0, 0.0)
    val pointZ = point(0.0, 0.0, 1.0)

    assert((pointCenter v pointZ) == (planeX ^ planeY))
  }

  test("plane defined by three points") {
    val pointCenter = point(0.0, 0.0, 0.0)
    val pointX = point(1.0, 0.0, 0.0)
    val pointY = point(0.0, 1.0, 0.0)

    assert((pointCenter v pointY v pointX) == plane(0.0, 0.0, 1.0, 0.0))
  }

  test("translated rotor is rotor with translated axis of rotation") {
    forAll(VectorMathGenerators.vectors3InCube, VectorMathGenerators.vectors3normalized, VectorMathGenerators.double1) { (translation, rotAxis, angle) =>
      val tr = translatorByIdealLine(MultiVector[Double](
        "wx" -> -translation.x,
        "wy" -> -translation.y,
        "wz" -> -translation.z,
      ))

      val axis = zeroPoint[Double] v point(rotAxis.x, rotAxis.y, rotAxis.z)
      val rot1 = tr.sandwich(rotor(angle, axis))
      val rot2 = rotor(angle, tr.sandwich(axis))

      assert((rot1 - rot2).squareMagnitude <= 1e-12)
    }
  }

  test("rotor, expForRotor and exponent by series sum are same for line through center") {
    forAll(VectorMathGenerators.vectors3normalized, VectorMathGenerators.double1) { (rotAxis, angle) =>
      val axis = zeroPoint[Double] v point(rotAxis)

      val rot1 = rotor(angle, axis)
      val rot2 = expForRotor(axis * 0.5 * angle)
      val rot3 = (axis * 0.5 * angle).exponentBySeriesSum(thresholdNorm = 1e-12)

      assert((rot1 - rot3).norm <= 1e-10, s"${rot1.toMultilineString} != ${rot3.toMultilineString}")
      assert((rot2 - rot3).norm <= 1e-10, s"${rot1.toMultilineString} != ${rot3.toMultilineString}")
    }
  }

  test("rotor, expForRotor and exponent by series sum are same for any line") {
    forAll(VectorMathGenerators.vectors3normalized, VectorMathGenerators.double1, VectorMathGenerators.vectors3InCube) { (rotAxis, angle, center) =>
      val axis = point(center) v point(center + rotAxis)

      val rot1 = rotor(angle, axis)
      val rot2 = expForRotor(axis * 0.5 * angle)
      val rot3 = (axis * 0.5 * angle).exponentBySeriesSum(thresholdNorm = 1e-15)

      assert((rot1 - rot3).norm <= 1e-10, s"${rot1.toMultilineString} != ${rot3.toMultilineString}")
      assert((rot2 - rot3).norm <= 1e-10, s"${rot1.toMultilineString} != ${rot3.toMultilineString}")
    }
  }

  test("rotation and orthogonal translation") {
    val lineUp = zeroPoint[Double] v point(0.0, 0.0, 1.0)

    val translateZ = translator(zeroPoint[Sym], point(Sym(0.0), Sym(0.0), Sym("dz")))

    val rotateXY = MultiVector(
      "1" -> Sym("cos"),
      "xy" -> Sym("sin"),
      "xz" -> Sym(0.0),
      "yz" -> Sym(0.0),
    )

    assert(translateZ.geometric(rotateXY) == rotateXY.geometric(translateZ))
  }
