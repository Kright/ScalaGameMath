package com.kright.math

/**
 * I used the book:
 * F. Dunn, I. Parberry - 3D Math Primer for Graphics and Game Development
 */
trait IQuaternion:
  def w: Double
  def x: Double
  def y: Double
  def z: Double

  def *(q: IQuaternion): Quaternion =
    Quaternion.multiply(this, q)

  def mag: Double =
    math.sqrt(w * w + x * x + y * y + z * z)

  def magXYZ: Double =
    math.sqrt(x * x + y * y + z * z)

  def dot(q: IQuaternion): Double =
    w * q.w + x * q.x + y * q.y + z * q.z

  def cos(q: IQuaternion): Double =
    dot(q) / (mag * q.mag)

  /** rotation axis with length of 0.5*angle in radians */
  def getLog(result: Vector3d = new Vector3d): Vector3d =
    val xyz = magXYZ
    val angle2 = math.atan2(xyz, w)
    val mul = angle2 / xyz
    result := (x * mul, y * mul, z * mul)
    result

  def rotationAngleRadians(): Double =
    2.0 * Math.acos(w / mag)

  def rotationAngleRadiansForNormalized(): Double =
    2.0 * Math.acos(w)

  def getRotationAxis(result: Vector3d = new Vector3d()): Vector3d =
    result := (x, y, z)
    result.normalize()
    result

  def isEquals(q: IQuaternion, eps: Double = 0.000001): Boolean =
    inline def eq(a: Double, b: Double) = math.abs(a - b) < eps
    if (eq(w, q.w)) {
      eq(x, q.x) && eq(y, q.y) && eq(z, q.z)
    } else {
      eq(w, -q.w) && eq(x, -q.x) && eq(y, -q.y) && eq(z, -q.z)
    }



final class Quaternion(var w: Double,
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
    val m = math.sin(realAngle) / axis.mag
    this := (math.cos(realAngle), axis.x * m, axis.y * m, axis.z * m)

  def setIdentity(): Quaternion =
    this := (1.0, 0.0, 0.0, 0.0)

  /** exponent length is 0.5*angle of rotation */
  def setFromExp(exp: IVector3d): Quaternion =
    val l = exp.mag
    val m = math.sin(l) / l
    this := (math.cos(l), exp.x * m, exp.y * m, exp.z * m)

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

  def ^(pow: Double): Quaternion =
    val xyz = magXYZ
    val alpha = pow * math.atan2(xyz, w)
    val m = math.sin(alpha) / xyz
    this := (math.cos(alpha), x * m, y * m, z * m)

  override def toString: String =
    s"Quaternion(w=$w, x=$x, y=$y, z=$z)"


object Quaternion:
  def multiply(first: IQuaternion, second: IQuaternion, result: Quaternion = new Quaternion()): Quaternion =
    result := (
      first.w * second.w - first.x * second.x - first.y * second.y - first.z * second.z,
      first.w * second.x + first.x * second.w + first.y * second.z - first.z * second.y,
      first.w * second.y + first.y * second.w + first.z * second.x - first.x * second.z,
      first.w * second.z + first.z * second.w + first.x * second.y - first.y * second.x
    )
    result

  def mix(q1: IQuaternion, k1: Double, q2: IQuaternion, k2: Double, result: Quaternion = new Quaternion()): Quaternion =
    result := (
      q1.w * k1 + q2.w * k2,
      q1.x * k1 + q2.x * k2,
      q1.y * k1 + q2.y * k2,
      q1.z * k1 + q2.z * k2
    )
    result

  /**
   * spherical linear interpolation.
   * works only for normalized quaternions
   */
  def slerp(q1: IQuaternion, q2: Quaternion, t: Double, result: Quaternion = new Quaternion()): Quaternion =
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
    val linearCriteria = 0.8f
    //if angle small, cosine is big, and we use linear interpolation
    if (cosOmega > linearCriteria) {
      mix(q1, 1 - t, q2, t, result)
      return result
    }
    //copy-paste code from page 213
    val sinOmega = math.sqrt(1.0 - cosOmega * cosOmega)
    val omega = Math.atan2(sinOmega, cosOmega)
    val mult = 1.0 / sinOmega
    val k0 = math.sin((1f - t) * omega) * mult
    val k1 = math.sin(t * omega) * mult
    mix(q1, k0, q2, k1, result)

  /**
   * linear interpolation. Really faster then spherical
   */
  def lerp(q1: Quaternion, q2: Quaternion, t: Float, result: Quaternion = new Quaternion()): Quaternion =
    if (q1.dot(q2) >= 0) {
      mix(q1, 1 - t, q2, t, result)
    } else {
      mix(q1, 1 - t, q2, -t, result)
    }
    result
