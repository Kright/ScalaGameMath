package com.github.kright.pga3d

/** this code is generated, see com.github.kright.pga3d.codegen.CodeGenClass */
case class Inertia(mass: Double,
                   mryz: Double,
                   mrxz: Double,
                   mrxy: Double):


  def apply(localB: Bivector): Bivector =
    Bivector(
      wx = localB.yz * mryz,
      wy = -localB.xz * mrxz,
      wz = localB.xy * mrxy,
      xy = localB.wz * mass,
      xz = -localB.wy * mass,
      yz = localB.wx * mass,
    )

  def invert(localInertia: Bivector): Bivector =
    Bivector(
      wx = localInertia.yz / mass,
      wy = -localInertia.xz / mass,
      wz = localInertia.xy / mass,
      xy = localInertia.wz / mrxy,
      xz = -localInertia.wy / mrxz,
      yz = localInertia.wx / mryz,
    )

  /** invert(localB.cross(apply(localB)) + localForque) */
  def getAcceleration(localB: Bivector, localForque: Bivector): Bivector =
    Bivector(
      wx = localForque.yz / mass + localB.wy * localB.xy + localB.wz * localB.xz,
      wy = -localForque.xz / mass + localB.wz * localB.yz - localB.wx * localB.xy,
      wz = localForque.xy / mass - localB.wx * localB.xz - localB.wy * localB.yz,
      xy = (localForque.wz + localB.xz * localB.yz * mrxz - localB.xz * localB.yz * mryz) / mrxy,
      xz = (-localForque.wy + localB.xy * localB.yz * mryz - localB.xy * localB.yz * mrxy) / mrxz,
      yz = (localForque.wx + localB.xy * localB.xz * mrxy - localB.xy * localB.xz * mrxz) / mryz,
    )


object Inertia:

  def cube(mass: Double, rx: Double, ry: Double, rz: Double): Inertia =
    val rx2 = rx * rx
    val ry2 = ry * ry
    val rz2 = rz * rz
    Inertia(
      mass,
      mryz = (ry2 + rz2) * mass / 3,
      mrxz = (rx2 + rz2) * mass / 3,
      mrxy = (rx2 + ry2) * mass / 3,
    )