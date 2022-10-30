package com.kright.math

trait IVector4d extends IVectorNd[IVector4d, Vector4d]:
  def x: Double
  def y: Double
  def z: Double
  def w: Double

  override def copy(): Vector4d =
    new Vector4d(x, y, z, w)

  override def dot(v: IVector4d): Double =
    x * v.x + y * v.y + z * v.z + w * v.w

  override def squareDistance(v: IVector4d): Double =
    val dx = x - v.x
    val dy = y - v.y
    val dz = z - v.z
    val dw = w - v.w
    dx * dx + dy * dy + dz * dz + dw * dw

  override def isEquals(v: IVector4d, eps: Double = 0.000001): Boolean =
    Math.abs(x - v.x) < eps && Math.abs(y - v.y) < eps && Math.abs(z - v.z) < eps


final case class Vector4d(var x: Double,
                          var y: Double,
                          var z: Double,
                          var w: Double) extends IVector4d with VectorNd[IVector4d, Vector4d]:

  def :=(x: Double, y: Double, z: Double, w: Double): Vector4d =
    this.x = x
    this.y = y
    this.z = z
    this.w = w
    this

  override def :=(v: IVector4d): Vector4d =
    setPerElement(v)((_, c) => c)

  override def +=(v: IVector4d): Vector4d =
    setPerElement(v)(_ + _)

  override def -=(v: IVector4d): Vector4d =
    setPerElement(v)(_ - _)

  override def *=(v: IVector4d): Vector4d =
    setPerElement(v)(_ * _)

  override def *=(m: Double): Vector4d =
    setPerElement(_ * m)

  override def madd(v: IVector4d, multiplier: Double): Vector4d =
    setPerElement(v)(_ + _ * multiplier)

  override def /=(v: IVector4d): Vector4d =
    setPerElement(v)(_ / _)

  override def ^=(v: IVector4d): Vector4d =
    setPerElement(v)(Math.pow)

  override def ^=(pow: Double): Vector4d =
    setPerElement(Math.pow(_, pow))

  override def setMin(v: IVector4d): Vector4d =
    setPerElement(v)(Math.min)

  override def setMax(v: IVector4d): Vector4d =
    setPerElement(v)(Math.max)

  override def toString: String = s"Vector4d($x, $y, $z, $w)"

  private inline def setPerElement(v: IVector4d)(inline f: (Double, Double) => Double): Vector4d =
    x = f(x, v.x)
    y = f(y, v.y)
    z = f(z, v.z)
    w = f(w, v.w)
    this

  private inline def setPerElement(inline f: Double => Double): Vector4d =
    x = f(x)
    y = f(y)
    z = f(z)
    w = f(w)
    this


object Vector4d:
  inline def apply(x: Double = 0.0, y: Double = 0.0, z: Double = 0.0, w: Double = 0.0): Vector4d =
    new Vector4d(x, y, z, w)
