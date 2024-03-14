package com.github.kright.physics3d

import com.github.kright.math.{IVector3d, Quaternion, Vector3d}


class AngularSpring3d(val localPos1: Transform3d,
                      val localPos2: Transform3d,
                      val k1: Double,
                      val k2: Double) extends Joint3d:
  override def addForces(firstBody: State3d, secondBody: State3d,
                         force1: Force3d, force2: Force3d): Unit =
    AngularSpring3d.addForces(firstBody, secondBody, localPos1, localPos2, k1, k2, force1, force2)

  override def getPotentialEnergy(firstBody: State3d, secondBody: State3d): Double =
    var result: Double = 0.0
    AngularSpring3d.processMoments(firstBody, secondBody, localPos1, localPos2) { (dq1, dq2, r12, dr1global, dr2global) =>
      val dq1Angle = dq1.rotationAngleRadians()
      val dq2Angle = dq2.rotationAngleRadians()
      result = 0.5 * (dq1Angle * dq1Angle * k1 + dq2Angle * dq2Angle * k2)
    }
    result


object AngularSpring3d:
  inline def processMoments(firstBody: State3d, secondBody: State3d,
                            localPos1: Transform3d, localPos2: Transform3d)
                           (inline process: (dq1: Quaternion, dq2: Quaternion, r12: IVector3d, dr1global: IVector3d, dr2global: IVector3d) => Unit): Unit =
    val dr1global = firstBody.q * localPos1.r
    val dr2global = secondBody.q * localPos2.r

    val globalPos1 = firstBody.transform.local2global(localPos1)
    val globalPos2 = secondBody.transform.local2global(localPos2)
    val r12 = globalPos2.r - globalPos1.r
    val r12Mag = r12.mag
    if (r12Mag > 1e-12) {
      val r12Norm = r12 / r12Mag
      val oX = Vector3d(1, 0, 0)

      val dq1 = Quaternion.fromAxisToAxis(globalPos1.q * oX, r12Norm)
      val dq2 = Quaternion.fromAxisToAxis(globalPos2.q * oX, r12Norm)
      // dq1 and dq2 rotation axis are perpendicular to r

      // val q1r12 = dq1 * globalPos1.q
      // val q2r12 = dq2 * globalPos2.q
      // dq * q1r12 = q2r12
      // dq is rotation along r
      // val dqr = q2r12 * q1r12.conjugated()

      process(dq1, dq2, r12, dr1global, dr2global)
    }

  def addForces(firstBody: State3d, secondBody: State3d,
                localPos1: Transform3d, localPos2: Transform3d,
                k1: Double, k2: Double,
                force1: Force3d, force2: Force3d): Unit =
    processMoments(firstBody, secondBody, localPos1, localPos2) { (dq1, dq2, r12, dr1global, dr2global) =>
      val moment1p = dq1.getLog() * (2 * k1)
      Joint3d.addMomentAndForces(r12, moment1p, dr1global, dr2global, force1, force2)

      val moment2p = dq2.getLog() * (2 * k2)
      Joint3d.addMomentAndForces(-r12, moment2p, dr2global, dr1global, force2, force1)
    }
