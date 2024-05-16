package com.github.kright.ga


case class Inertia3d[T](mass: MultiVector[T],
                        invertedMass: MultiVector[T]):
  def apply(b: MultiVector[T])(using num: Numeric[T]): MultiVector[T] =
    b.multiplyElementwise(mass).dual

  def invert(b: MultiVector[T])(using num: Numeric[T]): MultiVector[T] =
    b.dual.multiplyElementwise(invertedMass)

  def mapValues[U](f: T => U): Inertia3d[U] =
    Inertia3d(
      mass.mapValues(f),
      invertedMass.mapValues(f)
    )


object Inertia3d:
  def apply(m: Double, mryz: Double, mrxz: Double, mrxy: Double)(using ga: PGA3): Inertia3d[Double] =
    val inertia = MultiVector[Double](
      "wx" -> m,
      "wy" -> m,
      "wz" -> m,
      "yz" -> mryz,
      "xz" -> mrxz,
      "xy" -> mrxy,
    )

    Inertia3d(
      inertia,
      inertia.mapValues(d => 1.0 / d)
    )

  def cube(m: Double, rx: Double, ry: Double, rz: Double)(using ga: PGA3): Inertia3d[Double] =
    val rx2 = rx * rx
    val ry2 = ry * ry
    val rz2 = rz * rz
    apply(
      m = m,
      mryz = (ry2 + rz2) * m / 3,
      mrxz = (rx2 + rz2) * m / 3,
      mrxy = (rx2 + ry2) * m / 3,
    )
