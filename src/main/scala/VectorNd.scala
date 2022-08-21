package com.kright.math

trait IVectorNd[IVec <: IVectorNd[_, _], Vec]:
  self: IVec =>

  def +(v: IVec): Vec
  def -(v: IVec): Vec
  def *(v: IVec): Vec
  def *(m: Double): Vec
  def /(v: IVec): Vec
  def /(d: Double): Vec = this * (1.0 / d)
  def unary_- : Vec = this * (-1)

  def min(v: IVec): Vec
  def max(v: IVec): Vec
  def clamp(lower: IVec, upper: IVec): Vec

  def dot(v: IVec): Double
  def cos(v: IVec): Double = this.dot(v) / Math.sqrt(this.squareMag + v.squareMag)
  def normalized(): Vec = this / this.mag

  def squareMag: Double = this.dot(this)
  def mag: Double = Math.sqrt(squareMag)

  def squareDistance(v: IVec): Double
  def distance(v: IVec): Double = Math.sqrt(squareDistance(v))

  def isEquals(v: IVec, eps: Double = 0.000001): Boolean


trait VectorNd[IVec <: IVectorNd[_, _], Vec] extends IVectorNd[IVec, Vec]:
  self: Vec & IVec =>

  def :=(v: IVec): Vec

  def +=(v: IVec): Vec
  def -=(v: IVec): Vec
  def *=(v: IVec): Vec
  def *=(m: Double): Vec
  def madd(v: IVec, multiplier: Double): Vec
  def /=(v: IVec): Vec
  def /=(d: Double): Vec = this *= (1.0 / d)

  def setMin(v: IVec): Vec
  def setMax(v: IVec): Vec
  def setClamp(lower: IVec, upper: IVec): Vec

  def normalize(): Vec = this /= this.mag
