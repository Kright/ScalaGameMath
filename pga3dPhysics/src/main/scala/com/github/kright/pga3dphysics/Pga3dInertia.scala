package com.github.kright.pga3dphysics

import com.github.kright.pga3d.*

trait Pga3dInertia:

  def mass: Double

  def centerOfMass: Pga3dPoint

  def centerOfMassTrivector: Pga3dTrivector


  def apply(velocity: Pga3dBivector): Pga3dBivector

  def invert(localInertia: Pga3dBivector): Pga3dBivector

  def getAcceleration(velocity: Pga3dBivector, forque: Pga3dBivector): Pga3dBivector =
    invert(velocity.cross(apply(velocity)) + forque)

  def getKineticEnergy(velocity: Pga3dBivector): Double =
    (velocity v apply(velocity)) * 0.5


  def toInertiaMovedLocal: Pga3dInertiaMovedLocal

  def toSummable: Pga3dInertiaSummable

  def toPrecomputed: Pga3dInertiaPrecomputed

  def toFastestRepresentation: Pga3dInertia = toPrecomputed


  def movedBy(motor: Pga3dMotor): Pga3dInertia

  def movedBy(translator: Pga3dTranslator): Pga3dInertia

  def movedBy(quaternion: Pga3dQuaternion): Pga3dInertia


/**
 * class with useful constructor methods for base classes
 */
object Pga3dInertia:
  def cube(mass: Double, r: Double) = Pga3dInertiaSimple.cube(mass, r)

  def sphere(mass: Double, r: Double) = Pga3dInertiaSimple.sphere(mass, r)

  def solidSphere(mass: Double, r: Double) = Pga3dInertiaSimple.solidSphere(mass, r)

  def cube(mass: Double, rx: Double, ry: Double, rz: Double) = Pga3dInertiaLocal.cube(mass, rx, ry, rz)

  def solidEllipsoid(mass: Double, rx: Double, ry: Double, rz: Double) = Pga3dInertiaLocal.solidEllipsoid(mass, rx, ry, rz)

  def moved(motor: Pga3dMotor, inertia: Pga3dInertiaLocal) = Pga3dInertiaMovedLocal(motor, inertia)

  def movedSimple(translator: Pga3dTranslator, inertia: Pga3dInertiaSimple) = Pga3dInertiaMovedSimple(translator, inertia)

  /** transparent inline allows narrower return types */
  extension (motor: Pga3dMotor)
    transparent inline def sandwich(inertia: Pga3dInertia) =
      inertia.movedBy(motor)

  extension (translator: Pga3dTranslator)
    transparent inline def sandwich(inertia: Pga3dInertia) =
      inertia.movedBy(translator)

  extension (quaternion: Pga3dQuaternion)
    transparent inline def sandwich(inertia: Pga3dInertia) =
      inertia.movedBy(quaternion)
