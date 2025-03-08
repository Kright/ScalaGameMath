package com.github.kright.pga3dphysics

import com.github.kright.pga3d.*

case class Pga3dState(motor: Pga3dMotor,
                      localB: Pga3dBivector):

  def madd(derivative: Pga3dState, dt: Double): Pga3dState =
    Pga3dState(
      motor = motor + derivative.motor * dt,
      localB = localB + derivative.localB * dt
    )

object Pga3dState:
  def zero: Pga3dState =
    Pga3dState(
      Pga3dMotor(1.0, 0, 0, 0, 0, 0, 0, 0),
      Pga3dBivector(0, 0, 0, 0, 0, 0),
    )

  extension (state: Pga3dState)
    def normalized: Pga3dState =
      state.copy(motor = state.motor.normalizedByBulk)

    def getL(bodyInertia: Pga3dInertiaLocal): Pga3dBivector =
      state.motor.sandwich(bodyInertia(state.localB))

    def getL(bodyInertia: Pga3dInertia): Pga3dBivector =
      state.motor.sandwich(bodyInertia(state.localB))

    def center: Pga3dTrivector =
      state.motor.sandwich(Pga3dPointCenter)
