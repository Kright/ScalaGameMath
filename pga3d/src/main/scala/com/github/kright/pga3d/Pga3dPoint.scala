package com.github.kright.pga3d

/** this code is generated, see com.github.kright.pga3d.codegen.CodeGenClass */
final case class Pga3dPoint(x: Double = 0.0,
                            y: Double = 0.0,
                            z: Double = 0.0):
  inline val w = 1.0

  inline def wyz: Double = -x

  inline def wxz: Double = y

  inline def wxy: Double = -z

  inline def xyz: Double = 1.0

  override def toString: String =
    s"Pga3dPoint(x = $x, y = $y, z = $z)"

  def dual: Pga3dPlane =
    Pga3dPlane(
      x = x,
      y = y,
      z = z,
      w = 1.0,
    )

  def weight: Pga3dVector =
    Pga3dVector(
      x = x,
      y = y,
      z = z,
    )

  def bulk: Pga3dPointCenter.type =
    Pga3dPointCenter

  def unary_- : Pga3dTrivector =
    Pga3dTrivector(
      x = -x,
      y = -y,
      z = -z,
      w = -1.0,
    )

  def reverse: Pga3dTrivector =
    Pga3dTrivector(
      x = -x,
      y = -y,
      z = -z,
      w = -1.0,
    )

  def antiReverse: Pga3dPoint =
    this

  def bulkNormSquare: Double =
    1.0

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
    (1.0 + x * x + y * y + z * z)

  def norm: Double =
    Math.sqrt(normSquare)

  def normalizedByNorm =
    this / norm

  def *(v: Double): Pga3dTrivector =
    Pga3dTrivector(
      x = v * x,
      y = v * y,
      z = v * z,
      w = v,
    )

  inline def /(v: Double): Pga3dTrivector =
    this * (1.0 / v)

  def +(v: Pga3dTrivector): Pga3dTrivector =
    Pga3dTrivector(
      x = (v.x + x),
      y = (v.y + y),
      z = (v.z + z),
      w = (1.0 + v.w),
    )

  def -(v: Pga3dTrivector): Pga3dTrivector =
    Pga3dTrivector(
      x = (x - v.x),
      y = (y - v.y),
      z = (z - v.z),
      w = (1.0 - v.w),
    )

  def madd(v: Pga3dTrivector, mult: Double): Pga3dTrivector =
    Pga3dTrivector(
      x = (x + mult * v.x),
      y = (y + mult * v.y),
      z = (z + mult * v.z),
      w = (1.0 + mult * v.w),
    )

  def +(v: Pga3dPoint): Pga3dTrivector =
    Pga3dTrivector(
      x = (v.x + x),
      y = (v.y + y),
      z = (v.z + z),
      w = 2.0,
    )

  def -(v: Pga3dPoint): Pga3dVector =
    Pga3dVector(
      x = (x - v.x),
      y = (y - v.y),
      z = (z - v.z),
    )

  def madd(v: Pga3dPoint, mult: Double): Pga3dTrivector =
    Pga3dTrivector(
      x = (x + mult * v.x),
      y = (y + mult * v.y),
      z = (z + mult * v.z),
      w = (1.0 + mult),
    )

  def +(v: Pga3dVector): Pga3dPoint =
    Pga3dPoint(
      x = (v.x + x),
      y = (v.y + y),
      z = (v.z + z),
    )

  def -(v: Pga3dVector): Pga3dPoint =
    Pga3dPoint(
      x = (x - v.x),
      y = (y - v.y),
      z = (z - v.z),
    )

  def madd(v: Pga3dVector, mult: Double): Pga3dPoint =
    Pga3dPoint(
      x = (x + mult * v.x),
      y = (y + mult * v.y),
      z = (z + mult * v.z),
    )

  def multiplyElementwise(v: Pga3dPoint): Pga3dPoint =
    Pga3dPoint(
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
      xyz = 1.0,
      i = 0.0,
    )

  def toTrivector: Pga3dTrivector =
    Pga3dTrivector(
      x = x,
      y = y,
      z = z,
      w = 1.0,
    )

  def toVectorUnsafe: Pga3dVector =
    Pga3dVector(
      x = x,
      y = y,
      z = z,
    )

  /** fused plane.dot(point).geometric(plane) */
  def projectOntoPlane(plane: Pga3dPlane): Pga3dTrivector =
    Pga3dTrivector(
      x = -(plane.x * (plane.w + plane.y * y + plane.z * z) + x * (-plane.y * plane.y - plane.z * plane.z)),
      y = (plane.y * (-plane.w - plane.x * x - plane.z * z) + y * (plane.x * plane.x + plane.z * plane.z)),
      z = -(plane.z * (plane.w + plane.x * x + plane.y * y) + z * (-plane.x * plane.x - plane.y * plane.y)),
      w = (plane.x * plane.x + plane.y * plane.y + plane.z * plane.z),
    )

  /**
   * fused -line.dot(point).geometric(line).toPointUnsafe
   * not applicable for Bivector, input should be a line
   * example of result for Bivector:
   * Pga3dMultivector(
   *   s = 0.0,
   *   w = (line.wy * line.xz - line.wx * line.yz - line.wz * line.xy),
   *   x = 0.0,
   *   y = 0.0,
   *   z = 0.0,
   *   wx = 0.0,
   *   wy = 0.0,
   *   wz = 0.0,
   *   xy = 0.0,
   *   xz = 0.0,
   *   yz = 0.0,
   *   wxy = (line.xy * (line.xz * y - line.xy * z - line.yz * x) - line.wx * line.xz - line.wy * line.yz),
   *   wxz = (line.wx * line.xy + line.xz * (line.xz * y - line.xy * z - line.yz * x) - line.wz * line.yz),
   *   wyz = (line.wy * line.xy + line.wz * line.xz + line.yz * (line.xz * y - line.xy * z - line.yz * x)),
   *   xyz = (line.xy * line.xy + line.xz * line.xz + line.yz * line.yz),
   *   i = 0.0,
   * )
   */
  def projectOntoLine(line: Pga3dBivector): Pga3dTrivector =
    Pga3dTrivector(
      x = (-line.wy * line.xy - line.wz * line.xz + line.xy * line.yz * z + line.yz * line.yz * x - line.xz * line.yz * y),
      y = (line.wx * line.xy + line.xz * (line.xz * y - line.xy * z - line.yz * x) - line.wz * line.yz),
      z = (line.wx * line.xz + line.wy * line.yz + line.xy * line.xy * z + line.xy * line.yz * x - line.xy * line.xz * y),
      w = (line.xy * line.xy + line.xz * line.xz + line.yz * line.yz),
    )

  infix def geometric(v: Pga3dMotor): Pga3dMultivector =
    Pga3dMultivector(
      s = 0.0,
      w = (v.i + v.xy * z + v.yz * x - v.xz * y),
      x = -v.yz,
      y = v.xz,
      z = -v.xy,
      wx = 0.0,
      wy = 0.0,
      wz = 0.0,
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
      wxy = (-v.wz - v.s * z - v.xz * x - v.yz * y),
      wxz = (v.wy + v.s * y + v.xy * x - v.yz * z),
      wyz = (-v.wx + v.xy * y + v.xz * z - v.s * x),
      xyz = v.s,
      i = 0.0,
    )

  infix def geometric(v: Pga3dPlane): Pga3dMotor =
    Pga3dMotor(
      s = 0.0,
      wx = (v.z * y - v.y * z),
      wy = (v.x * z - v.z * x),
      wz = (v.y * x - v.x * y),
      xy = v.z,
      xz = -v.y,
      yz = v.x,
      i = (-v.w - v.x * x - v.y * y - v.z * z),
    )

  infix def geometric(v: Pga3dBivector): Pga3dMultivector =
    Pga3dMultivector(
      s = 0.0,
      w = (v.xy * z + v.yz * x - v.xz * y),
      x = -v.yz,
      y = v.xz,
      z = -v.xy,
      wx = 0.0,
      wy = 0.0,
      wz = 0.0,
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
      wxy = (-v.wz - v.xz * x - v.yz * y),
      wxz = (v.wy + v.xy * x - v.yz * z),
      wyz = (-v.wx + v.xy * y + v.xz * z),
      xyz = 0.0,
      i = 0.0,
    )

  infix def geometric(v: Pga3dTrivector): Pga3dMotor =
    Pga3dMotor(
      s = -v.w,
      wx = (-v.x + v.w * x),
      wy = (-v.y + v.w * y),
      wz = (-v.z + v.w * z),
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
      i = 0.0,
    )

  infix def geometric(v: Pga3dQuaternion): Pga3dMultivector =
    Pga3dMultivector(
      s = 0.0,
      w = (v.xy * z + v.yz * x - v.xz * y),
      x = -v.yz,
      y = v.xz,
      z = -v.xy,
      wx = 0.0,
      wy = 0.0,
      wz = 0.0,
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
      wxy = (-v.s * z - v.xz * x - v.yz * y),
      wxz = (v.s * y + v.xy * x - v.yz * z),
      wyz = (v.xy * y + v.xz * z - v.s * x),
      xyz = v.s,
      i = 0.0,
    )

  infix def geometric(v: Pga3dTranslator): Pga3dPoint =
    Pga3dPoint(
      x = (v.wx + x),
      y = (v.wy + y),
      z = (v.wz + z),
    )

  infix def geometric(v: Pga3dVector): Pga3dBivectorWeight =
    Pga3dBivectorWeight(
      wx = -v.x,
      wy = -v.y,
      wz = -v.z,
    )

  infix def geometric(v: Pga3dPoint): Pga3dMotor =
    Pga3dMotor(
      s = -1.0,
      wx = (x - v.x),
      wy = (y - v.y),
      wz = (z - v.z),
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
      xy = v.z,
      xz = -v.y,
      yz = v.x,
      i = (-v.x * x - v.y * y - v.z * z),
    )

  infix def geometric(v: Pga3dBivectorBulk): Pga3dMultivector =
    Pga3dMultivector(
      s = 0.0,
      w = (v.xy * z + v.yz * x - v.xz * y),
      x = -v.yz,
      y = v.xz,
      z = -v.xy,
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
      x = v.wx,
      y = v.wy,
      z = v.wz,
    )

  infix def geometric(v: Pga3dPseudoScalar): Pga3dPlane =
    Pga3dPlane(
      x = 0.0,
      y = 0.0,
      z = 0.0,
      w = v.i,
    )

  infix def geometric(v: Pga3dPointCenter.type): Pga3dMotor =
    Pga3dMotor(
      s = -1.0,
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
      w = (v.i + v.xy * z + v.yz * x - v.xz * y),
      x = -v.yz,
      y = v.xz,
      z = -v.xy,
      wx = 0.0,
      wy = 0.0,
      wz = 0.0,
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
      wxy = -v.s * z,
      wxz = v.s * y,
      wyz = -v.s * x,
      xyz = v.s,
      i = 0.0,
    )

  infix def dot(v: Pga3dPlane): Pga3dBivector =
    Pga3dBivector(
      wx = (v.z * y - v.y * z),
      wy = (v.x * z - v.z * x),
      wz = (v.y * x - v.x * y),
      xy = v.z,
      xz = -v.y,
      yz = v.x,
    )

  infix def dot(v: Pga3dBivector): Pga3dPlane =
    Pga3dPlane(
      x = -v.yz,
      y = v.xz,
      z = -v.xy,
      w = (v.xy * z + v.yz * x - v.xz * y),
    )

  infix def dot(v: Pga3dTrivector): Double =
    -v.w

  infix def dot(v: Pga3dQuaternion): Pga3dMultivector =
    Pga3dMultivector(
      s = 0.0,
      w = (v.xy * z + v.yz * x - v.xz * y),
      x = -v.yz,
      y = v.xz,
      z = -v.xy,
      wx = 0.0,
      wy = 0.0,
      wz = 0.0,
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
      wxy = -v.s * z,
      wxz = v.s * y,
      wyz = -v.s * x,
      xyz = v.s,
      i = 0.0,
    )

  infix def dot(v: Pga3dTranslator): Pga3dPoint =
    this

  infix def dot(v: Pga3dPoint): Double =
    -1.0

  infix def dot(v: Pga3dPlaneIdeal): Pga3dBivector =
    Pga3dBivector(
      wx = (v.z * y - v.y * z),
      wy = (v.x * z - v.z * x),
      wz = (v.y * x - v.x * y),
      xy = v.z,
      xz = -v.y,
      yz = v.x,
    )

  infix def dot(v: Pga3dBivectorBulk): Pga3dPlane =
    Pga3dPlane(
      x = -v.yz,
      y = v.xz,
      z = -v.xy,
      w = (v.xy * z + v.yz * x - v.xz * y),
    )

  infix def dot(v: Pga3dPseudoScalar): Pga3dPlane =
    Pga3dPlane(
      x = 0.0,
      y = 0.0,
      z = 0.0,
      w = v.i,
    )

  infix def dot(v: Pga3dPointCenter.type): Double =
    -1.0

  infix def wedge(v: Pga3dMotor): Pga3dTrivector =
    Pga3dTrivector(
      x = v.s * x,
      y = v.s * y,
      z = v.s * z,
      w = v.s,
    )

  inline infix def ^(v: Pga3dMotor): Pga3dTrivector = wedge(v)

  infix def wedge(v: Pga3dPlane): Pga3dPseudoScalar =
    Pga3dPseudoScalar(
      i = (-v.w - v.x * x - v.y * y - v.z * z),
    )

  inline infix def ^(v: Pga3dPlane): Pga3dPseudoScalar = wedge(v)

  infix def wedge(v: Pga3dQuaternion): Pga3dTrivector =
    Pga3dTrivector(
      x = v.s * x,
      y = v.s * y,
      z = v.s * z,
      w = v.s,
    )

  inline infix def ^(v: Pga3dQuaternion): Pga3dTrivector = wedge(v)

  infix def wedge(v: Pga3dTranslator): Pga3dPoint =
    this

  inline infix def ^(v: Pga3dTranslator): Pga3dPoint = wedge(v)

  infix def wedge(v: Pga3dPlaneIdeal): Pga3dPseudoScalar =
    Pga3dPseudoScalar(
      i = (-v.x * x - v.y * y - v.z * z),
    )

  inline infix def ^(v: Pga3dPlaneIdeal): Pga3dPseudoScalar = wedge(v)

  infix def antiGeometric(v: Pga3dMotor): Pga3dMultivector =
    Pga3dMultivector(
      s = 0.0,
      w = (v.wx * x + v.wy * y + v.wz * z),
      x = (-v.wx + v.s * x + v.xy * y + v.xz * z),
      y = (-v.wy + v.s * y + v.yz * z - v.xy * x),
      z = (-v.wz + v.s * z - v.xz * x - v.yz * y),
      wx = 0.0,
      wy = 0.0,
      wz = 0.0,
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
      wxy = (v.wy * x - v.i * z - v.wx * y),
      wxz = (v.i * y + v.wz * x - v.wx * z),
      wyz = (v.wz * y - v.i * x - v.wy * z),
      xyz = (v.i + v.xz * y - v.xy * z - v.yz * x),
      i = 0.0,
    )

  infix def antiGeometric(v: Pga3dPlane): Pga3dMotor =
    Pga3dMotor(
      s = (v.w + v.x * x + v.y * y + v.z * z),
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
      x = (-v.wx + v.xy * y + v.xz * z),
      y = (-v.wy + v.yz * z - v.xy * x),
      z = (-v.wz - v.xz * x - v.yz * y),
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

  infix def antiGeometric(v: Pga3dTrivector): Pga3dMotor =
    Pga3dMotor(
      s = 0.0,
      wx = (v.z * y - v.y * z),
      wy = (v.x * z - v.z * x),
      wz = (v.y * x - v.x * y),
      xy = (v.z - v.w * z),
      xz = (-v.y + v.w * y),
      yz = (v.x - v.w * x),
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
      x = (x - v.wx),
      y = (y - v.wy),
      z = (z - v.wz),
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
      xy = v.z,
      xz = -v.y,
      yz = v.x,
      i = (v.x * x + v.y * y + v.z * z),
    )

  infix def antiGeometric(v: Pga3dPoint): Pga3dMotor =
    Pga3dMotor(
      s = 0.0,
      wx = (v.z * y - v.y * z),
      wy = (v.x * z - v.z * x),
      wz = (v.y * x - v.x * y),
      xy = (v.z - z),
      xz = (y - v.y),
      yz = (v.x - x),
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
      x = -v.wx,
      y = -v.wy,
      z = -v.wz,
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

  infix def antiGeometric(v: Pga3dPseudoScalar): Pga3dTrivector =
    Pga3dTrivector(
      x = v.i * x,
      y = v.i * y,
      z = v.i * z,
      w = v.i,
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
      xyz = (v.i + v.xz * y - v.xy * z - v.yz * x),
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

  infix def antiDot(v: Pga3dBivector): Pga3dTrivector =
    Pga3dTrivector(
      x = (v.wy * z - v.wz * y),
      y = (v.wz * x - v.wx * z),
      z = (v.wx * y - v.wy * x),
      w = (v.xz * y - v.xy * z - v.yz * x),
    )

  infix def antiDot(v: Pga3dTrivector): Pga3dPseudoScalar =
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

  infix def antiDot(v: Pga3dBivectorBulk): Pga3dTrivector =
    Pga3dTrivector(
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

  infix def antiDot(v: Pga3dPseudoScalar): Pga3dTrivector =
    Pga3dTrivector(
      x = v.i * x,
      y = v.i * y,
      z = v.i * z,
      w = v.i,
    )

  infix def antiWedge(v: Pga3dMotor): Pga3dMultivector =
    Pga3dMultivector(
      s = 0.0,
      w = (v.wx * x + v.wy * y + v.wz * z),
      x = (-v.wx + v.xy * y + v.xz * z),
      y = (-v.wy + v.yz * z - v.xy * x),
      z = (-v.wz - v.xz * x - v.yz * y),
      wx = 0.0,
      wy = 0.0,
      wz = 0.0,
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
      wxy = -v.i * z,
      wxz = v.i * y,
      wyz = -v.i * x,
      xyz = v.i,
      i = 0.0,
    )

  inline infix def v(v: Pga3dMotor): Pga3dMultivector = antiWedge(v)

  infix def antiWedge(v: Pga3dPlane): Double =
    (v.w + v.x * x + v.y * y + v.z * z)

  inline infix def v(v: Pga3dPlane): Double = antiWedge(v)

  infix def antiWedge(v: Pga3dBivector): Pga3dPlane =
    Pga3dPlane(
      x = (-v.wx + v.xy * y + v.xz * z),
      y = (-v.wy + v.yz * z - v.xy * x),
      z = (-v.wz - v.xz * x - v.yz * y),
      w = (v.wx * x + v.wy * y + v.wz * z),
    )

  inline infix def v(v: Pga3dBivector): Pga3dPlane = antiWedge(v)

  infix def antiWedge(v: Pga3dTrivector): Pga3dBivector =
    Pga3dBivector(
      wx = (v.z * y - v.y * z),
      wy = (v.x * z - v.z * x),
      wz = (v.y * x - v.x * y),
      xy = (v.z - v.w * z),
      xz = (-v.y + v.w * y),
      yz = (v.x - v.w * x),
    )

  inline infix def v(v: Pga3dTrivector): Pga3dBivector = antiWedge(v)

  infix def antiWedge(v: Pga3dQuaternion): Pga3dPlaneIdeal =
    Pga3dPlaneIdeal(
      x = (v.xy * y + v.xz * z),
      y = (v.yz * z - v.xy * x),
      z = (-v.xz * x - v.yz * y),
    )

  inline infix def v(v: Pga3dQuaternion): Pga3dPlaneIdeal = antiWedge(v)

  infix def antiWedge(v: Pga3dTranslator): Pga3dPlane =
    Pga3dPlane(
      x = -v.wx,
      y = -v.wy,
      z = -v.wz,
      w = (v.wx * x + v.wy * y + v.wz * z),
    )

  inline infix def v(v: Pga3dTranslator): Pga3dPlane = antiWedge(v)

  infix def antiWedge(v: Pga3dVector): Pga3dBivector =
    Pga3dBivector(
      wx = (v.z * y - v.y * z),
      wy = (v.x * z - v.z * x),
      wz = (v.y * x - v.x * y),
      xy = v.z,
      xz = -v.y,
      yz = v.x,
    )

  inline infix def v(v: Pga3dVector): Pga3dBivector = antiWedge(v)

  infix def antiWedge(v: Pga3dPoint): Pga3dBivector =
    Pga3dBivector(
      wx = (v.z * y - v.y * z),
      wy = (v.x * z - v.z * x),
      wz = (v.y * x - v.x * y),
      xy = (v.z - z),
      xz = (y - v.y),
      yz = (v.x - x),
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
      x = -v.wx,
      y = -v.wy,
      z = -v.wz,
      w = (v.wx * x + v.wy * y + v.wz * z),
    )

  inline infix def v(v: Pga3dBivectorWeight): Pga3dPlane = antiWedge(v)

  infix def antiWedge(v: Pga3dPseudoScalar): Pga3dTrivector =
    Pga3dTrivector(
      x = v.i * x,
      y = v.i * y,
      z = v.i * z,
      w = v.i,
    )

  inline infix def v(v: Pga3dPseudoScalar): Pga3dTrivector = antiWedge(v)

  infix def antiWedge(v: Pga3dPointCenter.type): Pga3dBivectorBulk =
    Pga3dBivectorBulk(
      xy = -z,
      xz = y,
      yz = -x,
    )

  inline infix def v(v: Pga3dPointCenter.type): Pga3dBivectorBulk = antiWedge(v)

  infix def sandwich(v: Pga3dMotor): Pga3dMotor =
    Pga3dMotor(
      s = v.s,
      wx = (-v.wx + 2.0 * (v.xy * y + v.xz * z)),
      wy = (-v.wy + 2.0 * (v.yz * z - v.xy * x)),
      wz = (-v.wz + 2.0 * (-v.xz * x - v.yz * y)),
      xy = v.xy,
      xz = v.xz,
      yz = v.yz,
      i = -v.i,
    )

  infix def sandwich(v: Pga3dPlane): Pga3dPlane =
    Pga3dPlane(
      x = v.x,
      y = v.y,
      z = v.z,
      w = (-v.w + 2.0 * (-v.x * x - v.y * y - v.z * z)),
    )

  infix def sandwich(v: Pga3dBivector): Pga3dBivector =
    Pga3dBivector(
      wx = (-v.wx + 2.0 * (v.xy * y + v.xz * z)),
      wy = (-v.wy + 2.0 * (v.yz * z - v.xy * x)),
      wz = (-v.wz + 2.0 * (-v.xz * x - v.yz * y)),
      xy = v.xy,
      xz = v.xz,
      yz = v.yz,
    )

  infix def sandwich(v: Pga3dTrivector): Pga3dTrivector =
    Pga3dTrivector(
      x = (-v.x + 2.0 * v.w * x),
      y = (-v.y + 2.0 * v.w * y),
      z = (-v.z + 2.0 * v.w * z),
      w = v.w,
    )

  infix def sandwich(v: Pga3dQuaternion): Pga3dMotor =
    Pga3dMotor(
      s = v.s,
      wx = 2.0 * (v.xy * y + v.xz * z),
      wy = 2.0 * (v.yz * z - v.xy * x),
      wz = 2.0 * (-v.xz * x - v.yz * y),
      xy = v.xy,
      xz = v.xz,
      yz = v.yz,
      i = 0.0,
    )

  infix def sandwich(v: Pga3dTranslator): Pga3dTranslator =
    Pga3dTranslator(
      wx = -v.wx,
      wy = -v.wy,
      wz = -v.wz,
    )

  infix def sandwich(v: Pga3dVector): Pga3dVector =
    -v

  infix def sandwich(v: Pga3dPoint): Pga3dPoint =
    Pga3dPoint(
      x = (-v.x + 2.0 * x),
      y = (-v.y + 2.0 * y),
      z = (-v.z + 2.0 * z),
    )

  infix def sandwich(v: Pga3dPlaneIdeal): Pga3dPlane =
    Pga3dPlane(
      x = v.x,
      y = v.y,
      z = v.z,
      w = 2.0 * (-v.x * x - v.y * y - v.z * z),
    )

  infix def sandwich(v: Pga3dBivectorBulk): Pga3dBivector =
    Pga3dBivector(
      wx = 2.0 * (v.xy * y + v.xz * z),
      wy = 2.0 * (v.yz * z - v.xy * x),
      wz = 2.0 * (-v.xz * x - v.yz * y),
      xy = v.xy,
      xz = v.xz,
      yz = v.yz,
    )

  infix def sandwich(v: Pga3dBivectorWeight): Pga3dBivectorWeight =
    -v

  infix def sandwich(v: Pga3dPseudoScalar): Pga3dPseudoScalar =
    -v

  infix def sandwich(v: Pga3dPointCenter.type): Pga3dPoint =
    Pga3dPoint(
      x = 2.0 * x,
      y = 2.0 * y,
      z = 2.0 * z,
    )

  infix def reverseSandwich(v: Pga3dMotor): Pga3dMotor =
    Pga3dMotor(
      s = v.s,
      wx = (-v.wx + 2.0 * (v.xy * y + v.xz * z)),
      wy = (-v.wy + 2.0 * (v.yz * z - v.xy * x)),
      wz = (-v.wz + 2.0 * (-v.xz * x - v.yz * y)),
      xy = v.xy,
      xz = v.xz,
      yz = v.yz,
      i = -v.i,
    )

  infix def reverseSandwich(v: Pga3dPlane): Pga3dPlane =
    Pga3dPlane(
      x = v.x,
      y = v.y,
      z = v.z,
      w = (-v.w + 2.0 * (-v.x * x - v.y * y - v.z * z)),
    )

  infix def reverseSandwich(v: Pga3dBivector): Pga3dBivector =
    Pga3dBivector(
      wx = (-v.wx + 2.0 * (v.xy * y + v.xz * z)),
      wy = (-v.wy + 2.0 * (v.yz * z - v.xy * x)),
      wz = (-v.wz + 2.0 * (-v.xz * x - v.yz * y)),
      xy = v.xy,
      xz = v.xz,
      yz = v.yz,
    )

  infix def reverseSandwich(v: Pga3dTrivector): Pga3dTrivector =
    Pga3dTrivector(
      x = (-v.x + 2.0 * v.w * x),
      y = (-v.y + 2.0 * v.w * y),
      z = (-v.z + 2.0 * v.w * z),
      w = v.w,
    )

  infix def reverseSandwich(v: Pga3dQuaternion): Pga3dMotor =
    Pga3dMotor(
      s = v.s,
      wx = 2.0 * (v.xy * y + v.xz * z),
      wy = 2.0 * (v.yz * z - v.xy * x),
      wz = 2.0 * (-v.xz * x - v.yz * y),
      xy = v.xy,
      xz = v.xz,
      yz = v.yz,
      i = 0.0,
    )

  infix def reverseSandwich(v: Pga3dTranslator): Pga3dTranslator =
    Pga3dTranslator(
      wx = -v.wx,
      wy = -v.wy,
      wz = -v.wz,
    )

  infix def reverseSandwich(v: Pga3dVector): Pga3dVector =
    -v

  infix def reverseSandwich(v: Pga3dPoint): Pga3dPoint =
    Pga3dPoint(
      x = (-v.x + 2.0 * x),
      y = (-v.y + 2.0 * y),
      z = (-v.z + 2.0 * z),
    )

  infix def reverseSandwich(v: Pga3dPlaneIdeal): Pga3dPlane =
    Pga3dPlane(
      x = v.x,
      y = v.y,
      z = v.z,
      w = 2.0 * (-v.x * x - v.y * y - v.z * z),
    )

  infix def reverseSandwich(v: Pga3dBivectorBulk): Pga3dBivector =
    Pga3dBivector(
      wx = 2.0 * (v.xy * y + v.xz * z),
      wy = 2.0 * (v.yz * z - v.xy * x),
      wz = 2.0 * (-v.xz * x - v.yz * y),
      xy = v.xy,
      xz = v.xz,
      yz = v.yz,
    )

  infix def reverseSandwich(v: Pga3dBivectorWeight): Pga3dBivectorWeight =
    -v

  infix def reverseSandwich(v: Pga3dPseudoScalar): Pga3dPseudoScalar =
    -v

  infix def reverseSandwich(v: Pga3dPointCenter.type): Pga3dPoint =
    Pga3dPoint(
      x = 2.0 * x,
      y = 2.0 * y,
      z = 2.0 * z,
    )

  infix def cross(v: Pga3dMotor): Pga3dMultivector =
    Pga3dMultivector(
      s = 0.0,
      w = v.i,
      x = 0.0,
      y = 0.0,
      z = 0.0,
      wx = 0.0,
      wy = 0.0,
      wz = 0.0,
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
      wxy = (-v.wz - v.xz * x - v.yz * y),
      wxz = (v.wy + v.xy * x - v.yz * z),
      wyz = (-v.wx + v.xy * y + v.xz * z),
      xyz = 0.0,
      i = 0.0,
    )

  infix def cross(v: Pga3dPlane): Pga3dPseudoScalar =
    Pga3dPseudoScalar(
      i = (-v.w - v.x * x - v.y * y - v.z * z),
    )

  infix def cross(v: Pga3dBivector): Pga3dVector =
    Pga3dVector(
      x = (v.wx - v.xy * y - v.xz * z),
      y = (v.wy + v.xy * x - v.yz * z),
      z = (v.wz + v.xz * x + v.yz * y),
    )

  infix def cross(v: Pga3dTrivector): Pga3dBivectorWeight =
    Pga3dBivectorWeight(
      wx = (-v.x + v.w * x),
      wy = (-v.y + v.w * y),
      wz = (-v.z + v.w * z),
    )

  infix def cross(v: Pga3dQuaternion): Pga3dVector =
    Pga3dVector(
      x = (-v.xy * y - v.xz * z),
      y = (v.xy * x - v.yz * z),
      z = (v.xz * x + v.yz * y),
    )

  infix def cross(v: Pga3dTranslator): Pga3dVector =
    Pga3dVector(
      x = v.wx,
      y = v.wy,
      z = v.wz,
    )

  infix def cross(v: Pga3dVector): Pga3dBivectorWeight =
    Pga3dBivectorWeight(
      wx = -v.x,
      wy = -v.y,
      wz = -v.z,
    )

  infix def cross(v: Pga3dPoint): Pga3dBivectorWeight =
    Pga3dBivectorWeight(
      wx = (x - v.x),
      wy = (y - v.y),
      wz = (z - v.z),
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
      x = v.wx,
      y = v.wy,
      z = v.wz,
    )

  infix def cross(v: Pga3dPseudoScalar): Pga3dPlane =
    Pga3dPlane(
      x = 0.0,
      y = 0.0,
      z = 0.0,
      w = v.i,
    )

  infix def cross(v: Pga3dPointCenter.type): Pga3dBivectorWeight =
    Pga3dBivectorWeight(
      wx = x,
      wy = y,
      wz = z,
    )


object Pga3dPoint:

  inline val componentsCount = 3

  def blade3(wxy: Double, wxz: Double, wyz: Double): Pga3dPoint =
    Pga3dPoint(
      x = -wyz,
      y = wxz,
      z = -wxy,
    )

  def interpolate(a: Pga3dPoint, b: Pga3dPoint, t: Double): Pga3dPoint =
    (a.toVectorUnsafe * (1.0 - t) + b.toVectorUnsafe * t).toPointUnsafe