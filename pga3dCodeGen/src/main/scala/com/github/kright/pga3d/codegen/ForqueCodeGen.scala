package com.github.kright.pga3d.codegen

import com.github.kright.ga.PGA3
import com.github.kright.pga3d.codegen.MultivectorSubClass.{bivector, point, vector}

class ForqueCodeGen extends CodeGenClass:
  private given ga: PGA3 = MultivectorSubClass.pga3

  override def name: String = "Pga3dForque"

  override def isObject: Boolean = false

  override def generateCode(): String =
    val code = CodeGen()

    code(s"object ${name}:")
    code.block {
      code(
        s"""def force(point: ${point.typeName}, force: ${vector.typeName}): ${bivector.typeName} =
           |  point v force
           |  
           |def torque(torque: ${vector.typeName}): ${bivector.typeName} =
           |  ${bivector.typeName}(torque.x, torque.y, torque.z, 0.0, 0.0, 0.0)
           |
           |def getLinearForce(forque: ${bivector.typeName}): ${vector.typeName} =
           |  val fd = forque.dual
           |  ${vector.typeName}(fd.wx, fd.wy, fd.wz)
           |
           |def getCenter(forque: ${bivector.typeName}): ${point.typeName} =
           |  val v = getLinearForce(forque)
           |  val vNormSquare = v.normSquare
           |
           |  if (vNormSquare > 1e-100) {
           |    val w = Pga3dVector(forque.wx, forque.wy, forque.wz)
           |    val result = (v.dual.cross(w.dual)).dual / v.normSquare
           |    Pga3dPoint(result.wx, result.wy, result.wz)
           |  } else {
           |    // pure torque
           |    Pga3dPoint(0.0, 0.0, 0.0)
           |  }
           |  
           |def getTorqueAroundCenter(forque: ${bivector.typeName}): ${vector.typeName} = {
           |  val v = getLinearForce(forque)
           |  val vNormSquare = v.normSquare
           |  if (vNormSquare > 1e-100) {
           |    val inv = 1.0 / Math.sqrt(vNormSquare)
           |    ${vector.typeName}(forque.wx * v.x * inv, forque.wy * v.y * inv, forque.wz * v.z * inv)
           |  } else {
           |    ${vector.typeName}(forque.wx, forque.wy, forque.wz)
           |  }
           |}  
           |""".stripMargin)
    }

    code.toString
