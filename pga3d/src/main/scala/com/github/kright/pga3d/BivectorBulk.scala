package com.github.kright.pga3d

/** this code is generated, see com.github.kright.pga3d.codegen.MultivectorSubClass */
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

  def reverse: BivectorBulk =
    BivectorBulk(
      xy = -xy,
      xz = -xz,
      yz = -yz,
    )

  def antiReverse: BivectorBulk =
    BivectorBulk(
      xy = -xy,
      xz = -xz,
      yz = -yz,
    )

  def unary_ : BivectorBulk =
    BivectorBulk(
      xy = -xy,
      xz = -xz,
      yz = -yz,
    )

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

  def multiplyElementwise(v: BivectorBulk): BivectorBulk =
    BivectorBulk(
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

  infix def wedge(v: QuaternionDual): PseudoScalar =
    PseudoScalar(
      i = (v.wx * yz + v.wz * xy - v.wy * xz),
    )

  inline infix def ^(v: QuaternionDual): PseudoScalar = wedge(v)

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

  infix def sandwich(v: Multivector): Multivector =
    Multivector(
      s = v.s * (xy * xy + xz * xz + yz * yz),
      w = v.w * (xy * xy + xz * xz + yz * yz),
      x = (v.x * yz * yz - 2.0 * v.y * xz * yz - v.x * xy * xy - v.x * xz * xz + 2.0 * v.z * xy * yz),
      y = (v.y * xz * xz - 2.0 * v.x * xz * yz - 2.0 * v.z * xy * xz - v.y * xy * xy - v.y * yz * yz),
      z = (v.z * xy * xy - 2.0 * v.y * xy * xz - v.z * xz * xz - v.z * yz * yz + 2.0 * v.x * xy * yz),
      wx = (v.wx * yz * yz - 2.0 * v.wy * xz * yz - v.wx * xy * xy - v.wx * xz * xz + 2.0 * v.wz * xy * yz),
      wy = (v.wy * xz * xz - 2.0 * v.wx * xz * yz - 2.0 * v.wz * xy * xz - v.wy * xy * xy - v.wy * yz * yz),
      wz = (v.wz * xy * xy - 2.0 * v.wy * xy * xz - v.wz * xz * xz - v.wz * yz * yz + 2.0 * v.wx * xy * yz),
      xy = (v.xy * xy * xy - v.xy * xz * xz - v.xy * yz * yz + 2.0 * v.xz * xy * xz + 2.0 * v.yz * xy * yz),
      xz = (v.xz * xz * xz - v.xz * xy * xy - v.xz * yz * yz + 2.0 * v.xy * xy * xz + 2.0 * v.yz * xz * yz),
      yz = (v.yz * yz * yz - v.yz * xy * xy - v.yz * xz * xz + 2.0 * v.xy * xy * yz + 2.0 * v.xz * xz * yz),
      wxy = (v.wxy * xy * xy - v.wxy * xz * xz - v.wxy * yz * yz + 2.0 * v.wxz * xy * xz + 2.0 * v.wyz * xy * yz),
      wxz = (v.wxz * xz * xz - v.wxz * xy * xy - v.wxz * yz * yz + 2.0 * v.wxy * xy * xz + 2.0 * v.wyz * xz * yz),
      wyz = (v.wyz * yz * yz - v.wyz * xy * xy - v.wyz * xz * xz + 2.0 * v.wxy * xy * yz + 2.0 * v.wxz * xz * yz),
      xyz = v.xyz * (xy * xy + xz * xz + yz * yz),
      i = v.i * (xy * xy + xz * xz + yz * yz),
    )

  infix def sandwich(v: Motor): Motor =
    Motor(
      s = v.s * (xy * xy + xz * xz + yz * yz),
      wx = (v.wx * yz * yz - 2.0 * v.wy * xz * yz - v.wx * xy * xy - v.wx * xz * xz + 2.0 * v.wz * xy * yz),
      wy = (v.wy * xz * xz - 2.0 * v.wx * xz * yz - 2.0 * v.wz * xy * xz - v.wy * xy * xy - v.wy * yz * yz),
      wz = (v.wz * xy * xy - 2.0 * v.wy * xy * xz - v.wz * xz * xz - v.wz * yz * yz + 2.0 * v.wx * xy * yz),
      xy = (v.xy * xy * xy - v.xy * xz * xz - v.xy * yz * yz + 2.0 * v.xz * xy * xz + 2.0 * v.yz * xy * yz),
      xz = (v.xz * xz * xz - v.xz * xy * xy - v.xz * yz * yz + 2.0 * v.xy * xy * xz + 2.0 * v.yz * xz * yz),
      yz = (v.yz * yz * yz - v.yz * xy * xy - v.yz * xz * xz + 2.0 * v.xy * xy * yz + 2.0 * v.xz * xz * yz),
      i = v.i * (xy * xy + xz * xz + yz * yz),
    )

  infix def sandwich(v: Plane): Plane =
    Plane(
      w = v.w * (xy * xy + xz * xz + yz * yz),
      x = (v.x * yz * yz - 2.0 * v.y * xz * yz - v.x * xy * xy - v.x * xz * xz + 2.0 * v.z * xy * yz),
      y = (v.y * xz * xz - 2.0 * v.x * xz * yz - 2.0 * v.z * xy * xz - v.y * xy * xy - v.y * yz * yz),
      z = (v.z * xy * xy - 2.0 * v.y * xy * xz - v.z * xz * xz - v.z * yz * yz + 2.0 * v.x * xy * yz),
    )

  infix def sandwich(v: Bivector): Bivector =
    Bivector(
      wx = (v.wx * yz * yz - 2.0 * v.wy * xz * yz - v.wx * xy * xy - v.wx * xz * xz + 2.0 * v.wz * xy * yz),
      wy = (v.wy * xz * xz - 2.0 * v.wx * xz * yz - 2.0 * v.wz * xy * xz - v.wy * xy * xy - v.wy * yz * yz),
      wz = (v.wz * xy * xy - 2.0 * v.wy * xy * xz - v.wz * xz * xz - v.wz * yz * yz + 2.0 * v.wx * xy * yz),
      xy = (v.xy * xy * xy - v.xy * xz * xz - v.xy * yz * yz + 2.0 * v.xz * xy * xz + 2.0 * v.yz * xy * yz),
      xz = (v.xz * xz * xz - v.xz * xy * xy - v.xz * yz * yz + 2.0 * v.xy * xy * xz + 2.0 * v.yz * xz * yz),
      yz = (v.yz * yz * yz - v.yz * xy * xy - v.yz * xz * xz + 2.0 * v.xy * xy * yz + 2.0 * v.xz * xz * yz),
    )

  infix def sandwich(v: Point): Point =
    Point(
      wxy = (v.wxy * xy * xy - v.wxy * xz * xz - v.wxy * yz * yz + 2.0 * v.wxz * xy * xz + 2.0 * v.wyz * xy * yz),
      wxz = (v.wxz * xz * xz - v.wxz * xy * xy - v.wxz * yz * yz + 2.0 * v.wxy * xy * xz + 2.0 * v.wyz * xz * yz),
      wyz = (v.wyz * yz * yz - v.wyz * xy * xy - v.wyz * xz * xz + 2.0 * v.wxy * xy * yz + 2.0 * v.wxz * xz * yz),
      xyz = v.xyz * (xy * xy + xz * xz + yz * yz),
    )

  infix def sandwich(v: Quaternion): Quaternion =
    Quaternion(
      s = v.s * (xy * xy + xz * xz + yz * yz),
      xy = (v.xy * xy * xy - v.xy * xz * xz - v.xy * yz * yz + 2.0 * v.xz * xy * xz + 2.0 * v.yz * xy * yz),
      xz = (v.xz * xz * xz - v.xz * xy * xy - v.xz * yz * yz + 2.0 * v.xy * xy * xz + 2.0 * v.yz * xz * yz),
      yz = (v.yz * yz * yz - v.yz * xy * xy - v.yz * xz * xz + 2.0 * v.xy * xy * yz + 2.0 * v.xz * xz * yz),
    )

  infix def sandwich(v: QuaternionDual): QuaternionDual =
    QuaternionDual(
      wx = (v.wx * yz * yz - 2.0 * v.wy * xz * yz - v.wx * xy * xy - v.wx * xz * xz + 2.0 * v.wz * xy * yz),
      wy = (v.wy * xz * xz - 2.0 * v.wx * xz * yz - 2.0 * v.wz * xy * xz - v.wy * xy * xy - v.wy * yz * yz),
      wz = (v.wz * xy * xy - 2.0 * v.wy * xy * xz - v.wz * xz * xz - v.wz * yz * yz + 2.0 * v.wx * xy * yz),
      i = v.i * (xy * xy + xz * xz + yz * yz),
    )

  infix def sandwich(v: PointIdeal): PointIdeal =
    PointIdeal(
      wxy = (v.wxy * xy * xy - v.wxy * xz * xz - v.wxy * yz * yz + 2.0 * v.wxz * xy * xz + 2.0 * v.wyz * xy * yz),
      wxz = (v.wxz * xz * xz - v.wxz * xy * xy - v.wxz * yz * yz + 2.0 * v.wxy * xy * xz + 2.0 * v.wyz * xz * yz),
      wyz = (v.wyz * yz * yz - v.wyz * xy * xy - v.wyz * xz * xz + 2.0 * v.wxy * xy * yz + 2.0 * v.wxz * xz * yz),
    )

  infix def sandwich(v: PointNormalized): Point =
    Point(
      wxy = (v.wxy * xy * xy - v.wxy * xz * xz - v.wxy * yz * yz + 2.0 * v.wxz * xy * xz + 2.0 * v.wyz * xy * yz),
      wxz = (v.wxz * xz * xz - v.wxz * xy * xy - v.wxz * yz * yz + 2.0 * v.wxy * xy * xz + 2.0 * v.wyz * xz * yz),
      wyz = (v.wyz * yz * yz - v.wyz * xy * xy - v.wyz * xz * xz + 2.0 * v.wxy * xy * yz + 2.0 * v.wxz * xz * yz),
      xyz = (xy * xy + xz * xz + yz * yz),
    )

  infix def sandwich(v: PlaneIdeal): PlaneIdeal =
    PlaneIdeal(
      x = (v.x * yz * yz - 2.0 * v.y * xz * yz - v.x * xy * xy - v.x * xz * xz + 2.0 * v.z * xy * yz),
      y = (v.y * xz * xz - 2.0 * v.x * xz * yz - 2.0 * v.z * xy * xz - v.y * xy * xy - v.y * yz * yz),
      z = (v.z * xy * xy - 2.0 * v.y * xy * xz - v.z * xz * xz - v.z * yz * yz + 2.0 * v.x * xy * yz),
    )

  infix def sandwich(v: BivectorBulk): BivectorBulk =
    BivectorBulk(
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
    Multivector(
      s = v.s * (xy * xy + xz * xz + yz * yz),
      w = v.w * (xy * xy + xz * xz + yz * yz),
      x = (v.x * yz * yz - 2.0 * v.y * xz * yz - v.x * xy * xy - v.x * xz * xz + 2.0 * v.z * xy * yz),
      y = (v.y * xz * xz - 2.0 * v.x * xz * yz - 2.0 * v.z * xy * xz - v.y * xy * xy - v.y * yz * yz),
      z = (v.z * xy * xy - 2.0 * v.y * xy * xz - v.z * xz * xz - v.z * yz * yz + 2.0 * v.x * xy * yz),
      wx = (v.wx * yz * yz - 2.0 * v.wy * xz * yz - v.wx * xy * xy - v.wx * xz * xz + 2.0 * v.wz * xy * yz),
      wy = (v.wy * xz * xz - 2.0 * v.wx * xz * yz - 2.0 * v.wz * xy * xz - v.wy * xy * xy - v.wy * yz * yz),
      wz = (v.wz * xy * xy - 2.0 * v.wy * xy * xz - v.wz * xz * xz - v.wz * yz * yz + 2.0 * v.wx * xy * yz),
      xy = (v.xy * xy * xy - v.xy * xz * xz - v.xy * yz * yz + 2.0 * v.xz * xy * xz + 2.0 * v.yz * xy * yz),
      xz = (v.xz * xz * xz - v.xz * xy * xy - v.xz * yz * yz + 2.0 * v.xy * xy * xz + 2.0 * v.yz * xz * yz),
      yz = (v.yz * yz * yz - v.yz * xy * xy - v.yz * xz * xz + 2.0 * v.xy * xy * yz + 2.0 * v.xz * xz * yz),
      wxy = (v.wxy * xy * xy - v.wxy * xz * xz - v.wxy * yz * yz + 2.0 * v.wxz * xy * xz + 2.0 * v.wyz * xy * yz),
      wxz = (v.wxz * xz * xz - v.wxz * xy * xy - v.wxz * yz * yz + 2.0 * v.wxy * xy * xz + 2.0 * v.wyz * xz * yz),
      wyz = (v.wyz * yz * yz - v.wyz * xy * xy - v.wyz * xz * xz + 2.0 * v.wxy * xy * yz + 2.0 * v.wxz * xz * yz),
      xyz = v.xyz * (xy * xy + xz * xz + yz * yz),
      i = v.i * (xy * xy + xz * xz + yz * yz),
    )

  infix def reverseSandwich(v: Motor): Motor =
    Motor(
      s = v.s * (xy * xy + xz * xz + yz * yz),
      wx = (v.wx * yz * yz - 2.0 * v.wy * xz * yz - v.wx * xy * xy - v.wx * xz * xz + 2.0 * v.wz * xy * yz),
      wy = (v.wy * xz * xz - 2.0 * v.wx * xz * yz - 2.0 * v.wz * xy * xz - v.wy * xy * xy - v.wy * yz * yz),
      wz = (v.wz * xy * xy - 2.0 * v.wy * xy * xz - v.wz * xz * xz - v.wz * yz * yz + 2.0 * v.wx * xy * yz),
      xy = (v.xy * xy * xy - v.xy * xz * xz - v.xy * yz * yz + 2.0 * v.xz * xy * xz + 2.0 * v.yz * xy * yz),
      xz = (v.xz * xz * xz - v.xz * xy * xy - v.xz * yz * yz + 2.0 * v.xy * xy * xz + 2.0 * v.yz * xz * yz),
      yz = (v.yz * yz * yz - v.yz * xy * xy - v.yz * xz * xz + 2.0 * v.xy * xy * yz + 2.0 * v.xz * xz * yz),
      i = v.i * (xy * xy + xz * xz + yz * yz),
    )

  infix def reverseSandwich(v: Plane): Plane =
    Plane(
      w = v.w * (xy * xy + xz * xz + yz * yz),
      x = (v.x * yz * yz - 2.0 * v.y * xz * yz - v.x * xy * xy - v.x * xz * xz + 2.0 * v.z * xy * yz),
      y = (v.y * xz * xz - 2.0 * v.x * xz * yz - 2.0 * v.z * xy * xz - v.y * xy * xy - v.y * yz * yz),
      z = (v.z * xy * xy - 2.0 * v.y * xy * xz - v.z * xz * xz - v.z * yz * yz + 2.0 * v.x * xy * yz),
    )

  infix def reverseSandwich(v: Bivector): Bivector =
    Bivector(
      wx = (v.wx * yz * yz - 2.0 * v.wy * xz * yz - v.wx * xy * xy - v.wx * xz * xz + 2.0 * v.wz * xy * yz),
      wy = (v.wy * xz * xz - 2.0 * v.wx * xz * yz - 2.0 * v.wz * xy * xz - v.wy * xy * xy - v.wy * yz * yz),
      wz = (v.wz * xy * xy - 2.0 * v.wy * xy * xz - v.wz * xz * xz - v.wz * yz * yz + 2.0 * v.wx * xy * yz),
      xy = (v.xy * xy * xy - v.xy * xz * xz - v.xy * yz * yz + 2.0 * v.xz * xy * xz + 2.0 * v.yz * xy * yz),
      xz = (v.xz * xz * xz - v.xz * xy * xy - v.xz * yz * yz + 2.0 * v.xy * xy * xz + 2.0 * v.yz * xz * yz),
      yz = (v.yz * yz * yz - v.yz * xy * xy - v.yz * xz * xz + 2.0 * v.xy * xy * yz + 2.0 * v.xz * xz * yz),
    )

  infix def reverseSandwich(v: Point): Point =
    Point(
      wxy = (v.wxy * xy * xy - v.wxy * xz * xz - v.wxy * yz * yz + 2.0 * v.wxz * xy * xz + 2.0 * v.wyz * xy * yz),
      wxz = (v.wxz * xz * xz - v.wxz * xy * xy - v.wxz * yz * yz + 2.0 * v.wxy * xy * xz + 2.0 * v.wyz * xz * yz),
      wyz = (v.wyz * yz * yz - v.wyz * xy * xy - v.wyz * xz * xz + 2.0 * v.wxy * xy * yz + 2.0 * v.wxz * xz * yz),
      xyz = v.xyz * (xy * xy + xz * xz + yz * yz),
    )

  infix def reverseSandwich(v: Quaternion): Quaternion =
    Quaternion(
      s = v.s * (xy * xy + xz * xz + yz * yz),
      xy = (v.xy * xy * xy - v.xy * xz * xz - v.xy * yz * yz + 2.0 * v.xz * xy * xz + 2.0 * v.yz * xy * yz),
      xz = (v.xz * xz * xz - v.xz * xy * xy - v.xz * yz * yz + 2.0 * v.xy * xy * xz + 2.0 * v.yz * xz * yz),
      yz = (v.yz * yz * yz - v.yz * xy * xy - v.yz * xz * xz + 2.0 * v.xy * xy * yz + 2.0 * v.xz * xz * yz),
    )

  infix def reverseSandwich(v: QuaternionDual): QuaternionDual =
    QuaternionDual(
      wx = (v.wx * yz * yz - 2.0 * v.wy * xz * yz - v.wx * xy * xy - v.wx * xz * xz + 2.0 * v.wz * xy * yz),
      wy = (v.wy * xz * xz - 2.0 * v.wx * xz * yz - 2.0 * v.wz * xy * xz - v.wy * xy * xy - v.wy * yz * yz),
      wz = (v.wz * xy * xy - 2.0 * v.wy * xy * xz - v.wz * xz * xz - v.wz * yz * yz + 2.0 * v.wx * xy * yz),
      i = v.i * (xy * xy + xz * xz + yz * yz),
    )

  infix def reverseSandwich(v: PointIdeal): PointIdeal =
    PointIdeal(
      wxy = (v.wxy * xy * xy - v.wxy * xz * xz - v.wxy * yz * yz + 2.0 * v.wxz * xy * xz + 2.0 * v.wyz * xy * yz),
      wxz = (v.wxz * xz * xz - v.wxz * xy * xy - v.wxz * yz * yz + 2.0 * v.wxy * xy * xz + 2.0 * v.wyz * xz * yz),
      wyz = (v.wyz * yz * yz - v.wyz * xy * xy - v.wyz * xz * xz + 2.0 * v.wxy * xy * yz + 2.0 * v.wxz * xz * yz),
    )

  infix def reverseSandwich(v: PointNormalized): Point =
    Point(
      wxy = (v.wxy * xy * xy - v.wxy * xz * xz - v.wxy * yz * yz + 2.0 * v.wxz * xy * xz + 2.0 * v.wyz * xy * yz),
      wxz = (v.wxz * xz * xz - v.wxz * xy * xy - v.wxz * yz * yz + 2.0 * v.wxy * xy * xz + 2.0 * v.wyz * xz * yz),
      wyz = (v.wyz * yz * yz - v.wyz * xy * xy - v.wyz * xz * xz + 2.0 * v.wxy * xy * yz + 2.0 * v.wxz * xz * yz),
      xyz = (xy * xy + xz * xz + yz * yz),
    )

  infix def reverseSandwich(v: PlaneIdeal): PlaneIdeal =
    PlaneIdeal(
      x = (v.x * yz * yz - 2.0 * v.y * xz * yz - v.x * xy * xy - v.x * xz * xz + 2.0 * v.z * xy * yz),
      y = (v.y * xz * xz - 2.0 * v.x * xz * yz - 2.0 * v.z * xy * xz - v.y * xy * xy - v.y * yz * yz),
      z = (v.z * xy * xy - 2.0 * v.y * xy * xz - v.z * xz * xz - v.z * yz * yz + 2.0 * v.x * xy * yz),
    )

  infix def reverseSandwich(v: BivectorBulk): BivectorBulk =
    BivectorBulk(
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

  infix def cross(v: Point): PointIdeal =
    PointIdeal(
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

  infix def antiGeometric(v: QuaternionDual): Quaternion =
    Quaternion(
      s = (v.wx * yz + v.wz * xy - v.wy * xz),
      xy = (v.i * xy - v.wx * xz - v.wy * yz),
      xz = (v.i * xz + v.wx * xy - v.wz * yz),
      yz = (v.i * yz + v.wy * xy + v.wz * xz),
    )

  infix def antiGeometric(v: PointIdeal): Multivector =
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

  infix def antiDot(v: QuaternionDual): BivectorBulk =
    BivectorBulk(
      xy = v.i * xy,
      xz = v.i * xz,
      yz = v.i * yz,
    )

  infix def antiDot(v: PointIdeal): Point =
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

  infix def antiWedge(v: QuaternionDual): Quaternion =
    Quaternion(
      s = (v.wx * yz + v.wz * xy - v.wy * xz),
      xy = v.i * xy,
      xz = v.i * xz,
      yz = v.i * yz,
    )

  inline infix def v(v: QuaternionDual): Quaternion = antiWedge(v)

  infix def antiWedge(v: PointIdeal): PlaneIdeal =
    PlaneIdeal(
      x = (v.wxz * xy - v.wxy * xz),
      y = (v.wyz * xy - v.wxy * yz),
      z = (v.wyz * xz - v.wxz * yz),
    )

  inline infix def v(v: PointIdeal): PlaneIdeal = antiWedge(v)

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