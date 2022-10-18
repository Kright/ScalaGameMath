package com.kright.math

import scala.annotation.static

/**
 * I used the book:
 * F. Dunn, I. Parberry - 3D Math Primer for Graphics and Game Development
 */
trait IQuaternion:
  def w: Double
  def x: Double
  def y: Double
  def z: Double

  def copy(): Quaternion =
    Quaternion(w, x, y, z)

  def conjugated(): Quaternion =
    Quaternion(w, -x, -y, -z)

  def normalized(): Quaternion =
    val m = 1.0 / mag
    Quaternion(w * m, x * m, y * m, z * m)

  def safeNormalized(): Quaternion =
    val selfMag = mag
    if (selfMag < 0.000001) {
      Quaternion()
    } else {
      val m = 1.0 / mag
      Quaternion(w * m, x * m, y * m, z * m)
    }

  def *(q: IQuaternion): Quaternion =
    Quaternion.multiply(this, q, result = Quaternion())

  def *>(q: Quaternion): Quaternion =
    Quaternion.multiply(this, q, result = q)

  def *(v: IVector3d, result: Vector3d = Vector3d()): Vector3d =
    Quaternion.multiply(this, v, result)

  def *>(v: Vector3d): Vector3d =
    Quaternion.multiply(this, v, v)

  def ^(pow: Double): Quaternion =
    copy() ^= pow

  def squareMag: Double =
    w * w + x * x + y * y + z * z

  def mag: Double =
    Math.sqrt(w * w + x * x + y * y + z * z)

  def magXYZ: Double =
    Math.sqrt(x * x + y * y + z * z)

  def dot(q: IQuaternion): Double =
    w * q.w + x * q.x + y * q.y + z * q.z

  def cos(q: IQuaternion): Double =
    dot(q) / Math.sqrt(squareMag * q.squareMag)

  /** rotation axis with length of 0.5*angle in radians */
  def getLog(result: Vector3d = Vector3d()): Vector3d =
    val xyz = magXYZ
    if (xyz < 0.000001) return result := (0, 0, 0)
    val angle2 = Math.atan2(xyz, w)
    val mul = angle2 / xyz
    result := (x * mul, y * mul, z * mul)

  def rotationAngleRadians(): Double =
    2.0 * Math.acos(w / mag)

  def rotationAngleRadiansForNormalized(): Double =
    2.0 * Math.acos(w)

  def getRotationAxis(result: Vector3d = Vector3d()): Vector3d =
    val div = magXYZ
    if (div > 0.000001) {
      val m = 1.0 / div
      result := (x * m, y * m, z * m)
    } else { // no rotation
      result := (1, 0, 0)
    }

  def getX(result: Vector3d = Vector3d()): Vector3d =
    result := (rotM00, rotM01, rotM02)

  def getY(result: Vector3d = Vector3d()): Vector3d =
    result := (rotM10, rotM11, rotM12)

  def getZ(result: Vector3d = Vector3d()): Vector3d =
    result := (rotM20, rotM21, rotM22)

  def isEquals(q: IQuaternion, eps: Double = 0.000001): Boolean =
    inline def eq(a: Double, b: Double) = Math.abs(a - b) < eps
    if (eq(w, q.w)) {
      eq(x, q.x) && eq(y, q.y) && eq(z, q.z)
    } else {
      eq(w, -q.w) && eq(x, -q.x) && eq(y, -q.y) && eq(z, -q.z)
    }

  def rotM00: Double = 1.0 - 2.0f * (y * y + z * z)
  def rotM01: Double = 2.0 * (x * y - w * z)
  def rotM02: Double = 2.0 * (x * z + w * y)
  def rotM10: Double = 2.0 * (x * y + w * z)
  def rotM11: Double = 1.0 - 2.0f * (x * x + z * z)
  def rotM12: Double = 2.0 * (y * z - w * x)
  def rotM20: Double = 2.0 * (x * z - w * y)
  def rotM21: Double = 2.0 * (y * z + w * x)
  def rotM22: Double = 1.0 - 2.0 * (x * x + y * y)


