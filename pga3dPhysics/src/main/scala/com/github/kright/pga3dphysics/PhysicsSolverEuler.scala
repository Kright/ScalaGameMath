package com.github.kright.pga3dphysics

import com.github.kright.pga3dphysics.PhysicsSolverUtil.{getDerivative, setNewState}

import scala.collection.mutable.ArrayBuffer

/** First order of precision. Very imprecise */
object PhysicsSolverEuler extends PhysicsSolver[PhysicsBody]:
  override def step(dynamicBodies: ArrayBuffer[PhysicsBody],
                    dt: Double,
                    addForquesToBodies: (Double) => Unit): Unit = {

    val initial = dynamicBodies.map(State(_))
    val k1 = getDerivative(dynamicBodies, 0.0, addForquesToBodies)
    setNewState(dynamicBodies, initial, dt, k1)
  }
