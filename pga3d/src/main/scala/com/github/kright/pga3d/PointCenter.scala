package com.github.kright.pga3d

/** this code is generated, see com.github.kright.pga3d.codegen.CodeGenClass */
case object PointCenter:
  inline val wxy = 0.0
  inline val wxz = 0.0
  inline val wyz = 0.0
  inline val xyz = 1.0

  inline def dualX: Double = 0.0

  inline def dualW: Double = 1.0

  inline def dualY: Double = 0.0

  inline def dualZ: Double = 0.0

  def dual: Plane =
    Plane(
      w = 1.0,
      x = 0.0,
      y = 0.0,
      z = 0.0,
    )

  def bulk: PointCenter.type =
    PointCenter

  def reverse: Point =
    Point(
      wxy = 0.0,
      wxz = 0.0,
      wyz = 0.0,
      xyz = -1.0,
    )

  def antiReverse: PointCenter.type =
    this

  def unary_- : Point =
    Point(
      wxy = 0.0,
      wxz = 0.0,
      wyz = 0.0,
      xyz = -1.0,
    )

  def bulkNormSquare: Double =
    1.0

  def normSquare: Double =
    1.0

  def bulkNorm: Double =
    Math.sqrt(bulkNormSquare)

  def normalizedByBulk =
    this / bulkNorm

  def norm: Double =
    Math.sqrt(normSquare)

  def normalizedByNorm =
    this / norm

  def *(v: Double): Point =
    Point(
      wxy = 0.0,
      wxz = 0.0,
      wyz = 0.0,
      xyz = v,
    )

  inline def /(v: Double): Point =
    this * (1.0 / v)

  def +(v: PointCenter.type): Point =
    Point(
      wxy = 0.0,
      wxz = 0.0,
      wyz = 0.0,
      xyz = 2.0,
    )

  def madd(v: PointCenter.type, mult: Double): Point =
    Point(
      wxy = 0.0,
      wxz = 0.0,
      wyz = 0.0,
      xyz = (1.0 + mult),
    )

  def multiplyElementwise(v: PointCenter.type): PointCenter.type =
    PointCenter

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
      xyz = 1.0,
      i = 0.0,
    )

  def toPoint: Point =
    Point(
      wxy = 0.0,
      wxz = 0.0,
      wyz = 0.0,
      xyz = 1.0,
    )

  def toPointNormalized: PointNormalized =
    PointNormalized(
      wxy = 0.0,
      wxz = 0.0,
      wyz = 0.0,
    )

  infix def geometric(v: Multivector): Multivector =
    Multivector(
      s = -v.xyz,
      w = v.i,
      x = -v.yz,
      y = v.xz,
      z = -v.xy,
      wx = v.wyz,
      wy = -v.wxz,
      wz = v.wxy,
      xy = v.z,
      xz = -v.y,
      yz = v.x,
      wxy = -v.wz,
      wxz = v.wy,
      wyz = -v.wx,
      xyz = v.s,
      i = -v.w,
    )

  infix def geometric(v: Motor): Multivector =
    Multivector(
      s = 0.0,
      w = v.i,
      x = -v.yz,
      y = v.xz,
      z = -v.xy,
      wx = 0.0,
      wy = 0.0,
      wz = 0.0,
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
      wxy = -v.wz,
      wxz = v.wy,
      wyz = -v.wx,
      xyz = v.s,
      i = 0.0,
    )

  infix def geometric(v: Plane): Motor =
    Motor(
      s = 0.0,
      wx = 0.0,
      wy = 0.0,
      wz = 0.0,
      xy = v.z,
      xz = -v.y,
      yz = v.x,
      i = -v.w,
    )

  infix def geometric(v: Bivector): Multivector =
    Multivector(
      s = 0.0,
      w = 0.0,
      x = -v.yz,
      y = v.xz,
      z = -v.xy,
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

  infix def geometric(v: Point): Motor =
    Motor(
      s = -v.xyz,
      wx = v.wyz,
      wy = -v.wxz,
      wz = v.wxy,
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
      i = 0.0,
    )

  infix def geometric(v: Quaternion): Multivector =
    Multivector(
      s = 0.0,
      w = 0.0,
      x = -v.yz,
      y = v.xz,
      z = -v.xy,
      wx = 0.0,
      wy = 0.0,
      wz = 0.0,
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
      wxy = 0.0,
      wxz = 0.0,
      wyz = 0.0,
      xyz = v.s,
      i = 0.0,
    )

  infix def geometric(v: Translator): PointNormalized =
    PointNormalized(
      wxy = -v.wz,
      wxz = v.wy,
      wyz = -v.wx,
    )

  infix def geometric(v: Vector): BivectorWeight =
    BivectorWeight(
      wx = v.wyz,
      wy = -v.wxz,
      wz = v.wxy,
    )

  infix def geometric(v: PointNormalized): Motor =
    Motor(
      s = -1.0,
      wx = v.wyz,
      wy = -v.wxz,
      wz = v.wxy,
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
      i = 0.0,
    )

  infix def geometric(v: PlaneIdeal): BivectorBulk =
    BivectorBulk(
      xy = v.z,
      xz = -v.y,
      yz = v.x,
    )

  infix def geometric(v: BivectorBulk): PlaneIdeal =
    PlaneIdeal(
      x = -v.yz,
      y = v.xz,
      z = -v.xy,
    )

  infix def geometric(v: BivectorWeight): Vector =
    Vector(
      wxy = -v.wz,
      wxz = v.wy,
      wyz = -v.wx,
    )

  infix def geometric(v: PseudoScalar): Plane =
    Plane(
      w = v.i,
      x = 0.0,
      y = 0.0,
      z = 0.0,
    )

  infix def geometric(v: PointCenter.type): Double =
    -1.0

  infix def dot(v: Multivector): Multivector =
    Multivector(
      s = -v.xyz,
      w = v.i,
      x = -v.yz,
      y = v.xz,
      z = -v.xy,
      wx = 0.0,
      wy = 0.0,
      wz = 0.0,
      xy = v.z,
      xz = -v.y,
      yz = v.x,
      wxy = 0.0,
      wxz = 0.0,
      wyz = 0.0,
      xyz = v.s,
      i = 0.0,
    )

  infix def dot(v: Motor): Multivector =
    Multivector(
      s = 0.0,
      w = v.i,
      x = -v.yz,
      y = v.xz,
      z = -v.xy,
      wx = 0.0,
      wy = 0.0,
      wz = 0.0,
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
      wxy = 0.0,
      wxz = 0.0,
      wyz = 0.0,
      xyz = v.s,
      i = 0.0,
    )

  infix def dot(v: Plane): BivectorBulk =
    BivectorBulk(
      xy = v.z,
      xz = -v.y,
      yz = v.x,
    )

  infix def dot(v: Bivector): PlaneIdeal =
    PlaneIdeal(
      x = -v.yz,
      y = v.xz,
      z = -v.xy,
    )

  infix def dot(v: Point): Double =
    -v.xyz

  infix def dot(v: Quaternion): Multivector =
    Multivector(
      s = 0.0,
      w = 0.0,
      x = -v.yz,
      y = v.xz,
      z = -v.xy,
      wx = 0.0,
      wy = 0.0,
      wz = 0.0,
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
      wxy = 0.0,
      wxz = 0.0,
      wyz = 0.0,
      xyz = v.s,
      i = 0.0,
    )

  infix def dot(v: Translator): PointCenter.type =
    PointCenter

  infix def dot(v: PointNormalized): Double =
    -1.0

  infix def dot(v: PlaneIdeal): BivectorBulk =
    BivectorBulk(
      xy = v.z,
      xz = -v.y,
      yz = v.x,
    )

  infix def dot(v: BivectorBulk): PlaneIdeal =
    PlaneIdeal(
      x = -v.yz,
      y = v.xz,
      z = -v.xy,
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
      wxy = 0.0,
      wxz = 0.0,
      wyz = 0.0,
      xyz = v.s,
      i = -v.w,
    )

  inline infix def ^(v: Multivector): Multivector = wedge(v)

  infix def wedge(v: Motor): Point =
    Point(
      wxy = 0.0,
      wxz = 0.0,
      wyz = 0.0,
      xyz = v.s,
    )

  inline infix def ^(v: Motor): Point = wedge(v)

  infix def wedge(v: Plane): PseudoScalar =
    PseudoScalar(
      i = -v.w,
    )

  inline infix def ^(v: Plane): PseudoScalar = wedge(v)

  infix def wedge(v: Quaternion): Point =
    Point(
      wxy = 0.0,
      wxz = 0.0,
      wyz = 0.0,
      xyz = v.s,
    )

  inline infix def ^(v: Quaternion): Point = wedge(v)

  infix def wedge(v: Translator): PointCenter.type =
    PointCenter

  inline infix def ^(v: Translator): PointCenter.type = wedge(v)

  infix def antiGeometric(v: Multivector): Multivector =
    Multivector(
      s = v.w,
      w = 0.0,
      x = -v.wx,
      y = -v.wy,
      z = -v.wz,
      wx = 0.0,
      wy = 0.0,
      wz = 0.0,
      xy = -v.wxy,
      xz = -v.wxz,
      yz = -v.wyz,
      wxy = 0.0,
      wxz = 0.0,
      wyz = 0.0,
      xyz = v.i,
      i = 0.0,
    )

  infix def antiGeometric(v: Motor): Multivector =
    Multivector(
      s = 0.0,
      w = 0.0,
      x = -v.wx,
      y = -v.wy,
      z = -v.wz,
      wx = 0.0,
      wy = 0.0,
      wz = 0.0,
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
      wxy = 0.0,
      wxz = 0.0,
      wyz = 0.0,
      xyz = v.i,
      i = 0.0,
    )

  infix def antiGeometric(v: Plane): Double =
    v.w

  infix def antiGeometric(v: Bivector): PlaneIdeal =
    PlaneIdeal(
      x = -v.wx,
      y = -v.wy,
      z = -v.wz,
    )

  infix def antiGeometric(v: Point): BivectorBulk =
    BivectorBulk(
      xy = -v.wxy,
      xz = -v.wxz,
      yz = -v.wyz,
    )

  infix def antiGeometric(v: Translator): PlaneIdeal =
    PlaneIdeal(
      x = -v.wx,
      y = -v.wy,
      z = -v.wz,
    )

  infix def antiGeometric(v: Vector): BivectorBulk =
    BivectorBulk(
      xy = -v.wxy,
      xz = -v.wxz,
      yz = -v.wyz,
    )

  infix def antiGeometric(v: PointNormalized): BivectorBulk =
    BivectorBulk(
      xy = -v.wxy,
      xz = -v.wxz,
      yz = -v.wyz,
    )

  infix def antiGeometric(v: BivectorWeight): PlaneIdeal =
    PlaneIdeal(
      x = -v.wx,
      y = -v.wy,
      z = -v.wz,
    )

  infix def antiGeometric(v: PseudoScalar): Point =
    Point(
      wxy = 0.0,
      wxz = 0.0,
      wyz = 0.0,
      xyz = v.i,
    )

  infix def antiDot(v: Multivector): Point =
    Point(
      wxy = 0.0,
      wxz = 0.0,
      wyz = 0.0,
      xyz = v.i,
    )

  infix def antiDot(v: Motor): Point =
    Point(
      wxy = 0.0,
      wxz = 0.0,
      wyz = 0.0,
      xyz = v.i,
    )

  infix def antiDot(v: PseudoScalar): Point =
    Point(
      wxy = 0.0,
      wxz = 0.0,
      wyz = 0.0,
      xyz = v.i,
    )

  infix def antiWedge(v: Multivector): Multivector =
    Multivector(
      s = v.w,
      w = 0.0,
      x = -v.wx,
      y = -v.wy,
      z = -v.wz,
      wx = 0.0,
      wy = 0.0,
      wz = 0.0,
      xy = -v.wxy,
      xz = -v.wxz,
      yz = -v.wyz,
      wxy = 0.0,
      wxz = 0.0,
      wyz = 0.0,
      xyz = v.i,
      i = 0.0,
    )

  inline infix def v(v: Multivector): Multivector = antiWedge(v)

  infix def antiWedge(v: Motor): Multivector =
    Multivector(
      s = 0.0,
      w = 0.0,
      x = -v.wx,
      y = -v.wy,
      z = -v.wz,
      wx = 0.0,
      wy = 0.0,
      wz = 0.0,
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
      wxy = 0.0,
      wxz = 0.0,
      wyz = 0.0,
      xyz = v.i,
      i = 0.0,
    )

  inline infix def v(v: Motor): Multivector = antiWedge(v)

  infix def antiWedge(v: Plane): Double =
    v.w

  inline infix def v(v: Plane): Double = antiWedge(v)

  infix def antiWedge(v: Bivector): PlaneIdeal =
    PlaneIdeal(
      x = -v.wx,
      y = -v.wy,
      z = -v.wz,
    )

  inline infix def v(v: Bivector): PlaneIdeal = antiWedge(v)

  infix def antiWedge(v: Point): BivectorBulk =
    BivectorBulk(
      xy = -v.wxy,
      xz = -v.wxz,
      yz = -v.wyz,
    )

  inline infix def v(v: Point): BivectorBulk = antiWedge(v)

  infix def antiWedge(v: Translator): PlaneIdeal =
    PlaneIdeal(
      x = -v.wx,
      y = -v.wy,
      z = -v.wz,
    )

  inline infix def v(v: Translator): PlaneIdeal = antiWedge(v)

  infix def antiWedge(v: Vector): BivectorBulk =
    BivectorBulk(
      xy = -v.wxy,
      xz = -v.wxz,
      yz = -v.wyz,
    )

  inline infix def v(v: Vector): BivectorBulk = antiWedge(v)

  infix def antiWedge(v: PointNormalized): BivectorBulk =
    BivectorBulk(
      xy = -v.wxy,
      xz = -v.wxz,
      yz = -v.wyz,
    )

  inline infix def v(v: PointNormalized): BivectorBulk = antiWedge(v)

  infix def antiWedge(v: BivectorWeight): PlaneIdeal =
    PlaneIdeal(
      x = -v.wx,
      y = -v.wy,
      z = -v.wz,
    )

  inline infix def v(v: BivectorWeight): PlaneIdeal = antiWedge(v)

  infix def antiWedge(v: PseudoScalar): Point =
    Point(
      wxy = 0.0,
      wxz = 0.0,
      wyz = 0.0,
      xyz = v.i,
    )

  inline infix def v(v: PseudoScalar): Point = antiWedge(v)

  infix def sandwich(v: Multivector): Multivector =
    Multivector(
      s = v.s,
      w = -v.w,
      x = v.x,
      y = v.y,
      z = v.z,
      wx = -v.wx,
      wy = -v.wy,
      wz = -v.wz,
      xy = v.xy,
      xz = v.xz,
      yz = v.yz,
      wxy = -v.wxy,
      wxz = -v.wxz,
      wyz = -v.wyz,
      xyz = v.xyz,
      i = -v.i,
    )

  infix def sandwich(v: Motor): Motor =
    Motor(
      s = v.s,
      wx = -v.wx,
      wy = -v.wy,
      wz = -v.wz,
      xy = v.xy,
      xz = v.xz,
      yz = v.yz,
      i = -v.i,
    )

  infix def sandwich(v: Plane): Plane =
    Plane(
      w = -v.w,
      x = v.x,
      y = v.y,
      z = v.z,
    )

  infix def sandwich(v: Bivector): Bivector =
    Bivector(
      wx = -v.wx,
      wy = -v.wy,
      wz = -v.wz,
      xy = v.xy,
      xz = v.xz,
      yz = v.yz,
    )

  infix def sandwich(v: Point): Point =
    Point(
      wxy = -v.wxy,
      wxz = -v.wxz,
      wyz = -v.wyz,
      xyz = v.xyz,
    )

  infix def sandwich(v: Quaternion): Quaternion =
    Quaternion(
      s = v.s,
      xy = v.xy,
      xz = v.xz,
      yz = v.yz,
    )

  infix def sandwich(v: Translator): Translator =
    Translator(
      wx = -v.wx,
      wy = -v.wy,
      wz = -v.wz,
    )

  infix def sandwich(v: Vector): Vector =
    Vector(
      wxy = -v.wxy,
      wxz = -v.wxz,
      wyz = -v.wyz,
    )

  infix def sandwich(v: PointNormalized): PointNormalized =
    PointNormalized(
      wxy = -v.wxy,
      wxz = -v.wxz,
      wyz = -v.wyz,
    )

  infix def sandwich(v: PlaneIdeal): PlaneIdeal =
    PlaneIdeal(
      x = v.x,
      y = v.y,
      z = v.z,
    )

  infix def sandwich(v: BivectorBulk): BivectorBulk =
    BivectorBulk(
      xy = v.xy,
      xz = v.xz,
      yz = v.yz,
    )

  infix def sandwich(v: BivectorWeight): BivectorWeight =
    BivectorWeight(
      wx = -v.wx,
      wy = -v.wy,
      wz = -v.wz,
    )

  infix def sandwich(v: PseudoScalar): PseudoScalar =
    PseudoScalar(
      i = -v.i,
    )

  infix def sandwich(v: PointCenter.type): PointCenter.type =
    PointCenter

  infix def reverseSandwich(v: Multivector): Multivector =
    Multivector(
      s = v.s,
      w = -v.w,
      x = v.x,
      y = v.y,
      z = v.z,
      wx = -v.wx,
      wy = -v.wy,
      wz = -v.wz,
      xy = v.xy,
      xz = v.xz,
      yz = v.yz,
      wxy = -v.wxy,
      wxz = -v.wxz,
      wyz = -v.wyz,
      xyz = v.xyz,
      i = -v.i,
    )

  infix def reverseSandwich(v: Motor): Motor =
    Motor(
      s = v.s,
      wx = -v.wx,
      wy = -v.wy,
      wz = -v.wz,
      xy = v.xy,
      xz = v.xz,
      yz = v.yz,
      i = -v.i,
    )

  infix def reverseSandwich(v: Plane): Plane =
    Plane(
      w = -v.w,
      x = v.x,
      y = v.y,
      z = v.z,
    )

  infix def reverseSandwich(v: Bivector): Bivector =
    Bivector(
      wx = -v.wx,
      wy = -v.wy,
      wz = -v.wz,
      xy = v.xy,
      xz = v.xz,
      yz = v.yz,
    )

  infix def reverseSandwich(v: Point): Point =
    Point(
      wxy = -v.wxy,
      wxz = -v.wxz,
      wyz = -v.wyz,
      xyz = v.xyz,
    )

  infix def reverseSandwich(v: Quaternion): Quaternion =
    Quaternion(
      s = v.s,
      xy = v.xy,
      xz = v.xz,
      yz = v.yz,
    )

  infix def reverseSandwich(v: Translator): Translator =
    Translator(
      wx = -v.wx,
      wy = -v.wy,
      wz = -v.wz,
    )

  infix def reverseSandwich(v: Vector): Vector =
    Vector(
      wxy = -v.wxy,
      wxz = -v.wxz,
      wyz = -v.wyz,
    )

  infix def reverseSandwich(v: PointNormalized): PointNormalized =
    PointNormalized(
      wxy = -v.wxy,
      wxz = -v.wxz,
      wyz = -v.wyz,
    )

  infix def reverseSandwich(v: PlaneIdeal): PlaneIdeal =
    PlaneIdeal(
      x = v.x,
      y = v.y,
      z = v.z,
    )

  infix def reverseSandwich(v: BivectorBulk): BivectorBulk =
    BivectorBulk(
      xy = v.xy,
      xz = v.xz,
      yz = v.yz,
    )

  infix def reverseSandwich(v: BivectorWeight): BivectorWeight =
    BivectorWeight(
      wx = -v.wx,
      wy = -v.wy,
      wz = -v.wz,
    )

  infix def reverseSandwich(v: PseudoScalar): PseudoScalar =
    PseudoScalar(
      i = -v.i,
    )

  infix def reverseSandwich(v: PointCenter.type): PointCenter.type =
    PointCenter

  infix def cross(v: Multivector): Multivector =
    Multivector(
      s = 0.0,
      w = v.i,
      x = 0.0,
      y = 0.0,
      z = 0.0,
      wx = v.wyz,
      wy = -v.wxz,
      wz = v.wxy,
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
      wxy = -v.wz,
      wxz = v.wy,
      wyz = -v.wx,
      xyz = 0.0,
      i = -v.w,
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
      wxy = -v.wz,
      wxz = v.wy,
      wyz = -v.wx,
      xyz = 0.0,
      i = 0.0,
    )

  infix def cross(v: Plane): PseudoScalar =
    PseudoScalar(
      i = -v.w,
    )

  infix def cross(v: Bivector): Vector =
    Vector(
      wxy = -v.wz,
      wxz = v.wy,
      wyz = -v.wx,
    )

  infix def cross(v: Point): BivectorWeight =
    BivectorWeight(
      wx = v.wyz,
      wy = -v.wxz,
      wz = v.wxy,
    )

  infix def cross(v: Translator): Vector =
    Vector(
      wxy = -v.wz,
      wxz = v.wy,
      wyz = -v.wx,
    )

  infix def cross(v: Vector): BivectorWeight =
    BivectorWeight(
      wx = v.wyz,
      wy = -v.wxz,
      wz = v.wxy,
    )

  infix def cross(v: PointNormalized): BivectorWeight =
    BivectorWeight(
      wx = v.wyz,
      wy = -v.wxz,
      wz = v.wxy,
    )

  infix def cross(v: BivectorWeight): Vector =
    Vector(
      wxy = -v.wz,
      wxz = v.wy,
      wyz = -v.wx,
    )

  infix def cross(v: PseudoScalar): Plane =
    Plane(
      w = v.i,
      x = 0.0,
      y = 0.0,
      z = 0.0,
    )