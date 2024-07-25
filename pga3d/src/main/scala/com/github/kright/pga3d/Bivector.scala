package com.github.kright.pga3d

/** this code is generated, see com.github.kright.pga3d.codegen.CodeGenClass */
case class Bivector(wx: Double = 0.0,
                    wy: Double = 0.0,
                    wz: Double = 0.0,
                    xy: Double = 0.0,
                    xz: Double = 0.0,
                    yz: Double = 0.0):

  def dual: Bivector =
    Bivector(
      wx = yz,
      wy = -xz,
      wz = xy,
      xy = wz,
      xz = -wy,
      yz = wx,
    )

  def weight: BivectorWeight =
    BivectorWeight(
      wx = wx,
      wy = wy,
      wz = wz,
    )

  def bulk: BivectorBulk =
    BivectorBulk(
      xy = xy,
      xz = xz,
      yz = yz,
    )

  def unary_- : Bivector =
    Bivector(
      wx = -wx,
      wy = -wy,
      wz = -wz,
      xy = -xy,
      xz = -xz,
      yz = -yz,
    )

  def reverse: Bivector =
    -this

  def antiReverse: Bivector =
    -this

  def bulkNormSquare: Double =
    (xy * xy + xz * xz + yz * yz)

  def bulkNorm: Double =
    Math.sqrt(bulkNormSquare)

  def normalizedByBulk =
    this / bulkNorm

  def weightNormSquare: Double =
    (wx * wx + wy * wy + wz * wz)

  def weightNorm: Double =
    Math.sqrt(weightNormSquare)

  def normalizedByWeight =
    this / weightNorm

  def normSquare: Double =
    (wx * wx + wy * wy + wz * wz + xy * xy + xz * xz + yz * yz)

  def norm: Double =
    Math.sqrt(normSquare)

  def normalizedByNorm =
    this / norm

  def *(v: Double): Bivector =
    Bivector(
      wx = v * wx,
      wy = v * wy,
      wz = v * wz,
      xy = v * xy,
      xz = v * xz,
      yz = v * yz,
    )

  inline def /(v: Double): Bivector =
    this * (1.0 / v)

  def +(v: Bivector): Bivector =
    Bivector(
      wx = (v.wx + wx),
      wy = (v.wy + wy),
      wz = (v.wz + wz),
      xy = (v.xy + xy),
      xz = (v.xz + xz),
      yz = (v.yz + yz),
    )

  def -(v: Bivector): Bivector =
    Bivector(
      wx = (wx - v.wx),
      wy = (wy - v.wy),
      wz = (wz - v.wz),
      xy = (xy - v.xy),
      xz = (xz - v.xz),
      yz = (yz - v.yz),
    )

  def madd(v: Bivector, mult: Double): Bivector =
    Bivector(
      wx = (wx + mult * v.wx),
      wy = (wy + mult * v.wy),
      wz = (wz + mult * v.wz),
      xy = (xy + mult * v.xy),
      xz = (xz + mult * v.xz),
      yz = (yz + mult * v.yz),
    )

  def +(v: BivectorBulk): Bivector =
    Bivector(
      wx = wx,
      wy = wy,
      wz = wz,
      xy = (v.xy + xy),
      xz = (v.xz + xz),
      yz = (v.yz + yz),
    )

  def -(v: BivectorBulk): Bivector =
    Bivector(
      wx = wx,
      wy = wy,
      wz = wz,
      xy = (xy - v.xy),
      xz = (xz - v.xz),
      yz = (yz - v.yz),
    )

  def madd(v: BivectorBulk, mult: Double): Bivector =
    Bivector(
      wx = wx,
      wy = wy,
      wz = wz,
      xy = (xy + mult * v.xy),
      xz = (xz + mult * v.xz),
      yz = (yz + mult * v.yz),
    )

  def +(v: BivectorWeight): Bivector =
    Bivector(
      wx = (v.wx + wx),
      wy = (v.wy + wy),
      wz = (v.wz + wz),
      xy = xy,
      xz = xz,
      yz = yz,
    )

  def -(v: BivectorWeight): Bivector =
    Bivector(
      wx = (wx - v.wx),
      wy = (wy - v.wy),
      wz = (wz - v.wz),
      xy = xy,
      xz = xz,
      yz = yz,
    )

  def madd(v: BivectorWeight, mult: Double): Bivector =
    Bivector(
      wx = (wx + mult * v.wx),
      wy = (wy + mult * v.wy),
      wz = (wz + mult * v.wz),
      xy = xy,
      xz = xz,
      yz = yz,
    )

  def multiplyElementwise(v: Bivector): Bivector =
    Bivector(
      wx = v.wx * wx,
      wy = v.wy * wy,
      wz = v.wz * wz,
      xy = v.xy * xy,
      xz = v.xz * xz,
      yz = v.yz * yz,
    )

  def exp(): Motor =
    val len = bulkNorm
    val cos = Math.cos(len)

    val sinDivLen = if (len > 1e-5) {
      Math.sin(len) / len
    } else 1.0 - (len * len) / 6.0

    val sinMinusCosDivLen2 = if (len > 1e-5) {
      (sinDivLen - cos) / (len * len)
    } else (1.0 / 3.0) * (1.0 + 0.8 * len * len)

    Motor(
      s = cos,
      wx = (sinDivLen * wx + sinMinusCosDivLen2 * yz * (wy * xz - wx * yz - wz * xy)),
      wy = (sinDivLen * wy + sinMinusCosDivLen2 * xz * (wx * yz + wz * xy - wy * xz)),
      wz = (sinDivLen * wz + sinMinusCosDivLen2 * xy * (wy * xz - wx * yz - wz * xy)),
      xy = sinDivLen * xy,
      xz = sinDivLen * xz,
      yz = sinDivLen * yz,
      i = sinDivLen * (wx * yz + wz * xy - wy * xz),
    )

  def exp(t: Double): Motor =
    val len = bulkNorm * Math.abs(t)
    val cos = Math.cos(len)

    val sinDivLen = if (len > 1e-5) {
      Math.sin(len) / len
    } else 1.0 - (len * len) / 6.0

    val sinMinusCosDivLen2 = if (len > 1e-5) {
      (sinDivLen - cos) / (len * len)
    } else (1.0 / 3.0) * (1.0 + 0.8 * len * len)

    Motor(
      s = cos,
      wx = t * (sinDivLen * wx + sinMinusCosDivLen2 * t * t * yz * (wy * xz - wx * yz - wz * xy)),
      wy = t * (sinDivLen * wy + sinMinusCosDivLen2 * t * t * xz * (wx * yz + wz * xy - wy * xz)),
      wz = t * (sinDivLen * wz + sinMinusCosDivLen2 * t * t * xy * (wy * xz - wx * yz - wz * xy)),
      xy = sinDivLen * t * xy,
      xz = sinDivLen * t * xz,
      yz = sinDivLen * t * yz,
      i = sinDivLen * t * t * (wx * yz + wz * xy - wy * xz),
    )

  def split(): (Bivector, BivectorWeight) =
    val div = bulkNormSquare
    if (div < 1e-100) {
      return (Bivector(0.0, 0.0, 0.0, xy, xz, yz), BivectorWeight(wx, wy, wz))
    }

    // val shiftAlongLine = this.geometric((this ^ this.reverse) / div / 2.0)
    // pseudoScalar = this ^ this.reverse

    val pseudoScalar = (wy * xz - wx * yz - wz * xy) / div
    val shiftAlongLine = BivectorWeight(
      wx = -pseudoScalar * yz,
      wy = pseudoScalar * xz,
      wz = -pseudoScalar * xy,
    )

    val line = this - shiftAlongLine
    (line, shiftAlongLine)

  def toMultivector: Multivector =
    Multivector(
      s = 0.0,
      w = 0.0,
      x = 0.0,
      y = 0.0,
      z = 0.0,
      wx = wx,
      wy = wy,
      wz = wz,
      xy = xy,
      xz = xz,
      yz = yz,
      wxy = 0.0,
      wxz = 0.0,
      wyz = 0.0,
      xyz = 0.0,
      i = 0.0,
    )

  def toMotor: Motor =
    Motor(
      s = 0.0,
      wx = wx,
      wy = wy,
      wz = wz,
      xy = xy,
      xz = xz,
      yz = yz,
      i = 0.0,
    )

  def asQuaternionUnsafe: Quaternion =
    Quaternion(
      s = 0.0,
      xy = xy,
      xz = xz,
      yz = yz,
    )

  def asTranslatorUnsafe: Translator =
    Translator(
      wx = wx,
      wy = wy,
      wz = wz,
    )

  def asBivectorBulkUnsafe: BivectorBulk =
    BivectorBulk(
      xy = xy,
      xz = xz,
      yz = yz,
    )

  def asBivectorWeightUnsafe: BivectorWeight =
    BivectorWeight(
      wx = wx,
      wy = wy,
      wz = wz,
    )

  /** fused plane.dot(line).geometric(plane) */
  def projectOntoPlane(plane: Plane): Bivector =
    Bivector(
      wx = (plane.w * (-plane.y * xy - plane.z * xz) + plane.x * (plane.x * wx + plane.y * wy + plane.z * wz)),
      wy = (plane.w * (plane.x * xy - plane.z * yz) + plane.y * (plane.x * wx + plane.y * wy + plane.z * wz)),
      wz = (plane.w * (plane.x * xz + plane.y * yz) + plane.z * (plane.x * wx + plane.y * wy + plane.z * wz)),
      xy = (plane.x * (plane.x * xy - plane.z * yz) + plane.y * (plane.y * xy + plane.z * xz)),
      xz = (plane.x * (plane.x * xz + plane.y * yz) + plane.z * (plane.y * xy + plane.z * xz)),
      yz = (plane.x * (plane.y * xz - plane.z * xy) + yz * (plane.y * plane.y + plane.z * plane.z)),
    )

  /** fused plane.dot(line).geometric(plane) */
  def projectOntoPlane(plane: PlaneIdeal): Bivector =
    Bivector(
      wx = plane.x * (plane.x * wx + plane.y * wy + plane.z * wz),
      wy = plane.y * (plane.x * wx + plane.y * wy + plane.z * wz),
      wz = plane.z * (plane.x * wx + plane.y * wy + plane.z * wz),
      xy = (plane.x * (plane.x * xy - plane.z * yz) + plane.y * (plane.y * xy + plane.z * xz)),
      xz = (plane.x * (plane.x * xz + plane.y * yz) + plane.z * (plane.y * xy + plane.z * xz)),
      yz = (plane.x * (plane.y * xz - plane.z * xy) + yz * (plane.y * plane.y + plane.z * plane.z)),
    )

  infix def geometric(v: Multivector): Multivector =
    Multivector(
      s = (-v.xy * xy - v.xz * xz - v.yz * yz),
      w = (v.x * wx + v.y * wy + v.z * wz - v.wxy * xy - v.wxz * xz - v.wyz * yz),
      x = (v.y * xy + v.z * xz - v.xyz * yz),
      y = (v.xyz * xz + v.z * yz - v.x * xy),
      z = (-v.x * xz - v.xyz * xy - v.y * yz),
      wx = (v.s * wx + v.wy * xy + v.wz * xz - v.i * yz - v.xy * wy - v.xz * wz),
      wy = (v.i * xz + v.s * wy + v.wz * yz + v.xy * wx - v.wx * xy - v.yz * wz),
      wz = (v.s * wz + v.xz * wx + v.yz * wy - v.i * xy - v.wx * xz - v.wy * yz),
      xy = (v.s * xy + v.xz * yz - v.yz * xz),
      xz = (v.s * xz + v.yz * xy - v.xy * yz),
      yz = (v.s * yz + v.xy * xz - v.xz * xy),
      wxy = (v.w * xy + v.wxz * yz + v.xyz * wz + v.y * wx - v.wyz * xz - v.x * wy),
      wxz = (v.w * xz + v.wyz * xy + v.z * wx - v.wxy * yz - v.x * wz - v.xyz * wy),
      wyz = (v.w * yz + v.wxy * xz + v.xyz * wx + v.z * wy - v.wxz * xy - v.y * wz),
      xyz = (v.x * yz + v.z * xy - v.y * xz),
      i = (v.wx * yz + v.wz * xy + v.xy * wz + v.yz * wx - v.wy * xz - v.xz * wy),
    )

  infix def geometric(v: Motor): Motor =
    Motor(
      s = (-v.xy * xy - v.xz * xz - v.yz * yz),
      wx = (v.s * wx + v.wy * xy + v.wz * xz - v.i * yz - v.xy * wy - v.xz * wz),
      wy = (v.i * xz + v.s * wy + v.wz * yz + v.xy * wx - v.wx * xy - v.yz * wz),
      wz = (v.s * wz + v.xz * wx + v.yz * wy - v.i * xy - v.wx * xz - v.wy * yz),
      xy = (v.s * xy + v.xz * yz - v.yz * xz),
      xz = (v.s * xz + v.yz * xy - v.xy * yz),
      yz = (v.s * yz + v.xy * xz - v.xz * xy),
      i = (v.wx * yz + v.wz * xy + v.xy * wz + v.yz * wx - v.wy * xz - v.xz * wy),
    )

  infix def geometric(v: Plane): Multivector =
    Multivector(
      s = 0.0,
      w = (v.x * wx + v.y * wy + v.z * wz),
      x = (v.y * xy + v.z * xz),
      y = (v.z * yz - v.x * xy),
      z = (-v.x * xz - v.y * yz),
      wx = 0.0,
      wy = 0.0,
      wz = 0.0,
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
      wxy = (v.w * xy + v.y * wx - v.x * wy),
      wxz = (v.w * xz + v.z * wx - v.x * wz),
      wyz = (v.w * yz + v.z * wy - v.y * wz),
      xyz = (v.x * yz + v.z * xy - v.y * xz),
      i = 0.0,
    )

  infix def geometric(v: Bivector): Motor =
    Motor(
      s = (-v.xy * xy - v.xz * xz - v.yz * yz),
      wx = (v.wy * xy + v.wz * xz - v.xy * wy - v.xz * wz),
      wy = (v.wz * yz + v.xy * wx - v.wx * xy - v.yz * wz),
      wz = (v.xz * wx + v.yz * wy - v.wx * xz - v.wy * yz),
      xy = (v.xz * yz - v.yz * xz),
      xz = (v.yz * xy - v.xy * yz),
      yz = (v.xy * xz - v.xz * xy),
      i = (v.wx * yz + v.wz * xy + v.xy * wz + v.yz * wx - v.wy * xz - v.xz * wy),
    )

  infix def geometric(v: Point): Multivector =
    Multivector(
      s = 0.0,
      w = (-v.wxy * xy - v.wxz * xz - v.wyz * yz),
      x = -v.xyz * yz,
      y = v.xyz * xz,
      z = -v.xyz * xy,
      wx = 0.0,
      wy = 0.0,
      wz = 0.0,
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
      wxy = (v.wxz * yz + v.xyz * wz - v.wyz * xz),
      wxz = (v.wyz * xy - v.wxy * yz - v.xyz * wy),
      wyz = (v.wxy * xz + v.xyz * wx - v.wxz * xy),
      xyz = 0.0,
      i = 0.0,
    )

  infix def geometric(v: Quaternion): Motor =
    Motor(
      s = (-v.xy * xy - v.xz * xz - v.yz * yz),
      wx = (v.s * wx - v.xy * wy - v.xz * wz),
      wy = (v.s * wy + v.xy * wx - v.yz * wz),
      wz = (v.s * wz + v.xz * wx + v.yz * wy),
      xy = (v.s * xy + v.xz * yz - v.yz * xz),
      xz = (v.s * xz + v.yz * xy - v.xy * yz),
      yz = (v.s * yz + v.xy * xz - v.xz * xy),
      i = (v.xy * wz + v.yz * wx - v.xz * wy),
    )

  infix def geometric(v: Translator): Motor =
    Motor(
      s = 0.0,
      wx = (wx + v.wy * xy + v.wz * xz),
      wy = (wy + v.wz * yz - v.wx * xy),
      wz = (wz - v.wx * xz - v.wy * yz),
      xy = xy,
      xz = xz,
      yz = yz,
      i = (v.wx * yz + v.wz * xy - v.wy * xz),
    )

  infix def geometric(v: Vector): Multivector =
    Multivector(
      s = 0.0,
      w = (-v.wxy * xy - v.wxz * xz - v.wyz * yz),
      x = 0.0,
      y = 0.0,
      z = 0.0,
      wx = 0.0,
      wy = 0.0,
      wz = 0.0,
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
      wxy = (v.wxz * yz - v.wyz * xz),
      wxz = (v.wyz * xy - v.wxy * yz),
      wyz = (v.wxy * xz - v.wxz * xy),
      xyz = 0.0,
      i = 0.0,
    )

  infix def geometric(v: PointNormalized): Multivector =
    Multivector(
      s = 0.0,
      w = (-v.wxy * xy - v.wxz * xz - v.wyz * yz),
      x = -yz,
      y = xz,
      z = -xy,
      wx = 0.0,
      wy = 0.0,
      wz = 0.0,
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
      wxy = (wz + v.wxz * yz - v.wyz * xz),
      wxz = (-wy + v.wyz * xy - v.wxy * yz),
      wyz = (wx + v.wxy * xz - v.wxz * xy),
      xyz = 0.0,
      i = 0.0,
    )

  infix def geometric(v: PlaneIdeal): Multivector =
    Multivector(
      s = 0.0,
      w = (v.x * wx + v.y * wy + v.z * wz),
      x = (v.y * xy + v.z * xz),
      y = (v.z * yz - v.x * xy),
      z = (-v.x * xz - v.y * yz),
      wx = 0.0,
      wy = 0.0,
      wz = 0.0,
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
      wxy = (v.y * wx - v.x * wy),
      wxz = (v.z * wx - v.x * wz),
      wyz = (v.z * wy - v.y * wz),
      xyz = (v.x * yz + v.z * xy - v.y * xz),
      i = 0.0,
    )

  infix def geometric(v: BivectorBulk): Motor =
    Motor(
      s = (-v.xy * xy - v.xz * xz - v.yz * yz),
      wx = (-v.xy * wy - v.xz * wz),
      wy = (v.xy * wx - v.yz * wz),
      wz = (v.xz * wx + v.yz * wy),
      xy = (v.xz * yz - v.yz * xz),
      xz = (v.yz * xy - v.xy * yz),
      yz = (v.xy * xz - v.xz * xy),
      i = (v.xy * wz + v.yz * wx - v.xz * wy),
    )

  infix def geometric(v: BivectorWeight): Motor =
    Motor(
      s = 0.0,
      wx = (v.wy * xy + v.wz * xz),
      wy = (v.wz * yz - v.wx * xy),
      wz = (-v.wx * xz - v.wy * yz),
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
      i = (v.wx * yz + v.wz * xy - v.wy * xz),
    )

  infix def geometric(v: PseudoScalar): BivectorWeight =
    BivectorWeight(
      wx = -v.i * yz,
      wy = v.i * xz,
      wz = -v.i * xy,
    )

  infix def geometric(v: PointCenter.type): Multivector =
    Multivector(
      s = 0.0,
      w = 0.0,
      x = -yz,
      y = xz,
      z = -xy,
      wx = 0.0,
      wy = 0.0,
      wz = 0.0,
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
      wxy = wz,
      wxz = -wy,
      wyz = wx,
      xyz = 0.0,
      i = 0.0,
    )

  infix def dot(v: Multivector): Multivector =
    Multivector(
      s = (-v.xy * xy - v.xz * xz - v.yz * yz),
      w = (v.x * wx + v.y * wy + v.z * wz - v.wxy * xy - v.wxz * xz - v.wyz * yz),
      x = (v.y * xy + v.z * xz - v.xyz * yz),
      y = (v.xyz * xz + v.z * yz - v.x * xy),
      z = (-v.x * xz - v.xyz * xy - v.y * yz),
      wx = (v.s * wx - v.i * yz),
      wy = (v.i * xz + v.s * wy),
      wz = (v.s * wz - v.i * xy),
      xy = v.s * xy,
      xz = v.s * xz,
      yz = v.s * yz,
      wxy = 0.0,
      wxz = 0.0,
      wyz = 0.0,
      xyz = 0.0,
      i = 0.0,
    )

  infix def dot(v: Motor): Motor =
    Motor(
      s = (-v.xy * xy - v.xz * xz - v.yz * yz),
      wx = (v.s * wx - v.i * yz),
      wy = (v.i * xz + v.s * wy),
      wz = (v.s * wz - v.i * xy),
      xy = v.s * xy,
      xz = v.s * xz,
      yz = v.s * yz,
      i = 0.0,
    )

  infix def dot(v: Plane): Plane =
    Plane(
      w = (v.x * wx + v.y * wy + v.z * wz),
      x = (v.y * xy + v.z * xz),
      y = (v.z * yz - v.x * xy),
      z = (-v.x * xz - v.y * yz),
    )

  infix def dot(v: Bivector): Double =
    (-v.xy * xy - v.xz * xz - v.yz * yz)

  infix def dot(v: Point): Plane =
    Plane(
      w = (-v.wxy * xy - v.wxz * xz - v.wyz * yz),
      x = -v.xyz * yz,
      y = v.xyz * xz,
      z = -v.xyz * xy,
    )

  infix def dot(v: Quaternion): Motor =
    Motor(
      s = (-v.xy * xy - v.xz * xz - v.yz * yz),
      wx = v.s * wx,
      wy = v.s * wy,
      wz = v.s * wz,
      xy = v.s * xy,
      xz = v.s * xz,
      yz = v.s * yz,
      i = 0.0,
    )

  infix def dot(v: Translator): Bivector =
    this

  infix def dot(v: Vector): Plane =
    Plane(
      w = (-v.wxy * xy - v.wxz * xz - v.wyz * yz),
      x = 0.0,
      y = 0.0,
      z = 0.0,
    )

  infix def dot(v: PointNormalized): Plane =
    Plane(
      w = (-v.wxy * xy - v.wxz * xz - v.wyz * yz),
      x = -yz,
      y = xz,
      z = -xy,
    )

  infix def dot(v: PlaneIdeal): Plane =
    Plane(
      w = (v.x * wx + v.y * wy + v.z * wz),
      x = (v.y * xy + v.z * xz),
      y = (v.z * yz - v.x * xy),
      z = (-v.x * xz - v.y * yz),
    )

  infix def dot(v: BivectorBulk): Double =
    (-v.xy * xy - v.xz * xz - v.yz * yz)

  infix def dot(v: PseudoScalar): BivectorWeight =
    BivectorWeight(
      wx = -v.i * yz,
      wy = v.i * xz,
      wz = -v.i * xy,
    )

  infix def dot(v: PointCenter.type): PlaneIdeal =
    PlaneIdeal(
      x = -yz,
      y = xz,
      z = -xy,
    )

  infix def wedge(v: Multivector): Multivector =
    Multivector(
      s = 0.0,
      w = 0.0,
      x = 0.0,
      y = 0.0,
      z = 0.0,
      wx = v.s * wx,
      wy = v.s * wy,
      wz = v.s * wz,
      xy = v.s * xy,
      xz = v.s * xz,
      yz = v.s * yz,
      wxy = (v.w * xy + v.y * wx - v.x * wy),
      wxz = (v.w * xz + v.z * wx - v.x * wz),
      wyz = (v.w * yz + v.z * wy - v.y * wz),
      xyz = (v.x * yz + v.z * xy - v.y * xz),
      i = (v.wx * yz + v.wz * xy + v.xy * wz + v.yz * wx - v.wy * xz - v.xz * wy),
    )

  inline infix def ^(v: Multivector): Multivector = wedge(v)

  infix def wedge(v: Motor): Motor =
    Motor(
      s = 0.0,
      wx = v.s * wx,
      wy = v.s * wy,
      wz = v.s * wz,
      xy = v.s * xy,
      xz = v.s * xz,
      yz = v.s * yz,
      i = (v.wx * yz + v.wz * xy + v.xy * wz + v.yz * wx - v.wy * xz - v.xz * wy),
    )

  inline infix def ^(v: Motor): Motor = wedge(v)

  infix def wedge(v: Plane): Point =
    Point(
      wxy = (v.w * xy + v.y * wx - v.x * wy),
      wxz = (v.w * xz + v.z * wx - v.x * wz),
      wyz = (v.w * yz + v.z * wy - v.y * wz),
      xyz = (v.x * yz + v.z * xy - v.y * xz),
    )

  inline infix def ^(v: Plane): Point = wedge(v)

  infix def wedge(v: Bivector): PseudoScalar =
    PseudoScalar(
      i = (v.wx * yz + v.wz * xy + v.xy * wz + v.yz * wx - v.wy * xz - v.xz * wy),
    )

  inline infix def ^(v: Bivector): PseudoScalar = wedge(v)

  infix def wedge(v: Quaternion): Motor =
    Motor(
      s = 0.0,
      wx = v.s * wx,
      wy = v.s * wy,
      wz = v.s * wz,
      xy = v.s * xy,
      xz = v.s * xz,
      yz = v.s * yz,
      i = (v.xy * wz + v.yz * wx - v.xz * wy),
    )

  inline infix def ^(v: Quaternion): Motor = wedge(v)

  infix def wedge(v: Translator): Motor =
    Motor(
      s = 0.0,
      wx = wx,
      wy = wy,
      wz = wz,
      xy = xy,
      xz = xz,
      yz = yz,
      i = (v.wx * yz + v.wz * xy - v.wy * xz),
    )

  inline infix def ^(v: Translator): Motor = wedge(v)

  infix def wedge(v: PlaneIdeal): Point =
    Point(
      wxy = (v.y * wx - v.x * wy),
      wxz = (v.z * wx - v.x * wz),
      wyz = (v.z * wy - v.y * wz),
      xyz = (v.x * yz + v.z * xy - v.y * xz),
    )

  inline infix def ^(v: PlaneIdeal): Point = wedge(v)

  infix def wedge(v: BivectorBulk): PseudoScalar =
    PseudoScalar(
      i = (v.xy * wz + v.yz * wx - v.xz * wy),
    )

  inline infix def ^(v: BivectorBulk): PseudoScalar = wedge(v)

  infix def wedge(v: BivectorWeight): PseudoScalar =
    PseudoScalar(
      i = (v.wx * yz + v.wz * xy - v.wy * xz),
    )

  inline infix def ^(v: BivectorWeight): PseudoScalar = wedge(v)

  infix def antiGeometric(v: Multivector): Multivector =
    Multivector(
      s = (v.wx * yz + v.wz * xy + v.xy * wz + v.yz * wx - v.wy * xz - v.xz * wy),
      w = (v.wxz * wy - v.wxy * wz - v.wyz * wx),
      x = (v.wxz * xy + v.y * wz - v.w * yz - v.wxy * xz - v.xyz * wx - v.z * wy),
      y = (v.w * xz + v.wyz * xy + v.z * wx - v.wxy * yz - v.x * wz - v.xyz * wy),
      z = (v.wyz * xz + v.x * wy - v.w * xy - v.wxz * yz - v.xyz * wz - v.y * wx),
      wx = (v.i * wx + v.wy * wz - v.wz * wy),
      wy = (v.i * wy + v.wz * wx - v.wx * wz),
      wz = (v.i * wz + v.wx * wy - v.wy * wx),
      xy = (v.i * xy + v.xz * wx + v.yz * wy - v.s * wz - v.wx * xz - v.wy * yz),
      xz = (v.i * xz + v.s * wy + v.wx * xy + v.yz * wz - v.wz * yz - v.xy * wx),
      yz = (v.i * yz + v.wy * xy + v.wz * xz - v.s * wx - v.xy * wy - v.xz * wz),
      wxy = (v.w * wz + v.wxz * wx + v.wyz * wy),
      wxz = (v.wyz * wz - v.w * wy - v.wxy * wx),
      wyz = (v.w * wx - v.wxy * wy - v.wxz * wz),
      xyz = (v.x * wx + v.y * wy + v.z * wz - v.wxy * xy - v.wxz * xz - v.wyz * yz),
      i = (-v.wx * wx - v.wy * wy - v.wz * wz),
    )

  infix def antiGeometric(v: Motor): Motor =
    Motor(
      s = (v.wx * yz + v.wz * xy + v.xy * wz + v.yz * wx - v.wy * xz - v.xz * wy),
      wx = (v.i * wx + v.wy * wz - v.wz * wy),
      wy = (v.i * wy + v.wz * wx - v.wx * wz),
      wz = (v.i * wz + v.wx * wy - v.wy * wx),
      xy = (v.i * xy + v.xz * wx + v.yz * wy - v.s * wz - v.wx * xz - v.wy * yz),
      xz = (v.i * xz + v.s * wy + v.wx * xy + v.yz * wz - v.wz * yz - v.xy * wx),
      yz = (v.i * yz + v.wy * xy + v.wz * xz - v.s * wx - v.xy * wy - v.xz * wz),
      i = (-v.wx * wx - v.wy * wy - v.wz * wz),
    )

  infix def antiGeometric(v: Plane): Multivector =
    Multivector(
      s = 0.0,
      w = 0.0,
      x = (v.y * wz - v.w * yz - v.z * wy),
      y = (v.w * xz + v.z * wx - v.x * wz),
      z = (v.x * wy - v.w * xy - v.y * wx),
      wx = 0.0,
      wy = 0.0,
      wz = 0.0,
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
      wxy = v.w * wz,
      wxz = -v.w * wy,
      wyz = v.w * wx,
      xyz = (v.x * wx + v.y * wy + v.z * wz),
      i = 0.0,
    )

  infix def antiGeometric(v: Bivector): Motor =
    Motor(
      s = (v.wx * yz + v.wz * xy + v.xy * wz + v.yz * wx - v.wy * xz - v.xz * wy),
      wx = (v.wy * wz - v.wz * wy),
      wy = (v.wz * wx - v.wx * wz),
      wz = (v.wx * wy - v.wy * wx),
      xy = (v.xz * wx + v.yz * wy - v.wx * xz - v.wy * yz),
      xz = (v.wx * xy + v.yz * wz - v.wz * yz - v.xy * wx),
      yz = (v.wy * xy + v.wz * xz - v.xy * wy - v.xz * wz),
      i = (-v.wx * wx - v.wy * wy - v.wz * wz),
    )

  infix def antiGeometric(v: Point): Multivector =
    Multivector(
      s = 0.0,
      w = (v.wxz * wy - v.wxy * wz - v.wyz * wx),
      x = (v.wxz * xy - v.wxy * xz - v.xyz * wx),
      y = (v.wyz * xy - v.wxy * yz - v.xyz * wy),
      z = (v.wyz * xz - v.wxz * yz - v.xyz * wz),
      wx = 0.0,
      wy = 0.0,
      wz = 0.0,
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
      wxy = (v.wxz * wx + v.wyz * wy),
      wxz = (v.wyz * wz - v.wxy * wx),
      wyz = (-v.wxy * wy - v.wxz * wz),
      xyz = (-v.wxy * xy - v.wxz * xz - v.wyz * yz),
      i = 0.0,
    )

  infix def antiGeometric(v: Quaternion): Quaternion =
    Quaternion(
      s = (v.xy * wz + v.yz * wx - v.xz * wy),
      xy = (v.xz * wx + v.yz * wy - v.s * wz),
      xz = (v.s * wy + v.yz * wz - v.xy * wx),
      yz = (-v.s * wx - v.xy * wy - v.xz * wz),
    )

  infix def antiGeometric(v: Translator): Motor =
    Motor(
      s = (v.wx * yz + v.wz * xy - v.wy * xz),
      wx = (v.wy * wz - v.wz * wy),
      wy = (v.wz * wx - v.wx * wz),
      wz = (v.wx * wy - v.wy * wx),
      xy = (-wz - v.wx * xz - v.wy * yz),
      xz = (wy + v.wx * xy - v.wz * yz),
      yz = (-wx + v.wy * xy + v.wz * xz),
      i = (-v.wx * wx - v.wy * wy - v.wz * wz),
    )

  infix def antiGeometric(v: Vector): Multivector =
    Multivector(
      s = 0.0,
      w = (v.wxz * wy - v.wxy * wz - v.wyz * wx),
      x = (v.wxz * xy - v.wxy * xz),
      y = (v.wyz * xy - v.wxy * yz),
      z = (v.wyz * xz - v.wxz * yz),
      wx = 0.0,
      wy = 0.0,
      wz = 0.0,
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
      wxy = (v.wxz * wx + v.wyz * wy),
      wxz = (v.wyz * wz - v.wxy * wx),
      wyz = (-v.wxy * wy - v.wxz * wz),
      xyz = (-v.wxy * xy - v.wxz * xz - v.wyz * yz),
      i = 0.0,
    )

  infix def antiGeometric(v: PointNormalized): Multivector =
    Multivector(
      s = 0.0,
      w = (v.wxz * wy - v.wxy * wz - v.wyz * wx),
      x = (-wx + v.wxz * xy - v.wxy * xz),
      y = (-wy + v.wyz * xy - v.wxy * yz),
      z = (-wz + v.wyz * xz - v.wxz * yz),
      wx = 0.0,
      wy = 0.0,
      wz = 0.0,
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
      wxy = (v.wxz * wx + v.wyz * wy),
      wxz = (v.wyz * wz - v.wxy * wx),
      wyz = (-v.wxy * wy - v.wxz * wz),
      xyz = (-v.wxy * xy - v.wxz * xz - v.wyz * yz),
      i = 0.0,
    )

  infix def antiGeometric(v: PlaneIdeal): Multivector =
    Multivector(
      s = 0.0,
      w = 0.0,
      x = (v.y * wz - v.z * wy),
      y = (v.z * wx - v.x * wz),
      z = (v.x * wy - v.y * wx),
      wx = 0.0,
      wy = 0.0,
      wz = 0.0,
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
      wxy = 0.0,
      wxz = 0.0,
      wyz = 0.0,
      xyz = (v.x * wx + v.y * wy + v.z * wz),
      i = 0.0,
    )

  infix def antiGeometric(v: BivectorBulk): Quaternion =
    Quaternion(
      s = (v.xy * wz + v.yz * wx - v.xz * wy),
      xy = (v.xz * wx + v.yz * wy),
      xz = (v.yz * wz - v.xy * wx),
      yz = (-v.xy * wy - v.xz * wz),
    )

  infix def antiGeometric(v: BivectorWeight): Motor =
    Motor(
      s = (v.wx * yz + v.wz * xy - v.wy * xz),
      wx = (v.wy * wz - v.wz * wy),
      wy = (v.wz * wx - v.wx * wz),
      wz = (v.wx * wy - v.wy * wx),
      xy = (-v.wx * xz - v.wy * yz),
      xz = (v.wx * xy - v.wz * yz),
      yz = (v.wy * xy + v.wz * xz),
      i = (-v.wx * wx - v.wy * wy - v.wz * wz),
    )

  infix def antiGeometric(v: PseudoScalar): Bivector =
    Bivector(
      wx = v.i * wx,
      wy = v.i * wy,
      wz = v.i * wz,
      xy = v.i * xy,
      xz = v.i * xz,
      yz = v.i * yz,
    )

  infix def antiGeometric(v: PointCenter.type): PlaneIdeal =
    PlaneIdeal(
      x = -wx,
      y = -wy,
      z = -wz,
    )

  infix def antiDot(v: Multivector): Multivector =
    Multivector(
      s = 0.0,
      w = 0.0,
      x = 0.0,
      y = 0.0,
      z = 0.0,
      wx = v.i * wx,
      wy = v.i * wy,
      wz = v.i * wz,
      xy = (v.i * xy - v.s * wz),
      xz = (v.i * xz + v.s * wy),
      yz = (v.i * yz - v.s * wx),
      wxy = (v.w * wz + v.wxz * wx + v.wyz * wy),
      wxz = (v.wyz * wz - v.w * wy - v.wxy * wx),
      wyz = (v.w * wx - v.wxy * wy - v.wxz * wz),
      xyz = (v.x * wx + v.y * wy + v.z * wz - v.wxy * xy - v.wxz * xz - v.wyz * yz),
      i = (-v.wx * wx - v.wy * wy - v.wz * wz),
    )

  infix def antiDot(v: Motor): Motor =
    Motor(
      s = 0.0,
      wx = v.i * wx,
      wy = v.i * wy,
      wz = v.i * wz,
      xy = (v.i * xy - v.s * wz),
      xz = (v.i * xz + v.s * wy),
      yz = (v.i * yz - v.s * wx),
      i = (-v.wx * wx - v.wy * wy - v.wz * wz),
    )

  infix def antiDot(v: Plane): Point =
    Point(
      wxy = v.w * wz,
      wxz = -v.w * wy,
      wyz = v.w * wx,
      xyz = (v.x * wx + v.y * wy + v.z * wz),
    )

  infix def antiDot(v: Bivector): PseudoScalar =
    PseudoScalar(
      i = (-v.wx * wx - v.wy * wy - v.wz * wz),
    )

  infix def antiDot(v: Point): Point =
    Point(
      wxy = (v.wxz * wx + v.wyz * wy),
      wxz = (v.wyz * wz - v.wxy * wx),
      wyz = (-v.wxy * wy - v.wxz * wz),
      xyz = (-v.wxy * xy - v.wxz * xz - v.wyz * yz),
    )

  infix def antiDot(v: Quaternion): BivectorBulk =
    BivectorBulk(
      xy = -v.s * wz,
      xz = v.s * wy,
      yz = -v.s * wx,
    )

  infix def antiDot(v: Translator): Motor =
    Motor(
      s = 0.0,
      wx = 0.0,
      wy = 0.0,
      wz = 0.0,
      xy = -wz,
      xz = wy,
      yz = -wx,
      i = (-v.wx * wx - v.wy * wy - v.wz * wz),
    )

  infix def antiDot(v: Vector): Point =
    Point(
      wxy = (v.wxz * wx + v.wyz * wy),
      wxz = (v.wyz * wz - v.wxy * wx),
      wyz = (-v.wxy * wy - v.wxz * wz),
      xyz = (-v.wxy * xy - v.wxz * xz - v.wyz * yz),
    )

  infix def antiDot(v: PointNormalized): Point =
    Point(
      wxy = (v.wxz * wx + v.wyz * wy),
      wxz = (v.wyz * wz - v.wxy * wx),
      wyz = (-v.wxy * wy - v.wxz * wz),
      xyz = (-v.wxy * xy - v.wxz * xz - v.wyz * yz),
    )

  infix def antiDot(v: PlaneIdeal): Point =
    Point(
      wxy = 0.0,
      wxz = 0.0,
      wyz = 0.0,
      xyz = (v.x * wx + v.y * wy + v.z * wz),
    )

  infix def antiDot(v: BivectorWeight): PseudoScalar =
    PseudoScalar(
      i = (-v.wx * wx - v.wy * wy - v.wz * wz),
    )

  infix def antiDot(v: PseudoScalar): Bivector =
    Bivector(
      wx = v.i * wx,
      wy = v.i * wy,
      wz = v.i * wz,
      xy = v.i * xy,
      xz = v.i * xz,
      yz = v.i * yz,
    )

  infix def antiWedge(v: Multivector): Multivector =
    Multivector(
      s = (v.wx * yz + v.wz * xy + v.xy * wz + v.yz * wx - v.wy * xz - v.xz * wy),
      w = (v.wxz * wy - v.wxy * wz - v.wyz * wx),
      x = (v.wxz * xy - v.wxy * xz - v.xyz * wx),
      y = (v.wyz * xy - v.wxy * yz - v.xyz * wy),
      z = (v.wyz * xz - v.wxz * yz - v.xyz * wz),
      wx = v.i * wx,
      wy = v.i * wy,
      wz = v.i * wz,
      xy = v.i * xy,
      xz = v.i * xz,
      yz = v.i * yz,
      wxy = 0.0,
      wxz = 0.0,
      wyz = 0.0,
      xyz = 0.0,
      i = 0.0,
    )

  inline infix def v(v: Multivector): Multivector = antiWedge(v)

  infix def antiWedge(v: Motor): Motor =
    Motor(
      s = (v.wx * yz + v.wz * xy + v.xy * wz + v.yz * wx - v.wy * xz - v.xz * wy),
      wx = v.i * wx,
      wy = v.i * wy,
      wz = v.i * wz,
      xy = v.i * xy,
      xz = v.i * xz,
      yz = v.i * yz,
      i = 0.0,
    )

  inline infix def v(v: Motor): Motor = antiWedge(v)

  infix def antiWedge(v: Bivector): Double =
    (v.wx * yz + v.wz * xy + v.xy * wz + v.yz * wx - v.wy * xz - v.xz * wy)

  inline infix def v(v: Bivector): Double = antiWedge(v)

  infix def antiWedge(v: Point): Plane =
    Plane(
      w = (v.wxz * wy - v.wxy * wz - v.wyz * wx),
      x = (v.wxz * xy - v.wxy * xz - v.xyz * wx),
      y = (v.wyz * xy - v.wxy * yz - v.xyz * wy),
      z = (v.wyz * xz - v.wxz * yz - v.xyz * wz),
    )

  inline infix def v(v: Point): Plane = antiWedge(v)

  infix def antiWedge(v: Quaternion): Double =
    (v.xy * wz + v.yz * wx - v.xz * wy)

  inline infix def v(v: Quaternion): Double = antiWedge(v)

  infix def antiWedge(v: Translator): Double =
    (v.wx * yz + v.wz * xy - v.wy * xz)

  inline infix def v(v: Translator): Double = antiWedge(v)

  infix def antiWedge(v: Vector): Plane =
    Plane(
      w = (v.wxz * wy - v.wxy * wz - v.wyz * wx),
      x = (v.wxz * xy - v.wxy * xz),
      y = (v.wyz * xy - v.wxy * yz),
      z = (v.wyz * xz - v.wxz * yz),
    )

  inline infix def v(v: Vector): Plane = antiWedge(v)

  infix def antiWedge(v: PointNormalized): Plane =
    Plane(
      w = (v.wxz * wy - v.wxy * wz - v.wyz * wx),
      x = (-wx + v.wxz * xy - v.wxy * xz),
      y = (-wy + v.wyz * xy - v.wxy * yz),
      z = (-wz + v.wyz * xz - v.wxz * yz),
    )

  inline infix def v(v: PointNormalized): Plane = antiWedge(v)

  infix def antiWedge(v: BivectorBulk): Double =
    (v.xy * wz + v.yz * wx - v.xz * wy)

  inline infix def v(v: BivectorBulk): Double = antiWedge(v)

  infix def antiWedge(v: BivectorWeight): Double =
    (v.wx * yz + v.wz * xy - v.wy * xz)

  inline infix def v(v: BivectorWeight): Double = antiWedge(v)

  infix def antiWedge(v: PseudoScalar): Bivector =
    Bivector(
      wx = v.i * wx,
      wy = v.i * wy,
      wz = v.i * wz,
      xy = v.i * xy,
      xz = v.i * xz,
      yz = v.i * yz,
    )

  inline infix def v(v: PseudoScalar): Bivector = antiWedge(v)

  infix def antiWedge(v: PointCenter.type): PlaneIdeal =
    PlaneIdeal(
      x = -wx,
      y = -wy,
      z = -wz,
    )

  inline infix def v(v: PointCenter.type): PlaneIdeal = antiWedge(v)

  infix def sandwich(v: Multivector): Multivector =
    val wxMxy = wx * xy
    val wxMxz = wx * xz
    val wxMyz = wx * yz
    val wyMxy = wy * xy
    val wyMxz = wy * xz
    val wyMyz = wy * yz
    val wzMxy = wz * xy
    val wzMxz = wz * xz
    val wzMyz = wz * yz
    val xyMxy = xy * xy
    val xyMxz = xy * xz
    val xyMyz = xy * yz
    val xzMxz = xz * xz
    val xzMyz = xz * yz
    val yzMyz = yz * yz
    Multivector(
      s = v.s * (xyMxy + xzMxz + yzMyz),
      w = (2.0 * (v.x * (-wyMxy - wzMxz) + v.y * (wxMxy - wzMyz) + v.z * (wxMxz + wyMyz)) + v.w * (xyMxy + xzMxz + yzMyz)),
      x = (2.0 * (v.z * xyMyz - v.y * xzMyz) + v.x * (yzMyz - xyMxy - xzMxz)),
      y = (2.0 * (-v.x * xzMyz - v.z * xyMxz) + v.y * (xzMxz - xyMxy - yzMyz)),
      z = (2.0 * (v.x * xyMyz - v.y * xyMxz) + v.z * (xyMxy - xzMxz - yzMyz)),
      wx = (2.0 * (v.wz * xyMyz + v.xy * (wxMxy + wzMyz) + v.xz * (wxMxz - wyMyz) + v.yz * (wxMyz + wyMxz - wzMxy) - v.wy * xzMyz) + v.wx * (yzMyz - xyMxy - xzMxz)),
      wy = (2.0 * (v.xy * (wyMxy - wzMxz) + v.xz * (wxMyz + wyMxz + wzMxy) + v.yz * (wyMyz - wxMxz) - v.wx * xzMyz - v.wz * xyMxz) + v.wy * (xzMxz - xyMxy - yzMyz)),
      wz = (2.0 * (v.wx * xyMyz + v.xy * (wyMxz + wzMxy - wxMyz) + v.xz * (wzMxz - wyMxy) + v.yz * (wxMxy + wzMyz) - v.wy * xyMxz) + v.wz * (xyMxy - xzMxz - yzMyz)),
      xy = (2.0 * (v.xz * xyMxz + v.yz * xyMyz) + v.xy * (xyMxy - xzMxz - yzMyz)),
      xz = (2.0 * (v.xy * xyMxz + v.yz * xzMyz) + v.xz * (xzMxz - xyMxy - yzMyz)),
      yz = (2.0 * (v.xy * xyMyz + v.xz * xzMyz) + v.yz * (yzMyz - xyMxy - xzMxz)),
      wxy = (2.0 * (v.wxz * xyMxz + v.wyz * xyMyz + v.xyz * (-wxMxz - wyMyz)) + v.wxy * (xyMxy - xzMxz - yzMyz)),
      wxz = (2.0 * (v.wxy * xyMxz + v.wyz * xzMyz + v.xyz * (wxMxy - wzMyz)) + v.wxz * (xzMxz - xyMxy - yzMyz)),
      wyz = (2.0 * (v.wxy * xyMyz + v.wxz * xzMyz + v.xyz * (wyMxy + wzMxz)) + v.wyz * (yzMyz - xyMxy - xzMxz)),
      xyz = v.xyz * (xyMxy + xzMxz + yzMyz),
      i = (v.i * (xyMxy + xzMxz + yzMyz) + 2.0 * v.s * (wyMxz - wxMyz - wzMxy)),
    )

  infix def sandwich(v: Motor): Motor =
    val wxMxy = wx * xy
    val wxMxz = wx * xz
    val wxMyz = wx * yz
    val wyMxy = wy * xy
    val wyMxz = wy * xz
    val wyMyz = wy * yz
    val wzMxy = wz * xy
    val wzMxz = wz * xz
    val wzMyz = wz * yz
    val xyMxy = xy * xy
    val xyMxz = xy * xz
    val xyMyz = xy * yz
    val xzMxz = xz * xz
    val xzMyz = xz * yz
    val yzMyz = yz * yz
    Motor(
      s = v.s * (xyMxy + xzMxz + yzMyz),
      wx = (2.0 * (v.wz * xyMyz + v.xy * (wxMxy + wzMyz) + v.xz * (wxMxz - wyMyz) + v.yz * (wxMyz + wyMxz - wzMxy) - v.wy * xzMyz) + v.wx * (yzMyz - xyMxy - xzMxz)),
      wy = (2.0 * (v.xy * (wyMxy - wzMxz) + v.xz * (wxMyz + wyMxz + wzMxy) + v.yz * (wyMyz - wxMxz) - v.wx * xzMyz - v.wz * xyMxz) + v.wy * (xzMxz - xyMxy - yzMyz)),
      wz = (2.0 * (v.wx * xyMyz + v.xy * (wyMxz + wzMxy - wxMyz) + v.xz * (wzMxz - wyMxy) + v.yz * (wxMxy + wzMyz) - v.wy * xyMxz) + v.wz * (xyMxy - xzMxz - yzMyz)),
      xy = (2.0 * (v.xz * xyMxz + v.yz * xyMyz) + v.xy * (xyMxy - xzMxz - yzMyz)),
      xz = (2.0 * (v.xy * xyMxz + v.yz * xzMyz) + v.xz * (xzMxz - xyMxy - yzMyz)),
      yz = (2.0 * (v.xy * xyMyz + v.xz * xzMyz) + v.yz * (yzMyz - xyMxy - xzMxz)),
      i = (v.i * (xyMxy + xzMxz + yzMyz) + 2.0 * v.s * (wyMxz - wxMyz - wzMxy)),
    )

  infix def sandwich(v: Plane): Plane =
    val xyMxy = xy * xy
    val xyMxz = xy * xz
    val xyMyz = xy * yz
    val xzMxz = xz * xz
    val xzMyz = xz * yz
    val yzMyz = yz * yz
    Plane(
      w = (2.0 * (v.x * (-wy * xy - wz * xz) + v.y * (wx * xy - wz * yz) + v.z * (wx * xz + wy * yz)) + v.w * (xyMxy + xzMxz + yzMyz)),
      x = (2.0 * (v.z * xyMyz - v.y * xzMyz) + v.x * (yzMyz - xyMxy - xzMxz)),
      y = (2.0 * (-v.x * xzMyz - v.z * xyMxz) + v.y * (xzMxz - xyMxy - yzMyz)),
      z = (2.0 * (v.x * xyMyz - v.y * xyMxz) + v.z * (xyMxy - xzMxz - yzMyz)),
    )

  infix def sandwich(v: Bivector): Bivector =
    val wxMxy = wx * xy
    val wxMxz = wx * xz
    val wxMyz = wx * yz
    val wyMxy = wy * xy
    val wyMxz = wy * xz
    val wyMyz = wy * yz
    val wzMxy = wz * xy
    val wzMxz = wz * xz
    val wzMyz = wz * yz
    val xyMxy = xy * xy
    val xyMxz = xy * xz
    val xyMyz = xy * yz
    val xzMxz = xz * xz
    val xzMyz = xz * yz
    val yzMyz = yz * yz
    Bivector(
      wx = (2.0 * (v.wz * xyMyz + v.xy * (wxMxy + wzMyz) + v.xz * (wxMxz - wyMyz) + v.yz * (wxMyz + wyMxz - wzMxy) - v.wy * xzMyz) + v.wx * (yzMyz - xyMxy - xzMxz)),
      wy = (2.0 * (v.xy * (wyMxy - wzMxz) + v.xz * (wxMyz + wyMxz + wzMxy) + v.yz * (wyMyz - wxMxz) - v.wx * xzMyz - v.wz * xyMxz) + v.wy * (xzMxz - xyMxy - yzMyz)),
      wz = (2.0 * (v.wx * xyMyz + v.xy * (wyMxz + wzMxy - wxMyz) + v.xz * (wzMxz - wyMxy) + v.yz * (wxMxy + wzMyz) - v.wy * xyMxz) + v.wz * (xyMxy - xzMxz - yzMyz)),
      xy = (2.0 * (v.xz * xyMxz + v.yz * xyMyz) + v.xy * (xyMxy - xzMxz - yzMyz)),
      xz = (2.0 * (v.xy * xyMxz + v.yz * xzMyz) + v.xz * (xzMxz - xyMxy - yzMyz)),
      yz = (2.0 * (v.xy * xyMyz + v.xz * xzMyz) + v.yz * (yzMyz - xyMxy - xzMxz)),
    )

  infix def sandwich(v: Point): Point =
    val xyMxy = xy * xy
    val xyMxz = xy * xz
    val xyMyz = xy * yz
    val xzMxz = xz * xz
    val xzMyz = xz * yz
    val yzMyz = yz * yz
    Point(
      wxy = (2.0 * (v.wxz * xyMxz + v.wyz * xyMyz + v.xyz * (-wx * xz - wy * yz)) + v.wxy * (xyMxy - xzMxz - yzMyz)),
      wxz = (2.0 * (v.wxy * xyMxz + v.wyz * xzMyz + v.xyz * (wx * xy - wz * yz)) + v.wxz * (xzMxz - xyMxy - yzMyz)),
      wyz = (2.0 * (v.wxy * xyMyz + v.wxz * xzMyz + v.xyz * (wy * xy + wz * xz)) + v.wyz * (yzMyz - xyMxy - xzMxz)),
      xyz = v.xyz * (xyMxy + xzMxz + yzMyz),
    )

  infix def sandwich(v: Quaternion): Motor =
    val wxMxy = wx * xy
    val wxMxz = wx * xz
    val wxMyz = wx * yz
    val wyMxy = wy * xy
    val wyMxz = wy * xz
    val wyMyz = wy * yz
    val wzMxy = wz * xy
    val wzMxz = wz * xz
    val wzMyz = wz * yz
    val xyMxy = xy * xy
    val xyMxz = xy * xz
    val xyMyz = xy * yz
    val xzMxz = xz * xz
    val xzMyz = xz * yz
    val yzMyz = yz * yz
    Motor(
      s = v.s * (xyMxy + xzMxz + yzMyz),
      wx = 2.0 * (v.xy * (wxMxy + wzMyz) + v.xz * (wxMxz - wyMyz) + v.yz * (wxMyz + wyMxz - wzMxy)),
      wy = 2.0 * (v.xy * (wyMxy - wzMxz) + v.xz * (wxMyz + wyMxz + wzMxy) + v.yz * (wyMyz - wxMxz)),
      wz = 2.0 * (v.xy * (wyMxz + wzMxy - wxMyz) + v.xz * (wzMxz - wyMxy) + v.yz * (wxMxy + wzMyz)),
      xy = (2.0 * (v.xz * xyMxz + v.yz * xyMyz) + v.xy * (xyMxy - xzMxz - yzMyz)),
      xz = (2.0 * (v.xy * xyMxz + v.yz * xzMyz) + v.xz * (xzMxz - xyMxy - yzMyz)),
      yz = (2.0 * (v.xy * xyMyz + v.xz * xzMyz) + v.yz * (yzMyz - xyMxy - xzMxz)),
      i = 2.0 * v.s * (wyMxz - wxMyz - wzMxy),
    )

  infix def sandwich(v: Translator): Motor =
    val xyMxy = xy * xy
    val xyMxz = xy * xz
    val xyMyz = xy * yz
    val xzMxz = xz * xz
    val xzMyz = xz * yz
    val yzMyz = yz * yz
    Motor(
      s = (xyMxy + xzMxz + yzMyz),
      wx = (2.0 * (v.wz * xyMyz - v.wy * xzMyz) + v.wx * (yzMyz - xyMxy - xzMxz)),
      wy = (2.0 * (-v.wx * xzMyz - v.wz * xyMxz) + v.wy * (xzMxz - xyMxy - yzMyz)),
      wz = (2.0 * (v.wx * xyMyz - v.wy * xyMxz) + v.wz * (xyMxy - xzMxz - yzMyz)),
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
      i = 2.0 * (wy * xz - wx * yz - wz * xy),
    )

  infix def sandwich(v: Vector): Vector =
    val xyMxy = xy * xy
    val xyMxz = xy * xz
    val xyMyz = xy * yz
    val xzMxz = xz * xz
    val xzMyz = xz * yz
    val yzMyz = yz * yz
    Vector(
      wxy = (2.0 * (v.wxz * xyMxz + v.wyz * xyMyz) + v.wxy * (xyMxy - xzMxz - yzMyz)),
      wxz = (2.0 * (v.wxy * xyMxz + v.wyz * xzMyz) + v.wxz * (xzMxz - xyMxy - yzMyz)),
      wyz = (2.0 * (v.wxy * xyMyz + v.wxz * xzMyz) + v.wyz * (yzMyz - xyMxy - xzMxz)),
    )

  infix def sandwich(v: PointNormalized): Point =
    val xyMxy = xy * xy
    val xyMxz = xy * xz
    val xyMyz = xy * yz
    val xzMxz = xz * xz
    val xzMyz = xz * yz
    val yzMyz = yz * yz
    Point(
      wxy = (2.0 * (v.wxz * xyMxz + v.wyz * xyMyz - wx * xz - wy * yz) + v.wxy * (xyMxy - xzMxz - yzMyz)),
      wxz = (2.0 * (v.wxy * xyMxz + v.wyz * xzMyz + wx * xy - wz * yz) + v.wxz * (xzMxz - xyMxy - yzMyz)),
      wyz = (2.0 * (v.wxy * xyMyz + v.wxz * xzMyz + wy * xy + wz * xz) + v.wyz * (yzMyz - xyMxy - xzMxz)),
      xyz = (xyMxy + xzMxz + yzMyz),
    )

  infix def sandwich(v: PlaneIdeal): Plane =
    val xyMxy = xy * xy
    val xyMxz = xy * xz
    val xyMyz = xy * yz
    val xzMxz = xz * xz
    val xzMyz = xz * yz
    val yzMyz = yz * yz
    Plane(
      w = 2.0 * (v.x * (-wy * xy - wz * xz) + v.y * (wx * xy - wz * yz) + v.z * (wx * xz + wy * yz)),
      x = (2.0 * (v.z * xyMyz - v.y * xzMyz) + v.x * (yzMyz - xyMxy - xzMxz)),
      y = (2.0 * (-v.x * xzMyz - v.z * xyMxz) + v.y * (xzMxz - xyMxy - yzMyz)),
      z = (2.0 * (v.x * xyMyz - v.y * xyMxz) + v.z * (xyMxy - xzMxz - yzMyz)),
    )

  infix def sandwich(v: BivectorBulk): Bivector =
    val wxMxy = wx * xy
    val wxMxz = wx * xz
    val wxMyz = wx * yz
    val wyMxy = wy * xy
    val wyMxz = wy * xz
    val wyMyz = wy * yz
    val wzMxy = wz * xy
    val wzMxz = wz * xz
    val wzMyz = wz * yz
    val xyMxy = xy * xy
    val xyMxz = xy * xz
    val xyMyz = xy * yz
    val xzMxz = xz * xz
    val xzMyz = xz * yz
    val yzMyz = yz * yz
    Bivector(
      wx = 2.0 * (v.xy * (wxMxy + wzMyz) + v.xz * (wxMxz - wyMyz) + v.yz * (wxMyz + wyMxz - wzMxy)),
      wy = 2.0 * (v.xy * (wyMxy - wzMxz) + v.xz * (wxMyz + wyMxz + wzMxy) + v.yz * (wyMyz - wxMxz)),
      wz = 2.0 * (v.xy * (wyMxz + wzMxy - wxMyz) + v.xz * (wzMxz - wyMxy) + v.yz * (wxMxy + wzMyz)),
      xy = (2.0 * (v.xz * xyMxz + v.yz * xyMyz) + v.xy * (xyMxy - xzMxz - yzMyz)),
      xz = (2.0 * (v.xy * xyMxz + v.yz * xzMyz) + v.xz * (xzMxz - xyMxy - yzMyz)),
      yz = (2.0 * (v.xy * xyMyz + v.xz * xzMyz) + v.yz * (yzMyz - xyMxy - xzMxz)),
    )

  infix def sandwich(v: BivectorWeight): BivectorWeight =
    val xyMxy = xy * xy
    val xyMxz = xy * xz
    val xyMyz = xy * yz
    val xzMxz = xz * xz
    val xzMyz = xz * yz
    val yzMyz = yz * yz
    BivectorWeight(
      wx = (2.0 * (v.wz * xyMyz - v.wy * xzMyz) + v.wx * (yzMyz - xyMxy - xzMxz)),
      wy = (2.0 * (-v.wx * xzMyz - v.wz * xyMxz) + v.wy * (xzMxz - xyMxy - yzMyz)),
      wz = (2.0 * (v.wx * xyMyz - v.wy * xyMxz) + v.wz * (xyMxy - xzMxz - yzMyz)),
    )

  infix def sandwich(v: PseudoScalar): PseudoScalar =
    PseudoScalar(
      i = v.i * (xy * xy + xz * xz + yz * yz),
    )

  infix def sandwich(v: PointCenter.type): Point =
    Point(
      wxy = 2.0 * (-wx * xz - wy * yz),
      wxz = 2.0 * (wx * xy - wz * yz),
      wyz = 2.0 * (wy * xy + wz * xz),
      xyz = (xy * xy + xz * xz + yz * yz),
    )

  infix def reverseSandwich(v: Multivector): Multivector =
    val wxMxy = wx * xy
    val wxMxz = wx * xz
    val wxMyz = wx * yz
    val wyMxy = wy * xy
    val wyMxz = wy * xz
    val wyMyz = wy * yz
    val wzMxy = wz * xy
    val wzMxz = wz * xz
    val wzMyz = wz * yz
    val xyMxy = xy * xy
    val xyMxz = xy * xz
    val xyMyz = xy * yz
    val xzMxz = xz * xz
    val xzMyz = xz * yz
    val yzMyz = yz * yz
    Multivector(
      s = v.s * (xyMxy + xzMxz + yzMyz),
      w = (2.0 * (v.x * (-wyMxy - wzMxz) + v.y * (wxMxy - wzMyz) + v.z * (wxMxz + wyMyz)) + v.w * (xyMxy + xzMxz + yzMyz)),
      x = (2.0 * (v.z * xyMyz - v.y * xzMyz) + v.x * (yzMyz - xyMxy - xzMxz)),
      y = (2.0 * (-v.x * xzMyz - v.z * xyMxz) + v.y * (xzMxz - xyMxy - yzMyz)),
      z = (2.0 * (v.x * xyMyz - v.y * xyMxz) + v.z * (xyMxy - xzMxz - yzMyz)),
      wx = (2.0 * (v.wz * xyMyz + v.xy * (wxMxy + wzMyz) + v.xz * (wxMxz - wyMyz) + v.yz * (wxMyz + wyMxz - wzMxy) - v.wy * xzMyz) + v.wx * (yzMyz - xyMxy - xzMxz)),
      wy = (2.0 * (v.xy * (wyMxy - wzMxz) + v.xz * (wxMyz + wyMxz + wzMxy) + v.yz * (wyMyz - wxMxz) - v.wx * xzMyz - v.wz * xyMxz) + v.wy * (xzMxz - xyMxy - yzMyz)),
      wz = (2.0 * (v.wx * xyMyz + v.xy * (wyMxz + wzMxy - wxMyz) + v.xz * (wzMxz - wyMxy) + v.yz * (wxMxy + wzMyz) - v.wy * xyMxz) + v.wz * (xyMxy - xzMxz - yzMyz)),
      xy = (2.0 * (v.xz * xyMxz + v.yz * xyMyz) + v.xy * (xyMxy - xzMxz - yzMyz)),
      xz = (2.0 * (v.xy * xyMxz + v.yz * xzMyz) + v.xz * (xzMxz - xyMxy - yzMyz)),
      yz = (2.0 * (v.xy * xyMyz + v.xz * xzMyz) + v.yz * (yzMyz - xyMxy - xzMxz)),
      wxy = (2.0 * (v.wxz * xyMxz + v.wyz * xyMyz + v.xyz * (-wxMxz - wyMyz)) + v.wxy * (xyMxy - xzMxz - yzMyz)),
      wxz = (2.0 * (v.wxy * xyMxz + v.wyz * xzMyz + v.xyz * (wxMxy - wzMyz)) + v.wxz * (xzMxz - xyMxy - yzMyz)),
      wyz = (2.0 * (v.wxy * xyMyz + v.wxz * xzMyz + v.xyz * (wyMxy + wzMxz)) + v.wyz * (yzMyz - xyMxy - xzMxz)),
      xyz = v.xyz * (xyMxy + xzMxz + yzMyz),
      i = (v.i * (xyMxy + xzMxz + yzMyz) + 2.0 * v.s * (wyMxz - wxMyz - wzMxy)),
    )

  infix def reverseSandwich(v: Motor): Motor =
    val wxMxy = wx * xy
    val wxMxz = wx * xz
    val wxMyz = wx * yz
    val wyMxy = wy * xy
    val wyMxz = wy * xz
    val wyMyz = wy * yz
    val wzMxy = wz * xy
    val wzMxz = wz * xz
    val wzMyz = wz * yz
    val xyMxy = xy * xy
    val xyMxz = xy * xz
    val xyMyz = xy * yz
    val xzMxz = xz * xz
    val xzMyz = xz * yz
    val yzMyz = yz * yz
    Motor(
      s = v.s * (xyMxy + xzMxz + yzMyz),
      wx = (2.0 * (v.wz * xyMyz + v.xy * (wxMxy + wzMyz) + v.xz * (wxMxz - wyMyz) + v.yz * (wxMyz + wyMxz - wzMxy) - v.wy * xzMyz) + v.wx * (yzMyz - xyMxy - xzMxz)),
      wy = (2.0 * (v.xy * (wyMxy - wzMxz) + v.xz * (wxMyz + wyMxz + wzMxy) + v.yz * (wyMyz - wxMxz) - v.wx * xzMyz - v.wz * xyMxz) + v.wy * (xzMxz - xyMxy - yzMyz)),
      wz = (2.0 * (v.wx * xyMyz + v.xy * (wyMxz + wzMxy - wxMyz) + v.xz * (wzMxz - wyMxy) + v.yz * (wxMxy + wzMyz) - v.wy * xyMxz) + v.wz * (xyMxy - xzMxz - yzMyz)),
      xy = (2.0 * (v.xz * xyMxz + v.yz * xyMyz) + v.xy * (xyMxy - xzMxz - yzMyz)),
      xz = (2.0 * (v.xy * xyMxz + v.yz * xzMyz) + v.xz * (xzMxz - xyMxy - yzMyz)),
      yz = (2.0 * (v.xy * xyMyz + v.xz * xzMyz) + v.yz * (yzMyz - xyMxy - xzMxz)),
      i = (v.i * (xyMxy + xzMxz + yzMyz) + 2.0 * v.s * (wyMxz - wxMyz - wzMxy)),
    )

  infix def reverseSandwich(v: Plane): Plane =
    val xyMxy = xy * xy
    val xyMxz = xy * xz
    val xyMyz = xy * yz
    val xzMxz = xz * xz
    val xzMyz = xz * yz
    val yzMyz = yz * yz
    Plane(
      w = (2.0 * (v.x * (-wy * xy - wz * xz) + v.y * (wx * xy - wz * yz) + v.z * (wx * xz + wy * yz)) + v.w * (xyMxy + xzMxz + yzMyz)),
      x = (2.0 * (v.z * xyMyz - v.y * xzMyz) + v.x * (yzMyz - xyMxy - xzMxz)),
      y = (2.0 * (-v.x * xzMyz - v.z * xyMxz) + v.y * (xzMxz - xyMxy - yzMyz)),
      z = (2.0 * (v.x * xyMyz - v.y * xyMxz) + v.z * (xyMxy - xzMxz - yzMyz)),
    )

  infix def reverseSandwich(v: Bivector): Bivector =
    val wxMxy = wx * xy
    val wxMxz = wx * xz
    val wxMyz = wx * yz
    val wyMxy = wy * xy
    val wyMxz = wy * xz
    val wyMyz = wy * yz
    val wzMxy = wz * xy
    val wzMxz = wz * xz
    val wzMyz = wz * yz
    val xyMxy = xy * xy
    val xyMxz = xy * xz
    val xyMyz = xy * yz
    val xzMxz = xz * xz
    val xzMyz = xz * yz
    val yzMyz = yz * yz
    Bivector(
      wx = (2.0 * (v.wz * xyMyz + v.xy * (wxMxy + wzMyz) + v.xz * (wxMxz - wyMyz) + v.yz * (wxMyz + wyMxz - wzMxy) - v.wy * xzMyz) + v.wx * (yzMyz - xyMxy - xzMxz)),
      wy = (2.0 * (v.xy * (wyMxy - wzMxz) + v.xz * (wxMyz + wyMxz + wzMxy) + v.yz * (wyMyz - wxMxz) - v.wx * xzMyz - v.wz * xyMxz) + v.wy * (xzMxz - xyMxy - yzMyz)),
      wz = (2.0 * (v.wx * xyMyz + v.xy * (wyMxz + wzMxy - wxMyz) + v.xz * (wzMxz - wyMxy) + v.yz * (wxMxy + wzMyz) - v.wy * xyMxz) + v.wz * (xyMxy - xzMxz - yzMyz)),
      xy = (2.0 * (v.xz * xyMxz + v.yz * xyMyz) + v.xy * (xyMxy - xzMxz - yzMyz)),
      xz = (2.0 * (v.xy * xyMxz + v.yz * xzMyz) + v.xz * (xzMxz - xyMxy - yzMyz)),
      yz = (2.0 * (v.xy * xyMyz + v.xz * xzMyz) + v.yz * (yzMyz - xyMxy - xzMxz)),
    )

  infix def reverseSandwich(v: Point): Point =
    val xyMxy = xy * xy
    val xyMxz = xy * xz
    val xyMyz = xy * yz
    val xzMxz = xz * xz
    val xzMyz = xz * yz
    val yzMyz = yz * yz
    Point(
      wxy = (2.0 * (v.wxz * xyMxz + v.wyz * xyMyz + v.xyz * (-wx * xz - wy * yz)) + v.wxy * (xyMxy - xzMxz - yzMyz)),
      wxz = (2.0 * (v.wxy * xyMxz + v.wyz * xzMyz + v.xyz * (wx * xy - wz * yz)) + v.wxz * (xzMxz - xyMxy - yzMyz)),
      wyz = (2.0 * (v.wxy * xyMyz + v.wxz * xzMyz + v.xyz * (wy * xy + wz * xz)) + v.wyz * (yzMyz - xyMxy - xzMxz)),
      xyz = v.xyz * (xyMxy + xzMxz + yzMyz),
    )

  infix def reverseSandwich(v: Quaternion): Motor =
    val wxMxy = wx * xy
    val wxMxz = wx * xz
    val wxMyz = wx * yz
    val wyMxy = wy * xy
    val wyMxz = wy * xz
    val wyMyz = wy * yz
    val wzMxy = wz * xy
    val wzMxz = wz * xz
    val wzMyz = wz * yz
    val xyMxy = xy * xy
    val xyMxz = xy * xz
    val xyMyz = xy * yz
    val xzMxz = xz * xz
    val xzMyz = xz * yz
    val yzMyz = yz * yz
    Motor(
      s = v.s * (xyMxy + xzMxz + yzMyz),
      wx = 2.0 * (v.xy * (wxMxy + wzMyz) + v.xz * (wxMxz - wyMyz) + v.yz * (wxMyz + wyMxz - wzMxy)),
      wy = 2.0 * (v.xy * (wyMxy - wzMxz) + v.xz * (wxMyz + wyMxz + wzMxy) + v.yz * (wyMyz - wxMxz)),
      wz = 2.0 * (v.xy * (wyMxz + wzMxy - wxMyz) + v.xz * (wzMxz - wyMxy) + v.yz * (wxMxy + wzMyz)),
      xy = (2.0 * (v.xz * xyMxz + v.yz * xyMyz) + v.xy * (xyMxy - xzMxz - yzMyz)),
      xz = (2.0 * (v.xy * xyMxz + v.yz * xzMyz) + v.xz * (xzMxz - xyMxy - yzMyz)),
      yz = (2.0 * (v.xy * xyMyz + v.xz * xzMyz) + v.yz * (yzMyz - xyMxy - xzMxz)),
      i = 2.0 * v.s * (wyMxz - wxMyz - wzMxy),
    )

  infix def reverseSandwich(v: Translator): Motor =
    val xyMxy = xy * xy
    val xyMxz = xy * xz
    val xyMyz = xy * yz
    val xzMxz = xz * xz
    val xzMyz = xz * yz
    val yzMyz = yz * yz
    Motor(
      s = (xyMxy + xzMxz + yzMyz),
      wx = (2.0 * (v.wz * xyMyz - v.wy * xzMyz) + v.wx * (yzMyz - xyMxy - xzMxz)),
      wy = (2.0 * (-v.wx * xzMyz - v.wz * xyMxz) + v.wy * (xzMxz - xyMxy - yzMyz)),
      wz = (2.0 * (v.wx * xyMyz - v.wy * xyMxz) + v.wz * (xyMxy - xzMxz - yzMyz)),
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
      i = 2.0 * (wy * xz - wx * yz - wz * xy),
    )

  infix def reverseSandwich(v: Vector): Vector =
    val xyMxy = xy * xy
    val xyMxz = xy * xz
    val xyMyz = xy * yz
    val xzMxz = xz * xz
    val xzMyz = xz * yz
    val yzMyz = yz * yz
    Vector(
      wxy = (2.0 * (v.wxz * xyMxz + v.wyz * xyMyz) + v.wxy * (xyMxy - xzMxz - yzMyz)),
      wxz = (2.0 * (v.wxy * xyMxz + v.wyz * xzMyz) + v.wxz * (xzMxz - xyMxy - yzMyz)),
      wyz = (2.0 * (v.wxy * xyMyz + v.wxz * xzMyz) + v.wyz * (yzMyz - xyMxy - xzMxz)),
    )

  infix def reverseSandwich(v: PointNormalized): Point =
    val xyMxy = xy * xy
    val xyMxz = xy * xz
    val xyMyz = xy * yz
    val xzMxz = xz * xz
    val xzMyz = xz * yz
    val yzMyz = yz * yz
    Point(
      wxy = (2.0 * (v.wxz * xyMxz + v.wyz * xyMyz - wx * xz - wy * yz) + v.wxy * (xyMxy - xzMxz - yzMyz)),
      wxz = (2.0 * (v.wxy * xyMxz + v.wyz * xzMyz + wx * xy - wz * yz) + v.wxz * (xzMxz - xyMxy - yzMyz)),
      wyz = (2.0 * (v.wxy * xyMyz + v.wxz * xzMyz + wy * xy + wz * xz) + v.wyz * (yzMyz - xyMxy - xzMxz)),
      xyz = (xyMxy + xzMxz + yzMyz),
    )

  infix def reverseSandwich(v: PlaneIdeal): Plane =
    val xyMxy = xy * xy
    val xyMxz = xy * xz
    val xyMyz = xy * yz
    val xzMxz = xz * xz
    val xzMyz = xz * yz
    val yzMyz = yz * yz
    Plane(
      w = 2.0 * (v.x * (-wy * xy - wz * xz) + v.y * (wx * xy - wz * yz) + v.z * (wx * xz + wy * yz)),
      x = (2.0 * (v.z * xyMyz - v.y * xzMyz) + v.x * (yzMyz - xyMxy - xzMxz)),
      y = (2.0 * (-v.x * xzMyz - v.z * xyMxz) + v.y * (xzMxz - xyMxy - yzMyz)),
      z = (2.0 * (v.x * xyMyz - v.y * xyMxz) + v.z * (xyMxy - xzMxz - yzMyz)),
    )

  infix def reverseSandwich(v: BivectorBulk): Bivector =
    val wxMxy = wx * xy
    val wxMxz = wx * xz
    val wxMyz = wx * yz
    val wyMxy = wy * xy
    val wyMxz = wy * xz
    val wyMyz = wy * yz
    val wzMxy = wz * xy
    val wzMxz = wz * xz
    val wzMyz = wz * yz
    val xyMxy = xy * xy
    val xyMxz = xy * xz
    val xyMyz = xy * yz
    val xzMxz = xz * xz
    val xzMyz = xz * yz
    val yzMyz = yz * yz
    Bivector(
      wx = 2.0 * (v.xy * (wxMxy + wzMyz) + v.xz * (wxMxz - wyMyz) + v.yz * (wxMyz + wyMxz - wzMxy)),
      wy = 2.0 * (v.xy * (wyMxy - wzMxz) + v.xz * (wxMyz + wyMxz + wzMxy) + v.yz * (wyMyz - wxMxz)),
      wz = 2.0 * (v.xy * (wyMxz + wzMxy - wxMyz) + v.xz * (wzMxz - wyMxy) + v.yz * (wxMxy + wzMyz)),
      xy = (2.0 * (v.xz * xyMxz + v.yz * xyMyz) + v.xy * (xyMxy - xzMxz - yzMyz)),
      xz = (2.0 * (v.xy * xyMxz + v.yz * xzMyz) + v.xz * (xzMxz - xyMxy - yzMyz)),
      yz = (2.0 * (v.xy * xyMyz + v.xz * xzMyz) + v.yz * (yzMyz - xyMxy - xzMxz)),
    )

  infix def reverseSandwich(v: BivectorWeight): BivectorWeight =
    val xyMxy = xy * xy
    val xyMxz = xy * xz
    val xyMyz = xy * yz
    val xzMxz = xz * xz
    val xzMyz = xz * yz
    val yzMyz = yz * yz
    BivectorWeight(
      wx = (2.0 * (v.wz * xyMyz - v.wy * xzMyz) + v.wx * (yzMyz - xyMxy - xzMxz)),
      wy = (2.0 * (-v.wx * xzMyz - v.wz * xyMxz) + v.wy * (xzMxz - xyMxy - yzMyz)),
      wz = (2.0 * (v.wx * xyMyz - v.wy * xyMxz) + v.wz * (xyMxy - xzMxz - yzMyz)),
    )

  infix def reverseSandwich(v: PseudoScalar): PseudoScalar =
    PseudoScalar(
      i = v.i * (xy * xy + xz * xz + yz * yz),
    )

  infix def reverseSandwich(v: PointCenter.type): Point =
    Point(
      wxy = 2.0 * (-wx * xz - wy * yz),
      wxz = 2.0 * (wx * xy - wz * yz),
      wyz = 2.0 * (wy * xy + wz * xz),
      xyz = (xy * xy + xz * xz + yz * yz),
    )

  infix def cross(v: Multivector): Multivector =
    Multivector(
      s = 0.0,
      w = (v.x * wx + v.y * wy + v.z * wz),
      x = (v.y * xy + v.z * xz),
      y = (v.z * yz - v.x * xy),
      z = (-v.x * xz - v.y * yz),
      wx = (v.wy * xy + v.wz * xz - v.xy * wy - v.xz * wz),
      wy = (v.wz * yz + v.xy * wx - v.wx * xy - v.yz * wz),
      wz = (v.xz * wx + v.yz * wy - v.wx * xz - v.wy * yz),
      xy = (v.xz * yz - v.yz * xz),
      xz = (v.yz * xy - v.xy * yz),
      yz = (v.xy * xz - v.xz * xy),
      wxy = (v.wxz * yz + v.xyz * wz - v.wyz * xz),
      wxz = (v.wyz * xy - v.wxy * yz - v.xyz * wy),
      wyz = (v.wxy * xz + v.xyz * wx - v.wxz * xy),
      xyz = 0.0,
      i = 0.0,
    )

  infix def cross(v: Motor): Bivector =
    Bivector(
      wx = (v.wy * xy + v.wz * xz - v.xy * wy - v.xz * wz),
      wy = (v.wz * yz + v.xy * wx - v.wx * xy - v.yz * wz),
      wz = (v.xz * wx + v.yz * wy - v.wx * xz - v.wy * yz),
      xy = (v.xz * yz - v.yz * xz),
      xz = (v.yz * xy - v.xy * yz),
      yz = (v.xy * xz - v.xz * xy),
    )

  infix def cross(v: Plane): Plane =
    Plane(
      w = (v.x * wx + v.y * wy + v.z * wz),
      x = (v.y * xy + v.z * xz),
      y = (v.z * yz - v.x * xy),
      z = (-v.x * xz - v.y * yz),
    )

  infix def cross(v: Bivector): Bivector =
    Bivector(
      wx = (v.wy * xy + v.wz * xz - v.xy * wy - v.xz * wz),
      wy = (v.wz * yz + v.xy * wx - v.wx * xy - v.yz * wz),
      wz = (v.xz * wx + v.yz * wy - v.wx * xz - v.wy * yz),
      xy = (v.xz * yz - v.yz * xz),
      xz = (v.yz * xy - v.xy * yz),
      yz = (v.xy * xz - v.xz * xy),
    )

  infix def cross(v: Point): Vector =
    Vector(
      wxy = (v.wxz * yz + v.xyz * wz - v.wyz * xz),
      wxz = (v.wyz * xy - v.wxy * yz - v.xyz * wy),
      wyz = (v.wxy * xz + v.xyz * wx - v.wxz * xy),
    )

  infix def cross(v: Quaternion): Bivector =
    Bivector(
      wx = (-v.xy * wy - v.xz * wz),
      wy = (v.xy * wx - v.yz * wz),
      wz = (v.xz * wx + v.yz * wy),
      xy = (v.xz * yz - v.yz * xz),
      xz = (v.yz * xy - v.xy * yz),
      yz = (v.xy * xz - v.xz * xy),
    )

  infix def cross(v: Translator): BivectorWeight =
    BivectorWeight(
      wx = (v.wy * xy + v.wz * xz),
      wy = (v.wz * yz - v.wx * xy),
      wz = (-v.wx * xz - v.wy * yz),
    )

  infix def cross(v: Vector): Vector =
    Vector(
      wxy = (v.wxz * yz - v.wyz * xz),
      wxz = (v.wyz * xy - v.wxy * yz),
      wyz = (v.wxy * xz - v.wxz * xy),
    )

  infix def cross(v: PointNormalized): Vector =
    Vector(
      wxy = (wz + v.wxz * yz - v.wyz * xz),
      wxz = (-wy + v.wyz * xy - v.wxy * yz),
      wyz = (wx + v.wxy * xz - v.wxz * xy),
    )

  infix def cross(v: PlaneIdeal): Plane =
    Plane(
      w = (v.x * wx + v.y * wy + v.z * wz),
      x = (v.y * xy + v.z * xz),
      y = (v.z * yz - v.x * xy),
      z = (-v.x * xz - v.y * yz),
    )

  infix def cross(v: BivectorBulk): Bivector =
    Bivector(
      wx = (-v.xy * wy - v.xz * wz),
      wy = (v.xy * wx - v.yz * wz),
      wz = (v.xz * wx + v.yz * wy),
      xy = (v.xz * yz - v.yz * xz),
      xz = (v.yz * xy - v.xy * yz),
      yz = (v.xy * xz - v.xz * xy),
    )

  infix def cross(v: BivectorWeight): BivectorWeight =
    BivectorWeight(
      wx = (v.wy * xy + v.wz * xz),
      wy = (v.wz * yz - v.wx * xy),
      wz = (-v.wx * xz - v.wy * yz),
    )

  infix def cross(v: PointCenter.type): Vector =
    Vector(
      wxy = wz,
      wxz = -wy,
      wyz = wx,
    )