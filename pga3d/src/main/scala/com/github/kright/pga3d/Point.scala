package com.github.kright.pga3d

/** this code is generated, see com.github.kright.pga3d.codegen.MultivectorSubClass */
case class Point(
                  wxy: Double = 0.0,
                  wxz: Double = 0.0,
                  wyz: Double = 0.0,
                  xyz: Double = 0.0,
                ):

  def dual: Plane =
    Plane(
      w = xyz,
      x = -wyz,
      y = wxz,
      z = -wxy,
    )

  def weight: PointIdeal =
    PointIdeal(
      wxy = wxy,
      wxz = wxz,
      wyz = wyz,
    )

  def bulk: Point =
    Point(
      wxy = 0.0,
      wxz = 0.0,
      wyz = 0.0,
      xyz = xyz,
    )

  def reverse: Point =
    Point(
      wxy = -wxy,
      wxz = -wxz,
      wyz = -wyz,
      xyz = -xyz,
    )

  def antiReverse: Point =
    this

  def unary_ : Point =
    Point(
      wxy = -wxy,
      wxz = -wxz,
      wyz = -wyz,
      xyz = -xyz,
    )

  def bulkNormSquare: Double =
    xyz * xyz

  def weightNormSquare: Double =
    (wxy * wxy + wxz * wxz + wyz * wyz)

  def normSquare: Double =
    (wxy * wxy + wxz * wxz + wyz * wyz + xyz * xyz)

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

  def *(v: Double): Point =
    Point(
      wxy = v * wxy,
      wxz = v * wxz,
      wyz = v * wyz,
      xyz = v * xyz,
    )

  inline def /(v: Double): Point =
    this * (1.0 / v)

  def +(v: Point): Point =
    Point(
      wxy = (v.wxy + wxy),
      wxz = (v.wxz + wxz),
      wyz = (v.wyz + wyz),
      xyz = (v.xyz + xyz),
    )

  def -(v: Point): Point =
    Point(
      wxy = (wxy - v.wxy),
      wxz = (wxz - v.wxz),
      wyz = (wyz - v.wyz),
      xyz = (xyz - v.xyz),
    )

  def madd(v: Point, mult: Double): Point =
    Point(
      wxy = (wxy + mult * v.wxy),
      wxz = (wxz + mult * v.wxz),
      wyz = (wyz + mult * v.wyz),
      xyz = (xyz + mult * v.xyz),
    )

  def multiplyElementwise(v: Point): Point =
    Point(
      wxy = v.wxy * wxy,
      wxz = v.wxz * wxz,
      wyz = v.wyz * wyz,
      xyz = v.xyz * xyz,
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
      xyz = xyz,
      i = 0.0,
    )

  infix def geometric(v: Multivector): Multivector =
    Multivector(
      s = -v.xyz * xyz,
      w = (v.i * xyz - v.xy * wxy - v.xz * wxz - v.yz * wyz),
      x = -v.yz * xyz,
      y = v.xz * xyz,
      z = -v.xy * xyz,
      wx = (v.wyz * xyz + v.y * wxy + v.z * wxz - v.xyz * wyz),
      wy = (v.xyz * wxz + v.z * wyz - v.wxz * xyz - v.x * wxy),
      wz = (v.wxy * xyz - v.x * wxz - v.xyz * wxy - v.y * wyz),
      xy = v.z * xyz,
      xz = -v.y * xyz,
      yz = v.x * xyz,
      wxy = (v.s * wxy + v.xz * wyz - v.wz * xyz - v.yz * wxz),
      wxz = (v.s * wxz + v.wy * xyz + v.yz * wxy - v.xy * wyz),
      wyz = (v.s * wyz + v.xy * wxz - v.wx * xyz - v.xz * wxy),
      xyz = v.s * xyz,
      i = (v.x * wyz + v.z * wxy - v.w * xyz - v.y * wxz),
    )

  infix def geometric(v: Motor): Multivector =
    Multivector(
      s = 0.0,
      w = (v.i * xyz - v.xy * wxy - v.xz * wxz - v.yz * wyz),
      x = -v.yz * xyz,
      y = v.xz * xyz,
      z = -v.xy * xyz,
      wx = 0.0,
      wy = 0.0,
      wz = 0.0,
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
      wxy = (v.s * wxy + v.xz * wyz - v.wz * xyz - v.yz * wxz),
      wxz = (v.s * wxz + v.wy * xyz + v.yz * wxy - v.xy * wyz),
      wyz = (v.s * wyz + v.xy * wxz - v.wx * xyz - v.xz * wxy),
      xyz = v.s * xyz,
      i = 0.0,
    )

  infix def geometric(v: Plane): Motor =
    Motor(
      s = 0.0,
      wx = (v.y * wxy + v.z * wxz),
      wy = (v.z * wyz - v.x * wxy),
      wz = (-v.x * wxz - v.y * wyz),
      xy = v.z * xyz,
      xz = -v.y * xyz,
      yz = v.x * xyz,
      i = (v.x * wyz + v.z * wxy - v.w * xyz - v.y * wxz),
    )

  infix def geometric(v: Bivector): Multivector =
    Multivector(
      s = 0.0,
      w = (-v.xy * wxy - v.xz * wxz - v.yz * wyz),
      x = -v.yz * xyz,
      y = v.xz * xyz,
      z = -v.xy * xyz,
      wx = 0.0,
      wy = 0.0,
      wz = 0.0,
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
      wxy = (v.xz * wyz - v.wz * xyz - v.yz * wxz),
      wxz = (v.wy * xyz + v.yz * wxy - v.xy * wyz),
      wyz = (v.xy * wxz - v.wx * xyz - v.xz * wxy),
      xyz = 0.0,
      i = 0.0,
    )

  infix def geometric(v: Point): Motor =
    Motor(
      s = -v.xyz * xyz,
      wx = (v.wyz * xyz - v.xyz * wyz),
      wy = (v.xyz * wxz - v.wxz * xyz),
      wz = (v.wxy * xyz - v.xyz * wxy),
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
      i = 0.0,
    )

  infix def geometric(v: Quaternion): Multivector =
    Multivector(
      s = 0.0,
      w = (-v.xy * wxy - v.xz * wxz - v.yz * wyz),
      x = -v.yz * xyz,
      y = v.xz * xyz,
      z = -v.xy * xyz,
      wx = 0.0,
      wy = 0.0,
      wz = 0.0,
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
      wxy = (v.s * wxy + v.xz * wyz - v.yz * wxz),
      wxz = (v.s * wxz + v.yz * wxy - v.xy * wyz),
      wyz = (v.s * wyz + v.xy * wxz - v.xz * wxy),
      xyz = v.s * xyz,
      i = 0.0,
    )

  infix def geometric(v: QuaternionDual): Multivector =
    Multivector(
      s = 0.0,
      w = v.i * xyz,
      x = 0.0,
      y = 0.0,
      z = 0.0,
      wx = 0.0,
      wy = 0.0,
      wz = 0.0,
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
      wxy = -v.wz * xyz,
      wxz = v.wy * xyz,
      wyz = -v.wx * xyz,
      xyz = 0.0,
      i = 0.0,
    )

  infix def geometric(v: PointIdeal): BivectorWeight =
    BivectorWeight(
      wx = v.wyz * xyz,
      wy = -v.wxz * xyz,
      wz = v.wxy * xyz,
    )

  infix def geometric(v: PointNormalized): Motor =
    Motor(
      s = -xyz,
      wx = (-wyz + v.wyz * xyz),
      wy = (wxz - v.wxz * xyz),
      wz = (-wxy + v.wxy * xyz),
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
      i = 0.0,
    )

  infix def geometric(v: PlaneIdeal): Motor =
    Motor(
      s = 0.0,
      wx = (v.y * wxy + v.z * wxz),
      wy = (v.z * wyz - v.x * wxy),
      wz = (-v.x * wxz - v.y * wyz),
      xy = v.z * xyz,
      xz = -v.y * xyz,
      yz = v.x * xyz,
      i = (v.x * wyz + v.z * wxy - v.y * wxz),
    )

  infix def geometric(v: BivectorBulk): Multivector =
    Multivector(
      s = 0.0,
      w = (-v.xy * wxy - v.xz * wxz - v.yz * wyz),
      x = -v.yz * xyz,
      y = v.xz * xyz,
      z = -v.xy * xyz,
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

  infix def geometric(v: BivectorWeight): PointIdeal =
    PointIdeal(
      wxy = -v.wz * xyz,
      wxz = v.wy * xyz,
      wyz = -v.wx * xyz,
    )

  infix def geometric(v: PseudoScalar): Plane =
    Plane(
      w = v.i * xyz,
      x = 0.0,
      y = 0.0,
      z = 0.0,
    )

  infix def geometric(v: PointCenter.type): Motor =
    Motor(
      s = -xyz,
      wx = -wyz,
      wy = wxz,
      wz = -wxy,
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
      i = 0.0,
    )

  infix def dot(v: Multivector): Multivector =
    Multivector(
      s = -v.xyz * xyz,
      w = (v.i * xyz - v.xy * wxy - v.xz * wxz - v.yz * wyz),
      x = -v.yz * xyz,
      y = v.xz * xyz,
      z = -v.xy * xyz,
      wx = (v.y * wxy + v.z * wxz),
      wy = (v.z * wyz - v.x * wxy),
      wz = (-v.x * wxz - v.y * wyz),
      xy = v.z * xyz,
      xz = -v.y * xyz,
      yz = v.x * xyz,
      wxy = v.s * wxy,
      wxz = v.s * wxz,
      wyz = v.s * wyz,
      xyz = v.s * xyz,
      i = 0.0,
    )

  infix def dot(v: Motor): Multivector =
    Multivector(
      s = 0.0,
      w = (v.i * xyz - v.xy * wxy - v.xz * wxz - v.yz * wyz),
      x = -v.yz * xyz,
      y = v.xz * xyz,
      z = -v.xy * xyz,
      wx = 0.0,
      wy = 0.0,
      wz = 0.0,
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
      wxy = v.s * wxy,
      wxz = v.s * wxz,
      wyz = v.s * wyz,
      xyz = v.s * xyz,
      i = 0.0,
    )

  infix def dot(v: Plane): Bivector =
    Bivector(
      wx = (v.y * wxy + v.z * wxz),
      wy = (v.z * wyz - v.x * wxy),
      wz = (-v.x * wxz - v.y * wyz),
      xy = v.z * xyz,
      xz = -v.y * xyz,
      yz = v.x * xyz,
    )

  infix def dot(v: Bivector): Plane =
    Plane(
      w = (-v.xy * wxy - v.xz * wxz - v.yz * wyz),
      x = -v.yz * xyz,
      y = v.xz * xyz,
      z = -v.xy * xyz,
    )

  infix def dot(v: Point): Double =
    -v.xyz * xyz

  infix def dot(v: Quaternion): Multivector =
    Multivector(
      s = 0.0,
      w = (-v.xy * wxy - v.xz * wxz - v.yz * wyz),
      x = -v.yz * xyz,
      y = v.xz * xyz,
      z = -v.xy * xyz,
      wx = 0.0,
      wy = 0.0,
      wz = 0.0,
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
      wxy = v.s * wxy,
      wxz = v.s * wxz,
      wyz = v.s * wyz,
      xyz = v.s * xyz,
      i = 0.0,
    )

  infix def dot(v: QuaternionDual): Plane =
    Plane(
      w = v.i * xyz,
      x = 0.0,
      y = 0.0,
      z = 0.0,
    )

  infix def dot(v: PointNormalized): Double =
    -xyz

  infix def dot(v: PlaneIdeal): Bivector =
    Bivector(
      wx = (v.y * wxy + v.z * wxz),
      wy = (v.z * wyz - v.x * wxy),
      wz = (-v.x * wxz - v.y * wyz),
      xy = v.z * xyz,
      xz = -v.y * xyz,
      yz = v.x * xyz,
    )

  infix def dot(v: BivectorBulk): Plane =
    Plane(
      w = (-v.xy * wxy - v.xz * wxz - v.yz * wyz),
      x = -v.yz * xyz,
      y = v.xz * xyz,
      z = -v.xy * xyz,
    )

  infix def dot(v: PseudoScalar): Plane =
    Plane(
      w = v.i * xyz,
      x = 0.0,
      y = 0.0,
      z = 0.0,
    )

  infix def dot(v: PointCenter.type): Double =
    -xyz

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
      xyz = v.s * xyz,
      i = (v.x * wyz + v.z * wxy - v.w * xyz - v.y * wxz),
    )

  inline infix def ^(v: Multivector): Multivector = wedge(v)

  infix def wedge(v: Motor): Point =
    Point(
      wxy = v.s * wxy,
      wxz = v.s * wxz,
      wyz = v.s * wyz,
      xyz = v.s * xyz,
    )

  inline infix def ^(v: Motor): Point = wedge(v)

  infix def wedge(v: Plane): PseudoScalar =
    PseudoScalar(
      i = (v.x * wyz + v.z * wxy - v.w * xyz - v.y * wxz),
    )

  inline infix def ^(v: Plane): PseudoScalar = wedge(v)

  infix def wedge(v: Quaternion): Point =
    Point(
      wxy = v.s * wxy,
      wxz = v.s * wxz,
      wyz = v.s * wyz,
      xyz = v.s * xyz,
    )

  inline infix def ^(v: Quaternion): Point = wedge(v)

  infix def wedge(v: PlaneIdeal): PseudoScalar =
    PseudoScalar(
      i = (v.x * wyz + v.z * wxy - v.y * wxz),
    )

  inline infix def ^(v: PlaneIdeal): PseudoScalar = wedge(v)

  infix def antiGeometric(v: Multivector): Multivector =
    Multivector(
      s = (v.w * xyz + v.y * wxz - v.x * wyz - v.z * wxy),
      w = (v.wy * wxz - v.wx * wyz - v.wz * wxy),
      x = (v.xy * wxz - v.s * wyz - v.wx * xyz - v.xz * wxy),
      y = (v.s * wxz + v.xy * wyz - v.wy * xyz - v.yz * wxy),
      z = (v.xz * wyz - v.s * wxy - v.wz * xyz - v.yz * wxz),
      wx = (v.wxz * wxy - v.w * wyz - v.wxy * wxz),
      wy = (v.w * wxz + v.wyz * wxy - v.wxy * wyz),
      wz = (v.wyz * wxz - v.w * wxy - v.wxz * wyz),
      xy = (v.x * wxz + v.xyz * wxy + v.y * wyz - v.wxy * xyz),
      xz = (v.xyz * wxz + v.z * wyz - v.wxz * xyz - v.x * wxy),
      yz = (v.xyz * wyz - v.wyz * xyz - v.y * wxy - v.z * wxz),
      wxy = (v.i * wxy - v.wx * wxz - v.wy * wyz),
      wxz = (v.i * wxz + v.wx * wxy - v.wz * wyz),
      wyz = (v.i * wyz + v.wy * wxy + v.wz * wxz),
      xyz = (v.i * xyz + v.xy * wxy + v.xz * wxz + v.yz * wyz),
      i = (v.wxy * wxy + v.wxz * wxz + v.wyz * wyz),
    )

  infix def antiGeometric(v: Motor): Multivector =
    Multivector(
      s = 0.0,
      w = (v.wy * wxz - v.wx * wyz - v.wz * wxy),
      x = (v.xy * wxz - v.s * wyz - v.wx * xyz - v.xz * wxy),
      y = (v.s * wxz + v.xy * wyz - v.wy * xyz - v.yz * wxy),
      z = (v.xz * wyz - v.s * wxy - v.wz * xyz - v.yz * wxz),
      wx = 0.0,
      wy = 0.0,
      wz = 0.0,
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
      wxy = (v.i * wxy - v.wx * wxz - v.wy * wyz),
      wxz = (v.i * wxz + v.wx * wxy - v.wz * wyz),
      wyz = (v.i * wyz + v.wy * wxy + v.wz * wxz),
      xyz = (v.i * xyz + v.xy * wxy + v.xz * wxz + v.yz * wyz),
      i = 0.0,
    )

  infix def antiGeometric(v: Plane): Motor =
    Motor(
      s = (v.w * xyz + v.y * wxz - v.x * wyz - v.z * wxy),
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
      x = (v.xy * wxz - v.wx * xyz - v.xz * wxy),
      y = (v.xy * wyz - v.wy * xyz - v.yz * wxy),
      z = (v.xz * wyz - v.wz * xyz - v.yz * wxz),
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
      xy = (v.xyz * wxy - v.wxy * xyz),
      xz = (v.xyz * wxz - v.wxz * xyz),
      yz = (v.xyz * wyz - v.wyz * xyz),
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
      x = -v.wx * xyz,
      y = -v.wy * xyz,
      z = -v.wz * xyz,
      wx = 0.0,
      wy = 0.0,
      wz = 0.0,
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
      wxy = (v.i * wxy - v.wx * wxz - v.wy * wyz),
      wxz = (v.i * wxz + v.wx * wxy - v.wz * wyz),
      wyz = (v.i * wyz + v.wy * wxy + v.wz * wxz),
      xyz = v.i * xyz,
      i = 0.0,
    )

  infix def antiGeometric(v: PointIdeal): Motor =
    Motor(
      s = 0.0,
      wx = (v.wxz * wxy - v.wxy * wxz),
      wy = (v.wyz * wxy - v.wxy * wyz),
      wz = (v.wyz * wxz - v.wxz * wyz),
      xy = -v.wxy * xyz,
      xz = -v.wxz * xyz,
      yz = -v.wyz * xyz,
      i = (v.wxy * wxy + v.wxz * wxz + v.wyz * wyz),
    )

  infix def antiGeometric(v: PointNormalized): Motor =
    Motor(
      s = 0.0,
      wx = (v.wxz * wxy - v.wxy * wxz),
      wy = (v.wyz * wxy - v.wxy * wyz),
      wz = (v.wyz * wxz - v.wxz * wyz),
      xy = (wxy - v.wxy * xyz),
      xz = (wxz - v.wxz * xyz),
      yz = (wyz - v.wyz * xyz),
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
      x = -v.wx * xyz,
      y = -v.wy * xyz,
      z = -v.wz * xyz,
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

  infix def antiGeometric(v: PseudoScalar): Point =
    Point(
      wxy = v.i * wxy,
      wxz = v.i * wxz,
      wyz = v.i * wyz,
      xyz = v.i * xyz,
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
      xyz = (v.i * xyz + v.xy * wxy + v.xz * wxz + v.yz * wyz),
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
      xyz = (v.i * xyz + v.xy * wxy + v.xz * wxz + v.yz * wyz),
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

  infix def antiDot(v: QuaternionDual): Point =
    Point(
      wxy = (v.i * wxy - v.wx * wxz - v.wy * wyz),
      wxz = (v.i * wxz + v.wx * wxy - v.wz * wyz),
      wyz = (v.i * wyz + v.wy * wxy + v.wz * wxz),
      xyz = v.i * xyz,
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

  infix def antiDot(v: PseudoScalar): Point =
    Point(
      wxy = v.i * wxy,
      wxz = v.i * wxz,
      wyz = v.i * wyz,
      xyz = v.i * xyz,
    )

  infix def antiWedge(v: Multivector): Multivector =
    Multivector(
      s = (v.w * xyz + v.y * wxz - v.x * wyz - v.z * wxy),
      w = (v.wy * wxz - v.wx * wyz - v.wz * wxy),
      x = (v.xy * wxz - v.wx * xyz - v.xz * wxy),
      y = (v.xy * wyz - v.wy * xyz - v.yz * wxy),
      z = (v.xz * wyz - v.wz * xyz - v.yz * wxz),
      wx = (v.wxz * wxy - v.wxy * wxz),
      wy = (v.wyz * wxy - v.wxy * wyz),
      wz = (v.wyz * wxz - v.wxz * wyz),
      xy = (v.xyz * wxy - v.wxy * xyz),
      xz = (v.xyz * wxz - v.wxz * xyz),
      yz = (v.xyz * wyz - v.wyz * xyz),
      wxy = v.i * wxy,
      wxz = v.i * wxz,
      wyz = v.i * wyz,
      xyz = v.i * xyz,
      i = 0.0,
    )

  inline infix def v(v: Multivector): Multivector = antiWedge(v)

  infix def antiWedge(v: Motor): Multivector =
    Multivector(
      s = 0.0,
      w = (v.wy * wxz - v.wx * wyz - v.wz * wxy),
      x = (v.xy * wxz - v.wx * xyz - v.xz * wxy),
      y = (v.xy * wyz - v.wy * xyz - v.yz * wxy),
      z = (v.xz * wyz - v.wz * xyz - v.yz * wxz),
      wx = 0.0,
      wy = 0.0,
      wz = 0.0,
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
      wxy = v.i * wxy,
      wxz = v.i * wxz,
      wyz = v.i * wyz,
      xyz = v.i * xyz,
      i = 0.0,
    )

  inline infix def v(v: Motor): Multivector = antiWedge(v)

  infix def antiWedge(v: Plane): Double =
    (v.w * xyz + v.y * wxz - v.x * wyz - v.z * wxy)

  inline infix def v(v: Plane): Double = antiWedge(v)

  infix def antiWedge(v: Bivector): Plane =
    Plane(
      w = (v.wy * wxz - v.wx * wyz - v.wz * wxy),
      x = (v.xy * wxz - v.wx * xyz - v.xz * wxy),
      y = (v.xy * wyz - v.wy * xyz - v.yz * wxy),
      z = (v.xz * wyz - v.wz * xyz - v.yz * wxz),
    )

  inline infix def v(v: Bivector): Plane = antiWedge(v)

  infix def antiWedge(v: Point): Bivector =
    Bivector(
      wx = (v.wxz * wxy - v.wxy * wxz),
      wy = (v.wyz * wxy - v.wxy * wyz),
      wz = (v.wyz * wxz - v.wxz * wyz),
      xy = (v.xyz * wxy - v.wxy * xyz),
      xz = (v.xyz * wxz - v.wxz * xyz),
      yz = (v.xyz * wyz - v.wyz * xyz),
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
      x = -v.wx * xyz,
      y = -v.wy * xyz,
      z = -v.wz * xyz,
      wx = 0.0,
      wy = 0.0,
      wz = 0.0,
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
      wxy = v.i * wxy,
      wxz = v.i * wxz,
      wyz = v.i * wyz,
      xyz = v.i * xyz,
      i = 0.0,
    )

  inline infix def v(v: QuaternionDual): Multivector = antiWedge(v)

  infix def antiWedge(v: PointIdeal): Bivector =
    Bivector(
      wx = (v.wxz * wxy - v.wxy * wxz),
      wy = (v.wyz * wxy - v.wxy * wyz),
      wz = (v.wyz * wxz - v.wxz * wyz),
      xy = -v.wxy * xyz,
      xz = -v.wxz * xyz,
      yz = -v.wyz * xyz,
    )

  inline infix def v(v: PointIdeal): Bivector = antiWedge(v)

  infix def antiWedge(v: PointNormalized): Bivector =
    Bivector(
      wx = (v.wxz * wxy - v.wxy * wxz),
      wy = (v.wyz * wxy - v.wxy * wyz),
      wz = (v.wyz * wxz - v.wxz * wyz),
      xy = (wxy - v.wxy * xyz),
      xz = (wxz - v.wxz * xyz),
      yz = (wyz - v.wyz * xyz),
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
      x = -v.wx * xyz,
      y = -v.wy * xyz,
      z = -v.wz * xyz,
    )

  inline infix def v(v: BivectorWeight): Plane = antiWedge(v)

  infix def antiWedge(v: PseudoScalar): Point =
    Point(
      wxy = v.i * wxy,
      wxz = v.i * wxz,
      wyz = v.i * wyz,
      xyz = v.i * xyz,
    )

  inline infix def v(v: PseudoScalar): Point = antiWedge(v)

  infix def antiWedge(v: PointCenter.type): BivectorBulk =
    BivectorBulk(
      xy = wxy,
      xz = wxz,
      yz = wyz,
    )

  inline infix def v(v: PointCenter.type): BivectorBulk = antiWedge(v)

  infix def sandwich(v: Multivector): Multivector =
    val wxyMxyz = wxy * xyz
    val wxzMxyz = wxz * xyz
    val wyzMxyz = wyz * xyz
    val xyzMxyz = xyz * xyz
    Multivector(
      s = v.s * xyzMxyz,
      w = (-2.0 * v.y * wxzMxyz - v.w * xyzMxyz + 2.0 * v.x * wyzMxyz + 2.0 * v.z * wxyMxyz),
      x = v.x * xyzMxyz,
      y = v.y * xyzMxyz,
      z = v.z * xyzMxyz,
      wx = (-2.0 * v.xz * wxyMxyz - v.wx * xyzMxyz + 2.0 * v.xy * wxzMxyz),
      wy = (-2.0 * v.yz * wxyMxyz - v.wy * xyzMxyz + 2.0 * v.xy * wyzMxyz),
      wz = (-2.0 * v.yz * wxzMxyz - v.wz * xyzMxyz + 2.0 * v.xz * wyzMxyz),
      xy = v.xy * xyzMxyz,
      xz = v.xz * xyzMxyz,
      yz = v.yz * xyzMxyz,
      wxy = (-v.wxy * xyzMxyz + 2.0 * v.xyz * wxyMxyz),
      wxz = (-v.wxz * xyzMxyz + 2.0 * v.xyz * wxzMxyz),
      wyz = (-v.wyz * xyzMxyz + 2.0 * v.xyz * wyzMxyz),
      xyz = v.xyz * xyzMxyz,
      i = -v.i * xyzMxyz,
    )

  infix def sandwich(v: Motor): Motor =
    val wxyMxyz = wxy * xyz
    val wxzMxyz = wxz * xyz
    val wyzMxyz = wyz * xyz
    val xyzMxyz = xyz * xyz
    Motor(
      s = v.s * xyzMxyz,
      wx = (-2.0 * v.xz * wxyMxyz - v.wx * xyzMxyz + 2.0 * v.xy * wxzMxyz),
      wy = (-2.0 * v.yz * wxyMxyz - v.wy * xyzMxyz + 2.0 * v.xy * wyzMxyz),
      wz = (-2.0 * v.yz * wxzMxyz - v.wz * xyzMxyz + 2.0 * v.xz * wyzMxyz),
      xy = v.xy * xyzMxyz,
      xz = v.xz * xyzMxyz,
      yz = v.yz * xyzMxyz,
      i = -v.i * xyzMxyz,
    )

  infix def sandwich(v: Plane): Plane =
    val xyzMxyz = xyz * xyz
    Plane(
      w = (-v.w * xyzMxyz - 2.0 * v.y * wxz * xyz + 2.0 * v.x * wyz * xyz + 2.0 * v.z * wxy * xyz),
      x = v.x * xyzMxyz,
      y = v.y * xyzMxyz,
      z = v.z * xyzMxyz,
    )

  infix def sandwich(v: Bivector): Bivector =
    val wxyMxyz = wxy * xyz
    val wxzMxyz = wxz * xyz
    val wyzMxyz = wyz * xyz
    val xyzMxyz = xyz * xyz
    Bivector(
      wx = (-2.0 * v.xz * wxyMxyz - v.wx * xyzMxyz + 2.0 * v.xy * wxzMxyz),
      wy = (-2.0 * v.yz * wxyMxyz - v.wy * xyzMxyz + 2.0 * v.xy * wyzMxyz),
      wz = (-2.0 * v.yz * wxzMxyz - v.wz * xyzMxyz + 2.0 * v.xz * wyzMxyz),
      xy = v.xy * xyzMxyz,
      xz = v.xz * xyzMxyz,
      yz = v.yz * xyzMxyz,
    )

  infix def sandwich(v: Point): Point =
    val xyzMxyz = xyz * xyz
    Point(
      wxy = (-v.wxy * xyzMxyz + 2.0 * v.xyz * wxy * xyz),
      wxz = (-v.wxz * xyzMxyz + 2.0 * v.xyz * wxz * xyz),
      wyz = (-v.wyz * xyzMxyz + 2.0 * v.xyz * wyz * xyz),
      xyz = v.xyz * xyzMxyz,
    )

  infix def sandwich(v: Quaternion): Motor =
    val wxyMxyz = wxy * xyz
    val wxzMxyz = wxz * xyz
    val wyzMxyz = wyz * xyz
    val xyzMxyz = xyz * xyz
    Motor(
      s = v.s * xyzMxyz,
      wx = (-2.0 * v.xz * wxyMxyz + 2.0 * v.xy * wxzMxyz),
      wy = (-2.0 * v.yz * wxyMxyz + 2.0 * v.xy * wyzMxyz),
      wz = (-2.0 * v.yz * wxzMxyz + 2.0 * v.xz * wyzMxyz),
      xy = v.xy * xyzMxyz,
      xz = v.xz * xyzMxyz,
      yz = v.yz * xyzMxyz,
      i = 0.0,
    )

  infix def sandwich(v: QuaternionDual): QuaternionDual =
    val xyzMxyz = xyz * xyz
    QuaternionDual(
      wx = -v.wx * xyzMxyz,
      wy = -v.wy * xyzMxyz,
      wz = -v.wz * xyzMxyz,
      i = -v.i * xyzMxyz,
    )

  infix def sandwich(v: PointIdeal): PointIdeal =
    val xyzMxyz = xyz * xyz
    PointIdeal(
      wxy = -v.wxy * xyzMxyz,
      wxz = -v.wxz * xyzMxyz,
      wyz = -v.wyz * xyzMxyz,
    )

  infix def sandwich(v: PointNormalized): Point =
    val xyzMxyz = xyz * xyz
    Point(
      wxy = (-v.wxy * xyzMxyz + 2.0 * wxy * xyz),
      wxz = (-v.wxz * xyzMxyz + 2.0 * wxz * xyz),
      wyz = (-v.wyz * xyzMxyz + 2.0 * wyz * xyz),
      xyz = xyzMxyz,
    )

  infix def sandwich(v: PlaneIdeal): Plane =
    val xyzMxyz = xyz * xyz
    Plane(
      w = xyz * (-2.0 * v.y * wxz + 2.0 * v.x * wyz + 2.0 * v.z * wxy),
      x = v.x * xyzMxyz,
      y = v.y * xyzMxyz,
      z = v.z * xyzMxyz,
    )

  infix def sandwich(v: BivectorBulk): Bivector =
    val wxyMxyz = wxy * xyz
    val wxzMxyz = wxz * xyz
    val wyzMxyz = wyz * xyz
    val xyzMxyz = xyz * xyz
    Bivector(
      wx = (-2.0 * v.xz * wxyMxyz + 2.0 * v.xy * wxzMxyz),
      wy = (-2.0 * v.yz * wxyMxyz + 2.0 * v.xy * wyzMxyz),
      wz = (-2.0 * v.yz * wxzMxyz + 2.0 * v.xz * wyzMxyz),
      xy = v.xy * xyzMxyz,
      xz = v.xz * xyzMxyz,
      yz = v.yz * xyzMxyz,
    )

  infix def sandwich(v: BivectorWeight): BivectorWeight =
    val xyzMxyz = xyz * xyz
    BivectorWeight(
      wx = -v.wx * xyzMxyz,
      wy = -v.wy * xyzMxyz,
      wz = -v.wz * xyzMxyz,
    )

  infix def sandwich(v: PseudoScalar): PseudoScalar =
    PseudoScalar(
      i = -v.i * xyz * xyz,
    )

  infix def sandwich(v: PointCenter.type): Point =
    Point(
      wxy = 2.0 * wxy * xyz,
      wxz = 2.0 * wxz * xyz,
      wyz = 2.0 * wyz * xyz,
      xyz = xyz * xyz,
    )

  infix def reverseSandwich(v: Multivector): Multivector =
    val wxyMxyz = wxy * xyz
    val wxzMxyz = wxz * xyz
    val wyzMxyz = wyz * xyz
    val xyzMxyz = xyz * xyz
    Multivector(
      s = v.s * xyzMxyz,
      w = (-2.0 * v.y * wxzMxyz - v.w * xyzMxyz + 2.0 * v.x * wyzMxyz + 2.0 * v.z * wxyMxyz),
      x = v.x * xyzMxyz,
      y = v.y * xyzMxyz,
      z = v.z * xyzMxyz,
      wx = (-2.0 * v.xz * wxyMxyz - v.wx * xyzMxyz + 2.0 * v.xy * wxzMxyz),
      wy = (-2.0 * v.yz * wxyMxyz - v.wy * xyzMxyz + 2.0 * v.xy * wyzMxyz),
      wz = (-2.0 * v.yz * wxzMxyz - v.wz * xyzMxyz + 2.0 * v.xz * wyzMxyz),
      xy = v.xy * xyzMxyz,
      xz = v.xz * xyzMxyz,
      yz = v.yz * xyzMxyz,
      wxy = (-v.wxy * xyzMxyz + 2.0 * v.xyz * wxyMxyz),
      wxz = (-v.wxz * xyzMxyz + 2.0 * v.xyz * wxzMxyz),
      wyz = (-v.wyz * xyzMxyz + 2.0 * v.xyz * wyzMxyz),
      xyz = v.xyz * xyzMxyz,
      i = -v.i * xyzMxyz,
    )

  infix def reverseSandwich(v: Motor): Motor =
    val wxyMxyz = wxy * xyz
    val wxzMxyz = wxz * xyz
    val wyzMxyz = wyz * xyz
    val xyzMxyz = xyz * xyz
    Motor(
      s = v.s * xyzMxyz,
      wx = (-2.0 * v.xz * wxyMxyz - v.wx * xyzMxyz + 2.0 * v.xy * wxzMxyz),
      wy = (-2.0 * v.yz * wxyMxyz - v.wy * xyzMxyz + 2.0 * v.xy * wyzMxyz),
      wz = (-2.0 * v.yz * wxzMxyz - v.wz * xyzMxyz + 2.0 * v.xz * wyzMxyz),
      xy = v.xy * xyzMxyz,
      xz = v.xz * xyzMxyz,
      yz = v.yz * xyzMxyz,
      i = -v.i * xyzMxyz,
    )

  infix def reverseSandwich(v: Plane): Plane =
    val xyzMxyz = xyz * xyz
    Plane(
      w = (-v.w * xyzMxyz - 2.0 * v.y * wxz * xyz + 2.0 * v.x * wyz * xyz + 2.0 * v.z * wxy * xyz),
      x = v.x * xyzMxyz,
      y = v.y * xyzMxyz,
      z = v.z * xyzMxyz,
    )

  infix def reverseSandwich(v: Bivector): Bivector =
    val wxyMxyz = wxy * xyz
    val wxzMxyz = wxz * xyz
    val wyzMxyz = wyz * xyz
    val xyzMxyz = xyz * xyz
    Bivector(
      wx = (-2.0 * v.xz * wxyMxyz - v.wx * xyzMxyz + 2.0 * v.xy * wxzMxyz),
      wy = (-2.0 * v.yz * wxyMxyz - v.wy * xyzMxyz + 2.0 * v.xy * wyzMxyz),
      wz = (-2.0 * v.yz * wxzMxyz - v.wz * xyzMxyz + 2.0 * v.xz * wyzMxyz),
      xy = v.xy * xyzMxyz,
      xz = v.xz * xyzMxyz,
      yz = v.yz * xyzMxyz,
    )

  infix def reverseSandwich(v: Point): Point =
    val xyzMxyz = xyz * xyz
    Point(
      wxy = (-v.wxy * xyzMxyz + 2.0 * v.xyz * wxy * xyz),
      wxz = (-v.wxz * xyzMxyz + 2.0 * v.xyz * wxz * xyz),
      wyz = (-v.wyz * xyzMxyz + 2.0 * v.xyz * wyz * xyz),
      xyz = v.xyz * xyzMxyz,
    )

  infix def reverseSandwich(v: Quaternion): Motor =
    val wxyMxyz = wxy * xyz
    val wxzMxyz = wxz * xyz
    val wyzMxyz = wyz * xyz
    val xyzMxyz = xyz * xyz
    Motor(
      s = v.s * xyzMxyz,
      wx = (-2.0 * v.xz * wxyMxyz + 2.0 * v.xy * wxzMxyz),
      wy = (-2.0 * v.yz * wxyMxyz + 2.0 * v.xy * wyzMxyz),
      wz = (-2.0 * v.yz * wxzMxyz + 2.0 * v.xz * wyzMxyz),
      xy = v.xy * xyzMxyz,
      xz = v.xz * xyzMxyz,
      yz = v.yz * xyzMxyz,
      i = 0.0,
    )

  infix def reverseSandwich(v: QuaternionDual): QuaternionDual =
    val xyzMxyz = xyz * xyz
    QuaternionDual(
      wx = -v.wx * xyzMxyz,
      wy = -v.wy * xyzMxyz,
      wz = -v.wz * xyzMxyz,
      i = -v.i * xyzMxyz,
    )

  infix def reverseSandwich(v: PointIdeal): PointIdeal =
    val xyzMxyz = xyz * xyz
    PointIdeal(
      wxy = -v.wxy * xyzMxyz,
      wxz = -v.wxz * xyzMxyz,
      wyz = -v.wyz * xyzMxyz,
    )

  infix def reverseSandwich(v: PointNormalized): Point =
    val xyzMxyz = xyz * xyz
    Point(
      wxy = (-v.wxy * xyzMxyz + 2.0 * wxy * xyz),
      wxz = (-v.wxz * xyzMxyz + 2.0 * wxz * xyz),
      wyz = (-v.wyz * xyzMxyz + 2.0 * wyz * xyz),
      xyz = xyzMxyz,
    )

  infix def reverseSandwich(v: PlaneIdeal): Plane =
    val xyzMxyz = xyz * xyz
    Plane(
      w = xyz * (-2.0 * v.y * wxz + 2.0 * v.x * wyz + 2.0 * v.z * wxy),
      x = v.x * xyzMxyz,
      y = v.y * xyzMxyz,
      z = v.z * xyzMxyz,
    )

  infix def reverseSandwich(v: BivectorBulk): Bivector =
    val wxyMxyz = wxy * xyz
    val wxzMxyz = wxz * xyz
    val wyzMxyz = wyz * xyz
    val xyzMxyz = xyz * xyz
    Bivector(
      wx = (-2.0 * v.xz * wxyMxyz + 2.0 * v.xy * wxzMxyz),
      wy = (-2.0 * v.yz * wxyMxyz + 2.0 * v.xy * wyzMxyz),
      wz = (-2.0 * v.yz * wxzMxyz + 2.0 * v.xz * wyzMxyz),
      xy = v.xy * xyzMxyz,
      xz = v.xz * xyzMxyz,
      yz = v.yz * xyzMxyz,
    )

  infix def reverseSandwich(v: BivectorWeight): BivectorWeight =
    val xyzMxyz = xyz * xyz
    BivectorWeight(
      wx = -v.wx * xyzMxyz,
      wy = -v.wy * xyzMxyz,
      wz = -v.wz * xyzMxyz,
    )

  infix def reverseSandwich(v: PseudoScalar): PseudoScalar =
    PseudoScalar(
      i = -v.i * xyz * xyz,
    )

  infix def reverseSandwich(v: PointCenter.type): Point =
    Point(
      wxy = 2.0 * wxy * xyz,
      wxz = 2.0 * wxz * xyz,
      wyz = 2.0 * wyz * xyz,
      xyz = xyz * xyz,
    )

  infix def cross(v: Multivector): Multivector =
    Multivector(
      s = 0.0,
      w = v.i * xyz,
      x = 0.0,
      y = 0.0,
      z = 0.0,
      wx = (v.wyz * xyz - v.xyz * wyz),
      wy = (v.xyz * wxz - v.wxz * xyz),
      wz = (v.wxy * xyz - v.xyz * wxy),
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
      wxy = (v.xz * wyz - v.wz * xyz - v.yz * wxz),
      wxz = (v.wy * xyz + v.yz * wxy - v.xy * wyz),
      wyz = (v.xy * wxz - v.wx * xyz - v.xz * wxy),
      xyz = 0.0,
      i = (v.x * wyz + v.z * wxy - v.w * xyz - v.y * wxz),
    )

  infix def cross(v: Motor): Multivector =
    Multivector(
      s = 0.0,
      w = v.i * xyz,
      x = 0.0,
      y = 0.0,
      z = 0.0,
      wx = 0.0,
      wy = 0.0,
      wz = 0.0,
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
      wxy = (v.xz * wyz - v.wz * xyz - v.yz * wxz),
      wxz = (v.wy * xyz + v.yz * wxy - v.xy * wyz),
      wyz = (v.xy * wxz - v.wx * xyz - v.xz * wxy),
      xyz = 0.0,
      i = 0.0,
    )

  infix def cross(v: Plane): PseudoScalar =
    PseudoScalar(
      i = (v.x * wyz + v.z * wxy - v.w * xyz - v.y * wxz),
    )

  infix def cross(v: Bivector): PointIdeal =
    PointIdeal(
      wxy = (v.xz * wyz - v.wz * xyz - v.yz * wxz),
      wxz = (v.wy * xyz + v.yz * wxy - v.xy * wyz),
      wyz = (v.xy * wxz - v.wx * xyz - v.xz * wxy),
    )

  infix def cross(v: Point): BivectorWeight =
    BivectorWeight(
      wx = (v.wyz * xyz - v.xyz * wyz),
      wy = (v.xyz * wxz - v.wxz * xyz),
      wz = (v.wxy * xyz - v.xyz * wxy),
    )

  infix def cross(v: Quaternion): PointIdeal =
    PointIdeal(
      wxy = (v.xz * wyz - v.yz * wxz),
      wxz = (v.yz * wxy - v.xy * wyz),
      wyz = (v.xy * wxz - v.xz * wxy),
    )

  infix def cross(v: QuaternionDual): Multivector =
    Multivector(
      s = 0.0,
      w = v.i * xyz,
      x = 0.0,
      y = 0.0,
      z = 0.0,
      wx = 0.0,
      wy = 0.0,
      wz = 0.0,
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
      wxy = -v.wz * xyz,
      wxz = v.wy * xyz,
      wyz = -v.wx * xyz,
      xyz = 0.0,
      i = 0.0,
    )

  infix def cross(v: PointIdeal): BivectorWeight =
    BivectorWeight(
      wx = v.wyz * xyz,
      wy = -v.wxz * xyz,
      wz = v.wxy * xyz,
    )

  infix def cross(v: PointNormalized): BivectorWeight =
    BivectorWeight(
      wx = (-wyz + v.wyz * xyz),
      wy = (wxz - v.wxz * xyz),
      wz = (-wxy + v.wxy * xyz),
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

  infix def cross(v: BivectorWeight): PointIdeal =
    PointIdeal(
      wxy = -v.wz * xyz,
      wxz = v.wy * xyz,
      wyz = -v.wx * xyz,
    )

  infix def cross(v: PseudoScalar): Plane =
    Plane(
      w = v.i * xyz,
      x = 0.0,
      y = 0.0,
      z = 0.0,
    )

  infix def cross(v: PointCenter.type): BivectorWeight =
    BivectorWeight(
      wx = -wyz,
      wy = wxz,
      wz = -wxy,
    )