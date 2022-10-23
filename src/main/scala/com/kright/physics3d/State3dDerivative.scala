package com.kright.physics3d

class State3dDerivative(val velocity: Velocity3d,
                        val acceleration: Acceleration3d):
  def this() = this(Velocity3d(), Acceleration3d())

  def madd(s: State3dDerivative, m: Double): State3dDerivative =
    velocity.madd(s.velocity, m)
    acceleration.madd(s.acceleration, m)
    this
