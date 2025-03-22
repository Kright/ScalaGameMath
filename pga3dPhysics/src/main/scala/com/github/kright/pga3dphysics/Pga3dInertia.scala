package com.github.kright.pga3dphysics

import com.github.kright.pga3d.*

/**
 * class with useful constructor methods for base classes
 */
object Pga3dInertia:
  def cube(mass: Double, r: Double) = Pga3dInertiaSimple.cube(mass, r)

  def sphere(mass: Double, r: Double) = Pga3dInertiaSimple.sphere(mass, r)

  def solidSphere(mass: Double, r: Double) = Pga3dInertiaSimple.solidSphere(mass, r)

  def cube(mass: Double, rx: Double, ry: Double, rz: Double) = Pga3dInertiaLocal.cube(mass, rx, ry, rz)

  def moved(motor: Pga3dMotor, inertia: Pga3dInertiaLocal) = Pga3dInertiaMoved(motor, inertia)