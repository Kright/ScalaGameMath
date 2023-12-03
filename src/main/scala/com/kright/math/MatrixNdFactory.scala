package com.kright.math

trait MatrixNdFactory[Matrix <: MatrixNd[Matrix]] extends ZeroFactory[Matrix] with IdentityFactory[Matrix]:
  extension (d: Double)
    inline def *(m: Matrix): Matrix = m * d
