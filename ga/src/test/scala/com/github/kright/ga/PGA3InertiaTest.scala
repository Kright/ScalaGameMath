package com.github.kright.ga

import com.github.kright.math.EqualityEps
import org.scalactic.{Equality, TolerantNumerics}
import org.scalatest.funsuite.AnyFunSuiteLike
import org.scalatestplus.scalacheck.ScalaCheckPropertyChecks

import scala.math.Numeric.Implicits.infixNumericOps


class PGA3InertiaTest extends AnyFunSuiteLike with ScalaCheckPropertyChecks:
  private given ga: PGA3 = GA.pga3

  private val eps = 1e-12

  private given doubleEquality: Equality[Double] = TolerantNumerics.tolerantDoubleEquality(eps)

  private given equalityEps: EqualityEps = EqualityEps(eps)

  private val b = Sym.multiVector("b").filter((b, _) => b.grade == 2)

  // @formatter:off
  private def bxy = b("xy")
  private def bxz = b("xz")
  private def byz = b("yz")
  private def bwx = b("wx")
  private def bwy = b("wy")
  private def bwz = b("wz")
  // @formatter:on

  test("inertia") {
    val x = Sym.point("x")

    val mass = Sym("mass")
    val inertia = (x v x.crossX2(b) * Sym(0.5)) * mass

    val sq = {
      for (dx <- Seq(-1, 1);
           dy <- Seq(-2, 2);
           dz <- Seq(-4, 4);
           point = PGA3.point(Sym(dx), Sym(dy), Sym(dz));
           inertia = (point v point.crossX2(b) * Sym(0.5)))
      yield inertia
    }.reduce(_ + _).withoutZeros

    assert(
      sq == MultiVector(
        "wx" -> Sym("b.yz") * Sym((2 * 2 + 4 * 4) * 8.0),
        "wy" -> Sym("b.xz") * Sym((1 + 4 * 4) * -8.0),
        "wz" -> Sym("b.xy") * Sym((1 + 2 * 2) * 8.0),
        "xy" -> Sym("b.wz") * Sym(8.0),
        "xz" -> Sym("b.wy") * Sym(-8.0),
        "yz" -> Sym("b.wx") * Sym(8.0),
      )
    )

    val i3d = Inertia3d(8, (2 * 2 + 4 * 4) * 8.0, (1 + 4 * 4) * 8.0, (1 + 2 * 2) * 8.0).mapValues(Sym(_))

    assert(i3d.invert(i3d(b)) == b)
  }

  test("kinetic energy") {
    val i3d = Inertia3d.cube(3, 1, 1, 4)
    assert(i3d.mass == MultiVector("wx" -> 3.0, "wy" -> 3.0, "wz" -> 3.0, "xy" -> 2.0, "xz" -> 17.0, "yz" -> 17.0))

    val i3dSym = i3d.mapValues(Sym(_))
    val kineticEnergy = (b ^ i3dSym(b)) * Sym(0.5) // as pseudoScalar
    val kineticEnergyV2 = (b v i3dSym(b)) * Sym(0.5) // as scalar


    assert(kineticEnergy == MultiVector("I" -> (Sym(1.5) * (bwx * bwx + bwy * bwy + bwz * bwz) + bxy * bxy + Sym(8.5) * bxz * bxz + Sym(8.5) * byz * byz)))
    assert(kineticEnergyV2 == MultiVector("1" -> (Sym(1.5) * (bwx * bwx + bwy * bwy + bwz * bwz) + bxy * bxy + Sym(8.5) * bxz * bxz + Sym(8.5) * byz * byz)))
  }

  test("power of forque") {
    val f = Sym.multiVector("f").filter((b, _) => b.grade == 2)
    val power = b v f
    assert(power == MultiVector(
      "1" -> (bwx * f("yz") + bwz * f("xy") + bxy * f("wz") + byz * f("wx") - bwy * f("xz") - bxz * f("wy"))
    ))
  }

  test("power of linear force and linear speed") {
    val fx = Sym("fx")
    val fy = Sym("fy")
    val fz = Sym("fz")

    val f = Sym.point("p").dot(MultiVector("x" -> fx, "y" -> fy, "z" -> fz))

    val vx = Sym("vx")
    val vy = Sym("vy")
    val vz = Sym("vz")

    val bLinear = MultiVector(
      "wx" -> vx,
      "wy" -> vy,
      "wz" -> vz,
    )

    val power = bLinear v f
    assert(power == MultiVector(
      "1" -> (vx * fx + vy * fy + vz * fz)
    ))
  }


private case class Inertia3d[T](mass: MultiVector[T],
                                invertedMass: MultiVector[T]):
  def apply(b: MultiVector[T])(using num: Numeric[T]) =
    b.multiplyElementwise(mass).dual

  def invert(b: MultiVector[T])(using num: Numeric[T]) =
    b.dual.multiplyElementwise(invertedMass)

  def mapValues[U](f: T => U): Inertia3d[U] =
    Inertia3d(
      mass.mapValues(f),
      invertedMass.mapValues(f)
    )

private object Inertia3d:
  def apply(m: Double, mryz: Double, mrxz: Double, mrxy: Double)(using ga: PGA3): Inertia3d[Double] = {
    val inertia = MultiVector[Double](
      "wx" -> m,
      "wy" -> m,
      "wz" -> m,
      "yz" -> mryz,
      "xz" -> mrxz,
      "xy" -> mrxy,
    )

    Inertia3d(
      inertia,
      inertia.mapValues(d => 1.0 / d)
    )
  }

  def cube(m: Double, rx: Double, ry: Double, rz: Double)(using ga: PGA3): Inertia3d[Double] =
    val rx2 = rx * rx
    val ry2 = ry * ry
    val rz2 = rz * rz
    apply(
      m = m,
      mryz = (ry2 + rz2) * m / 3,
      mrxz = (rx2 + rz2) * m / 3,
      mrxy = (rx2 + ry2) * m / 3,
    )
