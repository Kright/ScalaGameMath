package com.github.kright.ga

case class PGA3State[T](motor: MultiVector[T],
                        localB: MultiVector[T]):

  def madd(derivative: PGA3State[T], dt: T)(using num: Numeric[T]): PGA3State[T] =
    PGA3State(
      motor = motor + derivative.motor * dt,
      localB = localB + derivative.localB * dt
    )

  def maddV2(derivative: PGA3State[T], dt: T)(using num: Numeric[T]): PGA3State[T] =
    val m2 = motor + derivative.motor * dt
    val b2 = localB + derivative.localB * dt
    PGA3State(
      motor = m2,
      localB = m2.reverse.geometric(motor).sandwich(b2)
    )

object PGA3State:
  extension (state3d: PGA3State[Double])
    def normalized: PGA3State[Double] =
      state3d.copy(motor = state3d.motor.normalizedByNorm)

    def getEnergy(bodyInertia: PGA3Inertia[Double]): Double =
      (state3d.localB v bodyInertia(state3d.localB)).scalar * 0.5

    def getL(bodyInertia: PGA3Inertia[Double]): MultiVector[Double] =
      state3d.motor.sandwich(bodyInertia(state3d.localB))
