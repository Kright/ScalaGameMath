package com.kright.math

trait IVector3d extends IVectorNd[IVector3d, Vector3d]:
  def x: Double
  def y: Double
  def z: Double

  override def copy(): Vector3d =
    new Vector3d(x, y, z)

  override infix def dot(v: IVector3d): Double =
    x * v.x + y * v.y + z * v.z

  override def squareDistance(v: IVector3d): Double =
    val dx = x - v.x
    val dy = y - v.y
    val dz = z - v.z
    dx * dx + dy * dy + dz * dz

  def cross(v: IVector3d): Vector3d =
    new Vector3d(
      y * v.z - z * v.y,
      z * v.x - x * v.z,
      x * v.y - y * v.x
    )

  def sin(v: IVector3d): Double =
    Math.sqrt(cross(v).squareMag / (squareMag * v.squareMag))

  override def isEquals(v: IVector3d, eps: Double = 0.000001): Boolean =
    Math.abs(x - v.x) < eps && Math.abs(y - v.y) < eps && Math.abs(z - v.z) < eps


final case class Vector3d(var x: Double,
                          var y: Double,
                          var z: Double) extends IVector3d with VectorNd[IVector3d, Vector3d]:

  def :=(x: Double, y: Double, z: Double): Vector3d =
    this.x = x
    this.y = y
    this.z = z
    this

  override def :=(v: IVector3d): Vector3d =
    setPerElement(v)((_, c) => c)

  override def +=(v: IVector3d): Vector3d =
    setPerElement(v)(_ + _)

  override def -=(v: IVector3d): Vector3d =
    setPerElement(v)(_ - _)

  override def *=(v: IVector3d): Vector3d =
    setPerElement(v)(_ * _)

  override def *=(m: Double): Vector3d =
    setPerElement(_ * m)

  override def madd(v: IVector3d, multiplier: Double): Vector3d =
    setPerElement(v)(_ + _ * multiplier)

  override def /=(v: IVector3d): Vector3d =
    setPerElement(v)(_ / _)

  override def ^=(v: IVector3d): Vector3d =
    setPerElement(v)(Math.pow)

  override def ^=(pow: Double): Vector3d =
    setPerElement(Math.pow(_, pow))

  override def setMin(v: IVector3d): Vector3d =
    setPerElement(v)(Math.min)

  override def setMax(v: IVector3d): Vector3d =
    setPerElement(v)(Math.max)

  def setCross(f: IVector3d, s: IVector3d): Vector3d =
    this := (
      f.y * s.z - f.z * s.y,
      f.z * s.x - f.x * s.z,
      f.x * s.y - f.y * s.x
    )

  def addCross(f: IVector3d, s: IVector3d): Vector3d =
    this := (
      this.x + f.y * s.z - f.z * s.y,
      this.y + f.z * s.x - f.x * s.z,
      this.z + f.x * s.y - f.y * s.x
    )

  override def toString: String = s"Vector3d($x, $y, $z)"

  private inline def setPerElement(v: IVector3d)(inline f: (Double, Double) => Double): Vector3d =
    x = f(x, v.x)
    y = f(y, v.y)
    z = f(z, v.z)
    this

  private inline def setPerElement(inline f: Double => Double): Vector3d =
    x = f(x)
    y = f(y)
    z = f(z)
    this


object Vector3d extends ZeroFactory[Vector3d]:
  inline def apply(x: Double = 0.0, y: Double = 0.0, z: Double = 0.0): Vector3d =
    new Vector3d(x, y, z)

  override def zero: Vector3d = 
    new Vector3d(0.0, 0.0, 0.0)
