package com.kright.physics3d

import com.kright.math.Vector3d

trait LinearWithAngular[Self <: LinearWithAngular[Self]]:
  def :=(other: Self): this.type =
    linear := other.linear
    angular := other.angular
    this

  def +(other: Self): Self =
    copy() += other

  def +=(other: Self): this.type =
    linear += other.linear
    angular += other.angular
    this

  def *(multiplier: Double): Self =
    copy() *= multiplier

  def copy(): Self = makeNew(Vector3d(), Vector3d())

  def *=(multiplier: Double): this.type =
    linear *= multiplier
    angular *= multiplier
    this

  def madd(other: Self, multiplier: Double): this.type =
    linear.madd(other.linear, multiplier)
    angular.madd(other.angular, multiplier)
    this

  override def toString: String = s"${getClass.getSimpleName}($linear, $angular)"

  protected def linear: Vector3d

  protected def angular: Vector3d

  protected def makeNew(newLinear: Vector3d, newAngular: Vector3d): Self