final case class Quaternion(var w: Double,
                            var x: Double,
                            var y: Double,
                            var z: Double) extends IQuaternion:

  def this() = this(1.0, 0.0, 0.0, 0.0)

  def :=(w: Double, x: Double, y: Double, z: Double): Quaternion =
    this.w = w
    this.x = x
    this.y = y
    this.z = z
    this

  def :=(v: IQuaternion): Quaternion =
    w = v.w
    x = v.x
    y = v.y
    z = v.z
    this

  def :=(angleRadians: Double, axis: IVector3d): Quaternion =
    val realAngle = angleRadians * 0.5
    val m = Math.sin(realAngle) / axis.mag
    this := (Math.cos(realAngle), axis.x * m, axis.y * m, axis.z * m)

  def :=(euler: EulerAngles): Quaternion =
    val cy = Math.cos(0.5 * euler.yaw)
    val sy = Math.sin(0.5 * euler.yaw)
    val cp = Math.cos(0.5 * euler.pitch)
    val sp = Math.sin(0.5 * euler.pitch)
    val cr = Math.cos(0.5 * euler.roll)
    val sr = Math.sin(0.5 * euler.roll)

    // yaw   axis Z
    // pitch axis Y
    // roll  axis X

    this := (
      cr * cp * cy + sr * sp * sy, // w
      cr * sp * cy + sr * cp * sy, // y 
      cr * cp * sy - sr * sp * cy, // z 
      sr * cp * cy - cr * sp * sy, // x
    )

  def setIdentity(): Quaternion =
    this := (1.0, 0.0, 0.0, 0.0)

  /** exponent length is 0.5*angle of rotation */
  def setFromExp(exp: IVector3d): Quaternion =
    val l = exp.mag
    val m = Math.sin(l) / l
    this := (Math.cos(l), exp.x * m, exp.y * m, exp.z * m)

  def setFromRotation(m: Matrix3d): Quaternion =
    Quaternion.restoreFromRotation(m, this)

  def setFromRotation(m: Matrix4d): Quaternion =
    Quaternion.restoreFromRotation(m, this)

  def conjugate(): Quaternion =
    x = -x
    y = -y
    z = -z
    this

  def negate(): Quaternion =
    w = -w
    x = -x
    y = -y
    z = -z
    this

  def *=(m: Double): Quaternion =
    w *= m
    x *= m
    y *= m
    z *= m
    this

  def *=(q: Quaternion): Quaternion =
    Quaternion.multiply(this, q, result = this)

  def normalize(): Quaternion =
    this *= 1.0 / mag

  def ^=(pow: Double): Quaternion =
    val xyz = magXYZ
    if (xyz < 0.000001) return this // no rotation
    val alpha = pow * Math.atan2(xyz, w)
    val m = Math.sin(alpha) / xyz
    this := (Math.cos(alpha), x * m, y * m, z * m)

  override def toString: String =
    f"Quaternion(w=$w%1.3f, x=$x%1.3f, y=$y%1.3f, z=$z%1.3f)"


