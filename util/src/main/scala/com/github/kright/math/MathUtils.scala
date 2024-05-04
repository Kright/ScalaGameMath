package com.github.kright.math

object MathUtils:
  inline def loop(count: Int)(inline body: Int => Unit): Unit =
    var i = 0
    while (i < count) {
      body(i)
      i += 1
    }

  def isEquals(arr1: Array[Double], arr2: Array[Double], eps: Double): Boolean =
    loop(arr1.length) { i =>
      if (math.abs(arr1(i) - arr2(i)) > eps) return false
    }
    true

  def pow[T](x: T, power: Int, mult: (T, T) => T): T =
    require(power >= 1)
    if (power == 1) return x

    if (power % 2 == 0) {
      pow(mult(x, x), power / 2, mult)
    }
    else {
      mult(x, pow(mult(x, x), power / 2, mult))
    }

  extension (d: Double)
    def clamp(lower: Double, upper: Double): Double =
      if (d < lower) lower
      else if (d > upper) upper
      else d

    def sign: Double =
      if (d > 0) 1.0
      else if (d < 0) -1.0
      else 0.0


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