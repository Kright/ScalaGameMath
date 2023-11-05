package com.kright.physics3d

import com.kright.math.{EulerAngles, IVector3d, Quaternion, Vector3d}

class Transform3d(val position: Vector3d,
                  val rotation: Quaternion):

  def this() = this(Vector3d(), Quaternion())

  def copy(): Transform3d =
    Transform3d(position.copy(), rotation.copy())

  def :=(t: Transform3d): Transform3d =
    position := t.position
    rotation := t.rotation
    this

  def madd(t: Transform3d, m: Double): Transform3d =
    position.madd(t.position, m)
    rotation.madd(t.rotation, m)
    this

  def normalize(): Transform3d =
    rotation.normalize()
    this

  def update(velocity: Velocity3d, dt: Double): Transform3d =
    position.madd(velocity.linear, dt)
    val dRot = Quaternion().setFromExp(velocity.angular * (0.5 * dt))
    dRot *> rotation
    rotation.normalize()
    this

  def local2global(local: IVector3d): Vector3d =
    rotation * local + position

  def global2local(global: IVector3d): Vector3d =
    rotation.conjugated() * (global - position)

  override def toString: String = s"Transform3d($position, ${EulerAngles() := rotation})"
