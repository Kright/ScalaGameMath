package com.github.kright.pga3dphysics

case class Point(wxy: Double,
                 wxz: Double,
                 wyz: Double,
                 xyz: Double):

  inline def x = -wyz

  inline def y = wxz

  inline def z = -wxy

  inline def w = xyz

case class NormalizedPoint(wxy: Double,
                           wxz: Double,
                           wyz: Double):

  inline def x = -wyz

  inline def y = wxz

  inline def z = -wxy

  inline def w = 1

case class Vector(wxy: Double,
                  wxz: Double,
                  wyz: Double):
  inline def x = -wyz

  inline def y = wxz

  inline def z = -wxy

  inline def w = 0

case class Plane(x: Double,
                 y: Double,
                 z: Double,
                 w: Double):
  def bulkNormSquare: Double =
    x * x + y * y + z * z

  def normalized: NormalizedPlane =
    val nrmSquare = bulkNormSquare
    if (nrmSquare > 1e-200) {
      val m = 1.0 / Math.sqrt(nrmSquare)
      NormalizedPlane(x * m, y * m, z * m, w * m)
    } else {
      NormalizedPlane(x = 1.0, 0.0, 0.0, 0.0)
    }

case class NormalizedPlane(x: Double = 0.0,
                           y: Double = 0.0,
                           z: Double = 0.0,
                           w: Double = 0.0)


case class Bivector(wx: Double,
                    wy: Double,
                    wz: Double,
                    xy: Double,
                    xz: Double,
                    yz: Double):
  def exp(): Motor = ???

