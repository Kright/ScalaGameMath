package com.github.kright.pga3d


/** this code is generated, see com.github.kright.pga3d.codegen.CodeGenClass */
object Pga3dForque:
  def force(point: Pga3dPoint, force: Pga3dVector): Pga3dBivector =
    point v force

  def torque(torque: Pga3dVector): Pga3dBivector =
    Pga3dBivector(torque.x, torque.y, torque.z, 0.0, 0.0, 0.0)

  def getLinearForce(forque: Pga3dBivector): Pga3dVector =
    val fd = forque.dual
    Pga3dVector(fd.wx, fd.wy, fd.wz)

  def getCenter(forque: Pga3dBivector): Pga3dPoint =
    val v = getLinearForce(forque)
    val vNormSquare = v.normSquare

    if (vNormSquare > 1e-100) {
      val w = Pga3dVector(forque.wx, forque.wy, forque.wz)
      val result = (v.dual.cross(w.dual)).dual / v.normSquare
      Pga3dPoint(result.wx, result.wy, result.wz)
    } else {
      // pure torque
      Pga3dPoint(0.0, 0.0, 0.0)
    }

  def getTorqueAroundCenter(forque: Pga3dBivector): Pga3dVector = {
    val v = getLinearForce(forque)
    val vNormSquare = v.normSquare
    if (vNormSquare > 1e-100) {
      val inv = 1.0 / Math.sqrt(vNormSquare)
      Pga3dVector(forque.wx * v.x * inv, forque.wy * v.y * inv, forque.wz * v.z * inv)
    } else {
      Pga3dVector(forque.wx, forque.wy, forque.wz)
    }
  }  