package com.kright.math

trait IVector2d extends IVectorNd[IVector2d, Vector2d]:
  def x: Double
  def y: Double

  override def +(v: IVector2d): Vector2d =
    new Vector2d(x + v.x, y + v.y)

  override def -(v: IVector2d): Vector2d =
    new Vector2d(x - v.x, y - v.y)

  override def *(v: IVector2d): Vector2d =
    new Vector2d(x * v.x, y * v.y)

  override def *(m: Double): Vector2d =
    new Vector2d(x * m, y * m)

  override def /(v: IVector2d): Vector2d =
    new Vector2d(x / v.x, y / v.y)

  override def min(v: IVector2d): Vector2d =
    new Vector2d(Math.min(x, v.x), Math.min(y, v.y))

  override def max(v: IVector2d): Vector2d =
    new Vector2d(Math.max(x, v.x), Math.max(y, v.y))

  override def clamp(lower: IVector2d, upper: IVector2d): Vector2d =
    new Vector2d(Math.min(upper.x, Math.max(x, lower.x)), Math.min(upper.y, Math.max(y, lower.y)))

  override def dot(v: IVector2d): Double =
    x * v.x + y * v.y

  def squareDistance(v: IVector2d): Double =
    val dx = x - v.x
    val dy = y - v.y
    dx * dx + dy * dy

  override def isEquals(v: IVector2d, eps: Double = 0.000001): Boolean =
    Math.abs(x - v.x) < eps && Math.abs(y - v.y) < eps


final class Vector2d(var x: Double = 0.0,
                     var y: Double = 0.0) extends IVector2d with VectorNd[IVector2d, Vector2d]:

  inline def :=(x: Double,y: Double): Vector2d =
    this.x = x
    this.y = y
    this

  override def :=(v: IVector2d): Vector2d =
    x = v.x
    y = v.y
    this

  override def +=(v: IVector2d): Vector2d =
    x += v.x
    y += v.y
    this

  override def -=(v: IVector2d): Vector2d =
    x -= v.x
    y -= v.y
    this

  override def *=(v: IVector2d): Vector2d =
    x *= v.x
    y *= v.y
    this

  override def *=(m: Double): Vector2d =
    x *= m
    y *= m
    this

  override def madd(v: IVector2d, multiplier: Double): Vector2d =
    x += v.x * multiplier
    y += v.y * multiplier
    this

  override def /=(v: IVector2d): Vector2d =
    x /= v.x
    y /= v.y
    this

  override def setMin(v: IVector2d): Vector2d =
    x = Math.min(x, v.x)
    y = Math.min(y, v.y)
    this

  override def setMax(v: IVector2d): Vector2d =
    x = Math.max(x, v.x)
    y = Math.max(y, v.y)
    this

  override def setClamp(lower: IVector2d, upper: IVector2d): Vector2d =
    x = Math.min(upper.x, Math.max(x, lower.x))
    y = Math.min(upper.y, Math.max(y, lower.y))
    this

  def sin(v: IVector2d): Double =
    (x * v.y - y * v.x) / Math.sqrt(squareMag * v.squareMag)
  
  override def toString: String = s"Vector2d($x, $y)"


object Vector2d:
  def apply(x: Double = 0.0, y: Double = 0.0): Vector2d =
    new Vector2d(x, y)
