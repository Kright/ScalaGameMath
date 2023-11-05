package com.kright.physics3d

import com.kright.math.{IVector2d, IVector3d, IVectorNd, Vector2d, Vector3d}
import com.kright.math.MathUtils.clamp

import scala.jdk.FunctionWrappers.FromJavaConsumer


trait Friction:
  /**
   * for positive velocity result force should be negative or zero
   * for zero it should be zero
   * for negative velocity result force should be positive or zero
   */
  def apply(velocity: Double): Double

  /**
   * direction of force should be opposite to direction of velocity
   * for zero speed force should be zero
   */
  def apply[Vec, IVec <: IVectorNd[IVec, Vec]](velocity: IVec, eps: Double = 1e-12): Vec =
    val mag = velocity.mag
    val multiplier = if (mag < eps) 0.0 else this (mag) / mag
    velocity * multiplier


object Friction:
  def apply(f: Double => Double): Friction = (velocity: Double) => f(velocity)

  def linear(k: Double): Friction =
    require(k >= 0)
    velocity => -k * velocity

  def linear(k: Double, maxForce: Double): Friction =
    require(k >= 0)
    velocity => (-k * velocity).clamp(-maxForce, maxForce)

  def quadratic(k2: Double, maxForce: Double = Double.MaxValue): Friction =
    require(k2 >= 0)
    velocity => (-velocity * velocity * k2 * velocity.sign).clamp(-maxForce, maxForce)

  /**
   * between -minVelocity and minVelocity changes linearly from maxForce to -maxForce for numerical stability
   */
  def const(minVelocity: Double, maxForce: Double): Friction =
    require(minVelocity > 0.0)
    linear(maxForce / minVelocity, maxForce)

  object ZeroFriction extends Friction:
    override def apply(velocity: Double): Double = 0.0

    override def apply[Vec, IVec <: IVectorNd[IVec, Vec]](velocity: IVec, eps: Double = 1e-12): Vec = velocity * 0.0

  val zero = ZeroFriction