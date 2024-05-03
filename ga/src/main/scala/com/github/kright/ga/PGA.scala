package com.github.kright.ga

import com.github.kright.ga.PGA.CommonMethods

class PGA(representationConfig: GARepresentationConfig) extends GA(representationConfig):
  require(representationConfig.signature.zeros == 1)
  require(representationConfig.signature.negatives == 0)

object PGA extends CommonMethods:

  trait CommonMethods:
    /**
     * Plane defined by equation x * nx + y * ny + z * nz + d = 0
     * if plane contains point (px, py, pz), then d = px * nx + py * ny + pz * nz = -dot(p, n)
     */
    def zeroPoint[T](using ga: PGA, num: Numeric[T]): MultiVector[T] =
      MultiVector.makeNonNegative[T](
        "w" -> num.one,
      ).dual

    protected def half[T: Numeric] =
      summon[Numeric[T]].parseString("0.5").get

    /**
     * @return multivector which translates by sandwich product
     *         MultiVector(
     *         1 -> 1.0
     *         wx -> -0.5 * d.x
     *         wy -> -0.5 * d.y
     *         wz -> -0.5 * d.z
     *         )
     */
    def translator[T](srcPoint: MultiVector[T], dstPoint: MultiVector[T])(using ga: PGA, num: Numeric[T]): MultiVector[T] =
      translatorByIdealLine((dstPoint v srcPoint).bulk.dual)

    /**
     * actually this is exponentiation
     *
     * ideal line has (wx, wy, wz) components only
     *
     * @return multivector which translates by sandwich product
     *         MultiVector(
     *         1 -> 1.0
     *         wx -> -0.5 * d.x
     *         wy -> -0.5 * d.y
     *         wz -> -0.5 * d.z
     *         )
     */
    def translatorByIdealLine[T](idealLine: MultiVector[T])(using ga: PGA, num: Numeric[T]): MultiVector[T] =
      MultiVector.scalar[T](num.one) + idealLine * half

    def rotor(angle: Double, line: MultiVector[Double])(using ga: GA): MultiVector[Double] =
      expForRotor(line * angle * 0.5)

    def expForRotor(line: MultiVector[Double])(using ga: GA): MultiVector[Double] =
      val len = line.bulk.norm

      // (1 - len^2 / 3! + len^4 / 5!), but double has 15-17 significant digits and for small len result is just 1.0
      val multiplier = if (Math.abs(len) > 1e-9) {
        Math.sin(len) / len
      } else 1.0

      MultiVector.scalar(Math.cos(len)) + line * multiplier

