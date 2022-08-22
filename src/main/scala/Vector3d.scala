package com.kright.math

trait IVector3d extends IVectorNd[IVector3d, Vector3d]:
  def x: Double
  def y: Double
  def z: Double

  override def +(v: IVector3d): Vector3d =
    new Vector3d(x + v.x, y + v.y, z + v.z)

  override def -(v: IVector3d): Vector3d =
    new Vector3d(x - v.x, y - v.y, z - v.z)

  override def *(v: IVector3d): Vector3d =
    new Vector3d(x * v.x, y * v.y, z * v.z)

  override def *(m: Double): Vector3d =
    new Vector3d(x * m, y * m, z * m)

  override def /(v: IVector3d): Vector3d =
    new Vector3d(x / v.x, y / v.y, z / v.z)

  override def ^(v: IVector3d): Vector3d =
    new Vector3d(Math.pow(x, v.x), Math.pow(y, v.y), Math.pow(z, v.z))

  override def ^(pow: Double): Vector3d =
    new Vector3d(Math.pow(x, pow), Math.pow(y, pow), Math.pow(z, pow))

  override def min(v: IVector3d): Vector3d =
    new Vector3d(Math.min(x, v.x), Math.min(y, v.y), Math.min(z, v.z))

  override def max(v: IVector3d): Vector3d =
    new Vector3d(Math.max(x, v.x), Math.max(y, v.y), Math.max(z, v.z))

  override def clamp(lower: IVector3d, upper: IVector3d): Vector3d =
    new Vector3d(Math.min(upper.x, Math.max(x, lower.x)), Math.min(upper.y, Math.max(y, lower.y)), Math.min(upper.z, Math.max(z, lower.z)))

  override def dot(v: IVector3d): Double =
    x * v.x + y * v.y + z * v.z

  override def squareDistance(v: IVector3d): Double =
    val dx = x - v.x
    val dy = y - v.y
    val dz = z - v.z
    dx * dx + dy * dy + dz * dz

  def cross(v: IVector3d): Vector3d =
    new Vector3d(y * v.z - z * v.y,
                 z * v.x - x * v.z,
                 x * v.y - y * v.x)

  def sin(v: IVector3d): Double =
    Math.sqrt(cross(v).squareMag / (squareMag * v.squareMag))

  override def isEquals(v: IVector3d, eps: Double = 0.000001): Boolean =
    Math.abs(x - v.x) < eps && Math.abs(y - v.y) < eps && Math.abs(z - v.z) < eps


final class Vector3d(var x:Double = 0.0,
                     var y:Double = 0.0,
                     var z:Double = 0.0) extends IVector3d with VectorNd[IVector3d, Vector3d]:

  def :=(x: Double,y: Double,z: Double): Vector3d =
    this.x = x
    this.y = y
    this.z = z
    this

  override def :=(v: IVector3d): Vector3d =
    x = v.x
    y = v.y
    z = v.z
    this

  override def +=(v: IVector3d): Vector3d =
    x += v.x
    y += v.y
    z += v.z
    this

  override def -=(v: IVector3d): Vector3d =
    x -= v.x
    y -= v.y
    z -= v.z
    this

  override def *=(v: IVector3d): Vector3d =
    x *= v.x
    y *= v.y
    z *= v.z
    this

  override def *=(m: Double): Vector3d =
    x *= m
    y *= m
    z *= m
    this

  override def madd(v: IVector3d, multiplier: Double): Vector3d =
    x += v.x * multiplier
    y += v.y * multiplier
    z += v.z * multiplier
    this

  override def /=(v: IVector3d): Vector3d =
    x /= v.x
    y /= v.y
    z /= v.z
    this

  override def ^=(v: IVector3d): Vector3d =
    x = Math.pow(x, v.x)
    y = Math.pow(y, v.y)
    z = Math.pow(z, v.z)
    this

  override def ^=(pow: Double): Vector3d =
    x = Math.pow(x, pow)
    y = Math.pow(y, pow)
    z = Math.pow(z, pow)
    this

  override def setMin(v: IVector3d): Vector3d =
    x = Math.min(x, v.x)
    y = Math.min(y, v.y)
    z = Math.min(z, v.z)
    this

  override def setMax(v: IVector3d): Vector3d =
    x = Math.max(x, v.x)
    y = Math.max(y, v.y)
    z = Math.max(z, v.z)
    this

  override def setClamp(lower: IVector3d, upper: IVector3d): Vector3d =
    x = Math.min(upper.x, Math.max(x, lower.x))
    y = Math.min(upper.y, Math.max(y, lower.y))
    z = Math.min(upper.z, Math.max(z, lower.z))
    this

  def setCross(f: IVector3d, s: IVector3d): Vector3d =
    this :=(f.y * s.z - f.z * s.y,
            f.z * s.x - f.x * s.z,
            f.x * s.y - f.y * s.x)

  override def toString: String = s"Vector3d($x, $y, $z)"


object Vector3d:
  def apply(x: Double = 0.0, y: Double = 0.0, z: Double = 0.0): Vector3d =
    new Vector3d(x, y, z)
