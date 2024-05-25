package com.github.kright.pga3d

/** this code is generated, see com.github.kright.pga3d.codegen.MultivectorSubClass */
case class PlaneIdeal(
                       x: Double = 0.0,
                       y: Double = 0.0,
                       z: Double = 0.0,
                     ):

  def dual: PointIdeal =
    PointIdeal(
      wxy = -z,
      wxz = y,
      wyz = -x,
    )

  def bulk: PlaneIdeal =
    this

  def reverse: PlaneIdeal =
    this

  def antiReverse: PlaneIdeal =
    PlaneIdeal(
      x = -x,
      y = -y,
      z = -z,
    )

  def unary_ : PlaneIdeal =
    PlaneIdeal(
      x = -x,
      y = -y,
      z = -z,
    )

  def bulkNormSquare: Double =
    (x * x + y * y + z * z)

  def normSquare: Double =
    (x * x + y * y + z * z)

  def bulkNorm: Double =
    Math.sqrt(bulkNormSquare)

  def normalizedByBulk =
    this / bulkNorm

  def norm: Double =
    Math.sqrt(normSquare)

  def normalizedByNorm =
    this / norm

  def *(v: Double): PlaneIdeal =
    PlaneIdeal(
      x = v * x,
      y = v * y,
      z = v * z,
    )

  inline def /(v: Double): PlaneIdeal =
    this * (1.0 / v)

  def +(v: PlaneIdeal): PlaneIdeal =
    PlaneIdeal(
      x = (v.x + x),
      y = (v.y + y),
      z = (v.z + z),
    )

  def -(v: PlaneIdeal): PlaneIdeal =
    PlaneIdeal(
      x = (x - v.x),
      y = (y - v.y),
      z = (z - v.z),
    )

  def madd(v: PlaneIdeal, mult: Double): PlaneIdeal =
    PlaneIdeal(
      x = (x + mult * v.x),
      y = (y + mult * v.y),
      z = (z + mult * v.z),
    )

  def multiplyElementwise(v: PlaneIdeal): PlaneIdeal =
    PlaneIdeal(
      x = v.x * x,
      y = v.y * y,
      z = v.z * z,
    )

  def toMultivector: Multivector =
    Multivector(
      s = 0.0,
      w = 0.0,
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

  def toPlane: Plane =
    Plane(
      w = 0.0,
      x = x,
      y = y,
      z = z,
    )

  infix def geometric(v: Multivector): Multivector =
    Multivector(
      s = (v.x * x + v.y * y + v.z * z),
      w = (-v.wx * x - v.wy * y - v.wz * z),
      x = (v.s * x - v.xy * y - v.xz * z),
      y = (v.s * y + v.xy * x - v.yz * z),
      z = (v.s * z + v.xz * x + v.yz * y),
      wx = (v.wxy * y + v.wxz * z - v.w * x),
      wy = (v.wyz * z - v.w * y - v.wxy * x),
      wz = (-v.w * z - v.wxz * x - v.wyz * y),
      xy = (v.xyz * z + v.y * x - v.x * y),
      xz = (v.z * x - v.x * z - v.xyz * y),
      yz = (v.xyz * x + v.z * y - v.y * z),
      wxy = (v.wx * y - v.i * z - v.wy * x),
      wxz = (v.i * y + v.wx * z - v.wz * x),
      wyz = (v.wy * z - v.i * x - v.wz * y),
      xyz = (v.xy * z + v.yz * x - v.xz * y),
      i = (v.wxz * y - v.wxy * z - v.wyz * x),
    )

  infix def geometric(v: Motor): Multivector =
    Multivector(
      s = 0.0,
      w = (-v.wx * x - v.wy * y - v.wz * z),
      x = (v.s * x - v.xy * y - v.xz * z),
      y = (v.s * y + v.xy * x - v.yz * z),
      z = (v.s * z + v.xz * x + v.yz * y),
      wx = 0.0,
      wy = 0.0,
      wz = 0.0,
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
      wxy = (v.wx * y - v.i * z - v.wy * x),
      wxz = (v.i * y + v.wx * z - v.wz * x),
      wyz = (v.wy * z - v.i * x - v.wz * y),
      xyz = (v.xy * z + v.yz * x - v.xz * y),
      i = 0.0,
    )

  infix def geometric(v: Plane): Motor =
    Motor(
      s = (v.x * x + v.y * y + v.z * z),
      wx = -v.w * x,
      wy = -v.w * y,
      wz = -v.w * z,
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
      wxy = (v.wx * y - v.wy * x),
      wxz = (v.wx * z - v.wz * x),
      wyz = (v.wy * z - v.wz * y),
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
      i = (v.wxz * y - v.wxy * z - v.wyz * x),
    )

  infix def geometric(v: Quaternion): Multivector =
    Multivector(
      s = 0.0,
      w = 0.0,
      x = (v.s * x - v.xy * y - v.xz * z),
      y = (v.s * y + v.xy * x - v.yz * z),
      z = (v.s * z + v.xz * x + v.yz * y),
      wx = 0.0,
      wy = 0.0,
      wz = 0.0,
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
      wxy = 0.0,
      wxz = 0.0,
      wyz = 0.0,
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
      i = (v.wxz * y - v.wxy * z - v.wyz * x),
    )

  infix def geometric(v: PlaneIdeal): Quaternion =
    Quaternion(
      s = (v.x * x + v.y * y + v.z * z),
      xy = (v.y * x - v.x * y),
      xz = (v.z * x - v.x * z),
      yz = (v.z * y - v.y * z),
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
      wxy = 0.0,
      wxz = 0.0,
      wyz = 0.0,
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

  infix def geometric(v: PointCenter.type): BivectorBulk =
    BivectorBulk(
      xy = z,
      xz = -y,
      yz = x,
    )

  infix def dot(v: Multivector): Multivector =
    Multivector(
      s = (v.x * x + v.y * y + v.z * z),
      w = (-v.wx * x - v.wy * y - v.wz * z),
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
      w = (-v.wx * x - v.wy * y - v.wz * z),
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

  infix def dot(v: Quaternion): PlaneIdeal =
    PlaneIdeal(
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
      w = 0.0,
      x = v.s * x,
      y = v.s * y,
      z = v.s * z,
      wx = -v.w * x,
      wy = -v.w * y,
      wz = -v.w * z,
      xy = (v.y * x - v.x * y),
      xz = (v.z * x - v.x * z),
      yz = (v.z * y - v.y * z),
      wxy = (v.wx * y - v.wy * x),
      wxz = (v.wx * z - v.wz * x),
      wyz = (v.wy * z - v.wz * y),
      xyz = (v.xy * z + v.yz * x - v.xz * y),
      i = (v.wxz * y - v.wxy * z - v.wyz * x),
    )

  inline infix def ^(v: Multivector): Multivector = wedge(v)

  infix def wedge(v: Motor): Multivector =
    Multivector(
      s = 0.0,
      w = 0.0,
      x = v.s * x,
      y = v.s * y,
      z = v.s * z,
      wx = 0.0,
      wy = 0.0,
      wz = 0.0,
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
      wxy = (v.wx * y - v.wy * x),
      wxz = (v.wx * z - v.wz * x),
      wyz = (v.wy * z - v.wz * y),
      xyz = (v.xy * z + v.yz * x - v.xz * y),
      i = 0.0,
    )

  inline infix def ^(v: Motor): Multivector = wedge(v)

  infix def wedge(v: Plane): Bivector =
    Bivector(
      wx = -v.w * x,
      wy = -v.w * y,
      wz = -v.w * z,
      xy = (v.y * x - v.x * y),
      xz = (v.z * x - v.x * z),
      yz = (v.z * y - v.y * z),
    )

  inline infix def ^(v: Plane): Bivector = wedge(v)

  infix def wedge(v: Bivector): Point =
    Point(
      wxy = (v.wx * y - v.wy * x),
      wxz = (v.wx * z - v.wz * x),
      wyz = (v.wy * z - v.wz * y),
      xyz = (v.xy * z + v.yz * x - v.xz * y),
    )

  inline infix def ^(v: Bivector): Point = wedge(v)

  infix def wedge(v: Point): PseudoScalar =
    PseudoScalar(
      i = (v.wxz * y - v.wxy * z - v.wyz * x),
    )

  inline infix def ^(v: Point): PseudoScalar = wedge(v)

  infix def wedge(v: Quaternion): Multivector =
    Multivector(
      s = 0.0,
      w = 0.0,
      x = v.s * x,
      y = v.s * y,
      z = v.s * z,
      wx = 0.0,
      wy = 0.0,
      wz = 0.0,
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
      wxy = 0.0,
      wxz = 0.0,
      wyz = 0.0,
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
      i = (v.wxz * y - v.wxy * z - v.wyz * x),
    )

  inline infix def ^(v: PointNormalized): PseudoScalar = wedge(v)

  infix def wedge(v: PlaneIdeal): BivectorBulk =
    BivectorBulk(
      xy = (v.y * x - v.x * y),
      xz = (v.z * x - v.x * z),
      yz = (v.z * y - v.y * z),
    )

  inline infix def ^(v: PlaneIdeal): BivectorBulk = wedge(v)

  infix def wedge(v: BivectorBulk): Point =
    Point(
      wxy = 0.0,
      wxz = 0.0,
      wyz = 0.0,
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

  infix def antiGeometric(v: Multivector): Multivector =
    Multivector(
      s = (v.wxy * z + v.wyz * x - v.wxz * y),
      w = 0.0,
      x = (v.i * x + v.wy * z - v.wz * y),
      y = (v.i * y + v.wz * x - v.wx * z),
      z = (v.i * z + v.wx * y - v.wy * x),
      wx = 0.0,
      wy = 0.0,
      wz = 0.0,
      xy = (v.w * z + v.wxz * x + v.wyz * y),
      xz = (v.wyz * z - v.w * y - v.wxy * x),
      yz = (v.w * x - v.wxy * y - v.wxz * z),
      wxy = 0.0,
      wxz = 0.0,
      wyz = 0.0,
      xyz = (v.wx * x + v.wy * y + v.wz * z),
      i = 0.0,
    )

  infix def antiGeometric(v: Motor): Multivector =
    Multivector(
      s = 0.0,
      w = 0.0,
      x = (v.i * x + v.wy * z - v.wz * y),
      y = (v.i * y + v.wz * x - v.wx * z),
      z = (v.i * z + v.wx * y - v.wy * x),
      wx = 0.0,
      wy = 0.0,
      wz = 0.0,
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
      wxy = 0.0,
      wxz = 0.0,
      wyz = 0.0,
      xyz = (v.wx * x + v.wy * y + v.wz * z),
      i = 0.0,
    )

  infix def antiGeometric(v: Plane): BivectorBulk =
    BivectorBulk(
      xy = v.w * z,
      xz = -v.w * y,
      yz = v.w * x,
    )

  infix def antiGeometric(v: Bivector): Multivector =
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
      wxy = 0.0,
      wxz = 0.0,
      wyz = 0.0,
      xyz = (v.wx * x + v.wy * y + v.wz * z),
      i = 0.0,
    )

  infix def antiGeometric(v: Point): Quaternion =
    Quaternion(
      s = (v.wxy * z + v.wyz * x - v.wxz * y),
      xy = (v.wxz * x + v.wyz * y),
      xz = (v.wyz * z - v.wxy * x),
      yz = (-v.wxy * y - v.wxz * z),
    )

  infix def antiGeometric(v: QuaternionDual): Multivector =
    Multivector(
      s = 0.0,
      w = 0.0,
      x = (v.i * x + v.wy * z - v.wz * y),
      y = (v.i * y + v.wz * x - v.wx * z),
      z = (v.i * z + v.wx * y - v.wy * x),
      wx = 0.0,
      wy = 0.0,
      wz = 0.0,
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
      wxy = 0.0,
      wxz = 0.0,
      wyz = 0.0,
      xyz = (v.wx * x + v.wy * y + v.wz * z),
      i = 0.0,
    )

  infix def antiGeometric(v: PointIdeal): Quaternion =
    Quaternion(
      s = (v.wxy * z + v.wyz * x - v.wxz * y),
      xy = (v.wxz * x + v.wyz * y),
      xz = (v.wyz * z - v.wxy * x),
      yz = (-v.wxy * y - v.wxz * z),
    )

  infix def antiGeometric(v: PointNormalized): Quaternion =
    Quaternion(
      s = (v.wxy * z + v.wyz * x - v.wxz * y),
      xy = (v.wxz * x + v.wyz * y),
      xz = (v.wyz * z - v.wxy * x),
      yz = (-v.wxy * y - v.wxz * z),
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
      wxy = 0.0,
      wxz = 0.0,
      wyz = 0.0,
      xyz = (v.wx * x + v.wy * y + v.wz * z),
      i = 0.0,
    )

  infix def antiGeometric(v: PseudoScalar): PlaneIdeal =
    PlaneIdeal(
      x = v.i * x,
      y = v.i * y,
      z = v.i * z,
    )

  infix def antiDot(v: Multivector): Multivector =
    Multivector(
      s = 0.0,
      w = 0.0,
      x = v.i * x,
      y = v.i * y,
      z = v.i * z,
      wx = 0.0,
      wy = 0.0,
      wz = 0.0,
      xy = (v.wxz * x + v.wyz * y),
      xz = (v.wyz * z - v.wxy * x),
      yz = (-v.wxy * y - v.wxz * z),
      wxy = 0.0,
      wxz = 0.0,
      wyz = 0.0,
      xyz = (v.wx * x + v.wy * y + v.wz * z),
      i = 0.0,
    )

  infix def antiDot(v: Motor): Multivector =
    Multivector(
      s = 0.0,
      w = 0.0,
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
      xyz = (v.wx * x + v.wy * y + v.wz * z),
      i = 0.0,
    )

  infix def antiDot(v: Bivector): Point =
    Point(
      wxy = 0.0,
      wxz = 0.0,
      wyz = 0.0,
      xyz = (v.wx * x + v.wy * y + v.wz * z),
    )

  infix def antiDot(v: Point): BivectorBulk =
    BivectorBulk(
      xy = (v.wxz * x + v.wyz * y),
      xz = (v.wyz * z - v.wxy * x),
      yz = (-v.wxy * y - v.wxz * z),
    )

  infix def antiDot(v: QuaternionDual): Multivector =
    Multivector(
      s = 0.0,
      w = 0.0,
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
      xyz = (v.wx * x + v.wy * y + v.wz * z),
      i = 0.0,
    )

  infix def antiDot(v: PointIdeal): BivectorBulk =
    BivectorBulk(
      xy = (v.wxz * x + v.wyz * y),
      xz = (v.wyz * z - v.wxy * x),
      yz = (-v.wxy * y - v.wxz * z),
    )

  infix def antiDot(v: PointNormalized): BivectorBulk =
    BivectorBulk(
      xy = (v.wxz * x + v.wyz * y),
      xz = (v.wyz * z - v.wxy * x),
      yz = (-v.wxy * y - v.wxz * z),
    )

  infix def antiDot(v: BivectorWeight): Point =
    Point(
      wxy = 0.0,
      wxz = 0.0,
      wyz = 0.0,
      xyz = (v.wx * x + v.wy * y + v.wz * z),
    )

  infix def antiDot(v: PseudoScalar): PlaneIdeal =
    PlaneIdeal(
      x = v.i * x,
      y = v.i * y,
      z = v.i * z,
    )

  infix def antiWedge(v: Multivector): Multivector =
    Multivector(
      s = (v.wxy * z + v.wyz * x - v.wxz * y),
      w = 0.0,
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

  infix def antiWedge(v: Motor): PlaneIdeal =
    PlaneIdeal(
      x = v.i * x,
      y = v.i * y,
      z = v.i * z,
    )

  inline infix def v(v: Motor): PlaneIdeal = antiWedge(v)

  infix def antiWedge(v: Point): Double =
    (v.wxy * z + v.wyz * x - v.wxz * y)

  inline infix def v(v: Point): Double = antiWedge(v)

  infix def antiWedge(v: QuaternionDual): PlaneIdeal =
    PlaneIdeal(
      x = v.i * x,
      y = v.i * y,
      z = v.i * z,
    )

  inline infix def v(v: QuaternionDual): PlaneIdeal = antiWedge(v)

  infix def antiWedge(v: PointIdeal): Double =
    (v.wxy * z + v.wyz * x - v.wxz * y)

  inline infix def v(v: PointIdeal): Double = antiWedge(v)

  infix def antiWedge(v: PointNormalized): Double =
    (v.wxy * z + v.wyz * x - v.wxz * y)

  inline infix def v(v: PointNormalized): Double = antiWedge(v)

  infix def antiWedge(v: PseudoScalar): PlaneIdeal =
    PlaneIdeal(
      x = v.i * x,
      y = v.i * y,
      z = v.i * z,
    )

  inline infix def v(v: PseudoScalar): PlaneIdeal = antiWedge(v)

  infix def sandwich(v: Multivector): Multivector =
    val xMx = x * x
    val xMy = x * y
    val xMz = x * z
    val yMy = y * y
    val yMz = y * z
    val zMz = z * z
    Multivector(
      s = v.s * (xMx + yMy + zMz),
      w = v.w * (-xMx - yMy - zMz),
      x = (2.0 * (v.y * xMy + v.z * xMz) + v.x * (xMx - yMy - zMz)),
      y = (2.0 * (v.x * xMy + v.z * yMz) + v.y * (yMy - xMx - zMz)),
      z = (2.0 * (v.x * xMz + v.y * yMz) + v.z * (zMz - xMx - yMy)),
      wx = (2.0 * (-v.wy * xMy - v.wz * xMz) + v.wx * (yMy + zMz - xMx)),
      wy = (2.0 * (-v.wx * xMy - v.wz * yMz) + v.wy * (xMx + zMz - yMy)),
      wz = (2.0 * (-v.wx * xMz - v.wy * yMz) + v.wz * (xMx + yMy - zMz)),
      xy = (2.0 * (v.yz * xMz - v.xz * yMz) + v.xy * (zMz - xMx - yMy)),
      xz = (2.0 * (-v.xy * yMz - v.yz * xMy) + v.xz * (yMy - xMx - zMz)),
      yz = (2.0 * (v.xy * xMz - v.xz * xMy) + v.yz * (xMx - yMy - zMz)),
      wxy = (2.0 * (v.wxz * yMz - v.wyz * xMz) + v.wxy * (xMx + yMy - zMz)),
      wxz = (2.0 * (v.wxy * yMz + v.wyz * xMy) + v.wxz * (xMx + zMz - yMy)),
      wyz = (2.0 * (v.wxz * xMy - v.wxy * xMz) + v.wyz * (yMy + zMz - xMx)),
      xyz = v.xyz * (xMx + yMy + zMz),
      i = v.i * (-xMx - yMy - zMz),
    )

  infix def sandwich(v: Motor): Motor =
    val xMx = x * x
    val xMy = x * y
    val xMz = x * z
    val yMy = y * y
    val yMz = y * z
    val zMz = z * z
    Motor(
      s = v.s * (xMx + yMy + zMz),
      wx = (2.0 * (-v.wy * xMy - v.wz * xMz) + v.wx * (yMy + zMz - xMx)),
      wy = (2.0 * (-v.wx * xMy - v.wz * yMz) + v.wy * (xMx + zMz - yMy)),
      wz = (2.0 * (-v.wx * xMz - v.wy * yMz) + v.wz * (xMx + yMy - zMz)),
      xy = (2.0 * (v.yz * xMz - v.xz * yMz) + v.xy * (zMz - xMx - yMy)),
      xz = (2.0 * (-v.xy * yMz - v.yz * xMy) + v.xz * (yMy - xMx - zMz)),
      yz = (2.0 * (v.xy * xMz - v.xz * xMy) + v.yz * (xMx - yMy - zMz)),
      i = v.i * (-xMx - yMy - zMz),
    )

  infix def sandwich(v: Plane): Plane =
    val xMx = x * x
    val xMy = x * y
    val xMz = x * z
    val yMy = y * y
    val yMz = y * z
    val zMz = z * z
    Plane(
      w = v.w * (-xMx - yMy - zMz),
      x = (2.0 * (v.y * xMy + v.z * xMz) + v.x * (xMx - yMy - zMz)),
      y = (2.0 * (v.x * xMy + v.z * yMz) + v.y * (yMy - xMx - zMz)),
      z = (2.0 * (v.x * xMz + v.y * yMz) + v.z * (zMz - xMx - yMy)),
    )

  infix def sandwich(v: Bivector): Bivector =
    val xMx = x * x
    val xMy = x * y
    val xMz = x * z
    val yMy = y * y
    val yMz = y * z
    val zMz = z * z
    Bivector(
      wx = (2.0 * (-v.wy * xMy - v.wz * xMz) + v.wx * (yMy + zMz - xMx)),
      wy = (2.0 * (-v.wx * xMy - v.wz * yMz) + v.wy * (xMx + zMz - yMy)),
      wz = (2.0 * (-v.wx * xMz - v.wy * yMz) + v.wz * (xMx + yMy - zMz)),
      xy = (2.0 * (v.yz * xMz - v.xz * yMz) + v.xy * (zMz - xMx - yMy)),
      xz = (2.0 * (-v.xy * yMz - v.yz * xMy) + v.xz * (yMy - xMx - zMz)),
      yz = (2.0 * (v.xy * xMz - v.xz * xMy) + v.yz * (xMx - yMy - zMz)),
    )

  infix def sandwich(v: Point): Point =
    val xMx = x * x
    val xMy = x * y
    val xMz = x * z
    val yMy = y * y
    val yMz = y * z
    val zMz = z * z
    Point(
      wxy = (2.0 * (v.wxz * yMz - v.wyz * xMz) + v.wxy * (xMx + yMy - zMz)),
      wxz = (2.0 * (v.wxy * yMz + v.wyz * xMy) + v.wxz * (xMx + zMz - yMy)),
      wyz = (2.0 * (v.wxz * xMy - v.wxy * xMz) + v.wyz * (yMy + zMz - xMx)),
      xyz = v.xyz * (xMx + yMy + zMz),
    )

  infix def sandwich(v: Quaternion): Quaternion =
    val xMx = x * x
    val xMy = x * y
    val xMz = x * z
    val yMy = y * y
    val yMz = y * z
    val zMz = z * z
    Quaternion(
      s = v.s * (xMx + yMy + zMz),
      xy = (2.0 * (v.yz * xMz - v.xz * yMz) + v.xy * (zMz - xMx - yMy)),
      xz = (2.0 * (-v.xy * yMz - v.yz * xMy) + v.xz * (yMy - xMx - zMz)),
      yz = (2.0 * (v.xy * xMz - v.xz * xMy) + v.yz * (xMx - yMy - zMz)),
    )

  infix def sandwich(v: QuaternionDual): QuaternionDual =
    val xMx = x * x
    val xMy = x * y
    val xMz = x * z
    val yMy = y * y
    val yMz = y * z
    val zMz = z * z
    QuaternionDual(
      wx = (2.0 * (-v.wy * xMy - v.wz * xMz) + v.wx * (yMy + zMz - xMx)),
      wy = (2.0 * (-v.wx * xMy - v.wz * yMz) + v.wy * (xMx + zMz - yMy)),
      wz = (2.0 * (-v.wx * xMz - v.wy * yMz) + v.wz * (xMx + yMy - zMz)),
      i = v.i * (-xMx - yMy - zMz),
    )

  infix def sandwich(v: PointIdeal): PointIdeal =
    val xMx = x * x
    val xMy = x * y
    val xMz = x * z
    val yMy = y * y
    val yMz = y * z
    val zMz = z * z
    PointIdeal(
      wxy = (2.0 * (v.wxz * yMz - v.wyz * xMz) + v.wxy * (xMx + yMy - zMz)),
      wxz = (2.0 * (v.wxy * yMz + v.wyz * xMy) + v.wxz * (xMx + zMz - yMy)),
      wyz = (2.0 * (v.wxz * xMy - v.wxy * xMz) + v.wyz * (yMy + zMz - xMx)),
    )

  infix def sandwich(v: PointNormalized): Point =
    val xMx = x * x
    val xMy = x * y
    val xMz = x * z
    val yMy = y * y
    val yMz = y * z
    val zMz = z * z
    Point(
      wxy = (2.0 * (v.wxz * yMz - v.wyz * xMz) + v.wxy * (xMx + yMy - zMz)),
      wxz = (2.0 * (v.wxy * yMz + v.wyz * xMy) + v.wxz * (xMx + zMz - yMy)),
      wyz = (2.0 * (v.wxz * xMy - v.wxy * xMz) + v.wyz * (yMy + zMz - xMx)),
      xyz = (xMx + yMy + zMz),
    )

  infix def sandwich(v: PlaneIdeal): PlaneIdeal =
    val xMx = x * x
    val xMy = x * y
    val xMz = x * z
    val yMy = y * y
    val yMz = y * z
    val zMz = z * z
    PlaneIdeal(
      x = (2.0 * (v.y * xMy + v.z * xMz) + v.x * (xMx - yMy - zMz)),
      y = (2.0 * (v.x * xMy + v.z * yMz) + v.y * (yMy - xMx - zMz)),
      z = (2.0 * (v.x * xMz + v.y * yMz) + v.z * (zMz - xMx - yMy)),
    )

  infix def sandwich(v: BivectorBulk): BivectorBulk =
    val xMx = x * x
    val xMy = x * y
    val xMz = x * z
    val yMy = y * y
    val yMz = y * z
    val zMz = z * z
    BivectorBulk(
      xy = (2.0 * (v.yz * xMz - v.xz * yMz) + v.xy * (zMz - xMx - yMy)),
      xz = (2.0 * (-v.xy * yMz - v.yz * xMy) + v.xz * (yMy - xMx - zMz)),
      yz = (2.0 * (v.xy * xMz - v.xz * xMy) + v.yz * (xMx - yMy - zMz)),
    )

  infix def sandwich(v: BivectorWeight): BivectorWeight =
    val xMx = x * x
    val xMy = x * y
    val xMz = x * z
    val yMy = y * y
    val yMz = y * z
    val zMz = z * z
    BivectorWeight(
      wx = (2.0 * (-v.wy * xMy - v.wz * xMz) + v.wx * (yMy + zMz - xMx)),
      wy = (2.0 * (-v.wx * xMy - v.wz * yMz) + v.wy * (xMx + zMz - yMy)),
      wz = (2.0 * (-v.wx * xMz - v.wy * yMz) + v.wz * (xMx + yMy - zMz)),
    )

  infix def sandwich(v: PseudoScalar): PseudoScalar =
    PseudoScalar(
      i = v.i * (-x * x - y * y - z * z),
    )

  infix def sandwich(v: PointCenter.type): Point =
    Point(
      wxy = 0.0,
      wxz = 0.0,
      wyz = 0.0,
      xyz = (x * x + y * y + z * z),
    )

  infix def reverseSandwich(v: Multivector): Multivector =
    val xMx = x * x
    val xMy = x * y
    val xMz = x * z
    val yMy = y * y
    val yMz = y * z
    val zMz = z * z
    Multivector(
      s = v.s * (xMx + yMy + zMz),
      w = v.w * (-xMx - yMy - zMz),
      x = (2.0 * (v.y * xMy + v.z * xMz) + v.x * (xMx - yMy - zMz)),
      y = (2.0 * (v.x * xMy + v.z * yMz) + v.y * (yMy - xMx - zMz)),
      z = (2.0 * (v.x * xMz + v.y * yMz) + v.z * (zMz - xMx - yMy)),
      wx = (2.0 * (-v.wy * xMy - v.wz * xMz) + v.wx * (yMy + zMz - xMx)),
      wy = (2.0 * (-v.wx * xMy - v.wz * yMz) + v.wy * (xMx + zMz - yMy)),
      wz = (2.0 * (-v.wx * xMz - v.wy * yMz) + v.wz * (xMx + yMy - zMz)),
      xy = (2.0 * (v.yz * xMz - v.xz * yMz) + v.xy * (zMz - xMx - yMy)),
      xz = (2.0 * (-v.xy * yMz - v.yz * xMy) + v.xz * (yMy - xMx - zMz)),
      yz = (2.0 * (v.xy * xMz - v.xz * xMy) + v.yz * (xMx - yMy - zMz)),
      wxy = (2.0 * (v.wxz * yMz - v.wyz * xMz) + v.wxy * (xMx + yMy - zMz)),
      wxz = (2.0 * (v.wxy * yMz + v.wyz * xMy) + v.wxz * (xMx + zMz - yMy)),
      wyz = (2.0 * (v.wxz * xMy - v.wxy * xMz) + v.wyz * (yMy + zMz - xMx)),
      xyz = v.xyz * (xMx + yMy + zMz),
      i = v.i * (-xMx - yMy - zMz),
    )

  infix def reverseSandwich(v: Motor): Motor =
    val xMx = x * x
    val xMy = x * y
    val xMz = x * z
    val yMy = y * y
    val yMz = y * z
    val zMz = z * z
    Motor(
      s = v.s * (xMx + yMy + zMz),
      wx = (2.0 * (-v.wy * xMy - v.wz * xMz) + v.wx * (yMy + zMz - xMx)),
      wy = (2.0 * (-v.wx * xMy - v.wz * yMz) + v.wy * (xMx + zMz - yMy)),
      wz = (2.0 * (-v.wx * xMz - v.wy * yMz) + v.wz * (xMx + yMy - zMz)),
      xy = (2.0 * (v.yz * xMz - v.xz * yMz) + v.xy * (zMz - xMx - yMy)),
      xz = (2.0 * (-v.xy * yMz - v.yz * xMy) + v.xz * (yMy - xMx - zMz)),
      yz = (2.0 * (v.xy * xMz - v.xz * xMy) + v.yz * (xMx - yMy - zMz)),
      i = v.i * (-xMx - yMy - zMz),
    )

  infix def reverseSandwich(v: Plane): Plane =
    val xMx = x * x
    val xMy = x * y
    val xMz = x * z
    val yMy = y * y
    val yMz = y * z
    val zMz = z * z
    Plane(
      w = v.w * (-xMx - yMy - zMz),
      x = (2.0 * (v.y * xMy + v.z * xMz) + v.x * (xMx - yMy - zMz)),
      y = (2.0 * (v.x * xMy + v.z * yMz) + v.y * (yMy - xMx - zMz)),
      z = (2.0 * (v.x * xMz + v.y * yMz) + v.z * (zMz - xMx - yMy)),
    )

  infix def reverseSandwich(v: Bivector): Bivector =
    val xMx = x * x
    val xMy = x * y
    val xMz = x * z
    val yMy = y * y
    val yMz = y * z
    val zMz = z * z
    Bivector(
      wx = (2.0 * (-v.wy * xMy - v.wz * xMz) + v.wx * (yMy + zMz - xMx)),
      wy = (2.0 * (-v.wx * xMy - v.wz * yMz) + v.wy * (xMx + zMz - yMy)),
      wz = (2.0 * (-v.wx * xMz - v.wy * yMz) + v.wz * (xMx + yMy - zMz)),
      xy = (2.0 * (v.yz * xMz - v.xz * yMz) + v.xy * (zMz - xMx - yMy)),
      xz = (2.0 * (-v.xy * yMz - v.yz * xMy) + v.xz * (yMy - xMx - zMz)),
      yz = (2.0 * (v.xy * xMz - v.xz * xMy) + v.yz * (xMx - yMy - zMz)),
    )

  infix def reverseSandwich(v: Point): Point =
    val xMx = x * x
    val xMy = x * y
    val xMz = x * z
    val yMy = y * y
    val yMz = y * z
    val zMz = z * z
    Point(
      wxy = (2.0 * (v.wxz * yMz - v.wyz * xMz) + v.wxy * (xMx + yMy - zMz)),
      wxz = (2.0 * (v.wxy * yMz + v.wyz * xMy) + v.wxz * (xMx + zMz - yMy)),
      wyz = (2.0 * (v.wxz * xMy - v.wxy * xMz) + v.wyz * (yMy + zMz - xMx)),
      xyz = v.xyz * (xMx + yMy + zMz),
    )

  infix def reverseSandwich(v: Quaternion): Quaternion =
    val xMx = x * x
    val xMy = x * y
    val xMz = x * z
    val yMy = y * y
    val yMz = y * z
    val zMz = z * z
    Quaternion(
      s = v.s * (xMx + yMy + zMz),
      xy = (2.0 * (v.yz * xMz - v.xz * yMz) + v.xy * (zMz - xMx - yMy)),
      xz = (2.0 * (-v.xy * yMz - v.yz * xMy) + v.xz * (yMy - xMx - zMz)),
      yz = (2.0 * (v.xy * xMz - v.xz * xMy) + v.yz * (xMx - yMy - zMz)),
    )

  infix def reverseSandwich(v: QuaternionDual): QuaternionDual =
    val xMx = x * x
    val xMy = x * y
    val xMz = x * z
    val yMy = y * y
    val yMz = y * z
    val zMz = z * z
    QuaternionDual(
      wx = (2.0 * (-v.wy * xMy - v.wz * xMz) + v.wx * (yMy + zMz - xMx)),
      wy = (2.0 * (-v.wx * xMy - v.wz * yMz) + v.wy * (xMx + zMz - yMy)),
      wz = (2.0 * (-v.wx * xMz - v.wy * yMz) + v.wz * (xMx + yMy - zMz)),
      i = v.i * (-xMx - yMy - zMz),
    )

  infix def reverseSandwich(v: PointIdeal): PointIdeal =
    val xMx = x * x
    val xMy = x * y
    val xMz = x * z
    val yMy = y * y
    val yMz = y * z
    val zMz = z * z
    PointIdeal(
      wxy = (2.0 * (v.wxz * yMz - v.wyz * xMz) + v.wxy * (xMx + yMy - zMz)),
      wxz = (2.0 * (v.wxy * yMz + v.wyz * xMy) + v.wxz * (xMx + zMz - yMy)),
      wyz = (2.0 * (v.wxz * xMy - v.wxy * xMz) + v.wyz * (yMy + zMz - xMx)),
    )

  infix def reverseSandwich(v: PointNormalized): Point =
    val xMx = x * x
    val xMy = x * y
    val xMz = x * z
    val yMy = y * y
    val yMz = y * z
    val zMz = z * z
    Point(
      wxy = (2.0 * (v.wxz * yMz - v.wyz * xMz) + v.wxy * (xMx + yMy - zMz)),
      wxz = (2.0 * (v.wxy * yMz + v.wyz * xMy) + v.wxz * (xMx + zMz - yMy)),
      wyz = (2.0 * (v.wxz * xMy - v.wxy * xMz) + v.wyz * (yMy + zMz - xMx)),
      xyz = (xMx + yMy + zMz),
    )

  infix def reverseSandwich(v: PlaneIdeal): PlaneIdeal =
    val xMx = x * x
    val xMy = x * y
    val xMz = x * z
    val yMy = y * y
    val yMz = y * z
    val zMz = z * z
    PlaneIdeal(
      x = (2.0 * (v.y * xMy + v.z * xMz) + v.x * (xMx - yMy - zMz)),
      y = (2.0 * (v.x * xMy + v.z * yMz) + v.y * (yMy - xMx - zMz)),
      z = (2.0 * (v.x * xMz + v.y * yMz) + v.z * (zMz - xMx - yMy)),
    )

  infix def reverseSandwich(v: BivectorBulk): BivectorBulk =
    val xMx = x * x
    val xMy = x * y
    val xMz = x * z
    val yMy = y * y
    val yMz = y * z
    val zMz = z * z
    BivectorBulk(
      xy = (2.0 * (v.yz * xMz - v.xz * yMz) + v.xy * (zMz - xMx - yMy)),
      xz = (2.0 * (-v.xy * yMz - v.yz * xMy) + v.xz * (yMy - xMx - zMz)),
      yz = (2.0 * (v.xy * xMz - v.xz * xMy) + v.yz * (xMx - yMy - zMz)),
    )

  infix def reverseSandwich(v: BivectorWeight): BivectorWeight =
    val xMx = x * x
    val xMy = x * y
    val xMz = x * z
    val yMy = y * y
    val yMz = y * z
    val zMz = z * z
    BivectorWeight(
      wx = (2.0 * (-v.wy * xMy - v.wz * xMz) + v.wx * (yMy + zMz - xMx)),
      wy = (2.0 * (-v.wx * xMy - v.wz * yMz) + v.wy * (xMx + zMz - yMy)),
      wz = (2.0 * (-v.wx * xMz - v.wy * yMz) + v.wz * (xMx + yMy - zMz)),
    )

  infix def reverseSandwich(v: PseudoScalar): PseudoScalar =
    PseudoScalar(
      i = v.i * (-x * x - y * y - z * z),
    )

  infix def reverseSandwich(v: PointCenter.type): Point =
    Point(
      wxy = 0.0,
      wxz = 0.0,
      wyz = 0.0,
      xyz = (x * x + y * y + z * z),
    )

  infix def cross(v: Multivector): Multivector =
    Multivector(
      s = 0.0,
      w = (-v.wx * x - v.wy * y - v.wz * z),
      x = (-v.xy * y - v.xz * z),
      y = (v.xy * x - v.yz * z),
      z = (v.xz * x + v.yz * y),
      wx = -v.w * x,
      wy = -v.w * y,
      wz = -v.w * z,
      xy = (v.y * x - v.x * y),
      xz = (v.z * x - v.x * z),
      yz = (v.z * y - v.y * z),
      wxy = -v.i * z,
      wxz = v.i * y,
      wyz = -v.i * x,
      xyz = 0.0,
      i = (v.wxz * y - v.wxy * z - v.wyz * x),
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
      wx = -v.w * x,
      wy = -v.w * y,
      wz = -v.w * z,
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
      i = (v.wxz * y - v.wxy * z - v.wyz * x),
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
      i = (v.wxz * y - v.wxy * z - v.wyz * x),
    )

  infix def cross(v: PlaneIdeal): BivectorBulk =
    BivectorBulk(
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