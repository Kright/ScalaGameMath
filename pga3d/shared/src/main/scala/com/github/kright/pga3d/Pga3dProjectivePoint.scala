package com.github.kright.pga3d

import scala.annotation.targetName

/** this code is generated, see com.github.kright.pga3d.codegen.CodeGenClass */
final case class Pga3dProjectivePoint(x: Double = 0.0,
                                      y: Double = 0.0,
                                      z: Double = 0.0,
                                      w: Double = 0.0) derives CanEqual:

  inline def wyz: Double = -x

  inline def wxz: Double = y

  inline def wxy: Double = -z

  inline def xyz: Double = w

  override def toString: String =
    s"Pga3dProjectivePoint(x = $x, y = $y, z = $z, w = $w)"

  def dual: Pga3dPlane =
    Pga3dPlane(
      x = x,
      y = y,
      z = z,
      w = w,
    )

  def weight: Pga3dVector =
    Pga3dVector(
      x = x,
      y = y,
      z = z,
    )

  def bulk: Pga3dProjectivePoint =
    Pga3dProjectivePoint(
      x = 0.0,
      y = 0.0,
      z = 0.0,
      w = w,
    )

  @targetName("unaryMinus")
  def unary_- : Pga3dProjectivePoint =
    Pga3dProjectivePoint(
      x = -x,
      y = -y,
      z = -z,
      w = -w,
    )

  def reverse: Pga3dProjectivePoint =
    -this

  def antiReverse: Pga3dProjectivePoint =
    this

  def bulkNormSquare: Double =
    w * w

  def bulkNorm: Double =
    Math.sqrt(bulkNormSquare)

  def normalizedByBulk =
    this / bulkNorm

  def weightNormSquare: Double =
    (x * x + y * y + z * z)

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
  def *(v: Double): Pga3dProjectivePoint =
    Pga3dProjectivePoint(
      x = v * x,
      y = v * y,
      z = v * z,
      w = v * w,
    )

  @targetName("div")
  def /(v: Double): Pga3dProjectivePoint =
    this * (1.0 / v)

  @targetName("plus")
  def +(v: Pga3dProjectivePoint): Pga3dProjectivePoint =
    Pga3dProjectivePoint(
      x = (v.x + x),
      y = (v.y + y),
      z = (v.z + z),
      w = (v.w + w),
    )

  @targetName("minus")
  def -(v: Pga3dProjectivePoint): Pga3dProjectivePoint =
    Pga3dProjectivePoint(
      x = (x - v.x),
      y = (y - v.y),
      z = (z - v.z),
      w = (w - v.w),
    )

  def madd(v: Pga3dProjectivePoint, mult: Double): Pga3dProjectivePoint =
    Pga3dProjectivePoint(
      x = (x + mult * v.x),
      y = (y + mult * v.y),
      z = (z + mult * v.z),
      w = (w + mult * v.w),
    )

  @targetName("plus")
  def +(v: Pga3dPoint): Pga3dProjectivePoint =
    Pga3dProjectivePoint(
      x = (v.x + x),
      y = (v.y + y),
      z = (v.z + z),
      w = (1.0 + w),
    )

  @targetName("minus")
  def -(v: Pga3dPoint): Pga3dProjectivePoint =
    Pga3dProjectivePoint(
      x = (x - v.x),
      y = (y - v.y),
      z = (z - v.z),
      w = (-1.0 + w),
    )

  def madd(v: Pga3dPoint, mult: Double): Pga3dProjectivePoint =
    Pga3dProjectivePoint(
      x = (x + mult * v.x),
      y = (y + mult * v.y),
      z = (z + mult * v.z),
      w = (mult + w),
    )

  @targetName("plus")
  def +(v: Pga3dVector): Pga3dProjectivePoint =
    Pga3dProjectivePoint(
      x = (v.x + x),
      y = (v.y + y),
      z = (v.z + z),
      w = w,
    )

  @targetName("minus")
  def -(v: Pga3dVector): Pga3dProjectivePoint =
    Pga3dProjectivePoint(
      x = (x - v.x),
      y = (y - v.y),
      z = (z - v.z),
      w = w,
    )

  def madd(v: Pga3dVector, mult: Double): Pga3dProjectivePoint =
    Pga3dProjectivePoint(
      x = (x + mult * v.x),
      y = (y + mult * v.y),
      z = (z + mult * v.z),
      w = w,
    )

  def multiplyElementwise(v: Pga3dProjectivePoint): Pga3dProjectivePoint =
    Pga3dProjectivePoint(
      x = -v.x * x,
      y = v.y * y,
      z = -v.z * z,
      w = v.w * w,
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
      xyz = w,
      i = 0.0,
    )

  def toVectorUnsafe: Pga3dVector =
    Pga3dVector(
      x = x,
      y = y,
      z = z,
    )

  def toPointUnsafe: Pga3dPoint =
    Pga3dPoint(
      x = x,
      y = y,
      z = z,
    )

  def toPoint: Pga3dPoint =
    Pga3dPoint(
      x = x / w,
      y = y / w,
      z = z / w,
    )

  /** fused plane.dot(point).geometric(plane) */
  def projectOntoPlane(plane: Pga3dPlane): Pga3dProjectivePoint =
    Pga3dProjectivePoint(
      x = (plane.y * plane.y * x + plane.z * plane.z * x - plane.w * plane.x * w - plane.x * plane.y * y - plane.x * plane.z * z),
      y = (plane.y * (-plane.w * w - plane.x * x - plane.z * z) + y * (plane.x * plane.x + plane.z * plane.z)),
      z = (plane.x * plane.x * z + plane.y * plane.y * z - plane.w * plane.z * w - plane.x * plane.z * x - plane.y * plane.z * y),
      w = w * (plane.x * plane.x + plane.y * plane.y + plane.z * plane.z),
    )

  /**
   * fused -line.dot(point).geometric(line).toPointUnsafe
   * not applicable for Bivector, input should be a line
   * example of result for Bivector:
   * Pga3dMultivector(
   *   s = 0.0,
   *   w = w * (line.wy * line.xz - line.wx * line.yz - line.wz * line.xy),
   *   x = 0.0,
   *   y = 0.0,
   *   z = 0.0,
   *   wx = 0.0,
   *   wy = 0.0,
   *   wz = 0.0,
   *   xy = 0.0,
   *   xz = 0.0,
   *   yz = 0.0,
   *   wxy = (line.xy * (line.xz * y - line.xy * z - line.yz * x) + w * (-line.wx * line.xz - line.wy * line.yz)),
   *   wxz = (line.xz * (line.xz * y - line.xy * z - line.yz * x) + w * (line.wx * line.xy - line.wz * line.yz)),
   *   wyz = (line.yz * (line.xz * y - line.xy * z - line.yz * x) + w * (line.wy * line.xy + line.wz * line.xz)),
   *   xyz = w * (line.xy * line.xy + line.xz * line.xz + line.yz * line.yz),
   *   i = 0.0,
   * )
   */
  def projectOntoLine(line: Pga3dBivector): Pga3dProjectivePoint =
    Pga3dProjectivePoint(
      x = (line.xy * line.yz * z + line.yz * line.yz * x - line.wy * line.xy * w - line.wz * line.xz * w - line.xz * line.yz * y),
      y = (line.xz * (line.xz * y - line.xy * z - line.yz * x) + w * (line.wx * line.xy - line.wz * line.yz)),
      z = (line.wx * line.xz * w + line.wy * line.yz * w + line.xy * line.xy * z + line.xy * line.yz * x - line.xy * line.xz * y),
      w = w * (line.xy * line.xy + line.xz * line.xz + line.yz * line.yz),
    )

  infix def geometric(v: Pga3dMotor): Pga3dMultivector =
    Pga3dMultivector(
      s = 0.0,
      w = (v.i * w + v.xy * z + v.yz * x - v.xz * y),
      x = -v.yz * w,
      y = v.xz * w,
      z = -v.xy * w,
      wx = 0.0,
      wy = 0.0,
      wz = 0.0,
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
      wxy = (-v.s * z - v.wz * w - v.xz * x - v.yz * y),
      wxz = (v.s * y + v.wy * w + v.xy * x - v.yz * z),
      wyz = (v.xy * y + v.xz * z - v.s * x - v.wx * w),
      xyz = v.s * w,
      i = 0.0,
    )

  infix def geometric(v: Pga3dPlane): Pga3dMotor =
    Pga3dMotor(
      s = 0.0,
      wx = (v.z * y - v.y * z),
      wy = (v.x * z - v.z * x),
      wz = (v.y * x - v.x * y),
      xy = v.z * w,
      xz = -v.y * w,
      yz = v.x * w,
      i = (-v.w * w - v.x * x - v.y * y - v.z * z),
    )

  infix def geometric(v: Pga3dBivector): Pga3dMultivector =
    Pga3dMultivector(
      s = 0.0,
      w = (v.xy * z + v.yz * x - v.xz * y),
      x = -v.yz * w,
      y = v.xz * w,
      z = -v.xy * w,
      wx = 0.0,
      wy = 0.0,
      wz = 0.0,
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
      wxy = (-v.wz * w - v.xz * x - v.yz * y),
      wxz = (v.wy * w + v.xy * x - v.yz * z),
      wyz = (v.xy * y + v.xz * z - v.wx * w),
      xyz = 0.0,
      i = 0.0,
    )

  infix def geometric(v: Pga3dProjectivePoint): Pga3dMotor =
    Pga3dMotor(
      s = -v.w * w,
      wx = (v.w * x - v.x * w),
      wy = (v.w * y - v.y * w),
      wz = (v.w * z - v.z * w),
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
      i = 0.0,
    )

  infix def geometric(v: Pga3dQuaternion): Pga3dMultivector =
    Pga3dMultivector(
      s = 0.0,
      w = (v.xy * z + v.yz * x - v.xz * y),
      x = -v.yz * w,
      y = v.xz * w,
      z = -v.xy * w,
      wx = 0.0,
      wy = 0.0,
      wz = 0.0,
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
      wxy = (-v.s * z - v.xz * x - v.yz * y),
      wxz = (v.s * y + v.xy * x - v.yz * z),
      wyz = (v.xy * y + v.xz * z - v.s * x),
      xyz = v.s * w,
      i = 0.0,
    )

  infix def geometric(v: Pga3dTranslator): Pga3dProjectivePoint =
    Pga3dProjectivePoint(
      x = (x + v.wx * w),
      y = (y + v.wy * w),
      z = (z + v.wz * w),
      w = w,
    )

  infix def geometric(v: Pga3dVector): Pga3dBivectorWeight =
    Pga3dBivectorWeight(
      wx = -v.x * w,
      wy = -v.y * w,
      wz = -v.z * w,
    )

  infix def geometric(v: Pga3dPoint): Pga3dMotor =
    Pga3dMotor(
      s = -w,
      wx = (x - v.x * w),
      wy = (y - v.y * w),
      wz = (z - v.z * w),
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
      i = 0.0,
    )

  infix def geometric(v: Pga3dPlaneIdeal): Pga3dMotor =
    Pga3dMotor(
      s = 0.0,
      wx = (v.z * y - v.y * z),
      wy = (v.x * z - v.z * x),
      wz = (v.y * x - v.x * y),
      xy = v.z * w,
      xz = -v.y * w,
      yz = v.x * w,
      i = (-v.x * x - v.y * y - v.z * z),
    )

  infix def geometric(v: Pga3dBivectorBulk): Pga3dMultivector =
    Pga3dMultivector(
      s = 0.0,
      w = (v.xy * z + v.yz * x - v.xz * y),
      x = -v.yz * w,
      y = v.xz * w,
      z = -v.xy * w,
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

  infix def geometric(v: Pga3dBivectorWeight): Pga3dVector =
    Pga3dVector(
      x = v.wx * w,
      y = v.wy * w,
      z = v.wz * w,
    )

  infix def geometric(v: Pga3dPseudoScalar): Pga3dPlane =
    Pga3dPlane(
      x = 0.0,
      y = 0.0,
      z = 0.0,
      w = v.i * w,
    )

  infix def geometric(v: Pga3dPointCenter.type): Pga3dMotor =
    Pga3dMotor(
      s = -w,
      wx = x,
      wy = y,
      wz = z,
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
      i = 0.0,
    )

  infix def dot(v: Pga3dMotor): Pga3dMultivector =
    Pga3dMultivector(
      s = 0.0,
      w = (v.i * w + v.xy * z + v.yz * x - v.xz * y),
      x = -v.yz * w,
      y = v.xz * w,
      z = -v.xy * w,
      wx = 0.0,
      wy = 0.0,
      wz = 0.0,
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
      wxy = -v.s * z,
      wxz = v.s * y,
      wyz = -v.s * x,
      xyz = v.s * w,
      i = 0.0,
    )

  infix def dot(v: Pga3dPlane): Pga3dBivector =
    Pga3dBivector(
      wx = (v.z * y - v.y * z),
      wy = (v.x * z - v.z * x),
      wz = (v.y * x - v.x * y),
      xy = v.z * w,
      xz = -v.y * w,
      yz = v.x * w,
    )

  infix def dot(v: Pga3dBivector): Pga3dPlane =
    Pga3dPlane(
      x = -v.yz * w,
      y = v.xz * w,
      z = -v.xy * w,
      w = (v.xy * z + v.yz * x - v.xz * y),
    )

  infix def dot(v: Pga3dProjectivePoint): Double =
    -v.w * w

  infix def dot(v: Pga3dQuaternion): Pga3dMultivector =
    Pga3dMultivector(
      s = 0.0,
      w = (v.xy * z + v.yz * x - v.xz * y),
      x = -v.yz * w,
      y = v.xz * w,
      z = -v.xy * w,
      wx = 0.0,
      wy = 0.0,
      wz = 0.0,
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
      wxy = -v.s * z,
      wxz = v.s * y,
      wyz = -v.s * x,
      xyz = v.s * w,
      i = 0.0,
    )

  infix def dot(v: Pga3dTranslator): Pga3dProjectivePoint =
    this

  infix def dot(v: Pga3dPoint): Double =
    -w

  infix def dot(v: Pga3dPlaneIdeal): Pga3dBivector =
    Pga3dBivector(
      wx = (v.z * y - v.y * z),
      wy = (v.x * z - v.z * x),
      wz = (v.y * x - v.x * y),
      xy = v.z * w,
      xz = -v.y * w,
      yz = v.x * w,
    )

  infix def dot(v: Pga3dBivectorBulk): Pga3dPlane =
    Pga3dPlane(
      x = -v.yz * w,
      y = v.xz * w,
      z = -v.xy * w,
      w = (v.xy * z + v.yz * x - v.xz * y),
    )

  infix def dot(v: Pga3dPseudoScalar): Pga3dPlane =
    Pga3dPlane(
      x = 0.0,
      y = 0.0,
      z = 0.0,
      w = v.i * w,
    )

  infix def dot(v: Pga3dPointCenter.type): Double =
    -w

  infix def wedge(v: Pga3dMotor): Pga3dProjectivePoint =
    Pga3dProjectivePoint(
      x = v.s * x,
      y = v.s * y,
      z = v.s * z,
      w = v.s * w,
    )

  inline infix def ^(v: Pga3dMotor): Pga3dProjectivePoint = wedge(v)

  infix def wedge(v: Pga3dPlane): Pga3dPseudoScalar =
    Pga3dPseudoScalar(
      i = (-v.w * w - v.x * x - v.y * y - v.z * z),
    )

  inline infix def ^(v: Pga3dPlane): Pga3dPseudoScalar = wedge(v)

  infix def wedge(v: Pga3dQuaternion): Pga3dProjectivePoint =
    Pga3dProjectivePoint(
      x = v.s * x,
      y = v.s * y,
      z = v.s * z,
      w = v.s * w,
    )

  inline infix def ^(v: Pga3dQuaternion): Pga3dProjectivePoint = wedge(v)

  infix def wedge(v: Pga3dTranslator): Pga3dProjectivePoint =
    this

  inline infix def ^(v: Pga3dTranslator): Pga3dProjectivePoint = wedge(v)

  infix def wedge(v: Pga3dPlaneIdeal): Pga3dPseudoScalar =
    Pga3dPseudoScalar(
      i = (-v.x * x - v.y * y - v.z * z),
    )

  inline infix def ^(v: Pga3dPlaneIdeal): Pga3dPseudoScalar = wedge(v)

  infix def antiGeometric(v: Pga3dMotor): Pga3dMultivector =
    Pga3dMultivector(
      s = 0.0,
      w = (v.wx * x + v.wy * y + v.wz * z),
      x = (v.s * x + v.xy * y + v.xz * z - v.wx * w),
      y = (v.s * y + v.yz * z - v.wy * w - v.xy * x),
      z = (v.s * z - v.wz * w - v.xz * x - v.yz * y),
      wx = 0.0,
      wy = 0.0,
      wz = 0.0,
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
      wxy = (v.wy * x - v.i * z - v.wx * y),
      wxz = (v.i * y + v.wz * x - v.wx * z),
      wyz = (v.wz * y - v.i * x - v.wy * z),
      xyz = (v.i * w + v.xz * y - v.xy * z - v.yz * x),
      i = 0.0,
    )

  infix def antiGeometric(v: Pga3dPlane): Pga3dMotor =
    Pga3dMotor(
      s = (v.w * w + v.x * x + v.y * y + v.z * z),
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
      x = (v.xy * y + v.xz * z - v.wx * w),
      y = (v.yz * z - v.wy * w - v.xy * x),
      z = (-v.wz * w - v.xz * x - v.yz * y),
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

  infix def antiGeometric(v: Pga3dProjectivePoint): Pga3dMotor =
    Pga3dMotor(
      s = 0.0,
      wx = (v.z * y - v.y * z),
      wy = (v.x * z - v.z * x),
      wz = (v.y * x - v.x * y),
      xy = (v.z * w - v.w * z),
      xz = (v.w * y - v.y * w),
      yz = (v.x * w - v.w * x),
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
      x = (x - v.wx * w),
      y = (y - v.wy * w),
      z = (z - v.wz * w),
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
      xy = v.z * w,
      xz = -v.y * w,
      yz = v.x * w,
      i = (v.x * x + v.y * y + v.z * z),
    )

  infix def antiGeometric(v: Pga3dPoint): Pga3dMotor =
    Pga3dMotor(
      s = 0.0,
      wx = (v.z * y - v.y * z),
      wy = (v.x * z - v.z * x),
      wz = (v.y * x - v.x * y),
      xy = (-z + v.z * w),
      xz = (y - v.y * w),
      yz = (-x + v.x * w),
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
      x = -v.wx * w,
      y = -v.wy * w,
      z = -v.wz * w,
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

  infix def antiGeometric(v: Pga3dPseudoScalar): Pga3dProjectivePoint =
    Pga3dProjectivePoint(
      x = v.i * x,
      y = v.i * y,
      z = v.i * z,
      w = v.i * w,
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
      xyz = (v.i * w + v.xz * y - v.xy * z - v.yz * x),
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

  infix def antiDot(v: Pga3dBivector): Pga3dProjectivePoint =
    Pga3dProjectivePoint(
      x = (v.wy * z - v.wz * y),
      y = (v.wz * x - v.wx * z),
      z = (v.wx * y - v.wy * x),
      w = (v.xz * y - v.xy * z - v.yz * x),
    )

  infix def antiDot(v: Pga3dProjectivePoint): Pga3dPseudoScalar =
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

  infix def antiDot(v: Pga3dPoint): Pga3dPseudoScalar =
    Pga3dPseudoScalar(
      i = (v.x * x + v.y * y + v.z * z),
    )

  infix def antiDot(v: Pga3dPlaneIdeal): Pga3dBivectorBulk =
    Pga3dBivectorBulk(
      xy = (v.x * y - v.y * x),
      xz = (v.x * z - v.z * x),
      yz = (v.y * z - v.z * y),
    )

  infix def antiDot(v: Pga3dBivectorBulk): Pga3dProjectivePoint =
    Pga3dProjectivePoint(
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

  infix def antiDot(v: Pga3dPseudoScalar): Pga3dProjectivePoint =
    Pga3dProjectivePoint(
      x = v.i * x,
      y = v.i * y,
      z = v.i * z,
      w = v.i * w,
    )

  infix def antiDotI(v: Pga3dProjectivePoint): Double =
    (v.x * x + v.y * y + v.z * z)

  infix def antiDotI(v: Pga3dVector): Double =
    (v.x * x + v.y * y + v.z * z)

  infix def antiDotI(v: Pga3dPoint): Double =
    (v.x * x + v.y * y + v.z * z)

  infix def antiWedge(v: Pga3dMotor): Pga3dMultivector =
    Pga3dMultivector(
      s = 0.0,
      w = (v.wx * x + v.wy * y + v.wz * z),
      x = (v.xy * y + v.xz * z - v.wx * w),
      y = (v.yz * z - v.wy * w - v.xy * x),
      z = (-v.wz * w - v.xz * x - v.yz * y),
      wx = 0.0,
      wy = 0.0,
      wz = 0.0,
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
      wxy = -v.i * z,
      wxz = v.i * y,
      wyz = -v.i * x,
      xyz = v.i * w,
      i = 0.0,
    )

  inline infix def v(v: Pga3dMotor): Pga3dMultivector = antiWedge(v)

  infix def antiWedge(v: Pga3dPlane): Double =
    (v.w * w + v.x * x + v.y * y + v.z * z)

  inline infix def v(v: Pga3dPlane): Double = antiWedge(v)

  infix def antiWedge(v: Pga3dBivector): Pga3dPlane =
    Pga3dPlane(
      x = (v.xy * y + v.xz * z - v.wx * w),
      y = (v.yz * z - v.wy * w - v.xy * x),
      z = (-v.wz * w - v.xz * x - v.yz * y),
      w = (v.wx * x + v.wy * y + v.wz * z),
    )

  inline infix def v(v: Pga3dBivector): Pga3dPlane = antiWedge(v)

  infix def antiWedge(v: Pga3dProjectivePoint): Pga3dBivector =
    Pga3dBivector(
      wx = (v.z * y - v.y * z),
      wy = (v.x * z - v.z * x),
      wz = (v.y * x - v.x * y),
      xy = (v.z * w - v.w * z),
      xz = (v.w * y - v.y * w),
      yz = (v.x * w - v.w * x),
    )

  inline infix def v(v: Pga3dProjectivePoint): Pga3dBivector = antiWedge(v)

  infix def antiWedge(v: Pga3dQuaternion): Pga3dPlaneIdeal =
    Pga3dPlaneIdeal(
      x = (v.xy * y + v.xz * z),
      y = (v.yz * z - v.xy * x),
      z = (-v.xz * x - v.yz * y),
    )

  inline infix def v(v: Pga3dQuaternion): Pga3dPlaneIdeal = antiWedge(v)

  infix def antiWedge(v: Pga3dTranslator): Pga3dPlane =
    Pga3dPlane(
      x = -v.wx * w,
      y = -v.wy * w,
      z = -v.wz * w,
      w = (v.wx * x + v.wy * y + v.wz * z),
    )

  inline infix def v(v: Pga3dTranslator): Pga3dPlane = antiWedge(v)

  infix def antiWedge(v: Pga3dVector): Pga3dBivector =
    Pga3dBivector(
      wx = (v.z * y - v.y * z),
      wy = (v.x * z - v.z * x),
      wz = (v.y * x - v.x * y),
      xy = v.z * w,
      xz = -v.y * w,
      yz = v.x * w,
    )

  inline infix def v(v: Pga3dVector): Pga3dBivector = antiWedge(v)

  infix def antiWedge(v: Pga3dPoint): Pga3dBivector =
    Pga3dBivector(
      wx = (v.z * y - v.y * z),
      wy = (v.x * z - v.z * x),
      wz = (v.y * x - v.x * y),
      xy = (-z + v.z * w),
      xz = (y - v.y * w),
      yz = (-x + v.x * w),
    )

  inline infix def v(v: Pga3dPoint): Pga3dBivector = antiWedge(v)

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
      x = -v.wx * w,
      y = -v.wy * w,
      z = -v.wz * w,
      w = (v.wx * x + v.wy * y + v.wz * z),
    )

  inline infix def v(v: Pga3dBivectorWeight): Pga3dPlane = antiWedge(v)

  infix def antiWedge(v: Pga3dPseudoScalar): Pga3dProjectivePoint =
    Pga3dProjectivePoint(
      x = v.i * x,
      y = v.i * y,
      z = v.i * z,
      w = v.i * w,
    )

  inline infix def v(v: Pga3dPseudoScalar): Pga3dProjectivePoint = antiWedge(v)

  infix def antiWedge(v: Pga3dPointCenter.type): Pga3dBivectorBulk =
    Pga3dBivectorBulk(
      xy = -z,
      xz = y,
      yz = -x,
    )

  inline infix def v(v: Pga3dPointCenter.type): Pga3dBivectorBulk = antiWedge(v)

  infix def sandwich(v: Pga3dMotor): Pga3dMotor =
    val yMw = w * y
    val wMw = w * w
    Pga3dMotor(
      s = v.s * wMw,
      wx = (2.0 * (v.xy * yMw + v.xz * w * z) - v.wx * wMw),
      wy = (-v.wy * wMw + 2.0 * w * (v.yz * z - v.xy * x)),
      wz = (2.0 * (-v.yz * yMw - v.xz * w * x) - v.wz * wMw),
      xy = v.xy * wMw,
      xz = v.xz * wMw,
      yz = v.yz * wMw,
      i = -v.i * wMw,
    )

  infix def sandwich(v: Pga3dPlane): Pga3dPlane =
    val wMw = w * w
    Pga3dPlane(
      x = v.x * wMw,
      y = v.y * wMw,
      z = v.z * wMw,
      w = (-v.w * wMw + 2.0 * w * (-v.x * x - v.y * y - v.z * z)),
    )

  infix def sandwich(v: Pga3dBivector): Pga3dBivector =
    val yMw = w * y
    val wMw = w * w
    Pga3dBivector(
      wx = (2.0 * (v.xy * yMw + v.xz * w * z) - v.wx * wMw),
      wy = (-v.wy * wMw + 2.0 * w * (v.yz * z - v.xy * x)),
      wz = (2.0 * (-v.yz * yMw - v.xz * w * x) - v.wz * wMw),
      xy = v.xy * wMw,
      xz = v.xz * wMw,
      yz = v.yz * wMw,
    )

  infix def sandwich(v: Pga3dProjectivePoint): Pga3dProjectivePoint =
    val wMw = w * w
    Pga3dProjectivePoint(
      x = (-v.x * wMw + 2.0 * v.w * w * x),
      y = (-v.y * wMw + 2.0 * v.w * w * y),
      z = (-v.z * wMw + 2.0 * v.w * w * z),
      w = v.w * wMw,
    )

  infix def sandwich(v: Pga3dQuaternion): Pga3dMotor =
    val yMw = w * y
    val wMw = w * w
    Pga3dMotor(
      s = v.s * wMw,
      wx = 2.0 * (v.xy * yMw + v.xz * w * z),
      wy = 2.0 * w * (v.yz * z - v.xy * x),
      wz = 2.0 * (-v.yz * yMw - v.xz * w * x),
      xy = v.xy * wMw,
      xz = v.xz * wMw,
      yz = v.yz * wMw,
      i = 0.0,
    )

  infix def sandwich(v: Pga3dTranslator): Pga3dMotor =
    val wMw = w * w
    Pga3dMotor(
      s = wMw,
      wx = -v.wx * wMw,
      wy = -v.wy * wMw,
      wz = -v.wz * wMw,
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
      i = 0.0,
    )

  infix def sandwich(v: Pga3dVector): Pga3dVector =
    val wMw = w * w
    Pga3dVector(
      x = -v.x * wMw,
      y = -v.y * wMw,
      z = -v.z * wMw,
    )

  infix def sandwich(v: Pga3dPoint): Pga3dProjectivePoint =
    val wMw = w * w
    Pga3dProjectivePoint(
      x = (-v.x * wMw + 2.0 * w * x),
      y = (-v.y * wMw + 2.0 * w * y),
      z = (-v.z * wMw + 2.0 * w * z),
      w = wMw,
    )

  infix def sandwich(v: Pga3dPlaneIdeal): Pga3dPlane =
    val wMw = w * w
    Pga3dPlane(
      x = v.x * wMw,
      y = v.y * wMw,
      z = v.z * wMw,
      w = 2.0 * w * (-v.x * x - v.y * y - v.z * z),
    )

  infix def sandwich(v: Pga3dBivectorBulk): Pga3dBivector =
    val yMw = w * y
    val wMw = w * w
    Pga3dBivector(
      wx = 2.0 * (v.xy * yMw + v.xz * w * z),
      wy = 2.0 * w * (v.yz * z - v.xy * x),
      wz = 2.0 * (-v.yz * yMw - v.xz * w * x),
      xy = v.xy * wMw,
      xz = v.xz * wMw,
      yz = v.yz * wMw,
    )

  infix def sandwich(v: Pga3dBivectorWeight): Pga3dBivectorWeight =
    val wMw = w * w
    Pga3dBivectorWeight(
      wx = -v.wx * wMw,
      wy = -v.wy * wMw,
      wz = -v.wz * wMw,
    )

  infix def sandwich(v: Pga3dPseudoScalar): Pga3dPseudoScalar =
    Pga3dPseudoScalar(
      i = -v.i * w * w,
    )

  infix def sandwich(v: Pga3dPointCenter.type): Pga3dProjectivePoint =
    Pga3dProjectivePoint(
      x = 2.0 * w * x,
      y = 2.0 * w * y,
      z = 2.0 * w * z,
      w = w * w,
    )

  infix def reverseSandwich(v: Pga3dMotor): Pga3dMotor =
    val yMw = w * y
    val wMw = w * w
    Pga3dMotor(
      s = v.s * wMw,
      wx = (2.0 * (v.xy * yMw + v.xz * w * z) - v.wx * wMw),
      wy = (-v.wy * wMw + 2.0 * w * (v.yz * z - v.xy * x)),
      wz = (2.0 * (-v.yz * yMw - v.xz * w * x) - v.wz * wMw),
      xy = v.xy * wMw,
      xz = v.xz * wMw,
      yz = v.yz * wMw,
      i = -v.i * wMw,
    )

  infix def reverseSandwich(v: Pga3dPlane): Pga3dPlane =
    val wMw = w * w
    Pga3dPlane(
      x = v.x * wMw,
      y = v.y * wMw,
      z = v.z * wMw,
      w = (-v.w * wMw + 2.0 * w * (-v.x * x - v.y * y - v.z * z)),
    )

  infix def reverseSandwich(v: Pga3dBivector): Pga3dBivector =
    val yMw = w * y
    val wMw = w * w
    Pga3dBivector(
      wx = (2.0 * (v.xy * yMw + v.xz * w * z) - v.wx * wMw),
      wy = (-v.wy * wMw + 2.0 * w * (v.yz * z - v.xy * x)),
      wz = (2.0 * (-v.yz * yMw - v.xz * w * x) - v.wz * wMw),
      xy = v.xy * wMw,
      xz = v.xz * wMw,
      yz = v.yz * wMw,
    )

  infix def reverseSandwich(v: Pga3dProjectivePoint): Pga3dProjectivePoint =
    val wMw = w * w
    Pga3dProjectivePoint(
      x = (-v.x * wMw + 2.0 * v.w * w * x),
      y = (-v.y * wMw + 2.0 * v.w * w * y),
      z = (-v.z * wMw + 2.0 * v.w * w * z),
      w = v.w * wMw,
    )

  infix def reverseSandwich(v: Pga3dQuaternion): Pga3dMotor =
    val yMw = w * y
    val wMw = w * w
    Pga3dMotor(
      s = v.s * wMw,
      wx = 2.0 * (v.xy * yMw + v.xz * w * z),
      wy = 2.0 * w * (v.yz * z - v.xy * x),
      wz = 2.0 * (-v.yz * yMw - v.xz * w * x),
      xy = v.xy * wMw,
      xz = v.xz * wMw,
      yz = v.yz * wMw,
      i = 0.0,
    )

  infix def reverseSandwich(v: Pga3dTranslator): Pga3dMotor =
    val wMw = w * w
    Pga3dMotor(
      s = wMw,
      wx = -v.wx * wMw,
      wy = -v.wy * wMw,
      wz = -v.wz * wMw,
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
      i = 0.0,
    )

  infix def reverseSandwich(v: Pga3dVector): Pga3dVector =
    val wMw = w * w
    Pga3dVector(
      x = -v.x * wMw,
      y = -v.y * wMw,
      z = -v.z * wMw,
    )

  infix def reverseSandwich(v: Pga3dPoint): Pga3dProjectivePoint =
    val wMw = w * w
    Pga3dProjectivePoint(
      x = (-v.x * wMw + 2.0 * w * x),
      y = (-v.y * wMw + 2.0 * w * y),
      z = (-v.z * wMw + 2.0 * w * z),
      w = wMw,
    )

  infix def reverseSandwich(v: Pga3dPlaneIdeal): Pga3dPlane =
    val wMw = w * w
    Pga3dPlane(
      x = v.x * wMw,
      y = v.y * wMw,
      z = v.z * wMw,
      w = 2.0 * w * (-v.x * x - v.y * y - v.z * z),
    )

  infix def reverseSandwich(v: Pga3dBivectorBulk): Pga3dBivector =
    val yMw = w * y
    val wMw = w * w
    Pga3dBivector(
      wx = 2.0 * (v.xy * yMw + v.xz * w * z),
      wy = 2.0 * w * (v.yz * z - v.xy * x),
      wz = 2.0 * (-v.yz * yMw - v.xz * w * x),
      xy = v.xy * wMw,
      xz = v.xz * wMw,
      yz = v.yz * wMw,
    )

  infix def reverseSandwich(v: Pga3dBivectorWeight): Pga3dBivectorWeight =
    val wMw = w * w
    Pga3dBivectorWeight(
      wx = -v.wx * wMw,
      wy = -v.wy * wMw,
      wz = -v.wz * wMw,
    )

  infix def reverseSandwich(v: Pga3dPseudoScalar): Pga3dPseudoScalar =
    Pga3dPseudoScalar(
      i = -v.i * w * w,
    )

  infix def reverseSandwich(v: Pga3dPointCenter.type): Pga3dProjectivePoint =
    Pga3dProjectivePoint(
      x = 2.0 * w * x,
      y = 2.0 * w * y,
      z = 2.0 * w * z,
      w = w * w,
    )

  infix def cross(v: Pga3dMotor): Pga3dMultivector =
    Pga3dMultivector(
      s = 0.0,
      w = v.i * w,
      x = 0.0,
      y = 0.0,
      z = 0.0,
      wx = 0.0,
      wy = 0.0,
      wz = 0.0,
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
      wxy = (-v.wz * w - v.xz * x - v.yz * y),
      wxz = (v.wy * w + v.xy * x - v.yz * z),
      wyz = (v.xy * y + v.xz * z - v.wx * w),
      xyz = 0.0,
      i = 0.0,
    )

  infix def cross(v: Pga3dPlane): Pga3dPseudoScalar =
    Pga3dPseudoScalar(
      i = (-v.w * w - v.x * x - v.y * y - v.z * z),
    )

  infix def cross(v: Pga3dBivector): Pga3dVector =
    Pga3dVector(
      x = (v.wx * w - v.xy * y - v.xz * z),
      y = (v.wy * w + v.xy * x - v.yz * z),
      z = (v.wz * w + v.xz * x + v.yz * y),
    )

  infix def cross(v: Pga3dProjectivePoint): Pga3dBivectorWeight =
    Pga3dBivectorWeight(
      wx = (v.w * x - v.x * w),
      wy = (v.w * y - v.y * w),
      wz = (v.w * z - v.z * w),
    )

  infix def cross(v: Pga3dQuaternion): Pga3dVector =
    Pga3dVector(
      x = (-v.xy * y - v.xz * z),
      y = (v.xy * x - v.yz * z),
      z = (v.xz * x + v.yz * y),
    )

  infix def cross(v: Pga3dTranslator): Pga3dVector =
    Pga3dVector(
      x = v.wx * w,
      y = v.wy * w,
      z = v.wz * w,
    )

  infix def cross(v: Pga3dVector): Pga3dBivectorWeight =
    Pga3dBivectorWeight(
      wx = -v.x * w,
      wy = -v.y * w,
      wz = -v.z * w,
    )

  infix def cross(v: Pga3dPoint): Pga3dBivectorWeight =
    Pga3dBivectorWeight(
      wx = (x - v.x * w),
      wy = (y - v.y * w),
      wz = (z - v.z * w),
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

  infix def cross(v: Pga3dBivectorWeight): Pga3dVector =
    Pga3dVector(
      x = v.wx * w,
      y = v.wy * w,
      z = v.wz * w,
    )

  infix def cross(v: Pga3dPseudoScalar): Pga3dPlane =
    Pga3dPlane(
      x = 0.0,
      y = 0.0,
      z = 0.0,
      w = v.i * w,
    )

  infix def cross(v: Pga3dPointCenter.type): Pga3dBivectorWeight =
    Pga3dBivectorWeight(
      wx = x,
      wy = y,
      wz = z,
    )


object Pga3dProjectivePoint:

  inline val componentsCount = 4

  val zero: Pga3dProjectivePoint = Pga3dProjectivePoint(0.0, 0.0, 0.0, 0.0)

  def blade3(wxy: Double, wxz: Double, wyz: Double, xyz: Double): Pga3dProjectivePoint =
    Pga3dProjectivePoint(
      x = -wyz,
      y = wxz,
      z = -wxy,
      w = xyz,
    )

  def interpolate(a: Pga3dProjectivePoint, b: Pga3dProjectivePoint, t: Double): Pga3dProjectivePoint =
    a * (1.0 - t) + b * t