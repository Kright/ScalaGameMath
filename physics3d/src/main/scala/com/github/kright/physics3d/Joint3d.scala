package com.github.kright.physics3d

import com.github.kright.math.{IVector3d, Vector3d}


/**
 * abstract class for joint between two bodies
 *
 * Notation for names in global coordinate system:
 *
 * r12: vector from first joint end to second joint end.
 * v12: vector velocity of second joint end relative for the first end. Derivative of r12.
 * dr1global, dr2global: distance from body center to joint point.
 * w1, w2: angular velocity of first and second bodies. Equals to [[State3d.w]]
 * wJointP: part of angular velocity of joint perpendicular to r12, see [[Joint3d.getWJointP]]
 * force1, force2: accumulators for adding calculated forces to first and second bodies.
 *
 * In local coordinate system:
 *
 * dr1local, dr2local: local position of joint point for first (or second) body
 */
trait Joint3d:
  def addForces(firstBody: State3d, secondBody: State3d,
                firstForceAccum: Force3d, secondForceAccum: Force3d): Unit

  def getPotentialEnergy(firstBody: State3d, secondBody: State3d): Double = 0.0

object Joint3d:
  /**
   * when
   */
  def addMomentAndForces(r12: IVector3d, moment1p: IVector3d,
                         dr1global: IVector3d, dr2global: IVector3d,
                         force1: Force3d, force2: Force3d): Unit =
    val force = r12.cross(moment1p) / r12.squareMag
    // M = R x F, so F = M x R / R^2

    force1.addTorque(moment1p)
    force1.addForce(-force, dr1global)
    force2.addForce(force, dr2global)

  /**
   * part of angular velocity perpendicular to r12.
   */
  def getWJointP(r12: IVector3d, v12: IVector3d): Vector3d =
    r12.cross(v12) / r12.squareMag