object Quaternion:
  inline def apply(): Quaternion = new Quaternion()

  // 16 multiplications, 12 additions
  @static def multiply(first: IQuaternion, second: IQuaternion, result: Quaternion): Quaternion =
    result := (
      first.w * second.w - first.x * second.x - first.y * second.y - first.z * second.z,
      first.w * second.x + first.x * second.w + first.y * second.z - first.z * second.y,
      first.w * second.y + first.y * second.w + first.z * second.x - first.x * second.z,
      first.w * second.z + first.z * second.w + first.x * second.y - first.y * second.x
    )

  @static def mix(q1: IQuaternion, k1: Double, q2: IQuaternion, k2: Double, result: Quaternion = new Quaternion()): Quaternion =
    result := (
      q1.w * k1 + q2.w * k2,
      q1.x * k1 + q2.x * k2,
      q1.y * k1 + q2.y * k2,
      q1.z * k1 + q2.z * k2
    )

  /**
   * spherical linear interpolation.
   * works only for normalized quaternions
   */
  @static def slerp(q1: IQuaternion, q2: Quaternion, t: Double, result: Quaternion = new Quaternion()): Quaternion =
    if (t < 0) {
      result := q1
      return result
    }
    if (t > 1) {
      result := q2
      return result
    }
    var cosOmega = q1.dot(q2)
    if (cosOmega < 0.0) {
      q2.negate()
      cosOmega = -cosOmega
    }
    val linearCriteria = 0.9999f
    //if angle small, cosine is big, and we use linear interpolation
    if (cosOmega > linearCriteria) {
      mix(q1, 1 - t, q2, t, result)
      return result
    }
    //copy-paste code from page 213
    val sinOmega = Math.sqrt(1.0 - cosOmega * cosOmega)
    val omega = Math.atan2(sinOmega, cosOmega)
    val mult = 1.0 / sinOmega
    val k1 = Math.sin((1f - t) * omega) * mult
    val k2 = Math.sin(t * omega) * mult
    mix(q1, k1, q2, k2, result)

  /**
   * linear interpolation. Really faster then spherical
   */
  @static def lerp(q1: Quaternion, q2: Quaternion, t: Float, result: Quaternion = new Quaternion()): Quaternion =
    if (q1.dot(q2) >= 0) {
      mix(q1, 1 - t, q2, t, result)
    } else {
      mix(q1, 1 - t, q2, -t, result)
    }
    result

  @static def multiply(q: IQuaternion, v: IVector3d, result: Vector3d): Vector3d =
    // val r = q * Quaternion(0.0, v.x, v.y, v.z) * q.conjugated()
    // result := (r.x, r.y, r.z)

    result := (
      v.x * q.rotM00 + v.y * q.rotM01 + v.z * q.rotM02,
      v.x * q.rotM10 + v.y * q.rotM11 + v.z * q.rotM12,
      v.x * q.rotM20 + v.y * q.rotM21 + v.z * q.rotM22,
    )

  @static def restoreFromRotation(m: Matrix3d, result: Quaternion): Quaternion =
    val m00 = m(0, 0)
    val m11 = m(1, 1)
    val m22 = m(2, 2)
    val tr = m00 + m11 + m22
    val max = Math.max(tr, Math.max(m00, Math.max(m11, m22)))
    if (tr == max) {
      val w = Math.sqrt(1.0 + m00 + m11 + m22)
      return result := (
        0.5 * w,
        0.5 * (m(2, 1) - m(1, 2)) / w,
        0.5 * (m(0, 2) - m(2, 0)) / w,
        0.5 * (m(1, 0) - m(0, 1)) / w,
      )
    }
    if (m00 == max) {
      val d = Math.sqrt(1.0 + m00 - m11 - m22)
      return result := (
        0.5 * (m(2, 1) - m(1, 2)) / d,
        0.5 * d,
        0.5 * (m(0, 1) + m(1, 0)) / d,
        0.5 * (m(2, 0) + m(0, 2)) / d,
        )
    }
    if (m11 == max) {
      val d = Math.sqrt(1.0 - m00 + m11 - m22)
      return result := (
        0.5 * (m(0, 2) - m(2, 0)) / d,
        0.5 * (m(0, 1) + m(1, 0)) / d,
        0.5 * d,
        0.5 * (m(1, 2) + m(2, 1)) / d
      )
    }
    // qz2 == max
    {
      val d = Math.sqrt(1.0 - m00 - m11 + m22)
      return result := (
        0.5 * (m(1, 0) - m(0, 1)) / d,
        0.5 * (m(2, 0) + m(0, 2)) / d,
        0.5 * (m(2, 1) + m(1, 2)) / d,
        0.5 * d
      )
    }

  @static def restoreFromRotation(m: Matrix4d, result: Quaternion): Quaternion =
    val m00 = m(0, 0)
    val m11 = m(1, 1)
    val m22 = m(2, 2)
    val tr = m00 + m11 + m22
    val max = Math.max(tr, Math.max(m00, Math.max(m11, m22)))
    if (tr == max) {
      val w = Math.sqrt(1.0 + m00 + m11 + m22)
      return result := (
        0.5 * w,
        0.5 * (m(2, 1) - m(1, 2)) / w,
        0.5 * (m(0, 2) - m(2, 0)) / w,
        0.5 * (m(1, 0) - m(0, 1)) / w,
      )
    }
    if (m00 == max) {
      val d = Math.sqrt(1.0 + m00 - m11 - m22)
      return result := (
        0.5 * (m(2, 1) - m(1, 2)) / d,
        0.5 * d,
        0.5 * (m(0, 1) + m(1, 0)) / d,
        0.5 * (m(2, 0) + m(0, 2)) / d,
      )
    }
    if (m11 == max) {
      val d = Math.sqrt(1.0 - m00 + m11 - m22)
      return result := (
        0.5 * (m(0, 2) - m(2, 0)) / d,
        0.5 * (m(0, 1) + m(1, 0)) / d,
        0.5 * d,
        0.5 * (m(1, 2) + m(2, 1)) / d
      )
    }
    // qz2 == max
    {
      val d = Math.sqrt(1.0 - m00 - m11 + m22)
      return result := (
        0.5 * (m(1, 0) - m(0, 1)) / d,
        0.5 * (m(2, 0) + m(0, 2)) / d,
        0.5 * (m(2, 1) + m(1, 2)) / d,
        0.5 * d
      )
    }