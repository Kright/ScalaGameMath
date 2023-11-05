package com.kright.physics3d

import com.kright.math.{IVector3d, IVectorNd, Vector3d}

object Invariants:
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
