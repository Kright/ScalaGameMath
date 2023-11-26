package com.kright.physics3d

import com.kright.math.{Quaternion, Vector3d}

/**
 * Body orientation is described as Quaternion, but rotation velocity described as vector.
 *
 * For solvers with 4-th order of precision this difference is important and derivative of orientation should be
 * Quaternion too (otherwise precision will be limited to second order).
 *
 * So derivative of (rotation: Quaternion, velocity: Vector3d) is (velocity: Quaternion, acceleration: Vector3d)
 * and not (velocity: Vector3d, acceleration: Vector3d)
 *
 * I reuse [[State3d]] for such purpose.
 */
object State3dDerivative:
  /**
   * key difference from [[State3d]] constructor is in zero Quaternion
   */
  def apply(): State3d =
    State3d(Transform3d(Vector3d(), Quaternion.zero), Velocity3d(Vector3d(), Vector3d()))

  def apply(state: State3d, inertia: Inertia3d, force: Force3d): State3d =
    val acc = inertia.getAcceleration(state, force)
    // dq = 0.5 * w * q
    val qDerivative: Quaternion = 0.5 * Quaternion(state.velocity.angular) * state.transform.rotation
    State3d(
      Transform3d(state.velocity.linear, qDerivative),
      Velocity3d(acc.linear, acc.angular)
    )
