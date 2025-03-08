package com.github.kright.pga3dphysics

import com.github.kright.pga3d.{Pga3dBivector, Pga3dMotor}

case class State(motor: Pga3dMotor, localB: Pga3dBivector)

object State:
  def apply(b: PhysicsBody): State =
    new State(
      motor = b.motor,
      localB = b.localB,
    )

  def derivative(b: PhysicsBody): State =
    new State(
      motor = b.motor.geometric(b.localB) * -0.5,
      localB = b.inertia.getAcceleration(b.localB, b.localForque)
    )
