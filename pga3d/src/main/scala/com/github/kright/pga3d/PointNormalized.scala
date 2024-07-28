package com.github.kright.pga3d

/** this code is generated, see com.github.kright.pga3d.codegen.CodeGenClass */
case class PointNormalized(wxy: Double = 0.0,
                           wxz: Double = 0.0,
                           wyz: Double = 0.0):
  inline val xyz = 1.0

  inline def dualX: Double = -wyz

  inline def dualW: Double = 1.0

  inline def dualY: Double = wxz

  inline def dualZ: Double = -wxy

  def dual: Plane =
    Plane(
      w = 1.0,
      x = -wyz,
      y = wxz,
      z = -wxy,
    )

  def weight: Vector =
    Vector(
      wxy = wxy,
      wxz = wxz,
      wyz = wyz,
    )

  def bulk: PointCenter.type =
    PointCenter

  def unary_- : Point =
    Point(
      wxy = -wxy,
      wxz = -wxz,
      wyz = -wyz,
      xyz = -1.0,
    )

  def reverse: Point =
    Point(
      wxy = -wxy,
      wxz = -wxz,
      wyz = -wyz,
      xyz = -1.0,
    )

  def antiReverse: PointNormalized =
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

  def *(v: Double): Point =
    Point(
      wxy = v * wxy,
      wxz = v * wxz,
      wyz = v * wyz,
      xyz = v,
    )

  inline def /(v: Double): Point =
    this * (1.0 / v)

  def +(v: Point): Point =
    Point(
      wxy = (v.wxy + wxy),
      wxz = (v.wxz + wxz),
      wyz = (v.wyz + wyz),
      xyz = (1.0 + v.xyz),
    )

  def -(v: Point): Point =
    Point(
      wxy = (wxy - v.wxy),
      wxz = (wxz - v.wxz),
      wyz = (wyz - v.wyz),
      xyz = (1.0 - v.xyz),
    )

  def madd(v: Point, mult: Double): Point =
    Point(
      wxy = (wxy + mult * v.wxy),
      wxz = (wxz + mult * v.wxz),
      wyz = (wyz + mult * v.wyz),
      xyz = (1.0 + mult * v.xyz),
    )

  def +(v: PointNormalized): Point =
    Point(
      wxy = (v.wxy + wxy),
      wxz = (v.wxz + wxz),
      wyz = (v.wyz + wyz),
      xyz = 2.0,
    )

  def -(v: PointNormalized): Vector =
    Vector(
      wxy = (wxy - v.wxy),
      wxz = (wxz - v.wxz),
      wyz = (wyz - v.wyz),
    )

  def madd(v: PointNormalized, mult: Double): Point =
    Point(
      wxy = (wxy + mult * v.wxy),
      wxz = (wxz + mult * v.wxz),
      wyz = (wyz + mult * v.wyz),
      xyz = (1.0 + mult),
    )

  def +(v: Vector): PointNormalized =
    PointNormalized(
      wxy = (v.wxy + wxy),
      wxz = (v.wxz + wxz),
      wyz = (v.wyz + wyz),
    )

  def -(v: Vector): PointNormalized =
    PointNormalized(
      wxy = (wxy - v.wxy),
      wxz = (wxz - v.wxz),
      wyz = (wyz - v.wyz),
    )

  def madd(v: Vector, mult: Double): PointNormalized =
    PointNormalized(
      wxy = (wxy + mult * v.wxy),
      wxz = (wxz + mult * v.wxz),
      wyz = (wyz + mult * v.wyz),
    )

  def multiplyElementwise(v: PointNormalized): PointNormalized =
    PointNormalized(
      wxy = v.wxy * wxy,
      wxz = v.wxz * wxz,
      wyz = v.wyz * wyz,
    )

  def toMultivector: Multivector =
    Multivector(
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

  def toPoint: Point =
    Point(
      wxy = wxy,
      wxz = wxz,
      wyz = wyz,
      xyz = 1.0,
    )

  def asVectorUnsafe: Vector =
    Vector(
      wxy = wxy,
      wxz = wxz,
      wyz = wyz,
    )

  /** fused plane.dot(point).geometric(plane) */
  def projectOntoPlane(plane: Plane): Point =
    Point(
      wxy = (plane.z * (plane.w + plane.y * wxz - plane.x * wyz) + wxy * (plane.x * plane.x + plane.y * plane.y)),
      wxz = (plane.y * (-plane.w + plane.x * wyz + plane.z * wxy) + wxz * (plane.x * plane.x + plane.z * plane.z)),
      wyz = (plane.x * (plane.w + plane.y * wxz - plane.z * wxy) + wyz * (plane.y * plane.y + plane.z * plane.z)),
      xyz = (plane.x * plane.x + plane.y * plane.y + plane.z * plane.z),
    )

  /**
   * fused -line.dot(point).geometric(line).toPointUnsafe
   * not applicable for Bivector, input should be a line
   * example of result for Bivector:
   * Multivector(
   * s = 0.0,
   * w = (line.wx * line.yz + line.wz * line.xy - line.wy * line.xz),
   * x = 0.0,
   * y = 0.0,
   * z = 0.0,
   * wx = 0.0,
   * wy = 0.0,
   * wz = 0.0,
   * xy = 0.0,
   * xz = 0.0,
   * yz = 0.0,
   * wxy = (line.wx * line.xz + line.wy * line.yz + line.xy * (-line.xy * wxy - line.xz * wxz - line.yz * wyz)),
   * wxz = (line.wz * line.yz + line.xz * (-line.xy * wxy - line.xz * wxz - line.yz * wyz) - line.wx * line.xy),
   * wyz = (line.yz * (-line.xy * wxy - line.xz * wxz - line.yz * wyz) - line.wy * line.xy - line.wz * line.xz),
   * xyz = (-line.xy * line.xy - line.xz * line.xz - line.yz * line.yz),
   * i = 0.0,
   * )
   */
  def projectOntoLine(line: Bivector): Point =
    Point(
      wxy = (line.xy * (line.xy * wxy + line.xz * wxz + line.yz * wyz) - line.wx * line.xz - line.wy * line.yz),
      wxz = (line.wx * line.xy + line.xz * (line.xy * wxy + line.xz * wxz + line.yz * wyz) - line.wz * line.yz),
      wyz = (line.wy * line.xy + line.wz * line.xz + line.yz * (line.xy * wxy + line.xz * wxz + line.yz * wyz)),
      xyz = (line.xy * line.xy + line.xz * line.xz + line.yz * line.yz),
    )

  infix def geometric(v: Multivector): Multivector =
    Multivector(
      s = -v.xyz,
      w = (v.i - v.xy * wxy - v.xz * wxz - v.yz * wyz),
      x = -v.yz,
      y = v.xz,
      z = -v.xy,
      wx = (v.wyz + v.y * wxy + v.z * wxz - v.xyz * wyz),
      wy = (-v.wxz + v.xyz * wxz + v.z * wyz - v.x * wxy),
      wz = (v.wxy - v.x * wxz - v.xyz * wxy - v.y * wyz),
      xy = v.z,
      xz = -v.y,
      yz = v.x,
      wxy = (-v.wz + v.s * wxy + v.xz * wyz - v.yz * wxz),
      wxz = (v.wy + v.s * wxz + v.yz * wxy - v.xy * wyz),
      wyz = (-v.wx + v.s * wyz + v.xy * wxz - v.xz * wxy),
      xyz = v.s,
      i = (-v.w + v.x * wyz + v.z * wxy - v.y * wxz),
    )

  infix def geometric(v: Motor): Multivector =
    Multivector(
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

  infix def geometric(v: Plane): Motor =
    Motor(
      s = 0.0,
      wx = (v.y * wxy + v.z * wxz),
      wy = (v.z * wyz - v.x * wxy),
      wz = (-v.x * wxz - v.y * wyz),
      xy = v.z,
      xz = -v.y,
      yz = v.x,
      i = (-v.w + v.x * wyz + v.z * wxy - v.y * wxz),
    )

  infix def geometric(v: Bivector): Multivector =
    Multivector(
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

  infix def geometric(v: Point): Motor =
    Motor(
      s = -v.xyz,
      wx = (v.wyz - v.xyz * wyz),
      wy = (-v.wxz + v.xyz * wxz),
      wz = (v.wxy - v.xyz * wxy),
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
      i = 0.0,
    )

  infix def geometric(v: Quaternion): Multivector =
    Multivector(
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

  infix def geometric(v: Translator): PointNormalized =
    PointNormalized(
      wxy = (wxy - v.wz),
      wxz = (v.wy + wxz),
      wyz = (wyz - v.wx),
    )

  infix def geometric(v: Vector): BivectorWeight =
    BivectorWeight(
      wx = v.wyz,
      wy = -v.wxz,
      wz = v.wxy,
    )

  infix def geometric(v: PointNormalized): Motor =
    Motor(
      s = -1.0,
      wx = (v.wyz - wyz),
      wy = (wxz - v.wxz),
      wz = (v.wxy - wxy),
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
      i = 0.0,
    )

  infix def geometric(v: PlaneIdeal): Motor =
    Motor(
      s = 0.0,
      wx = (v.y * wxy + v.z * wxz),
      wy = (v.z * wyz - v.x * wxy),
      wz = (-v.x * wxz - v.y * wyz),
      xy = v.z,
      xz = -v.y,
      yz = v.x,
      i = (v.x * wyz + v.z * wxy - v.y * wxz),
    )

  infix def geometric(v: BivectorBulk): Multivector =
    Multivector(
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

  infix def geometric(v: BivectorWeight): Vector =
    Vector(
      wxy = -v.wz,
      wxz = v.wy,
      wyz = -v.wx,
    )

  infix def geometric(v: PseudoScalar): Plane =
    Plane(
      w = v.i,
      x = 0.0,
      y = 0.0,
      z = 0.0,
    )

  infix def geometric(v: PointCenter.type): Motor =
    Motor(
      s = -1.0,
      wx = -wyz,
      wy = wxz,
      wz = -wxy,
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
      i = 0.0,
    )

  infix def dot(v: Multivector): Multivector =
    Multivector(
      s = -v.xyz,
      w = (v.i - v.xy * wxy - v.xz * wxz - v.yz * wyz),
      x = -v.yz,
      y = v.xz,
      z = -v.xy,
      wx = (v.y * wxy + v.z * wxz),
      wy = (v.z * wyz - v.x * wxy),
      wz = (-v.x * wxz - v.y * wyz),
      xy = v.z,
      xz = -v.y,
      yz = v.x,
      wxy = v.s * wxy,
      wxz = v.s * wxz,
      wyz = v.s * wyz,
      xyz = v.s,
      i = 0.0,
    )

  infix def dot(v: Motor): Multivector =
    Multivector(
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

  infix def dot(v: Plane): Bivector =
    Bivector(
      wx = (v.y * wxy + v.z * wxz),
      wy = (v.z * wyz - v.x * wxy),
      wz = (-v.x * wxz - v.y * wyz),
      xy = v.z,
      xz = -v.y,
      yz = v.x,
    )

  infix def dot(v: Bivector): Plane =
    Plane(
      w = (-v.xy * wxy - v.xz * wxz - v.yz * wyz),
      x = -v.yz,
      y = v.xz,
      z = -v.xy,
    )

  infix def dot(v: Point): Double =
    -v.xyz

  infix def dot(v: Quaternion): Multivector =
    Multivector(
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

  infix def dot(v: Translator): PointNormalized =
    this

  infix def dot(v: PointNormalized): Double =
    -1.0

  infix def dot(v: PlaneIdeal): Bivector =
    Bivector(
      wx = (v.y * wxy + v.z * wxz),
      wy = (v.z * wyz - v.x * wxy),
      wz = (-v.x * wxz - v.y * wyz),
      xy = v.z,
      xz = -v.y,
      yz = v.x,
    )

  infix def dot(v: BivectorBulk): Plane =
    Plane(
      w = (-v.xy * wxy - v.xz * wxz - v.yz * wyz),
      x = -v.yz,
      y = v.xz,
      z = -v.xy,
    )

  infix def dot(v: PseudoScalar): Plane =
    Plane(
      w = v.i,
      x = 0.0,
      y = 0.0,
      z = 0.0,
    )

  infix def dot(v: PointCenter.type): Double =
    -1.0

  infix def wedge(v: Multivector): Multivector =
    Multivector(
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
      xyz = v.s,
      i = (-v.w + v.x * wyz + v.z * wxy - v.y * wxz),
    )

  inline infix def ^(v: Multivector): Multivector = wedge(v)

  infix def wedge(v: Motor): Point =
    Point(
      wxy = v.s * wxy,
      wxz = v.s * wxz,
      wyz = v.s * wyz,
      xyz = v.s,
    )

  inline infix def ^(v: Motor): Point = wedge(v)

  infix def wedge(v: Plane): PseudoScalar =
    PseudoScalar(
      i = (-v.w + v.x * wyz + v.z * wxy - v.y * wxz),
    )

  inline infix def ^(v: Plane): PseudoScalar = wedge(v)

  infix def wedge(v: Quaternion): Point =
    Point(
      wxy = v.s * wxy,
      wxz = v.s * wxz,
      wyz = v.s * wyz,
      xyz = v.s,
    )

  inline infix def ^(v: Quaternion): Point = wedge(v)

  infix def wedge(v: Translator): PointNormalized =
    this

  inline infix def ^(v: Translator): PointNormalized = wedge(v)

  infix def wedge(v: PlaneIdeal): PseudoScalar =
    PseudoScalar(
      i = (v.x * wyz + v.z * wxy - v.y * wxz),
    )

  inline infix def ^(v: PlaneIdeal): PseudoScalar = wedge(v)

  infix def antiGeometric(v: Multivector): Multivector =
    Multivector(
      s = (v.w + v.y * wxz - v.x * wyz - v.z * wxy),
      w = (v.wy * wxz - v.wx * wyz - v.wz * wxy),
      x = (-v.wx + v.xy * wxz - v.s * wyz - v.xz * wxy),
      y = (-v.wy + v.s * wxz + v.xy * wyz - v.yz * wxy),
      z = (-v.wz + v.xz * wyz - v.s * wxy - v.yz * wxz),
      wx = (v.wxz * wxy - v.w * wyz - v.wxy * wxz),
      wy = (v.w * wxz + v.wyz * wxy - v.wxy * wyz),
      wz = (v.wyz * wxz - v.w * wxy - v.wxz * wyz),
      xy = (-v.wxy + v.x * wxz + v.xyz * wxy + v.y * wyz),
      xz = (-v.wxz + v.xyz * wxz + v.z * wyz - v.x * wxy),
      yz = (-v.wyz + v.xyz * wyz - v.y * wxy - v.z * wxz),
      wxy = (v.i * wxy - v.wx * wxz - v.wy * wyz),
      wxz = (v.i * wxz + v.wx * wxy - v.wz * wyz),
      wyz = (v.i * wyz + v.wy * wxy + v.wz * wxz),
      xyz = (v.i + v.xy * wxy + v.xz * wxz + v.yz * wyz),
      i = (v.wxy * wxy + v.wxz * wxz + v.wyz * wyz),
    )

  infix def antiGeometric(v: Motor): Multivector =
    Multivector(
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

  infix def antiGeometric(v: Plane): Motor =
    Motor(
      s = (v.w + v.y * wxz - v.x * wyz - v.z * wxy),
      wx = -v.w * wyz,
      wy = v.w * wxz,
      wz = -v.w * wxy,
      xy = (v.x * wxz + v.y * wyz),
      xz = (v.z * wyz - v.x * wxy),
      yz = (-v.y * wxy - v.z * wxz),
      i = 0.0,
    )

  infix def antiGeometric(v: Bivector): Multivector =
    Multivector(
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

  infix def antiGeometric(v: Point): Motor =
    Motor(
      s = 0.0,
      wx = (v.wxz * wxy - v.wxy * wxz),
      wy = (v.wyz * wxy - v.wxy * wyz),
      wz = (v.wyz * wxz - v.wxz * wyz),
      xy = (-v.wxy + v.xyz * wxy),
      xz = (-v.wxz + v.xyz * wxz),
      yz = (-v.wyz + v.xyz * wyz),
      i = (v.wxy * wxy + v.wxz * wxz + v.wyz * wyz),
    )

  infix def antiGeometric(v: Quaternion): Multivector =
    Multivector(
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

  infix def antiGeometric(v: Translator): Multivector =
    Multivector(
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

  infix def antiGeometric(v: Vector): Motor =
    Motor(
      s = 0.0,
      wx = (v.wxz * wxy - v.wxy * wxz),
      wy = (v.wyz * wxy - v.wxy * wyz),
      wz = (v.wyz * wxz - v.wxz * wyz),
      xy = -v.wxy,
      xz = -v.wxz,
      yz = -v.wyz,
      i = (v.wxy * wxy + v.wxz * wxz + v.wyz * wyz),
    )

  infix def antiGeometric(v: PointNormalized): Motor =
    Motor(
      s = 0.0,
      wx = (v.wxz * wxy - v.wxy * wxz),
      wy = (v.wyz * wxy - v.wxy * wyz),
      wz = (v.wyz * wxz - v.wxz * wyz),
      xy = (wxy - v.wxy),
      xz = (wxz - v.wxz),
      yz = (wyz - v.wyz),
      i = (v.wxy * wxy + v.wxz * wxz + v.wyz * wyz),
    )

  infix def antiGeometric(v: PlaneIdeal): Quaternion =
    Quaternion(
      s = (v.y * wxz - v.x * wyz - v.z * wxy),
      xy = (v.x * wxz + v.y * wyz),
      xz = (v.z * wyz - v.x * wxy),
      yz = (-v.y * wxy - v.z * wxz),
    )

  infix def antiGeometric(v: BivectorBulk): Multivector =
    Multivector(
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

  infix def antiGeometric(v: BivectorWeight): Multivector =
    Multivector(
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

  infix def antiGeometric(v: PseudoScalar): Point =
    Point(
      wxy = v.i * wxy,
      wxz = v.i * wxz,
      wyz = v.i * wyz,
      xyz = v.i,
    )

  infix def antiGeometric(v: PointCenter.type): BivectorBulk =
    BivectorBulk(
      xy = wxy,
      xz = wxz,
      yz = wyz,
    )

  infix def antiDot(v: Multivector): Multivector =
    Multivector(
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
      xyz = (v.i + v.xy * wxy + v.xz * wxz + v.yz * wyz),
      i = (v.wxy * wxy + v.wxz * wxz + v.wyz * wyz),
    )

  infix def antiDot(v: Motor): Multivector =
    Multivector(
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

  infix def antiDot(v: Plane): Bivector =
    Bivector(
      wx = -v.w * wyz,
      wy = v.w * wxz,
      wz = -v.w * wxy,
      xy = (v.x * wxz + v.y * wyz),
      xz = (v.z * wyz - v.x * wxy),
      yz = (-v.y * wxy - v.z * wxz),
    )

  infix def antiDot(v: Bivector): Point =
    Point(
      wxy = (-v.wx * wxz - v.wy * wyz),
      wxz = (v.wx * wxy - v.wz * wyz),
      wyz = (v.wy * wxy + v.wz * wxz),
      xyz = (v.xy * wxy + v.xz * wxz + v.yz * wyz),
    )

  infix def antiDot(v: Point): PseudoScalar =
    PseudoScalar(
      i = (v.wxy * wxy + v.wxz * wxz + v.wyz * wyz),
    )

  infix def antiDot(v: Quaternion): Multivector =
    Multivector(
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

  infix def antiDot(v: Translator): Multivector =
    Multivector(
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

  infix def antiDot(v: Vector): PseudoScalar =
    PseudoScalar(
      i = (v.wxy * wxy + v.wxz * wxz + v.wyz * wyz),
    )

  infix def antiDot(v: PointNormalized): PseudoScalar =
    PseudoScalar(
      i = (v.wxy * wxy + v.wxz * wxz + v.wyz * wyz),
    )

  infix def antiDot(v: PlaneIdeal): BivectorBulk =
    BivectorBulk(
      xy = (v.x * wxz + v.y * wyz),
      xz = (v.z * wyz - v.x * wxy),
      yz = (-v.y * wxy - v.z * wxz),
    )

  infix def antiDot(v: BivectorBulk): Point =
    Point(
      wxy = 0.0,
      wxz = 0.0,
      wyz = 0.0,
      xyz = (v.xy * wxy + v.xz * wxz + v.yz * wyz),
    )

  infix def antiDot(v: BivectorWeight): Vector =
    Vector(
      wxy = (-v.wx * wxz - v.wy * wyz),
      wxz = (v.wx * wxy - v.wz * wyz),
      wyz = (v.wy * wxy + v.wz * wxz),
    )

  infix def antiDot(v: PseudoScalar): Point =
    Point(
      wxy = v.i * wxy,
      wxz = v.i * wxz,
      wyz = v.i * wyz,
      xyz = v.i,
    )

  infix def antiWedge(v: Multivector): Multivector =
    Multivector(
      s = (v.w + v.y * wxz - v.x * wyz - v.z * wxy),
      w = (v.wy * wxz - v.wx * wyz - v.wz * wxy),
      x = (-v.wx + v.xy * wxz - v.xz * wxy),
      y = (-v.wy + v.xy * wyz - v.yz * wxy),
      z = (-v.wz + v.xz * wyz - v.yz * wxz),
      wx = (v.wxz * wxy - v.wxy * wxz),
      wy = (v.wyz * wxy - v.wxy * wyz),
      wz = (v.wyz * wxz - v.wxz * wyz),
      xy = (-v.wxy + v.xyz * wxy),
      xz = (-v.wxz + v.xyz * wxz),
      yz = (-v.wyz + v.xyz * wyz),
      wxy = v.i * wxy,
      wxz = v.i * wxz,
      wyz = v.i * wyz,
      xyz = v.i,
      i = 0.0,
    )

  inline infix def v(v: Multivector): Multivector = antiWedge(v)

  infix def antiWedge(v: Motor): Multivector =
    Multivector(
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

  inline infix def v(v: Motor): Multivector = antiWedge(v)

  infix def antiWedge(v: Plane): Double =
    (v.w + v.y * wxz - v.x * wyz - v.z * wxy)

  inline infix def v(v: Plane): Double = antiWedge(v)

  infix def antiWedge(v: Bivector): Plane =
    Plane(
      w = (v.wy * wxz - v.wx * wyz - v.wz * wxy),
      x = (-v.wx + v.xy * wxz - v.xz * wxy),
      y = (-v.wy + v.xy * wyz - v.yz * wxy),
      z = (-v.wz + v.xz * wyz - v.yz * wxz),
    )

  inline infix def v(v: Bivector): Plane = antiWedge(v)

  infix def antiWedge(v: Point): Bivector =
    Bivector(
      wx = (v.wxz * wxy - v.wxy * wxz),
      wy = (v.wyz * wxy - v.wxy * wyz),
      wz = (v.wyz * wxz - v.wxz * wyz),
      xy = (-v.wxy + v.xyz * wxy),
      xz = (-v.wxz + v.xyz * wxz),
      yz = (-v.wyz + v.xyz * wyz),
    )

  inline infix def v(v: Point): Bivector = antiWedge(v)

  infix def antiWedge(v: Quaternion): PlaneIdeal =
    PlaneIdeal(
      x = (v.xy * wxz - v.xz * wxy),
      y = (v.xy * wyz - v.yz * wxy),
      z = (v.xz * wyz - v.yz * wxz),
    )

  inline infix def v(v: Quaternion): PlaneIdeal = antiWedge(v)

  infix def antiWedge(v: Translator): Plane =
    Plane(
      w = (v.wy * wxz - v.wx * wyz - v.wz * wxy),
      x = -v.wx,
      y = -v.wy,
      z = -v.wz,
    )

  inline infix def v(v: Translator): Plane = antiWedge(v)

  infix def antiWedge(v: Vector): Bivector =
    Bivector(
      wx = (v.wxz * wxy - v.wxy * wxz),
      wy = (v.wyz * wxy - v.wxy * wyz),
      wz = (v.wyz * wxz - v.wxz * wyz),
      xy = -v.wxy,
      xz = -v.wxz,
      yz = -v.wyz,
    )

  inline infix def v(v: Vector): Bivector = antiWedge(v)

  infix def antiWedge(v: PointNormalized): Bivector =
    Bivector(
      wx = (v.wxz * wxy - v.wxy * wxz),
      wy = (v.wyz * wxy - v.wxy * wyz),
      wz = (v.wyz * wxz - v.wxz * wyz),
      xy = (wxy - v.wxy),
      xz = (wxz - v.wxz),
      yz = (wyz - v.wyz),
    )

  inline infix def v(v: PointNormalized): Bivector = antiWedge(v)

  infix def antiWedge(v: PlaneIdeal): Double =
    (v.y * wxz - v.x * wyz - v.z * wxy)

  inline infix def v(v: PlaneIdeal): Double = antiWedge(v)

  infix def antiWedge(v: BivectorBulk): PlaneIdeal =
    PlaneIdeal(
      x = (v.xy * wxz - v.xz * wxy),
      y = (v.xy * wyz - v.yz * wxy),
      z = (v.xz * wyz - v.yz * wxz),
    )

  inline infix def v(v: BivectorBulk): PlaneIdeal = antiWedge(v)

  infix def antiWedge(v: BivectorWeight): Plane =
    Plane(
      w = (v.wy * wxz - v.wx * wyz - v.wz * wxy),
      x = -v.wx,
      y = -v.wy,
      z = -v.wz,
    )

  inline infix def v(v: BivectorWeight): Plane = antiWedge(v)

  infix def antiWedge(v: PseudoScalar): Point =
    Point(
      wxy = v.i * wxy,
      wxz = v.i * wxz,
      wyz = v.i * wyz,
      xyz = v.i,
    )

  inline infix def v(v: PseudoScalar): Point = antiWedge(v)

  infix def antiWedge(v: PointCenter.type): BivectorBulk =
    BivectorBulk(
      xy = wxy,
      xz = wxz,
      yz = wyz,
    )

  inline infix def v(v: PointCenter.type): BivectorBulk = antiWedge(v)

  infix def sandwich(v: Multivector): Multivector =
    Multivector(
      s = v.s,
      w = (-v.w + 2.0 * (v.x * wyz + v.z * wxy - v.y * wxz)),
      x = v.x,
      y = v.y,
      z = v.z,
      wx = (-v.wx + 2.0 * (v.xy * wxz - v.xz * wxy)),
      wy = (-v.wy + 2.0 * (v.xy * wyz - v.yz * wxy)),
      wz = (-v.wz + 2.0 * (v.xz * wyz - v.yz * wxz)),
      xy = v.xy,
      xz = v.xz,
      yz = v.yz,
      wxy = (-v.wxy + 2.0 * v.xyz * wxy),
      wxz = (-v.wxz + 2.0 * v.xyz * wxz),
      wyz = (-v.wyz + 2.0 * v.xyz * wyz),
      xyz = v.xyz,
      i = -v.i,
    )

  infix def sandwich(v: Motor): Motor =
    Motor(
      s = v.s,
      wx = (-v.wx + 2.0 * (v.xy * wxz - v.xz * wxy)),
      wy = (-v.wy + 2.0 * (v.xy * wyz - v.yz * wxy)),
      wz = (-v.wz + 2.0 * (v.xz * wyz - v.yz * wxz)),
      xy = v.xy,
      xz = v.xz,
      yz = v.yz,
      i = -v.i,
    )

  infix def sandwich(v: Plane): Plane =
    Plane(
      w = (-v.w + 2.0 * (v.x * wyz + v.z * wxy - v.y * wxz)),
      x = v.x,
      y = v.y,
      z = v.z,
    )

  infix def sandwich(v: Bivector): Bivector =
    Bivector(
      wx = (-v.wx + 2.0 * (v.xy * wxz - v.xz * wxy)),
      wy = (-v.wy + 2.0 * (v.xy * wyz - v.yz * wxy)),
      wz = (-v.wz + 2.0 * (v.xz * wyz - v.yz * wxz)),
      xy = v.xy,
      xz = v.xz,
      yz = v.yz,
    )

  infix def sandwich(v: Point): Point =
    Point(
      wxy = (-v.wxy + 2.0 * v.xyz * wxy),
      wxz = (-v.wxz + 2.0 * v.xyz * wxz),
      wyz = (-v.wyz + 2.0 * v.xyz * wyz),
      xyz = v.xyz,
    )

  infix def sandwich(v: Quaternion): Motor =
    Motor(
      s = v.s,
      wx = 2.0 * (v.xy * wxz - v.xz * wxy),
      wy = 2.0 * (v.xy * wyz - v.yz * wxy),
      wz = 2.0 * (v.xz * wyz - v.yz * wxz),
      xy = v.xy,
      xz = v.xz,
      yz = v.yz,
      i = 0.0,
    )

  infix def sandwich(v: Translator): Translator =
    Translator(
      wx = -v.wx,
      wy = -v.wy,
      wz = -v.wz,
    )

  infix def sandwich(v: Vector): Vector =
    -v

  infix def sandwich(v: PointNormalized): PointNormalized =
    PointNormalized(
      wxy = (-v.wxy + 2.0 * wxy),
      wxz = (-v.wxz + 2.0 * wxz),
      wyz = (-v.wyz + 2.0 * wyz),
    )

  infix def sandwich(v: PlaneIdeal): Plane =
    Plane(
      w = 2.0 * (v.x * wyz + v.z * wxy - v.y * wxz),
      x = v.x,
      y = v.y,
      z = v.z,
    )

  infix def sandwich(v: BivectorBulk): Bivector =
    Bivector(
      wx = 2.0 * (v.xy * wxz - v.xz * wxy),
      wy = 2.0 * (v.xy * wyz - v.yz * wxy),
      wz = 2.0 * (v.xz * wyz - v.yz * wxz),
      xy = v.xy,
      xz = v.xz,
      yz = v.yz,
    )

  infix def sandwich(v: BivectorWeight): BivectorWeight =
    -v

  infix def sandwich(v: PseudoScalar): PseudoScalar =
    -v

  infix def sandwich(v: PointCenter.type): PointNormalized =
    PointNormalized(
      wxy = 2.0 * wxy,
      wxz = 2.0 * wxz,
      wyz = 2.0 * wyz,
    )

  infix def reverseSandwich(v: Multivector): Multivector =
    Multivector(
      s = v.s,
      w = (-v.w + 2.0 * (v.x * wyz + v.z * wxy - v.y * wxz)),
      x = v.x,
      y = v.y,
      z = v.z,
      wx = (-v.wx + 2.0 * (v.xy * wxz - v.xz * wxy)),
      wy = (-v.wy + 2.0 * (v.xy * wyz - v.yz * wxy)),
      wz = (-v.wz + 2.0 * (v.xz * wyz - v.yz * wxz)),
      xy = v.xy,
      xz = v.xz,
      yz = v.yz,
      wxy = (-v.wxy + 2.0 * v.xyz * wxy),
      wxz = (-v.wxz + 2.0 * v.xyz * wxz),
      wyz = (-v.wyz + 2.0 * v.xyz * wyz),
      xyz = v.xyz,
      i = -v.i,
    )

  infix def reverseSandwich(v: Motor): Motor =
    Motor(
      s = v.s,
      wx = (-v.wx + 2.0 * (v.xy * wxz - v.xz * wxy)),
      wy = (-v.wy + 2.0 * (v.xy * wyz - v.yz * wxy)),
      wz = (-v.wz + 2.0 * (v.xz * wyz - v.yz * wxz)),
      xy = v.xy,
      xz = v.xz,
      yz = v.yz,
      i = -v.i,
    )

  infix def reverseSandwich(v: Plane): Plane =
    Plane(
      w = (-v.w + 2.0 * (v.x * wyz + v.z * wxy - v.y * wxz)),
      x = v.x,
      y = v.y,
      z = v.z,
    )

  infix def reverseSandwich(v: Bivector): Bivector =
    Bivector(
      wx = (-v.wx + 2.0 * (v.xy * wxz - v.xz * wxy)),
      wy = (-v.wy + 2.0 * (v.xy * wyz - v.yz * wxy)),
      wz = (-v.wz + 2.0 * (v.xz * wyz - v.yz * wxz)),
      xy = v.xy,
      xz = v.xz,
      yz = v.yz,
    )

  infix def reverseSandwich(v: Point): Point =
    Point(
      wxy = (-v.wxy + 2.0 * v.xyz * wxy),
      wxz = (-v.wxz + 2.0 * v.xyz * wxz),
      wyz = (-v.wyz + 2.0 * v.xyz * wyz),
      xyz = v.xyz,
    )

  infix def reverseSandwich(v: Quaternion): Motor =
    Motor(
      s = v.s,
      wx = 2.0 * (v.xy * wxz - v.xz * wxy),
      wy = 2.0 * (v.xy * wyz - v.yz * wxy),
      wz = 2.0 * (v.xz * wyz - v.yz * wxz),
      xy = v.xy,
      xz = v.xz,
      yz = v.yz,
      i = 0.0,
    )

  infix def reverseSandwich(v: Translator): Translator =
    Translator(
      wx = -v.wx,
      wy = -v.wy,
      wz = -v.wz,
    )

  infix def reverseSandwich(v: Vector): Vector =
    -v

  infix def reverseSandwich(v: PointNormalized): PointNormalized =
    PointNormalized(
      wxy = (-v.wxy + 2.0 * wxy),
      wxz = (-v.wxz + 2.0 * wxz),
      wyz = (-v.wyz + 2.0 * wyz),
    )

  infix def reverseSandwich(v: PlaneIdeal): Plane =
    Plane(
      w = 2.0 * (v.x * wyz + v.z * wxy - v.y * wxz),
      x = v.x,
      y = v.y,
      z = v.z,
    )

  infix def reverseSandwich(v: BivectorBulk): Bivector =
    Bivector(
      wx = 2.0 * (v.xy * wxz - v.xz * wxy),
      wy = 2.0 * (v.xy * wyz - v.yz * wxy),
      wz = 2.0 * (v.xz * wyz - v.yz * wxz),
      xy = v.xy,
      xz = v.xz,
      yz = v.yz,
    )

  infix def reverseSandwich(v: BivectorWeight): BivectorWeight =
    -v

  infix def reverseSandwich(v: PseudoScalar): PseudoScalar =
    -v

  infix def reverseSandwich(v: PointCenter.type): PointNormalized =
    PointNormalized(
      wxy = 2.0 * wxy,
      wxz = 2.0 * wxz,
      wyz = 2.0 * wyz,
    )

  infix def cross(v: Multivector): Multivector =
    Multivector(
      s = 0.0,
      w = v.i,
      x = 0.0,
      y = 0.0,
      z = 0.0,
      wx = (v.wyz - v.xyz * wyz),
      wy = (-v.wxz + v.xyz * wxz),
      wz = (v.wxy - v.xyz * wxy),
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
      wxy = (-v.wz + v.xz * wyz - v.yz * wxz),
      wxz = (v.wy + v.yz * wxy - v.xy * wyz),
      wyz = (-v.wx + v.xy * wxz - v.xz * wxy),
      xyz = 0.0,
      i = (-v.w + v.x * wyz + v.z * wxy - v.y * wxz),
    )

  infix def cross(v: Motor): Multivector =
    Multivector(
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

  infix def cross(v: Plane): PseudoScalar =
    PseudoScalar(
      i = (-v.w + v.x * wyz + v.z * wxy - v.y * wxz),
    )

  infix def cross(v: Bivector): Vector =
    Vector(
      wxy = (-v.wz + v.xz * wyz - v.yz * wxz),
      wxz = (v.wy + v.yz * wxy - v.xy * wyz),
      wyz = (-v.wx + v.xy * wxz - v.xz * wxy),
    )

  infix def cross(v: Point): BivectorWeight =
    BivectorWeight(
      wx = (v.wyz - v.xyz * wyz),
      wy = (-v.wxz + v.xyz * wxz),
      wz = (v.wxy - v.xyz * wxy),
    )

  infix def cross(v: Quaternion): Vector =
    Vector(
      wxy = (v.xz * wyz - v.yz * wxz),
      wxz = (v.yz * wxy - v.xy * wyz),
      wyz = (v.xy * wxz - v.xz * wxy),
    )

  infix def cross(v: Translator): Vector =
    Vector(
      wxy = -v.wz,
      wxz = v.wy,
      wyz = -v.wx,
    )

  infix def cross(v: Vector): BivectorWeight =
    BivectorWeight(
      wx = v.wyz,
      wy = -v.wxz,
      wz = v.wxy,
    )

  infix def cross(v: PointNormalized): BivectorWeight =
    BivectorWeight(
      wx = (v.wyz - wyz),
      wy = (wxz - v.wxz),
      wz = (v.wxy - wxy),
    )

  infix def cross(v: PlaneIdeal): PseudoScalar =
    PseudoScalar(
      i = (v.x * wyz + v.z * wxy - v.y * wxz),
    )

  infix def cross(v: BivectorBulk): Vector =
    Vector(
      wxy = (v.xz * wyz - v.yz * wxz),
      wxz = (v.yz * wxy - v.xy * wyz),
      wyz = (v.xy * wxz - v.xz * wxy),
    )

  infix def cross(v: BivectorWeight): Vector =
    Vector(
      wxy = -v.wz,
      wxz = v.wy,
      wyz = -v.wx,
    )

  infix def cross(v: PseudoScalar): Plane =
    Plane(
      w = v.i,
      x = 0.0,
      y = 0.0,
      z = 0.0,
    )

  infix def cross(v: PointCenter.type): BivectorWeight =
    BivectorWeight(
      wx = -wyz,
      wy = wxz,
      wz = -wxy,
    )


object PointNormalized:
  def fromDual(x: Double, y: Double, z: Double): PointNormalized =
    PointNormalized(
      wxy = -z,
      wxz = y,
      wyz = -x,
    )