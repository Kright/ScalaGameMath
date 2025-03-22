package com.github.kright.pga3dphysics

import com.github.kright.pga3d.*

class Pga3dInertia(val localToGlobal: Pga3dMotor,
                   val localInertia: Pga3dInertiaLocal) extends Pga3dInertiaAbstract:
  // motor moves inertia from local to global

  override def mass: Double =
    localInertia.mass

  override def centerOfMass: Pga3dPoint =
    localToGlobal.sandwich(Pga3dPointCenter).toPointUnsafe

  override def centerOfMassTrivector: Pga3dTrivector =
    centerOfMass * localInertia.mass

  /**
   * @return L - combination of linear impulse and angular momentum
   */
  override def apply(globalB: Pga3dBivector): Pga3dBivector =
    val localB = localToGlobal.reverseSandwich(globalB)
    val localI = localInertia(localB)
    localToGlobal.sandwich(localI)

  override def invert(globalI: Pga3dBivector): Pga3dBivector =
    val localI = localToGlobal.reverseSandwich(globalI)
    val localB = localInertia.invert(localI)
    localToGlobal.sandwich(localB)

  def getLocalAcceleration(globalB: Pga3dBivector, globalForque: Pga3dBivector): Pga3dBivector =
    val localB = localToGlobal.reverseSandwich(globalB)
    val localF = localToGlobal.reverseSandwich(globalForque)
    localInertia.getAcceleration(localB, localF)

  override def getAcceleration(globalB: Pga3dBivector, globalForque: Pga3dBivector): Pga3dBivector =
    val localA = getLocalAcceleration(globalB, globalForque)
    localToGlobal.sandwich(localA)

  override def getKineticEnergy(globalB: Pga3dBivector): Double =
    val localB = localToGlobal.reverseSandwich(globalB)
    localInertia.getKineticEnergy(localB)

  override def toSummable: Pga3dInertiaSummable =
    localToGlobal.sandwich(localInertia.toSummable)

  override def toPrecomputed: Pga3dInertiaPrecomputed =
    Pga3dInertiaPrecomputed(localToGlobal, localInertia)

  override def toInertia: Pga3dInertia =
    this

  override def toString: String =
    s"Pga3dInertia(motor = $localToGlobal, inertia = $localInertia)"


object Pga3dInertia:
  def cube(mass: Double, r: Double) = Pga3dInertiaSimple.cube(mass, r)

  def sphere(mass: Double, r: Double) = Pga3dInertiaSimple.sphere(mass, r)

  def solidSphere(mass: Double, r: Double) = Pga3dInertiaSimple.solidSphere(mass, r)

  def cube(mass: Double, rx: Double, ry: Double, rz: Double) = Pga3dInertiaLocal.cube(mass, rx, ry, rz)


  extension (m: Pga3dMotor)
    def sandwich(inertia: Pga3dInertia): Pga3dInertia =
      Pga3dInertia(m.geometric(inertia.localToGlobal), inertia.localInertia)

  extension (m: Pga3dTranslator)
    def sandwich(inertia: Pga3dInertia): Pga3dInertia =
      Pga3dInertia(m.geometric(inertia.localToGlobal), inertia.localInertia)

  extension (m: Pga3dQuaternion)
    def sandwich(inertia: Pga3dInertia): Pga3dInertia =
      Pga3dInertia(m.geometric(inertia.localToGlobal), inertia.localInertia)

