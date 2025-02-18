package com.github.kright.pga3d


/** this code is generated, see com.github.kright.pga3d.codegen.CodeGenClass */
final case class Pga3dQuaternion(s: Double = 0.0,
                                 xy: Double = 0.0,
                                 xz: Double = 0.0,
                                 yz: Double = 0.0):

  override def toString: String =
    s"Pga3dQuaternion(s = $s, xy = $xy, xz = $xz, yz = $yz)"

  def dual: Pga3dMotor =
    Pga3dMotor(
      s = 0.0,
      wx = yz,
      wy = -xz,
      wz = xy,
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
      i = s,
    )

  def bulk: Pga3dQuaternion =
    this

  def unary_- : Pga3dQuaternion =
    Pga3dQuaternion(
      s = -s,
      xy = -xy,
      xz = -xz,
      yz = -yz,
    )

  def reverse: Pga3dQuaternion =
    Pga3dQuaternion(
      s = s,
      xy = -xy,
      xz = -xz,
      yz = -yz,
    )

  def antiReverse: Pga3dQuaternion =
    Pga3dQuaternion(
      s = s,
      xy = -xy,
      xz = -xz,
      yz = -yz,
    )

  def bulkNormSquare: Double =
    (s * s + xy * xy + xz * xz + yz * yz)

  def bulkNorm: Double =
    Math.sqrt(bulkNormSquare)

  def normalizedByBulk =
    this / bulkNorm

  def normSquare: Double =
    (s * s + xy * xy + xz * xz + yz * yz)

  def norm: Double =
    Math.sqrt(normSquare)

  def normalizedByNorm =
    this / norm

  def *(v: Double): Pga3dQuaternion =
    Pga3dQuaternion(
      s = s * v,
      xy = v * xy,
      xz = v * xz,
      yz = v * yz,
    )

  inline def /(v: Double): Pga3dQuaternion =
    this * (1.0 / v)

  def +(v: Pga3dQuaternion): Pga3dQuaternion =
    Pga3dQuaternion(
      s = (s + v.s),
      xy = (v.xy + xy),
      xz = (v.xz + xz),
      yz = (v.yz + yz),
    )

  def -(v: Pga3dQuaternion): Pga3dQuaternion =
    Pga3dQuaternion(
      s = (s - v.s),
      xy = (xy - v.xy),
      xz = (xz - v.xz),
      yz = (yz - v.yz),
    )

  def madd(v: Pga3dQuaternion, mult: Double): Pga3dQuaternion =
    Pga3dQuaternion(
      s = (s + mult * v.s),
      xy = (xy + mult * v.xy),
      xz = (xz + mult * v.xz),
      yz = (yz + mult * v.yz),
    )

  def multiplyElementwise(v: Pga3dQuaternion): Pga3dQuaternion =
    Pga3dQuaternion(
      s = s * v.s,
      xy = v.xy * xy,
      xz = v.xz * xz,
      yz = v.yz * yz,
    )

  def log(): Pga3dBivectorBulk =
    val scalar = s
    if (s < 0.0) return (-this).log()

    val lenXYZ = Math.sqrt(xy * xy + xz * xz + yz * yz)
    val angle = Math.atan2(lenXYZ, scalar)

    val a = 1.0 / (1.0 - scalar * scalar) // 1 / sin^2

    val b = if (Math.abs(angle) > 1e-5) { // angle / sin(angle)
      angle * Math.sqrt(a)
    } else {
      1.0 + angle * angle / 6.0
    }

    Pga3dBivectorBulk(
      xy = b * xy,
      xz = b * xz,
      yz = b * yz,
    )

  def toMultivector: Pga3dMultivector =
    Pga3dMultivector(
      s = s,
      w = 0.0,
      x = 0.0,
      y = 0.0,
      z = 0.0,
      wx = 0.0,
      wy = 0.0,
      wz = 0.0,
      xy = xy,
      xz = xz,
      yz = yz,
      wxy = 0.0,
      wxz = 0.0,
      wyz = 0.0,
      xyz = 0.0,
      i = 0.0,
    )

  def toMotor: Pga3dMotor =
    Pga3dMotor(
      s = s,
      wx = 0.0,
      wy = 0.0,
      wz = 0.0,
      xy = xy,
      xz = xz,
      yz = yz,
      i = 0.0,
    )

  def toBivectorUnsafe: Pga3dBivector =
    Pga3dBivector(
      wx = 0.0,
      wy = 0.0,
      wz = 0.0,
      xy = xy,
      xz = xz,
      yz = yz,
    )

  def toBivectorBulkUnsafe: Pga3dBivectorBulk =
    Pga3dBivectorBulk(
      xy = xy,
      xz = xz,
      yz = yz,
    )

  infix def geometric(v: Pga3dMotor): Pga3dMotor =
    Pga3dMotor(
      s = (s * v.s - v.xy * xy - v.xz * xz - v.yz * yz),
      wx = (s * v.wx + v.wy * xy + v.wz * xz - v.i * yz),
      wy = (s * v.wy + v.i * xz + v.wz * yz - v.wx * xy),
      wz = (s * v.wz - v.i * xy - v.wx * xz - v.wy * yz),
      xy = (s * v.xy + v.s * xy + v.xz * yz - v.yz * xz),
      xz = (s * v.xz + v.s * xz + v.yz * xy - v.xy * yz),
      yz = (s * v.yz + v.s * yz + v.xy * xz - v.xz * xy),
      i = (s * v.i + v.wx * yz + v.wz * xy - v.wy * xz),
    )

  infix def geometric(v: Pga3dPlane): Pga3dMultivector =
    Pga3dMultivector(
      s = 0.0,
      w = s * v.w,
      x = (s * v.x + v.y * xy + v.z * xz),
      y = (s * v.y + v.z * yz - v.x * xy),
      z = (s * v.z - v.x * xz - v.y * yz),
      wx = 0.0,
      wy = 0.0,
      wz = 0.0,
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
      wxy = v.w * xy,
      wxz = v.w * xz,
      wyz = v.w * yz,
      xyz = (v.x * yz + v.z * xy - v.y * xz),
      i = 0.0,
    )

  infix def geometric(v: Pga3dBivector): Pga3dMotor =
    Pga3dMotor(
      s = (-v.xy * xy - v.xz * xz - v.yz * yz),
      wx = (s * v.wx + v.wy * xy + v.wz * xz),
      wy = (s * v.wy + v.wz * yz - v.wx * xy),
      wz = (s * v.wz - v.wx * xz - v.wy * yz),
      xy = (s * v.xy + v.xz * yz - v.yz * xz),
      xz = (s * v.xz + v.yz * xy - v.xy * yz),
      yz = (s * v.yz + v.xy * xz - v.xz * xy),
      i = (v.wx * yz + v.wz * xy - v.wy * xz),
    )

  infix def geometric(v: Pga3dTrivector): Pga3dMultivector =
    Pga3dMultivector(
      s = 0.0,
      w = (v.x * yz + v.z * xy - v.y * xz),
      x = -v.w * yz,
      y = v.w * xz,
      z = -v.w * xy,
      wx = 0.0,
      wy = 0.0,
      wz = 0.0,
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
      wxy = (v.x * xz + v.y * yz - s * v.z),
      wxz = (s * v.y + v.z * yz - v.x * xy),
      wyz = (-s * v.x - v.y * xy - v.z * xz),
      xyz = s * v.w,
      i = 0.0,
    )

  infix def geometric(v: Pga3dQuaternion): Pga3dQuaternion =
    Pga3dQuaternion(
      s = (s * v.s - v.xy * xy - v.xz * xz - v.yz * yz),
      xy = (s * v.xy + v.s * xy + v.xz * yz - v.yz * xz),
      xz = (s * v.xz + v.s * xz + v.yz * xy - v.xy * yz),
      yz = (s * v.yz + v.s * yz + v.xy * xz - v.xz * xy),
    )

  infix def geometric(v: Pga3dTranslator): Pga3dMotor =
    Pga3dMotor(
      s = s,
      wx = (s * v.wx + v.wy * xy + v.wz * xz),
      wy = (s * v.wy + v.wz * yz - v.wx * xy),
      wz = (s * v.wz - v.wx * xz - v.wy * yz),
      xy = xy,
      xz = xz,
      yz = yz,
      i = (v.wx * yz + v.wz * xy - v.wy * xz),
    )

  infix def geometric(v: Pga3dVector): Pga3dMultivector =
    Pga3dMultivector(
      s = 0.0,
      w = (v.x * yz + v.z * xy - v.y * xz),
      x = 0.0,
      y = 0.0,
      z = 0.0,
      wx = 0.0,
      wy = 0.0,
      wz = 0.0,
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
      wxy = (v.x * xz + v.y * yz - s * v.z),
      wxz = (s * v.y + v.z * yz - v.x * xy),
      wyz = (-s * v.x - v.y * xy - v.z * xz),
      xyz = 0.0,
      i = 0.0,
    )

  infix def geometric(v: Pga3dPoint): Pga3dMultivector =
    Pga3dMultivector(
      s = 0.0,
      w = (v.x * yz + v.z * xy - v.y * xz),
      x = -yz,
      y = xz,
      z = -xy,
      wx = 0.0,
      wy = 0.0,
      wz = 0.0,
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
      wxy = (v.x * xz + v.y * yz - s * v.z),
      wxz = (s * v.y + v.z * yz - v.x * xy),
      wyz = (-s * v.x - v.y * xy - v.z * xz),
      xyz = s,
      i = 0.0,
    )

  infix def geometric(v: Pga3dPlaneIdeal): Pga3dMultivector =
    Pga3dMultivector(
      s = 0.0,
      w = 0.0,
      x = (s * v.x + v.y * xy + v.z * xz),
      y = (s * v.y + v.z * yz - v.x * xy),
      z = (s * v.z - v.x * xz - v.y * yz),
      wx = 0.0,
      wy = 0.0,
      wz = 0.0,
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
      wxy = 0.0,
      wxz = 0.0,
      wyz = 0.0,
      xyz = (v.x * yz + v.z * xy - v.y * xz),
      i = 0.0,
    )

  infix def geometric(v: Pga3dBivectorBulk): Pga3dQuaternion =
    Pga3dQuaternion(
      s = (-v.xy * xy - v.xz * xz - v.yz * yz),
      xy = (s * v.xy + v.xz * yz - v.yz * xz),
      xz = (s * v.xz + v.yz * xy - v.xy * yz),
      yz = (s * v.yz + v.xy * xz - v.xz * xy),
    )

  infix def geometric(v: Pga3dBivectorWeight): Pga3dMotor =
    Pga3dMotor(
      s = 0.0,
      wx = (s * v.wx + v.wy * xy + v.wz * xz),
      wy = (s * v.wy + v.wz * yz - v.wx * xy),
      wz = (s * v.wz - v.wx * xz - v.wy * yz),
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
      i = (v.wx * yz + v.wz * xy - v.wy * xz),
    )

  infix def geometric(v: Pga3dPseudoScalar): Pga3dMotor =
    Pga3dMotor(
      s = 0.0,
      wx = -v.i * yz,
      wy = v.i * xz,
      wz = -v.i * xy,
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
      i = s * v.i,
    )

  infix def geometric(v: Pga3dPointCenter.type): Pga3dMultivector =
    Pga3dMultivector(
      s = 0.0,
      w = 0.0,
      x = -yz,
      y = xz,
      z = -xy,
      wx = 0.0,
      wy = 0.0,
      wz = 0.0,
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
      wxy = 0.0,
      wxz = 0.0,
      wyz = 0.0,
      xyz = s,
      i = 0.0,
    )

  infix def dot(v: Pga3dMotor): Pga3dMotor =
    Pga3dMotor(
      s = (s * v.s - v.xy * xy - v.xz * xz - v.yz * yz),
      wx = (s * v.wx - v.i * yz),
      wy = (s * v.wy + v.i * xz),
      wz = (s * v.wz - v.i * xy),
      xy = (s * v.xy + v.s * xy),
      xz = (s * v.xz + v.s * xz),
      yz = (s * v.yz + v.s * yz),
      i = s * v.i,
    )

  infix def dot(v: Pga3dPlane): Pga3dPlane =
    Pga3dPlane(
      x = (s * v.x + v.y * xy + v.z * xz),
      y = (s * v.y + v.z * yz - v.x * xy),
      z = (s * v.z - v.x * xz - v.y * yz),
      w = s * v.w,
    )

  infix def dot(v: Pga3dBivector): Pga3dMotor =
    Pga3dMotor(
      s = (-v.xy * xy - v.xz * xz - v.yz * yz),
      wx = s * v.wx,
      wy = s * v.wy,
      wz = s * v.wz,
      xy = s * v.xy,
      xz = s * v.xz,
      yz = s * v.yz,
      i = 0.0,
    )

  infix def dot(v: Pga3dTrivector): Pga3dMultivector =
    Pga3dMultivector(
      s = 0.0,
      w = (v.x * yz + v.z * xy - v.y * xz),
      x = -v.w * yz,
      y = v.w * xz,
      z = -v.w * xy,
      wx = 0.0,
      wy = 0.0,
      wz = 0.0,
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
      wxy = -s * v.z,
      wxz = s * v.y,
      wyz = -s * v.x,
      xyz = s * v.w,
      i = 0.0,
    )

  infix def dot(v: Pga3dQuaternion): Pga3dQuaternion =
    Pga3dQuaternion(
      s = (s * v.s - v.xy * xy - v.xz * xz - v.yz * yz),
      xy = (s * v.xy + v.s * xy),
      xz = (s * v.xz + v.s * xz),
      yz = (s * v.yz + v.s * yz),
    )

  infix def dot(v: Pga3dTranslator): Pga3dMotor =
    Pga3dMotor(
      s = s,
      wx = s * v.wx,
      wy = s * v.wy,
      wz = s * v.wz,
      xy = xy,
      xz = xz,
      yz = yz,
      i = 0.0,
    )

  infix def dot(v: Pga3dVector): Pga3dMultivector =
    Pga3dMultivector(
      s = 0.0,
      w = (v.x * yz + v.z * xy - v.y * xz),
      x = 0.0,
      y = 0.0,
      z = 0.0,
      wx = 0.0,
      wy = 0.0,
      wz = 0.0,
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
      wxy = -s * v.z,
      wxz = s * v.y,
      wyz = -s * v.x,
      xyz = 0.0,
      i = 0.0,
    )

  infix def dot(v: Pga3dPoint): Pga3dMultivector =
    Pga3dMultivector(
      s = 0.0,
      w = (v.x * yz + v.z * xy - v.y * xz),
      x = -yz,
      y = xz,
      z = -xy,
      wx = 0.0,
      wy = 0.0,
      wz = 0.0,
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
      wxy = -s * v.z,
      wxz = s * v.y,
      wyz = -s * v.x,
      xyz = s,
      i = 0.0,
    )

  infix def dot(v: Pga3dPlaneIdeal): Pga3dPlaneIdeal =
    Pga3dPlaneIdeal(
      x = (s * v.x + v.y * xy + v.z * xz),
      y = (s * v.y + v.z * yz - v.x * xy),
      z = (s * v.z - v.x * xz - v.y * yz),
    )

  infix def dot(v: Pga3dBivectorBulk): Pga3dQuaternion =
    Pga3dQuaternion(
      s = (-v.xy * xy - v.xz * xz - v.yz * yz),
      xy = s * v.xy,
      xz = s * v.xz,
      yz = s * v.yz,
    )

  infix def dot(v: Pga3dBivectorWeight): Pga3dBivectorWeight =
    Pga3dBivectorWeight(
      wx = s * v.wx,
      wy = s * v.wy,
      wz = s * v.wz,
    )

  infix def dot(v: Pga3dPseudoScalar): Pga3dMotor =
    Pga3dMotor(
      s = 0.0,
      wx = -v.i * yz,
      wy = v.i * xz,
      wz = -v.i * xy,
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
      i = s * v.i,
    )

  infix def dot(v: Pga3dPointCenter.type): Pga3dMultivector =
    Pga3dMultivector(
      s = 0.0,
      w = 0.0,
      x = -yz,
      y = xz,
      z = -xy,
      wx = 0.0,
      wy = 0.0,
      wz = 0.0,
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
      wxy = 0.0,
      wxz = 0.0,
      wyz = 0.0,
      xyz = s,
      i = 0.0,
    )

  infix def wedge(v: Pga3dMotor): Pga3dMotor =
    Pga3dMotor(
      s = s * v.s,
      wx = s * v.wx,
      wy = s * v.wy,
      wz = s * v.wz,
      xy = (s * v.xy + v.s * xy),
      xz = (s * v.xz + v.s * xz),
      yz = (s * v.yz + v.s * yz),
      i = (s * v.i + v.wx * yz + v.wz * xy - v.wy * xz),
    )

  inline infix def ^(v: Pga3dMotor): Pga3dMotor = wedge(v)

  infix def wedge(v: Pga3dPlane): Pga3dMultivector =
    Pga3dMultivector(
      s = 0.0,
      w = s * v.w,
      x = s * v.x,
      y = s * v.y,
      z = s * v.z,
      wx = 0.0,
      wy = 0.0,
      wz = 0.0,
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
      wxy = v.w * xy,
      wxz = v.w * xz,
      wyz = v.w * yz,
      xyz = (v.x * yz + v.z * xy - v.y * xz),
      i = 0.0,
    )

  inline infix def ^(v: Pga3dPlane): Pga3dMultivector = wedge(v)

  infix def wedge(v: Pga3dBivector): Pga3dMotor =
    Pga3dMotor(
      s = 0.0,
      wx = s * v.wx,
      wy = s * v.wy,
      wz = s * v.wz,
      xy = s * v.xy,
      xz = s * v.xz,
      yz = s * v.yz,
      i = (v.wx * yz + v.wz * xy - v.wy * xz),
    )

  inline infix def ^(v: Pga3dBivector): Pga3dMotor = wedge(v)

  infix def wedge(v: Pga3dTrivector): Pga3dTrivector =
    Pga3dTrivector(
      x = s * v.x,
      y = s * v.y,
      z = s * v.z,
      w = s * v.w,
    )

  inline infix def ^(v: Pga3dTrivector): Pga3dTrivector = wedge(v)

  infix def wedge(v: Pga3dQuaternion): Pga3dQuaternion =
    Pga3dQuaternion(
      s = s * v.s,
      xy = (s * v.xy + v.s * xy),
      xz = (s * v.xz + v.s * xz),
      yz = (s * v.yz + v.s * yz),
    )

  inline infix def ^(v: Pga3dQuaternion): Pga3dQuaternion = wedge(v)

  infix def wedge(v: Pga3dTranslator): Pga3dMotor =
    Pga3dMotor(
      s = s,
      wx = s * v.wx,
      wy = s * v.wy,
      wz = s * v.wz,
      xy = xy,
      xz = xz,
      yz = yz,
      i = (v.wx * yz + v.wz * xy - v.wy * xz),
    )

  inline infix def ^(v: Pga3dTranslator): Pga3dMotor = wedge(v)

  infix def wedge(v: Pga3dVector): Pga3dVector =
    Pga3dVector(
      x = s * v.x,
      y = s * v.y,
      z = s * v.z,
    )

  inline infix def ^(v: Pga3dVector): Pga3dVector = wedge(v)

  infix def wedge(v: Pga3dPoint): Pga3dTrivector =
    Pga3dTrivector(
      x = s * v.x,
      y = s * v.y,
      z = s * v.z,
      w = s,
    )

  inline infix def ^(v: Pga3dPoint): Pga3dTrivector = wedge(v)

  infix def wedge(v: Pga3dPlaneIdeal): Pga3dMultivector =
    Pga3dMultivector(
      s = 0.0,
      w = 0.0,
      x = s * v.x,
      y = s * v.y,
      z = s * v.z,
      wx = 0.0,
      wy = 0.0,
      wz = 0.0,
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
      wxy = 0.0,
      wxz = 0.0,
      wyz = 0.0,
      xyz = (v.x * yz + v.z * xy - v.y * xz),
      i = 0.0,
    )

  inline infix def ^(v: Pga3dPlaneIdeal): Pga3dMultivector = wedge(v)

  infix def wedge(v: Pga3dBivectorBulk): Pga3dBivectorBulk =
    Pga3dBivectorBulk(
      xy = s * v.xy,
      xz = s * v.xz,
      yz = s * v.yz,
    )

  inline infix def ^(v: Pga3dBivectorBulk): Pga3dBivectorBulk = wedge(v)

  infix def wedge(v: Pga3dBivectorWeight): Pga3dMotor =
    Pga3dMotor(
      s = 0.0,
      wx = s * v.wx,
      wy = s * v.wy,
      wz = s * v.wz,
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
      i = (v.wx * yz + v.wz * xy - v.wy * xz),
    )

  inline infix def ^(v: Pga3dBivectorWeight): Pga3dMotor = wedge(v)

  infix def wedge(v: Pga3dPseudoScalar): Pga3dPseudoScalar =
    Pga3dPseudoScalar(
      i = s * v.i,
    )

  inline infix def ^(v: Pga3dPseudoScalar): Pga3dPseudoScalar = wedge(v)

  infix def wedge(v: Pga3dPointCenter.type): Pga3dTrivector =
    Pga3dTrivector(
      x = 0.0,
      y = 0.0,
      z = 0.0,
      w = s,
    )

  inline infix def ^(v: Pga3dPointCenter.type): Pga3dTrivector = wedge(v)

  infix def antiGeometric(v: Pga3dMotor): Pga3dQuaternion =
    Pga3dQuaternion(
      s = (s * v.i + v.wx * yz + v.wz * xy - v.wy * xz),
      xy = (v.i * xy - s * v.wz - v.wx * xz - v.wy * yz),
      xz = (s * v.wy + v.i * xz + v.wx * xy - v.wz * yz),
      yz = (v.i * yz + v.wy * xy + v.wz * xz - s * v.wx),
    )

  infix def antiGeometric(v: Pga3dPlane): Pga3dMultivector =
    Pga3dMultivector(
      s = 0.0,
      w = 0.0,
      x = -v.w * yz,
      y = v.w * xz,
      z = -v.w * xy,
      wx = 0.0,
      wy = 0.0,
      wz = 0.0,
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
      wxy = 0.0,
      wxz = 0.0,
      wyz = 0.0,
      xyz = -s * v.w,
      i = 0.0,
    )

  infix def antiGeometric(v: Pga3dBivector): Pga3dQuaternion =
    Pga3dQuaternion(
      s = (v.wx * yz + v.wz * xy - v.wy * xz),
      xy = (-s * v.wz - v.wx * xz - v.wy * yz),
      xz = (s * v.wy + v.wx * xy - v.wz * yz),
      yz = (v.wy * xy + v.wz * xz - s * v.wx),
    )

  infix def antiGeometric(v: Pga3dTrivector): Pga3dMultivector =
    Pga3dMultivector(
      s = 0.0,
      w = 0.0,
      x = (v.y * xy + v.z * xz - s * v.x),
      y = (v.z * yz - s * v.y - v.x * xy),
      z = (-s * v.z - v.x * xz - v.y * yz),
      wx = 0.0,
      wy = 0.0,
      wz = 0.0,
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
      wxy = 0.0,
      wxz = 0.0,
      wyz = 0.0,
      xyz = (v.x * yz + v.z * xy - v.y * xz),
      i = 0.0,
    )

  infix def antiGeometric(v: Pga3dTranslator): Pga3dQuaternion =
    Pga3dQuaternion(
      s = (v.wx * yz + v.wz * xy - v.wy * xz),
      xy = (-s * v.wz - v.wx * xz - v.wy * yz),
      xz = (s * v.wy + v.wx * xy - v.wz * yz),
      yz = (v.wy * xy + v.wz * xz - s * v.wx),
    )

  infix def antiGeometric(v: Pga3dVector): Pga3dMultivector =
    Pga3dMultivector(
      s = 0.0,
      w = 0.0,
      x = (v.y * xy + v.z * xz - s * v.x),
      y = (v.z * yz - s * v.y - v.x * xy),
      z = (-s * v.z - v.x * xz - v.y * yz),
      wx = 0.0,
      wy = 0.0,
      wz = 0.0,
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
      wxy = 0.0,
      wxz = 0.0,
      wyz = 0.0,
      xyz = (v.x * yz + v.z * xy - v.y * xz),
      i = 0.0,
    )

  infix def antiGeometric(v: Pga3dPoint): Pga3dMultivector =
    Pga3dMultivector(
      s = 0.0,
      w = 0.0,
      x = (v.y * xy + v.z * xz - s * v.x),
      y = (v.z * yz - s * v.y - v.x * xy),
      z = (-s * v.z - v.x * xz - v.y * yz),
      wx = 0.0,
      wy = 0.0,
      wz = 0.0,
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
      wxy = 0.0,
      wxz = 0.0,
      wyz = 0.0,
      xyz = (v.x * yz + v.z * xy - v.y * xz),
      i = 0.0,
    )

  infix def antiGeometric(v: Pga3dBivectorWeight): Pga3dQuaternion =
    Pga3dQuaternion(
      s = (v.wx * yz + v.wz * xy - v.wy * xz),
      xy = (-s * v.wz - v.wx * xz - v.wy * yz),
      xz = (s * v.wy + v.wx * xy - v.wz * yz),
      yz = (v.wy * xy + v.wz * xz - s * v.wx),
    )

  infix def antiGeometric(v: Pga3dPseudoScalar): Pga3dQuaternion =
    Pga3dQuaternion(
      s = s * v.i,
      xy = v.i * xy,
      xz = v.i * xz,
      yz = v.i * yz,
    )

  infix def antiDot(v: Pga3dMotor): Pga3dQuaternion =
    Pga3dQuaternion(
      s = s * v.i,
      xy = (v.i * xy - s * v.wz),
      xz = (s * v.wy + v.i * xz),
      yz = (v.i * yz - s * v.wx),
    )

  infix def antiDot(v: Pga3dPlane): Pga3dTrivector =
    Pga3dTrivector(
      x = 0.0,
      y = 0.0,
      z = 0.0,
      w = -s * v.w,
    )

  infix def antiDot(v: Pga3dBivector): Pga3dBivectorBulk =
    Pga3dBivectorBulk(
      xy = -s * v.wz,
      xz = s * v.wy,
      yz = -s * v.wx,
    )

  infix def antiDot(v: Pga3dTrivector): Pga3dMultivector =
    Pga3dMultivector(
      s = 0.0,
      w = 0.0,
      x = -s * v.x,
      y = -s * v.y,
      z = -s * v.z,
      wx = 0.0,
      wy = 0.0,
      wz = 0.0,
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
      wxy = 0.0,
      wxz = 0.0,
      wyz = 0.0,
      xyz = (v.x * yz + v.z * xy - v.y * xz),
      i = 0.0,
    )

  infix def antiDot(v: Pga3dTranslator): Pga3dBivectorBulk =
    Pga3dBivectorBulk(
      xy = -s * v.wz,
      xz = s * v.wy,
      yz = -s * v.wx,
    )

  infix def antiDot(v: Pga3dVector): Pga3dMultivector =
    Pga3dMultivector(
      s = 0.0,
      w = 0.0,
      x = -s * v.x,
      y = -s * v.y,
      z = -s * v.z,
      wx = 0.0,
      wy = 0.0,
      wz = 0.0,
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
      wxy = 0.0,
      wxz = 0.0,
      wyz = 0.0,
      xyz = (v.x * yz + v.z * xy - v.y * xz),
      i = 0.0,
    )

  infix def antiDot(v: Pga3dPoint): Pga3dMultivector =
    Pga3dMultivector(
      s = 0.0,
      w = 0.0,
      x = -s * v.x,
      y = -s * v.y,
      z = -s * v.z,
      wx = 0.0,
      wy = 0.0,
      wz = 0.0,
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
      wxy = 0.0,
      wxz = 0.0,
      wyz = 0.0,
      xyz = (v.x * yz + v.z * xy - v.y * xz),
      i = 0.0,
    )

  infix def antiDot(v: Pga3dBivectorWeight): Pga3dBivectorBulk =
    Pga3dBivectorBulk(
      xy = -s * v.wz,
      xz = s * v.wy,
      yz = -s * v.wx,
    )

  infix def antiDot(v: Pga3dPseudoScalar): Pga3dQuaternion =
    Pga3dQuaternion(
      s = s * v.i,
      xy = v.i * xy,
      xz = v.i * xz,
      yz = v.i * yz,
    )

  infix def antiWedge(v: Pga3dMotor): Pga3dQuaternion =
    Pga3dQuaternion(
      s = (s * v.i + v.wx * yz + v.wz * xy - v.wy * xz),
      xy = v.i * xy,
      xz = v.i * xz,
      yz = v.i * yz,
    )

  inline infix def v(v: Pga3dMotor): Pga3dQuaternion = antiWedge(v)

  infix def antiWedge(v: Pga3dBivector): Double =
    (v.wx * yz + v.wz * xy - v.wy * xz)

  inline infix def v(v: Pga3dBivector): Double = antiWedge(v)

  infix def antiWedge(v: Pga3dTrivector): Pga3dPlaneIdeal =
    Pga3dPlaneIdeal(
      x = (v.y * xy + v.z * xz),
      y = (v.z * yz - v.x * xy),
      z = (-v.x * xz - v.y * yz),
    )

  inline infix def v(v: Pga3dTrivector): Pga3dPlaneIdeal = antiWedge(v)

  infix def antiWedge(v: Pga3dTranslator): Double =
    (v.wx * yz + v.wz * xy - v.wy * xz)

  inline infix def v(v: Pga3dTranslator): Double = antiWedge(v)

  infix def antiWedge(v: Pga3dVector): Pga3dPlaneIdeal =
    Pga3dPlaneIdeal(
      x = (v.y * xy + v.z * xz),
      y = (v.z * yz - v.x * xy),
      z = (-v.x * xz - v.y * yz),
    )

  inline infix def v(v: Pga3dVector): Pga3dPlaneIdeal = antiWedge(v)

  infix def antiWedge(v: Pga3dPoint): Pga3dPlaneIdeal =
    Pga3dPlaneIdeal(
      x = (v.y * xy + v.z * xz),
      y = (v.z * yz - v.x * xy),
      z = (-v.x * xz - v.y * yz),
    )

  inline infix def v(v: Pga3dPoint): Pga3dPlaneIdeal = antiWedge(v)

  infix def antiWedge(v: Pga3dBivectorWeight): Double =
    (v.wx * yz + v.wz * xy - v.wy * xz)

  inline infix def v(v: Pga3dBivectorWeight): Double = antiWedge(v)

  infix def antiWedge(v: Pga3dPseudoScalar): Pga3dQuaternion =
    Pga3dQuaternion(
      s = s * v.i,
      xy = v.i * xy,
      xz = v.i * xz,
      yz = v.i * yz,
    )

  inline infix def v(v: Pga3dPseudoScalar): Pga3dQuaternion = antiWedge(v)

  infix def sandwich(v: Pga3dMotor): Pga3dMotor =
    val sMs = s * s
    val sMxy = s * xy
    val sMxz = s * xz
    val sMyz = s * yz
    val xyMxy = xy * xy
    val xyMxz = xy * xz
    val xyMyz = xy * yz
    val xzMxz = xz * xz
    val xzMyz = xz * yz
    val yzMyz = yz * yz
    Pga3dMotor(
      s = v.s * (sMs + xyMxy + xzMxz + yzMyz),
      wx = (2.0 * (v.wy * (sMxy - xzMyz) + v.wz * (sMxz + xyMyz)) + v.wx * (sMs + yzMyz - xyMxy - xzMxz)),
      wy = (2.0 * (v.wx * (-sMxy - xzMyz) + v.wz * (sMyz - xyMxz)) + v.wy * (sMs + xzMxz - xyMxy - yzMyz)),
      wz = (2.0 * (v.wx * (xyMyz - sMxz) + v.wy * (-sMyz - xyMxz)) + v.wz * (sMs + xyMxy - xzMxz - yzMyz)),
      xy = (2.0 * (v.xz * (sMyz + xyMxz) + v.yz * (xyMyz - sMxz)) + v.xy * (sMs + xyMxy - xzMxz - yzMyz)),
      xz = (2.0 * (v.xy * (xyMxz - sMyz) + v.yz * (sMxy + xzMyz)) + v.xz * (sMs + xzMxz - xyMxy - yzMyz)),
      yz = (2.0 * (v.xy * (sMxz + xyMyz) + v.xz * (xzMyz - sMxy)) + v.yz * (sMs + yzMyz - xyMxy - xzMxz)),
      i = v.i * (sMs + xyMxy + xzMxz + yzMyz),
    )

  infix def sandwich(v: Pga3dPlane): Pga3dPlane =
    val sMs = s * s
    val sMxy = s * xy
    val sMxz = s * xz
    val sMyz = s * yz
    val xyMxy = xy * xy
    val xyMxz = xy * xz
    val xyMyz = xy * yz
    val xzMxz = xz * xz
    val xzMyz = xz * yz
    val yzMyz = yz * yz
    Pga3dPlane(
      x = (2.0 * (v.y * (sMxy - xzMyz) + v.z * (sMxz + xyMyz)) + v.x * (sMs + yzMyz - xyMxy - xzMxz)),
      y = (2.0 * (v.x * (-sMxy - xzMyz) + v.z * (sMyz - xyMxz)) + v.y * (sMs + xzMxz - xyMxy - yzMyz)),
      z = (2.0 * (v.x * (xyMyz - sMxz) + v.y * (-sMyz - xyMxz)) + v.z * (sMs + xyMxy - xzMxz - yzMyz)),
      w = v.w * (sMs + xyMxy + xzMxz + yzMyz),
    )

  infix def sandwich(v: Pga3dBivector): Pga3dBivector =
    val sMs = s * s
    val sMxy = s * xy
    val sMxz = s * xz
    val sMyz = s * yz
    val xyMxy = xy * xy
    val xyMxz = xy * xz
    val xyMyz = xy * yz
    val xzMxz = xz * xz
    val xzMyz = xz * yz
    val yzMyz = yz * yz
    Pga3dBivector(
      wx = (2.0 * (v.wy * (sMxy - xzMyz) + v.wz * (sMxz + xyMyz)) + v.wx * (sMs + yzMyz - xyMxy - xzMxz)),
      wy = (2.0 * (v.wx * (-sMxy - xzMyz) + v.wz * (sMyz - xyMxz)) + v.wy * (sMs + xzMxz - xyMxy - yzMyz)),
      wz = (2.0 * (v.wx * (xyMyz - sMxz) + v.wy * (-sMyz - xyMxz)) + v.wz * (sMs + xyMxy - xzMxz - yzMyz)),
      xy = (2.0 * (v.xz * (sMyz + xyMxz) + v.yz * (xyMyz - sMxz)) + v.xy * (sMs + xyMxy - xzMxz - yzMyz)),
      xz = (2.0 * (v.xy * (xyMxz - sMyz) + v.yz * (sMxy + xzMyz)) + v.xz * (sMs + xzMxz - xyMxy - yzMyz)),
      yz = (2.0 * (v.xy * (sMxz + xyMyz) + v.xz * (xzMyz - sMxy)) + v.yz * (sMs + yzMyz - xyMxy - xzMxz)),
    )

  infix def sandwich(v: Pga3dTrivector): Pga3dTrivector =
    val sMs = s * s
    val sMxy = s * xy
    val sMxz = s * xz
    val sMyz = s * yz
    val xyMxy = xy * xy
    val xyMxz = xy * xz
    val xyMyz = xy * yz
    val xzMxz = xz * xz
    val xzMyz = xz * yz
    val yzMyz = yz * yz
    Pga3dTrivector(
      x = -(2.0 * (v.y * (xzMyz - sMxy) + v.z * (-sMxz - xyMyz)) + v.x * (xyMxy + xzMxz - sMs - yzMyz)),
      y = (2.0 * (v.x * (-sMxy - xzMyz) + v.z * (sMyz - xyMxz)) + v.y * (sMs + xzMxz - xyMxy - yzMyz)),
      z = -(2.0 * (v.x * (sMxz - xyMyz) + v.y * (sMyz + xyMxz)) + v.z * (xzMxz + yzMyz - sMs - xyMxy)),
      w = v.w * (sMs + xyMxy + xzMxz + yzMyz),
    )

  infix def sandwich(v: Pga3dQuaternion): Pga3dQuaternion =
    val sMs = s * s
    val sMxy = s * xy
    val sMxz = s * xz
    val sMyz = s * yz
    val xyMxy = xy * xy
    val xyMxz = xy * xz
    val xyMyz = xy * yz
    val xzMxz = xz * xz
    val xzMyz = xz * yz
    val yzMyz = yz * yz
    Pga3dQuaternion(
      s = v.s * (sMs + xyMxy + xzMxz + yzMyz),
      xy = (2.0 * (v.xz * (sMyz + xyMxz) + v.yz * (xyMyz - sMxz)) + v.xy * (sMs + xyMxy - xzMxz - yzMyz)),
      xz = (2.0 * (v.xy * (xyMxz - sMyz) + v.yz * (sMxy + xzMyz)) + v.xz * (sMs + xzMxz - xyMxy - yzMyz)),
      yz = (2.0 * (v.xy * (sMxz + xyMyz) + v.xz * (xzMyz - sMxy)) + v.yz * (sMs + yzMyz - xyMxy - xzMxz)),
    )

  infix def sandwich(v: Pga3dTranslator): Pga3dMotor =
    val sMs = s * s
    val sMxy = s * xy
    val sMxz = s * xz
    val sMyz = s * yz
    val xyMxy = xy * xy
    val xyMxz = xy * xz
    val xyMyz = xy * yz
    val xzMxz = xz * xz
    val xzMyz = xz * yz
    val yzMyz = yz * yz
    Pga3dMotor(
      s = (sMs + xyMxy + xzMxz + yzMyz),
      wx = (2.0 * (v.wy * (sMxy - xzMyz) + v.wz * (sMxz + xyMyz)) + v.wx * (sMs + yzMyz - xyMxy - xzMxz)),
      wy = (2.0 * (v.wx * (-sMxy - xzMyz) + v.wz * (sMyz - xyMxz)) + v.wy * (sMs + xzMxz - xyMxy - yzMyz)),
      wz = (2.0 * (v.wx * (xyMyz - sMxz) + v.wy * (-sMyz - xyMxz)) + v.wz * (sMs + xyMxy - xzMxz - yzMyz)),
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
      i = 0.0,
    )

  infix def sandwich(v: Pga3dVector): Pga3dVector =
    val sMs = s * s
    val sMxy = s * xy
    val sMxz = s * xz
    val sMyz = s * yz
    val xyMxy = xy * xy
    val xyMxz = xy * xz
    val xyMyz = xy * yz
    val xzMxz = xz * xz
    val xzMyz = xz * yz
    val yzMyz = yz * yz
    Pga3dVector(
      x = -(2.0 * (v.y * (xzMyz - sMxy) + v.z * (-sMxz - xyMyz)) + v.x * (xyMxy + xzMxz - sMs - yzMyz)),
      y = (2.0 * (v.x * (-sMxy - xzMyz) + v.z * (sMyz - xyMxz)) + v.y * (sMs + xzMxz - xyMxy - yzMyz)),
      z = -(2.0 * (v.x * (sMxz - xyMyz) + v.y * (sMyz + xyMxz)) + v.z * (xzMxz + yzMyz - sMs - xyMxy)),
    )

  infix def sandwich(v: Pga3dPoint): Pga3dTrivector =
    val sMs = s * s
    val sMxy = s * xy
    val sMxz = s * xz
    val sMyz = s * yz
    val xyMxy = xy * xy
    val xyMxz = xy * xz
    val xyMyz = xy * yz
    val xzMxz = xz * xz
    val xzMyz = xz * yz
    val yzMyz = yz * yz
    Pga3dTrivector(
      x = -(2.0 * (v.y * (xzMyz - sMxy) + v.z * (-sMxz - xyMyz)) + v.x * (xyMxy + xzMxz - sMs - yzMyz)),
      y = (2.0 * (v.x * (-sMxy - xzMyz) + v.z * (sMyz - xyMxz)) + v.y * (sMs + xzMxz - xyMxy - yzMyz)),
      z = -(2.0 * (v.x * (sMxz - xyMyz) + v.y * (sMyz + xyMxz)) + v.z * (xzMxz + yzMyz - sMs - xyMxy)),
      w = (sMs + xyMxy + xzMxz + yzMyz),
    )

  infix def sandwich(v: Pga3dPlaneIdeal): Pga3dPlaneIdeal =
    val sMs = s * s
    val sMxy = s * xy
    val sMxz = s * xz
    val sMyz = s * yz
    val xyMxy = xy * xy
    val xyMxz = xy * xz
    val xyMyz = xy * yz
    val xzMxz = xz * xz
    val xzMyz = xz * yz
    val yzMyz = yz * yz
    Pga3dPlaneIdeal(
      x = (2.0 * (v.y * (sMxy - xzMyz) + v.z * (sMxz + xyMyz)) + v.x * (sMs + yzMyz - xyMxy - xzMxz)),
      y = (2.0 * (v.x * (-sMxy - xzMyz) + v.z * (sMyz - xyMxz)) + v.y * (sMs + xzMxz - xyMxy - yzMyz)),
      z = (2.0 * (v.x * (xyMyz - sMxz) + v.y * (-sMyz - xyMxz)) + v.z * (sMs + xyMxy - xzMxz - yzMyz)),
    )

  infix def sandwich(v: Pga3dBivectorBulk): Pga3dBivectorBulk =
    val sMs = s * s
    val sMxy = s * xy
    val sMxz = s * xz
    val sMyz = s * yz
    val xyMxy = xy * xy
    val xyMxz = xy * xz
    val xyMyz = xy * yz
    val xzMxz = xz * xz
    val xzMyz = xz * yz
    val yzMyz = yz * yz
    Pga3dBivectorBulk(
      xy = (2.0 * (v.xz * (sMyz + xyMxz) + v.yz * (xyMyz - sMxz)) + v.xy * (sMs + xyMxy - xzMxz - yzMyz)),
      xz = (2.0 * (v.xy * (xyMxz - sMyz) + v.yz * (sMxy + xzMyz)) + v.xz * (sMs + xzMxz - xyMxy - yzMyz)),
      yz = (2.0 * (v.xy * (sMxz + xyMyz) + v.xz * (xzMyz - sMxy)) + v.yz * (sMs + yzMyz - xyMxy - xzMxz)),
    )

  infix def sandwich(v: Pga3dBivectorWeight): Pga3dBivectorWeight =
    val sMs = s * s
    val sMxy = s * xy
    val sMxz = s * xz
    val sMyz = s * yz
    val xyMxy = xy * xy
    val xyMxz = xy * xz
    val xyMyz = xy * yz
    val xzMxz = xz * xz
    val xzMyz = xz * yz
    val yzMyz = yz * yz
    Pga3dBivectorWeight(
      wx = (2.0 * (v.wy * (sMxy - xzMyz) + v.wz * (sMxz + xyMyz)) + v.wx * (sMs + yzMyz - xyMxy - xzMxz)),
      wy = (2.0 * (v.wx * (-sMxy - xzMyz) + v.wz * (sMyz - xyMxz)) + v.wy * (sMs + xzMxz - xyMxy - yzMyz)),
      wz = (2.0 * (v.wx * (xyMyz - sMxz) + v.wy * (-sMyz - xyMxz)) + v.wz * (sMs + xyMxy - xzMxz - yzMyz)),
    )

  infix def sandwich(v: Pga3dPseudoScalar): Pga3dPseudoScalar =
    Pga3dPseudoScalar(
      i = v.i * (s * s + xy * xy + xz * xz + yz * yz),
    )

  infix def sandwich(v: Pga3dPointCenter.type): Pga3dTrivector =
    Pga3dTrivector(
      x = 0.0,
      y = 0.0,
      z = 0.0,
      w = (s * s + xy * xy + xz * xz + yz * yz),
    )

  infix def reverseSandwich(v: Pga3dMotor): Pga3dMotor =
    val sMs = s * s
    val sMxy = s * xy
    val sMxz = s * xz
    val sMyz = s * yz
    val xyMxy = xy * xy
    val xyMxz = xy * xz
    val xyMyz = xy * yz
    val xzMxz = xz * xz
    val xzMyz = xz * yz
    val yzMyz = yz * yz
    Pga3dMotor(
      s = v.s * (sMs + xyMxy + xzMxz + yzMyz),
      wx = (2.0 * (v.wy * (-sMxy - xzMyz) + v.wz * (xyMyz - sMxz)) + v.wx * (sMs + yzMyz - xyMxy - xzMxz)),
      wy = (2.0 * (v.wx * (sMxy - xzMyz) + v.wz * (-sMyz - xyMxz)) + v.wy * (sMs + xzMxz - xyMxy - yzMyz)),
      wz = (2.0 * (v.wx * (sMxz + xyMyz) + v.wy * (sMyz - xyMxz)) + v.wz * (sMs + xyMxy - xzMxz - yzMyz)),
      xy = (2.0 * (v.xz * (xyMxz - sMyz) + v.yz * (sMxz + xyMyz)) + v.xy * (sMs + xyMxy - xzMxz - yzMyz)),
      xz = (2.0 * (v.xy * (sMyz + xyMxz) + v.yz * (xzMyz - sMxy)) + v.xz * (sMs + xzMxz - xyMxy - yzMyz)),
      yz = (2.0 * (v.xy * (xyMyz - sMxz) + v.xz * (sMxy + xzMyz)) + v.yz * (sMs + yzMyz - xyMxy - xzMxz)),
      i = v.i * (sMs + xyMxy + xzMxz + yzMyz),
    )

  infix def reverseSandwich(v: Pga3dPlane): Pga3dPlane =
    val sMs = s * s
    val sMxy = s * xy
    val sMxz = s * xz
    val sMyz = s * yz
    val xyMxy = xy * xy
    val xyMxz = xy * xz
    val xyMyz = xy * yz
    val xzMxz = xz * xz
    val xzMyz = xz * yz
    val yzMyz = yz * yz
    Pga3dPlane(
      x = (2.0 * (v.y * (-sMxy - xzMyz) + v.z * (xyMyz - sMxz)) + v.x * (sMs + yzMyz - xyMxy - xzMxz)),
      y = (2.0 * (v.x * (sMxy - xzMyz) + v.z * (-sMyz - xyMxz)) + v.y * (sMs + xzMxz - xyMxy - yzMyz)),
      z = (2.0 * (v.x * (sMxz + xyMyz) + v.y * (sMyz - xyMxz)) + v.z * (sMs + xyMxy - xzMxz - yzMyz)),
      w = v.w * (sMs + xyMxy + xzMxz + yzMyz),
    )

  infix def reverseSandwich(v: Pga3dBivector): Pga3dBivector =
    val sMs = s * s
    val sMxy = s * xy
    val sMxz = s * xz
    val sMyz = s * yz
    val xyMxy = xy * xy
    val xyMxz = xy * xz
    val xyMyz = xy * yz
    val xzMxz = xz * xz
    val xzMyz = xz * yz
    val yzMyz = yz * yz
    Pga3dBivector(
      wx = (2.0 * (v.wy * (-sMxy - xzMyz) + v.wz * (xyMyz - sMxz)) + v.wx * (sMs + yzMyz - xyMxy - xzMxz)),
      wy = (2.0 * (v.wx * (sMxy - xzMyz) + v.wz * (-sMyz - xyMxz)) + v.wy * (sMs + xzMxz - xyMxy - yzMyz)),
      wz = (2.0 * (v.wx * (sMxz + xyMyz) + v.wy * (sMyz - xyMxz)) + v.wz * (sMs + xyMxy - xzMxz - yzMyz)),
      xy = (2.0 * (v.xz * (xyMxz - sMyz) + v.yz * (sMxz + xyMyz)) + v.xy * (sMs + xyMxy - xzMxz - yzMyz)),
      xz = (2.0 * (v.xy * (sMyz + xyMxz) + v.yz * (xzMyz - sMxy)) + v.xz * (sMs + xzMxz - xyMxy - yzMyz)),
      yz = (2.0 * (v.xy * (xyMyz - sMxz) + v.xz * (sMxy + xzMyz)) + v.yz * (sMs + yzMyz - xyMxy - xzMxz)),
    )

  infix def reverseSandwich(v: Pga3dTrivector): Pga3dTrivector =
    val sMs = s * s
    val sMxy = s * xy
    val sMxz = s * xz
    val sMyz = s * yz
    val xyMxy = xy * xy
    val xyMxz = xy * xz
    val xyMyz = xy * yz
    val xzMxz = xz * xz
    val xzMyz = xz * yz
    val yzMyz = yz * yz
    Pga3dTrivector(
      x = -(2.0 * (v.y * (sMxy + xzMyz) + v.z * (sMxz - xyMyz)) + v.x * (xyMxy + xzMxz - sMs - yzMyz)),
      y = (2.0 * (v.x * (sMxy - xzMyz) + v.z * (-sMyz - xyMxz)) + v.y * (sMs + xzMxz - xyMxy - yzMyz)),
      z = -(2.0 * (v.x * (-sMxz - xyMyz) + v.y * (xyMxz - sMyz)) + v.z * (xzMxz + yzMyz - sMs - xyMxy)),
      w = v.w * (sMs + xyMxy + xzMxz + yzMyz),
    )

  infix def reverseSandwich(v: Pga3dQuaternion): Pga3dQuaternion =
    val sMs = s * s
    val sMxy = s * xy
    val sMxz = s * xz
    val sMyz = s * yz
    val xyMxy = xy * xy
    val xyMxz = xy * xz
    val xyMyz = xy * yz
    val xzMxz = xz * xz
    val xzMyz = xz * yz
    val yzMyz = yz * yz
    Pga3dQuaternion(
      s = v.s * (sMs + xyMxy + xzMxz + yzMyz),
      xy = (2.0 * (v.xz * (xyMxz - sMyz) + v.yz * (sMxz + xyMyz)) + v.xy * (sMs + xyMxy - xzMxz - yzMyz)),
      xz = (2.0 * (v.xy * (sMyz + xyMxz) + v.yz * (xzMyz - sMxy)) + v.xz * (sMs + xzMxz - xyMxy - yzMyz)),
      yz = (2.0 * (v.xy * (xyMyz - sMxz) + v.xz * (sMxy + xzMyz)) + v.yz * (sMs + yzMyz - xyMxy - xzMxz)),
    )

  infix def reverseSandwich(v: Pga3dTranslator): Pga3dMotor =
    val sMs = s * s
    val sMxy = s * xy
    val sMxz = s * xz
    val sMyz = s * yz
    val xyMxy = xy * xy
    val xyMxz = xy * xz
    val xyMyz = xy * yz
    val xzMxz = xz * xz
    val xzMyz = xz * yz
    val yzMyz = yz * yz
    Pga3dMotor(
      s = (sMs + xyMxy + xzMxz + yzMyz),
      wx = (2.0 * (v.wy * (-sMxy - xzMyz) + v.wz * (xyMyz - sMxz)) + v.wx * (sMs + yzMyz - xyMxy - xzMxz)),
      wy = (2.0 * (v.wx * (sMxy - xzMyz) + v.wz * (-sMyz - xyMxz)) + v.wy * (sMs + xzMxz - xyMxy - yzMyz)),
      wz = (2.0 * (v.wx * (sMxz + xyMyz) + v.wy * (sMyz - xyMxz)) + v.wz * (sMs + xyMxy - xzMxz - yzMyz)),
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
      i = 0.0,
    )

  infix def reverseSandwich(v: Pga3dVector): Pga3dVector =
    val sMs = s * s
    val sMxy = s * xy
    val sMxz = s * xz
    val sMyz = s * yz
    val xyMxy = xy * xy
    val xyMxz = xy * xz
    val xyMyz = xy * yz
    val xzMxz = xz * xz
    val xzMyz = xz * yz
    val yzMyz = yz * yz
    Pga3dVector(
      x = -(2.0 * (v.y * (sMxy + xzMyz) + v.z * (sMxz - xyMyz)) + v.x * (xyMxy + xzMxz - sMs - yzMyz)),
      y = (2.0 * (v.x * (sMxy - xzMyz) + v.z * (-sMyz - xyMxz)) + v.y * (sMs + xzMxz - xyMxy - yzMyz)),
      z = -(2.0 * (v.x * (-sMxz - xyMyz) + v.y * (xyMxz - sMyz)) + v.z * (xzMxz + yzMyz - sMs - xyMxy)),
    )

  infix def reverseSandwich(v: Pga3dPoint): Pga3dTrivector =
    val sMs = s * s
    val sMxy = s * xy
    val sMxz = s * xz
    val sMyz = s * yz
    val xyMxy = xy * xy
    val xyMxz = xy * xz
    val xyMyz = xy * yz
    val xzMxz = xz * xz
    val xzMyz = xz * yz
    val yzMyz = yz * yz
    Pga3dTrivector(
      x = -(2.0 * (v.y * (sMxy + xzMyz) + v.z * (sMxz - xyMyz)) + v.x * (xyMxy + xzMxz - sMs - yzMyz)),
      y = (2.0 * (v.x * (sMxy - xzMyz) + v.z * (-sMyz - xyMxz)) + v.y * (sMs + xzMxz - xyMxy - yzMyz)),
      z = -(2.0 * (v.x * (-sMxz - xyMyz) + v.y * (xyMxz - sMyz)) + v.z * (xzMxz + yzMyz - sMs - xyMxy)),
      w = (sMs + xyMxy + xzMxz + yzMyz),
    )

  infix def reverseSandwich(v: Pga3dPlaneIdeal): Pga3dPlaneIdeal =
    val sMs = s * s
    val sMxy = s * xy
    val sMxz = s * xz
    val sMyz = s * yz
    val xyMxy = xy * xy
    val xyMxz = xy * xz
    val xyMyz = xy * yz
    val xzMxz = xz * xz
    val xzMyz = xz * yz
    val yzMyz = yz * yz
    Pga3dPlaneIdeal(
      x = (2.0 * (v.y * (-sMxy - xzMyz) + v.z * (xyMyz - sMxz)) + v.x * (sMs + yzMyz - xyMxy - xzMxz)),
      y = (2.0 * (v.x * (sMxy - xzMyz) + v.z * (-sMyz - xyMxz)) + v.y * (sMs + xzMxz - xyMxy - yzMyz)),
      z = (2.0 * (v.x * (sMxz + xyMyz) + v.y * (sMyz - xyMxz)) + v.z * (sMs + xyMxy - xzMxz - yzMyz)),
    )

  infix def reverseSandwich(v: Pga3dBivectorBulk): Pga3dBivectorBulk =
    val sMs = s * s
    val sMxy = s * xy
    val sMxz = s * xz
    val sMyz = s * yz
    val xyMxy = xy * xy
    val xyMxz = xy * xz
    val xyMyz = xy * yz
    val xzMxz = xz * xz
    val xzMyz = xz * yz
    val yzMyz = yz * yz
    Pga3dBivectorBulk(
      xy = (2.0 * (v.xz * (xyMxz - sMyz) + v.yz * (sMxz + xyMyz)) + v.xy * (sMs + xyMxy - xzMxz - yzMyz)),
      xz = (2.0 * (v.xy * (sMyz + xyMxz) + v.yz * (xzMyz - sMxy)) + v.xz * (sMs + xzMxz - xyMxy - yzMyz)),
      yz = (2.0 * (v.xy * (xyMyz - sMxz) + v.xz * (sMxy + xzMyz)) + v.yz * (sMs + yzMyz - xyMxy - xzMxz)),
    )

  infix def reverseSandwich(v: Pga3dBivectorWeight): Pga3dBivectorWeight =
    val sMs = s * s
    val sMxy = s * xy
    val sMxz = s * xz
    val sMyz = s * yz
    val xyMxy = xy * xy
    val xyMxz = xy * xz
    val xyMyz = xy * yz
    val xzMxz = xz * xz
    val xzMyz = xz * yz
    val yzMyz = yz * yz
    Pga3dBivectorWeight(
      wx = (2.0 * (v.wy * (-sMxy - xzMyz) + v.wz * (xyMyz - sMxz)) + v.wx * (sMs + yzMyz - xyMxy - xzMxz)),
      wy = (2.0 * (v.wx * (sMxy - xzMyz) + v.wz * (-sMyz - xyMxz)) + v.wy * (sMs + xzMxz - xyMxy - yzMyz)),
      wz = (2.0 * (v.wx * (sMxz + xyMyz) + v.wy * (sMyz - xyMxz)) + v.wz * (sMs + xyMxy - xzMxz - yzMyz)),
    )

  infix def reverseSandwich(v: Pga3dPseudoScalar): Pga3dPseudoScalar =
    Pga3dPseudoScalar(
      i = v.i * (s * s + xy * xy + xz * xz + yz * yz),
    )

  infix def reverseSandwich(v: Pga3dPointCenter.type): Pga3dTrivector =
    Pga3dTrivector(
      x = 0.0,
      y = 0.0,
      z = 0.0,
      w = (s * s + xy * xy + xz * xz + yz * yz),
    )

  infix def cross(v: Pga3dMotor): Pga3dBivector =
    Pga3dBivector(
      wx = (v.wy * xy + v.wz * xz),
      wy = (v.wz * yz - v.wx * xy),
      wz = (-v.wx * xz - v.wy * yz),
      xy = (v.xz * yz - v.yz * xz),
      xz = (v.yz * xy - v.xy * yz),
      yz = (v.xy * xz - v.xz * xy),
    )

  infix def cross(v: Pga3dPlane): Pga3dPlaneIdeal =
    Pga3dPlaneIdeal(
      x = (v.y * xy + v.z * xz),
      y = (v.z * yz - v.x * xy),
      z = (-v.x * xz - v.y * yz),
    )

  infix def cross(v: Pga3dBivector): Pga3dBivector =
    Pga3dBivector(
      wx = (v.wy * xy + v.wz * xz),
      wy = (v.wz * yz - v.wx * xy),
      wz = (-v.wx * xz - v.wy * yz),
      xy = (v.xz * yz - v.yz * xz),
      xz = (v.yz * xy - v.xy * yz),
      yz = (v.xy * xz - v.xz * xy),
    )

  infix def cross(v: Pga3dTrivector): Pga3dVector =
    Pga3dVector(
      x = (v.y * xy + v.z * xz),
      y = (v.z * yz - v.x * xy),
      z = (-v.x * xz - v.y * yz),
    )

  infix def cross(v: Pga3dQuaternion): Pga3dBivectorBulk =
    Pga3dBivectorBulk(
      xy = (v.xz * yz - v.yz * xz),
      xz = (v.yz * xy - v.xy * yz),
      yz = (v.xy * xz - v.xz * xy),
    )

  infix def cross(v: Pga3dTranslator): Pga3dBivectorWeight =
    Pga3dBivectorWeight(
      wx = (v.wy * xy + v.wz * xz),
      wy = (v.wz * yz - v.wx * xy),
      wz = (-v.wx * xz - v.wy * yz),
    )

  infix def cross(v: Pga3dVector): Pga3dVector =
    Pga3dVector(
      x = (v.y * xy + v.z * xz),
      y = (v.z * yz - v.x * xy),
      z = (-v.x * xz - v.y * yz),
    )

  infix def cross(v: Pga3dPoint): Pga3dVector =
    Pga3dVector(
      x = (v.y * xy + v.z * xz),
      y = (v.z * yz - v.x * xy),
      z = (-v.x * xz - v.y * yz),
    )

  infix def cross(v: Pga3dPlaneIdeal): Pga3dPlaneIdeal =
    Pga3dPlaneIdeal(
      x = (v.y * xy + v.z * xz),
      y = (v.z * yz - v.x * xy),
      z = (-v.x * xz - v.y * yz),
    )

  infix def cross(v: Pga3dBivectorBulk): Pga3dBivectorBulk =
    Pga3dBivectorBulk(
      xy = (v.xz * yz - v.yz * xz),
      xz = (v.yz * xy - v.xy * yz),
      yz = (v.xy * xz - v.xz * xy),
    )

  infix def cross(v: Pga3dBivectorWeight): Pga3dBivectorWeight =
    Pga3dBivectorWeight(
      wx = (v.wy * xy + v.wz * xz),
      wy = (v.wz * yz - v.wx * xy),
      wz = (-v.wx * xz - v.wy * yz),
    )


