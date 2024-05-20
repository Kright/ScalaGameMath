package com.github.kright.pga3d

/** this code is generated, see com.github.kright.pga3d.codegen.MultivectorSubClass */
case class Motor(
                  s: Double = 0.0,
                  wx: Double = 0.0,
                  wy: Double = 0.0,
                  wz: Double = 0.0,
                  xy: Double = 0.0,
                  xz: Double = 0.0,
                  yz: Double = 0.0,
                  i: Double = 0.0,
                ):

  def dual: Motor =
    Motor(
      s = i,
      wx = yz,
      wy = -xz,
      wz = xy,
      xy = wz,
      xz = -wy,
      yz = wx,
      i = s,
    )

  def weight: QuaternionDual =
    QuaternionDual(
      wx = wx,
      wy = wy,
      wz = wz,
      i = i,
    )

  def bulk: Quaternion =
    Quaternion(
      s = s,
      xy = xy,
      xz = xz,
      yz = yz,
    )

  def reverse: Motor =
    Motor(
      s = s,
      wx = -wx,
      wy = -wy,
      wz = -wz,
      xy = -xy,
      xz = -xz,
      yz = -yz,
      i = i,
    )

  def antiReverse: Motor =
    Motor(
      s = s,
      wx = -wx,
      wy = -wy,
      wz = -wz,
      xy = -xy,
      xz = -xz,
      yz = -yz,
      i = i,
    )

  def unary_ : Motor =
    Motor(
      s = -s,
      wx = -wx,
      wy = -wy,
      wz = -wz,
      xy = -xy,
      xz = -xz,
      yz = -yz,
      i = -i,
    )

  def bulkNormSquare: Double =
    (s * s + xy * xy + xz * xz + yz * yz)

  def weightNormSquare: Double =
    (i * i + wx * wx + wy * wy + wz * wz)

  def normSquare: Double =
    (i * i + s * s + wx * wx + wy * wy + wz * wz + xy * xy + xz * xz + yz * yz)

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
      s = s * v,
      wx = v * wx,
      wy = v * wy,
      wz = v * wz,
      xy = v * xy,
      xz = v * xz,
      yz = v * yz,
      i = i * v,
    )

  inline def /(v: Double): Motor =
    this * (1.0 / v)

  def +(v: Motor): Motor =
    Motor(
      s = (s + v.s),
      wx = (v.wx + wx),
      wy = (v.wy + wy),
      wz = (v.wz + wz),
      xy = (v.xy + xy),
      xz = (v.xz + xz),
      yz = (v.yz + yz),
      i = (i + v.i),
    )

  def -(v: Motor): Motor =
    Motor(
      s = (s - v.s),
      wx = (wx - v.wx),
      wy = (wy - v.wy),
      wz = (wz - v.wz),
      xy = (xy - v.xy),
      xz = (xz - v.xz),
      yz = (yz - v.yz),
      i = (i - v.i),
    )

  def madd(v: Motor, mult: Double): Motor =
    Motor(
      s = (s + mult * v.s),
      wx = (wx + mult * v.wx),
      wy = (wy + mult * v.wy),
      wz = (wz + mult * v.wz),
      xy = (xy + mult * v.xy),
      xz = (xz + mult * v.xz),
      yz = (yz + mult * v.yz),
      i = (i + mult * v.i),
    )

  def toMultivector: Multivector =
    Multivector(
      s = s,
      w = 0.0,
      x = 0.0,
      y = 0.0,
      z = 0.0,
      wx = wx,
      wy = wy,
      wz = wz,
      xy = xy,
      xz = xz,
      yz = yz,
      wxy = 0.0,
      wxz = 0.0,
      wyz = 0.0,
      xyz = 0.0,
      i = i,
    )

  infix def multiplyElementwise(v: Multivector): Motor =
    Motor(
      s = s * v.s,
      wx = v.wx * wx,
      wy = v.wy * wy,
      wz = v.wz * wz,
      xy = v.xy * xy,
      xz = v.xz * xz,
      yz = v.yz * yz,
      i = i * v.i,
    )

  infix def multiplyElementwise(v: Motor): Motor =
    Motor(
      s = s * v.s,
      wx = v.wx * wx,
      wy = v.wy * wy,
      wz = v.wz * wz,
      xy = v.xy * xy,
      xz = v.xz * xz,
      yz = v.yz * yz,
      i = i * v.i,
    )

  infix def multiplyElementwise(v: Bivector): Bivector =
    Bivector(
      wx = v.wx * wx,
      wy = v.wy * wy,
      wz = v.wz * wz,
      xy = v.xy * xy,
      xz = v.xz * xz,
      yz = v.yz * yz,
    )

  infix def multiplyElementwise(v: Quaternion): Quaternion =
    Quaternion(
      s = s * v.s,
      xy = v.xy * xy,
      xz = v.xz * xz,
      yz = v.yz * yz,
    )

  infix def multiplyElementwise(v: QuaternionDual): QuaternionDual =
    QuaternionDual(
      wx = v.wx * wx,
      wy = v.wy * wy,
      wz = v.wz * wz,
      i = i * v.i,
    )

  infix def multiplyElementwise(v: PseudoScalar): PseudoScalar =
    PseudoScalar(
      i = i * v.i,
    )

  infix def geometric(v: Multivector): Multivector =
    Multivector(
      s = (s * v.s - v.xy * xy - v.xz * xz - v.yz * yz),
      w = (s * v.w + v.x * wx + v.y * wy + v.z * wz - i * v.xyz - v.wxy * xy - v.wxz * xz - v.wyz * yz),
      x = (s * v.x + v.y * xy + v.z * xz - v.xyz * yz),
      y = (s * v.y + v.xyz * xz + v.z * yz - v.x * xy),
      z = (s * v.z - v.x * xz - v.xyz * xy - v.y * yz),
      wx = (s * v.wx + v.s * wx + v.wy * xy + v.wz * xz - i * v.yz - v.i * yz - v.xy * wy - v.xz * wz),
      wy = (i * v.xz + s * v.wy + v.i * xz + v.s * wy + v.wz * yz + v.xy * wx - v.wx * xy - v.yz * wz),
      wz = (s * v.wz + v.s * wz + v.xz * wx + v.yz * wy - i * v.xy - v.i * xy - v.wx * xz - v.wy * yz),
      xy = (s * v.xy + v.s * xy + v.xz * yz - v.yz * xz),
      xz = (s * v.xz + v.s * xz + v.yz * xy - v.xy * yz),
      yz = (s * v.yz + v.s * yz + v.xy * xz - v.xz * xy),
      wxy = (i * v.z + s * v.wxy + v.w * xy + v.wxz * yz + v.xyz * wz + v.y * wx - v.wyz * xz - v.x * wy),
      wxz = (s * v.wxz + v.w * xz + v.wyz * xy + v.z * wx - i * v.y - v.wxy * yz - v.x * wz - v.xyz * wy),
      wyz = (i * v.x + s * v.wyz + v.w * yz + v.wxy * xz + v.xyz * wx + v.z * wy - v.wxz * xy - v.y * wz),
      xyz = (s * v.xyz + v.x * yz + v.z * xy - v.y * xz),
      i = (i * v.s + s * v.i + v.wx * yz + v.wz * xy + v.xy * wz + v.yz * wx - v.wy * xz - v.xz * wy),
    )

  infix def geometric(v: Motor): Motor =
    Motor(
      s = (s * v.s - v.xy * xy - v.xz * xz - v.yz * yz),
      wx = (s * v.wx + v.s * wx + v.wy * xy + v.wz * xz - i * v.yz - v.i * yz - v.xy * wy - v.xz * wz),
      wy = (i * v.xz + s * v.wy + v.i * xz + v.s * wy + v.wz * yz + v.xy * wx - v.wx * xy - v.yz * wz),
      wz = (s * v.wz + v.s * wz + v.xz * wx + v.yz * wy - i * v.xy - v.i * xy - v.wx * xz - v.wy * yz),
      xy = (s * v.xy + v.s * xy + v.xz * yz - v.yz * xz),
      xz = (s * v.xz + v.s * xz + v.yz * xy - v.xy * yz),
      yz = (s * v.yz + v.s * yz + v.xy * xz - v.xz * xy),
      i = (i * v.s + s * v.i + v.wx * yz + v.wz * xy + v.xy * wz + v.yz * wx - v.wy * xz - v.xz * wy),
    )

  infix def geometric(v: Plane): Multivector =
    Multivector(
      s = 0.0,
      w = (s * v.w + v.x * wx + v.y * wy + v.z * wz),
      x = (s * v.x + v.y * xy + v.z * xz),
      y = (s * v.y + v.z * yz - v.x * xy),
      z = (s * v.z - v.x * xz - v.y * yz),
      wx = 0.0,
      wy = 0.0,
      wz = 0.0,
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
      wxy = (i * v.z + v.w * xy + v.y * wx - v.x * wy),
      wxz = (v.w * xz + v.z * wx - i * v.y - v.x * wz),
      wyz = (i * v.x + v.w * yz + v.z * wy - v.y * wz),
      xyz = (v.x * yz + v.z * xy - v.y * xz),
      i = 0.0,
    )

  infix def geometric(v: Bivector): Motor =
    Motor(
      s = (-v.xy * xy - v.xz * xz - v.yz * yz),
      wx = (s * v.wx + v.wy * xy + v.wz * xz - i * v.yz - v.xy * wy - v.xz * wz),
      wy = (i * v.xz + s * v.wy + v.wz * yz + v.xy * wx - v.wx * xy - v.yz * wz),
      wz = (s * v.wz + v.xz * wx + v.yz * wy - i * v.xy - v.wx * xz - v.wy * yz),
      xy = (s * v.xy + v.xz * yz - v.yz * xz),
      xz = (s * v.xz + v.yz * xy - v.xy * yz),
      yz = (s * v.yz + v.xy * xz - v.xz * xy),
      i = (v.wx * yz + v.wz * xy + v.xy * wz + v.yz * wx - v.wy * xz - v.xz * wy),
    )

  infix def geometric(v: Point): Multivector =
    Multivector(
      s = 0.0,
      w = (-i * v.xyz - v.wxy * xy - v.wxz * xz - v.wyz * yz),
      x = -v.xyz * yz,
      y = v.xyz * xz,
      z = -v.xyz * xy,
      wx = 0.0,
      wy = 0.0,
      wz = 0.0,
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
      wxy = (s * v.wxy + v.wxz * yz + v.xyz * wz - v.wyz * xz),
      wxz = (s * v.wxz + v.wyz * xy - v.wxy * yz - v.xyz * wy),
      wyz = (s * v.wyz + v.wxy * xz + v.xyz * wx - v.wxz * xy),
      xyz = s * v.xyz,
      i = 0.0,
    )

  infix def geometric(v: Quaternion): Motor =
    Motor(
      s = (s * v.s - v.xy * xy - v.xz * xz - v.yz * yz),
      wx = (v.s * wx - i * v.yz - v.xy * wy - v.xz * wz),
      wy = (i * v.xz + v.s * wy + v.xy * wx - v.yz * wz),
      wz = (v.s * wz + v.xz * wx + v.yz * wy - i * v.xy),
      xy = (s * v.xy + v.s * xy + v.xz * yz - v.yz * xz),
      xz = (s * v.xz + v.s * xz + v.yz * xy - v.xy * yz),
      yz = (s * v.yz + v.s * yz + v.xy * xz - v.xz * xy),
      i = (i * v.s + v.xy * wz + v.yz * wx - v.xz * wy),
    )

  infix def geometric(v: QuaternionDual): QuaternionDual =
    QuaternionDual(
      wx = (s * v.wx + v.wy * xy + v.wz * xz - v.i * yz),
      wy = (s * v.wy + v.i * xz + v.wz * yz - v.wx * xy),
      wz = (s * v.wz - v.i * xy - v.wx * xz - v.wy * yz),
      i = (s * v.i + v.wx * yz + v.wz * xy - v.wy * xz),
    )

  infix def geometric(v: PointIdeal): Multivector =
    Multivector(
      s = 0.0,
      w = (-v.wxy * xy - v.wxz * xz - v.wyz * yz),
      x = 0.0,
      y = 0.0,
      z = 0.0,
      wx = 0.0,
      wy = 0.0,
      wz = 0.0,
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
      wxy = (s * v.wxy + v.wxz * yz - v.wyz * xz),
      wxz = (s * v.wxz + v.wyz * xy - v.wxy * yz),
      wyz = (s * v.wyz + v.wxy * xz - v.wxz * xy),
      xyz = 0.0,
      i = 0.0,
    )

  infix def geometric(v: PointNormalized): Multivector =
    Multivector(
      s = 0.0,
      w = (-i - v.wxy * xy - v.wxz * xz - v.wyz * yz),
      x = -yz,
      y = xz,
      z = -xy,
      wx = 0.0,
      wy = 0.0,
      wz = 0.0,
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
      wxy = (wz + s * v.wxy + v.wxz * yz - v.wyz * xz),
      wxz = (-wy + s * v.wxz + v.wyz * xy - v.wxy * yz),
      wyz = (wx + s * v.wyz + v.wxy * xz - v.wxz * xy),
      xyz = s,
      i = 0.0,
    )

  infix def geometric(v: PlaneIdeal): Multivector =
    Multivector(
      s = 0.0,
      w = (v.x * wx + v.y * wy + v.z * wz),
      x = (s * v.x + v.y * xy + v.z * xz),
      y = (s * v.y + v.z * yz - v.x * xy),
      z = (s * v.z - v.x * xz - v.y * yz),
      wx = 0.0,
      wy = 0.0,
      wz = 0.0,
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
      wxy = (i * v.z + v.y * wx - v.x * wy),
      wxz = (v.z * wx - i * v.y - v.x * wz),
      wyz = (i * v.x + v.z * wy - v.y * wz),
      xyz = (v.x * yz + v.z * xy - v.y * xz),
      i = 0.0,
    )

  infix def geometric(v: PseudoScalar): QuaternionDual =
    QuaternionDual(
      wx = -v.i * yz,
      wy = v.i * xz,
      wz = -v.i * xy,
      i = s * v.i,
    )

  infix def geometric(v: PointCenter.type): Multivector =
    Multivector(
      s = 0.0,
      w = -i,
      x = -yz,
      y = xz,
      z = -xy,
      wx = 0.0,
      wy = 0.0,
      wz = 0.0,
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
      wxy = wz,
      wxz = -wy,
      wyz = wx,
      xyz = s,
      i = 0.0,
    )

  infix def dot(v: Multivector): Multivector =
    Multivector(
      s = (s * v.s - v.xy * xy - v.xz * xz - v.yz * yz),
      w = (s * v.w + v.x * wx + v.y * wy + v.z * wz - i * v.xyz - v.wxy * xy - v.wxz * xz - v.wyz * yz),
      x = (s * v.x + v.y * xy + v.z * xz - v.xyz * yz),
      y = (s * v.y + v.xyz * xz + v.z * yz - v.x * xy),
      z = (s * v.z - v.x * xz - v.xyz * xy - v.y * yz),
      wx = (s * v.wx + v.s * wx - i * v.yz - v.i * yz),
      wy = (i * v.xz + s * v.wy + v.i * xz + v.s * wy),
      wz = (s * v.wz + v.s * wz - i * v.xy - v.i * xy),
      xy = (s * v.xy + v.s * xy),
      xz = (s * v.xz + v.s * xz),
      yz = (s * v.yz + v.s * yz),
      wxy = (i * v.z + s * v.wxy),
      wxz = (s * v.wxz - i * v.y),
      wyz = (i * v.x + s * v.wyz),
      xyz = s * v.xyz,
      i = (i * v.s + s * v.i),
    )

  infix def dot(v: Motor): Motor =
    Motor(
      s = (s * v.s - v.xy * xy - v.xz * xz - v.yz * yz),
      wx = (s * v.wx + v.s * wx - i * v.yz - v.i * yz),
      wy = (i * v.xz + s * v.wy + v.i * xz + v.s * wy),
      wz = (s * v.wz + v.s * wz - i * v.xy - v.i * xy),
      xy = (s * v.xy + v.s * xy),
      xz = (s * v.xz + v.s * xz),
      yz = (s * v.yz + v.s * yz),
      i = (i * v.s + s * v.i),
    )

  infix def dot(v: Plane): Multivector =
    Multivector(
      s = 0.0,
      w = (s * v.w + v.x * wx + v.y * wy + v.z * wz),
      x = (s * v.x + v.y * xy + v.z * xz),
      y = (s * v.y + v.z * yz - v.x * xy),
      z = (s * v.z - v.x * xz - v.y * yz),
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

  infix def dot(v: Bivector): Motor =
    Motor(
      s = (-v.xy * xy - v.xz * xz - v.yz * yz),
      wx = (s * v.wx - i * v.yz),
      wy = (i * v.xz + s * v.wy),
      wz = (s * v.wz - i * v.xy),
      xy = s * v.xy,
      xz = s * v.xz,
      yz = s * v.yz,
      i = 0.0,
    )

  infix def dot(v: Point): Multivector =
    Multivector(
      s = 0.0,
      w = (-i * v.xyz - v.wxy * xy - v.wxz * xz - v.wyz * yz),
      x = -v.xyz * yz,
      y = v.xyz * xz,
      z = -v.xyz * xy,
      wx = 0.0,
      wy = 0.0,
      wz = 0.0,
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
      wxy = s * v.wxy,
      wxz = s * v.wxz,
      wyz = s * v.wyz,
      xyz = s * v.xyz,
      i = 0.0,
    )

  infix def dot(v: Quaternion): Motor =
    Motor(
      s = (s * v.s - v.xy * xy - v.xz * xz - v.yz * yz),
      wx = (v.s * wx - i * v.yz),
      wy = (i * v.xz + v.s * wy),
      wz = (v.s * wz - i * v.xy),
      xy = (s * v.xy + v.s * xy),
      xz = (s * v.xz + v.s * xz),
      yz = (s * v.yz + v.s * yz),
      i = i * v.s,
    )

  infix def dot(v: QuaternionDual): QuaternionDual =
    QuaternionDual(
      wx = (s * v.wx - v.i * yz),
      wy = (s * v.wy + v.i * xz),
      wz = (s * v.wz - v.i * xy),
      i = s * v.i,
    )

  infix def dot(v: PointIdeal): Multivector =
    Multivector(
      s = 0.0,
      w = (-v.wxy * xy - v.wxz * xz - v.wyz * yz),
      x = 0.0,
      y = 0.0,
      z = 0.0,
      wx = 0.0,
      wy = 0.0,
      wz = 0.0,
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
      wxy = s * v.wxy,
      wxz = s * v.wxz,
      wyz = s * v.wyz,
      xyz = 0.0,
      i = 0.0,
    )

  infix def dot(v: PointNormalized): Multivector =
    Multivector(
      s = 0.0,
      w = (-i - v.wxy * xy - v.wxz * xz - v.wyz * yz),
      x = -yz,
      y = xz,
      z = -xy,
      wx = 0.0,
      wy = 0.0,
      wz = 0.0,
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
      wxy = s * v.wxy,
      wxz = s * v.wxz,
      wyz = s * v.wyz,
      xyz = s,
      i = 0.0,
    )

  infix def dot(v: PlaneIdeal): Multivector =
    Multivector(
      s = 0.0,
      w = (v.x * wx + v.y * wy + v.z * wz),
      x = (s * v.x + v.y * xy + v.z * xz),
      y = (s * v.y + v.z * yz - v.x * xy),
      z = (s * v.z - v.x * xz - v.y * yz),
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

  infix def dot(v: PseudoScalar): QuaternionDual =
    QuaternionDual(
      wx = -v.i * yz,
      wy = v.i * xz,
      wz = -v.i * xy,
      i = s * v.i,
    )

  infix def dot(v: PointCenter.type): Multivector =
    Multivector(
      s = 0.0,
      w = -i,
      x = -yz,
      y = xz,
      z = -xy,
      wx = 0.0,
      wy = 0.0,
      wz = 0.0,
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
      wxy = 0.0,
      wxz = 0.0,
      wyz = 0.0,
      xyz = s,
      i = 0.0,
    )

  infix def wedge(v: Multivector): Multivector =
    Multivector(
      s = s * v.s,
      w = s * v.w,
      x = s * v.x,
      y = s * v.y,
      z = s * v.z,
      wx = (s * v.wx + v.s * wx),
      wy = (s * v.wy + v.s * wy),
      wz = (s * v.wz + v.s * wz),
      xy = (s * v.xy + v.s * xy),
      xz = (s * v.xz + v.s * xz),
      yz = (s * v.yz + v.s * yz),
      wxy = (s * v.wxy + v.w * xy + v.y * wx - v.x * wy),
      wxz = (s * v.wxz + v.w * xz + v.z * wx - v.x * wz),
      wyz = (s * v.wyz + v.w * yz + v.z * wy - v.y * wz),
      xyz = (s * v.xyz + v.x * yz + v.z * xy - v.y * xz),
      i = (i * v.s + s * v.i + v.wx * yz + v.wz * xy + v.xy * wz + v.yz * wx - v.wy * xz - v.xz * wy),
    )

  inline infix def ^(v: Multivector): Multivector = wedge(v)

  infix def wedge(v: Motor): Motor =
    Motor(
      s = s * v.s,
      wx = (s * v.wx + v.s * wx),
      wy = (s * v.wy + v.s * wy),
      wz = (s * v.wz + v.s * wz),
      xy = (s * v.xy + v.s * xy),
      xz = (s * v.xz + v.s * xz),
      yz = (s * v.yz + v.s * yz),
      i = (i * v.s + s * v.i + v.wx * yz + v.wz * xy + v.xy * wz + v.yz * wx - v.wy * xz - v.xz * wy),
    )

  inline infix def ^(v: Motor): Motor = wedge(v)

  infix def wedge(v: Plane): Multivector =
    Multivector(
      s = 0.0,
      w = s * v.w,
      x = s * v.x,
      y = s * v.y,
      z = s * v.z,
      wx = 0.0,
      wy = 0.0,
      wz = 0.0,
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
      wxy = (v.w * xy + v.y * wx - v.x * wy),
      wxz = (v.w * xz + v.z * wx - v.x * wz),
      wyz = (v.w * yz + v.z * wy - v.y * wz),
      xyz = (v.x * yz + v.z * xy - v.y * xz),
      i = 0.0,
    )

  inline infix def ^(v: Plane): Multivector = wedge(v)

  infix def wedge(v: Bivector): Motor =
    Motor(
      s = 0.0,
      wx = s * v.wx,
      wy = s * v.wy,
      wz = s * v.wz,
      xy = s * v.xy,
      xz = s * v.xz,
      yz = s * v.yz,
      i = (v.wx * yz + v.wz * xy + v.xy * wz + v.yz * wx - v.wy * xz - v.xz * wy),
    )

  inline infix def ^(v: Bivector): Motor = wedge(v)

  infix def wedge(v: Point): Point =
    Point(
      wxy = s * v.wxy,
      wxz = s * v.wxz,
      wyz = s * v.wyz,
      xyz = s * v.xyz,
    )

  inline infix def ^(v: Point): Point = wedge(v)

  infix def wedge(v: Quaternion): Motor =
    Motor(
      s = s * v.s,
      wx = v.s * wx,
      wy = v.s * wy,
      wz = v.s * wz,
      xy = (s * v.xy + v.s * xy),
      xz = (s * v.xz + v.s * xz),
      yz = (s * v.yz + v.s * yz),
      i = (i * v.s + v.xy * wz + v.yz * wx - v.xz * wy),
    )

  inline infix def ^(v: Quaternion): Motor = wedge(v)

  infix def wedge(v: QuaternionDual): QuaternionDual =
    QuaternionDual(
      wx = s * v.wx,
      wy = s * v.wy,
      wz = s * v.wz,
      i = (s * v.i + v.wx * yz + v.wz * xy - v.wy * xz),
    )

  inline infix def ^(v: QuaternionDual): QuaternionDual = wedge(v)

  infix def wedge(v: PointIdeal): PointIdeal =
    PointIdeal(
      wxy = s * v.wxy,
      wxz = s * v.wxz,
      wyz = s * v.wyz,
    )

  inline infix def ^(v: PointIdeal): PointIdeal = wedge(v)

  infix def wedge(v: PointNormalized): Point =
    Point(
      wxy = s * v.wxy,
      wxz = s * v.wxz,
      wyz = s * v.wyz,
      xyz = s,
    )

  inline infix def ^(v: PointNormalized): Point = wedge(v)

  infix def wedge(v: PlaneIdeal): Multivector =
    Multivector(
      s = 0.0,
      w = 0.0,
      x = s * v.x,
      y = s * v.y,
      z = s * v.z,
      wx = 0.0,
      wy = 0.0,
      wz = 0.0,
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
      wxy = (v.y * wx - v.x * wy),
      wxz = (v.z * wx - v.x * wz),
      wyz = (v.z * wy - v.y * wz),
      xyz = (v.x * yz + v.z * xy - v.y * xz),
      i = 0.0,
    )

  inline infix def ^(v: PlaneIdeal): Multivector = wedge(v)

  infix def wedge(v: PseudoScalar): PseudoScalar =
    PseudoScalar(
      i = s * v.i,
    )

  inline infix def ^(v: PseudoScalar): PseudoScalar = wedge(v)

  infix def wedge(v: PointCenter.type): Point =
    Point(
      wxy = 0.0,
      wxz = 0.0,
      wyz = 0.0,
      xyz = s,
    )

  inline infix def ^(v: PointCenter.type): Point = wedge(v)

  infix def sandwich(v: Multivector): Multivector =
    Multivector(
      s = (s * s * v.s + v.s * xy * xy + v.s * xz * xz + v.s * yz * yz),
      w = (s * s * v.w + v.w * xy * xy + v.w * xz * xz + v.w * yz * yz - 2.0 * i * v.y * xz - 2.0 * v.x * wy * xy - 2.0 * v.x * wz * xz - 2.0 * v.y * wz * yz + 2.0 * i * v.x * yz + 2.0 * i * v.z * xy + 2.0 * s * v.x * wx + 2.0 * s * v.y * wy + 2.0 * s * v.z * wz + 2.0 * v.y * wx * xy + 2.0 * v.z * wx * xz + 2.0 * v.z * wy * yz),
      x = (s * s * v.x + v.x * yz * yz - 2.0 * v.y * xz * yz - v.x * xy * xy - v.x * xz * xz + 2.0 * s * v.y * xy + 2.0 * s * v.z * xz + 2.0 * v.z * xy * yz),
      y = (s * s * v.y + v.y * xz * xz - 2.0 * s * v.x * xy - 2.0 * v.x * xz * yz - 2.0 * v.z * xy * xz - v.y * xy * xy - v.y * yz * yz + 2.0 * s * v.z * yz),
      z = (s * s * v.z + v.z * xy * xy - 2.0 * s * v.x * xz - 2.0 * s * v.y * yz - 2.0 * v.y * xy * xz - v.z * xz * xz - v.z * yz * yz + 2.0 * v.x * xy * yz),
      wx = (s * s * v.wx + v.wx * yz * yz - 2.0 * i * s * v.yz - 2.0 * i * v.xy * xz - 2.0 * s * v.xy * wy - 2.0 * s * v.xz * wz - 2.0 * v.wy * xz * yz - 2.0 * v.xz * wy * yz - 2.0 * v.yz * wz * xy - v.wx * xy * xy - v.wx * xz * xz + 2.0 * i * v.xz * xy + 2.0 * s * v.wy * xy + 2.0 * s * v.wz * xz + 2.0 * v.wz * xy * yz + 2.0 * v.xy * wx * xy + 2.0 * v.xy * wz * yz + 2.0 * v.xz * wx * xz + 2.0 * v.yz * wx * yz + 2.0 * v.yz * wy * xz),
      wy = (s * s * v.wy + v.wy * xz * xz - 2.0 * i * v.xy * yz - 2.0 * s * v.wx * xy - 2.0 * s * v.yz * wz - 2.0 * v.wx * xz * yz - 2.0 * v.wz * xy * xz - 2.0 * v.xy * wz * xz - 2.0 * v.yz * wx * xz - v.wy * xy * xy - v.wy * yz * yz + 2.0 * i * s * v.xz + 2.0 * i * v.yz * xy + 2.0 * s * v.wz * yz + 2.0 * s * v.xy * wx + 2.0 * v.xy * wy * xy + 2.0 * v.xz * wx * yz + 2.0 * v.xz * wy * xz + 2.0 * v.xz * wz * xy + 2.0 * v.yz * wy * yz),
      wz = (s * s * v.wz + v.wz * xy * xy - 2.0 * i * s * v.xy - 2.0 * i * v.xz * yz - 2.0 * s * v.wx * xz - 2.0 * s * v.wy * yz - 2.0 * v.wy * xy * xz - 2.0 * v.xy * wx * yz - 2.0 * v.xz * wy * xy - v.wz * xz * xz - v.wz * yz * yz + 2.0 * i * v.yz * xz + 2.0 * s * v.xz * wx + 2.0 * s * v.yz * wy + 2.0 * v.wx * xy * yz + 2.0 * v.xy * wy * xz + 2.0 * v.xy * wz * xy + 2.0 * v.xz * wz * xz + 2.0 * v.yz * wx * xy + 2.0 * v.yz * wz * yz),
      xy = (s * s * v.xy + v.xy * xy * xy - 2.0 * s * v.yz * xz - v.xy * xz * xz - v.xy * yz * yz + 2.0 * s * v.xz * yz + 2.0 * v.xz * xy * xz + 2.0 * v.yz * xy * yz),
      xz = (s * s * v.xz + v.xz * xz * xz - 2.0 * s * v.xy * yz - v.xz * xy * xy - v.xz * yz * yz + 2.0 * s * v.yz * xy + 2.0 * v.xy * xy * xz + 2.0 * v.yz * xz * yz),
      yz = (s * s * v.yz + v.yz * yz * yz - 2.0 * s * v.xz * xy - v.yz * xy * xy - v.yz * xz * xz + 2.0 * s * v.xy * xz + 2.0 * v.xy * xy * yz + 2.0 * v.xz * xz * yz),
      wxy = (s * s * v.wxy + v.wxy * xy * xy - 2.0 * s * v.wyz * xz - 2.0 * v.xyz * wx * xz - 2.0 * v.xyz * wy * yz - v.wxy * xz * xz - v.wxy * yz * yz + 2.0 * i * v.xyz * xy + 2.0 * s * v.wxz * yz + 2.0 * s * v.xyz * wz + 2.0 * v.wxz * xy * xz + 2.0 * v.wyz * xy * yz),
      wxz = (s * s * v.wxz + v.wxz * xz * xz - 2.0 * s * v.wxy * yz - 2.0 * s * v.xyz * wy - 2.0 * v.xyz * wz * yz - v.wxz * xy * xy - v.wxz * yz * yz + 2.0 * i * v.xyz * xz + 2.0 * s * v.wyz * xy + 2.0 * v.wxy * xy * xz + 2.0 * v.wyz * xz * yz + 2.0 * v.xyz * wx * xy),
      wyz = (s * s * v.wyz + v.wyz * yz * yz - 2.0 * s * v.wxz * xy - v.wyz * xy * xy - v.wyz * xz * xz + 2.0 * i * v.xyz * yz + 2.0 * s * v.wxy * xz + 2.0 * s * v.xyz * wx + 2.0 * v.wxy * xy * yz + 2.0 * v.wxz * xz * yz + 2.0 * v.xyz * wy * xy + 2.0 * v.xyz * wz * xz),
      xyz = (s * s * v.xyz + v.xyz * xy * xy + v.xyz * xz * xz + v.xyz * yz * yz),
      i = (s * s * v.i + v.i * xy * xy + v.i * xz * xz + v.i * yz * yz - 2.0 * v.s * wx * yz - 2.0 * v.s * wz * xy + 2.0 * i * s * v.s + 2.0 * v.s * wy * xz),
    )

  infix def sandwich(v: Motor): Motor =
    Motor(
      s = (s * s * v.s + v.s * xy * xy + v.s * xz * xz + v.s * yz * yz),
      wx = (s * s * v.wx + v.wx * yz * yz - 2.0 * i * s * v.yz - 2.0 * i * v.xy * xz - 2.0 * s * v.xy * wy - 2.0 * s * v.xz * wz - 2.0 * v.wy * xz * yz - 2.0 * v.xz * wy * yz - 2.0 * v.yz * wz * xy - v.wx * xy * xy - v.wx * xz * xz + 2.0 * i * v.xz * xy + 2.0 * s * v.wy * xy + 2.0 * s * v.wz * xz + 2.0 * v.wz * xy * yz + 2.0 * v.xy * wx * xy + 2.0 * v.xy * wz * yz + 2.0 * v.xz * wx * xz + 2.0 * v.yz * wx * yz + 2.0 * v.yz * wy * xz),
      wy = (s * s * v.wy + v.wy * xz * xz - 2.0 * i * v.xy * yz - 2.0 * s * v.wx * xy - 2.0 * s * v.yz * wz - 2.0 * v.wx * xz * yz - 2.0 * v.wz * xy * xz - 2.0 * v.xy * wz * xz - 2.0 * v.yz * wx * xz - v.wy * xy * xy - v.wy * yz * yz + 2.0 * i * s * v.xz + 2.0 * i * v.yz * xy + 2.0 * s * v.wz * yz + 2.0 * s * v.xy * wx + 2.0 * v.xy * wy * xy + 2.0 * v.xz * wx * yz + 2.0 * v.xz * wy * xz + 2.0 * v.xz * wz * xy + 2.0 * v.yz * wy * yz),
      wz = (s * s * v.wz + v.wz * xy * xy - 2.0 * i * s * v.xy - 2.0 * i * v.xz * yz - 2.0 * s * v.wx * xz - 2.0 * s * v.wy * yz - 2.0 * v.wy * xy * xz - 2.0 * v.xy * wx * yz - 2.0 * v.xz * wy * xy - v.wz * xz * xz - v.wz * yz * yz + 2.0 * i * v.yz * xz + 2.0 * s * v.xz * wx + 2.0 * s * v.yz * wy + 2.0 * v.wx * xy * yz + 2.0 * v.xy * wy * xz + 2.0 * v.xy * wz * xy + 2.0 * v.xz * wz * xz + 2.0 * v.yz * wx * xy + 2.0 * v.yz * wz * yz),
      xy = (s * s * v.xy + v.xy * xy * xy - 2.0 * s * v.yz * xz - v.xy * xz * xz - v.xy * yz * yz + 2.0 * s * v.xz * yz + 2.0 * v.xz * xy * xz + 2.0 * v.yz * xy * yz),
      xz = (s * s * v.xz + v.xz * xz * xz - 2.0 * s * v.xy * yz - v.xz * xy * xy - v.xz * yz * yz + 2.0 * s * v.yz * xy + 2.0 * v.xy * xy * xz + 2.0 * v.yz * xz * yz),
      yz = (s * s * v.yz + v.yz * yz * yz - 2.0 * s * v.xz * xy - v.yz * xy * xy - v.yz * xz * xz + 2.0 * s * v.xy * xz + 2.0 * v.xy * xy * yz + 2.0 * v.xz * xz * yz),
      i = (s * s * v.i + v.i * xy * xy + v.i * xz * xz + v.i * yz * yz - 2.0 * v.s * wx * yz - 2.0 * v.s * wz * xy + 2.0 * i * s * v.s + 2.0 * v.s * wy * xz),
    )

  infix def sandwich(v: Plane): Plane =
    Plane(
      w = (s * s * v.w + v.w * xy * xy + v.w * xz * xz + v.w * yz * yz - 2.0 * i * v.y * xz - 2.0 * v.x * wy * xy - 2.0 * v.x * wz * xz - 2.0 * v.y * wz * yz + 2.0 * i * v.x * yz + 2.0 * i * v.z * xy + 2.0 * s * v.x * wx + 2.0 * s * v.y * wy + 2.0 * s * v.z * wz + 2.0 * v.y * wx * xy + 2.0 * v.z * wx * xz + 2.0 * v.z * wy * yz),
      x = (s * s * v.x + v.x * yz * yz - 2.0 * v.y * xz * yz - v.x * xy * xy - v.x * xz * xz + 2.0 * s * v.y * xy + 2.0 * s * v.z * xz + 2.0 * v.z * xy * yz),
      y = (s * s * v.y + v.y * xz * xz - 2.0 * s * v.x * xy - 2.0 * v.x * xz * yz - 2.0 * v.z * xy * xz - v.y * xy * xy - v.y * yz * yz + 2.0 * s * v.z * yz),
      z = (s * s * v.z + v.z * xy * xy - 2.0 * s * v.x * xz - 2.0 * s * v.y * yz - 2.0 * v.y * xy * xz - v.z * xz * xz - v.z * yz * yz + 2.0 * v.x * xy * yz),
    )

  infix def sandwich(v: Bivector): Bivector =
    Bivector(
      wx = (s * s * v.wx + v.wx * yz * yz - 2.0 * i * s * v.yz - 2.0 * i * v.xy * xz - 2.0 * s * v.xy * wy - 2.0 * s * v.xz * wz - 2.0 * v.wy * xz * yz - 2.0 * v.xz * wy * yz - 2.0 * v.yz * wz * xy - v.wx * xy * xy - v.wx * xz * xz + 2.0 * i * v.xz * xy + 2.0 * s * v.wy * xy + 2.0 * s * v.wz * xz + 2.0 * v.wz * xy * yz + 2.0 * v.xy * wx * xy + 2.0 * v.xy * wz * yz + 2.0 * v.xz * wx * xz + 2.0 * v.yz * wx * yz + 2.0 * v.yz * wy * xz),
      wy = (s * s * v.wy + v.wy * xz * xz - 2.0 * i * v.xy * yz - 2.0 * s * v.wx * xy - 2.0 * s * v.yz * wz - 2.0 * v.wx * xz * yz - 2.0 * v.wz * xy * xz - 2.0 * v.xy * wz * xz - 2.0 * v.yz * wx * xz - v.wy * xy * xy - v.wy * yz * yz + 2.0 * i * s * v.xz + 2.0 * i * v.yz * xy + 2.0 * s * v.wz * yz + 2.0 * s * v.xy * wx + 2.0 * v.xy * wy * xy + 2.0 * v.xz * wx * yz + 2.0 * v.xz * wy * xz + 2.0 * v.xz * wz * xy + 2.0 * v.yz * wy * yz),
      wz = (s * s * v.wz + v.wz * xy * xy - 2.0 * i * s * v.xy - 2.0 * i * v.xz * yz - 2.0 * s * v.wx * xz - 2.0 * s * v.wy * yz - 2.0 * v.wy * xy * xz - 2.0 * v.xy * wx * yz - 2.0 * v.xz * wy * xy - v.wz * xz * xz - v.wz * yz * yz + 2.0 * i * v.yz * xz + 2.0 * s * v.xz * wx + 2.0 * s * v.yz * wy + 2.0 * v.wx * xy * yz + 2.0 * v.xy * wy * xz + 2.0 * v.xy * wz * xy + 2.0 * v.xz * wz * xz + 2.0 * v.yz * wx * xy + 2.0 * v.yz * wz * yz),
      xy = (s * s * v.xy + v.xy * xy * xy - 2.0 * s * v.yz * xz - v.xy * xz * xz - v.xy * yz * yz + 2.0 * s * v.xz * yz + 2.0 * v.xz * xy * xz + 2.0 * v.yz * xy * yz),
      xz = (s * s * v.xz + v.xz * xz * xz - 2.0 * s * v.xy * yz - v.xz * xy * xy - v.xz * yz * yz + 2.0 * s * v.yz * xy + 2.0 * v.xy * xy * xz + 2.0 * v.yz * xz * yz),
      yz = (s * s * v.yz + v.yz * yz * yz - 2.0 * s * v.xz * xy - v.yz * xy * xy - v.yz * xz * xz + 2.0 * s * v.xy * xz + 2.0 * v.xy * xy * yz + 2.0 * v.xz * xz * yz),
    )

  infix def sandwich(v: Point): Point =
    Point(
      wxy = (s * s * v.wxy + v.wxy * xy * xy - 2.0 * s * v.wyz * xz - 2.0 * v.xyz * wx * xz - 2.0 * v.xyz * wy * yz - v.wxy * xz * xz - v.wxy * yz * yz + 2.0 * i * v.xyz * xy + 2.0 * s * v.wxz * yz + 2.0 * s * v.xyz * wz + 2.0 * v.wxz * xy * xz + 2.0 * v.wyz * xy * yz),
      wxz = (s * s * v.wxz + v.wxz * xz * xz - 2.0 * s * v.wxy * yz - 2.0 * s * v.xyz * wy - 2.0 * v.xyz * wz * yz - v.wxz * xy * xy - v.wxz * yz * yz + 2.0 * i * v.xyz * xz + 2.0 * s * v.wyz * xy + 2.0 * v.wxy * xy * xz + 2.0 * v.wyz * xz * yz + 2.0 * v.xyz * wx * xy),
      wyz = (s * s * v.wyz + v.wyz * yz * yz - 2.0 * s * v.wxz * xy - v.wyz * xy * xy - v.wyz * xz * xz + 2.0 * i * v.xyz * yz + 2.0 * s * v.wxy * xz + 2.0 * s * v.xyz * wx + 2.0 * v.wxy * xy * yz + 2.0 * v.wxz * xz * yz + 2.0 * v.xyz * wy * xy + 2.0 * v.xyz * wz * xz),
      xyz = (s * s * v.xyz + v.xyz * xy * xy + v.xyz * xz * xz + v.xyz * yz * yz),
    )

  infix def sandwich(v: Quaternion): Motor =
    Motor(
      s = (s * s * v.s + v.s * xy * xy + v.s * xz * xz + v.s * yz * yz),
      wx = (-2.0 * i * s * v.yz - 2.0 * i * v.xy * xz - 2.0 * s * v.xy * wy - 2.0 * s * v.xz * wz - 2.0 * v.xz * wy * yz - 2.0 * v.yz * wz * xy + 2.0 * i * v.xz * xy + 2.0 * v.xy * wx * xy + 2.0 * v.xy * wz * yz + 2.0 * v.xz * wx * xz + 2.0 * v.yz * wx * yz + 2.0 * v.yz * wy * xz),
      wy = (-2.0 * i * v.xy * yz - 2.0 * s * v.yz * wz - 2.0 * v.xy * wz * xz - 2.0 * v.yz * wx * xz + 2.0 * i * s * v.xz + 2.0 * i * v.yz * xy + 2.0 * s * v.xy * wx + 2.0 * v.xy * wy * xy + 2.0 * v.xz * wx * yz + 2.0 * v.xz * wy * xz + 2.0 * v.xz * wz * xy + 2.0 * v.yz * wy * yz),
      wz = (-2.0 * i * s * v.xy - 2.0 * i * v.xz * yz - 2.0 * v.xy * wx * yz - 2.0 * v.xz * wy * xy + 2.0 * i * v.yz * xz + 2.0 * s * v.xz * wx + 2.0 * s * v.yz * wy + 2.0 * v.xy * wy * xz + 2.0 * v.xy * wz * xy + 2.0 * v.xz * wz * xz + 2.0 * v.yz * wx * xy + 2.0 * v.yz * wz * yz),
      xy = (s * s * v.xy + v.xy * xy * xy - 2.0 * s * v.yz * xz - v.xy * xz * xz - v.xy * yz * yz + 2.0 * s * v.xz * yz + 2.0 * v.xz * xy * xz + 2.0 * v.yz * xy * yz),
      xz = (s * s * v.xz + v.xz * xz * xz - 2.0 * s * v.xy * yz - v.xz * xy * xy - v.xz * yz * yz + 2.0 * s * v.yz * xy + 2.0 * v.xy * xy * xz + 2.0 * v.yz * xz * yz),
      yz = (s * s * v.yz + v.yz * yz * yz - 2.0 * s * v.xz * xy - v.yz * xy * xy - v.yz * xz * xz + 2.0 * s * v.xy * xz + 2.0 * v.xy * xy * yz + 2.0 * v.xz * xz * yz),
      i = (-2.0 * v.s * wx * yz - 2.0 * v.s * wz * xy + 2.0 * i * s * v.s + 2.0 * v.s * wy * xz),
    )

  infix def sandwich(v: QuaternionDual): QuaternionDual =
    QuaternionDual(
      wx = (s * s * v.wx + v.wx * yz * yz - 2.0 * v.wy * xz * yz - v.wx * xy * xy - v.wx * xz * xz + 2.0 * s * v.wy * xy + 2.0 * s * v.wz * xz + 2.0 * v.wz * xy * yz),
      wy = (s * s * v.wy + v.wy * xz * xz - 2.0 * s * v.wx * xy - 2.0 * v.wx * xz * yz - 2.0 * v.wz * xy * xz - v.wy * xy * xy - v.wy * yz * yz + 2.0 * s * v.wz * yz),
      wz = (s * s * v.wz + v.wz * xy * xy - 2.0 * s * v.wx * xz - 2.0 * s * v.wy * yz - 2.0 * v.wy * xy * xz - v.wz * xz * xz - v.wz * yz * yz + 2.0 * v.wx * xy * yz),
      i = (s * s * v.i + v.i * xy * xy + v.i * xz * xz + v.i * yz * yz),
    )

  infix def sandwich(v: PointIdeal): PointIdeal =
    PointIdeal(
      wxy = (s * s * v.wxy + v.wxy * xy * xy - 2.0 * s * v.wyz * xz - v.wxy * xz * xz - v.wxy * yz * yz + 2.0 * s * v.wxz * yz + 2.0 * v.wxz * xy * xz + 2.0 * v.wyz * xy * yz),
      wxz = (s * s * v.wxz + v.wxz * xz * xz - 2.0 * s * v.wxy * yz - v.wxz * xy * xy - v.wxz * yz * yz + 2.0 * s * v.wyz * xy + 2.0 * v.wxy * xy * xz + 2.0 * v.wyz * xz * yz),
      wyz = (s * s * v.wyz + v.wyz * yz * yz - 2.0 * s * v.wxz * xy - v.wyz * xy * xy - v.wyz * xz * xz + 2.0 * s * v.wxy * xz + 2.0 * v.wxy * xy * yz + 2.0 * v.wxz * xz * yz),
    )

  infix def sandwich(v: PointNormalized): Point =
    Point(
      wxy = (-2.0 * wx * xz - 2.0 * wy * yz + 2.0 * i * xy + 2.0 * s * wz + s * s * v.wxy + v.wxy * xy * xy - 2.0 * s * v.wyz * xz - v.wxy * xz * xz - v.wxy * yz * yz + 2.0 * s * v.wxz * yz + 2.0 * v.wxz * xy * xz + 2.0 * v.wyz * xy * yz),
      wxz = (-2.0 * s * wy - 2.0 * wz * yz + 2.0 * i * xz + 2.0 * wx * xy + s * s * v.wxz + v.wxz * xz * xz - 2.0 * s * v.wxy * yz - v.wxz * xy * xy - v.wxz * yz * yz + 2.0 * s * v.wyz * xy + 2.0 * v.wxy * xy * xz + 2.0 * v.wyz * xz * yz),
      wyz = (2.0 * i * yz + 2.0 * s * wx + 2.0 * wy * xy + 2.0 * wz * xz + s * s * v.wyz + v.wyz * yz * yz - 2.0 * s * v.wxz * xy - v.wyz * xy * xy - v.wyz * xz * xz + 2.0 * s * v.wxy * xz + 2.0 * v.wxy * xy * yz + 2.0 * v.wxz * xz * yz),
      xyz = (s * s + xy * xy + xz * xz + yz * yz),
    )

  infix def sandwich(v: PlaneIdeal): Plane =
    Plane(
      w = (-2.0 * i * v.y * xz - 2.0 * v.x * wy * xy - 2.0 * v.x * wz * xz - 2.0 * v.y * wz * yz + 2.0 * i * v.x * yz + 2.0 * i * v.z * xy + 2.0 * s * v.x * wx + 2.0 * s * v.y * wy + 2.0 * s * v.z * wz + 2.0 * v.y * wx * xy + 2.0 * v.z * wx * xz + 2.0 * v.z * wy * yz),
      x = (s * s * v.x + v.x * yz * yz - 2.0 * v.y * xz * yz - v.x * xy * xy - v.x * xz * xz + 2.0 * s * v.y * xy + 2.0 * s * v.z * xz + 2.0 * v.z * xy * yz),
      y = (s * s * v.y + v.y * xz * xz - 2.0 * s * v.x * xy - 2.0 * v.x * xz * yz - 2.0 * v.z * xy * xz - v.y * xy * xy - v.y * yz * yz + 2.0 * s * v.z * yz),
      z = (s * s * v.z + v.z * xy * xy - 2.0 * s * v.x * xz - 2.0 * s * v.y * yz - 2.0 * v.y * xy * xz - v.z * xz * xz - v.z * yz * yz + 2.0 * v.x * xy * yz),
    )

  infix def sandwich(v: PseudoScalar): PseudoScalar =
    PseudoScalar(
      i = (s * s * v.i + v.i * xy * xy + v.i * xz * xz + v.i * yz * yz),
    )

  infix def sandwich(v: PointCenter.type): Point =
    Point(
      wxy = (-2.0 * wx * xz - 2.0 * wy * yz + 2.0 * i * xy + 2.0 * s * wz),
      wxz = (-2.0 * s * wy - 2.0 * wz * yz + 2.0 * i * xz + 2.0 * wx * xy),
      wyz = (2.0 * i * yz + 2.0 * s * wx + 2.0 * wy * xy + 2.0 * wz * xz),
      xyz = (s * s + xy * xy + xz * xz + yz * yz),
    )

  infix def reverseSandwich(v: Multivector): Multivector =
    Multivector(
      s = (s * s * v.s + v.s * xy * xy + v.s * xz * xz + v.s * yz * yz),
      w = (s * s * v.w + v.w * xy * xy + v.w * xz * xz + v.w * yz * yz - 2.0 * i * v.x * yz - 2.0 * i * v.z * xy - 2.0 * s * v.x * wx - 2.0 * s * v.y * wy - 2.0 * s * v.z * wz - 2.0 * v.x * wy * xy - 2.0 * v.x * wz * xz - 2.0 * v.y * wz * yz + 2.0 * i * v.y * xz + 2.0 * v.y * wx * xy + 2.0 * v.z * wx * xz + 2.0 * v.z * wy * yz),
      x = (s * s * v.x + v.x * yz * yz - 2.0 * s * v.y * xy - 2.0 * s * v.z * xz - 2.0 * v.y * xz * yz - v.x * xy * xy - v.x * xz * xz + 2.0 * v.z * xy * yz),
      y = (s * s * v.y + v.y * xz * xz - 2.0 * s * v.z * yz - 2.0 * v.x * xz * yz - 2.0 * v.z * xy * xz - v.y * xy * xy - v.y * yz * yz + 2.0 * s * v.x * xy),
      z = (s * s * v.z + v.z * xy * xy - 2.0 * v.y * xy * xz - v.z * xz * xz - v.z * yz * yz + 2.0 * s * v.x * xz + 2.0 * s * v.y * yz + 2.0 * v.x * xy * yz),
      wx = (s * s * v.wx + v.wx * yz * yz - 2.0 * i * s * v.yz - 2.0 * i * v.xz * xy - 2.0 * s * v.wy * xy - 2.0 * s * v.wz * xz - 2.0 * v.wy * xz * yz - 2.0 * v.xz * wy * yz - 2.0 * v.yz * wz * xy - v.wx * xy * xy - v.wx * xz * xz + 2.0 * i * v.xy * xz + 2.0 * s * v.xy * wy + 2.0 * s * v.xz * wz + 2.0 * v.wz * xy * yz + 2.0 * v.xy * wx * xy + 2.0 * v.xy * wz * yz + 2.0 * v.xz * wx * xz + 2.0 * v.yz * wx * yz + 2.0 * v.yz * wy * xz),
      wy = (s * s * v.wy + v.wy * xz * xz - 2.0 * i * v.yz * xy - 2.0 * s * v.wz * yz - 2.0 * s * v.xy * wx - 2.0 * v.wx * xz * yz - 2.0 * v.wz * xy * xz - 2.0 * v.xy * wz * xz - 2.0 * v.yz * wx * xz - v.wy * xy * xy - v.wy * yz * yz + 2.0 * i * s * v.xz + 2.0 * i * v.xy * yz + 2.0 * s * v.wx * xy + 2.0 * s * v.yz * wz + 2.0 * v.xy * wy * xy + 2.0 * v.xz * wx * yz + 2.0 * v.xz * wy * xz + 2.0 * v.xz * wz * xy + 2.0 * v.yz * wy * yz),
      wz = (s * s * v.wz + v.wz * xy * xy - 2.0 * i * s * v.xy - 2.0 * i * v.yz * xz - 2.0 * s * v.xz * wx - 2.0 * s * v.yz * wy - 2.0 * v.wy * xy * xz - 2.0 * v.xy * wx * yz - 2.0 * v.xz * wy * xy - v.wz * xz * xz - v.wz * yz * yz + 2.0 * i * v.xz * yz + 2.0 * s * v.wx * xz + 2.0 * s * v.wy * yz + 2.0 * v.wx * xy * yz + 2.0 * v.xy * wy * xz + 2.0 * v.xy * wz * xy + 2.0 * v.xz * wz * xz + 2.0 * v.yz * wx * xy + 2.0 * v.yz * wz * yz),
      xy = (s * s * v.xy + v.xy * xy * xy - 2.0 * s * v.xz * yz - v.xy * xz * xz - v.xy * yz * yz + 2.0 * s * v.yz * xz + 2.0 * v.xz * xy * xz + 2.0 * v.yz * xy * yz),
      xz = (s * s * v.xz + v.xz * xz * xz - 2.0 * s * v.yz * xy - v.xz * xy * xy - v.xz * yz * yz + 2.0 * s * v.xy * yz + 2.0 * v.xy * xy * xz + 2.0 * v.yz * xz * yz),
      yz = (s * s * v.yz + v.yz * yz * yz - 2.0 * s * v.xy * xz - v.yz * xy * xy - v.yz * xz * xz + 2.0 * s * v.xz * xy + 2.0 * v.xy * xy * yz + 2.0 * v.xz * xz * yz),
      wxy = (s * s * v.wxy + v.wxy * xy * xy - 2.0 * i * v.xyz * xy - 2.0 * s * v.wxz * yz - 2.0 * s * v.xyz * wz - 2.0 * v.xyz * wx * xz - 2.0 * v.xyz * wy * yz - v.wxy * xz * xz - v.wxy * yz * yz + 2.0 * s * v.wyz * xz + 2.0 * v.wxz * xy * xz + 2.0 * v.wyz * xy * yz),
      wxz = (s * s * v.wxz + v.wxz * xz * xz - 2.0 * i * v.xyz * xz - 2.0 * s * v.wyz * xy - 2.0 * v.xyz * wz * yz - v.wxz * xy * xy - v.wxz * yz * yz + 2.0 * s * v.wxy * yz + 2.0 * s * v.xyz * wy + 2.0 * v.wxy * xy * xz + 2.0 * v.wyz * xz * yz + 2.0 * v.xyz * wx * xy),
      wyz = (s * s * v.wyz + v.wyz * yz * yz - 2.0 * i * v.xyz * yz - 2.0 * s * v.wxy * xz - 2.0 * s * v.xyz * wx - v.wyz * xy * xy - v.wyz * xz * xz + 2.0 * s * v.wxz * xy + 2.0 * v.wxy * xy * yz + 2.0 * v.wxz * xz * yz + 2.0 * v.xyz * wy * xy + 2.0 * v.xyz * wz * xz),
      xyz = (s * s * v.xyz + v.xyz * xy * xy + v.xyz * xz * xz + v.xyz * yz * yz),
      i = (s * s * v.i + v.i * xy * xy + v.i * xz * xz + v.i * yz * yz - 2.0 * v.s * wx * yz - 2.0 * v.s * wz * xy + 2.0 * i * s * v.s + 2.0 * v.s * wy * xz),
    )

  infix def reverseSandwich(v: Motor): Motor =
    Motor(
      s = (s * s * v.s + v.s * xy * xy + v.s * xz * xz + v.s * yz * yz),
      wx = (s * s * v.wx + v.wx * yz * yz - 2.0 * i * s * v.yz - 2.0 * i * v.xz * xy - 2.0 * s * v.wy * xy - 2.0 * s * v.wz * xz - 2.0 * v.wy * xz * yz - 2.0 * v.xz * wy * yz - 2.0 * v.yz * wz * xy - v.wx * xy * xy - v.wx * xz * xz + 2.0 * i * v.xy * xz + 2.0 * s * v.xy * wy + 2.0 * s * v.xz * wz + 2.0 * v.wz * xy * yz + 2.0 * v.xy * wx * xy + 2.0 * v.xy * wz * yz + 2.0 * v.xz * wx * xz + 2.0 * v.yz * wx * yz + 2.0 * v.yz * wy * xz),
      wy = (s * s * v.wy + v.wy * xz * xz - 2.0 * i * v.yz * xy - 2.0 * s * v.wz * yz - 2.0 * s * v.xy * wx - 2.0 * v.wx * xz * yz - 2.0 * v.wz * xy * xz - 2.0 * v.xy * wz * xz - 2.0 * v.yz * wx * xz - v.wy * xy * xy - v.wy * yz * yz + 2.0 * i * s * v.xz + 2.0 * i * v.xy * yz + 2.0 * s * v.wx * xy + 2.0 * s * v.yz * wz + 2.0 * v.xy * wy * xy + 2.0 * v.xz * wx * yz + 2.0 * v.xz * wy * xz + 2.0 * v.xz * wz * xy + 2.0 * v.yz * wy * yz),
      wz = (s * s * v.wz + v.wz * xy * xy - 2.0 * i * s * v.xy - 2.0 * i * v.yz * xz - 2.0 * s * v.xz * wx - 2.0 * s * v.yz * wy - 2.0 * v.wy * xy * xz - 2.0 * v.xy * wx * yz - 2.0 * v.xz * wy * xy - v.wz * xz * xz - v.wz * yz * yz + 2.0 * i * v.xz * yz + 2.0 * s * v.wx * xz + 2.0 * s * v.wy * yz + 2.0 * v.wx * xy * yz + 2.0 * v.xy * wy * xz + 2.0 * v.xy * wz * xy + 2.0 * v.xz * wz * xz + 2.0 * v.yz * wx * xy + 2.0 * v.yz * wz * yz),
      xy = (s * s * v.xy + v.xy * xy * xy - 2.0 * s * v.xz * yz - v.xy * xz * xz - v.xy * yz * yz + 2.0 * s * v.yz * xz + 2.0 * v.xz * xy * xz + 2.0 * v.yz * xy * yz),
      xz = (s * s * v.xz + v.xz * xz * xz - 2.0 * s * v.yz * xy - v.xz * xy * xy - v.xz * yz * yz + 2.0 * s * v.xy * yz + 2.0 * v.xy * xy * xz + 2.0 * v.yz * xz * yz),
      yz = (s * s * v.yz + v.yz * yz * yz - 2.0 * s * v.xy * xz - v.yz * xy * xy - v.yz * xz * xz + 2.0 * s * v.xz * xy + 2.0 * v.xy * xy * yz + 2.0 * v.xz * xz * yz),
      i = (s * s * v.i + v.i * xy * xy + v.i * xz * xz + v.i * yz * yz - 2.0 * v.s * wx * yz - 2.0 * v.s * wz * xy + 2.0 * i * s * v.s + 2.0 * v.s * wy * xz),
    )

  infix def reverseSandwich(v: Plane): Plane =
    Plane(
      w = (s * s * v.w + v.w * xy * xy + v.w * xz * xz + v.w * yz * yz - 2.0 * i * v.x * yz - 2.0 * i * v.z * xy - 2.0 * s * v.x * wx - 2.0 * s * v.y * wy - 2.0 * s * v.z * wz - 2.0 * v.x * wy * xy - 2.0 * v.x * wz * xz - 2.0 * v.y * wz * yz + 2.0 * i * v.y * xz + 2.0 * v.y * wx * xy + 2.0 * v.z * wx * xz + 2.0 * v.z * wy * yz),
      x = (s * s * v.x + v.x * yz * yz - 2.0 * s * v.y * xy - 2.0 * s * v.z * xz - 2.0 * v.y * xz * yz - v.x * xy * xy - v.x * xz * xz + 2.0 * v.z * xy * yz),
      y = (s * s * v.y + v.y * xz * xz - 2.0 * s * v.z * yz - 2.0 * v.x * xz * yz - 2.0 * v.z * xy * xz - v.y * xy * xy - v.y * yz * yz + 2.0 * s * v.x * xy),
      z = (s * s * v.z + v.z * xy * xy - 2.0 * v.y * xy * xz - v.z * xz * xz - v.z * yz * yz + 2.0 * s * v.x * xz + 2.0 * s * v.y * yz + 2.0 * v.x * xy * yz),
    )

  infix def reverseSandwich(v: Bivector): Bivector =
    Bivector(
      wx = (s * s * v.wx + v.wx * yz * yz - 2.0 * i * s * v.yz - 2.0 * i * v.xz * xy - 2.0 * s * v.wy * xy - 2.0 * s * v.wz * xz - 2.0 * v.wy * xz * yz - 2.0 * v.xz * wy * yz - 2.0 * v.yz * wz * xy - v.wx * xy * xy - v.wx * xz * xz + 2.0 * i * v.xy * xz + 2.0 * s * v.xy * wy + 2.0 * s * v.xz * wz + 2.0 * v.wz * xy * yz + 2.0 * v.xy * wx * xy + 2.0 * v.xy * wz * yz + 2.0 * v.xz * wx * xz + 2.0 * v.yz * wx * yz + 2.0 * v.yz * wy * xz),
      wy = (s * s * v.wy + v.wy * xz * xz - 2.0 * i * v.yz * xy - 2.0 * s * v.wz * yz - 2.0 * s * v.xy * wx - 2.0 * v.wx * xz * yz - 2.0 * v.wz * xy * xz - 2.0 * v.xy * wz * xz - 2.0 * v.yz * wx * xz - v.wy * xy * xy - v.wy * yz * yz + 2.0 * i * s * v.xz + 2.0 * i * v.xy * yz + 2.0 * s * v.wx * xy + 2.0 * s * v.yz * wz + 2.0 * v.xy * wy * xy + 2.0 * v.xz * wx * yz + 2.0 * v.xz * wy * xz + 2.0 * v.xz * wz * xy + 2.0 * v.yz * wy * yz),
      wz = (s * s * v.wz + v.wz * xy * xy - 2.0 * i * s * v.xy - 2.0 * i * v.yz * xz - 2.0 * s * v.xz * wx - 2.0 * s * v.yz * wy - 2.0 * v.wy * xy * xz - 2.0 * v.xy * wx * yz - 2.0 * v.xz * wy * xy - v.wz * xz * xz - v.wz * yz * yz + 2.0 * i * v.xz * yz + 2.0 * s * v.wx * xz + 2.0 * s * v.wy * yz + 2.0 * v.wx * xy * yz + 2.0 * v.xy * wy * xz + 2.0 * v.xy * wz * xy + 2.0 * v.xz * wz * xz + 2.0 * v.yz * wx * xy + 2.0 * v.yz * wz * yz),
      xy = (s * s * v.xy + v.xy * xy * xy - 2.0 * s * v.xz * yz - v.xy * xz * xz - v.xy * yz * yz + 2.0 * s * v.yz * xz + 2.0 * v.xz * xy * xz + 2.0 * v.yz * xy * yz),
      xz = (s * s * v.xz + v.xz * xz * xz - 2.0 * s * v.yz * xy - v.xz * xy * xy - v.xz * yz * yz + 2.0 * s * v.xy * yz + 2.0 * v.xy * xy * xz + 2.0 * v.yz * xz * yz),
      yz = (s * s * v.yz + v.yz * yz * yz - 2.0 * s * v.xy * xz - v.yz * xy * xy - v.yz * xz * xz + 2.0 * s * v.xz * xy + 2.0 * v.xy * xy * yz + 2.0 * v.xz * xz * yz),
    )

  infix def reverseSandwich(v: Point): Point =
    Point(
      wxy = (s * s * v.wxy + v.wxy * xy * xy - 2.0 * i * v.xyz * xy - 2.0 * s * v.wxz * yz - 2.0 * s * v.xyz * wz - 2.0 * v.xyz * wx * xz - 2.0 * v.xyz * wy * yz - v.wxy * xz * xz - v.wxy * yz * yz + 2.0 * s * v.wyz * xz + 2.0 * v.wxz * xy * xz + 2.0 * v.wyz * xy * yz),
      wxz = (s * s * v.wxz + v.wxz * xz * xz - 2.0 * i * v.xyz * xz - 2.0 * s * v.wyz * xy - 2.0 * v.xyz * wz * yz - v.wxz * xy * xy - v.wxz * yz * yz + 2.0 * s * v.wxy * yz + 2.0 * s * v.xyz * wy + 2.0 * v.wxy * xy * xz + 2.0 * v.wyz * xz * yz + 2.0 * v.xyz * wx * xy),
      wyz = (s * s * v.wyz + v.wyz * yz * yz - 2.0 * i * v.xyz * yz - 2.0 * s * v.wxy * xz - 2.0 * s * v.xyz * wx - v.wyz * xy * xy - v.wyz * xz * xz + 2.0 * s * v.wxz * xy + 2.0 * v.wxy * xy * yz + 2.0 * v.wxz * xz * yz + 2.0 * v.xyz * wy * xy + 2.0 * v.xyz * wz * xz),
      xyz = (s * s * v.xyz + v.xyz * xy * xy + v.xyz * xz * xz + v.xyz * yz * yz),
    )

  infix def reverseSandwich(v: Quaternion): Motor =
    Motor(
      s = (s * s * v.s + v.s * xy * xy + v.s * xz * xz + v.s * yz * yz),
      wx = (-2.0 * i * s * v.yz - 2.0 * i * v.xz * xy - 2.0 * v.xz * wy * yz - 2.0 * v.yz * wz * xy + 2.0 * i * v.xy * xz + 2.0 * s * v.xy * wy + 2.0 * s * v.xz * wz + 2.0 * v.xy * wx * xy + 2.0 * v.xy * wz * yz + 2.0 * v.xz * wx * xz + 2.0 * v.yz * wx * yz + 2.0 * v.yz * wy * xz),
      wy = (-2.0 * i * v.yz * xy - 2.0 * s * v.xy * wx - 2.0 * v.xy * wz * xz - 2.0 * v.yz * wx * xz + 2.0 * i * s * v.xz + 2.0 * i * v.xy * yz + 2.0 * s * v.yz * wz + 2.0 * v.xy * wy * xy + 2.0 * v.xz * wx * yz + 2.0 * v.xz * wy * xz + 2.0 * v.xz * wz * xy + 2.0 * v.yz * wy * yz),
      wz = (-2.0 * i * s * v.xy - 2.0 * i * v.yz * xz - 2.0 * s * v.xz * wx - 2.0 * s * v.yz * wy - 2.0 * v.xy * wx * yz - 2.0 * v.xz * wy * xy + 2.0 * i * v.xz * yz + 2.0 * v.xy * wy * xz + 2.0 * v.xy * wz * xy + 2.0 * v.xz * wz * xz + 2.0 * v.yz * wx * xy + 2.0 * v.yz * wz * yz),
      xy = (s * s * v.xy + v.xy * xy * xy - 2.0 * s * v.xz * yz - v.xy * xz * xz - v.xy * yz * yz + 2.0 * s * v.yz * xz + 2.0 * v.xz * xy * xz + 2.0 * v.yz * xy * yz),
      xz = (s * s * v.xz + v.xz * xz * xz - 2.0 * s * v.yz * xy - v.xz * xy * xy - v.xz * yz * yz + 2.0 * s * v.xy * yz + 2.0 * v.xy * xy * xz + 2.0 * v.yz * xz * yz),
      yz = (s * s * v.yz + v.yz * yz * yz - 2.0 * s * v.xy * xz - v.yz * xy * xy - v.yz * xz * xz + 2.0 * s * v.xz * xy + 2.0 * v.xy * xy * yz + 2.0 * v.xz * xz * yz),
      i = (-2.0 * v.s * wx * yz - 2.0 * v.s * wz * xy + 2.0 * i * s * v.s + 2.0 * v.s * wy * xz),
    )

  infix def reverseSandwich(v: QuaternionDual): QuaternionDual =
    QuaternionDual(
      wx = (s * s * v.wx + v.wx * yz * yz - 2.0 * s * v.wy * xy - 2.0 * s * v.wz * xz - 2.0 * v.wy * xz * yz - v.wx * xy * xy - v.wx * xz * xz + 2.0 * v.wz * xy * yz),
      wy = (s * s * v.wy + v.wy * xz * xz - 2.0 * s * v.wz * yz - 2.0 * v.wx * xz * yz - 2.0 * v.wz * xy * xz - v.wy * xy * xy - v.wy * yz * yz + 2.0 * s * v.wx * xy),
      wz = (s * s * v.wz + v.wz * xy * xy - 2.0 * v.wy * xy * xz - v.wz * xz * xz - v.wz * yz * yz + 2.0 * s * v.wx * xz + 2.0 * s * v.wy * yz + 2.0 * v.wx * xy * yz),
      i = (s * s * v.i + v.i * xy * xy + v.i * xz * xz + v.i * yz * yz),
    )

  infix def reverseSandwich(v: PointIdeal): PointIdeal =
    PointIdeal(
      wxy = (s * s * v.wxy + v.wxy * xy * xy - 2.0 * s * v.wxz * yz - v.wxy * xz * xz - v.wxy * yz * yz + 2.0 * s * v.wyz * xz + 2.0 * v.wxz * xy * xz + 2.0 * v.wyz * xy * yz),
      wxz = (s * s * v.wxz + v.wxz * xz * xz - 2.0 * s * v.wyz * xy - v.wxz * xy * xy - v.wxz * yz * yz + 2.0 * s * v.wxy * yz + 2.0 * v.wxy * xy * xz + 2.0 * v.wyz * xz * yz),
      wyz = (s * s * v.wyz + v.wyz * yz * yz - 2.0 * s * v.wxy * xz - v.wyz * xy * xy - v.wyz * xz * xz + 2.0 * s * v.wxz * xy + 2.0 * v.wxy * xy * yz + 2.0 * v.wxz * xz * yz),
    )

  infix def reverseSandwich(v: PointNormalized): Point =
    Point(
      wxy = (-2.0 * i * xy - 2.0 * s * wz - 2.0 * wx * xz - 2.0 * wy * yz + s * s * v.wxy + v.wxy * xy * xy - 2.0 * s * v.wxz * yz - v.wxy * xz * xz - v.wxy * yz * yz + 2.0 * s * v.wyz * xz + 2.0 * v.wxz * xy * xz + 2.0 * v.wyz * xy * yz),
      wxz = (-2.0 * i * xz - 2.0 * wz * yz + 2.0 * s * wy + 2.0 * wx * xy + s * s * v.wxz + v.wxz * xz * xz - 2.0 * s * v.wyz * xy - v.wxz * xy * xy - v.wxz * yz * yz + 2.0 * s * v.wxy * yz + 2.0 * v.wxy * xy * xz + 2.0 * v.wyz * xz * yz),
      wyz = (-2.0 * i * yz - 2.0 * s * wx + 2.0 * wy * xy + 2.0 * wz * xz + s * s * v.wyz + v.wyz * yz * yz - 2.0 * s * v.wxy * xz - v.wyz * xy * xy - v.wyz * xz * xz + 2.0 * s * v.wxz * xy + 2.0 * v.wxy * xy * yz + 2.0 * v.wxz * xz * yz),
      xyz = (s * s + xy * xy + xz * xz + yz * yz),
    )

  infix def reverseSandwich(v: PlaneIdeal): Plane =
    Plane(
      w = (-2.0 * i * v.x * yz - 2.0 * i * v.z * xy - 2.0 * s * v.x * wx - 2.0 * s * v.y * wy - 2.0 * s * v.z * wz - 2.0 * v.x * wy * xy - 2.0 * v.x * wz * xz - 2.0 * v.y * wz * yz + 2.0 * i * v.y * xz + 2.0 * v.y * wx * xy + 2.0 * v.z * wx * xz + 2.0 * v.z * wy * yz),
      x = (s * s * v.x + v.x * yz * yz - 2.0 * s * v.y * xy - 2.0 * s * v.z * xz - 2.0 * v.y * xz * yz - v.x * xy * xy - v.x * xz * xz + 2.0 * v.z * xy * yz),
      y = (s * s * v.y + v.y * xz * xz - 2.0 * s * v.z * yz - 2.0 * v.x * xz * yz - 2.0 * v.z * xy * xz - v.y * xy * xy - v.y * yz * yz + 2.0 * s * v.x * xy),
      z = (s * s * v.z + v.z * xy * xy - 2.0 * v.y * xy * xz - v.z * xz * xz - v.z * yz * yz + 2.0 * s * v.x * xz + 2.0 * s * v.y * yz + 2.0 * v.x * xy * yz),
    )

  infix def reverseSandwich(v: PseudoScalar): PseudoScalar =
    PseudoScalar(
      i = (s * s * v.i + v.i * xy * xy + v.i * xz * xz + v.i * yz * yz),
    )

  infix def reverseSandwich(v: PointCenter.type): Point =
    Point(
      wxy = (-2.0 * i * xy - 2.0 * s * wz - 2.0 * wx * xz - 2.0 * wy * yz),
      wxz = (-2.0 * i * xz - 2.0 * wz * yz + 2.0 * s * wy + 2.0 * wx * xy),
      wyz = (-2.0 * i * yz - 2.0 * s * wx + 2.0 * wy * xy + 2.0 * wz * xz),
      xyz = (s * s + xy * xy + xz * xz + yz * yz),
    )

  infix def cross(v: Multivector): Multivector =
    Multivector(
      s = 0.0,
      w = (v.x * wx + v.y * wy + v.z * wz - i * v.xyz),
      x = (v.y * xy + v.z * xz),
      y = (v.z * yz - v.x * xy),
      z = (-v.x * xz - v.y * yz),
      wx = (v.wy * xy + v.wz * xz - v.xy * wy - v.xz * wz),
      wy = (v.wz * yz + v.xy * wx - v.wx * xy - v.yz * wz),
      wz = (v.xz * wx + v.yz * wy - v.wx * xz - v.wy * yz),
      xy = (v.xz * yz - v.yz * xz),
      xz = (v.yz * xy - v.xy * yz),
      yz = (v.xy * xz - v.xz * xy),
      wxy = (i * v.z + v.wxz * yz + v.xyz * wz - v.wyz * xz),
      wxz = (v.wyz * xy - i * v.y - v.wxy * yz - v.xyz * wy),
      wyz = (i * v.x + v.wxy * xz + v.xyz * wx - v.wxz * xy),
      xyz = 0.0,
      i = 0.0,
    )

  infix def cross(v: Motor): Bivector =
    Bivector(
      wx = (v.wy * xy + v.wz * xz - v.xy * wy - v.xz * wz),
      wy = (v.wz * yz + v.xy * wx - v.wx * xy - v.yz * wz),
      wz = (v.xz * wx + v.yz * wy - v.wx * xz - v.wy * yz),
      xy = (v.xz * yz - v.yz * xz),
      xz = (v.yz * xy - v.xy * yz),
      yz = (v.xy * xz - v.xz * xy),
    )

  infix def cross(v: Plane): Multivector =
    Multivector(
      s = 0.0,
      w = (v.x * wx + v.y * wy + v.z * wz),
      x = (v.y * xy + v.z * xz),
      y = (v.z * yz - v.x * xy),
      z = (-v.x * xz - v.y * yz),
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

  infix def cross(v: Bivector): Bivector =
    Bivector(
      wx = (v.wy * xy + v.wz * xz - v.xy * wy - v.xz * wz),
      wy = (v.wz * yz + v.xy * wx - v.wx * xy - v.yz * wz),
      wz = (v.xz * wx + v.yz * wy - v.wx * xz - v.wy * yz),
      xy = (v.xz * yz - v.yz * xz),
      xz = (v.yz * xy - v.xy * yz),
      yz = (v.xy * xz - v.xz * xy),
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
      wxy = (v.wxz * yz + v.xyz * wz - v.wyz * xz),
      wxz = (v.wyz * xy - v.wxy * yz - v.xyz * wy),
      wyz = (v.wxy * xz + v.xyz * wx - v.wxz * xy),
      xyz = 0.0,
      i = 0.0,
    )

  infix def cross(v: Quaternion): Bivector =
    Bivector(
      wx = (-v.xy * wy - v.xz * wz),
      wy = (v.xy * wx - v.yz * wz),
      wz = (v.xz * wx + v.yz * wy),
      xy = (v.xz * yz - v.yz * xz),
      xz = (v.yz * xy - v.xy * yz),
      yz = (v.xy * xz - v.xz * xy),
    )

  infix def cross(v: QuaternionDual): QuaternionDual =
    QuaternionDual(
      wx = (v.wy * xy + v.wz * xz),
      wy = (v.wz * yz - v.wx * xy),
      wz = (-v.wx * xz - v.wy * yz),
      i = 0.0,
    )

  infix def cross(v: PointIdeal): PointIdeal =
    PointIdeal(
      wxy = (v.wxz * yz - v.wyz * xz),
      wxz = (v.wyz * xy - v.wxy * yz),
      wyz = (v.wxy * xz - v.wxz * xy),
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
      wxy = (wz + v.wxz * yz - v.wyz * xz),
      wxz = (-wy + v.wyz * xy - v.wxy * yz),
      wyz = (wx + v.wxy * xz - v.wxz * xy),
      xyz = 0.0,
      i = 0.0,
    )

  infix def cross(v: PlaneIdeal): Multivector =
    Multivector(
      s = 0.0,
      w = (v.x * wx + v.y * wy + v.z * wz),
      x = (v.y * xy + v.z * xz),
      y = (v.z * yz - v.x * xy),
      z = (-v.x * xz - v.y * yz),
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
      s = (i * v.s + s * v.i + v.wx * yz + v.wz * xy + v.xy * wz + v.yz * wx - v.wy * xz - v.xz * wy),
      w = (i * v.w + v.wxz * wy - v.wxy * wz - v.wyz * wx),
      x = (i * v.x + s * v.wyz + v.wxz * xy + v.y * wz - v.w * yz - v.wxy * xz - v.xyz * wx - v.z * wy),
      y = (i * v.y + v.w * xz + v.wyz * xy + v.z * wx - s * v.wxz - v.wxy * yz - v.x * wz - v.xyz * wy),
      z = (i * v.z + s * v.wxy + v.wyz * xz + v.x * wy - v.w * xy - v.wxz * yz - v.xyz * wz - v.y * wx),
      wx = (i * v.wx + v.i * wx + v.wy * wz - v.wz * wy),
      wy = (i * v.wy + v.i * wy + v.wz * wx - v.wx * wz),
      wz = (i * v.wz + v.i * wz + v.wx * wy - v.wy * wx),
      xy = (i * v.xy + v.i * xy + v.xz * wx + v.yz * wy - s * v.wz - v.s * wz - v.wx * xz - v.wy * yz),
      xz = (i * v.xz + s * v.wy + v.i * xz + v.s * wy + v.wx * xy + v.yz * wz - v.wz * yz - v.xy * wx),
      yz = (i * v.yz + v.i * yz + v.wy * xy + v.wz * xz - s * v.wx - v.s * wx - v.xy * wy - v.xz * wz),
      wxy = (i * v.wxy + v.w * wz + v.wxz * wx + v.wyz * wy),
      wxz = (i * v.wxz + v.wyz * wz - v.w * wy - v.wxy * wx),
      wyz = (i * v.wyz + v.w * wx - v.wxy * wy - v.wxz * wz),
      xyz = (i * v.xyz + v.x * wx + v.y * wy + v.z * wz - s * v.w - v.wxy * xy - v.wxz * xz - v.wyz * yz),
      i = (i * v.i - v.wx * wx - v.wy * wy - v.wz * wz),
    )

  infix def antiGeometric(v: Motor): Motor =
    Motor(
      s = (i * v.s + s * v.i + v.wx * yz + v.wz * xy + v.xy * wz + v.yz * wx - v.wy * xz - v.xz * wy),
      wx = (i * v.wx + v.i * wx + v.wy * wz - v.wz * wy),
      wy = (i * v.wy + v.i * wy + v.wz * wx - v.wx * wz),
      wz = (i * v.wz + v.i * wz + v.wx * wy - v.wy * wx),
      xy = (i * v.xy + v.i * xy + v.xz * wx + v.yz * wy - s * v.wz - v.s * wz - v.wx * xz - v.wy * yz),
      xz = (i * v.xz + s * v.wy + v.i * xz + v.s * wy + v.wx * xy + v.yz * wz - v.wz * yz - v.xy * wx),
      yz = (i * v.yz + v.i * yz + v.wy * xy + v.wz * xz - s * v.wx - v.s * wx - v.xy * wy - v.xz * wz),
      i = (i * v.i - v.wx * wx - v.wy * wy - v.wz * wz),
    )

  infix def antiGeometric(v: Plane): Multivector =
    Multivector(
      s = 0.0,
      w = i * v.w,
      x = (i * v.x + v.y * wz - v.w * yz - v.z * wy),
      y = (i * v.y + v.w * xz + v.z * wx - v.x * wz),
      z = (i * v.z + v.x * wy - v.w * xy - v.y * wx),
      wx = 0.0,
      wy = 0.0,
      wz = 0.0,
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
      wxy = v.w * wz,
      wxz = -v.w * wy,
      wyz = v.w * wx,
      xyz = (v.x * wx + v.y * wy + v.z * wz - s * v.w),
      i = 0.0,
    )

  infix def antiGeometric(v: Bivector): Motor =
    Motor(
      s = (v.wx * yz + v.wz * xy + v.xy * wz + v.yz * wx - v.wy * xz - v.xz * wy),
      wx = (i * v.wx + v.wy * wz - v.wz * wy),
      wy = (i * v.wy + v.wz * wx - v.wx * wz),
      wz = (i * v.wz + v.wx * wy - v.wy * wx),
      xy = (i * v.xy + v.xz * wx + v.yz * wy - s * v.wz - v.wx * xz - v.wy * yz),
      xz = (i * v.xz + s * v.wy + v.wx * xy + v.yz * wz - v.wz * yz - v.xy * wx),
      yz = (i * v.yz + v.wy * xy + v.wz * xz - s * v.wx - v.xy * wy - v.xz * wz),
      i = (-v.wx * wx - v.wy * wy - v.wz * wz),
    )

  infix def antiGeometric(v: Point): Multivector =
    Multivector(
      s = 0.0,
      w = (v.wxz * wy - v.wxy * wz - v.wyz * wx),
      x = (s * v.wyz + v.wxz * xy - v.wxy * xz - v.xyz * wx),
      y = (v.wyz * xy - s * v.wxz - v.wxy * yz - v.xyz * wy),
      z = (s * v.wxy + v.wyz * xz - v.wxz * yz - v.xyz * wz),
      wx = 0.0,
      wy = 0.0,
      wz = 0.0,
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
      wxy = (i * v.wxy + v.wxz * wx + v.wyz * wy),
      wxz = (i * v.wxz + v.wyz * wz - v.wxy * wx),
      wyz = (i * v.wyz - v.wxy * wy - v.wxz * wz),
      xyz = (i * v.xyz - v.wxy * xy - v.wxz * xz - v.wyz * yz),
      i = 0.0,
    )

  infix def antiGeometric(v: Quaternion): Quaternion =
    Quaternion(
      s = (i * v.s + v.xy * wz + v.yz * wx - v.xz * wy),
      xy = (i * v.xy + v.xz * wx + v.yz * wy - v.s * wz),
      xz = (i * v.xz + v.s * wy + v.yz * wz - v.xy * wx),
      yz = (i * v.yz - v.s * wx - v.xy * wy - v.xz * wz),
    )

  infix def antiGeometric(v: QuaternionDual): Motor =
    Motor(
      s = (s * v.i + v.wx * yz + v.wz * xy - v.wy * xz),
      wx = (i * v.wx + v.i * wx + v.wy * wz - v.wz * wy),
      wy = (i * v.wy + v.i * wy + v.wz * wx - v.wx * wz),
      wz = (i * v.wz + v.i * wz + v.wx * wy - v.wy * wx),
      xy = (v.i * xy - s * v.wz - v.wx * xz - v.wy * yz),
      xz = (s * v.wy + v.i * xz + v.wx * xy - v.wz * yz),
      yz = (v.i * yz + v.wy * xy + v.wz * xz - s * v.wx),
      i = (i * v.i - v.wx * wx - v.wy * wy - v.wz * wz),
    )

  infix def antiGeometric(v: PointIdeal): Multivector =
    Multivector(
      s = 0.0,
      w = (v.wxz * wy - v.wxy * wz - v.wyz * wx),
      x = (s * v.wyz + v.wxz * xy - v.wxy * xz),
      y = (v.wyz * xy - s * v.wxz - v.wxy * yz),
      z = (s * v.wxy + v.wyz * xz - v.wxz * yz),
      wx = 0.0,
      wy = 0.0,
      wz = 0.0,
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
      wxy = (i * v.wxy + v.wxz * wx + v.wyz * wy),
      wxz = (i * v.wxz + v.wyz * wz - v.wxy * wx),
      wyz = (i * v.wyz - v.wxy * wy - v.wxz * wz),
      xyz = (-v.wxy * xy - v.wxz * xz - v.wyz * yz),
      i = 0.0,
    )

  infix def antiGeometric(v: PointNormalized): Multivector =
    Multivector(
      s = 0.0,
      w = (v.wxz * wy - v.wxy * wz - v.wyz * wx),
      x = (-wx + s * v.wyz + v.wxz * xy - v.wxy * xz),
      y = (-wy + v.wyz * xy - s * v.wxz - v.wxy * yz),
      z = (-wz + s * v.wxy + v.wyz * xz - v.wxz * yz),
      wx = 0.0,
      wy = 0.0,
      wz = 0.0,
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
      wxy = (i * v.wxy + v.wxz * wx + v.wyz * wy),
      wxz = (i * v.wxz + v.wyz * wz - v.wxy * wx),
      wyz = (i * v.wyz - v.wxy * wy - v.wxz * wz),
      xyz = (i - v.wxy * xy - v.wxz * xz - v.wyz * yz),
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

  infix def antiGeometric(v: PseudoScalar): Motor =
    Motor(
      s = s * v.i,
      wx = v.i * wx,
      wy = v.i * wy,
      wz = v.i * wz,
      xy = v.i * xy,
      xz = v.i * xz,
      yz = v.i * yz,
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
      s = (i * v.s + s * v.i),
      w = i * v.w,
      x = (i * v.x + s * v.wyz),
      y = (i * v.y - s * v.wxz),
      z = (i * v.z + s * v.wxy),
      wx = (i * v.wx + v.i * wx),
      wy = (i * v.wy + v.i * wy),
      wz = (i * v.wz + v.i * wz),
      xy = (i * v.xy + v.i * xy - s * v.wz - v.s * wz),
      xz = (i * v.xz + s * v.wy + v.i * xz + v.s * wy),
      yz = (i * v.yz + v.i * yz - s * v.wx - v.s * wx),
      wxy = (i * v.wxy + v.w * wz + v.wxz * wx + v.wyz * wy),
      wxz = (i * v.wxz + v.wyz * wz - v.w * wy - v.wxy * wx),
      wyz = (i * v.wyz + v.w * wx - v.wxy * wy - v.wxz * wz),
      xyz = (i * v.xyz + v.x * wx + v.y * wy + v.z * wz - s * v.w - v.wxy * xy - v.wxz * xz - v.wyz * yz),
      i = (i * v.i - v.wx * wx - v.wy * wy - v.wz * wz),
    )

  infix def antiDot(v: Motor): Motor =
    Motor(
      s = (i * v.s + s * v.i),
      wx = (i * v.wx + v.i * wx),
      wy = (i * v.wy + v.i * wy),
      wz = (i * v.wz + v.i * wz),
      xy = (i * v.xy + v.i * xy - s * v.wz - v.s * wz),
      xz = (i * v.xz + s * v.wy + v.i * xz + v.s * wy),
      yz = (i * v.yz + v.i * yz - s * v.wx - v.s * wx),
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
      xyz = (v.x * wx + v.y * wy + v.z * wz - s * v.w),
      i = 0.0,
    )

  infix def antiDot(v: Bivector): Motor =
    Motor(
      s = 0.0,
      wx = i * v.wx,
      wy = i * v.wy,
      wz = i * v.wz,
      xy = (i * v.xy - s * v.wz),
      xz = (i * v.xz + s * v.wy),
      yz = (i * v.yz - s * v.wx),
      i = (-v.wx * wx - v.wy * wy - v.wz * wz),
    )

  infix def antiDot(v: Point): Multivector =
    Multivector(
      s = 0.0,
      w = 0.0,
      x = s * v.wyz,
      y = -s * v.wxz,
      z = s * v.wxy,
      wx = 0.0,
      wy = 0.0,
      wz = 0.0,
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
      wxy = (i * v.wxy + v.wxz * wx + v.wyz * wy),
      wxz = (i * v.wxz + v.wyz * wz - v.wxy * wx),
      wyz = (i * v.wyz - v.wxy * wy - v.wxz * wz),
      xyz = (i * v.xyz - v.wxy * xy - v.wxz * xz - v.wyz * yz),
      i = 0.0,
    )

  infix def antiDot(v: Quaternion): Quaternion =
    Quaternion(
      s = i * v.s,
      xy = (i * v.xy - v.s * wz),
      xz = (i * v.xz + v.s * wy),
      yz = (i * v.yz - v.s * wx),
    )

  infix def antiDot(v: QuaternionDual): Motor =
    Motor(
      s = s * v.i,
      wx = (i * v.wx + v.i * wx),
      wy = (i * v.wy + v.i * wy),
      wz = (i * v.wz + v.i * wz),
      xy = (v.i * xy - s * v.wz),
      xz = (s * v.wy + v.i * xz),
      yz = (v.i * yz - s * v.wx),
      i = (i * v.i - v.wx * wx - v.wy * wy - v.wz * wz),
    )

  infix def antiDot(v: PointIdeal): Multivector =
    Multivector(
      s = 0.0,
      w = 0.0,
      x = s * v.wyz,
      y = -s * v.wxz,
      z = s * v.wxy,
      wx = 0.0,
      wy = 0.0,
      wz = 0.0,
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
      wxy = (i * v.wxy + v.wxz * wx + v.wyz * wy),
      wxz = (i * v.wxz + v.wyz * wz - v.wxy * wx),
      wyz = (i * v.wyz - v.wxy * wy - v.wxz * wz),
      xyz = (-v.wxy * xy - v.wxz * xz - v.wyz * yz),
      i = 0.0,
    )

  infix def antiDot(v: PointNormalized): Multivector =
    Multivector(
      s = 0.0,
      w = 0.0,
      x = s * v.wyz,
      y = -s * v.wxz,
      z = s * v.wxy,
      wx = 0.0,
      wy = 0.0,
      wz = 0.0,
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
      wxy = (i * v.wxy + v.wxz * wx + v.wyz * wy),
      wxz = (i * v.wxz + v.wyz * wz - v.wxy * wx),
      wyz = (i * v.wyz - v.wxy * wy - v.wxz * wz),
      xyz = (i - v.wxy * xy - v.wxz * xz - v.wyz * yz),
      i = 0.0,
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

  infix def antiDot(v: PseudoScalar): Motor =
    Motor(
      s = s * v.i,
      wx = v.i * wx,
      wy = v.i * wy,
      wz = v.i * wz,
      xy = v.i * xy,
      xz = v.i * xz,
      yz = v.i * yz,
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
      s = (i * v.s + s * v.i + v.wx * yz + v.wz * xy + v.xy * wz + v.yz * wx - v.wy * xz - v.xz * wy),
      w = (i * v.w + v.wxz * wy - v.wxy * wz - v.wyz * wx),
      x = (i * v.x + v.wxz * xy - v.wxy * xz - v.xyz * wx),
      y = (i * v.y + v.wyz * xy - v.wxy * yz - v.xyz * wy),
      z = (i * v.z + v.wyz * xz - v.wxz * yz - v.xyz * wz),
      wx = (i * v.wx + v.i * wx),
      wy = (i * v.wy + v.i * wy),
      wz = (i * v.wz + v.i * wz),
      xy = (i * v.xy + v.i * xy),
      xz = (i * v.xz + v.i * xz),
      yz = (i * v.yz + v.i * yz),
      wxy = i * v.wxy,
      wxz = i * v.wxz,
      wyz = i * v.wyz,
      xyz = i * v.xyz,
      i = i * v.i,
    )

  inline infix def v(v: Multivector): Multivector = antiWedge(v)

  infix def antiWedge(v: Motor): Motor =
    Motor(
      s = (i * v.s + s * v.i + v.wx * yz + v.wz * xy + v.xy * wz + v.yz * wx - v.wy * xz - v.xz * wy),
      wx = (i * v.wx + v.i * wx),
      wy = (i * v.wy + v.i * wy),
      wz = (i * v.wz + v.i * wz),
      xy = (i * v.xy + v.i * xy),
      xz = (i * v.xz + v.i * xz),
      yz = (i * v.yz + v.i * yz),
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
      s = (v.wx * yz + v.wz * xy + v.xy * wz + v.yz * wx - v.wy * xz - v.xz * wy),
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
      x = (v.wxz * xy - v.wxy * xz - v.xyz * wx),
      y = (v.wyz * xy - v.wxy * yz - v.xyz * wy),
      z = (v.wyz * xz - v.wxz * yz - v.xyz * wz),
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

  infix def antiWedge(v: QuaternionDual): Motor =
    Motor(
      s = (s * v.i + v.wx * yz + v.wz * xy - v.wy * xz),
      wx = (i * v.wx + v.i * wx),
      wy = (i * v.wy + v.i * wy),
      wz = (i * v.wz + v.i * wz),
      xy = v.i * xy,
      xz = v.i * xz,
      yz = v.i * yz,
      i = i * v.i,
    )

  inline infix def v(v: QuaternionDual): Motor = antiWedge(v)

  infix def antiWedge(v: PointIdeal): Multivector =
    Multivector(
      s = 0.0,
      w = (v.wxz * wy - v.wxy * wz - v.wyz * wx),
      x = (v.wxz * xy - v.wxy * xz),
      y = (v.wyz * xy - v.wxy * yz),
      z = (v.wyz * xz - v.wxz * yz),
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
      x = (-wx + v.wxz * xy - v.wxy * xz),
      y = (-wy + v.wyz * xy - v.wxy * yz),
      z = (-wz + v.wyz * xz - v.wxz * yz),
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

  infix def antiWedge(v: PseudoScalar): Motor =
    Motor(
      s = s * v.i,
      wx = v.i * wx,
      wy = v.i * wy,
      wz = v.i * wz,
      xy = v.i * xy,
      xz = v.i * xz,
      yz = v.i * yz,
      i = i * v.i,
    )

  inline infix def v(v: PseudoScalar): Motor = antiWedge(v)

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