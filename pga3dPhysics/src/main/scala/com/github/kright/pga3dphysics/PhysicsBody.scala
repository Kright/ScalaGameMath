package com.github.kright.pga3dphysics

import com.github.kright.pga3d.*

import scala.util.chaining.scalaUtilChainingOps


class PhysicsBody(var inertia: Pga3dInertiaPrecomputed,
                  _motor: Pga3dMotor,
                  var localB: Pga3dBivector) extends Body(_motor):

  private val globalForqueAccumulator = Pga3dBivectorMutable()

  override def deepCopy(): PhysicsBody =
    PhysicsBody(inertia, motor, localB).tap { b =>
      b.globalForqueAccumulator := globalForqueAccumulator
    }

  def globalForque: Pga3dBivector =
    globalForqueAccumulator.toBivector

  def localForque: Pga3dBivector =
    motor.reverseSandwich(globalForque)

  def addGlobalForque(globalForque: Pga3dBivector): Unit =
    globalForqueAccumulator += globalForque

  /** Otherwise it's too easy to forget adding paired force */
  def addGlobalForquePaired(globalForque: Pga3dBivector, other: PhysicsBody): Unit =
    globalForqueAccumulator += globalForque
    other.globalForqueAccumulator -= globalForque

  def resetForqueAccum(): Unit =
    globalForqueAccumulator.setZero()

  /** @return kinetic energy */
  def getKineticEnergy: Double =
    inertia.getKineticEnergy(localB)

  /** @return combination of linear and rotational momentum */
  def getL: Pga3dBivector =
    inertia(localB)

  def globalCenterOfMass: Pga3dPoint =
    motorSandwich(inertia.centerOfMass)


object PhysicsBody:
  def motionless(inertia: Pga3dInertia, motor: Pga3dMotor): PhysicsBody =
    PhysicsBody(inertia.toPrecomputed, motor, Pga3dBivector())

  def motionless(inertia: Pga3dInertiaLocal, motor: Pga3dMotor): PhysicsBody =
    PhysicsBody(inertia.toInertia.toPrecomputed, motor, Pga3dBivector())
