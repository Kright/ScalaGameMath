package com.kright.physics3d

class State3d(val transform: Transform3d,
              val velocity: Velocity3d):
  def this() = this(Transform3d(), Velocity3d())
  
  def updated(s: State3dDerivative, dt: Double): State3d =
    State3d(
      transform.copy().update(s.velocity, dt),
      velocity.copy().update(s.acceleration, dt)
    )
    
  def :=(state: State3d): State3d =
    transform := state.transform
    velocity := state.velocity
    this
