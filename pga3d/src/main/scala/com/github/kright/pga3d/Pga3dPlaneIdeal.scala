package com.github.kright.pga3d

/** this code is generated, see com.github.kright.pga3d.codegen.CodeGenClass */
case class Pga3dPlaneIdeal(x: Double = 0.0,
                           y: Double = 0.0,
                           z: Double = 0.0):

  def dual: Pga3dVector =
    Pga3dVector(
      wxy = -z,
      wxz = y,
      wyz = -x,
    )

  def bulk: Pga3dPlaneIdeal =
    this

  def unary_- : Pga3dPlaneIdeal =
    Pga3dPlaneIdeal(
      x = -x,
      y = -y,
      z = -z,
    )

  def reverse: Pga3dPlaneIdeal =
    this

  def antiReverse: Pga3dPlaneIdeal =
    -this

  def bulkNormSquare: Double =
    (x * x + y * y + z * z)

  def bulkNorm: Double =
    Math.sqrt(bulkNormSquare)

  def normalizedByBulk =
    this / bulkNorm

  def normSquare: Double =
    (x * x + y * y + z * z)

  def norm: Double =
    Math.sqrt(normSquare)

  def normalizedByNorm =
    this / norm

  def *(v: Double): Pga3dPlaneIdeal =
    Pga3dPlaneIdeal(
      x = v * x,
      y = v * y,
      z = v * z,
    )

  inline def /(v: Double): Pga3dPlaneIdeal =
    this * (1.0 / v)

  def +(v: Pga3dPlaneIdeal): Pga3dPlaneIdeal =
    Pga3dPlaneIdeal(
      x = (v.x + x),
      y = (v.y + y),
      z = (v.z + z),
    )

  def -(v: Pga3dPlaneIdeal): Pga3dPlaneIdeal =
    Pga3dPlaneIdeal(
      x = (x - v.x),
      y = (y - v.y),
      z = (z - v.z),
    )

  def madd(v: Pga3dPlaneIdeal, mult: Double): Pga3dPlaneIdeal =
    Pga3dPlaneIdeal(
      x = (x + mult * v.x),
      y = (y + mult * v.y),
      z = (z + mult * v.z),
    )

  def multiplyElementwise(v: Pga3dPlaneIdeal): Pga3dPlaneIdeal =
    Pga3dPlaneIdeal(
      x = v.x * x,
      y = v.y * y,
      z = v.z * z,
    )

  def toMultivector: Pga3dMultivector =
    Pga3dMultivector(
      s = 0.0,
      w = 0.0,
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

  def toPlane: Pga3dPlane =
    Pga3dPlane(
      w = 0.0,
      x = x,
      y = y,
      z = z,
    )

  infix def geometric(v: Pga3dMultivector): Pga3dMultivector =
    Pga3dMultivector(
      s = (v.x * x + v.y * y + v.z * z),
      w = (-v.wx * x - v.wy * y - v.wz * z),
      x = (v.s * x - v.xy * y - v.xz * z),
      y = (v.s * y + v.xy * x - v.yz * z),
      z = (v.s * z + v.xz * x + v.yz * y),
      wx = (v.wxy * y + v.wxz * z - v.w * x),
      wy = (v.wyz * z - v.w * y - v.wxy * x),
      wz = (-v.w * z - v.wxz * x - v.wyz * y),
      xy = (v.xyz * z + v.y * x - v.x * y),
      xz = (v.z * x - v.x * z - v.xyz * y),
      yz = (v.xyz * x + v.z * y - v.y * z),
      wxy = (v.wx * y - v.i * z - v.wy * x),
      wxz = (v.i * y + v.wx * z - v.wz * x),
      wyz = (v.wy * z - v.i * x - v.wz * y),
      xyz = (v.xy * z + v.yz * x - v.xz * y),
      i = (v.wxz * y - v.wxy * z - v.wyz * x),
    )

  infix def geometric(v: Pga3dMotor): Pga3dMultivector =
    Pga3dMultivector(
      s = 0.0,
      w = (-v.wx * x - v.wy * y - v.wz * z),
      x = (v.s * x - v.xy * y - v.xz * z),
      y = (v.s * y + v.xy * x - v.yz * z),
      z = (v.s * z + v.xz * x + v.yz * y),
      wx = 0.0,
      wy = 0.0,
      wz = 0.0,
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
      wxy = (v.wx * y - v.i * z - v.wy * x),
      wxz = (v.i * y + v.wx * z - v.wz * x),
      wyz = (v.wy * z - v.i * x - v.wz * y),
      xyz = (v.xy * z + v.yz * x - v.xz * y),
      i = 0.0,
    )

  infix def geometric(v: Pga3dPlane): Pga3dMotor =
    Pga3dMotor(
      s = (v.x * x + v.y * y + v.z * z),
      wx = -v.w * x,
      wy = -v.w * y,
      wz = -v.w * z,
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
      wxy = (v.wx * y - v.wy * x),
      wxz = (v.wx * z - v.wz * x),
      wyz = (v.wy * z - v.wz * y),
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
      i = (v.wxz * y - v.wxy * z - v.wyz * x),
    )

  infix def geometric(v: Pga3dQuaternion): Pga3dMultivector =
    Pga3dMultivector(
      s = 0.0,
      w = 0.0,
      x = (v.s * x - v.xy * y - v.xz * z),
      y = (v.s * y + v.xy * x - v.yz * z),
      z = (v.s * z + v.xz * x + v.yz * y),
      wx = 0.0,
      wy = 0.0,
      wz = 0.0,
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
      wxy = 0.0,
      wxz = 0.0,
      wyz = 0.0,
      xyz = (v.xy * z + v.yz * x - v.xz * y),
      i = 0.0,
    )

  infix def geometric(v: Pga3dTranslator): Pga3dMultivector =
    Pga3dMultivector(
      s = 0.0,
      w = (-v.wx * x - v.wy * y - v.wz * z),
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
      i = (v.wxz * y - v.wxy * z - v.wyz * x),
    )

  infix def geometric(v: Pga3dPlaneIdeal): Pga3dQuaternion =
    Pga3dQuaternion(
      s = (v.x * x + v.y * y + v.z * z),
      xy = (v.y * x - v.x * y),
      xz = (v.z * x - v.x * z),
      yz = (v.z * y - v.y * z),
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
      wxy = 0.0,
      wxz = 0.0,
      wyz = 0.0,
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

  infix def geometric(v: Pga3dPointCenter.type): Pga3dBivectorBulk =
    Pga3dBivectorBulk(
      xy = z,
      xz = -y,
      yz = x,
    )

  infix def dot(v: Pga3dMultivector): Pga3dMultivector =
    Pga3dMultivector(
      s = (v.x * x + v.y * y + v.z * z),
      w = (-v.wx * x - v.wy * y - v.wz * z),
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
      w = (-v.wx * x - v.wy * y - v.wz * z),
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

  infix def dot(v: Pga3dQuaternion): Pga3dPlaneIdeal =
    Pga3dPlaneIdeal(
      x = (v.s * x - v.xy * y - v.xz * z),
      y = (v.s * y + v.xy * x - v.yz * z),
      z = (v.s * z + v.xz * x + v.yz * y),
    )

  infix def dot(v: Pga3dTranslator): Pga3dPlane =
    Pga3dPlane(
      w = (-v.wx * x - v.wy * y - v.wz * z),
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
      w = 0.0,
      x = v.s * x,
      y = v.s * y,
      z = v.s * z,
      wx = -v.w * x,
      wy = -v.w * y,
      wz = -v.w * z,
      xy = (v.y * x - v.x * y),
      xz = (v.z * x - v.x * z),
      yz = (v.z * y - v.y * z),
      wxy = (v.wx * y - v.wy * x),
      wxz = (v.wx * z - v.wz * x),
      wyz = (v.wy * z - v.wz * y),
      xyz = (v.xy * z + v.yz * x - v.xz * y),
      i = (v.wxz * y - v.wxy * z - v.wyz * x),
    )

  inline infix def ^(v: Pga3dMultivector): Pga3dMultivector = wedge(v)

  infix def wedge(v: Pga3dMotor): Pga3dMultivector =
    Pga3dMultivector(
      s = 0.0,
      w = 0.0,
      x = v.s * x,
      y = v.s * y,
      z = v.s * z,
      wx = 0.0,
      wy = 0.0,
      wz = 0.0,
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
      wxy = (v.wx * y - v.wy * x),
      wxz = (v.wx * z - v.wz * x),
      wyz = (v.wy * z - v.wz * y),
      xyz = (v.xy * z + v.yz * x - v.xz * y),
      i = 0.0,
    )

  inline infix def ^(v: Pga3dMotor): Pga3dMultivector = wedge(v)

  infix def wedge(v: Pga3dPlane): Pga3dBivector =
    Pga3dBivector(
      wx = -v.w * x,
      wy = -v.w * y,
      wz = -v.w * z,
      xy = (v.y * x - v.x * y),
      xz = (v.z * x - v.x * z),
      yz = (v.z * y - v.y * z),
    )

  inline infix def ^(v: Pga3dPlane): Pga3dBivector = wedge(v)

  infix def wedge(v: Pga3dBivector): Pga3dPoint =
    Pga3dPoint(
      wxy = (v.wx * y - v.wy * x),
      wxz = (v.wx * z - v.wz * x),
      wyz = (v.wy * z - v.wz * y),
      xyz = (v.xy * z + v.yz * x - v.xz * y),
    )

  inline infix def ^(v: Pga3dBivector): Pga3dPoint = wedge(v)

  infix def wedge(v: Pga3dPoint): Pga3dPseudoScalar =
    Pga3dPseudoScalar(
      i = (v.wxz * y - v.wxy * z - v.wyz * x),
    )

  inline infix def ^(v: Pga3dPoint): Pga3dPseudoScalar = wedge(v)

  infix def wedge(v: Pga3dQuaternion): Pga3dMultivector =
    Pga3dMultivector(
      s = 0.0,
      w = 0.0,
      x = v.s * x,
      y = v.s * y,
      z = v.s * z,
      wx = 0.0,
      wy = 0.0,
      wz = 0.0,
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
      wxy = 0.0,
      wxz = 0.0,
      wyz = 0.0,
      xyz = (v.xy * z + v.yz * x - v.xz * y),
      i = 0.0,
    )

  inline infix def ^(v: Pga3dQuaternion): Pga3dMultivector = wedge(v)

  infix def wedge(v: Pga3dTranslator): Pga3dMultivector =
    Pga3dMultivector(
      s = 0.0,
      w = 0.0,
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
      i = (v.wxz * y - v.wxy * z - v.wyz * x),
    )

  inline infix def ^(v: Pga3dPointNormalized): Pga3dPseudoScalar = wedge(v)

  infix def wedge(v: Pga3dPlaneIdeal): Pga3dBivectorBulk =
    Pga3dBivectorBulk(
      xy = (v.y * x - v.x * y),
      xz = (v.z * x - v.x * z),
      yz = (v.z * y - v.y * z),
    )

  inline infix def ^(v: Pga3dPlaneIdeal): Pga3dBivectorBulk = wedge(v)

  infix def wedge(v: Pga3dBivectorBulk): Pga3dPoint =
    Pga3dPoint(
      wxy = 0.0,
      wxz = 0.0,
      wyz = 0.0,
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

  infix def antiGeometric(v: Pga3dMultivector): Pga3dMultivector =
    Pga3dMultivector(
      s = (v.wxy * z + v.wyz * x - v.wxz * y),
      w = 0.0,
      x = (v.i * x + v.wy * z - v.wz * y),
      y = (v.i * y + v.wz * x - v.wx * z),
      z = (v.i * z + v.wx * y - v.wy * x),
      wx = 0.0,
      wy = 0.0,
      wz = 0.0,
      xy = (v.w * z + v.wxz * x + v.wyz * y),
      xz = (v.wyz * z - v.w * y - v.wxy * x),
      yz = (v.w * x - v.wxy * y - v.wxz * z),
      wxy = 0.0,
      wxz = 0.0,
      wyz = 0.0,
      xyz = (v.wx * x + v.wy * y + v.wz * z),
      i = 0.0,
    )

  infix def antiGeometric(v: Pga3dMotor): Pga3dMultivector =
    Pga3dMultivector(
      s = 0.0,
      w = 0.0,
      x = (v.i * x + v.wy * z - v.wz * y),
      y = (v.i * y + v.wz * x - v.wx * z),
      z = (v.i * z + v.wx * y - v.wy * x),
      wx = 0.0,
      wy = 0.0,
      wz = 0.0,
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
      wxy = 0.0,
      wxz = 0.0,
      wyz = 0.0,
      xyz = (v.wx * x + v.wy * y + v.wz * z),
      i = 0.0,
    )

  infix def antiGeometric(v: Pga3dPlane): Pga3dBivectorBulk =
    Pga3dBivectorBulk(
      xy = v.w * z,
      xz = -v.w * y,
      yz = v.w * x,
    )

  infix def antiGeometric(v: Pga3dBivector): Pga3dMultivector =
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
      wxy = 0.0,
      wxz = 0.0,
      wyz = 0.0,
      xyz = (v.wx * x + v.wy * y + v.wz * z),
      i = 0.0,
    )

  infix def antiGeometric(v: Pga3dPoint): Pga3dQuaternion =
    Pga3dQuaternion(
      s = (v.wxy * z + v.wyz * x - v.wxz * y),
      xy = (v.wxz * x + v.wyz * y),
      xz = (v.wyz * z - v.wxy * x),
      yz = (-v.wxy * y - v.wxz * z),
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
      wxy = 0.0,
      wxz = 0.0,
      wyz = 0.0,
      xyz = (v.wx * x + v.wy * y + v.wz * z),
      i = 0.0,
    )

  infix def antiGeometric(v: Pga3dVector): Pga3dQuaternion =
    Pga3dQuaternion(
      s = (v.wxy * z + v.wyz * x - v.wxz * y),
      xy = (v.wxz * x + v.wyz * y),
      xz = (v.wyz * z - v.wxy * x),
      yz = (-v.wxy * y - v.wxz * z),
    )

  infix def antiGeometric(v: Pga3dPointNormalized): Pga3dQuaternion =
    Pga3dQuaternion(
      s = (v.wxy * z + v.wyz * x - v.wxz * y),
      xy = (v.wxz * x + v.wyz * y),
      xz = (v.wyz * z - v.wxy * x),
      yz = (-v.wxy * y - v.wxz * z),
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
      wxy = 0.0,
      wxz = 0.0,
      wyz = 0.0,
      xyz = (v.wx * x + v.wy * y + v.wz * z),
      i = 0.0,
    )

  infix def antiGeometric(v: Pga3dPseudoScalar): Pga3dPlaneIdeal =
    Pga3dPlaneIdeal(
      x = v.i * x,
      y = v.i * y,
      z = v.i * z,
    )

  infix def antiDot(v: Pga3dMultivector): Pga3dMultivector =
    Pga3dMultivector(
      s = 0.0,
      w = 0.0,
      x = v.i * x,
      y = v.i * y,
      z = v.i * z,
      wx = 0.0,
      wy = 0.0,
      wz = 0.0,
      xy = (v.wxz * x + v.wyz * y),
      xz = (v.wyz * z - v.wxy * x),
      yz = (-v.wxy * y - v.wxz * z),
      wxy = 0.0,
      wxz = 0.0,
      wyz = 0.0,
      xyz = (v.wx * x + v.wy * y + v.wz * z),
      i = 0.0,
    )

  infix def antiDot(v: Pga3dMotor): Pga3dMultivector =
    Pga3dMultivector(
      s = 0.0,
      w = 0.0,
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
      xyz = (v.wx * x + v.wy * y + v.wz * z),
      i = 0.0,
    )

  infix def antiDot(v: Pga3dBivector): Pga3dPoint =
    Pga3dPoint(
      wxy = 0.0,
      wxz = 0.0,
      wyz = 0.0,
      xyz = (v.wx * x + v.wy * y + v.wz * z),
    )

  infix def antiDot(v: Pga3dPoint): Pga3dBivectorBulk =
    Pga3dBivectorBulk(
      xy = (v.wxz * x + v.wyz * y),
      xz = (v.wyz * z - v.wxy * x),
      yz = (-v.wxy * y - v.wxz * z),
    )

  infix def antiDot(v: Pga3dTranslator): Pga3dPoint =
    Pga3dPoint(
      wxy = 0.0,
      wxz = 0.0,
      wyz = 0.0,
      xyz = (v.wx * x + v.wy * y + v.wz * z),
    )

  infix def antiDot(v: Pga3dVector): Pga3dBivectorBulk =
    Pga3dBivectorBulk(
      xy = (v.wxz * x + v.wyz * y),
      xz = (v.wyz * z - v.wxy * x),
      yz = (-v.wxy * y - v.wxz * z),
    )

  infix def antiDot(v: Pga3dPointNormalized): Pga3dBivectorBulk =
    Pga3dBivectorBulk(
      xy = (v.wxz * x + v.wyz * y),
      xz = (v.wyz * z - v.wxy * x),
      yz = (-v.wxy * y - v.wxz * z),
    )

  infix def antiDot(v: Pga3dBivectorWeight): Pga3dPoint =
    Pga3dPoint(
      wxy = 0.0,
      wxz = 0.0,
      wyz = 0.0,
      xyz = (v.wx * x + v.wy * y + v.wz * z),
    )

  infix def antiDot(v: Pga3dPseudoScalar): Pga3dPlaneIdeal =
    Pga3dPlaneIdeal(
      x = v.i * x,
      y = v.i * y,
      z = v.i * z,
    )

  infix def antiWedge(v: Pga3dMultivector): Pga3dMultivector =
    Pga3dMultivector(
      s = (v.wxy * z + v.wyz * x - v.wxz * y),
      w = 0.0,
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

  infix def antiWedge(v: Pga3dMotor): Pga3dPlaneIdeal =
    Pga3dPlaneIdeal(
      x = v.i * x,
      y = v.i * y,
      z = v.i * z,
    )

  inline infix def v(v: Pga3dMotor): Pga3dPlaneIdeal = antiWedge(v)

  infix def antiWedge(v: Pga3dPoint): Double =
    (v.wxy * z + v.wyz * x - v.wxz * y)

  inline infix def v(v: Pga3dPoint): Double = antiWedge(v)

  infix def antiWedge(v: Pga3dVector): Double =
    (v.wxy * z + v.wyz * x - v.wxz * y)

  inline infix def v(v: Pga3dVector): Double = antiWedge(v)

  infix def antiWedge(v: Pga3dPointNormalized): Double =
    (v.wxy * z + v.wyz * x - v.wxz * y)

  inline infix def v(v: Pga3dPointNormalized): Double = antiWedge(v)

  infix def antiWedge(v: Pga3dPseudoScalar): Pga3dPlaneIdeal =
    Pga3dPlaneIdeal(
      x = v.i * x,
      y = v.i * y,
      z = v.i * z,
    )

  inline infix def v(v: Pga3dPseudoScalar): Pga3dPlaneIdeal = antiWedge(v)

  infix def sandwich(v: Pga3dMultivector): Pga3dMultivector =
    val xMx = x * x
    val xMy = x * y
    val xMz = x * z
    val yMy = y * y
    val yMz = y * z
    val zMz = z * z
    Pga3dMultivector(
      s = v.s * (xMx + yMy + zMz),
      w = v.w * (-xMx - yMy - zMz),
      x = (2.0 * (v.y * xMy + v.z * xMz) + v.x * (xMx - yMy - zMz)),
      y = (2.0 * (v.x * xMy + v.z * yMz) + v.y * (yMy - xMx - zMz)),
      z = (2.0 * (v.x * xMz + v.y * yMz) + v.z * (zMz - xMx - yMy)),
      wx = (2.0 * (-v.wy * xMy - v.wz * xMz) + v.wx * (yMy + zMz - xMx)),
      wy = (2.0 * (-v.wx * xMy - v.wz * yMz) + v.wy * (xMx + zMz - yMy)),
      wz = (2.0 * (-v.wx * xMz - v.wy * yMz) + v.wz * (xMx + yMy - zMz)),
      xy = (2.0 * (v.yz * xMz - v.xz * yMz) + v.xy * (zMz - xMx - yMy)),
      xz = (2.0 * (-v.xy * yMz - v.yz * xMy) + v.xz * (yMy - xMx - zMz)),
      yz = (2.0 * (v.xy * xMz - v.xz * xMy) + v.yz * (xMx - yMy - zMz)),
      wxy = (2.0 * (v.wxz * yMz - v.wyz * xMz) + v.wxy * (xMx + yMy - zMz)),
      wxz = (2.0 * (v.wxy * yMz + v.wyz * xMy) + v.wxz * (xMx + zMz - yMy)),
      wyz = (2.0 * (v.wxz * xMy - v.wxy * xMz) + v.wyz * (yMy + zMz - xMx)),
      xyz = v.xyz * (xMx + yMy + zMz),
      i = v.i * (-xMx - yMy - zMz),
    )

  infix def sandwich(v: Pga3dMotor): Pga3dMotor =
    val xMx = x * x
    val xMy = x * y
    val xMz = x * z
    val yMy = y * y
    val yMz = y * z
    val zMz = z * z
    Pga3dMotor(
      s = v.s * (xMx + yMy + zMz),
      wx = (2.0 * (-v.wy * xMy - v.wz * xMz) + v.wx * (yMy + zMz - xMx)),
      wy = (2.0 * (-v.wx * xMy - v.wz * yMz) + v.wy * (xMx + zMz - yMy)),
      wz = (2.0 * (-v.wx * xMz - v.wy * yMz) + v.wz * (xMx + yMy - zMz)),
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
      w = v.w * (-xMx - yMy - zMz),
      x = (2.0 * (v.y * xMy + v.z * xMz) + v.x * (xMx - yMy - zMz)),
      y = (2.0 * (v.x * xMy + v.z * yMz) + v.y * (yMy - xMx - zMz)),
      z = (2.0 * (v.x * xMz + v.y * yMz) + v.z * (zMz - xMx - yMy)),
    )

  infix def sandwich(v: Pga3dBivector): Pga3dBivector =
    val xMx = x * x
    val xMy = x * y
    val xMz = x * z
    val yMy = y * y
    val yMz = y * z
    val zMz = z * z
    Pga3dBivector(
      wx = (2.0 * (-v.wy * xMy - v.wz * xMz) + v.wx * (yMy + zMz - xMx)),
      wy = (2.0 * (-v.wx * xMy - v.wz * yMz) + v.wy * (xMx + zMz - yMy)),
      wz = (2.0 * (-v.wx * xMz - v.wy * yMz) + v.wz * (xMx + yMy - zMz)),
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
      wxy = (2.0 * (v.wxz * yMz - v.wyz * xMz) + v.wxy * (xMx + yMy - zMz)),
      wxz = (2.0 * (v.wxy * yMz + v.wyz * xMy) + v.wxz * (xMx + zMz - yMy)),
      wyz = (2.0 * (v.wxz * xMy - v.wxy * xMz) + v.wyz * (yMy + zMz - xMx)),
      xyz = v.xyz * (xMx + yMy + zMz),
    )

  infix def sandwich(v: Pga3dQuaternion): Pga3dQuaternion =
    val xMx = x * x
    val xMy = x * y
    val xMz = x * z
    val yMy = y * y
    val yMz = y * z
    val zMz = z * z
    Pga3dQuaternion(
      s = v.s * (xMx + yMy + zMz),
      xy = (2.0 * (v.yz * xMz - v.xz * yMz) + v.xy * (zMz - xMx - yMy)),
      xz = (2.0 * (-v.xy * yMz - v.yz * xMy) + v.xz * (yMy - xMx - zMz)),
      yz = (2.0 * (v.xy * xMz - v.xz * xMy) + v.yz * (xMx - yMy - zMz)),
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
      wxy = (2.0 * (v.wxz * yMz - v.wyz * xMz) + v.wxy * (xMx + yMy - zMz)),
      wxz = (2.0 * (v.wxy * yMz + v.wyz * xMy) + v.wxz * (xMx + zMz - yMy)),
      wyz = (2.0 * (v.wxz * xMy - v.wxy * xMz) + v.wyz * (yMy + zMz - xMx)),
      xyz = (xMx + yMy + zMz),
    )

  infix def sandwich(v: Pga3dPlaneIdeal): Pga3dPlaneIdeal =
    val xMx = x * x
    val xMy = x * y
    val xMz = x * z
    val yMy = y * y
    val yMz = y * z
    val zMz = z * z
    Pga3dPlaneIdeal(
      x = (2.0 * (v.y * xMy + v.z * xMz) + v.x * (xMx - yMy - zMz)),
      y = (2.0 * (v.x * xMy + v.z * yMz) + v.y * (yMy - xMx - zMz)),
      z = (2.0 * (v.x * xMz + v.y * yMz) + v.z * (zMz - xMx - yMy)),
    )

  infix def sandwich(v: Pga3dBivectorBulk): Pga3dBivectorBulk =
    val xMx = x * x
    val xMy = x * y
    val xMz = x * z
    val yMy = y * y
    val yMz = y * z
    val zMz = z * z
    Pga3dBivectorBulk(
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
      wxy = 0.0,
      wxz = 0.0,
      wyz = 0.0,
      xyz = (x * x + y * y + z * z),
    )

  infix def reverseSandwich(v: Pga3dMultivector): Pga3dMultivector =
    val xMx = x * x
    val xMy = x * y
    val xMz = x * z
    val yMy = y * y
    val yMz = y * z
    val zMz = z * z
    Pga3dMultivector(
      s = v.s * (xMx + yMy + zMz),
      w = v.w * (-xMx - yMy - zMz),
      x = (2.0 * (v.y * xMy + v.z * xMz) + v.x * (xMx - yMy - zMz)),
      y = (2.0 * (v.x * xMy + v.z * yMz) + v.y * (yMy - xMx - zMz)),
      z = (2.0 * (v.x * xMz + v.y * yMz) + v.z * (zMz - xMx - yMy)),
      wx = (2.0 * (-v.wy * xMy - v.wz * xMz) + v.wx * (yMy + zMz - xMx)),
      wy = (2.0 * (-v.wx * xMy - v.wz * yMz) + v.wy * (xMx + zMz - yMy)),
      wz = (2.0 * (-v.wx * xMz - v.wy * yMz) + v.wz * (xMx + yMy - zMz)),
      xy = (2.0 * (v.yz * xMz - v.xz * yMz) + v.xy * (zMz - xMx - yMy)),
      xz = (2.0 * (-v.xy * yMz - v.yz * xMy) + v.xz * (yMy - xMx - zMz)),
      yz = (2.0 * (v.xy * xMz - v.xz * xMy) + v.yz * (xMx - yMy - zMz)),
      wxy = (2.0 * (v.wxz * yMz - v.wyz * xMz) + v.wxy * (xMx + yMy - zMz)),
      wxz = (2.0 * (v.wxy * yMz + v.wyz * xMy) + v.wxz * (xMx + zMz - yMy)),
      wyz = (2.0 * (v.wxz * xMy - v.wxy * xMz) + v.wyz * (yMy + zMz - xMx)),
      xyz = v.xyz * (xMx + yMy + zMz),
      i = v.i * (-xMx - yMy - zMz),
    )

  infix def reverseSandwich(v: Pga3dMotor): Pga3dMotor =
    val xMx = x * x
    val xMy = x * y
    val xMz = x * z
    val yMy = y * y
    val yMz = y * z
    val zMz = z * z
    Pga3dMotor(
      s = v.s * (xMx + yMy + zMz),
      wx = (2.0 * (-v.wy * xMy - v.wz * xMz) + v.wx * (yMy + zMz - xMx)),
      wy = (2.0 * (-v.wx * xMy - v.wz * yMz) + v.wy * (xMx + zMz - yMy)),
      wz = (2.0 * (-v.wx * xMz - v.wy * yMz) + v.wz * (xMx + yMy - zMz)),
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
      w = v.w * (-xMx - yMy - zMz),
      x = (2.0 * (v.y * xMy + v.z * xMz) + v.x * (xMx - yMy - zMz)),
      y = (2.0 * (v.x * xMy + v.z * yMz) + v.y * (yMy - xMx - zMz)),
      z = (2.0 * (v.x * xMz + v.y * yMz) + v.z * (zMz - xMx - yMy)),
    )

  infix def reverseSandwich(v: Pga3dBivector): Pga3dBivector =
    val xMx = x * x
    val xMy = x * y
    val xMz = x * z
    val yMy = y * y
    val yMz = y * z
    val zMz = z * z
    Pga3dBivector(
      wx = (2.0 * (-v.wy * xMy - v.wz * xMz) + v.wx * (yMy + zMz - xMx)),
      wy = (2.0 * (-v.wx * xMy - v.wz * yMz) + v.wy * (xMx + zMz - yMy)),
      wz = (2.0 * (-v.wx * xMz - v.wy * yMz) + v.wz * (xMx + yMy - zMz)),
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
      wxy = (2.0 * (v.wxz * yMz - v.wyz * xMz) + v.wxy * (xMx + yMy - zMz)),
      wxz = (2.0 * (v.wxy * yMz + v.wyz * xMy) + v.wxz * (xMx + zMz - yMy)),
      wyz = (2.0 * (v.wxz * xMy - v.wxy * xMz) + v.wyz * (yMy + zMz - xMx)),
      xyz = v.xyz * (xMx + yMy + zMz),
    )

  infix def reverseSandwich(v: Pga3dQuaternion): Pga3dQuaternion =
    val xMx = x * x
    val xMy = x * y
    val xMz = x * z
    val yMy = y * y
    val yMz = y * z
    val zMz = z * z
    Pga3dQuaternion(
      s = v.s * (xMx + yMy + zMz),
      xy = (2.0 * (v.yz * xMz - v.xz * yMz) + v.xy * (zMz - xMx - yMy)),
      xz = (2.0 * (-v.xy * yMz - v.yz * xMy) + v.xz * (yMy - xMx - zMz)),
      yz = (2.0 * (v.xy * xMz - v.xz * xMy) + v.yz * (xMx - yMy - zMz)),
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
      wxy = (2.0 * (v.wxz * yMz - v.wyz * xMz) + v.wxy * (xMx + yMy - zMz)),
      wxz = (2.0 * (v.wxy * yMz + v.wyz * xMy) + v.wxz * (xMx + zMz - yMy)),
      wyz = (2.0 * (v.wxz * xMy - v.wxy * xMz) + v.wyz * (yMy + zMz - xMx)),
      xyz = (xMx + yMy + zMz),
    )

  infix def reverseSandwich(v: Pga3dPlaneIdeal): Pga3dPlaneIdeal =
    val xMx = x * x
    val xMy = x * y
    val xMz = x * z
    val yMy = y * y
    val yMz = y * z
    val zMz = z * z
    Pga3dPlaneIdeal(
      x = (2.0 * (v.y * xMy + v.z * xMz) + v.x * (xMx - yMy - zMz)),
      y = (2.0 * (v.x * xMy + v.z * yMz) + v.y * (yMy - xMx - zMz)),
      z = (2.0 * (v.x * xMz + v.y * yMz) + v.z * (zMz - xMx - yMy)),
    )

  infix def reverseSandwich(v: Pga3dBivectorBulk): Pga3dBivectorBulk =
    val xMx = x * x
    val xMy = x * y
    val xMz = x * z
    val yMy = y * y
    val yMz = y * z
    val zMz = z * z
    Pga3dBivectorBulk(
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
      wxy = 0.0,
      wxz = 0.0,
      wyz = 0.0,
      xyz = (x * x + y * y + z * z),
    )

  infix def cross(v: Pga3dMultivector): Pga3dMultivector =
    Pga3dMultivector(
      s = 0.0,
      w = (-v.wx * x - v.wy * y - v.wz * z),
      x = (-v.xy * y - v.xz * z),
      y = (v.xy * x - v.yz * z),
      z = (v.xz * x + v.yz * y),
      wx = -v.w * x,
      wy = -v.w * y,
      wz = -v.w * z,
      xy = (v.y * x - v.x * y),
      xz = (v.z * x - v.x * z),
      yz = (v.z * y - v.y * z),
      wxy = -v.i * z,
      wxz = v.i * y,
      wyz = -v.i * x,
      xyz = 0.0,
      i = (v.wxz * y - v.wxy * z - v.wyz * x),
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
      wx = -v.w * x,
      wy = -v.w * y,
      wz = -v.w * z,
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
      i = (v.wxz * y - v.wxy * z - v.wyz * x),
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
      i = (v.wxz * y - v.wxy * z - v.wyz * x),
    )

  infix def cross(v: Pga3dPlaneIdeal): Pga3dBivectorBulk =
    Pga3dBivectorBulk(
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