package com.github.kright.physics3d

import com.github.kright.math.{IQuaternion, Quaternion}

/**
 * Tries to keep same relative orientation between bodies, so q1 * dq == q2, dq == q1.conjugated() * q2
 */
class OrientationSpring3d(dq: Quaternion,
                          val k: Double,
                          val friction: Friction) extends Joint3d:
  val dqConjugated = dq.conjugated()

  def this(q1: IQuaternion, q2: IQuaternion, k: Double, friction: Friction) =
    this(q1.conjugated() * q2, k, friction)

  /**
   * dqf * q1 * dq == q2
   * dqf * q1 == q2 * dq.conjugated()
   * dqf == q2 * dq.conjugated() * q1.conjugated()
   *
   * @return dqf
   */
  private def getDqf(q1: IQuaternion, q2: IQuaternion): Quaternion =
    q2 * dqConjugated * q1.conjugated()

  override def addForces(firstBody: State3d, secondBody: State3d,
                         firstForceAccum: Force3d, secondForceAccum: Force3d): Unit =
    val dqf = getDqf(firstBody.q, secondBody.q)
    val log = dqf.getLog()
    val dw21 = firstBody.velocity.angular - secondBody.velocity.angular
    val moment = log * (2 * k) + friction(dw21)
    firstForceAccum.addTorque(moment)
    secondForceAccum.addTorque(-moment)

  override def getPotentialEnergy(firstBody: State3d, secondBody: State3d): Double =
    val dqf = getDqf(firstBody.q, secondBody.q)
    val angle = dqf.rotationAngleRadians()
    0.5 * angle * angle * k
