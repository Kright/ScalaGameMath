package com.github.kright.pga3d

import com.github.kright.matrix.{Matrix, SymmetricMatrixDiagonalization}
import com.github.kright.pga3d
import com.github.kright.pga3d.Pga3dInertiaSummable.diagonalyzeSymmetricInplace

final case class Pga3dInertiaSummable(ww: Double,
                                      wx: Double,
                                      wy: Double,
                                      wz: Double,
                                      xx: Double,
                                      yy: Double,
                                      zz: Double,
                                      xy: Double,
                                      yz: Double,
                                      xz: Double):

  def mass: Double =
    ww

  def centerOfMass: Pga3dPoint =
    val inv = 1.0 / mass
    Pga3dPoint(wx * inv, wy * inv, wz * inv)

  def centerOfMassTrivector: Pga3dTrivector =
    Pga3dTrivector(wx, wy, wz, ww)

  def +(v: Pga3dInertiaSummable): Pga3dInertiaSummable =
    Pga3dInertiaSummable(
      ww = v.ww + ww,
      wx = v.wx + wx,
      wy = v.wy + wy,
      wz = v.wz + wz,
      xx = v.xx + xx,
      yy = v.yy + yy,
      zz = v.zz + zz,
      xy = v.xy + xy,
      yz = v.yz + yz,
      xz = v.xz + xz
    )

  def -(v: Pga3dInertiaSummable): Pga3dInertiaSummable =
    Pga3dInertiaSummable(
      ww = ww - v.ww,
      wx = wx - v.wx,
      wy = wy - v.wy,
      wz = wz - v.wz,
      xx = xx - v.xx,
      yy = yy - v.yy,
      zz = zz - v.zz,
      xy = xy - v.xy,
      yz = yz - v.yz,
      xz = xz - v.xz
    )

  def *(s: Double): Pga3dInertiaSummable =
    Pga3dInertiaSummable(
      ww = ww * s,
      wx = wx * s,
      wy = wy * s,
      wz = wz * s,
      xx = xx * s,
      yy = yy * s,
      zz = zz * s,
      xy = xy * s,
      yz = yz * s,
      xz = xz * s,
    )

  def normSquare: Double =
    ww * ww +
      wx * wx +
      wy * wy +
      wz * wz +
      xx * xx +
      yy * yy +
      zz * zz +
      xy * xy +
      yz * yz +
      xz * xz

  def norm: Double =
    Math.sqrt(normSquare)

  def apply(localB: Pga3dBivector): Pga3dBivector = {
    val wx2 = wx * wx
    val wy2 = wy * wy
    val wz2 = wz * wz
    val invMass = 1.0 / ww

    val b = localB

    Pga3dBivector(
      wx = +(yy + zz - (wy2 + wz2) * invMass) * b.yz + xy * b.xz - xz * b.xy - wz * b.wy + wy * b.wz,
      wy = -xy * b.yz - (xx + zz - (wx2 + wz2) * invMass) * b.xz + yz * b.xy - wx * b.wz + wz * b.wx,
      wz = +xz * b.yz - yz * b.xz + (xx + yy - (wx2 + wy2) * invMass) * b.xy + wx * b.wy - wy * b.wx,
      xy = ww * b.wz,
      xz = -ww * b.wy,
      yz = ww * b.wx,
    )
  }

  def invert(localInertia: Pga3dBivector): Pga3dBivector = {
    val invMass = 1.0 / ww

    val bwx = localInertia.yz * invMass
    val bwy = -localInertia.xz * invMass
    val bwz = localInertia.xy * invMass

    Pga3dBivector(
      wx = bwx,
      wy = bwy,
      wz = bwz,
      xy = ???,
      xz = ???,
      yz = ???,
    )
  }

  def toInertia(): Pga3dInertia =
    val shift = centerOfMass.toVectorUnsafe

    val shifted = Pga3dTranslator.addVector(-shift).sandwich(this)
    val i = shifted.toMatrixXYZ
    val quaternion = diagonalyzeSymmetricInplace(i)
    val ixx = i(0, 0)
    val iyy = i(1, 1)
    val izz = i(2, 2)

    Pga3dInertia(
      localToGlobal = Pga3dTranslator.addVector(shift).geometric(quaternion),
      localInertia = Pga3dInertiaLocal(mass, iyy + izz, ixx + izz, ixx + iyy)
    )

  // todo rename and dualize
  def actOnBivectorAsInertia(a: Pga3dBivector): Pga3dBivector = {
    val wx2 = wx * wx
    val wy2 = wy * wy
    val wz2 = wz * wz
    val invMass = 1.0 / ww

    Pga3dBivector(
      wx = +(yy + zz - (wy2 + wz2) * invMass) * a.wx - xy * a.wy - xz * a.wz + wz * a.xz + wy * a.xy,
      wy = -xy * a.wx + (xx + zz - (wx2 + wz2) * invMass) * a.wy + yz * a.wz - wx * a.xy + wz * a.yz,
      wz = +xz * a.wx + yz * a.wy + (xx + yy - (wx2 + wy2) * invMass) * a.wz - wx * a.xz - wy * a.yz,
      xy = ww * a.xy,
      xz = ww * a.xz,
      yz = ww * a.yz,
    )
  }

  // todo rename
  def actOnBivectorAsInertia2(b: Pga3dBivector): Pga3dBivector = {
    val translator = Pga3dTranslator.addVector(-centerOfMass.toVectorUnsafe)
    translator.reverseSandwich(translator.sandwich(this).actOnBivectorAsInertia(translator.sandwich(b)))
  }

  def withXYZ(m: Matrix): Pga3dInertiaSummable = {
    copy(
      xx = m(0, 0),
      xy = m(0, 1),
      xz = m(0, 2),
      yy = m(1, 1),
      yz = m(1, 2),
      zz = m(2, 2),
    )
  }

  def toMatrixXYZ: Matrix = {
    val m = new Matrix(3, 3)
    m(0, 0) = xx
    m(0, 1) = xy
    m(0, 2) = xz
    m(1, 0) = xy
    m(1, 1) = yy
    m(1, 2) = yz
    m(2, 0) = xz
    m(2, 1) = yz
    m(2, 2) = zz
    m
  }

  def toMatrixXYZW: Matrix = {
    val m = new Matrix(4, 4)
    m(0, 0) = xx
    m(0, 1) = xy
    m(0, 2) = xz
    m(0, 3) = wx

    m(1, 0) = xy
    m(1, 1) = yy
    m(1, 2) = yz
    m(1, 3) = wy

    m(2, 0) = xz
    m(2, 1) = yz
    m(2, 2) = zz
    m(2, 3) = wz

    m(3, 0) = wx
    m(3, 1) = wy
    m(3, 2) = wz
    m(3, 3) = ww

    m
  }

  override def toString: String =
    s"Pga3dInertia(ww=$ww, wx=$wx, wy=$wy, wz=$wz, xx=$xx, yy=$yy, zz=$zz, xy=$xy, yz=$yz, xz=$xz)"

  def toMatrixString: String =
    "%5.2f %5.2f %5.2f %5.2f\n%5.2f %5.2f %5.2f %5.2f\n%5.2f %5.2f %5.2f %5.2f\n%5.2f %5.2f %5.2f %5.2f"
      .format(xx, xy, xz, wx, xy, yy, yz, wy, xz, yz, zz, wz, wx, wy, wz, ww)


