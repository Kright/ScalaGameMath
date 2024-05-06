package com.github.kright.ga

import com.github.kright.math.Vector3d

import scala.math.Numeric.Implicits.infixNumericOps

class PGA3(representationConfig: GARepresentationConfig) extends PGA(representationConfig):
  require(representationConfig.signature == Signature.pga3)

object PGA3 extends PGA.CommonMethods:

  /**
   * Plane defined by equation x * nx + y * ny + z * nz + d = 0
   * if plane contains point (px, py, pz), then d = px * nx + py * ny + pz * nz = -dot(p, n)
   */
  def plane[T](nx: T, ny: T, nz: T, minusDot: T)(using ga: PGA3): MultiVector[T] =
    MultiVector.makeNonNegative[T](
      "x" -> nx,
      "y" -> ny,
      "z" -> nz,
      "w" -> minusDot,
    )

  /**
   * @return MultiVector.makeNonNegative[T]("xyz" -> 1.0, "yzw" -> -x, "xzw" -> y, "xyw" -> -z)
   */
  def point[T](x: T, y: T, z: T)(using ga: PGA3, num: Numeric[T]): MultiVector[T] =
    MultiVector.makeNonNegative[T](
      "x" -> x,
      "y" -> y,
      "z" -> z,
      "w" -> num.one,
    ).dual

  /**
   * @return MultiVector.makeNonNegative[T]("yzw" -> -x, "xzw" -> y, "xyw" -> -z)
   */
  def idealPoint[T](x: T, y: T, z: T)(using ga: PGA3, num: Numeric[T]): MultiVector[T] =
    MultiVector.makeNonNegative[T](
      "x" -> x,
      "y" -> y,
      "z" -> z,
    ).dual

  def point(v: Vector3d)(using ga: PGA3): MultiVector[Double] =
    point(v.x, v.y, v.z)

  def idealPoint(v: Vector3d)(using ga: PGA3): MultiVector[Double] =
    idealPoint(v.x, v.y, v.z)

  def translator[T](dx: T, dy: T, dz: T)(using ga: PGA3, num: Numeric[T]): MultiVector[T] =
    MultiVector(
      "1" -> num.one,
      "wx" -> -half * dx,
      "wy" -> -half * dy,
      "wz" -> -half * dz,
    )

  def translator(v: Vector3d)(using ga: PGA3): MultiVector[Double] =
    MultiVector(
      "1" -> 1.0,
      "wx" -> -0.5 * v.x,
      "wy" -> -0.5 * v.y,
      "wz" -> -0.5 * v.z,
    )

  /**
   * @param b - any bivector
   * @return pair: line, shift along line
   */
  def bivectorSplit(b: MultiVector[Double])(using ga: PGA3): (MultiVector[Double], MultiVector[Double]) =
    val shiftAlongLine = b.geometric((b ^ b.reverse) / (2.0 * (b dot b.reverse).scalar))
    val line = b - shiftAlongLine
    (line, shiftAlongLine)
