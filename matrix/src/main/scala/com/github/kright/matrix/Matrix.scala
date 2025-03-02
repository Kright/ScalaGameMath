package com.github.kright.matrix

import com.github.kright.math.FastRange

class Matrix(val h: Int, val w: Int):

  val elements: Array[Double] = new Array[Double](h * w)

  def apply(y: Int, x: Int): Double =
    elements(x + y * w)

  def update(y: Int, x: Int, v: Double): Unit =
    elements(x + y * w) = v

  def isSquare: Boolean =
    w == h

  def hasSameSize(m: Matrix): Boolean =
    h == m.h && w == m.w

  def setIdt(): Unit =
    require(w == h)
    for (y <- 0 until h) {
      for (x <- 0 until w) {
        val v = if (x == y) 1.0 else 0.0
        this (y, x) = v
      }
    }

  def :=(m: Matrix): Unit =
    require(hasSameSize(m))
    m.elements.copyToArray(elements)

  def *=(s: Double): Unit =
    mapElements(_ * s)

  private inline def elementsIndices =
    FastRange(elements.length)

  def +=(m: Matrix): Unit =
    require(hasSameSize(m))
    for (i <- elementsIndices) {
      elements(i) += m.elements(i)
    }

  def -=(m: Matrix): Unit =
    require(hasSameSize(m))
    for (i <- elementsIndices) {
      elements(i) -= m.elements(i)
    }

  def +(m: Matrix): Matrix =
    val r = this.copy()
    r += m
    r

  def -(m: Matrix): Matrix =
    val r = this.copy()
    r -= m
    r

  def *(right: Matrix): Matrix =
    require(this.w == right.h)

    val result = new Matrix(this.h, right.w)

    for (y <- FastRange(result.h); 
         x <- FastRange(result.w)) {
      var sum = 0.0
      for (k <- FastRange(this.w)) {
        sum += this (y, k) * right(k, x)
      }
      result(y, x) = sum
    }

    result

  def transposed(): Matrix =
    val result = new Matrix(w, h)
    for (y <- FastRange(result.h);
         x <- FastRange(result.w)) {
      result(y, x) = this (x, y)
    }
    result

  def transposeInplace(): Unit =
    require(isSquare)

    for (i <- FastRange(1, h);
         j <- FastRange(0, i)) {
      val t = this (i, j)
      val t2 = this (j, i)
      this (i, j) = t2
      this (j, i) = t
    }

  def mapElements(f: Double => Double): Unit = {
    for (i <- elementsIndices) {
      elements(i) = f(elements(i))
    }
  }

  def setZero(): Unit =
    for (i <- elementsIndices) {
      elements(i) = 0.0
    }

  def copy(): Matrix =
    val r = Matrix(h, w)
    elements.copyToArray(r.elements)
    r

  override def toString: String =
    MatrixPrinter.oneLinePrinter(this)


object Matrix:
  def symmetricMatrixToDiagonalAndEigenvectors(m: Matrix): (Matrix, Matrix) =
    SymmetricMatrixDiagonalization.toDiagonalAndEigenvectors(m)

  def fromValues(h: Int, w: Int)(elems: Double*): Matrix = {
    require(elems.size == h * w)
    val m = Matrix(h, w)
    elems.copyToArray(m.elements)
    m
  }  