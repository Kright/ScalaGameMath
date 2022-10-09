package com.kright.math

object MathUtils:
  extension (arr: Array[Double])
    inline def swap(i: Int, j: Int): Unit =
      val t = arr(i)
      arr(i) = arr(j)
      arr(j) = t

  inline def loop(count: Int)(inline body: Int => Unit): Unit =
    var i = 0
    while (i < count) {
      body(i)
      i += 1 
    }
