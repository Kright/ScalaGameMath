package com.github.kright.math


/**
 * @param yaw   - angle in radians around axis Y (up)
 * @param pitch - angle in radians around axis X (right)
 * @param roll  - angle in radians around axis Z (forward)
 */
case class EulerAngles(var yaw: Double,
                       var pitch: Double,
                       var roll: Double) extends IEqualsWithEps[EulerAngles]:
  def :=(yaw: Double, pitch: Double, roll: Double): EulerAngles =
    this.yaw = yaw
    this.pitch = pitch
    this.roll = roll
    this

  def :=(q: Quaternion): EulerAngles =
    EulerAngles.restoreFromRotation(q, this)

  def setFromRotation(m: Matrix3d): EulerAngles =
    EulerAngles.restoreFromRotation(m, this)

  def setFromRotation(m: Matrix4d): EulerAngles =
    EulerAngles.restoreFromRotation(m, this)


  override def isEquals(e: EulerAngles, eps: Double): Boolean =
    Math.abs(yaw - e.yaw) < eps &&
      Math.abs(pitch - e.pitch) < eps &&
      Math.abs(roll - e.roll) < eps

  /** print angles in degrees */
  override def toString: String =
    inline def d(rads: Double) = f"${Math.toDegrees(rads)}%1.1f"

    f"EulerAngles(yaw=${d(yaw)}, pitch=${d(pitch)}, roll=${d(roll)})"

object EulerAngles:
  inline def apply(): EulerAngles = new EulerAngles(0.0, 0.0, 0.0)

  inline def fromDegrees(yaw: Double, pitch: Double, roll: Double): EulerAngles =
    new EulerAngles(
      Math.toRadians(yaw),
      Math.toRadians(pitch),
      Math.toRadians(roll),
    )

  def restoreFromRotation(m: Matrix3d, result: EulerAngles): EulerAngles =
    restoreFromRotation(m(0, 0), m(0, 2), m(1, 0), m(1, 1), m(1, 2), m(2, 0), m(2, 2), result)

  def restoreFromRotation(m: Matrix4d, result: EulerAngles): EulerAngles =
    restoreFromRotation(m(0, 0), m(0, 2), m(1, 0), m(1, 1), m(1, 2), m(2, 0), m(2, 2), result)

  def restoreFromRotation(q: Quaternion, result: EulerAngles): EulerAngles =
    restoreFromRotation(q.rotM00, q.rotM02, q.rotM10, q.rotM11, q.rotM12, q.rotM20, q.rotM22, result)

  private inline def restoreFromRotation(inline m00: => Double,
                                         inline m02: => Double,
                                         inline m10: => Double,
                                         inline m11: => Double,
                                         inline m12: => Double,
                                         inline m20: => Double,
                                         inline m22: => Double,
                                         result: EulerAngles): EulerAngles =
    val sp = -m12

    if (sp > 0.999999) {
      result := (
        yaw = Math.atan2(-m20, m00),
        pitch = if (sp >= 1.0) 0.5 * Math.PI else Math.asin(sp),
        roll = 0.0
      )
    } else if (sp < -0.999999) {
      result := (
        yaw = Math.atan2(-m20, m00),
        pitch = if (sp <= -1.0) -0.5 * Math.PI else Math.asin(sp),
        roll = 0.0
      )
    } else {
      result := (
        yaw = Math.atan2(m02, m22),
        pitch = Math.asin(sp),
        roll = Math.atan2(m10, m11)
      )
    }
