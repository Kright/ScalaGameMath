package com.github.kright.pga3d

import com.github.kright.math.DifferentialSolvers

class PGA3OneBody(val inertia: PGA3Inertia,
                  val initialState: PGA3State) {
  var state: PGA3State = initialState
  val initialE = getEnergy()
  val initialL = getL()

  def getEnergy(): Double =
    state.getEnergy(inertia)

  def getL(): Bivector =
    state.getL(inertia)

  def getErrorE(): Double =
    math.abs(getEnergy() - initialE) / initialE

  def getErrorL(): Double =
    (getL() - initialL).norm / initialL.norm

  def getError() = PGA3OneBody.Error(getErrorE(), getErrorL())

  def doStepRK4(dt: Double, globalForque: Bivector): Unit = {
    doStepRK4F(dt, (state, time) => {
      val localForque = state.motor.reverseSandwich(globalForque)
      localForque
    })
  }

  def doStepRK4F(dt: Double, getLocalForque: (state: PGA3State, time: Double) => Bivector): Unit = {
    val (k1, k2, k3, k4) = DifferentialSolvers.rungeKutta4K(state, time = 0.0, dt,
      getDerivative = (state, time) => {
        val localForque = getLocalForque(state, time)
        PGA3State(
          motor = state.motor.geometric(state.localB) * -0.5,
          localB = inertia.invert(state.localB.cross(inertia(state.localB)) + localForque)
        )
      },
      nextState = getNextState,
    )

    state = state
      .madd(k1, dt * (1.0 / 6.0))
      .madd(k2, dt * (2.0 / 6.0))
      .madd(k3, dt * (2.0 / 6.0))
      .madd(k4, dt * (1.0 / 6.0))
      .normalized
  }

  private def getDerivative(globalForque: Bivector)(state: PGA3State, time: Double): PGA3State =
    val localForque = state.motor.reverse.sandwich(globalForque)
    PGA3State(
      motor = state.motor.geometric(state.localB) * -0.5,
      localB = inertia.invert(state.localB.cross(inertia(state.localB)) + localForque)
    )

  private def getNextState(state: PGA3State, derivative: PGA3State, dt: Double): PGA3State =
    state.madd(derivative, dt).normalized
}

object PGA3OneBody:
  case class Error(errorE: Double, errorL: Double):
    def this() = this(0.0, 0.0)

    infix def max(other: Error): Error =
      Error(Math.max(errorE, other.errorE), Math.max(errorL, other.errorL))

    def <(other: Error): Boolean =
      errorE <= other.errorE && errorL <= other.errorL

  def simple123() = new PGA3OneBody(
    PGA3Inertia(1.0, 3.0, 2.0, 1.0),
    PGA3State(
      Motor(1, 0, 0, 0, 0, 0, 0, 0),
      Bivector(
        wx = 0.0,
        wy = 0.0,
        wz = 0.0,
        xy = 1.0,
        yz = 1.0,
        xz = -1.0,
      )
    )
  )
