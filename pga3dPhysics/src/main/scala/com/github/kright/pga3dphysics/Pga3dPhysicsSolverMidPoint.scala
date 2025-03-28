package com.github.kright.pga3dphysics

import com.github.kright.pga3dphysics.Pga3dPhysicsSolverUtil.*

/** Second order of precision */
object Pga3dPhysicsSolverMidPoint extends Pga3dPhysicsSolver[Pga3dPhysicsBody]:
  override def step(dynamicBodies: Array[Pga3dPhysicsBody],
                    dt: Double,
                    addForquesToBodies: (Double) => Unit): Unit = {

    val initial = dynamicBodies.map(Pga3dBodyState(_))
    val k1 = getDerivative(dynamicBodies, 0.0, addForquesToBodies)

    setNewState(dynamicBodies, initial, dt * 0.5, k1)
    val k2 = getDerivative(dynamicBodies, dt * 0.5, addForquesToBodies)

    setNewState(dynamicBodies, initial, dt, k2)
  }

  override def toString: String = 
    "Pga3dPhysicsSolverMidPoint"
