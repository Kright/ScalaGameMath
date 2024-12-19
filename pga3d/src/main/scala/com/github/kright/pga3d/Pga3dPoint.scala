package com.github.kright.pga3d

/** this code is generated, see com.github.kright.pga3d.codegen.CodeGenClass */
case class Pga3dPoint(wxy: Double = 0.0,
                      wxz: Double = 0.0,
                      wyz: Double = 0.0,
                      xyz: Double = 0.0):

  inline def dualX: Double = -wyz

  inline def dualW: Double = xyz

  inline def dualY: Double = wxz

  inline def dualZ: Double = -wxy

  def dual: Pga3dPlane =
    Pga3dPlane(
      w = xyz,
      x = -wyz,
      y = wxz,
      z = -wxy,
    )

  def weight: Pga3dVector =
    Pga3dVector(
      wxy = wxy,
      wxz = wxz,
      wyz = wyz,
    )

  def bulk: Pga3dPoint =
    Pga3dPoint(
      wxy = 0.0,
      wxz = 0.0,
      wyz = 0.0,
      xyz = xyz,
    )

  def unary_- : Pga3dPoint =
    Pga3dPoint(
      wxy = -wxy,
      wxz = -wxz,
      wyz = -wyz,
      xyz = -xyz,
    )

  def reverse: Pga3dPoint =
    -this

  def antiReverse: Pga3dPoint =
    this

  def bulkNormSquare: Double =
    xyz * xyz

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
    (wxy * wxy + wxz * wxz + wyz * wyz + xyz * xyz)

  def norm: Double =
    Math.sqrt(normSquare)

  def normalizedByNorm =
    this / norm

  def *(v: Double): Pga3dPoint =
    Pga3dPoint(
      wxy = v * wxy,
      wxz = v * wxz,
      wyz = v * wyz,
      xyz = v * xyz,
    )

  inline def /(v: Double): Pga3dPoint =
    this * (1.0 / v)

  def +(v: Pga3dPoint): Pga3dPoint =
    Pga3dPoint(
      wxy = (v.wxy + wxy),
      wxz = (v.wxz + wxz),
      wyz = (v.wyz + wyz),
      xyz = (v.xyz + xyz),
    )

  def -(v: Pga3dPoint): Pga3dPoint =
    Pga3dPoint(
      wxy = (wxy - v.wxy),
      wxz = (wxz - v.wxz),
      wyz = (wyz - v.wyz),
      xyz = (xyz - v.xyz),
    )

  def madd(v: Pga3dPoint, mult: Double): Pga3dPoint =
    Pga3dPoint(
      wxy = (wxy + mult * v.wxy),
      wxz = (wxz + mult * v.wxz),
      wyz = (wyz + mult * v.wyz),
      xyz = (xyz + mult * v.xyz),
    )

  def +(v: Pga3dPointNormalized): Pga3dPoint =
    Pga3dPoint(
      wxy = (v.wxy + wxy),
      wxz = (v.wxz + wxz),
      wyz = (v.wyz + wyz),
      xyz = (1.0 + xyz),
    )

  def -(v: Pga3dPointNormalized): Pga3dPoint =
    Pga3dPoint(
      wxy = (wxy - v.wxy),
      wxz = (wxz - v.wxz),
      wyz = (wyz - v.wyz),
      xyz = (-1.0 + xyz),
    )

  def madd(v: Pga3dPointNormalized, mult: Double): Pga3dPoint =
    Pga3dPoint(
      wxy = (wxy + mult * v.wxy),
      wxz = (wxz + mult * v.wxz),
      wyz = (wyz + mult * v.wyz),
      xyz = (mult + xyz),
    )

  def +(v: Pga3dVector): Pga3dPoint =
    Pga3dPoint(
      wxy = (v.wxy + wxy),
      wxz = (v.wxz + wxz),
      wyz = (v.wyz + wyz),
      xyz = xyz,
    )

  def -(v: Pga3dVector): Pga3dPoint =
    Pga3dPoint(
      wxy = (wxy - v.wxy),
      wxz = (wxz - v.wxz),
      wyz = (wyz - v.wyz),
      xyz = xyz,
    )

  def madd(v: Pga3dVector, mult: Double): Pga3dPoint =
    Pga3dPoint(
      wxy = (wxy + mult * v.wxy),
      wxz = (wxz + mult * v.wxz),
      wyz = (wyz + mult * v.wyz),
      xyz = xyz,
    )

  def multiplyElementwise(v: Pga3dPoint): Pga3dPoint =
    Pga3dPoint(
      wxy = v.wxy * wxy,
      wxz = v.wxz * wxz,
      wyz = v.wyz * wyz,
      xyz = v.xyz * xyz,
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
      xyz = xyz,
      i = 0.0,
    )

  def asVectorUnsafe: Pga3dVector =
    Pga3dVector(
      wxy = wxy,
      wxz = wxz,
      wyz = wyz,
    )

  def asPointNormalizedUnsafe: Pga3dPointNormalized =
    Pga3dPointNormalized(
      wxy = wxy,
      wxz = wxz,
      wyz = wyz,
    )

  def toPga3dPointNormalized: Pga3dPointNormalized =
    Pga3dPointNormalized(
      wxy = wxy / xyz,
      wxz = wxz / xyz,
      wyz = wyz / xyz,
    )

  /** fused plane.dot(point).geometric(plane) */
  def projectOntoPlane(plane: Pga3dPlane): Pga3dPoint =
    Pga3dPoint(
      wxy = (plane.z * (plane.w * xyz + plane.y * wxz - plane.x * wyz) + wxy * (plane.x * plane.x + plane.y * plane.y)),
      wxz = (plane.y * (plane.x * wyz + plane.z * wxy - plane.w * xyz) + wxz * (plane.x * plane.x + plane.z * plane.z)),
      wyz = (plane.x * (plane.w * xyz + plane.y * wxz - plane.z * wxy) + wyz * (plane.y * plane.y + plane.z * plane.z)),
      xyz = xyz * (plane.x * plane.x + plane.y * plane.y + plane.z * plane.z),
    )

  /**
   * fused -line.dot(point).geometric(line).toPointUnsafe
   * not applicable for Bivector, input should be a line
   * example of result for Bivector:
   * Pga3dMultivector(
   * s = 0.0,
   * w = xyz * (line.wy * line.xz - line.wx * line.yz - line.wz * line.xy),
   * x = 0.0,
   * y = 0.0,
   * z = 0.0,
   * wx = 0.0,
   * wy = 0.0,
   * wz = 0.0,
   * xy = 0.0,
   * xz = 0.0,
   * yz = 0.0,
   * wxy = (line.xy * (line.xy * wxy + line.xz * wxz + line.yz * wyz) + xyz * (-line.wx * line.xz - line.wy * line.yz)),
   * wxz = (line.xz * (line.xy * wxy + line.xz * wxz + line.yz * wyz) + xyz * (line.wx * line.xy - line.wz * line.yz)),
   * wyz = (line.yz * (line.xy * wxy + line.xz * wxz + line.yz * wyz) + xyz * (line.wy * line.xy + line.wz * line.xz)),
   * xyz = xyz * (line.xy * line.xy + line.xz * line.xz + line.yz * line.yz),
   * i = 0.0,
   * )
   */
  def projectOntoLine(line: Pga3dBivector): Pga3dPoint =
    Pga3dPoint(
      wxy = (line.xy * (line.xy * wxy + line.xz * wxz + line.yz * wyz) + xyz * (-line.wx * line.xz - line.wy * line.yz)),
      wxz = (line.xz * (line.xy * wxy + line.xz * wxz + line.yz * wyz) + xyz * (line.wx * line.xy - line.wz * line.yz)),
      wyz = (line.yz * (line.xy * wxy + line.xz * wxz + line.yz * wyz) + xyz * (line.wy * line.xy + line.wz * line.xz)),
      xyz = xyz * (line.xy * line.xy + line.xz * line.xz + line.yz * line.yz),
    )

  infix def geometric(v: Pga3dMultivector): Pga3dMultivector =
    Pga3dMultivector(
      s = -v.xyz * xyz,
      w = (v.i * xyz - v.xy * wxy - v.xz * wxz - v.yz * wyz),
      x = -v.yz * xyz,
      y = v.xz * xyz,
      z = -v.xy * xyz,
      wx = (v.wyz * xyz + v.y * wxy + v.z * wxz - v.xyz * wyz),
      wy = (v.xyz * wxz + v.z * wyz - v.wxz * xyz - v.x * wxy),
      wz = (v.wxy * xyz - v.x * wxz - v.xyz * wxy - v.y * wyz),
      xy = v.z * xyz,
      xz = -v.y * xyz,
      yz = v.x * xyz,
      wxy = (v.s * wxy + v.xz * wyz - v.wz * xyz - v.yz * wxz),
      wxz = (v.s * wxz + v.wy * xyz + v.yz * wxy - v.xy * wyz),
      wyz = (v.s * wyz + v.xy * wxz - v.wx * xyz - v.xz * wxy),
      xyz = v.s * xyz,
      i = (v.x * wyz + v.z * wxy - v.w * xyz - v.y * wxz),
    )

  infix def geometric(v: Pga3dMotor): Pga3dMultivector =
    Pga3dMultivector(
      s = 0.0,
      w = (v.i * xyz - v.xy * wxy - v.xz * wxz - v.yz * wyz),
      x = -v.yz * xyz,
      y = v.xz * xyz,
      z = -v.xy * xyz,
      wx = 0.0,
      wy = 0.0,
      wz = 0.0,
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
      wxy = (v.s * wxy + v.xz * wyz - v.wz * xyz - v.yz * wxz),
      wxz = (v.s * wxz + v.wy * xyz + v.yz * wxy - v.xy * wyz),
      wyz = (v.s * wyz + v.xy * wxz - v.wx * xyz - v.xz * wxy),
      xyz = v.s * xyz,
      i = 0.0,
    )

  infix def geometric(v: Pga3dPlane): Pga3dMotor =
    Pga3dMotor(
      s = 0.0,
      wx = (v.y * wxy + v.z * wxz),
      wy = (v.z * wyz - v.x * wxy),
      wz = (-v.x * wxz - v.y * wyz),
      xy = v.z * xyz,
      xz = -v.y * xyz,
      yz = v.x * xyz,
      i = (v.x * wyz + v.z * wxy - v.w * xyz - v.y * wxz),
    )

  infix def geometric(v: Pga3dBivector): Pga3dMultivector =
    Pga3dMultivector(
      s = 0.0,
      w = (-v.xy * wxy - v.xz * wxz - v.yz * wyz),
      x = -v.yz * xyz,
      y = v.xz * xyz,
      z = -v.xy * xyz,
      wx = 0.0,
      wy = 0.0,
      wz = 0.0,
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
      wxy = (v.xz * wyz - v.wz * xyz - v.yz * wxz),
      wxz = (v.wy * xyz + v.yz * wxy - v.xy * wyz),
      wyz = (v.xy * wxz - v.wx * xyz - v.xz * wxy),
      xyz = 0.0,
      i = 0.0,
    )

  infix def geometric(v: Pga3dPoint): Pga3dMotor =
    Pga3dMotor(
      s = -v.xyz * xyz,
      wx = (v.wyz * xyz - v.xyz * wyz),
      wy = (v.xyz * wxz - v.wxz * xyz),
      wz = (v.wxy * xyz - v.xyz * wxy),
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
      i = 0.0,
    )

  infix def geometric(v: Pga3dQuaternion): Pga3dMultivector =
    Pga3dMultivector(
      s = 0.0,
      w = (-v.xy * wxy - v.xz * wxz - v.yz * wyz),
      x = -v.yz * xyz,
      y = v.xz * xyz,
      z = -v.xy * xyz,
      wx = 0.0,
      wy = 0.0,
      wz = 0.0,
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
      wxy = (v.s * wxy + v.xz * wyz - v.yz * wxz),
      wxz = (v.s * wxz + v.yz * wxy - v.xy * wyz),
      wyz = (v.s * wyz + v.xy * wxz - v.xz * wxy),
      xyz = v.s * xyz,
      i = 0.0,
    )

  infix def geometric(v: Pga3dTranslator): Pga3dPoint =
    Pga3dPoint(
      wxy = (wxy - v.wz * xyz),
      wxz = (wxz + v.wy * xyz),
      wyz = (wyz - v.wx * xyz),
      xyz = xyz,
    )

  infix def geometric(v: Pga3dVector): Pga3dBivectorWeight =
    Pga3dBivectorWeight(
      wx = v.wyz * xyz,
      wy = -v.wxz * xyz,
      wz = v.wxy * xyz,
    )

  infix def geometric(v: Pga3dPointNormalized): Pga3dMotor =
    Pga3dMotor(
      s = -xyz,
      wx = (-wyz + v.wyz * xyz),
      wy = (wxz - v.wxz * xyz),
      wz = (-wxy + v.wxy * xyz),
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
      xy = v.z * xyz,
      xz = -v.y * xyz,
      yz = v.x * xyz,
      i = (v.x * wyz + v.z * wxy - v.y * wxz),
    )

  infix def geometric(v: Pga3dBivectorBulk): Pga3dMultivector =
    Pga3dMultivector(
      s = 0.0,
      w = (-v.xy * wxy - v.xz * wxz - v.yz * wyz),
      x = -v.yz * xyz,
      y = v.xz * xyz,
      z = -v.xy * xyz,
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
      wxy = -v.wz * xyz,
      wxz = v.wy * xyz,
      wyz = -v.wx * xyz,
    )

  infix def geometric(v: Pga3dPseudoScalar): Pga3dPlane =
    Pga3dPlane(
      w = v.i * xyz,
      x = 0.0,
      y = 0.0,
      z = 0.0,
    )

  infix def geometric(v: Pga3dPointCenter.type): Pga3dMotor =
    Pga3dMotor(
      s = -xyz,
      wx = -wyz,
      wy = wxz,
      wz = -wxy,
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
      i = 0.0,
    )

  infix def dot(v: Pga3dMultivector): Pga3dMultivector =
    Pga3dMultivector(
      s = -v.xyz * xyz,
      w = (v.i * xyz - v.xy * wxy - v.xz * wxz - v.yz * wyz),
      x = -v.yz * xyz,
      y = v.xz * xyz,
      z = -v.xy * xyz,
      wx = (v.y * wxy + v.z * wxz),
      wy = (v.z * wyz - v.x * wxy),
      wz = (-v.x * wxz - v.y * wyz),
      xy = v.z * xyz,
      xz = -v.y * xyz,
      yz = v.x * xyz,
      wxy = v.s * wxy,
      wxz = v.s * wxz,
      wyz = v.s * wyz,
      xyz = v.s * xyz,
      i = 0.0,
    )

  infix def dot(v: Pga3dMotor): Pga3dMultivector =
    Pga3dMultivector(
      s = 0.0,
      w = (v.i * xyz - v.xy * wxy - v.xz * wxz - v.yz * wyz),
      x = -v.yz * xyz,
      y = v.xz * xyz,
      z = -v.xy * xyz,
      wx = 0.0,
      wy = 0.0,
      wz = 0.0,
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
      wxy = v.s * wxy,
      wxz = v.s * wxz,
      wyz = v.s * wyz,
      xyz = v.s * xyz,
      i = 0.0,
    )

  infix def dot(v: Pga3dPlane): Pga3dBivector =
    Pga3dBivector(
      wx = (v.y * wxy + v.z * wxz),
      wy = (v.z * wyz - v.x * wxy),
      wz = (-v.x * wxz - v.y * wyz),
      xy = v.z * xyz,
      xz = -v.y * xyz,
      yz = v.x * xyz,
    )

  infix def dot(v: Pga3dBivector): Pga3dPlane =
    Pga3dPlane(
      w = (-v.xy * wxy - v.xz * wxz - v.yz * wyz),
      x = -v.yz * xyz,
      y = v.xz * xyz,
      z = -v.xy * xyz,
    )

  infix def dot(v: Pga3dPoint): Double =
    -v.xyz * xyz

  infix def dot(v: Pga3dQuaternion): Pga3dMultivector =
    Pga3dMultivector(
      s = 0.0,
      w = (-v.xy * wxy - v.xz * wxz - v.yz * wyz),
      x = -v.yz * xyz,
      y = v.xz * xyz,
      z = -v.xy * xyz,
      wx = 0.0,
      wy = 0.0,
      wz = 0.0,
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
      wxy = v.s * wxy,
      wxz = v.s * wxz,
      wyz = v.s * wyz,
      xyz = v.s * xyz,
      i = 0.0,
    )

  infix def dot(v: Pga3dTranslator): Pga3dPoint =
    this

  infix def dot(v: Pga3dPointNormalized): Double =
    -xyz

  infix def dot(v: Pga3dPlaneIdeal): Pga3dBivector =
    Pga3dBivector(
      wx = (v.y * wxy + v.z * wxz),
      wy = (v.z * wyz - v.x * wxy),
      wz = (-v.x * wxz - v.y * wyz),
      xy = v.z * xyz,
      xz = -v.y * xyz,
      yz = v.x * xyz,
    )

  infix def dot(v: Pga3dBivectorBulk): Pga3dPlane =
    Pga3dPlane(
      w = (-v.xy * wxy - v.xz * wxz - v.yz * wyz),
      x = -v.yz * xyz,
      y = v.xz * xyz,
      z = -v.xy * xyz,
    )

  infix def dot(v: Pga3dPseudoScalar): Pga3dPlane =
    Pga3dPlane(
      w = v.i * xyz,
      x = 0.0,
      y = 0.0,
      z = 0.0,
    )

  infix def dot(v: Pga3dPointCenter.type): Double =
    -xyz

  infix def wedge(v: Pga3dMultivector): Pga3dMultivector =
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
      wxy = v.s * wxy,
      wxz = v.s * wxz,
      wyz = v.s * wyz,
      xyz = v.s * xyz,
      i = (v.x * wyz + v.z * wxy - v.w * xyz - v.y * wxz),
    )

  inline infix def ^(v: Pga3dMultivector): Pga3dMultivector = wedge(v)

  infix def wedge(v: Pga3dMotor): Pga3dPoint =
    Pga3dPoint(
      wxy = v.s * wxy,
      wxz = v.s * wxz,
      wyz = v.s * wyz,
      xyz = v.s * xyz,
    )

  inline infix def ^(v: Pga3dMotor): Pga3dPoint = wedge(v)

  infix def wedge(v: Pga3dPlane): Pga3dPseudoScalar =
    Pga3dPseudoScalar(
      i = (v.x * wyz + v.z * wxy - v.w * xyz - v.y * wxz),
    )

  inline infix def ^(v: Pga3dPlane): Pga3dPseudoScalar = wedge(v)

  infix def wedge(v: Pga3dQuaternion): Pga3dPoint =
    Pga3dPoint(
      wxy = v.s * wxy,
      wxz = v.s * wxz,
      wyz = v.s * wyz,
      xyz = v.s * xyz,
    )

  inline infix def ^(v: Pga3dQuaternion): Pga3dPoint = wedge(v)

  infix def wedge(v: Pga3dTranslator): Pga3dPoint =
    this

  inline infix def ^(v: Pga3dTranslator): Pga3dPoint = wedge(v)

  infix def wedge(v: Pga3dPlaneIdeal): Pga3dPseudoScalar =
    Pga3dPseudoScalar(
      i = (v.x * wyz + v.z * wxy - v.y * wxz),
    )

  inline infix def ^(v: Pga3dPlaneIdeal): Pga3dPseudoScalar = wedge(v)

  infix def antiGeometric(v: Pga3dMultivector): Pga3dMultivector =
    Pga3dMultivector(
      s = (v.w * xyz + v.y * wxz - v.x * wyz - v.z * wxy),
      w = (v.wy * wxz - v.wx * wyz - v.wz * wxy),
      x = (v.xy * wxz - v.s * wyz - v.wx * xyz - v.xz * wxy),
      y = (v.s * wxz + v.xy * wyz - v.wy * xyz - v.yz * wxy),
      z = (v.xz * wyz - v.s * wxy - v.wz * xyz - v.yz * wxz),
      wx = (v.wxz * wxy - v.w * wyz - v.wxy * wxz),
      wy = (v.w * wxz + v.wyz * wxy - v.wxy * wyz),
      wz = (v.wyz * wxz - v.w * wxy - v.wxz * wyz),
      xy = (v.x * wxz + v.xyz * wxy + v.y * wyz - v.wxy * xyz),
      xz = (v.xyz * wxz + v.z * wyz - v.wxz * xyz - v.x * wxy),
      yz = (v.xyz * wyz - v.wyz * xyz - v.y * wxy - v.z * wxz),
      wxy = (v.i * wxy - v.wx * wxz - v.wy * wyz),
      wxz = (v.i * wxz + v.wx * wxy - v.wz * wyz),
      wyz = (v.i * wyz + v.wy * wxy + v.wz * wxz),
      xyz = (v.i * xyz + v.xy * wxy + v.xz * wxz + v.yz * wyz),
      i = (v.wxy * wxy + v.wxz * wxz + v.wyz * wyz),
    )

  infix def antiGeometric(v: Pga3dMotor): Pga3dMultivector =
    Pga3dMultivector(
      s = 0.0,
      w = (v.wy * wxz - v.wx * wyz - v.wz * wxy),
      x = (v.xy * wxz - v.s * wyz - v.wx * xyz - v.xz * wxy),
      y = (v.s * wxz + v.xy * wyz - v.wy * xyz - v.yz * wxy),
      z = (v.xz * wyz - v.s * wxy - v.wz * xyz - v.yz * wxz),
      wx = 0.0,
      wy = 0.0,
      wz = 0.0,
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
      wxy = (v.i * wxy - v.wx * wxz - v.wy * wyz),
      wxz = (v.i * wxz + v.wx * wxy - v.wz * wyz),
      wyz = (v.i * wyz + v.wy * wxy + v.wz * wxz),
      xyz = (v.i * xyz + v.xy * wxy + v.xz * wxz + v.yz * wyz),
      i = 0.0,
    )

  infix def antiGeometric(v: Pga3dPlane): Pga3dMotor =
    Pga3dMotor(
      s = (v.w * xyz + v.y * wxz - v.x * wyz - v.z * wxy),
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
      x = (v.xy * wxz - v.wx * xyz - v.xz * wxy),
      y = (v.xy * wyz - v.wy * xyz - v.yz * wxy),
      z = (v.xz * wyz - v.wz * xyz - v.yz * wxz),
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
      xy = (v.xyz * wxy - v.wxy * xyz),
      xz = (v.xyz * wxz - v.wxz * xyz),
      yz = (v.xyz * wyz - v.wyz * xyz),
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
      x = (-wyz - v.wx * xyz),
      y = (wxz - v.wy * xyz),
      z = (-wxy - v.wz * xyz),
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
      xy = -v.wxy * xyz,
      xz = -v.wxz * xyz,
      yz = -v.wyz * xyz,
      i = (v.wxy * wxy + v.wxz * wxz + v.wyz * wyz),
    )

  infix def antiGeometric(v: Pga3dPointNormalized): Pga3dMotor =
    Pga3dMotor(
      s = 0.0,
      wx = (v.wxz * wxy - v.wxy * wxz),
      wy = (v.wyz * wxy - v.wxy * wyz),
      wz = (v.wyz * wxz - v.wxz * wyz),
      xy = (wxy - v.wxy * xyz),
      xz = (wxz - v.wxz * xyz),
      yz = (wyz - v.wyz * xyz),
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
      x = -v.wx * xyz,
      y = -v.wy * xyz,
      z = -v.wz * xyz,
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
      xyz = v.i * xyz,
    )

  infix def antiGeometric(v: Pga3dPointCenter.type): Pga3dBivectorBulk =
    Pga3dBivectorBulk(
      xy = wxy,
      xz = wxz,
      yz = wyz,
    )

  infix def antiDot(v: Pga3dMultivector): Pga3dMultivector =
    Pga3dMultivector(
      s = 0.0,
      w = 0.0,
      x = -v.s * wyz,
      y = v.s * wxz,
      z = -v.s * wxy,
      wx = -v.w * wyz,
      wy = v.w * wxz,
      wz = -v.w * wxy,
      xy = (v.x * wxz + v.y * wyz),
      xz = (v.z * wyz - v.x * wxy),
      yz = (-v.y * wxy - v.z * wxz),
      wxy = (v.i * wxy - v.wx * wxz - v.wy * wyz),
      wxz = (v.i * wxz + v.wx * wxy - v.wz * wyz),
      wyz = (v.i * wyz + v.wy * wxy + v.wz * wxz),
      xyz = (v.i * xyz + v.xy * wxy + v.xz * wxz + v.yz * wyz),
      i = (v.wxy * wxy + v.wxz * wxz + v.wyz * wyz),
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
      xyz = (v.i * xyz + v.xy * wxy + v.xz * wxz + v.yz * wyz),
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
      xyz = v.i * xyz,
    )

  infix def antiWedge(v: Pga3dMultivector): Pga3dMultivector =
    Pga3dMultivector(
      s = (v.w * xyz + v.y * wxz - v.x * wyz - v.z * wxy),
      w = (v.wy * wxz - v.wx * wyz - v.wz * wxy),
      x = (v.xy * wxz - v.wx * xyz - v.xz * wxy),
      y = (v.xy * wyz - v.wy * xyz - v.yz * wxy),
      z = (v.xz * wyz - v.wz * xyz - v.yz * wxz),
      wx = (v.wxz * wxy - v.wxy * wxz),
      wy = (v.wyz * wxy - v.wxy * wyz),
      wz = (v.wyz * wxz - v.wxz * wyz),
      xy = (v.xyz * wxy - v.wxy * xyz),
      xz = (v.xyz * wxz - v.wxz * xyz),
      yz = (v.xyz * wyz - v.wyz * xyz),
      wxy = v.i * wxy,
      wxz = v.i * wxz,
      wyz = v.i * wyz,
      xyz = v.i * xyz,
      i = 0.0,
    )

  inline infix def v(v: Pga3dMultivector): Pga3dMultivector = antiWedge(v)

  infix def antiWedge(v: Pga3dMotor): Pga3dMultivector =
    Pga3dMultivector(
      s = 0.0,
      w = (v.wy * wxz - v.wx * wyz - v.wz * wxy),
      x = (v.xy * wxz - v.wx * xyz - v.xz * wxy),
      y = (v.xy * wyz - v.wy * xyz - v.yz * wxy),
      z = (v.xz * wyz - v.wz * xyz - v.yz * wxz),
      wx = 0.0,
      wy = 0.0,
      wz = 0.0,
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
      wxy = v.i * wxy,
      wxz = v.i * wxz,
      wyz = v.i * wyz,
      xyz = v.i * xyz,
      i = 0.0,
    )

  inline infix def v(v: Pga3dMotor): Pga3dMultivector = antiWedge(v)

  infix def antiWedge(v: Pga3dPlane): Double =
    (v.w * xyz + v.y * wxz - v.x * wyz - v.z * wxy)

  inline infix def v(v: Pga3dPlane): Double = antiWedge(v)

  infix def antiWedge(v: Pga3dBivector): Pga3dPlane =
    Pga3dPlane(
      w = (v.wy * wxz - v.wx * wyz - v.wz * wxy),
      x = (v.xy * wxz - v.wx * xyz - v.xz * wxy),
      y = (v.xy * wyz - v.wy * xyz - v.yz * wxy),
      z = (v.xz * wyz - v.wz * xyz - v.yz * wxz),
    )

  inline infix def v(v: Pga3dBivector): Pga3dPlane = antiWedge(v)

  infix def antiWedge(v: Pga3dPoint): Pga3dBivector =
    Pga3dBivector(
      wx = (v.wxz * wxy - v.wxy * wxz),
      wy = (v.wyz * wxy - v.wxy * wyz),
      wz = (v.wyz * wxz - v.wxz * wyz),
      xy = (v.xyz * wxy - v.wxy * xyz),
      xz = (v.xyz * wxz - v.wxz * xyz),
      yz = (v.xyz * wyz - v.wyz * xyz),
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
      w = (v.wy * wxz - v.wx * wyz - v.wz * wxy),
      x = -v.wx * xyz,
      y = -v.wy * xyz,
      z = -v.wz * xyz,
    )

  inline infix def v(v: Pga3dTranslator): Pga3dPlane = antiWedge(v)

  infix def antiWedge(v: Pga3dVector): Pga3dBivector =
    Pga3dBivector(
      wx = (v.wxz * wxy - v.wxy * wxz),
      wy = (v.wyz * wxy - v.wxy * wyz),
      wz = (v.wyz * wxz - v.wxz * wyz),
      xy = -v.wxy * xyz,
      xz = -v.wxz * xyz,
      yz = -v.wyz * xyz,
    )

  inline infix def v(v: Pga3dVector): Pga3dBivector = antiWedge(v)

  infix def antiWedge(v: Pga3dPointNormalized): Pga3dBivector =
    Pga3dBivector(
      wx = (v.wxz * wxy - v.wxy * wxz),
      wy = (v.wyz * wxy - v.wxy * wyz),
      wz = (v.wyz * wxz - v.wxz * wyz),
      xy = (wxy - v.wxy * xyz),
      xz = (wxz - v.wxz * xyz),
      yz = (wyz - v.wyz * xyz),
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
      w = (v.wy * wxz - v.wx * wyz - v.wz * wxy),
      x = -v.wx * xyz,
      y = -v.wy * xyz,
      z = -v.wz * xyz,
    )

  inline infix def v(v: Pga3dBivectorWeight): Pga3dPlane = antiWedge(v)

  infix def antiWedge(v: Pga3dPseudoScalar): Pga3dPoint =
    Pga3dPoint(
      wxy = v.i * wxy,
      wxz = v.i * wxz,
      wyz = v.i * wyz,
      xyz = v.i * xyz,
    )

  inline infix def v(v: Pga3dPseudoScalar): Pga3dPoint = antiWedge(v)

  infix def antiWedge(v: Pga3dPointCenter.type): Pga3dBivectorBulk =
    Pga3dBivectorBulk(
      xy = wxy,
      xz = wxz,
      yz = wyz,
    )

  inline infix def v(v: Pga3dPointCenter.type): Pga3dBivectorBulk = antiWedge(v)

  infix def sandwich(v: Pga3dMultivector): Pga3dMultivector =
    val wxyMxyz = wxy * xyz
    val wxzMxyz = wxz * xyz
    val wyzMxyz = wyz * xyz
    val xyzMxyz = xyz * xyz
    Pga3dMultivector(
      s = v.s * xyzMxyz,
      w = (2.0 * (v.x * wyzMxyz + v.z * wxyMxyz - v.y * wxzMxyz) - v.w * xyzMxyz),
      x = v.x * xyzMxyz,
      y = v.y * xyzMxyz,
      z = v.z * xyzMxyz,
      wx = (2.0 * (v.xy * wxzMxyz - v.xz * wxyMxyz) - v.wx * xyzMxyz),
      wy = (2.0 * (v.xy * wyzMxyz - v.yz * wxyMxyz) - v.wy * xyzMxyz),
      wz = (2.0 * (v.xz * wyzMxyz - v.yz * wxzMxyz) - v.wz * xyzMxyz),
      xy = v.xy * xyzMxyz,
      xz = v.xz * xyzMxyz,
      yz = v.yz * xyzMxyz,
      wxy = (-v.wxy * xyzMxyz + 2.0 * v.xyz * wxyMxyz),
      wxz = (-v.wxz * xyzMxyz + 2.0 * v.xyz * wxzMxyz),
      wyz = (-v.wyz * xyzMxyz + 2.0 * v.xyz * wyzMxyz),
      xyz = v.xyz * xyzMxyz,
      i = -v.i * xyzMxyz,
    )

  infix def sandwich(v: Pga3dMotor): Pga3dMotor =
    val wxyMxyz = wxy * xyz
    val wxzMxyz = wxz * xyz
    val wyzMxyz = wyz * xyz
    val xyzMxyz = xyz * xyz
    Pga3dMotor(
      s = v.s * xyzMxyz,
      wx = (2.0 * (v.xy * wxzMxyz - v.xz * wxyMxyz) - v.wx * xyzMxyz),
      wy = (2.0 * (v.xy * wyzMxyz - v.yz * wxyMxyz) - v.wy * xyzMxyz),
      wz = (2.0 * (v.xz * wyzMxyz - v.yz * wxzMxyz) - v.wz * xyzMxyz),
      xy = v.xy * xyzMxyz,
      xz = v.xz * xyzMxyz,
      yz = v.yz * xyzMxyz,
      i = -v.i * xyzMxyz,
    )

  infix def sandwich(v: Pga3dPlane): Pga3dPlane =
    val xyzMxyz = xyz * xyz
    Pga3dPlane(
      w = (-v.w * xyzMxyz + 2.0 * xyz * (v.x * wyz + v.z * wxy - v.y * wxz)),
      x = v.x * xyzMxyz,
      y = v.y * xyzMxyz,
      z = v.z * xyzMxyz,
    )

  infix def sandwich(v: Pga3dBivector): Pga3dBivector =
    val wxyMxyz = wxy * xyz
    val wxzMxyz = wxz * xyz
    val wyzMxyz = wyz * xyz
    val xyzMxyz = xyz * xyz
    Pga3dBivector(
      wx = (2.0 * (v.xy * wxzMxyz - v.xz * wxyMxyz) - v.wx * xyzMxyz),
      wy = (2.0 * (v.xy * wyzMxyz - v.yz * wxyMxyz) - v.wy * xyzMxyz),
      wz = (2.0 * (v.xz * wyzMxyz - v.yz * wxzMxyz) - v.wz * xyzMxyz),
      xy = v.xy * xyzMxyz,
      xz = v.xz * xyzMxyz,
      yz = v.yz * xyzMxyz,
    )

  infix def sandwich(v: Pga3dPoint): Pga3dPoint =
    val xyzMxyz = xyz * xyz
    Pga3dPoint(
      wxy = (-v.wxy * xyzMxyz + 2.0 * v.xyz * wxy * xyz),
      wxz = (-v.wxz * xyzMxyz + 2.0 * v.xyz * wxz * xyz),
      wyz = (-v.wyz * xyzMxyz + 2.0 * v.xyz * wyz * xyz),
      xyz = v.xyz * xyzMxyz,
    )

  infix def sandwich(v: Pga3dQuaternion): Pga3dMotor =
    val wxyMxyz = wxy * xyz
    val wxzMxyz = wxz * xyz
    val wyzMxyz = wyz * xyz
    val xyzMxyz = xyz * xyz
    Pga3dMotor(
      s = v.s * xyzMxyz,
      wx = 2.0 * (v.xy * wxzMxyz - v.xz * wxyMxyz),
      wy = 2.0 * (v.xy * wyzMxyz - v.yz * wxyMxyz),
      wz = 2.0 * (v.xz * wyzMxyz - v.yz * wxzMxyz),
      xy = v.xy * xyzMxyz,
      xz = v.xz * xyzMxyz,
      yz = v.yz * xyzMxyz,
      i = 0.0,
    )

  infix def sandwich(v: Pga3dTranslator): Pga3dMotor =
    val xyzMxyz = xyz * xyz
    Pga3dMotor(
      s = xyzMxyz,
      wx = -v.wx * xyzMxyz,
      wy = -v.wy * xyzMxyz,
      wz = -v.wz * xyzMxyz,
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
      i = 0.0,
    )

  infix def sandwich(v: Pga3dVector): Pga3dVector =
    val xyzMxyz = xyz * xyz
    Pga3dVector(
      wxy = -v.wxy * xyzMxyz,
      wxz = -v.wxz * xyzMxyz,
      wyz = -v.wyz * xyzMxyz,
    )

  infix def sandwich(v: Pga3dPointNormalized): Pga3dPoint =
    val xyzMxyz = xyz * xyz
    Pga3dPoint(
      wxy = (-v.wxy * xyzMxyz + 2.0 * wxy * xyz),
      wxz = (-v.wxz * xyzMxyz + 2.0 * wxz * xyz),
      wyz = (-v.wyz * xyzMxyz + 2.0 * wyz * xyz),
      xyz = xyzMxyz,
    )

  infix def sandwich(v: Pga3dPlaneIdeal): Pga3dPlane =
    val xyzMxyz = xyz * xyz
    Pga3dPlane(
      w = 2.0 * xyz * (v.x * wyz + v.z * wxy - v.y * wxz),
      x = v.x * xyzMxyz,
      y = v.y * xyzMxyz,
      z = v.z * xyzMxyz,
    )

  infix def sandwich(v: Pga3dBivectorBulk): Pga3dBivector =
    val wxyMxyz = wxy * xyz
    val wxzMxyz = wxz * xyz
    val wyzMxyz = wyz * xyz
    val xyzMxyz = xyz * xyz
    Pga3dBivector(
      wx = 2.0 * (v.xy * wxzMxyz - v.xz * wxyMxyz),
      wy = 2.0 * (v.xy * wyzMxyz - v.yz * wxyMxyz),
      wz = 2.0 * (v.xz * wyzMxyz - v.yz * wxzMxyz),
      xy = v.xy * xyzMxyz,
      xz = v.xz * xyzMxyz,
      yz = v.yz * xyzMxyz,
    )

  infix def sandwich(v: Pga3dBivectorWeight): Pga3dBivectorWeight =
    val xyzMxyz = xyz * xyz
    Pga3dBivectorWeight(
      wx = -v.wx * xyzMxyz,
      wy = -v.wy * xyzMxyz,
      wz = -v.wz * xyzMxyz,
    )

  infix def sandwich(v: Pga3dPseudoScalar): Pga3dPseudoScalar =
    Pga3dPseudoScalar(
      i = -v.i * xyz * xyz,
    )

  infix def sandwich(v: Pga3dPointCenter.type): Pga3dPoint =
    Pga3dPoint(
      wxy = 2.0 * wxy * xyz,
      wxz = 2.0 * wxz * xyz,
      wyz = 2.0 * wyz * xyz,
      xyz = xyz * xyz,
    )

  infix def reverseSandwich(v: Pga3dMultivector): Pga3dMultivector =
    val wxyMxyz = wxy * xyz
    val wxzMxyz = wxz * xyz
    val wyzMxyz = wyz * xyz
    val xyzMxyz = xyz * xyz
    Pga3dMultivector(
      s = v.s * xyzMxyz,
      w = (2.0 * (v.x * wyzMxyz + v.z * wxyMxyz - v.y * wxzMxyz) - v.w * xyzMxyz),
      x = v.x * xyzMxyz,
      y = v.y * xyzMxyz,
      z = v.z * xyzMxyz,
      wx = (2.0 * (v.xy * wxzMxyz - v.xz * wxyMxyz) - v.wx * xyzMxyz),
      wy = (2.0 * (v.xy * wyzMxyz - v.yz * wxyMxyz) - v.wy * xyzMxyz),
      wz = (2.0 * (v.xz * wyzMxyz - v.yz * wxzMxyz) - v.wz * xyzMxyz),
      xy = v.xy * xyzMxyz,
      xz = v.xz * xyzMxyz,
      yz = v.yz * xyzMxyz,
      wxy = (-v.wxy * xyzMxyz + 2.0 * v.xyz * wxyMxyz),
      wxz = (-v.wxz * xyzMxyz + 2.0 * v.xyz * wxzMxyz),
      wyz = (-v.wyz * xyzMxyz + 2.0 * v.xyz * wyzMxyz),
      xyz = v.xyz * xyzMxyz,
      i = -v.i * xyzMxyz,
    )

  infix def reverseSandwich(v: Pga3dMotor): Pga3dMotor =
    val wxyMxyz = wxy * xyz
    val wxzMxyz = wxz * xyz
    val wyzMxyz = wyz * xyz
    val xyzMxyz = xyz * xyz
    Pga3dMotor(
      s = v.s * xyzMxyz,
      wx = (2.0 * (v.xy * wxzMxyz - v.xz * wxyMxyz) - v.wx * xyzMxyz),
      wy = (2.0 * (v.xy * wyzMxyz - v.yz * wxyMxyz) - v.wy * xyzMxyz),
      wz = (2.0 * (v.xz * wyzMxyz - v.yz * wxzMxyz) - v.wz * xyzMxyz),
      xy = v.xy * xyzMxyz,
      xz = v.xz * xyzMxyz,
      yz = v.yz * xyzMxyz,
      i = -v.i * xyzMxyz,
    )

  infix def reverseSandwich(v: Pga3dPlane): Pga3dPlane =
    val xyzMxyz = xyz * xyz
    Pga3dPlane(
      w = (-v.w * xyzMxyz + 2.0 * xyz * (v.x * wyz + v.z * wxy - v.y * wxz)),
      x = v.x * xyzMxyz,
      y = v.y * xyzMxyz,
      z = v.z * xyzMxyz,
    )

  infix def reverseSandwich(v: Pga3dBivector): Pga3dBivector =
    val wxyMxyz = wxy * xyz
    val wxzMxyz = wxz * xyz
    val wyzMxyz = wyz * xyz
    val xyzMxyz = xyz * xyz
    Pga3dBivector(
      wx = (2.0 * (v.xy * wxzMxyz - v.xz * wxyMxyz) - v.wx * xyzMxyz),
      wy = (2.0 * (v.xy * wyzMxyz - v.yz * wxyMxyz) - v.wy * xyzMxyz),
      wz = (2.0 * (v.xz * wyzMxyz - v.yz * wxzMxyz) - v.wz * xyzMxyz),
      xy = v.xy * xyzMxyz,
      xz = v.xz * xyzMxyz,
      yz = v.yz * xyzMxyz,
    )

  infix def reverseSandwich(v: Pga3dPoint): Pga3dPoint =
    val xyzMxyz = xyz * xyz
    Pga3dPoint(
      wxy = (-v.wxy * xyzMxyz + 2.0 * v.xyz * wxy * xyz),
      wxz = (-v.wxz * xyzMxyz + 2.0 * v.xyz * wxz * xyz),
      wyz = (-v.wyz * xyzMxyz + 2.0 * v.xyz * wyz * xyz),
      xyz = v.xyz * xyzMxyz,
    )

  infix def reverseSandwich(v: Pga3dQuaternion): Pga3dMotor =
    val wxyMxyz = wxy * xyz
    val wxzMxyz = wxz * xyz
    val wyzMxyz = wyz * xyz
    val xyzMxyz = xyz * xyz
    Pga3dMotor(
      s = v.s * xyzMxyz,
      wx = 2.0 * (v.xy * wxzMxyz - v.xz * wxyMxyz),
      wy = 2.0 * (v.xy * wyzMxyz - v.yz * wxyMxyz),
      wz = 2.0 * (v.xz * wyzMxyz - v.yz * wxzMxyz),
      xy = v.xy * xyzMxyz,
      xz = v.xz * xyzMxyz,
      yz = v.yz * xyzMxyz,
      i = 0.0,
    )

  infix def reverseSandwich(v: Pga3dTranslator): Pga3dMotor =
    val xyzMxyz = xyz * xyz
    Pga3dMotor(
      s = xyzMxyz,
      wx = -v.wx * xyzMxyz,
      wy = -v.wy * xyzMxyz,
      wz = -v.wz * xyzMxyz,
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
      i = 0.0,
    )

  infix def reverseSandwich(v: Pga3dVector): Pga3dVector =
    val xyzMxyz = xyz * xyz
    Pga3dVector(
      wxy = -v.wxy * xyzMxyz,
      wxz = -v.wxz * xyzMxyz,
      wyz = -v.wyz * xyzMxyz,
    )

  infix def reverseSandwich(v: Pga3dPointNormalized): Pga3dPoint =
    val xyzMxyz = xyz * xyz
    Pga3dPoint(
      wxy = (-v.wxy * xyzMxyz + 2.0 * wxy * xyz),
      wxz = (-v.wxz * xyzMxyz + 2.0 * wxz * xyz),
      wyz = (-v.wyz * xyzMxyz + 2.0 * wyz * xyz),
      xyz = xyzMxyz,
    )

  infix def reverseSandwich(v: Pga3dPlaneIdeal): Pga3dPlane =
    val xyzMxyz = xyz * xyz
    Pga3dPlane(
      w = 2.0 * xyz * (v.x * wyz + v.z * wxy - v.y * wxz),
      x = v.x * xyzMxyz,
      y = v.y * xyzMxyz,
      z = v.z * xyzMxyz,
    )

  infix def reverseSandwich(v: Pga3dBivectorBulk): Pga3dBivector =
    val wxyMxyz = wxy * xyz
    val wxzMxyz = wxz * xyz
    val wyzMxyz = wyz * xyz
    val xyzMxyz = xyz * xyz
    Pga3dBivector(
      wx = 2.0 * (v.xy * wxzMxyz - v.xz * wxyMxyz),
      wy = 2.0 * (v.xy * wyzMxyz - v.yz * wxyMxyz),
      wz = 2.0 * (v.xz * wyzMxyz - v.yz * wxzMxyz),
      xy = v.xy * xyzMxyz,
      xz = v.xz * xyzMxyz,
      yz = v.yz * xyzMxyz,
    )

  infix def reverseSandwich(v: Pga3dBivectorWeight): Pga3dBivectorWeight =
    val xyzMxyz = xyz * xyz
    Pga3dBivectorWeight(
      wx = -v.wx * xyzMxyz,
      wy = -v.wy * xyzMxyz,
      wz = -v.wz * xyzMxyz,
    )

  infix def reverseSandwich(v: Pga3dPseudoScalar): Pga3dPseudoScalar =
    Pga3dPseudoScalar(
      i = -v.i * xyz * xyz,
    )

  infix def reverseSandwich(v: Pga3dPointCenter.type): Pga3dPoint =
    Pga3dPoint(
      wxy = 2.0 * wxy * xyz,
      wxz = 2.0 * wxz * xyz,
      wyz = 2.0 * wyz * xyz,
      xyz = xyz * xyz,
    )

  infix def cross(v: Pga3dMultivector): Pga3dMultivector =
    Pga3dMultivector(
      s = 0.0,
      w = v.i * xyz,
      x = 0.0,
      y = 0.0,
      z = 0.0,
      wx = (v.wyz * xyz - v.xyz * wyz),
      wy = (v.xyz * wxz - v.wxz * xyz),
      wz = (v.wxy * xyz - v.xyz * wxy),
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
      wxy = (v.xz * wyz - v.wz * xyz - v.yz * wxz),
      wxz = (v.wy * xyz + v.yz * wxy - v.xy * wyz),
      wyz = (v.xy * wxz - v.wx * xyz - v.xz * wxy),
      xyz = 0.0,
      i = (v.x * wyz + v.z * wxy - v.w * xyz - v.y * wxz),
    )

  infix def cross(v: Pga3dMotor): Pga3dMultivector =
    Pga3dMultivector(
      s = 0.0,
      w = v.i * xyz,
      x = 0.0,
      y = 0.0,
      z = 0.0,
      wx = 0.0,
      wy = 0.0,
      wz = 0.0,
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
      wxy = (v.xz * wyz - v.wz * xyz - v.yz * wxz),
      wxz = (v.wy * xyz + v.yz * wxy - v.xy * wyz),
      wyz = (v.xy * wxz - v.wx * xyz - v.xz * wxy),
      xyz = 0.0,
      i = 0.0,
    )

  infix def cross(v: Pga3dPlane): Pga3dPseudoScalar =
    Pga3dPseudoScalar(
      i = (v.x * wyz + v.z * wxy - v.w * xyz - v.y * wxz),
    )

  infix def cross(v: Pga3dBivector): Pga3dVector =
    Pga3dVector(
      wxy = (v.xz * wyz - v.wz * xyz - v.yz * wxz),
      wxz = (v.wy * xyz + v.yz * wxy - v.xy * wyz),
      wyz = (v.xy * wxz - v.wx * xyz - v.xz * wxy),
    )

  infix def cross(v: Pga3dPoint): Pga3dBivectorWeight =
    Pga3dBivectorWeight(
      wx = (v.wyz * xyz - v.xyz * wyz),
      wy = (v.xyz * wxz - v.wxz * xyz),
      wz = (v.wxy * xyz - v.xyz * wxy),
    )

  infix def cross(v: Pga3dQuaternion): Pga3dVector =
    Pga3dVector(
      wxy = (v.xz * wyz - v.yz * wxz),
      wxz = (v.yz * wxy - v.xy * wyz),
      wyz = (v.xy * wxz - v.xz * wxy),
    )

  infix def cross(v: Pga3dTranslator): Pga3dVector =
    Pga3dVector(
      wxy = -v.wz * xyz,
      wxz = v.wy * xyz,
      wyz = -v.wx * xyz,
    )

  infix def cross(v: Pga3dVector): Pga3dBivectorWeight =
    Pga3dBivectorWeight(
      wx = v.wyz * xyz,
      wy = -v.wxz * xyz,
      wz = v.wxy * xyz,
    )

  infix def cross(v: Pga3dPointNormalized): Pga3dBivectorWeight =
    Pga3dBivectorWeight(
      wx = (-wyz + v.wyz * xyz),
      wy = (wxz - v.wxz * xyz),
      wz = (-wxy + v.wxy * xyz),
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
      wxy = -v.wz * xyz,
      wxz = v.wy * xyz,
      wyz = -v.wx * xyz,
    )

  infix def cross(v: Pga3dPseudoScalar): Pga3dPlane =
    Pga3dPlane(
      w = v.i * xyz,
      x = 0.0,
      y = 0.0,
      z = 0.0,
    )

  infix def cross(v: Pga3dPointCenter.type): Pga3dBivectorWeight =
    Pga3dBivectorWeight(
      wx = -wyz,
      wy = wxz,
      wz = -wxy,
    )


object Pga3dPoint:
  def fromDual(x: Double, y: Double, z: Double, w: Double): Pga3dPoint =
    Pga3dPoint(
      wxy = -z,
      wxz = y,
      wyz = -x,
      xyz = w,
    )