package com.kright.physics3d

import com.kright.math.{IQuaternion, IVector3d, Matrix3d, Vector3d}

class Inertia3d(var mass: Double,
                val localI: Matrix3d):
  def this(mass: Double, localI: Vector3d) = this(mass, new Matrix3d().setScale(localI))

  def getImpulse(t: Transform3d, v: Velocity3d): Impulse3d =
    Impulse3d(linear = getP(v.linear), angular = getL(t, v))

  def getL(t: Transform3d, v: Velocity3d): Vector3d =
    getL(t.rotation, v.angular)

  def getL(rot: IQuaternion, rotVelocity: IVector3d): Vector3d =
    val localVelocity = rot.conjugated() * rotVelocity
    rot *> (localI *> localVelocity)

  def getP(linearVelocity: Vector3d): Vector3d =
    linearVelocity * mass

  def getEnergy(t: Transform3d, v: Velocity3d): Double =
    val localVelocity = t.rotation.conjugated() * v.angular
    0.5 * (mass * v.linear.squareMag + localVelocity.dot(localI * localVelocity))

  // https://en.wikipedia.org/wiki/Euler%27s_equations_(rigid_body_dynamics)
  def getAcceleration(t: Transform3d, v: Velocity3d, force: Force3d): Acceleration3d =
    val I = getGlobalI(t)
    new Acceleration3d(
      linear = force.linear * (1.0 / mass),
      angular = I.inverted() * (force.torque - v.angular.cross(I * v.angular)),
    )

  def getGlobalI(rotation: IQuaternion): Matrix3d =
    (Matrix3d() := rotation) *= localI *= (Matrix3d() := rotation.conjugated())
  
  def getGlobalI(t: Transform3d): Matrix3d =
    getGlobalI(t.rotation)

  override def toString: String = s"Inertia(mass = $mass, I = $localI)"