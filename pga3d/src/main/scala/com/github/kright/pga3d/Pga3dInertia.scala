package com.github.kright.pga3d

class Pga3dInertia(val motor: Pga3dMotor,
                   val local: Pga3dInertiaLocal):
  // motor moves inertia from local to global

  def mass: Double =
    local.mass

  def toSummable: Pga3dInertiaSummable =
    motor.sandwich(local.toSummable)

  override def toString: String =
    s"Pga3dInertia(motor = $motor, inertia = $local)"

object Pga3dInertia:
  extension (m: Pga3dMotor)
    def sandwich(inertia: Pga3dInertia): Pga3dInertia =
      Pga3dInertia(m.geometric(inertia.motor), inertia.local)

  extension (m: Pga3dTranslator)
    def sandwich(inertia: Pga3dInertia): Pga3dInertia =
      Pga3dInertia(m.geometric(inertia.motor), inertia.local)

  extension (m: Pga3dQuaternion)
    def sandwich(inertia: Pga3dInertia): Pga3dInertia =
      Pga3dInertia(m.geometric(inertia.motor), inertia.local)     