object Pga3dQuaternion:

  inline val componentsCount = 4

  val id: Pga3dQuaternion = Pga3dQuaternion(1.0, 0.0, 0.0, 0.0)

  def rotation(from: Pga3dPlaneIdeal, to: Pga3dPlaneIdeal): Pga3dQuaternion = {
    val norm = Math.sqrt(from.normSquare * to.normSquare)
    val q2a = to.geometric(from) / norm
    val dot = q2a.s

    if (dot > -1.0 + 1e-6) {
      val newCos = Math.sqrt((1.0 + dot) / 2)
      val newSinDivSin2 = 0.5 / newCos
      return Pga3dQuaternion(newCos, q2a.xy * newSinDivSin2, q2a.xz * newSinDivSin2, q2a.yz * newSinDivSin2)
    }

    val sin2a = Math.sqrt(q2a.xy * q2a.xy + q2a.xz * q2a.xz + q2a.yz * q2a.yz)

    if (sin2a > 1e-8) {
      val angle2 = Math.atan2(sin2a, q2a.s)
      val propAngle = angle2 * 0.5
      val mult = Math.sin(propAngle) / sin2a
      return Pga3dQuaternion(Math.cos(propAngle), q2a.xy * mult, q2a.xz * mult, q2a.yz * mult).normalizedByNorm
    }

    // choose any axis
    val orthogonalPlane =
      if (Math.abs(from.x) > Math.abs(from.z)) Pga3dPlaneIdeal(-from.y, from.x, 0)
      else Pga3dPlaneIdeal(0, -from.z, from.y)

    Pga3dQuaternion(0, orthogonalPlane.z, -orthogonalPlane.y, orthogonalPlane.x).normalizedByNorm
  }

  def rotation(from: Pga3dVector, to: Pga3dVector): Pga3dQuaternion =
    rotation(from.dual, to.dual)