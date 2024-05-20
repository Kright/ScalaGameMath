package com.github.kright.pga3d

/** this code is generated, see com.github.kright.pga3d.codegen.MultivectorSubClass */
case class PointNormalized(
                            wxy: Double = 0.0,
                            wxz: Double = 0.0,
                            wyz: Double = 0.0,
                          ):
  inline val xyz = 1.0

  def dual: Plane =
    Plane(
      w = 1.0,
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

  def bulk: PointNormalized =
    PointNormalized(
      wxy = 0.0,
      wxz = 0.0,
      wyz = 0.0,
    )

  def reverse: Point =
    Point(
      wxy = -wxy,
      wxz = -wxz,
      wyz = -wyz,
      xyz = -1.0,
    )

  def antiReverse: PointNormalized =
    this

  def unary_ : Point =
    Point(
      wxy = -wxy,
      wxz = -wxz,
      wyz = -wyz,
      xyz = -1.0,
    )

  def bulkNormSquare: Double =
    1.0

  def weightNormSquare: Double =
    (wxy * wxy + wxz * wxz + wyz * wyz)

  def normSquare: Double =
    (1.0 + wxy * wxy + wxz * wxz + wyz * wyz)

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
      xyz = v,
    )

  inline def /(v: Double): Point =
    this * (1.0 / v)

  def +(v: PointNormalized): PointNormalized =
    PointNormalized(
      wxy = (v.wxy + wxy),
      wxz = (v.wxz + wxz),
      wyz = (v.wyz + wyz),
    )

  def -(v: PointNormalized): PointNormalized =
    PointNormalized(
      wxy = (wxy - v.wxy),
      wxz = (wxz - v.wxz),
      wyz = (wyz - v.wyz),
    )

  def madd(v: PointNormalized, mult: Double): PointNormalized =
    PointNormalized(
      wxy = (wxy + mult * v.wxy),
      wxz = (wxz + mult * v.wxz),
      wyz = (wyz + mult * v.wyz),
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
      xyz = 1.0,
      i = 0.0,
    )

  def toPoint: Point =
    Point(
      wxy = wxy,
      wxz = wxz,
      wyz = wyz,
      xyz = 1.0,
    )

  infix def multiplyElementwise(v: Multivector): Point =
    Point(
      wxy = v.wxy * wxy,
      wxz = v.wxz * wxz,
      wyz = v.wyz * wyz,
      xyz = v.xyz,
    )

  infix def multiplyElementwise(v: Point): Point =
    Point(
      wxy = v.wxy * wxy,
      wxz = v.wxz * wxz,
      wyz = v.wyz * wyz,
      xyz = v.xyz,
    )

  infix def multiplyElementwise(v: PointIdeal): PointIdeal =
    PointIdeal(
      wxy = v.wxy * wxy,
      wxz = v.wxz * wxz,
      wyz = v.wyz * wyz,
    )

  infix def multiplyElementwise(v: PointNormalized): PointNormalized =
    PointNormalized(
      wxy = v.wxy * wxy,
      wxz = v.wxz * wxz,
      wyz = v.wyz * wyz,
    )

  infix def multiplyElementwise(v: PointCenter.type): PointCenter.type =
    PointCenter

  infix def geometric(v: Multivector): Multivector =
    Multivector(
      s = -v.xyz,
      w = (v.i - v.xy * wxy - v.xz * wxz - v.yz * wyz),
      x = -v.yz,
      y = v.xz,
      z = -v.xy,
      wx = (v.wyz + v.y * wxy + v.z * wxz - v.xyz * wyz),
      wy = (-v.wxz + v.xyz * wxz + v.z * wyz - v.x * wxy),
      wz = (v.wxy - v.x * wxz - v.xyz * wxy - v.y * wyz),
      xy = v.z,
      xz = -v.y,
      yz = v.x,
      wxy = (-v.wz + v.s * wxy + v.xz * wyz - v.yz * wxz),
      wxz = (v.wy + v.s * wxz + v.yz * wxy - v.xy * wyz),
      wyz = (-v.wx + v.s * wyz + v.xy * wxz - v.xz * wxy),
      xyz = v.s,
      i = (-v.w + v.x * wyz + v.z * wxy - v.y * wxz),
    )

  infix def geometric(v: Motor): Multivector =
    Multivector(
      s = 0.0,
      w = (v.i - v.xy * wxy - v.xz * wxz - v.yz * wyz),
      x = -v.yz,
      y = v.xz,
      z = -v.xy,
      wx = 0.0,
      wy = 0.0,
      wz = 0.0,
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
      wxy = (-v.wz + v.s * wxy + v.xz * wyz - v.yz * wxz),
      wxz = (v.wy + v.s * wxz + v.yz * wxy - v.xy * wyz),
      wyz = (-v.wx + v.s * wyz + v.xy * wxz - v.xz * wxy),
      xyz = v.s,
      i = 0.0,
    )

  infix def geometric(v: Plane): Motor =
    Motor(
      s = 0.0,
      wx = (v.y * wxy + v.z * wxz),
      wy = (v.z * wyz - v.x * wxy),
      wz = (-v.x * wxz - v.y * wyz),
      xy = v.z,
      xz = -v.y,
      yz = v.x,
      i = (-v.w + v.x * wyz + v.z * wxy - v.y * wxz),
    )

  infix def geometric(v: Bivector): Multivector =
    Multivector(
      s = 0.0,
      w = (-v.xy * wxy - v.xz * wxz - v.yz * wyz),
      x = -v.yz,
      y = v.xz,
      z = -v.xy,
      wx = 0.0,
      wy = 0.0,
      wz = 0.0,
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
      wxy = (-v.wz + v.xz * wyz - v.yz * wxz),
      wxz = (v.wy + v.yz * wxy - v.xy * wyz),
      wyz = (-v.wx + v.xy * wxz - v.xz * wxy),
      xyz = 0.0,
      i = 0.0,
    )

  infix def geometric(v: Point): Motor =
    Motor(
      s = -v.xyz,
      wx = (v.wyz - v.xyz * wyz),
      wy = (-v.wxz + v.xyz * wxz),
      wz = (v.wxy - v.xyz * wxy),
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
      i = 0.0,
    )

  infix def geometric(v: Quaternion): Multivector =
    Multivector(
      s = 0.0,
      w = (-v.xy * wxy - v.xz * wxz - v.yz * wyz),
      x = -v.yz,
      y = v.xz,
      z = -v.xy,
      wx = 0.0,
      wy = 0.0,
      wz = 0.0,
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
      wxy = (v.s * wxy + v.xz * wyz - v.yz * wxz),
      wxz = (v.s * wxz + v.yz * wxy - v.xy * wyz),
      wyz = (v.s * wyz + v.xy * wxz - v.xz * wxy),
      xyz = v.s,
      i = 0.0,
    )

  infix def geometric(v: QuaternionDual): Multivector =
    Multivector(
      s = 0.0,
      w = v.i,
      x = 0.0,
      y = 0.0,
      z = 0.0,
      wx = 0.0,
      wy = 0.0,
      wz = 0.0,
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
      wxy = -v.wz,
      wxz = v.wy,
      wyz = -v.wx,
      xyz = 0.0,
      i = 0.0,
    )

  infix def geometric(v: PointIdeal): QuaternionDual =
    QuaternionDual(
      wx = v.wyz,
      wy = -v.wxz,
      wz = v.wxy,
      i = 0.0,
    )

  infix def geometric(v: PointNormalized): Motor =
    Motor(
      s = -1.0,
      wx = (v.wyz - wyz),
      wy = (wxz - v.wxz),
      wz = (v.wxy - wxy),
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
      xy = v.z,
      xz = -v.y,
      yz = v.x,
      i = (v.x * wyz + v.z * wxy - v.y * wxz),
    )

  infix def geometric(v: PseudoScalar): Plane =
    Plane(
      w = v.i,
      x = 0.0,
      y = 0.0,
      z = 0.0,
    )

  infix def geometric(v: PointCenter.type): Motor =
    Motor(
      s = -1.0,
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
      s = -v.xyz,
      w = (v.i - v.xy * wxy - v.xz * wxz - v.yz * wyz),
      x = -v.yz,
      y = v.xz,
      z = -v.xy,
      wx = (v.y * wxy + v.z * wxz),
      wy = (v.z * wyz - v.x * wxy),
      wz = (-v.x * wxz - v.y * wyz),
      xy = v.z,
      xz = -v.y,
      yz = v.x,
      wxy = v.s * wxy,
      wxz = v.s * wxz,
      wyz = v.s * wyz,
      xyz = v.s,
      i = 0.0,
    )

  infix def dot(v: Motor): Multivector =
    Multivector(
      s = 0.0,
      w = (v.i - v.xy * wxy - v.xz * wxz - v.yz * wyz),
      x = -v.yz,
      y = v.xz,
      z = -v.xy,
      wx = 0.0,
      wy = 0.0,
      wz = 0.0,
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
      wxy = v.s * wxy,
      wxz = v.s * wxz,
      wyz = v.s * wyz,
      xyz = v.s,
      i = 0.0,
    )

  infix def dot(v: Plane): Bivector =
    Bivector(
      wx = (v.y * wxy + v.z * wxz),
      wy = (v.z * wyz - v.x * wxy),
      wz = (-v.x * wxz - v.y * wyz),
      xy = v.z,
      xz = -v.y,
      yz = v.x,
    )

  infix def dot(v: Bivector): Plane =
    Plane(
      w = (-v.xy * wxy - v.xz * wxz - v.yz * wyz),
      x = -v.yz,
      y = v.xz,
      z = -v.xy,
    )

  infix def dot(v: Point): Double =
    -v.xyz

  infix def dot(v: Quaternion): Multivector =
    Multivector(
      s = 0.0,
      w = (-v.xy * wxy - v.xz * wxz - v.yz * wyz),
      x = -v.yz,
      y = v.xz,
      z = -v.xy,
      wx = 0.0,
      wy = 0.0,
      wz = 0.0,
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
      wxy = v.s * wxy,
      wxz = v.s * wxz,
      wyz = v.s * wyz,
      xyz = v.s,
      i = 0.0,
    )

  infix def dot(v: QuaternionDual): Plane =
    Plane(
      w = v.i,
      x = 0.0,
      y = 0.0,
      z = 0.0,
    )

  infix def dot(v: PointNormalized): Double =
    -1.0

  infix def dot(v: PlaneIdeal): Bivector =
    Bivector(
      wx = (v.y * wxy + v.z * wxz),
      wy = (v.z * wyz - v.x * wxy),
      wz = (-v.x * wxz - v.y * wyz),
      xy = v.z,
      xz = -v.y,
      yz = v.x,
    )

  infix def dot(v: PseudoScalar): Plane =
    Plane(
      w = v.i,
      x = 0.0,
      y = 0.0,
      z = 0.0,
    )

  infix def dot(v: PointCenter.type): Double =
    -1.0

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
      xyz = v.s,
      i = (-v.w + v.x * wyz + v.z * wxy - v.y * wxz),
    )

  inline infix def ^(v: Multivector): Multivector = wedge(v)

  infix def wedge(v: Motor): Point =
    Point(
      wxy = v.s * wxy,
      wxz = v.s * wxz,
      wyz = v.s * wyz,
      xyz = v.s,
    )

  inline infix def ^(v: Motor): Point = wedge(v)

  infix def wedge(v: Plane): PseudoScalar =
    PseudoScalar(
      i = (-v.w + v.x * wyz + v.z * wxy - v.y * wxz),
    )

  inline infix def ^(v: Plane): PseudoScalar = wedge(v)

  infix def wedge(v: Quaternion): Point =
    Point(
      wxy = v.s * wxy,
      wxz = v.s * wxz,
      wyz = v.s * wyz,
      xyz = v.s,
    )

  inline infix def ^(v: Quaternion): Point = wedge(v)

  infix def wedge(v: PlaneIdeal): PseudoScalar =
    PseudoScalar(
      i = (v.x * wyz + v.z * wxy - v.y * wxz),
    )

  inline infix def ^(v: PlaneIdeal): PseudoScalar = wedge(v)

  infix def sandwich(v: Multivector): Multivector =
    Multivector(
      s = v.s,
      w = (-v.w - 2.0 * v.y * wxz + 2.0 * v.x * wyz + 2.0 * v.z * wxy),
      x = v.x,
      y = v.y,
      z = v.z,
      wx = (-v.wx - 2.0 * v.xz * wxy + 2.0 * v.xy * wxz),
      wy = (-v.wy - 2.0 * v.yz * wxy + 2.0 * v.xy * wyz),
      wz = (-v.wz - 2.0 * v.yz * wxz + 2.0 * v.xz * wyz),
      xy = v.xy,
      xz = v.xz,
      yz = v.yz,
      wxy = (-v.wxy + 2.0 * v.xyz * wxy),
      wxz = (-v.wxz + 2.0 * v.xyz * wxz),
      wyz = (-v.wyz + 2.0 * v.xyz * wyz),
      xyz = v.xyz,
      i = -v.i,
    )

  infix def sandwich(v: Motor): Motor =
    Motor(
      s = v.s,
      wx = (-v.wx - 2.0 * v.xz * wxy + 2.0 * v.xy * wxz),
      wy = (-v.wy - 2.0 * v.yz * wxy + 2.0 * v.xy * wyz),
      wz = (-v.wz - 2.0 * v.yz * wxz + 2.0 * v.xz * wyz),
      xy = v.xy,
      xz = v.xz,
      yz = v.yz,
      i = -v.i,
    )

  infix def sandwich(v: Plane): Plane =
    Plane(
      w = (-v.w - 2.0 * v.y * wxz + 2.0 * v.x * wyz + 2.0 * v.z * wxy),
      x = v.x,
      y = v.y,
      z = v.z,
    )

  infix def sandwich(v: Bivector): Bivector =
    Bivector(
      wx = (-v.wx - 2.0 * v.xz * wxy + 2.0 * v.xy * wxz),
      wy = (-v.wy - 2.0 * v.yz * wxy + 2.0 * v.xy * wyz),
      wz = (-v.wz - 2.0 * v.yz * wxz + 2.0 * v.xz * wyz),
      xy = v.xy,
      xz = v.xz,
      yz = v.yz,
    )

  infix def sandwich(v: Point): Point =
    Point(
      wxy = (-v.wxy + 2.0 * v.xyz * wxy),
      wxz = (-v.wxz + 2.0 * v.xyz * wxz),
      wyz = (-v.wyz + 2.0 * v.xyz * wyz),
      xyz = v.xyz,
    )

  infix def sandwich(v: Quaternion): Motor =
    Motor(
      s = v.s,
      wx = (-2.0 * v.xz * wxy + 2.0 * v.xy * wxz),
      wy = (-2.0 * v.yz * wxy + 2.0 * v.xy * wyz),
      wz = (-2.0 * v.yz * wxz + 2.0 * v.xz * wyz),
      xy = v.xy,
      xz = v.xz,
      yz = v.yz,
      i = 0.0,
    )

  infix def sandwich(v: QuaternionDual): QuaternionDual =
    QuaternionDual(
      wx = -v.wx,
      wy = -v.wy,
      wz = -v.wz,
      i = -v.i,
    )

  infix def sandwich(v: PointIdeal): PointIdeal =
    PointIdeal(
      wxy = -v.wxy,
      wxz = -v.wxz,
      wyz = -v.wyz,
    )

  infix def sandwich(v: PointNormalized): PointNormalized =
    PointNormalized(
      wxy = (-v.wxy + 2.0 * wxy),
      wxz = (-v.wxz + 2.0 * wxz),
      wyz = (-v.wyz + 2.0 * wyz),
    )

  infix def sandwich(v: PlaneIdeal): Plane =
    Plane(
      w = (-2.0 * v.y * wxz + 2.0 * v.x * wyz + 2.0 * v.z * wxy),
      x = v.x,
      y = v.y,
      z = v.z,
    )

  infix def sandwich(v: PseudoScalar): PseudoScalar =
    PseudoScalar(
      i = -v.i,
    )

  infix def sandwich(v: PointCenter.type): PointNormalized =
    PointNormalized(
      wxy = 2.0 * wxy,
      wxz = 2.0 * wxz,
      wyz = 2.0 * wyz,
    )

  infix def reverseSandwich(v: Multivector): Multivector =
    Multivector(
      s = v.s,
      w = (-v.w - 2.0 * v.y * wxz + 2.0 * v.x * wyz + 2.0 * v.z * wxy),
      x = v.x,
      y = v.y,
      z = v.z,
      wx = (-v.wx - 2.0 * v.xz * wxy + 2.0 * v.xy * wxz),
      wy = (-v.wy - 2.0 * v.yz * wxy + 2.0 * v.xy * wyz),
      wz = (-v.wz - 2.0 * v.yz * wxz + 2.0 * v.xz * wyz),
      xy = v.xy,
      xz = v.xz,
      yz = v.yz,
      wxy = (-v.wxy + 2.0 * v.xyz * wxy),
      wxz = (-v.wxz + 2.0 * v.xyz * wxz),
      wyz = (-v.wyz + 2.0 * v.xyz * wyz),
      xyz = v.xyz,
      i = -v.i,
    )

  infix def reverseSandwich(v: Motor): Motor =
    Motor(
      s = v.s,
      wx = (-v.wx - 2.0 * v.xz * wxy + 2.0 * v.xy * wxz),
      wy = (-v.wy - 2.0 * v.yz * wxy + 2.0 * v.xy * wyz),
      wz = (-v.wz - 2.0 * v.yz * wxz + 2.0 * v.xz * wyz),
      xy = v.xy,
      xz = v.xz,
      yz = v.yz,
      i = -v.i,
    )

  infix def reverseSandwich(v: Plane): Plane =
    Plane(
      w = (-v.w - 2.0 * v.y * wxz + 2.0 * v.x * wyz + 2.0 * v.z * wxy),
      x = v.x,
      y = v.y,
      z = v.z,
    )

  infix def reverseSandwich(v: Bivector): Bivector =
    Bivector(
      wx = (-v.wx - 2.0 * v.xz * wxy + 2.0 * v.xy * wxz),
      wy = (-v.wy - 2.0 * v.yz * wxy + 2.0 * v.xy * wyz),
      wz = (-v.wz - 2.0 * v.yz * wxz + 2.0 * v.xz * wyz),
      xy = v.xy,
      xz = v.xz,
      yz = v.yz,
    )

  infix def reverseSandwich(v: Point): Point =
    Point(
      wxy = (-v.wxy + 2.0 * v.xyz * wxy),
      wxz = (-v.wxz + 2.0 * v.xyz * wxz),
      wyz = (-v.wyz + 2.0 * v.xyz * wyz),
      xyz = v.xyz,
    )

  infix def reverseSandwich(v: Quaternion): Motor =
    Motor(
      s = v.s,
      wx = (-2.0 * v.xz * wxy + 2.0 * v.xy * wxz),
      wy = (-2.0 * v.yz * wxy + 2.0 * v.xy * wyz),
      wz = (-2.0 * v.yz * wxz + 2.0 * v.xz * wyz),
      xy = v.xy,
      xz = v.xz,
      yz = v.yz,
      i = 0.0,
    )

  infix def reverseSandwich(v: QuaternionDual): QuaternionDual =
    QuaternionDual(
      wx = -v.wx,
      wy = -v.wy,
      wz = -v.wz,
      i = -v.i,
    )

  infix def reverseSandwich(v: PointIdeal): PointIdeal =
    PointIdeal(
      wxy = -v.wxy,
      wxz = -v.wxz,
      wyz = -v.wyz,
    )

  infix def reverseSandwich(v: PointNormalized): PointNormalized =
    PointNormalized(
      wxy = (-v.wxy + 2.0 * wxy),
      wxz = (-v.wxz + 2.0 * wxz),
      wyz = (-v.wyz + 2.0 * wyz),
    )

  infix def reverseSandwich(v: PlaneIdeal): Plane =
    Plane(
      w = (-2.0 * v.y * wxz + 2.0 * v.x * wyz + 2.0 * v.z * wxy),
      x = v.x,
      y = v.y,
      z = v.z,
    )

  infix def reverseSandwich(v: PseudoScalar): PseudoScalar =
    PseudoScalar(
      i = -v.i,
    )

  infix def reverseSandwich(v: PointCenter.type): PointNormalized =
    PointNormalized(
      wxy = 2.0 * wxy,
      wxz = 2.0 * wxz,
      wyz = 2.0 * wyz,
    )

  infix def cross(v: Multivector): Multivector =
    Multivector(
      s = 0.0,
      w = v.i,
      x = 0.0,
      y = 0.0,
      z = 0.0,
      wx = (v.wyz - v.xyz * wyz),
      wy = (-v.wxz + v.xyz * wxz),
      wz = (v.wxy - v.xyz * wxy),
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
      wxy = (-v.wz + v.xz * wyz - v.yz * wxz),
      wxz = (v.wy + v.yz * wxy - v.xy * wyz),
      wyz = (-v.wx + v.xy * wxz - v.xz * wxy),
      xyz = 0.0,
      i = (-v.w + v.x * wyz + v.z * wxy - v.y * wxz),
    )

  infix def cross(v: Motor): Multivector =
    Multivector(
      s = 0.0,
      w = v.i,
      x = 0.0,
      y = 0.0,
      z = 0.0,
      wx = 0.0,
      wy = 0.0,
      wz = 0.0,
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
      wxy = (-v.wz + v.xz * wyz - v.yz * wxz),
      wxz = (v.wy + v.yz * wxy - v.xy * wyz),
      wyz = (-v.wx + v.xy * wxz - v.xz * wxy),
      xyz = 0.0,
      i = 0.0,
    )

  infix def cross(v: Plane): PseudoScalar =
    PseudoScalar(
      i = (-v.w + v.x * wyz + v.z * wxy - v.y * wxz),
    )

  infix def cross(v: Bivector): PointIdeal =
    PointIdeal(
      wxy = (-v.wz + v.xz * wyz - v.yz * wxz),
      wxz = (v.wy + v.yz * wxy - v.xy * wyz),
      wyz = (-v.wx + v.xy * wxz - v.xz * wxy),
    )

  infix def cross(v: Point): QuaternionDual =
    QuaternionDual(
      wx = (v.wyz - v.xyz * wyz),
      wy = (-v.wxz + v.xyz * wxz),
      wz = (v.wxy - v.xyz * wxy),
      i = 0.0,
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
      w = v.i,
      x = 0.0,
      y = 0.0,
      z = 0.0,
      wx = 0.0,
      wy = 0.0,
      wz = 0.0,
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
      wxy = -v.wz,
      wxz = v.wy,
      wyz = -v.wx,
      xyz = 0.0,
      i = 0.0,
    )

  infix def cross(v: PointIdeal): QuaternionDual =
    QuaternionDual(
      wx = v.wyz,
      wy = -v.wxz,
      wz = v.wxy,
      i = 0.0,
    )

  infix def cross(v: PointNormalized): QuaternionDual =
    QuaternionDual(
      wx = (v.wyz - wyz),
      wy = (wxz - v.wxz),
      wz = (v.wxy - wxy),
      i = 0.0,
    )

  infix def cross(v: PlaneIdeal): PseudoScalar =
    PseudoScalar(
      i = (v.x * wyz + v.z * wxy - v.y * wxz),
    )

  infix def cross(v: PseudoScalar): Plane =
    Plane(
      w = v.i,
      x = 0.0,
      y = 0.0,
      z = 0.0,
    )

  infix def cross(v: PointCenter.type): QuaternionDual =
    QuaternionDual(
      wx = -wyz,
      wy = wxz,
      wz = -wxy,
      i = 0.0,
    )

  infix def antiGeometric(v: Multivector): Multivector =
    Multivector(
      s = (v.w + v.y * wxz - v.x * wyz - v.z * wxy),
      w = (v.wy * wxz - v.wx * wyz - v.wz * wxy),
      x = (-v.wx + v.xy * wxz - v.s * wyz - v.xz * wxy),
      y = (-v.wy + v.s * wxz + v.xy * wyz - v.yz * wxy),
      z = (-v.wz + v.xz * wyz - v.s * wxy - v.yz * wxz),
      wx = (v.wxz * wxy - v.w * wyz - v.wxy * wxz),
      wy = (v.w * wxz + v.wyz * wxy - v.wxy * wyz),
      wz = (v.wyz * wxz - v.w * wxy - v.wxz * wyz),
      xy = (-v.wxy + v.x * wxz + v.xyz * wxy + v.y * wyz),
      xz = (-v.wxz + v.xyz * wxz + v.z * wyz - v.x * wxy),
      yz = (-v.wyz + v.xyz * wyz - v.y * wxy - v.z * wxz),
      wxy = (v.i * wxy - v.wx * wxz - v.wy * wyz),
      wxz = (v.i * wxz + v.wx * wxy - v.wz * wyz),
      wyz = (v.i * wyz + v.wy * wxy + v.wz * wxz),
      xyz = (v.i + v.xy * wxy + v.xz * wxz + v.yz * wyz),
      i = (v.wxy * wxy + v.wxz * wxz + v.wyz * wyz),
    )

  infix def antiGeometric(v: Motor): Multivector =
    Multivector(
      s = 0.0,
      w = (v.wy * wxz - v.wx * wyz - v.wz * wxy),
      x = (-v.wx + v.xy * wxz - v.s * wyz - v.xz * wxy),
      y = (-v.wy + v.s * wxz + v.xy * wyz - v.yz * wxy),
      z = (-v.wz + v.xz * wyz - v.s * wxy - v.yz * wxz),
      wx = 0.0,
      wy = 0.0,
      wz = 0.0,
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
      wxy = (v.i * wxy - v.wx * wxz - v.wy * wyz),
      wxz = (v.i * wxz + v.wx * wxy - v.wz * wyz),
      wyz = (v.i * wyz + v.wy * wxy + v.wz * wxz),
      xyz = (v.i + v.xy * wxy + v.xz * wxz + v.yz * wyz),
      i = 0.0,
    )

  infix def antiGeometric(v: Plane): Motor =
    Motor(
      s = (v.w + v.y * wxz - v.x * wyz - v.z * wxy),
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
      x = (-v.wx + v.xy * wxz - v.xz * wxy),
      y = (-v.wy + v.xy * wyz - v.yz * wxy),
      z = (-v.wz + v.xz * wyz - v.yz * wxz),
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
      xy = (-v.wxy + v.xyz * wxy),
      xz = (-v.wxz + v.xyz * wxz),
      yz = (-v.wyz + v.xyz * wyz),
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
      x = -v.wx,
      y = -v.wy,
      z = -v.wz,
      wx = 0.0,
      wy = 0.0,
      wz = 0.0,
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
      wxy = (v.i * wxy - v.wx * wxz - v.wy * wyz),
      wxz = (v.i * wxz + v.wx * wxy - v.wz * wyz),
      wyz = (v.i * wyz + v.wy * wxy + v.wz * wxz),
      xyz = v.i,
      i = 0.0,
    )

  infix def antiGeometric(v: PointIdeal): Motor =
    Motor(
      s = 0.0,
      wx = (v.wxz * wxy - v.wxy * wxz),
      wy = (v.wyz * wxy - v.wxy * wyz),
      wz = (v.wyz * wxz - v.wxz * wyz),
      xy = -v.wxy,
      xz = -v.wxz,
      yz = -v.wyz,
      i = (v.wxy * wxy + v.wxz * wxz + v.wyz * wyz),
    )

  infix def antiGeometric(v: PointNormalized): Motor =
    Motor(
      s = 0.0,
      wx = (v.wxz * wxy - v.wxy * wxz),
      wy = (v.wyz * wxy - v.wxy * wyz),
      wz = (v.wyz * wxz - v.wxz * wyz),
      xy = (wxy - v.wxy),
      xz = (wxz - v.wxz),
      yz = (wyz - v.wyz),
      i = (v.wxy * wxy + v.wxz * wxz + v.wyz * wyz),
    )

  infix def antiGeometric(v: PlaneIdeal): Quaternion =
    Quaternion(
      s = (v.y * wxz - v.x * wyz - v.z * wxy),
      xy = (v.x * wxz + v.y * wyz),
      xz = (v.z * wyz - v.x * wxy),
      yz = (-v.y * wxy - v.z * wxz),
    )

  infix def antiGeometric(v: PseudoScalar): Point =
    Point(
      wxy = v.i * wxy,
      wxz = v.i * wxz,
      wyz = v.i * wyz,
      xyz = v.i,
    )

  infix def antiGeometric(v: PointCenter.type): Quaternion =
    Quaternion(
      s = 0.0,
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
      xyz = (v.i + v.xy * wxy + v.xz * wxz + v.yz * wyz),
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
      xyz = (v.i + v.xy * wxy + v.xz * wxz + v.yz * wyz),
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
      xyz = v.i,
    )

  infix def antiDot(v: PointIdeal): PseudoScalar =
    PseudoScalar(
      i = (v.wxy * wxy + v.wxz * wxz + v.wyz * wyz),
    )

  infix def antiDot(v: PointNormalized): PseudoScalar =
    PseudoScalar(
      i = (v.wxy * wxy + v.wxz * wxz + v.wyz * wyz),
    )

  infix def antiDot(v: PlaneIdeal): Quaternion =
    Quaternion(
      s = 0.0,
      xy = (v.x * wxz + v.y * wyz),
      xz = (v.z * wyz - v.x * wxy),
      yz = (-v.y * wxy - v.z * wxz),
    )

  infix def antiDot(v: PseudoScalar): Point =
    Point(
      wxy = v.i * wxy,
      wxz = v.i * wxz,
      wyz = v.i * wyz,
      xyz = v.i,
    )

  infix def antiWedge(v: Multivector): Multivector =
    Multivector(
      s = (v.w + v.y * wxz - v.x * wyz - v.z * wxy),
      w = (v.wy * wxz - v.wx * wyz - v.wz * wxy),
      x = (-v.wx + v.xy * wxz - v.xz * wxy),
      y = (-v.wy + v.xy * wyz - v.yz * wxy),
      z = (-v.wz + v.xz * wyz - v.yz * wxz),
      wx = (v.wxz * wxy - v.wxy * wxz),
      wy = (v.wyz * wxy - v.wxy * wyz),
      wz = (v.wyz * wxz - v.wxz * wyz),
      xy = (-v.wxy + v.xyz * wxy),
      xz = (-v.wxz + v.xyz * wxz),
      yz = (-v.wyz + v.xyz * wyz),
      wxy = v.i * wxy,
      wxz = v.i * wxz,
      wyz = v.i * wyz,
      xyz = v.i,
      i = 0.0,
    )

  inline infix def v(v: Multivector): Multivector = antiWedge(v)

  infix def antiWedge(v: Motor): Multivector =
    Multivector(
      s = 0.0,
      w = (v.wy * wxz - v.wx * wyz - v.wz * wxy),
      x = (-v.wx + v.xy * wxz - v.xz * wxy),
      y = (-v.wy + v.xy * wyz - v.yz * wxy),
      z = (-v.wz + v.xz * wyz - v.yz * wxz),
      wx = 0.0,
      wy = 0.0,
      wz = 0.0,
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
      wxy = v.i * wxy,
      wxz = v.i * wxz,
      wyz = v.i * wyz,
      xyz = v.i,
      i = 0.0,
    )

  inline infix def v(v: Motor): Multivector = antiWedge(v)

  infix def antiWedge(v: Plane): Double =
    (v.w + v.y * wxz - v.x * wyz - v.z * wxy)

  inline infix def v(v: Plane): Double = antiWedge(v)

  infix def antiWedge(v: Bivector): Plane =
    Plane(
      w = (v.wy * wxz - v.wx * wyz - v.wz * wxy),
      x = (-v.wx + v.xy * wxz - v.xz * wxy),
      y = (-v.wy + v.xy * wyz - v.yz * wxy),
      z = (-v.wz + v.xz * wyz - v.yz * wxz),
    )

  inline infix def v(v: Bivector): Plane = antiWedge(v)

  infix def antiWedge(v: Point): Bivector =
    Bivector(
      wx = (v.wxz * wxy - v.wxy * wxz),
      wy = (v.wyz * wxy - v.wxy * wyz),
      wz = (v.wyz * wxz - v.wxz * wyz),
      xy = (-v.wxy + v.xyz * wxy),
      xz = (-v.wxz + v.xyz * wxz),
      yz = (-v.wyz + v.xyz * wyz),
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
      x = -v.wx,
      y = -v.wy,
      z = -v.wz,
      wx = 0.0,
      wy = 0.0,
      wz = 0.0,
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
      wxy = v.i * wxy,
      wxz = v.i * wxz,
      wyz = v.i * wyz,
      xyz = v.i,
      i = 0.0,
    )

  inline infix def v(v: QuaternionDual): Multivector = antiWedge(v)

  infix def antiWedge(v: PointIdeal): Bivector =
    Bivector(
      wx = (v.wxz * wxy - v.wxy * wxz),
      wy = (v.wyz * wxy - v.wxy * wyz),
      wz = (v.wyz * wxz - v.wxz * wyz),
      xy = -v.wxy,
      xz = -v.wxz,
      yz = -v.wyz,
    )

  inline infix def v(v: PointIdeal): Bivector = antiWedge(v)

  infix def antiWedge(v: PointNormalized): Bivector =
    Bivector(
      wx = (v.wxz * wxy - v.wxy * wxz),
      wy = (v.wyz * wxy - v.wxy * wyz),
      wz = (v.wyz * wxz - v.wxz * wyz),
      xy = (wxy - v.wxy),
      xz = (wxz - v.wxz),
      yz = (wyz - v.wyz),
    )

  inline infix def v(v: PointNormalized): Bivector = antiWedge(v)

  infix def antiWedge(v: PlaneIdeal): Double =
    (v.y * wxz - v.x * wyz - v.z * wxy)

  inline infix def v(v: PlaneIdeal): Double = antiWedge(v)

  infix def antiWedge(v: PseudoScalar): Point =
    Point(
      wxy = v.i * wxy,
      wxz = v.i * wxz,
      wyz = v.i * wyz,
      xyz = v.i,
    )

  inline infix def v(v: PseudoScalar): Point = antiWedge(v)

  infix def antiWedge(v: PointCenter.type): Quaternion =
    Quaternion(
      s = 0.0,
      xy = wxy,
      xz = wxz,
      yz = wyz,
    )

  inline infix def v(v: PointCenter.type): Quaternion = antiWedge(v)