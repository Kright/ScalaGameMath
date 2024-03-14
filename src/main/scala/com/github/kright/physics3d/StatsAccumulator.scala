package com.github.kright.physics3d

import com.github.kright.math.Vector3d


/**
 * class calculating physics invariants for system of bodies:
 * * linear impulse (P = m v)
 * * angular impulse (momentum, L = r x P)
 * * center of mass
 * * total mass of all bodies
 * * total kinetic energy
 */
class StatsAccumulator:
  private var _mass: Double = 0.0
  private var _kineticEnergy: Double = 0.0
  private val _massR: Vector3d = Vector3d()
  private val _linearImpulse = Vector3d()
  private val _angularImpulse = Vector3d()

  def add(inertia: Inertia3d, state3d: State3d): Unit =
    val position = state3d.transform.position
    val mass = inertia.mass
    val velocity = state3d.velocity

    _mass += mass
    _massR.madd(position, mass)
    _linearImpulse.madd(velocity.linear, mass)
    // += m v

    val L = inertia.getL(state3d)
    _angularImpulse += L
    _kineticEnergy += 0.5 * (velocity.angular.dot(L) + mass * velocity.linear.squareMag)
    // += 0.5 * (w dot L + m v^2)
    _angularImpulse.madd(position.cross(velocity.linear), mass)
  // += r x P

  def reset(): Unit =
    _mass = 0.0
    _kineticEnergy = 0.0
    _massR := (0.0, 0.0, 0.0)
    _linearImpulse := (0.0, 0.0, 0.0)
    _angularImpulse := (0.0, 0.0, 0.0)

  def mass: Double =
    _mass

  def kineticEnergy: Double =
    _kineticEnergy

  def linearImpulse: Vector3d =
    _linearImpulse.copy()

  def center: Vector3d =
    if (_mass != 0.0) _massR / _mass
    else Vector3d()

  def centerVelocity: Vector3d =
    if (_mass != 0.0) linearImpulse / _mass
    else Vector3d()

  def angularImpulse: Vector3d =
    _angularImpulse - center.cross(linearImpulse)

  def impulse: Impulse3d =
    Impulse3d(linearImpulse, angularImpulse)

  override def toString: String =
    s"Impulse3dAccumulator(mass = $mass, center = $center, linearImpulse = $linearImpulse, angularImpulse = $angularImpulse, kineticEnergy = ${kineticEnergy})"

object StatsAccumulator:
  def apply(): StatsAccumulator =
    new StatsAccumulator()

  def apply(init: StatsAccumulator => Unit): StatsAccumulator =
    val acc = new StatsAccumulator()
    init(acc)
    acc