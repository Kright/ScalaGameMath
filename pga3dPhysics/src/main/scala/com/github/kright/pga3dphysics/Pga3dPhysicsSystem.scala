package com.github.kright.pga3dphysics

import com.github.kright.pga3d.Pga3dBivector

class Pga3dPhysicsSystem(val state: Array[Pga3dPhysicsBody],
                         val solver: Pga3dPhysicsSolver[Pga3dPhysicsBody],
                         var time: Double = 0.0):

  def getL(): Pga3dBivector =
    Pga3dPhysicsBody.getL(state)

  def getKineticEnergy(): Double =
    Pga3dPhysicsBody.getKineticEnergy(state)

  def doStep(dt: Double, addForquesToBodies: Double => Unit): Unit =
    solver.step(state, dt, addForquesToBodies)
    time += dt

  def withStateDeepCopy: Pga3dPhysicsSystem =
    Pga3dPhysicsSystem(state.map(_.deepCopy), solver, time)
