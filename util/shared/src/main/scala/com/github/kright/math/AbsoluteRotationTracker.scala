package com.github.kright.math

import com.github.kright.math.AbsoluteRotationTracker.*

/**
 * Tracks rotations count
 * There should be no more than half of the turnover between calls to `update`
 *
 * Position of zero could be reset with [[resetAbsolute]]
 *
 * @param rotations       is stored in rotations, not in radians
 * @param rotationsOffset is stored in rotations in the interval [0, 1)
 */
class AbsoluteRotationTracker(var rotations: Double = 0.0,
                              var rotationsOffset: Double = 0.0):

  /**
   * @return angle in radians
   */
  def absolute: Double =
    toRadians(rotations + rotationsOffset)

  /**
   * resets rotations and rotationsOffset, so absolute becomes equal newAbsoluteInRadians
   */
  def resetAbsolute(newAbsoluteInRadians: Double): Unit =
    setNewOffset(toRotations(newAbsoluteInRadians) - rotations)

  private def setNewOffset(newOffset: Double): Unit = {
    val floor = newOffset.floor
    rotationsOffset = newOffset - floor
    rotations += floor
  }

  /**
   * newAngleInRadians could have any value and will be wrapped into an interval of length 2 * PI
   */
  def update(newAngleInRadians: Double): Unit =
    val wrappedNewAngle = getWrapped(newAngleInRadians * tauDiv)
    val wrappedOldAngle = getWrapped(rotations)

    // diff is in [-1, 1]
    val diff = wrappedNewAngle - wrappedOldAngle
    rotations += diff

    if (diff > 0.5) {
      rotations -= 1.0
    } else if (diff < -0.5) {
      rotations += 1.0
    }


object AbsoluteRotationTracker:
  inline val tau = math.Pi * 2
  inline val tauDiv = 1.0 / tau

  def toRotations(angleInRadians: Double): Double =
    angleInRadians * tauDiv

  def toRadians(angleInRotations: Double): Double =
    angleInRotations * tau

  /**
   * @return wrapped angle in interval [0, 1)
   */
  private def getWrapped(angleInRotations: Double): Double =
    angleInRotations - angleInRotations.floor
