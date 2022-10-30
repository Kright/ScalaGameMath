package com.kright.physics3d

import com.kright.math.{IVector3d, Vector3d}

class Force3d(val linear: Vector3d,
              val torque: Vector3d) extends LinearWithAngular[Force3d]:

  def this() = this(Vector3d(), Vector3d())

  override def copy(): Force3d =
    Force3d(linear.copy(), torque.copy())

  /**
   * Moment of inertia = r cross force
   * r is vector from center of mass to point at which force is applied
   */
  def addForce(force: IVector3d, r: IVector3d): Force3d =
    linear += force
    torque.addCross(r, force)
    this

  def addForce(force: IVector3d): Force3d =
    linear += force
    this

  def addTorque(dtorque: IVector3d): Force3d =
    torque += dtorque
    this
    
  def toImpulse(dt: Double): Impulse3d =
    Impulse3d(linear * dt, angular * dt)  

  override protected def makeNew(newLinear: Vector3d, newAngular: Vector3d): Force3d =
    Force3d(newLinear, newAngular)

  override protected def angular: Vector3d = torque
