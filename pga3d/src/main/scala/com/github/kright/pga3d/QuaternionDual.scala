package com.github.kright.pga3d

/** this code is generated, see com.github.kright.pga3d.codegen.MultivectorSubClass */
case class QuaternionDual(
                           wx: Double = 0.0,
                           wy: Double = 0.0,
                           wz: Double = 0.0,
                           i: Double = 0.0,
                         ):

  def dual: Quaternion =
    Quaternion(
      s = i,
      xy = wz,
      xz = -wy,
      yz = wx,
    )

  def weight: QuaternionDual =
    this

  def reverse: QuaternionDual =
    QuaternionDual(
      wx = -wx,
      wy = -wy,
      wz = -wz,
      i = i,
    )

  def antiReverse: QuaternionDual =
    QuaternionDual(
      wx = -wx,
      wy = -wy,
      wz = -wz,
      i = i,
    )

  def unary_ : QuaternionDual =
    QuaternionDual(
      wx = -wx,
      wy = -wy,
      wz = -wz,
      i = -i,
    )

  def weightNormSquare: Double =
    (i * i + wx * wx + wy * wy + wz * wz)

  def normSquare: Double =
    (i * i + wx * wx + wy * wy + wz * wz)

  def weightNorm: Double =
    Math.sqrt(weightNormSquare)

  def normalizedByWeight =
    this / weightNorm

  def norm: Double =
    Math.sqrt(normSquare)

  def normalizedByNorm =
    this / norm

  def *(v: Double): QuaternionDual =
    QuaternionDual(
      wx = v * wx,
      wy = v * wy,
      wz = v * wz,
      i = i * v,
    )

  inline def /(v: Double): QuaternionDual =
    this * (1.0 / v)

  def +(v: QuaternionDual): QuaternionDual =
    QuaternionDual(
      wx = (v.wx + wx),
      wy = (v.wy + wy),
      wz = (v.wz + wz),
      i = (i + v.i),
    )

  def -(v: QuaternionDual): QuaternionDual =
    QuaternionDual(
      wx = (wx - v.wx),
      wy = (wy - v.wy),
      wz = (wz - v.wz),
      i = (i - v.i),
    )

  def madd(v: QuaternionDual, mult: Double): QuaternionDual =
    QuaternionDual(
      wx = (wx + mult * v.wx),
      wy = (wy + mult * v.wy),
      wz = (wz + mult * v.wz),
      i = (i + mult * v.i),
    )

  def multiplyElementwise(v: QuaternionDual): QuaternionDual =
    QuaternionDual(
      wx = v.wx * wx,
      wy = v.wy * wy,
      wz = v.wz * wz,
      i = i * v.i,
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
      i = i,
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
      i = i,
    )

  infix def geometric(v: Multivector): Multivector =
    Multivector(
      s = 0.0,
      w = (v.x * wx + v.y * wy + v.z * wz - i * v.xyz),
      x = 0.0,
      y = 0.0,
      z = 0.0,
      wx = (v.s * wx - i * v.yz - v.xy * wy - v.xz * wz),
      wy = (i * v.xz + v.s * wy + v.xy * wx - v.yz * wz),
      wz = (v.s * wz + v.xz * wx + v.yz * wy - i * v.xy),
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
      wxy = (i * v.z + v.xyz * wz + v.y * wx - v.x * wy),
      wxz = (v.z * wx - i * v.y - v.x * wz - v.xyz * wy),
      wyz = (i * v.x + v.xyz * wx + v.z * wy - v.y * wz),
      xyz = 0.0,
      i = (i * v.s + v.xy * wz + v.yz * wx - v.xz * wy),
    )

  infix def geometric(v: Motor): QuaternionDual =
    QuaternionDual(
      wx = (v.s * wx - i * v.yz - v.xy * wy - v.xz * wz),
      wy = (i * v.xz + v.s * wy + v.xy * wx - v.yz * wz),
      wz = (v.s * wz + v.xz * wx + v.yz * wy - i * v.xy),
      i = (i * v.s + v.xy * wz + v.yz * wx - v.xz * wy),
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
      wxy = (i * v.z + v.y * wx - v.x * wy),
      wxz = (v.z * wx - i * v.y - v.x * wz),
      wyz = (i * v.x + v.z * wy - v.y * wz),
      xyz = 0.0,
      i = 0.0,
    )

  infix def geometric(v: Bivector): QuaternionDual =
    QuaternionDual(
      wx = (-i * v.yz - v.xy * wy - v.xz * wz),
      wy = (i * v.xz + v.xy * wx - v.yz * wz),
      wz = (v.xz * wx + v.yz * wy - i * v.xy),
      i = (v.xy * wz + v.yz * wx - v.xz * wy),
    )

  infix def geometric(v: Point): Multivector =
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
      wxy = v.xyz * wz,
      wxz = -v.xyz * wy,
      wyz = v.xyz * wx,
      xyz = 0.0,
      i = 0.0,
    )

  infix def geometric(v: Quaternion): QuaternionDual =
    QuaternionDual(
      wx = (v.s * wx - i * v.yz - v.xy * wy - v.xz * wz),
      wy = (i * v.xz + v.s * wy + v.xy * wx - v.yz * wz),
      wz = (v.s * wz + v.xz * wx + v.yz * wy - i * v.xy),
      i = (i * v.s + v.xy * wz + v.yz * wx - v.xz * wy),
    )

  infix def geometric(v: PointNormalized): Multivector =
    Multivector(
      s = 0.0,
      w = -i,
      x = 0.0,
      y = 0.0,
      z = 0.0,
      wx = 0.0,
      wy = 0.0,
      wz = 0.0,
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
      wxy = wz,
      wxz = -wy,
      wyz = wx,
      xyz = 0.0,
      i = 0.0,
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
      wxy = (i * v.z + v.y * wx - v.x * wy),
      wxz = (v.z * wx - i * v.y - v.x * wz),
      wyz = (i * v.x + v.z * wy - v.y * wz),
      xyz = 0.0,
      i = 0.0,
    )

  infix def geometric(v: BivectorBulk): QuaternionDual =
    QuaternionDual(
      wx = (-i * v.yz - v.xy * wy - v.xz * wz),
      wy = (i * v.xz + v.xy * wx - v.yz * wz),
      wz = (v.xz * wx + v.yz * wy - i * v.xy),
      i = (v.xy * wz + v.yz * wx - v.xz * wy),
    )

  infix def geometric(v: PointCenter.type): Multivector =
    Multivector(
      s = 0.0,
      w = -i,
      x = 0.0,
      y = 0.0,
      z = 0.0,
      wx = 0.0,
      wy = 0.0,
      wz = 0.0,
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
      wxy = wz,
      wxz = -wy,
      wyz = wx,
      xyz = 0.0,
      i = 0.0,
    )

  infix def dot(v: Multivector): Multivector =
    Multivector(
      s = 0.0,
      w = (v.x * wx + v.y * wy + v.z * wz - i * v.xyz),
      x = 0.0,
      y = 0.0,
      z = 0.0,
      wx = (v.s * wx - i * v.yz),
      wy = (i * v.xz + v.s * wy),
      wz = (v.s * wz - i * v.xy),
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
      wx = (v.s * wx - i * v.yz),
      wy = (i * v.xz + v.s * wy),
      wz = (v.s * wz - i * v.xy),
      i = i * v.s,
    )

  infix def dot(v: Plane): Multivector =
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
      wxy = i * v.z,
      wxz = -i * v.y,
      wyz = i * v.x,
      xyz = 0.0,
      i = 0.0,
    )

  infix def dot(v: Bivector): BivectorWeight =
    BivectorWeight(
      wx = -i * v.yz,
      wy = i * v.xz,
      wz = -i * v.xy,
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
      wx = (v.s * wx - i * v.yz),
      wy = (i * v.xz + v.s * wy),
      wz = (v.s * wz - i * v.xy),
      i = i * v.s,
    )

  infix def dot(v: PointNormalized): Plane =
    Plane(
      w = -i,
      x = 0.0,
      y = 0.0,
      z = 0.0,
    )

  infix def dot(v: PlaneIdeal): Multivector =
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
      wxy = i * v.z,
      wxz = -i * v.y,
      wyz = i * v.x,
      xyz = 0.0,
      i = 0.0,
    )

  infix def dot(v: BivectorBulk): BivectorWeight =
    BivectorWeight(
      wx = -i * v.yz,
      wy = i * v.xz,
      wz = -i * v.xy,
    )

  infix def dot(v: PointCenter.type): Plane =
    Plane(
      w = -i,
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
      i = (i * v.s + v.xy * wz + v.yz * wx - v.xz * wy),
    )

  inline infix def ^(v: Multivector): Multivector = wedge(v)

  infix def wedge(v: Motor): QuaternionDual =
    QuaternionDual(
      wx = v.s * wx,
      wy = v.s * wy,
      wz = v.s * wz,
      i = (i * v.s + v.xy * wz + v.yz * wx - v.xz * wy),
    )

  inline infix def ^(v: Motor): QuaternionDual = wedge(v)

  infix def wedge(v: Plane): PointIdeal =
    PointIdeal(
      wxy = (v.y * wx - v.x * wy),
      wxz = (v.z * wx - v.x * wz),
      wyz = (v.z * wy - v.y * wz),
    )

  inline infix def ^(v: Plane): PointIdeal = wedge(v)

  infix def wedge(v: Bivector): PseudoScalar =
    PseudoScalar(
      i = (v.xy * wz + v.yz * wx - v.xz * wy),
    )

  inline infix def ^(v: Bivector): PseudoScalar = wedge(v)

  infix def wedge(v: Quaternion): QuaternionDual =
    QuaternionDual(
      wx = v.s * wx,
      wy = v.s * wy,
      wz = v.s * wz,
      i = (i * v.s + v.xy * wz + v.yz * wx - v.xz * wy),
    )

  inline infix def ^(v: Quaternion): QuaternionDual = wedge(v)

  infix def wedge(v: PlaneIdeal): PointIdeal =
    PointIdeal(
      wxy = (v.y * wx - v.x * wy),
      wxz = (v.z * wx - v.x * wz),
      wyz = (v.z * wy - v.y * wz),
    )

  inline infix def ^(v: PlaneIdeal): PointIdeal = wedge(v)

  infix def wedge(v: BivectorBulk): PseudoScalar =
    PseudoScalar(
      i = (v.xy * wz + v.yz * wx - v.xz * wy),
    )

  inline infix def ^(v: BivectorBulk): PseudoScalar = wedge(v)

  infix def cross(v: Multivector): Multivector =
    Multivector(
      s = 0.0,
      w = (v.x * wx + v.y * wy + v.z * wz - i * v.xyz),
      x = 0.0,
      y = 0.0,
      z = 0.0,
      wx = (-v.xy * wy - v.xz * wz),
      wy = (v.xy * wx - v.yz * wz),
      wz = (v.xz * wx + v.yz * wy),
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
      wxy = (i * v.z + v.xyz * wz),
      wxz = (-i * v.y - v.xyz * wy),
      wyz = (i * v.x + v.xyz * wx),
      xyz = 0.0,
      i = 0.0,
    )

  infix def cross(v: Motor): BivectorWeight =
    BivectorWeight(
      wx = (-v.xy * wy - v.xz * wz),
      wy = (v.xy * wx - v.yz * wz),
      wz = (v.xz * wx + v.yz * wy),
    )

  infix def cross(v: Plane): Multivector =
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
      wxy = i * v.z,
      wxz = -i * v.y,
      wyz = i * v.x,
      xyz = 0.0,
      i = 0.0,
    )

  infix def cross(v: Bivector): BivectorWeight =
    BivectorWeight(
      wx = (-v.xy * wy - v.xz * wz),
      wy = (v.xy * wx - v.yz * wz),
      wz = (v.xz * wx + v.yz * wy),
    )

  infix def cross(v: Point): Multivector =
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
      wxy = v.xyz * wz,
      wxz = -v.xyz * wy,
      wyz = v.xyz * wx,
      xyz = 0.0,
      i = 0.0,
    )

  infix def cross(v: Quaternion): BivectorWeight =
    BivectorWeight(
      wx = (-v.xy * wy - v.xz * wz),
      wy = (v.xy * wx - v.yz * wz),
      wz = (v.xz * wx + v.yz * wy),
    )

  infix def cross(v: PointNormalized): Multivector =
    Multivector(
      s = 0.0,
      w = -i,
      x = 0.0,
      y = 0.0,
      z = 0.0,
      wx = 0.0,
      wy = 0.0,
      wz = 0.0,
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
      wxy = wz,
      wxz = -wy,
      wyz = wx,
      xyz = 0.0,
      i = 0.0,
    )

  infix def cross(v: PlaneIdeal): Multivector =
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
      wxy = i * v.z,
      wxz = -i * v.y,
      wyz = i * v.x,
      xyz = 0.0,
      i = 0.0,
    )

  infix def cross(v: BivectorBulk): BivectorWeight =
    BivectorWeight(
      wx = (-v.xy * wy - v.xz * wz),
      wy = (v.xy * wx - v.yz * wz),
      wz = (v.xz * wx + v.yz * wy),
    )

  infix def cross(v: PointCenter.type): Multivector =
    Multivector(
      s = 0.0,
      w = -i,
      x = 0.0,
      y = 0.0,
      z = 0.0,
      wx = 0.0,
      wy = 0.0,
      wz = 0.0,
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
      wxy = wz,
      wxz = -wy,
      wyz = wx,
      xyz = 0.0,
      i = 0.0,
    )

  infix def antiGeometric(v: Multivector): Multivector =
    Multivector(
      s = (i * v.s + v.xy * wz + v.yz * wx - v.xz * wy),
      w = (i * v.w + v.wxz * wy - v.wxy * wz - v.wyz * wx),
      x = (i * v.x + v.y * wz - v.xyz * wx - v.z * wy),
      y = (i * v.y + v.z * wx - v.x * wz - v.xyz * wy),
      z = (i * v.z + v.x * wy - v.xyz * wz - v.y * wx),
      wx = (i * v.wx + v.i * wx + v.wy * wz - v.wz * wy),
      wy = (i * v.wy + v.i * wy + v.wz * wx - v.wx * wz),
      wz = (i * v.wz + v.i * wz + v.wx * wy - v.wy * wx),
      xy = (i * v.xy + v.xz * wx + v.yz * wy - v.s * wz),
      xz = (i * v.xz + v.s * wy + v.yz * wz - v.xy * wx),
      yz = (i * v.yz - v.s * wx - v.xy * wy - v.xz * wz),
      wxy = (i * v.wxy + v.w * wz + v.wxz * wx + v.wyz * wy),
      wxz = (i * v.wxz + v.wyz * wz - v.w * wy - v.wxy * wx),
      wyz = (i * v.wyz + v.w * wx - v.wxy * wy - v.wxz * wz),
      xyz = (i * v.xyz + v.x * wx + v.y * wy + v.z * wz),
      i = (i * v.i - v.wx * wx - v.wy * wy - v.wz * wz),
    )

  infix def antiGeometric(v: Motor): Motor =
    Motor(
      s = (i * v.s + v.xy * wz + v.yz * wx - v.xz * wy),
      wx = (i * v.wx + v.i * wx + v.wy * wz - v.wz * wy),
      wy = (i * v.wy + v.i * wy + v.wz * wx - v.wx * wz),
      wz = (i * v.wz + v.i * wz + v.wx * wy - v.wy * wx),
      xy = (i * v.xy + v.xz * wx + v.yz * wy - v.s * wz),
      xz = (i * v.xz + v.s * wy + v.yz * wz - v.xy * wx),
      yz = (i * v.yz - v.s * wx - v.xy * wy - v.xz * wz),
      i = (i * v.i - v.wx * wx - v.wy * wy - v.wz * wz),
    )

  infix def antiGeometric(v: Plane): Multivector =
    Multivector(
      s = 0.0,
      w = i * v.w,
      x = (i * v.x + v.y * wz - v.z * wy),
      y = (i * v.y + v.z * wx - v.x * wz),
      z = (i * v.z + v.x * wy - v.y * wx),
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
      wx = (i * v.wx + v.wy * wz - v.wz * wy),
      wy = (i * v.wy + v.wz * wx - v.wx * wz),
      wz = (i * v.wz + v.wx * wy - v.wy * wx),
      xy = (i * v.xy + v.xz * wx + v.yz * wy),
      xz = (i * v.xz + v.yz * wz - v.xy * wx),
      yz = (i * v.yz - v.xy * wy - v.xz * wz),
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
      wxy = (i * v.wxy + v.wxz * wx + v.wyz * wy),
      wxz = (i * v.wxz + v.wyz * wz - v.wxy * wx),
      wyz = (i * v.wyz - v.wxy * wy - v.wxz * wz),
      xyz = i * v.xyz,
      i = 0.0,
    )

  infix def antiGeometric(v: Quaternion): Quaternion =
    Quaternion(
      s = (i * v.s + v.xy * wz + v.yz * wx - v.xz * wy),
      xy = (i * v.xy + v.xz * wx + v.yz * wy - v.s * wz),
      xz = (i * v.xz + v.s * wy + v.yz * wz - v.xy * wx),
      yz = (i * v.yz - v.s * wx - v.xy * wy - v.xz * wz),
    )

  infix def antiGeometric(v: QuaternionDual): QuaternionDual =
    QuaternionDual(
      wx = (i * v.wx + v.i * wx + v.wy * wz - v.wz * wy),
      wy = (i * v.wy + v.i * wy + v.wz * wx - v.wx * wz),
      wz = (i * v.wz + v.i * wz + v.wx * wy - v.wy * wx),
      i = (i * v.i - v.wx * wx - v.wy * wy - v.wz * wz),
    )

  infix def antiGeometric(v: PointIdeal): Multivector =
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
      wxy = (i * v.wxy + v.wxz * wx + v.wyz * wy),
      wxz = (i * v.wxz + v.wyz * wz - v.wxy * wx),
      wyz = (i * v.wyz - v.wxy * wy - v.wxz * wz),
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
      wxy = (i * v.wxy + v.wxz * wx + v.wyz * wy),
      wxz = (i * v.wxz + v.wyz * wz - v.wxy * wx),
      wyz = (i * v.wyz - v.wxy * wy - v.wxz * wz),
      xyz = i,
      i = 0.0,
    )

  infix def antiGeometric(v: PlaneIdeal): Multivector =
    Multivector(
      s = 0.0,
      w = 0.0,
      x = (i * v.x + v.y * wz - v.z * wy),
      y = (i * v.y + v.z * wx - v.x * wz),
      z = (i * v.z + v.x * wy - v.y * wx),
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
      xy = (i * v.xy + v.xz * wx + v.yz * wy),
      xz = (i * v.xz + v.yz * wz - v.xy * wx),
      yz = (i * v.yz - v.xy * wy - v.xz * wz),
    )

  infix def antiGeometric(v: BivectorWeight): QuaternionDual =
    QuaternionDual(
      wx = (i * v.wx + v.wy * wz - v.wz * wy),
      wy = (i * v.wy + v.wz * wx - v.wx * wz),
      wz = (i * v.wz + v.wx * wy - v.wy * wx),
      i = (-v.wx * wx - v.wy * wy - v.wz * wz),
    )

  infix def antiGeometric(v: PseudoScalar): QuaternionDual =
    QuaternionDual(
      wx = v.i * wx,
      wy = v.i * wy,
      wz = v.i * wz,
      i = i * v.i,
    )

  infix def antiGeometric(v: PointCenter.type): Multivector =
    Multivector(
      s = 0.0,
      w = 0.0,
      x = -wx,
      y = -wy,
      z = -wz,
      wx = 0.0,
      wy = 0.0,
      wz = 0.0,
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
      wxy = 0.0,
      wxz = 0.0,
      wyz = 0.0,
      xyz = i,
      i = 0.0,
    )

  infix def antiDot(v: Multivector): Multivector =
    Multivector(
      s = i * v.s,
      w = i * v.w,
      x = i * v.x,
      y = i * v.y,
      z = i * v.z,
      wx = (i * v.wx + v.i * wx),
      wy = (i * v.wy + v.i * wy),
      wz = (i * v.wz + v.i * wz),
      xy = (i * v.xy - v.s * wz),
      xz = (i * v.xz + v.s * wy),
      yz = (i * v.yz - v.s * wx),
      wxy = (i * v.wxy + v.w * wz + v.wxz * wx + v.wyz * wy),
      wxz = (i * v.wxz + v.wyz * wz - v.w * wy - v.wxy * wx),
      wyz = (i * v.wyz + v.w * wx - v.wxy * wy - v.wxz * wz),
      xyz = (i * v.xyz + v.x * wx + v.y * wy + v.z * wz),
      i = (i * v.i - v.wx * wx - v.wy * wy - v.wz * wz),
    )

  infix def antiDot(v: Motor): Motor =
    Motor(
      s = i * v.s,
      wx = (i * v.wx + v.i * wx),
      wy = (i * v.wy + v.i * wy),
      wz = (i * v.wz + v.i * wz),
      xy = (i * v.xy - v.s * wz),
      xz = (i * v.xz + v.s * wy),
      yz = (i * v.yz - v.s * wx),
      i = (i * v.i - v.wx * wx - v.wy * wy - v.wz * wz),
    )

  infix def antiDot(v: Plane): Multivector =
    Multivector(
      s = 0.0,
      w = i * v.w,
      x = i * v.x,
      y = i * v.y,
      z = i * v.z,
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

  infix def antiDot(v: Bivector): Motor =
    Motor(
      s = 0.0,
      wx = i * v.wx,
      wy = i * v.wy,
      wz = i * v.wz,
      xy = i * v.xy,
      xz = i * v.xz,
      yz = i * v.yz,
      i = (-v.wx * wx - v.wy * wy - v.wz * wz),
    )

  infix def antiDot(v: Point): Point =
    Point(
      wxy = (i * v.wxy + v.wxz * wx + v.wyz * wy),
      wxz = (i * v.wxz + v.wyz * wz - v.wxy * wx),
      wyz = (i * v.wyz - v.wxy * wy - v.wxz * wz),
      xyz = i * v.xyz,
    )

  infix def antiDot(v: Quaternion): Quaternion =
    Quaternion(
      s = i * v.s,
      xy = (i * v.xy - v.s * wz),
      xz = (i * v.xz + v.s * wy),
      yz = (i * v.yz - v.s * wx),
    )

  infix def antiDot(v: QuaternionDual): QuaternionDual =
    QuaternionDual(
      wx = (i * v.wx + v.i * wx),
      wy = (i * v.wy + v.i * wy),
      wz = (i * v.wz + v.i * wz),
      i = (i * v.i - v.wx * wx - v.wy * wy - v.wz * wz),
    )

  infix def antiDot(v: PointIdeal): PointIdeal =
    PointIdeal(
      wxy = (i * v.wxy + v.wxz * wx + v.wyz * wy),
      wxz = (i * v.wxz + v.wyz * wz - v.wxy * wx),
      wyz = (i * v.wyz - v.wxy * wy - v.wxz * wz),
    )

  infix def antiDot(v: PointNormalized): Point =
    Point(
      wxy = (i * v.wxy + v.wxz * wx + v.wyz * wy),
      wxz = (i * v.wxz + v.wyz * wz - v.wxy * wx),
      wyz = (i * v.wyz - v.wxy * wy - v.wxz * wz),
      xyz = i,
    )

  infix def antiDot(v: PlaneIdeal): Multivector =
    Multivector(
      s = 0.0,
      w = 0.0,
      x = i * v.x,
      y = i * v.y,
      z = i * v.z,
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

  infix def antiDot(v: BivectorBulk): BivectorBulk =
    BivectorBulk(
      xy = i * v.xy,
      xz = i * v.xz,
      yz = i * v.yz,
    )

  infix def antiDot(v: BivectorWeight): QuaternionDual =
    QuaternionDual(
      wx = i * v.wx,
      wy = i * v.wy,
      wz = i * v.wz,
      i = (-v.wx * wx - v.wy * wy - v.wz * wz),
    )

  infix def antiDot(v: PseudoScalar): QuaternionDual =
    QuaternionDual(
      wx = v.i * wx,
      wy = v.i * wy,
      wz = v.i * wz,
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
      s = (i * v.s + v.xy * wz + v.yz * wx - v.xz * wy),
      w = (i * v.w + v.wxz * wy - v.wxy * wz - v.wyz * wx),
      x = (i * v.x - v.xyz * wx),
      y = (i * v.y - v.xyz * wy),
      z = (i * v.z - v.xyz * wz),
      wx = (i * v.wx + v.i * wx),
      wy = (i * v.wy + v.i * wy),
      wz = (i * v.wz + v.i * wz),
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
      s = (i * v.s + v.xy * wz + v.yz * wx - v.xz * wy),
      wx = (i * v.wx + v.i * wx),
      wy = (i * v.wy + v.i * wy),
      wz = (i * v.wz + v.i * wz),
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

  infix def antiWedge(v: Bivector): Motor =
    Motor(
      s = (v.xy * wz + v.yz * wx - v.xz * wy),
      wx = i * v.wx,
      wy = i * v.wy,
      wz = i * v.wz,
      xy = i * v.xy,
      xz = i * v.xz,
      yz = i * v.yz,
      i = 0.0,
    )

  inline infix def v(v: Bivector): Motor = antiWedge(v)

  infix def antiWedge(v: Point): Multivector =
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
      wxy = i * v.wxy,
      wxz = i * v.wxz,
      wyz = i * v.wyz,
      xyz = i * v.xyz,
      i = 0.0,
    )

  inline infix def v(v: Point): Multivector = antiWedge(v)

  infix def antiWedge(v: Quaternion): Quaternion =
    Quaternion(
      s = (i * v.s + v.xy * wz + v.yz * wx - v.xz * wy),
      xy = i * v.xy,
      xz = i * v.xz,
      yz = i * v.yz,
    )

  inline infix def v(v: Quaternion): Quaternion = antiWedge(v)

  infix def antiWedge(v: QuaternionDual): QuaternionDual =
    QuaternionDual(
      wx = (i * v.wx + v.i * wx),
      wy = (i * v.wy + v.i * wy),
      wz = (i * v.wz + v.i * wz),
      i = i * v.i,
    )

  inline infix def v(v: QuaternionDual): QuaternionDual = antiWedge(v)

  infix def antiWedge(v: PointIdeal): Multivector =
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
      wxy = i * v.wxy,
      wxz = i * v.wxz,
      wyz = i * v.wyz,
      xyz = 0.0,
      i = 0.0,
    )

  inline infix def v(v: PointIdeal): Multivector = antiWedge(v)

  infix def antiWedge(v: PointNormalized): Multivector =
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
      wxy = i * v.wxy,
      wxz = i * v.wxz,
      wyz = i * v.wyz,
      xyz = i,
      i = 0.0,
    )

  inline infix def v(v: PointNormalized): Multivector = antiWedge(v)

  infix def antiWedge(v: PlaneIdeal): PlaneIdeal =
    PlaneIdeal(
      x = i * v.x,
      y = i * v.y,
      z = i * v.z,
    )

  inline infix def v(v: PlaneIdeal): PlaneIdeal = antiWedge(v)

  infix def antiWedge(v: BivectorBulk): Quaternion =
    Quaternion(
      s = (v.xy * wz + v.yz * wx - v.xz * wy),
      xy = i * v.xy,
      xz = i * v.xz,
      yz = i * v.yz,
    )

  inline infix def v(v: BivectorBulk): Quaternion = antiWedge(v)

  infix def antiWedge(v: BivectorWeight): BivectorWeight =
    BivectorWeight(
      wx = i * v.wx,
      wy = i * v.wy,
      wz = i * v.wz,
    )

  inline infix def v(v: BivectorWeight): BivectorWeight = antiWedge(v)

  infix def antiWedge(v: PseudoScalar): QuaternionDual =
    QuaternionDual(
      wx = v.i * wx,
      wy = v.i * wy,
      wz = v.i * wz,
      i = i * v.i,
    )

  inline infix def v(v: PseudoScalar): QuaternionDual = antiWedge(v)

  infix def antiWedge(v: PointCenter.type): Multivector =
    Multivector(
      s = 0.0,
      w = 0.0,
      x = -wx,
      y = -wy,
      z = -wz,
      wx = 0.0,
      wy = 0.0,
      wz = 0.0,
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
      wxy = 0.0,
      wxz = 0.0,
      wyz = 0.0,
      xyz = i,
      i = 0.0,
    )

  inline infix def v(v: PointCenter.type): Multivector = antiWedge(v)