package com.kright.physics3d

import com.kright.math.{DifferentialSolvers, IQuaternion, IVector3d, Matrix3d, Vector3d}

class Inertia3d(var mass: Double,
                val localI: Matrix3d):
  def this(mass: Double, localI: IVector3d) = this(mass, new Matrix3d().setScale(localI))

  def getImpulse(t: Transform3d, v: Velocity3d): Impulse3d =
    Impulse3d(linear = getP(v.linear), angular = getL(t, v))

  def getImpulse(state: State3d): Impulse3d =
    getImpulse(state.transform, state.velocity)  

  def getL(t: Transform3d, v: Velocity3d): Vector3d =
    getL(t.rotation, v.angular)  
    
  def getL(state: State3d): Vector3d =
    getL(state.transform, state.velocity)

  def getL(rot: IQuaternion, rotVelocity: IVector3d): Vector3d =
    val localVelocity = rot.conjugated() * rotVelocity
    rot *> (localI *> localVelocity)

  def getP(linearVelocity: Vector3d): Vector3d =
    linearVelocity * mass

  def getEnergy(t: Transform3d, v: Velocity3d): Double =
    val localVelocity = t.rotation.conjugated() * v.angular
    0.5 * (mass * v.linear.squareMag + localVelocity.dot(localI * localVelocity))

  def getEnergy(state: State3d): Double =
    getEnergy(state.transform, state.velocity)
  
  // https://en.wikipedia.org/wiki/Euler%27s_equations_(rigid_body_dynamics)
  def getAcceleration(t: Transform3d, v: Velocity3d, force: Force3d): Acceleration3d =
    val I = getGlobalI(t)
    new Acceleration3d(
      linear = force.linear * (1.0 / mass),
      angular = I.inverted() * (force.torque - v.angular.cross(I * v.angular)),
    )

  def getAcceleration(state: State3d, force: Force3d): Acceleration3d =
    getAcceleration(state.transform, state.velocity, force)
    
  def getDerivative(state: State3d, force: Force3d): State3dDerivative =
    State3dDerivative(state.velocity, getAcceleration(state, force))  

  def getGlobalI(rotation: IQuaternion): Matrix3d =
    (Matrix3d() := rotation) *= localI *= (Matrix3d() := rotation.conjugated())
  
  def getGlobalI(t: Transform3d): Matrix3d =
    getGlobalI(t.rotation)
    
  def getGlobalI(s: State3d): Matrix3d =
    getGlobalI(s.transform.rotation)  

  override def toString: String = s"Inertia(mass = $mass, I = $localI)"