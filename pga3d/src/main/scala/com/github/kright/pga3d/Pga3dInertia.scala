package com.github.kright.pga3d


/** this code is generated, see com.github.kright.pga3d.codegen.CodeGenClass */
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

  override def getEnergy(globalB: Pga3dBivector): Double =
    val localB = localToGlobal.reverseSandwich(globalB)
    localInertia.getEnergy(localB)

  def toSummable: Pga3dInertiaSummable =
    localToGlobal.sandwich(localInertia.toSummable)
    
  def toPrecomputed: Pga3dInertiaPrecomputed =
    Pga3dInertiaPrecomputed(localToGlobal, localInertia)

  override def toString: String =
    s"Pga3dInertia(motor = $localToGlobal, inertia = $localInertia)"


object Pga3dInertia:
  extension (m: Pga3dMotor)
    def sandwich(inertia: Pga3dInertia): Pga3dInertia =
      Pga3dInertia(m.geometric(inertia.localToGlobal), inertia.localInertia)

  extension (m: Pga3dTranslator)
    def sandwich(inertia: Pga3dInertia): Pga3dInertia =
      Pga3dInertia(m.geometric(inertia.localToGlobal), inertia.localInertia)

  extension (m: Pga3dQuaternion)
    def sandwich(inertia: Pga3dInertia): Pga3dInertia =
      Pga3dInertia(m.geometric(inertia.localToGlobal), inertia.localInertia)

