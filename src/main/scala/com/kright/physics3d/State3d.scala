package com.kright.physics3d

import com.kright.math.{IVector3d, Quaternion, Vector3d}

class State3d(val transform: Transform3d,
              val velocity: Velocity3d):
  def this() = this(Transform3d(), Velocity3d())

  def v: Vector3d = velocity.v

  def w: Vector3d = velocity.w

  def r: Vector3d = transform.r

  def q: Quaternion = transform.q

  def copy(): State3d =
    State3d(transform.copy(), velocity.copy())

  def normalize(): State3d =
    transform.rotation.normalize()
    this

  def madd(derivative: State3d, dt: Double): State3d =
    transform.madd(derivative.transform, dt)
    velocity.madd(derivative.velocity, dt)
    this

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

  def getGlobalVelocity(localPos: IVector3d, localVelocity: IVector3d): Vector3d =
    getGlobalVelocity(localPos) + q * localVelocity

  def isEquals(other: State3d, eps: Double): Boolean =
    transform.isEquals(other.transform, eps) && velocity.isEquals(other.velocity, eps)

  override def toString: String =
    s"State3d($transform, $velocity})"
