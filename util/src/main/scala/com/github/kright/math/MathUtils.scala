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


  extension (arr: Array[Double])
    inline def swap(i: Int, j: Int): Unit =
      val t = arr(i)
      arr(i) = arr(j)
      arr(j) = t


  extension (d: Double)
    def clamp(lower: Double, upper: Double): Double =
      if (d < lower) lower
      else if (d > upper) upper
      else d

    def sign: Double =
      if (d > 0) 1.0
      else if (d < 0) -1.0
      else 0.0
