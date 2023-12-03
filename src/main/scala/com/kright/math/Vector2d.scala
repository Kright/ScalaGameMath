package com.kright.math

trait IVector2d extends IVectorNd[IVector2d, Vector2d]:
  def x: Double
  def y: Double

  override def copy(): Vector2d =
    new Vector2d(x, y)

  override def dot(v: IVector2d): Double =
    x * v.x + y * v.y

  def squareDistance(v: IVector2d): Double =
    val dx = x - v.x
    val dy = y - v.y
    dx * dx + dy * dy

  override def isEquals(v: IVector2d, eps: Double = 0.000001): Boolean =
    Math.abs(x - v.x) < eps && Math.abs(y - v.y) < eps


final case class Vector2d(var x: Double,
                          var y: Double) extends IVector2d with VectorNd[IVector2d, Vector2d]:

  def :=(x: Double, y: Double): Vector2d =
    this.x = x
    this.y = y
    this

  override def :=(v: IVector2d): Vector2d =
    setPerElement(v)((_, c) => c)

  override def +=(v: IVector2d): Vector2d =
    setPerElement(v)(_ + _)

  override def -=(v: IVector2d): Vector2d =
    setPerElement(v)(_ - _)

  override def *=(v: IVector2d): Vector2d =
    setPerElement(v)(_ * _)

  override def *=(m: Double): Vector2d =
    setPerElement(_ * m)

  override def madd(v: IVector2d, multiplier: Double): Vector2d =
    setPerElement(v)(_ + _ * multiplier)

  override def /=(v: IVector2d): Vector2d =
    setPerElement(v)(_ / _)

  override def ^=(v: IVector2d): Vector2d =
    setPerElement(v)(Math.pow)

  override def ^=(pow: Double): Vector2d =
    setPerElement(Math.pow(_, pow))

  override def setMin(v: IVector2d): Vector2d =
    setPerElement(v)(Math.min)

  override def setMax(v: IVector2d): Vector2d =
    setPerElement(v)(Math.max)

  def sin(v: IVector2d): Double =
    (x * v.y - y * v.x) / Math.sqrt(squareMag * v.squareMag)

  override def toString: String = s"Vector2d($x, $y)"

  private inline def setPerElement(v: IVector2d)(inline f: (Double, Double) => Double): Vector2d =
    x = f(x, v.x)
    y = f(y, v.y)
    this

  private inline def setPerElement(inline f: Double => Double): Vector2d =
    x = f(x)
    y = f(y)
    this


object Vector2d extends ZeroFactory[Vector2d]:
  inline def apply(x: Double = 0.0, y: Double = 0.0): Vector2d =
    new Vector2d(x, y)

  override def zero: Vector2d =
    new Vector2d(0.0, 0.0)
