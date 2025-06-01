package com.github.kright.pga3d

import scala.annotation.targetName

/** this code is generated, see com.github.kright.pga3d.codegen.CodeGenClass */
final case class Pga3dPlane(x: Double = 0.0,
                            y: Double = 0.0,
                            z: Double = 0.0,
                            w: Double = 0.0):

  override def toString: String =
    s"Pga3dPlane(x = $x, y = $y, z = $z, w = $w)"

  def dual: Pga3dTrivector =
    Pga3dTrivector(
      x = x,
      y = y,
      z = z,
      w = w,
    )

  def weight: Pga3dPlane =
    Pga3dPlane(
      x = 0.0,
      y = 0.0,
      z = 0.0,
      w = w,
    )

  def bulk: Pga3dPlaneIdeal =
    Pga3dPlaneIdeal(
      x = x,
      y = y,
      z = z,
    )

  @targetName("unaryMinus")
  def unary_- : Pga3dPlane =
    Pga3dPlane(
      x = -x,
      y = -y,
      z = -z,
      w = -w,
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

  @targetName("times")
  def *(v: Double): Pga3dPlane =
    Pga3dPlane(
      x = v * x,
      y = v * y,
      z = v * z,
      w = v * w,
    )

  @targetName("div")
  def /(v: Double): Pga3dPlane =
    this * (1.0 / v)

  @targetName("plus")
  def +(v: Pga3dPlane): Pga3dPlane =
    Pga3dPlane(
      x = (v.x + x),
      y = (v.y + y),
      z = (v.z + z),
      w = (v.w + w),
    )

  @targetName("minus")
  def -(v: Pga3dPlane): Pga3dPlane =
    Pga3dPlane(
      x = (x - v.x),
      y = (y - v.y),
      z = (z - v.z),
      w = (w - v.w),
    )

  def madd(v: Pga3dPlane, mult: Double): Pga3dPlane =
    Pga3dPlane(
      x = (x + mult * v.x),
      y = (y + mult * v.y),
      z = (z + mult * v.z),
      w = (w + mult * v.w),
    )

  def multiplyElementwise(v: Pga3dPlane): Pga3dPlane =
    Pga3dPlane(
      x = v.x * x,
      y = v.y * y,
      z = v.z * z,
      w = v.w * w,
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

  def toPlaneIdealUnsafe: Pga3dPlaneIdeal =
    Pga3dPlaneIdeal(
      x = x,
      y = y,
      z = z,
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

  infix def geometric(v: Pga3dTrivector): Pga3dMotor =
    Pga3dMotor(
      s = 0.0,
      wx = (v.y * z - v.z * y),
      wy = (v.z * x - v.x * z),
      wz = (v.x * y - v.y * x),
      xy = v.w * z,
      xz = -v.w * y,
      yz = v.w * x,
      i = (v.w * w + v.x * x + v.y * y + v.z * z),
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
      wx = (v.y * z - v.z * y),
      wy = (v.z * x - v.x * z),
      wz = (v.x * y - v.y * x),
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
      i = (v.x * x + v.y * y + v.z * z),
    )

  infix def geometric(v: Pga3dPoint): Pga3dMotor =
    Pga3dMotor(
      s = 0.0,
      wx = (v.y * z - v.z * y),
      wy = (v.z * x - v.x * z),
      wz = (v.x * y - v.y * x),
      xy = z,
      xz = -y,
      yz = x,
      i = (w + v.x * x + v.y * y + v.z * z),
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
      x = v.i * x,
      y = v.i * y,
      z = v.i * z,
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
      x = (-v.xy * y - v.xz * z),
      y = (v.xy * x - v.yz * z),
      z = (v.xz * x + v.yz * y),
      w = (-v.wx * x - v.wy * y - v.wz * z),
    )

  infix def dot(v: Pga3dTrivector): Pga3dBivector =
    Pga3dBivector(
      wx = (v.y * z - v.z * y),
      wy = (v.z * x - v.x * z),
      wz = (v.x * y - v.y * x),
      xy = v.w * z,
      xz = -v.w * y,
      yz = v.w * x,
    )

  infix def dot(v: Pga3dQuaternion): Pga3dPlane =
    Pga3dPlane(
      x = (v.s * x - v.xy * y - v.xz * z),
      y = (v.s * y + v.xy * x - v.yz * z),
      z = (v.s * z + v.xz * x + v.yz * y),
      w = v.s * w,
    )

  infix def dot(v: Pga3dTranslator): Pga3dPlane =
    Pga3dPlane(
      x = x,
      y = y,
      z = z,
      w = (w - v.wx * x - v.wy * y - v.wz * z),
    )

  infix def dot(v: Pga3dVector): Pga3dBivectorWeight =
    Pga3dBivectorWeight(
      wx = (v.y * z - v.z * y),
      wy = (v.z * x - v.x * z),
      wz = (v.x * y - v.y * x),
    )

  infix def dot(v: Pga3dPoint): Pga3dBivector =
    Pga3dBivector(
      wx = (v.y * z - v.z * y),
      wy = (v.z * x - v.x * z),
      wz = (v.x * y - v.y * x),
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
      x = 0.0,
      y = 0.0,
      z = 0.0,
      w = (-v.wx * x - v.wy * y - v.wz * z),
    )

  infix def dot(v: Pga3dPseudoScalar): Pga3dVector =
    Pga3dVector(
      x = v.i * x,
      y = v.i * y,
      z = v.i * z,
    )

  infix def dot(v: Pga3dPointCenter.type): Pga3dBivectorBulk =
    Pga3dBivectorBulk(
      xy = z,
      xz = -y,
      yz = x,
    )

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

  infix def wedge(v: Pga3dBivector): Pga3dTrivector =
    Pga3dTrivector(
      x = (v.wz * y - v.wy * z - v.yz * w),
      y = (v.wx * z + v.xz * w - v.wz * x),
      z = (v.wy * x - v.wx * y - v.xy * w),
      w = (v.xy * z + v.yz * x - v.xz * y),
    )

  inline infix def ^(v: Pga3dBivector): Pga3dTrivector = wedge(v)

  infix def wedge(v: Pga3dTrivector): Pga3dPseudoScalar =
    Pga3dPseudoScalar(
      i = (v.w * w + v.x * x + v.y * y + v.z * z),
    )

  inline infix def ^(v: Pga3dTrivector): Pga3dPseudoScalar = wedge(v)

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
      i = (v.x * x + v.y * y + v.z * z),
    )

  inline infix def ^(v: Pga3dVector): Pga3dPseudoScalar = wedge(v)

  infix def wedge(v: Pga3dPoint): Pga3dPseudoScalar =
    Pga3dPseudoScalar(
      i = (w + v.x * x + v.y * y + v.z * z),
    )

  inline infix def ^(v: Pga3dPoint): Pga3dPseudoScalar = wedge(v)

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

  infix def wedge(v: Pga3dBivectorBulk): Pga3dTrivector =
    Pga3dTrivector(
      x = -v.yz * w,
      y = v.xz * w,
      z = -v.xy * w,
      w = (v.xy * z + v.yz * x - v.xz * y),
    )

  inline infix def ^(v: Pga3dBivectorBulk): Pga3dTrivector = wedge(v)

  infix def wedge(v: Pga3dBivectorWeight): Pga3dVector =
    Pga3dVector(
      x = (v.wz * y - v.wy * z),
      y = (v.wx * z - v.wz * x),
      z = (v.wy * x - v.wx * y),
    )

  inline infix def ^(v: Pga3dBivectorWeight): Pga3dVector = wedge(v)

  infix def wedge(v: Pga3dPointCenter.type): Pga3dPseudoScalar =
    Pga3dPseudoScalar(
      i = w,
    )

  inline infix def ^(v: Pga3dPointCenter.type): Pga3dPseudoScalar = wedge(v)

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

  infix def antiGeometric(v: Pga3dTrivector): Pga3dMotor =
    Pga3dMotor(
      s = (-v.w * w - v.x * x - v.y * y - v.z * z),
      wx = v.x * w,
      wy = v.y * w,
      wz = v.z * w,
      xy = (v.y * x - v.x * y),
      xz = (v.z * x - v.x * z),
      yz = (v.z * y - v.y * z),
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
      s = (-v.x * x - v.y * y - v.z * z),
      wx = v.x * w,
      wy = v.y * w,
      wz = v.z * w,
      xy = (v.y * x - v.x * y),
      xz = (v.z * x - v.x * z),
      yz = (v.z * y - v.y * z),
      i = 0.0,
    )

  infix def antiGeometric(v: Pga3dPoint): Pga3dMotor =
    Pga3dMotor(
      s = (-w - v.x * x - v.y * y - v.z * z),
      wx = v.x * w,
      wy = v.y * w,
      wz = v.z * w,
      xy = (v.y * x - v.x * y),
      xz = (v.z * x - v.x * z),
      yz = (v.z * y - v.y * z),
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
      x = v.i * x,
      y = v.i * y,
      z = v.i * z,
      w = v.i * w,
    )

  infix def antiGeometric(v: Pga3dPointCenter.type): Double =
    -w

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

  infix def antiDot(v: Pga3dBivector): Pga3dTrivector =
    Pga3dTrivector(
      x = -v.wx * w,
      y = -v.wy * w,
      z = -v.wz * w,
      w = (v.wx * x + v.wy * y + v.wz * z),
    )

  infix def antiDot(v: Pga3dTrivector): Pga3dBivector =
    Pga3dBivector(
      wx = v.x * w,
      wy = v.y * w,
      wz = v.z * w,
      xy = (v.y * x - v.x * y),
      xz = (v.z * x - v.x * z),
      yz = (v.z * y - v.y * z),
    )

  infix def antiDot(v: Pga3dQuaternion): Pga3dTrivector =
    Pga3dTrivector(
      x = 0.0,
      y = 0.0,
      z = 0.0,
      w = v.s * w,
    )

  infix def antiDot(v: Pga3dTranslator): Pga3dTrivector =
    Pga3dTrivector(
      x = -v.wx * w,
      y = -v.wy * w,
      z = -v.wz * w,
      w = (w + v.wx * x + v.wy * y + v.wz * z),
    )

  infix def antiDot(v: Pga3dVector): Pga3dBivector =
    Pga3dBivector(
      wx = v.x * w,
      wy = v.y * w,
      wz = v.z * w,
      xy = (v.y * x - v.x * y),
      xz = (v.z * x - v.x * z),
      yz = (v.z * y - v.y * z),
    )

  infix def antiDot(v: Pga3dPoint): Pga3dBivector =
    Pga3dBivector(
      wx = v.x * w,
      wy = v.y * w,
      wz = v.z * w,
      xy = (v.y * x - v.x * y),
      xz = (v.z * x - v.x * z),
      yz = (v.z * y - v.y * z),
    )

  infix def antiDot(v: Pga3dBivectorWeight): Pga3dTrivector =
    Pga3dTrivector(
      x = -v.wx * w,
      y = -v.wy * w,
      z = -v.wz * w,
      w = (v.wx * x + v.wy * y + v.wz * z),
    )

  infix def antiDot(v: Pga3dPseudoScalar): Pga3dPlane =
    Pga3dPlane(
      x = v.i * x,
      y = v.i * y,
      z = v.i * z,
      w = v.i * w,
    )

  infix def antiDotI(v: Pga3dPlane): Double =
    -v.w * w

  infix def antiWedge(v: Pga3dMotor): Pga3dPlane =
    Pga3dPlane(
      x = v.i * x,
      y = v.i * y,
      z = v.i * z,
      w = v.i * w,
    )

  inline infix def v(v: Pga3dMotor): Pga3dPlane = antiWedge(v)

  infix def antiWedge(v: Pga3dTrivector): Double =
    (-v.w * w - v.x * x - v.y * y - v.z * z)

  inline infix def v(v: Pga3dTrivector): Double = antiWedge(v)

  infix def antiWedge(v: Pga3dVector): Double =
    (-v.x * x - v.y * y - v.z * z)

  inline infix def v(v: Pga3dVector): Double = antiWedge(v)

  infix def antiWedge(v: Pga3dPoint): Double =
    (-w - v.x * x - v.y * y - v.z * z)

  inline infix def v(v: Pga3dPoint): Double = antiWedge(v)

  infix def antiWedge(v: Pga3dPseudoScalar): Pga3dPlane =
    Pga3dPlane(
      x = v.i * x,
      y = v.i * y,
      z = v.i * z,
      w = v.i * w,
    )

  inline infix def v(v: Pga3dPseudoScalar): Pga3dPlane = antiWedge(v)

  infix def antiWedge(v: Pga3dPointCenter.type): Double =
    -w

  inline infix def v(v: Pga3dPointCenter.type): Double = antiWedge(v)

  infix def sandwich(v: Pga3dMotor): Pga3dMotor =
    val xMx = x * x
    val xMy = x * y
    val xMz = x * z
    val xMw = w * x
    val yMy = y * y
    val yMz = y * z
    val yMw = w * y
    val zMz = z * z
    val zMw = w * z
    Pga3dMotor(
      s = v.s * (xMx + yMy + zMz),
      wx = (2.0 * (v.xy * yMw + v.xz * zMw - v.wy * xMy - v.wz * xMz) + v.wx * (yMy + zMz - xMx)),
      wy = (2.0 * (v.yz * zMw - v.wx * xMy - v.wz * yMz - v.xy * xMw) + v.wy * (xMx + zMz - yMy)),
      wz = (2.0 * (-v.wx * xMz - v.wy * yMz - v.xz * xMw - v.yz * yMw) + v.wz * (xMx + yMy - zMz)),
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
      x = (2.0 * (v.y * xMy + v.z * xMz) + v.x * (xMx - yMy - zMz)),
      y = (2.0 * (v.x * xMy + v.z * yMz) + v.y * (yMy - xMx - zMz)),
      z = (2.0 * (v.x * xMz + v.y * yMz) + v.z * (zMz - xMx - yMy)),
      w = (v.w * (-xMx - yMy - zMz) + 2.0 * w * (v.x * x + v.y * y + v.z * z)),
    )

  infix def sandwich(v: Pga3dBivector): Pga3dBivector =
    val xMx = x * x
    val xMy = x * y
    val xMz = x * z
    val xMw = w * x
    val yMy = y * y
    val yMz = y * z
    val yMw = w * y
    val zMz = z * z
    val zMw = w * z
    Pga3dBivector(
      wx = (2.0 * (v.xy * yMw + v.xz * zMw - v.wy * xMy - v.wz * xMz) + v.wx * (yMy + zMz - xMx)),
      wy = (2.0 * (v.yz * zMw - v.wx * xMy - v.wz * yMz - v.xy * xMw) + v.wy * (xMx + zMz - yMy)),
      wz = (2.0 * (-v.wx * xMz - v.wy * yMz - v.xz * xMw - v.yz * yMw) + v.wz * (xMx + yMy - zMz)),
      xy = (2.0 * (v.yz * xMz - v.xz * yMz) + v.xy * (zMz - xMx - yMy)),
      xz = (2.0 * (-v.xy * yMz - v.yz * xMy) + v.xz * (yMy - xMx - zMz)),
      yz = (2.0 * (v.xy * xMz - v.xz * xMy) + v.yz * (xMx - yMy - zMz)),
    )

  infix def sandwich(v: Pga3dTrivector): Pga3dTrivector =
    val xMx = x * x
    val xMy = x * y
    val xMz = x * z
    val yMy = y * y
    val yMz = y * z
    val zMz = z * z
    Pga3dTrivector(
      x = -(2.0 * (v.y * xMy + v.z * xMz + v.w * w * x) + v.x * (xMx - yMy - zMz)),
      y = (2.0 * (-v.x * xMy - v.z * yMz - v.w * w * y) + v.y * (xMx + zMz - yMy)),
      z = -(2.0 * (v.x * xMz + v.y * yMz + v.w * w * z) + v.z * (zMz - xMx - yMy)),
      w = v.w * (xMx + yMy + zMz),
    )

  infix def sandwich(v: Pga3dQuaternion): Pga3dMotor =
    val xMx = x * x
    val xMy = x * y
    val xMz = x * z
    val xMw = w * x
    val yMy = y * y
    val yMz = y * z
    val yMw = w * y
    val zMz = z * z
    val zMw = w * z
    Pga3dMotor(
      s = v.s * (xMx + yMy + zMz),
      wx = 2.0 * (v.xy * yMw + v.xz * zMw),
      wy = 2.0 * (v.yz * zMw - v.xy * xMw),
      wz = 2.0 * (-v.xz * xMw - v.yz * yMw),
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
      x = -(2.0 * (v.y * xMy + v.z * xMz) + v.x * (xMx - yMy - zMz)),
      y = (2.0 * (-v.x * xMy - v.z * yMz) + v.y * (xMx + zMz - yMy)),
      z = -(2.0 * (v.x * xMz + v.y * yMz) + v.z * (zMz - xMx - yMy)),
    )

  infix def sandwich(v: Pga3dPoint): Pga3dTrivector =
    val xMx = x * x
    val xMy = x * y
    val xMz = x * z
    val yMy = y * y
    val yMz = y * z
    val zMz = z * z
    Pga3dTrivector(
      x = -(2.0 * (v.y * xMy + v.z * xMz + w * x) + v.x * (xMx - yMy - zMz)),
      y = (2.0 * (-v.x * xMy - v.z * yMz - w * y) + v.y * (xMx + zMz - yMy)),
      z = -(2.0 * (v.x * xMz + v.y * yMz + w * z) + v.z * (zMz - xMx - yMy)),
      w = (xMx + yMy + zMz),
    )

  infix def sandwich(v: Pga3dPlaneIdeal): Pga3dPlane =
    val xMx = x * x
    val xMy = x * y
    val xMz = x * z
    val yMy = y * y
    val yMz = y * z
    val zMz = z * z
    Pga3dPlane(
      x = (2.0 * (v.y * xMy + v.z * xMz) + v.x * (xMx - yMy - zMz)),
      y = (2.0 * (v.x * xMy + v.z * yMz) + v.y * (yMy - xMx - zMz)),
      z = (2.0 * (v.x * xMz + v.y * yMz) + v.z * (zMz - xMx - yMy)),
      w = 2.0 * w * (v.x * x + v.y * y + v.z * z),
    )

  infix def sandwich(v: Pga3dBivectorBulk): Pga3dBivector =
    val xMx = x * x
    val xMy = x * y
    val xMz = x * z
    val xMw = w * x
    val yMy = y * y
    val yMz = y * z
    val yMw = w * y
    val zMz = z * z
    val zMw = w * z
    Pga3dBivector(
      wx = 2.0 * (v.xy * yMw + v.xz * zMw),
      wy = 2.0 * (v.yz * zMw - v.xy * xMw),
      wz = 2.0 * (-v.xz * xMw - v.yz * yMw),
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

  infix def sandwich(v: Pga3dPointCenter.type): Pga3dTrivector =
    Pga3dTrivector(
      x = -2.0 * w * x,
      y = -2.0 * w * y,
      z = -2.0 * w * z,
      w = (x * x + y * y + z * z),
    )

  infix def reverseSandwich(v: Pga3dMotor): Pga3dMotor =
    val xMx = x * x
    val xMy = x * y
    val xMz = x * z
    val xMw = w * x
    val yMy = y * y
    val yMz = y * z
    val yMw = w * y
    val zMz = z * z
    val zMw = w * z
    Pga3dMotor(
      s = v.s * (xMx + yMy + zMz),
      wx = (2.0 * (v.xy * yMw + v.xz * zMw - v.wy * xMy - v.wz * xMz) + v.wx * (yMy + zMz - xMx)),
      wy = (2.0 * (v.yz * zMw - v.wx * xMy - v.wz * yMz - v.xy * xMw) + v.wy * (xMx + zMz - yMy)),
      wz = (2.0 * (-v.wx * xMz - v.wy * yMz - v.xz * xMw - v.yz * yMw) + v.wz * (xMx + yMy - zMz)),
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
      x = (2.0 * (v.y * xMy + v.z * xMz) + v.x * (xMx - yMy - zMz)),
      y = (2.0 * (v.x * xMy + v.z * yMz) + v.y * (yMy - xMx - zMz)),
      z = (2.0 * (v.x * xMz + v.y * yMz) + v.z * (zMz - xMx - yMy)),
      w = (v.w * (-xMx - yMy - zMz) + 2.0 * w * (v.x * x + v.y * y + v.z * z)),
    )

  infix def reverseSandwich(v: Pga3dBivector): Pga3dBivector =
    val xMx = x * x
    val xMy = x * y
    val xMz = x * z
    val xMw = w * x
    val yMy = y * y
    val yMz = y * z
    val yMw = w * y
    val zMz = z * z
    val zMw = w * z
    Pga3dBivector(
      wx = (2.0 * (v.xy * yMw + v.xz * zMw - v.wy * xMy - v.wz * xMz) + v.wx * (yMy + zMz - xMx)),
      wy = (2.0 * (v.yz * zMw - v.wx * xMy - v.wz * yMz - v.xy * xMw) + v.wy * (xMx + zMz - yMy)),
      wz = (2.0 * (-v.wx * xMz - v.wy * yMz - v.xz * xMw - v.yz * yMw) + v.wz * (xMx + yMy - zMz)),
      xy = (2.0 * (v.yz * xMz - v.xz * yMz) + v.xy * (zMz - xMx - yMy)),
      xz = (2.0 * (-v.xy * yMz - v.yz * xMy) + v.xz * (yMy - xMx - zMz)),
      yz = (2.0 * (v.xy * xMz - v.xz * xMy) + v.yz * (xMx - yMy - zMz)),
    )

  infix def reverseSandwich(v: Pga3dTrivector): Pga3dTrivector =
    val xMx = x * x
    val xMy = x * y
    val xMz = x * z
    val yMy = y * y
    val yMz = y * z
    val zMz = z * z
    Pga3dTrivector(
      x = -(2.0 * (v.y * xMy + v.z * xMz + v.w * w * x) + v.x * (xMx - yMy - zMz)),
      y = (2.0 * (-v.x * xMy - v.z * yMz - v.w * w * y) + v.y * (xMx + zMz - yMy)),
      z = -(2.0 * (v.x * xMz + v.y * yMz + v.w * w * z) + v.z * (zMz - xMx - yMy)),
      w = v.w * (xMx + yMy + zMz),
    )

  infix def reverseSandwich(v: Pga3dQuaternion): Pga3dMotor =
    val xMx = x * x
    val xMy = x * y
    val xMz = x * z
    val xMw = w * x
    val yMy = y * y
    val yMz = y * z
    val yMw = w * y
    val zMz = z * z
    val zMw = w * z
    Pga3dMotor(
      s = v.s * (xMx + yMy + zMz),
      wx = 2.0 * (v.xy * yMw + v.xz * zMw),
      wy = 2.0 * (v.yz * zMw - v.xy * xMw),
      wz = 2.0 * (-v.xz * xMw - v.yz * yMw),
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
      x = -(2.0 * (v.y * xMy + v.z * xMz) + v.x * (xMx - yMy - zMz)),
      y = (2.0 * (-v.x * xMy - v.z * yMz) + v.y * (xMx + zMz - yMy)),
      z = -(2.0 * (v.x * xMz + v.y * yMz) + v.z * (zMz - xMx - yMy)),
    )

  infix def reverseSandwich(v: Pga3dPoint): Pga3dTrivector =
    val xMx = x * x
    val xMy = x * y
    val xMz = x * z
    val yMy = y * y
    val yMz = y * z
    val zMz = z * z
    Pga3dTrivector(
      x = -(2.0 * (v.y * xMy + v.z * xMz + w * x) + v.x * (xMx - yMy - zMz)),
      y = (2.0 * (-v.x * xMy - v.z * yMz - w * y) + v.y * (xMx + zMz - yMy)),
      z = -(2.0 * (v.x * xMz + v.y * yMz + w * z) + v.z * (zMz - xMx - yMy)),
      w = (xMx + yMy + zMz),
    )

  infix def reverseSandwich(v: Pga3dPlaneIdeal): Pga3dPlane =
    val xMx = x * x
    val xMy = x * y
    val xMz = x * z
    val yMy = y * y
    val yMz = y * z
    val zMz = z * z
    Pga3dPlane(
      x = (2.0 * (v.y * xMy + v.z * xMz) + v.x * (xMx - yMy - zMz)),
      y = (2.0 * (v.x * xMy + v.z * yMz) + v.y * (yMy - xMx - zMz)),
      z = (2.0 * (v.x * xMz + v.y * yMz) + v.z * (zMz - xMx - yMy)),
      w = 2.0 * w * (v.x * x + v.y * y + v.z * z),
    )

  infix def reverseSandwich(v: Pga3dBivectorBulk): Pga3dBivector =
    val xMx = x * x
    val xMy = x * y
    val xMz = x * z
    val xMw = w * x
    val yMy = y * y
    val yMz = y * z
    val yMw = w * y
    val zMz = z * z
    val zMw = w * z
    Pga3dBivector(
      wx = 2.0 * (v.xy * yMw + v.xz * zMw),
      wy = 2.0 * (v.yz * zMw - v.xy * xMw),
      wz = 2.0 * (-v.xz * xMw - v.yz * yMw),
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

  infix def reverseSandwich(v: Pga3dPointCenter.type): Pga3dTrivector =
    Pga3dTrivector(
      x = -2.0 * w * x,
      y = -2.0 * w * y,
      z = -2.0 * w * z,
      w = (x * x + y * y + z * z),
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
      x = (-v.xy * y - v.xz * z),
      y = (v.xy * x - v.yz * z),
      z = (v.xz * x + v.yz * y),
      w = (-v.wx * x - v.wy * y - v.wz * z),
    )

  infix def cross(v: Pga3dTrivector): Pga3dPseudoScalar =
    Pga3dPseudoScalar(
      i = (v.w * w + v.x * x + v.y * y + v.z * z),
    )

  infix def cross(v: Pga3dQuaternion): Pga3dPlaneIdeal =
    Pga3dPlaneIdeal(
      x = (-v.xy * y - v.xz * z),
      y = (v.xy * x - v.yz * z),
      z = (v.xz * x + v.yz * y),
    )

  infix def cross(v: Pga3dTranslator): Pga3dPlane =
    Pga3dPlane(
      x = 0.0,
      y = 0.0,
      z = 0.0,
      w = (-v.wx * x - v.wy * y - v.wz * z),
    )

  infix def cross(v: Pga3dVector): Pga3dPseudoScalar =
    Pga3dPseudoScalar(
      i = (v.x * x + v.y * y + v.z * z),
    )

  infix def cross(v: Pga3dPoint): Pga3dPseudoScalar =
    Pga3dPseudoScalar(
      i = (w + v.x * x + v.y * y + v.z * z),
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
      x = 0.0,
      y = 0.0,
      z = 0.0,
      w = (-v.wx * x - v.wy * y - v.wz * z),
    )

  infix def cross(v: Pga3dPseudoScalar): Pga3dVector =
    Pga3dVector(
      x = v.i * x,
      y = v.i * y,
      z = v.i * z,
    )

  infix def cross(v: Pga3dPointCenter.type): Pga3dPseudoScalar =
    Pga3dPseudoScalar(
      i = w,
    )


object Pga3dPlane:

  inline val componentsCount = 4

  val zero: Pga3dPlane = Pga3dPlane(0.0, 0.0, 0.0, 0.0)