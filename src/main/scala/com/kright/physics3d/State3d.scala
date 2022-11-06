package com.kright.physics3d

class State3d(val transform: Transform3d,
              val velocity: Velocity3d):
  def this() = this(Transform3d(), Velocity3d())
  
  def copy(): State3d =
    State3d(transform.copy(), velocity.copy())

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
