package com.github.kright.pga3dphysics

import com.github.kright.pga3d.*

final case class Pga3dInertiaLocal(mass: Double,
                                   mryz: Double,
                                   mrxz: Double,
                                   mrxy: Double) extends Pga3dInertiaAbstract:

  override def toString: String =
    s"Pga3dInertiaLocal(mass = $mass, mryz = $mryz, mrxz = $mrxz, mrxy = $mrxy)"

  override def centerOfMass: Pga3dPoint =
    Pga3dPoint(0.0, 0.0, 0.0)

  override def centerOfMassTrivector: Pga3dTrivector =
    Pga3dTrivector(x = 0.0, y = 0.0, z = 0.0, w = mass)

  override def apply(localB: Pga3dBivector): Pga3dBivector =
    Pga3dBivector(
      wx = localB.yz * mryz,
      wy = -localB.xz * mrxz,
      wz = localB.xy * mrxy,
      xy = localB.wz * mass,
      xz = -localB.wy * mass,
      yz = localB.wx * mass,
    )

  override def invert(localInertia: Pga3dBivector): Pga3dBivector =
    Pga3dBivector(
      wx = localInertia.yz / mass,
      wy = -localInertia.xz / mass,
      wz = localInertia.xy / mass,
      xy = localInertia.wz / mrxy,
      xz = -localInertia.wy / mrxz,
      yz = localInertia.wx / mryz,
    )

  /** invert(localB.cross(apply(localB)) + localForque) */
  override def getAcceleration(localB: Pga3dBivector, localForque: Pga3dBivector): Pga3dBivector =
    Pga3dBivector(
      wx = localForque.yz / mass + localB.wy * localB.xy + localB.wz * localB.xz,
      wy = -localForque.xz / mass + localB.wz * localB.yz - localB.wx * localB.xy,
      wz = localForque.xy / mass - localB.wx * localB.xz - localB.wy * localB.yz,
      xy = (localForque.wz + localB.xz * localB.yz * mrxz - localB.xz * localB.yz * mryz) / mrxy,
      xz = (-localForque.wy + localB.xy * localB.yz * mryz - localB.xy * localB.yz * mrxy) / mrxz,
      yz = (localForque.wx + localB.xy * localB.xz * mrxy - localB.xy * localB.xz * mrxz) / mryz,
    )

  override def toSummable: Pga3dInertiaSummable =
    val mrxyz2 = (mrxy + mrxz + mryz) * 0.5

    val mrx2 = mrxyz2 - mryz
    val mry2 = mrxyz2 - mrxz
    val mrz2 = mrxyz2 - mrxy

    Pga3dInertiaSummable(
      ww = mass,
      wx = 0.0,
      wy = 0.0,
      wz = 0.0,
      xx = mrx2,
      yy = mry2,
      zz = mrz2,
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
    )

  override def toInertia: Pga3dInertia =
    Pga3dInertia(Pga3dMotor.id, this)

  override def toPrecomputed: Pga3dInertiaPrecomputed =
    Pga3dInertiaPrecomputed(Pga3dMotor.id, this)  


object Pga3dInertiaLocal:

  inline val componentsCount = 4

  def cube(mass: Double, rx: Double, ry: Double, rz: Double): Pga3dInertiaLocal =
    val rx2 = rx * rx
    val ry2 = ry * ry
    val rz2 = rz * rz
    Pga3dInertiaLocal(
      mass,
      mryz = (ry2 + rz2) * mass / 3,
      mrxz = (rx2 + rz2) * mass / 3,
      mrxy = (rx2 + ry2) * mass / 3,
    )