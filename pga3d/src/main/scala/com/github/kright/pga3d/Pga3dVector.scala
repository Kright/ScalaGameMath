package com.github.kright.pga3d

/** this code is generated, see com.github.kright.pga3d.codegen.CodeGenClass */
case class Pga3dVector(x: Double = 0.0,
                       y: Double = 0.0,
                       z: Double = 0.0):

  inline def wyz: Double = -x

  inline def wxz: Double = y

  inline def wxy: Double = -z

  def dual: Pga3dPlaneIdeal =
    Pga3dPlaneIdeal(
      x = x,
      y = y,
      z = z,
    )

  def weight: Pga3dVector =
    this

  def unary_- : Pga3dVector =
    Pga3dVector(
      x = -x,
      y = -y,
      z = -z,
    )

  def reverse: Pga3dVector =
    -this

  def antiReverse: Pga3dVector =
    this

  def weightNormSquare: Double =
    (x * x + y * y + z * z)

  def weightNorm: Double =
    Math.sqrt(weightNormSquare)

  def normalizedByWeight =
    this / weightNorm

  def normSquare: Double =
    (x * x + y * y + z * z)

  def norm: Double =
    Math.sqrt(normSquare)

  def normalizedByNorm =
    this / norm

  def *(v: Double): Pga3dVector =
    Pga3dVector(
      x = v * x,
      y = v * y,
      z = v * z,
    )

  inline def /(v: Double): Pga3dVector =
    this * (1.0 / v)

  def +(v: Pga3dPoint): Pga3dPoint =
    Pga3dPoint(
      x = (v.x + x),
      y = (v.y + y),
      z = (v.z + z),
      w = v.w,
    )

  def -(v: Pga3dPoint): Pga3dPoint =
    Pga3dPoint(
      x = (x - v.x),
      y = (y - v.y),
      z = (z - v.z),
      w = -v.w,
    )

  def madd(v: Pga3dPoint, mult: Double): Pga3dPoint =
    Pga3dPoint(
      x = (x + mult * v.x),
      y = (y + mult * v.y),
      z = (z + mult * v.z),
      w = mult * v.w,
    )

  def +(v: Pga3dPointNormalized): Pga3dPointNormalized =
    Pga3dPointNormalized(
      x = (v.x + x),
      y = (v.y + y),
      z = (v.z + z),
    )

  def -(v: Pga3dPointNormalized): Pga3dPoint =
    Pga3dPoint(
      x = (x - v.x),
      y = (y - v.y),
      z = (z - v.z),
      w = -1.0,
    )

  def madd(v: Pga3dPointNormalized, mult: Double): Pga3dPoint =
    Pga3dPoint(
      x = (x + mult * v.x),
      y = (y + mult * v.y),
      z = (z + mult * v.z),
      w = mult,
    )

  def +(v: Pga3dVector): Pga3dVector =
    Pga3dVector(
      x = (v.x + x),
      y = (v.y + y),
      z = (v.z + z),
    )

  def -(v: Pga3dVector): Pga3dVector =
    Pga3dVector(
      x = (x - v.x),
      y = (y - v.y),
      z = (z - v.z),
    )

  def madd(v: Pga3dVector, mult: Double): Pga3dVector =
    Pga3dVector(
      x = (x + mult * v.x),
      y = (y + mult * v.y),
      z = (z + mult * v.z),
    )

  def multiplyElementwise(v: Pga3dVector): Pga3dVector =
    Pga3dVector(
      x = -v.x * x,
      y = v.y * y,
      z = -v.z * z,
    )

  def toMultivector: Pga3dMultivector =
    Pga3dMultivector(
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
      wxy = -z,
      wxz = y,
      wyz = -x,
      xyz = 0.0,
      i = 0.0,
    )

  def toPoint: Pga3dPoint =
    Pga3dPoint(
      x = x,
      y = y,
      z = z,
      w = 0.0,
    )

  def toPointNormalizedUnsafe: Pga3dPointNormalized =
    Pga3dPointNormalized(
      x = x,
      y = y,
      z = z,
    )

  infix def geometric(v: Pga3dMotor): Pga3dMultivector =
    Pga3dMultivector(
      s = 0.0,
      w = (v.xy * z + v.yz * x - v.xz * y),
      x = 0.0,
      y = 0.0,
      z = 0.0,
      wx = 0.0,
      wy = 0.0,
      wz = 0.0,
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
      wxy = (-v.s * z - v.xz * x - v.yz * y),
      wxz = (v.s * y + v.xy * x - v.yz * z),
      wyz = (v.xy * y + v.xz * z - v.s * x),
      xyz = 0.0,
      i = 0.0,
    )

  infix def geometric(v: Pga3dPlane): Pga3dMotor =
    Pga3dMotor(
      s = 0.0,
      wx = (v.z * y - v.y * z),
      wy = (v.x * z - v.z * x),
      wz = (v.y * x - v.x * y),
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
      i = (-v.x * x - v.y * y - v.z * z),
    )

  infix def geometric(v: Pga3dBivector): Pga3dMultivector =
    Pga3dMultivector(
      s = 0.0,
      w = (v.xy * z + v.yz * x - v.xz * y),
      x = 0.0,
      y = 0.0,
      z = 0.0,
      wx = 0.0,
      wy = 0.0,
      wz = 0.0,
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
      wxy = (-v.xz * x - v.yz * y),
      wxz = (v.xy * x - v.yz * z),
      wyz = (v.xy * y + v.xz * z),
      xyz = 0.0,
      i = 0.0,
    )

  infix def geometric(v: Pga3dPoint): Pga3dBivectorWeight =
    Pga3dBivectorWeight(
      wx = v.w * x,
      wy = v.w * y,
      wz = v.w * z,
    )

  infix def geometric(v: Pga3dQuaternion): Pga3dMultivector =
    Pga3dMultivector(
      s = 0.0,
      w = (v.xy * z + v.yz * x - v.xz * y),
      x = 0.0,
      y = 0.0,
      z = 0.0,
      wx = 0.0,
      wy = 0.0,
      wz = 0.0,
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
      wxy = (-v.s * z - v.xz * x - v.yz * y),
      wxz = (v.s * y + v.xy * x - v.yz * z),
      wyz = (v.xy * y + v.xz * z - v.s * x),
      xyz = 0.0,
      i = 0.0,
    )

  infix def geometric(v: Pga3dTranslator): Pga3dVector =
    this

  infix def geometric(v: Pga3dPointNormalized): Pga3dBivectorWeight =
    Pga3dBivectorWeight(
      wx = x,
      wy = y,
      wz = z,
    )

  infix def geometric(v: Pga3dPlaneIdeal): Pga3dMotor =
    Pga3dMotor(
      s = 0.0,
      wx = (v.z * y - v.y * z),
      wy = (v.x * z - v.z * x),
      wz = (v.y * x - v.x * y),
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
      i = (-v.x * x - v.y * y - v.z * z),
    )

  infix def geometric(v: Pga3dBivectorBulk): Pga3dMultivector =
    Pga3dMultivector(
      s = 0.0,
      w = (v.xy * z + v.yz * x - v.xz * y),
      x = 0.0,
      y = 0.0,
      z = 0.0,
      wx = 0.0,
      wy = 0.0,
      wz = 0.0,
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
      wxy = (-v.xz * x - v.yz * y),
      wxz = (v.xy * x - v.yz * z),
      wyz = (v.xy * y + v.xz * z),
      xyz = 0.0,
      i = 0.0,
    )

  infix def geometric(v: Pga3dPointCenter.type): Pga3dBivectorWeight =
    Pga3dBivectorWeight(
      wx = x,
      wy = y,
      wz = z,
    )

  infix def dot(v: Pga3dMotor): Pga3dMultivector =
    Pga3dMultivector(
      s = 0.0,
      w = (v.xy * z + v.yz * x - v.xz * y),
      x = 0.0,
      y = 0.0,
      z = 0.0,
      wx = 0.0,
      wy = 0.0,
      wz = 0.0,
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
      wxy = -v.s * z,
      wxz = v.s * y,
      wyz = -v.s * x,
      xyz = 0.0,
      i = 0.0,
    )

  infix def dot(v: Pga3dPlane): Pga3dBivectorWeight =
    Pga3dBivectorWeight(
      wx = (v.z * y - v.y * z),
      wy = (v.x * z - v.z * x),
      wz = (v.y * x - v.x * y),
    )

  infix def dot(v: Pga3dBivector): Pga3dPlane =
    Pga3dPlane(
      x = 0.0,
      y = 0.0,
      z = 0.0,
      w = (v.xy * z + v.yz * x - v.xz * y),
    )

  infix def dot(v: Pga3dQuaternion): Pga3dMultivector =
    Pga3dMultivector(
      s = 0.0,
      w = (v.xy * z + v.yz * x - v.xz * y),
      x = 0.0,
      y = 0.0,
      z = 0.0,
      wx = 0.0,
      wy = 0.0,
      wz = 0.0,
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
      wxy = -v.s * z,
      wxz = v.s * y,
      wyz = -v.s * x,
      xyz = 0.0,
      i = 0.0,
    )

  infix def dot(v: Pga3dTranslator): Pga3dVector =
    this

  infix def dot(v: Pga3dPlaneIdeal): Pga3dBivectorWeight =
    Pga3dBivectorWeight(
      wx = (v.z * y - v.y * z),
      wy = (v.x * z - v.z * x),
      wz = (v.y * x - v.x * y),
    )

  infix def dot(v: Pga3dBivectorBulk): Pga3dPlane =
    Pga3dPlane(
      x = 0.0,
      y = 0.0,
      z = 0.0,
      w = (v.xy * z + v.yz * x - v.xz * y),
    )

  infix def wedge(v: Pga3dMotor): Pga3dVector =
    Pga3dVector(
      x = v.s * x,
      y = v.s * y,
      z = v.s * z,
    )

  inline infix def ^(v: Pga3dMotor): Pga3dVector = wedge(v)

  infix def wedge(v: Pga3dPlane): Pga3dPseudoScalar =
    Pga3dPseudoScalar(
      i = (-v.x * x - v.y * y - v.z * z),
    )

  inline infix def ^(v: Pga3dPlane): Pga3dPseudoScalar = wedge(v)

  infix def wedge(v: Pga3dQuaternion): Pga3dVector =
    Pga3dVector(
      x = v.s * x,
      y = v.s * y,
      z = v.s * z,
    )

  inline infix def ^(v: Pga3dQuaternion): Pga3dVector = wedge(v)

  infix def wedge(v: Pga3dTranslator): Pga3dVector =
    this

  inline infix def ^(v: Pga3dTranslator): Pga3dVector = wedge(v)

  infix def wedge(v: Pga3dPlaneIdeal): Pga3dPseudoScalar =
    Pga3dPseudoScalar(
      i = (-v.x * x - v.y * y - v.z * z),
    )

  inline infix def ^(v: Pga3dPlaneIdeal): Pga3dPseudoScalar = wedge(v)

  infix def antiGeometric(v: Pga3dMotor): Pga3dMultivector =
    Pga3dMultivector(
      s = 0.0,
      w = (v.wx * x + v.wy * y + v.wz * z),
      x = (v.s * x + v.xy * y + v.xz * z),
      y = (v.s * y + v.yz * z - v.xy * x),
      z = (v.s * z - v.xz * x - v.yz * y),
      wx = 0.0,
      wy = 0.0,
      wz = 0.0,
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
      wxy = (v.wy * x - v.i * z - v.wx * y),
      wxz = (v.i * y + v.wz * x - v.wx * z),
      wyz = (v.wz * y - v.i * x - v.wy * z),
      xyz = (v.xz * y - v.xy * z - v.yz * x),
      i = 0.0,
    )

  infix def antiGeometric(v: Pga3dPlane): Pga3dMotor =
    Pga3dMotor(
      s = (v.x * x + v.y * y + v.z * z),
      wx = v.w * x,
      wy = v.w * y,
      wz = v.w * z,
      xy = (v.x * y - v.y * x),
      xz = (v.x * z - v.z * x),
      yz = (v.y * z - v.z * y),
      i = 0.0,
    )

  infix def antiGeometric(v: Pga3dBivector): Pga3dMultivector =
    Pga3dMultivector(
      s = 0.0,
      w = (v.wx * x + v.wy * y + v.wz * z),
      x = (v.xy * y + v.xz * z),
      y = (v.yz * z - v.xy * x),
      z = (-v.xz * x - v.yz * y),
      wx = 0.0,
      wy = 0.0,
      wz = 0.0,
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
      wxy = (v.wy * x - v.wx * y),
      wxz = (v.wz * x - v.wx * z),
      wyz = (v.wz * y - v.wy * z),
      xyz = (v.xz * y - v.xy * z - v.yz * x),
      i = 0.0,
    )

  infix def antiGeometric(v: Pga3dPoint): Pga3dMotor =
    Pga3dMotor(
      s = 0.0,
      wx = (v.z * y - v.y * z),
      wy = (v.x * z - v.z * x),
      wz = (v.y * x - v.x * y),
      xy = -v.w * z,
      xz = v.w * y,
      yz = -v.w * x,
      i = (v.x * x + v.y * y + v.z * z),
    )

  infix def antiGeometric(v: Pga3dQuaternion): Pga3dMultivector =
    Pga3dMultivector(
      s = 0.0,
      w = 0.0,
      x = (v.s * x + v.xy * y + v.xz * z),
      y = (v.s * y + v.yz * z - v.xy * x),
      z = (v.s * z - v.xz * x - v.yz * y),
      wx = 0.0,
      wy = 0.0,
      wz = 0.0,
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
      wxy = 0.0,
      wxz = 0.0,
      wyz = 0.0,
      xyz = (v.xz * y - v.xy * z - v.yz * x),
      i = 0.0,
    )

  infix def antiGeometric(v: Pga3dTranslator): Pga3dMultivector =
    Pga3dMultivector(
      s = 0.0,
      w = (v.wx * x + v.wy * y + v.wz * z),
      x = x,
      y = y,
      z = z,
      wx = 0.0,
      wy = 0.0,
      wz = 0.0,
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
      wxy = (v.wy * x - v.wx * y),
      wxz = (v.wz * x - v.wx * z),
      wyz = (v.wz * y - v.wy * z),
      xyz = 0.0,
      i = 0.0,
    )

  infix def antiGeometric(v: Pga3dVector): Pga3dMotor =
    Pga3dMotor(
      s = 0.0,
      wx = (v.z * y - v.y * z),
      wy = (v.x * z - v.z * x),
      wz = (v.y * x - v.x * y),
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
      i = (v.x * x + v.y * y + v.z * z),
    )

  infix def antiGeometric(v: Pga3dPointNormalized): Pga3dMotor =
    Pga3dMotor(
      s = 0.0,
      wx = (v.z * y - v.y * z),
      wy = (v.x * z - v.z * x),
      wz = (v.y * x - v.x * y),
      xy = -z,
      xz = y,
      yz = -x,
      i = (v.x * x + v.y * y + v.z * z),
    )

  infix def antiGeometric(v: Pga3dPlaneIdeal): Pga3dQuaternion =
    Pga3dQuaternion(
      s = (v.x * x + v.y * y + v.z * z),
      xy = (v.x * y - v.y * x),
      xz = (v.x * z - v.z * x),
      yz = (v.y * z - v.z * y),
    )

  infix def antiGeometric(v: Pga3dBivectorBulk): Pga3dMultivector =
    Pga3dMultivector(
      s = 0.0,
      w = 0.0,
      x = (v.xy * y + v.xz * z),
      y = (v.yz * z - v.xy * x),
      z = (-v.xz * x - v.yz * y),
      wx = 0.0,
      wy = 0.0,
      wz = 0.0,
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
      wxy = 0.0,
      wxz = 0.0,
      wyz = 0.0,
      xyz = (v.xz * y - v.xy * z - v.yz * x),
      i = 0.0,
    )

  infix def antiGeometric(v: Pga3dBivectorWeight): Pga3dMultivector =
    Pga3dMultivector(
      s = 0.0,
      w = (v.wx * x + v.wy * y + v.wz * z),
      x = 0.0,
      y = 0.0,
      z = 0.0,
      wx = 0.0,
      wy = 0.0,
      wz = 0.0,
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
      wxy = (v.wy * x - v.wx * y),
      wxz = (v.wz * x - v.wx * z),
      wyz = (v.wz * y - v.wy * z),
      xyz = 0.0,
      i = 0.0,
    )

  infix def antiGeometric(v: Pga3dPseudoScalar): Pga3dVector =
    Pga3dVector(
      x = v.i * x,
      y = v.i * y,
      z = v.i * z,
    )

  infix def antiGeometric(v: Pga3dPointCenter.type): Pga3dBivectorBulk =
    Pga3dBivectorBulk(
      xy = -z,
      xz = y,
      yz = -x,
    )

  infix def antiDot(v: Pga3dMotor): Pga3dMultivector =
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
      wxy = (v.wy * x - v.i * z - v.wx * y),
      wxz = (v.i * y + v.wz * x - v.wx * z),
      wyz = (v.wz * y - v.i * x - v.wy * z),
      xyz = (v.xz * y - v.xy * z - v.yz * x),
      i = 0.0,
    )

  infix def antiDot(v: Pga3dPlane): Pga3dBivector =
    Pga3dBivector(
      wx = v.w * x,
      wy = v.w * y,
      wz = v.w * z,
      xy = (v.x * y - v.y * x),
      xz = (v.x * z - v.z * x),
      yz = (v.y * z - v.z * y),
    )

  infix def antiDot(v: Pga3dBivector): Pga3dPoint =
    Pga3dPoint(
      x = (v.wy * z - v.wz * y),
      y = (v.wz * x - v.wx * z),
      z = (v.wx * y - v.wy * x),
      w = (v.xz * y - v.xy * z - v.yz * x),
    )

  infix def antiDot(v: Pga3dPoint): Pga3dPseudoScalar =
    Pga3dPseudoScalar(
      i = (v.x * x + v.y * y + v.z * z),
    )

  infix def antiDot(v: Pga3dQuaternion): Pga3dMultivector =
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
      xyz = (v.xz * y - v.xy * z - v.yz * x),
      i = 0.0,
    )

  infix def antiDot(v: Pga3dTranslator): Pga3dMultivector =
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
      wxy = (v.wy * x - v.wx * y),
      wxz = (v.wz * x - v.wx * z),
      wyz = (v.wz * y - v.wy * z),
      xyz = 0.0,
      i = 0.0,
    )

  infix def antiDot(v: Pga3dVector): Pga3dPseudoScalar =
    Pga3dPseudoScalar(
      i = (v.x * x + v.y * y + v.z * z),
    )

  infix def antiDot(v: Pga3dPointNormalized): Pga3dPseudoScalar =
    Pga3dPseudoScalar(
      i = (v.x * x + v.y * y + v.z * z),
    )

  infix def antiDot(v: Pga3dPlaneIdeal): Pga3dBivectorBulk =
    Pga3dBivectorBulk(
      xy = (v.x * y - v.y * x),
      xz = (v.x * z - v.z * x),
      yz = (v.y * z - v.z * y),
    )

  infix def antiDot(v: Pga3dBivectorBulk): Pga3dPoint =
    Pga3dPoint(
      x = 0.0,
      y = 0.0,
      z = 0.0,
      w = (v.xz * y - v.xy * z - v.yz * x),
    )

  infix def antiDot(v: Pga3dBivectorWeight): Pga3dVector =
    Pga3dVector(
      x = (v.wy * z - v.wz * y),
      y = (v.wz * x - v.wx * z),
      z = (v.wx * y - v.wy * x),
    )

  infix def antiDot(v: Pga3dPseudoScalar): Pga3dVector =
    Pga3dVector(
      x = v.i * x,
      y = v.i * y,
      z = v.i * z,
    )

  infix def antiWedge(v: Pga3dMotor): Pga3dMultivector =
    Pga3dMultivector(
      s = 0.0,
      w = (v.wx * x + v.wy * y + v.wz * z),
      x = (v.xy * y + v.xz * z),
      y = (v.yz * z - v.xy * x),
      z = (-v.xz * x - v.yz * y),
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

  inline infix def v(v: Pga3dMotor): Pga3dMultivector = antiWedge(v)

  infix def antiWedge(v: Pga3dPlane): Double =
    (v.x * x + v.y * y + v.z * z)

  inline infix def v(v: Pga3dPlane): Double = antiWedge(v)

  infix def antiWedge(v: Pga3dBivector): Pga3dPlane =
    Pga3dPlane(
      x = (v.xy * y + v.xz * z),
      y = (v.yz * z - v.xy * x),
      z = (-v.xz * x - v.yz * y),
      w = (v.wx * x + v.wy * y + v.wz * z),
    )

  inline infix def v(v: Pga3dBivector): Pga3dPlane = antiWedge(v)

  infix def antiWedge(v: Pga3dPoint): Pga3dBivector =
    Pga3dBivector(
      wx = (v.z * y - v.y * z),
      wy = (v.x * z - v.z * x),
      wz = (v.y * x - v.x * y),
      xy = -v.w * z,
      xz = v.w * y,
      yz = -v.w * x,
    )

  inline infix def v(v: Pga3dPoint): Pga3dBivector = antiWedge(v)

  infix def antiWedge(v: Pga3dQuaternion): Pga3dPlaneIdeal =
    Pga3dPlaneIdeal(
      x = (v.xy * y + v.xz * z),
      y = (v.yz * z - v.xy * x),
      z = (-v.xz * x - v.yz * y),
    )

  inline infix def v(v: Pga3dQuaternion): Pga3dPlaneIdeal = antiWedge(v)

  infix def antiWedge(v: Pga3dTranslator): Pga3dPlane =
    Pga3dPlane(
      x = 0.0,
      y = 0.0,
      z = 0.0,
      w = (v.wx * x + v.wy * y + v.wz * z),
    )

  inline infix def v(v: Pga3dTranslator): Pga3dPlane = antiWedge(v)

  infix def antiWedge(v: Pga3dVector): Pga3dBivectorWeight =
    Pga3dBivectorWeight(
      wx = (v.z * y - v.y * z),
      wy = (v.x * z - v.z * x),
      wz = (v.y * x - v.x * y),
    )

  inline infix def v(v: Pga3dVector): Pga3dBivectorWeight = antiWedge(v)

  infix def antiWedge(v: Pga3dPointNormalized): Pga3dBivector =
    Pga3dBivector(
      wx = (v.z * y - v.y * z),
      wy = (v.x * z - v.z * x),
      wz = (v.y * x - v.x * y),
      xy = -z,
      xz = y,
      yz = -x,
    )

  inline infix def v(v: Pga3dPointNormalized): Pga3dBivector = antiWedge(v)

  infix def antiWedge(v: Pga3dPlaneIdeal): Double =
    (v.x * x + v.y * y + v.z * z)

  inline infix def v(v: Pga3dPlaneIdeal): Double = antiWedge(v)

  infix def antiWedge(v: Pga3dBivectorBulk): Pga3dPlaneIdeal =
    Pga3dPlaneIdeal(
      x = (v.xy * y + v.xz * z),
      y = (v.yz * z - v.xy * x),
      z = (-v.xz * x - v.yz * y),
    )

  inline infix def v(v: Pga3dBivectorBulk): Pga3dPlaneIdeal = antiWedge(v)

  infix def antiWedge(v: Pga3dBivectorWeight): Pga3dPlane =
    Pga3dPlane(
      x = 0.0,
      y = 0.0,
      z = 0.0,
      w = (v.wx * x + v.wy * y + v.wz * z),
    )

  inline infix def v(v: Pga3dBivectorWeight): Pga3dPlane = antiWedge(v)

  infix def antiWedge(v: Pga3dPseudoScalar): Pga3dVector =
    Pga3dVector(
      x = v.i * x,
      y = v.i * y,
      z = v.i * z,
    )

  inline infix def v(v: Pga3dPseudoScalar): Pga3dVector = antiWedge(v)

  infix def antiWedge(v: Pga3dPointCenter.type): Pga3dBivectorBulk =
    Pga3dBivectorBulk(
      xy = -z,
      xz = y,
      yz = -x,
    )

  inline infix def v(v: Pga3dPointCenter.type): Pga3dBivectorBulk = antiWedge(v)

  infix def cross(v: Pga3dMotor): Pga3dVector =
    Pga3dVector(
      x = (-v.xy * y - v.xz * z),
      y = (v.xy * x - v.yz * z),
      z = (v.xz * x + v.yz * y),
    )

  infix def cross(v: Pga3dPlane): Pga3dPseudoScalar =
    Pga3dPseudoScalar(
      i = (-v.x * x - v.y * y - v.z * z),
    )

  infix def cross(v: Pga3dBivector): Pga3dVector =
    Pga3dVector(
      x = (-v.xy * y - v.xz * z),
      y = (v.xy * x - v.yz * z),
      z = (v.xz * x + v.yz * y),
    )

  infix def cross(v: Pga3dPoint): Pga3dBivectorWeight =
    Pga3dBivectorWeight(
      wx = v.w * x,
      wy = v.w * y,
      wz = v.w * z,
    )

  infix def cross(v: Pga3dQuaternion): Pga3dVector =
    Pga3dVector(
      x = (-v.xy * y - v.xz * z),
      y = (v.xy * x - v.yz * z),
      z = (v.xz * x + v.yz * y),
    )

  infix def cross(v: Pga3dPointNormalized): Pga3dBivectorWeight =
    Pga3dBivectorWeight(
      wx = x,
      wy = y,
      wz = z,
    )

  infix def cross(v: Pga3dPlaneIdeal): Pga3dPseudoScalar =
    Pga3dPseudoScalar(
      i = (-v.x * x - v.y * y - v.z * z),
    )

  infix def cross(v: Pga3dBivectorBulk): Pga3dVector =
    Pga3dVector(
      x = (-v.xy * y - v.xz * z),
      y = (v.xy * x - v.yz * z),
      z = (v.xz * x + v.yz * y),
    )

  infix def cross(v: Pga3dPointCenter.type): Pga3dBivectorWeight =
    Pga3dBivectorWeight(
      wx = x,
      wy = y,
      wz = z,
    )


object Pga3dVector:

  inline val componentsCount = 3

  def blade3(wxy: Double, wxz: Double, wyz: Double): Pga3dVector =
    Pga3dVector(
      x = -wyz,
      y = wxz,
      z = -wxy,
    )