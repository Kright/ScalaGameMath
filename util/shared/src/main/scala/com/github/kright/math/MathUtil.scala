package com.github.kright.math

object MathUtil:
  def isEquals(arr1: Array[Double], arr2: Array[Double], eps: Double): Boolean =
    for (i <- FastRange(arr1.length)) {
      if (math.abs(arr1(i) - arr2(i)) > eps) return false
    }
    true

  def pow[T](x: T, power: Int, mult: (T, T) => T): T =
    require(power >= 1)
    if (power == 1) return x

    val xx = mult(x, x)
    if (power % 2 == 0) {
      pow(xx, power / 2, mult)
    }
    else {
      mult(x, pow(xx, power / 2, mult))
    }

  def interpolate(a: Double, b: Double, t: Double): Double =
    a * (1.0 - t) + b * t

  extension (d: Double)
    def clamp(lower: Double, upper: Double): Double =
      if (d < lower) lower
      else if (d > upper) upper
      else d

    def sign: Double =
      if (d > 0) 1.0
      else if (d < 0) -1.0
      else 0.0

    def square: Double =
      d * d


  extension [T](arr: Array[T])
    inline def swap(i: Int, j: Int): Unit =
      val t = arr(i)
      arr(i) = arr(j)
      arr(j) = t

    inline def getOrElseUpdate(i: Int, inline update: => T): T =
      val result = arr(i)
      if (result != null) {
        result
      } else {
        val newValue = update
        arr(i) = newValue
        newValue
      }