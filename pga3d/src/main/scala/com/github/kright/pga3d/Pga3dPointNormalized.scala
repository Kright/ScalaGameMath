package com.github.kright.pga3d

/** this code is generated, see com.github.kright.pga3d.codegen.CodeGenClass */
case class Pga3dPointNormalized(wxy: Double = 0.0,
                                wxz: Double = 0.0,
                                wyz: Double = 0.0):
  inline val xyz = 1.0

  inline def dualX: Double = -wyz

  inline def dualW: Double = 1.0

  inline def dualY: Double = wxz

  inline def dualZ: Double = -wxy

  def dual: Pga3dPlane =
    Pga3dPlane(
      x = -wyz,
      y = wxz,
      z = -wxy,
      w = 1.0,
    )

  def weight: Pga3dVector =
    Pga3dVector(
      wxy = wxy,
      wxz = wxz,
      wyz = wyz,
    )

  def bulk: Pga3dPointCenter.type =
    Pga3dPointCenter

  def unary_- : Pga3dPoint =
    Pga3dPoint(
      wxy = -wxy,
      wxz = -wxz,
      wyz = -wyz,
      xyz = -1.0,
    )

  def reverse: Pga3dPoint =
    Pga3dPoint(
      wxy = -wxy,
      wxz = -wxz,
      wyz = -wyz,
      xyz = -1.0,
    )

  def antiReverse: Pga3dPointNormalized =
    this

  def bulkNormSquare: Double =
    1.0

  def bulkNorm: Double =
    Math.sqrt(bulkNormSquare)

  def normalizedByBulk =
    this / bulkNorm

  def weightNormSquare: Double =
    (wxy * wxy + wxz * wxz + wyz * wyz)

  def weightNorm: Double =
    Math.sqrt(weightNormSquare)

  def normalizedByWeight =
    this / weightNorm

  def normSquare: Double =
    (1.0 + wxy * wxy + wxz * wxz + wyz * wyz)

  def norm: Double =
    Math.sqrt(normSquare)

  def normalizedByNorm =
    this / norm

  def *(v: Double): Pga3dPoint =
    Pga3dPoint(
      wxy = v * wxy,
      wxz = v * wxz,
      wyz = v * wyz,
      xyz = v,
    )

  inline def /(v: Double): Pga3dPoint =
    this * (1.0 / v)

  def +(v: Pga3dPoint): Pga3dPoint =
    Pga3dPoint(
      wxy = (v.wxy + wxy),
      wxz = (v.wxz + wxz),
      wyz = (v.wyz + wyz),
      xyz = (1.0 + v.xyz),
    )

  def -(v: Pga3dPoint): Pga3dPoint =
    Pga3dPoint(
      wxy = (wxy - v.wxy),
      wxz = (wxz - v.wxz),
      wyz = (wyz - v.wyz),
      xyz = (1.0 - v.xyz),
    )

  def madd(v: Pga3dPoint, mult: Double): Pga3dPoint =
    Pga3dPoint(
      wxy = (wxy + mult * v.wxy),
      wxz = (wxz + mult * v.wxz),
      wyz = (wyz + mult * v.wyz),
      xyz = (1.0 + mult * v.xyz),
    )

  def +(v: Pga3dPointNormalized): Pga3dPoint =
    Pga3dPoint(
      wxy = (v.wxy + wxy),
      wxz = (v.wxz + wxz),
      wyz = (v.wyz + wyz),
      xyz = 2.0,
    )

  def -(v: Pga3dPointNormalized): Pga3dVector =
    Pga3dVector(
      wxy = (wxy - v.wxy),
      wxz = (wxz - v.wxz),
      wyz = (wyz - v.wyz),
    )

  def madd(v: Pga3dPointNormalized, mult: Double): Pga3dPoint =
    Pga3dPoint(
      wxy = (wxy + mult * v.wxy),
      wxz = (wxz + mult * v.wxz),
      wyz = (wyz + mult * v.wyz),
      xyz = (1.0 + mult),
    )

  def +(v: Pga3dVector): Pga3dPointNormalized =
    Pga3dPointNormalized(
      wxy = (v.wxy + wxy),
      wxz = (v.wxz + wxz),
      wyz = (v.wyz + wyz),
    )

  def -(v: Pga3dVector): Pga3dPointNormalized =
    Pga3dPointNormalized(
      wxy = (wxy - v.wxy),
      wxz = (wxz - v.wxz),
      wyz = (wyz - v.wyz),
    )

  def madd(v: Pga3dVector, mult: Double): Pga3dPointNormalized =
    Pga3dPointNormalized(
      wxy = (wxy + mult * v.wxy),
      wxz = (wxz + mult * v.wxz),
      wyz = (wyz + mult * v.wyz),
    )

  def multiplyElementwise(v: Pga3dPointNormalized): Pga3dPointNormalized =
    Pga3dPointNormalized(
      wxy = v.wxy * wxy,
      wxz = v.wxz * wxz,
      wyz = v.wyz * wyz,
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
      wxy = wxy,
      wxz = wxz,
      wyz = wyz,
      xyz = 1.0,
      i = 0.0,
    )

  def toPoint: Pga3dPoint =
    Pga3dPoint(
      wxy = wxy,
      wxz = wxz,
      wyz = wyz,
      xyz = 1.0,
    )

  def asVectorUnsafe: Pga3dVector =
    Pga3dVector(
      wxy = wxy,
      wxz = wxz,
      wyz = wyz,
    )

  /** fused plane.dot(point).geometric(plane) */
  def projectOntoPlane(plane: Pga3dPlane): Pga3dPoint =
    Pga3dPoint(
      wxy = (plane.z * (plane.w + plane.y * wxz - plane.x * wyz) + wxy * (plane.x * plane.x + plane.y * plane.y)),
      wxz = (plane.y * (-plane.w + plane.x * wyz + plane.z * wxy) + wxz * (plane.x * plane.x + plane.z * plane.z)),
      wyz = (plane.x * (plane.w + plane.y * wxz - plane.z * wxy) + wyz * (plane.y * plane.y + plane.z * plane.z)),
      xyz = (plane.x * plane.x + plane.y * plane.y + plane.z * plane.z),
    )

  /**
   * fused -line.dot(point).geometric(line).toPointUnsafe
   * not applicable for Bivector, input should be a line
   * example of result for Bivector:
   * Pga3dMultivector(
   * s = 0.0,
   * w = (line.wy * line.xz - line.wx * line.yz - line.wz * line.xy),
   * x = 0.0,
   * y = 0.0,
   * z = 0.0,
   * wx = 0.0,
   * wy = 0.0,
   * wz = 0.0,
   * xy = 0.0,
   * xz = 0.0,
   * yz = 0.0,
   * wxy = (line.xy * (line.xy * wxy + line.xz * wxz + line.yz * wyz) - line.wx * line.xz - line.wy * line.yz),
   * wxz = (line.wx * line.xy + line.xz * (line.xy * wxy + line.xz * wxz + line.yz * wyz) - line.wz * line.yz),
   * wyz = (line.wy * line.xy + line.wz * line.xz + line.yz * (line.xy * wxy + line.xz * wxz + line.yz * wyz)),
   * xyz = (line.xy * line.xy + line.xz * line.xz + line.yz * line.yz),
   * i = 0.0,
   * )
   */
  def projectOntoLine(line: Pga3dBivector): Pga3dPoint =
    Pga3dPoint(
      wxy = (line.xy * (line.xy * wxy + line.xz * wxz + line.yz * wyz) - line.wx * line.xz - line.wy * line.yz),
      wxz = (line.wx * line.xy + line.xz * (line.xy * wxy + line.xz * wxz + line.yz * wyz) - line.wz * line.yz),
      wyz = (line.wy * line.xy + line.wz * line.xz + line.yz * (line.xy * wxy + line.xz * wxz + line.yz * wyz)),
      xyz = (line.xy * line.xy + line.xz * line.xz + line.yz * line.yz),
    )

  infix def geometric(v: Pga3dMotor): Pga3dMultivector =
    Pga3dMultivector(
      s = 0.0,
      w = (v.i - v.xy * wxy - v.xz * wxz - v.yz * wyz),
      x = -v.yz,
      y = v.xz,
      z = -v.xy,
      wx = 0.0,
      wy = 0.0,
      wz = 0.0,
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
      wxy = (-v.wz + v.s * wxy + v.xz * wyz - v.yz * wxz),
      wxz = (v.wy + v.s * wxz + v.yz * wxy - v.xy * wyz),
      wyz = (-v.wx + v.s * wyz + v.xy * wxz - v.xz * wxy),
      xyz = v.s,
      i = 0.0,
    )

  infix def geometric(v: Pga3dPlane): Pga3dMotor =
    Pga3dMotor(
      s = 0.0,
      wx = (v.y * wxy + v.z * wxz),
      wy = (v.z * wyz - v.x * wxy),
      wz = (-v.x * wxz - v.y * wyz),
      xy = v.z,
      xz = -v.y,
      yz = v.x,
      i = (-v.w + v.x * wyz + v.z * wxy - v.y * wxz),
    )

  infix def geometric(v: Pga3dBivector): Pga3dMultivector =
    Pga3dMultivector(
      s = 0.0,
      w = (-v.xy * wxy - v.xz * wxz - v.yz * wyz),
      x = -v.yz,
      y = v.xz,
      z = -v.xy,
      wx = 0.0,
      wy = 0.0,
      wz = 0.0,
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
      wxy = (-v.wz + v.xz * wyz - v.yz * wxz),
      wxz = (v.wy + v.yz * wxy - v.xy * wyz),
      wyz = (-v.wx + v.xy * wxz - v.xz * wxy),
      xyz = 0.0,
      i = 0.0,
    )

  infix def geometric(v: Pga3dPoint): Pga3dMotor =
    Pga3dMotor(
      s = -v.xyz,
      wx = (v.wyz - v.xyz * wyz),
      wy = (-v.wxz + v.xyz * wxz),
      wz = (v.wxy - v.xyz * wxy),
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
      i = 0.0,
    )

  infix def geometric(v: Pga3dQuaternion): Pga3dMultivector =
    Pga3dMultivector(
      s = 0.0,
      w = (-v.xy * wxy - v.xz * wxz - v.yz * wyz),
      x = -v.yz,
      y = v.xz,
      z = -v.xy,
      wx = 0.0,
      wy = 0.0,
      wz = 0.0,
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
      wxy = (v.s * wxy + v.xz * wyz - v.yz * wxz),
      wxz = (v.s * wxz + v.yz * wxy - v.xy * wyz),
      wyz = (v.s * wyz + v.xy * wxz - v.xz * wxy),
      xyz = v.s,
      i = 0.0,
    )

  infix def geometric(v: Pga3dTranslator): Pga3dPointNormalized =
    Pga3dPointNormalized(
      wxy = (wxy - v.wz),
      wxz = (v.wy + wxz),
      wyz = (wyz - v.wx),
    )

  infix def geometric(v: Pga3dVector): Pga3dBivectorWeight =
    Pga3dBivectorWeight(
      wx = v.wyz,
      wy = -v.wxz,
      wz = v.wxy,
    )

  infix def geometric(v: Pga3dPointNormalized): Pga3dMotor =
    Pga3dMotor(
      s = -1.0,
      wx = (v.wyz - wyz),
      wy = (wxz - v.wxz),
      wz = (v.wxy - wxy),
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
      i = 0.0,
    )

  infix def geometric(v: Pga3dPlaneIdeal): Pga3dMotor =
    Pga3dMotor(
      s = 0.0,
      wx = (v.y * wxy + v.z * wxz),
      wy = (v.z * wyz - v.x * wxy),
      wz = (-v.x * wxz - v.y * wyz),
      xy = v.z,
      xz = -v.y,
      yz = v.x,
      i = (v.x * wyz + v.z * wxy - v.y * wxz),
    )

  infix def geometric(v: Pga3dBivectorBulk): Pga3dMultivector =
    Pga3dMultivector(
      s = 0.0,
      w = (-v.xy * wxy - v.xz * wxz - v.yz * wyz),
      x = -v.yz,
      y = v.xz,
      z = -v.xy,
      wx = 0.0,
      wy = 0.0,
      wz = 0.0,
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
      wxy = (v.xz * wyz - v.yz * wxz),
      wxz = (v.yz * wxy - v.xy * wyz),
      wyz = (v.xy * wxz - v.xz * wxy),
      xyz = 0.0,
      i = 0.0,
    )

  infix def geometric(v: Pga3dBivectorWeight): Pga3dVector =
    Pga3dVector(
      wxy = -v.wz,
      wxz = v.wy,
      wyz = -v.wx,
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
      wx = -wyz,
      wy = wxz,
      wz = -wxy,
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
      i = 0.0,
    )

  infix def dot(v: Pga3dMotor): Pga3dMultivector =
    Pga3dMultivector(
      s = 0.0,
      w = (v.i - v.xy * wxy - v.xz * wxz - v.yz * wyz),
      x = -v.yz,
      y = v.xz,
      z = -v.xy,
      wx = 0.0,
      wy = 0.0,
      wz = 0.0,
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
      wxy = v.s * wxy,
      wxz = v.s * wxz,
      wyz = v.s * wyz,
      xyz = v.s,
      i = 0.0,
    )

  infix def dot(v: Pga3dPlane): Pga3dBivector =
    Pga3dBivector(
      wx = (v.y * wxy + v.z * wxz),
      wy = (v.z * wyz - v.x * wxy),
      wz = (-v.x * wxz - v.y * wyz),
      xy = v.z,
      xz = -v.y,
      yz = v.x,
    )

  infix def dot(v: Pga3dBivector): Pga3dPlane =
    Pga3dPlane(
      x = -v.yz,
      y = v.xz,
      z = -v.xy,
      w = (-v.xy * wxy - v.xz * wxz - v.yz * wyz),
    )

  infix def dot(v: Pga3dPoint): Double =
    -v.xyz

  infix def dot(v: Pga3dQuaternion): Pga3dMultivector =
    Pga3dMultivector(
      s = 0.0,
      w = (-v.xy * wxy - v.xz * wxz - v.yz * wyz),
      x = -v.yz,
      y = v.xz,
      z = -v.xy,
      wx = 0.0,
      wy = 0.0,
      wz = 0.0,
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
      wxy = v.s * wxy,
      wxz = v.s * wxz,
      wyz = v.s * wyz,
      xyz = v.s,
      i = 0.0,
    )

  infix def dot(v: Pga3dTranslator): Pga3dPointNormalized =
    this

  infix def dot(v: Pga3dPointNormalized): Double =
    -1.0

  infix def dot(v: Pga3dPlaneIdeal): Pga3dBivector =
    Pga3dBivector(
      wx = (v.y * wxy + v.z * wxz),
      wy = (v.z * wyz - v.x * wxy),
      wz = (-v.x * wxz - v.y * wyz),
      xy = v.z,
      xz = -v.y,
      yz = v.x,
    )

  infix def dot(v: Pga3dBivectorBulk): Pga3dPlane =
    Pga3dPlane(
      x = -v.yz,
      y = v.xz,
      z = -v.xy,
      w = (-v.xy * wxy - v.xz * wxz - v.yz * wyz),
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

  infix def wedge(v: Pga3dMotor): Pga3dPoint =
    Pga3dPoint(
      wxy = v.s * wxy,
      wxz = v.s * wxz,
      wyz = v.s * wyz,
      xyz = v.s,
    )

  inline infix def ^(v: Pga3dMotor): Pga3dPoint = wedge(v)

  infix def wedge(v: Pga3dPlane): Pga3dPseudoScalar =
    Pga3dPseudoScalar(
      i = (-v.w + v.x * wyz + v.z * wxy - v.y * wxz),
    )

  inline infix def ^(v: Pga3dPlane): Pga3dPseudoScalar = wedge(v)

  infix def wedge(v: Pga3dQuaternion): Pga3dPoint =
    Pga3dPoint(
      wxy = v.s * wxy,
      wxz = v.s * wxz,
      wyz = v.s * wyz,
      xyz = v.s,
    )

  inline infix def ^(v: Pga3dQuaternion): Pga3dPoint = wedge(v)

  infix def wedge(v: Pga3dTranslator): Pga3dPointNormalized =
    this

  inline infix def ^(v: Pga3dTranslator): Pga3dPointNormalized = wedge(v)

  infix def wedge(v: Pga3dPlaneIdeal): Pga3dPseudoScalar =
    Pga3dPseudoScalar(
      i = (v.x * wyz + v.z * wxy - v.y * wxz),
    )

  inline infix def ^(v: Pga3dPlaneIdeal): Pga3dPseudoScalar = wedge(v)

  infix def antiGeometric(v: Pga3dMotor): Pga3dMultivector =
    Pga3dMultivector(
      s = 0.0,
      w = (v.wy * wxz - v.wx * wyz - v.wz * wxy),
      x = (-v.wx + v.xy * wxz - v.s * wyz - v.xz * wxy),
      y = (-v.wy + v.s * wxz + v.xy * wyz - v.yz * wxy),
      z = (-v.wz + v.xz * wyz - v.s * wxy - v.yz * wxz),
      wx = 0.0,
      wy = 0.0,
      wz = 0.0,
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
      wxy = (v.i * wxy - v.wx * wxz - v.wy * wyz),
      wxz = (v.i * wxz + v.wx * wxy - v.wz * wyz),
      wyz = (v.i * wyz + v.wy * wxy + v.wz * wxz),
      xyz = (v.i + v.xy * wxy + v.xz * wxz + v.yz * wyz),
      i = 0.0,
    )

  infix def antiGeometric(v: Pga3dPlane): Pga3dMotor =
    Pga3dMotor(
      s = (v.w + v.y * wxz - v.x * wyz - v.z * wxy),
      wx = -v.w * wyz,
      wy = v.w * wxz,
      wz = -v.w * wxy,
      xy = (v.x * wxz + v.y * wyz),
      xz = (v.z * wyz - v.x * wxy),
      yz = (-v.y * wxy - v.z * wxz),
      i = 0.0,
    )

  infix def antiGeometric(v: Pga3dBivector): Pga3dMultivector =
    Pga3dMultivector(
      s = 0.0,
      w = (v.wy * wxz - v.wx * wyz - v.wz * wxy),
      x = (-v.wx + v.xy * wxz - v.xz * wxy),
      y = (-v.wy + v.xy * wyz - v.yz * wxy),
      z = (-v.wz + v.xz * wyz - v.yz * wxz),
      wx = 0.0,
      wy = 0.0,
      wz = 0.0,
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
      wxy = (-v.wx * wxz - v.wy * wyz),
      wxz = (v.wx * wxy - v.wz * wyz),
      wyz = (v.wy * wxy + v.wz * wxz),
      xyz = (v.xy * wxy + v.xz * wxz + v.yz * wyz),
      i = 0.0,
    )

  infix def antiGeometric(v: Pga3dPoint): Pga3dMotor =
    Pga3dMotor(
      s = 0.0,
      wx = (v.wxz * wxy - v.wxy * wxz),
      wy = (v.wyz * wxy - v.wxy * wyz),
      wz = (v.wyz * wxz - v.wxz * wyz),
      xy = (-v.wxy + v.xyz * wxy),
      xz = (-v.wxz + v.xyz * wxz),
      yz = (-v.wyz + v.xyz * wyz),
      i = (v.wxy * wxy + v.wxz * wxz + v.wyz * wyz),
    )

  infix def antiGeometric(v: Pga3dQuaternion): Pga3dMultivector =
    Pga3dMultivector(
      s = 0.0,
      w = 0.0,
      x = (v.xy * wxz - v.s * wyz - v.xz * wxy),
      y = (v.s * wxz + v.xy * wyz - v.yz * wxy),
      z = (v.xz * wyz - v.s * wxy - v.yz * wxz),
      wx = 0.0,
      wy = 0.0,
      wz = 0.0,
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
      wxy = 0.0,
      wxz = 0.0,
      wyz = 0.0,
      xyz = (v.xy * wxy + v.xz * wxz + v.yz * wyz),
      i = 0.0,
    )

  infix def antiGeometric(v: Pga3dTranslator): Pga3dMultivector =
    Pga3dMultivector(
      s = 0.0,
      w = (v.wy * wxz - v.wx * wyz - v.wz * wxy),
      x = (-v.wx - wyz),
      y = (wxz - v.wy),
      z = (-v.wz - wxy),
      wx = 0.0,
      wy = 0.0,
      wz = 0.0,
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
      wxy = (-v.wx * wxz - v.wy * wyz),
      wxz = (v.wx * wxy - v.wz * wyz),
      wyz = (v.wy * wxy + v.wz * wxz),
      xyz = 0.0,
      i = 0.0,
    )

  infix def antiGeometric(v: Pga3dVector): Pga3dMotor =
    Pga3dMotor(
      s = 0.0,
      wx = (v.wxz * wxy - v.wxy * wxz),
      wy = (v.wyz * wxy - v.wxy * wyz),
      wz = (v.wyz * wxz - v.wxz * wyz),
      xy = -v.wxy,
      xz = -v.wxz,
      yz = -v.wyz,
      i = (v.wxy * wxy + v.wxz * wxz + v.wyz * wyz),
    )

  infix def antiGeometric(v: Pga3dPointNormalized): Pga3dMotor =
    Pga3dMotor(
      s = 0.0,
      wx = (v.wxz * wxy - v.wxy * wxz),
      wy = (v.wyz * wxy - v.wxy * wyz),
      wz = (v.wyz * wxz - v.wxz * wyz),
      xy = (wxy - v.wxy),
      xz = (wxz - v.wxz),
      yz = (wyz - v.wyz),
      i = (v.wxy * wxy + v.wxz * wxz + v.wyz * wyz),
    )

  infix def antiGeometric(v: Pga3dPlaneIdeal): Pga3dQuaternion =
    Pga3dQuaternion(
      s = (v.y * wxz - v.x * wyz - v.z * wxy),
      xy = (v.x * wxz + v.y * wyz),
      xz = (v.z * wyz - v.x * wxy),
      yz = (-v.y * wxy - v.z * wxz),
    )

  infix def antiGeometric(v: Pga3dBivectorBulk): Pga3dMultivector =
    Pga3dMultivector(
      s = 0.0,
      w = 0.0,
      x = (v.xy * wxz - v.xz * wxy),
      y = (v.xy * wyz - v.yz * wxy),
      z = (v.xz * wyz - v.yz * wxz),
      wx = 0.0,
      wy = 0.0,
      wz = 0.0,
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
      wxy = 0.0,
      wxz = 0.0,
      wyz = 0.0,
      xyz = (v.xy * wxy + v.xz * wxz + v.yz * wyz),
      i = 0.0,
    )

  infix def antiGeometric(v: Pga3dBivectorWeight): Pga3dMultivector =
    Pga3dMultivector(
      s = 0.0,
      w = (v.wy * wxz - v.wx * wyz - v.wz * wxy),
      x = -v.wx,
      y = -v.wy,
      z = -v.wz,
      wx = 0.0,
      wy = 0.0,
      wz = 0.0,
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
      wxy = (-v.wx * wxz - v.wy * wyz),
      wxz = (v.wx * wxy - v.wz * wyz),
      wyz = (v.wy * wxy + v.wz * wxz),
      xyz = 0.0,
      i = 0.0,
    )

  infix def antiGeometric(v: Pga3dPseudoScalar): Pga3dPoint =
    Pga3dPoint(
      wxy = v.i * wxy,
      wxz = v.i * wxz,
      wyz = v.i * wyz,
      xyz = v.i,
    )

  infix def antiGeometric(v: Pga3dPointCenter.type): Pga3dBivectorBulk =
    Pga3dBivectorBulk(
      xy = wxy,
      xz = wxz,
      yz = wyz,
    )

  infix def antiDot(v: Pga3dMotor): Pga3dMultivector =
    Pga3dMultivector(
      s = 0.0,
      w = 0.0,
      x = -v.s * wyz,
      y = v.s * wxz,
      z = -v.s * wxy,
      wx = 0.0,
      wy = 0.0,
      wz = 0.0,
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
      wxy = (v.i * wxy - v.wx * wxz - v.wy * wyz),
      wxz = (v.i * wxz + v.wx * wxy - v.wz * wyz),
      wyz = (v.i * wyz + v.wy * wxy + v.wz * wxz),
      xyz = (v.i + v.xy * wxy + v.xz * wxz + v.yz * wyz),
      i = 0.0,
    )

  infix def antiDot(v: Pga3dPlane): Pga3dBivector =
    Pga3dBivector(
      wx = -v.w * wyz,
      wy = v.w * wxz,
      wz = -v.w * wxy,
      xy = (v.x * wxz + v.y * wyz),
      xz = (v.z * wyz - v.x * wxy),
      yz = (-v.y * wxy - v.z * wxz),
    )

  infix def antiDot(v: Pga3dBivector): Pga3dPoint =
    Pga3dPoint(
      wxy = (-v.wx * wxz - v.wy * wyz),
      wxz = (v.wx * wxy - v.wz * wyz),
      wyz = (v.wy * wxy + v.wz * wxz),
      xyz = (v.xy * wxy + v.xz * wxz + v.yz * wyz),
    )

  infix def antiDot(v: Pga3dPoint): Pga3dPseudoScalar =
    Pga3dPseudoScalar(
      i = (v.wxy * wxy + v.wxz * wxz + v.wyz * wyz),
    )

  infix def antiDot(v: Pga3dQuaternion): Pga3dMultivector =
    Pga3dMultivector(
      s = 0.0,
      w = 0.0,
      x = -v.s * wyz,
      y = v.s * wxz,
      z = -v.s * wxy,
      wx = 0.0,
      wy = 0.0,
      wz = 0.0,
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
      wxy = 0.0,
      wxz = 0.0,
      wyz = 0.0,
      xyz = (v.xy * wxy + v.xz * wxz + v.yz * wyz),
      i = 0.0,
    )

  infix def antiDot(v: Pga3dTranslator): Pga3dMultivector =
    Pga3dMultivector(
      s = 0.0,
      w = 0.0,
      x = -wyz,
      y = wxz,
      z = -wxy,
      wx = 0.0,
      wy = 0.0,
      wz = 0.0,
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
      wxy = (-v.wx * wxz - v.wy * wyz),
      wxz = (v.wx * wxy - v.wz * wyz),
      wyz = (v.wy * wxy + v.wz * wxz),
      xyz = 0.0,
      i = 0.0,
    )

  infix def antiDot(v: Pga3dVector): Pga3dPseudoScalar =
    Pga3dPseudoScalar(
      i = (v.wxy * wxy + v.wxz * wxz + v.wyz * wyz),
    )

  infix def antiDot(v: Pga3dPointNormalized): Pga3dPseudoScalar =
    Pga3dPseudoScalar(
      i = (v.wxy * wxy + v.wxz * wxz + v.wyz * wyz),
    )

  infix def antiDot(v: Pga3dPlaneIdeal): Pga3dBivectorBulk =
    Pga3dBivectorBulk(
      xy = (v.x * wxz + v.y * wyz),
      xz = (v.z * wyz - v.x * wxy),
      yz = (-v.y * wxy - v.z * wxz),
    )

  infix def antiDot(v: Pga3dBivectorBulk): Pga3dPoint =
    Pga3dPoint(
      wxy = 0.0,
      wxz = 0.0,
      wyz = 0.0,
      xyz = (v.xy * wxy + v.xz * wxz + v.yz * wyz),
    )

  infix def antiDot(v: Pga3dBivectorWeight): Pga3dVector =
    Pga3dVector(
      wxy = (-v.wx * wxz - v.wy * wyz),
      wxz = (v.wx * wxy - v.wz * wyz),
      wyz = (v.wy * wxy + v.wz * wxz),
    )

  infix def antiDot(v: Pga3dPseudoScalar): Pga3dPoint =
    Pga3dPoint(
      wxy = v.i * wxy,
      wxz = v.i * wxz,
      wyz = v.i * wyz,
      xyz = v.i,
    )

  infix def antiWedge(v: Pga3dMotor): Pga3dMultivector =
    Pga3dMultivector(
      s = 0.0,
      w = (v.wy * wxz - v.wx * wyz - v.wz * wxy),
      x = (-v.wx + v.xy * wxz - v.xz * wxy),
      y = (-v.wy + v.xy * wyz - v.yz * wxy),
      z = (-v.wz + v.xz * wyz - v.yz * wxz),
      wx = 0.0,
      wy = 0.0,
      wz = 0.0,
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
      wxy = v.i * wxy,
      wxz = v.i * wxz,
      wyz = v.i * wyz,
      xyz = v.i,
      i = 0.0,
    )

  inline infix def v(v: Pga3dMotor): Pga3dMultivector = antiWedge(v)

  infix def antiWedge(v: Pga3dPlane): Double =
    (v.w + v.y * wxz - v.x * wyz - v.z * wxy)

  inline infix def v(v: Pga3dPlane): Double = antiWedge(v)

  infix def antiWedge(v: Pga3dBivector): Pga3dPlane =
    Pga3dPlane(
      x = (-v.wx + v.xy * wxz - v.xz * wxy),
      y = (-v.wy + v.xy * wyz - v.yz * wxy),
      z = (-v.wz + v.xz * wyz - v.yz * wxz),
      w = (v.wy * wxz - v.wx * wyz - v.wz * wxy),
    )

  inline infix def v(v: Pga3dBivector): Pga3dPlane = antiWedge(v)

  infix def antiWedge(v: Pga3dPoint): Pga3dBivector =
    Pga3dBivector(
      wx = (v.wxz * wxy - v.wxy * wxz),
      wy = (v.wyz * wxy - v.wxy * wyz),
      wz = (v.wyz * wxz - v.wxz * wyz),
      xy = (-v.wxy + v.xyz * wxy),
      xz = (-v.wxz + v.xyz * wxz),
      yz = (-v.wyz + v.xyz * wyz),
    )

  inline infix def v(v: Pga3dPoint): Pga3dBivector = antiWedge(v)

  infix def antiWedge(v: Pga3dQuaternion): Pga3dPlaneIdeal =
    Pga3dPlaneIdeal(
      x = (v.xy * wxz - v.xz * wxy),
      y = (v.xy * wyz - v.yz * wxy),
      z = (v.xz * wyz - v.yz * wxz),
    )

  inline infix def v(v: Pga3dQuaternion): Pga3dPlaneIdeal = antiWedge(v)

  infix def antiWedge(v: Pga3dTranslator): Pga3dPlane =
    Pga3dPlane(
      x = -v.wx,
      y = -v.wy,
      z = -v.wz,
      w = (v.wy * wxz - v.wx * wyz - v.wz * wxy),
    )

  inline infix def v(v: Pga3dTranslator): Pga3dPlane = antiWedge(v)

  infix def antiWedge(v: Pga3dVector): Pga3dBivector =
    Pga3dBivector(
      wx = (v.wxz * wxy - v.wxy * wxz),
      wy = (v.wyz * wxy - v.wxy * wyz),
      wz = (v.wyz * wxz - v.wxz * wyz),
      xy = -v.wxy,
      xz = -v.wxz,
      yz = -v.wyz,
    )

  inline infix def v(v: Pga3dVector): Pga3dBivector = antiWedge(v)

  infix def antiWedge(v: Pga3dPointNormalized): Pga3dBivector =
    Pga3dBivector(
      wx = (v.wxz * wxy - v.wxy * wxz),
      wy = (v.wyz * wxy - v.wxy * wyz),
      wz = (v.wyz * wxz - v.wxz * wyz),
      xy = (wxy - v.wxy),
      xz = (wxz - v.wxz),
      yz = (wyz - v.wyz),
    )

  inline infix def v(v: Pga3dPointNormalized): Pga3dBivector = antiWedge(v)

  infix def antiWedge(v: Pga3dPlaneIdeal): Double =
    (v.y * wxz - v.x * wyz - v.z * wxy)

  inline infix def v(v: Pga3dPlaneIdeal): Double = antiWedge(v)

  infix def antiWedge(v: Pga3dBivectorBulk): Pga3dPlaneIdeal =
    Pga3dPlaneIdeal(
      x = (v.xy * wxz - v.xz * wxy),
      y = (v.xy * wyz - v.yz * wxy),
      z = (v.xz * wyz - v.yz * wxz),
    )

  inline infix def v(v: Pga3dBivectorBulk): Pga3dPlaneIdeal = antiWedge(v)

  infix def antiWedge(v: Pga3dBivectorWeight): Pga3dPlane =
    Pga3dPlane(
      x = -v.wx,
      y = -v.wy,
      z = -v.wz,
      w = (v.wy * wxz - v.wx * wyz - v.wz * wxy),
    )

  inline infix def v(v: Pga3dBivectorWeight): Pga3dPlane = antiWedge(v)

  infix def antiWedge(v: Pga3dPseudoScalar): Pga3dPoint =
    Pga3dPoint(
      wxy = v.i * wxy,
      wxz = v.i * wxz,
      wyz = v.i * wyz,
      xyz = v.i,
    )

  inline infix def v(v: Pga3dPseudoScalar): Pga3dPoint = antiWedge(v)

  infix def antiWedge(v: Pga3dPointCenter.type): Pga3dBivectorBulk =
    Pga3dBivectorBulk(
      xy = wxy,
      xz = wxz,
      yz = wyz,
    )

  inline infix def v(v: Pga3dPointCenter.type): Pga3dBivectorBulk = antiWedge(v)

  infix def sandwich(v: Pga3dMotor): Pga3dMotor =
    Pga3dMotor(
      s = v.s,
      wx = (-v.wx + 2.0 * (v.xy * wxz - v.xz * wxy)),
      wy = (-v.wy + 2.0 * (v.xy * wyz - v.yz * wxy)),
      wz = (-v.wz + 2.0 * (v.xz * wyz - v.yz * wxz)),
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
      w = (-v.w + 2.0 * (v.x * wyz + v.z * wxy - v.y * wxz)),
    )

  infix def sandwich(v: Pga3dBivector): Pga3dBivector =
    Pga3dBivector(
      wx = (-v.wx + 2.0 * (v.xy * wxz - v.xz * wxy)),
      wy = (-v.wy + 2.0 * (v.xy * wyz - v.yz * wxy)),
      wz = (-v.wz + 2.0 * (v.xz * wyz - v.yz * wxz)),
      xy = v.xy,
      xz = v.xz,
      yz = v.yz,
    )

  infix def sandwich(v: Pga3dPoint): Pga3dPoint =
    Pga3dPoint(
      wxy = (-v.wxy + 2.0 * v.xyz * wxy),
      wxz = (-v.wxz + 2.0 * v.xyz * wxz),
      wyz = (-v.wyz + 2.0 * v.xyz * wyz),
      xyz = v.xyz,
    )

  infix def sandwich(v: Pga3dQuaternion): Pga3dMotor =
    Pga3dMotor(
      s = v.s,
      wx = 2.0 * (v.xy * wxz - v.xz * wxy),
      wy = 2.0 * (v.xy * wyz - v.yz * wxy),
      wz = 2.0 * (v.xz * wyz - v.yz * wxz),
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

  infix def sandwich(v: Pga3dPointNormalized): Pga3dPointNormalized =
    Pga3dPointNormalized(
      wxy = (-v.wxy + 2.0 * wxy),
      wxz = (-v.wxz + 2.0 * wxz),
      wyz = (-v.wyz + 2.0 * wyz),
    )

  infix def sandwich(v: Pga3dPlaneIdeal): Pga3dPlane =
    Pga3dPlane(
      x = v.x,
      y = v.y,
      z = v.z,
      w = 2.0 * (v.x * wyz + v.z * wxy - v.y * wxz),
    )

  infix def sandwich(v: Pga3dBivectorBulk): Pga3dBivector =
    Pga3dBivector(
      wx = 2.0 * (v.xy * wxz - v.xz * wxy),
      wy = 2.0 * (v.xy * wyz - v.yz * wxy),
      wz = 2.0 * (v.xz * wyz - v.yz * wxz),
      xy = v.xy,
      xz = v.xz,
      yz = v.yz,
    )

  infix def sandwich(v: Pga3dBivectorWeight): Pga3dBivectorWeight =
    -v

  infix def sandwich(v: Pga3dPseudoScalar): Pga3dPseudoScalar =
    -v

  infix def sandwich(v: Pga3dPointCenter.type): Pga3dPointNormalized =
    Pga3dPointNormalized(
      wxy = 2.0 * wxy,
      wxz = 2.0 * wxz,
      wyz = 2.0 * wyz,
    )

  infix def reverseSandwich(v: Pga3dMotor): Pga3dMotor =
    Pga3dMotor(
      s = v.s,
      wx = (-v.wx + 2.0 * (v.xy * wxz - v.xz * wxy)),
      wy = (-v.wy + 2.0 * (v.xy * wyz - v.yz * wxy)),
      wz = (-v.wz + 2.0 * (v.xz * wyz - v.yz * wxz)),
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
      w = (-v.w + 2.0 * (v.x * wyz + v.z * wxy - v.y * wxz)),
    )

  infix def reverseSandwich(v: Pga3dBivector): Pga3dBivector =
    Pga3dBivector(
      wx = (-v.wx + 2.0 * (v.xy * wxz - v.xz * wxy)),
      wy = (-v.wy + 2.0 * (v.xy * wyz - v.yz * wxy)),
      wz = (-v.wz + 2.0 * (v.xz * wyz - v.yz * wxz)),
      xy = v.xy,
      xz = v.xz,
      yz = v.yz,
    )

  infix def reverseSandwich(v: Pga3dPoint): Pga3dPoint =
    Pga3dPoint(
      wxy = (-v.wxy + 2.0 * v.xyz * wxy),
      wxz = (-v.wxz + 2.0 * v.xyz * wxz),
      wyz = (-v.wyz + 2.0 * v.xyz * wyz),
      xyz = v.xyz,
    )

  infix def reverseSandwich(v: Pga3dQuaternion): Pga3dMotor =
    Pga3dMotor(
      s = v.s,
      wx = 2.0 * (v.xy * wxz - v.xz * wxy),
      wy = 2.0 * (v.xy * wyz - v.yz * wxy),
      wz = 2.0 * (v.xz * wyz - v.yz * wxz),
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

  infix def reverseSandwich(v: Pga3dPointNormalized): Pga3dPointNormalized =
    Pga3dPointNormalized(
      wxy = (-v.wxy + 2.0 * wxy),
      wxz = (-v.wxz + 2.0 * wxz),
      wyz = (-v.wyz + 2.0 * wyz),
    )

  infix def reverseSandwich(v: Pga3dPlaneIdeal): Pga3dPlane =
    Pga3dPlane(
      x = v.x,
      y = v.y,
      z = v.z,
      w = 2.0 * (v.x * wyz + v.z * wxy - v.y * wxz),
    )

  infix def reverseSandwich(v: Pga3dBivectorBulk): Pga3dBivector =
    Pga3dBivector(
      wx = 2.0 * (v.xy * wxz - v.xz * wxy),
      wy = 2.0 * (v.xy * wyz - v.yz * wxy),
      wz = 2.0 * (v.xz * wyz - v.yz * wxz),
      xy = v.xy,
      xz = v.xz,
      yz = v.yz,
    )

  infix def reverseSandwich(v: Pga3dBivectorWeight): Pga3dBivectorWeight =
    -v

  infix def reverseSandwich(v: Pga3dPseudoScalar): Pga3dPseudoScalar =
    -v

  infix def reverseSandwich(v: Pga3dPointCenter.type): Pga3dPointNormalized =
    Pga3dPointNormalized(
      wxy = 2.0 * wxy,
      wxz = 2.0 * wxz,
      wyz = 2.0 * wyz,
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
      wxy = (-v.wz + v.xz * wyz - v.yz * wxz),
      wxz = (v.wy + v.yz * wxy - v.xy * wyz),
      wyz = (-v.wx + v.xy * wxz - v.xz * wxy),
      xyz = 0.0,
      i = 0.0,
    )

  infix def cross(v: Pga3dPlane): Pga3dPseudoScalar =
    Pga3dPseudoScalar(
      i = (-v.w + v.x * wyz + v.z * wxy - v.y * wxz),
    )

  infix def cross(v: Pga3dBivector): Pga3dVector =
    Pga3dVector(
      wxy = (-v.wz + v.xz * wyz - v.yz * wxz),
      wxz = (v.wy + v.yz * wxy - v.xy * wyz),
      wyz = (-v.wx + v.xy * wxz - v.xz * wxy),
    )

  infix def cross(v: Pga3dPoint): Pga3dBivectorWeight =
    Pga3dBivectorWeight(
      wx = (v.wyz - v.xyz * wyz),
      wy = (-v.wxz + v.xyz * wxz),
      wz = (v.wxy - v.xyz * wxy),
    )

  infix def cross(v: Pga3dQuaternion): Pga3dVector =
    Pga3dVector(
      wxy = (v.xz * wyz - v.yz * wxz),
      wxz = (v.yz * wxy - v.xy * wyz),
      wyz = (v.xy * wxz - v.xz * wxy),
    )

  infix def cross(v: Pga3dTranslator): Pga3dVector =
    Pga3dVector(
      wxy = -v.wz,
      wxz = v.wy,
      wyz = -v.wx,
    )

  infix def cross(v: Pga3dVector): Pga3dBivectorWeight =
    Pga3dBivectorWeight(
      wx = v.wyz,
      wy = -v.wxz,
      wz = v.wxy,
    )

  infix def cross(v: Pga3dPointNormalized): Pga3dBivectorWeight =
    Pga3dBivectorWeight(
      wx = (v.wyz - wyz),
      wy = (wxz - v.wxz),
      wz = (v.wxy - wxy),
    )

  infix def cross(v: Pga3dPlaneIdeal): Pga3dPseudoScalar =
    Pga3dPseudoScalar(
      i = (v.x * wyz + v.z * wxy - v.y * wxz),
    )

  infix def cross(v: Pga3dBivectorBulk): Pga3dVector =
    Pga3dVector(
      wxy = (v.xz * wyz - v.yz * wxz),
      wxz = (v.yz * wxy - v.xy * wyz),
      wyz = (v.xy * wxz - v.xz * wxy),
    )

  infix def cross(v: Pga3dBivectorWeight): Pga3dVector =
    Pga3dVector(
      wxy = -v.wz,
      wxz = v.wy,
      wyz = -v.wx,
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
      wx = -wyz,
      wy = wxz,
      wz = -wxy,
    )


object Pga3dPointNormalized:
  def fromDual(x: Double, y: Double, z: Double): Pga3dPointNormalized =
    Pga3dPointNormalized(
      wxy = -z,
      wxz = y,
      wyz = -x,
    )