package com.github.kright.pga3dphysics

import com.github.kright.pga3dphysics.PhysicsSolverUtil.*

import scala.collection.mutable.ArrayBuffer

/**
 * Runge-Kutta solver with 4th order of precision
 */
object PhysicsSolverRK4 extends PhysicsSolver[PhysicsBody]:
  override def step(dynamicBodies: ArrayBuffer[PhysicsBody],
                    dt: Double,
                    addForquesToBodies: (Double) => Unit): Unit = {

    val initial = dynamicBodies.map(State(_))

    val k1 = getDerivative(dynamicBodies, 0.0, addForquesToBodies)

    setNewState(dynamicBodies, initial, 0.5 * dt, k1)
    val k2 = getDerivative(dynamicBodies, 0.5 * dt, addForquesToBodies)

    setNewState(dynamicBodies, initial, 0.5 * dt, k2)
    val k3 = getDerivative(dynamicBodies, 0.5 * dt, addForquesToBodies)

    setNewState(dynamicBodies, initial, dt, k3)
    val k4 = getDerivative(dynamicBodies, dt, addForquesToBodies)

    setNewState(dynamicBodies, initial, dt, k1, 1.0 / 6.0, k2, 2.0 / 6.0, k3, 2.0 / 6.0, k4, 1.0 / 6.0)
  }
