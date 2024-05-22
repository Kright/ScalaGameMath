package com.github.kright.pga3d

/** this code is generated, see com.github.kright.pga3d.codegen.MultivectorSubClass */
case class Plane(
                  w: Double = 0.0,
                  x: Double = 0.0,
                  y: Double = 0.0,
                  z: Double = 0.0,
                ):

  def dual: Point =
    Point(
      wxy = -z,
      wxz = y,
      wyz = -x,
      xyz = w,
    )

  def weight: Plane =
    Plane(
      w = w,
      x = 0.0,
      y = 0.0,
      z = 0.0,
    )

  def bulk: PlaneIdeal =
    PlaneIdeal(
      x = x,
      y = y,
      z = z,
    )

  def reverse: Plane =
    this

  def antiReverse: Plane =
    Plane(
      w = -w,
      x = -x,
      y = -y,
      z = -z,
    )

  def unary_ : Plane =
    Plane(
      w = -w,
      x = -x,
      y = -y,
      z = -z,
    )

  def bulkNormSquare: Double =
    (x * x + y * y + z * z)

  def weightNormSquare: Double =
    w * w

  def normSquare: Double =
    (w * w + x * x + y * y + z * z)

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

  def *(v: Double): Plane =
    Plane(
      w = v * w,
      x = v * x,
      y = v * y,
      z = v * z,
    )

  inline def /(v: Double): Plane =
    this * (1.0 / v)

  def +(v: Plane): Plane =
    Plane(
      w = (v.w + w),
      x = (v.x + x),
      y = (v.y + y),
      z = (v.z + z),
    )

  def -(v: Plane): Plane =
    Plane(
      w = (w - v.w),
      x = (x - v.x),
      y = (y - v.y),
      z = (z - v.z),
    )

  def madd(v: Plane, mult: Double): Plane =
    Plane(
      w = (w + mult * v.w),
      x = (x + mult * v.x),
      y = (y + mult * v.y),
      z = (z + mult * v.z),
    )

  def multiplyElementwise(v: Plane): Plane =
    Plane(
      w = v.w * w,
      x = v.x * x,
      y = v.y * y,
      z = v.z * z,
    )

  def toMultivector: Multivector =
    Multivector(
      s = 0.0,
      w = w,
      x = x,
      y = y,
      z = z,
      wx = 0.0,
      wy = 0.0,
      wz = 0.0,
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
      wxy = 0.0,
      wxz = 0.0,
      wyz = 0.0,
      xyz = 0.0,
      i = 0.0,
    )

  infix def geometric(v: Multivector): Multivector =
    Multivector(
      s = (v.x * x + v.y * y + v.z * z),
      w = (v.s * w - v.wx * x - v.wy * y - v.wz * z),
      x = (v.s * x - v.xy * y - v.xz * z),
      y = (v.s * y + v.xy * x - v.yz * z),
      z = (v.s * z + v.xz * x + v.yz * y),
      wx = (v.wxy * y + v.wxz * z + v.x * w - v.w * x),
      wy = (v.wyz * z + v.y * w - v.w * y - v.wxy * x),
      wz = (v.z * w - v.w * z - v.wxz * x - v.wyz * y),
      xy = (v.xyz * z + v.y * x - v.x * y),
      xz = (v.z * x - v.x * z - v.xyz * y),
      yz = (v.xyz * x + v.z * y - v.y * z),
      wxy = (v.wx * y + v.xy * w - v.i * z - v.wy * x),
      wxz = (v.i * y + v.wx * z + v.xz * w - v.wz * x),
      wyz = (v.wy * z + v.yz * w - v.i * x - v.wz * y),
      xyz = (v.xy * z + v.yz * x - v.xz * y),
      i = (v.wxz * y + v.xyz * w - v.wxy * z - v.wyz * x),
    )

  infix def geometric(v: Motor): Multivector =
    Multivector(
      s = 0.0,
      w = (v.s * w - v.wx * x - v.wy * y - v.wz * z),
      x = (v.s * x - v.xy * y - v.xz * z),
      y = (v.s * y + v.xy * x - v.yz * z),
      z = (v.s * z + v.xz * x + v.yz * y),
      wx = 0.0,
      wy = 0.0,
      wz = 0.0,
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
      wxy = (v.wx * y + v.xy * w - v.i * z - v.wy * x),
      wxz = (v.i * y + v.wx * z + v.xz * w - v.wz * x),
      wyz = (v.wy * z + v.yz * w - v.i * x - v.wz * y),
      xyz = (v.xy * z + v.yz * x - v.xz * y),
      i = 0.0,
    )

  infix def geometric(v: Plane): Motor =
    Motor(
      s = (v.x * x + v.y * y + v.z * z),
      wx = (v.x * w - v.w * x),
      wy = (v.y * w - v.w * y),
      wz = (v.z * w - v.w * z),
      xy = (v.y * x - v.x * y),
      xz = (v.z * x - v.x * z),
      yz = (v.z * y - v.y * z),
      i = 0.0,
    )

  infix def geometric(v: Bivector): Multivector =
    Multivector(
      s = 0.0,
      w = (-v.wx * x - v.wy * y - v.wz * z),
      x = (-v.xy * y - v.xz * z),
      y = (v.xy * x - v.yz * z),
      z = (v.xz * x + v.yz * y),
      wx = 0.0,
      wy = 0.0,
      wz = 0.0,
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
      wxy = (v.wx * y + v.xy * w - v.wy * x),
      wxz = (v.wx * z + v.xz * w - v.wz * x),
      wyz = (v.wy * z + v.yz * w - v.wz * y),
      xyz = (v.xy * z + v.yz * x - v.xz * y),
      i = 0.0,
    )

  infix def geometric(v: Point): Motor =
    Motor(
      s = 0.0,
      wx = (v.wxy * y + v.wxz * z),
      wy = (v.wyz * z - v.wxy * x),
      wz = (-v.wxz * x - v.wyz * y),
      xy = v.xyz * z,
      xz = -v.xyz * y,
      yz = v.xyz * x,
      i = (v.wxz * y + v.xyz * w - v.wxy * z - v.wyz * x),
    )

  infix def geometric(v: Quaternion): Multivector =
    Multivector(
      s = 0.0,
      w = v.s * w,
      x = (v.s * x - v.xy * y - v.xz * z),
      y = (v.s * y + v.xy * x - v.yz * z),
      z = (v.s * z + v.xz * x + v.yz * y),
      wx = 0.0,
      wy = 0.0,
      wz = 0.0,
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
      wxy = v.xy * w,
      wxz = v.xz * w,
      wyz = v.yz * w,
      xyz = (v.xy * z + v.yz * x - v.xz * y),
      i = 0.0,
    )

  infix def geometric(v: QuaternionDual): Multivector =
    Multivector(
      s = 0.0,
      w = (-v.wx * x - v.wy * y - v.wz * z),
      x = 0.0,
      y = 0.0,
      z = 0.0,
      wx = 0.0,
      wy = 0.0,
      wz = 0.0,
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
      wxy = (v.wx * y - v.i * z - v.wy * x),
      wxz = (v.i * y + v.wx * z - v.wz * x),
      wyz = (v.wy * z - v.i * x - v.wz * y),
      xyz = 0.0,
      i = 0.0,
    )

  infix def geometric(v: PointIdeal): QuaternionDual =
    QuaternionDual(
      wx = (v.wxy * y + v.wxz * z),
      wy = (v.wyz * z - v.wxy * x),
      wz = (-v.wxz * x - v.wyz * y),
      i = (v.wxz * y - v.wxy * z - v.wyz * x),
    )

  infix def geometric(v: PointNormalized): Motor =
    Motor(
      s = 0.0,
      wx = (v.wxy * y + v.wxz * z),
      wy = (v.wyz * z - v.wxy * x),
      wz = (-v.wxz * x - v.wyz * y),
      xy = z,
      xz = -y,
      yz = x,
      i = (w + v.wxz * y - v.wxy * z - v.wyz * x),
    )

  infix def geometric(v: PlaneIdeal): Motor =
    Motor(
      s = (v.x * x + v.y * y + v.z * z),
      wx = v.x * w,
      wy = v.y * w,
      wz = v.z * w,
      xy = (v.y * x - v.x * y),
      xz = (v.z * x - v.x * z),
      yz = (v.z * y - v.y * z),
      i = 0.0,
    )

  infix def geometric(v: BivectorBulk): Multivector =
    Multivector(
      s = 0.0,
      w = 0.0,
      x = (-v.xy * y - v.xz * z),
      y = (v.xy * x - v.yz * z),
      z = (v.xz * x + v.yz * y),
      wx = 0.0,
      wy = 0.0,
      wz = 0.0,
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
      wxy = v.xy * w,
      wxz = v.xz * w,
      wyz = v.yz * w,
      xyz = (v.xy * z + v.yz * x - v.xz * y),
      i = 0.0,
    )

  infix def geometric(v: BivectorWeight): Multivector =
    Multivector(
      s = 0.0,
      w = (-v.wx * x - v.wy * y - v.wz * z),
      x = 0.0,
      y = 0.0,
      z = 0.0,
      wx = 0.0,
      wy = 0.0,
      wz = 0.0,
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
      wxy = (v.wx * y - v.wy * x),
      wxz = (v.wx * z - v.wz * x),
      wyz = (v.wy * z - v.wz * y),
      xyz = 0.0,
      i = 0.0,
    )

  infix def geometric(v: PseudoScalar): PointIdeal =
    PointIdeal(
      wxy = -v.i * z,
      wxz = v.i * y,
      wyz = -v.i * x,
    )

  infix def geometric(v: PointCenter.type): Motor =
    Motor(
      s = 0.0,
      wx = 0.0,
      wy = 0.0,
      wz = 0.0,
      xy = z,
      xz = -y,
      yz = x,
      i = w,
    )

  infix def dot(v: Multivector): Multivector =
    Multivector(
      s = (v.x * x + v.y * y + v.z * z),
      w = (v.s * w - v.wx * x - v.wy * y - v.wz * z),
      x = (v.s * x - v.xy * y - v.xz * z),
      y = (v.s * y + v.xy * x - v.yz * z),
      z = (v.s * z + v.xz * x + v.yz * y),
      wx = (v.wxy * y + v.wxz * z),
      wy = (v.wyz * z - v.wxy * x),
      wz = (-v.wxz * x - v.wyz * y),
      xy = v.xyz * z,
      xz = -v.xyz * y,
      yz = v.xyz * x,
      wxy = -v.i * z,
      wxz = v.i * y,
      wyz = -v.i * x,
      xyz = 0.0,
      i = 0.0,
    )

  infix def dot(v: Motor): Multivector =
    Multivector(
      s = 0.0,
      w = (v.s * w - v.wx * x - v.wy * y - v.wz * z),
      x = (v.s * x - v.xy * y - v.xz * z),
      y = (v.s * y + v.xy * x - v.yz * z),
      z = (v.s * z + v.xz * x + v.yz * y),
      wx = 0.0,
      wy = 0.0,
      wz = 0.0,
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
      wxy = -v.i * z,
      wxz = v.i * y,
      wyz = -v.i * x,
      xyz = 0.0,
      i = 0.0,
    )

  infix def dot(v: Plane): Double =
    (v.x * x + v.y * y + v.z * z)

  infix def dot(v: Bivector): Plane =
    Plane(
      w = (-v.wx * x - v.wy * y - v.wz * z),
      x = (-v.xy * y - v.xz * z),
      y = (v.xy * x - v.yz * z),
      z = (v.xz * x + v.yz * y),
    )

  infix def dot(v: Point): Bivector =
    Bivector(
      wx = (v.wxy * y + v.wxz * z),
      wy = (v.wyz * z - v.wxy * x),
      wz = (-v.wxz * x - v.wyz * y),
      xy = v.xyz * z,
      xz = -v.xyz * y,
      yz = v.xyz * x,
    )

  infix def dot(v: Quaternion): Plane =
    Plane(
      w = v.s * w,
      x = (v.s * x - v.xy * y - v.xz * z),
      y = (v.s * y + v.xy * x - v.yz * z),
      z = (v.s * z + v.xz * x + v.yz * y),
    )

  infix def dot(v: QuaternionDual): Multivector =
    Multivector(
      s = 0.0,
      w = (-v.wx * x - v.wy * y - v.wz * z),
      x = 0.0,
      y = 0.0,
      z = 0.0,
      wx = 0.0,
      wy = 0.0,
      wz = 0.0,
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
      wxy = -v.i * z,
      wxz = v.i * y,
      wyz = -v.i * x,
      xyz = 0.0,
      i = 0.0,
    )

  infix def dot(v: PointIdeal): BivectorWeight =
    BivectorWeight(
      wx = (v.wxy * y + v.wxz * z),
      wy = (v.wyz * z - v.wxy * x),
      wz = (-v.wxz * x - v.wyz * y),
    )

  infix def dot(v: PointNormalized): Bivector =
    Bivector(
      wx = (v.wxy * y + v.wxz * z),
      wy = (v.wyz * z - v.wxy * x),
      wz = (-v.wxz * x - v.wyz * y),
      xy = z,
      xz = -y,
      yz = x,
    )

  infix def dot(v: PlaneIdeal): Double =
    (v.x * x + v.y * y + v.z * z)

  infix def dot(v: BivectorBulk): PlaneIdeal =
    PlaneIdeal(
      x = (-v.xy * y - v.xz * z),
      y = (v.xy * x - v.yz * z),
      z = (v.xz * x + v.yz * y),
    )

  infix def dot(v: BivectorWeight): Plane =
    Plane(
      w = (-v.wx * x - v.wy * y - v.wz * z),
      x = 0.0,
      y = 0.0,
      z = 0.0,
    )

  infix def dot(v: PseudoScalar): PointIdeal =
    PointIdeal(
      wxy = -v.i * z,
      wxz = v.i * y,
      wyz = -v.i * x,
    )

  infix def dot(v: PointCenter.type): BivectorBulk =
    BivectorBulk(
      xy = z,
      xz = -y,
      yz = x,
    )

  infix def wedge(v: Multivector): Multivector =
    Multivector(
      s = 0.0,
      w = v.s * w,
      x = v.s * x,
      y = v.s * y,
      z = v.s * z,
      wx = (v.x * w - v.w * x),
      wy = (v.y * w - v.w * y),
      wz = (v.z * w - v.w * z),
      xy = (v.y * x - v.x * y),
      xz = (v.z * x - v.x * z),
      yz = (v.z * y - v.y * z),
      wxy = (v.wx * y + v.xy * w - v.wy * x),
      wxz = (v.wx * z + v.xz * w - v.wz * x),
      wyz = (v.wy * z + v.yz * w - v.wz * y),
      xyz = (v.xy * z + v.yz * x - v.xz * y),
      i = (v.wxz * y + v.xyz * w - v.wxy * z - v.wyz * x),
    )

  inline infix def ^(v: Multivector): Multivector = wedge(v)

  infix def wedge(v: Motor): Multivector =
    Multivector(
      s = 0.0,
      w = v.s * w,
      x = v.s * x,
      y = v.s * y,
      z = v.s * z,
      wx = 0.0,
      wy = 0.0,
      wz = 0.0,
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
      wxy = (v.wx * y + v.xy * w - v.wy * x),
      wxz = (v.wx * z + v.xz * w - v.wz * x),
      wyz = (v.wy * z + v.yz * w - v.wz * y),
      xyz = (v.xy * z + v.yz * x - v.xz * y),
      i = 0.0,
    )

  inline infix def ^(v: Motor): Multivector = wedge(v)

  infix def wedge(v: Plane): Bivector =
    Bivector(
      wx = (v.x * w - v.w * x),
      wy = (v.y * w - v.w * y),
      wz = (v.z * w - v.w * z),
      xy = (v.y * x - v.x * y),
      xz = (v.z * x - v.x * z),
      yz = (v.z * y - v.y * z),
    )

  inline infix def ^(v: Plane): Bivector = wedge(v)

  infix def wedge(v: Bivector): Point =
    Point(
      wxy = (v.wx * y + v.xy * w - v.wy * x),
      wxz = (v.wx * z + v.xz * w - v.wz * x),
      wyz = (v.wy * z + v.yz * w - v.wz * y),
      xyz = (v.xy * z + v.yz * x - v.xz * y),
    )

  inline infix def ^(v: Bivector): Point = wedge(v)

  infix def wedge(v: Point): PseudoScalar =
    PseudoScalar(
      i = (v.wxz * y + v.xyz * w - v.wxy * z - v.wyz * x),
    )

  inline infix def ^(v: Point): PseudoScalar = wedge(v)

  infix def wedge(v: Quaternion): Multivector =
    Multivector(
      s = 0.0,
      w = v.s * w,
      x = v.s * x,
      y = v.s * y,
      z = v.s * z,
      wx = 0.0,
      wy = 0.0,
      wz = 0.0,
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
      wxy = v.xy * w,
      wxz = v.xz * w,
      wyz = v.yz * w,
      xyz = (v.xy * z + v.yz * x - v.xz * y),
      i = 0.0,
    )

  inline infix def ^(v: Quaternion): Multivector = wedge(v)

  infix def wedge(v: QuaternionDual): PointIdeal =
    PointIdeal(
      wxy = (v.wx * y - v.wy * x),
      wxz = (v.wx * z - v.wz * x),
      wyz = (v.wy * z - v.wz * y),
    )

  inline infix def ^(v: QuaternionDual): PointIdeal = wedge(v)

  infix def wedge(v: PointIdeal): PseudoScalar =
    PseudoScalar(
      i = (v.wxz * y - v.wxy * z - v.wyz * x),
    )

  inline infix def ^(v: PointIdeal): PseudoScalar = wedge(v)

  infix def wedge(v: PointNormalized): PseudoScalar =
    PseudoScalar(
      i = (w + v.wxz * y - v.wxy * z - v.wyz * x),
    )

  inline infix def ^(v: PointNormalized): PseudoScalar = wedge(v)

  infix def wedge(v: PlaneIdeal): Bivector =
    Bivector(
      wx = v.x * w,
      wy = v.y * w,
      wz = v.z * w,
      xy = (v.y * x - v.x * y),
      xz = (v.z * x - v.x * z),
      yz = (v.z * y - v.y * z),
    )

  inline infix def ^(v: PlaneIdeal): Bivector = wedge(v)

  infix def wedge(v: BivectorBulk): Point =
    Point(
      wxy = v.xy * w,
      wxz = v.xz * w,
      wyz = v.yz * w,
      xyz = (v.xy * z + v.yz * x - v.xz * y),
    )

  inline infix def ^(v: BivectorBulk): Point = wedge(v)

  infix def wedge(v: BivectorWeight): PointIdeal =
    PointIdeal(
      wxy = (v.wx * y - v.wy * x),
      wxz = (v.wx * z - v.wz * x),
      wyz = (v.wy * z - v.wz * y),
    )

  inline infix def ^(v: BivectorWeight): PointIdeal = wedge(v)

  infix def wedge(v: PointCenter.type): PseudoScalar =
    PseudoScalar(
      i = w,
    )

  inline infix def ^(v: PointCenter.type): PseudoScalar = wedge(v)

  infix def sandwich(v: Multivector): Multivector =
    Multivector(
      s = v.s * (x * x + y * y + z * z),
      w = (-v.w * x * x - v.w * y * y - v.w * z * z + 2.0 * v.x * w * x + 2.0 * v.y * w * y + 2.0 * v.z * w * z),
      x = (v.x * x * x - v.x * y * y - v.x * z * z + 2.0 * v.y * x * y + 2.0 * v.z * x * z),
      y = (v.y * y * y - v.y * x * x - v.y * z * z + 2.0 * v.x * x * y + 2.0 * v.z * y * z),
      z = (v.z * z * z - v.z * x * x - v.z * y * y + 2.0 * v.x * x * z + 2.0 * v.y * y * z),
      wx = (v.wx * y * y + v.wx * z * z - 2.0 * v.wy * x * y - 2.0 * v.wz * x * z - v.wx * x * x + 2.0 * v.xy * w * y + 2.0 * v.xz * w * z),
      wy = (v.wy * x * x + v.wy * z * z - 2.0 * v.wx * x * y - 2.0 * v.wz * y * z - 2.0 * v.xy * w * x - v.wy * y * y + 2.0 * v.yz * w * z),
      wz = (v.wz * x * x + v.wz * y * y - 2.0 * v.wx * x * z - 2.0 * v.wy * y * z - 2.0 * v.xz * w * x - 2.0 * v.yz * w * y - v.wz * z * z),
      xy = (v.xy * z * z - 2.0 * v.xz * y * z - v.xy * x * x - v.xy * y * y + 2.0 * v.yz * x * z),
      xz = (v.xz * y * y - 2.0 * v.xy * y * z - 2.0 * v.yz * x * y - v.xz * x * x - v.xz * z * z),
      yz = (v.yz * x * x - 2.0 * v.xz * x * y - v.yz * y * y - v.yz * z * z + 2.0 * v.xy * x * z),
      wxy = (v.wxy * x * x + v.wxy * y * y - 2.0 * v.wyz * x * z - v.wxy * z * z + 2.0 * v.wxz * y * z + 2.0 * v.xyz * w * z),
      wxz = (v.wxz * x * x + v.wxz * z * z - 2.0 * v.xyz * w * y - v.wxz * y * y + 2.0 * v.wxy * y * z + 2.0 * v.wyz * x * y),
      wyz = (v.wyz * y * y + v.wyz * z * z - 2.0 * v.wxy * x * z - v.wyz * x * x + 2.0 * v.wxz * x * y + 2.0 * v.xyz * w * x),
      xyz = v.xyz * (x * x + y * y + z * z),
      i = v.i * (-x * x - y * y - z * z),
    )

  infix def sandwich(v: Motor): Motor =
    Motor(
      s = v.s * (x * x + y * y + z * z),
      wx = (v.wx * y * y + v.wx * z * z - 2.0 * v.wy * x * y - 2.0 * v.wz * x * z - v.wx * x * x + 2.0 * v.xy * w * y + 2.0 * v.xz * w * z),
      wy = (v.wy * x * x + v.wy * z * z - 2.0 * v.wx * x * y - 2.0 * v.wz * y * z - 2.0 * v.xy * w * x - v.wy * y * y + 2.0 * v.yz * w * z),
      wz = (v.wz * x * x + v.wz * y * y - 2.0 * v.wx * x * z - 2.0 * v.wy * y * z - 2.0 * v.xz * w * x - 2.0 * v.yz * w * y - v.wz * z * z),
      xy = (v.xy * z * z - 2.0 * v.xz * y * z - v.xy * x * x - v.xy * y * y + 2.0 * v.yz * x * z),
      xz = (v.xz * y * y - 2.0 * v.xy * y * z - 2.0 * v.yz * x * y - v.xz * x * x - v.xz * z * z),
      yz = (v.yz * x * x - 2.0 * v.xz * x * y - v.yz * y * y - v.yz * z * z + 2.0 * v.xy * x * z),
      i = v.i * (-x * x - y * y - z * z),
    )

  infix def sandwich(v: Plane): Plane =
    Plane(
      w = (-v.w * x * x - v.w * y * y - v.w * z * z + 2.0 * v.x * w * x + 2.0 * v.y * w * y + 2.0 * v.z * w * z),
      x = (v.x * x * x - v.x * y * y - v.x * z * z + 2.0 * v.y * x * y + 2.0 * v.z * x * z),
      y = (v.y * y * y - v.y * x * x - v.y * z * z + 2.0 * v.x * x * y + 2.0 * v.z * y * z),
      z = (v.z * z * z - v.z * x * x - v.z * y * y + 2.0 * v.x * x * z + 2.0 * v.y * y * z),
    )

  infix def sandwich(v: Bivector): Bivector =
    Bivector(
      wx = (v.wx * y * y + v.wx * z * z - 2.0 * v.wy * x * y - 2.0 * v.wz * x * z - v.wx * x * x + 2.0 * v.xy * w * y + 2.0 * v.xz * w * z),
      wy = (v.wy * x * x + v.wy * z * z - 2.0 * v.wx * x * y - 2.0 * v.wz * y * z - 2.0 * v.xy * w * x - v.wy * y * y + 2.0 * v.yz * w * z),
      wz = (v.wz * x * x + v.wz * y * y - 2.0 * v.wx * x * z - 2.0 * v.wy * y * z - 2.0 * v.xz * w * x - 2.0 * v.yz * w * y - v.wz * z * z),
      xy = (v.xy * z * z - 2.0 * v.xz * y * z - v.xy * x * x - v.xy * y * y + 2.0 * v.yz * x * z),
      xz = (v.xz * y * y - 2.0 * v.xy * y * z - 2.0 * v.yz * x * y - v.xz * x * x - v.xz * z * z),
      yz = (v.yz * x * x - 2.0 * v.xz * x * y - v.yz * y * y - v.yz * z * z + 2.0 * v.xy * x * z),
    )

  infix def sandwich(v: Point): Point =
    Point(
      wxy = (v.wxy * x * x + v.wxy * y * y - 2.0 * v.wyz * x * z - v.wxy * z * z + 2.0 * v.wxz * y * z + 2.0 * v.xyz * w * z),
      wxz = (v.wxz * x * x + v.wxz * z * z - 2.0 * v.xyz * w * y - v.wxz * y * y + 2.0 * v.wxy * y * z + 2.0 * v.wyz * x * y),
      wyz = (v.wyz * y * y + v.wyz * z * z - 2.0 * v.wxy * x * z - v.wyz * x * x + 2.0 * v.wxz * x * y + 2.0 * v.xyz * w * x),
      xyz = v.xyz * (x * x + y * y + z * z),
    )

  infix def sandwich(v: Quaternion): Motor =
    Motor(
      s = v.s * (x * x + y * y + z * z),
      wx = 2.0 * w * (v.xy * y + v.xz * z),
      wy = w * (-2.0 * v.xy * x + 2.0 * v.yz * z),
      wz = -2.0 * w * (v.xz * x + v.yz * y),
      xy = (v.xy * z * z - 2.0 * v.xz * y * z - v.xy * x * x - v.xy * y * y + 2.0 * v.yz * x * z),
      xz = (v.xz * y * y - 2.0 * v.xy * y * z - 2.0 * v.yz * x * y - v.xz * x * x - v.xz * z * z),
      yz = (v.yz * x * x - 2.0 * v.xz * x * y - v.yz * y * y - v.yz * z * z + 2.0 * v.xy * x * z),
      i = 0.0,
    )

  infix def sandwich(v: QuaternionDual): QuaternionDual =
    QuaternionDual(
      wx = (v.wx * y * y + v.wx * z * z - 2.0 * v.wy * x * y - 2.0 * v.wz * x * z - v.wx * x * x),
      wy = (v.wy * x * x + v.wy * z * z - 2.0 * v.wx * x * y - 2.0 * v.wz * y * z - v.wy * y * y),
      wz = (v.wz * x * x + v.wz * y * y - 2.0 * v.wx * x * z - 2.0 * v.wy * y * z - v.wz * z * z),
      i = v.i * (-x * x - y * y - z * z),
    )

  infix def sandwich(v: PointIdeal): PointIdeal =
    PointIdeal(
      wxy = (v.wxy * x * x + v.wxy * y * y - 2.0 * v.wyz * x * z - v.wxy * z * z + 2.0 * v.wxz * y * z),
      wxz = (v.wxz * x * x + v.wxz * z * z - v.wxz * y * y + 2.0 * v.wxy * y * z + 2.0 * v.wyz * x * y),
      wyz = (v.wyz * y * y + v.wyz * z * z - 2.0 * v.wxy * x * z - v.wyz * x * x + 2.0 * v.wxz * x * y),
    )

  infix def sandwich(v: PointNormalized): Point =
    Point(
      wxy = (2.0 * w * z + v.wxy * x * x + v.wxy * y * y - 2.0 * v.wyz * x * z - v.wxy * z * z + 2.0 * v.wxz * y * z),
      wxz = (-2.0 * w * y + v.wxz * x * x + v.wxz * z * z - v.wxz * y * y + 2.0 * v.wxy * y * z + 2.0 * v.wyz * x * y),
      wyz = (2.0 * w * x + v.wyz * y * y + v.wyz * z * z - 2.0 * v.wxy * x * z - v.wyz * x * x + 2.0 * v.wxz * x * y),
      xyz = (x * x + y * y + z * z),
    )

  infix def sandwich(v: PlaneIdeal): Plane =
    Plane(
      w = 2.0 * w * (v.x * x + v.y * y + v.z * z),
      x = (v.x * x * x - v.x * y * y - v.x * z * z + 2.0 * v.y * x * y + 2.0 * v.z * x * z),
      y = (v.y * y * y - v.y * x * x - v.y * z * z + 2.0 * v.x * x * y + 2.0 * v.z * y * z),
      z = (v.z * z * z - v.z * x * x - v.z * y * y + 2.0 * v.x * x * z + 2.0 * v.y * y * z),
    )

  infix def sandwich(v: BivectorBulk): Bivector =
    Bivector(
      wx = 2.0 * w * (v.xy * y + v.xz * z),
      wy = w * (-2.0 * v.xy * x + 2.0 * v.yz * z),
      wz = -2.0 * w * (v.xz * x + v.yz * y),
      xy = (v.xy * z * z - 2.0 * v.xz * y * z - v.xy * x * x - v.xy * y * y + 2.0 * v.yz * x * z),
      xz = (v.xz * y * y - 2.0 * v.xy * y * z - 2.0 * v.yz * x * y - v.xz * x * x - v.xz * z * z),
      yz = (v.yz * x * x - 2.0 * v.xz * x * y - v.yz * y * y - v.yz * z * z + 2.0 * v.xy * x * z),
    )

  infix def sandwich(v: BivectorWeight): BivectorWeight =
    BivectorWeight(
      wx = (v.wx * y * y + v.wx * z * z - 2.0 * v.wy * x * y - 2.0 * v.wz * x * z - v.wx * x * x),
      wy = (v.wy * x * x + v.wy * z * z - 2.0 * v.wx * x * y - 2.0 * v.wz * y * z - v.wy * y * y),
      wz = (v.wz * x * x + v.wz * y * y - 2.0 * v.wx * x * z - 2.0 * v.wy * y * z - v.wz * z * z),
    )

  infix def sandwich(v: PseudoScalar): PseudoScalar =
    PseudoScalar(
      i = v.i * (-x * x - y * y - z * z),
    )

  infix def sandwich(v: PointCenter.type): Point =
    Point(
      wxy = 2.0 * w * z,
      wxz = -2.0 * w * y,
      wyz = 2.0 * w * x,
      xyz = (x * x + y * y + z * z),
    )

  infix def reverseSandwich(v: Multivector): Multivector =
    Multivector(
      s = v.s * (x * x + y * y + z * z),
      w = (-v.w * x * x - v.w * y * y - v.w * z * z + 2.0 * v.x * w * x + 2.0 * v.y * w * y + 2.0 * v.z * w * z),
      x = (v.x * x * x - v.x * y * y - v.x * z * z + 2.0 * v.y * x * y + 2.0 * v.z * x * z),
      y = (v.y * y * y - v.y * x * x - v.y * z * z + 2.0 * v.x * x * y + 2.0 * v.z * y * z),
      z = (v.z * z * z - v.z * x * x - v.z * y * y + 2.0 * v.x * x * z + 2.0 * v.y * y * z),
      wx = (v.wx * y * y + v.wx * z * z - 2.0 * v.wy * x * y - 2.0 * v.wz * x * z - v.wx * x * x + 2.0 * v.xy * w * y + 2.0 * v.xz * w * z),
      wy = (v.wy * x * x + v.wy * z * z - 2.0 * v.wx * x * y - 2.0 * v.wz * y * z - 2.0 * v.xy * w * x - v.wy * y * y + 2.0 * v.yz * w * z),
      wz = (v.wz * x * x + v.wz * y * y - 2.0 * v.wx * x * z - 2.0 * v.wy * y * z - 2.0 * v.xz * w * x - 2.0 * v.yz * w * y - v.wz * z * z),
      xy = (v.xy * z * z - 2.0 * v.xz * y * z - v.xy * x * x - v.xy * y * y + 2.0 * v.yz * x * z),
      xz = (v.xz * y * y - 2.0 * v.xy * y * z - 2.0 * v.yz * x * y - v.xz * x * x - v.xz * z * z),
      yz = (v.yz * x * x - 2.0 * v.xz * x * y - v.yz * y * y - v.yz * z * z + 2.0 * v.xy * x * z),
      wxy = (v.wxy * x * x + v.wxy * y * y - 2.0 * v.wyz * x * z - v.wxy * z * z + 2.0 * v.wxz * y * z + 2.0 * v.xyz * w * z),
      wxz = (v.wxz * x * x + v.wxz * z * z - 2.0 * v.xyz * w * y - v.wxz * y * y + 2.0 * v.wxy * y * z + 2.0 * v.wyz * x * y),
      wyz = (v.wyz * y * y + v.wyz * z * z - 2.0 * v.wxy * x * z - v.wyz * x * x + 2.0 * v.wxz * x * y + 2.0 * v.xyz * w * x),
      xyz = v.xyz * (x * x + y * y + z * z),
      i = v.i * (-x * x - y * y - z * z),
    )

  infix def reverseSandwich(v: Motor): Motor =
    Motor(
      s = v.s * (x * x + y * y + z * z),
      wx = (v.wx * y * y + v.wx * z * z - 2.0 * v.wy * x * y - 2.0 * v.wz * x * z - v.wx * x * x + 2.0 * v.xy * w * y + 2.0 * v.xz * w * z),
      wy = (v.wy * x * x + v.wy * z * z - 2.0 * v.wx * x * y - 2.0 * v.wz * y * z - 2.0 * v.xy * w * x - v.wy * y * y + 2.0 * v.yz * w * z),
      wz = (v.wz * x * x + v.wz * y * y - 2.0 * v.wx * x * z - 2.0 * v.wy * y * z - 2.0 * v.xz * w * x - 2.0 * v.yz * w * y - v.wz * z * z),
      xy = (v.xy * z * z - 2.0 * v.xz * y * z - v.xy * x * x - v.xy * y * y + 2.0 * v.yz * x * z),
      xz = (v.xz * y * y - 2.0 * v.xy * y * z - 2.0 * v.yz * x * y - v.xz * x * x - v.xz * z * z),
      yz = (v.yz * x * x - 2.0 * v.xz * x * y - v.yz * y * y - v.yz * z * z + 2.0 * v.xy * x * z),
      i = v.i * (-x * x - y * y - z * z),
    )

  infix def reverseSandwich(v: Plane): Plane =
    Plane(
      w = (-v.w * x * x - v.w * y * y - v.w * z * z + 2.0 * v.x * w * x + 2.0 * v.y * w * y + 2.0 * v.z * w * z),
      x = (v.x * x * x - v.x * y * y - v.x * z * z + 2.0 * v.y * x * y + 2.0 * v.z * x * z),
      y = (v.y * y * y - v.y * x * x - v.y * z * z + 2.0 * v.x * x * y + 2.0 * v.z * y * z),
      z = (v.z * z * z - v.z * x * x - v.z * y * y + 2.0 * v.x * x * z + 2.0 * v.y * y * z),
    )

  infix def reverseSandwich(v: Bivector): Bivector =
    Bivector(
      wx = (v.wx * y * y + v.wx * z * z - 2.0 * v.wy * x * y - 2.0 * v.wz * x * z - v.wx * x * x + 2.0 * v.xy * w * y + 2.0 * v.xz * w * z),
      wy = (v.wy * x * x + v.wy * z * z - 2.0 * v.wx * x * y - 2.0 * v.wz * y * z - 2.0 * v.xy * w * x - v.wy * y * y + 2.0 * v.yz * w * z),
      wz = (v.wz * x * x + v.wz * y * y - 2.0 * v.wx * x * z - 2.0 * v.wy * y * z - 2.0 * v.xz * w * x - 2.0 * v.yz * w * y - v.wz * z * z),
      xy = (v.xy * z * z - 2.0 * v.xz * y * z - v.xy * x * x - v.xy * y * y + 2.0 * v.yz * x * z),
      xz = (v.xz * y * y - 2.0 * v.xy * y * z - 2.0 * v.yz * x * y - v.xz * x * x - v.xz * z * z),
      yz = (v.yz * x * x - 2.0 * v.xz * x * y - v.yz * y * y - v.yz * z * z + 2.0 * v.xy * x * z),
    )

  infix def reverseSandwich(v: Point): Point =
    Point(
      wxy = (v.wxy * x * x + v.wxy * y * y - 2.0 * v.wyz * x * z - v.wxy * z * z + 2.0 * v.wxz * y * z + 2.0 * v.xyz * w * z),
      wxz = (v.wxz * x * x + v.wxz * z * z - 2.0 * v.xyz * w * y - v.wxz * y * y + 2.0 * v.wxy * y * z + 2.0 * v.wyz * x * y),
      wyz = (v.wyz * y * y + v.wyz * z * z - 2.0 * v.wxy * x * z - v.wyz * x * x + 2.0 * v.wxz * x * y + 2.0 * v.xyz * w * x),
      xyz = v.xyz * (x * x + y * y + z * z),
    )

  infix def reverseSandwich(v: Quaternion): Motor =
    Motor(
      s = v.s * (x * x + y * y + z * z),
      wx = 2.0 * w * (v.xy * y + v.xz * z),
      wy = w * (-2.0 * v.xy * x + 2.0 * v.yz * z),
      wz = -2.0 * w * (v.xz * x + v.yz * y),
      xy = (v.xy * z * z - 2.0 * v.xz * y * z - v.xy * x * x - v.xy * y * y + 2.0 * v.yz * x * z),
      xz = (v.xz * y * y - 2.0 * v.xy * y * z - 2.0 * v.yz * x * y - v.xz * x * x - v.xz * z * z),
      yz = (v.yz * x * x - 2.0 * v.xz * x * y - v.yz * y * y - v.yz * z * z + 2.0 * v.xy * x * z),
      i = 0.0,
    )

  infix def reverseSandwich(v: QuaternionDual): QuaternionDual =
    QuaternionDual(
      wx = (v.wx * y * y + v.wx * z * z - 2.0 * v.wy * x * y - 2.0 * v.wz * x * z - v.wx * x * x),
      wy = (v.wy * x * x + v.wy * z * z - 2.0 * v.wx * x * y - 2.0 * v.wz * y * z - v.wy * y * y),
      wz = (v.wz * x * x + v.wz * y * y - 2.0 * v.wx * x * z - 2.0 * v.wy * y * z - v.wz * z * z),
      i = v.i * (-x * x - y * y - z * z),
    )

  infix def reverseSandwich(v: PointIdeal): PointIdeal =
    PointIdeal(
      wxy = (v.wxy * x * x + v.wxy * y * y - 2.0 * v.wyz * x * z - v.wxy * z * z + 2.0 * v.wxz * y * z),
      wxz = (v.wxz * x * x + v.wxz * z * z - v.wxz * y * y + 2.0 * v.wxy * y * z + 2.0 * v.wyz * x * y),
      wyz = (v.wyz * y * y + v.wyz * z * z - 2.0 * v.wxy * x * z - v.wyz * x * x + 2.0 * v.wxz * x * y),
    )

  infix def reverseSandwich(v: PointNormalized): Point =
    Point(
      wxy = (2.0 * w * z + v.wxy * x * x + v.wxy * y * y - 2.0 * v.wyz * x * z - v.wxy * z * z + 2.0 * v.wxz * y * z),
      wxz = (-2.0 * w * y + v.wxz * x * x + v.wxz * z * z - v.wxz * y * y + 2.0 * v.wxy * y * z + 2.0 * v.wyz * x * y),
      wyz = (2.0 * w * x + v.wyz * y * y + v.wyz * z * z - 2.0 * v.wxy * x * z - v.wyz * x * x + 2.0 * v.wxz * x * y),
      xyz = (x * x + y * y + z * z),
    )

  infix def reverseSandwich(v: PlaneIdeal): Plane =
    Plane(
      w = 2.0 * w * (v.x * x + v.y * y + v.z * z),
      x = (v.x * x * x - v.x * y * y - v.x * z * z + 2.0 * v.y * x * y + 2.0 * v.z * x * z),
      y = (v.y * y * y - v.y * x * x - v.y * z * z + 2.0 * v.x * x * y + 2.0 * v.z * y * z),
      z = (v.z * z * z - v.z * x * x - v.z * y * y + 2.0 * v.x * x * z + 2.0 * v.y * y * z),
    )

  infix def reverseSandwich(v: BivectorBulk): Bivector =
    Bivector(
      wx = 2.0 * w * (v.xy * y + v.xz * z),
      wy = w * (-2.0 * v.xy * x + 2.0 * v.yz * z),
      wz = -2.0 * w * (v.xz * x + v.yz * y),
      xy = (v.xy * z * z - 2.0 * v.xz * y * z - v.xy * x * x - v.xy * y * y + 2.0 * v.yz * x * z),
      xz = (v.xz * y * y - 2.0 * v.xy * y * z - 2.0 * v.yz * x * y - v.xz * x * x - v.xz * z * z),
      yz = (v.yz * x * x - 2.0 * v.xz * x * y - v.yz * y * y - v.yz * z * z + 2.0 * v.xy * x * z),
    )

  infix def reverseSandwich(v: BivectorWeight): BivectorWeight =
    BivectorWeight(
      wx = (v.wx * y * y + v.wx * z * z - 2.0 * v.wy * x * y - 2.0 * v.wz * x * z - v.wx * x * x),
      wy = (v.wy * x * x + v.wy * z * z - 2.0 * v.wx * x * y - 2.0 * v.wz * y * z - v.wy * y * y),
      wz = (v.wz * x * x + v.wz * y * y - 2.0 * v.wx * x * z - 2.0 * v.wy * y * z - v.wz * z * z),
    )

  infix def reverseSandwich(v: PseudoScalar): PseudoScalar =
    PseudoScalar(
      i = v.i * (-x * x - y * y - z * z),
    )

  infix def reverseSandwich(v: PointCenter.type): Point =
    Point(
      wxy = 2.0 * w * z,
      wxz = -2.0 * w * y,
      wyz = 2.0 * w * x,
      xyz = (x * x + y * y + z * z),
    )

  infix def cross(v: Multivector): Multivector =
    Multivector(
      s = 0.0,
      w = (-v.wx * x - v.wy * y - v.wz * z),
      x = (-v.xy * y - v.xz * z),
      y = (v.xy * x - v.yz * z),
      z = (v.xz * x + v.yz * y),
      wx = (v.x * w - v.w * x),
      wy = (v.y * w - v.w * y),
      wz = (v.z * w - v.w * z),
      xy = (v.y * x - v.x * y),
      xz = (v.z * x - v.x * z),
      yz = (v.z * y - v.y * z),
      wxy = -v.i * z,
      wxz = v.i * y,
      wyz = -v.i * x,
      xyz = 0.0,
      i = (v.wxz * y + v.xyz * w - v.wxy * z - v.wyz * x),
    )

  infix def cross(v: Motor): Multivector =
    Multivector(
      s = 0.0,
      w = (-v.wx * x - v.wy * y - v.wz * z),
      x = (-v.xy * y - v.xz * z),
      y = (v.xy * x - v.yz * z),
      z = (v.xz * x + v.yz * y),
      wx = 0.0,
      wy = 0.0,
      wz = 0.0,
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
      wxy = -v.i * z,
      wxz = v.i * y,
      wyz = -v.i * x,
      xyz = 0.0,
      i = 0.0,
    )

  infix def cross(v: Plane): Bivector =
    Bivector(
      wx = (v.x * w - v.w * x),
      wy = (v.y * w - v.w * y),
      wz = (v.z * w - v.w * z),
      xy = (v.y * x - v.x * y),
      xz = (v.z * x - v.x * z),
      yz = (v.z * y - v.y * z),
    )

  infix def cross(v: Bivector): Plane =
    Plane(
      w = (-v.wx * x - v.wy * y - v.wz * z),
      x = (-v.xy * y - v.xz * z),
      y = (v.xy * x - v.yz * z),
      z = (v.xz * x + v.yz * y),
    )

  infix def cross(v: Point): PseudoScalar =
    PseudoScalar(
      i = (v.wxz * y + v.xyz * w - v.wxy * z - v.wyz * x),
    )

  infix def cross(v: Quaternion): PlaneIdeal =
    PlaneIdeal(
      x = (-v.xy * y - v.xz * z),
      y = (v.xy * x - v.yz * z),
      z = (v.xz * x + v.yz * y),
    )

  infix def cross(v: QuaternionDual): Multivector =
    Multivector(
      s = 0.0,
      w = (-v.wx * x - v.wy * y - v.wz * z),
      x = 0.0,
      y = 0.0,
      z = 0.0,
      wx = 0.0,
      wy = 0.0,
      wz = 0.0,
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
      wxy = -v.i * z,
      wxz = v.i * y,
      wyz = -v.i * x,
      xyz = 0.0,
      i = 0.0,
    )

  infix def cross(v: PointIdeal): PseudoScalar =
    PseudoScalar(
      i = (v.wxz * y - v.wxy * z - v.wyz * x),
    )

  infix def cross(v: PointNormalized): PseudoScalar =
    PseudoScalar(
      i = (w + v.wxz * y - v.wxy * z - v.wyz * x),
    )

  infix def cross(v: PlaneIdeal): Bivector =
    Bivector(
      wx = v.x * w,
      wy = v.y * w,
      wz = v.z * w,
      xy = (v.y * x - v.x * y),
      xz = (v.z * x - v.x * z),
      yz = (v.z * y - v.y * z),
    )

  infix def cross(v: BivectorBulk): PlaneIdeal =
    PlaneIdeal(
      x = (-v.xy * y - v.xz * z),
      y = (v.xy * x - v.yz * z),
      z = (v.xz * x + v.yz * y),
    )

  infix def cross(v: BivectorWeight): Plane =
    Plane(
      w = (-v.wx * x - v.wy * y - v.wz * z),
      x = 0.0,
      y = 0.0,
      z = 0.0,
    )

  infix def cross(v: PseudoScalar): PointIdeal =
    PointIdeal(
      wxy = -v.i * z,
      wxz = v.i * y,
      wyz = -v.i * x,
    )

  infix def cross(v: PointCenter.type): PseudoScalar =
    PseudoScalar(
      i = w,
    )

  infix def antiGeometric(v: Multivector): Multivector =
    Multivector(
      s = (v.wxy * z + v.wyz * x - v.wxz * y - v.xyz * w),
      w = v.i * w,
      x = (v.i * x + v.wy * z + v.yz * w - v.wz * y),
      y = (v.i * y + v.wz * x - v.wx * z - v.xz * w),
      z = (v.i * z + v.wx * y + v.xy * w - v.wy * x),
      wx = -v.wyz * w,
      wy = v.wxz * w,
      wz = -v.wxy * w,
      xy = (v.w * z + v.wxz * x + v.wyz * y - v.z * w),
      xz = (v.wyz * z + v.y * w - v.w * y - v.wxy * x),
      yz = (v.w * x - v.wxy * y - v.wxz * z - v.x * w),
      wxy = v.wz * w,
      wxz = -v.wy * w,
      wyz = v.wx * w,
      xyz = (v.s * w + v.wx * x + v.wy * y + v.wz * z),
      i = -v.w * w,
    )

  infix def antiGeometric(v: Motor): Multivector =
    Multivector(
      s = 0.0,
      w = v.i * w,
      x = (v.i * x + v.wy * z + v.yz * w - v.wz * y),
      y = (v.i * y + v.wz * x - v.wx * z - v.xz * w),
      z = (v.i * z + v.wx * y + v.xy * w - v.wy * x),
      wx = 0.0,
      wy = 0.0,
      wz = 0.0,
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
      wxy = v.wz * w,
      wxz = -v.wy * w,
      wyz = v.wx * w,
      xyz = (v.s * w + v.wx * x + v.wy * y + v.wz * z),
      i = 0.0,
    )

  infix def antiGeometric(v: Plane): Motor =
    Motor(
      s = 0.0,
      wx = 0.0,
      wy = 0.0,
      wz = 0.0,
      xy = (v.w * z - v.z * w),
      xz = (v.y * w - v.w * y),
      yz = (v.w * x - v.x * w),
      i = -v.w * w,
    )

  infix def antiGeometric(v: Bivector): Multivector =
    Multivector(
      s = 0.0,
      w = 0.0,
      x = (v.wy * z + v.yz * w - v.wz * y),
      y = (v.wz * x - v.wx * z - v.xz * w),
      z = (v.wx * y + v.xy * w - v.wy * x),
      wx = 0.0,
      wy = 0.0,
      wz = 0.0,
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
      wxy = v.wz * w,
      wxz = -v.wy * w,
      wyz = v.wx * w,
      xyz = (v.wx * x + v.wy * y + v.wz * z),
      i = 0.0,
    )

  infix def antiGeometric(v: Point): Motor =
    Motor(
      s = (v.wxy * z + v.wyz * x - v.wxz * y - v.xyz * w),
      wx = -v.wyz * w,
      wy = v.wxz * w,
      wz = -v.wxy * w,
      xy = (v.wxz * x + v.wyz * y),
      xz = (v.wyz * z - v.wxy * x),
      yz = (-v.wxy * y - v.wxz * z),
      i = 0.0,
    )

  infix def antiGeometric(v: Quaternion): Multivector =
    Multivector(
      s = 0.0,
      w = 0.0,
      x = v.yz * w,
      y = -v.xz * w,
      z = v.xy * w,
      wx = 0.0,
      wy = 0.0,
      wz = 0.0,
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
      wxy = 0.0,
      wxz = 0.0,
      wyz = 0.0,
      xyz = v.s * w,
      i = 0.0,
    )

  infix def antiGeometric(v: QuaternionDual): Multivector =
    Multivector(
      s = 0.0,
      w = v.i * w,
      x = (v.i * x + v.wy * z - v.wz * y),
      y = (v.i * y + v.wz * x - v.wx * z),
      z = (v.i * z + v.wx * y - v.wy * x),
      wx = 0.0,
      wy = 0.0,
      wz = 0.0,
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
      wxy = v.wz * w,
      wxz = -v.wy * w,
      wyz = v.wx * w,
      xyz = (v.wx * x + v.wy * y + v.wz * z),
      i = 0.0,
    )

  infix def antiGeometric(v: PointIdeal): Motor =
    Motor(
      s = (v.wxy * z + v.wyz * x - v.wxz * y),
      wx = -v.wyz * w,
      wy = v.wxz * w,
      wz = -v.wxy * w,
      xy = (v.wxz * x + v.wyz * y),
      xz = (v.wyz * z - v.wxy * x),
      yz = (-v.wxy * y - v.wxz * z),
      i = 0.0,
    )

  infix def antiGeometric(v: PointNormalized): Motor =
    Motor(
      s = (-w + v.wxy * z + v.wyz * x - v.wxz * y),
      wx = -v.wyz * w,
      wy = v.wxz * w,
      wz = -v.wxy * w,
      xy = (v.wxz * x + v.wyz * y),
      xz = (v.wyz * z - v.wxy * x),
      yz = (-v.wxy * y - v.wxz * z),
      i = 0.0,
    )

  infix def antiGeometric(v: PlaneIdeal): BivectorBulk =
    BivectorBulk(
      xy = -v.z * w,
      xz = v.y * w,
      yz = -v.x * w,
    )

  infix def antiGeometric(v: BivectorBulk): PlaneIdeal =
    PlaneIdeal(
      x = v.yz * w,
      y = -v.xz * w,
      z = v.xy * w,
    )

  infix def antiGeometric(v: BivectorWeight): Multivector =
    Multivector(
      s = 0.0,
      w = 0.0,
      x = (v.wy * z - v.wz * y),
      y = (v.wz * x - v.wx * z),
      z = (v.wx * y - v.wy * x),
      wx = 0.0,
      wy = 0.0,
      wz = 0.0,
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
      wxy = v.wz * w,
      wxz = -v.wy * w,
      wyz = v.wx * w,
      xyz = (v.wx * x + v.wy * y + v.wz * z),
      i = 0.0,
    )

  infix def antiGeometric(v: PseudoScalar): Plane =
    Plane(
      w = v.i * w,
      x = v.i * x,
      y = v.i * y,
      z = v.i * z,
    )

  infix def antiGeometric(v: PointCenter.type): Double =
    -w

  infix def antiDot(v: Multivector): Multivector =
    Multivector(
      s = 0.0,
      w = v.i * w,
      x = v.i * x,
      y = v.i * y,
      z = v.i * z,
      wx = -v.wyz * w,
      wy = v.wxz * w,
      wz = -v.wxy * w,
      xy = (v.wxz * x + v.wyz * y),
      xz = (v.wyz * z - v.wxy * x),
      yz = (-v.wxy * y - v.wxz * z),
      wxy = v.wz * w,
      wxz = -v.wy * w,
      wyz = v.wx * w,
      xyz = (v.s * w + v.wx * x + v.wy * y + v.wz * z),
      i = -v.w * w,
    )

  infix def antiDot(v: Motor): Multivector =
    Multivector(
      s = 0.0,
      w = v.i * w,
      x = v.i * x,
      y = v.i * y,
      z = v.i * z,
      wx = 0.0,
      wy = 0.0,
      wz = 0.0,
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
      wxy = v.wz * w,
      wxz = -v.wy * w,
      wyz = v.wx * w,
      xyz = (v.s * w + v.wx * x + v.wy * y + v.wz * z),
      i = 0.0,
    )

  infix def antiDot(v: Plane): PseudoScalar =
    PseudoScalar(
      i = -v.w * w,
    )

  infix def antiDot(v: Bivector): Point =
    Point(
      wxy = v.wz * w,
      wxz = -v.wy * w,
      wyz = v.wx * w,
      xyz = (v.wx * x + v.wy * y + v.wz * z),
    )

  infix def antiDot(v: Point): Bivector =
    Bivector(
      wx = -v.wyz * w,
      wy = v.wxz * w,
      wz = -v.wxy * w,
      xy = (v.wxz * x + v.wyz * y),
      xz = (v.wyz * z - v.wxy * x),
      yz = (-v.wxy * y - v.wxz * z),
    )

  infix def antiDot(v: Quaternion): Point =
    Point(
      wxy = 0.0,
      wxz = 0.0,
      wyz = 0.0,
      xyz = v.s * w,
    )

  infix def antiDot(v: QuaternionDual): Multivector =
    Multivector(
      s = 0.0,
      w = v.i * w,
      x = v.i * x,
      y = v.i * y,
      z = v.i * z,
      wx = 0.0,
      wy = 0.0,
      wz = 0.0,
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
      wxy = v.wz * w,
      wxz = -v.wy * w,
      wyz = v.wx * w,
      xyz = (v.wx * x + v.wy * y + v.wz * z),
      i = 0.0,
    )

  infix def antiDot(v: PointIdeal): Bivector =
    Bivector(
      wx = -v.wyz * w,
      wy = v.wxz * w,
      wz = -v.wxy * w,
      xy = (v.wxz * x + v.wyz * y),
      xz = (v.wyz * z - v.wxy * x),
      yz = (-v.wxy * y - v.wxz * z),
    )

  infix def antiDot(v: PointNormalized): Bivector =
    Bivector(
      wx = -v.wyz * w,
      wy = v.wxz * w,
      wz = -v.wxy * w,
      xy = (v.wxz * x + v.wyz * y),
      xz = (v.wyz * z - v.wxy * x),
      yz = (-v.wxy * y - v.wxz * z),
    )

  infix def antiDot(v: BivectorWeight): Point =
    Point(
      wxy = v.wz * w,
      wxz = -v.wy * w,
      wyz = v.wx * w,
      xyz = (v.wx * x + v.wy * y + v.wz * z),
    )

  infix def antiDot(v: PseudoScalar): Plane =
    Plane(
      w = v.i * w,
      x = v.i * x,
      y = v.i * y,
      z = v.i * z,
    )

  infix def antiWedge(v: Multivector): Multivector =
    Multivector(
      s = (v.wxy * z + v.wyz * x - v.wxz * y - v.xyz * w),
      w = v.i * w,
      x = v.i * x,
      y = v.i * y,
      z = v.i * z,
      wx = 0.0,
      wy = 0.0,
      wz = 0.0,
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
      wxy = 0.0,
      wxz = 0.0,
      wyz = 0.0,
      xyz = 0.0,
      i = 0.0,
    )

  inline infix def v(v: Multivector): Multivector = antiWedge(v)

  infix def antiWedge(v: Motor): Plane =
    Plane(
      w = v.i * w,
      x = v.i * x,
      y = v.i * y,
      z = v.i * z,
    )

  inline infix def v(v: Motor): Plane = antiWedge(v)

  infix def antiWedge(v: Point): Double =
    (v.wxy * z + v.wyz * x - v.wxz * y - v.xyz * w)

  inline infix def v(v: Point): Double = antiWedge(v)

  infix def antiWedge(v: QuaternionDual): Plane =
    Plane(
      w = v.i * w,
      x = v.i * x,
      y = v.i * y,
      z = v.i * z,
    )

  inline infix def v(v: QuaternionDual): Plane = antiWedge(v)

  infix def antiWedge(v: PointIdeal): Double =
    (v.wxy * z + v.wyz * x - v.wxz * y)

  inline infix def v(v: PointIdeal): Double = antiWedge(v)

  infix def antiWedge(v: PointNormalized): Double =
    (-w + v.wxy * z + v.wyz * x - v.wxz * y)

  inline infix def v(v: PointNormalized): Double = antiWedge(v)

  infix def antiWedge(v: PseudoScalar): Plane =
    Plane(
      w = v.i * w,
      x = v.i * x,
      y = v.i * y,
      z = v.i * z,
    )

  inline infix def v(v: PseudoScalar): Plane = antiWedge(v)

  infix def antiWedge(v: PointCenter.type): Double =
    -w

  inline infix def v(v: PointCenter.type): Double = antiWedge(v)