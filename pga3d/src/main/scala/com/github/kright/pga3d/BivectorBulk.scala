package com.github.kright.pga3d

/** this code is generated, see com.github.kright.pga3d.codegen.CodeGenClass */
case class BivectorBulk(
                         xy: Double = 0.0,
                         xz: Double = 0.0,
                         yz: Double = 0.0,
                       ):

  def dual: BivectorWeight =
    BivectorWeight(
      wx = yz,
      wy = -xz,
      wz = xy,
    )

  def bulk: BivectorBulk =
    this

  def unary_- : BivectorBulk =
    BivectorBulk(
      xy = -xy,
      xz = -xz,
      yz = -yz,
    )

  def reverse: BivectorBulk =
    -this

  def antiReverse: BivectorBulk =
    -this

  def bulkNormSquare: Double =
    (xy * xy + xz * xz + yz * yz)

  def normSquare: Double =
    (xy * xy + xz * xz + yz * yz)

  def bulkNorm: Double =
    Math.sqrt(bulkNormSquare)

  def normalizedByBulk =
    this / bulkNorm

  def norm: Double =
    Math.sqrt(normSquare)

  def normalizedByNorm =
    this / norm

  def *(v: Double): BivectorBulk =
    BivectorBulk(
      xy = v * xy,
      xz = v * xz,
      yz = v * yz,
    )

  inline def /(v: Double): BivectorBulk =
    this * (1.0 / v)

  def +(v: Bivector): Bivector =
    Bivector(
      wx = v.wx,
      wy = v.wy,
      wz = v.wz,
      xy = (v.xy + xy),
      xz = (v.xz + xz),
      yz = (v.yz + yz),
    )

  def -(v: Bivector): Bivector =
    Bivector(
      wx = -v.wx,
      wy = -v.wy,
      wz = -v.wz,
      xy = (xy - v.xy),
      xz = (xz - v.xz),
      yz = (yz - v.yz),
    )

  def madd(v: Bivector, mult: Double): Bivector =
    Bivector(
      wx = mult * v.wx,
      wy = mult * v.wy,
      wz = mult * v.wz,
      xy = (xy + mult * v.xy),
      xz = (xz + mult * v.xz),
      yz = (yz + mult * v.yz),
    )

  def +(v: BivectorBulk): BivectorBulk =
    BivectorBulk(
      xy = (v.xy + xy),
      xz = (v.xz + xz),
      yz = (v.yz + yz),
    )

  def -(v: BivectorBulk): BivectorBulk =
    BivectorBulk(
      xy = (xy - v.xy),
      xz = (xz - v.xz),
      yz = (yz - v.yz),
    )

  def madd(v: BivectorBulk, mult: Double): BivectorBulk =
    BivectorBulk(
      xy = (xy + mult * v.xy),
      xz = (xz + mult * v.xz),
      yz = (yz + mult * v.yz),
    )

  def +(v: BivectorWeight): Bivector =
    Bivector(
      wx = v.wx,
      wy = v.wy,
      wz = v.wz,
      xy = xy,
      xz = xz,
      yz = yz,
    )

  def -(v: BivectorWeight): Bivector =
    Bivector(
      wx = -v.wx,
      wy = -v.wy,
      wz = -v.wz,
      xy = xy,
      xz = xz,
      yz = yz,
    )

  def madd(v: BivectorWeight, mult: Double): Bivector =
    Bivector(
      wx = mult * v.wx,
      wy = mult * v.wy,
      wz = mult * v.wz,
      xy = xy,
      xz = xz,
      yz = yz,
    )

  def multiplyElementwise(v: BivectorBulk): BivectorBulk =
    BivectorBulk(
      xy = v.xy * xy,
      xz = v.xz * xz,
      yz = v.yz * yz,
    )

  def exp(): Quaternion =
    val len = bulkNorm
    val cos = Math.cos(len)

    val sinDivLen = if (len > 1e-5) {
      Math.sin(len) / len
    } else 1.0 - (len * len) / 6.0

    Quaternion(
      s = cos,
      xy = sinDivLen * xy,
      xz = sinDivLen * xz,
      yz = sinDivLen * yz,
    )

  def exp(t: Double): Quaternion =
    val len = bulkNorm * Math.abs(t)
    val cos = Math.cos(len)

    val sinDivLen = if (len > 1e-5) {
      Math.sin(len) / len
    } else 1.0 - (len * len) / 6.0

    Quaternion(
      s = cos,
      xy = sinDivLen * t * xy,
      xz = sinDivLen * t * xz,
      yz = sinDivLen * t * yz,
    )

  def toMultivector: Multivector =
    Multivector(
      s = 0.0,
      w = 0.0,
      x = 0.0,
      y = 0.0,
      z = 0.0,
      wx = 0.0,
      wy = 0.0,
      wz = 0.0,
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
      wx = 0.0,
      wy = 0.0,
      wz = 0.0,
      xy = xy,
      xz = xz,
      yz = yz,
      i = 0.0,
    )

  def toBivector: Bivector =
    Bivector(
      wx = 0.0,
      wy = 0.0,
      wz = 0.0,
      xy = xy,
      xz = xz,
      yz = yz,
    )

  def toQuaternion: Quaternion =
    Quaternion(
      s = 0.0,
      xy = xy,
      xz = xz,
      yz = yz,
    )

  infix def geometric(v: Multivector): Multivector =
    Multivector(
      s = (-v.xy * xy - v.xz * xz - v.yz * yz),
      w = (-v.wxy * xy - v.wxz * xz - v.wyz * yz),
      x = (v.y * xy + v.z * xz - v.xyz * yz),
      y = (v.xyz * xz + v.z * yz - v.x * xy),
      z = (-v.x * xz - v.xyz * xy - v.y * yz),
      wx = (v.wy * xy + v.wz * xz - v.i * yz),
      wy = (v.i * xz + v.wz * yz - v.wx * xy),
      wz = (-v.i * xy - v.wx * xz - v.wy * yz),
      xy = (v.s * xy + v.xz * yz - v.yz * xz),
      xz = (v.s * xz + v.yz * xy - v.xy * yz),
      yz = (v.s * yz + v.xy * xz - v.xz * xy),
      wxy = (v.w * xy + v.wxz * yz - v.wyz * xz),
      wxz = (v.w * xz + v.wyz * xy - v.wxy * yz),
      wyz = (v.w * yz + v.wxy * xz - v.wxz * xy),
      xyz = (v.x * yz + v.z * xy - v.y * xz),
      i = (v.wx * yz + v.wz * xy - v.wy * xz),
    )

  infix def geometric(v: Motor): Motor =
    Motor(
      s = (-v.xy * xy - v.xz * xz - v.yz * yz),
      wx = (v.wy * xy + v.wz * xz - v.i * yz),
      wy = (v.i * xz + v.wz * yz - v.wx * xy),
      wz = (-v.i * xy - v.wx * xz - v.wy * yz),
      xy = (v.s * xy + v.xz * yz - v.yz * xz),
      xz = (v.s * xz + v.yz * xy - v.xy * yz),
      yz = (v.s * yz + v.xy * xz - v.xz * xy),
      i = (v.wx * yz + v.wz * xy - v.wy * xz),
    )

  infix def geometric(v: Plane): Multivector =
    Multivector(
      s = 0.0,
      w = 0.0,
      x = (v.y * xy + v.z * xz),
      y = (v.z * yz - v.x * xy),
      z = (-v.x * xz - v.y * yz),
      wx = 0.0,
      wy = 0.0,
      wz = 0.0,
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
      wxy = v.w * xy,
      wxz = v.w * xz,
      wyz = v.w * yz,
      xyz = (v.x * yz + v.z * xy - v.y * xz),
      i = 0.0,
    )

  infix def geometric(v: Bivector): Motor =
    Motor(
      s = (-v.xy * xy - v.xz * xz - v.yz * yz),
      wx = (v.wy * xy + v.wz * xz),
      wy = (v.wz * yz - v.wx * xy),
      wz = (-v.wx * xz - v.wy * yz),
      xy = (v.xz * yz - v.yz * xz),
      xz = (v.yz * xy - v.xy * yz),
      yz = (v.xy * xz - v.xz * xy),
      i = (v.wx * yz + v.wz * xy - v.wy * xz),
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
      wxy = (v.wxz * yz - v.wyz * xz),
      wxz = (v.wyz * xy - v.wxy * yz),
      wyz = (v.wxy * xz - v.wxz * xy),
      xyz = 0.0,
      i = 0.0,
    )

  infix def geometric(v: Quaternion): Quaternion =
    Quaternion(
      s = (-v.xy * xy - v.xz * xz - v.yz * yz),
      xy = (v.s * xy + v.xz * yz - v.yz * xz),
      xz = (v.s * xz + v.yz * xy - v.xy * yz),
      yz = (v.s * yz + v.xy * xz - v.xz * xy),
    )

  infix def geometric(v: Translator): Motor =
    Motor(
      s = 0.0,
      wx = (v.wy * xy + v.wz * xz),
      wy = (v.wz * yz - v.wx * xy),
      wz = (-v.wx * xz - v.wy * yz),
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
      wxy = (v.wxz * yz - v.wyz * xz),
      wxz = (v.wyz * xy - v.wxy * yz),
      wyz = (v.wxy * xz - v.wxz * xy),
      xyz = 0.0,
      i = 0.0,
    )

  infix def geometric(v: PlaneIdeal): Multivector =
    Multivector(
      s = 0.0,
      w = 0.0,
      x = (v.y * xy + v.z * xz),
      y = (v.z * yz - v.x * xy),
      z = (-v.x * xz - v.y * yz),
      wx = 0.0,
      wy = 0.0,
      wz = 0.0,
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
      wxy = 0.0,
      wxz = 0.0,
      wyz = 0.0,
      xyz = (v.x * yz + v.z * xy - v.y * xz),
      i = 0.0,
    )

  infix def geometric(v: BivectorBulk): Quaternion =
    Quaternion(
      s = (-v.xy * xy - v.xz * xz - v.yz * yz),
      xy = (v.xz * yz - v.yz * xz),
      xz = (v.yz * xy - v.xy * yz),
      yz = (v.xy * xz - v.xz * xy),
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

  infix def geometric(v: PointCenter.type): PlaneIdeal =
    PlaneIdeal(
      x = -yz,
      y = xz,
      z = -xy,
    )

  infix def dot(v: Multivector): Multivector =
    Multivector(
      s = (-v.xy * xy - v.xz * xz - v.yz * yz),
      w = (-v.wxy * xy - v.wxz * xz - v.wyz * yz),
      x = (v.y * xy + v.z * xz - v.xyz * yz),
      y = (v.xyz * xz + v.z * yz - v.x * xy),
      z = (-v.x * xz - v.xyz * xy - v.y * yz),
      wx = -v.i * yz,
      wy = v.i * xz,
      wz = -v.i * xy,
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
      wx = -v.i * yz,
      wy = v.i * xz,
      wz = -v.i * xy,
      xy = v.s * xy,
      xz = v.s * xz,
      yz = v.s * yz,
      i = 0.0,
    )

  infix def dot(v: Plane): PlaneIdeal =
    PlaneIdeal(
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

  infix def dot(v: Quaternion): Quaternion =
    Quaternion(
      s = (-v.xy * xy - v.xz * xz - v.yz * yz),
      xy = v.s * xy,
      xz = v.s * xz,
      yz = v.s * yz,
    )

  infix def dot(v: Translator): BivectorBulk =
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

  infix def dot(v: PlaneIdeal): PlaneIdeal =
    PlaneIdeal(
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
      wx = 0.0,
      wy = 0.0,
      wz = 0.0,
      xy = v.s * xy,
      xz = v.s * xz,
      yz = v.s * yz,
      wxy = v.w * xy,
      wxz = v.w * xz,
      wyz = v.w * yz,
      xyz = (v.x * yz + v.z * xy - v.y * xz),
      i = (v.wx * yz + v.wz * xy - v.wy * xz),
    )

  inline infix def ^(v: Multivector): Multivector = wedge(v)

  infix def wedge(v: Motor): Motor =
    Motor(
      s = 0.0,
      wx = 0.0,
      wy = 0.0,
      wz = 0.0,
      xy = v.s * xy,
      xz = v.s * xz,
      yz = v.s * yz,
      i = (v.wx * yz + v.wz * xy - v.wy * xz),
    )

  inline infix def ^(v: Motor): Motor = wedge(v)

  infix def wedge(v: Plane): Point =
    Point(
      wxy = v.w * xy,
      wxz = v.w * xz,
      wyz = v.w * yz,
      xyz = (v.x * yz + v.z * xy - v.y * xz),
    )

  inline infix def ^(v: Plane): Point = wedge(v)

  infix def wedge(v: Bivector): PseudoScalar =
    PseudoScalar(
      i = (v.wx * yz + v.wz * xy - v.wy * xz),
    )

  inline infix def ^(v: Bivector): PseudoScalar = wedge(v)

  infix def wedge(v: Quaternion): BivectorBulk =
    BivectorBulk(
      xy = v.s * xy,
      xz = v.s * xz,
      yz = v.s * yz,
    )

  inline infix def ^(v: Quaternion): BivectorBulk = wedge(v)

  infix def wedge(v: Translator): Motor =
    Motor(
      s = 0.0,
      wx = 0.0,
      wy = 0.0,
      wz = 0.0,
      xy = xy,
      xz = xz,
      yz = yz,
      i = (v.wx * yz + v.wz * xy - v.wy * xz),
    )

  inline infix def ^(v: Translator): Motor = wedge(v)

  infix def wedge(v: PlaneIdeal): Point =
    Point(
      wxy = 0.0,
      wxz = 0.0,
      wyz = 0.0,
      xyz = (v.x * yz + v.z * xy - v.y * xz),
    )

  inline infix def ^(v: PlaneIdeal): Point = wedge(v)

  infix def wedge(v: BivectorWeight): PseudoScalar =
    PseudoScalar(
      i = (v.wx * yz + v.wz * xy - v.wy * xz),
    )

  inline infix def ^(v: BivectorWeight): PseudoScalar = wedge(v)

  infix def antiGeometric(v: Multivector): Multivector =
    Multivector(
      s = (v.wx * yz + v.wz * xy - v.wy * xz),
      w = 0.0,
      x = (v.wxz * xy - v.w * yz - v.wxy * xz),
      y = (v.w * xz + v.wyz * xy - v.wxy * yz),
      z = (v.wyz * xz - v.w * xy - v.wxz * yz),
      wx = 0.0,
      wy = 0.0,
      wz = 0.0,
      xy = (v.i * xy - v.wx * xz - v.wy * yz),
      xz = (v.i * xz + v.wx * xy - v.wz * yz),
      yz = (v.i * yz + v.wy * xy + v.wz * xz),
      wxy = 0.0,
      wxz = 0.0,
      wyz = 0.0,
      xyz = (-v.wxy * xy - v.wxz * xz - v.wyz * yz),
      i = 0.0,
    )

  infix def antiGeometric(v: Motor): Quaternion =
    Quaternion(
      s = (v.wx * yz + v.wz * xy - v.wy * xz),
      xy = (v.i * xy - v.wx * xz - v.wy * yz),
      xz = (v.i * xz + v.wx * xy - v.wz * yz),
      yz = (v.i * yz + v.wy * xy + v.wz * xz),
    )

  infix def antiGeometric(v: Plane): PlaneIdeal =
    PlaneIdeal(
      x = -v.w * yz,
      y = v.w * xz,
      z = -v.w * xy,
    )

  infix def antiGeometric(v: Bivector): Quaternion =
    Quaternion(
      s = (v.wx * yz + v.wz * xy - v.wy * xz),
      xy = (-v.wx * xz - v.wy * yz),
      xz = (v.wx * xy - v.wz * yz),
      yz = (v.wy * xy + v.wz * xz),
    )

  infix def antiGeometric(v: Point): Multivector =
    Multivector(
      s = 0.0,
      w = 0.0,
      x = (v.wxz * xy - v.wxy * xz),
      y = (v.wyz * xy - v.wxy * yz),
      z = (v.wyz * xz - v.wxz * yz),
      wx = 0.0,
      wy = 0.0,
      wz = 0.0,
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
      wxy = 0.0,
      wxz = 0.0,
      wyz = 0.0,
      xyz = (-v.wxy * xy - v.wxz * xz - v.wyz * yz),
      i = 0.0,
    )

  infix def antiGeometric(v: Translator): Quaternion =
    Quaternion(
      s = (v.wx * yz + v.wz * xy - v.wy * xz),
      xy = (-v.wx * xz - v.wy * yz),
      xz = (v.wx * xy - v.wz * yz),
      yz = (v.wy * xy + v.wz * xz),
    )

  infix def antiGeometric(v: Vector): Multivector =
    Multivector(
      s = 0.0,
      w = 0.0,
      x = (v.wxz * xy - v.wxy * xz),
      y = (v.wyz * xy - v.wxy * yz),
      z = (v.wyz * xz - v.wxz * yz),
      wx = 0.0,
      wy = 0.0,
      wz = 0.0,
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
      wxy = 0.0,
      wxz = 0.0,
      wyz = 0.0,
      xyz = (-v.wxy * xy - v.wxz * xz - v.wyz * yz),
      i = 0.0,
    )

  infix def antiGeometric(v: PointNormalized): Multivector =
    Multivector(
      s = 0.0,
      w = 0.0,
      x = (v.wxz * xy - v.wxy * xz),
      y = (v.wyz * xy - v.wxy * yz),
      z = (v.wyz * xz - v.wxz * yz),
      wx = 0.0,
      wy = 0.0,
      wz = 0.0,
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
      wxy = 0.0,
      wxz = 0.0,
      wyz = 0.0,
      xyz = (-v.wxy * xy - v.wxz * xz - v.wyz * yz),
      i = 0.0,
    )

  infix def antiGeometric(v: BivectorWeight): Quaternion =
    Quaternion(
      s = (v.wx * yz + v.wz * xy - v.wy * xz),
      xy = (-v.wx * xz - v.wy * yz),
      xz = (v.wx * xy - v.wz * yz),
      yz = (v.wy * xy + v.wz * xz),
    )

  infix def antiGeometric(v: PseudoScalar): BivectorBulk =
    BivectorBulk(
      xy = v.i * xy,
      xz = v.i * xz,
      yz = v.i * yz,
    )

  infix def antiDot(v: Multivector): Multivector =
    Multivector(
      s = 0.0,
      w = 0.0,
      x = 0.0,
      y = 0.0,
      z = 0.0,
      wx = 0.0,
      wy = 0.0,
      wz = 0.0,
      xy = v.i * xy,
      xz = v.i * xz,
      yz = v.i * yz,
      wxy = 0.0,
      wxz = 0.0,
      wyz = 0.0,
      xyz = (-v.wxy * xy - v.wxz * xz - v.wyz * yz),
      i = 0.0,
    )

  infix def antiDot(v: Motor): BivectorBulk =
    BivectorBulk(
      xy = v.i * xy,
      xz = v.i * xz,
      yz = v.i * yz,
    )

  infix def antiDot(v: Point): Point =
    Point(
      wxy = 0.0,
      wxz = 0.0,
      wyz = 0.0,
      xyz = (-v.wxy * xy - v.wxz * xz - v.wyz * yz),
    )

  infix def antiDot(v: Vector): Point =
    Point(
      wxy = 0.0,
      wxz = 0.0,
      wyz = 0.0,
      xyz = (-v.wxy * xy - v.wxz * xz - v.wyz * yz),
    )

  infix def antiDot(v: PointNormalized): Point =
    Point(
      wxy = 0.0,
      wxz = 0.0,
      wyz = 0.0,
      xyz = (-v.wxy * xy - v.wxz * xz - v.wyz * yz),
    )

  infix def antiDot(v: PseudoScalar): BivectorBulk =
    BivectorBulk(
      xy = v.i * xy,
      xz = v.i * xz,
      yz = v.i * yz,
    )

  infix def antiWedge(v: Multivector): Multivector =
    Multivector(
      s = (v.wx * yz + v.wz * xy - v.wy * xz),
      w = 0.0,
      x = (v.wxz * xy - v.wxy * xz),
      y = (v.wyz * xy - v.wxy * yz),
      z = (v.wyz * xz - v.wxz * yz),
      wx = 0.0,
      wy = 0.0,
      wz = 0.0,
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

  infix def antiWedge(v: Motor): Quaternion =
    Quaternion(
      s = (v.wx * yz + v.wz * xy - v.wy * xz),
      xy = v.i * xy,
      xz = v.i * xz,
      yz = v.i * yz,
    )

  inline infix def v(v: Motor): Quaternion = antiWedge(v)

  infix def antiWedge(v: Bivector): Double =
    (v.wx * yz + v.wz * xy - v.wy * xz)

  inline infix def v(v: Bivector): Double = antiWedge(v)

  infix def antiWedge(v: Point): PlaneIdeal =
    PlaneIdeal(
      x = (v.wxz * xy - v.wxy * xz),
      y = (v.wyz * xy - v.wxy * yz),
      z = (v.wyz * xz - v.wxz * yz),
    )

  inline infix def v(v: Point): PlaneIdeal = antiWedge(v)

  infix def antiWedge(v: Translator): Double =
    (v.wx * yz + v.wz * xy - v.wy * xz)

  inline infix def v(v: Translator): Double = antiWedge(v)

  infix def antiWedge(v: Vector): PlaneIdeal =
    PlaneIdeal(
      x = (v.wxz * xy - v.wxy * xz),
      y = (v.wyz * xy - v.wxy * yz),
      z = (v.wyz * xz - v.wxz * yz),
    )

  inline infix def v(v: Vector): PlaneIdeal = antiWedge(v)

  infix def antiWedge(v: PointNormalized): PlaneIdeal =
    PlaneIdeal(
      x = (v.wxz * xy - v.wxy * xz),
      y = (v.wyz * xy - v.wxy * yz),
      z = (v.wyz * xz - v.wxz * yz),
    )

  inline infix def v(v: PointNormalized): PlaneIdeal = antiWedge(v)

  infix def antiWedge(v: BivectorWeight): Double =
    (v.wx * yz + v.wz * xy - v.wy * xz)

  inline infix def v(v: BivectorWeight): Double = antiWedge(v)

  infix def antiWedge(v: PseudoScalar): BivectorBulk =
    BivectorBulk(
      xy = v.i * xy,
      xz = v.i * xz,
      yz = v.i * yz,
    )

  inline infix def v(v: PseudoScalar): BivectorBulk = antiWedge(v)

  infix def sandwich(v: Multivector): Multivector =
    val xyMxy = xy * xy
    val xyMxz = xy * xz
    val xyMyz = xy * yz
    val xzMxz = xz * xz
    val xzMyz = xz * yz
    val yzMyz = yz * yz
    Multivector(
      s = v.s * (xyMxy + xzMxz + yzMyz),
      w = v.w * (xyMxy + xzMxz + yzMyz),
      x = (2.0 * (v.z * xyMyz - v.y * xzMyz) + v.x * (yzMyz - xyMxy - xzMxz)),
      y = (2.0 * (-v.x * xzMyz - v.z * xyMxz) + v.y * (xzMxz - xyMxy - yzMyz)),
      z = (2.0 * (v.x * xyMyz - v.y * xyMxz) + v.z * (xyMxy - xzMxz - yzMyz)),
      wx = (2.0 * (v.wz * xyMyz - v.wy * xzMyz) + v.wx * (yzMyz - xyMxy - xzMxz)),
      wy = (2.0 * (-v.wx * xzMyz - v.wz * xyMxz) + v.wy * (xzMxz - xyMxy - yzMyz)),
      wz = (2.0 * (v.wx * xyMyz - v.wy * xyMxz) + v.wz * (xyMxy - xzMxz - yzMyz)),
      xy = (2.0 * (v.xz * xyMxz + v.yz * xyMyz) + v.xy * (xyMxy - xzMxz - yzMyz)),
      xz = (2.0 * (v.xy * xyMxz + v.yz * xzMyz) + v.xz * (xzMxz - xyMxy - yzMyz)),
      yz = (2.0 * (v.xy * xyMyz + v.xz * xzMyz) + v.yz * (yzMyz - xyMxy - xzMxz)),
      wxy = (2.0 * (v.wxz * xyMxz + v.wyz * xyMyz) + v.wxy * (xyMxy - xzMxz - yzMyz)),
      wxz = (2.0 * (v.wxy * xyMxz + v.wyz * xzMyz) + v.wxz * (xzMxz - xyMxy - yzMyz)),
      wyz = (2.0 * (v.wxy * xyMyz + v.wxz * xzMyz) + v.wyz * (yzMyz - xyMxy - xzMxz)),
      xyz = v.xyz * (xyMxy + xzMxz + yzMyz),
      i = v.i * (xyMxy + xzMxz + yzMyz),
    )

  infix def sandwich(v: Motor): Motor =
    val xyMxy = xy * xy
    val xyMxz = xy * xz
    val xyMyz = xy * yz
    val xzMxz = xz * xz
    val xzMyz = xz * yz
    val yzMyz = yz * yz
    Motor(
      s = v.s * (xyMxy + xzMxz + yzMyz),
      wx = (2.0 * (v.wz * xyMyz - v.wy * xzMyz) + v.wx * (yzMyz - xyMxy - xzMxz)),
      wy = (2.0 * (-v.wx * xzMyz - v.wz * xyMxz) + v.wy * (xzMxz - xyMxy - yzMyz)),
      wz = (2.0 * (v.wx * xyMyz - v.wy * xyMxz) + v.wz * (xyMxy - xzMxz - yzMyz)),
      xy = (2.0 * (v.xz * xyMxz + v.yz * xyMyz) + v.xy * (xyMxy - xzMxz - yzMyz)),
      xz = (2.0 * (v.xy * xyMxz + v.yz * xzMyz) + v.xz * (xzMxz - xyMxy - yzMyz)),
      yz = (2.0 * (v.xy * xyMyz + v.xz * xzMyz) + v.yz * (yzMyz - xyMxy - xzMxz)),
      i = v.i * (xyMxy + xzMxz + yzMyz),
    )

  infix def sandwich(v: Plane): Plane =
    val xyMxy = xy * xy
    val xyMxz = xy * xz
    val xyMyz = xy * yz
    val xzMxz = xz * xz
    val xzMyz = xz * yz
    val yzMyz = yz * yz
    Plane(
      w = v.w * (xyMxy + xzMxz + yzMyz),
      x = (2.0 * (v.z * xyMyz - v.y * xzMyz) + v.x * (yzMyz - xyMxy - xzMxz)),
      y = (2.0 * (-v.x * xzMyz - v.z * xyMxz) + v.y * (xzMxz - xyMxy - yzMyz)),
      z = (2.0 * (v.x * xyMyz - v.y * xyMxz) + v.z * (xyMxy - xzMxz - yzMyz)),
    )

  infix def sandwich(v: Bivector): Bivector =
    val xyMxy = xy * xy
    val xyMxz = xy * xz
    val xyMyz = xy * yz
    val xzMxz = xz * xz
    val xzMyz = xz * yz
    val yzMyz = yz * yz
    Bivector(
      wx = (2.0 * (v.wz * xyMyz - v.wy * xzMyz) + v.wx * (yzMyz - xyMxy - xzMxz)),
      wy = (2.0 * (-v.wx * xzMyz - v.wz * xyMxz) + v.wy * (xzMxz - xyMxy - yzMyz)),
      wz = (2.0 * (v.wx * xyMyz - v.wy * xyMxz) + v.wz * (xyMxy - xzMxz - yzMyz)),
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
      wxy = (2.0 * (v.wxz * xyMxz + v.wyz * xyMyz) + v.wxy * (xyMxy - xzMxz - yzMyz)),
      wxz = (2.0 * (v.wxy * xyMxz + v.wyz * xzMyz) + v.wxz * (xzMxz - xyMxy - yzMyz)),
      wyz = (2.0 * (v.wxy * xyMyz + v.wxz * xzMyz) + v.wyz * (yzMyz - xyMxy - xzMxz)),
      xyz = v.xyz * (xyMxy + xzMxz + yzMyz),
    )

  infix def sandwich(v: Quaternion): Quaternion =
    val xyMxy = xy * xy
    val xyMxz = xy * xz
    val xyMyz = xy * yz
    val xzMxz = xz * xz
    val xzMyz = xz * yz
    val yzMyz = yz * yz
    Quaternion(
      s = v.s * (xyMxy + xzMxz + yzMyz),
      xy = (2.0 * (v.xz * xyMxz + v.yz * xyMyz) + v.xy * (xyMxy - xzMxz - yzMyz)),
      xz = (2.0 * (v.xy * xyMxz + v.yz * xzMyz) + v.xz * (xzMxz - xyMxy - yzMyz)),
      yz = (2.0 * (v.xy * xyMyz + v.xz * xzMyz) + v.yz * (yzMyz - xyMxy - xzMxz)),
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
      i = 0.0,
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
      wxy = (2.0 * (v.wxz * xyMxz + v.wyz * xyMyz) + v.wxy * (xyMxy - xzMxz - yzMyz)),
      wxz = (2.0 * (v.wxy * xyMxz + v.wyz * xzMyz) + v.wxz * (xzMxz - xyMxy - yzMyz)),
      wyz = (2.0 * (v.wxy * xyMyz + v.wxz * xzMyz) + v.wyz * (yzMyz - xyMxy - xzMxz)),
      xyz = (xyMxy + xzMxz + yzMyz),
    )

  infix def sandwich(v: PlaneIdeal): PlaneIdeal =
    val xyMxy = xy * xy
    val xyMxz = xy * xz
    val xyMyz = xy * yz
    val xzMxz = xz * xz
    val xzMyz = xz * yz
    val yzMyz = yz * yz
    PlaneIdeal(
      x = (2.0 * (v.z * xyMyz - v.y * xzMyz) + v.x * (yzMyz - xyMxy - xzMxz)),
      y = (2.0 * (-v.x * xzMyz - v.z * xyMxz) + v.y * (xzMxz - xyMxy - yzMyz)),
      z = (2.0 * (v.x * xyMyz - v.y * xyMxz) + v.z * (xyMxy - xzMxz - yzMyz)),
    )

  infix def sandwich(v: BivectorBulk): BivectorBulk =
    val xyMxy = xy * xy
    val xyMxz = xy * xz
    val xyMyz = xy * yz
    val xzMxz = xz * xz
    val xzMyz = xz * yz
    val yzMyz = yz * yz
    BivectorBulk(
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
      wxy = 0.0,
      wxz = 0.0,
      wyz = 0.0,
      xyz = (xy * xy + xz * xz + yz * yz),
    )

  infix def reverseSandwich(v: Multivector): Multivector =
    val xyMxy = xy * xy
    val xyMxz = xy * xz
    val xyMyz = xy * yz
    val xzMxz = xz * xz
    val xzMyz = xz * yz
    val yzMyz = yz * yz
    Multivector(
      s = v.s * (xyMxy + xzMxz + yzMyz),
      w = v.w * (xyMxy + xzMxz + yzMyz),
      x = (2.0 * (v.z * xyMyz - v.y * xzMyz) + v.x * (yzMyz - xyMxy - xzMxz)),
      y = (2.0 * (-v.x * xzMyz - v.z * xyMxz) + v.y * (xzMxz - xyMxy - yzMyz)),
      z = (2.0 * (v.x * xyMyz - v.y * xyMxz) + v.z * (xyMxy - xzMxz - yzMyz)),
      wx = (2.0 * (v.wz * xyMyz - v.wy * xzMyz) + v.wx * (yzMyz - xyMxy - xzMxz)),
      wy = (2.0 * (-v.wx * xzMyz - v.wz * xyMxz) + v.wy * (xzMxz - xyMxy - yzMyz)),
      wz = (2.0 * (v.wx * xyMyz - v.wy * xyMxz) + v.wz * (xyMxy - xzMxz - yzMyz)),
      xy = (2.0 * (v.xz * xyMxz + v.yz * xyMyz) + v.xy * (xyMxy - xzMxz - yzMyz)),
      xz = (2.0 * (v.xy * xyMxz + v.yz * xzMyz) + v.xz * (xzMxz - xyMxy - yzMyz)),
      yz = (2.0 * (v.xy * xyMyz + v.xz * xzMyz) + v.yz * (yzMyz - xyMxy - xzMxz)),
      wxy = (2.0 * (v.wxz * xyMxz + v.wyz * xyMyz) + v.wxy * (xyMxy - xzMxz - yzMyz)),
      wxz = (2.0 * (v.wxy * xyMxz + v.wyz * xzMyz) + v.wxz * (xzMxz - xyMxy - yzMyz)),
      wyz = (2.0 * (v.wxy * xyMyz + v.wxz * xzMyz) + v.wyz * (yzMyz - xyMxy - xzMxz)),
      xyz = v.xyz * (xyMxy + xzMxz + yzMyz),
      i = v.i * (xyMxy + xzMxz + yzMyz),
    )

  infix def reverseSandwich(v: Motor): Motor =
    val xyMxy = xy * xy
    val xyMxz = xy * xz
    val xyMyz = xy * yz
    val xzMxz = xz * xz
    val xzMyz = xz * yz
    val yzMyz = yz * yz
    Motor(
      s = v.s * (xyMxy + xzMxz + yzMyz),
      wx = (2.0 * (v.wz * xyMyz - v.wy * xzMyz) + v.wx * (yzMyz - xyMxy - xzMxz)),
      wy = (2.0 * (-v.wx * xzMyz - v.wz * xyMxz) + v.wy * (xzMxz - xyMxy - yzMyz)),
      wz = (2.0 * (v.wx * xyMyz - v.wy * xyMxz) + v.wz * (xyMxy - xzMxz - yzMyz)),
      xy = (2.0 * (v.xz * xyMxz + v.yz * xyMyz) + v.xy * (xyMxy - xzMxz - yzMyz)),
      xz = (2.0 * (v.xy * xyMxz + v.yz * xzMyz) + v.xz * (xzMxz - xyMxy - yzMyz)),
      yz = (2.0 * (v.xy * xyMyz + v.xz * xzMyz) + v.yz * (yzMyz - xyMxy - xzMxz)),
      i = v.i * (xyMxy + xzMxz + yzMyz),
    )

  infix def reverseSandwich(v: Plane): Plane =
    val xyMxy = xy * xy
    val xyMxz = xy * xz
    val xyMyz = xy * yz
    val xzMxz = xz * xz
    val xzMyz = xz * yz
    val yzMyz = yz * yz
    Plane(
      w = v.w * (xyMxy + xzMxz + yzMyz),
      x = (2.0 * (v.z * xyMyz - v.y * xzMyz) + v.x * (yzMyz - xyMxy - xzMxz)),
      y = (2.0 * (-v.x * xzMyz - v.z * xyMxz) + v.y * (xzMxz - xyMxy - yzMyz)),
      z = (2.0 * (v.x * xyMyz - v.y * xyMxz) + v.z * (xyMxy - xzMxz - yzMyz)),
    )

  infix def reverseSandwich(v: Bivector): Bivector =
    val xyMxy = xy * xy
    val xyMxz = xy * xz
    val xyMyz = xy * yz
    val xzMxz = xz * xz
    val xzMyz = xz * yz
    val yzMyz = yz * yz
    Bivector(
      wx = (2.0 * (v.wz * xyMyz - v.wy * xzMyz) + v.wx * (yzMyz - xyMxy - xzMxz)),
      wy = (2.0 * (-v.wx * xzMyz - v.wz * xyMxz) + v.wy * (xzMxz - xyMxy - yzMyz)),
      wz = (2.0 * (v.wx * xyMyz - v.wy * xyMxz) + v.wz * (xyMxy - xzMxz - yzMyz)),
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
      wxy = (2.0 * (v.wxz * xyMxz + v.wyz * xyMyz) + v.wxy * (xyMxy - xzMxz - yzMyz)),
      wxz = (2.0 * (v.wxy * xyMxz + v.wyz * xzMyz) + v.wxz * (xzMxz - xyMxy - yzMyz)),
      wyz = (2.0 * (v.wxy * xyMyz + v.wxz * xzMyz) + v.wyz * (yzMyz - xyMxy - xzMxz)),
      xyz = v.xyz * (xyMxy + xzMxz + yzMyz),
    )

  infix def reverseSandwich(v: Quaternion): Quaternion =
    val xyMxy = xy * xy
    val xyMxz = xy * xz
    val xyMyz = xy * yz
    val xzMxz = xz * xz
    val xzMyz = xz * yz
    val yzMyz = yz * yz
    Quaternion(
      s = v.s * (xyMxy + xzMxz + yzMyz),
      xy = (2.0 * (v.xz * xyMxz + v.yz * xyMyz) + v.xy * (xyMxy - xzMxz - yzMyz)),
      xz = (2.0 * (v.xy * xyMxz + v.yz * xzMyz) + v.xz * (xzMxz - xyMxy - yzMyz)),
      yz = (2.0 * (v.xy * xyMyz + v.xz * xzMyz) + v.yz * (yzMyz - xyMxy - xzMxz)),
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
      i = 0.0,
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
      wxy = (2.0 * (v.wxz * xyMxz + v.wyz * xyMyz) + v.wxy * (xyMxy - xzMxz - yzMyz)),
      wxz = (2.0 * (v.wxy * xyMxz + v.wyz * xzMyz) + v.wxz * (xzMxz - xyMxy - yzMyz)),
      wyz = (2.0 * (v.wxy * xyMyz + v.wxz * xzMyz) + v.wyz * (yzMyz - xyMxy - xzMxz)),
      xyz = (xyMxy + xzMxz + yzMyz),
    )

  infix def reverseSandwich(v: PlaneIdeal): PlaneIdeal =
    val xyMxy = xy * xy
    val xyMxz = xy * xz
    val xyMyz = xy * yz
    val xzMxz = xz * xz
    val xzMyz = xz * yz
    val yzMyz = yz * yz
    PlaneIdeal(
      x = (2.0 * (v.z * xyMyz - v.y * xzMyz) + v.x * (yzMyz - xyMxy - xzMxz)),
      y = (2.0 * (-v.x * xzMyz - v.z * xyMxz) + v.y * (xzMxz - xyMxy - yzMyz)),
      z = (2.0 * (v.x * xyMyz - v.y * xyMxz) + v.z * (xyMxy - xzMxz - yzMyz)),
    )

  infix def reverseSandwich(v: BivectorBulk): BivectorBulk =
    val xyMxy = xy * xy
    val xyMxz = xy * xz
    val xyMyz = xy * yz
    val xzMxz = xz * xz
    val xzMyz = xz * yz
    val yzMyz = yz * yz
    BivectorBulk(
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
      wxy = 0.0,
      wxz = 0.0,
      wyz = 0.0,
      xyz = (xy * xy + xz * xz + yz * yz),
    )

  infix def cross(v: Multivector): Multivector =
    Multivector(
      s = 0.0,
      w = 0.0,
      x = (v.y * xy + v.z * xz),
      y = (v.z * yz - v.x * xy),
      z = (-v.x * xz - v.y * yz),
      wx = (v.wy * xy + v.wz * xz),
      wy = (v.wz * yz - v.wx * xy),
      wz = (-v.wx * xz - v.wy * yz),
      xy = (v.xz * yz - v.yz * xz),
      xz = (v.yz * xy - v.xy * yz),
      yz = (v.xy * xz - v.xz * xy),
      wxy = (v.wxz * yz - v.wyz * xz),
      wxz = (v.wyz * xy - v.wxy * yz),
      wyz = (v.wxy * xz - v.wxz * xy),
      xyz = 0.0,
      i = 0.0,
    )

  infix def cross(v: Motor): Bivector =
    Bivector(
      wx = (v.wy * xy + v.wz * xz),
      wy = (v.wz * yz - v.wx * xy),
      wz = (-v.wx * xz - v.wy * yz),
      xy = (v.xz * yz - v.yz * xz),
      xz = (v.yz * xy - v.xy * yz),
      yz = (v.xy * xz - v.xz * xy),
    )

  infix def cross(v: Plane): PlaneIdeal =
    PlaneIdeal(
      x = (v.y * xy + v.z * xz),
      y = (v.z * yz - v.x * xy),
      z = (-v.x * xz - v.y * yz),
    )

  infix def cross(v: Bivector): Bivector =
    Bivector(
      wx = (v.wy * xy + v.wz * xz),
      wy = (v.wz * yz - v.wx * xy),
      wz = (-v.wx * xz - v.wy * yz),
      xy = (v.xz * yz - v.yz * xz),
      xz = (v.yz * xy - v.xy * yz),
      yz = (v.xy * xz - v.xz * xy),
    )

  infix def cross(v: Point): Vector =
    Vector(
      wxy = (v.wxz * yz - v.wyz * xz),
      wxz = (v.wyz * xy - v.wxy * yz),
      wyz = (v.wxy * xz - v.wxz * xy),
    )

  infix def cross(v: Quaternion): BivectorBulk =
    BivectorBulk(
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
      wxy = (v.wxz * yz - v.wyz * xz),
      wxz = (v.wyz * xy - v.wxy * yz),
      wyz = (v.wxy * xz - v.wxz * xy),
    )

  infix def cross(v: PlaneIdeal): PlaneIdeal =
    PlaneIdeal(
      x = (v.y * xy + v.z * xz),
      y = (v.z * yz - v.x * xy),
      z = (-v.x * xz - v.y * yz),
    )

  infix def cross(v: BivectorBulk): BivectorBulk =
    BivectorBulk(
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