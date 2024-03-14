package com.github.kright.physics3d

import com.github.kright.math.{IVector3d, Vector3d}

class Velocity3d(val linear: Vector3d,
                 val angular: Vector3d) extends LinearWithAngular[Velocity3d]:
  def this() = this(Vector3d(), Vector3d())

  def v: Vector3d = linear

  def w: Vector3d = angular

  def update(acceleration: Acceleration3d, dt: Double): Velocity3d =
    linear.madd(acceleration.linear, dt)
    angular.madd(acceleration.angular, dt)
    this

  def update(body: Inertia3d, transform: Transform3d, impulse3d: Impulse3d): Velocity3d =
    linear.madd(impulse3d.linear, 1.0 / body.mass)
    angular += body.getGlobalI(transform).invert() * impulse3d.angular
    this

  override protected def makeNew(newLinear: Vector3d, newAngular: Vector3d): Velocity3d =
    Velocity3d(newLinear, newAngular)
