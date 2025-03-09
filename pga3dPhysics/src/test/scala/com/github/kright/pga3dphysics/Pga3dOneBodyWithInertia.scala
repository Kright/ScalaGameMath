package com.github.kright.pga3dphysics

import com.github.kright.math.DifferentialSolvers
import com.github.kright.pga3d.*

class Pga3dOneBodyWithInertia(val inertia: Pga3dInertia, val initialState: Pga3dBodyState):
  var state: Pga3dBodyState = initialState
  val initialE = getEnergy()
  val initialL = getL()

  def getEnergy(): Double =
    inertia.getKineticEnergy(state.localB)

  def getL(): Pga3dBivector =
    state.getL(inertia)

  def getErrorE(): Double =
    math.abs(getEnergy() - initialE) / initialE

  def getErrorL(): Double =
    (getL() - initialL).norm / initialL.norm

  def getError() = ErrorOfEnergyAndMomentum(getErrorE(), getErrorL())

  def doStepRK4(dt: Double, globalForque: Pga3dBivector): Unit = {
    doStepRK4F(dt, (state, time) => {
      val localForque = state.motor.reverseSandwich(globalForque)
      localForque
    })
  }

  def doStepRK4F(dt: Double, getLocalForque: (state: Pga3dBodyState, time: Double) => Pga3dBivector): Unit = {
    val (k1, k2, k3, k4) = DifferentialSolvers.rungeKutta4K(state, time = 0.0, dt,
      getDerivative = (state, time) => {
        val localForque = getLocalForque(state, time)
        Pga3dBodyState(
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

  private def getDerivative(globalForque: Pga3dBivector)(state: Pga3dBodyState, time: Double): Pga3dBodyState =
    val localForque = state.motor.reverse.sandwich(globalForque)
    Pga3dBodyState(
      motor = state.motor.geometric(state.localB) * -0.5,
      localB = inertia.invert(state.localB.cross(inertia(state.localB)) + localForque)
    )

  private def getNextState(state: Pga3dBodyState, derivative: Pga3dBodyState, dt: Double): Pga3dBodyState =
    state.madd(derivative, dt).normalized

object Pga3dOneBodyWithInertia:
  def simple123(motor: Pga3dMotor) = new Pga3dOneBodyWithInertia(
    Pga3dInertia(motor.reverse, Pga3dInertiaLocal(1.0, 3.0, 2.0, 1.0)),
    Pga3dBodyState(
      motor,
      motor.reverseSandwich(Pga3dBivector(
        wx = 0.0,
        wy = 0.0,
        wz = 0.0,
        xy = 1.0,
        yz = 1.0,
        xz = -1.0,
      ))
    )
  )