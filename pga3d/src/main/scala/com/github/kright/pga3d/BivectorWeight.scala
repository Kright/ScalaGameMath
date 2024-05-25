package com.github.kright.pga3d

/** this code is generated, see com.github.kright.pga3d.codegen.CodeGenClass */
case class BivectorWeight(
                           wx: Double = 0.0,
                           wy: Double = 0.0,
                           wz: Double = 0.0,
                         ):

  def dual: BivectorBulk =
    BivectorBulk(
      xy = wz,
      xz = -wy,
      yz = wx,
    )

  def weight: BivectorWeight =
    this

  def reverse: BivectorWeight =
    BivectorWeight(
      wx = -wx,
      wy = -wy,
      wz = -wz,
    )

  def antiReverse: BivectorWeight =
    BivectorWeight(
      wx = -wx,
      wy = -wy,
      wz = -wz,
    )

  def unary_ : BivectorWeight =
    BivectorWeight(
      wx = -wx,
      wy = -wy,
      wz = -wz,
    )

  def weightNormSquare: Double =
    (wx * wx + wy * wy + wz * wz)

  def normSquare: Double =
    (wx * wx + wy * wy + wz * wz)

  def weightNorm: Double =
    Math.sqrt(weightNormSquare)

  def normalizedByWeight =
    this / weightNorm

  def norm: Double =
    Math.sqrt(normSquare)

  def normalizedByNorm =
    this / norm

  def *(v: Double): BivectorWeight =
    BivectorWeight(
      wx = v * wx,
      wy = v * wy,
      wz = v * wz,
    )

  inline def /(v: Double): BivectorWeight =
    this * (1.0 / v)

  def +(v: Bivector): Bivector =
    Bivector(
      wx = (v.wx + wx),
      wy = (v.wy + wy),
      wz = (v.wz + wz),
      xy = v.xy,
      xz = v.xz,
      yz = v.yz,
    )

  def -(v: Bivector): Bivector =
    Bivector(
      wx = (wx - v.wx),
      wy = (wy - v.wy),
      wz = (wz - v.wz),
      xy = -v.xy,
      xz = -v.xz,
      yz = -v.yz,
    )

  def madd(v: Bivector, mult: Double): Bivector =
    Bivector(
      wx = (wx + mult * v.wx),
      wy = (wy + mult * v.wy),
      wz = (wz + mult * v.wz),
      xy = mult * v.xy,
      xz = mult * v.xz,
      yz = mult * v.yz,
    )

  def +(v: BivectorBulk): Bivector =
    Bivector(
      wx = wx,
      wy = wy,
      wz = wz,
      xy = v.xy,
      xz = v.xz,
      yz = v.yz,
    )

  def -(v: BivectorBulk): Bivector =
    Bivector(
      wx = wx,
      wy = wy,
      wz = wz,
      xy = -v.xy,
      xz = -v.xz,
      yz = -v.yz,
    )

  def madd(v: BivectorBulk, mult: Double): Bivector =
    Bivector(
      wx = wx,
      wy = wy,
      wz = wz,
      xy = mult * v.xy,
      xz = mult * v.xz,
      yz = mult * v.yz,
    )

  def +(v: BivectorWeight): BivectorWeight =
    BivectorWeight(
      wx = (v.wx + wx),
      wy = (v.wy + wy),
      wz = (v.wz + wz),
    )

  def -(v: BivectorWeight): BivectorWeight =
    BivectorWeight(
      wx = (wx - v.wx),
      wy = (wy - v.wy),
      wz = (wz - v.wz),
    )

  def madd(v: BivectorWeight, mult: Double): BivectorWeight =
    BivectorWeight(
      wx = (wx + mult * v.wx),
      wy = (wy + mult * v.wy),
      wz = (wz + mult * v.wz),
    )

  def multiplyElementwise(v: BivectorWeight): BivectorWeight =
    BivectorWeight(
      wx = v.wx * wx,
      wy = v.wy * wy,
      wz = v.wz * wz,
    )

  def exp(): Translator =
    Translator(
      wx = wx,
      wy = wy,
      wz = wz,
    )

  def exp(t: Double): Translator =
    Translator(
      wx = t * wx,
      wy = t * wy,
      wz = t * wz,
    )

  def toMultivector: Multivector =
    Multivector(
      s = 0.0,
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
      s = 0.0,
      wx = wx,
      wy = wy,
      wz = wz,
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
      i = 0.0,
    )

  def toBivector: Bivector =
    Bivector(
      wx = wx,
      wy = wy,
      wz = wz,
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
    )

  infix def geometric(v: Multivector): Multivector =
    Multivector(
      s = 0.0,
      w = (v.x * wx + v.y * wy + v.z * wz),
      x = 0.0,
      y = 0.0,
      z = 0.0,
      wx = (v.s * wx - v.xy * wy - v.xz * wz),
      wy = (v.s * wy + v.xy * wx - v.yz * wz),
      wz = (v.s * wz + v.xz * wx + v.yz * wy),
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
      wxy = (v.xyz * wz + v.y * wx - v.x * wy),
      wxz = (v.z * wx - v.x * wz - v.xyz * wy),
      wyz = (v.xyz * wx + v.z * wy - v.y * wz),
      xyz = 0.0,
      i = (v.xy * wz + v.yz * wx - v.xz * wy),
    )

  infix def geometric(v: Motor): Motor =
    Motor(
      s = 0.0,
      wx = (v.s * wx - v.xy * wy - v.xz * wz),
      wy = (v.s * wy + v.xy * wx - v.yz * wz),
      wz = (v.s * wz + v.xz * wx + v.yz * wy),
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
      i = (v.xy * wz + v.yz * wx - v.xz * wy),
    )

  infix def geometric(v: Plane): Multivector =
    Multivector(
      s = 0.0,
      w = (v.x * wx + v.y * wy + v.z * wz),
      x = 0.0,
      y = 0.0,
      z = 0.0,
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
      wx = (-v.xy * wy - v.xz * wz),
      wy = (v.xy * wx - v.yz * wz),
      wz = (v.xz * wx + v.yz * wy),
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
      i = (v.xy * wz + v.yz * wx - v.xz * wy),
    )

  infix def geometric(v: Point): Vector =
    Vector(
      wxy = v.xyz * wz,
      wxz = -v.xyz * wy,
      wyz = v.xyz * wx,
    )

  infix def geometric(v: Quaternion): Motor =
    Motor(
      s = 0.0,
      wx = (v.s * wx - v.xy * wy - v.xz * wz),
      wy = (v.s * wy + v.xy * wx - v.yz * wz),
      wz = (v.s * wz + v.xz * wx + v.yz * wy),
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
      i = (v.xy * wz + v.yz * wx - v.xz * wy),
    )

  infix def geometric(v: Translator): BivectorWeight =
    BivectorWeight(
      wx = wx,
      wy = wy,
      wz = wz,
    )

  infix def geometric(v: PointNormalized): Vector =
    Vector(
      wxy = wz,
      wxz = -wy,
      wyz = wx,
    )

  infix def geometric(v: PlaneIdeal): Multivector =
    Multivector(
      s = 0.0,
      w = (v.x * wx + v.y * wy + v.z * wz),
      x = 0.0,
      y = 0.0,
      z = 0.0,
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
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
      i = (v.xy * wz + v.yz * wx - v.xz * wy),
    )

  infix def geometric(v: PointCenter.type): Vector =
    Vector(
      wxy = wz,
      wxz = -wy,
      wyz = wx,
    )

  infix def dot(v: Multivector): Multivector =
    Multivector(
      s = 0.0,
      w = (v.x * wx + v.y * wy + v.z * wz),
      x = 0.0,
      y = 0.0,
      z = 0.0,
      wx = v.s * wx,
      wy = v.s * wy,
      wz = v.s * wz,
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
      wxy = 0.0,
      wxz = 0.0,
      wyz = 0.0,
      xyz = 0.0,
      i = 0.0,
    )

  infix def dot(v: Motor): BivectorWeight =
    BivectorWeight(
      wx = v.s * wx,
      wy = v.s * wy,
      wz = v.s * wz,
    )

  infix def dot(v: Plane): Plane =
    Plane(
      w = (v.x * wx + v.y * wy + v.z * wz),
      x = 0.0,
      y = 0.0,
      z = 0.0,
    )

  infix def dot(v: Quaternion): BivectorWeight =
    BivectorWeight(
      wx = v.s * wx,
      wy = v.s * wy,
      wz = v.s * wz,
    )

  infix def dot(v: Translator): BivectorWeight =
    BivectorWeight(
      wx = wx,
      wy = wy,
      wz = wz,
    )

  infix def dot(v: PlaneIdeal): Plane =
    Plane(
      w = (v.x * wx + v.y * wy + v.z * wz),
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
      wx = v.s * wx,
      wy = v.s * wy,
      wz = v.s * wz,
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
      wxy = (v.y * wx - v.x * wy),
      wxz = (v.z * wx - v.x * wz),
      wyz = (v.z * wy - v.y * wz),
      xyz = 0.0,
      i = (v.xy * wz + v.yz * wx - v.xz * wy),
    )

  inline infix def ^(v: Multivector): Multivector = wedge(v)

  infix def wedge(v: Motor): Motor =
    Motor(
      s = 0.0,
      wx = v.s * wx,
      wy = v.s * wy,
      wz = v.s * wz,
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
      i = (v.xy * wz + v.yz * wx - v.xz * wy),
    )

  inline infix def ^(v: Motor): Motor = wedge(v)

  infix def wedge(v: Plane): Vector =
    Vector(
      wxy = (v.y * wx - v.x * wy),
      wxz = (v.z * wx - v.x * wz),
      wyz = (v.z * wy - v.y * wz),
    )

  inline infix def ^(v: Plane): Vector = wedge(v)

  infix def wedge(v: Bivector): PseudoScalar =
    PseudoScalar(
      i = (v.xy * wz + v.yz * wx - v.xz * wy),
    )

  inline infix def ^(v: Bivector): PseudoScalar = wedge(v)

  infix def wedge(v: Quaternion): Motor =
    Motor(
      s = 0.0,
      wx = v.s * wx,
      wy = v.s * wy,
      wz = v.s * wz,
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
      i = (v.xy * wz + v.yz * wx - v.xz * wy),
    )

  inline infix def ^(v: Quaternion): Motor = wedge(v)

  infix def wedge(v: Translator): BivectorWeight =
    BivectorWeight(
      wx = wx,
      wy = wy,
      wz = wz,
    )

  inline infix def ^(v: Translator): BivectorWeight = wedge(v)

  infix def wedge(v: PlaneIdeal): Vector =
    Vector(
      wxy = (v.y * wx - v.x * wy),
      wxz = (v.z * wx - v.x * wz),
      wyz = (v.z * wy - v.y * wz),
    )

  inline infix def ^(v: PlaneIdeal): Vector = wedge(v)

  infix def wedge(v: BivectorBulk): PseudoScalar =
    PseudoScalar(
      i = (v.xy * wz + v.yz * wx - v.xz * wy),
    )

  inline infix def ^(v: BivectorBulk): PseudoScalar = wedge(v)

  infix def antiGeometric(v: Multivector): Multivector =
    Multivector(
      s = (v.xy * wz + v.yz * wx - v.xz * wy),
      w = (v.wxz * wy - v.wxy * wz - v.wyz * wx),
      x = (v.y * wz - v.xyz * wx - v.z * wy),
      y = (v.z * wx - v.x * wz - v.xyz * wy),
      z = (v.x * wy - v.xyz * wz - v.y * wx),
      wx = (v.i * wx + v.wy * wz - v.wz * wy),
      wy = (v.i * wy + v.wz * wx - v.wx * wz),
      wz = (v.i * wz + v.wx * wy - v.wy * wx),
      xy = (v.xz * wx + v.yz * wy - v.s * wz),
      xz = (v.s * wy + v.yz * wz - v.xy * wx),
      yz = (-v.s * wx - v.xy * wy - v.xz * wz),
      wxy = (v.w * wz + v.wxz * wx + v.wyz * wy),
      wxz = (v.wyz * wz - v.w * wy - v.wxy * wx),
      wyz = (v.w * wx - v.wxy * wy - v.wxz * wz),
      xyz = (v.x * wx + v.y * wy + v.z * wz),
      i = (-v.wx * wx - v.wy * wy - v.wz * wz),
    )

  infix def antiGeometric(v: Motor): Motor =
    Motor(
      s = (v.xy * wz + v.yz * wx - v.xz * wy),
      wx = (v.i * wx + v.wy * wz - v.wz * wy),
      wy = (v.i * wy + v.wz * wx - v.wx * wz),
      wz = (v.i * wz + v.wx * wy - v.wy * wx),
      xy = (v.xz * wx + v.yz * wy - v.s * wz),
      xz = (v.s * wy + v.yz * wz - v.xy * wx),
      yz = (-v.s * wx - v.xy * wy - v.xz * wz),
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
      xyz = (v.x * wx + v.y * wy + v.z * wz),
      i = 0.0,
    )

  infix def antiGeometric(v: Bivector): Motor =
    Motor(
      s = (v.xy * wz + v.yz * wx - v.xz * wy),
      wx = (v.wy * wz - v.wz * wy),
      wy = (v.wz * wx - v.wx * wz),
      wz = (v.wx * wy - v.wy * wx),
      xy = (v.xz * wx + v.yz * wy),
      xz = (v.yz * wz - v.xy * wx),
      yz = (-v.xy * wy - v.xz * wz),
      i = (-v.wx * wx - v.wy * wy - v.wz * wz),
    )

  infix def antiGeometric(v: Point): Multivector =
    Multivector(
      s = 0.0,
      w = (v.wxz * wy - v.wxy * wz - v.wyz * wx),
      x = -v.xyz * wx,
      y = -v.xyz * wy,
      z = -v.xyz * wz,
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
      xy = -wz,
      xz = wy,
      yz = -wx,
      i = (-v.wx * wx - v.wy * wy - v.wz * wz),
    )

  infix def antiGeometric(v: Vector): Multivector =
    Multivector(
      s = 0.0,
      w = (v.wxz * wy - v.wxy * wz - v.wyz * wx),
      x = 0.0,
      y = 0.0,
      z = 0.0,
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
      x = -wx,
      y = -wy,
      z = -wz,
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
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
      i = (-v.wx * wx - v.wy * wy - v.wz * wz),
    )

  infix def antiGeometric(v: PseudoScalar): BivectorWeight =
    BivectorWeight(
      wx = v.i * wx,
      wy = v.i * wy,
      wz = v.i * wz,
    )

  infix def antiGeometric(v: PointCenter.type): PlaneIdeal =
    PlaneIdeal(
      x = -wx,
      y = -wy,
      z = -wz,
    )

  infix def antiDot(v: Multivector): Multivector =
    Multivector(
      s = 0.0,
      w = 0.0,
      x = 0.0,
      y = 0.0,
      z = 0.0,
      wx = v.i * wx,
      wy = v.i * wy,
      wz = v.i * wz,
      xy = -v.s * wz,
      xz = v.s * wy,
      yz = -v.s * wx,
      wxy = (v.w * wz + v.wxz * wx + v.wyz * wy),
      wxz = (v.wyz * wz - v.w * wy - v.wxy * wx),
      wyz = (v.w * wx - v.wxy * wy - v.wxz * wz),
      xyz = (v.x * wx + v.y * wy + v.z * wz),
      i = (-v.wx * wx - v.wy * wy - v.wz * wz),
    )

  infix def antiDot(v: Motor): Motor =
    Motor(
      s = 0.0,
      wx = v.i * wx,
      wy = v.i * wy,
      wz = v.i * wz,
      xy = -v.s * wz,
      xz = v.s * wy,
      yz = -v.s * wx,
      i = (-v.wx * wx - v.wy * wy - v.wz * wz),
    )

  infix def antiDot(v: Plane): Point =
    Point(
      wxy = v.w * wz,
      wxz = -v.w * wy,
      wyz = v.w * wx,
      xyz = (v.x * wx + v.y * wy + v.z * wz),
    )

  infix def antiDot(v: Bivector): PseudoScalar =
    PseudoScalar(
      i = (-v.wx * wx - v.wy * wy - v.wz * wz),
    )

  infix def antiDot(v: Point): Vector =
    Vector(
      wxy = (v.wxz * wx + v.wyz * wy),
      wxz = (v.wyz * wz - v.wxy * wx),
      wyz = (-v.wxy * wy - v.wxz * wz),
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
      xy = -wz,
      xz = wy,
      yz = -wx,
      i = (-v.wx * wx - v.wy * wy - v.wz * wz),
    )

  infix def antiDot(v: Vector): Vector =
    Vector(
      wxy = (v.wxz * wx + v.wyz * wy),
      wxz = (v.wyz * wz - v.wxy * wx),
      wyz = (-v.wxy * wy - v.wxz * wz),
    )

  infix def antiDot(v: PointNormalized): Vector =
    Vector(
      wxy = (v.wxz * wx + v.wyz * wy),
      wxz = (v.wyz * wz - v.wxy * wx),
      wyz = (-v.wxy * wy - v.wxz * wz),
    )

  infix def antiDot(v: PlaneIdeal): Point =
    Point(
      wxy = 0.0,
      wxz = 0.0,
      wyz = 0.0,
      xyz = (v.x * wx + v.y * wy + v.z * wz),
    )

  infix def antiDot(v: BivectorWeight): PseudoScalar =
    PseudoScalar(
      i = (-v.wx * wx - v.wy * wy - v.wz * wz),
    )

  infix def antiDot(v: PseudoScalar): BivectorWeight =
    BivectorWeight(
      wx = v.i * wx,
      wy = v.i * wy,
      wz = v.i * wz,
    )

  infix def antiWedge(v: Multivector): Multivector =
    Multivector(
      s = (v.xy * wz + v.yz * wx - v.xz * wy),
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
      s = (v.xy * wz + v.yz * wx - v.xz * wy),
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

  infix def antiWedge(v: PseudoScalar): BivectorWeight =
    BivectorWeight(
      wx = v.i * wx,
      wy = v.i * wy,
      wz = v.i * wz,
    )

  inline infix def v(v: PseudoScalar): BivectorWeight = antiWedge(v)

  infix def antiWedge(v: PointCenter.type): PlaneIdeal =
    PlaneIdeal(
      x = -wx,
      y = -wy,
      z = -wz,
    )

  inline infix def v(v: PointCenter.type): PlaneIdeal = antiWedge(v)

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