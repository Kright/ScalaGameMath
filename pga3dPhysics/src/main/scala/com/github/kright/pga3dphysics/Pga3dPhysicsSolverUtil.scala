package com.github.kright.pga3dphysics

import com.github.kright.math.FastRange

object Pga3dPhysicsSolverUtil:
  def getDerivative(dynamicBodies: Array[Pga3dPhysicsBody], currentDt: Double, addForquesToBodies: Double => Unit): Array[Pga3dBodyState] = {
    for (body <- dynamicBodies) {
      body.resetForqueAccum()
    }

    addForquesToBodies(currentDt)
    dynamicBodies.map(b => Pga3dBodyState.derivative(b))
  }

  def setNewState(result: Array[Pga3dPhysicsBody], initial: Array[Pga3dBodyState], dt: Double, derivative: Array[Pga3dBodyState]): Unit =
    for (pos <- FastRange(result.length)) {
      val r = result(pos)
      val i = initial(pos)
      val d = derivative(pos)

      r.motor = (i.motor + d.motor * dt).normalizedByBulk
      r.localB = i.localB + d.localB * dt
    }

  def setNewState(result: Array[Pga3dPhysicsBody], initial: Array[Pga3dBodyState], dt: Double,
                  derivative0: Array[Pga3dBodyState], k0: Double,
                  derivative1: Array[Pga3dBodyState], k1: Double): Unit =
    for (pos <- FastRange(result.length)) {
      val r = result(pos)
      val i = initial(pos)
      val d0 = derivative0(pos)
      val d1 = derivative1(pos)

      r.motor = (i.motor
        + d0.motor * (dt * k0)
        + d1.motor * (dt * k1)
        ).normalizedByBulk

      r.localB = i.localB
        + d0.localB * (dt * k0)
        + d1.localB * (dt * k1)
    }

  def setNewState(result: Array[Pga3dPhysicsBody], initial: Array[Pga3dBodyState], dt: Double,
                  derivative0: Array[Pga3dBodyState], k0: Double,
                  derivative1: Array[Pga3dBodyState], k1: Double,
                  derivative2: Array[Pga3dBodyState], k2: Double,
                  derivative3: Array[Pga3dBodyState], k3: Double): Unit =
    for (pos <- FastRange(result.length)) {
      val r = result(pos)
      val i = initial(pos)
      val d0 = derivative0(pos)
      val d1 = derivative1(pos)
      val d2 = derivative2(pos)
      val d3 = derivative3(pos)

      val dMotor =
        d0.motor * (dt * k0)
          + d1.motor * (dt * k1)
          + d2.motor * (dt * k2)
          + d3.motor * (dt * k3)

      r.motor = (i.motor + dMotor).normalizedByBulk

      val dB =
        d0.localB * (dt * k0)
          + d1.localB * (dt * k1)
          + d2.localB * (dt * k2)
          + d3.localB * (dt * k3)

      r.localB = i.localB + dB
    }