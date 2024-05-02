package com.github.kright.ga


class PGA2(stringMapperParams: GARepresentationConfig) extends PGA(stringMapperParams):
  require(stringMapperParams.signature == Signature.pga2)


object PGA2 extends PGA.CommonMethods:
  /**
   * Line defined by equation x * nx + y * ny + d = 0
   * if line contains point (px, py, pz), then d = px * nx + py * ny + pz * nz = -dot(p, n)
   */
  def line[T](nx: T, ny: T, minusDot: T)(using ga: PGA2): MultiVector[T] =
    MultiVector.makeNonNegative[T](
      "x" -> nx,
      "y" -> ny,
      "w" -> minusDot,
    )

  /**
   * @return MultiVector.makeNonNegative[T](wx -> y, wy -> -x, xy -> 1.0)
   */
  def point[T](x: T, y: T)(using ga: PGA2, num: Numeric[T]): MultiVector[T] =
    MultiVector.makeNonNegative[T](
      "x" -> x,
      "y" -> y,
      "w" -> num.one,
    ).dual
