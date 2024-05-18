package com.github.kright.ga

import com.github.kright.math.{DifferentialSolvers, EqualityEps}
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

    val i3d = PGA3Inertia(8, (2 * 2 + 4 * 4) * 8.0, (1 + 4 * 4) * 8.0, (1 + 2 * 2) * 8.0).mapValues(Sym(_))

    assert(i3d.invert(i3d(b)) == b)
  }

  test("kinetic energy") {
    val i3d = PGA3Inertia.cube(3, 1, 1, 4)
    assert(i3d.mass == MultiVector("wx" -> 3.0, "wy" -> 3.0, "wz" -> 3.0, "xy" -> 2.0, "xz" -> 17.0, "yz" -> 17.0))

    val i3dSym = i3d.mapValues(Sym(_))
    val kineticEnergy = (b ^ i3dSym(b)) * Sym(0.5) // as pseudoScalar
    val kineticEnergyV2 = (b v i3dSym(b)) * Sym(0.5) // as scalar


    assert(kineticEnergy == MultiVector("I" -> (Sym(1.5) * (bwx * bwx + bwy * bwy + bwz * bwz) + bxy * bxy + Sym(8.5) * bxz * bxz + Sym(8.5) * byz * byz)))
    assert(kineticEnergyV2 == MultiVector("1" -> (Sym(1.5) * (bwx * bwx + bwy * bwy + bwz * bwz) + bxy * bxy + Sym(8.5) * bxz * bxz + Sym(8.5) * byz * byz)))
  }

  test("power of forque") {
    val f = Sym.multiVector("f", grade = 2)
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

  /**
   * see https://bivector.net/PGAdyn.pdf
   *
   * I[B] = Sum(mass_i X_i v (X_i x B))
   * B' = I**{-1}[B x I[B] + F]
   * M' = -0.5 M B
   * I, B, F are in local frame, where I is diagonal matrix
   */
  test("test precession") {
    //    val i3d = Inertia3d.cube(3, 1, 1, 4).mapValues(Sym(_))
    val m = Sym("mass")
    val mryz = Sym("Ix")
    val mrxz = Sym("Iy")
    val mrxy = Sym("Iz")

    val mInv = Sym("1 / mass")
    val mryzInv = Sym("1 / Ix")
    val mrxzInv = Sym("1 / Iy")
    val mrxyInv = Sym("1 / Iz")

    val i3d = PGA3Inertia(
      MultiVector(
        "wx" -> m,
        "wy" -> m,
        "wz" -> m,
        "yz" -> mryz,
        "xz" -> mrxz,
        "xy" -> mrxy,
      ),
      MultiVector(
        "wx" -> mInv,
        "wy" -> mInv,
        "wz" -> mInv,
        "yz" -> mryzInv,
        "xz" -> mrxzInv,
        "xy" -> mrxyInv,
      ),
    )

    val forque = Sym.multiVector("f", grade = 2)
    val dB = i3d.invert(b.crossX2(i3d(b)) * Sym(0.5) + forque)

    assert(dB.toMultilineString ==
      """MultiVector(
        |"wx" -> (1 / mass * f.yz + 1 / mass * b.wy * b.xy * mass + 1 / mass * b.wz * b.xz * mass)
        |"wy" -> (-1 / mass * f.xz + 1 / mass * b.wz * b.yz * mass - 1 / mass * b.wx * b.xy * mass)
        |"wz" -> (1 / mass * f.xy - 1 / mass * b.wx * b.xz * mass - 1 / mass * b.wy * b.yz * mass)
        |"xy" -> (1 / Iz * f.wz + 1 / Iz * Iy * b.xz * b.yz - 1 / Iz * Ix * b.xz * b.yz)
        |"xz" -> (-1 / Iy * f.wy + 1 / Iy * Ix * b.xy * b.yz - 1 / Iy * Iz * b.xy * b.yz)
        |"yz" -> (1 / Ix * f.wx + 1 / Ix * Iz * b.xy * b.xz - 1 / Ix * Iy * b.xy * b.xz)
        |)""".stripMargin)
  }

  /** same as [com.github.kright.physics3d.InertiaTest] */
  test("calculate free rotation body precession") {
    val stepsCount = 10
    val dt = 0.01
    val bodyInertia = PGA3Inertia(1.0, 3.0, 2.0, 1.0)

    val initialState = PGA3State(
      MultiVector.scalar[Double](1.0),
      MultiVector[Double](
        "xy" -> 1.0,
        "yz" -> 1.0,
        "zx" -> 1.0,
      )
    )

    var state: PGA3State[Double] = initialState
    val zeroForce = MultiVector.zero[Double]

    def getEnergy() = state.getEnergy(bodyInertia)

    def getL() = state.getL(bodyInertia)

    val initialE = getEnergy()
    val initialL = getL()

    assert(initialE == 3.0)
    assert(initialL == MultiVector("wx" -> 3.0, "wy" -> 2.0, "wz" -> 1.0))

    var errorE = 0.0
    var errorL = 0.0

    def getDerivative(state: PGA3State[Double], time: Double): PGA3State[Double] =
      PGA3State(
        motor = state.motor.geometric(state.localB) * -0.5,
        localB = bodyInertia.invert(state.localB.cross(bodyInertia(state.localB)) + zeroForce)
      )

    def getNextState(state: PGA3State[Double], derivative: PGA3State[Double], dt: Double): PGA3State[Double] =
      state.madd(derivative, dt).normalized

    for (step <- 0 until stepsCount) {
      state = DifferentialSolvers.rungeKutta2(state, time = 0.0, dt,
        getDerivative = getDerivative,
        nextState = getNextState,
      )

      val currentE = getEnergy()
      val currentL = getL()

      errorE = math.max(errorE, math.abs(currentE - initialE) / initialE)
      errorL = math.max(errorL, (currentL - initialL).norm / initialL.norm)

      //      println(s"step $step, errorE = ${errorE}, errorL = ${errorL}")
    }
  }
