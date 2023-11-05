package com.kright.physics3d

import com.kright.math.{IVector3d, IVectorNd, Vector3d}

object Invariants:
  /**
   * class calculating for system of bodies:
   * * linear impulse (P = m v)
   * * angular impulse (momentum, L = r x P)
   * * center of mass
   * * total mass of all bodies
   */
  class Impulse3dAccumulator:
    val massAndCenter: MassAndCenter = MassAndCenter()
    private val _linearImpulse = Vector3d()
    private val _angularImpulse = Vector3d()

    def add(inertia: Inertia3d, state3d: State3d): Unit =
      val position = state3d.transform.position
      val mass = inertia.mass

      massAndCenter.add(mass, position)
      _linearImpulse.madd(state3d.velocity.linear, mass)

      _angularImpulse += inertia.getL(state3d)
      // += r cross P
      _angularImpulse.madd(position.cross(state3d.velocity.linear), mass)

    def reset(): Unit =
      massAndCenter.reset()
      _linearImpulse := (0.0, 0.0, 0.0)
      _angularImpulse := (0.0, 0.0, 0.0)

    def linearImpulse: Vector3d =
      _linearImpulse.copy()

    def angularImpulse: Vector3d =
      _angularImpulse - massAndCenter.center.cross(linearImpulse)

    def impulse: Impulse3d =
      Impulse3d(linearImpulse, angularImpulse)

    def mass: Double =
      massAndCenter.mass

    def center: Vector3d =
      massAndCenter.center

    override def toString: String =
      s"Impulse3dAccumulator(mass = ${massAndCenter.mass}, center = ${massAndCenter.center}, impulse = $impulse)"

  /**
   * Class calculating for system of bodies:
   * * center of mass
   * * total mass
   */
  class MassAndCenter:
    private var _mass: Double = 0.0
    private val massR: Vector3d = Vector3d()

    def add(mass: Double, position: IVector3d): Unit =
      _mass += mass
      massR.madd(position, mass)

    def reset(): Unit =
      _mass = 0.0
      massR := (0.0, 0.0, 0.0)

    def mass: Double = _mass

    def center: Vector3d =
      if (_mass != 0.0) massR / _mass
      else Vector3d()

    override def toString: String = s"MassAndCenter(mass = $mass, center = $center)"
