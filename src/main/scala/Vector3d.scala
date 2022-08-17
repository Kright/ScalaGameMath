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

  override def min(v: IVector3d): Vector3d =
    new Vector3d(math.min(x, v.x), math.min(y, v.y), math.min(z, v.z))

  override def max(v: IVector3d): Vector3d =
    new Vector3d(math.max(x, v.x), math.max(y, v.y), math.max(z, v.z))

  override def clamp(lower: IVector3d, upper: IVector3d): Vector3d =
    new Vector3d(math.min(upper.x, math.max(x, lower.x)), math.min(upper.y, math.max(y, lower.y)), math.min(upper.z, math.max(z, lower.z)))

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
    math.sqrt(cross(v).squareMag / (squareMag * v.squareMag))

  override def isEquals(v: IVector3d, eps: Double = 0.000001): Boolean =
    math.abs(x - v.x) < eps && math.abs(y - v.y) < eps && math.abs(z - v.z) < eps


final class Vector3d(var x:Double = 0.0,
                     var y:Double = 0.0,
                     var z:Double = 0.0) extends IVector3d with VectorNd[IVector3d, Vector3d]:

  def :=(x: Double,y: Double,z: Double): Unit =
    this.x = x
    this.y = y
    this.z = z

  override def :=(v: IVector3d): Unit =
    x = v.x
    y = v.y
    z = v.z

  override def +=(v: IVector3d): Unit =
    x += v.x
    y += v.y
    z += v.z

  override def -=(v: IVector3d): Unit =
    x -= v.x
    y -= v.y
    z -= v.z

  override def *=(v: IVector3d): Unit =
    x *= v.x
    y *= v.y
    z *= v.z

  override def *=(m: Double): Unit =
    x *= m
    y *= m
    z *= m

  override def madd(v: IVector3d, multiplier: Double): Unit =
    x += v.x * multiplier
    y += v.y * multiplier
    z += v.z * multiplier

  override def /=(v: IVector3d): Unit =
    x /= v.x
    y /= v.y
    z /= v.z

  override def setMin(v: IVector3d): Unit =
    x = math.min(x, v.x)
    y = math.min(y, v.y)
    z = math.min(z, v.z)

  override def setMax(v: IVector3d): Unit =
    x = math.max(x, v.x)
    y = math.max(y, v.y)
    z = math.max(z, v.z)

  override def setClamp(lower: IVector3d, upper: IVector3d): Unit =
    x = math.min(upper.x, math.max(x, lower.x))
    y = math.min(upper.y, math.max(y, lower.y))
    z = math.min(upper.z, math.max(z, lower.z))

  def setCross(f: IVector3d, s: IVector3d): Unit =
    this :=(f.y * s.z - f.z * s.y,
            f.z * s.x - f.x * s.z,
            f.x * s.y - f.y * s.x)

  override def toString: String = s"Vector3d($x, $y, $z)"


object Vector3d:
  def apply(x: Double = 0.0, y: Double = 0.0, z: Double = 0.0): Vector3d =
    new Vector3d(x, y, z)
