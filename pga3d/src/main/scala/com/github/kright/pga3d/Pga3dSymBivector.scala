package com.github.kright.pga3d

import com.github.kright.pga3d

/**
 * symmetric product of projective vectors
 * represents inertia of body
 */
case class Pga3dSymBivector(ww: Double,
                            wx: Double,
                            wy: Double,
                            wz: Double,
                            xx: Double,
                            yy: Double,
                            zz: Double,
                            xy: Double,
                            yz: Double,
                            xz: Double):

  def this(u: Pga3dTrivector, v: Pga3dTrivector) =
    this(
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
  def this(p: Pga3dPoint, m: Double) =
    this(p.toTrivector, p * m)

  def +(v: Pga3dSymBivector): Pga3dSymBivector =
    Pga3dSymBivector(
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

  def -(v: Pga3dSymBivector): Pga3dSymBivector =
    Pga3dSymBivector(
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

  def *(s: Double): Pga3dSymBivector =
    Pga3dSymBivector(
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

  def centerOfMass: Pga3dTrivector =
    Pga3dTrivector(wx, wy, wz, ww)

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

  /**
   *
   * @param a
   * @return
   */
  def actOnBivectorAsInertia(a: Pga3dBivector): Pga3dBivector = {
    Pga3dBivector(
      wx = + (yy + zz - wy * wy / ww - wz * wz / ww) * a.wx - xy * a.wy - xz * a.wz + wz * a.xz + wy * a.xy,
      wy = - xy * a.wx + (xx + zz - wx * wx / ww - wz * wz / ww) * a.wy + yz * a.wz - wx * a.xy + wz * a.yz,
      wz = + xz * a.wx + yz * a.wy + (xx + yy - wx * wx / ww - wy * wy / ww) * a.wz - wx * a.xz - wy * a.yz,
      xy = ww * a.xy,
      xz = ww * a.xz,
      yz = ww * a.yz,
    )
  }

  def actOnBivectorAsInertia2(b: Pga3dBivector): Pga3dBivector = {
    val translator = Pga3dTranslator.addVector(-centerOfMass.toPoint.toVectorUnsafe)
    translator.reverseSandwich(translator.sandwich(this).actOnBivectorAsInertia(translator.sandwich(b)))
  }

  def str: String =
    s"""Pga3dSymBivector(ww = $ww,
       |                 wx = $wx, wy = $wy, wz = $wz,
       |                 xx = $xx, yy = $yy, zz = $zz,
       |                 xy = $xy, xz = $xz, yz = $yz)""".stripMargin

  def strMatrix: String =
    "%5.2f %5.2f %5.2f %5.2f\n%5.2f %5.2f %5.2f %5.2f\n%5.2f %5.2f %5.2f %5.2f\n%5.2f %5.2f %5.2f %5.2f"
      .format(xx, xy, xz, wx, xy, yy, yz, wy, xz, yz, zz, wz, wx, wy, wz, ww)


object Pga3dSymBivector:
  val zero: Pga3dSymBivector =
    Pga3dSymBivector(0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0)

  private inline def sandwichImpl(b: Pga3dSymBivector, sandwichF: Pga3dTrivector => Pga3dTrivector): Pga3dSymBivector =
    val cx = sandwichF(Pga3dTrivector(b.xx, b.xy, b.xz, b.wx))
    val cy = sandwichF(Pga3dTrivector(b.xy, b.yy, b.yz, b.wy))
    val cz = sandwichF(Pga3dTrivector(b.xz, b.yz, b.zz, b.wz))
    val cw = sandwichF(Pga3dTrivector(b.wx, b.wy, b.wz, b.ww))

    val rx = sandwichF(Pga3dTrivector(cx.x, cy.x, cz.x, cw.x))
    val ry = sandwichF(Pga3dTrivector(cx.y, cy.y, cz.y, cw.y))
    val rz = sandwichF(Pga3dTrivector(cx.z, cy.z, cz.z, cw.z))
    val rw = sandwichF(Pga3dTrivector(cx.w, cy.w, cz.w, cw.w))

    Pga3dSymBivector(rw.w, rw.x, rw.y, rw.z, rx.x, ry.y, rz.z, rx.y, ry.z, rx.z)


  extension (motor: Pga3dMotor)
    def sandwich(b: Pga3dSymBivector): Pga3dSymBivector =
      sandwichImpl(b, motor.sandwich)

  extension (t: Pga3dTranslator)
    def sandwich(b: Pga3dSymBivector): Pga3dSymBivector =
      sandwichImpl(b, t.sandwich)

  extension (q: Pga3dQuaternion)
    def sandwich(b: Pga3dSymBivector): Pga3dSymBivector =
      sandwichImpl(b, q.sandwich)