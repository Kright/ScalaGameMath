package com.github.kright.pga3dphysics

import com.github.kright.pga3dphysics.PhysicsSolverUtil.*

/** Second order of precision */
object PhysicsSolverHeun extends PhysicsSolver[PhysicsBody]:
  override def step(dynamicBodies: Array[PhysicsBody],
                    dt: Double,
                    addForquesToBodies: (Double) => Unit): Unit = {

    val initial = dynamicBodies.map(State(_))
    val k1 = getDerivative(dynamicBodies, 0.0, addForquesToBodies)

    setNewState(dynamicBodies, initial, dt, k1)
    val k2 = getDerivative(dynamicBodies, dt, addForquesToBodies)

    setNewState(dynamicBodies, initial, dt, k1, 0.5, k2, 0.5)
  }
