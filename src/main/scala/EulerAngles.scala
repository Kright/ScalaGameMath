package com.kright.math

/**
 * @param yaw   - angle in radians along Z axis
 * @param pitch - angle in radians along Y axis
 * @param roll  - angle in radians along X axis
 */
case class EulerAngles(yaw: Double, pitch: Double, roll: Double) 

object EulerAngles:
  inline def fromDegrees(yaw: Double, pitch: Double, roll: Double): EulerAngles =
    new EulerAngles(
      Math.toRadians(yaw), 
      Math.toRadians(pitch), 
      Math.toRadians(roll), 
    )
