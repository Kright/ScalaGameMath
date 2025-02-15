package com.github.kright.pga3d

import com.github.kright.math.DifferentialSolvers

class Pga3dOneBody(val inertia: Pga3dInertia,
                   val initialState: Pga3dState) {
  var state: Pga3dState = initialState
  val initialE = getEnergy()
  val initialL = getL()

  def getEnergy(): Double =
    state.getEnergy(inertia)

  def getL(): Pga3dBivector =
    state.getL(inertia)

  def getErrorE(): Double =
    math.abs(getEnergy() - initialE) / initialE

  def getErrorL(): Double =
    (getL() - initialL).norm / initialL.norm

  def getError() = Pga3dOneBody.Error(getErrorE(), getErrorL())

  def doStepRK4(dt: Double, globalForque: Pga3dBivector): Unit = {
    doStepRK4F(dt, (state, time) => {
      val localForque = state.motor.reverseSandwich(globalForque)
      localForque
    })
  }

  def doStepRK4F(dt: Double, getLocalForque: (state: Pga3dState, time: Double) => Pga3dBivector): Unit = {
    val (k1, k2, k3, k4) = DifferentialSolvers.rungeKutta4K(state, time = 0.0, dt,
      getDerivative = (state, time) => {
        val localForque = getLocalForque(state, time)
        Pga3dState(
          motor = state.motor.geometric(state.localB) * -0.5,
          localB = inertia.getAcceleration(state.localB, localForque)
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

  private def getDerivative(globalForque: Pga3dBivector)(state: Pga3dState, time: Double): Pga3dState =
    val localForque = state.motor.reverse.sandwich(globalForque)
    Pga3dState(
      motor = state.motor.geometric(state.localB) * -0.5,
      localB = inertia.invert(state.localB.cross(inertia(state.localB)) + localForque)
    )

  private def getNextState(state: Pga3dState, derivative: Pga3dState, dt: Double): Pga3dState =
    state.madd(derivative, dt).normalized
}

object Pga3dOneBody:
  case class Error(errorE: Double, errorL: Double):
    def this() = this(0.0, 0.0)

    infix def max(other: Error): Error =
      Error(Math.max(errorE, other.errorE), Math.max(errorL, other.errorL))

    def <(other: Error): Boolean =
      errorE <= other.errorE && errorL <= other.errorL

  def simple123() = new Pga3dOneBody(
    Pga3dInertia(1.0, 3.0, 2.0, 1.0),
    Pga3dState(
      Pga3dMotor(1, 0, 0, 0, 0, 0, 0, 0),
      Pga3dBivector(
        wx = 0.0,
        wy = 0.0,
        wz = 0.0,
        xy = 1.0,
        yz = 1.0,
        xz = -1.0,
      )
    )
  )
