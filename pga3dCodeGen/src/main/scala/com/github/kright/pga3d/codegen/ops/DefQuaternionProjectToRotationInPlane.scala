package com.github.kright.pga3d.codegen.ops

import com.github.kright.ga.PGA3
import com.github.kright.pga3d.codegen.{GeneratedCode, MultivectorSubClass, MultivectorUnaryOp}

object DefQuaternionProjectToRotationInPlane:
  def apply()(using pga3: PGA3): MultivectorUnaryOp = MultivectorUnaryOp { (cls, v) =>
    GeneratedCode { code =>
      if (cls == MultivectorSubClass.quaternion) {
        code(
          s"""
             |def projectToRotationInPlane(plane: Pga3dPlaneIdeal): Pga3dQuaternion =
             |  val q = this.normalizedByNorm
             |  val qPart = Pga3dQuaternion.rotation(q.sandwich(plane), plane)
             |  qPart.geometric(q)
             |
             |def restoreRotationInPlane(plane: Pga3dPlaneIdeal): Double =
             |  val q0 = this.projectToRotationInPlane(plane)
             |  val logDual = q0.log().dual
             |  val currentAngle = 2.0 * (logDual.wx * plane.x + logDual.wy * plane.y + logDual.wz * plane.z) / plane.norm
             |  currentAngle
             |
             |def restoreRotationInPlaneX: Double =
             |  restoreRotationInPlane(Pga3dPlaneIdeal(1, 0, 0))
             |
             |def restoreRotationInPlaneY: Double =
             |  restoreRotationInPlane(Pga3dPlaneIdeal(0, 1, 0))
             |
             |def restoreRotationInPlaneZ: Double =
             |  restoreRotationInPlane(Pga3dPlaneIdeal(0, 0, 1))""".stripMargin)
      }
    }
  }
