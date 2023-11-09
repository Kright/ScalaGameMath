package com.kright.physics3d

import com.kright.math.{IVector3d, Vector3d}

class AngularFriction3d(val localPos1: Vector3d,
                        val localPos2: Vector3d,
                        val friction: AngularFriction3dParams) extends Joint3d:

  override def addForces(firstBody: State3d, secondBody: State3d, firstForceAccum: Force3d, secondForceAccum: Force3d): Unit =
    AngularFriction3d.addAngularFriction(firstBody, secondBody, localPos1, localPos2, friction, firstForceAccum, secondForceAccum)

  override def getPotentialEnergy(firstBody: State3d, secondBody: State3d): Double = 0.0


object AngularFriction3d:
  /**
   * Example is friction is bolt screwed into nut
   */
  def addTwistFriction(r12: IVector3d,
                       friction: Friction,
                       w1: IVector3d, w2: IVector3d,
                       force1: Force3d, force2: Force3d): Unit =
    val eps = 1e-12
    if (r12.mag < eps) return

    // along r12
    val w1r = w1.projected(r12)
    val w2r = w2.projected(r12)
    val wJointR = (w1r + w2r) * 0.5

    val moment1r = friction(w1r - wJointR)
    force1.addTorque(moment1r)
    force2.addTorque(-moment1r)

  /**
   * Example is ball joint when it doesn't want to be bent.
   *
   * Twisting friction is not accounted because it depends on friction on both ends of joint,
   * it should be handled by [[addTwistFriction]]
   *
   * This friction could be added independently to first joint end and to second.
   */
  def addBallJointPerpendicularFriction(r12: IVector3d, wJointP: IVector3d,
                                        friction: Friction,
                                        w1: IVector3d,
                                        dr1global: IVector3d, dr2global: IVector3d,
                                        force1: Force3d, force2: Force3d): Unit =
    val eps = 1e-12
    if (r12.mag < eps) return

    val w1p = w1.unprojected(r12)
    val moment1p = friction(w1p - wJointP)
    Joint3d.addMomentAndForces(r12, moment1p, dr1global, dr2global, force1, force2)

  def addAngularFriction(s1: State3d, s2: State3d,
                         dr1local: IVector3d, dr2local: IVector3d,
                         friction: AngularFriction3dParams,
                         force1: Force3d, force2: Force3d): Unit =
    val w1 = s1.w
    val w2 = s2.w

    val dr1global = s1.q * dr1local
    val dr2global = s2.q * dr2local

    val globalPos1 = s1.r + dr1global
    val globalPos2 = s2.r + dr2global

    val r12 = globalPos2 - globalPos1
    val v12 = s2.getGlobalVelocity(dr2local) - s1.getGlobalVelocity(dr1local)
    val wJointP = Joint3d.getWJointP(r12, v12)

    addTwistFriction(r12, friction.twistFriction, w1, w2, force1, force2)
    addBallJointPerpendicularFriction(r12, wJointP, friction.ballJointFriction1, w1, dr1global, dr2global, force1, force2)
    addBallJointPerpendicularFriction(-r12, wJointP, friction.ballJointFriction2, w2, dr2global, dr1global, force2, force1)

