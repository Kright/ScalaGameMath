package com.kright.math

trait IVectorNd[IVec, Vec]:
  def copy(): Vec

  def +(v: IVec): Vec
  def -(v: IVec): Vec
  def *(v: IVec): Vec
  def *(m: Double): Vec
  def /(v: IVec): Vec
  def /(d: Double): Vec = this * (1.0 / d)
  def ^(pow: Double): Vec
  def ^(v: IVec): Vec
  def unary_- : Vec = this * (-1)

  def min(v: IVec): Vec
  def max(v: IVec): Vec
  def clamp(lower: IVec, upper: IVec): Vec

  def dot(v: IVec): Double
  def cos(v: IVec): Double
  def projected(axis: IVec): Vec
  def unprojected(axix: IVec): Vec
  def normalized(): Vec = this / this.mag

  def squareMag: Double
  def mag: Double = Math.sqrt(squareMag)

  def squareDistance(v: IVec): Double
  def distance(v: IVec): Double = Math.sqrt(squareDistance(v))

  def isEquals(v: IVec, eps: Double = 0.000001): Boolean


object IVectorNd:
  extension (m: Double)
    inline def *[IVec, Vec](v: IVectorNd[IVec, Vec]): Vec =
      v * m


trait VectorNd[IVec <: IVectorNd[_, _], Vec <: VectorNd[IVec, Vec]] extends IVectorNd[IVec, Vec]:
  self: Vec & IVec =>

  override def +(v: IVec): Vec = copy() += v
  override def -(v: IVec): Vec = copy() -= v
  override def *(v: IVec): Vec = copy() *= v
  override def *(m: Double): Vec = copy() *= m
  override def /(v: IVec): Vec = copy() /= v
  override def ^(pow: Double): Vec = copy() ^= pow
  override def ^(v: IVec): Vec = copy() ^= v
  override def min(v: IVec): Vec = copy().setMin(v)
  override def max(v: IVec): Vec = copy().setMax(v)
  override def clamp(lower: IVec, upper: IVec): Vec = max(lower).setMin(upper)
  override def cos(v: IVec): Double = this.dot(v) / Math.sqrt(this.squareMag * v.squareMag)
  override def projected(axis: IVec): Vec = copy().setProjected(axis)
  override def unprojected(axis: IVec): Vec = copy().setUnprojected(axis)
  override def squareMag: Double = this.dot(this)

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

  def setProjected(axis: IVec): Vec =
    val m = this.dot(axis) / axis.squareMag
    this := axis
    this *= m

  def setUnprojected(axis: IVec): Vec =
    val m = this.dot(axis) / axis.squareMag
    this.madd(axis, -m)

  def normalize(): Vec = this /= this.mag
