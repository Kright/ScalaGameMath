package com.github.kright.pga3dphysics

import com.github.kright.pga3d.{Pga3dBivector, Pga3dPoint, Pga3dTrivector}

trait Pga3dInertiaAbstract:
  def mass: Double

  def centerOfMass: Pga3dPoint

  def centerOfMassTrivector: Pga3dTrivector

  def apply(velocity: Pga3dBivector): Pga3dBivector

  def invert(localInertia: Pga3dBivector): Pga3dBivector

  def getAcceleration(velocity: Pga3dBivector, forque: Pga3dBivector): Pga3dBivector =
    invert(velocity.cross(apply(velocity)) + forque)

  def getKineticEnergy(velocity: Pga3dBivector): Double =
    (velocity v apply(velocity)) * 0.5

  def toInertia: Pga3dInertia

  def toSummable: Pga3dInertiaSummable

  def toPrecomputed: Pga3dInertiaPrecomputed
