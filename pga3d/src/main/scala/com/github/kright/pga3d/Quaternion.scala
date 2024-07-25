package com.github.kright.pga3d

/** this code is generated, see com.github.kright.pga3d.codegen.CodeGenClass */
case class Quaternion(s: Double = 0.0,
                      xy: Double = 0.0,
                      xz: Double = 0.0,
                      yz: Double = 0.0):

  def dual: Motor =
    Motor(
      s = 0.0,
      wx = yz,
      wy = -xz,
      wz = xy,
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
      i = s,
    )

  def bulk: Quaternion =
    this

  def unary_- : Quaternion =
    Quaternion(
      s = -s,
      xy = -xy,
      xz = -xz,
      yz = -yz,
    )

  def reverse: Quaternion =
    Quaternion(
      s = s,
      xy = -xy,
      xz = -xz,
      yz = -yz,
    )

  def antiReverse: Quaternion =
    Quaternion(
      s = s,
      xy = -xy,
      xz = -xz,
      yz = -yz,
    )

  def bulkNormSquare: Double =
    (s * s + xy * xy + xz * xz + yz * yz)

  def bulkNorm: Double =
    Math.sqrt(bulkNormSquare)

  def normalizedByBulk =
    this / bulkNorm

  def normSquare: Double =
    (s * s + xy * xy + xz * xz + yz * yz)

  def norm: Double =
    Math.sqrt(normSquare)

  def normalizedByNorm =
    this / norm

  def *(v: Double): Quaternion =
    Quaternion(
      s = s * v,
      xy = v * xy,
      xz = v * xz,
      yz = v * yz,
    )

  inline def /(v: Double): Quaternion =
    this * (1.0 / v)

  def +(v: Quaternion): Quaternion =
    Quaternion(
      s = (s + v.s),
      xy = (v.xy + xy),
      xz = (v.xz + xz),
      yz = (v.yz + yz),
    )

  def -(v: Quaternion): Quaternion =
    Quaternion(
      s = (s - v.s),
      xy = (xy - v.xy),
      xz = (xz - v.xz),
      yz = (yz - v.yz),
    )

  def madd(v: Quaternion, mult: Double): Quaternion =
    Quaternion(
      s = (s + mult * v.s),
      xy = (xy + mult * v.xy),
      xz = (xz + mult * v.xz),
      yz = (yz + mult * v.yz),
    )

  def multiplyElementwise(v: Quaternion): Quaternion =
    Quaternion(
      s = s * v.s,
      xy = v.xy * xy,
      xz = v.xz * xz,
      yz = v.yz * yz,
    )

  def log(): BivectorBulk =
    val scalar = s
    val lenXYZ = Math.sqrt(xy * xy + xz * xz + yz * yz)
    val angle = Math.atan2(lenXYZ, scalar)

    val a = 1.0 / (1.0 - scalar * scalar) // 1 / sin^2

    val b = if (Math.abs(angle) > 1e-5) { // angle / sin(angle)
      angle * Math.sqrt(a)
    } else {
      1.0 + angle * angle / 6.0
    }

    BivectorBulk(
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
      wx = 0.0,
      wy = 0.0,
      wz = 0.0,
      xy = xy,
      xz = xz,
      yz = yz,
      wxy = 0.0,
      wxz = 0.0,
      wyz = 0.0,
      xyz = 0.0,
      i = 0.0,
    )

  def toMotor: Motor =
    Motor(
      s = s,
      wx = 0.0,
      wy = 0.0,
      wz = 0.0,
      xy = xy,
      xz = xz,
      yz = yz,
      i = 0.0,
    )

  def asBivectorUnsafe: Bivector =
    Bivector(
      wx = 0.0,
      wy = 0.0,
      wz = 0.0,
      xy = xy,
      xz = xz,
      yz = yz,
    )

  def asBivectorBulkUnsafe: BivectorBulk =
    BivectorBulk(
      xy = xy,
      xz = xz,
      yz = yz,
    )

  infix def geometric(v: Multivector): Multivector =
    Multivector(
      s = (s * v.s - v.xy * xy - v.xz * xz - v.yz * yz),
      w = (s * v.w - v.wxy * xy - v.wxz * xz - v.wyz * yz),
      x = (s * v.x + v.y * xy + v.z * xz - v.xyz * yz),
      y = (s * v.y + v.xyz * xz + v.z * yz - v.x * xy),
      z = (s * v.z - v.x * xz - v.xyz * xy - v.y * yz),
      wx = (s * v.wx + v.wy * xy + v.wz * xz - v.i * yz),
      wy = (s * v.wy + v.i * xz + v.wz * yz - v.wx * xy),
      wz = (s * v.wz - v.i * xy - v.wx * xz - v.wy * yz),
      xy = (s * v.xy + v.s * xy + v.xz * yz - v.yz * xz),
      xz = (s * v.xz + v.s * xz + v.yz * xy - v.xy * yz),
      yz = (s * v.yz + v.s * yz + v.xy * xz - v.xz * xy),
      wxy = (s * v.wxy + v.w * xy + v.wxz * yz - v.wyz * xz),
      wxz = (s * v.wxz + v.w * xz + v.wyz * xy - v.wxy * yz),
      wyz = (s * v.wyz + v.w * yz + v.wxy * xz - v.wxz * xy),
      xyz = (s * v.xyz + v.x * yz + v.z * xy - v.y * xz),
      i = (s * v.i + v.wx * yz + v.wz * xy - v.wy * xz),
    )

  infix def geometric(v: Motor): Motor =
    Motor(
      s = (s * v.s - v.xy * xy - v.xz * xz - v.yz * yz),
      wx = (s * v.wx + v.wy * xy + v.wz * xz - v.i * yz),
      wy = (s * v.wy + v.i * xz + v.wz * yz - v.wx * xy),
      wz = (s * v.wz - v.i * xy - v.wx * xz - v.wy * yz),
      xy = (s * v.xy + v.s * xy + v.xz * yz - v.yz * xz),
      xz = (s * v.xz + v.s * xz + v.yz * xy - v.xy * yz),
      yz = (s * v.yz + v.s * yz + v.xy * xz - v.xz * xy),
      i = (s * v.i + v.wx * yz + v.wz * xy - v.wy * xz),
    )

  infix def geometric(v: Plane): Multivector =
    Multivector(
      s = 0.0,
      w = s * v.w,
      x = (s * v.x + v.y * xy + v.z * xz),
      y = (s * v.y + v.z * yz - v.x * xy),
      z = (s * v.z - v.x * xz - v.y * yz),
      wx = 0.0,
      wy = 0.0,
      wz = 0.0,
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
      wxy = v.w * xy,
      wxz = v.w * xz,
      wyz = v.w * yz,
      xyz = (v.x * yz + v.z * xy - v.y * xz),
      i = 0.0,
    )

  infix def geometric(v: Bivector): Motor =
    Motor(
      s = (-v.xy * xy - v.xz * xz - v.yz * yz),
      wx = (s * v.wx + v.wy * xy + v.wz * xz),
      wy = (s * v.wy + v.wz * yz - v.wx * xy),
      wz = (s * v.wz - v.wx * xz - v.wy * yz),
      xy = (s * v.xy + v.xz * yz - v.yz * xz),
      xz = (s * v.xz + v.yz * xy - v.xy * yz),
      yz = (s * v.yz + v.xy * xz - v.xz * xy),
      i = (v.wx * yz + v.wz * xy - v.wy * xz),
    )

  infix def geometric(v: Point): Multivector =
    Multivector(
      s = 0.0,
      w = (-v.wxy * xy - v.wxz * xz - v.wyz * yz),
      x = -v.xyz * yz,
      y = v.xyz * xz,
      z = -v.xyz * xy,
      wx = 0.0,
      wy = 0.0,
      wz = 0.0,
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
      wxy = (s * v.wxy + v.wxz * yz - v.wyz * xz),
      wxz = (s * v.wxz + v.wyz * xy - v.wxy * yz),
      wyz = (s * v.wyz + v.wxy * xz - v.wxz * xy),
      xyz = s * v.xyz,
      i = 0.0,
    )

  infix def geometric(v: Quaternion): Quaternion =
    Quaternion(
      s = (s * v.s - v.xy * xy - v.xz * xz - v.yz * yz),
      xy = (s * v.xy + v.s * xy + v.xz * yz - v.yz * xz),
      xz = (s * v.xz + v.s * xz + v.yz * xy - v.xy * yz),
      yz = (s * v.yz + v.s * yz + v.xy * xz - v.xz * xy),
    )

  infix def geometric(v: Translator): Motor =
    Motor(
      s = s,
      wx = (s * v.wx + v.wy * xy + v.wz * xz),
      wy = (s * v.wy + v.wz * yz - v.wx * xy),
      wz = (s * v.wz - v.wx * xz - v.wy * yz),
      xy = xy,
      xz = xz,
      yz = yz,
      i = (v.wx * yz + v.wz * xy - v.wy * xz),
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
      w = (-v.wxy * xy - v.wxz * xz - v.wyz * yz),
      x = -yz,
      y = xz,
      z = -xy,
      wx = 0.0,
      wy = 0.0,
      wz = 0.0,
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
      wxy = (s * v.wxy + v.wxz * yz - v.wyz * xz),
      wxz = (s * v.wxz + v.wyz * xy - v.wxy * yz),
      wyz = (s * v.wyz + v.wxy * xz - v.wxz * xy),
      xyz = s,
      i = 0.0,
    )

  infix def geometric(v: PlaneIdeal): Multivector =
    Multivector(
      s = 0.0,
      w = 0.0,
      x = (s * v.x + v.y * xy + v.z * xz),
      y = (s * v.y + v.z * yz - v.x * xy),
      z = (s * v.z - v.x * xz - v.y * yz),
      wx = 0.0,
      wy = 0.0,
      wz = 0.0,
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
      wxy = 0.0,
      wxz = 0.0,
      wyz = 0.0,
      xyz = (v.x * yz + v.z * xy - v.y * xz),
      i = 0.0,
    )

  infix def geometric(v: BivectorBulk): Quaternion =
    Quaternion(
      s = (-v.xy * xy - v.xz * xz - v.yz * yz),
      xy = (s * v.xy + v.xz * yz - v.yz * xz),
      xz = (s * v.xz + v.yz * xy - v.xy * yz),
      yz = (s * v.yz + v.xy * xz - v.xz * xy),
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
      w = 0.0,
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

  infix def dot(v: Multivector): Multivector =
    Multivector(
      s = (s * v.s - v.xy * xy - v.xz * xz - v.yz * yz),
      w = (s * v.w - v.wxy * xy - v.wxz * xz - v.wyz * yz),
      x = (s * v.x + v.y * xy + v.z * xz - v.xyz * yz),
      y = (s * v.y + v.xyz * xz + v.z * yz - v.x * xy),
      z = (s * v.z - v.x * xz - v.xyz * xy - v.y * yz),
      wx = (s * v.wx - v.i * yz),
      wy = (s * v.wy + v.i * xz),
      wz = (s * v.wz - v.i * xy),
      xy = (s * v.xy + v.s * xy),
      xz = (s * v.xz + v.s * xz),
      yz = (s * v.yz + v.s * yz),
      wxy = s * v.wxy,
      wxz = s * v.wxz,
      wyz = s * v.wyz,
      xyz = s * v.xyz,
      i = s * v.i,
    )

  infix def dot(v: Motor): Motor =
    Motor(
      s = (s * v.s - v.xy * xy - v.xz * xz - v.yz * yz),
      wx = (s * v.wx - v.i * yz),
      wy = (s * v.wy + v.i * xz),
      wz = (s * v.wz - v.i * xy),
      xy = (s * v.xy + v.s * xy),
      xz = (s * v.xz + v.s * xz),
      yz = (s * v.yz + v.s * yz),
      i = s * v.i,
    )

  infix def dot(v: Plane): Plane =
    Plane(
      w = s * v.w,
      x = (s * v.x + v.y * xy + v.z * xz),
      y = (s * v.y + v.z * yz - v.x * xy),
      z = (s * v.z - v.x * xz - v.y * yz),
    )

  infix def dot(v: Bivector): Motor =
    Motor(
      s = (-v.xy * xy - v.xz * xz - v.yz * yz),
      wx = s * v.wx,
      wy = s * v.wy,
      wz = s * v.wz,
      xy = s * v.xy,
      xz = s * v.xz,
      yz = s * v.yz,
      i = 0.0,
    )

  infix def dot(v: Point): Multivector =
    Multivector(
      s = 0.0,
      w = (-v.wxy * xy - v.wxz * xz - v.wyz * yz),
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

  infix def dot(v: Quaternion): Quaternion =
    Quaternion(
      s = (s * v.s - v.xy * xy - v.xz * xz - v.yz * yz),
      xy = (s * v.xy + v.s * xy),
      xz = (s * v.xz + v.s * xz),
      yz = (s * v.yz + v.s * yz),
    )

  infix def dot(v: Translator): Motor =
    Motor(
      s = s,
      wx = s * v.wx,
      wy = s * v.wy,
      wz = s * v.wz,
      xy = xy,
      xz = xz,
      yz = yz,
      i = 0.0,
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
      w = (-v.wxy * xy - v.wxz * xz - v.wyz * yz),
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

  infix def dot(v: PlaneIdeal): PlaneIdeal =
    PlaneIdeal(
      x = (s * v.x + v.y * xy + v.z * xz),
      y = (s * v.y + v.z * yz - v.x * xy),
      z = (s * v.z - v.x * xz - v.y * yz),
    )

  infix def dot(v: BivectorBulk): Quaternion =
    Quaternion(
      s = (-v.xy * xy - v.xz * xz - v.yz * yz),
      xy = s * v.xy,
      xz = s * v.xz,
      yz = s * v.yz,
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
      w = 0.0,
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
      wx = s * v.wx,
      wy = s * v.wy,
      wz = s * v.wz,
      xy = (s * v.xy + v.s * xy),
      xz = (s * v.xz + v.s * xz),
      yz = (s * v.yz + v.s * yz),
      wxy = (s * v.wxy + v.w * xy),
      wxz = (s * v.wxz + v.w * xz),
      wyz = (s * v.wyz + v.w * yz),
      xyz = (s * v.xyz + v.x * yz + v.z * xy - v.y * xz),
      i = (s * v.i + v.wx * yz + v.wz * xy - v.wy * xz),
    )

  inline infix def ^(v: Multivector): Multivector = wedge(v)

  infix def wedge(v: Motor): Motor =
    Motor(
      s = s * v.s,
      wx = s * v.wx,
      wy = s * v.wy,
      wz = s * v.wz,
      xy = (s * v.xy + v.s * xy),
      xz = (s * v.xz + v.s * xz),
      yz = (s * v.yz + v.s * yz),
      i = (s * v.i + v.wx * yz + v.wz * xy - v.wy * xz),
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
      wxy = v.w * xy,
      wxz = v.w * xz,
      wyz = v.w * yz,
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
      i = (v.wx * yz + v.wz * xy - v.wy * xz),
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

  infix def wedge(v: Quaternion): Quaternion =
    Quaternion(
      s = s * v.s,
      xy = (s * v.xy + v.s * xy),
      xz = (s * v.xz + v.s * xz),
      yz = (s * v.yz + v.s * yz),
    )

  inline infix def ^(v: Quaternion): Quaternion = wedge(v)

  infix def wedge(v: Translator): Motor =
    Motor(
      s = s,
      wx = s * v.wx,
      wy = s * v.wy,
      wz = s * v.wz,
      xy = xy,
      xz = xz,
      yz = yz,
      i = (v.wx * yz + v.wz * xy - v.wy * xz),
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
      wxy = 0.0,
      wxz = 0.0,
      wyz = 0.0,
      xyz = (v.x * yz + v.z * xy - v.y * xz),
      i = 0.0,
    )

  inline infix def ^(v: PlaneIdeal): Multivector = wedge(v)

  infix def wedge(v: BivectorBulk): BivectorBulk =
    BivectorBulk(
      xy = s * v.xy,
      xz = s * v.xz,
      yz = s * v.yz,
    )

  inline infix def ^(v: BivectorBulk): BivectorBulk = wedge(v)

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
      s = (s * v.i + v.wx * yz + v.wz * xy - v.wy * xz),
      w = 0.0,
      x = (s * v.wyz + v.wxz * xy - v.w * yz - v.wxy * xz),
      y = (v.w * xz + v.wyz * xy - s * v.wxz - v.wxy * yz),
      z = (s * v.wxy + v.wyz * xz - v.w * xy - v.wxz * yz),
      wx = 0.0,
      wy = 0.0,
      wz = 0.0,
      xy = (v.i * xy - s * v.wz - v.wx * xz - v.wy * yz),
      xz = (s * v.wy + v.i * xz + v.wx * xy - v.wz * yz),
      yz = (v.i * yz + v.wy * xy + v.wz * xz - s * v.wx),
      wxy = 0.0,
      wxz = 0.0,
      wyz = 0.0,
      xyz = (-s * v.w - v.wxy * xy - v.wxz * xz - v.wyz * yz),
      i = 0.0,
    )

  infix def antiGeometric(v: Motor): Quaternion =
    Quaternion(
      s = (s * v.i + v.wx * yz + v.wz * xy - v.wy * xz),
      xy = (v.i * xy - s * v.wz - v.wx * xz - v.wy * yz),
      xz = (s * v.wy + v.i * xz + v.wx * xy - v.wz * yz),
      yz = (v.i * yz + v.wy * xy + v.wz * xz - s * v.wx),
    )

  infix def antiGeometric(v: Plane): Multivector =
    Multivector(
      s = 0.0,
      w = 0.0,
      x = -v.w * yz,
      y = v.w * xz,
      z = -v.w * xy,
      wx = 0.0,
      wy = 0.0,
      wz = 0.0,
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
      wxy = 0.0,
      wxz = 0.0,
      wyz = 0.0,
      xyz = -s * v.w,
      i = 0.0,
    )

  infix def antiGeometric(v: Bivector): Quaternion =
    Quaternion(
      s = (v.wx * yz + v.wz * xy - v.wy * xz),
      xy = (-s * v.wz - v.wx * xz - v.wy * yz),
      xz = (s * v.wy + v.wx * xy - v.wz * yz),
      yz = (v.wy * xy + v.wz * xz - s * v.wx),
    )

  infix def antiGeometric(v: Point): Multivector =
    Multivector(
      s = 0.0,
      w = 0.0,
      x = (s * v.wyz + v.wxz * xy - v.wxy * xz),
      y = (v.wyz * xy - s * v.wxz - v.wxy * yz),
      z = (s * v.wxy + v.wyz * xz - v.wxz * yz),
      wx = 0.0,
      wy = 0.0,
      wz = 0.0,
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
      wxy = 0.0,
      wxz = 0.0,
      wyz = 0.0,
      xyz = (-v.wxy * xy - v.wxz * xz - v.wyz * yz),
      i = 0.0,
    )

  infix def antiGeometric(v: Translator): Quaternion =
    Quaternion(
      s = (v.wx * yz + v.wz * xy - v.wy * xz),
      xy = (-s * v.wz - v.wx * xz - v.wy * yz),
      xz = (s * v.wy + v.wx * xy - v.wz * yz),
      yz = (v.wy * xy + v.wz * xz - s * v.wx),
    )

  infix def antiGeometric(v: Vector): Multivector =
    Multivector(
      s = 0.0,
      w = 0.0,
      x = (s * v.wyz + v.wxz * xy - v.wxy * xz),
      y = (v.wyz * xy - s * v.wxz - v.wxy * yz),
      z = (s * v.wxy + v.wyz * xz - v.wxz * yz),
      wx = 0.0,
      wy = 0.0,
      wz = 0.0,
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
      wxy = 0.0,
      wxz = 0.0,
      wyz = 0.0,
      xyz = (-v.wxy * xy - v.wxz * xz - v.wyz * yz),
      i = 0.0,
    )

  infix def antiGeometric(v: PointNormalized): Multivector =
    Multivector(
      s = 0.0,
      w = 0.0,
      x = (s * v.wyz + v.wxz * xy - v.wxy * xz),
      y = (v.wyz * xy - s * v.wxz - v.wxy * yz),
      z = (s * v.wxy + v.wyz * xz - v.wxz * yz),
      wx = 0.0,
      wy = 0.0,
      wz = 0.0,
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
      wxy = 0.0,
      wxz = 0.0,
      wyz = 0.0,
      xyz = (-v.wxy * xy - v.wxz * xz - v.wyz * yz),
      i = 0.0,
    )

  infix def antiGeometric(v: BivectorWeight): Quaternion =
    Quaternion(
      s = (v.wx * yz + v.wz * xy - v.wy * xz),
      xy = (-s * v.wz - v.wx * xz - v.wy * yz),
      xz = (s * v.wy + v.wx * xy - v.wz * yz),
      yz = (v.wy * xy + v.wz * xz - s * v.wx),
    )

  infix def antiGeometric(v: PseudoScalar): Quaternion =
    Quaternion(
      s = s * v.i,
      xy = v.i * xy,
      xz = v.i * xz,
      yz = v.i * yz,
    )

  infix def antiDot(v: Multivector): Multivector =
    Multivector(
      s = s * v.i,
      w = 0.0,
      x = s * v.wyz,
      y = -s * v.wxz,
      z = s * v.wxy,
      wx = 0.0,
      wy = 0.0,
      wz = 0.0,
      xy = (v.i * xy - s * v.wz),
      xz = (s * v.wy + v.i * xz),
      yz = (v.i * yz - s * v.wx),
      wxy = 0.0,
      wxz = 0.0,
      wyz = 0.0,
      xyz = (-s * v.w - v.wxy * xy - v.wxz * xz - v.wyz * yz),
      i = 0.0,
    )

  infix def antiDot(v: Motor): Quaternion =
    Quaternion(
      s = s * v.i,
      xy = (v.i * xy - s * v.wz),
      xz = (s * v.wy + v.i * xz),
      yz = (v.i * yz - s * v.wx),
    )

  infix def antiDot(v: Plane): Point =
    Point(
      wxy = 0.0,
      wxz = 0.0,
      wyz = 0.0,
      xyz = -s * v.w,
    )

  infix def antiDot(v: Bivector): BivectorBulk =
    BivectorBulk(
      xy = -s * v.wz,
      xz = s * v.wy,
      yz = -s * v.wx,
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
      wxy = 0.0,
      wxz = 0.0,
      wyz = 0.0,
      xyz = (-v.wxy * xy - v.wxz * xz - v.wyz * yz),
      i = 0.0,
    )

  infix def antiDot(v: Translator): BivectorBulk =
    BivectorBulk(
      xy = -s * v.wz,
      xz = s * v.wy,
      yz = -s * v.wx,
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
      wxy = 0.0,
      wxz = 0.0,
      wyz = 0.0,
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
      wxy = 0.0,
      wxz = 0.0,
      wyz = 0.0,
      xyz = (-v.wxy * xy - v.wxz * xz - v.wyz * yz),
      i = 0.0,
    )

  infix def antiDot(v: BivectorWeight): BivectorBulk =
    BivectorBulk(
      xy = -s * v.wz,
      xz = s * v.wy,
      yz = -s * v.wx,
    )

  infix def antiDot(v: PseudoScalar): Quaternion =
    Quaternion(
      s = s * v.i,
      xy = v.i * xy,
      xz = v.i * xz,
      yz = v.i * yz,
    )

  infix def antiWedge(v: Multivector): Multivector =
    Multivector(
      s = (s * v.i + v.wx * yz + v.wz * xy - v.wy * xz),
      w = 0.0,
      x = (v.wxz * xy - v.wxy * xz),
      y = (v.wyz * xy - v.wxy * yz),
      z = (v.wyz * xz - v.wxz * yz),
      wx = 0.0,
      wy = 0.0,
      wz = 0.0,
      xy = v.i * xy,
      xz = v.i * xz,
      yz = v.i * yz,
      wxy = 0.0,
      wxz = 0.0,
      wyz = 0.0,
      xyz = 0.0,
      i = 0.0,
    )

  inline infix def v(v: Multivector): Multivector = antiWedge(v)

  infix def antiWedge(v: Motor): Quaternion =
    Quaternion(
      s = (s * v.i + v.wx * yz + v.wz * xy - v.wy * xz),
      xy = v.i * xy,
      xz = v.i * xz,
      yz = v.i * yz,
    )

  inline infix def v(v: Motor): Quaternion = antiWedge(v)

  infix def antiWedge(v: Bivector): Double =
    (v.wx * yz + v.wz * xy - v.wy * xz)

  inline infix def v(v: Bivector): Double = antiWedge(v)

  infix def antiWedge(v: Point): PlaneIdeal =
    PlaneIdeal(
      x = (v.wxz * xy - v.wxy * xz),
      y = (v.wyz * xy - v.wxy * yz),
      z = (v.wyz * xz - v.wxz * yz),
    )

  inline infix def v(v: Point): PlaneIdeal = antiWedge(v)

  infix def antiWedge(v: Translator): Double =
    (v.wx * yz + v.wz * xy - v.wy * xz)

  inline infix def v(v: Translator): Double = antiWedge(v)

  infix def antiWedge(v: Vector): PlaneIdeal =
    PlaneIdeal(
      x = (v.wxz * xy - v.wxy * xz),
      y = (v.wyz * xy - v.wxy * yz),
      z = (v.wyz * xz - v.wxz * yz),
    )

  inline infix def v(v: Vector): PlaneIdeal = antiWedge(v)

  infix def antiWedge(v: PointNormalized): PlaneIdeal =
    PlaneIdeal(
      x = (v.wxz * xy - v.wxy * xz),
      y = (v.wyz * xy - v.wxy * yz),
      z = (v.wyz * xz - v.wxz * yz),
    )

  inline infix def v(v: PointNormalized): PlaneIdeal = antiWedge(v)

  infix def antiWedge(v: BivectorWeight): Double =
    (v.wx * yz + v.wz * xy - v.wy * xz)

  inline infix def v(v: BivectorWeight): Double = antiWedge(v)

  infix def antiWedge(v: PseudoScalar): Quaternion =
    Quaternion(
      s = s * v.i,
      xy = v.i * xy,
      xz = v.i * xz,
      yz = v.i * yz,
    )

  inline infix def v(v: PseudoScalar): Quaternion = antiWedge(v)

  infix def sandwich(v: Multivector): Multivector =
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
    Multivector(
      s = v.s * (sMs + xyMxy + xzMxz + yzMyz),
      w = v.w * (sMs + xyMxy + xzMxz + yzMyz),
      x = (2.0 * (v.y * (sMxy - xzMyz) + v.z * (sMxz + xyMyz)) + v.x * (sMs + yzMyz - xyMxy - xzMxz)),
      y = (2.0 * (v.x * (-sMxy - xzMyz) + v.z * (sMyz - xyMxz)) + v.y * (sMs + xzMxz - xyMxy - yzMyz)),
      z = (2.0 * (v.x * (xyMyz - sMxz) + v.y * (-sMyz - xyMxz)) + v.z * (sMs + xyMxy - xzMxz - yzMyz)),
      wx = (2.0 * (v.wy * (sMxy - xzMyz) + v.wz * (sMxz + xyMyz)) + v.wx * (sMs + yzMyz - xyMxy - xzMxz)),
      wy = (2.0 * (v.wx * (-sMxy - xzMyz) + v.wz * (sMyz - xyMxz)) + v.wy * (sMs + xzMxz - xyMxy - yzMyz)),
      wz = (2.0 * (v.wx * (xyMyz - sMxz) + v.wy * (-sMyz - xyMxz)) + v.wz * (sMs + xyMxy - xzMxz - yzMyz)),
      xy = (2.0 * (v.xz * (sMyz + xyMxz) + v.yz * (xyMyz - sMxz)) + v.xy * (sMs + xyMxy - xzMxz - yzMyz)),
      xz = (2.0 * (v.xy * (xyMxz - sMyz) + v.yz * (sMxy + xzMyz)) + v.xz * (sMs + xzMxz - xyMxy - yzMyz)),
      yz = (2.0 * (v.xy * (sMxz + xyMyz) + v.xz * (xzMyz - sMxy)) + v.yz * (sMs + yzMyz - xyMxy - xzMxz)),
      wxy = (2.0 * (v.wxz * (sMyz + xyMxz) + v.wyz * (xyMyz - sMxz)) + v.wxy * (sMs + xyMxy - xzMxz - yzMyz)),
      wxz = (2.0 * (v.wxy * (xyMxz - sMyz) + v.wyz * (sMxy + xzMyz)) + v.wxz * (sMs + xzMxz - xyMxy - yzMyz)),
      wyz = (2.0 * (v.wxy * (sMxz + xyMyz) + v.wxz * (xzMyz - sMxy)) + v.wyz * (sMs + yzMyz - xyMxy - xzMxz)),
      xyz = v.xyz * (sMs + xyMxy + xzMxz + yzMyz),
      i = v.i * (sMs + xyMxy + xzMxz + yzMyz),
    )

  infix def sandwich(v: Motor): Motor =
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
      s = v.s * (sMs + xyMxy + xzMxz + yzMyz),
      wx = (2.0 * (v.wy * (sMxy - xzMyz) + v.wz * (sMxz + xyMyz)) + v.wx * (sMs + yzMyz - xyMxy - xzMxz)),
      wy = (2.0 * (v.wx * (-sMxy - xzMyz) + v.wz * (sMyz - xyMxz)) + v.wy * (sMs + xzMxz - xyMxy - yzMyz)),
      wz = (2.0 * (v.wx * (xyMyz - sMxz) + v.wy * (-sMyz - xyMxz)) + v.wz * (sMs + xyMxy - xzMxz - yzMyz)),
      xy = (2.0 * (v.xz * (sMyz + xyMxz) + v.yz * (xyMyz - sMxz)) + v.xy * (sMs + xyMxy - xzMxz - yzMyz)),
      xz = (2.0 * (v.xy * (xyMxz - sMyz) + v.yz * (sMxy + xzMyz)) + v.xz * (sMs + xzMxz - xyMxy - yzMyz)),
      yz = (2.0 * (v.xy * (sMxz + xyMyz) + v.xz * (xzMyz - sMxy)) + v.yz * (sMs + yzMyz - xyMxy - xzMxz)),
      i = v.i * (sMs + xyMxy + xzMxz + yzMyz),
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
      w = v.w * (sMs + xyMxy + xzMxz + yzMyz),
      x = (2.0 * (v.y * (sMxy - xzMyz) + v.z * (sMxz + xyMyz)) + v.x * (sMs + yzMyz - xyMxy - xzMxz)),
      y = (2.0 * (v.x * (-sMxy - xzMyz) + v.z * (sMyz - xyMxz)) + v.y * (sMs + xzMxz - xyMxy - yzMyz)),
      z = (2.0 * (v.x * (xyMyz - sMxz) + v.y * (-sMyz - xyMxz)) + v.z * (sMs + xyMxy - xzMxz - yzMyz)),
    )

  infix def sandwich(v: Bivector): Bivector =
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
    Bivector(
      wx = (2.0 * (v.wy * (sMxy - xzMyz) + v.wz * (sMxz + xyMyz)) + v.wx * (sMs + yzMyz - xyMxy - xzMxz)),
      wy = (2.0 * (v.wx * (-sMxy - xzMyz) + v.wz * (sMyz - xyMxz)) + v.wy * (sMs + xzMxz - xyMxy - yzMyz)),
      wz = (2.0 * (v.wx * (xyMyz - sMxz) + v.wy * (-sMyz - xyMxz)) + v.wz * (sMs + xyMxy - xzMxz - yzMyz)),
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
      wxy = (2.0 * (v.wxz * (sMyz + xyMxz) + v.wyz * (xyMyz - sMxz)) + v.wxy * (sMs + xyMxy - xzMxz - yzMyz)),
      wxz = (2.0 * (v.wxy * (xyMxz - sMyz) + v.wyz * (sMxy + xzMyz)) + v.wxz * (sMs + xzMxz - xyMxy - yzMyz)),
      wyz = (2.0 * (v.wxy * (sMxz + xyMyz) + v.wxz * (xzMyz - sMxy)) + v.wyz * (sMs + yzMyz - xyMxy - xzMxz)),
      xyz = v.xyz * (sMs + xyMxy + xzMxz + yzMyz),
    )

  infix def sandwich(v: Quaternion): Quaternion =
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
    Quaternion(
      s = v.s * (sMs + xyMxy + xzMxz + yzMyz),
      xy = (2.0 * (v.xz * (sMyz + xyMxz) + v.yz * (xyMyz - sMxz)) + v.xy * (sMs + xyMxy - xzMxz - yzMyz)),
      xz = (2.0 * (v.xy * (xyMxz - sMyz) + v.yz * (sMxy + xzMyz)) + v.xz * (sMs + xzMxz - xyMxy - yzMyz)),
      yz = (2.0 * (v.xy * (sMxz + xyMyz) + v.xz * (xzMyz - sMxy)) + v.yz * (sMs + yzMyz - xyMxy - xzMxz)),
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
      i = 0.0,
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
      wxy = (2.0 * (v.wxz * (sMyz + xyMxz) + v.wyz * (xyMyz - sMxz)) + v.wxy * (sMs + xyMxy - xzMxz - yzMyz)),
      wxz = (2.0 * (v.wxy * (xyMxz - sMyz) + v.wyz * (sMxy + xzMyz)) + v.wxz * (sMs + xzMxz - xyMxy - yzMyz)),
      wyz = (2.0 * (v.wxy * (sMxz + xyMyz) + v.wxz * (xzMyz - sMxy)) + v.wyz * (sMs + yzMyz - xyMxy - xzMxz)),
      xyz = (sMs + xyMxy + xzMxz + yzMyz),
    )

  infix def sandwich(v: PlaneIdeal): PlaneIdeal =
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
    PlaneIdeal(
      x = (2.0 * (v.y * (sMxy - xzMyz) + v.z * (sMxz + xyMyz)) + v.x * (sMs + yzMyz - xyMxy - xzMxz)),
      y = (2.0 * (v.x * (-sMxy - xzMyz) + v.z * (sMyz - xyMxz)) + v.y * (sMs + xzMxz - xyMxy - yzMyz)),
      z = (2.0 * (v.x * (xyMyz - sMxz) + v.y * (-sMyz - xyMxz)) + v.z * (sMs + xyMxy - xzMxz - yzMyz)),
    )

  infix def sandwich(v: BivectorBulk): BivectorBulk =
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
    BivectorBulk(
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
      wxy = 0.0,
      wxz = 0.0,
      wyz = 0.0,
      xyz = (s * s + xy * xy + xz * xz + yz * yz),
    )

  infix def reverseSandwich(v: Multivector): Multivector =
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
    Multivector(
      s = v.s * (sMs + xyMxy + xzMxz + yzMyz),
      w = v.w * (sMs + xyMxy + xzMxz + yzMyz),
      x = (2.0 * (v.y * (-sMxy - xzMyz) + v.z * (xyMyz - sMxz)) + v.x * (sMs + yzMyz - xyMxy - xzMxz)),
      y = (2.0 * (v.x * (sMxy - xzMyz) + v.z * (-sMyz - xyMxz)) + v.y * (sMs + xzMxz - xyMxy - yzMyz)),
      z = (2.0 * (v.x * (sMxz + xyMyz) + v.y * (sMyz - xyMxz)) + v.z * (sMs + xyMxy - xzMxz - yzMyz)),
      wx = (2.0 * (v.wy * (-sMxy - xzMyz) + v.wz * (xyMyz - sMxz)) + v.wx * (sMs + yzMyz - xyMxy - xzMxz)),
      wy = (2.0 * (v.wx * (sMxy - xzMyz) + v.wz * (-sMyz - xyMxz)) + v.wy * (sMs + xzMxz - xyMxy - yzMyz)),
      wz = (2.0 * (v.wx * (sMxz + xyMyz) + v.wy * (sMyz - xyMxz)) + v.wz * (sMs + xyMxy - xzMxz - yzMyz)),
      xy = (2.0 * (v.xz * (xyMxz - sMyz) + v.yz * (sMxz + xyMyz)) + v.xy * (sMs + xyMxy - xzMxz - yzMyz)),
      xz = (2.0 * (v.xy * (sMyz + xyMxz) + v.yz * (xzMyz - sMxy)) + v.xz * (sMs + xzMxz - xyMxy - yzMyz)),
      yz = (2.0 * (v.xy * (xyMyz - sMxz) + v.xz * (sMxy + xzMyz)) + v.yz * (sMs + yzMyz - xyMxy - xzMxz)),
      wxy = (2.0 * (v.wxz * (xyMxz - sMyz) + v.wyz * (sMxz + xyMyz)) + v.wxy * (sMs + xyMxy - xzMxz - yzMyz)),
      wxz = (2.0 * (v.wxy * (sMyz + xyMxz) + v.wyz * (xzMyz - sMxy)) + v.wxz * (sMs + xzMxz - xyMxy - yzMyz)),
      wyz = (2.0 * (v.wxy * (xyMyz - sMxz) + v.wxz * (sMxy + xzMyz)) + v.wyz * (sMs + yzMyz - xyMxy - xzMxz)),
      xyz = v.xyz * (sMs + xyMxy + xzMxz + yzMyz),
      i = v.i * (sMs + xyMxy + xzMxz + yzMyz),
    )

  infix def reverseSandwich(v: Motor): Motor =
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
      s = v.s * (sMs + xyMxy + xzMxz + yzMyz),
      wx = (2.0 * (v.wy * (-sMxy - xzMyz) + v.wz * (xyMyz - sMxz)) + v.wx * (sMs + yzMyz - xyMxy - xzMxz)),
      wy = (2.0 * (v.wx * (sMxy - xzMyz) + v.wz * (-sMyz - xyMxz)) + v.wy * (sMs + xzMxz - xyMxy - yzMyz)),
      wz = (2.0 * (v.wx * (sMxz + xyMyz) + v.wy * (sMyz - xyMxz)) + v.wz * (sMs + xyMxy - xzMxz - yzMyz)),
      xy = (2.0 * (v.xz * (xyMxz - sMyz) + v.yz * (sMxz + xyMyz)) + v.xy * (sMs + xyMxy - xzMxz - yzMyz)),
      xz = (2.0 * (v.xy * (sMyz + xyMxz) + v.yz * (xzMyz - sMxy)) + v.xz * (sMs + xzMxz - xyMxy - yzMyz)),
      yz = (2.0 * (v.xy * (xyMyz - sMxz) + v.xz * (sMxy + xzMyz)) + v.yz * (sMs + yzMyz - xyMxy - xzMxz)),
      i = v.i * (sMs + xyMxy + xzMxz + yzMyz),
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
      w = v.w * (sMs + xyMxy + xzMxz + yzMyz),
      x = (2.0 * (v.y * (-sMxy - xzMyz) + v.z * (xyMyz - sMxz)) + v.x * (sMs + yzMyz - xyMxy - xzMxz)),
      y = (2.0 * (v.x * (sMxy - xzMyz) + v.z * (-sMyz - xyMxz)) + v.y * (sMs + xzMxz - xyMxy - yzMyz)),
      z = (2.0 * (v.x * (sMxz + xyMyz) + v.y * (sMyz - xyMxz)) + v.z * (sMs + xyMxy - xzMxz - yzMyz)),
    )

  infix def reverseSandwich(v: Bivector): Bivector =
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
    Bivector(
      wx = (2.0 * (v.wy * (-sMxy - xzMyz) + v.wz * (xyMyz - sMxz)) + v.wx * (sMs + yzMyz - xyMxy - xzMxz)),
      wy = (2.0 * (v.wx * (sMxy - xzMyz) + v.wz * (-sMyz - xyMxz)) + v.wy * (sMs + xzMxz - xyMxy - yzMyz)),
      wz = (2.0 * (v.wx * (sMxz + xyMyz) + v.wy * (sMyz - xyMxz)) + v.wz * (sMs + xyMxy - xzMxz - yzMyz)),
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
      wxy = (2.0 * (v.wxz * (xyMxz - sMyz) + v.wyz * (sMxz + xyMyz)) + v.wxy * (sMs + xyMxy - xzMxz - yzMyz)),
      wxz = (2.0 * (v.wxy * (sMyz + xyMxz) + v.wyz * (xzMyz - sMxy)) + v.wxz * (sMs + xzMxz - xyMxy - yzMyz)),
      wyz = (2.0 * (v.wxy * (xyMyz - sMxz) + v.wxz * (sMxy + xzMyz)) + v.wyz * (sMs + yzMyz - xyMxy - xzMxz)),
      xyz = v.xyz * (sMs + xyMxy + xzMxz + yzMyz),
    )

  infix def reverseSandwich(v: Quaternion): Quaternion =
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
    Quaternion(
      s = v.s * (sMs + xyMxy + xzMxz + yzMyz),
      xy = (2.0 * (v.xz * (xyMxz - sMyz) + v.yz * (sMxz + xyMyz)) + v.xy * (sMs + xyMxy - xzMxz - yzMyz)),
      xz = (2.0 * (v.xy * (sMyz + xyMxz) + v.yz * (xzMyz - sMxy)) + v.xz * (sMs + xzMxz - xyMxy - yzMyz)),
      yz = (2.0 * (v.xy * (xyMyz - sMxz) + v.xz * (sMxy + xzMyz)) + v.yz * (sMs + yzMyz - xyMxy - xzMxz)),
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
      i = 0.0,
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
      wxy = (2.0 * (v.wxz * (xyMxz - sMyz) + v.wyz * (sMxz + xyMyz)) + v.wxy * (sMs + xyMxy - xzMxz - yzMyz)),
      wxz = (2.0 * (v.wxy * (sMyz + xyMxz) + v.wyz * (xzMyz - sMxy)) + v.wxz * (sMs + xzMxz - xyMxy - yzMyz)),
      wyz = (2.0 * (v.wxy * (xyMyz - sMxz) + v.wxz * (sMxy + xzMyz)) + v.wyz * (sMs + yzMyz - xyMxy - xzMxz)),
      xyz = (sMs + xyMxy + xzMxz + yzMyz),
    )

  infix def reverseSandwich(v: PlaneIdeal): PlaneIdeal =
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
    PlaneIdeal(
      x = (2.0 * (v.y * (-sMxy - xzMyz) + v.z * (xyMyz - sMxz)) + v.x * (sMs + yzMyz - xyMxy - xzMxz)),
      y = (2.0 * (v.x * (sMxy - xzMyz) + v.z * (-sMyz - xyMxz)) + v.y * (sMs + xzMxz - xyMxy - yzMyz)),
      z = (2.0 * (v.x * (sMxz + xyMyz) + v.y * (sMyz - xyMxz)) + v.z * (sMs + xyMxy - xzMxz - yzMyz)),
    )

  infix def reverseSandwich(v: BivectorBulk): BivectorBulk =
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
    BivectorBulk(
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
      wxy = 0.0,
      wxz = 0.0,
      wyz = 0.0,
      xyz = (s * s + xy * xy + xz * xz + yz * yz),
    )

  infix def cross(v: Multivector): Multivector =
    Multivector(
      s = 0.0,
      w = 0.0,
      x = (v.y * xy + v.z * xz),
      y = (v.z * yz - v.x * xy),
      z = (-v.x * xz - v.y * yz),
      wx = (v.wy * xy + v.wz * xz),
      wy = (v.wz * yz - v.wx * xy),
      wz = (-v.wx * xz - v.wy * yz),
      xy = (v.xz * yz - v.yz * xz),
      xz = (v.yz * xy - v.xy * yz),
      yz = (v.xy * xz - v.xz * xy),
      wxy = (v.wxz * yz - v.wyz * xz),
      wxz = (v.wyz * xy - v.wxy * yz),
      wyz = (v.wxy * xz - v.wxz * xy),
      xyz = 0.0,
      i = 0.0,
    )

  infix def cross(v: Motor): Bivector =
    Bivector(
      wx = (v.wy * xy + v.wz * xz),
      wy = (v.wz * yz - v.wx * xy),
      wz = (-v.wx * xz - v.wy * yz),
      xy = (v.xz * yz - v.yz * xz),
      xz = (v.yz * xy - v.xy * yz),
      yz = (v.xy * xz - v.xz * xy),
    )

  infix def cross(v: Plane): PlaneIdeal =
    PlaneIdeal(
      x = (v.y * xy + v.z * xz),
      y = (v.z * yz - v.x * xy),
      z = (-v.x * xz - v.y * yz),
    )

  infix def cross(v: Bivector): Bivector =
    Bivector(
      wx = (v.wy * xy + v.wz * xz),
      wy = (v.wz * yz - v.wx * xy),
      wz = (-v.wx * xz - v.wy * yz),
      xy = (v.xz * yz - v.yz * xz),
      xz = (v.yz * xy - v.xy * yz),
      yz = (v.xy * xz - v.xz * xy),
    )

  infix def cross(v: Point): Vector =
    Vector(
      wxy = (v.wxz * yz - v.wyz * xz),
      wxz = (v.wyz * xy - v.wxy * yz),
      wyz = (v.wxy * xz - v.wxz * xy),
    )

  infix def cross(v: Quaternion): BivectorBulk =
    BivectorBulk(
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

  infix def cross(v: PointNormalized): Vector =
    Vector(
      wxy = (v.wxz * yz - v.wyz * xz),
      wxz = (v.wyz * xy - v.wxy * yz),
      wyz = (v.wxy * xz - v.wxz * xy),
    )

  infix def cross(v: PlaneIdeal): PlaneIdeal =
    PlaneIdeal(
      x = (v.y * xy + v.z * xz),
      y = (v.z * yz - v.x * xy),
      z = (-v.x * xz - v.y * yz),
    )

  infix def cross(v: BivectorBulk): BivectorBulk =
    BivectorBulk(
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