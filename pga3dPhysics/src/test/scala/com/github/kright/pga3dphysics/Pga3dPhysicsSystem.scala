package com.github.kright.pga3dphysics

import com.github.kright.pga3d.{Pga3dBivector, Pga3dMotor}

class Pga3dPhysicsSystem(val initialState: Array[Pga3dPhysicsBody], val solver: Pga3dPhysicsSolver[Pga3dPhysicsBody]):
  var state: Array[Pga3dPhysicsBody] = initialState.map(_.deepCopy())

  val initialE = getKineticEnergy()
  val initialL = getL()

  def getL(): Pga3dBivector =
    Pga3dPhysicsBody.getL(state)

  def getKineticEnergy(): Double =
    Pga3dPhysicsBody.getKineticEnergy(state)

  def getErrorE(): Double =
    math.abs(getKineticEnergy() - initialE) / initialE

  def getErrorL(): Double =
    (getL() - initialL).norm / initialL.norm

  def getError() = Pga3dOneBodyWithInertiaLocal.Error(getErrorE(), getErrorL())

  def doStep(dt: Double, addForquesToBodies: Double => Unit): Unit =
    solver.step(state, dt, addForquesToBodies)

object Pga3dPhysicsSystem:
  def simpleBody(motor: Pga3dMotor): Pga3dPhysicsBody =
    Pga3dPhysicsBody(
      Pga3dInertia(motor.reverse, Pga3dInertiaLocal(1.0, 3.0, 2.0, 1.0)).toPrecomputed,
      motor,
      motor.reverseSandwich(Pga3dBivector(
        wx = 0.0,
        wy = 0.0,
        wz = 0.0,
        xy = 1.0,
        yz = 1.0,
        xz = -1.0,
      ))
    )
  