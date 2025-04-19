package com.github.kright.math

trait MatrixNdFactory[Matrix <: MatrixNd[Matrix]]:
  extension (d: Double)
    inline def *(m: Matrix): Matrix = m * d

  def zero: Matrix
  
  def id: Matrix
