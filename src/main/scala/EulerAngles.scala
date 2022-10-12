package com.kright.math

/**
 * @param yaw   - angle in radians around axis Y (up)
 * @param pitch - angle in radians around axis X (right)
 * @param roll  - angle in radians around axis Z (forward)
 */
case class EulerAngles(yaw: Double, pitch: Double, roll: Double)

object EulerAngles:
  inline def fromDegrees(yaw: Double, pitch: Double, roll: Double): EulerAngles =
    new EulerAngles(
      Math.toRadians(yaw),
      Math.toRadians(pitch),
      Math.toRadians(roll),
    )
