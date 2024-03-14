package com.github.kright.math

trait MatrixNd[Matrix <: MatrixNd[Matrix]]:
  def copy(): Matrix

  def setIdentity(): Matrix

  def :=(m: Matrix): Matrix

  def det(): Double

  def transpose(): Matrix

  def transposed(): Matrix = copy().transpose()

  def invert(): Matrix

  def inverted(): Matrix = copy().invert()

  def isEquals(matrix: Matrix, eps: Double): Boolean

  /* Matrix arithmetics */

  def *(right: Matrix): Matrix

  def *=(right: Matrix): Matrix

  def *>(right: Matrix): Matrix

  def +=(m: Matrix): Matrix

  def +(m: Matrix): Matrix

  def -=(m: Matrix): Matrix

  def -(m: Matrix): Matrix

  def madd(m: Matrix, v: Double): Matrix

  /* multiplication to scalar */

  def *=(v: Double): Matrix

  def *(v: Double): Matrix = this.copy() *= v

  def /(v: Double): Matrix = this * (1.0 / v)

  def /=(v: Double): Matrix = this *= (1.0 / v)
