package com.github.kright.pga3d

import com.github.kright.pga3d

case class Pga3dInertia(ww: Double,
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

  def +(v: Pga3dInertia): Pga3dInertia =
    Pga3dInertia(
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

  def -(v: Pga3dInertia): Pga3dInertia =
    Pga3dInertia(
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

  def *(s: Double): Pga3dInertia =
    Pga3dInertia(
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

  override def toString: String =
    s"Pga3dInertia(ww=$ww, wx=$wx, wy=$wy, wz=$wz, xx=$xx, yy=$yy, zz=$zz, xy=$xy, yz=$yz, xz=$xz)"

  def toMatrixString: String =
    "%5.2f %5.2f %5.2f %5.2f\n%5.2f %5.2f %5.2f %5.2f\n%5.2f %5.2f %5.2f %5.2f\n%5.2f %5.2f %5.2f %5.2f"
      .format(xx, xy, xz, wx, xy, yy, yz, wy, xz, yz, zz, wz, wx, wy, wz, ww)


object Pga3dInertia:
  val zero: Pga3dInertia =
    Pga3dInertia(0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0)

  def symmetricProduct(u: Pga3dTrivector, v: Pga3dTrivector): Pga3dInertia =
    Pga3dInertia(
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
  def point(p: Pga3dPoint, mass: Double): Pga3dInertia =
    symmetricProduct(p.toTrivector, p * mass)

  private inline def sandwichImpl(b: Pga3dInertia, sandwichF: Pga3dTrivector => Pga3dTrivector): Pga3dInertia =
    val cx = sandwichF(Pga3dTrivector(b.xx, b.xy, b.xz, b.wx))
    val cy = sandwichF(Pga3dTrivector(b.xy, b.yy, b.yz, b.wy))
    val cz = sandwichF(Pga3dTrivector(b.xz, b.yz, b.zz, b.wz))
    val cw = sandwichF(Pga3dTrivector(b.wx, b.wy, b.wz, b.ww))

    val rx = sandwichF(Pga3dTrivector(cx.x, cy.x, cz.x, cw.x))
    val ry = sandwichF(Pga3dTrivector(cx.y, cy.y, cz.y, cw.y))
    val rz = sandwichF(Pga3dTrivector(cx.z, cy.z, cz.z, cw.z))
    val rw = sandwichF(Pga3dTrivector(cx.w, cy.w, cz.w, cw.w))

    Pga3dInertia(rw.w, rw.x, rw.y, rw.z, rx.x, ry.y, rz.z, rx.y, ry.z, rx.z)

  extension (motor: Pga3dMotor)
    def sandwich(b: Pga3dInertia): Pga3dInertia =
      sandwichImpl(b, motor.sandwich)
  extension (t: Pga3dTranslator)
    def sandwich(b: Pga3dInertia): Pga3dInertia =
      sandwichImpl(b, t.sandwich)
  extension (q: Pga3dQuaternion)
    def sandwich(b: Pga3dInertia): Pga3dInertia =
      sandwichImpl(b, q.sandwich)  
