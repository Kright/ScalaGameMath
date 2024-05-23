package com.github.kright.pga3d

/** this code is generated, see com.github.kright.pga3d.codegen.MultivectorSubClass */
case class PointIdeal(
                       wxy: Double = 0.0,
                       wxz: Double = 0.0,
                       wyz: Double = 0.0,
                     ):

  inline def dualX: Double = -wyz

  inline def dualY: Double = wxz

  inline def dualZ: Double = -wxy

  def dual: PlaneIdeal =
    PlaneIdeal(
      x = -wyz,
      y = wxz,
      z = -wxy,
    )

  def weight: PointIdeal =
    this

  def reverse: PointIdeal =
    PointIdeal(
      wxy = -wxy,
      wxz = -wxz,
      wyz = -wyz,
    )

  def antiReverse: PointIdeal =
    this

  def unary_ : PointIdeal =
    PointIdeal(
      wxy = -wxy,
      wxz = -wxz,
      wyz = -wyz,
    )

  def weightNormSquare: Double =
    (wxy * wxy + wxz * wxz + wyz * wyz)

  def normSquare: Double =
    (wxy * wxy + wxz * wxz + wyz * wyz)

  def weightNorm: Double =
    Math.sqrt(weightNormSquare)

  def normalizedByWeight =
    this / weightNorm

  def norm: Double =
    Math.sqrt(normSquare)

  def normalizedByNorm =
    this / norm

  def *(v: Double): PointIdeal =
    PointIdeal(
      wxy = v * wxy,
      wxz = v * wxz,
      wyz = v * wyz,
    )

  inline def /(v: Double): PointIdeal =
    this * (1.0 / v)

  def +(v: PointIdeal): PointIdeal =
    PointIdeal(
      wxy = (v.wxy + wxy),
      wxz = (v.wxz + wxz),
      wyz = (v.wyz + wyz),
    )

  def -(v: PointIdeal): PointIdeal =
    PointIdeal(
      wxy = (wxy - v.wxy),
      wxz = (wxz - v.wxz),
      wyz = (wyz - v.wyz),
    )

  def madd(v: PointIdeal, mult: Double): PointIdeal =
    PointIdeal(
      wxy = (wxy + mult * v.wxy),
      wxz = (wxz + mult * v.wxz),
      wyz = (wyz + mult * v.wyz),
    )

  def multiplyElementwise(v: PointIdeal): PointIdeal =
    PointIdeal(
      wxy = v.wxy * wxy,
      wxz = v.wxz * wxz,
      wyz = v.wyz * wyz,
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
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
      wxy = wxy,
      wxz = wxz,
      wyz = wyz,
      xyz = 0.0,
      i = 0.0,
    )

  def toPoint: Point =
    Point(
      wxy = wxy,
      wxz = wxz,
      wyz = wyz,
      xyz = 0.0,
    )

  infix def geometric(v: Multivector): Multivector =
    Multivector(
      s = 0.0,
      w = (-v.xy * wxy - v.xz * wxz - v.yz * wyz),
      x = 0.0,
      y = 0.0,
      z = 0.0,
      wx = (v.y * wxy + v.z * wxz - v.xyz * wyz),
      wy = (v.xyz * wxz + v.z * wyz - v.x * wxy),
      wz = (-v.x * wxz - v.xyz * wxy - v.y * wyz),
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
      wxy = (v.s * wxy + v.xz * wyz - v.yz * wxz),
      wxz = (v.s * wxz + v.yz * wxy - v.xy * wyz),
      wyz = (v.s * wyz + v.xy * wxz - v.xz * wxy),
      xyz = 0.0,
      i = (v.x * wyz + v.z * wxy - v.y * wxz),
    )

  infix def geometric(v: Motor): Multivector =
    Multivector(
      s = 0.0,
      w = (-v.xy * wxy - v.xz * wxz - v.yz * wyz),
      x = 0.0,
      y = 0.0,
      z = 0.0,
      wx = 0.0,
      wy = 0.0,
      wz = 0.0,
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
      wxy = (v.s * wxy + v.xz * wyz - v.yz * wxz),
      wxz = (v.s * wxz + v.yz * wxy - v.xy * wyz),
      wyz = (v.s * wyz + v.xy * wxz - v.xz * wxy),
      xyz = 0.0,
      i = 0.0,
    )

  infix def geometric(v: Plane): QuaternionDual =
    QuaternionDual(
      wx = (v.y * wxy + v.z * wxz),
      wy = (v.z * wyz - v.x * wxy),
      wz = (-v.x * wxz - v.y * wyz),
      i = (v.x * wyz + v.z * wxy - v.y * wxz),
    )

  infix def geometric(v: Bivector): Multivector =
    Multivector(
      s = 0.0,
      w = (-v.xy * wxy - v.xz * wxz - v.yz * wyz),
      x = 0.0,
      y = 0.0,
      z = 0.0,
      wx = 0.0,
      wy = 0.0,
      wz = 0.0,
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
      wxy = (v.xz * wyz - v.yz * wxz),
      wxz = (v.yz * wxy - v.xy * wyz),
      wyz = (v.xy * wxz - v.xz * wxy),
      xyz = 0.0,
      i = 0.0,
    )

  infix def geometric(v: Point): BivectorWeight =
    BivectorWeight(
      wx = -v.xyz * wyz,
      wy = v.xyz * wxz,
      wz = -v.xyz * wxy,
    )

  infix def geometric(v: Quaternion): Multivector =
    Multivector(
      s = 0.0,
      w = (-v.xy * wxy - v.xz * wxz - v.yz * wyz),
      x = 0.0,
      y = 0.0,
      z = 0.0,
      wx = 0.0,
      wy = 0.0,
      wz = 0.0,
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
      wxy = (v.s * wxy + v.xz * wyz - v.yz * wxz),
      wxz = (v.s * wxz + v.yz * wxy - v.xy * wyz),
      wyz = (v.s * wyz + v.xy * wxz - v.xz * wxy),
      xyz = 0.0,
      i = 0.0,
    )

  infix def geometric(v: PointNormalized): BivectorWeight =
    BivectorWeight(
      wx = -wyz,
      wy = wxz,
      wz = -wxy,
    )

  infix def geometric(v: PlaneIdeal): QuaternionDual =
    QuaternionDual(
      wx = (v.y * wxy + v.z * wxz),
      wy = (v.z * wyz - v.x * wxy),
      wz = (-v.x * wxz - v.y * wyz),
      i = (v.x * wyz + v.z * wxy - v.y * wxz),
    )

  infix def geometric(v: BivectorBulk): Multivector =
    Multivector(
      s = 0.0,
      w = (-v.xy * wxy - v.xz * wxz - v.yz * wyz),
      x = 0.0,
      y = 0.0,
      z = 0.0,
      wx = 0.0,
      wy = 0.0,
      wz = 0.0,
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
      wxy = (v.xz * wyz - v.yz * wxz),
      wxz = (v.yz * wxy - v.xy * wyz),
      wyz = (v.xy * wxz - v.xz * wxy),
      xyz = 0.0,
      i = 0.0,
    )

  infix def geometric(v: PointCenter.type): BivectorWeight =
    BivectorWeight(
      wx = -wyz,
      wy = wxz,
      wz = -wxy,
    )

  infix def dot(v: Multivector): Multivector =
    Multivector(
      s = 0.0,
      w = (-v.xy * wxy - v.xz * wxz - v.yz * wyz),
      x = 0.0,
      y = 0.0,
      z = 0.0,
      wx = (v.y * wxy + v.z * wxz),
      wy = (v.z * wyz - v.x * wxy),
      wz = (-v.x * wxz - v.y * wyz),
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
      wxy = v.s * wxy,
      wxz = v.s * wxz,
      wyz = v.s * wyz,
      xyz = 0.0,
      i = 0.0,
    )

  infix def dot(v: Motor): Multivector =
    Multivector(
      s = 0.0,
      w = (-v.xy * wxy - v.xz * wxz - v.yz * wyz),
      x = 0.0,
      y = 0.0,
      z = 0.0,
      wx = 0.0,
      wy = 0.0,
      wz = 0.0,
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
      wxy = v.s * wxy,
      wxz = v.s * wxz,
      wyz = v.s * wyz,
      xyz = 0.0,
      i = 0.0,
    )

  infix def dot(v: Plane): BivectorWeight =
    BivectorWeight(
      wx = (v.y * wxy + v.z * wxz),
      wy = (v.z * wyz - v.x * wxy),
      wz = (-v.x * wxz - v.y * wyz),
    )

  infix def dot(v: Bivector): Plane =
    Plane(
      w = (-v.xy * wxy - v.xz * wxz - v.yz * wyz),
      x = 0.0,
      y = 0.0,
      z = 0.0,
    )

  infix def dot(v: Quaternion): Multivector =
    Multivector(
      s = 0.0,
      w = (-v.xy * wxy - v.xz * wxz - v.yz * wyz),
      x = 0.0,
      y = 0.0,
      z = 0.0,
      wx = 0.0,
      wy = 0.0,
      wz = 0.0,
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
      wxy = v.s * wxy,
      wxz = v.s * wxz,
      wyz = v.s * wyz,
      xyz = 0.0,
      i = 0.0,
    )

  infix def dot(v: PlaneIdeal): BivectorWeight =
    BivectorWeight(
      wx = (v.y * wxy + v.z * wxz),
      wy = (v.z * wyz - v.x * wxy),
      wz = (-v.x * wxz - v.y * wyz),
    )

  infix def dot(v: BivectorBulk): Plane =
    Plane(
      w = (-v.xy * wxy - v.xz * wxz - v.yz * wyz),
      x = 0.0,
      y = 0.0,
      z = 0.0,
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
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
      wxy = v.s * wxy,
      wxz = v.s * wxz,
      wyz = v.s * wyz,
      xyz = 0.0,
      i = (v.x * wyz + v.z * wxy - v.y * wxz),
    )

  inline infix def ^(v: Multivector): Multivector = wedge(v)

  infix def wedge(v: Motor): PointIdeal =
    PointIdeal(
      wxy = v.s * wxy,
      wxz = v.s * wxz,
      wyz = v.s * wyz,
    )

  inline infix def ^(v: Motor): PointIdeal = wedge(v)

  infix def wedge(v: Plane): PseudoScalar =
    PseudoScalar(
      i = (v.x * wyz + v.z * wxy - v.y * wxz),
    )

  inline infix def ^(v: Plane): PseudoScalar = wedge(v)

  infix def wedge(v: Quaternion): PointIdeal =
    PointIdeal(
      wxy = v.s * wxy,
      wxz = v.s * wxz,
      wyz = v.s * wyz,
    )

  inline infix def ^(v: Quaternion): PointIdeal = wedge(v)

  infix def wedge(v: PlaneIdeal): PseudoScalar =
    PseudoScalar(
      i = (v.x * wyz + v.z * wxy - v.y * wxz),
    )

  inline infix def ^(v: PlaneIdeal): PseudoScalar = wedge(v)

  infix def antiGeometric(v: Multivector): Multivector =
    Multivector(
      s = (v.y * wxz - v.x * wyz - v.z * wxy),
      w = (v.wy * wxz - v.wx * wyz - v.wz * wxy),
      x = (v.xy * wxz - v.s * wyz - v.xz * wxy),
      y = (v.s * wxz + v.xy * wyz - v.yz * wxy),
      z = (v.xz * wyz - v.s * wxy - v.yz * wxz),
      wx = (v.wxz * wxy - v.w * wyz - v.wxy * wxz),
      wy = (v.w * wxz + v.wyz * wxy - v.wxy * wyz),
      wz = (v.wyz * wxz - v.w * wxy - v.wxz * wyz),
      xy = (v.x * wxz + v.xyz * wxy + v.y * wyz),
      xz = (v.xyz * wxz + v.z * wyz - v.x * wxy),
      yz = (v.xyz * wyz - v.y * wxy - v.z * wxz),
      wxy = (v.i * wxy - v.wx * wxz - v.wy * wyz),
      wxz = (v.i * wxz + v.wx * wxy - v.wz * wyz),
      wyz = (v.i * wyz + v.wy * wxy + v.wz * wxz),
      xyz = (v.xy * wxy + v.xz * wxz + v.yz * wyz),
      i = (v.wxy * wxy + v.wxz * wxz + v.wyz * wyz),
    )

  infix def antiGeometric(v: Motor): Multivector =
    Multivector(
      s = 0.0,
      w = (v.wy * wxz - v.wx * wyz - v.wz * wxy),
      x = (v.xy * wxz - v.s * wyz - v.xz * wxy),
      y = (v.s * wxz + v.xy * wyz - v.yz * wxy),
      z = (v.xz * wyz - v.s * wxy - v.yz * wxz),
      wx = 0.0,
      wy = 0.0,
      wz = 0.0,
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
      wxy = (v.i * wxy - v.wx * wxz - v.wy * wyz),
      wxz = (v.i * wxz + v.wx * wxy - v.wz * wyz),
      wyz = (v.i * wyz + v.wy * wxy + v.wz * wxz),
      xyz = (v.xy * wxy + v.xz * wxz + v.yz * wyz),
      i = 0.0,
    )

  infix def antiGeometric(v: Plane): Motor =
    Motor(
      s = (v.y * wxz - v.x * wyz - v.z * wxy),
      wx = -v.w * wyz,
      wy = v.w * wxz,
      wz = -v.w * wxy,
      xy = (v.x * wxz + v.y * wyz),
      xz = (v.z * wyz - v.x * wxy),
      yz = (-v.y * wxy - v.z * wxz),
      i = 0.0,
    )

  infix def antiGeometric(v: Bivector): Multivector =
    Multivector(
      s = 0.0,
      w = (v.wy * wxz - v.wx * wyz - v.wz * wxy),
      x = (v.xy * wxz - v.xz * wxy),
      y = (v.xy * wyz - v.yz * wxy),
      z = (v.xz * wyz - v.yz * wxz),
      wx = 0.0,
      wy = 0.0,
      wz = 0.0,
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
      wxy = (-v.wx * wxz - v.wy * wyz),
      wxz = (v.wx * wxy - v.wz * wyz),
      wyz = (v.wy * wxy + v.wz * wxz),
      xyz = (v.xy * wxy + v.xz * wxz + v.yz * wyz),
      i = 0.0,
    )

  infix def antiGeometric(v: Point): Motor =
    Motor(
      s = 0.0,
      wx = (v.wxz * wxy - v.wxy * wxz),
      wy = (v.wyz * wxy - v.wxy * wyz),
      wz = (v.wyz * wxz - v.wxz * wyz),
      xy = v.xyz * wxy,
      xz = v.xyz * wxz,
      yz = v.xyz * wyz,
      i = (v.wxy * wxy + v.wxz * wxz + v.wyz * wyz),
    )

  infix def antiGeometric(v: Quaternion): Multivector =
    Multivector(
      s = 0.0,
      w = 0.0,
      x = (v.xy * wxz - v.s * wyz - v.xz * wxy),
      y = (v.s * wxz + v.xy * wyz - v.yz * wxy),
      z = (v.xz * wyz - v.s * wxy - v.yz * wxz),
      wx = 0.0,
      wy = 0.0,
      wz = 0.0,
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
      wxy = 0.0,
      wxz = 0.0,
      wyz = 0.0,
      xyz = (v.xy * wxy + v.xz * wxz + v.yz * wyz),
      i = 0.0,
    )

  infix def antiGeometric(v: QuaternionDual): Multivector =
    Multivector(
      s = 0.0,
      w = (v.wy * wxz - v.wx * wyz - v.wz * wxy),
      x = 0.0,
      y = 0.0,
      z = 0.0,
      wx = 0.0,
      wy = 0.0,
      wz = 0.0,
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
      wxy = (v.i * wxy - v.wx * wxz - v.wy * wyz),
      wxz = (v.i * wxz + v.wx * wxy - v.wz * wyz),
      wyz = (v.i * wyz + v.wy * wxy + v.wz * wxz),
      xyz = 0.0,
      i = 0.0,
    )

  infix def antiGeometric(v: PointIdeal): QuaternionDual =
    QuaternionDual(
      wx = (v.wxz * wxy - v.wxy * wxz),
      wy = (v.wyz * wxy - v.wxy * wyz),
      wz = (v.wyz * wxz - v.wxz * wyz),
      i = (v.wxy * wxy + v.wxz * wxz + v.wyz * wyz),
    )

  infix def antiGeometric(v: PointNormalized): Motor =
    Motor(
      s = 0.0,
      wx = (v.wxz * wxy - v.wxy * wxz),
      wy = (v.wyz * wxy - v.wxy * wyz),
      wz = (v.wyz * wxz - v.wxz * wyz),
      xy = wxy,
      xz = wxz,
      yz = wyz,
      i = (v.wxy * wxy + v.wxz * wxz + v.wyz * wyz),
    )

  infix def antiGeometric(v: PlaneIdeal): Quaternion =
    Quaternion(
      s = (v.y * wxz - v.x * wyz - v.z * wxy),
      xy = (v.x * wxz + v.y * wyz),
      xz = (v.z * wyz - v.x * wxy),
      yz = (-v.y * wxy - v.z * wxz),
    )

  infix def antiGeometric(v: BivectorBulk): Multivector =
    Multivector(
      s = 0.0,
      w = 0.0,
      x = (v.xy * wxz - v.xz * wxy),
      y = (v.xy * wyz - v.yz * wxy),
      z = (v.xz * wyz - v.yz * wxz),
      wx = 0.0,
      wy = 0.0,
      wz = 0.0,
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
      wxy = 0.0,
      wxz = 0.0,
      wyz = 0.0,
      xyz = (v.xy * wxy + v.xz * wxz + v.yz * wyz),
      i = 0.0,
    )

  infix def antiGeometric(v: BivectorWeight): Multivector =
    Multivector(
      s = 0.0,
      w = (v.wy * wxz - v.wx * wyz - v.wz * wxy),
      x = 0.0,
      y = 0.0,
      z = 0.0,
      wx = 0.0,
      wy = 0.0,
      wz = 0.0,
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
      wxy = (-v.wx * wxz - v.wy * wyz),
      wxz = (v.wx * wxy - v.wz * wyz),
      wyz = (v.wy * wxy + v.wz * wxz),
      xyz = 0.0,
      i = 0.0,
    )

  infix def antiGeometric(v: PseudoScalar): PointIdeal =
    PointIdeal(
      wxy = v.i * wxy,
      wxz = v.i * wxz,
      wyz = v.i * wyz,
    )

  infix def antiGeometric(v: PointCenter.type): BivectorBulk =
    BivectorBulk(
      xy = wxy,
      xz = wxz,
      yz = wyz,
    )

  infix def antiDot(v: Multivector): Multivector =
    Multivector(
      s = 0.0,
      w = 0.0,
      x = -v.s * wyz,
      y = v.s * wxz,
      z = -v.s * wxy,
      wx = -v.w * wyz,
      wy = v.w * wxz,
      wz = -v.w * wxy,
      xy = (v.x * wxz + v.y * wyz),
      xz = (v.z * wyz - v.x * wxy),
      yz = (-v.y * wxy - v.z * wxz),
      wxy = (v.i * wxy - v.wx * wxz - v.wy * wyz),
      wxz = (v.i * wxz + v.wx * wxy - v.wz * wyz),
      wyz = (v.i * wyz + v.wy * wxy + v.wz * wxz),
      xyz = (v.xy * wxy + v.xz * wxz + v.yz * wyz),
      i = (v.wxy * wxy + v.wxz * wxz + v.wyz * wyz),
    )

  infix def antiDot(v: Motor): Multivector =
    Multivector(
      s = 0.0,
      w = 0.0,
      x = -v.s * wyz,
      y = v.s * wxz,
      z = -v.s * wxy,
      wx = 0.0,
      wy = 0.0,
      wz = 0.0,
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
      wxy = (v.i * wxy - v.wx * wxz - v.wy * wyz),
      wxz = (v.i * wxz + v.wx * wxy - v.wz * wyz),
      wyz = (v.i * wyz + v.wy * wxy + v.wz * wxz),
      xyz = (v.xy * wxy + v.xz * wxz + v.yz * wyz),
      i = 0.0,
    )

  infix def antiDot(v: Plane): Bivector =
    Bivector(
      wx = -v.w * wyz,
      wy = v.w * wxz,
      wz = -v.w * wxy,
      xy = (v.x * wxz + v.y * wyz),
      xz = (v.z * wyz - v.x * wxy),
      yz = (-v.y * wxy - v.z * wxz),
    )

  infix def antiDot(v: Bivector): Point =
    Point(
      wxy = (-v.wx * wxz - v.wy * wyz),
      wxz = (v.wx * wxy - v.wz * wyz),
      wyz = (v.wy * wxy + v.wz * wxz),
      xyz = (v.xy * wxy + v.xz * wxz + v.yz * wyz),
    )

  infix def antiDot(v: Point): PseudoScalar =
    PseudoScalar(
      i = (v.wxy * wxy + v.wxz * wxz + v.wyz * wyz),
    )

  infix def antiDot(v: Quaternion): Multivector =
    Multivector(
      s = 0.0,
      w = 0.0,
      x = -v.s * wyz,
      y = v.s * wxz,
      z = -v.s * wxy,
      wx = 0.0,
      wy = 0.0,
      wz = 0.0,
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
      wxy = 0.0,
      wxz = 0.0,
      wyz = 0.0,
      xyz = (v.xy * wxy + v.xz * wxz + v.yz * wyz),
      i = 0.0,
    )

  infix def antiDot(v: QuaternionDual): PointIdeal =
    PointIdeal(
      wxy = (v.i * wxy - v.wx * wxz - v.wy * wyz),
      wxz = (v.i * wxz + v.wx * wxy - v.wz * wyz),
      wyz = (v.i * wyz + v.wy * wxy + v.wz * wxz),
    )

  infix def antiDot(v: PointIdeal): PseudoScalar =
    PseudoScalar(
      i = (v.wxy * wxy + v.wxz * wxz + v.wyz * wyz),
    )

  infix def antiDot(v: PointNormalized): PseudoScalar =
    PseudoScalar(
      i = (v.wxy * wxy + v.wxz * wxz + v.wyz * wyz),
    )

  infix def antiDot(v: PlaneIdeal): BivectorBulk =
    BivectorBulk(
      xy = (v.x * wxz + v.y * wyz),
      xz = (v.z * wyz - v.x * wxy),
      yz = (-v.y * wxy - v.z * wxz),
    )

  infix def antiDot(v: BivectorBulk): Point =
    Point(
      wxy = 0.0,
      wxz = 0.0,
      wyz = 0.0,
      xyz = (v.xy * wxy + v.xz * wxz + v.yz * wyz),
    )

  infix def antiDot(v: BivectorWeight): PointIdeal =
    PointIdeal(
      wxy = (-v.wx * wxz - v.wy * wyz),
      wxz = (v.wx * wxy - v.wz * wyz),
      wyz = (v.wy * wxy + v.wz * wxz),
    )

  infix def antiDot(v: PseudoScalar): PointIdeal =
    PointIdeal(
      wxy = v.i * wxy,
      wxz = v.i * wxz,
      wyz = v.i * wyz,
    )

  infix def antiWedge(v: Multivector): Multivector =
    Multivector(
      s = (v.y * wxz - v.x * wyz - v.z * wxy),
      w = (v.wy * wxz - v.wx * wyz - v.wz * wxy),
      x = (v.xy * wxz - v.xz * wxy),
      y = (v.xy * wyz - v.yz * wxy),
      z = (v.xz * wyz - v.yz * wxz),
      wx = (v.wxz * wxy - v.wxy * wxz),
      wy = (v.wyz * wxy - v.wxy * wyz),
      wz = (v.wyz * wxz - v.wxz * wyz),
      xy = v.xyz * wxy,
      xz = v.xyz * wxz,
      yz = v.xyz * wyz,
      wxy = v.i * wxy,
      wxz = v.i * wxz,
      wyz = v.i * wyz,
      xyz = 0.0,
      i = 0.0,
    )

  inline infix def v(v: Multivector): Multivector = antiWedge(v)

  infix def antiWedge(v: Motor): Multivector =
    Multivector(
      s = 0.0,
      w = (v.wy * wxz - v.wx * wyz - v.wz * wxy),
      x = (v.xy * wxz - v.xz * wxy),
      y = (v.xy * wyz - v.yz * wxy),
      z = (v.xz * wyz - v.yz * wxz),
      wx = 0.0,
      wy = 0.0,
      wz = 0.0,
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
      wxy = v.i * wxy,
      wxz = v.i * wxz,
      wyz = v.i * wyz,
      xyz = 0.0,
      i = 0.0,
    )

  inline infix def v(v: Motor): Multivector = antiWedge(v)

  infix def antiWedge(v: Plane): Double =
    (v.y * wxz - v.x * wyz - v.z * wxy)

  inline infix def v(v: Plane): Double = antiWedge(v)

  infix def antiWedge(v: Bivector): Plane =
    Plane(
      w = (v.wy * wxz - v.wx * wyz - v.wz * wxy),
      x = (v.xy * wxz - v.xz * wxy),
      y = (v.xy * wyz - v.yz * wxy),
      z = (v.xz * wyz - v.yz * wxz),
    )

  inline infix def v(v: Bivector): Plane = antiWedge(v)

  infix def antiWedge(v: Point): Bivector =
    Bivector(
      wx = (v.wxz * wxy - v.wxy * wxz),
      wy = (v.wyz * wxy - v.wxy * wyz),
      wz = (v.wyz * wxz - v.wxz * wyz),
      xy = v.xyz * wxy,
      xz = v.xyz * wxz,
      yz = v.xyz * wyz,
    )

  inline infix def v(v: Point): Bivector = antiWedge(v)

  infix def antiWedge(v: Quaternion): PlaneIdeal =
    PlaneIdeal(
      x = (v.xy * wxz - v.xz * wxy),
      y = (v.xy * wyz - v.yz * wxy),
      z = (v.xz * wyz - v.yz * wxz),
    )

  inline infix def v(v: Quaternion): PlaneIdeal = antiWedge(v)

  infix def antiWedge(v: QuaternionDual): Multivector =
    Multivector(
      s = 0.0,
      w = (v.wy * wxz - v.wx * wyz - v.wz * wxy),
      x = 0.0,
      y = 0.0,
      z = 0.0,
      wx = 0.0,
      wy = 0.0,
      wz = 0.0,
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
      wxy = v.i * wxy,
      wxz = v.i * wxz,
      wyz = v.i * wyz,
      xyz = 0.0,
      i = 0.0,
    )

  inline infix def v(v: QuaternionDual): Multivector = antiWedge(v)

  infix def antiWedge(v: PointIdeal): BivectorWeight =
    BivectorWeight(
      wx = (v.wxz * wxy - v.wxy * wxz),
      wy = (v.wyz * wxy - v.wxy * wyz),
      wz = (v.wyz * wxz - v.wxz * wyz),
    )

  inline infix def v(v: PointIdeal): BivectorWeight = antiWedge(v)

  infix def antiWedge(v: PointNormalized): Bivector =
    Bivector(
      wx = (v.wxz * wxy - v.wxy * wxz),
      wy = (v.wyz * wxy - v.wxy * wyz),
      wz = (v.wyz * wxz - v.wxz * wyz),
      xy = wxy,
      xz = wxz,
      yz = wyz,
    )

  inline infix def v(v: PointNormalized): Bivector = antiWedge(v)

  infix def antiWedge(v: PlaneIdeal): Double =
    (v.y * wxz - v.x * wyz - v.z * wxy)

  inline infix def v(v: PlaneIdeal): Double = antiWedge(v)

  infix def antiWedge(v: BivectorBulk): PlaneIdeal =
    PlaneIdeal(
      x = (v.xy * wxz - v.xz * wxy),
      y = (v.xy * wyz - v.yz * wxy),
      z = (v.xz * wyz - v.yz * wxz),
    )

  inline infix def v(v: BivectorBulk): PlaneIdeal = antiWedge(v)

  infix def antiWedge(v: BivectorWeight): Plane =
    Plane(
      w = (v.wy * wxz - v.wx * wyz - v.wz * wxy),
      x = 0.0,
      y = 0.0,
      z = 0.0,
    )

  inline infix def v(v: BivectorWeight): Plane = antiWedge(v)

  infix def antiWedge(v: PseudoScalar): PointIdeal =
    PointIdeal(
      wxy = v.i * wxy,
      wxz = v.i * wxz,
      wyz = v.i * wyz,
    )

  inline infix def v(v: PseudoScalar): PointIdeal = antiWedge(v)

  infix def antiWedge(v: PointCenter.type): BivectorBulk =
    BivectorBulk(
      xy = wxy,
      xz = wxz,
      yz = wyz,
    )

  inline infix def v(v: PointCenter.type): BivectorBulk = antiWedge(v)

  infix def cross(v: Multivector): Multivector =
    Multivector(
      s = 0.0,
      w = 0.0,
      x = 0.0,
      y = 0.0,
      z = 0.0,
      wx = -v.xyz * wyz,
      wy = v.xyz * wxz,
      wz = -v.xyz * wxy,
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
      wxy = (v.xz * wyz - v.yz * wxz),
      wxz = (v.yz * wxy - v.xy * wyz),
      wyz = (v.xy * wxz - v.xz * wxy),
      xyz = 0.0,
      i = (v.x * wyz + v.z * wxy - v.y * wxz),
    )

  infix def cross(v: Motor): PointIdeal =
    PointIdeal(
      wxy = (v.xz * wyz - v.yz * wxz),
      wxz = (v.yz * wxy - v.xy * wyz),
      wyz = (v.xy * wxz - v.xz * wxy),
    )

  infix def cross(v: Plane): PseudoScalar =
    PseudoScalar(
      i = (v.x * wyz + v.z * wxy - v.y * wxz),
    )

  infix def cross(v: Bivector): PointIdeal =
    PointIdeal(
      wxy = (v.xz * wyz - v.yz * wxz),
      wxz = (v.yz * wxy - v.xy * wyz),
      wyz = (v.xy * wxz - v.xz * wxy),
    )

  infix def cross(v: Point): BivectorWeight =
    BivectorWeight(
      wx = -v.xyz * wyz,
      wy = v.xyz * wxz,
      wz = -v.xyz * wxy,
    )

  infix def cross(v: Quaternion): PointIdeal =
    PointIdeal(
      wxy = (v.xz * wyz - v.yz * wxz),
      wxz = (v.yz * wxy - v.xy * wyz),
      wyz = (v.xy * wxz - v.xz * wxy),
    )

  infix def cross(v: PointNormalized): BivectorWeight =
    BivectorWeight(
      wx = -wyz,
      wy = wxz,
      wz = -wxy,
    )

  infix def cross(v: PlaneIdeal): PseudoScalar =
    PseudoScalar(
      i = (v.x * wyz + v.z * wxy - v.y * wxz),
    )

  infix def cross(v: BivectorBulk): PointIdeal =
    PointIdeal(
      wxy = (v.xz * wyz - v.yz * wxz),
      wxz = (v.yz * wxy - v.xy * wyz),
      wyz = (v.xy * wxz - v.xz * wxy),
    )

  infix def cross(v: PointCenter.type): BivectorWeight =
    BivectorWeight(
      wx = -wyz,
      wy = wxz,
      wz = -wxy,
    )