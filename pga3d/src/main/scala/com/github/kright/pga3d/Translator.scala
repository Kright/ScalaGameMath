package com.github.kright.pga3d

/** this code is generated, see com.github.kright.pga3d.codegen.CodeGenClass */
case class Translator(
  wx: Double = 0.0,
  wy: Double = 0.0,
  wz: Double = 0.0,
):
  inline val s = 1.0

  def dual: Motor =
    Motor(
      s = 0.0,
      wx = 0.0,
      wy = 0.0,
      wz = 0.0,
      xy = wz,
      xz = -wy,
      yz = wx,
      i = 1.0,
    )

  def weight: BivectorWeight =
    BivectorWeight(
      wx = wx,
      wy = wy,
      wz = wz,
    )

  def bulk: Double =
    1.0

  def reverse: Translator =
    Translator(
      wx = -wx,
      wy = -wy,
      wz = -wz,
    )

  def antiReverse: Translator =
    Translator(
      wx = -wx,
      wy = -wy,
      wz = -wz,
    )

  def unary_ : Motor =
    Motor(
      s = -1.0,
      wx = -wx,
      wy = -wy,
      wz = -wz,
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
      i = 0.0,
    )

  def bulkNormSquare: Double =
    1.0

  def weightNormSquare: Double =
    (wx * wx + wy * wy + wz * wz)

  def normSquare: Double =
    (1.0 + wx * wx + wy * wy + wz * wz)

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

  def *(v: Double): Motor =
    Motor(
      s = v,
      wx = v * wx,
      wy = v * wy,
      wz = v * wz,
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
      i = 0.0,
    )

  inline def /(v: Double): Motor =
    this * (1.0 / v)

  def +(v: Translator): Motor =
    Motor(
      s = 2.0,
      wx = (v.wx + wx),
      wy = (v.wy + wy),
      wz = (v.wz + wz),
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
      i = 0.0,
    )

  def -(v: Translator): BivectorWeight =
    BivectorWeight(
      wx = (wx - v.wx),
      wy = (wy - v.wy),
      wz = (wz - v.wz),
    )

  def madd(v: Translator, mult: Double): Motor =
    Motor(
      s = (1.0 + mult),
      wx = (wx + mult * v.wx),
      wy = (wy + mult * v.wy),
      wz = (wz + mult * v.wz),
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
      i = 0.0,
    )

  def multiplyElementwise(v: Translator): Translator =
    Translator(
      wx = v.wx * wx,
      wy = v.wy * wy,
      wz = v.wz * wz,
    )

  def log(): BivectorWeight =
    BivectorWeight(
      wx = wx,
      wy = wy,
      wz = wz,
    )

  def toMultivector: Multivector =
    Multivector(
      s = 1.0,
      w = 0.0,
      x = 0.0,
      y = 0.0,
      z = 0.0,
      wx = wx,
      wy = wy,
      wz = wz,
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
      wxy = 0.0,
      wxz = 0.0,
      wyz = 0.0,
      xyz = 0.0,
      i = 0.0,
    )

  def toMotor: Motor =
    Motor(
      s = 1.0,
      wx = wx,
      wy = wy,
      wz = wz,
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
      i = 0.0,
    )

  infix def geometric(v: Multivector): Multivector =
    Multivector(
      s = v.s,
      w = (v.w + v.x * wx + v.y * wy + v.z * wz),
      x = v.x,
      y = v.y,
      z = v.z,
      wx = (v.wx + v.s * wx - v.xy * wy - v.xz * wz),
      wy = (v.wy + v.s * wy + v.xy * wx - v.yz * wz),
      wz = (v.wz + v.s * wz + v.xz * wx + v.yz * wy),
      xy = v.xy,
      xz = v.xz,
      yz = v.yz,
      wxy = (v.wxy + v.xyz * wz + v.y * wx - v.x * wy),
      wxz = (v.wxz + v.z * wx - v.x * wz - v.xyz * wy),
      wyz = (v.wyz + v.xyz * wx + v.z * wy - v.y * wz),
      xyz = v.xyz,
      i = (v.i + v.xy * wz + v.yz * wx - v.xz * wy),
    )

  infix def geometric(v: Motor): Motor =
    Motor(
      s = v.s,
      wx = (v.wx + v.s * wx - v.xy * wy - v.xz * wz),
      wy = (v.wy + v.s * wy + v.xy * wx - v.yz * wz),
      wz = (v.wz + v.s * wz + v.xz * wx + v.yz * wy),
      xy = v.xy,
      xz = v.xz,
      yz = v.yz,
      i = (v.i + v.xy * wz + v.yz * wx - v.xz * wy),
    )

  infix def geometric(v: Plane): Multivector =
    Multivector(
      s = 0.0,
      w = (v.w + v.x * wx + v.y * wy + v.z * wz),
      x = v.x,
      y = v.y,
      z = v.z,
      wx = 0.0,
      wy = 0.0,
      wz = 0.0,
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
      wxy = (v.y * wx - v.x * wy),
      wxz = (v.z * wx - v.x * wz),
      wyz = (v.z * wy - v.y * wz),
      xyz = 0.0,
      i = 0.0,
    )

  infix def geometric(v: Bivector): Motor =
    Motor(
      s = 0.0,
      wx = (v.wx - v.xy * wy - v.xz * wz),
      wy = (v.wy + v.xy * wx - v.yz * wz),
      wz = (v.wz + v.xz * wx + v.yz * wy),
      xy = v.xy,
      xz = v.xz,
      yz = v.yz,
      i = (v.xy * wz + v.yz * wx - v.xz * wy),
    )

  infix def geometric(v: Point): Point =
    Point(
      wxy = (v.wxy + v.xyz * wz),
      wxz = (v.wxz - v.xyz * wy),
      wyz = (v.wyz + v.xyz * wx),
      xyz = v.xyz,
    )

  infix def geometric(v: Quaternion): Motor =
    Motor(
      s = v.s,
      wx = (v.s * wx - v.xy * wy - v.xz * wz),
      wy = (v.s * wy + v.xy * wx - v.yz * wz),
      wz = (v.s * wz + v.xz * wx + v.yz * wy),
      xy = v.xy,
      xz = v.xz,
      yz = v.yz,
      i = (v.xy * wz + v.yz * wx - v.xz * wy),
    )

  infix def geometric(v: Translator): Translator =
    Translator(
      wx = (v.wx + wx),
      wy = (v.wy + wy),
      wz = (v.wz + wz),
    )

  infix def geometric(v: Vector): Vector =
    Vector(
      wxy = v.wxy,
      wxz = v.wxz,
      wyz = v.wyz,
    )

  infix def geometric(v: PointNormalized): PointNormalized =
    PointNormalized(
      wxy = (v.wxy + wz),
      wxz = (v.wxz - wy),
      wyz = (v.wyz + wx),
    )

  infix def geometric(v: PlaneIdeal): Multivector =
    Multivector(
      s = 0.0,
      w = (v.x * wx + v.y * wy + v.z * wz),
      x = v.x,
      y = v.y,
      z = v.z,
      wx = 0.0,
      wy = 0.0,
      wz = 0.0,
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
      wxy = (v.y * wx - v.x * wy),
      wxz = (v.z * wx - v.x * wz),
      wyz = (v.z * wy - v.y * wz),
      xyz = 0.0,
      i = 0.0,
    )

  infix def geometric(v: BivectorBulk): Motor =
    Motor(
      s = 0.0,
      wx = (-v.xy * wy - v.xz * wz),
      wy = (v.xy * wx - v.yz * wz),
      wz = (v.xz * wx + v.yz * wy),
      xy = v.xy,
      xz = v.xz,
      yz = v.yz,
      i = (v.xy * wz + v.yz * wx - v.xz * wy),
    )

  infix def geometric(v: BivectorWeight): BivectorWeight =
    BivectorWeight(
      wx = v.wx,
      wy = v.wy,
      wz = v.wz,
    )

  infix def geometric(v: PseudoScalar): PseudoScalar =
    PseudoScalar(
      i = v.i,
    )

  infix def geometric(v: PointCenter.type): PointNormalized =
    PointNormalized(
      wxy = wz,
      wxz = -wy,
      wyz = wx,
    )

  infix def dot(v: Multivector): Multivector =
    Multivector(
      s = v.s,
      w = (v.w + v.x * wx + v.y * wy + v.z * wz),
      x = v.x,
      y = v.y,
      z = v.z,
      wx = (v.wx + v.s * wx),
      wy = (v.wy + v.s * wy),
      wz = (v.wz + v.s * wz),
      xy = v.xy,
      xz = v.xz,
      yz = v.yz,
      wxy = v.wxy,
      wxz = v.wxz,
      wyz = v.wyz,
      xyz = v.xyz,
      i = v.i,
    )

  infix def dot(v: Motor): Motor =
    Motor(
      s = v.s,
      wx = (v.wx + v.s * wx),
      wy = (v.wy + v.s * wy),
      wz = (v.wz + v.s * wz),
      xy = v.xy,
      xz = v.xz,
      yz = v.yz,
      i = v.i,
    )

  infix def dot(v: Plane): Plane =
    Plane(
      w = (v.w + v.x * wx + v.y * wy + v.z * wz),
      x = v.x,
      y = v.y,
      z = v.z,
    )

  infix def dot(v: Bivector): Bivector =
    Bivector(
      wx = v.wx,
      wy = v.wy,
      wz = v.wz,
      xy = v.xy,
      xz = v.xz,
      yz = v.yz,
    )

  infix def dot(v: Point): Point =
    Point(
      wxy = v.wxy,
      wxz = v.wxz,
      wyz = v.wyz,
      xyz = v.xyz,
    )

  infix def dot(v: Quaternion): Motor =
    Motor(
      s = v.s,
      wx = v.s * wx,
      wy = v.s * wy,
      wz = v.s * wz,
      xy = v.xy,
      xz = v.xz,
      yz = v.yz,
      i = 0.0,
    )

  infix def dot(v: Translator): Translator =
    Translator(
      wx = (v.wx + wx),
      wy = (v.wy + wy),
      wz = (v.wz + wz),
    )

  infix def dot(v: Vector): Vector =
    Vector(
      wxy = v.wxy,
      wxz = v.wxz,
      wyz = v.wyz,
    )

  infix def dot(v: PointNormalized): PointNormalized =
    PointNormalized(
      wxy = v.wxy,
      wxz = v.wxz,
      wyz = v.wyz,
    )

  infix def dot(v: PlaneIdeal): Plane =
    Plane(
      w = (v.x * wx + v.y * wy + v.z * wz),
      x = v.x,
      y = v.y,
      z = v.z,
    )

  infix def dot(v: BivectorBulk): BivectorBulk =
    BivectorBulk(
      xy = v.xy,
      xz = v.xz,
      yz = v.yz,
    )

  infix def dot(v: BivectorWeight): BivectorWeight =
    BivectorWeight(
      wx = v.wx,
      wy = v.wy,
      wz = v.wz,
    )

  infix def dot(v: PseudoScalar): PseudoScalar =
    PseudoScalar(
      i = v.i,
    )

  infix def dot(v: PointCenter.type): PointCenter.type =
    PointCenter

  infix def wedge(v: Multivector): Multivector =
    Multivector(
      s = v.s,
      w = v.w,
      x = v.x,
      y = v.y,
      z = v.z,
      wx = (v.wx + v.s * wx),
      wy = (v.wy + v.s * wy),
      wz = (v.wz + v.s * wz),
      xy = v.xy,
      xz = v.xz,
      yz = v.yz,
      wxy = (v.wxy + v.y * wx - v.x * wy),
      wxz = (v.wxz + v.z * wx - v.x * wz),
      wyz = (v.wyz + v.z * wy - v.y * wz),
      xyz = v.xyz,
      i = (v.i + v.xy * wz + v.yz * wx - v.xz * wy),
    )

  inline infix def ^(v: Multivector): Multivector = wedge(v)

  infix def wedge(v: Motor): Motor =
    Motor(
      s = v.s,
      wx = (v.wx + v.s * wx),
      wy = (v.wy + v.s * wy),
      wz = (v.wz + v.s * wz),
      xy = v.xy,
      xz = v.xz,
      yz = v.yz,
      i = (v.i + v.xy * wz + v.yz * wx - v.xz * wy),
    )

  inline infix def ^(v: Motor): Motor = wedge(v)

  infix def wedge(v: Plane): Multivector =
    Multivector(
      s = 0.0,
      w = v.w,
      x = v.x,
      y = v.y,
      z = v.z,
      wx = 0.0,
      wy = 0.0,
      wz = 0.0,
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
      wxy = (v.y * wx - v.x * wy),
      wxz = (v.z * wx - v.x * wz),
      wyz = (v.z * wy - v.y * wz),
      xyz = 0.0,
      i = 0.0,
    )

  inline infix def ^(v: Plane): Multivector = wedge(v)

  infix def wedge(v: Bivector): Motor =
    Motor(
      s = 0.0,
      wx = v.wx,
      wy = v.wy,
      wz = v.wz,
      xy = v.xy,
      xz = v.xz,
      yz = v.yz,
      i = (v.xy * wz + v.yz * wx - v.xz * wy),
    )

  inline infix def ^(v: Bivector): Motor = wedge(v)

  infix def wedge(v: Point): Point =
    Point(
      wxy = v.wxy,
      wxz = v.wxz,
      wyz = v.wyz,
      xyz = v.xyz,
    )

  inline infix def ^(v: Point): Point = wedge(v)

  infix def wedge(v: Quaternion): Motor =
    Motor(
      s = v.s,
      wx = v.s * wx,
      wy = v.s * wy,
      wz = v.s * wz,
      xy = v.xy,
      xz = v.xz,
      yz = v.yz,
      i = (v.xy * wz + v.yz * wx - v.xz * wy),
    )

  inline infix def ^(v: Quaternion): Motor = wedge(v)

  infix def wedge(v: Translator): Translator =
    Translator(
      wx = (v.wx + wx),
      wy = (v.wy + wy),
      wz = (v.wz + wz),
    )

  inline infix def ^(v: Translator): Translator = wedge(v)

  infix def wedge(v: Vector): Vector =
    Vector(
      wxy = v.wxy,
      wxz = v.wxz,
      wyz = v.wyz,
    )

  inline infix def ^(v: Vector): Vector = wedge(v)

  infix def wedge(v: PointNormalized): PointNormalized =
    PointNormalized(
      wxy = v.wxy,
      wxz = v.wxz,
      wyz = v.wyz,
    )

  inline infix def ^(v: PointNormalized): PointNormalized = wedge(v)

  infix def wedge(v: PlaneIdeal): Multivector =
    Multivector(
      s = 0.0,
      w = 0.0,
      x = v.x,
      y = v.y,
      z = v.z,
      wx = 0.0,
      wy = 0.0,
      wz = 0.0,
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
      wxy = (v.y * wx - v.x * wy),
      wxz = (v.z * wx - v.x * wz),
      wyz = (v.z * wy - v.y * wz),
      xyz = 0.0,
      i = 0.0,
    )

  inline infix def ^(v: PlaneIdeal): Multivector = wedge(v)

  infix def wedge(v: BivectorBulk): Motor =
    Motor(
      s = 0.0,
      wx = 0.0,
      wy = 0.0,
      wz = 0.0,
      xy = v.xy,
      xz = v.xz,
      yz = v.yz,
      i = (v.xy * wz + v.yz * wx - v.xz * wy),
    )

  inline infix def ^(v: BivectorBulk): Motor = wedge(v)

  infix def wedge(v: BivectorWeight): BivectorWeight =
    BivectorWeight(
      wx = v.wx,
      wy = v.wy,
      wz = v.wz,
    )

  inline infix def ^(v: BivectorWeight): BivectorWeight = wedge(v)

  infix def wedge(v: PseudoScalar): PseudoScalar =
    PseudoScalar(
      i = v.i,
    )

  inline infix def ^(v: PseudoScalar): PseudoScalar = wedge(v)

  infix def wedge(v: PointCenter.type): PointCenter.type =
    PointCenter

  inline infix def ^(v: PointCenter.type): PointCenter.type = wedge(v)

  infix def antiGeometric(v: Multivector): Multivector =
    Multivector(
      s = (v.i + v.xy * wz + v.yz * wx - v.xz * wy),
      w = (v.wxz * wy - v.wxy * wz - v.wyz * wx),
      x = (v.wyz + v.y * wz - v.xyz * wx - v.z * wy),
      y = (-v.wxz + v.z * wx - v.x * wz - v.xyz * wy),
      z = (v.wxy + v.x * wy - v.xyz * wz - v.y * wx),
      wx = (v.i * wx + v.wy * wz - v.wz * wy),
      wy = (v.i * wy + v.wz * wx - v.wx * wz),
      wz = (v.i * wz + v.wx * wy - v.wy * wx),
      xy = (-v.wz + v.xz * wx + v.yz * wy - v.s * wz),
      xz = (v.wy + v.s * wy + v.yz * wz - v.xy * wx),
      yz = (-v.wx - v.s * wx - v.xy * wy - v.xz * wz),
      wxy = (v.w * wz + v.wxz * wx + v.wyz * wy),
      wxz = (v.wyz * wz - v.w * wy - v.wxy * wx),
      wyz = (v.w * wx - v.wxy * wy - v.wxz * wz),
      xyz = (-v.w + v.x * wx + v.y * wy + v.z * wz),
      i = (-v.wx * wx - v.wy * wy - v.wz * wz),
    )

  infix def antiGeometric(v: Motor): Motor =
    Motor(
      s = (v.i + v.xy * wz + v.yz * wx - v.xz * wy),
      wx = (v.i * wx + v.wy * wz - v.wz * wy),
      wy = (v.i * wy + v.wz * wx - v.wx * wz),
      wz = (v.i * wz + v.wx * wy - v.wy * wx),
      xy = (-v.wz + v.xz * wx + v.yz * wy - v.s * wz),
      xz = (v.wy + v.s * wy + v.yz * wz - v.xy * wx),
      yz = (-v.wx - v.s * wx - v.xy * wy - v.xz * wz),
      i = (-v.wx * wx - v.wy * wy - v.wz * wz),
    )

  infix def antiGeometric(v: Plane): Multivector =
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
      wxy = v.w * wz,
      wxz = -v.w * wy,
      wyz = v.w * wx,
      xyz = (-v.w + v.x * wx + v.y * wy + v.z * wz),
      i = 0.0,
    )

  infix def antiGeometric(v: Bivector): Motor =
    Motor(
      s = (v.xy * wz + v.yz * wx - v.xz * wy),
      wx = (v.wy * wz - v.wz * wy),
      wy = (v.wz * wx - v.wx * wz),
      wz = (v.wx * wy - v.wy * wx),
      xy = (-v.wz + v.xz * wx + v.yz * wy),
      xz = (v.wy + v.yz * wz - v.xy * wx),
      yz = (-v.wx - v.xy * wy - v.xz * wz),
      i = (-v.wx * wx - v.wy * wy - v.wz * wz),
    )

  infix def antiGeometric(v: Point): Multivector =
    Multivector(
      s = 0.0,
      w = (v.wxz * wy - v.wxy * wz - v.wyz * wx),
      x = (v.wyz - v.xyz * wx),
      y = (-v.wxz - v.xyz * wy),
      z = (v.wxy - v.xyz * wz),
      wx = 0.0,
      wy = 0.0,
      wz = 0.0,
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
      wxy = (v.wxz * wx + v.wyz * wy),
      wxz = (v.wyz * wz - v.wxy * wx),
      wyz = (-v.wxy * wy - v.wxz * wz),
      xyz = 0.0,
      i = 0.0,
    )

  infix def antiGeometric(v: Quaternion): Quaternion =
    Quaternion(
      s = (v.xy * wz + v.yz * wx - v.xz * wy),
      xy = (v.xz * wx + v.yz * wy - v.s * wz),
      xz = (v.s * wy + v.yz * wz - v.xy * wx),
      yz = (-v.s * wx - v.xy * wy - v.xz * wz),
    )

  infix def antiGeometric(v: Translator): Motor =
    Motor(
      s = 0.0,
      wx = (v.wy * wz - v.wz * wy),
      wy = (v.wz * wx - v.wx * wz),
      wz = (v.wx * wy - v.wy * wx),
      xy = (-v.wz - wz),
      xz = (v.wy + wy),
      yz = (-v.wx - wx),
      i = (-v.wx * wx - v.wy * wy - v.wz * wz),
    )

  infix def antiGeometric(v: Vector): Multivector =
    Multivector(
      s = 0.0,
      w = (v.wxz * wy - v.wxy * wz - v.wyz * wx),
      x = v.wyz,
      y = -v.wxz,
      z = v.wxy,
      wx = 0.0,
      wy = 0.0,
      wz = 0.0,
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
      wxy = (v.wxz * wx + v.wyz * wy),
      wxz = (v.wyz * wz - v.wxy * wx),
      wyz = (-v.wxy * wy - v.wxz * wz),
      xyz = 0.0,
      i = 0.0,
    )

  infix def antiGeometric(v: PointNormalized): Multivector =
    Multivector(
      s = 0.0,
      w = (v.wxz * wy - v.wxy * wz - v.wyz * wx),
      x = (v.wyz - wx),
      y = (-v.wxz - wy),
      z = (v.wxy - wz),
      wx = 0.0,
      wy = 0.0,
      wz = 0.0,
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
      wxy = (v.wxz * wx + v.wyz * wy),
      wxz = (v.wyz * wz - v.wxy * wx),
      wyz = (-v.wxy * wy - v.wxz * wz),
      xyz = 0.0,
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
      s = 0.0,
      wx = (v.wy * wz - v.wz * wy),
      wy = (v.wz * wx - v.wx * wz),
      wz = (v.wx * wy - v.wy * wx),
      xy = -v.wz,
      xz = v.wy,
      yz = -v.wx,
      i = (-v.wx * wx - v.wy * wy - v.wz * wz),
    )

  infix def antiGeometric(v: PseudoScalar): Motor =
    Motor(
      s = v.i,
      wx = v.i * wx,
      wy = v.i * wy,
      wz = v.i * wz,
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
      i = 0.0,
    )

  infix def antiGeometric(v: PointCenter.type): PlaneIdeal =
    PlaneIdeal(
      x = -wx,
      y = -wy,
      z = -wz,
    )

  infix def antiDot(v: Multivector): Multivector =
    Multivector(
      s = v.i,
      w = 0.0,
      x = v.wyz,
      y = -v.wxz,
      z = v.wxy,
      wx = v.i * wx,
      wy = v.i * wy,
      wz = v.i * wz,
      xy = (-v.wz - v.s * wz),
      xz = (v.wy + v.s * wy),
      yz = (-v.wx - v.s * wx),
      wxy = (v.w * wz + v.wxz * wx + v.wyz * wy),
      wxz = (v.wyz * wz - v.w * wy - v.wxy * wx),
      wyz = (v.w * wx - v.wxy * wy - v.wxz * wz),
      xyz = (-v.w + v.x * wx + v.y * wy + v.z * wz),
      i = (-v.wx * wx - v.wy * wy - v.wz * wz),
    )

  infix def antiDot(v: Motor): Motor =
    Motor(
      s = v.i,
      wx = v.i * wx,
      wy = v.i * wy,
      wz = v.i * wz,
      xy = (-v.wz - v.s * wz),
      xz = (v.wy + v.s * wy),
      yz = (-v.wx - v.s * wx),
      i = (-v.wx * wx - v.wy * wy - v.wz * wz),
    )

  infix def antiDot(v: Plane): Point =
    Point(
      wxy = v.w * wz,
      wxz = -v.w * wy,
      wyz = v.w * wx,
      xyz = (-v.w + v.x * wx + v.y * wy + v.z * wz),
    )

  infix def antiDot(v: Bivector): Motor =
    Motor(
      s = 0.0,
      wx = 0.0,
      wy = 0.0,
      wz = 0.0,
      xy = -v.wz,
      xz = v.wy,
      yz = -v.wx,
      i = (-v.wx * wx - v.wy * wy - v.wz * wz),
    )

  infix def antiDot(v: Point): Multivector =
    Multivector(
      s = 0.0,
      w = 0.0,
      x = v.wyz,
      y = -v.wxz,
      z = v.wxy,
      wx = 0.0,
      wy = 0.0,
      wz = 0.0,
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
      wxy = (v.wxz * wx + v.wyz * wy),
      wxz = (v.wyz * wz - v.wxy * wx),
      wyz = (-v.wxy * wy - v.wxz * wz),
      xyz = 0.0,
      i = 0.0,
    )

  infix def antiDot(v: Quaternion): BivectorBulk =
    BivectorBulk(
      xy = -v.s * wz,
      xz = v.s * wy,
      yz = -v.s * wx,
    )

  infix def antiDot(v: Translator): Motor =
    Motor(
      s = 0.0,
      wx = 0.0,
      wy = 0.0,
      wz = 0.0,
      xy = (-v.wz - wz),
      xz = (v.wy + wy),
      yz = (-v.wx - wx),
      i = (-v.wx * wx - v.wy * wy - v.wz * wz),
    )

  infix def antiDot(v: Vector): Multivector =
    Multivector(
      s = 0.0,
      w = 0.0,
      x = v.wyz,
      y = -v.wxz,
      z = v.wxy,
      wx = 0.0,
      wy = 0.0,
      wz = 0.0,
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
      wxy = (v.wxz * wx + v.wyz * wy),
      wxz = (v.wyz * wz - v.wxy * wx),
      wyz = (-v.wxy * wy - v.wxz * wz),
      xyz = 0.0,
      i = 0.0,
    )

  infix def antiDot(v: PointNormalized): Multivector =
    Multivector(
      s = 0.0,
      w = 0.0,
      x = v.wyz,
      y = -v.wxz,
      z = v.wxy,
      wx = 0.0,
      wy = 0.0,
      wz = 0.0,
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
      wxy = (v.wxz * wx + v.wyz * wy),
      wxz = (v.wyz * wz - v.wxy * wx),
      wyz = (-v.wxy * wy - v.wxz * wz),
      xyz = 0.0,
      i = 0.0,
    )

  infix def antiDot(v: PlaneIdeal): Point =
    Point(
      wxy = 0.0,
      wxz = 0.0,
      wyz = 0.0,
      xyz = (v.x * wx + v.y * wy + v.z * wz),
    )

  infix def antiDot(v: BivectorWeight): Motor =
    Motor(
      s = 0.0,
      wx = 0.0,
      wy = 0.0,
      wz = 0.0,
      xy = -v.wz,
      xz = v.wy,
      yz = -v.wx,
      i = (-v.wx * wx - v.wy * wy - v.wz * wz),
    )

  infix def antiDot(v: PseudoScalar): Motor =
    Motor(
      s = v.i,
      wx = v.i * wx,
      wy = v.i * wy,
      wz = v.i * wz,
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
      i = 0.0,
    )

  infix def antiWedge(v: Multivector): Multivector =
    Multivector(
      s = (v.i + v.xy * wz + v.yz * wx - v.xz * wy),
      w = (v.wxz * wy - v.wxy * wz - v.wyz * wx),
      x = -v.xyz * wx,
      y = -v.xyz * wy,
      z = -v.xyz * wz,
      wx = v.i * wx,
      wy = v.i * wy,
      wz = v.i * wz,
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

  infix def antiWedge(v: Motor): Motor =
    Motor(
      s = (v.i + v.xy * wz + v.yz * wx - v.xz * wy),
      wx = v.i * wx,
      wy = v.i * wy,
      wz = v.i * wz,
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
      i = 0.0,
    )

  inline infix def v(v: Motor): Motor = antiWedge(v)

  infix def antiWedge(v: Bivector): Double =
    (v.xy * wz + v.yz * wx - v.xz * wy)

  inline infix def v(v: Bivector): Double = antiWedge(v)

  infix def antiWedge(v: Point): Plane =
    Plane(
      w = (v.wxz * wy - v.wxy * wz - v.wyz * wx),
      x = -v.xyz * wx,
      y = -v.xyz * wy,
      z = -v.xyz * wz,
    )

  inline infix def v(v: Point): Plane = antiWedge(v)

  infix def antiWedge(v: Quaternion): Double =
    (v.xy * wz + v.yz * wx - v.xz * wy)

  inline infix def v(v: Quaternion): Double = antiWedge(v)

  infix def antiWedge(v: Vector): Plane =
    Plane(
      w = (v.wxz * wy - v.wxy * wz - v.wyz * wx),
      x = 0.0,
      y = 0.0,
      z = 0.0,
    )

  inline infix def v(v: Vector): Plane = antiWedge(v)

  infix def antiWedge(v: PointNormalized): Plane =
    Plane(
      w = (v.wxz * wy - v.wxy * wz - v.wyz * wx),
      x = -wx,
      y = -wy,
      z = -wz,
    )

  inline infix def v(v: PointNormalized): Plane = antiWedge(v)

  infix def antiWedge(v: BivectorBulk): Double =
    (v.xy * wz + v.yz * wx - v.xz * wy)

  inline infix def v(v: BivectorBulk): Double = antiWedge(v)

  infix def antiWedge(v: PseudoScalar): Motor =
    Motor(
      s = v.i,
      wx = v.i * wx,
      wy = v.i * wy,
      wz = v.i * wz,
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
      i = 0.0,
    )

  inline infix def v(v: PseudoScalar): Motor = antiWedge(v)

  infix def antiWedge(v: PointCenter.type): PlaneIdeal =
    PlaneIdeal(
      x = -wx,
      y = -wy,
      z = -wz,
    )

  inline infix def v(v: PointCenter.type): PlaneIdeal = antiWedge(v)

  infix def sandwich(v: Multivector): Multivector =
    Multivector(
      s = v.s,
      w = (v.w + 2.0 * v.x * wx + 2.0 * v.y * wy + 2.0 * v.z * wz),
      x = v.x,
      y = v.y,
      z = v.z,
      wx = (v.wx - 2.0 * v.xy * wy - 2.0 * v.xz * wz),
      wy = (v.wy - 2.0 * v.yz * wz + 2.0 * v.xy * wx),
      wz = (v.wz + 2.0 * v.xz * wx + 2.0 * v.yz * wy),
      xy = v.xy,
      xz = v.xz,
      yz = v.yz,
      wxy = (v.wxy + 2.0 * v.xyz * wz),
      wxz = (v.wxz - 2.0 * v.xyz * wy),
      wyz = (v.wyz + 2.0 * v.xyz * wx),
      xyz = v.xyz,
      i = v.i,
    )

  infix def sandwich(v: Motor): Motor =
    Motor(
      s = v.s,
      wx = (v.wx - 2.0 * v.xy * wy - 2.0 * v.xz * wz),
      wy = (v.wy - 2.0 * v.yz * wz + 2.0 * v.xy * wx),
      wz = (v.wz + 2.0 * v.xz * wx + 2.0 * v.yz * wy),
      xy = v.xy,
      xz = v.xz,
      yz = v.yz,
      i = v.i,
    )

  infix def sandwich(v: Plane): Plane =
    Plane(
      w = (v.w + 2.0 * v.x * wx + 2.0 * v.y * wy + 2.0 * v.z * wz),
      x = v.x,
      y = v.y,
      z = v.z,
    )

  infix def sandwich(v: Bivector): Bivector =
    Bivector(
      wx = (v.wx - 2.0 * v.xy * wy - 2.0 * v.xz * wz),
      wy = (v.wy - 2.0 * v.yz * wz + 2.0 * v.xy * wx),
      wz = (v.wz + 2.0 * v.xz * wx + 2.0 * v.yz * wy),
      xy = v.xy,
      xz = v.xz,
      yz = v.yz,
    )

  infix def sandwich(v: Point): Point =
    Point(
      wxy = (v.wxy + 2.0 * v.xyz * wz),
      wxz = (v.wxz - 2.0 * v.xyz * wy),
      wyz = (v.wyz + 2.0 * v.xyz * wx),
      xyz = v.xyz,
    )

  infix def sandwich(v: Quaternion): Motor =
    Motor(
      s = v.s,
      wx = 2.0 * (-v.xy * wy - v.xz * wz),
      wy = 2.0 * (v.xy * wx - v.yz * wz),
      wz = 2.0 * (v.xz * wx + v.yz * wy),
      xy = v.xy,
      xz = v.xz,
      yz = v.yz,
      i = 0.0,
    )

  infix def sandwich(v: Translator): Translator =
    Translator(
      wx = v.wx,
      wy = v.wy,
      wz = v.wz,
    )

  infix def sandwich(v: Vector): Vector =
    Vector(
      wxy = v.wxy,
      wxz = v.wxz,
      wyz = v.wyz,
    )

  infix def sandwich(v: PointNormalized): PointNormalized =
    PointNormalized(
      wxy = (v.wxy + 2.0 * wz),
      wxz = (v.wxz - 2.0 * wy),
      wyz = (v.wyz + 2.0 * wx),
    )

  infix def sandwich(v: PlaneIdeal): Plane =
    Plane(
      w = 2.0 * (v.x * wx + v.y * wy + v.z * wz),
      x = v.x,
      y = v.y,
      z = v.z,
    )

  infix def sandwich(v: BivectorBulk): Bivector =
    Bivector(
      wx = 2.0 * (-v.xy * wy - v.xz * wz),
      wy = 2.0 * (v.xy * wx - v.yz * wz),
      wz = 2.0 * (v.xz * wx + v.yz * wy),
      xy = v.xy,
      xz = v.xz,
      yz = v.yz,
    )

  infix def sandwich(v: BivectorWeight): BivectorWeight =
    BivectorWeight(
      wx = v.wx,
      wy = v.wy,
      wz = v.wz,
    )

  infix def sandwich(v: PseudoScalar): PseudoScalar =
    PseudoScalar(
      i = v.i,
    )

  infix def sandwich(v: PointCenter.type): PointNormalized =
    PointNormalized(
      wxy = 2.0 * wz,
      wxz = -2.0 * wy,
      wyz = 2.0 * wx,
    )

  infix def reverseSandwich(v: Multivector): Multivector =
    Multivector(
      s = v.s,
      w = (v.w - 2.0 * v.x * wx - 2.0 * v.y * wy - 2.0 * v.z * wz),
      x = v.x,
      y = v.y,
      z = v.z,
      wx = (v.wx + 2.0 * v.xy * wy + 2.0 * v.xz * wz),
      wy = (v.wy - 2.0 * v.xy * wx + 2.0 * v.yz * wz),
      wz = (v.wz - 2.0 * v.xz * wx - 2.0 * v.yz * wy),
      xy = v.xy,
      xz = v.xz,
      yz = v.yz,
      wxy = (v.wxy - 2.0 * v.xyz * wz),
      wxz = (v.wxz + 2.0 * v.xyz * wy),
      wyz = (v.wyz - 2.0 * v.xyz * wx),
      xyz = v.xyz,
      i = v.i,
    )

  infix def reverseSandwich(v: Motor): Motor =
    Motor(
      s = v.s,
      wx = (v.wx + 2.0 * v.xy * wy + 2.0 * v.xz * wz),
      wy = (v.wy - 2.0 * v.xy * wx + 2.0 * v.yz * wz),
      wz = (v.wz - 2.0 * v.xz * wx - 2.0 * v.yz * wy),
      xy = v.xy,
      xz = v.xz,
      yz = v.yz,
      i = v.i,
    )

  infix def reverseSandwich(v: Plane): Plane =
    Plane(
      w = (v.w - 2.0 * v.x * wx - 2.0 * v.y * wy - 2.0 * v.z * wz),
      x = v.x,
      y = v.y,
      z = v.z,
    )

  infix def reverseSandwich(v: Bivector): Bivector =
    Bivector(
      wx = (v.wx + 2.0 * v.xy * wy + 2.0 * v.xz * wz),
      wy = (v.wy - 2.0 * v.xy * wx + 2.0 * v.yz * wz),
      wz = (v.wz - 2.0 * v.xz * wx - 2.0 * v.yz * wy),
      xy = v.xy,
      xz = v.xz,
      yz = v.yz,
    )

  infix def reverseSandwich(v: Point): Point =
    Point(
      wxy = (v.wxy - 2.0 * v.xyz * wz),
      wxz = (v.wxz + 2.0 * v.xyz * wy),
      wyz = (v.wyz - 2.0 * v.xyz * wx),
      xyz = v.xyz,
    )

  infix def reverseSandwich(v: Quaternion): Motor =
    Motor(
      s = v.s,
      wx = 2.0 * (v.xy * wy + v.xz * wz),
      wy = 2.0 * (v.yz * wz - v.xy * wx),
      wz = 2.0 * (-v.xz * wx - v.yz * wy),
      xy = v.xy,
      xz = v.xz,
      yz = v.yz,
      i = 0.0,
    )

  infix def reverseSandwich(v: Translator): Translator =
    Translator(
      wx = v.wx,
      wy = v.wy,
      wz = v.wz,
    )

  infix def reverseSandwich(v: Vector): Vector =
    Vector(
      wxy = v.wxy,
      wxz = v.wxz,
      wyz = v.wyz,
    )

  infix def reverseSandwich(v: PointNormalized): PointNormalized =
    PointNormalized(
      wxy = (v.wxy - 2.0 * wz),
      wxz = (v.wxz + 2.0 * wy),
      wyz = (v.wyz - 2.0 * wx),
    )

  infix def reverseSandwich(v: PlaneIdeal): Plane =
    Plane(
      w = 2.0 * (-v.x * wx - v.y * wy - v.z * wz),
      x = v.x,
      y = v.y,
      z = v.z,
    )

  infix def reverseSandwich(v: BivectorBulk): Bivector =
    Bivector(
      wx = 2.0 * (v.xy * wy + v.xz * wz),
      wy = 2.0 * (v.yz * wz - v.xy * wx),
      wz = 2.0 * (-v.xz * wx - v.yz * wy),
      xy = v.xy,
      xz = v.xz,
      yz = v.yz,
    )

  infix def reverseSandwich(v: BivectorWeight): BivectorWeight =
    BivectorWeight(
      wx = v.wx,
      wy = v.wy,
      wz = v.wz,
    )

  infix def reverseSandwich(v: PseudoScalar): PseudoScalar =
    PseudoScalar(
      i = v.i,
    )

  infix def reverseSandwich(v: PointCenter.type): PointNormalized =
    PointNormalized(
      wxy = -2.0 * wz,
      wxz = 2.0 * wy,
      wyz = -2.0 * wx,
    )

  infix def cross(v: Multivector): Multivector =
    Multivector(
      s = 0.0,
      w = (v.x * wx + v.y * wy + v.z * wz),
      x = 0.0,
      y = 0.0,
      z = 0.0,
      wx = (-v.xy * wy - v.xz * wz),
      wy = (v.xy * wx - v.yz * wz),
      wz = (v.xz * wx + v.yz * wy),
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
      wxy = v.xyz * wz,
      wxz = -v.xyz * wy,
      wyz = v.xyz * wx,
      xyz = 0.0,
      i = 0.0,
    )

  infix def cross(v: Motor): BivectorWeight =
    BivectorWeight(
      wx = (-v.xy * wy - v.xz * wz),
      wy = (v.xy * wx - v.yz * wz),
      wz = (v.xz * wx + v.yz * wy),
    )

  infix def cross(v: Plane): Plane =
    Plane(
      w = (v.x * wx + v.y * wy + v.z * wz),
      x = 0.0,
      y = 0.0,
      z = 0.0,
    )

  infix def cross(v: Bivector): BivectorWeight =
    BivectorWeight(
      wx = (-v.xy * wy - v.xz * wz),
      wy = (v.xy * wx - v.yz * wz),
      wz = (v.xz * wx + v.yz * wy),
    )

  infix def cross(v: Point): Vector =
    Vector(
      wxy = v.xyz * wz,
      wxz = -v.xyz * wy,
      wyz = v.xyz * wx,
    )

  infix def cross(v: Quaternion): BivectorWeight =
    BivectorWeight(
      wx = (-v.xy * wy - v.xz * wz),
      wy = (v.xy * wx - v.yz * wz),
      wz = (v.xz * wx + v.yz * wy),
    )

  infix def cross(v: PointNormalized): Vector =
    Vector(
      wxy = wz,
      wxz = -wy,
      wyz = wx,
    )

  infix def cross(v: PlaneIdeal): Plane =
    Plane(
      w = (v.x * wx + v.y * wy + v.z * wz),
      x = 0.0,
      y = 0.0,
      z = 0.0,
    )

  infix def cross(v: BivectorBulk): BivectorWeight =
    BivectorWeight(
      wx = (-v.xy * wy - v.xz * wz),
      wy = (v.xy * wx - v.yz * wz),
      wz = (v.xz * wx + v.yz * wy),
    )

  infix def cross(v: PointCenter.type): Vector =
    Vector(
      wxy = wz,
      wxz = -wy,
      wyz = wx,
    )