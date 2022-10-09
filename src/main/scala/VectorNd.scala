package com.kright.math

trait IVectorNd[IVec <: IVectorNd[_, _], Vec <: VectorNd[IVec, Vec]]:
  self: IVec =>
  
  def copy(): Vec

  def +(v: IVec): Vec = copy() += v
  def -(v: IVec): Vec = copy() -= v
  def *(v: IVec): Vec = copy() *= v
  def *(m: Double): Vec = copy() *= m
  def /(v: IVec): Vec = copy() /= v
  def /(d: Double): Vec = this * (1.0 / d)
  def ^(pow: Double): Vec = copy() ^= pow
  def ^(v: IVec): Vec = copy() ^= v
  def unary_- : Vec = this * (-1)

  def min(v: IVec): Vec = copy().setMin(v)
  def max(v: IVec): Vec = copy().setMax(v)
  def clamp(lower: IVec, upper: IVec): Vec = max(lower).setMin(upper)

  def dot(v: IVec): Double
  def cos(v: IVec): Double = this.dot(v) / Math.sqrt(this.squareMag * v.squareMag)
  def normalized(): Vec = this / this.mag

  def squareMag: Double = this.dot(this)
  def mag: Double = Math.sqrt(squareMag)

  def squareDistance(v: IVec): Double
  def distance(v: IVec): Double = Math.sqrt(squareDistance(v))

  def isEquals(v: IVec, eps: Double = 0.000001): Boolean


trait VectorNd[IVec <: IVectorNd[_, _], Vec <: VectorNd[IVec, Vec]] extends IVectorNd[IVec, Vec]:
  self: Vec & IVec =>

  def :=(v: IVec): Vec

  def +=(v: IVec): Vec
  def -=(v: IVec): Vec
  def *=(v: IVec): Vec
  def *=(m: Double): Vec
  def madd(v: IVec, multiplier: Double): Vec
  def /=(v: IVec): Vec
  def /=(d: Double): Vec = this *= (1.0 / d)
  def ^=(v: IVec): Vec
  def ^=(pow: Double): Vec

  def setMin(v: IVec): Vec
  def setMax(v: IVec): Vec
  def setClamp(lower: IVec, upper: IVec): Vec = setMax(lower).setMin(upper)

  def normalize(): Vec = this /= this.mag
