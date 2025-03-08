package com.github.kright.pga3dphysics

import scala.collection.mutable.ArrayBuffer

object PhysicsSolverUtil:
  def getDerivative(dynamicBodies: ArrayBuffer[PhysicsBody], currentDt: Double, addForquesToBodies: Double => Unit): ArrayBuffer[State] = {
    for (body <- dynamicBodies) {
      body.resetForqueAccum()
    }

    addForquesToBodies(currentDt)
    dynamicBodies.map(b => State.derivative(b))
  }

  def setNewState(result: ArrayBuffer[PhysicsBody], initial: ArrayBuffer[State], dt: Double, derivative: ArrayBuffer[State]): Unit =
    for (pos <- result.indices) {
      val r = result(pos)
      val i = initial(pos)
      val d = derivative(pos)

      r.motor = (i.motor + d.motor * dt).normalizedByBulk
      r.localB = i.localB + d.localB * dt
    }

  def setNewState(result: ArrayBuffer[PhysicsBody], initial: ArrayBuffer[State], dt: Double,
                  derivative0: ArrayBuffer[State], k0: Double,
                  derivative1: ArrayBuffer[State], k1: Double): Unit =
    for (pos <- result.indices) {
      val r = result(pos)
      val i = initial(pos)
      val d0 = derivative0(pos)
      val d1 = derivative1(pos)

      r.motor = (
        i.motor
          + d0.motor * (dt * k0)
          + d1.motor * (dt * k1)
        ).normalizedByBulk

      r.localB = i.localB
        + d0.localB * (dt * k0)
        + d1.localB * (dt * k1)
    }

  def setNewState(result: ArrayBuffer[PhysicsBody], initial: ArrayBuffer[State], dt: Double,
                  derivative0: ArrayBuffer[State], k0: Double,
                  derivative1: ArrayBuffer[State], k1: Double,
                  derivative2: ArrayBuffer[State], k2: Double,
                  derivative3: ArrayBuffer[State], k3: Double): Unit =
    for (pos <- result.indices) {
      val r = result(pos)
      val i = initial(pos)
      val d0 = derivative0(pos)
      val d1 = derivative1(pos)
      val d2 = derivative2(pos)
      val d3 = derivative3(pos)

      r.motor = (
        i.motor
          + d0.motor * (dt * k0)
          + d1.motor * (dt * k1)
          + d2.motor * (dt * k2)
          + d3.motor * (dt * k3)
        ).normalizedByBulk

      r.localB = i.localB
        + d0.localB * (dt * k0)
        + d1.localB * (dt * k1)
        + d2.localB * (dt * k2)
        + d3.localB * (dt * k3)
    }