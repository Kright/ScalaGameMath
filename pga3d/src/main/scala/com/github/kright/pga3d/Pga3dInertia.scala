package com.github.kright.pga3d

class Pga3dInertia(val localToGlobal: Pga3dMotor,
                   val localInertia: Pga3dInertiaLocal):
  // motor moves inertia from local to global

  def mass: Double =
    localInertia.mass

  def apply(globalB: Pga3dBivector): Pga3dBivector =
    val localB = localToGlobal.reverseSandwich(globalB)
    val localI = localInertia(localB)
    localToGlobal.sandwich(localI)

  def invert(globalI: Pga3dBivector): Pga3dBivector =
    val localI = localToGlobal.reverseSandwich(globalI)
    val localB = localInertia.invert(localI)
    localToGlobal.sandwich(localB)

  def getLocalAcceleration(globalB: Pga3dBivector, globalForque: Pga3dBivector): Pga3dBivector =
    val localB = localToGlobal.reverseSandwich(globalB)
    val localF = localToGlobal.reverseSandwich(globalForque)
    localInertia.getAcceleration(localB, localF)

  def getAcceleration(globalB: Pga3dBivector, globalForque: Pga3dBivector): Pga3dBivector =
    val localA = getLocalAcceleration(globalB, globalForque)
    localToGlobal.sandwich(localA)

  def toSummable: Pga3dInertiaSummable =
    localToGlobal.sandwich(localInertia.toSummable)

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