package com.kright.physics3d

import com.kright.math.{IVector3d, Vector3d}


class Spring3d(val dr1local: Vector3d,
               val dr2local: Vector3d,
               val r0: Double,
               val k: Double,
               val friction: Friction) extends Joint3d:

  override def addForces(firstBody: State3d, secondBody: State3d,
                         firstForceAccum: Force3d, secondForceAccum: Force3d): Unit =
    Spring3d.addSpringWithFriction(
      firstBody, secondBody,
      dr1local, dr2local,
      k, r0,
      friction,
      firstForceAccum, secondForceAccum
    )

  def getPotentialEnergy(r12: Double): Double =
    Spring3d.getSpringPotentialEnergy(r12, r0, k)

  override def getPotentialEnergy(firstBody: State3d, secondBody: State3d): Double =
    val r1 = firstBody.transform.local2global(dr1local)
    val r2 = secondBody.transform.local2global(dr2local)
    val r12 = (r2 - r1).mag
    getPotentialEnergy(r12)


object Spring3d:
  /**
   * @param k  is stiffness of spring, F = -k dx
   * @param r0 is default magnitude of spring
   */
  def addSpring(r12: IVector3d, k: Double, r0: Double,
                dr1global: IVector3d, dr2global: IVector3d,
                force1: Force3d, force2: Force3d): Unit =
    val eps = 1e-12
    val rMag = r12.mag
    if (rMag < eps) return

    val force = r12 * (k * (rMag - r0) / rMag)
    force1.addForce(force, dr1global)
    force2.addForce(-force, dr2global)

  /**
   * @param k  is stiffness of spring, F = -k dx
   * @param r0 is default magnitude of spring
   */
  def getSpringPotentialEnergy(r12: Double, r0: Double, k: Double): Double =
    val dr = r12 - r0
    0.5 * k * dr * dr

  /**
   * Example is car shock absorber. It counteracts changes in absorber length.
   */
  def addLinearFriction(r12: IVector3d, v12: IVector3d,
                        friction: Friction,
                        dr1global: IVector3d, dr2global: IVector3d,
                        force1: Force3d, force2: Force3d): Unit =
    val eps = 1e-12
    if (r12.mag < eps) return
    val vpr = v12.projected(r12)
    val frictionForce = friction(vpr)
    force1.addForce(-frictionForce, dr1global)
    force2.addForce(frictionForce, dr2global)

  /**
   * [[addSpring]] and [[addLinearFriction]],
   */
  def addSpringWithFriction(s1: State3d, s2: State3d,
                            dr1local: IVector3d, dr2local: IVector3d,
                            springK: Double, springR0: Double,
                            friction: Friction,
                            force1: Force3d, force2: Force3d): Unit =
    val dr1global = s1.q * dr1local
    val dr2global = s2.q * dr2local

    val globalPos1 = s1.r + dr1global
    val globalPos2 = s2.r + dr2global

    val r12 = globalPos2 - globalPos1
    val v12 = s2.getGlobalVelocity(dr2local) - s1.getGlobalVelocity(dr1local)

    addSpring(r12, springK, springR0, dr1global, dr2global, force1, force2)
    addLinearFriction(r12, v12, friction, dr1global, dr2global, force1, force2)
