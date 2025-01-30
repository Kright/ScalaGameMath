package com.github.kright.pga3d

case class PGA3State(motor: Pga3dMotor,
                     localB: Pga3dBivector):

  def madd(derivative: PGA3State, dt: Double): PGA3State =
    PGA3State(
      motor = motor + derivative.motor * dt,
      localB = localB + derivative.localB * dt
    )

object PGA3State:
  def zero: PGA3State =
    PGA3State(
      Pga3dMotor(1.0, 0, 0, 0, 0, 0, 0, 0),
      Pga3dBivector(0, 0, 0, 0, 0, 0),
    )

  extension (state: PGA3State)
    def normalized: PGA3State =
      state.copy(motor = state.motor.normalizedByBulk)

    def getEnergy(bodyInertia: Pga3dInertia): Double =
      (state.localB v bodyInertia(state.localB)) * 0.5

    def getL(bodyInertia: Pga3dInertia): Pga3dBivector =
      state.motor.sandwich(bodyInertia(state.localB))

    def center: Pga3dTrivector =
      state.motor.sandwich(Pga3dPointCenter)
