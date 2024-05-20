package com.github.kright.pga3d

/** this code is generated, see com.github.kright.pga3d.codegen.MultivectorSubClass */
case class PseudoScalar(
                         i: Double = 0.0,
                       ):

  def dual: Double =
    i

  def weight: PseudoScalar =
    this

  def reverse: PseudoScalar =
    this

  def antiReverse: PseudoScalar =
    this

  def unary_ : PseudoScalar =
    PseudoScalar(
      i = -i,
    )

  def weightNormSquare: Double =
    i * i

  def normSquare: Double =
    i * i

  def weightNorm: Double =
    Math.sqrt(weightNormSquare)

  def normalizedByWeight =
    this / weightNorm

  def norm: Double =
    Math.sqrt(normSquare)

  def normalizedByNorm =
    this / norm

  def *(v: Double): PseudoScalar =
    PseudoScalar(
      i = i * v,
    )

  inline def /(v: Double): PseudoScalar =
    this * (1.0 / v)

  def +(v: PseudoScalar): PseudoScalar =
    PseudoScalar(
      i = (i + v.i),
    )

  def -(v: PseudoScalar): PseudoScalar =
    PseudoScalar(
      i = (i - v.i),
    )

  def madd(v: PseudoScalar, mult: Double): PseudoScalar =
    PseudoScalar(
      i = (i + mult * v.i),
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
      wxy = 0.0,
      wxz = 0.0,
      wyz = 0.0,
      xyz = 0.0,
      i = i,
    )

  def toMotor: Motor =
    Motor(
      s = 0.0,
      wx = 0.0,
      wy = 0.0,
      wz = 0.0,
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
      i = i,
    )

  def toQuaternionDual: QuaternionDual =
    QuaternionDual(
      wx = 0.0,
      wy = 0.0,
      wz = 0.0,
      i = i,
    )

  infix def multiplyElementwise(v: Multivector): PseudoScalar =
    PseudoScalar(
      i = i * v.i,
    )

  infix def multiplyElementwise(v: Motor): PseudoScalar =
    PseudoScalar(
      i = i * v.i,
    )

  infix def multiplyElementwise(v: QuaternionDual): PseudoScalar =
    PseudoScalar(
      i = i * v.i,
    )

  infix def multiplyElementwise(v: PseudoScalar): PseudoScalar =
    PseudoScalar(
      i = i * v.i,
    )

  infix def geometric(v: Multivector): Multivector =
    Multivector(
      s = 0.0,
      w = -i * v.xyz,
      x = 0.0,
      y = 0.0,
      z = 0.0,
      wx = -i * v.yz,
      wy = i * v.xz,
      wz = -i * v.xy,
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
      wxy = i * v.z,
      wxz = -i * v.y,
      wyz = i * v.x,
      xyz = 0.0,
      i = i * v.s,
    )

  infix def geometric(v: Motor): QuaternionDual =
    QuaternionDual(
      wx = -i * v.yz,
      wy = i * v.xz,
      wz = -i * v.xy,
      i = i * v.s,
    )

  infix def geometric(v: Plane): PointIdeal =
    PointIdeal(
      wxy = i * v.z,
      wxz = -i * v.y,
      wyz = i * v.x,
    )

  infix def geometric(v: Bivector): QuaternionDual =
    QuaternionDual(
      wx = -i * v.yz,
      wy = i * v.xz,
      wz = -i * v.xy,
      i = 0.0,
    )

  infix def geometric(v: Point): Plane =
    Plane(
      w = -i * v.xyz,
      x = 0.0,
      y = 0.0,
      z = 0.0,
    )

  infix def geometric(v: Quaternion): QuaternionDual =
    QuaternionDual(
      wx = -i * v.yz,
      wy = i * v.xz,
      wz = -i * v.xy,
      i = i * v.s,
    )

  infix def geometric(v: PointNormalized): Plane =
    Plane(
      w = -i,
      x = 0.0,
      y = 0.0,
      z = 0.0,
    )

  infix def geometric(v: PlaneIdeal): PointIdeal =
    PointIdeal(
      wxy = i * v.z,
      wxz = -i * v.y,
      wyz = i * v.x,
    )

  infix def geometric(v: PointCenter.type): Plane =
    Plane(
      w = -i,
      x = 0.0,
      y = 0.0,
      z = 0.0,
    )

  infix def dot(v: Multivector): Multivector =
    Multivector(
      s = 0.0,
      w = -i * v.xyz,
      x = 0.0,
      y = 0.0,
      z = 0.0,
      wx = -i * v.yz,
      wy = i * v.xz,
      wz = -i * v.xy,
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
      wxy = i * v.z,
      wxz = -i * v.y,
      wyz = i * v.x,
      xyz = 0.0,
      i = i * v.s,
    )

  infix def dot(v: Motor): QuaternionDual =
    QuaternionDual(
      wx = -i * v.yz,
      wy = i * v.xz,
      wz = -i * v.xy,
      i = i * v.s,
    )

  infix def dot(v: Plane): PointIdeal =
    PointIdeal(
      wxy = i * v.z,
      wxz = -i * v.y,
      wyz = i * v.x,
    )

  infix def dot(v: Bivector): QuaternionDual =
    QuaternionDual(
      wx = -i * v.yz,
      wy = i * v.xz,
      wz = -i * v.xy,
      i = 0.0,
    )

  infix def dot(v: Point): Plane =
    Plane(
      w = -i * v.xyz,
      x = 0.0,
      y = 0.0,
      z = 0.0,
    )

  infix def dot(v: Quaternion): QuaternionDual =
    QuaternionDual(
      wx = -i * v.yz,
      wy = i * v.xz,
      wz = -i * v.xy,
      i = i * v.s,
    )

  infix def dot(v: PointNormalized): Plane =
    Plane(
      w = -i,
      x = 0.0,
      y = 0.0,
      z = 0.0,
    )

  infix def dot(v: PlaneIdeal): PointIdeal =
    PointIdeal(
      wxy = i * v.z,
      wxz = -i * v.y,
      wyz = i * v.x,
    )

  infix def dot(v: PointCenter.type): Plane =
    Plane(
      w = -i,
      x = 0.0,
      y = 0.0,
      z = 0.0,
    )

  infix def wedge(v: Multivector): PseudoScalar =
    PseudoScalar(
      i = i * v.s,
    )

  inline infix def ^(v: Multivector): PseudoScalar = wedge(v)

  infix def wedge(v: Motor): PseudoScalar =
    PseudoScalar(
      i = i * v.s,
    )

  inline infix def ^(v: Motor): PseudoScalar = wedge(v)

  infix def wedge(v: Quaternion): PseudoScalar =
    PseudoScalar(
      i = i * v.s,
    )

  inline infix def ^(v: Quaternion): PseudoScalar = wedge(v)

  infix def cross(v: Multivector): Multivector =
    Multivector(
      s = 0.0,
      w = -i * v.xyz,
      x = 0.0,
      y = 0.0,
      z = 0.0,
      wx = 0.0,
      wy = 0.0,
      wz = 0.0,
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
      wxy = i * v.z,
      wxz = -i * v.y,
      wyz = i * v.x,
      xyz = 0.0,
      i = 0.0,
    )

  infix def cross(v: Plane): PointIdeal =
    PointIdeal(
      wxy = i * v.z,
      wxz = -i * v.y,
      wyz = i * v.x,
    )

  infix def cross(v: Point): Plane =
    Plane(
      w = -i * v.xyz,
      x = 0.0,
      y = 0.0,
      z = 0.0,
    )

  infix def cross(v: PointNormalized): Plane =
    Plane(
      w = -i,
      x = 0.0,
      y = 0.0,
      z = 0.0,
    )

  infix def cross(v: PlaneIdeal): PointIdeal =
    PointIdeal(
      wxy = i * v.z,
      wxz = -i * v.y,
      wyz = i * v.x,
    )

  infix def cross(v: PointCenter.type): Plane =
    Plane(
      w = -i,
      x = 0.0,
      y = 0.0,
      z = 0.0,
    )

  infix def antiGeometric(v: Multivector): Multivector =
    Multivector(
      s = i * v.s,
      w = i * v.w,
      x = i * v.x,
      y = i * v.y,
      z = i * v.z,
      wx = i * v.wx,
      wy = i * v.wy,
      wz = i * v.wz,
      xy = i * v.xy,
      xz = i * v.xz,
      yz = i * v.yz,
      wxy = i * v.wxy,
      wxz = i * v.wxz,
      wyz = i * v.wyz,
      xyz = i * v.xyz,
      i = i * v.i,
    )

  infix def antiGeometric(v: Motor): Motor =
    Motor(
      s = i * v.s,
      wx = i * v.wx,
      wy = i * v.wy,
      wz = i * v.wz,
      xy = i * v.xy,
      xz = i * v.xz,
      yz = i * v.yz,
      i = i * v.i,
    )

  infix def antiGeometric(v: Plane): Plane =
    Plane(
      w = i * v.w,
      x = i * v.x,
      y = i * v.y,
      z = i * v.z,
    )

  infix def antiGeometric(v: Bivector): Bivector =
    Bivector(
      wx = i * v.wx,
      wy = i * v.wy,
      wz = i * v.wz,
      xy = i * v.xy,
      xz = i * v.xz,
      yz = i * v.yz,
    )

  infix def antiGeometric(v: Point): Point =
    Point(
      wxy = i * v.wxy,
      wxz = i * v.wxz,
      wyz = i * v.wyz,
      xyz = i * v.xyz,
    )

  infix def antiGeometric(v: Quaternion): Quaternion =
    Quaternion(
      s = i * v.s,
      xy = i * v.xy,
      xz = i * v.xz,
      yz = i * v.yz,
    )

  infix def antiGeometric(v: QuaternionDual): QuaternionDual =
    QuaternionDual(
      wx = i * v.wx,
      wy = i * v.wy,
      wz = i * v.wz,
      i = i * v.i,
    )

  infix def antiGeometric(v: PointIdeal): PointIdeal =
    PointIdeal(
      wxy = i * v.wxy,
      wxz = i * v.wxz,
      wyz = i * v.wyz,
    )

  infix def antiGeometric(v: PointNormalized): Point =
    Point(
      wxy = i * v.wxy,
      wxz = i * v.wxz,
      wyz = i * v.wyz,
      xyz = i,
    )

  infix def antiGeometric(v: PlaneIdeal): PlaneIdeal =
    PlaneIdeal(
      x = i * v.x,
      y = i * v.y,
      z = i * v.z,
    )

  infix def antiGeometric(v: PseudoScalar): PseudoScalar =
    PseudoScalar(
      i = i * v.i,
    )

  infix def antiGeometric(v: PointCenter.type): Point =
    Point(
      wxy = 0.0,
      wxz = 0.0,
      wyz = 0.0,
      xyz = i,
    )

  infix def antiDot(v: Multivector): Multivector =
    Multivector(
      s = i * v.s,
      w = i * v.w,
      x = i * v.x,
      y = i * v.y,
      z = i * v.z,
      wx = i * v.wx,
      wy = i * v.wy,
      wz = i * v.wz,
      xy = i * v.xy,
      xz = i * v.xz,
      yz = i * v.yz,
      wxy = i * v.wxy,
      wxz = i * v.wxz,
      wyz = i * v.wyz,
      xyz = i * v.xyz,
      i = i * v.i,
    )

  infix def antiDot(v: Motor): Motor =
    Motor(
      s = i * v.s,
      wx = i * v.wx,
      wy = i * v.wy,
      wz = i * v.wz,
      xy = i * v.xy,
      xz = i * v.xz,
      yz = i * v.yz,
      i = i * v.i,
    )

  infix def antiDot(v: Plane): Plane =
    Plane(
      w = i * v.w,
      x = i * v.x,
      y = i * v.y,
      z = i * v.z,
    )

  infix def antiDot(v: Bivector): Bivector =
    Bivector(
      wx = i * v.wx,
      wy = i * v.wy,
      wz = i * v.wz,
      xy = i * v.xy,
      xz = i * v.xz,
      yz = i * v.yz,
    )

  infix def antiDot(v: Point): Point =
    Point(
      wxy = i * v.wxy,
      wxz = i * v.wxz,
      wyz = i * v.wyz,
      xyz = i * v.xyz,
    )

  infix def antiDot(v: Quaternion): Quaternion =
    Quaternion(
      s = i * v.s,
      xy = i * v.xy,
      xz = i * v.xz,
      yz = i * v.yz,
    )

  infix def antiDot(v: QuaternionDual): QuaternionDual =
    QuaternionDual(
      wx = i * v.wx,
      wy = i * v.wy,
      wz = i * v.wz,
      i = i * v.i,
    )

  infix def antiDot(v: PointIdeal): PointIdeal =
    PointIdeal(
      wxy = i * v.wxy,
      wxz = i * v.wxz,
      wyz = i * v.wyz,
    )

  infix def antiDot(v: PointNormalized): Point =
    Point(
      wxy = i * v.wxy,
      wxz = i * v.wxz,
      wyz = i * v.wyz,
      xyz = i,
    )

  infix def antiDot(v: PlaneIdeal): PlaneIdeal =
    PlaneIdeal(
      x = i * v.x,
      y = i * v.y,
      z = i * v.z,
    )

  infix def antiDot(v: PseudoScalar): PseudoScalar =
    PseudoScalar(
      i = i * v.i,
    )

  infix def antiDot(v: PointCenter.type): Point =
    Point(
      wxy = 0.0,
      wxz = 0.0,
      wyz = 0.0,
      xyz = i,
    )

  infix def antiWedge(v: Multivector): Multivector =
    Multivector(
      s = i * v.s,
      w = i * v.w,
      x = i * v.x,
      y = i * v.y,
      z = i * v.z,
      wx = i * v.wx,
      wy = i * v.wy,
      wz = i * v.wz,
      xy = i * v.xy,
      xz = i * v.xz,
      yz = i * v.yz,
      wxy = i * v.wxy,
      wxz = i * v.wxz,
      wyz = i * v.wyz,
      xyz = i * v.xyz,
      i = i * v.i,
    )

  inline infix def v(v: Multivector): Multivector = antiWedge(v)

  infix def antiWedge(v: Motor): Motor =
    Motor(
      s = i * v.s,
      wx = i * v.wx,
      wy = i * v.wy,
      wz = i * v.wz,
      xy = i * v.xy,
      xz = i * v.xz,
      yz = i * v.yz,
      i = i * v.i,
    )

  inline infix def v(v: Motor): Motor = antiWedge(v)

  infix def antiWedge(v: Plane): Plane =
    Plane(
      w = i * v.w,
      x = i * v.x,
      y = i * v.y,
      z = i * v.z,
    )

  inline infix def v(v: Plane): Plane = antiWedge(v)

  infix def antiWedge(v: Bivector): Bivector =
    Bivector(
      wx = i * v.wx,
      wy = i * v.wy,
      wz = i * v.wz,
      xy = i * v.xy,
      xz = i * v.xz,
      yz = i * v.yz,
    )

  inline infix def v(v: Bivector): Bivector = antiWedge(v)

  infix def antiWedge(v: Point): Point =
    Point(
      wxy = i * v.wxy,
      wxz = i * v.wxz,
      wyz = i * v.wyz,
      xyz = i * v.xyz,
    )

  inline infix def v(v: Point): Point = antiWedge(v)

  infix def antiWedge(v: Quaternion): Quaternion =
    Quaternion(
      s = i * v.s,
      xy = i * v.xy,
      xz = i * v.xz,
      yz = i * v.yz,
    )

  inline infix def v(v: Quaternion): Quaternion = antiWedge(v)

  infix def antiWedge(v: QuaternionDual): QuaternionDual =
    QuaternionDual(
      wx = i * v.wx,
      wy = i * v.wy,
      wz = i * v.wz,
      i = i * v.i,
    )

  inline infix def v(v: QuaternionDual): QuaternionDual = antiWedge(v)

  infix def antiWedge(v: PointIdeal): PointIdeal =
    PointIdeal(
      wxy = i * v.wxy,
      wxz = i * v.wxz,
      wyz = i * v.wyz,
    )

  inline infix def v(v: PointIdeal): PointIdeal = antiWedge(v)

  infix def antiWedge(v: PointNormalized): Point =
    Point(
      wxy = i * v.wxy,
      wxz = i * v.wxz,
      wyz = i * v.wyz,
      xyz = i,
    )

  inline infix def v(v: PointNormalized): Point = antiWedge(v)

  infix def antiWedge(v: PlaneIdeal): PlaneIdeal =
    PlaneIdeal(
      x = i * v.x,
      y = i * v.y,
      z = i * v.z,
    )

  inline infix def v(v: PlaneIdeal): PlaneIdeal = antiWedge(v)

  infix def antiWedge(v: PseudoScalar): PseudoScalar =
    PseudoScalar(
      i = i * v.i,
    )

  inline infix def v(v: PseudoScalar): PseudoScalar = antiWedge(v)

  infix def antiWedge(v: PointCenter.type): Point =
    Point(
      wxy = 0.0,
      wxz = 0.0,
      wyz = 0.0,
      xyz = i,
    )

  inline infix def v(v: PointCenter.type): Point = antiWedge(v)