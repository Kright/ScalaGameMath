package com.github.kright.pga3d

/** this code is generated, see com.github.kright.pga3d.codegen.CodeGenClass */
case class Motor(s: Double = 0.0,
                 wx: Double = 0.0,
                 wy: Double = 0.0,
                 wz: Double = 0.0,
                 xy: Double = 0.0,
                 xz: Double = 0.0,
                 yz: Double = 0.0,
                 i: Double = 0.0):

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

  def weight: Motor =
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

  def bulk: Quaternion =
    Quaternion(
      s = s,
      xy = xy,
      xz = xz,
      yz = yz,
    )

  def unary_- : Motor =
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

  def bulkNormSquare: Double =
    (s * s + xy * xy + xz * xz + yz * yz)

  def bulkNorm: Double =
    Math.sqrt(bulkNormSquare)

  def normalizedByBulk =
    this / bulkNorm

  def weightNormSquare: Double =
    (i * i + wx * wx + wy * wy + wz * wz)

  def weightNorm: Double =
    Math.sqrt(weightNormSquare)

  def normalizedByWeight =
    this / weightNorm

  def normSquare: Double =
    (i * i + s * s + wx * wx + wy * wy + wz * wz + xy * xy + xz * xz + yz * yz)

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

  def multiplyElementwise(v: Motor): Motor =
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

  def log(): Bivector =
    val scalar = s
    if (s < 0.0) return (-this).log()

    val lenXYZ = Math.sqrt(xy * xy + xz * xz + yz * yz)
    val angle = Math.atan2(lenXYZ, scalar)

    val a = 1.0 / (1.0 - scalar * scalar) // 1 / sin^2

    val b = if (Math.abs(angle) > 1e-5) { // angle / sin(angle)
      angle * Math.sqrt(a)
    } else {
      1.0 + angle * angle / 6.0
    }

    val c = if (Math.abs(angle) > 1e-5) {
      a * i * (1.0 - scalar * b)
    } else {
      (1.0 + angle * angle / 2.0) * i / 3.0
    }

    Bivector(
      wx = (b * wx + c * yz),
      wy = (b * wy - c * xz),
      wz = (b * wz + c * xy),
      xy = b * xy,
      xz = b * xz,
      yz = b * yz,
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

  def asBivectorUnsafe: Bivector =
    Bivector(
      wx = wx,
      wy = wy,
      wz = wz,
      xy = xy,
      xz = xz,
      yz = yz,
    )

  def asQuaternionUnsafe: Quaternion =
    Quaternion(
      s = s,
      xy = xy,
      xz = xz,
      yz = yz,
    )

  def asTranslatorUnsafe: Translator =
    Translator(
      wx = wx,
      wy = wy,
      wz = wz,
    )

  def asBivectorBulkUnsafe: BivectorBulk =
    BivectorBulk(
      xy = xy,
      xz = xz,
      yz = yz,
    )

  def asBivectorWeightUnsafe: BivectorWeight =
    BivectorWeight(
      wx = wx,
      wy = wy,
      wz = wz,
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

  infix def geometric(v: Translator): Motor =
    Motor(
      s = s,
      wx = (wx + s * v.wx + v.wy * xy + v.wz * xz),
      wy = (wy + s * v.wy + v.wz * yz - v.wx * xy),
      wz = (wz + s * v.wz - v.wx * xz - v.wy * yz),
      xy = xy,
      xz = xz,
      yz = yz,
      i = (i + v.wx * yz + v.wz * xy - v.wy * xz),
    )

  infix def geometric(v: Vector): Multivector =
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

  infix def geometric(v: BivectorBulk): Motor =
    Motor(
      s = (-v.xy * xy - v.xz * xz - v.yz * yz),
      wx = (-i * v.yz - v.xy * wy - v.xz * wz),
      wy = (i * v.xz + v.xy * wx - v.yz * wz),
      wz = (v.xz * wx + v.yz * wy - i * v.xy),
      xy = (s * v.xy + v.xz * yz - v.yz * xz),
      xz = (s * v.xz + v.yz * xy - v.xy * yz),
      yz = (s * v.yz + v.xy * xz - v.xz * xy),
      i = (v.xy * wz + v.yz * wx - v.xz * wy),
    )

  infix def geometric(v: BivectorWeight): Motor =
    Motor(
      s = 0.0,
      wx = (s * v.wx + v.wy * xy + v.wz * xz),
      wy = (s * v.wy + v.wz * yz - v.wx * xy),
      wz = (s * v.wz - v.wx * xz - v.wy * yz),
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
      i = (v.wx * yz + v.wz * xy - v.wy * xz),
    )

  infix def geometric(v: PseudoScalar): Motor =
    Motor(
      s = 0.0,
      wx = -v.i * yz,
      wy = v.i * xz,
      wz = -v.i * xy,
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
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

  infix def dot(v: Translator): Motor =
    Motor(
      s = s,
      wx = (wx + s * v.wx),
      wy = (wy + s * v.wy),
      wz = (wz + s * v.wz),
      xy = xy,
      xz = xz,
      yz = yz,
      i = i,
    )

  infix def dot(v: Vector): Multivector =
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

  infix def dot(v: BivectorBulk): Motor =
    Motor(
      s = (-v.xy * xy - v.xz * xz - v.yz * yz),
      wx = -i * v.yz,
      wy = i * v.xz,
      wz = -i * v.xy,
      xy = s * v.xy,
      xz = s * v.xz,
      yz = s * v.yz,
      i = 0.0,
    )

  infix def dot(v: BivectorWeight): BivectorWeight =
    BivectorWeight(
      wx = s * v.wx,
      wy = s * v.wy,
      wz = s * v.wz,
    )

  infix def dot(v: PseudoScalar): Motor =
    Motor(
      s = 0.0,
      wx = -v.i * yz,
      wy = v.i * xz,
      wz = -v.i * xy,
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
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

  infix def wedge(v: Translator): Motor =
    Motor(
      s = s,
      wx = (wx + s * v.wx),
      wy = (wy + s * v.wy),
      wz = (wz + s * v.wz),
      xy = xy,
      xz = xz,
      yz = yz,
      i = (i + v.wx * yz + v.wz * xy - v.wy * xz),
    )

  inline infix def ^(v: Translator): Motor = wedge(v)

  infix def wedge(v: Vector): Vector =
    Vector(
      wxy = s * v.wxy,
      wxz = s * v.wxz,
      wyz = s * v.wyz,
    )

  inline infix def ^(v: Vector): Vector = wedge(v)

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

  infix def wedge(v: BivectorBulk): Motor =
    Motor(
      s = 0.0,
      wx = 0.0,
      wy = 0.0,
      wz = 0.0,
      xy = s * v.xy,
      xz = s * v.xz,
      yz = s * v.yz,
      i = (v.xy * wz + v.yz * wx - v.xz * wy),
    )

  inline infix def ^(v: BivectorBulk): Motor = wedge(v)

  infix def wedge(v: BivectorWeight): Motor =
    Motor(
      s = 0.0,
      wx = s * v.wx,
      wy = s * v.wy,
      wz = s * v.wz,
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
      i = (v.wx * yz + v.wz * xy - v.wy * xz),
    )

  inline infix def ^(v: BivectorWeight): Motor = wedge(v)

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

  infix def antiGeometric(v: Translator): Motor =
    Motor(
      s = (i + v.wx * yz + v.wz * xy - v.wy * xz),
      wx = (i * v.wx + v.wy * wz - v.wz * wy),
      wy = (i * v.wy + v.wz * wx - v.wx * wz),
      wz = (i * v.wz + v.wx * wy - v.wy * wx),
      xy = (-wz - s * v.wz - v.wx * xz - v.wy * yz),
      xz = (wy + s * v.wy + v.wx * xy - v.wz * yz),
      yz = (-wx + v.wy * xy + v.wz * xz - s * v.wx),
      i = (-v.wx * wx - v.wy * wy - v.wz * wz),
    )

  infix def antiGeometric(v: Vector): Multivector =
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

  infix def antiGeometric(v: BivectorBulk): Quaternion =
    Quaternion(
      s = (v.xy * wz + v.yz * wx - v.xz * wy),
      xy = (i * v.xy + v.xz * wx + v.yz * wy),
      xz = (i * v.xz + v.yz * wz - v.xy * wx),
      yz = (i * v.yz - v.xy * wy - v.xz * wz),
    )

  infix def antiGeometric(v: BivectorWeight): Motor =
    Motor(
      s = (v.wx * yz + v.wz * xy - v.wy * xz),
      wx = (i * v.wx + v.wy * wz - v.wz * wy),
      wy = (i * v.wy + v.wz * wx - v.wx * wz),
      wz = (i * v.wz + v.wx * wy - v.wy * wx),
      xy = (-s * v.wz - v.wx * xz - v.wy * yz),
      xz = (s * v.wy + v.wx * xy - v.wz * yz),
      yz = (v.wy * xy + v.wz * xz - s * v.wx),
      i = (-v.wx * wx - v.wy * wy - v.wz * wz),
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

  infix def antiDot(v: Translator): Motor =
    Motor(
      s = i,
      wx = i * v.wx,
      wy = i * v.wy,
      wz = i * v.wz,
      xy = (-wz - s * v.wz),
      xz = (wy + s * v.wy),
      yz = (-wx - s * v.wx),
      i = (-v.wx * wx - v.wy * wy - v.wz * wz),
    )

  infix def antiDot(v: Vector): Multivector =
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

  infix def antiDot(v: BivectorBulk): BivectorBulk =
    BivectorBulk(
      xy = i * v.xy,
      xz = i * v.xz,
      yz = i * v.yz,
    )

  infix def antiDot(v: BivectorWeight): Motor =
    Motor(
      s = 0.0,
      wx = i * v.wx,
      wy = i * v.wy,
      wz = i * v.wz,
      xy = -s * v.wz,
      xz = s * v.wy,
      yz = -s * v.wx,
      i = (-v.wx * wx - v.wy * wy - v.wz * wz),
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

  infix def antiWedge(v: Translator): Motor =
    Motor(
      s = (i + v.wx * yz + v.wz * xy - v.wy * xz),
      wx = i * v.wx,
      wy = i * v.wy,
      wz = i * v.wz,
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
      i = 0.0,
    )

  inline infix def v(v: Translator): Motor = antiWedge(v)

  infix def antiWedge(v: Vector): Multivector =
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

  inline infix def v(v: Vector): Multivector = antiWedge(v)

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

  infix def antiWedge(v: BivectorBulk): Quaternion =
    Quaternion(
      s = (v.xy * wz + v.yz * wx - v.xz * wy),
      xy = i * v.xy,
      xz = i * v.xz,
      yz = i * v.yz,
    )

  inline infix def v(v: BivectorBulk): Quaternion = antiWedge(v)

  infix def antiWedge(v: BivectorWeight): Motor =
    Motor(
      s = (v.wx * yz + v.wz * xy - v.wy * xz),
      wx = i * v.wx,
      wy = i * v.wy,
      wz = i * v.wz,
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
      i = 0.0,
    )

  inline infix def v(v: BivectorWeight): Motor = antiWedge(v)

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

  infix def sandwich(v: Multivector): Multivector =
    val sMs = s * s
    val sMwx = s * wx
    val sMwy = s * wy
    val sMwz = s * wz
    val sMxy = s * xy
    val sMxz = s * xz
    val sMyz = s * yz
    val sMi = i * s
    val wxMxy = wx * xy
    val wxMxz = wx * xz
    val wxMyz = wx * yz
    val wyMxy = wy * xy
    val wyMxz = wy * xz
    val wyMyz = wy * yz
    val wzMxy = wz * xy
    val wzMxz = wz * xz
    val wzMyz = wz * yz
    val xyMxy = xy * xy
    val xyMxz = xy * xz
    val xyMyz = xy * yz
    val xyMi = i * xy
    val xzMxz = xz * xz
    val xzMyz = xz * yz
    val xzMi = i * xz
    val yzMyz = yz * yz
    val yzMi = i * yz
    Multivector(
      s = v.s * (sMs + xyMxy + xzMxz + yzMyz),
      w = (2.0 * (v.x * (sMwx + yzMi - wyMxy - wzMxz) + v.y * (sMwy + wxMxy - wzMyz - xzMi) + v.z * (sMwz + wxMxz + wyMyz + xyMi)) + v.w * (sMs + xyMxy + xzMxz + yzMyz)),
      x = (2.0 * (v.y * (sMxy - xzMyz) + v.z * (sMxz + xyMyz)) + v.x * (sMs + yzMyz - xyMxy - xzMxz)),
      y = (2.0 * (v.x * (-sMxy - xzMyz) + v.z * (sMyz - xyMxz)) + v.y * (sMs + xzMxz - xyMxy - yzMyz)),
      z = (2.0 * (v.x * (xyMyz - sMxz) + v.y * (-sMyz - xyMxz)) + v.z * (sMs + xyMxy - xzMxz - yzMyz)),
      wx = (2.0 * (v.wy * (sMxy - xzMyz) + v.wz * (sMxz + xyMyz) + v.xy * (wxMxy + wzMyz - sMwy - xzMi) + v.xz * (wxMxz + xyMi - sMwz - wyMyz) + v.yz * (wxMyz + wyMxz - sMi - wzMxy)) + v.wx * (sMs + yzMyz - xyMxy - xzMxz)),
      wy = (2.0 * (v.wx * (-sMxy - xzMyz) + v.wz * (sMyz - xyMxz) + v.xy * (sMwx + wyMxy - wzMxz - yzMi) + v.xz * (sMi + wxMyz + wyMxz + wzMxy) + v.yz * (wyMyz + xyMi - sMwz - wxMxz)) + v.wy * (sMs + xzMxz - xyMxy - yzMyz)),
      wz = (2.0 * (v.wx * (xyMyz - sMxz) + v.wy * (-sMyz - xyMxz) + v.xy * (wyMxz + wzMxy - sMi - wxMyz) + v.xz * (sMwx + wzMxz - wyMxy - yzMi) + v.yz * (sMwy + wxMxy + wzMyz + xzMi)) + v.wz * (sMs + xyMxy - xzMxz - yzMyz)),
      xy = (2.0 * (v.xz * (sMyz + xyMxz) + v.yz * (xyMyz - sMxz)) + v.xy * (sMs + xyMxy - xzMxz - yzMyz)),
      xz = (2.0 * (v.xy * (xyMxz - sMyz) + v.yz * (sMxy + xzMyz)) + v.xz * (sMs + xzMxz - xyMxy - yzMyz)),
      yz = (2.0 * (v.xy * (sMxz + xyMyz) + v.xz * (xzMyz - sMxy)) + v.yz * (sMs + yzMyz - xyMxy - xzMxz)),
      wxy = (2.0 * (v.wxz * (sMyz + xyMxz) + v.wyz * (xyMyz - sMxz) + v.xyz * (sMwz + xyMi - wxMxz - wyMyz)) + v.wxy * (sMs + xyMxy - xzMxz - yzMyz)),
      wxz = (2.0 * (v.wxy * (xyMxz - sMyz) + v.wyz * (sMxy + xzMyz) + v.xyz * (wxMxy + xzMi - sMwy - wzMyz)) + v.wxz * (sMs + xzMxz - xyMxy - yzMyz)),
      wyz = (2.0 * (v.wxy * (sMxz + xyMyz) + v.wxz * (xzMyz - sMxy) + v.xyz * (sMwx + wyMxy + wzMxz + yzMi)) + v.wyz * (sMs + yzMyz - xyMxy - xzMxz)),
      xyz = v.xyz * (sMs + xyMxy + xzMxz + yzMyz),
      i = (v.i * (sMs + xyMxy + xzMxz + yzMyz) + 2.0 * v.s * (sMi + wyMxz - wxMyz - wzMxy)),
    )

  infix def sandwich(v: Motor): Motor =
    val sMs = s * s
    val sMwx = s * wx
    val sMwy = s * wy
    val sMwz = s * wz
    val sMxy = s * xy
    val sMxz = s * xz
    val sMyz = s * yz
    val sMi = i * s
    val wxMxy = wx * xy
    val wxMxz = wx * xz
    val wxMyz = wx * yz
    val wyMxy = wy * xy
    val wyMxz = wy * xz
    val wyMyz = wy * yz
    val wzMxy = wz * xy
    val wzMxz = wz * xz
    val wzMyz = wz * yz
    val xyMxy = xy * xy
    val xyMxz = xy * xz
    val xyMyz = xy * yz
    val xyMi = i * xy
    val xzMxz = xz * xz
    val xzMyz = xz * yz
    val xzMi = i * xz
    val yzMyz = yz * yz
    val yzMi = i * yz
    Motor(
      s = v.s * (sMs + xyMxy + xzMxz + yzMyz),
      wx = (2.0 * (v.wy * (sMxy - xzMyz) + v.wz * (sMxz + xyMyz) + v.xy * (wxMxy + wzMyz - sMwy - xzMi) + v.xz * (wxMxz + xyMi - sMwz - wyMyz) + v.yz * (wxMyz + wyMxz - sMi - wzMxy)) + v.wx * (sMs + yzMyz - xyMxy - xzMxz)),
      wy = (2.0 * (v.wx * (-sMxy - xzMyz) + v.wz * (sMyz - xyMxz) + v.xy * (sMwx + wyMxy - wzMxz - yzMi) + v.xz * (sMi + wxMyz + wyMxz + wzMxy) + v.yz * (wyMyz + xyMi - sMwz - wxMxz)) + v.wy * (sMs + xzMxz - xyMxy - yzMyz)),
      wz = (2.0 * (v.wx * (xyMyz - sMxz) + v.wy * (-sMyz - xyMxz) + v.xy * (wyMxz + wzMxy - sMi - wxMyz) + v.xz * (sMwx + wzMxz - wyMxy - yzMi) + v.yz * (sMwy + wxMxy + wzMyz + xzMi)) + v.wz * (sMs + xyMxy - xzMxz - yzMyz)),
      xy = (2.0 * (v.xz * (sMyz + xyMxz) + v.yz * (xyMyz - sMxz)) + v.xy * (sMs + xyMxy - xzMxz - yzMyz)),
      xz = (2.0 * (v.xy * (xyMxz - sMyz) + v.yz * (sMxy + xzMyz)) + v.xz * (sMs + xzMxz - xyMxy - yzMyz)),
      yz = (2.0 * (v.xy * (sMxz + xyMyz) + v.xz * (xzMyz - sMxy)) + v.yz * (sMs + yzMyz - xyMxy - xzMxz)),
      i = (v.i * (sMs + xyMxy + xzMxz + yzMyz) + 2.0 * v.s * (sMi + wyMxz - wxMyz - wzMxy)),
    )

  infix def sandwich(v: Plane): Plane =
    val sMs = s * s
    val sMxy = s * xy
    val sMxz = s * xz
    val sMyz = s * yz
    val xyMxy = xy * xy
    val xyMxz = xy * xz
    val xyMyz = xy * yz
    val xzMxz = xz * xz
    val xzMyz = xz * yz
    val yzMyz = yz * yz
    Plane(
      w = (2.0 * (v.x * (i * yz + s * wx - wy * xy - wz * xz) + v.y * (s * wy + wx * xy - i * xz - wz * yz) + v.z * (i * xy + s * wz + wx * xz + wy * yz)) + v.w * (sMs + xyMxy + xzMxz + yzMyz)),
      x = (2.0 * (v.y * (sMxy - xzMyz) + v.z * (sMxz + xyMyz)) + v.x * (sMs + yzMyz - xyMxy - xzMxz)),
      y = (2.0 * (v.x * (-sMxy - xzMyz) + v.z * (sMyz - xyMxz)) + v.y * (sMs + xzMxz - xyMxy - yzMyz)),
      z = (2.0 * (v.x * (xyMyz - sMxz) + v.y * (-sMyz - xyMxz)) + v.z * (sMs + xyMxy - xzMxz - yzMyz)),
    )

  infix def sandwich(v: Bivector): Bivector =
    val sMs = s * s
    val sMwx = s * wx
    val sMwy = s * wy
    val sMwz = s * wz
    val sMxy = s * xy
    val sMxz = s * xz
    val sMyz = s * yz
    val sMi = i * s
    val wxMxy = wx * xy
    val wxMxz = wx * xz
    val wxMyz = wx * yz
    val wyMxy = wy * xy
    val wyMxz = wy * xz
    val wyMyz = wy * yz
    val wzMxy = wz * xy
    val wzMxz = wz * xz
    val wzMyz = wz * yz
    val xyMxy = xy * xy
    val xyMxz = xy * xz
    val xyMyz = xy * yz
    val xyMi = i * xy
    val xzMxz = xz * xz
    val xzMyz = xz * yz
    val xzMi = i * xz
    val yzMyz = yz * yz
    val yzMi = i * yz
    Bivector(
      wx = (2.0 * (v.wy * (sMxy - xzMyz) + v.wz * (sMxz + xyMyz) + v.xy * (wxMxy + wzMyz - sMwy - xzMi) + v.xz * (wxMxz + xyMi - sMwz - wyMyz) + v.yz * (wxMyz + wyMxz - sMi - wzMxy)) + v.wx * (sMs + yzMyz - xyMxy - xzMxz)),
      wy = (2.0 * (v.wx * (-sMxy - xzMyz) + v.wz * (sMyz - xyMxz) + v.xy * (sMwx + wyMxy - wzMxz - yzMi) + v.xz * (sMi + wxMyz + wyMxz + wzMxy) + v.yz * (wyMyz + xyMi - sMwz - wxMxz)) + v.wy * (sMs + xzMxz - xyMxy - yzMyz)),
      wz = (2.0 * (v.wx * (xyMyz - sMxz) + v.wy * (-sMyz - xyMxz) + v.xy * (wyMxz + wzMxy - sMi - wxMyz) + v.xz * (sMwx + wzMxz - wyMxy - yzMi) + v.yz * (sMwy + wxMxy + wzMyz + xzMi)) + v.wz * (sMs + xyMxy - xzMxz - yzMyz)),
      xy = (2.0 * (v.xz * (sMyz + xyMxz) + v.yz * (xyMyz - sMxz)) + v.xy * (sMs + xyMxy - xzMxz - yzMyz)),
      xz = (2.0 * (v.xy * (xyMxz - sMyz) + v.yz * (sMxy + xzMyz)) + v.xz * (sMs + xzMxz - xyMxy - yzMyz)),
      yz = (2.0 * (v.xy * (sMxz + xyMyz) + v.xz * (xzMyz - sMxy)) + v.yz * (sMs + yzMyz - xyMxy - xzMxz)),
    )

  infix def sandwich(v: Point): Point =
    val sMs = s * s
    val sMxy = s * xy
    val sMxz = s * xz
    val sMyz = s * yz
    val xyMxy = xy * xy
    val xyMxz = xy * xz
    val xyMyz = xy * yz
    val xzMxz = xz * xz
    val xzMyz = xz * yz
    val yzMyz = yz * yz
    Point(
      wxy = (2.0 * (v.wxz * (sMyz + xyMxz) + v.wyz * (xyMyz - sMxz) + v.xyz * (i * xy + s * wz - wx * xz - wy * yz)) + v.wxy * (sMs + xyMxy - xzMxz - yzMyz)),
      wxz = (2.0 * (v.wxy * (xyMxz - sMyz) + v.wyz * (sMxy + xzMyz) + v.xyz * (i * xz + wx * xy - s * wy - wz * yz)) + v.wxz * (sMs + xzMxz - xyMxy - yzMyz)),
      wyz = (2.0 * (v.wxy * (sMxz + xyMyz) + v.wxz * (xzMyz - sMxy) + v.xyz * (i * yz + s * wx + wy * xy + wz * xz)) + v.wyz * (sMs + yzMyz - xyMxy - xzMxz)),
      xyz = v.xyz * (sMs + xyMxy + xzMxz + yzMyz),
    )

  infix def sandwich(v: Quaternion): Motor =
    val sMs = s * s
    val sMwx = s * wx
    val sMwy = s * wy
    val sMwz = s * wz
    val sMxy = s * xy
    val sMxz = s * xz
    val sMyz = s * yz
    val sMi = i * s
    val wxMxy = wx * xy
    val wxMxz = wx * xz
    val wxMyz = wx * yz
    val wyMxy = wy * xy
    val wyMxz = wy * xz
    val wyMyz = wy * yz
    val wzMxy = wz * xy
    val wzMxz = wz * xz
    val wzMyz = wz * yz
    val xyMxy = xy * xy
    val xyMxz = xy * xz
    val xyMyz = xy * yz
    val xyMi = i * xy
    val xzMxz = xz * xz
    val xzMyz = xz * yz
    val xzMi = i * xz
    val yzMyz = yz * yz
    val yzMi = i * yz
    Motor(
      s = v.s * (sMs + xyMxy + xzMxz + yzMyz),
      wx = 2.0 * (v.xy * (wxMxy + wzMyz - sMwy - xzMi) + v.xz * (wxMxz + xyMi - sMwz - wyMyz) + v.yz * (wxMyz + wyMxz - sMi - wzMxy)),
      wy = 2.0 * (v.xy * (sMwx + wyMxy - wzMxz - yzMi) + v.xz * (sMi + wxMyz + wyMxz + wzMxy) + v.yz * (wyMyz + xyMi - sMwz - wxMxz)),
      wz = 2.0 * (v.xy * (wyMxz + wzMxy - sMi - wxMyz) + v.xz * (sMwx + wzMxz - wyMxy - yzMi) + v.yz * (sMwy + wxMxy + wzMyz + xzMi)),
      xy = (2.0 * (v.xz * (sMyz + xyMxz) + v.yz * (xyMyz - sMxz)) + v.xy * (sMs + xyMxy - xzMxz - yzMyz)),
      xz = (2.0 * (v.xy * (xyMxz - sMyz) + v.yz * (sMxy + xzMyz)) + v.xz * (sMs + xzMxz - xyMxy - yzMyz)),
      yz = (2.0 * (v.xy * (sMxz + xyMyz) + v.xz * (xzMyz - sMxy)) + v.yz * (sMs + yzMyz - xyMxy - xzMxz)),
      i = 2.0 * v.s * (sMi + wyMxz - wxMyz - wzMxy),
    )

  infix def sandwich(v: Translator): Motor =
    val sMs = s * s
    val sMxy = s * xy
    val sMxz = s * xz
    val sMyz = s * yz
    val xyMxy = xy * xy
    val xyMxz = xy * xz
    val xyMyz = xy * yz
    val xzMxz = xz * xz
    val xzMyz = xz * yz
    val yzMyz = yz * yz
    Motor(
      s = (sMs + xyMxy + xzMxz + yzMyz),
      wx = (2.0 * (v.wy * (sMxy - xzMyz) + v.wz * (sMxz + xyMyz)) + v.wx * (sMs + yzMyz - xyMxy - xzMxz)),
      wy = (2.0 * (v.wx * (-sMxy - xzMyz) + v.wz * (sMyz - xyMxz)) + v.wy * (sMs + xzMxz - xyMxy - yzMyz)),
      wz = (2.0 * (v.wx * (xyMyz - sMxz) + v.wy * (-sMyz - xyMxz)) + v.wz * (sMs + xyMxy - xzMxz - yzMyz)),
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
      i = 2.0 * (i * s + wy * xz - wx * yz - wz * xy),
    )

  infix def sandwich(v: Vector): Vector =
    val sMs = s * s
    val sMxy = s * xy
    val sMxz = s * xz
    val sMyz = s * yz
    val xyMxy = xy * xy
    val xyMxz = xy * xz
    val xyMyz = xy * yz
    val xzMxz = xz * xz
    val xzMyz = xz * yz
    val yzMyz = yz * yz
    Vector(
      wxy = (2.0 * (v.wxz * (sMyz + xyMxz) + v.wyz * (xyMyz - sMxz)) + v.wxy * (sMs + xyMxy - xzMxz - yzMyz)),
      wxz = (2.0 * (v.wxy * (xyMxz - sMyz) + v.wyz * (sMxy + xzMyz)) + v.wxz * (sMs + xzMxz - xyMxy - yzMyz)),
      wyz = (2.0 * (v.wxy * (sMxz + xyMyz) + v.wxz * (xzMyz - sMxy)) + v.wyz * (sMs + yzMyz - xyMxy - xzMxz)),
    )

  infix def sandwich(v: PointNormalized): Point =
    val sMs = s * s
    val sMxy = s * xy
    val sMxz = s * xz
    val sMyz = s * yz
    val xyMxy = xy * xy
    val xyMxz = xy * xz
    val xyMyz = xy * yz
    val xzMxz = xz * xz
    val xzMyz = xz * yz
    val yzMyz = yz * yz
    Point(
      wxy = (2.0 * (i * xy + s * wz + v.wxz * (sMyz + xyMxz) + v.wyz * (xyMyz - sMxz) - wx * xz - wy * yz) + v.wxy * (sMs + xyMxy - xzMxz - yzMyz)),
      wxz = (2.0 * (i * xz + v.wxy * (xyMxz - sMyz) + v.wyz * (sMxy + xzMyz) + wx * xy - s * wy - wz * yz) + v.wxz * (sMs + xzMxz - xyMxy - yzMyz)),
      wyz = (2.0 * (i * yz + s * wx + v.wxy * (sMxz + xyMyz) + v.wxz * (xzMyz - sMxy) + wy * xy + wz * xz) + v.wyz * (sMs + yzMyz - xyMxy - xzMxz)),
      xyz = (sMs + xyMxy + xzMxz + yzMyz),
    )

  infix def sandwich(v: PlaneIdeal): Plane =
    val sMs = s * s
    val sMxy = s * xy
    val sMxz = s * xz
    val sMyz = s * yz
    val xyMxy = xy * xy
    val xyMxz = xy * xz
    val xyMyz = xy * yz
    val xzMxz = xz * xz
    val xzMyz = xz * yz
    val yzMyz = yz * yz
    Plane(
      w = 2.0 * (v.x * (i * yz + s * wx - wy * xy - wz * xz) + v.y * (s * wy + wx * xy - i * xz - wz * yz) + v.z * (i * xy + s * wz + wx * xz + wy * yz)),
      x = (2.0 * (v.y * (sMxy - xzMyz) + v.z * (sMxz + xyMyz)) + v.x * (sMs + yzMyz - xyMxy - xzMxz)),
      y = (2.0 * (v.x * (-sMxy - xzMyz) + v.z * (sMyz - xyMxz)) + v.y * (sMs + xzMxz - xyMxy - yzMyz)),
      z = (2.0 * (v.x * (xyMyz - sMxz) + v.y * (-sMyz - xyMxz)) + v.z * (sMs + xyMxy - xzMxz - yzMyz)),
    )

  infix def sandwich(v: BivectorBulk): Bivector =
    val sMs = s * s
    val sMwx = s * wx
    val sMwy = s * wy
    val sMwz = s * wz
    val sMxy = s * xy
    val sMxz = s * xz
    val sMyz = s * yz
    val sMi = i * s
    val wxMxy = wx * xy
    val wxMxz = wx * xz
    val wxMyz = wx * yz
    val wyMxy = wy * xy
    val wyMxz = wy * xz
    val wyMyz = wy * yz
    val wzMxy = wz * xy
    val wzMxz = wz * xz
    val wzMyz = wz * yz
    val xyMxy = xy * xy
    val xyMxz = xy * xz
    val xyMyz = xy * yz
    val xyMi = i * xy
    val xzMxz = xz * xz
    val xzMyz = xz * yz
    val xzMi = i * xz
    val yzMyz = yz * yz
    val yzMi = i * yz
    Bivector(
      wx = 2.0 * (v.xy * (wxMxy + wzMyz - sMwy - xzMi) + v.xz * (wxMxz + xyMi - sMwz - wyMyz) + v.yz * (wxMyz + wyMxz - sMi - wzMxy)),
      wy = 2.0 * (v.xy * (sMwx + wyMxy - wzMxz - yzMi) + v.xz * (sMi + wxMyz + wyMxz + wzMxy) + v.yz * (wyMyz + xyMi - sMwz - wxMxz)),
      wz = 2.0 * (v.xy * (wyMxz + wzMxy - sMi - wxMyz) + v.xz * (sMwx + wzMxz - wyMxy - yzMi) + v.yz * (sMwy + wxMxy + wzMyz + xzMi)),
      xy = (2.0 * (v.xz * (sMyz + xyMxz) + v.yz * (xyMyz - sMxz)) + v.xy * (sMs + xyMxy - xzMxz - yzMyz)),
      xz = (2.0 * (v.xy * (xyMxz - sMyz) + v.yz * (sMxy + xzMyz)) + v.xz * (sMs + xzMxz - xyMxy - yzMyz)),
      yz = (2.0 * (v.xy * (sMxz + xyMyz) + v.xz * (xzMyz - sMxy)) + v.yz * (sMs + yzMyz - xyMxy - xzMxz)),
    )

  infix def sandwich(v: BivectorWeight): BivectorWeight =
    val sMs = s * s
    val sMxy = s * xy
    val sMxz = s * xz
    val sMyz = s * yz
    val xyMxy = xy * xy
    val xyMxz = xy * xz
    val xyMyz = xy * yz
    val xzMxz = xz * xz
    val xzMyz = xz * yz
    val yzMyz = yz * yz
    BivectorWeight(
      wx = (2.0 * (v.wy * (sMxy - xzMyz) + v.wz * (sMxz + xyMyz)) + v.wx * (sMs + yzMyz - xyMxy - xzMxz)),
      wy = (2.0 * (v.wx * (-sMxy - xzMyz) + v.wz * (sMyz - xyMxz)) + v.wy * (sMs + xzMxz - xyMxy - yzMyz)),
      wz = (2.0 * (v.wx * (xyMyz - sMxz) + v.wy * (-sMyz - xyMxz)) + v.wz * (sMs + xyMxy - xzMxz - yzMyz)),
    )

  infix def sandwich(v: PseudoScalar): PseudoScalar =
    PseudoScalar(
      i = v.i * (s * s + xy * xy + xz * xz + yz * yz),
    )

  infix def sandwich(v: PointCenter.type): Point =
    Point(
      wxy = 2.0 * (i * xy + s * wz - wx * xz - wy * yz),
      wxz = 2.0 * (i * xz + wx * xy - s * wy - wz * yz),
      wyz = 2.0 * (i * yz + s * wx + wy * xy + wz * xz),
      xyz = (s * s + xy * xy + xz * xz + yz * yz),
    )

  infix def reverseSandwich(v: Multivector): Multivector =
    val sMs = s * s
    val sMwx = s * wx
    val sMwy = s * wy
    val sMwz = s * wz
    val sMxy = s * xy
    val sMxz = s * xz
    val sMyz = s * yz
    val sMi = i * s
    val wxMxy = wx * xy
    val wxMxz = wx * xz
    val wxMyz = wx * yz
    val wyMxy = wy * xy
    val wyMxz = wy * xz
    val wyMyz = wy * yz
    val wzMxy = wz * xy
    val wzMxz = wz * xz
    val wzMyz = wz * yz
    val xyMxy = xy * xy
    val xyMxz = xy * xz
    val xyMyz = xy * yz
    val xyMi = i * xy
    val xzMxz = xz * xz
    val xzMyz = xz * yz
    val xzMi = i * xz
    val yzMyz = yz * yz
    val yzMi = i * yz
    Multivector(
      s = v.s * (sMs + xyMxy + xzMxz + yzMyz),
      w = (2.0 * (v.x * (-sMwx - wyMxy - wzMxz - yzMi) + v.y * (wxMxy + xzMi - sMwy - wzMyz) + v.z * (wxMxz + wyMyz - sMwz - xyMi)) + v.w * (sMs + xyMxy + xzMxz + yzMyz)),
      x = (2.0 * (v.y * (-sMxy - xzMyz) + v.z * (xyMyz - sMxz)) + v.x * (sMs + yzMyz - xyMxy - xzMxz)),
      y = (2.0 * (v.x * (sMxy - xzMyz) + v.z * (-sMyz - xyMxz)) + v.y * (sMs + xzMxz - xyMxy - yzMyz)),
      z = (2.0 * (v.x * (sMxz + xyMyz) + v.y * (sMyz - xyMxz)) + v.z * (sMs + xyMxy - xzMxz - yzMyz)),
      wx = (2.0 * (v.wy * (-sMxy - xzMyz) + v.wz * (xyMyz - sMxz) + v.xy * (sMwy + wxMxy + wzMyz + xzMi) + v.xz * (sMwz + wxMxz - wyMyz - xyMi) + v.yz * (wxMyz + wyMxz - sMi - wzMxy)) + v.wx * (sMs + yzMyz - xyMxy - xzMxz)),
      wy = (2.0 * (v.wx * (sMxy - xzMyz) + v.wz * (-sMyz - xyMxz) + v.xy * (wyMxy + yzMi - sMwx - wzMxz) + v.xz * (sMi + wxMyz + wyMxz + wzMxy) + v.yz * (sMwz + wyMyz - wxMxz - xyMi)) + v.wy * (sMs + xzMxz - xyMxy - yzMyz)),
      wz = (2.0 * (v.wx * (sMxz + xyMyz) + v.wy * (sMyz - xyMxz) + v.xy * (wyMxz + wzMxy - sMi - wxMyz) + v.xz * (wzMxz + yzMi - sMwx - wyMxy) + v.yz * (wxMxy + wzMyz - sMwy - xzMi)) + v.wz * (sMs + xyMxy - xzMxz - yzMyz)),
      xy = (2.0 * (v.xz * (xyMxz - sMyz) + v.yz * (sMxz + xyMyz)) + v.xy * (sMs + xyMxy - xzMxz - yzMyz)),
      xz = (2.0 * (v.xy * (sMyz + xyMxz) + v.yz * (xzMyz - sMxy)) + v.xz * (sMs + xzMxz - xyMxy - yzMyz)),
      yz = (2.0 * (v.xy * (xyMyz - sMxz) + v.xz * (sMxy + xzMyz)) + v.yz * (sMs + yzMyz - xyMxy - xzMxz)),
      wxy = (2.0 * (v.wxz * (xyMxz - sMyz) + v.wyz * (sMxz + xyMyz) + v.xyz * (-sMwz - wxMxz - wyMyz - xyMi)) + v.wxy * (sMs + xyMxy - xzMxz - yzMyz)),
      wxz = (2.0 * (v.wxy * (sMyz + xyMxz) + v.wyz * (xzMyz - sMxy) + v.xyz * (sMwy + wxMxy - wzMyz - xzMi)) + v.wxz * (sMs + xzMxz - xyMxy - yzMyz)),
      wyz = (2.0 * (v.wxy * (xyMyz - sMxz) + v.wxz * (sMxy + xzMyz) + v.xyz * (wyMxy + wzMxz - sMwx - yzMi)) + v.wyz * (sMs + yzMyz - xyMxy - xzMxz)),
      xyz = v.xyz * (sMs + xyMxy + xzMxz + yzMyz),
      i = (v.i * (sMs + xyMxy + xzMxz + yzMyz) + 2.0 * v.s * (sMi + wyMxz - wxMyz - wzMxy)),
    )

  infix def reverseSandwich(v: Motor): Motor =
    val sMs = s * s
    val sMwx = s * wx
    val sMwy = s * wy
    val sMwz = s * wz
    val sMxy = s * xy
    val sMxz = s * xz
    val sMyz = s * yz
    val sMi = i * s
    val wxMxy = wx * xy
    val wxMxz = wx * xz
    val wxMyz = wx * yz
    val wyMxy = wy * xy
    val wyMxz = wy * xz
    val wyMyz = wy * yz
    val wzMxy = wz * xy
    val wzMxz = wz * xz
    val wzMyz = wz * yz
    val xyMxy = xy * xy
    val xyMxz = xy * xz
    val xyMyz = xy * yz
    val xyMi = i * xy
    val xzMxz = xz * xz
    val xzMyz = xz * yz
    val xzMi = i * xz
    val yzMyz = yz * yz
    val yzMi = i * yz
    Motor(
      s = v.s * (sMs + xyMxy + xzMxz + yzMyz),
      wx = (2.0 * (v.wy * (-sMxy - xzMyz) + v.wz * (xyMyz - sMxz) + v.xy * (sMwy + wxMxy + wzMyz + xzMi) + v.xz * (sMwz + wxMxz - wyMyz - xyMi) + v.yz * (wxMyz + wyMxz - sMi - wzMxy)) + v.wx * (sMs + yzMyz - xyMxy - xzMxz)),
      wy = (2.0 * (v.wx * (sMxy - xzMyz) + v.wz * (-sMyz - xyMxz) + v.xy * (wyMxy + yzMi - sMwx - wzMxz) + v.xz * (sMi + wxMyz + wyMxz + wzMxy) + v.yz * (sMwz + wyMyz - wxMxz - xyMi)) + v.wy * (sMs + xzMxz - xyMxy - yzMyz)),
      wz = (2.0 * (v.wx * (sMxz + xyMyz) + v.wy * (sMyz - xyMxz) + v.xy * (wyMxz + wzMxy - sMi - wxMyz) + v.xz * (wzMxz + yzMi - sMwx - wyMxy) + v.yz * (wxMxy + wzMyz - sMwy - xzMi)) + v.wz * (sMs + xyMxy - xzMxz - yzMyz)),
      xy = (2.0 * (v.xz * (xyMxz - sMyz) + v.yz * (sMxz + xyMyz)) + v.xy * (sMs + xyMxy - xzMxz - yzMyz)),
      xz = (2.0 * (v.xy * (sMyz + xyMxz) + v.yz * (xzMyz - sMxy)) + v.xz * (sMs + xzMxz - xyMxy - yzMyz)),
      yz = (2.0 * (v.xy * (xyMyz - sMxz) + v.xz * (sMxy + xzMyz)) + v.yz * (sMs + yzMyz - xyMxy - xzMxz)),
      i = (v.i * (sMs + xyMxy + xzMxz + yzMyz) + 2.0 * v.s * (sMi + wyMxz - wxMyz - wzMxy)),
    )

  infix def reverseSandwich(v: Plane): Plane =
    val sMs = s * s
    val sMxy = s * xy
    val sMxz = s * xz
    val sMyz = s * yz
    val xyMxy = xy * xy
    val xyMxz = xy * xz
    val xyMyz = xy * yz
    val xzMxz = xz * xz
    val xzMyz = xz * yz
    val yzMyz = yz * yz
    Plane(
      w = (2.0 * (v.x * (-i * yz - s * wx - wy * xy - wz * xz) + v.y * (i * xz + wx * xy - s * wy - wz * yz) + v.z * (wx * xz + wy * yz - i * xy - s * wz)) + v.w * (sMs + xyMxy + xzMxz + yzMyz)),
      x = (2.0 * (v.y * (-sMxy - xzMyz) + v.z * (xyMyz - sMxz)) + v.x * (sMs + yzMyz - xyMxy - xzMxz)),
      y = (2.0 * (v.x * (sMxy - xzMyz) + v.z * (-sMyz - xyMxz)) + v.y * (sMs + xzMxz - xyMxy - yzMyz)),
      z = (2.0 * (v.x * (sMxz + xyMyz) + v.y * (sMyz - xyMxz)) + v.z * (sMs + xyMxy - xzMxz - yzMyz)),
    )

  infix def reverseSandwich(v: Bivector): Bivector =
    val sMs = s * s
    val sMwx = s * wx
    val sMwy = s * wy
    val sMwz = s * wz
    val sMxy = s * xy
    val sMxz = s * xz
    val sMyz = s * yz
    val sMi = i * s
    val wxMxy = wx * xy
    val wxMxz = wx * xz
    val wxMyz = wx * yz
    val wyMxy = wy * xy
    val wyMxz = wy * xz
    val wyMyz = wy * yz
    val wzMxy = wz * xy
    val wzMxz = wz * xz
    val wzMyz = wz * yz
    val xyMxy = xy * xy
    val xyMxz = xy * xz
    val xyMyz = xy * yz
    val xyMi = i * xy
    val xzMxz = xz * xz
    val xzMyz = xz * yz
    val xzMi = i * xz
    val yzMyz = yz * yz
    val yzMi = i * yz
    Bivector(
      wx = (2.0 * (v.wy * (-sMxy - xzMyz) + v.wz * (xyMyz - sMxz) + v.xy * (sMwy + wxMxy + wzMyz + xzMi) + v.xz * (sMwz + wxMxz - wyMyz - xyMi) + v.yz * (wxMyz + wyMxz - sMi - wzMxy)) + v.wx * (sMs + yzMyz - xyMxy - xzMxz)),
      wy = (2.0 * (v.wx * (sMxy - xzMyz) + v.wz * (-sMyz - xyMxz) + v.xy * (wyMxy + yzMi - sMwx - wzMxz) + v.xz * (sMi + wxMyz + wyMxz + wzMxy) + v.yz * (sMwz + wyMyz - wxMxz - xyMi)) + v.wy * (sMs + xzMxz - xyMxy - yzMyz)),
      wz = (2.0 * (v.wx * (sMxz + xyMyz) + v.wy * (sMyz - xyMxz) + v.xy * (wyMxz + wzMxy - sMi - wxMyz) + v.xz * (wzMxz + yzMi - sMwx - wyMxy) + v.yz * (wxMxy + wzMyz - sMwy - xzMi)) + v.wz * (sMs + xyMxy - xzMxz - yzMyz)),
      xy = (2.0 * (v.xz * (xyMxz - sMyz) + v.yz * (sMxz + xyMyz)) + v.xy * (sMs + xyMxy - xzMxz - yzMyz)),
      xz = (2.0 * (v.xy * (sMyz + xyMxz) + v.yz * (xzMyz - sMxy)) + v.xz * (sMs + xzMxz - xyMxy - yzMyz)),
      yz = (2.0 * (v.xy * (xyMyz - sMxz) + v.xz * (sMxy + xzMyz)) + v.yz * (sMs + yzMyz - xyMxy - xzMxz)),
    )

  infix def reverseSandwich(v: Point): Point =
    val sMs = s * s
    val sMxy = s * xy
    val sMxz = s * xz
    val sMyz = s * yz
    val xyMxy = xy * xy
    val xyMxz = xy * xz
    val xyMyz = xy * yz
    val xzMxz = xz * xz
    val xzMyz = xz * yz
    val yzMyz = yz * yz
    Point(
      wxy = (2.0 * (v.wxz * (xyMxz - sMyz) + v.wyz * (sMxz + xyMyz) + v.xyz * (-i * xy - s * wz - wx * xz - wy * yz)) + v.wxy * (sMs + xyMxy - xzMxz - yzMyz)),
      wxz = (2.0 * (v.wxy * (sMyz + xyMxz) + v.wyz * (xzMyz - sMxy) + v.xyz * (s * wy + wx * xy - i * xz - wz * yz)) + v.wxz * (sMs + xzMxz - xyMxy - yzMyz)),
      wyz = (2.0 * (v.wxy * (xyMyz - sMxz) + v.wxz * (sMxy + xzMyz) + v.xyz * (wy * xy + wz * xz - i * yz - s * wx)) + v.wyz * (sMs + yzMyz - xyMxy - xzMxz)),
      xyz = v.xyz * (sMs + xyMxy + xzMxz + yzMyz),
    )

  infix def reverseSandwich(v: Quaternion): Motor =
    val sMs = s * s
    val sMwx = s * wx
    val sMwy = s * wy
    val sMwz = s * wz
    val sMxy = s * xy
    val sMxz = s * xz
    val sMyz = s * yz
    val sMi = i * s
    val wxMxy = wx * xy
    val wxMxz = wx * xz
    val wxMyz = wx * yz
    val wyMxy = wy * xy
    val wyMxz = wy * xz
    val wyMyz = wy * yz
    val wzMxy = wz * xy
    val wzMxz = wz * xz
    val wzMyz = wz * yz
    val xyMxy = xy * xy
    val xyMxz = xy * xz
    val xyMyz = xy * yz
    val xyMi = i * xy
    val xzMxz = xz * xz
    val xzMyz = xz * yz
    val xzMi = i * xz
    val yzMyz = yz * yz
    val yzMi = i * yz
    Motor(
      s = v.s * (sMs + xyMxy + xzMxz + yzMyz),
      wx = 2.0 * (v.xy * (sMwy + wxMxy + wzMyz + xzMi) + v.xz * (sMwz + wxMxz - wyMyz - xyMi) + v.yz * (wxMyz + wyMxz - sMi - wzMxy)),
      wy = 2.0 * (v.xy * (wyMxy + yzMi - sMwx - wzMxz) + v.xz * (sMi + wxMyz + wyMxz + wzMxy) + v.yz * (sMwz + wyMyz - wxMxz - xyMi)),
      wz = 2.0 * (v.xy * (wyMxz + wzMxy - sMi - wxMyz) + v.xz * (wzMxz + yzMi - sMwx - wyMxy) + v.yz * (wxMxy + wzMyz - sMwy - xzMi)),
      xy = (2.0 * (v.xz * (xyMxz - sMyz) + v.yz * (sMxz + xyMyz)) + v.xy * (sMs + xyMxy - xzMxz - yzMyz)),
      xz = (2.0 * (v.xy * (sMyz + xyMxz) + v.yz * (xzMyz - sMxy)) + v.xz * (sMs + xzMxz - xyMxy - yzMyz)),
      yz = (2.0 * (v.xy * (xyMyz - sMxz) + v.xz * (sMxy + xzMyz)) + v.yz * (sMs + yzMyz - xyMxy - xzMxz)),
      i = 2.0 * v.s * (sMi + wyMxz - wxMyz - wzMxy),
    )

  infix def reverseSandwich(v: Translator): Motor =
    val sMs = s * s
    val sMxy = s * xy
    val sMxz = s * xz
    val sMyz = s * yz
    val xyMxy = xy * xy
    val xyMxz = xy * xz
    val xyMyz = xy * yz
    val xzMxz = xz * xz
    val xzMyz = xz * yz
    val yzMyz = yz * yz
    Motor(
      s = (sMs + xyMxy + xzMxz + yzMyz),
      wx = (2.0 * (v.wy * (-sMxy - xzMyz) + v.wz * (xyMyz - sMxz)) + v.wx * (sMs + yzMyz - xyMxy - xzMxz)),
      wy = (2.0 * (v.wx * (sMxy - xzMyz) + v.wz * (-sMyz - xyMxz)) + v.wy * (sMs + xzMxz - xyMxy - yzMyz)),
      wz = (2.0 * (v.wx * (sMxz + xyMyz) + v.wy * (sMyz - xyMxz)) + v.wz * (sMs + xyMxy - xzMxz - yzMyz)),
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
      i = 2.0 * (i * s + wy * xz - wx * yz - wz * xy),
    )

  infix def reverseSandwich(v: Vector): Vector =
    val sMs = s * s
    val sMxy = s * xy
    val sMxz = s * xz
    val sMyz = s * yz
    val xyMxy = xy * xy
    val xyMxz = xy * xz
    val xyMyz = xy * yz
    val xzMxz = xz * xz
    val xzMyz = xz * yz
    val yzMyz = yz * yz
    Vector(
      wxy = (2.0 * (v.wxz * (xyMxz - sMyz) + v.wyz * (sMxz + xyMyz)) + v.wxy * (sMs + xyMxy - xzMxz - yzMyz)),
      wxz = (2.0 * (v.wxy * (sMyz + xyMxz) + v.wyz * (xzMyz - sMxy)) + v.wxz * (sMs + xzMxz - xyMxy - yzMyz)),
      wyz = (2.0 * (v.wxy * (xyMyz - sMxz) + v.wxz * (sMxy + xzMyz)) + v.wyz * (sMs + yzMyz - xyMxy - xzMxz)),
    )

  infix def reverseSandwich(v: PointNormalized): Point =
    val sMs = s * s
    val sMxy = s * xy
    val sMxz = s * xz
    val sMyz = s * yz
    val xyMxy = xy * xy
    val xyMxz = xy * xz
    val xyMyz = xy * yz
    val xzMxz = xz * xz
    val xzMyz = xz * yz
    val yzMyz = yz * yz
    Point(
      wxy = (2.0 * (v.wxz * (xyMxz - sMyz) + v.wyz * (sMxz + xyMyz) - i * xy - s * wz - wx * xz - wy * yz) + v.wxy * (sMs + xyMxy - xzMxz - yzMyz)),
      wxz = (2.0 * (s * wy + v.wxy * (sMyz + xyMxz) + v.wyz * (xzMyz - sMxy) + wx * xy - i * xz - wz * yz) + v.wxz * (sMs + xzMxz - xyMxy - yzMyz)),
      wyz = (2.0 * (v.wxy * (xyMyz - sMxz) + v.wxz * (sMxy + xzMyz) + wy * xy + wz * xz - i * yz - s * wx) + v.wyz * (sMs + yzMyz - xyMxy - xzMxz)),
      xyz = (sMs + xyMxy + xzMxz + yzMyz),
    )

  infix def reverseSandwich(v: PlaneIdeal): Plane =
    val sMs = s * s
    val sMxy = s * xy
    val sMxz = s * xz
    val sMyz = s * yz
    val xyMxy = xy * xy
    val xyMxz = xy * xz
    val xyMyz = xy * yz
    val xzMxz = xz * xz
    val xzMyz = xz * yz
    val yzMyz = yz * yz
    Plane(
      w = 2.0 * (v.x * (-i * yz - s * wx - wy * xy - wz * xz) + v.y * (i * xz + wx * xy - s * wy - wz * yz) + v.z * (wx * xz + wy * yz - i * xy - s * wz)),
      x = (2.0 * (v.y * (-sMxy - xzMyz) + v.z * (xyMyz - sMxz)) + v.x * (sMs + yzMyz - xyMxy - xzMxz)),
      y = (2.0 * (v.x * (sMxy - xzMyz) + v.z * (-sMyz - xyMxz)) + v.y * (sMs + xzMxz - xyMxy - yzMyz)),
      z = (2.0 * (v.x * (sMxz + xyMyz) + v.y * (sMyz - xyMxz)) + v.z * (sMs + xyMxy - xzMxz - yzMyz)),
    )

  infix def reverseSandwich(v: BivectorBulk): Bivector =
    val sMs = s * s
    val sMwx = s * wx
    val sMwy = s * wy
    val sMwz = s * wz
    val sMxy = s * xy
    val sMxz = s * xz
    val sMyz = s * yz
    val sMi = i * s
    val wxMxy = wx * xy
    val wxMxz = wx * xz
    val wxMyz = wx * yz
    val wyMxy = wy * xy
    val wyMxz = wy * xz
    val wyMyz = wy * yz
    val wzMxy = wz * xy
    val wzMxz = wz * xz
    val wzMyz = wz * yz
    val xyMxy = xy * xy
    val xyMxz = xy * xz
    val xyMyz = xy * yz
    val xyMi = i * xy
    val xzMxz = xz * xz
    val xzMyz = xz * yz
    val xzMi = i * xz
    val yzMyz = yz * yz
    val yzMi = i * yz
    Bivector(
      wx = 2.0 * (v.xy * (sMwy + wxMxy + wzMyz + xzMi) + v.xz * (sMwz + wxMxz - wyMyz - xyMi) + v.yz * (wxMyz + wyMxz - sMi - wzMxy)),
      wy = 2.0 * (v.xy * (wyMxy + yzMi - sMwx - wzMxz) + v.xz * (sMi + wxMyz + wyMxz + wzMxy) + v.yz * (sMwz + wyMyz - wxMxz - xyMi)),
      wz = 2.0 * (v.xy * (wyMxz + wzMxy - sMi - wxMyz) + v.xz * (wzMxz + yzMi - sMwx - wyMxy) + v.yz * (wxMxy + wzMyz - sMwy - xzMi)),
      xy = (2.0 * (v.xz * (xyMxz - sMyz) + v.yz * (sMxz + xyMyz)) + v.xy * (sMs + xyMxy - xzMxz - yzMyz)),
      xz = (2.0 * (v.xy * (sMyz + xyMxz) + v.yz * (xzMyz - sMxy)) + v.xz * (sMs + xzMxz - xyMxy - yzMyz)),
      yz = (2.0 * (v.xy * (xyMyz - sMxz) + v.xz * (sMxy + xzMyz)) + v.yz * (sMs + yzMyz - xyMxy - xzMxz)),
    )

  infix def reverseSandwich(v: BivectorWeight): BivectorWeight =
    val sMs = s * s
    val sMxy = s * xy
    val sMxz = s * xz
    val sMyz = s * yz
    val xyMxy = xy * xy
    val xyMxz = xy * xz
    val xyMyz = xy * yz
    val xzMxz = xz * xz
    val xzMyz = xz * yz
    val yzMyz = yz * yz
    BivectorWeight(
      wx = (2.0 * (v.wy * (-sMxy - xzMyz) + v.wz * (xyMyz - sMxz)) + v.wx * (sMs + yzMyz - xyMxy - xzMxz)),
      wy = (2.0 * (v.wx * (sMxy - xzMyz) + v.wz * (-sMyz - xyMxz)) + v.wy * (sMs + xzMxz - xyMxy - yzMyz)),
      wz = (2.0 * (v.wx * (sMxz + xyMyz) + v.wy * (sMyz - xyMxz)) + v.wz * (sMs + xyMxy - xzMxz - yzMyz)),
    )

  infix def reverseSandwich(v: PseudoScalar): PseudoScalar =
    PseudoScalar(
      i = v.i * (s * s + xy * xy + xz * xz + yz * yz),
    )

  infix def reverseSandwich(v: PointCenter.type): Point =
    Point(
      wxy = 2.0 * (-i * xy - s * wz - wx * xz - wy * yz),
      wxz = 2.0 * (s * wy + wx * xy - i * xz - wz * yz),
      wyz = 2.0 * (wy * xy + wz * xz - i * yz - s * wx),
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

  infix def cross(v: Translator): BivectorWeight =
    BivectorWeight(
      wx = (v.wy * xy + v.wz * xz),
      wy = (v.wz * yz - v.wx * xy),
      wz = (-v.wx * xz - v.wy * yz),
    )

  infix def cross(v: Vector): Vector =
    Vector(
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

  infix def cross(v: BivectorBulk): Bivector =
    Bivector(
      wx = (-v.xy * wy - v.xz * wz),
      wy = (v.xy * wx - v.yz * wz),
      wz = (v.xz * wx + v.yz * wy),
      xy = (v.xz * yz - v.yz * xz),
      xz = (v.yz * xy - v.xy * yz),
      yz = (v.xy * xz - v.xz * xy),
    )

  infix def cross(v: BivectorWeight): BivectorWeight =
    BivectorWeight(
      wx = (v.wy * xy + v.wz * xz),
      wy = (v.wz * yz - v.wx * xy),
      wz = (-v.wx * xz - v.wy * yz),
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


object Motor:
  val id: Motor = Motor(1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0)