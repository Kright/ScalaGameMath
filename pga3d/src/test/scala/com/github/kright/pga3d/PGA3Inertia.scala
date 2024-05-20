package com.github.kright.pga3d


case class PGA3Inertia(mass: Bivector,
                       invertedMass: Bivector):
  def apply(localB: Bivector): Bivector =
    localB.multiplyElementwise(mass).dual

  def invert(localInertia: Bivector): Bivector =
    localInertia.dual.multiplyElementwise(invertedMass)

  def linearMass: Double =
    mass.wx


object PGA3Inertia:
  def apply(m: Double, mryz: Double, mrxz: Double, mrxy: Double): PGA3Inertia =
    val inertia = Bivector(
      wx = m,
      wy = m,
      wz = m,
      yz = mryz,
      xz = mrxz,
      xy = mrxy,
    )

    val invertedInertia = Bivector(
      wx = 1.0 / m,
      wy = 1.0 / m,
      wz = 1.0 / m,
      yz = 1.0 / mryz,
      xz = 1.0 / mrxz,
      xy = 1.0 / mrxy,
    )

    PGA3Inertia(
      inertia,
      invertedInertia
    )

  def cube(m: Double, rx: Double, ry: Double, rz: Double): PGA3Inertia =
    val rx2 = rx * rx
    val ry2 = ry * ry
    val rz2 = rz * rz
    apply(
      m = m,
      mryz = (ry2 + rz2) * m / 3,
      mrxz = (rx2 + rz2) * m / 3,
      mrxy = (rx2 + ry2) * m / 3,
    )
