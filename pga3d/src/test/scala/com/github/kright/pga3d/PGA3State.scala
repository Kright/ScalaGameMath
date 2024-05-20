package com.github.kright.pga3d

case class PGA3State(motor: Motor,
                     localB: Bivector):

  def madd(derivative: PGA3State, dt: Double): PGA3State =
    PGA3State(
      motor = motor + derivative.motor * dt,
      localB = localB + derivative.localB * dt
    )

object PGA3State:
  def zero: PGA3State =
    PGA3State(
      Motor(1.0, 0, 0, 0, 0, 0, 0, 0),
      Bivector(0, 0, 0, 0, 0, 0),
    )

  extension (state: PGA3State)
    def normalized: PGA3State =
      state.copy(motor = state.motor.normalizedByBulk)

    def getEnergy(bodyInertia: PGA3Inertia): Double =
      (state.localB v bodyInertia(state.localB)) * 0.5

    def getL(bodyInertia: PGA3Inertia): Bivector =
      state.motor.sandwich(bodyInertia(state.localB))

    def center: Point =
      state.motor.sandwich(PointCenter)
