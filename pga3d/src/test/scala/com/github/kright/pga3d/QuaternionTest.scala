package com.github.kright.pga3d

import org.scalatest.funsuite.AnyFunSuiteLike

import scala.collection.mutable.ArrayBuffer
import scala.util.Random

class QuaternionTest extends AnyFunSuiteLike:
  test("rotation is same vectors") {
    val from = Vector(1, 2, 3).normalizedByNorm
    val to = Vector(3, 4, 5).normalizedByNorm
    val q = Quaternion.rotation(from, to)
    assert((q.sandwich(from) - to).norm < 1e-15)
  }

  test("check for angles near zero") {
    val angles = Seq(0.0, 1e-20, 1e-12, 1e-8, 1e-7, 1e-6, 1e-5, 1e-4, 1e-3, 0.01, 0.1, 1.0)

    val rnd = new Random()
    rnd.setSeed(123)

    def makeQ(): Quaternion =
      val q = Quaternion(rnd.nextGaussian(), rnd.nextGaussian(), rnd.nextGaussian(), rnd.nextGaussian())
      if (q.norm < 1e-3) makeQ() else q.normalizedByNorm

    for (isNormalizedInput <- Seq(false, true);
         isNearPi <- Seq(false, true);
         angle <- angles) {
      val from = PlaneIdeal(1.0, 0.0, 0.0)

      val to =
        if (isNearPi) PlaneIdeal(-Math.cos(angle), Math.sin(angle), 0.0)
        else PlaneIdeal(Math.cos(angle), Math.sin(angle), 0.0)

      val errors = new ArrayBuffer[Double]()
      for (i <- 0 until 1000) {
        val q = makeQ()
        val qFrom = q.sandwich(from)
        val qTo = q.sandwich(to)

        val m1 = if (isNormalizedInput) 1.0 else rnd.nextDouble() * 2 + 0.001
        val m2 = if (isNormalizedInput) 1.0 else rnd.nextDouble() * 2 + 0.001

        val real = Quaternion.rotation(qFrom * m1, qTo * m2).sandwich(qFrom)
        val err = (real - qTo).norm
        errors += err
      }

      require(errors.max < 2e-8)
      // println(s"${if (isNormalizedInput) "normalized" else "non normalized"} angle = ${if (isNearPi) "Pi - " else ""}${angle}, errors max ${errors.max}, average ${errors.sum / errors.size}")
    }
  }
