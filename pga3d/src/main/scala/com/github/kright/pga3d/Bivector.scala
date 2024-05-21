package com.github.kright.pga3d

/** this code is generated, see com.github.kright.pga3d.codegen.MultivectorSubClass */
case class Bivector(
                     wx: Double = 0.0,
                     wy: Double = 0.0,
                     wz: Double = 0.0,
                     xy: Double = 0.0,
                     xz: Double = 0.0,
                     yz: Double = 0.0,
                   ):

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

  def reverse: Bivector =
    Bivector(
      wx = -wx,
      wy = -wy,
      wz = -wz,
      xy = -xy,
      xz = -xz,
      yz = -yz,
    )

  def antiReverse: Bivector =
    Bivector(
      wx = -wx,
      wy = -wy,
      wz = -wz,
      xy = -xy,
      xz = -xz,
      yz = -yz,
    )

  def unary_ : Bivector =
    Bivector(
      wx = -wx,
      wy = -wy,
      wz = -wz,
      xy = -xy,
      xz = -xz,
      yz = -yz,
    )

  def bulkNormSquare: Double =
    (xy * xy + xz * xz + yz * yz)

  def weightNormSquare: Double =
    (wx * wx + wy * wy + wz * wz)

  def normSquare: Double =
    (wx * wx + wy * wy + wz * wz + xy * xy + xz * xz + yz * yz)

  def bulkNorm: Double =
    Math.sqrt(bulkNormSquare)

  def normalizedByBulk =
    this / bulkNorm

  def weightNorm: Double =
    Math.sqrt(weightNormSquare)

  def normalizedByWeight =
    this / weightNorm

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

  def multiplyElementwise(v: Bivector): Bivector =
    Bivector(
      wx = v.wx * wx,
      wy = v.wy * wy,
      wz = v.wz * wz,
      xy = v.xy * xy,
      xz = v.xz * xz,
      yz = v.yz * yz,
    )

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

  infix def geometric(v: QuaternionDual): QuaternionDual =
    QuaternionDual(
      wx = (v.wy * xy + v.wz * xz - v.i * yz),
      wy = (v.i * xz + v.wz * yz - v.wx * xy),
      wz = (-v.i * xy - v.wx * xz - v.wy * yz),
      i = (v.wx * yz + v.wz * xy - v.wy * xz),
    )

  infix def geometric(v: PointIdeal): Multivector =
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

  infix def geometric(v: BivectorWeight): QuaternionDual =
    QuaternionDual(
      wx = (v.wy * xy + v.wz * xz),
      wy = (v.wz * yz - v.wx * xy),
      wz = (-v.wx * xz - v.wy * yz),
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

  infix def dot(v: QuaternionDual): BivectorWeight =
    BivectorWeight(
      wx = -v.i * yz,
      wy = v.i * xz,
      wz = -v.i * xy,
    )

  infix def dot(v: PointIdeal): Plane =
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

  infix def wedge(v: QuaternionDual): PseudoScalar =
    PseudoScalar(
      i = (v.wx * yz + v.wz * xy - v.wy * xz),
    )

  inline infix def ^(v: QuaternionDual): PseudoScalar = wedge(v)

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

  infix def sandwich(v: Multivector): Multivector =
    Multivector(
      s = (v.s * xy * xy + v.s * xz * xz + v.s * yz * yz),
      w = (v.w * xy * xy + v.w * xz * xz + v.w * yz * yz - 2.0 * v.x * wy * xy - 2.0 * v.x * wz * xz - 2.0 * v.y * wz * yz + 2.0 * v.y * wx * xy + 2.0 * v.z * wx * xz + 2.0 * v.z * wy * yz),
      x = (v.x * yz * yz - 2.0 * v.y * xz * yz - v.x * xy * xy - v.x * xz * xz + 2.0 * v.z * xy * yz),
      y = (v.y * xz * xz - 2.0 * v.x * xz * yz - 2.0 * v.z * xy * xz - v.y * xy * xy - v.y * yz * yz),
      z = (v.z * xy * xy - 2.0 * v.y * xy * xz - v.z * xz * xz - v.z * yz * yz + 2.0 * v.x * xy * yz),
      wx = (v.wx * yz * yz - 2.0 * v.wy * xz * yz - 2.0 * v.xz * wy * yz - 2.0 * v.yz * wz * xy - v.wx * xy * xy - v.wx * xz * xz + 2.0 * v.wz * xy * yz + 2.0 * v.xy * wx * xy + 2.0 * v.xy * wz * yz + 2.0 * v.xz * wx * xz + 2.0 * v.yz * wx * yz + 2.0 * v.yz * wy * xz),
      wy = (v.wy * xz * xz - 2.0 * v.wx * xz * yz - 2.0 * v.wz * xy * xz - 2.0 * v.xy * wz * xz - 2.0 * v.yz * wx * xz - v.wy * xy * xy - v.wy * yz * yz + 2.0 * v.xy * wy * xy + 2.0 * v.xz * wx * yz + 2.0 * v.xz * wy * xz + 2.0 * v.xz * wz * xy + 2.0 * v.yz * wy * yz),
      wz = (v.wz * xy * xy - 2.0 * v.wy * xy * xz - 2.0 * v.xy * wx * yz - 2.0 * v.xz * wy * xy - v.wz * xz * xz - v.wz * yz * yz + 2.0 * v.wx * xy * yz + 2.0 * v.xy * wy * xz + 2.0 * v.xy * wz * xy + 2.0 * v.xz * wz * xz + 2.0 * v.yz * wx * xy + 2.0 * v.yz * wz * yz),
      xy = (v.xy * xy * xy - v.xy * xz * xz - v.xy * yz * yz + 2.0 * v.xz * xy * xz + 2.0 * v.yz * xy * yz),
      xz = (v.xz * xz * xz - v.xz * xy * xy - v.xz * yz * yz + 2.0 * v.xy * xy * xz + 2.0 * v.yz * xz * yz),
      yz = (v.yz * yz * yz - v.yz * xy * xy - v.yz * xz * xz + 2.0 * v.xy * xy * yz + 2.0 * v.xz * xz * yz),
      wxy = (v.wxy * xy * xy - 2.0 * v.xyz * wx * xz - 2.0 * v.xyz * wy * yz - v.wxy * xz * xz - v.wxy * yz * yz + 2.0 * v.wxz * xy * xz + 2.0 * v.wyz * xy * yz),
      wxz = (v.wxz * xz * xz - 2.0 * v.xyz * wz * yz - v.wxz * xy * xy - v.wxz * yz * yz + 2.0 * v.wxy * xy * xz + 2.0 * v.wyz * xz * yz + 2.0 * v.xyz * wx * xy),
      wyz = (v.wyz * yz * yz - v.wyz * xy * xy - v.wyz * xz * xz + 2.0 * v.wxy * xy * yz + 2.0 * v.wxz * xz * yz + 2.0 * v.xyz * wy * xy + 2.0 * v.xyz * wz * xz),
      xyz = (v.xyz * xy * xy + v.xyz * xz * xz + v.xyz * yz * yz),
      i = (v.i * xy * xy + v.i * xz * xz + v.i * yz * yz - 2.0 * v.s * wx * yz - 2.0 * v.s * wz * xy + 2.0 * v.s * wy * xz),
    )

  infix def sandwich(v: Motor): Motor =
    Motor(
      s = (v.s * xy * xy + v.s * xz * xz + v.s * yz * yz),
      wx = (v.wx * yz * yz - 2.0 * v.wy * xz * yz - 2.0 * v.xz * wy * yz - 2.0 * v.yz * wz * xy - v.wx * xy * xy - v.wx * xz * xz + 2.0 * v.wz * xy * yz + 2.0 * v.xy * wx * xy + 2.0 * v.xy * wz * yz + 2.0 * v.xz * wx * xz + 2.0 * v.yz * wx * yz + 2.0 * v.yz * wy * xz),
      wy = (v.wy * xz * xz - 2.0 * v.wx * xz * yz - 2.0 * v.wz * xy * xz - 2.0 * v.xy * wz * xz - 2.0 * v.yz * wx * xz - v.wy * xy * xy - v.wy * yz * yz + 2.0 * v.xy * wy * xy + 2.0 * v.xz * wx * yz + 2.0 * v.xz * wy * xz + 2.0 * v.xz * wz * xy + 2.0 * v.yz * wy * yz),
      wz = (v.wz * xy * xy - 2.0 * v.wy * xy * xz - 2.0 * v.xy * wx * yz - 2.0 * v.xz * wy * xy - v.wz * xz * xz - v.wz * yz * yz + 2.0 * v.wx * xy * yz + 2.0 * v.xy * wy * xz + 2.0 * v.xy * wz * xy + 2.0 * v.xz * wz * xz + 2.0 * v.yz * wx * xy + 2.0 * v.yz * wz * yz),
      xy = (v.xy * xy * xy - v.xy * xz * xz - v.xy * yz * yz + 2.0 * v.xz * xy * xz + 2.0 * v.yz * xy * yz),
      xz = (v.xz * xz * xz - v.xz * xy * xy - v.xz * yz * yz + 2.0 * v.xy * xy * xz + 2.0 * v.yz * xz * yz),
      yz = (v.yz * yz * yz - v.yz * xy * xy - v.yz * xz * xz + 2.0 * v.xy * xy * yz + 2.0 * v.xz * xz * yz),
      i = (v.i * xy * xy + v.i * xz * xz + v.i * yz * yz - 2.0 * v.s * wx * yz - 2.0 * v.s * wz * xy + 2.0 * v.s * wy * xz),
    )

  infix def sandwich(v: Plane): Plane =
    Plane(
      w = (v.w * xy * xy + v.w * xz * xz + v.w * yz * yz - 2.0 * v.x * wy * xy - 2.0 * v.x * wz * xz - 2.0 * v.y * wz * yz + 2.0 * v.y * wx * xy + 2.0 * v.z * wx * xz + 2.0 * v.z * wy * yz),
      x = (v.x * yz * yz - 2.0 * v.y * xz * yz - v.x * xy * xy - v.x * xz * xz + 2.0 * v.z * xy * yz),
      y = (v.y * xz * xz - 2.0 * v.x * xz * yz - 2.0 * v.z * xy * xz - v.y * xy * xy - v.y * yz * yz),
      z = (v.z * xy * xy - 2.0 * v.y * xy * xz - v.z * xz * xz - v.z * yz * yz + 2.0 * v.x * xy * yz),
    )

  infix def sandwich(v: Bivector): Bivector =
    Bivector(
      wx = (v.wx * yz * yz - 2.0 * v.wy * xz * yz - 2.0 * v.xz * wy * yz - 2.0 * v.yz * wz * xy - v.wx * xy * xy - v.wx * xz * xz + 2.0 * v.wz * xy * yz + 2.0 * v.xy * wx * xy + 2.0 * v.xy * wz * yz + 2.0 * v.xz * wx * xz + 2.0 * v.yz * wx * yz + 2.0 * v.yz * wy * xz),
      wy = (v.wy * xz * xz - 2.0 * v.wx * xz * yz - 2.0 * v.wz * xy * xz - 2.0 * v.xy * wz * xz - 2.0 * v.yz * wx * xz - v.wy * xy * xy - v.wy * yz * yz + 2.0 * v.xy * wy * xy + 2.0 * v.xz * wx * yz + 2.0 * v.xz * wy * xz + 2.0 * v.xz * wz * xy + 2.0 * v.yz * wy * yz),
      wz = (v.wz * xy * xy - 2.0 * v.wy * xy * xz - 2.0 * v.xy * wx * yz - 2.0 * v.xz * wy * xy - v.wz * xz * xz - v.wz * yz * yz + 2.0 * v.wx * xy * yz + 2.0 * v.xy * wy * xz + 2.0 * v.xy * wz * xy + 2.0 * v.xz * wz * xz + 2.0 * v.yz * wx * xy + 2.0 * v.yz * wz * yz),
      xy = (v.xy * xy * xy - v.xy * xz * xz - v.xy * yz * yz + 2.0 * v.xz * xy * xz + 2.0 * v.yz * xy * yz),
      xz = (v.xz * xz * xz - v.xz * xy * xy - v.xz * yz * yz + 2.0 * v.xy * xy * xz + 2.0 * v.yz * xz * yz),
      yz = (v.yz * yz * yz - v.yz * xy * xy - v.yz * xz * xz + 2.0 * v.xy * xy * yz + 2.0 * v.xz * xz * yz),
    )

  infix def sandwich(v: Point): Point =
    Point(
      wxy = (v.wxy * xy * xy - 2.0 * v.xyz * wx * xz - 2.0 * v.xyz * wy * yz - v.wxy * xz * xz - v.wxy * yz * yz + 2.0 * v.wxz * xy * xz + 2.0 * v.wyz * xy * yz),
      wxz = (v.wxz * xz * xz - 2.0 * v.xyz * wz * yz - v.wxz * xy * xy - v.wxz * yz * yz + 2.0 * v.wxy * xy * xz + 2.0 * v.wyz * xz * yz + 2.0 * v.xyz * wx * xy),
      wyz = (v.wyz * yz * yz - v.wyz * xy * xy - v.wyz * xz * xz + 2.0 * v.wxy * xy * yz + 2.0 * v.wxz * xz * yz + 2.0 * v.xyz * wy * xy + 2.0 * v.xyz * wz * xz),
      xyz = (v.xyz * xy * xy + v.xyz * xz * xz + v.xyz * yz * yz),
    )

  infix def sandwich(v: Quaternion): Motor =
    Motor(
      s = (v.s * xy * xy + v.s * xz * xz + v.s * yz * yz),
      wx = (-2.0 * v.xz * wy * yz - 2.0 * v.yz * wz * xy + 2.0 * v.xy * wx * xy + 2.0 * v.xy * wz * yz + 2.0 * v.xz * wx * xz + 2.0 * v.yz * wx * yz + 2.0 * v.yz * wy * xz),
      wy = (-2.0 * v.xy * wz * xz - 2.0 * v.yz * wx * xz + 2.0 * v.xy * wy * xy + 2.0 * v.xz * wx * yz + 2.0 * v.xz * wy * xz + 2.0 * v.xz * wz * xy + 2.0 * v.yz * wy * yz),
      wz = (-2.0 * v.xy * wx * yz - 2.0 * v.xz * wy * xy + 2.0 * v.xy * wy * xz + 2.0 * v.xy * wz * xy + 2.0 * v.xz * wz * xz + 2.0 * v.yz * wx * xy + 2.0 * v.yz * wz * yz),
      xy = (v.xy * xy * xy - v.xy * xz * xz - v.xy * yz * yz + 2.0 * v.xz * xy * xz + 2.0 * v.yz * xy * yz),
      xz = (v.xz * xz * xz - v.xz * xy * xy - v.xz * yz * yz + 2.0 * v.xy * xy * xz + 2.0 * v.yz * xz * yz),
      yz = (v.yz * yz * yz - v.yz * xy * xy - v.yz * xz * xz + 2.0 * v.xy * xy * yz + 2.0 * v.xz * xz * yz),
      i = (-2.0 * v.s * wx * yz - 2.0 * v.s * wz * xy + 2.0 * v.s * wy * xz),
    )

  infix def sandwich(v: QuaternionDual): QuaternionDual =
    QuaternionDual(
      wx = (v.wx * yz * yz - 2.0 * v.wy * xz * yz - v.wx * xy * xy - v.wx * xz * xz + 2.0 * v.wz * xy * yz),
      wy = (v.wy * xz * xz - 2.0 * v.wx * xz * yz - 2.0 * v.wz * xy * xz - v.wy * xy * xy - v.wy * yz * yz),
      wz = (v.wz * xy * xy - 2.0 * v.wy * xy * xz - v.wz * xz * xz - v.wz * yz * yz + 2.0 * v.wx * xy * yz),
      i = (v.i * xy * xy + v.i * xz * xz + v.i * yz * yz),
    )

  infix def sandwich(v: PointIdeal): PointIdeal =
    PointIdeal(
      wxy = (v.wxy * xy * xy - v.wxy * xz * xz - v.wxy * yz * yz + 2.0 * v.wxz * xy * xz + 2.0 * v.wyz * xy * yz),
      wxz = (v.wxz * xz * xz - v.wxz * xy * xy - v.wxz * yz * yz + 2.0 * v.wxy * xy * xz + 2.0 * v.wyz * xz * yz),
      wyz = (v.wyz * yz * yz - v.wyz * xy * xy - v.wyz * xz * xz + 2.0 * v.wxy * xy * yz + 2.0 * v.wxz * xz * yz),
    )

  infix def sandwich(v: PointNormalized): Point =
    Point(
      wxy = (-2.0 * wx * xz - 2.0 * wy * yz + v.wxy * xy * xy - v.wxy * xz * xz - v.wxy * yz * yz + 2.0 * v.wxz * xy * xz + 2.0 * v.wyz * xy * yz),
      wxz = (-2.0 * wz * yz + 2.0 * wx * xy + v.wxz * xz * xz - v.wxz * xy * xy - v.wxz * yz * yz + 2.0 * v.wxy * xy * xz + 2.0 * v.wyz * xz * yz),
      wyz = (2.0 * wy * xy + 2.0 * wz * xz + v.wyz * yz * yz - v.wyz * xy * xy - v.wyz * xz * xz + 2.0 * v.wxy * xy * yz + 2.0 * v.wxz * xz * yz),
      xyz = (xy * xy + xz * xz + yz * yz),
    )

  infix def sandwich(v: PlaneIdeal): Plane =
    Plane(
      w = (-2.0 * v.x * wy * xy - 2.0 * v.x * wz * xz - 2.0 * v.y * wz * yz + 2.0 * v.y * wx * xy + 2.0 * v.z * wx * xz + 2.0 * v.z * wy * yz),
      x = (v.x * yz * yz - 2.0 * v.y * xz * yz - v.x * xy * xy - v.x * xz * xz + 2.0 * v.z * xy * yz),
      y = (v.y * xz * xz - 2.0 * v.x * xz * yz - 2.0 * v.z * xy * xz - v.y * xy * xy - v.y * yz * yz),
      z = (v.z * xy * xy - 2.0 * v.y * xy * xz - v.z * xz * xz - v.z * yz * yz + 2.0 * v.x * xy * yz),
    )

  infix def sandwich(v: BivectorBulk): Bivector =
    Bivector(
      wx = (-2.0 * v.xz * wy * yz - 2.0 * v.yz * wz * xy + 2.0 * v.xy * wx * xy + 2.0 * v.xy * wz * yz + 2.0 * v.xz * wx * xz + 2.0 * v.yz * wx * yz + 2.0 * v.yz * wy * xz),
      wy = (-2.0 * v.xy * wz * xz - 2.0 * v.yz * wx * xz + 2.0 * v.xy * wy * xy + 2.0 * v.xz * wx * yz + 2.0 * v.xz * wy * xz + 2.0 * v.xz * wz * xy + 2.0 * v.yz * wy * yz),
      wz = (-2.0 * v.xy * wx * yz - 2.0 * v.xz * wy * xy + 2.0 * v.xy * wy * xz + 2.0 * v.xy * wz * xy + 2.0 * v.xz * wz * xz + 2.0 * v.yz * wx * xy + 2.0 * v.yz * wz * yz),
      xy = (v.xy * xy * xy - v.xy * xz * xz - v.xy * yz * yz + 2.0 * v.xz * xy * xz + 2.0 * v.yz * xy * yz),
      xz = (v.xz * xz * xz - v.xz * xy * xy - v.xz * yz * yz + 2.0 * v.xy * xy * xz + 2.0 * v.yz * xz * yz),
      yz = (v.yz * yz * yz - v.yz * xy * xy - v.yz * xz * xz + 2.0 * v.xy * xy * yz + 2.0 * v.xz * xz * yz),
    )

  infix def sandwich(v: BivectorWeight): BivectorWeight =
    BivectorWeight(
      wx = (v.wx * yz * yz - 2.0 * v.wy * xz * yz - v.wx * xy * xy - v.wx * xz * xz + 2.0 * v.wz * xy * yz),
      wy = (v.wy * xz * xz - 2.0 * v.wx * xz * yz - 2.0 * v.wz * xy * xz - v.wy * xy * xy - v.wy * yz * yz),
      wz = (v.wz * xy * xy - 2.0 * v.wy * xy * xz - v.wz * xz * xz - v.wz * yz * yz + 2.0 * v.wx * xy * yz),
    )

  infix def sandwich(v: PseudoScalar): PseudoScalar =
    PseudoScalar(
      i = (v.i * xy * xy + v.i * xz * xz + v.i * yz * yz),
    )

  infix def sandwich(v: PointCenter.type): Point =
    Point(
      wxy = (-2.0 * wx * xz - 2.0 * wy * yz),
      wxz = (-2.0 * wz * yz + 2.0 * wx * xy),
      wyz = (2.0 * wy * xy + 2.0 * wz * xz),
      xyz = (xy * xy + xz * xz + yz * yz),
    )

  infix def reverseSandwich(v: Multivector): Multivector =
    Multivector(
      s = (v.s * xy * xy + v.s * xz * xz + v.s * yz * yz),
      w = (v.w * xy * xy + v.w * xz * xz + v.w * yz * yz - 2.0 * v.x * wy * xy - 2.0 * v.x * wz * xz - 2.0 * v.y * wz * yz + 2.0 * v.y * wx * xy + 2.0 * v.z * wx * xz + 2.0 * v.z * wy * yz),
      x = (v.x * yz * yz - 2.0 * v.y * xz * yz - v.x * xy * xy - v.x * xz * xz + 2.0 * v.z * xy * yz),
      y = (v.y * xz * xz - 2.0 * v.x * xz * yz - 2.0 * v.z * xy * xz - v.y * xy * xy - v.y * yz * yz),
      z = (v.z * xy * xy - 2.0 * v.y * xy * xz - v.z * xz * xz - v.z * yz * yz + 2.0 * v.x * xy * yz),
      wx = (v.wx * yz * yz - 2.0 * v.wy * xz * yz - 2.0 * v.xz * wy * yz - 2.0 * v.yz * wz * xy - v.wx * xy * xy - v.wx * xz * xz + 2.0 * v.wz * xy * yz + 2.0 * v.xy * wx * xy + 2.0 * v.xy * wz * yz + 2.0 * v.xz * wx * xz + 2.0 * v.yz * wx * yz + 2.0 * v.yz * wy * xz),
      wy = (v.wy * xz * xz - 2.0 * v.wx * xz * yz - 2.0 * v.wz * xy * xz - 2.0 * v.xy * wz * xz - 2.0 * v.yz * wx * xz - v.wy * xy * xy - v.wy * yz * yz + 2.0 * v.xy * wy * xy + 2.0 * v.xz * wx * yz + 2.0 * v.xz * wy * xz + 2.0 * v.xz * wz * xy + 2.0 * v.yz * wy * yz),
      wz = (v.wz * xy * xy - 2.0 * v.wy * xy * xz - 2.0 * v.xy * wx * yz - 2.0 * v.xz * wy * xy - v.wz * xz * xz - v.wz * yz * yz + 2.0 * v.wx * xy * yz + 2.0 * v.xy * wy * xz + 2.0 * v.xy * wz * xy + 2.0 * v.xz * wz * xz + 2.0 * v.yz * wx * xy + 2.0 * v.yz * wz * yz),
      xy = (v.xy * xy * xy - v.xy * xz * xz - v.xy * yz * yz + 2.0 * v.xz * xy * xz + 2.0 * v.yz * xy * yz),
      xz = (v.xz * xz * xz - v.xz * xy * xy - v.xz * yz * yz + 2.0 * v.xy * xy * xz + 2.0 * v.yz * xz * yz),
      yz = (v.yz * yz * yz - v.yz * xy * xy - v.yz * xz * xz + 2.0 * v.xy * xy * yz + 2.0 * v.xz * xz * yz),
      wxy = (v.wxy * xy * xy - 2.0 * v.xyz * wx * xz - 2.0 * v.xyz * wy * yz - v.wxy * xz * xz - v.wxy * yz * yz + 2.0 * v.wxz * xy * xz + 2.0 * v.wyz * xy * yz),
      wxz = (v.wxz * xz * xz - 2.0 * v.xyz * wz * yz - v.wxz * xy * xy - v.wxz * yz * yz + 2.0 * v.wxy * xy * xz + 2.0 * v.wyz * xz * yz + 2.0 * v.xyz * wx * xy),
      wyz = (v.wyz * yz * yz - v.wyz * xy * xy - v.wyz * xz * xz + 2.0 * v.wxy * xy * yz + 2.0 * v.wxz * xz * yz + 2.0 * v.xyz * wy * xy + 2.0 * v.xyz * wz * xz),
      xyz = (v.xyz * xy * xy + v.xyz * xz * xz + v.xyz * yz * yz),
      i = (v.i * xy * xy + v.i * xz * xz + v.i * yz * yz - 2.0 * v.s * wx * yz - 2.0 * v.s * wz * xy + 2.0 * v.s * wy * xz),
    )

  infix def reverseSandwich(v: Motor): Motor =
    Motor(
      s = (v.s * xy * xy + v.s * xz * xz + v.s * yz * yz),
      wx = (v.wx * yz * yz - 2.0 * v.wy * xz * yz - 2.0 * v.xz * wy * yz - 2.0 * v.yz * wz * xy - v.wx * xy * xy - v.wx * xz * xz + 2.0 * v.wz * xy * yz + 2.0 * v.xy * wx * xy + 2.0 * v.xy * wz * yz + 2.0 * v.xz * wx * xz + 2.0 * v.yz * wx * yz + 2.0 * v.yz * wy * xz),
      wy = (v.wy * xz * xz - 2.0 * v.wx * xz * yz - 2.0 * v.wz * xy * xz - 2.0 * v.xy * wz * xz - 2.0 * v.yz * wx * xz - v.wy * xy * xy - v.wy * yz * yz + 2.0 * v.xy * wy * xy + 2.0 * v.xz * wx * yz + 2.0 * v.xz * wy * xz + 2.0 * v.xz * wz * xy + 2.0 * v.yz * wy * yz),
      wz = (v.wz * xy * xy - 2.0 * v.wy * xy * xz - 2.0 * v.xy * wx * yz - 2.0 * v.xz * wy * xy - v.wz * xz * xz - v.wz * yz * yz + 2.0 * v.wx * xy * yz + 2.0 * v.xy * wy * xz + 2.0 * v.xy * wz * xy + 2.0 * v.xz * wz * xz + 2.0 * v.yz * wx * xy + 2.0 * v.yz * wz * yz),
      xy = (v.xy * xy * xy - v.xy * xz * xz - v.xy * yz * yz + 2.0 * v.xz * xy * xz + 2.0 * v.yz * xy * yz),
      xz = (v.xz * xz * xz - v.xz * xy * xy - v.xz * yz * yz + 2.0 * v.xy * xy * xz + 2.0 * v.yz * xz * yz),
      yz = (v.yz * yz * yz - v.yz * xy * xy - v.yz * xz * xz + 2.0 * v.xy * xy * yz + 2.0 * v.xz * xz * yz),
      i = (v.i * xy * xy + v.i * xz * xz + v.i * yz * yz - 2.0 * v.s * wx * yz - 2.0 * v.s * wz * xy + 2.0 * v.s * wy * xz),
    )

  infix def reverseSandwich(v: Plane): Plane =
    Plane(
      w = (v.w * xy * xy + v.w * xz * xz + v.w * yz * yz - 2.0 * v.x * wy * xy - 2.0 * v.x * wz * xz - 2.0 * v.y * wz * yz + 2.0 * v.y * wx * xy + 2.0 * v.z * wx * xz + 2.0 * v.z * wy * yz),
      x = (v.x * yz * yz - 2.0 * v.y * xz * yz - v.x * xy * xy - v.x * xz * xz + 2.0 * v.z * xy * yz),
      y = (v.y * xz * xz - 2.0 * v.x * xz * yz - 2.0 * v.z * xy * xz - v.y * xy * xy - v.y * yz * yz),
      z = (v.z * xy * xy - 2.0 * v.y * xy * xz - v.z * xz * xz - v.z * yz * yz + 2.0 * v.x * xy * yz),
    )

  infix def reverseSandwich(v: Bivector): Bivector =
    Bivector(
      wx = (v.wx * yz * yz - 2.0 * v.wy * xz * yz - 2.0 * v.xz * wy * yz - 2.0 * v.yz * wz * xy - v.wx * xy * xy - v.wx * xz * xz + 2.0 * v.wz * xy * yz + 2.0 * v.xy * wx * xy + 2.0 * v.xy * wz * yz + 2.0 * v.xz * wx * xz + 2.0 * v.yz * wx * yz + 2.0 * v.yz * wy * xz),
      wy = (v.wy * xz * xz - 2.0 * v.wx * xz * yz - 2.0 * v.wz * xy * xz - 2.0 * v.xy * wz * xz - 2.0 * v.yz * wx * xz - v.wy * xy * xy - v.wy * yz * yz + 2.0 * v.xy * wy * xy + 2.0 * v.xz * wx * yz + 2.0 * v.xz * wy * xz + 2.0 * v.xz * wz * xy + 2.0 * v.yz * wy * yz),
      wz = (v.wz * xy * xy - 2.0 * v.wy * xy * xz - 2.0 * v.xy * wx * yz - 2.0 * v.xz * wy * xy - v.wz * xz * xz - v.wz * yz * yz + 2.0 * v.wx * xy * yz + 2.0 * v.xy * wy * xz + 2.0 * v.xy * wz * xy + 2.0 * v.xz * wz * xz + 2.0 * v.yz * wx * xy + 2.0 * v.yz * wz * yz),
      xy = (v.xy * xy * xy - v.xy * xz * xz - v.xy * yz * yz + 2.0 * v.xz * xy * xz + 2.0 * v.yz * xy * yz),
      xz = (v.xz * xz * xz - v.xz * xy * xy - v.xz * yz * yz + 2.0 * v.xy * xy * xz + 2.0 * v.yz * xz * yz),
      yz = (v.yz * yz * yz - v.yz * xy * xy - v.yz * xz * xz + 2.0 * v.xy * xy * yz + 2.0 * v.xz * xz * yz),
    )

  infix def reverseSandwich(v: Point): Point =
    Point(
      wxy = (v.wxy * xy * xy - 2.0 * v.xyz * wx * xz - 2.0 * v.xyz * wy * yz - v.wxy * xz * xz - v.wxy * yz * yz + 2.0 * v.wxz * xy * xz + 2.0 * v.wyz * xy * yz),
      wxz = (v.wxz * xz * xz - 2.0 * v.xyz * wz * yz - v.wxz * xy * xy - v.wxz * yz * yz + 2.0 * v.wxy * xy * xz + 2.0 * v.wyz * xz * yz + 2.0 * v.xyz * wx * xy),
      wyz = (v.wyz * yz * yz - v.wyz * xy * xy - v.wyz * xz * xz + 2.0 * v.wxy * xy * yz + 2.0 * v.wxz * xz * yz + 2.0 * v.xyz * wy * xy + 2.0 * v.xyz * wz * xz),
      xyz = (v.xyz * xy * xy + v.xyz * xz * xz + v.xyz * yz * yz),
    )

  infix def reverseSandwich(v: Quaternion): Motor =
    Motor(
      s = (v.s * xy * xy + v.s * xz * xz + v.s * yz * yz),
      wx = (-2.0 * v.xz * wy * yz - 2.0 * v.yz * wz * xy + 2.0 * v.xy * wx * xy + 2.0 * v.xy * wz * yz + 2.0 * v.xz * wx * xz + 2.0 * v.yz * wx * yz + 2.0 * v.yz * wy * xz),
      wy = (-2.0 * v.xy * wz * xz - 2.0 * v.yz * wx * xz + 2.0 * v.xy * wy * xy + 2.0 * v.xz * wx * yz + 2.0 * v.xz * wy * xz + 2.0 * v.xz * wz * xy + 2.0 * v.yz * wy * yz),
      wz = (-2.0 * v.xy * wx * yz - 2.0 * v.xz * wy * xy + 2.0 * v.xy * wy * xz + 2.0 * v.xy * wz * xy + 2.0 * v.xz * wz * xz + 2.0 * v.yz * wx * xy + 2.0 * v.yz * wz * yz),
      xy = (v.xy * xy * xy - v.xy * xz * xz - v.xy * yz * yz + 2.0 * v.xz * xy * xz + 2.0 * v.yz * xy * yz),
      xz = (v.xz * xz * xz - v.xz * xy * xy - v.xz * yz * yz + 2.0 * v.xy * xy * xz + 2.0 * v.yz * xz * yz),
      yz = (v.yz * yz * yz - v.yz * xy * xy - v.yz * xz * xz + 2.0 * v.xy * xy * yz + 2.0 * v.xz * xz * yz),
      i = (-2.0 * v.s * wx * yz - 2.0 * v.s * wz * xy + 2.0 * v.s * wy * xz),
    )

  infix def reverseSandwich(v: QuaternionDual): QuaternionDual =
    QuaternionDual(
      wx = (v.wx * yz * yz - 2.0 * v.wy * xz * yz - v.wx * xy * xy - v.wx * xz * xz + 2.0 * v.wz * xy * yz),
      wy = (v.wy * xz * xz - 2.0 * v.wx * xz * yz - 2.0 * v.wz * xy * xz - v.wy * xy * xy - v.wy * yz * yz),
      wz = (v.wz * xy * xy - 2.0 * v.wy * xy * xz - v.wz * xz * xz - v.wz * yz * yz + 2.0 * v.wx * xy * yz),
      i = (v.i * xy * xy + v.i * xz * xz + v.i * yz * yz),
    )

  infix def reverseSandwich(v: PointIdeal): PointIdeal =
    PointIdeal(
      wxy = (v.wxy * xy * xy - v.wxy * xz * xz - v.wxy * yz * yz + 2.0 * v.wxz * xy * xz + 2.0 * v.wyz * xy * yz),
      wxz = (v.wxz * xz * xz - v.wxz * xy * xy - v.wxz * yz * yz + 2.0 * v.wxy * xy * xz + 2.0 * v.wyz * xz * yz),
      wyz = (v.wyz * yz * yz - v.wyz * xy * xy - v.wyz * xz * xz + 2.0 * v.wxy * xy * yz + 2.0 * v.wxz * xz * yz),
    )

  infix def reverseSandwich(v: PointNormalized): Point =
    Point(
      wxy = (-2.0 * wx * xz - 2.0 * wy * yz + v.wxy * xy * xy - v.wxy * xz * xz - v.wxy * yz * yz + 2.0 * v.wxz * xy * xz + 2.0 * v.wyz * xy * yz),
      wxz = (-2.0 * wz * yz + 2.0 * wx * xy + v.wxz * xz * xz - v.wxz * xy * xy - v.wxz * yz * yz + 2.0 * v.wxy * xy * xz + 2.0 * v.wyz * xz * yz),
      wyz = (2.0 * wy * xy + 2.0 * wz * xz + v.wyz * yz * yz - v.wyz * xy * xy - v.wyz * xz * xz + 2.0 * v.wxy * xy * yz + 2.0 * v.wxz * xz * yz),
      xyz = (xy * xy + xz * xz + yz * yz),
    )

  infix def reverseSandwich(v: PlaneIdeal): Plane =
    Plane(
      w = (-2.0 * v.x * wy * xy - 2.0 * v.x * wz * xz - 2.0 * v.y * wz * yz + 2.0 * v.y * wx * xy + 2.0 * v.z * wx * xz + 2.0 * v.z * wy * yz),
      x = (v.x * yz * yz - 2.0 * v.y * xz * yz - v.x * xy * xy - v.x * xz * xz + 2.0 * v.z * xy * yz),
      y = (v.y * xz * xz - 2.0 * v.x * xz * yz - 2.0 * v.z * xy * xz - v.y * xy * xy - v.y * yz * yz),
      z = (v.z * xy * xy - 2.0 * v.y * xy * xz - v.z * xz * xz - v.z * yz * yz + 2.0 * v.x * xy * yz),
    )

  infix def reverseSandwich(v: BivectorBulk): Bivector =
    Bivector(
      wx = (-2.0 * v.xz * wy * yz - 2.0 * v.yz * wz * xy + 2.0 * v.xy * wx * xy + 2.0 * v.xy * wz * yz + 2.0 * v.xz * wx * xz + 2.0 * v.yz * wx * yz + 2.0 * v.yz * wy * xz),
      wy = (-2.0 * v.xy * wz * xz - 2.0 * v.yz * wx * xz + 2.0 * v.xy * wy * xy + 2.0 * v.xz * wx * yz + 2.0 * v.xz * wy * xz + 2.0 * v.xz * wz * xy + 2.0 * v.yz * wy * yz),
      wz = (-2.0 * v.xy * wx * yz - 2.0 * v.xz * wy * xy + 2.0 * v.xy * wy * xz + 2.0 * v.xy * wz * xy + 2.0 * v.xz * wz * xz + 2.0 * v.yz * wx * xy + 2.0 * v.yz * wz * yz),
      xy = (v.xy * xy * xy - v.xy * xz * xz - v.xy * yz * yz + 2.0 * v.xz * xy * xz + 2.0 * v.yz * xy * yz),
      xz = (v.xz * xz * xz - v.xz * xy * xy - v.xz * yz * yz + 2.0 * v.xy * xy * xz + 2.0 * v.yz * xz * yz),
      yz = (v.yz * yz * yz - v.yz * xy * xy - v.yz * xz * xz + 2.0 * v.xy * xy * yz + 2.0 * v.xz * xz * yz),
    )

  infix def reverseSandwich(v: BivectorWeight): BivectorWeight =
    BivectorWeight(
      wx = (v.wx * yz * yz - 2.0 * v.wy * xz * yz - v.wx * xy * xy - v.wx * xz * xz + 2.0 * v.wz * xy * yz),
      wy = (v.wy * xz * xz - 2.0 * v.wx * xz * yz - 2.0 * v.wz * xy * xz - v.wy * xy * xy - v.wy * yz * yz),
      wz = (v.wz * xy * xy - 2.0 * v.wy * xy * xz - v.wz * xz * xz - v.wz * yz * yz + 2.0 * v.wx * xy * yz),
    )

  infix def reverseSandwich(v: PseudoScalar): PseudoScalar =
    PseudoScalar(
      i = (v.i * xy * xy + v.i * xz * xz + v.i * yz * yz),
    )

  infix def reverseSandwich(v: PointCenter.type): Point =
    Point(
      wxy = (-2.0 * wx * xz - 2.0 * wy * yz),
      wxz = (-2.0 * wz * yz + 2.0 * wx * xy),
      wyz = (2.0 * wy * xy + 2.0 * wz * xz),
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

  infix def cross(v: Point): PointIdeal =
    PointIdeal(
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

  infix def cross(v: QuaternionDual): BivectorWeight =
    BivectorWeight(
      wx = (v.wy * xy + v.wz * xz),
      wy = (v.wz * yz - v.wx * xy),
      wz = (-v.wx * xz - v.wy * yz),
    )

  infix def cross(v: PointIdeal): PointIdeal =
    PointIdeal(
      wxy = (v.wxz * yz - v.wyz * xz),
      wxz = (v.wyz * xy - v.wxy * yz),
      wyz = (v.wxy * xz - v.wxz * xy),
    )

  infix def cross(v: PointNormalized): PointIdeal =
    PointIdeal(
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

  infix def cross(v: PointCenter.type): PointIdeal =
    PointIdeal(
      wxy = wz,
      wxz = -wy,
      wyz = wx,
    )

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

  infix def antiGeometric(v: QuaternionDual): Motor =
    Motor(
      s = (v.wx * yz + v.wz * xy - v.wy * xz),
      wx = (v.i * wx + v.wy * wz - v.wz * wy),
      wy = (v.i * wy + v.wz * wx - v.wx * wz),
      wz = (v.i * wz + v.wx * wy - v.wy * wx),
      xy = (v.i * xy - v.wx * xz - v.wy * yz),
      xz = (v.i * xz + v.wx * xy - v.wz * yz),
      yz = (v.i * yz + v.wy * xy + v.wz * xz),
      i = (-v.wx * wx - v.wy * wy - v.wz * wz),
    )

  infix def antiGeometric(v: PointIdeal): Multivector =
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

  infix def antiDot(v: QuaternionDual): Motor =
    Motor(
      s = 0.0,
      wx = v.i * wx,
      wy = v.i * wy,
      wz = v.i * wz,
      xy = v.i * xy,
      xz = v.i * xz,
      yz = v.i * yz,
      i = (-v.wx * wx - v.wy * wy - v.wz * wz),
    )

  infix def antiDot(v: PointIdeal): Point =
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

  infix def antiWedge(v: QuaternionDual): Motor =
    Motor(
      s = (v.wx * yz + v.wz * xy - v.wy * xz),
      wx = v.i * wx,
      wy = v.i * wy,
      wz = v.i * wz,
      xy = v.i * xy,
      xz = v.i * xz,
      yz = v.i * yz,
      i = 0.0,
    )

  inline infix def v(v: QuaternionDual): Motor = antiWedge(v)

  infix def antiWedge(v: PointIdeal): Plane =
    Plane(
      w = (v.wxz * wy - v.wxy * wz - v.wyz * wx),
      x = (v.wxz * xy - v.wxy * xz),
      y = (v.wyz * xy - v.wxy * yz),
      z = (v.wyz * xz - v.wxz * yz),
    )

  inline infix def v(v: PointIdeal): Plane = antiWedge(v)

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