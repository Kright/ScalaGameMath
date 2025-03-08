package com.github.kright.pga3dphysics

import scala.collection.mutable.ArrayBuffer

/**
 * Runge-Kutta solver of 4th order
 */
object PhysicsSolverRK4 extends PhysicsSolver[PhysicsBody]:
  override def step(dynamicBodies: ArrayBuffer[PhysicsBody],
                    dt: Double,
                    addForquesToBodies: (Double) => Unit): Unit = {

    val initial = dynamicBodies.map(State(_))

    val k1 = getDerivative(dynamicBodies, 0.0, addForquesToBodies)

    setNewState(dynamicBodies, initial, k1, 0.5 * dt)
    val k2 = getDerivative(dynamicBodies, 0.5 * dt, addForquesToBodies)

    setNewState(dynamicBodies, initial, k2, 0.5 * dt)
    val k3 = getDerivative(dynamicBodies, 0.5 * dt, addForquesToBodies)

    setNewState(dynamicBodies, initial, k3, dt)
    val k4 = getDerivative(dynamicBodies, dt, addForquesToBodies)

    setNewState(dynamicBodies, initial, k1, k2, k3, k4, dt)
  }

  private def getDerivative(dynamicBodies: ArrayBuffer[PhysicsBody], currentDt: Double, addForquesToBodies: Double => Unit): ArrayBuffer[State] = {
    for (body <- dynamicBodies) {
      body.resetForqueAccum()
    }

    addForquesToBodies(currentDt)
    dynamicBodies.map(b => State.derivative(b))
  }

  private def setNewState(result: ArrayBuffer[PhysicsBody], initial: ArrayBuffer[State], derivative: ArrayBuffer[State], dt: Double): Unit =
    for (pos <- result.indices) {
      val r = result(pos)
      val i = initial(pos)
      val d = derivative(pos)

      r.motor = (i.motor + d.motor * dt).normalizedByBulk
      r.localB = i.localB + d.localB * dt
    }

  private def setNewState(result: ArrayBuffer[PhysicsBody], initial: ArrayBuffer[State],
                          k1: ArrayBuffer[State], k2: ArrayBuffer[State], k3: ArrayBuffer[State], k4: ArrayBuffer[State], dt: Double): Unit =
    for (pos <- result.indices) {
      val r = result(pos)
      val i = initial(pos)
      val d1 = k1(pos)
      val d2 = k2(pos)
      val d3 = k3(pos)
      val d4 = k4(pos)

      r.motor = (
        i.motor
          + d1.motor * (dt * (1.0 / 6.0))
          + d2.motor * (dt * (1.0 / 3.0))
          + d3.motor * (dt * (1.0 / 3.0))
          + d4.motor * (dt * (1.0 / 6.0))
        ).normalizedByBulk

      r.localB = i.localB
        + d1.localB * (dt * (1.0 / 6.0))
        + d2.localB * (dt * (1.0 / 3.0))
        + d3.localB * (dt * (1.0 / 3.0))
        + d4.localB * (dt * (1.0 / 6.0))
    }
