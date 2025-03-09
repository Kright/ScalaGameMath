package com.github.kright.pga3dphysics

import com.github.kright.pga3dphysics.PhysicsSolverUtil.{getDerivative, setNewState}

/** First order of precision. Very imprecise */
object PhysicsSolverEuler extends PhysicsSolver[Pga3dPhysicsBody]:
  override def step(dynamicBodies: Array[Pga3dPhysicsBody],
                    dt: Double,
                    addForquesToBodies: (Double) => Unit): Unit = {

    val initial = dynamicBodies.map(Pga3dBodyState(_))
    val k1 = getDerivative(dynamicBodies, 0.0, addForquesToBodies)
    setNewState(dynamicBodies, initial, dt, k1)
  }
