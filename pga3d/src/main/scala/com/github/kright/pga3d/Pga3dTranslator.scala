package com.github.kright.pga3d

/** this code is generated, see com.github.kright.pga3d.codegen.CodeGenClass */
case class Pga3dTranslator(wx: Double = 0.0,
                           wy: Double = 0.0,
                           wz: Double = 0.0):
  inline val s = 1.0

  def dual: Pga3dMotor =
    Pga3dMotor(
      s = 0.0,
      wx = 0.0,
      wy = 0.0,
      wz = 0.0,
      xy = wz,
      xz = -wy,
      yz = wx,
      i = 1.0,
    )

  def weight: Pga3dBivectorWeight =
    Pga3dBivectorWeight(
      wx = wx,
      wy = wy,
      wz = wz,
    )

  def bulk: Double =
    1.0

  def unary_- : Pga3dMotor =
    Pga3dMotor(
      s = -1.0,
      wx = -wx,
      wy = -wy,
      wz = -wz,
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
      i = 0.0,
    )

  def reverse: Pga3dTranslator =
    Pga3dTranslator(
      wx = -wx,
      wy = -wy,
      wz = -wz,
    )

  def antiReverse: Pga3dTranslator =
    Pga3dTranslator(
      wx = -wx,
      wy = -wy,
      wz = -wz,
    )

  def bulkNormSquare: Double =
    1.0

  def bulkNorm: Double =
    Math.sqrt(bulkNormSquare)

  def normalizedByBulk =
    this / bulkNorm

  def weightNormSquare: Double =
    (wx * wx + wy * wy + wz * wz)

  def weightNorm: Double =
    Math.sqrt(weightNormSquare)

  def normalizedByWeight =
    this / weightNorm

  def normSquare: Double =
    (1.0 + wx * wx + wy * wy + wz * wz)

  def norm: Double =
    Math.sqrt(normSquare)

  def normalizedByNorm =
    this / norm

  def *(v: Double): Pga3dMotor =
    Pga3dMotor(
      s = v,
      wx = v * wx,
      wy = v * wy,
      wz = v * wz,
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
      i = 0.0,
    )

  inline def /(v: Double): Pga3dMotor =
    this * (1.0 / v)

  def +(v: Pga3dTranslator): Pga3dMotor =
    Pga3dMotor(
      s = 2.0,
      wx = (v.wx + wx),
      wy = (v.wy + wy),
      wz = (v.wz + wz),
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
      i = 0.0,
    )

  def -(v: Pga3dTranslator): Pga3dBivectorWeight =
    Pga3dBivectorWeight(
      wx = (wx - v.wx),
      wy = (wy - v.wy),
      wz = (wz - v.wz),
    )

  def madd(v: Pga3dTranslator, mult: Double): Pga3dMotor =
    Pga3dMotor(
      s = (1.0 + mult),
      wx = (wx + mult * v.wx),
      wy = (wy + mult * v.wy),
      wz = (wz + mult * v.wz),
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
      i = 0.0,
    )

  def multiplyElementwise(v: Pga3dTranslator): Pga3dTranslator =
    Pga3dTranslator(
      wx = v.wx * wx,
      wy = v.wy * wy,
      wz = v.wz * wz,
    )

  def log(): Pga3dBivectorWeight =
    Pga3dBivectorWeight(
      wx = wx,
      wy = wy,
      wz = wz,
    )

  def toMultivector: Pga3dMultivector =
    Pga3dMultivector(
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

  def toMotor: Pga3dMotor =
    Pga3dMotor(
      s = 1.0,
      wx = wx,
      wy = wy,
      wz = wz,
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
      i = 0.0,
    )

  def asBivectorUnsafe: Pga3dBivector =
    Pga3dBivector(
      wx = wx,
      wy = wy,
      wz = wz,
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
    )

  def asQuaternionUnsafe: Pga3dQuaternion =
    Pga3dQuaternion(
      s = 1.0,
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
    )

  def asBivectorWeightUnsafe: Pga3dBivectorWeight =
    Pga3dBivectorWeight(
      wx = wx,
      wy = wy,
      wz = wz,
    )

  infix def geometric(v: Pga3dMotor): Pga3dMotor =
    Pga3dMotor(
      s = v.s,
      wx = (v.wx + v.s * wx - v.xy * wy - v.xz * wz),
      wy = (v.wy + v.s * wy + v.xy * wx - v.yz * wz),
      wz = (v.wz + v.s * wz + v.xz * wx + v.yz * wy),
      xy = v.xy,
      xz = v.xz,
      yz = v.yz,
      i = (v.i + v.xy * wz + v.yz * wx - v.xz * wy),
    )

  infix def geometric(v: Pga3dPlane): Pga3dMultivector =
    Pga3dMultivector(
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

  infix def geometric(v: Pga3dBivector): Pga3dMotor =
    Pga3dMotor(
      s = 0.0,
      wx = (v.wx - v.xy * wy - v.xz * wz),
      wy = (v.wy + v.xy * wx - v.yz * wz),
      wz = (v.wz + v.xz * wx + v.yz * wy),
      xy = v.xy,
      xz = v.xz,
      yz = v.yz,
      i = (v.xy * wz + v.yz * wx - v.xz * wy),
    )

  infix def geometric(v: Pga3dPoint): Pga3dPoint =
    Pga3dPoint(
      wxy = (v.wxy + v.xyz * wz),
      wxz = (v.wxz - v.xyz * wy),
      wyz = (v.wyz + v.xyz * wx),
      xyz = v.xyz,
    )

  infix def geometric(v: Pga3dQuaternion): Pga3dMotor =
    Pga3dMotor(
      s = v.s,
      wx = (v.s * wx - v.xy * wy - v.xz * wz),
      wy = (v.s * wy + v.xy * wx - v.yz * wz),
      wz = (v.s * wz + v.xz * wx + v.yz * wy),
      xy = v.xy,
      xz = v.xz,
      yz = v.yz,
      i = (v.xy * wz + v.yz * wx - v.xz * wy),
    )

  infix def geometric(v: Pga3dTranslator): Pga3dTranslator =
    Pga3dTranslator(
      wx = (v.wx + wx),
      wy = (v.wy + wy),
      wz = (v.wz + wz),
    )

  infix def geometric(v: Pga3dVector): Pga3dVector =
    v

  infix def geometric(v: Pga3dPointNormalized): Pga3dPointNormalized =
    Pga3dPointNormalized(
      wxy = (v.wxy + wz),
      wxz = (v.wxz - wy),
      wyz = (v.wyz + wx),
    )

  infix def geometric(v: Pga3dPlaneIdeal): Pga3dMultivector =
    Pga3dMultivector(
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

  infix def geometric(v: Pga3dBivectorBulk): Pga3dMotor =
    Pga3dMotor(
      s = 0.0,
      wx = (-v.xy * wy - v.xz * wz),
      wy = (v.xy * wx - v.yz * wz),
      wz = (v.xz * wx + v.yz * wy),
      xy = v.xy,
      xz = v.xz,
      yz = v.yz,
      i = (v.xy * wz + v.yz * wx - v.xz * wy),
    )

  infix def geometric(v: Pga3dBivectorWeight): Pga3dBivectorWeight =
    v

  infix def geometric(v: Pga3dPseudoScalar): Pga3dPseudoScalar =
    v

  infix def geometric(v: Pga3dPointCenter.type): Pga3dPointNormalized =
    Pga3dPointNormalized(
      wxy = wz,
      wxz = -wy,
      wyz = wx,
    )

  infix def dot(v: Pga3dMotor): Pga3dMotor =
    Pga3dMotor(
      s = v.s,
      wx = (v.wx + v.s * wx),
      wy = (v.wy + v.s * wy),
      wz = (v.wz + v.s * wz),
      xy = v.xy,
      xz = v.xz,
      yz = v.yz,
      i = v.i,
    )

  infix def dot(v: Pga3dPlane): Pga3dPlane =
    Pga3dPlane(
      w = (v.w + v.x * wx + v.y * wy + v.z * wz),
      x = v.x,
      y = v.y,
      z = v.z,
    )

  infix def dot(v: Pga3dBivector): Pga3dBivector =
    v

  infix def dot(v: Pga3dPoint): Pga3dPoint =
    v

  infix def dot(v: Pga3dQuaternion): Pga3dMotor =
    Pga3dMotor(
      s = v.s,
      wx = v.s * wx,
      wy = v.s * wy,
      wz = v.s * wz,
      xy = v.xy,
      xz = v.xz,
      yz = v.yz,
      i = 0.0,
    )

  infix def dot(v: Pga3dTranslator): Pga3dTranslator =
    Pga3dTranslator(
      wx = (v.wx + wx),
      wy = (v.wy + wy),
      wz = (v.wz + wz),
    )

  infix def dot(v: Pga3dVector): Pga3dVector =
    v

  infix def dot(v: Pga3dPointNormalized): Pga3dPointNormalized =
    v

  infix def dot(v: Pga3dPlaneIdeal): Pga3dPlane =
    Pga3dPlane(
      w = (v.x * wx + v.y * wy + v.z * wz),
      x = v.x,
      y = v.y,
      z = v.z,
    )

  infix def dot(v: Pga3dBivectorBulk): Pga3dBivectorBulk =
    v

  infix def dot(v: Pga3dBivectorWeight): Pga3dBivectorWeight =
    v

  infix def dot(v: Pga3dPseudoScalar): Pga3dPseudoScalar =
    v

  infix def dot(v: Pga3dPointCenter.type): Pga3dPointCenter.type =
    v

  infix def wedge(v: Pga3dMotor): Pga3dMotor =
    Pga3dMotor(
      s = v.s,
      wx = (v.wx + v.s * wx),
      wy = (v.wy + v.s * wy),
      wz = (v.wz + v.s * wz),
      xy = v.xy,
      xz = v.xz,
      yz = v.yz,
      i = (v.i + v.xy * wz + v.yz * wx - v.xz * wy),
    )

  inline infix def ^(v: Pga3dMotor): Pga3dMotor = wedge(v)

  infix def wedge(v: Pga3dPlane): Pga3dMultivector =
    Pga3dMultivector(
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

  inline infix def ^(v: Pga3dPlane): Pga3dMultivector = wedge(v)

  infix def wedge(v: Pga3dBivector): Pga3dMotor =
    Pga3dMotor(
      s = 0.0,
      wx = v.wx,
      wy = v.wy,
      wz = v.wz,
      xy = v.xy,
      xz = v.xz,
      yz = v.yz,
      i = (v.xy * wz + v.yz * wx - v.xz * wy),
    )

  inline infix def ^(v: Pga3dBivector): Pga3dMotor = wedge(v)

  infix def wedge(v: Pga3dPoint): Pga3dPoint =
    v

  inline infix def ^(v: Pga3dPoint): Pga3dPoint = wedge(v)

  infix def wedge(v: Pga3dQuaternion): Pga3dMotor =
    Pga3dMotor(
      s = v.s,
      wx = v.s * wx,
      wy = v.s * wy,
      wz = v.s * wz,
      xy = v.xy,
      xz = v.xz,
      yz = v.yz,
      i = (v.xy * wz + v.yz * wx - v.xz * wy),
    )

  inline infix def ^(v: Pga3dQuaternion): Pga3dMotor = wedge(v)

  infix def wedge(v: Pga3dTranslator): Pga3dTranslator =
    Pga3dTranslator(
      wx = (v.wx + wx),
      wy = (v.wy + wy),
      wz = (v.wz + wz),
    )

  inline infix def ^(v: Pga3dTranslator): Pga3dTranslator = wedge(v)

  infix def wedge(v: Pga3dVector): Pga3dVector =
    v

  inline infix def ^(v: Pga3dVector): Pga3dVector = wedge(v)

  infix def wedge(v: Pga3dPointNormalized): Pga3dPointNormalized =
    v

  inline infix def ^(v: Pga3dPointNormalized): Pga3dPointNormalized = wedge(v)

  infix def wedge(v: Pga3dPlaneIdeal): Pga3dMultivector =
    Pga3dMultivector(
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

  inline infix def ^(v: Pga3dPlaneIdeal): Pga3dMultivector = wedge(v)

  infix def wedge(v: Pga3dBivectorBulk): Pga3dMotor =
    Pga3dMotor(
      s = 0.0,
      wx = 0.0,
      wy = 0.0,
      wz = 0.0,
      xy = v.xy,
      xz = v.xz,
      yz = v.yz,
      i = (v.xy * wz + v.yz * wx - v.xz * wy),
    )

  inline infix def ^(v: Pga3dBivectorBulk): Pga3dMotor = wedge(v)

  infix def wedge(v: Pga3dBivectorWeight): Pga3dBivectorWeight =
    v

  inline infix def ^(v: Pga3dBivectorWeight): Pga3dBivectorWeight = wedge(v)

  infix def wedge(v: Pga3dPseudoScalar): Pga3dPseudoScalar =
    v

  inline infix def ^(v: Pga3dPseudoScalar): Pga3dPseudoScalar = wedge(v)

  infix def wedge(v: Pga3dPointCenter.type): Pga3dPointCenter.type =
    v

  inline infix def ^(v: Pga3dPointCenter.type): Pga3dPointCenter.type = wedge(v)

  infix def antiGeometric(v: Pga3dMotor): Pga3dMotor =
    Pga3dMotor(
      s = (v.i + v.xy * wz + v.yz * wx - v.xz * wy),
      wx = (v.i * wx + v.wy * wz - v.wz * wy),
      wy = (v.i * wy + v.wz * wx - v.wx * wz),
      wz = (v.i * wz + v.wx * wy - v.wy * wx),
      xy = (-v.wz + v.xz * wx + v.yz * wy - v.s * wz),
      xz = (v.wy + v.s * wy + v.yz * wz - v.xy * wx),
      yz = (-v.wx - v.s * wx - v.xy * wy - v.xz * wz),
      i = (-v.wx * wx - v.wy * wy - v.wz * wz),
    )

  infix def antiGeometric(v: Pga3dPlane): Pga3dMultivector =
    Pga3dMultivector(
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

  infix def antiGeometric(v: Pga3dBivector): Pga3dMotor =
    Pga3dMotor(
      s = (v.xy * wz + v.yz * wx - v.xz * wy),
      wx = (v.wy * wz - v.wz * wy),
      wy = (v.wz * wx - v.wx * wz),
      wz = (v.wx * wy - v.wy * wx),
      xy = (-v.wz + v.xz * wx + v.yz * wy),
      xz = (v.wy + v.yz * wz - v.xy * wx),
      yz = (-v.wx - v.xy * wy - v.xz * wz),
      i = (-v.wx * wx - v.wy * wy - v.wz * wz),
    )

  infix def antiGeometric(v: Pga3dPoint): Pga3dMultivector =
    Pga3dMultivector(
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

  infix def antiGeometric(v: Pga3dQuaternion): Pga3dQuaternion =
    Pga3dQuaternion(
      s = (v.xy * wz + v.yz * wx - v.xz * wy),
      xy = (v.xz * wx + v.yz * wy - v.s * wz),
      xz = (v.s * wy + v.yz * wz - v.xy * wx),
      yz = (-v.s * wx - v.xy * wy - v.xz * wz),
    )

  infix def antiGeometric(v: Pga3dTranslator): Pga3dMotor =
    Pga3dMotor(
      s = 0.0,
      wx = (v.wy * wz - v.wz * wy),
      wy = (v.wz * wx - v.wx * wz),
      wz = (v.wx * wy - v.wy * wx),
      xy = (-v.wz - wz),
      xz = (v.wy + wy),
      yz = (-v.wx - wx),
      i = (-v.wx * wx - v.wy * wy - v.wz * wz),
    )

  infix def antiGeometric(v: Pga3dVector): Pga3dMultivector =
    Pga3dMultivector(
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

  infix def antiGeometric(v: Pga3dPointNormalized): Pga3dMultivector =
    Pga3dMultivector(
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

  infix def antiGeometric(v: Pga3dPlaneIdeal): Pga3dMultivector =
    Pga3dMultivector(
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

  infix def antiGeometric(v: Pga3dBivectorBulk): Pga3dQuaternion =
    Pga3dQuaternion(
      s = (v.xy * wz + v.yz * wx - v.xz * wy),
      xy = (v.xz * wx + v.yz * wy),
      xz = (v.yz * wz - v.xy * wx),
      yz = (-v.xy * wy - v.xz * wz),
    )

  infix def antiGeometric(v: Pga3dBivectorWeight): Pga3dMotor =
    Pga3dMotor(
      s = 0.0,
      wx = (v.wy * wz - v.wz * wy),
      wy = (v.wz * wx - v.wx * wz),
      wz = (v.wx * wy - v.wy * wx),
      xy = -v.wz,
      xz = v.wy,
      yz = -v.wx,
      i = (-v.wx * wx - v.wy * wy - v.wz * wz),
    )

  infix def antiGeometric(v: Pga3dPseudoScalar): Pga3dMotor =
    Pga3dMotor(
      s = v.i,
      wx = v.i * wx,
      wy = v.i * wy,
      wz = v.i * wz,
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
      i = 0.0,
    )

  infix def antiGeometric(v: Pga3dPointCenter.type): Pga3dPlaneIdeal =
    Pga3dPlaneIdeal(
      x = -wx,
      y = -wy,
      z = -wz,
    )

  infix def antiDot(v: Pga3dMotor): Pga3dMotor =
    Pga3dMotor(
      s = v.i,
      wx = v.i * wx,
      wy = v.i * wy,
      wz = v.i * wz,
      xy = (-v.wz - v.s * wz),
      xz = (v.wy + v.s * wy),
      yz = (-v.wx - v.s * wx),
      i = (-v.wx * wx - v.wy * wy - v.wz * wz),
    )

  infix def antiDot(v: Pga3dPlane): Pga3dPoint =
    Pga3dPoint(
      wxy = v.w * wz,
      wxz = -v.w * wy,
      wyz = v.w * wx,
      xyz = (-v.w + v.x * wx + v.y * wy + v.z * wz),
    )

  infix def antiDot(v: Pga3dBivector): Pga3dMotor =
    Pga3dMotor(
      s = 0.0,
      wx = 0.0,
      wy = 0.0,
      wz = 0.0,
      xy = -v.wz,
      xz = v.wy,
      yz = -v.wx,
      i = (-v.wx * wx - v.wy * wy - v.wz * wz),
    )

  infix def antiDot(v: Pga3dPoint): Pga3dMultivector =
    Pga3dMultivector(
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

  infix def antiDot(v: Pga3dQuaternion): Pga3dBivectorBulk =
    Pga3dBivectorBulk(
      xy = -v.s * wz,
      xz = v.s * wy,
      yz = -v.s * wx,
    )

  infix def antiDot(v: Pga3dTranslator): Pga3dMotor =
    Pga3dMotor(
      s = 0.0,
      wx = 0.0,
      wy = 0.0,
      wz = 0.0,
      xy = (-v.wz - wz),
      xz = (v.wy + wy),
      yz = (-v.wx - wx),
      i = (-v.wx * wx - v.wy * wy - v.wz * wz),
    )

  infix def antiDot(v: Pga3dVector): Pga3dMultivector =
    Pga3dMultivector(
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

  infix def antiDot(v: Pga3dPointNormalized): Pga3dMultivector =
    Pga3dMultivector(
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

  infix def antiDot(v: Pga3dPlaneIdeal): Pga3dPoint =
    Pga3dPoint(
      wxy = 0.0,
      wxz = 0.0,
      wyz = 0.0,
      xyz = (v.x * wx + v.y * wy + v.z * wz),
    )

  infix def antiDot(v: Pga3dBivectorWeight): Pga3dMotor =
    Pga3dMotor(
      s = 0.0,
      wx = 0.0,
      wy = 0.0,
      wz = 0.0,
      xy = -v.wz,
      xz = v.wy,
      yz = -v.wx,
      i = (-v.wx * wx - v.wy * wy - v.wz * wz),
    )

  infix def antiDot(v: Pga3dPseudoScalar): Pga3dMotor =
    Pga3dMotor(
      s = v.i,
      wx = v.i * wx,
      wy = v.i * wy,
      wz = v.i * wz,
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
      i = 0.0,
    )

  infix def antiWedge(v: Pga3dMotor): Pga3dMotor =
    Pga3dMotor(
      s = (v.i + v.xy * wz + v.yz * wx - v.xz * wy),
      wx = v.i * wx,
      wy = v.i * wy,
      wz = v.i * wz,
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
      i = 0.0,
    )

  inline infix def v(v: Pga3dMotor): Pga3dMotor = antiWedge(v)

  infix def antiWedge(v: Pga3dBivector): Double =
    (v.xy * wz + v.yz * wx - v.xz * wy)

  inline infix def v(v: Pga3dBivector): Double = antiWedge(v)

  infix def antiWedge(v: Pga3dPoint): Pga3dPlane =
    Pga3dPlane(
      w = (v.wxz * wy - v.wxy * wz - v.wyz * wx),
      x = -v.xyz * wx,
      y = -v.xyz * wy,
      z = -v.xyz * wz,
    )

  inline infix def v(v: Pga3dPoint): Pga3dPlane = antiWedge(v)

  infix def antiWedge(v: Pga3dQuaternion): Double =
    (v.xy * wz + v.yz * wx - v.xz * wy)

  inline infix def v(v: Pga3dQuaternion): Double = antiWedge(v)

  infix def antiWedge(v: Pga3dVector): Pga3dPlane =
    Pga3dPlane(
      w = (v.wxz * wy - v.wxy * wz - v.wyz * wx),
      x = 0.0,
      y = 0.0,
      z = 0.0,
    )

  inline infix def v(v: Pga3dVector): Pga3dPlane = antiWedge(v)

  infix def antiWedge(v: Pga3dPointNormalized): Pga3dPlane =
    Pga3dPlane(
      w = (v.wxz * wy - v.wxy * wz - v.wyz * wx),
      x = -wx,
      y = -wy,
      z = -wz,
    )

  inline infix def v(v: Pga3dPointNormalized): Pga3dPlane = antiWedge(v)

  infix def antiWedge(v: Pga3dBivectorBulk): Double =
    (v.xy * wz + v.yz * wx - v.xz * wy)

  inline infix def v(v: Pga3dBivectorBulk): Double = antiWedge(v)

  infix def antiWedge(v: Pga3dPseudoScalar): Pga3dMotor =
    Pga3dMotor(
      s = v.i,
      wx = v.i * wx,
      wy = v.i * wy,
      wz = v.i * wz,
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
      i = 0.0,
    )

  inline infix def v(v: Pga3dPseudoScalar): Pga3dMotor = antiWedge(v)

  infix def antiWedge(v: Pga3dPointCenter.type): Pga3dPlaneIdeal =
    Pga3dPlaneIdeal(
      x = -wx,
      y = -wy,
      z = -wz,
    )

  inline infix def v(v: Pga3dPointCenter.type): Pga3dPlaneIdeal = antiWedge(v)

  infix def sandwich(v: Pga3dMotor): Pga3dMotor =
    Pga3dMotor(
      s = v.s,
      wx = (v.wx - 2.0 * v.xy * wy - 2.0 * v.xz * wz),
      wy = (v.wy - 2.0 * v.yz * wz + 2.0 * v.xy * wx),
      wz = (v.wz + 2.0 * v.xz * wx + 2.0 * v.yz * wy),
      xy = v.xy,
      xz = v.xz,
      yz = v.yz,
      i = v.i,
    )

  infix def sandwich(v: Pga3dPlane): Pga3dPlane =
    Pga3dPlane(
      w = (v.w + 2.0 * v.x * wx + 2.0 * v.y * wy + 2.0 * v.z * wz),
      x = v.x,
      y = v.y,
      z = v.z,
    )

  infix def sandwich(v: Pga3dBivector): Pga3dBivector =
    Pga3dBivector(
      wx = (v.wx - 2.0 * v.xy * wy - 2.0 * v.xz * wz),
      wy = (v.wy - 2.0 * v.yz * wz + 2.0 * v.xy * wx),
      wz = (v.wz + 2.0 * v.xz * wx + 2.0 * v.yz * wy),
      xy = v.xy,
      xz = v.xz,
      yz = v.yz,
    )

  infix def sandwich(v: Pga3dPoint): Pga3dPoint =
    Pga3dPoint(
      wxy = (v.wxy + 2.0 * v.xyz * wz),
      wxz = (v.wxz - 2.0 * v.xyz * wy),
      wyz = (v.wyz + 2.0 * v.xyz * wx),
      xyz = v.xyz,
    )

  infix def sandwich(v: Pga3dQuaternion): Pga3dMotor =
    Pga3dMotor(
      s = v.s,
      wx = 2.0 * (-v.xy * wy - v.xz * wz),
      wy = 2.0 * (v.xy * wx - v.yz * wz),
      wz = 2.0 * (v.xz * wx + v.yz * wy),
      xy = v.xy,
      xz = v.xz,
      yz = v.yz,
      i = 0.0,
    )

  infix def sandwich(v: Pga3dTranslator): Pga3dTranslator =
    v

  infix def sandwich(v: Pga3dVector): Pga3dVector =
    v

  infix def sandwich(v: Pga3dPointNormalized): Pga3dPointNormalized =
    Pga3dPointNormalized(
      wxy = (v.wxy + 2.0 * wz),
      wxz = (v.wxz - 2.0 * wy),
      wyz = (v.wyz + 2.0 * wx),
    )

  infix def sandwich(v: Pga3dPlaneIdeal): Pga3dPlane =
    Pga3dPlane(
      w = 2.0 * (v.x * wx + v.y * wy + v.z * wz),
      x = v.x,
      y = v.y,
      z = v.z,
    )

  infix def sandwich(v: Pga3dBivectorBulk): Pga3dBivector =
    Pga3dBivector(
      wx = 2.0 * (-v.xy * wy - v.xz * wz),
      wy = 2.0 * (v.xy * wx - v.yz * wz),
      wz = 2.0 * (v.xz * wx + v.yz * wy),
      xy = v.xy,
      xz = v.xz,
      yz = v.yz,
    )

  infix def sandwich(v: Pga3dBivectorWeight): Pga3dBivectorWeight =
    v

  infix def sandwich(v: Pga3dPseudoScalar): Pga3dPseudoScalar =
    v

  infix def sandwich(v: Pga3dPointCenter.type): Pga3dPointNormalized =
    Pga3dPointNormalized(
      wxy = 2.0 * wz,
      wxz = -2.0 * wy,
      wyz = 2.0 * wx,
    )

  infix def reverseSandwich(v: Pga3dMotor): Pga3dMotor =
    Pga3dMotor(
      s = v.s,
      wx = (v.wx + 2.0 * v.xy * wy + 2.0 * v.xz * wz),
      wy = (v.wy - 2.0 * v.xy * wx + 2.0 * v.yz * wz),
      wz = (v.wz - 2.0 * v.xz * wx - 2.0 * v.yz * wy),
      xy = v.xy,
      xz = v.xz,
      yz = v.yz,
      i = v.i,
    )

  infix def reverseSandwich(v: Pga3dPlane): Pga3dPlane =
    Pga3dPlane(
      w = (v.w - 2.0 * v.x * wx - 2.0 * v.y * wy - 2.0 * v.z * wz),
      x = v.x,
      y = v.y,
      z = v.z,
    )

  infix def reverseSandwich(v: Pga3dBivector): Pga3dBivector =
    Pga3dBivector(
      wx = (v.wx + 2.0 * v.xy * wy + 2.0 * v.xz * wz),
      wy = (v.wy - 2.0 * v.xy * wx + 2.0 * v.yz * wz),
      wz = (v.wz - 2.0 * v.xz * wx - 2.0 * v.yz * wy),
      xy = v.xy,
      xz = v.xz,
      yz = v.yz,
    )

  infix def reverseSandwich(v: Pga3dPoint): Pga3dPoint =
    Pga3dPoint(
      wxy = (v.wxy - 2.0 * v.xyz * wz),
      wxz = (v.wxz + 2.0 * v.xyz * wy),
      wyz = (v.wyz - 2.0 * v.xyz * wx),
      xyz = v.xyz,
    )

  infix def reverseSandwich(v: Pga3dQuaternion): Pga3dMotor =
    Pga3dMotor(
      s = v.s,
      wx = 2.0 * (v.xy * wy + v.xz * wz),
      wy = 2.0 * (v.yz * wz - v.xy * wx),
      wz = 2.0 * (-v.xz * wx - v.yz * wy),
      xy = v.xy,
      xz = v.xz,
      yz = v.yz,
      i = 0.0,
    )

  infix def reverseSandwich(v: Pga3dTranslator): Pga3dTranslator =
    v

  infix def reverseSandwich(v: Pga3dVector): Pga3dVector =
    v

  infix def reverseSandwich(v: Pga3dPointNormalized): Pga3dPointNormalized =
    Pga3dPointNormalized(
      wxy = (v.wxy - 2.0 * wz),
      wxz = (v.wxz + 2.0 * wy),
      wyz = (v.wyz - 2.0 * wx),
    )

  infix def reverseSandwich(v: Pga3dPlaneIdeal): Pga3dPlane =
    Pga3dPlane(
      w = 2.0 * (-v.x * wx - v.y * wy - v.z * wz),
      x = v.x,
      y = v.y,
      z = v.z,
    )

  infix def reverseSandwich(v: Pga3dBivectorBulk): Pga3dBivector =
    Pga3dBivector(
      wx = 2.0 * (v.xy * wy + v.xz * wz),
      wy = 2.0 * (v.yz * wz - v.xy * wx),
      wz = 2.0 * (-v.xz * wx - v.yz * wy),
      xy = v.xy,
      xz = v.xz,
      yz = v.yz,
    )

  infix def reverseSandwich(v: Pga3dBivectorWeight): Pga3dBivectorWeight =
    v

  infix def reverseSandwich(v: Pga3dPseudoScalar): Pga3dPseudoScalar =
    v

  infix def reverseSandwich(v: Pga3dPointCenter.type): Pga3dPointNormalized =
    Pga3dPointNormalized(
      wxy = -2.0 * wz,
      wxz = 2.0 * wy,
      wyz = -2.0 * wx,
    )

  infix def cross(v: Pga3dMotor): Pga3dBivectorWeight =
    Pga3dBivectorWeight(
      wx = (-v.xy * wy - v.xz * wz),
      wy = (v.xy * wx - v.yz * wz),
      wz = (v.xz * wx + v.yz * wy),
    )

  infix def cross(v: Pga3dPlane): Pga3dPlane =
    Pga3dPlane(
      w = (v.x * wx + v.y * wy + v.z * wz),
      x = 0.0,
      y = 0.0,
      z = 0.0,
    )

  infix def cross(v: Pga3dBivector): Pga3dBivectorWeight =
    Pga3dBivectorWeight(
      wx = (-v.xy * wy - v.xz * wz),
      wy = (v.xy * wx - v.yz * wz),
      wz = (v.xz * wx + v.yz * wy),
    )

  infix def cross(v: Pga3dPoint): Pga3dVector =
    Pga3dVector(
      wxy = v.xyz * wz,
      wxz = -v.xyz * wy,
      wyz = v.xyz * wx,
    )

  infix def cross(v: Pga3dQuaternion): Pga3dBivectorWeight =
    Pga3dBivectorWeight(
      wx = (-v.xy * wy - v.xz * wz),
      wy = (v.xy * wx - v.yz * wz),
      wz = (v.xz * wx + v.yz * wy),
    )

  infix def cross(v: Pga3dPointNormalized): Pga3dVector =
    Pga3dVector(
      wxy = wz,
      wxz = -wy,
      wyz = wx,
    )

  infix def cross(v: Pga3dPlaneIdeal): Pga3dPlane =
    Pga3dPlane(
      w = (v.x * wx + v.y * wy + v.z * wz),
      x = 0.0,
      y = 0.0,
      z = 0.0,
    )

  infix def cross(v: Pga3dBivectorBulk): Pga3dBivectorWeight =
    Pga3dBivectorWeight(
      wx = (-v.xy * wy - v.xz * wz),
      wy = (v.xy * wx - v.yz * wz),
      wz = (v.xz * wx + v.yz * wy),
    )

  infix def cross(v: Pga3dPointCenter.type): Pga3dVector =
    Pga3dVector(
      wxy = wz,
      wxz = -wy,
      wyz = wx,
    )


object Pga3dTranslator:
  def addVector(v: Pga3dVector): Pga3dTranslator =
    Pga3dTranslator(
      wx = 0.5 * v.wyz,
      wy = -0.5 * v.wxz,
      wz = 0.5 * v.wxy,
    )