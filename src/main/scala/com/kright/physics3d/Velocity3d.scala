package com.kright.physics3d

import com.kright.math.Vector3d

class Velocity3d(val linear: Vector3d,
                 val angular: Vector3d) extends LinearWithAngular[Velocity3d] :
  def this() = this(Vector3d(), Vector3d())

  def update(acceleration: Acceleration3d, dt: Double): Velocity3d =
    linear.madd(acceleration.linear, dt)
    angular.madd(acceleration.angular, dt)
    this

  override protected def makeNew(newLinear: Vector3d, newAngular: Vector3d): Velocity3d =
    Velocity3d(newLinear, newAngular)
