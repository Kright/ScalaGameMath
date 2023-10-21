package com.kright.physics3d
import com.kright.math.Quaternion

class State3dDerivative(val velocity: Velocity3d,
                        val acceleration: Acceleration3d):
  def this() = this(Velocity3d(), Acceleration3d())

  def madd(s: State3dDerivative, m: Double): State3dDerivative =
    velocity.madd(s.velocity, m)
    acceleration.madd(s.acceleration, m)
    this

  override def toString: String =
    s"State3dDerivative($velocity, $acceleration)"

object State3dDerivative:
  def apply(state: State3d, inertia: Inertia3d, force: Force3d): State3d =
    // for Runge-Kutta 4 method it's better to use this 'derivative',
    // it gives to achieve 4rth order of precision
    val acc = inertia.getAcceleration(state, force)
    // dq = 0.5 * w * q
    val qDerivative: Quaternion = 0.5 * Quaternion(state.velocity.angular) * state.transform.rotation
    State3d(
      Transform3d(state.velocity.linear, qDerivative),
      Velocity3d(acc.linear, acc.angular)
    )

  def simple(state: State3d, inertia: Inertia3d, force: Force3d): State3dDerivative =
    // ok for Runge-Kutta 2, euler and other solvers, not suitable for RK4
    val acc = inertia.getAcceleration(state, force)
    new State3dDerivative(state.velocity, acc)
