package com.github.kright.pga3d

/** this code is generated, see com.github.kright.pga3d.codegen.CodeGenClass */
case object Pga3dPointCenter:
  inline val wxy = 0.0
  inline val wxz = 0.0
  inline val wyz = 0.0
  inline val xyz = 1.0

  inline def dualX: Double = 0.0

  inline def dualW: Double = 1.0

  inline def dualY: Double = 0.0

  inline def dualZ: Double = 0.0

  def dual: Pga3dPlane =
    Pga3dPlane(
      w = 1.0,
      x = 0.0,
      y = 0.0,
      z = 0.0,
    )

  def bulk: Pga3dPointCenter.type =
    Pga3dPointCenter

  def unary_- : Pga3dPoint =
    Pga3dPoint(
      wxy = 0.0,
      wxz = 0.0,
      wyz = 0.0,
      xyz = -1.0,
    )

  def reverse: Pga3dPoint =
    Pga3dPoint(
      wxy = 0.0,
      wxz = 0.0,
      wyz = 0.0,
      xyz = -1.0,
    )

  def antiReverse: Pga3dPointCenter.type =
    this

  def bulkNormSquare: Double =
    1.0

  def bulkNorm: Double =
    Math.sqrt(bulkNormSquare)

  def normalizedByBulk =
    this / bulkNorm

  def normSquare: Double =
    1.0

  def norm: Double =
    Math.sqrt(normSquare)

  def normalizedByNorm =
    this / norm

  def *(v: Double): Pga3dPoint =
    Pga3dPoint(
      wxy = 0.0,
      wxz = 0.0,
      wyz = 0.0,
      xyz = v,
    )

  inline def /(v: Double): Pga3dPoint =
    this * (1.0 / v)

  def +(v: Pga3dPointCenter.type): Pga3dPoint =
    Pga3dPoint(
      wxy = 0.0,
      wxz = 0.0,
      wyz = 0.0,
      xyz = 2.0,
    )

  def madd(v: Pga3dPointCenter.type, mult: Double): Pga3dPoint =
    Pga3dPoint(
      wxy = 0.0,
      wxz = 0.0,
      wyz = 0.0,
      xyz = (1.0 + mult),
    )

  def multiplyElementwise(v: Pga3dPointCenter.type): Pga3dPointCenter.type =
    Pga3dPointCenter

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
      wxy = 0.0,
      wxz = 0.0,
      wyz = 0.0,
      xyz = 1.0,
      i = 0.0,
    )

  def toPoint: Pga3dPoint =
    Pga3dPoint(
      wxy = 0.0,
      wxz = 0.0,
      wyz = 0.0,
      xyz = 1.0,
    )

  def asVectorUnsafe: Pga3dVector =
    Pga3dVector(
      wxy = 0.0,
      wxz = 0.0,
      wyz = 0.0,
    )

  def toPointNormalized: Pga3dPointNormalized =
    Pga3dPointNormalized(
      wxy = 0.0,
      wxz = 0.0,
      wyz = 0.0,
    )

  /** fused plane.dot(point).geometric(plane) */
  def projectOntoPlane(plane: Pga3dPlane): Pga3dPoint =
    Pga3dPoint(
      wxy = plane.w * plane.z,
      wxz = -plane.w * plane.y,
      wyz = plane.w * plane.x,
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
   * wxy = (-line.wx * line.xz - line.wy * line.yz),
   * wxz = (line.wx * line.xy - line.wz * line.yz),
   * wyz = (line.wy * line.xy + line.wz * line.xz),
   * xyz = (line.xy * line.xy + line.xz * line.xz + line.yz * line.yz),
   * i = 0.0,
   * )
   */
  def projectOntoLine(line: Pga3dBivector): Pga3dPoint =
    Pga3dPoint(
      wxy = (-line.wx * line.xz - line.wy * line.yz),
      wxz = (line.wx * line.xy - line.wz * line.yz),
      wyz = (line.wy * line.xy + line.wz * line.xz),
      xyz = (line.xy * line.xy + line.xz * line.xz + line.yz * line.yz),
    )

  infix def geometric(v: Pga3dMotor): Pga3dMultivector =
    Pga3dMultivector(
      s = 0.0,
      w = v.i,
      x = -v.yz,
      y = v.xz,
      z = -v.xy,
      wx = 0.0,
      wy = 0.0,
      wz = 0.0,
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
      wxy = -v.wz,
      wxz = v.wy,
      wyz = -v.wx,
      xyz = v.s,
      i = 0.0,
    )

  infix def geometric(v: Pga3dPlane): Pga3dMotor =
    Pga3dMotor(
      s = 0.0,
      wx = 0.0,
      wy = 0.0,
      wz = 0.0,
      xy = v.z,
      xz = -v.y,
      yz = v.x,
      i = -v.w,
    )

  infix def geometric(v: Pga3dBivector): Pga3dMultivector =
    Pga3dMultivector(
      s = 0.0,
      w = 0.0,
      x = -v.yz,
      y = v.xz,
      z = -v.xy,
      wx = 0.0,
      wy = 0.0,
      wz = 0.0,
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
      wxy = -v.wz,
      wxz = v.wy,
      wyz = -v.wx,
      xyz = 0.0,
      i = 0.0,
    )

  infix def geometric(v: Pga3dPoint): Pga3dMotor =
    Pga3dMotor(
      s = -v.xyz,
      wx = v.wyz,
      wy = -v.wxz,
      wz = v.wxy,
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
      i = 0.0,
    )

  infix def geometric(v: Pga3dQuaternion): Pga3dMultivector =
    Pga3dMultivector(
      s = 0.0,
      w = 0.0,
      x = -v.yz,
      y = v.xz,
      z = -v.xy,
      wx = 0.0,
      wy = 0.0,
      wz = 0.0,
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
      wxy = 0.0,
      wxz = 0.0,
      wyz = 0.0,
      xyz = v.s,
      i = 0.0,
    )

  infix def geometric(v: Pga3dTranslator): Pga3dPointNormalized =
    Pga3dPointNormalized(
      wxy = -v.wz,
      wxz = v.wy,
      wyz = -v.wx,
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
      wx = v.wyz,
      wy = -v.wxz,
      wz = v.wxy,
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
      i = 0.0,
    )

  infix def geometric(v: Pga3dPlaneIdeal): Pga3dBivectorBulk =
    Pga3dBivectorBulk(
      xy = v.z,
      xz = -v.y,
      yz = v.x,
    )

  infix def geometric(v: Pga3dBivectorBulk): Pga3dPlaneIdeal =
    Pga3dPlaneIdeal(
      x = -v.yz,
      y = v.xz,
      z = -v.xy,
    )

  infix def geometric(v: Pga3dBivectorWeight): Pga3dVector =
    Pga3dVector(
      wxy = -v.wz,
      wxz = v.wy,
      wyz = -v.wx,
    )

  infix def geometric(v: Pga3dPseudoScalar): Pga3dPlane =
    Pga3dPlane(
      w = v.i,
      x = 0.0,
      y = 0.0,
      z = 0.0,
    )

  infix def geometric(v: Pga3dPointCenter.type): Double =
    -1.0

  infix def dot(v: Pga3dMotor): Pga3dMultivector =
    Pga3dMultivector(
      s = 0.0,
      w = v.i,
      x = -v.yz,
      y = v.xz,
      z = -v.xy,
      wx = 0.0,
      wy = 0.0,
      wz = 0.0,
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
      wxy = 0.0,
      wxz = 0.0,
      wyz = 0.0,
      xyz = v.s,
      i = 0.0,
    )

  infix def dot(v: Pga3dPlane): Pga3dBivectorBulk =
    Pga3dBivectorBulk(
      xy = v.z,
      xz = -v.y,
      yz = v.x,
    )

  infix def dot(v: Pga3dBivector): Pga3dPlaneIdeal =
    Pga3dPlaneIdeal(
      x = -v.yz,
      y = v.xz,
      z = -v.xy,
    )

  infix def dot(v: Pga3dPoint): Double =
    -v.xyz

  infix def dot(v: Pga3dQuaternion): Pga3dMultivector =
    Pga3dMultivector(
      s = 0.0,
      w = 0.0,
      x = -v.yz,
      y = v.xz,
      z = -v.xy,
      wx = 0.0,
      wy = 0.0,
      wz = 0.0,
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
      wxy = 0.0,
      wxz = 0.0,
      wyz = 0.0,
      xyz = v.s,
      i = 0.0,
    )

  infix def dot(v: Pga3dTranslator): Pga3dPointCenter.type =
    this

  infix def dot(v: Pga3dPointNormalized): Double =
    -1.0

  infix def dot(v: Pga3dPlaneIdeal): Pga3dBivectorBulk =
    Pga3dBivectorBulk(
      xy = v.z,
      xz = -v.y,
      yz = v.x,
    )

  infix def dot(v: Pga3dBivectorBulk): Pga3dPlaneIdeal =
    Pga3dPlaneIdeal(
      x = -v.yz,
      y = v.xz,
      z = -v.xy,
    )

  infix def dot(v: Pga3dPseudoScalar): Pga3dPlane =
    Pga3dPlane(
      w = v.i,
      x = 0.0,
      y = 0.0,
      z = 0.0,
    )

  infix def dot(v: Pga3dPointCenter.type): Double =
    -1.0

  infix def wedge(v: Pga3dMotor): Pga3dPoint =
    Pga3dPoint(
      wxy = 0.0,
      wxz = 0.0,
      wyz = 0.0,
      xyz = v.s,
    )

  inline infix def ^(v: Pga3dMotor): Pga3dPoint = wedge(v)

  infix def wedge(v: Pga3dPlane): Pga3dPseudoScalar =
    Pga3dPseudoScalar(
      i = -v.w,
    )

  inline infix def ^(v: Pga3dPlane): Pga3dPseudoScalar = wedge(v)

  infix def wedge(v: Pga3dQuaternion): Pga3dPoint =
    Pga3dPoint(
      wxy = 0.0,
      wxz = 0.0,
      wyz = 0.0,
      xyz = v.s,
    )

  inline infix def ^(v: Pga3dQuaternion): Pga3dPoint = wedge(v)

  infix def wedge(v: Pga3dTranslator): Pga3dPointCenter.type =
    this

  inline infix def ^(v: Pga3dTranslator): Pga3dPointCenter.type = wedge(v)

  infix def antiGeometric(v: Pga3dMotor): Pga3dMultivector =
    Pga3dMultivector(
      s = 0.0,
      w = 0.0,
      x = -v.wx,
      y = -v.wy,
      z = -v.wz,
      wx = 0.0,
      wy = 0.0,
      wz = 0.0,
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
      wxy = 0.0,
      wxz = 0.0,
      wyz = 0.0,
      xyz = v.i,
      i = 0.0,
    )

  infix def antiGeometric(v: Pga3dPlane): Double =
    v.w

  infix def antiGeometric(v: Pga3dBivector): Pga3dPlaneIdeal =
    Pga3dPlaneIdeal(
      x = -v.wx,
      y = -v.wy,
      z = -v.wz,
    )

  infix def antiGeometric(v: Pga3dPoint): Pga3dBivectorBulk =
    Pga3dBivectorBulk(
      xy = -v.wxy,
      xz = -v.wxz,
      yz = -v.wyz,
    )

  infix def antiGeometric(v: Pga3dTranslator): Pga3dPlaneIdeal =
    Pga3dPlaneIdeal(
      x = -v.wx,
      y = -v.wy,
      z = -v.wz,
    )

  infix def antiGeometric(v: Pga3dVector): Pga3dBivectorBulk =
    Pga3dBivectorBulk(
      xy = -v.wxy,
      xz = -v.wxz,
      yz = -v.wyz,
    )

  infix def antiGeometric(v: Pga3dPointNormalized): Pga3dBivectorBulk =
    Pga3dBivectorBulk(
      xy = -v.wxy,
      xz = -v.wxz,
      yz = -v.wyz,
    )

  infix def antiGeometric(v: Pga3dBivectorWeight): Pga3dPlaneIdeal =
    Pga3dPlaneIdeal(
      x = -v.wx,
      y = -v.wy,
      z = -v.wz,
    )

  infix def antiGeometric(v: Pga3dPseudoScalar): Pga3dPoint =
    Pga3dPoint(
      wxy = 0.0,
      wxz = 0.0,
      wyz = 0.0,
      xyz = v.i,
    )

  infix def antiDot(v: Pga3dMotor): Pga3dPoint =
    Pga3dPoint(
      wxy = 0.0,
      wxz = 0.0,
      wyz = 0.0,
      xyz = v.i,
    )

  infix def antiDot(v: Pga3dPseudoScalar): Pga3dPoint =
    Pga3dPoint(
      wxy = 0.0,
      wxz = 0.0,
      wyz = 0.0,
      xyz = v.i,
    )

  infix def antiWedge(v: Pga3dMotor): Pga3dMultivector =
    Pga3dMultivector(
      s = 0.0,
      w = 0.0,
      x = -v.wx,
      y = -v.wy,
      z = -v.wz,
      wx = 0.0,
      wy = 0.0,
      wz = 0.0,
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
      wxy = 0.0,
      wxz = 0.0,
      wyz = 0.0,
      xyz = v.i,
      i = 0.0,
    )

  inline infix def v(v: Pga3dMotor): Pga3dMultivector = antiWedge(v)

  infix def antiWedge(v: Pga3dPlane): Double =
    v.w

  inline infix def v(v: Pga3dPlane): Double = antiWedge(v)

  infix def antiWedge(v: Pga3dBivector): Pga3dPlaneIdeal =
    Pga3dPlaneIdeal(
      x = -v.wx,
      y = -v.wy,
      z = -v.wz,
    )

  inline infix def v(v: Pga3dBivector): Pga3dPlaneIdeal = antiWedge(v)

  infix def antiWedge(v: Pga3dPoint): Pga3dBivectorBulk =
    Pga3dBivectorBulk(
      xy = -v.wxy,
      xz = -v.wxz,
      yz = -v.wyz,
    )

  inline infix def v(v: Pga3dPoint): Pga3dBivectorBulk = antiWedge(v)

  infix def antiWedge(v: Pga3dTranslator): Pga3dPlaneIdeal =
    Pga3dPlaneIdeal(
      x = -v.wx,
      y = -v.wy,
      z = -v.wz,
    )

  inline infix def v(v: Pga3dTranslator): Pga3dPlaneIdeal = antiWedge(v)

  infix def antiWedge(v: Pga3dVector): Pga3dBivectorBulk =
    Pga3dBivectorBulk(
      xy = -v.wxy,
      xz = -v.wxz,
      yz = -v.wyz,
    )

  inline infix def v(v: Pga3dVector): Pga3dBivectorBulk = antiWedge(v)

  infix def antiWedge(v: Pga3dPointNormalized): Pga3dBivectorBulk =
    Pga3dBivectorBulk(
      xy = -v.wxy,
      xz = -v.wxz,
      yz = -v.wyz,
    )

  inline infix def v(v: Pga3dPointNormalized): Pga3dBivectorBulk = antiWedge(v)

  infix def antiWedge(v: Pga3dBivectorWeight): Pga3dPlaneIdeal =
    Pga3dPlaneIdeal(
      x = -v.wx,
      y = -v.wy,
      z = -v.wz,
    )

  inline infix def v(v: Pga3dBivectorWeight): Pga3dPlaneIdeal = antiWedge(v)

  infix def antiWedge(v: Pga3dPseudoScalar): Pga3dPoint =
    Pga3dPoint(
      wxy = 0.0,
      wxz = 0.0,
      wyz = 0.0,
      xyz = v.i,
    )

  inline infix def v(v: Pga3dPseudoScalar): Pga3dPoint = antiWedge(v)

  infix def sandwich(v: Pga3dMotor): Pga3dMotor =
    Pga3dMotor(
      s = v.s,
      wx = -v.wx,
      wy = -v.wy,
      wz = -v.wz,
      xy = v.xy,
      xz = v.xz,
      yz = v.yz,
      i = -v.i,
    )

  infix def sandwich(v: Pga3dPlane): Pga3dPlane =
    Pga3dPlane(
      w = -v.w,
      x = v.x,
      y = v.y,
      z = v.z,
    )

  infix def sandwich(v: Pga3dBivector): Pga3dBivector =
    Pga3dBivector(
      wx = -v.wx,
      wy = -v.wy,
      wz = -v.wz,
      xy = v.xy,
      xz = v.xz,
      yz = v.yz,
    )

  infix def sandwich(v: Pga3dPoint): Pga3dPoint =
    Pga3dPoint(
      wxy = -v.wxy,
      wxz = -v.wxz,
      wyz = -v.wyz,
      xyz = v.xyz,
    )

  infix def sandwich(v: Pga3dQuaternion): Pga3dQuaternion =
    Pga3dQuaternion(
      s = v.s,
      xy = v.xy,
      xz = v.xz,
      yz = v.yz,
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
      wxy = -v.wxy,
      wxz = -v.wxz,
      wyz = -v.wyz,
    )

  infix def sandwich(v: Pga3dPlaneIdeal): Pga3dPlaneIdeal =
    Pga3dPlaneIdeal(
      x = v.x,
      y = v.y,
      z = v.z,
    )

  infix def sandwich(v: Pga3dBivectorBulk): Pga3dBivectorBulk =
    Pga3dBivectorBulk(
      xy = v.xy,
      xz = v.xz,
      yz = v.yz,
    )

  infix def sandwich(v: Pga3dBivectorWeight): Pga3dBivectorWeight =
    -v

  infix def sandwich(v: Pga3dPseudoScalar): Pga3dPseudoScalar =
    -v

  infix def sandwich(v: Pga3dPointCenter.type): Pga3dPointCenter.type =
    this

  infix def reverseSandwich(v: Pga3dMotor): Pga3dMotor =
    Pga3dMotor(
      s = v.s,
      wx = -v.wx,
      wy = -v.wy,
      wz = -v.wz,
      xy = v.xy,
      xz = v.xz,
      yz = v.yz,
      i = -v.i,
    )

  infix def reverseSandwich(v: Pga3dPlane): Pga3dPlane =
    Pga3dPlane(
      w = -v.w,
      x = v.x,
      y = v.y,
      z = v.z,
    )

  infix def reverseSandwich(v: Pga3dBivector): Pga3dBivector =
    Pga3dBivector(
      wx = -v.wx,
      wy = -v.wy,
      wz = -v.wz,
      xy = v.xy,
      xz = v.xz,
      yz = v.yz,
    )

  infix def reverseSandwich(v: Pga3dPoint): Pga3dPoint =
    Pga3dPoint(
      wxy = -v.wxy,
      wxz = -v.wxz,
      wyz = -v.wyz,
      xyz = v.xyz,
    )

  infix def reverseSandwich(v: Pga3dQuaternion): Pga3dQuaternion =
    Pga3dQuaternion(
      s = v.s,
      xy = v.xy,
      xz = v.xz,
      yz = v.yz,
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
      wxy = -v.wxy,
      wxz = -v.wxz,
      wyz = -v.wyz,
    )

  infix def reverseSandwich(v: Pga3dPlaneIdeal): Pga3dPlaneIdeal =
    Pga3dPlaneIdeal(
      x = v.x,
      y = v.y,
      z = v.z,
    )

  infix def reverseSandwich(v: Pga3dBivectorBulk): Pga3dBivectorBulk =
    Pga3dBivectorBulk(
      xy = v.xy,
      xz = v.xz,
      yz = v.yz,
    )

  infix def reverseSandwich(v: Pga3dBivectorWeight): Pga3dBivectorWeight =
    -v

  infix def reverseSandwich(v: Pga3dPseudoScalar): Pga3dPseudoScalar =
    -v

  infix def reverseSandwich(v: Pga3dPointCenter.type): Pga3dPointCenter.type =
    this

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
      wxy = -v.wz,
      wxz = v.wy,
      wyz = -v.wx,
      xyz = 0.0,
      i = 0.0,
    )

  infix def cross(v: Pga3dPlane): Pga3dPseudoScalar =
    Pga3dPseudoScalar(
      i = -v.w,
    )

  infix def cross(v: Pga3dBivector): Pga3dVector =
    Pga3dVector(
      wxy = -v.wz,
      wxz = v.wy,
      wyz = -v.wx,
    )

  infix def cross(v: Pga3dPoint): Pga3dBivectorWeight =
    Pga3dBivectorWeight(
      wx = v.wyz,
      wy = -v.wxz,
      wz = v.wxy,
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
      wx = v.wyz,
      wy = -v.wxz,
      wz = v.wxy,
    )

  infix def cross(v: Pga3dBivectorWeight): Pga3dVector =
    Pga3dVector(
      wxy = -v.wz,
      wxz = v.wy,
      wyz = -v.wx,
    )

  infix def cross(v: Pga3dPseudoScalar): Pga3dPlane =
    Pga3dPlane(
      w = v.i,
      x = 0.0,
      y = 0.0,
      z = 0.0,
    )