package com.github.kright.pga3d

/** this code is generated, see com.github.kright.pga3d.codegen.CodeGenClass */
case class Pga3dBivectorWeight(wx: Double = 0.0,
                               wy: Double = 0.0,
                               wz: Double = 0.0):

  override def toString: String =
    s"Pga3dBivectorWeight(wx = $wx, wy = $wy, wz = $wz)"

  def dual: Pga3dBivectorBulk =
    Pga3dBivectorBulk(
      xy = wz,
      xz = -wy,
      yz = wx,
    )

  def weight: Pga3dBivectorWeight =
    this

  def unary_- : Pga3dBivectorWeight =
    Pga3dBivectorWeight(
      wx = -wx,
      wy = -wy,
      wz = -wz,
    )

  def reverse: Pga3dBivectorWeight =
    -this

  def antiReverse: Pga3dBivectorWeight =
    -this

  def weightNormSquare: Double =
    (wx * wx + wy * wy + wz * wz)

  def weightNorm: Double =
    Math.sqrt(weightNormSquare)

  def normalizedByWeight =
    this / weightNorm

  def normSquare: Double =
    (wx * wx + wy * wy + wz * wz)

  def norm: Double =
    Math.sqrt(normSquare)

  def normalizedByNorm =
    this / norm

  def *(v: Double): Pga3dBivectorWeight =
    Pga3dBivectorWeight(
      wx = v * wx,
      wy = v * wy,
      wz = v * wz,
    )

  inline def /(v: Double): Pga3dBivectorWeight =
    this * (1.0 / v)

  def +(v: Pga3dBivector): Pga3dBivector =
    Pga3dBivector(
      wx = (v.wx + wx),
      wy = (v.wy + wy),
      wz = (v.wz + wz),
      xy = v.xy,
      xz = v.xz,
      yz = v.yz,
    )

  def -(v: Pga3dBivector): Pga3dBivector =
    Pga3dBivector(
      wx = (wx - v.wx),
      wy = (wy - v.wy),
      wz = (wz - v.wz),
      xy = -v.xy,
      xz = -v.xz,
      yz = -v.yz,
    )

  def madd(v: Pga3dBivector, mult: Double): Pga3dBivector =
    Pga3dBivector(
      wx = (wx + mult * v.wx),
      wy = (wy + mult * v.wy),
      wz = (wz + mult * v.wz),
      xy = mult * v.xy,
      xz = mult * v.xz,
      yz = mult * v.yz,
    )

  def +(v: Pga3dBivectorBulk): Pga3dBivector =
    Pga3dBivector(
      wx = wx,
      wy = wy,
      wz = wz,
      xy = v.xy,
      xz = v.xz,
      yz = v.yz,
    )

  def -(v: Pga3dBivectorBulk): Pga3dBivector =
    Pga3dBivector(
      wx = wx,
      wy = wy,
      wz = wz,
      xy = -v.xy,
      xz = -v.xz,
      yz = -v.yz,
    )

  def madd(v: Pga3dBivectorBulk, mult: Double): Pga3dBivector =
    Pga3dBivector(
      wx = wx,
      wy = wy,
      wz = wz,
      xy = mult * v.xy,
      xz = mult * v.xz,
      yz = mult * v.yz,
    )

  def +(v: Pga3dBivectorWeight): Pga3dBivectorWeight =
    Pga3dBivectorWeight(
      wx = (v.wx + wx),
      wy = (v.wy + wy),
      wz = (v.wz + wz),
    )

  def -(v: Pga3dBivectorWeight): Pga3dBivectorWeight =
    Pga3dBivectorWeight(
      wx = (wx - v.wx),
      wy = (wy - v.wy),
      wz = (wz - v.wz),
    )

  def madd(v: Pga3dBivectorWeight, mult: Double): Pga3dBivectorWeight =
    Pga3dBivectorWeight(
      wx = (wx + mult * v.wx),
      wy = (wy + mult * v.wy),
      wz = (wz + mult * v.wz),
    )

  def multiplyElementwise(v: Pga3dBivectorWeight): Pga3dBivectorWeight =
    Pga3dBivectorWeight(
      wx = v.wx * wx,
      wy = v.wy * wy,
      wz = v.wz * wz,
    )

  def exp(): Pga3dTranslator =
    Pga3dTranslator(
      wx = wx,
      wy = wy,
      wz = wz,
    )

  def exp(t: Double): Pga3dTranslator =
    Pga3dTranslator(
      wx = t * wx,
      wy = t * wy,
      wz = t * wz,
    )

  def toMultivector: Pga3dMultivector =
    Pga3dMultivector(
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

  def toMotor: Pga3dMotor =
    Pga3dMotor(
      s = 0.0,
      wx = wx,
      wy = wy,
      wz = wz,
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
      i = 0.0,
    )

  def toBivector: Pga3dBivector =
    Pga3dBivector(
      wx = wx,
      wy = wy,
      wz = wz,
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
    )

  def toTranslatorUnsafe: Pga3dTranslator =
    Pga3dTranslator(
      wx = wx,
      wy = wy,
      wz = wz,
    )

  infix def geometric(v: Pga3dMotor): Pga3dMotor =
    Pga3dMotor(
      s = 0.0,
      wx = (v.s * wx - v.xy * wy - v.xz * wz),
      wy = (v.s * wy + v.xy * wx - v.yz * wz),
      wz = (v.s * wz + v.xz * wx + v.yz * wy),
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
      i = (v.xy * wz + v.yz * wx - v.xz * wy),
    )

  infix def geometric(v: Pga3dPlane): Pga3dMultivector =
    Pga3dMultivector(
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

  infix def geometric(v: Pga3dBivector): Pga3dMotor =
    Pga3dMotor(
      s = 0.0,
      wx = (-v.xy * wy - v.xz * wz),
      wy = (v.xy * wx - v.yz * wz),
      wz = (v.xz * wx + v.yz * wy),
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
      i = (v.xy * wz + v.yz * wx - v.xz * wy),
    )

  infix def geometric(v: Pga3dTrivector): Pga3dVector =
    Pga3dVector(
      x = -v.w * wx,
      y = -v.w * wy,
      z = -v.w * wz,
    )

  infix def geometric(v: Pga3dQuaternion): Pga3dMotor =
    Pga3dMotor(
      s = 0.0,
      wx = (v.s * wx - v.xy * wy - v.xz * wz),
      wy = (v.s * wy + v.xy * wx - v.yz * wz),
      wz = (v.s * wz + v.xz * wx + v.yz * wy),
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
      i = (v.xy * wz + v.yz * wx - v.xz * wy),
    )

  infix def geometric(v: Pga3dTranslator): Pga3dBivectorWeight =
    this

  infix def geometric(v: Pga3dPoint): Pga3dVector =
    Pga3dVector(
      x = -wx,
      y = -wy,
      z = -wz,
    )

  infix def geometric(v: Pga3dPlaneIdeal): Pga3dMultivector =
    Pga3dMultivector(
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

  infix def geometric(v: Pga3dBivectorBulk): Pga3dMotor =
    Pga3dMotor(
      s = 0.0,
      wx = (-v.xy * wy - v.xz * wz),
      wy = (v.xy * wx - v.yz * wz),
      wz = (v.xz * wx + v.yz * wy),
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
      i = (v.xy * wz + v.yz * wx - v.xz * wy),
    )

  infix def geometric(v: Pga3dPointCenter.type): Pga3dVector =
    Pga3dVector(
      x = -wx,
      y = -wy,
      z = -wz,
    )

  infix def dot(v: Pga3dMotor): Pga3dBivectorWeight =
    Pga3dBivectorWeight(
      wx = v.s * wx,
      wy = v.s * wy,
      wz = v.s * wz,
    )

  infix def dot(v: Pga3dPlane): Pga3dPlane =
    Pga3dPlane(
      x = 0.0,
      y = 0.0,
      z = 0.0,
      w = (v.x * wx + v.y * wy + v.z * wz),
    )

  infix def dot(v: Pga3dQuaternion): Pga3dBivectorWeight =
    Pga3dBivectorWeight(
      wx = v.s * wx,
      wy = v.s * wy,
      wz = v.s * wz,
    )

  infix def dot(v: Pga3dTranslator): Pga3dBivectorWeight =
    this

  infix def dot(v: Pga3dPlaneIdeal): Pga3dPlane =
    Pga3dPlane(
      x = 0.0,
      y = 0.0,
      z = 0.0,
      w = (v.x * wx + v.y * wy + v.z * wz),
    )

  infix def wedge(v: Pga3dMotor): Pga3dMotor =
    Pga3dMotor(
      s = 0.0,
      wx = v.s * wx,
      wy = v.s * wy,
      wz = v.s * wz,
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
      i = (v.xy * wz + v.yz * wx - v.xz * wy),
    )

  inline infix def ^(v: Pga3dMotor): Pga3dMotor = wedge(v)

  infix def wedge(v: Pga3dPlane): Pga3dVector =
    Pga3dVector(
      x = (v.y * wz - v.z * wy),
      y = (v.z * wx - v.x * wz),
      z = (v.x * wy - v.y * wx),
    )

  inline infix def ^(v: Pga3dPlane): Pga3dVector = wedge(v)

  infix def wedge(v: Pga3dBivector): Pga3dPseudoScalar =
    Pga3dPseudoScalar(
      i = (v.xy * wz + v.yz * wx - v.xz * wy),
    )

  inline infix def ^(v: Pga3dBivector): Pga3dPseudoScalar = wedge(v)

  infix def wedge(v: Pga3dQuaternion): Pga3dMotor =
    Pga3dMotor(
      s = 0.0,
      wx = v.s * wx,
      wy = v.s * wy,
      wz = v.s * wz,
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
      i = (v.xy * wz + v.yz * wx - v.xz * wy),
    )

  inline infix def ^(v: Pga3dQuaternion): Pga3dMotor = wedge(v)

  infix def wedge(v: Pga3dTranslator): Pga3dBivectorWeight =
    this

  inline infix def ^(v: Pga3dTranslator): Pga3dBivectorWeight = wedge(v)

  infix def wedge(v: Pga3dPlaneIdeal): Pga3dVector =
    Pga3dVector(
      x = (v.y * wz - v.z * wy),
      y = (v.z * wx - v.x * wz),
      z = (v.x * wy - v.y * wx),
    )

  inline infix def ^(v: Pga3dPlaneIdeal): Pga3dVector = wedge(v)

  infix def wedge(v: Pga3dBivectorBulk): Pga3dPseudoScalar =
    Pga3dPseudoScalar(
      i = (v.xy * wz + v.yz * wx - v.xz * wy),
    )

  inline infix def ^(v: Pga3dBivectorBulk): Pga3dPseudoScalar = wedge(v)

  infix def antiGeometric(v: Pga3dMotor): Pga3dMotor =
    Pga3dMotor(
      s = (v.xy * wz + v.yz * wx - v.xz * wy),
      wx = (v.i * wx + v.wy * wz - v.wz * wy),
      wy = (v.i * wy + v.wz * wx - v.wx * wz),
      wz = (v.i * wz + v.wx * wy - v.wy * wx),
      xy = (v.xz * wx + v.yz * wy - v.s * wz),
      xz = (v.s * wy + v.yz * wz - v.xy * wx),
      yz = (-v.s * wx - v.xy * wy - v.xz * wz),
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
      xyz = (v.x * wx + v.y * wy + v.z * wz),
      i = 0.0,
    )

  infix def antiGeometric(v: Pga3dBivector): Pga3dMotor =
    Pga3dMotor(
      s = (v.xy * wz + v.yz * wx - v.xz * wy),
      wx = (v.wy * wz - v.wz * wy),
      wy = (v.wz * wx - v.wx * wz),
      wz = (v.wx * wy - v.wy * wx),
      xy = (v.xz * wx + v.yz * wy),
      xz = (v.yz * wz - v.xy * wx),
      yz = (-v.xy * wy - v.xz * wz),
      i = (-v.wx * wx - v.wy * wy - v.wz * wz),
    )

  infix def antiGeometric(v: Pga3dTrivector): Pga3dMultivector =
    Pga3dMultivector(
      s = 0.0,
      w = (v.x * wx + v.y * wy + v.z * wz),
      x = -v.w * wx,
      y = -v.w * wy,
      z = -v.w * wz,
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
      xy = -wz,
      xz = wy,
      yz = -wx,
      i = (-v.wx * wx - v.wy * wy - v.wz * wz),
    )

  infix def antiGeometric(v: Pga3dVector): Pga3dMultivector =
    Pga3dMultivector(
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

  infix def antiGeometric(v: Pga3dPoint): Pga3dMultivector =
    Pga3dMultivector(
      s = 0.0,
      w = (v.x * wx + v.y * wy + v.z * wz),
      x = -wx,
      y = -wy,
      z = -wz,
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
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
      i = (-v.wx * wx - v.wy * wy - v.wz * wz),
    )

  infix def antiGeometric(v: Pga3dPseudoScalar): Pga3dBivectorWeight =
    Pga3dBivectorWeight(
      wx = v.i * wx,
      wy = v.i * wy,
      wz = v.i * wz,
    )

  infix def antiGeometric(v: Pga3dPointCenter.type): Pga3dPlaneIdeal =
    Pga3dPlaneIdeal(
      x = -wx,
      y = -wy,
      z = -wz,
    )

  infix def antiDot(v: Pga3dMotor): Pga3dMotor =
    Pga3dMotor(
      s = 0.0,
      wx = v.i * wx,
      wy = v.i * wy,
      wz = v.i * wz,
      xy = -v.s * wz,
      xz = v.s * wy,
      yz = -v.s * wx,
      i = (-v.wx * wx - v.wy * wy - v.wz * wz),
    )

  infix def antiDot(v: Pga3dPlane): Pga3dTrivector =
    Pga3dTrivector(
      x = -v.w * wx,
      y = -v.w * wy,
      z = -v.w * wz,
      w = (v.x * wx + v.y * wy + v.z * wz),
    )

  infix def antiDot(v: Pga3dBivector): Pga3dPseudoScalar =
    Pga3dPseudoScalar(
      i = (-v.wx * wx - v.wy * wy - v.wz * wz),
    )

  infix def antiDot(v: Pga3dTrivector): Pga3dVector =
    Pga3dVector(
      x = (v.y * wz - v.z * wy),
      y = (v.z * wx - v.x * wz),
      z = (v.x * wy - v.y * wx),
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
      xy = -wz,
      xz = wy,
      yz = -wx,
      i = (-v.wx * wx - v.wy * wy - v.wz * wz),
    )

  infix def antiDot(v: Pga3dVector): Pga3dVector =
    Pga3dVector(
      x = (v.y * wz - v.z * wy),
      y = (v.z * wx - v.x * wz),
      z = (v.x * wy - v.y * wx),
    )

  infix def antiDot(v: Pga3dPoint): Pga3dVector =
    Pga3dVector(
      x = (v.y * wz - v.z * wy),
      y = (v.z * wx - v.x * wz),
      z = (v.x * wy - v.y * wx),
    )

  infix def antiDot(v: Pga3dPlaneIdeal): Pga3dTrivector =
    Pga3dTrivector(
      x = 0.0,
      y = 0.0,
      z = 0.0,
      w = (v.x * wx + v.y * wy + v.z * wz),
    )

  infix def antiDot(v: Pga3dBivectorWeight): Pga3dPseudoScalar =
    Pga3dPseudoScalar(
      i = (-v.wx * wx - v.wy * wy - v.wz * wz),
    )

  infix def antiDot(v: Pga3dPseudoScalar): Pga3dBivectorWeight =
    Pga3dBivectorWeight(
      wx = v.i * wx,
      wy = v.i * wy,
      wz = v.i * wz,
    )

  infix def antiWedge(v: Pga3dMotor): Pga3dMotor =
    Pga3dMotor(
      s = (v.xy * wz + v.yz * wx - v.xz * wy),
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

  infix def antiWedge(v: Pga3dTrivector): Pga3dPlane =
    Pga3dPlane(
      x = -v.w * wx,
      y = -v.w * wy,
      z = -v.w * wz,
      w = (v.x * wx + v.y * wy + v.z * wz),
    )

  inline infix def v(v: Pga3dTrivector): Pga3dPlane = antiWedge(v)

  infix def antiWedge(v: Pga3dQuaternion): Double =
    (v.xy * wz + v.yz * wx - v.xz * wy)

  inline infix def v(v: Pga3dQuaternion): Double = antiWedge(v)

  infix def antiWedge(v: Pga3dVector): Pga3dPlane =
    Pga3dPlane(
      x = 0.0,
      y = 0.0,
      z = 0.0,
      w = (v.x * wx + v.y * wy + v.z * wz),
    )

  inline infix def v(v: Pga3dVector): Pga3dPlane = antiWedge(v)

  infix def antiWedge(v: Pga3dPoint): Pga3dPlane =
    Pga3dPlane(
      x = -wx,
      y = -wy,
      z = -wz,
      w = (v.x * wx + v.y * wy + v.z * wz),
    )

  inline infix def v(v: Pga3dPoint): Pga3dPlane = antiWedge(v)

  infix def antiWedge(v: Pga3dBivectorBulk): Double =
    (v.xy * wz + v.yz * wx - v.xz * wy)

  inline infix def v(v: Pga3dBivectorBulk): Double = antiWedge(v)

  infix def antiWedge(v: Pga3dPseudoScalar): Pga3dBivectorWeight =
    Pga3dBivectorWeight(
      wx = v.i * wx,
      wy = v.i * wy,
      wz = v.i * wz,
    )

  inline infix def v(v: Pga3dPseudoScalar): Pga3dBivectorWeight = antiWedge(v)

  infix def antiWedge(v: Pga3dPointCenter.type): Pga3dPlaneIdeal =
    Pga3dPlaneIdeal(
      x = -wx,
      y = -wy,
      z = -wz,
    )

  inline infix def v(v: Pga3dPointCenter.type): Pga3dPlaneIdeal = antiWedge(v)

  infix def cross(v: Pga3dMotor): Pga3dBivectorWeight =
    Pga3dBivectorWeight(
      wx = (-v.xy * wy - v.xz * wz),
      wy = (v.xy * wx - v.yz * wz),
      wz = (v.xz * wx + v.yz * wy),
    )

  infix def cross(v: Pga3dPlane): Pga3dPlane =
    Pga3dPlane(
      x = 0.0,
      y = 0.0,
      z = 0.0,
      w = (v.x * wx + v.y * wy + v.z * wz),
    )

  infix def cross(v: Pga3dBivector): Pga3dBivectorWeight =
    Pga3dBivectorWeight(
      wx = (-v.xy * wy - v.xz * wz),
      wy = (v.xy * wx - v.yz * wz),
      wz = (v.xz * wx + v.yz * wy),
    )

  infix def cross(v: Pga3dTrivector): Pga3dVector =
    Pga3dVector(
      x = -v.w * wx,
      y = -v.w * wy,
      z = -v.w * wz,
    )

  infix def cross(v: Pga3dQuaternion): Pga3dBivectorWeight =
    Pga3dBivectorWeight(
      wx = (-v.xy * wy - v.xz * wz),
      wy = (v.xy * wx - v.yz * wz),
      wz = (v.xz * wx + v.yz * wy),
    )

  infix def cross(v: Pga3dPoint): Pga3dVector =
    Pga3dVector(
      x = -wx,
      y = -wy,
      z = -wz,
    )

  infix def cross(v: Pga3dPlaneIdeal): Pga3dPlane =
    Pga3dPlane(
      x = 0.0,
      y = 0.0,
      z = 0.0,
      w = (v.x * wx + v.y * wy + v.z * wz),
    )

  infix def cross(v: Pga3dBivectorBulk): Pga3dBivectorWeight =
    Pga3dBivectorWeight(
      wx = (-v.xy * wy - v.xz * wz),
      wy = (v.xy * wx - v.yz * wz),
      wz = (v.xz * wx + v.yz * wy),
    )

  infix def cross(v: Pga3dPointCenter.type): Pga3dVector =
    Pga3dVector(
      x = -wx,
      y = -wy,
      z = -wz,
    )


object Pga3dBivectorWeight:

  inline val componentsCount = 3

  val zero: Pga3dBivectorWeight = Pga3dBivectorWeight(0.0, 0.0, 0.0)