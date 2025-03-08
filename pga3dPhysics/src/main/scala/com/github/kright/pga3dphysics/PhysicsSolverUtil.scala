package com.github.kright.pga3dphysics

import com.github.kright.math.FastRange

object PhysicsSolverUtil:
  def getDerivative(dynamicBodies: Array[PhysicsBody], currentDt: Double, addForquesToBodies: Double => Unit): Array[State] = {
    for (body <- dynamicBodies) {
      body.resetForqueAccum()
    }

    addForquesToBodies(currentDt)
    dynamicBodies.map(b => State.derivative(b))
  }

  def setNewState(result: Array[PhysicsBody], initial: Array[State], dt: Double, derivative: Array[State]): Unit =
    for (pos <- FastRange(result.length)) {
      val r = result(pos)
      val i = initial(pos)
      val d = derivative(pos)

      r.motor = (i.motor + d.motor * dt).normalizedByBulk
      r.localB = i.localB + d.localB * dt
    }

  def setNewState(result: Array[PhysicsBody], initial: Array[State], dt: Double,
                  derivative0: Array[State], k0: Double,
                  derivative1: Array[State], k1: Double): Unit =
    for (pos <- FastRange(result.length)) {
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

  def setNewState(result: Array[PhysicsBody], initial: Array[State], dt: Double,
                  derivative0: Array[State], k0: Double,
                  derivative1: Array[State], k1: Double,
                  derivative2: Array[State], k2: Double,
                  derivative3: Array[State], k3: Double): Unit =
    for (pos <- FastRange(result.length)) {
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