object Pga3dInertiaSummable:
  val zero: Pga3dInertiaSummable =
    Pga3dInertiaSummable(0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0)

  def symmetricProduct(u: Pga3dTrivector, v: Pga3dTrivector): Pga3dInertiaSummable =
    Pga3dInertiaSummable(
      (u.w * v.w + v.w * u.w) * 0.5,
      (u.w * v.x + v.w * u.x) * 0.5,
      (u.w * v.y + v.w * u.y) * 0.5,
      (u.w * v.z + v.w * u.z) * 0.5,
      (u.x * v.x + v.x * u.x) * 0.5,
      (u.y * v.y + v.y * u.y) * 0.5,
      (u.z * v.z + v.z * u.z) * 0.5,
      (u.x * v.y + v.x * u.y) * 0.5,
      (u.y * v.z + v.y * u.z) * 0.5,
      (u.x * v.z + v.x * u.z) * 0.5,
    )

  // inertia of a mass in a point
  def point(p: Pga3dPoint, mass: Double): Pga3dInertiaSummable =
    symmetricProduct(p.toTrivector, p * mass)

  private inline def sandwichImpl(b: Pga3dInertiaSummable, sandwichF: Pga3dTrivector => Pga3dTrivector): Pga3dInertiaSummable =
    val cx = sandwichF(Pga3dTrivector(b.xx, b.xy, b.xz, b.wx))
    val cy = sandwichF(Pga3dTrivector(b.xy, b.yy, b.yz, b.wy))
    val cz = sandwichF(Pga3dTrivector(b.xz, b.yz, b.zz, b.wz))
    val cw = sandwichF(Pga3dTrivector(b.wx, b.wy, b.wz, b.ww))

    val rx = sandwichF(Pga3dTrivector(cx.x, cy.x, cz.x, cw.x))
    val ry = sandwichF(Pga3dTrivector(cx.y, cy.y, cz.y, cw.y))
    val rz = sandwichF(Pga3dTrivector(cx.z, cy.z, cz.z, cw.z))
    val rw = sandwichF(Pga3dTrivector(cx.w, cy.w, cz.w, cw.w))

    Pga3dInertiaSummable(rw.w, rw.x, rw.y, rw.z, rx.x, ry.y, rz.z, rx.y, ry.z, rx.z)

  extension (motor: Pga3dMotor)
    def sandwich(b: Pga3dInertiaSummable): Pga3dInertiaSummable =
      sandwichImpl(b, motor.sandwich)

  extension (t: Pga3dTranslator)
    def sandwich(b: Pga3dInertiaSummable): Pga3dInertiaSummable =
      sandwichImpl(b, t.sandwich)

  extension (q: Pga3dQuaternion)
    def sandwich(b: Pga3dInertiaSummable): Pga3dInertiaSummable =
      sandwichImpl(b, q.sandwich)

  private val planesByAxis = Seq(
    Pga3dPlaneIdeal(1, 0, 0),
    Pga3dPlaneIdeal(0, 1, 0),
    Pga3dPlaneIdeal(0, 0, 1),
  )

  private def diagonalyzeSymmetricInplace(i: Matrix): Pga3dQuaternion = {
    var quaternion = Pga3dQuaternion.id

    while (true) {
      val (p, q) = SymmetricMatrixDiagonalization.findBiggestOffDiagonalElementByAbs(i)
      if (Math.abs(i(p, q)) < 1e-10) {
        return quaternion
      }
      val (sin, cos) = SymmetricMatrixDiagonalization.findSinCosAtan(i(p, p), i(p, q), i(q, q))
      SymmetricMatrixDiagonalization.sandwichRotSymmetricMatrix(i, p, q, sin, cos)

      val planeP = planesByAxis(p)
      val planeQ = planesByAxis(q)
      val dq = Pga3dQuaternion.rotation(planeP, planeP * cos + planeQ * sin)
      quaternion = quaternion.geometric(dq)
    }

    quaternion
  }
