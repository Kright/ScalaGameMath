package com.github.kright.pga3dphysics

import com.github.kright.matrix.Matrix
import com.github.kright.pga3d.*

class Pga3dInertiaPrecomputed(val localToGlobal: Pga3dMotor,
                              val localInertia: Pga3dInertiaLocal) extends Pga3dInertiaAbstract:
  override val mass: Double =
    localInertia.mass

  override val centerOfMass: Pga3dPoint =
    localToGlobal.sandwich(Pga3dPointCenter).toPointUnsafe

  override val centerOfMassTrivector: Pga3dTrivector =
    centerOfMass * localInertia.mass

  private val matrixFwd: Matrix = {
    val tmpInertia = Pga3dInertia(localToGlobal, localInertia)
    Pga3dMatrix.linearMapping(tmpInertia.apply)
  }

  private val matrixInv: Matrix = {
    val tmpInertia = Pga3dInertia(localToGlobal, localInertia)
    Pga3dMatrix.linearMapping(tmpInertia.invert)
  }

  override def apply(globalB: Pga3dBivector): Pga3dBivector =
    Pga3dMatrix.multiply(matrixFwd, globalB)

  override def invert(globalInertia: Pga3dBivector): Pga3dBivector =
    Pga3dMatrix.multiply(matrixInv, globalInertia)
    
  def toInertia: Pga3dInertia =
    Pga3dInertia(localToGlobal, localInertia)
    
  def toSummable: Pga3dInertiaSummable =
    toInertia.toSummable
    
