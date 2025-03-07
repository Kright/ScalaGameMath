package com.github.kright.pga3d.codegen.inertia

import com.github.kright.pga3d.codegen.CodeGenClass

class InertiaAbstractCodeGen extends CodeGenClass:
  override def name: String = "Pga3dInertiaAbstract"

  override def isObject: Boolean = false

  override def generateCode(): String =
    s"""trait Pga3dInertiaAbstract:
       |  def mass: Double
       |
       |  def centerOfMass: Pga3dPoint
       |
       |  def centerOfMassTrivector: Pga3dTrivector
       |
       |  def apply(velocity: Pga3dBivector): Pga3dBivector
       |
       |  def invert(localInertia: Pga3dBivector): Pga3dBivector
       |
       |  def getAcceleration(velocity: Pga3dBivector, forque: Pga3dBivector): Pga3dBivector =
       |    invert(velocity.cross(apply(velocity)) + forque)
       |
       |  def getKineticEnergy(velocity: Pga3dBivector): Double =
       |    (velocity v apply(velocity)) * 0.5
       |""".stripMargin