case class Motor(var s: Double,
                 var wx: Double,
                 var wy: Double,
                 var wz: Double,
                 var xy: Double,
                 var xz: Double,
                 var yz: Double,
                 var i: Double):
  def log(): Bivector = ???

  def apply(v: Point): Point =
    Point(
      wxy = (s * s * v.wxy + v.wxy * xy * xy - 2.0 * s * v.wyz * xz - 2.0 * v.xyz * wx * xz - 2.0 * v.xyz * wy * yz - v.wxy * xz * xz - v.wxy * yz * yz + 2.0 * i * v.xyz * xy + 2.0 * s * v.wxz * yz + 2.0 * s * v.xyz * wz + 2.0 * v.wxz * xy * xz + 2.0 * v.wyz * xy * yz),
      wxz = (s * s * v.wxz + v.wxz * xz * xz - 2.0 * s * v.wxy * yz - 2.0 * s * v.xyz * wy - 2.0 * v.xyz * wz * yz - v.wxz * xy * xy - v.wxz * yz * yz + 2.0 * i * v.xyz * xz + 2.0 * s * v.wyz * xy + 2.0 * v.wxy * xy * xz + 2.0 * v.wyz * xz * yz + 2.0 * v.xyz * wx * xy),
      wyz = (s * s * v.wyz + v.wyz * yz * yz - 2.0 * s * v.wxz * xy - v.wyz * xy * xy - v.wyz * xz * xz + 2.0 * i * v.xyz * yz + 2.0 * s * v.wxy * xz + 2.0 * s * v.xyz * wx + 2.0 * v.wxy * xy * yz + 2.0 * v.wxz * xz * yz + 2.0 * v.xyz * wy * xy + 2.0 * v.xyz * wz * xz),
      xyz = v.xyz,
    )

  def apply(v: NormalizedPoint) = NormalizedPoint(
    wxy = (-2.0 * wx * xz - 2.0 * wy * yz + 2.0 * i * xy + 2.0 * s * wz + s * s * v.wxy + v.wxy * xy * xy - 2.0 * s * v.wyz * xz - v.wxy * xz * xz - v.wxy * yz * yz + 2.0 * s * v.wxz * yz + 2.0 * v.wxz * xy * xz + 2.0 * v.wyz * xy * yz),
    wxz = (-2.0 * s * wy - 2.0 * wz * yz + 2.0 * i * xz + 2.0 * wx * xy + s * s * v.wxz + v.wxz * xz * xz - 2.0 * s * v.wxy * yz - v.wxz * xy * xy - v.wxz * yz * yz + 2.0 * s * v.wyz * xy + 2.0 * v.wxy * xy * xz + 2.0 * v.wyz * xz * yz),
    wyz = (2.0 * i * yz + 2.0 * s * wx + 2.0 * wy * xy + 2.0 * wz * xz + s * s * v.wyz + v.wyz * yz * yz - 2.0 * s * v.wxz * xy - v.wyz * xy * xy - v.wyz * xz * xz + 2.0 * s * v.wxy * xz + 2.0 * v.wxy * xy * yz + 2.0 * v.wxz * xz * yz),
  )

  def apply(v: Vector): Vector = Vector(
    wxy = (s * s * v.wxy + v.wxy * xy * xy - 2.0 * s * v.wyz * xz - v.wxy * xz * xz - v.wxy * yz * yz + 2.0 * s * v.wxz * yz + 2.0 * v.wxz * xy * xz + 2.0 * v.wyz * xy * yz),
    wxz = (s * s * v.wxz + v.wxz * xz * xz - 2.0 * s * v.wxy * yz - v.wxz * xy * xy - v.wxz * yz * yz + 2.0 * s * v.wyz * xy + 2.0 * v.wxy * xy * xz + 2.0 * v.wyz * xz * yz),
    wyz = (s * s * v.wyz + v.wyz * yz * yz - 2.0 * s * v.wxz * xy - v.wyz * xy * xy - v.wyz * xz * xz + 2.0 * s * v.wxy * xz + 2.0 * v.wxy * xy * yz + 2.0 * v.wxz * xz * yz),
  )

  def apply(v: Plane): Plane = Plane(
    w = (s * s * v.w + v.w * xy * xy + v.w * xz * xz + v.w * yz * yz - 2.0 * i * v.y * xz - 2.0 * v.x * wy * xy - 2.0 * v.x * wz * xz - 2.0 * v.y * wz * yz + 2.0 * i * v.x * yz + 2.0 * i * v.z * xy + 2.0 * s * v.x * wx + 2.0 * s * v.y * wy + 2.0 * s * v.z * wz + 2.0 * v.y * wx * xy + 2.0 * v.z * wx * xz + 2.0 * v.z * wy * yz),
    x = (s * s * v.x + v.x * yz * yz - 2.0 * v.y * xz * yz - v.x * xy * xy - v.x * xz * xz + 2.0 * s * v.y * xy + 2.0 * s * v.z * xz + 2.0 * v.z * xy * yz),
    y = (s * s * v.y + v.y * xz * xz - 2.0 * s * v.x * xy - 2.0 * v.x * xz * yz - 2.0 * v.z * xy * xz - v.y * xy * xy - v.y * yz * yz + 2.0 * s * v.z * yz),
    z = (s * s * v.z + v.z * xy * xy - 2.0 * s * v.x * xz - 2.0 * s * v.y * yz - 2.0 * v.y * xy * xz - v.z * xz * xz - v.z * yz * yz + 2.0 * v.x * xy * yz),
  )

  def apply(v: NormalizedPlane): NormalizedPlane = NormalizedPlane(
    w = (s * s * v.w + v.w * xy * xy + v.w * xz * xz + v.w * yz * yz - 2.0 * i * v.y * xz - 2.0 * v.x * wy * xy - 2.0 * v.x * wz * xz - 2.0 * v.y * wz * yz + 2.0 * i * v.x * yz + 2.0 * i * v.z * xy + 2.0 * s * v.x * wx + 2.0 * s * v.y * wy + 2.0 * s * v.z * wz + 2.0 * v.y * wx * xy + 2.0 * v.z * wx * xz + 2.0 * v.z * wy * yz),
    x = (s * s * v.x + v.x * yz * yz - 2.0 * v.y * xz * yz - v.x * xy * xy - v.x * xz * xz + 2.0 * s * v.y * xy + 2.0 * s * v.z * xz + 2.0 * v.z * xy * yz),
    y = (s * s * v.y + v.y * xz * xz - 2.0 * s * v.x * xy - 2.0 * v.x * xz * yz - 2.0 * v.z * xy * xz - v.y * xy * xy - v.y * yz * yz + 2.0 * s * v.z * yz),
    z = (s * s * v.z + v.z * xy * xy - 2.0 * s * v.x * xz - 2.0 * s * v.y * yz - 2.0 * v.y * xy * xz - v.z * xz * xz - v.z * yz * yz + 2.0 * v.x * xy * yz),
  )

  def apply(v: Bivector): Bivector = Bivector(
    wx = (s * s * v.wx + v.wx * yz * yz - 2.0 * i * s * v.yz - 2.0 * i * v.xy * xz - 2.0 * s * v.xy * wy - 2.0 * s * v.xz * wz - 2.0 * v.wy * xz * yz - 2.0 * v.xz * wy * yz - 2.0 * v.yz * wz * xy - v.wx * xy * xy - v.wx * xz * xz + 2.0 * i * v.xz * xy + 2.0 * s * v.wy * xy + 2.0 * s * v.wz * xz + 2.0 * v.wz * xy * yz + 2.0 * v.xy * wx * xy + 2.0 * v.xy * wz * yz + 2.0 * v.xz * wx * xz + 2.0 * v.yz * wx * yz + 2.0 * v.yz * wy * xz),
    wy = (s * s * v.wy + v.wy * xz * xz - 2.0 * i * v.xy * yz - 2.0 * s * v.wx * xy - 2.0 * s * v.yz * wz - 2.0 * v.wx * xz * yz - 2.0 * v.wz * xy * xz - 2.0 * v.xy * wz * xz - 2.0 * v.yz * wx * xz - v.wy * xy * xy - v.wy * yz * yz + 2.0 * i * s * v.xz + 2.0 * i * v.yz * xy + 2.0 * s * v.wz * yz + 2.0 * s * v.xy * wx + 2.0 * v.xy * wy * xy + 2.0 * v.xz * wx * yz + 2.0 * v.xz * wy * xz + 2.0 * v.xz * wz * xy + 2.0 * v.yz * wy * yz),
    wz = (s * s * v.wz + v.wz * xy * xy - 2.0 * i * s * v.xy - 2.0 * i * v.xz * yz - 2.0 * s * v.wx * xz - 2.0 * s * v.wy * yz - 2.0 * v.wy * xy * xz - 2.0 * v.xy * wx * yz - 2.0 * v.xz * wy * xy - v.wz * xz * xz - v.wz * yz * yz + 2.0 * i * v.yz * xz + 2.0 * s * v.xz * wx + 2.0 * s * v.yz * wy + 2.0 * v.wx * xy * yz + 2.0 * v.xy * wy * xz + 2.0 * v.xy * wz * xy + 2.0 * v.xz * wz * xz + 2.0 * v.yz * wx * xy + 2.0 * v.yz * wz * yz),
    xy = (s * s * v.xy + v.xy * xy * xy - 2.0 * s * v.yz * xz - v.xy * xz * xz - v.xy * yz * yz + 2.0 * s * v.xz * yz + 2.0 * v.xz * xy * xz + 2.0 * v.yz * xy * yz),
    xz = (s * s * v.xz + v.xz * xz * xz - 2.0 * s * v.xy * yz - v.xz * xy * xy - v.xz * yz * yz + 2.0 * s * v.yz * xy + 2.0 * v.xy * xy * xz + 2.0 * v.yz * xz * yz),
    yz = (s * s * v.yz + v.yz * yz * yz - 2.0 * s * v.xz * xy - v.yz * xy * xy - v.yz * xz * xz + 2.0 * s * v.xy * xz + 2.0 * v.xy * xy * yz + 2.0 * v.xz * xz * yz),
  )

  def apply(v: Motor): Motor = Motor(
    s = v.s * (s * s + xy * xy + xz * xz + yz * yz),
    wx = (s * s * v.wx + v.wx * yz * yz - 2.0 * i * s * v.yz - 2.0 * i * v.xy * xz - 2.0 * s * v.xy * wy - 2.0 * s * v.xz * wz - 2.0 * v.wy * xz * yz - 2.0 * v.xz * wy * yz - 2.0 * v.yz * wz * xy - v.wx * xy * xy - v.wx * xz * xz + 2.0 * i * v.xz * xy + 2.0 * s * v.wy * xy + 2.0 * s * v.wz * xz + 2.0 * v.wz * xy * yz + 2.0 * v.xy * wx * xy + 2.0 * v.xy * wz * yz + 2.0 * v.xz * wx * xz + 2.0 * v.yz * wx * yz + 2.0 * v.yz * wy * xz),
    wy = (s * s * v.wy + v.wy * xz * xz - 2.0 * i * v.xy * yz - 2.0 * s * v.wx * xy - 2.0 * s * v.yz * wz - 2.0 * v.wx * xz * yz - 2.0 * v.wz * xy * xz - 2.0 * v.xy * wz * xz - 2.0 * v.yz * wx * xz - v.wy * xy * xy - v.wy * yz * yz + 2.0 * i * s * v.xz + 2.0 * i * v.yz * xy + 2.0 * s * v.wz * yz + 2.0 * s * v.xy * wx + 2.0 * v.xy * wy * xy + 2.0 * v.xz * wx * yz + 2.0 * v.xz * wy * xz + 2.0 * v.xz * wz * xy + 2.0 * v.yz * wy * yz),
    wz = (s * s * v.wz + v.wz * xy * xy - 2.0 * i * s * v.xy - 2.0 * i * v.xz * yz - 2.0 * s * v.wx * xz - 2.0 * s * v.wy * yz - 2.0 * v.wy * xy * xz - 2.0 * v.xy * wx * yz - 2.0 * v.xz * wy * xy - v.wz * xz * xz - v.wz * yz * yz + 2.0 * i * v.yz * xz + 2.0 * s * v.xz * wx + 2.0 * s * v.yz * wy + 2.0 * v.wx * xy * yz + 2.0 * v.xy * wy * xz + 2.0 * v.xy * wz * xy + 2.0 * v.xz * wz * xz + 2.0 * v.yz * wx * xy + 2.0 * v.yz * wz * yz),
    xy = (s * s * v.xy + v.xy * xy * xy - 2.0 * s * v.yz * xz - v.xy * xz * xz - v.xy * yz * yz + 2.0 * s * v.xz * yz + 2.0 * v.xz * xy * xz + 2.0 * v.yz * xy * yz),
    xz = (s * s * v.xz + v.xz * xz * xz - 2.0 * s * v.xy * yz - v.xz * xy * xy - v.xz * yz * yz + 2.0 * s * v.yz * xy + 2.0 * v.xy * xy * xz + 2.0 * v.yz * xz * yz),
    yz = (s * s * v.yz + v.yz * yz * yz - 2.0 * s * v.xz * xy - v.yz * xy * xy - v.yz * xz * xz + 2.0 * s * v.xy * xz + 2.0 * v.xy * xy * yz + 2.0 * v.xz * xz * yz),
    i = (s * s * v.i + v.i * xy * xy + v.i * xz * xz + v.i * yz * yz - 2.0 * v.s * wx * yz - 2.0 * v.s * wz * xy + 2.0 * i * s * v.s + 2.0 * v.s * wy * xz),
  )

  def reverse(point: Point) = ???

  def reverse(point: NormalizedPoint) = ???

  def reverse(point: Vector) = ???

  def reverse(point: Plane) = ???

  def reverse(point: NormalizedPlane) = ???

  def reverse(point: Bivector) = ???

  def reverse(point: Motor) = ???


case class Inertia(mass: Double, mrxy: Double, mryz: Double, mrxz: Double):
  def apply(velocity: Bivector): Bivector = ???

  def calculateB(localB: Bivector, localForce: Bivector) = ???

  def reverse(bivector: Bivector): Bivector = ???

