package com.github.kright.pga3d

/** this code is generated, see com.github.kright.pga3d.codegen.CodeGenClass */
case class Pga3dPlane(w: Double = 0.0,
                      x: Double = 0.0,
                      y: Double = 0.0,
                      z: Double = 0.0):

  def dual: Pga3dPoint =
    Pga3dPoint(
      wxy = -z,
      wxz = y,
      wyz = -x,
      xyz = w,
    )

  def weight: Pga3dPlane =
    Pga3dPlane(
      w = w,
      x = 0.0,
      y = 0.0,
      z = 0.0,
    )

  def bulk: Pga3dPlaneIdeal =
    Pga3dPlaneIdeal(
      x = x,
      y = y,
      z = z,
    )

  def unary_- : Pga3dPlane =
    Pga3dPlane(
      w = -w,
      x = -x,
      y = -y,
      z = -z,
    )

  def reverse: Pga3dPlane =
    this

  def antiReverse: Pga3dPlane =
    -this

  def bulkNormSquare: Double =
    (x * x + y * y + z * z)

  def bulkNorm: Double =
    Math.sqrt(bulkNormSquare)

  def normalizedByBulk =
    this / bulkNorm

  def weightNormSquare: Double =
    w * w

  def weightNorm: Double =
    Math.sqrt(weightNormSquare)

  def normalizedByWeight =
    this / weightNorm

  def normSquare: Double =
    (w * w + x * x + y * y + z * z)

  def norm: Double =
    Math.sqrt(normSquare)

  def normalizedByNorm =
    this / norm

  def *(v: Double): Pga3dPlane =
    Pga3dPlane(
      w = v * w,
      x = v * x,
      y = v * y,
      z = v * z,
    )

  inline def /(v: Double): Pga3dPlane =
    this * (1.0 / v)

  def +(v: Pga3dPlane): Pga3dPlane =
    Pga3dPlane(
      w = (v.w + w),
      x = (v.x + x),
      y = (v.y + y),
      z = (v.z + z),
    )

  def -(v: Pga3dPlane): Pga3dPlane =
    Pga3dPlane(
      w = (w - v.w),
      x = (x - v.x),
      y = (y - v.y),
      z = (z - v.z),
    )

  def madd(v: Pga3dPlane, mult: Double): Pga3dPlane =
    Pga3dPlane(
      w = (w + mult * v.w),
      x = (x + mult * v.x),
      y = (y + mult * v.y),
      z = (z + mult * v.z),
    )

  def multiplyElementwise(v: Pga3dPlane): Pga3dPlane =
    Pga3dPlane(
      w = v.w * w,
      x = v.x * x,
      y = v.y * y,
      z = v.z * z,
    )

  def toMultivector: Pga3dMultivector =
    Pga3dMultivector(
      s = 0.0,
      w = w,
      x = x,
      y = y,
      z = z,
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
      i = 0.0,
    )

  def asPlaneIdealUnsafe: Pga3dPlaneIdeal =
    Pga3dPlaneIdeal(
      x = x,
      y = y,
      z = z,
    )

  infix def geometric(v: Pga3dMultivector): Pga3dMultivector =
    Pga3dMultivector(
      s = (v.x * x + v.y * y + v.z * z),
      w = (v.s * w - v.wx * x - v.wy * y - v.wz * z),
      x = (v.s * x - v.xy * y - v.xz * z),
      y = (v.s * y + v.xy * x - v.yz * z),
      z = (v.s * z + v.xz * x + v.yz * y),
      wx = (v.wxy * y + v.wxz * z + v.x * w - v.w * x),
      wy = (v.wyz * z + v.y * w - v.w * y - v.wxy * x),
      wz = (v.z * w - v.w * z - v.wxz * x - v.wyz * y),
      xy = (v.xyz * z + v.y * x - v.x * y),
      xz = (v.z * x - v.x * z - v.xyz * y),
      yz = (v.xyz * x + v.z * y - v.y * z),
      wxy = (v.wx * y + v.xy * w - v.i * z - v.wy * x),
      wxz = (v.i * y + v.wx * z + v.xz * w - v.wz * x),
      wyz = (v.wy * z + v.yz * w - v.i * x - v.wz * y),
      xyz = (v.xy * z + v.yz * x - v.xz * y),
      i = (v.wxz * y + v.xyz * w - v.wxy * z - v.wyz * x),
    )

  infix def geometric(v: Pga3dMotor): Pga3dMultivector =
    Pga3dMultivector(
      s = 0.0,
      w = (v.s * w - v.wx * x - v.wy * y - v.wz * z),
      x = (v.s * x - v.xy * y - v.xz * z),
      y = (v.s * y + v.xy * x - v.yz * z),
      z = (v.s * z + v.xz * x + v.yz * y),
      wx = 0.0,
      wy = 0.0,
      wz = 0.0,
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
      wxy = (v.wx * y + v.xy * w - v.i * z - v.wy * x),
      wxz = (v.i * y + v.wx * z + v.xz * w - v.wz * x),
      wyz = (v.wy * z + v.yz * w - v.i * x - v.wz * y),
      xyz = (v.xy * z + v.yz * x - v.xz * y),
      i = 0.0,
    )

  infix def geometric(v: Pga3dPlane): Pga3dMotor =
    Pga3dMotor(
      s = (v.x * x + v.y * y + v.z * z),
      wx = (v.x * w - v.w * x),
      wy = (v.y * w - v.w * y),
      wz = (v.z * w - v.w * z),
      xy = (v.y * x - v.x * y),
      xz = (v.z * x - v.x * z),
      yz = (v.z * y - v.y * z),
      i = 0.0,
    )

  infix def geometric(v: Pga3dBivector): Pga3dMultivector =
    Pga3dMultivector(
      s = 0.0,
      w = (-v.wx * x - v.wy * y - v.wz * z),
      x = (-v.xy * y - v.xz * z),
      y = (v.xy * x - v.yz * z),
      z = (v.xz * x + v.yz * y),
      wx = 0.0,
      wy = 0.0,
      wz = 0.0,
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
      wxy = (v.wx * y + v.xy * w - v.wy * x),
      wxz = (v.wx * z + v.xz * w - v.wz * x),
      wyz = (v.wy * z + v.yz * w - v.wz * y),
      xyz = (v.xy * z + v.yz * x - v.xz * y),
      i = 0.0,
    )

  infix def geometric(v: Pga3dPoint): Pga3dMotor =
    Pga3dMotor(
      s = 0.0,
      wx = (v.wxy * y + v.wxz * z),
      wy = (v.wyz * z - v.wxy * x),
      wz = (-v.wxz * x - v.wyz * y),
      xy = v.xyz * z,
      xz = -v.xyz * y,
      yz = v.xyz * x,
      i = (v.wxz * y + v.xyz * w - v.wxy * z - v.wyz * x),
    )

  infix def geometric(v: Pga3dQuaternion): Pga3dMultivector =
    Pga3dMultivector(
      s = 0.0,
      w = v.s * w,
      x = (v.s * x - v.xy * y - v.xz * z),
      y = (v.s * y + v.xy * x - v.yz * z),
      z = (v.s * z + v.xz * x + v.yz * y),
      wx = 0.0,
      wy = 0.0,
      wz = 0.0,
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
      wxy = v.xy * w,
      wxz = v.xz * w,
      wyz = v.yz * w,
      xyz = (v.xy * z + v.yz * x - v.xz * y),
      i = 0.0,
    )

  infix def geometric(v: Pga3dTranslator): Pga3dMultivector =
    Pga3dMultivector(
      s = 0.0,
      w = (w - v.wx * x - v.wy * y - v.wz * z),
      x = x,
      y = y,
      z = z,
      wx = 0.0,
      wy = 0.0,
      wz = 0.0,
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
      wxy = (v.wx * y - v.wy * x),
      wxz = (v.wx * z - v.wz * x),
      wyz = (v.wy * z - v.wz * y),
      xyz = 0.0,
      i = 0.0,
    )

  infix def geometric(v: Pga3dVector): Pga3dMotor =
    Pga3dMotor(
      s = 0.0,
      wx = (v.wxy * y + v.wxz * z),
      wy = (v.wyz * z - v.wxy * x),
      wz = (-v.wxz * x - v.wyz * y),
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
      i = (v.wxz * y - v.wxy * z - v.wyz * x),
    )

  infix def geometric(v: Pga3dPointNormalized): Pga3dMotor =
    Pga3dMotor(
      s = 0.0,
      wx = (v.wxy * y + v.wxz * z),
      wy = (v.wyz * z - v.wxy * x),
      wz = (-v.wxz * x - v.wyz * y),
      xy = z,
      xz = -y,
      yz = x,
      i = (w + v.wxz * y - v.wxy * z - v.wyz * x),
    )

  infix def geometric(v: Pga3dPlaneIdeal): Pga3dMotor =
    Pga3dMotor(
      s = (v.x * x + v.y * y + v.z * z),
      wx = v.x * w,
      wy = v.y * w,
      wz = v.z * w,
      xy = (v.y * x - v.x * y),
      xz = (v.z * x - v.x * z),
      yz = (v.z * y - v.y * z),
      i = 0.0,
    )

  infix def geometric(v: Pga3dBivectorBulk): Pga3dMultivector =
    Pga3dMultivector(
      s = 0.0,
      w = 0.0,
      x = (-v.xy * y - v.xz * z),
      y = (v.xy * x - v.yz * z),
      z = (v.xz * x + v.yz * y),
      wx = 0.0,
      wy = 0.0,
      wz = 0.0,
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
      wxy = v.xy * w,
      wxz = v.xz * w,
      wyz = v.yz * w,
      xyz = (v.xy * z + v.yz * x - v.xz * y),
      i = 0.0,
    )

  infix def geometric(v: Pga3dBivectorWeight): Pga3dMultivector =
    Pga3dMultivector(
      s = 0.0,
      w = (-v.wx * x - v.wy * y - v.wz * z),
      x = 0.0,
      y = 0.0,
      z = 0.0,
      wx = 0.0,
      wy = 0.0,
      wz = 0.0,
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
      wxy = (v.wx * y - v.wy * x),
      wxz = (v.wx * z - v.wz * x),
      wyz = (v.wy * z - v.wz * y),
      xyz = 0.0,
      i = 0.0,
    )

  infix def geometric(v: Pga3dPseudoScalar): Pga3dVector =
    Pga3dVector(
      wxy = -v.i * z,
      wxz = v.i * y,
      wyz = -v.i * x,
    )

  infix def geometric(v: Pga3dPointCenter.type): Pga3dMotor =
    Pga3dMotor(
      s = 0.0,
      wx = 0.0,
      wy = 0.0,
      wz = 0.0,
      xy = z,
      xz = -y,
      yz = x,
      i = w,
    )

  infix def dot(v: Pga3dMultivector): Pga3dMultivector =
    Pga3dMultivector(
      s = (v.x * x + v.y * y + v.z * z),
      w = (v.s * w - v.wx * x - v.wy * y - v.wz * z),
      x = (v.s * x - v.xy * y - v.xz * z),
      y = (v.s * y + v.xy * x - v.yz * z),
      z = (v.s * z + v.xz * x + v.yz * y),
      wx = (v.wxy * y + v.wxz * z),
      wy = (v.wyz * z - v.wxy * x),
      wz = (-v.wxz * x - v.wyz * y),
      xy = v.xyz * z,
      xz = -v.xyz * y,
      yz = v.xyz * x,
      wxy = -v.i * z,
      wxz = v.i * y,
      wyz = -v.i * x,
      xyz = 0.0,
      i = 0.0,
    )

  infix def dot(v: Pga3dMotor): Pga3dMultivector =
    Pga3dMultivector(
      s = 0.0,
      w = (v.s * w - v.wx * x - v.wy * y - v.wz * z),
      x = (v.s * x - v.xy * y - v.xz * z),
      y = (v.s * y + v.xy * x - v.yz * z),
      z = (v.s * z + v.xz * x + v.yz * y),
      wx = 0.0,
      wy = 0.0,
      wz = 0.0,
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
      wxy = -v.i * z,
      wxz = v.i * y,
      wyz = -v.i * x,
      xyz = 0.0,
      i = 0.0,
    )

  infix def dot(v: Pga3dPlane): Double =
    (v.x * x + v.y * y + v.z * z)

  infix def dot(v: Pga3dBivector): Pga3dPlane =
    Pga3dPlane(
      w = (-v.wx * x - v.wy * y - v.wz * z),
      x = (-v.xy * y - v.xz * z),
      y = (v.xy * x - v.yz * z),
      z = (v.xz * x + v.yz * y),
    )

  infix def dot(v: Pga3dPoint): Pga3dBivector =
    Pga3dBivector(
      wx = (v.wxy * y + v.wxz * z),
      wy = (v.wyz * z - v.wxy * x),
      wz = (-v.wxz * x - v.wyz * y),
      xy = v.xyz * z,
      xz = -v.xyz * y,
      yz = v.xyz * x,
    )

  infix def dot(v: Pga3dQuaternion): Pga3dPlane =
    Pga3dPlane(
      w = v.s * w,
      x = (v.s * x - v.xy * y - v.xz * z),
      y = (v.s * y + v.xy * x - v.yz * z),
      z = (v.s * z + v.xz * x + v.yz * y),
    )

  infix def dot(v: Pga3dTranslator): Pga3dPlane =
    Pga3dPlane(
      w = (w - v.wx * x - v.wy * y - v.wz * z),
      x = x,
      y = y,
      z = z,
    )

  infix def dot(v: Pga3dVector): Pga3dBivectorWeight =
    Pga3dBivectorWeight(
      wx = (v.wxy * y + v.wxz * z),
      wy = (v.wyz * z - v.wxy * x),
      wz = (-v.wxz * x - v.wyz * y),
    )

  infix def dot(v: Pga3dPointNormalized): Pga3dBivector =
    Pga3dBivector(
      wx = (v.wxy * y + v.wxz * z),
      wy = (v.wyz * z - v.wxy * x),
      wz = (-v.wxz * x - v.wyz * y),
      xy = z,
      xz = -y,
      yz = x,
    )

  infix def dot(v: Pga3dPlaneIdeal): Double =
    (v.x * x + v.y * y + v.z * z)

  infix def dot(v: Pga3dBivectorBulk): Pga3dPlaneIdeal =
    Pga3dPlaneIdeal(
      x = (-v.xy * y - v.xz * z),
      y = (v.xy * x - v.yz * z),
      z = (v.xz * x + v.yz * y),
    )

  infix def dot(v: Pga3dBivectorWeight): Pga3dPlane =
    Pga3dPlane(
      w = (-v.wx * x - v.wy * y - v.wz * z),
      x = 0.0,
      y = 0.0,
      z = 0.0,
    )

  infix def dot(v: Pga3dPseudoScalar): Pga3dVector =
    Pga3dVector(
      wxy = -v.i * z,
      wxz = v.i * y,
      wyz = -v.i * x,
    )

  infix def dot(v: Pga3dPointCenter.type): Pga3dBivectorBulk =
    Pga3dBivectorBulk(
      xy = z,
      xz = -y,
      yz = x,
    )

  infix def wedge(v: Pga3dMultivector): Pga3dMultivector =
    Pga3dMultivector(
      s = 0.0,
      w = v.s * w,
      x = v.s * x,
      y = v.s * y,
      z = v.s * z,
      wx = (v.x * w - v.w * x),
      wy = (v.y * w - v.w * y),
      wz = (v.z * w - v.w * z),
      xy = (v.y * x - v.x * y),
      xz = (v.z * x - v.x * z),
      yz = (v.z * y - v.y * z),
      wxy = (v.wx * y + v.xy * w - v.wy * x),
      wxz = (v.wx * z + v.xz * w - v.wz * x),
      wyz = (v.wy * z + v.yz * w - v.wz * y),
      xyz = (v.xy * z + v.yz * x - v.xz * y),
      i = (v.wxz * y + v.xyz * w - v.wxy * z - v.wyz * x),
    )

  inline infix def ^(v: Pga3dMultivector): Pga3dMultivector = wedge(v)

  infix def wedge(v: Pga3dMotor): Pga3dMultivector =
    Pga3dMultivector(
      s = 0.0,
      w = v.s * w,
      x = v.s * x,
      y = v.s * y,
      z = v.s * z,
      wx = 0.0,
      wy = 0.0,
      wz = 0.0,
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
      wxy = (v.wx * y + v.xy * w - v.wy * x),
      wxz = (v.wx * z + v.xz * w - v.wz * x),
      wyz = (v.wy * z + v.yz * w - v.wz * y),
      xyz = (v.xy * z + v.yz * x - v.xz * y),
      i = 0.0,
    )

  inline infix def ^(v: Pga3dMotor): Pga3dMultivector = wedge(v)

  infix def wedge(v: Pga3dPlane): Pga3dBivector =
    Pga3dBivector(
      wx = (v.x * w - v.w * x),
      wy = (v.y * w - v.w * y),
      wz = (v.z * w - v.w * z),
      xy = (v.y * x - v.x * y),
      xz = (v.z * x - v.x * z),
      yz = (v.z * y - v.y * z),
    )

  inline infix def ^(v: Pga3dPlane): Pga3dBivector = wedge(v)

  infix def wedge(v: Pga3dBivector): Pga3dPoint =
    Pga3dPoint(
      wxy = (v.wx * y + v.xy * w - v.wy * x),
      wxz = (v.wx * z + v.xz * w - v.wz * x),
      wyz = (v.wy * z + v.yz * w - v.wz * y),
      xyz = (v.xy * z + v.yz * x - v.xz * y),
    )

  inline infix def ^(v: Pga3dBivector): Pga3dPoint = wedge(v)

  infix def wedge(v: Pga3dPoint): Pga3dPseudoScalar =
    Pga3dPseudoScalar(
      i = (v.wxz * y + v.xyz * w - v.wxy * z - v.wyz * x),
    )

  inline infix def ^(v: Pga3dPoint): Pga3dPseudoScalar = wedge(v)

  infix def wedge(v: Pga3dQuaternion): Pga3dMultivector =
    Pga3dMultivector(
      s = 0.0,
      w = v.s * w,
      x = v.s * x,
      y = v.s * y,
      z = v.s * z,
      wx = 0.0,
      wy = 0.0,
      wz = 0.0,
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
      wxy = v.xy * w,
      wxz = v.xz * w,
      wyz = v.yz * w,
      xyz = (v.xy * z + v.yz * x - v.xz * y),
      i = 0.0,
    )

  inline infix def ^(v: Pga3dQuaternion): Pga3dMultivector = wedge(v)

  infix def wedge(v: Pga3dTranslator): Pga3dMultivector =
    Pga3dMultivector(
      s = 0.0,
      w = w,
      x = x,
      y = y,
      z = z,
      wx = 0.0,
      wy = 0.0,
      wz = 0.0,
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
      wxy = (v.wx * y - v.wy * x),
      wxz = (v.wx * z - v.wz * x),
      wyz = (v.wy * z - v.wz * y),
      xyz = 0.0,
      i = 0.0,
    )

  inline infix def ^(v: Pga3dTranslator): Pga3dMultivector = wedge(v)

  infix def wedge(v: Pga3dVector): Pga3dPseudoScalar =
    Pga3dPseudoScalar(
      i = (v.wxz * y - v.wxy * z - v.wyz * x),
    )

  inline infix def ^(v: Pga3dVector): Pga3dPseudoScalar = wedge(v)

  infix def wedge(v: Pga3dPointNormalized): Pga3dPseudoScalar =
    Pga3dPseudoScalar(
      i = (w + v.wxz * y - v.wxy * z - v.wyz * x),
    )

  inline infix def ^(v: Pga3dPointNormalized): Pga3dPseudoScalar = wedge(v)

  infix def wedge(v: Pga3dPlaneIdeal): Pga3dBivector =
    Pga3dBivector(
      wx = v.x * w,
      wy = v.y * w,
      wz = v.z * w,
      xy = (v.y * x - v.x * y),
      xz = (v.z * x - v.x * z),
      yz = (v.z * y - v.y * z),
    )

  inline infix def ^(v: Pga3dPlaneIdeal): Pga3dBivector = wedge(v)

  infix def wedge(v: Pga3dBivectorBulk): Pga3dPoint =
    Pga3dPoint(
      wxy = v.xy * w,
      wxz = v.xz * w,
      wyz = v.yz * w,
      xyz = (v.xy * z + v.yz * x - v.xz * y),
    )

  inline infix def ^(v: Pga3dBivectorBulk): Pga3dPoint = wedge(v)

  infix def wedge(v: Pga3dBivectorWeight): Pga3dVector =
    Pga3dVector(
      wxy = (v.wx * y - v.wy * x),
      wxz = (v.wx * z - v.wz * x),
      wyz = (v.wy * z - v.wz * y),
    )

  inline infix def ^(v: Pga3dBivectorWeight): Pga3dVector = wedge(v)

  infix def wedge(v: Pga3dPointCenter.type): Pga3dPseudoScalar =
    Pga3dPseudoScalar(
      i = w,
    )

  inline infix def ^(v: Pga3dPointCenter.type): Pga3dPseudoScalar = wedge(v)

  infix def antiGeometric(v: Pga3dMultivector): Pga3dMultivector =
    Pga3dMultivector(
      s = (v.wxy * z + v.wyz * x - v.wxz * y - v.xyz * w),
      w = v.i * w,
      x = (v.i * x + v.wy * z + v.yz * w - v.wz * y),
      y = (v.i * y + v.wz * x - v.wx * z - v.xz * w),
      z = (v.i * z + v.wx * y + v.xy * w - v.wy * x),
      wx = -v.wyz * w,
      wy = v.wxz * w,
      wz = -v.wxy * w,
      xy = (v.w * z + v.wxz * x + v.wyz * y - v.z * w),
      xz = (v.wyz * z + v.y * w - v.w * y - v.wxy * x),
      yz = (v.w * x - v.wxy * y - v.wxz * z - v.x * w),
      wxy = v.wz * w,
      wxz = -v.wy * w,
      wyz = v.wx * w,
      xyz = (v.s * w + v.wx * x + v.wy * y + v.wz * z),
      i = -v.w * w,
    )

  infix def antiGeometric(v: Pga3dMotor): Pga3dMultivector =
    Pga3dMultivector(
      s = 0.0,
      w = v.i * w,
      x = (v.i * x + v.wy * z + v.yz * w - v.wz * y),
      y = (v.i * y + v.wz * x - v.wx * z - v.xz * w),
      z = (v.i * z + v.wx * y + v.xy * w - v.wy * x),
      wx = 0.0,
      wy = 0.0,
      wz = 0.0,
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
      wxy = v.wz * w,
      wxz = -v.wy * w,
      wyz = v.wx * w,
      xyz = (v.s * w + v.wx * x + v.wy * y + v.wz * z),
      i = 0.0,
    )

  infix def antiGeometric(v: Pga3dPlane): Pga3dMotor =
    Pga3dMotor(
      s = 0.0,
      wx = 0.0,
      wy = 0.0,
      wz = 0.0,
      xy = (v.w * z - v.z * w),
      xz = (v.y * w - v.w * y),
      yz = (v.w * x - v.x * w),
      i = -v.w * w,
    )

  infix def antiGeometric(v: Pga3dBivector): Pga3dMultivector =
    Pga3dMultivector(
      s = 0.0,
      w = 0.0,
      x = (v.wy * z + v.yz * w - v.wz * y),
      y = (v.wz * x - v.wx * z - v.xz * w),
      z = (v.wx * y + v.xy * w - v.wy * x),
      wx = 0.0,
      wy = 0.0,
      wz = 0.0,
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
      wxy = v.wz * w,
      wxz = -v.wy * w,
      wyz = v.wx * w,
      xyz = (v.wx * x + v.wy * y + v.wz * z),
      i = 0.0,
    )

  infix def antiGeometric(v: Pga3dPoint): Pga3dMotor =
    Pga3dMotor(
      s = (v.wxy * z + v.wyz * x - v.wxz * y - v.xyz * w),
      wx = -v.wyz * w,
      wy = v.wxz * w,
      wz = -v.wxy * w,
      xy = (v.wxz * x + v.wyz * y),
      xz = (v.wyz * z - v.wxy * x),
      yz = (-v.wxy * y - v.wxz * z),
      i = 0.0,
    )

  infix def antiGeometric(v: Pga3dQuaternion): Pga3dMultivector =
    Pga3dMultivector(
      s = 0.0,
      w = 0.0,
      x = v.yz * w,
      y = -v.xz * w,
      z = v.xy * w,
      wx = 0.0,
      wy = 0.0,
      wz = 0.0,
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
      wxy = 0.0,
      wxz = 0.0,
      wyz = 0.0,
      xyz = v.s * w,
      i = 0.0,
    )

  infix def antiGeometric(v: Pga3dTranslator): Pga3dMultivector =
    Pga3dMultivector(
      s = 0.0,
      w = 0.0,
      x = (v.wy * z - v.wz * y),
      y = (v.wz * x - v.wx * z),
      z = (v.wx * y - v.wy * x),
      wx = 0.0,
      wy = 0.0,
      wz = 0.0,
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
      wxy = v.wz * w,
      wxz = -v.wy * w,
      wyz = v.wx * w,
      xyz = (w + v.wx * x + v.wy * y + v.wz * z),
      i = 0.0,
    )

  infix def antiGeometric(v: Pga3dVector): Pga3dMotor =
    Pga3dMotor(
      s = (v.wxy * z + v.wyz * x - v.wxz * y),
      wx = -v.wyz * w,
      wy = v.wxz * w,
      wz = -v.wxy * w,
      xy = (v.wxz * x + v.wyz * y),
      xz = (v.wyz * z - v.wxy * x),
      yz = (-v.wxy * y - v.wxz * z),
      i = 0.0,
    )

  infix def antiGeometric(v: Pga3dPointNormalized): Pga3dMotor =
    Pga3dMotor(
      s = (-w + v.wxy * z + v.wyz * x - v.wxz * y),
      wx = -v.wyz * w,
      wy = v.wxz * w,
      wz = -v.wxy * w,
      xy = (v.wxz * x + v.wyz * y),
      xz = (v.wyz * z - v.wxy * x),
      yz = (-v.wxy * y - v.wxz * z),
      i = 0.0,
    )

  infix def antiGeometric(v: Pga3dPlaneIdeal): Pga3dBivectorBulk =
    Pga3dBivectorBulk(
      xy = -v.z * w,
      xz = v.y * w,
      yz = -v.x * w,
    )

  infix def antiGeometric(v: Pga3dBivectorBulk): Pga3dPlaneIdeal =
    Pga3dPlaneIdeal(
      x = v.yz * w,
      y = -v.xz * w,
      z = v.xy * w,
    )

  infix def antiGeometric(v: Pga3dBivectorWeight): Pga3dMultivector =
    Pga3dMultivector(
      s = 0.0,
      w = 0.0,
      x = (v.wy * z - v.wz * y),
      y = (v.wz * x - v.wx * z),
      z = (v.wx * y - v.wy * x),
      wx = 0.0,
      wy = 0.0,
      wz = 0.0,
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
      wxy = v.wz * w,
      wxz = -v.wy * w,
      wyz = v.wx * w,
      xyz = (v.wx * x + v.wy * y + v.wz * z),
      i = 0.0,
    )

  infix def antiGeometric(v: Pga3dPseudoScalar): Pga3dPlane =
    Pga3dPlane(
      w = v.i * w,
      x = v.i * x,
      y = v.i * y,
      z = v.i * z,
    )

  infix def antiGeometric(v: Pga3dPointCenter.type): Double =
    -w

  infix def antiDot(v: Pga3dMultivector): Pga3dMultivector =
    Pga3dMultivector(
      s = 0.0,
      w = v.i * w,
      x = v.i * x,
      y = v.i * y,
      z = v.i * z,
      wx = -v.wyz * w,
      wy = v.wxz * w,
      wz = -v.wxy * w,
      xy = (v.wxz * x + v.wyz * y),
      xz = (v.wyz * z - v.wxy * x),
      yz = (-v.wxy * y - v.wxz * z),
      wxy = v.wz * w,
      wxz = -v.wy * w,
      wyz = v.wx * w,
      xyz = (v.s * w + v.wx * x + v.wy * y + v.wz * z),
      i = -v.w * w,
    )

  infix def antiDot(v: Pga3dMotor): Pga3dMultivector =
    Pga3dMultivector(
      s = 0.0,
      w = v.i * w,
      x = v.i * x,
      y = v.i * y,
      z = v.i * z,
      wx = 0.0,
      wy = 0.0,
      wz = 0.0,
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
      wxy = v.wz * w,
      wxz = -v.wy * w,
      wyz = v.wx * w,
      xyz = (v.s * w + v.wx * x + v.wy * y + v.wz * z),
      i = 0.0,
    )

  infix def antiDot(v: Pga3dPlane): Pga3dPseudoScalar =
    Pga3dPseudoScalar(
      i = -v.w * w,
    )

  infix def antiDot(v: Pga3dBivector): Pga3dPoint =
    Pga3dPoint(
      wxy = v.wz * w,
      wxz = -v.wy * w,
      wyz = v.wx * w,
      xyz = (v.wx * x + v.wy * y + v.wz * z),
    )

  infix def antiDot(v: Pga3dPoint): Pga3dBivector =
    Pga3dBivector(
      wx = -v.wyz * w,
      wy = v.wxz * w,
      wz = -v.wxy * w,
      xy = (v.wxz * x + v.wyz * y),
      xz = (v.wyz * z - v.wxy * x),
      yz = (-v.wxy * y - v.wxz * z),
    )

  infix def antiDot(v: Pga3dQuaternion): Pga3dPoint =
    Pga3dPoint(
      wxy = 0.0,
      wxz = 0.0,
      wyz = 0.0,
      xyz = v.s * w,
    )

  infix def antiDot(v: Pga3dTranslator): Pga3dPoint =
    Pga3dPoint(
      wxy = v.wz * w,
      wxz = -v.wy * w,
      wyz = v.wx * w,
      xyz = (w + v.wx * x + v.wy * y + v.wz * z),
    )

  infix def antiDot(v: Pga3dVector): Pga3dBivector =
    Pga3dBivector(
      wx = -v.wyz * w,
      wy = v.wxz * w,
      wz = -v.wxy * w,
      xy = (v.wxz * x + v.wyz * y),
      xz = (v.wyz * z - v.wxy * x),
      yz = (-v.wxy * y - v.wxz * z),
    )

  infix def antiDot(v: Pga3dPointNormalized): Pga3dBivector =
    Pga3dBivector(
      wx = -v.wyz * w,
      wy = v.wxz * w,
      wz = -v.wxy * w,
      xy = (v.wxz * x + v.wyz * y),
      xz = (v.wyz * z - v.wxy * x),
      yz = (-v.wxy * y - v.wxz * z),
    )

  infix def antiDot(v: Pga3dBivectorWeight): Pga3dPoint =
    Pga3dPoint(
      wxy = v.wz * w,
      wxz = -v.wy * w,
      wyz = v.wx * w,
      xyz = (v.wx * x + v.wy * y + v.wz * z),
    )

  infix def antiDot(v: Pga3dPseudoScalar): Pga3dPlane =
    Pga3dPlane(
      w = v.i * w,
      x = v.i * x,
      y = v.i * y,
      z = v.i * z,
    )

  infix def antiWedge(v: Pga3dMultivector): Pga3dMultivector =
    Pga3dMultivector(
      s = (v.wxy * z + v.wyz * x - v.wxz * y - v.xyz * w),
      w = v.i * w,
      x = v.i * x,
      y = v.i * y,
      z = v.i * z,
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
      i = 0.0,
    )

  inline infix def v(v: Pga3dMultivector): Pga3dMultivector = antiWedge(v)

  infix def antiWedge(v: Pga3dMotor): Pga3dPlane =
    Pga3dPlane(
      w = v.i * w,
      x = v.i * x,
      y = v.i * y,
      z = v.i * z,
    )

  inline infix def v(v: Pga3dMotor): Pga3dPlane = antiWedge(v)

  infix def antiWedge(v: Pga3dPoint): Double =
    (v.wxy * z + v.wyz * x - v.wxz * y - v.xyz * w)

  inline infix def v(v: Pga3dPoint): Double = antiWedge(v)

  infix def antiWedge(v: Pga3dVector): Double =
    (v.wxy * z + v.wyz * x - v.wxz * y)

  inline infix def v(v: Pga3dVector): Double = antiWedge(v)

  infix def antiWedge(v: Pga3dPointNormalized): Double =
    (-w + v.wxy * z + v.wyz * x - v.wxz * y)

  inline infix def v(v: Pga3dPointNormalized): Double = antiWedge(v)

  infix def antiWedge(v: Pga3dPseudoScalar): Pga3dPlane =
    Pga3dPlane(
      w = v.i * w,
      x = v.i * x,
      y = v.i * y,
      z = v.i * z,
    )

  inline infix def v(v: Pga3dPseudoScalar): Pga3dPlane = antiWedge(v)

  infix def antiWedge(v: Pga3dPointCenter.type): Double =
    -w

  inline infix def v(v: Pga3dPointCenter.type): Double = antiWedge(v)

  infix def sandwich(v: Pga3dMultivector): Pga3dMultivector =
    val wMx = w * x
    val wMy = w * y
    val wMz = w * z
    val xMx = x * x
    val xMy = x * y
    val xMz = x * z
    val yMy = y * y
    val yMz = y * z
    val zMz = z * z
    Pga3dMultivector(
      s = v.s * (xMx + yMy + zMz),
      w = (2.0 * (v.x * wMx + v.y * wMy + v.z * wMz) + v.w * (-xMx - yMy - zMz)),
      x = (2.0 * (v.y * xMy + v.z * xMz) + v.x * (xMx - yMy - zMz)),
      y = (2.0 * (v.x * xMy + v.z * yMz) + v.y * (yMy - xMx - zMz)),
      z = (2.0 * (v.x * xMz + v.y * yMz) + v.z * (zMz - xMx - yMy)),
      wx = (2.0 * (v.xy * wMy + v.xz * wMz - v.wy * xMy - v.wz * xMz) + v.wx * (yMy + zMz - xMx)),
      wy = (2.0 * (v.yz * wMz - v.wx * xMy - v.wz * yMz - v.xy * wMx) + v.wy * (xMx + zMz - yMy)),
      wz = (2.0 * (-v.wx * xMz - v.wy * yMz - v.xz * wMx - v.yz * wMy) + v.wz * (xMx + yMy - zMz)),
      xy = (2.0 * (v.yz * xMz - v.xz * yMz) + v.xy * (zMz - xMx - yMy)),
      xz = (2.0 * (-v.xy * yMz - v.yz * xMy) + v.xz * (yMy - xMx - zMz)),
      yz = (2.0 * (v.xy * xMz - v.xz * xMy) + v.yz * (xMx - yMy - zMz)),
      wxy = (2.0 * (v.wxz * yMz + v.xyz * wMz - v.wyz * xMz) + v.wxy * (xMx + yMy - zMz)),
      wxz = (2.0 * (v.wxy * yMz + v.wyz * xMy - v.xyz * wMy) + v.wxz * (xMx + zMz - yMy)),
      wyz = (2.0 * (v.wxz * xMy + v.xyz * wMx - v.wxy * xMz) + v.wyz * (yMy + zMz - xMx)),
      xyz = v.xyz * (xMx + yMy + zMz),
      i = v.i * (-xMx - yMy - zMz),
    )

  infix def sandwich(v: Pga3dMotor): Pga3dMotor =
    val wMx = w * x
    val wMy = w * y
    val wMz = w * z
    val xMx = x * x
    val xMy = x * y
    val xMz = x * z
    val yMy = y * y
    val yMz = y * z
    val zMz = z * z
    Pga3dMotor(
      s = v.s * (xMx + yMy + zMz),
      wx = (2.0 * (v.xy * wMy + v.xz * wMz - v.wy * xMy - v.wz * xMz) + v.wx * (yMy + zMz - xMx)),
      wy = (2.0 * (v.yz * wMz - v.wx * xMy - v.wz * yMz - v.xy * wMx) + v.wy * (xMx + zMz - yMy)),
      wz = (2.0 * (-v.wx * xMz - v.wy * yMz - v.xz * wMx - v.yz * wMy) + v.wz * (xMx + yMy - zMz)),
      xy = (2.0 * (v.yz * xMz - v.xz * yMz) + v.xy * (zMz - xMx - yMy)),
      xz = (2.0 * (-v.xy * yMz - v.yz * xMy) + v.xz * (yMy - xMx - zMz)),
      yz = (2.0 * (v.xy * xMz - v.xz * xMy) + v.yz * (xMx - yMy - zMz)),
      i = v.i * (-xMx - yMy - zMz),
    )

  infix def sandwich(v: Pga3dPlane): Pga3dPlane =
    val xMx = x * x
    val xMy = x * y
    val xMz = x * z
    val yMy = y * y
    val yMz = y * z
    val zMz = z * z
    Pga3dPlane(
      w = (v.w * (-xMx - yMy - zMz) + 2.0 * w * (v.x * x + v.y * y + v.z * z)),
      x = (2.0 * (v.y * xMy + v.z * xMz) + v.x * (xMx - yMy - zMz)),
      y = (2.0 * (v.x * xMy + v.z * yMz) + v.y * (yMy - xMx - zMz)),
      z = (2.0 * (v.x * xMz + v.y * yMz) + v.z * (zMz - xMx - yMy)),
    )

  infix def sandwich(v: Pga3dBivector): Pga3dBivector =
    val wMx = w * x
    val wMy = w * y
    val wMz = w * z
    val xMx = x * x
    val xMy = x * y
    val xMz = x * z
    val yMy = y * y
    val yMz = y * z
    val zMz = z * z
    Pga3dBivector(
      wx = (2.0 * (v.xy * wMy + v.xz * wMz - v.wy * xMy - v.wz * xMz) + v.wx * (yMy + zMz - xMx)),
      wy = (2.0 * (v.yz * wMz - v.wx * xMy - v.wz * yMz - v.xy * wMx) + v.wy * (xMx + zMz - yMy)),
      wz = (2.0 * (-v.wx * xMz - v.wy * yMz - v.xz * wMx - v.yz * wMy) + v.wz * (xMx + yMy - zMz)),
      xy = (2.0 * (v.yz * xMz - v.xz * yMz) + v.xy * (zMz - xMx - yMy)),
      xz = (2.0 * (-v.xy * yMz - v.yz * xMy) + v.xz * (yMy - xMx - zMz)),
      yz = (2.0 * (v.xy * xMz - v.xz * xMy) + v.yz * (xMx - yMy - zMz)),
    )

  infix def sandwich(v: Pga3dPoint): Pga3dPoint =
    val xMx = x * x
    val xMy = x * y
    val xMz = x * z
    val yMy = y * y
    val yMz = y * z
    val zMz = z * z
    Pga3dPoint(
      wxy = (2.0 * (v.wxz * yMz - v.wyz * xMz + v.xyz * w * z) + v.wxy * (xMx + yMy - zMz)),
      wxz = (2.0 * (v.wxy * yMz + v.wyz * xMy - v.xyz * w * y) + v.wxz * (xMx + zMz - yMy)),
      wyz = (2.0 * (v.wxz * xMy - v.wxy * xMz + v.xyz * w * x) + v.wyz * (yMy + zMz - xMx)),
      xyz = v.xyz * (xMx + yMy + zMz),
    )

  infix def sandwich(v: Pga3dQuaternion): Pga3dMotor =
    val wMx = w * x
    val wMy = w * y
    val wMz = w * z
    val xMx = x * x
    val xMy = x * y
    val xMz = x * z
    val yMy = y * y
    val yMz = y * z
    val zMz = z * z
    Pga3dMotor(
      s = v.s * (xMx + yMy + zMz),
      wx = 2.0 * (v.xy * wMy + v.xz * wMz),
      wy = 2.0 * (v.yz * wMz - v.xy * wMx),
      wz = 2.0 * (-v.xz * wMx - v.yz * wMy),
      xy = (2.0 * (v.yz * xMz - v.xz * yMz) + v.xy * (zMz - xMx - yMy)),
      xz = (2.0 * (-v.xy * yMz - v.yz * xMy) + v.xz * (yMy - xMx - zMz)),
      yz = (2.0 * (v.xy * xMz - v.xz * xMy) + v.yz * (xMx - yMy - zMz)),
      i = 0.0,
    )

  infix def sandwich(v: Pga3dTranslator): Pga3dMotor =
    val xMx = x * x
    val xMy = x * y
    val xMz = x * z
    val yMy = y * y
    val yMz = y * z
    val zMz = z * z
    Pga3dMotor(
      s = (xMx + yMy + zMz),
      wx = (2.0 * (-v.wy * xMy - v.wz * xMz) + v.wx * (yMy + zMz - xMx)),
      wy = (2.0 * (-v.wx * xMy - v.wz * yMz) + v.wy * (xMx + zMz - yMy)),
      wz = (2.0 * (-v.wx * xMz - v.wy * yMz) + v.wz * (xMx + yMy - zMz)),
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
      i = 0.0,
    )

  infix def sandwich(v: Pga3dVector): Pga3dVector =
    val xMx = x * x
    val xMy = x * y
    val xMz = x * z
    val yMy = y * y
    val yMz = y * z
    val zMz = z * z
    Pga3dVector(
      wxy = (2.0 * (v.wxz * yMz - v.wyz * xMz) + v.wxy * (xMx + yMy - zMz)),
      wxz = (2.0 * (v.wxy * yMz + v.wyz * xMy) + v.wxz * (xMx + zMz - yMy)),
      wyz = (2.0 * (v.wxz * xMy - v.wxy * xMz) + v.wyz * (yMy + zMz - xMx)),
    )

  infix def sandwich(v: Pga3dPointNormalized): Pga3dPoint =
    val xMx = x * x
    val xMy = x * y
    val xMz = x * z
    val yMy = y * y
    val yMz = y * z
    val zMz = z * z
    Pga3dPoint(
      wxy = (2.0 * (v.wxz * yMz + w * z - v.wyz * xMz) + v.wxy * (xMx + yMy - zMz)),
      wxz = (2.0 * (v.wxy * yMz + v.wyz * xMy - w * y) + v.wxz * (xMx + zMz - yMy)),
      wyz = (2.0 * (v.wxz * xMy + w * x - v.wxy * xMz) + v.wyz * (yMy + zMz - xMx)),
      xyz = (xMx + yMy + zMz),
    )

  infix def sandwich(v: Pga3dPlaneIdeal): Pga3dPlane =
    val xMx = x * x
    val xMy = x * y
    val xMz = x * z
    val yMy = y * y
    val yMz = y * z
    val zMz = z * z
    Pga3dPlane(
      w = 2.0 * w * (v.x * x + v.y * y + v.z * z),
      x = (2.0 * (v.y * xMy + v.z * xMz) + v.x * (xMx - yMy - zMz)),
      y = (2.0 * (v.x * xMy + v.z * yMz) + v.y * (yMy - xMx - zMz)),
      z = (2.0 * (v.x * xMz + v.y * yMz) + v.z * (zMz - xMx - yMy)),
    )

  infix def sandwich(v: Pga3dBivectorBulk): Pga3dBivector =
    val wMx = w * x
    val wMy = w * y
    val wMz = w * z
    val xMx = x * x
    val xMy = x * y
    val xMz = x * z
    val yMy = y * y
    val yMz = y * z
    val zMz = z * z
    Pga3dBivector(
      wx = 2.0 * (v.xy * wMy + v.xz * wMz),
      wy = 2.0 * (v.yz * wMz - v.xy * wMx),
      wz = 2.0 * (-v.xz * wMx - v.yz * wMy),
      xy = (2.0 * (v.yz * xMz - v.xz * yMz) + v.xy * (zMz - xMx - yMy)),
      xz = (2.0 * (-v.xy * yMz - v.yz * xMy) + v.xz * (yMy - xMx - zMz)),
      yz = (2.0 * (v.xy * xMz - v.xz * xMy) + v.yz * (xMx - yMy - zMz)),
    )

  infix def sandwich(v: Pga3dBivectorWeight): Pga3dBivectorWeight =
    val xMx = x * x
    val xMy = x * y
    val xMz = x * z
    val yMy = y * y
    val yMz = y * z
    val zMz = z * z
    Pga3dBivectorWeight(
      wx = (2.0 * (-v.wy * xMy - v.wz * xMz) + v.wx * (yMy + zMz - xMx)),
      wy = (2.0 * (-v.wx * xMy - v.wz * yMz) + v.wy * (xMx + zMz - yMy)),
      wz = (2.0 * (-v.wx * xMz - v.wy * yMz) + v.wz * (xMx + yMy - zMz)),
    )

  infix def sandwich(v: Pga3dPseudoScalar): Pga3dPseudoScalar =
    Pga3dPseudoScalar(
      i = v.i * (-x * x - y * y - z * z),
    )

  infix def sandwich(v: Pga3dPointCenter.type): Pga3dPoint =
    Pga3dPoint(
      wxy = 2.0 * w * z,
      wxz = -2.0 * w * y,
      wyz = 2.0 * w * x,
      xyz = (x * x + y * y + z * z),
    )

  infix def reverseSandwich(v: Pga3dMultivector): Pga3dMultivector =
    val wMx = w * x
    val wMy = w * y
    val wMz = w * z
    val xMx = x * x
    val xMy = x * y
    val xMz = x * z
    val yMy = y * y
    val yMz = y * z
    val zMz = z * z
    Pga3dMultivector(
      s = v.s * (xMx + yMy + zMz),
      w = (2.0 * (v.x * wMx + v.y * wMy + v.z * wMz) + v.w * (-xMx - yMy - zMz)),
      x = (2.0 * (v.y * xMy + v.z * xMz) + v.x * (xMx - yMy - zMz)),
      y = (2.0 * (v.x * xMy + v.z * yMz) + v.y * (yMy - xMx - zMz)),
      z = (2.0 * (v.x * xMz + v.y * yMz) + v.z * (zMz - xMx - yMy)),
      wx = (2.0 * (v.xy * wMy + v.xz * wMz - v.wy * xMy - v.wz * xMz) + v.wx * (yMy + zMz - xMx)),
      wy = (2.0 * (v.yz * wMz - v.wx * xMy - v.wz * yMz - v.xy * wMx) + v.wy * (xMx + zMz - yMy)),
      wz = (2.0 * (-v.wx * xMz - v.wy * yMz - v.xz * wMx - v.yz * wMy) + v.wz * (xMx + yMy - zMz)),
      xy = (2.0 * (v.yz * xMz - v.xz * yMz) + v.xy * (zMz - xMx - yMy)),
      xz = (2.0 * (-v.xy * yMz - v.yz * xMy) + v.xz * (yMy - xMx - zMz)),
      yz = (2.0 * (v.xy * xMz - v.xz * xMy) + v.yz * (xMx - yMy - zMz)),
      wxy = (2.0 * (v.wxz * yMz + v.xyz * wMz - v.wyz * xMz) + v.wxy * (xMx + yMy - zMz)),
      wxz = (2.0 * (v.wxy * yMz + v.wyz * xMy - v.xyz * wMy) + v.wxz * (xMx + zMz - yMy)),
      wyz = (2.0 * (v.wxz * xMy + v.xyz * wMx - v.wxy * xMz) + v.wyz * (yMy + zMz - xMx)),
      xyz = v.xyz * (xMx + yMy + zMz),
      i = v.i * (-xMx - yMy - zMz),
    )

  infix def reverseSandwich(v: Pga3dMotor): Pga3dMotor =
    val wMx = w * x
    val wMy = w * y
    val wMz = w * z
    val xMx = x * x
    val xMy = x * y
    val xMz = x * z
    val yMy = y * y
    val yMz = y * z
    val zMz = z * z
    Pga3dMotor(
      s = v.s * (xMx + yMy + zMz),
      wx = (2.0 * (v.xy * wMy + v.xz * wMz - v.wy * xMy - v.wz * xMz) + v.wx * (yMy + zMz - xMx)),
      wy = (2.0 * (v.yz * wMz - v.wx * xMy - v.wz * yMz - v.xy * wMx) + v.wy * (xMx + zMz - yMy)),
      wz = (2.0 * (-v.wx * xMz - v.wy * yMz - v.xz * wMx - v.yz * wMy) + v.wz * (xMx + yMy - zMz)),
      xy = (2.0 * (v.yz * xMz - v.xz * yMz) + v.xy * (zMz - xMx - yMy)),
      xz = (2.0 * (-v.xy * yMz - v.yz * xMy) + v.xz * (yMy - xMx - zMz)),
      yz = (2.0 * (v.xy * xMz - v.xz * xMy) + v.yz * (xMx - yMy - zMz)),
      i = v.i * (-xMx - yMy - zMz),
    )

  infix def reverseSandwich(v: Pga3dPlane): Pga3dPlane =
    val xMx = x * x
    val xMy = x * y
    val xMz = x * z
    val yMy = y * y
    val yMz = y * z
    val zMz = z * z
    Pga3dPlane(
      w = (v.w * (-xMx - yMy - zMz) + 2.0 * w * (v.x * x + v.y * y + v.z * z)),
      x = (2.0 * (v.y * xMy + v.z * xMz) + v.x * (xMx - yMy - zMz)),
      y = (2.0 * (v.x * xMy + v.z * yMz) + v.y * (yMy - xMx - zMz)),
      z = (2.0 * (v.x * xMz + v.y * yMz) + v.z * (zMz - xMx - yMy)),
    )

  infix def reverseSandwich(v: Pga3dBivector): Pga3dBivector =
    val wMx = w * x
    val wMy = w * y
    val wMz = w * z
    val xMx = x * x
    val xMy = x * y
    val xMz = x * z
    val yMy = y * y
    val yMz = y * z
    val zMz = z * z
    Pga3dBivector(
      wx = (2.0 * (v.xy * wMy + v.xz * wMz - v.wy * xMy - v.wz * xMz) + v.wx * (yMy + zMz - xMx)),
      wy = (2.0 * (v.yz * wMz - v.wx * xMy - v.wz * yMz - v.xy * wMx) + v.wy * (xMx + zMz - yMy)),
      wz = (2.0 * (-v.wx * xMz - v.wy * yMz - v.xz * wMx - v.yz * wMy) + v.wz * (xMx + yMy - zMz)),
      xy = (2.0 * (v.yz * xMz - v.xz * yMz) + v.xy * (zMz - xMx - yMy)),
      xz = (2.0 * (-v.xy * yMz - v.yz * xMy) + v.xz * (yMy - xMx - zMz)),
      yz = (2.0 * (v.xy * xMz - v.xz * xMy) + v.yz * (xMx - yMy - zMz)),
    )

  infix def reverseSandwich(v: Pga3dPoint): Pga3dPoint =
    val xMx = x * x
    val xMy = x * y
    val xMz = x * z
    val yMy = y * y
    val yMz = y * z
    val zMz = z * z
    Pga3dPoint(
      wxy = (2.0 * (v.wxz * yMz - v.wyz * xMz + v.xyz * w * z) + v.wxy * (xMx + yMy - zMz)),
      wxz = (2.0 * (v.wxy * yMz + v.wyz * xMy - v.xyz * w * y) + v.wxz * (xMx + zMz - yMy)),
      wyz = (2.0 * (v.wxz * xMy - v.wxy * xMz + v.xyz * w * x) + v.wyz * (yMy + zMz - xMx)),
      xyz = v.xyz * (xMx + yMy + zMz),
    )

  infix def reverseSandwich(v: Pga3dQuaternion): Pga3dMotor =
    val wMx = w * x
    val wMy = w * y
    val wMz = w * z
    val xMx = x * x
    val xMy = x * y
    val xMz = x * z
    val yMy = y * y
    val yMz = y * z
    val zMz = z * z
    Pga3dMotor(
      s = v.s * (xMx + yMy + zMz),
      wx = 2.0 * (v.xy * wMy + v.xz * wMz),
      wy = 2.0 * (v.yz * wMz - v.xy * wMx),
      wz = 2.0 * (-v.xz * wMx - v.yz * wMy),
      xy = (2.0 * (v.yz * xMz - v.xz * yMz) + v.xy * (zMz - xMx - yMy)),
      xz = (2.0 * (-v.xy * yMz - v.yz * xMy) + v.xz * (yMy - xMx - zMz)),
      yz = (2.0 * (v.xy * xMz - v.xz * xMy) + v.yz * (xMx - yMy - zMz)),
      i = 0.0,
    )

  infix def reverseSandwich(v: Pga3dTranslator): Pga3dMotor =
    val xMx = x * x
    val xMy = x * y
    val xMz = x * z
    val yMy = y * y
    val yMz = y * z
    val zMz = z * z
    Pga3dMotor(
      s = (xMx + yMy + zMz),
      wx = (2.0 * (-v.wy * xMy - v.wz * xMz) + v.wx * (yMy + zMz - xMx)),
      wy = (2.0 * (-v.wx * xMy - v.wz * yMz) + v.wy * (xMx + zMz - yMy)),
      wz = (2.0 * (-v.wx * xMz - v.wy * yMz) + v.wz * (xMx + yMy - zMz)),
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
      i = 0.0,
    )

  infix def reverseSandwich(v: Pga3dVector): Pga3dVector =
    val xMx = x * x
    val xMy = x * y
    val xMz = x * z
    val yMy = y * y
    val yMz = y * z
    val zMz = z * z
    Pga3dVector(
      wxy = (2.0 * (v.wxz * yMz - v.wyz * xMz) + v.wxy * (xMx + yMy - zMz)),
      wxz = (2.0 * (v.wxy * yMz + v.wyz * xMy) + v.wxz * (xMx + zMz - yMy)),
      wyz = (2.0 * (v.wxz * xMy - v.wxy * xMz) + v.wyz * (yMy + zMz - xMx)),
    )

  infix def reverseSandwich(v: Pga3dPointNormalized): Pga3dPoint =
    val xMx = x * x
    val xMy = x * y
    val xMz = x * z
    val yMy = y * y
    val yMz = y * z
    val zMz = z * z
    Pga3dPoint(
      wxy = (2.0 * (v.wxz * yMz + w * z - v.wyz * xMz) + v.wxy * (xMx + yMy - zMz)),
      wxz = (2.0 * (v.wxy * yMz + v.wyz * xMy - w * y) + v.wxz * (xMx + zMz - yMy)),
      wyz = (2.0 * (v.wxz * xMy + w * x - v.wxy * xMz) + v.wyz * (yMy + zMz - xMx)),
      xyz = (xMx + yMy + zMz),
    )

  infix def reverseSandwich(v: Pga3dPlaneIdeal): Pga3dPlane =
    val xMx = x * x
    val xMy = x * y
    val xMz = x * z
    val yMy = y * y
    val yMz = y * z
    val zMz = z * z
    Pga3dPlane(
      w = 2.0 * w * (v.x * x + v.y * y + v.z * z),
      x = (2.0 * (v.y * xMy + v.z * xMz) + v.x * (xMx - yMy - zMz)),
      y = (2.0 * (v.x * xMy + v.z * yMz) + v.y * (yMy - xMx - zMz)),
      z = (2.0 * (v.x * xMz + v.y * yMz) + v.z * (zMz - xMx - yMy)),
    )

  infix def reverseSandwich(v: Pga3dBivectorBulk): Pga3dBivector =
    val wMx = w * x
    val wMy = w * y
    val wMz = w * z
    val xMx = x * x
    val xMy = x * y
    val xMz = x * z
    val yMy = y * y
    val yMz = y * z
    val zMz = z * z
    Pga3dBivector(
      wx = 2.0 * (v.xy * wMy + v.xz * wMz),
      wy = 2.0 * (v.yz * wMz - v.xy * wMx),
      wz = 2.0 * (-v.xz * wMx - v.yz * wMy),
      xy = (2.0 * (v.yz * xMz - v.xz * yMz) + v.xy * (zMz - xMx - yMy)),
      xz = (2.0 * (-v.xy * yMz - v.yz * xMy) + v.xz * (yMy - xMx - zMz)),
      yz = (2.0 * (v.xy * xMz - v.xz * xMy) + v.yz * (xMx - yMy - zMz)),
    )

  infix def reverseSandwich(v: Pga3dBivectorWeight): Pga3dBivectorWeight =
    val xMx = x * x
    val xMy = x * y
    val xMz = x * z
    val yMy = y * y
    val yMz = y * z
    val zMz = z * z
    Pga3dBivectorWeight(
      wx = (2.0 * (-v.wy * xMy - v.wz * xMz) + v.wx * (yMy + zMz - xMx)),
      wy = (2.0 * (-v.wx * xMy - v.wz * yMz) + v.wy * (xMx + zMz - yMy)),
      wz = (2.0 * (-v.wx * xMz - v.wy * yMz) + v.wz * (xMx + yMy - zMz)),
    )

  infix def reverseSandwich(v: Pga3dPseudoScalar): Pga3dPseudoScalar =
    Pga3dPseudoScalar(
      i = v.i * (-x * x - y * y - z * z),
    )

  infix def reverseSandwich(v: Pga3dPointCenter.type): Pga3dPoint =
    Pga3dPoint(
      wxy = 2.0 * w * z,
      wxz = -2.0 * w * y,
      wyz = 2.0 * w * x,
      xyz = (x * x + y * y + z * z),
    )

  infix def cross(v: Pga3dMultivector): Pga3dMultivector =
    Pga3dMultivector(
      s = 0.0,
      w = (-v.wx * x - v.wy * y - v.wz * z),
      x = (-v.xy * y - v.xz * z),
      y = (v.xy * x - v.yz * z),
      z = (v.xz * x + v.yz * y),
      wx = (v.x * w - v.w * x),
      wy = (v.y * w - v.w * y),
      wz = (v.z * w - v.w * z),
      xy = (v.y * x - v.x * y),
      xz = (v.z * x - v.x * z),
      yz = (v.z * y - v.y * z),
      wxy = -v.i * z,
      wxz = v.i * y,
      wyz = -v.i * x,
      xyz = 0.0,
      i = (v.wxz * y + v.xyz * w - v.wxy * z - v.wyz * x),
    )

  infix def cross(v: Pga3dMotor): Pga3dMultivector =
    Pga3dMultivector(
      s = 0.0,
      w = (-v.wx * x - v.wy * y - v.wz * z),
      x = (-v.xy * y - v.xz * z),
      y = (v.xy * x - v.yz * z),
      z = (v.xz * x + v.yz * y),
      wx = 0.0,
      wy = 0.0,
      wz = 0.0,
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
      wxy = -v.i * z,
      wxz = v.i * y,
      wyz = -v.i * x,
      xyz = 0.0,
      i = 0.0,
    )

  infix def cross(v: Pga3dPlane): Pga3dBivector =
    Pga3dBivector(
      wx = (v.x * w - v.w * x),
      wy = (v.y * w - v.w * y),
      wz = (v.z * w - v.w * z),
      xy = (v.y * x - v.x * y),
      xz = (v.z * x - v.x * z),
      yz = (v.z * y - v.y * z),
    )

  infix def cross(v: Pga3dBivector): Pga3dPlane =
    Pga3dPlane(
      w = (-v.wx * x - v.wy * y - v.wz * z),
      x = (-v.xy * y - v.xz * z),
      y = (v.xy * x - v.yz * z),
      z = (v.xz * x + v.yz * y),
    )

  infix def cross(v: Pga3dPoint): Pga3dPseudoScalar =
    Pga3dPseudoScalar(
      i = (v.wxz * y + v.xyz * w - v.wxy * z - v.wyz * x),
    )

  infix def cross(v: Pga3dQuaternion): Pga3dPlaneIdeal =
    Pga3dPlaneIdeal(
      x = (-v.xy * y - v.xz * z),
      y = (v.xy * x - v.yz * z),
      z = (v.xz * x + v.yz * y),
    )

  infix def cross(v: Pga3dTranslator): Pga3dPlane =
    Pga3dPlane(
      w = (-v.wx * x - v.wy * y - v.wz * z),
      x = 0.0,
      y = 0.0,
      z = 0.0,
    )

  infix def cross(v: Pga3dVector): Pga3dPseudoScalar =
    Pga3dPseudoScalar(
      i = (v.wxz * y - v.wxy * z - v.wyz * x),
    )

  infix def cross(v: Pga3dPointNormalized): Pga3dPseudoScalar =
    Pga3dPseudoScalar(
      i = (w + v.wxz * y - v.wxy * z - v.wyz * x),
    )

  infix def cross(v: Pga3dPlaneIdeal): Pga3dBivector =
    Pga3dBivector(
      wx = v.x * w,
      wy = v.y * w,
      wz = v.z * w,
      xy = (v.y * x - v.x * y),
      xz = (v.z * x - v.x * z),
      yz = (v.z * y - v.y * z),
    )

  infix def cross(v: Pga3dBivectorBulk): Pga3dPlaneIdeal =
    Pga3dPlaneIdeal(
      x = (-v.xy * y - v.xz * z),
      y = (v.xy * x - v.yz * z),
      z = (v.xz * x + v.yz * y),
    )

  infix def cross(v: Pga3dBivectorWeight): Pga3dPlane =
    Pga3dPlane(
      w = (-v.wx * x - v.wy * y - v.wz * z),
      x = 0.0,
      y = 0.0,
      z = 0.0,
    )

  infix def cross(v: Pga3dPseudoScalar): Pga3dVector =
    Pga3dVector(
      wxy = -v.i * z,
      wxz = v.i * y,
      wyz = -v.i * x,
    )

  infix def cross(v: Pga3dPointCenter.type): Pga3dPseudoScalar =
    Pga3dPseudoScalar(
      i = w,
    )