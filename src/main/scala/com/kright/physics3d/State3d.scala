package com.kright.physics3d

import com.kright.math.{IVector3d, Vector3d}

class State3d(val transform: Transform3d,
              val velocity: Velocity3d):
  def this() = this(Transform3d(), Velocity3d())
  
  def copy(): State3d =
    State3d(transform.copy(), velocity.copy())

  def normalize(): State3d =
    transform.rotation.normalize()
    this

  def madd(derivative: State3d, dt: Double): State3d =
    transform.madd(derivative.transform, dt)
    velocity.madd(derivative.velocity, dt)
    this

  def updated(s: State3dDerivative, dt: Double): State3d =
    State3d(
      transform.copy().update(s.velocity, dt),
      velocity.copy().update(s.acceleration, dt)
    )
    
  def updated(body: Inertia3d, impulse: Impulse3d): State3d =
    State3d(
      transform.copy(),
      velocity.copy().update(body, transform, impulse)
    )  
    
  def :=(state: State3d): State3d =
    transform := state.transform
    velocity := state.velocity
    this
    
  def getGlobalVelocity(localPos: IVector3d): Vector3d =
    velocity.linear + velocity.angular.cross(transform.rotation * localPos)

  override def toString: String =
    s"State3d($transform, $velocity})"