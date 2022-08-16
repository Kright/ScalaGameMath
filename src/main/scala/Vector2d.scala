package com.kright.math

trait IVector2d:
  def x: Double
  def y: Double

  def +(v: IVector2d): Vector2d =
    new Vector2d(x + v.x, y + v.y)

  def -(v: IVector2d): Vector2d =
    new Vector2d(x - v.x, y - v.y)

  def *(v: IVector2d): Vector2d =
    new Vector2d(x * v.x, y * v.y)

  def *(m: Double): Vector2d =
    new Vector2d(x * m, y * m)

  def /(v: IVector2d): Vector2d =
    new Vector2d(x / v.x, y / v.y)

  def /(d: Double): Vector2d =
    new Vector2d(x / d, y / d)

  def min(v: IVector2d): Vector2d =
    new Vector2d(math.min(x, v.x), math.min(y, v.y))

  def max(v: IVector2d): Vector2d =
    new Vector2d(math.max(x, v.x), math.max(y, v.y))

  def clamp(lower: IVector2d, upper: IVector2d): Vector2d =
    new Vector2d(math.min(upper.x, math.max(x, lower.x)), math.min(upper.y, math.max(y, lower.y)))

  def squareMag: Double =
    x * x + y * y

  def mag: Double =
    math.sqrt(x * x + y * y)

  def dot(v: IVector2d): Double =
    x * v.x + y * v.y

  def cos(v: IVector2d): Double =
    this.dot(v) / math.sqrt(this.squareMag * v.squareMag)

  def normalized(): Vector2d =
    this / this.mag

  def distance(v: IVector2d): Double =
    val dx = x - v.x
    val dy = y - v.y
    math.sqrt(dx * dx + dy * dy)

  def squareDistance(v: IVector2d): Double =
    val dx = x - v.x
    val dy = y - v.y
    dx * dx + dy * dy

  def isEqual(v: Vector2d, eps: Double = 0.000001): Boolean =
    math.abs(x - v.x) < eps && math.abs(y - v.y) < eps


class Vector2d(var x: Double = 0.0,
               var y: Double = 0.0) extends IVector2d:

  def :=(x: Double,y: Double): Unit =
    this.x = x
    this.y = y

  def :=(v: IVector2d): Unit =
    x = v.x
    y = v.y

  def +=(v: IVector2d): Unit =
    x += v.x
    y += v.y

  def -=(v: IVector2d): Unit =
    x -= v.x
    y -= v.y

  def *=(v: IVector2d): Unit =
    x *= v.x
    y *= v.y

  def *=(m: Double): Unit =
    x *= m
    y *= m

  def madd(v: IVector2d, multiplier: Double): Unit =
    x += v.x * multiplier
    y += v.y * multiplier

  def /=(v: IVector2d): Unit =
    x /= v.x
    y /= v.y

  def /=(d: Double): Unit =
    x /= d
    y /= d

  def setMin(v: IVector2d): Unit =
    x = math.min(x, v.x)
    y = math.min(y, v.y)

  def setMax(v: IVector2d): Unit =
    x = math.max(x, v.x)
    y = math.max(y, v.y)

  def setClamp(lower: IVector2d, upper: IVector2d): Unit =
    x = math.min(upper.x, math.max(x, lower.x))
    y = math.min(upper.y, math.max(y, lower.y))

  def normalize(): Unit =
    this /= this.mag
  
  override def toString: String = s"Vector2d($x, $y)"


object Vector2d:
  def apply(x: Double = 0.0, y: Double = 0.0): Vector2d =
    new Vector2d(x, y)
