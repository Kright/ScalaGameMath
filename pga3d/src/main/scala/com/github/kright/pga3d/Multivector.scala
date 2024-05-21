package com.github.kright.pga3d

/** this code is generated, see com.github.kright.pga3d.codegen.MultivectorSubClass */
case class Multivector(
                        s: Double = 0.0,
                        w: Double = 0.0,
                        x: Double = 0.0,
                        y: Double = 0.0,
                        z: Double = 0.0,
                        wx: Double = 0.0,
                        wy: Double = 0.0,
                        wz: Double = 0.0,
                        xy: Double = 0.0,
                        xz: Double = 0.0,
                        yz: Double = 0.0,
                        wxy: Double = 0.0,
                        wxz: Double = 0.0,
                        wyz: Double = 0.0,
                        xyz: Double = 0.0,
                        i: Double = 0.0,
                      ):

  def dual: Multivector =
    Multivector(
      s = i,
      w = xyz,
      x = -wyz,
      y = wxz,
      z = -wxy,
      wx = yz,
      wy = -xz,
      wz = xy,
      xy = wz,
      xz = -wy,
      yz = wx,
      wxy = -z,
      wxz = y,
      wyz = -x,
      xyz = w,
      i = s,
    )

  def weight: Multivector =
    Multivector(
      s = 0.0,
      w = w,
      x = 0.0,
      y = 0.0,
      z = 0.0,
      wx = wx,
      wy = wy,
      wz = wz,
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
      wxy = wxy,
      wxz = wxz,
      wyz = wyz,
      xyz = 0.0,
      i = i,
    )

  def bulk: Multivector =
    Multivector(
      s = s,
      w = 0.0,
      x = x,
      y = y,
      z = z,
      wx = 0.0,
      wy = 0.0,
      wz = 0.0,
      xy = xy,
      xz = xz,
      yz = yz,
      wxy = 0.0,
      wxz = 0.0,
      wyz = 0.0,
      xyz = xyz,
      i = 0.0,
    )

  def reverse: Multivector =
    Multivector(
      s = s,
      w = w,
      x = x,
      y = y,
      z = z,
      wx = -wx,
      wy = -wy,
      wz = -wz,
      xy = -xy,
      xz = -xz,
      yz = -yz,
      wxy = -wxy,
      wxz = -wxz,
      wyz = -wyz,
      xyz = -xyz,
      i = i,
    )

  def antiReverse: Multivector =
    Multivector(
      s = s,
      w = -w,
      x = -x,
      y = -y,
      z = -z,
      wx = -wx,
      wy = -wy,
      wz = -wz,
      xy = -xy,
      xz = -xz,
      yz = -yz,
      wxy = wxy,
      wxz = wxz,
      wyz = wyz,
      xyz = xyz,
      i = i,
    )

  def unary_ : Multivector =
    Multivector(
      s = -s,
      w = -w,
      x = -x,
      y = -y,
      z = -z,
      wx = -wx,
      wy = -wy,
      wz = -wz,
      xy = -xy,
      xz = -xz,
      yz = -yz,
      wxy = -wxy,
      wxz = -wxz,
      wyz = -wyz,
      xyz = -xyz,
      i = -i,
    )

  def bulkNormSquare: Double =
    (s * s + x * x + xy * xy + xyz * xyz + xz * xz + y * y + yz * yz + z * z)

  def weightNormSquare: Double =
    (i * i + w * w + wx * wx + wxy * wxy + wxz * wxz + wy * wy + wyz * wyz + wz * wz)

  def normSquare: Double =
    (i * i + s * s + w * w + wx * wx + wxy * wxy + wxz * wxz + wy * wy + wyz * wyz + wz * wz + x * x + xy * xy + xyz * xyz + xz * xz + y * y + yz * yz + z * z)

  def bulkNorm: Double =
    Math.sqrt(bulkNormSquare)

  def normalizedByBulk =
    this / bulkNorm

  def weightNorm: Double =
    Math.sqrt(weightNormSquare)

  def normalizedByWeight =
    this / weightNorm

  def norm: Double =
    Math.sqrt(normSquare)

  def normalizedByNorm =
    this / norm

  def *(v: Double): Multivector =
    Multivector(
      s = s * v,
      w = v * w,
      x = v * x,
      y = v * y,
      z = v * z,
      wx = v * wx,
      wy = v * wy,
      wz = v * wz,
      xy = v * xy,
      xz = v * xz,
      yz = v * yz,
      wxy = v * wxy,
      wxz = v * wxz,
      wyz = v * wyz,
      xyz = v * xyz,
      i = i * v,
    )

  inline def /(v: Double): Multivector =
    this * (1.0 / v)

  def +(v: Multivector): Multivector =
    Multivector(
      s = (s + v.s),
      w = (v.w + w),
      x = (v.x + x),
      y = (v.y + y),
      z = (v.z + z),
      wx = (v.wx + wx),
      wy = (v.wy + wy),
      wz = (v.wz + wz),
      xy = (v.xy + xy),
      xz = (v.xz + xz),
      yz = (v.yz + yz),
      wxy = (v.wxy + wxy),
      wxz = (v.wxz + wxz),
      wyz = (v.wyz + wyz),
      xyz = (v.xyz + xyz),
      i = (i + v.i),
    )

  def -(v: Multivector): Multivector =
    Multivector(
      s = (s - v.s),
      w = (w - v.w),
      x = (x - v.x),
      y = (y - v.y),
      z = (z - v.z),
      wx = (wx - v.wx),
      wy = (wy - v.wy),
      wz = (wz - v.wz),
      xy = (xy - v.xy),
      xz = (xz - v.xz),
      yz = (yz - v.yz),
      wxy = (wxy - v.wxy),
      wxz = (wxz - v.wxz),
      wyz = (wyz - v.wyz),
      xyz = (xyz - v.xyz),
      i = (i - v.i),
    )

  def madd(v: Multivector, mult: Double): Multivector =
    Multivector(
      s = (s + mult * v.s),
      w = (w + mult * v.w),
      x = (x + mult * v.x),
      y = (y + mult * v.y),
      z = (z + mult * v.z),
      wx = (wx + mult * v.wx),
      wy = (wy + mult * v.wy),
      wz = (wz + mult * v.wz),
      xy = (xy + mult * v.xy),
      xz = (xz + mult * v.xz),
      yz = (yz + mult * v.yz),
      wxy = (wxy + mult * v.wxy),
      wxz = (wxz + mult * v.wxz),
      wyz = (wyz + mult * v.wyz),
      xyz = (xyz + mult * v.xyz),
      i = (i + mult * v.i),
    )

  def multiplyElementwise(v: Multivector): Multivector =
    Multivector(
      s = s * v.s,
      w = v.w * w,
      x = v.x * x,
      y = v.y * y,
      z = v.z * z,
      wx = v.wx * wx,
      wy = v.wy * wy,
      wz = v.wz * wz,
      xy = v.xy * xy,
      xz = v.xz * xz,
      yz = v.yz * yz,
      wxy = v.wxy * wxy,
      wxz = v.wxz * wxz,
      wyz = v.wyz * wyz,
      xyz = v.xyz * xyz,
      i = i * v.i,
    )

  infix def geometric(v: Multivector): Multivector =
    Multivector(
      s = (s * v.s + v.x * x + v.y * y + v.z * z - v.xy * xy - v.xyz * xyz - v.xz * xz - v.yz * yz),
      w = (s * v.w + v.i * xyz + v.s * w + v.x * wx + v.y * wy + v.z * wz - i * v.xyz - v.wx * x - v.wxy * xy - v.wxz * xz - v.wy * y - v.wyz * yz - v.wz * z - v.xy * wxy - v.xz * wxz - v.yz * wyz),
      x = (s * v.x + v.s * x + v.y * xy + v.z * xz - v.xy * y - v.xyz * yz - v.xz * z - v.yz * xyz),
      y = (s * v.y + v.s * y + v.xy * x + v.xyz * xz + v.xz * xyz + v.z * yz - v.x * xy - v.yz * z),
      z = (s * v.z + v.s * z + v.xz * x + v.yz * y - v.x * xz - v.xy * xyz - v.xyz * xy - v.y * yz),
      wx = (s * v.wx + v.s * wx + v.wxy * y + v.wxz * z + v.wy * xy + v.wyz * xyz + v.wz * xz + v.x * w + v.y * wxy + v.z * wxz - i * v.yz - v.i * yz - v.w * x - v.xy * wy - v.xyz * wyz - v.xz * wz),
      wy = (i * v.xz + s * v.wy + v.i * xz + v.s * wy + v.wyz * z + v.wz * yz + v.xy * wx + v.xyz * wxz + v.y * w + v.z * wyz - v.w * y - v.wx * xy - v.wxy * x - v.wxz * xyz - v.x * wxy - v.yz * wz),
      wz = (s * v.wz + v.s * wz + v.wxy * xyz + v.xz * wx + v.yz * wy + v.z * w - i * v.xy - v.i * xy - v.w * z - v.wx * xz - v.wxz * x - v.wy * yz - v.wyz * y - v.x * wxz - v.xyz * wxy - v.y * wyz),
      xy = (s * v.xy + v.s * xy + v.xyz * z + v.xz * yz + v.y * x + v.z * xyz - v.x * y - v.yz * xz),
      xz = (s * v.xz + v.s * xz + v.yz * xy + v.z * x - v.x * z - v.xy * yz - v.xyz * y - v.y * xyz),
      yz = (s * v.yz + v.s * yz + v.x * xyz + v.xy * xz + v.xyz * x + v.z * y - v.xz * xy - v.y * z),
      wxy = (i * v.z + s * v.wxy + v.s * wxy + v.w * xy + v.wx * y + v.wxz * yz + v.xy * w + v.xyz * wz + v.xz * wyz + v.y * wx - v.i * z - v.wy * x - v.wyz * xz - v.wz * xyz - v.x * wy - v.yz * wxz),
      wxz = (s * v.wxz + v.i * y + v.s * wxz + v.w * xz + v.wx * z + v.wy * xyz + v.wyz * xy + v.xz * w + v.yz * wxy + v.z * wx - i * v.y - v.wxy * yz - v.wz * x - v.x * wz - v.xy * wyz - v.xyz * wy),
      wyz = (i * v.x + s * v.wyz + v.s * wyz + v.w * yz + v.wxy * xz + v.wy * z + v.xy * wxz + v.xyz * wx + v.yz * w + v.z * wy - v.i * x - v.wx * xyz - v.wxz * xy - v.wz * y - v.xz * wxy - v.y * wz),
      xyz = (s * v.xyz + v.s * xyz + v.x * yz + v.xy * z + v.yz * x + v.z * xy - v.xz * y - v.y * xz),
      i = (i * v.s + s * v.i + v.wx * yz + v.wxz * y + v.wz * xy + v.x * wyz + v.xy * wz + v.xyz * w + v.yz * wx + v.z * wxy - v.w * xyz - v.wxy * z - v.wy * xz - v.wyz * x - v.xz * wy - v.y * wxz),
    )

  infix def geometric(v: Motor): Multivector =
    Multivector(
      s = (s * v.s - v.xy * xy - v.xz * xz - v.yz * yz),
      w = (v.i * xyz + v.s * w - v.wx * x - v.wy * y - v.wz * z - v.xy * wxy - v.xz * wxz - v.yz * wyz),
      x = (v.s * x - v.xy * y - v.xz * z - v.yz * xyz),
      y = (v.s * y + v.xy * x + v.xz * xyz - v.yz * z),
      z = (v.s * z + v.xz * x + v.yz * y - v.xy * xyz),
      wx = (s * v.wx + v.s * wx + v.wy * xy + v.wz * xz - i * v.yz - v.i * yz - v.xy * wy - v.xz * wz),
      wy = (i * v.xz + s * v.wy + v.i * xz + v.s * wy + v.wz * yz + v.xy * wx - v.wx * xy - v.yz * wz),
      wz = (s * v.wz + v.s * wz + v.xz * wx + v.yz * wy - i * v.xy - v.i * xy - v.wx * xz - v.wy * yz),
      xy = (s * v.xy + v.s * xy + v.xz * yz - v.yz * xz),
      xz = (s * v.xz + v.s * xz + v.yz * xy - v.xy * yz),
      yz = (s * v.yz + v.s * yz + v.xy * xz - v.xz * xy),
      wxy = (v.s * wxy + v.wx * y + v.xy * w + v.xz * wyz - v.i * z - v.wy * x - v.wz * xyz - v.yz * wxz),
      wxz = (v.i * y + v.s * wxz + v.wx * z + v.wy * xyz + v.xz * w + v.yz * wxy - v.wz * x - v.xy * wyz),
      wyz = (v.s * wyz + v.wy * z + v.xy * wxz + v.yz * w - v.i * x - v.wx * xyz - v.wz * y - v.xz * wxy),
      xyz = (v.s * xyz + v.xy * z + v.yz * x - v.xz * y),
      i = (i * v.s + s * v.i + v.wx * yz + v.wz * xy + v.xy * wz + v.yz * wx - v.wy * xz - v.xz * wy),
    )

  infix def geometric(v: Plane): Multivector =
    Multivector(
      s = (v.x * x + v.y * y + v.z * z),
      w = (s * v.w + v.x * wx + v.y * wy + v.z * wz),
      x = (s * v.x + v.y * xy + v.z * xz),
      y = (s * v.y + v.z * yz - v.x * xy),
      z = (s * v.z - v.x * xz - v.y * yz),
      wx = (v.x * w + v.y * wxy + v.z * wxz - v.w * x),
      wy = (v.y * w + v.z * wyz - v.w * y - v.x * wxy),
      wz = (v.z * w - v.w * z - v.x * wxz - v.y * wyz),
      xy = (v.y * x + v.z * xyz - v.x * y),
      xz = (v.z * x - v.x * z - v.y * xyz),
      yz = (v.x * xyz + v.z * y - v.y * z),
      wxy = (i * v.z + v.w * xy + v.y * wx - v.x * wy),
      wxz = (v.w * xz + v.z * wx - i * v.y - v.x * wz),
      wyz = (i * v.x + v.w * yz + v.z * wy - v.y * wz),
      xyz = (v.x * yz + v.z * xy - v.y * xz),
      i = (v.x * wyz + v.z * wxy - v.w * xyz - v.y * wxz),
    )

  infix def geometric(v: Bivector): Multivector =
    Multivector(
      s = (-v.xy * xy - v.xz * xz - v.yz * yz),
      w = (-v.wx * x - v.wy * y - v.wz * z - v.xy * wxy - v.xz * wxz - v.yz * wyz),
      x = (-v.xy * y - v.xz * z - v.yz * xyz),
      y = (v.xy * x + v.xz * xyz - v.yz * z),
      z = (v.xz * x + v.yz * y - v.xy * xyz),
      wx = (s * v.wx + v.wy * xy + v.wz * xz - i * v.yz - v.xy * wy - v.xz * wz),
      wy = (i * v.xz + s * v.wy + v.wz * yz + v.xy * wx - v.wx * xy - v.yz * wz),
      wz = (s * v.wz + v.xz * wx + v.yz * wy - i * v.xy - v.wx * xz - v.wy * yz),
      xy = (s * v.xy + v.xz * yz - v.yz * xz),
      xz = (s * v.xz + v.yz * xy - v.xy * yz),
      yz = (s * v.yz + v.xy * xz - v.xz * xy),
      wxy = (v.wx * y + v.xy * w + v.xz * wyz - v.wy * x - v.wz * xyz - v.yz * wxz),
      wxz = (v.wx * z + v.wy * xyz + v.xz * w + v.yz * wxy - v.wz * x - v.xy * wyz),
      wyz = (v.wy * z + v.xy * wxz + v.yz * w - v.wx * xyz - v.wz * y - v.xz * wxy),
      xyz = (v.xy * z + v.yz * x - v.xz * y),
      i = (v.wx * yz + v.wz * xy + v.xy * wz + v.yz * wx - v.wy * xz - v.xz * wy),
    )

  infix def geometric(v: Point): Multivector =
    Multivector(
      s = -v.xyz * xyz,
      w = (-i * v.xyz - v.wxy * xy - v.wxz * xz - v.wyz * yz),
      x = -v.xyz * yz,
      y = v.xyz * xz,
      z = -v.xyz * xy,
      wx = (v.wxy * y + v.wxz * z + v.wyz * xyz - v.xyz * wyz),
      wy = (v.wyz * z + v.xyz * wxz - v.wxy * x - v.wxz * xyz),
      wz = (v.wxy * xyz - v.wxz * x - v.wyz * y - v.xyz * wxy),
      xy = v.xyz * z,
      xz = -v.xyz * y,
      yz = v.xyz * x,
      wxy = (s * v.wxy + v.wxz * yz + v.xyz * wz - v.wyz * xz),
      wxz = (s * v.wxz + v.wyz * xy - v.wxy * yz - v.xyz * wy),
      wyz = (s * v.wyz + v.wxy * xz + v.xyz * wx - v.wxz * xy),
      xyz = s * v.xyz,
      i = (v.wxz * y + v.xyz * w - v.wxy * z - v.wyz * x),
    )

  infix def geometric(v: Quaternion): Multivector =
    Multivector(
      s = (s * v.s - v.xy * xy - v.xz * xz - v.yz * yz),
      w = (v.s * w - v.xy * wxy - v.xz * wxz - v.yz * wyz),
      x = (v.s * x - v.xy * y - v.xz * z - v.yz * xyz),
      y = (v.s * y + v.xy * x + v.xz * xyz - v.yz * z),
      z = (v.s * z + v.xz * x + v.yz * y - v.xy * xyz),
      wx = (v.s * wx - i * v.yz - v.xy * wy - v.xz * wz),
      wy = (i * v.xz + v.s * wy + v.xy * wx - v.yz * wz),
      wz = (v.s * wz + v.xz * wx + v.yz * wy - i * v.xy),
      xy = (s * v.xy + v.s * xy + v.xz * yz - v.yz * xz),
      xz = (s * v.xz + v.s * xz + v.yz * xy - v.xy * yz),
      yz = (s * v.yz + v.s * yz + v.xy * xz - v.xz * xy),
      wxy = (v.s * wxy + v.xy * w + v.xz * wyz - v.yz * wxz),
      wxz = (v.s * wxz + v.xz * w + v.yz * wxy - v.xy * wyz),
      wyz = (v.s * wyz + v.xy * wxz + v.yz * w - v.xz * wxy),
      xyz = (v.s * xyz + v.xy * z + v.yz * x - v.xz * y),
      i = (i * v.s + v.xy * wz + v.yz * wx - v.xz * wy),
    )

  infix def geometric(v: QuaternionDual): Multivector =
    Multivector(
      s = 0.0,
      w = (v.i * xyz - v.wx * x - v.wy * y - v.wz * z),
      x = 0.0,
      y = 0.0,
      z = 0.0,
      wx = (s * v.wx + v.wy * xy + v.wz * xz - v.i * yz),
      wy = (s * v.wy + v.i * xz + v.wz * yz - v.wx * xy),
      wz = (s * v.wz - v.i * xy - v.wx * xz - v.wy * yz),
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
      wxy = (v.wx * y - v.i * z - v.wy * x - v.wz * xyz),
      wxz = (v.i * y + v.wx * z + v.wy * xyz - v.wz * x),
      wyz = (v.wy * z - v.i * x - v.wx * xyz - v.wz * y),
      xyz = 0.0,
      i = (s * v.i + v.wx * yz + v.wz * xy - v.wy * xz),
    )

  infix def geometric(v: PointIdeal): Multivector =
    Multivector(
      s = 0.0,
      w = (-v.wxy * xy - v.wxz * xz - v.wyz * yz),
      x = 0.0,
      y = 0.0,
      z = 0.0,
      wx = (v.wxy * y + v.wxz * z + v.wyz * xyz),
      wy = (v.wyz * z - v.wxy * x - v.wxz * xyz),
      wz = (v.wxy * xyz - v.wxz * x - v.wyz * y),
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
      wxy = (s * v.wxy + v.wxz * yz - v.wyz * xz),
      wxz = (s * v.wxz + v.wyz * xy - v.wxy * yz),
      wyz = (s * v.wyz + v.wxy * xz - v.wxz * xy),
      xyz = 0.0,
      i = (v.wxz * y - v.wxy * z - v.wyz * x),
    )

  infix def geometric(v: PointNormalized): Multivector =
    Multivector(
      s = -xyz,
      w = (-i - v.wxy * xy - v.wxz * xz - v.wyz * yz),
      x = -yz,
      y = xz,
      z = -xy,
      wx = (-wyz + v.wxy * y + v.wxz * z + v.wyz * xyz),
      wy = (wxz + v.wyz * z - v.wxy * x - v.wxz * xyz),
      wz = (-wxy + v.wxy * xyz - v.wxz * x - v.wyz * y),
      xy = z,
      xz = -y,
      yz = x,
      wxy = (wz + s * v.wxy + v.wxz * yz - v.wyz * xz),
      wxz = (-wy + s * v.wxz + v.wyz * xy - v.wxy * yz),
      wyz = (wx + s * v.wyz + v.wxy * xz - v.wxz * xy),
      xyz = s,
      i = (w + v.wxz * y - v.wxy * z - v.wyz * x),
    )

  infix def geometric(v: PlaneIdeal): Multivector =
    Multivector(
      s = (v.x * x + v.y * y + v.z * z),
      w = (v.x * wx + v.y * wy + v.z * wz),
      x = (s * v.x + v.y * xy + v.z * xz),
      y = (s * v.y + v.z * yz - v.x * xy),
      z = (s * v.z - v.x * xz - v.y * yz),
      wx = (v.x * w + v.y * wxy + v.z * wxz),
      wy = (v.y * w + v.z * wyz - v.x * wxy),
      wz = (v.z * w - v.x * wxz - v.y * wyz),
      xy = (v.y * x + v.z * xyz - v.x * y),
      xz = (v.z * x - v.x * z - v.y * xyz),
      yz = (v.x * xyz + v.z * y - v.y * z),
      wxy = (i * v.z + v.y * wx - v.x * wy),
      wxz = (v.z * wx - i * v.y - v.x * wz),
      wyz = (i * v.x + v.z * wy - v.y * wz),
      xyz = (v.x * yz + v.z * xy - v.y * xz),
      i = (v.x * wyz + v.z * wxy - v.y * wxz),
    )

  infix def geometric(v: BivectorBulk): Multivector =
    Multivector(
      s = (-v.xy * xy - v.xz * xz - v.yz * yz),
      w = (-v.xy * wxy - v.xz * wxz - v.yz * wyz),
      x = (-v.xy * y - v.xz * z - v.yz * xyz),
      y = (v.xy * x + v.xz * xyz - v.yz * z),
      z = (v.xz * x + v.yz * y - v.xy * xyz),
      wx = (-i * v.yz - v.xy * wy - v.xz * wz),
      wy = (i * v.xz + v.xy * wx - v.yz * wz),
      wz = (v.xz * wx + v.yz * wy - i * v.xy),
      xy = (s * v.xy + v.xz * yz - v.yz * xz),
      xz = (s * v.xz + v.yz * xy - v.xy * yz),
      yz = (s * v.yz + v.xy * xz - v.xz * xy),
      wxy = (v.xy * w + v.xz * wyz - v.yz * wxz),
      wxz = (v.xz * w + v.yz * wxy - v.xy * wyz),
      wyz = (v.xy * wxz + v.yz * w - v.xz * wxy),
      xyz = (v.xy * z + v.yz * x - v.xz * y),
      i = (v.xy * wz + v.yz * wx - v.xz * wy),
    )

  infix def geometric(v: BivectorWeight): Multivector =
    Multivector(
      s = 0.0,
      w = (-v.wx * x - v.wy * y - v.wz * z),
      x = 0.0,
      y = 0.0,
      z = 0.0,
      wx = (s * v.wx + v.wy * xy + v.wz * xz),
      wy = (s * v.wy + v.wz * yz - v.wx * xy),
      wz = (s * v.wz - v.wx * xz - v.wy * yz),
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
      wxy = (v.wx * y - v.wy * x - v.wz * xyz),
      wxz = (v.wx * z + v.wy * xyz - v.wz * x),
      wyz = (v.wy * z - v.wx * xyz - v.wz * y),
      xyz = 0.0,
      i = (v.wx * yz + v.wz * xy - v.wy * xz),
    )

  infix def geometric(v: PseudoScalar): Multivector =
    Multivector(
      s = 0.0,
      w = v.i * xyz,
      x = 0.0,
      y = 0.0,
      z = 0.0,
      wx = -v.i * yz,
      wy = v.i * xz,
      wz = -v.i * xy,
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
      wxy = -v.i * z,
      wxz = v.i * y,
      wyz = -v.i * x,
      xyz = 0.0,
      i = s * v.i,
    )

  infix def geometric(v: PointCenter.type): Multivector =
    Multivector(
      s = -xyz,
      w = -i,
      x = -yz,
      y = xz,
      z = -xy,
      wx = -wyz,
      wy = wxz,
      wz = -wxy,
      xy = z,
      xz = -y,
      yz = x,
      wxy = wz,
      wxz = -wy,
      wyz = wx,
      xyz = s,
      i = w,
    )

  infix def dot(v: Multivector): Multivector =
    Multivector(
      s = (s * v.s + v.x * x + v.y * y + v.z * z - v.xy * xy - v.xyz * xyz - v.xz * xz - v.yz * yz),
      w = (s * v.w + v.i * xyz + v.s * w + v.x * wx + v.y * wy + v.z * wz - i * v.xyz - v.wx * x - v.wxy * xy - v.wxz * xz - v.wy * y - v.wyz * yz - v.wz * z - v.xy * wxy - v.xz * wxz - v.yz * wyz),
      x = (s * v.x + v.s * x + v.y * xy + v.z * xz - v.xy * y - v.xyz * yz - v.xz * z - v.yz * xyz),
      y = (s * v.y + v.s * y + v.xy * x + v.xyz * xz + v.xz * xyz + v.z * yz - v.x * xy - v.yz * z),
      z = (s * v.z + v.s * z + v.xz * x + v.yz * y - v.x * xz - v.xy * xyz - v.xyz * xy - v.y * yz),
      wx = (s * v.wx + v.s * wx + v.wxy * y + v.wxz * z + v.y * wxy + v.z * wxz - i * v.yz - v.i * yz),
      wy = (i * v.xz + s * v.wy + v.i * xz + v.s * wy + v.wyz * z + v.z * wyz - v.wxy * x - v.x * wxy),
      wz = (s * v.wz + v.s * wz - i * v.xy - v.i * xy - v.wxz * x - v.wyz * y - v.x * wxz - v.y * wyz),
      xy = (s * v.xy + v.s * xy + v.xyz * z + v.z * xyz),
      xz = (s * v.xz + v.s * xz - v.xyz * y - v.y * xyz),
      yz = (s * v.yz + v.s * yz + v.x * xyz + v.xyz * x),
      wxy = (i * v.z + s * v.wxy + v.s * wxy - v.i * z),
      wxz = (s * v.wxz + v.i * y + v.s * wxz - i * v.y),
      wyz = (i * v.x + s * v.wyz + v.s * wyz - v.i * x),
      xyz = (s * v.xyz + v.s * xyz),
      i = (i * v.s + s * v.i),
    )

  infix def dot(v: Motor): Multivector =
    Multivector(
      s = (s * v.s - v.xy * xy - v.xz * xz - v.yz * yz),
      w = (v.i * xyz + v.s * w - v.wx * x - v.wy * y - v.wz * z - v.xy * wxy - v.xz * wxz - v.yz * wyz),
      x = (v.s * x - v.xy * y - v.xz * z - v.yz * xyz),
      y = (v.s * y + v.xy * x + v.xz * xyz - v.yz * z),
      z = (v.s * z + v.xz * x + v.yz * y - v.xy * xyz),
      wx = (s * v.wx + v.s * wx - i * v.yz - v.i * yz),
      wy = (i * v.xz + s * v.wy + v.i * xz + v.s * wy),
      wz = (s * v.wz + v.s * wz - i * v.xy - v.i * xy),
      xy = (s * v.xy + v.s * xy),
      xz = (s * v.xz + v.s * xz),
      yz = (s * v.yz + v.s * yz),
      wxy = (v.s * wxy - v.i * z),
      wxz = (v.i * y + v.s * wxz),
      wyz = (v.s * wyz - v.i * x),
      xyz = v.s * xyz,
      i = (i * v.s + s * v.i),
    )

  infix def dot(v: Plane): Multivector =
    Multivector(
      s = (v.x * x + v.y * y + v.z * z),
      w = (s * v.w + v.x * wx + v.y * wy + v.z * wz),
      x = (s * v.x + v.y * xy + v.z * xz),
      y = (s * v.y + v.z * yz - v.x * xy),
      z = (s * v.z - v.x * xz - v.y * yz),
      wx = (v.y * wxy + v.z * wxz),
      wy = (v.z * wyz - v.x * wxy),
      wz = (-v.x * wxz - v.y * wyz),
      xy = v.z * xyz,
      xz = -v.y * xyz,
      yz = v.x * xyz,
      wxy = i * v.z,
      wxz = -i * v.y,
      wyz = i * v.x,
      xyz = 0.0,
      i = 0.0,
    )

  infix def dot(v: Bivector): Multivector =
    Multivector(
      s = (-v.xy * xy - v.xz * xz - v.yz * yz),
      w = (-v.wx * x - v.wy * y - v.wz * z - v.xy * wxy - v.xz * wxz - v.yz * wyz),
      x = (-v.xy * y - v.xz * z - v.yz * xyz),
      y = (v.xy * x + v.xz * xyz - v.yz * z),
      z = (v.xz * x + v.yz * y - v.xy * xyz),
      wx = (s * v.wx - i * v.yz),
      wy = (i * v.xz + s * v.wy),
      wz = (s * v.wz - i * v.xy),
      xy = s * v.xy,
      xz = s * v.xz,
      yz = s * v.yz,
      wxy = 0.0,
      wxz = 0.0,
      wyz = 0.0,
      xyz = 0.0,
      i = 0.0,
    )

  infix def dot(v: Point): Multivector =
    Multivector(
      s = -v.xyz * xyz,
      w = (-i * v.xyz - v.wxy * xy - v.wxz * xz - v.wyz * yz),
      x = -v.xyz * yz,
      y = v.xyz * xz,
      z = -v.xyz * xy,
      wx = (v.wxy * y + v.wxz * z),
      wy = (v.wyz * z - v.wxy * x),
      wz = (-v.wxz * x - v.wyz * y),
      xy = v.xyz * z,
      xz = -v.xyz * y,
      yz = v.xyz * x,
      wxy = s * v.wxy,
      wxz = s * v.wxz,
      wyz = s * v.wyz,
      xyz = s * v.xyz,
      i = 0.0,
    )

  infix def dot(v: Quaternion): Multivector =
    Multivector(
      s = (s * v.s - v.xy * xy - v.xz * xz - v.yz * yz),
      w = (v.s * w - v.xy * wxy - v.xz * wxz - v.yz * wyz),
      x = (v.s * x - v.xy * y - v.xz * z - v.yz * xyz),
      y = (v.s * y + v.xy * x + v.xz * xyz - v.yz * z),
      z = (v.s * z + v.xz * x + v.yz * y - v.xy * xyz),
      wx = (v.s * wx - i * v.yz),
      wy = (i * v.xz + v.s * wy),
      wz = (v.s * wz - i * v.xy),
      xy = (s * v.xy + v.s * xy),
      xz = (s * v.xz + v.s * xz),
      yz = (s * v.yz + v.s * yz),
      wxy = v.s * wxy,
      wxz = v.s * wxz,
      wyz = v.s * wyz,
      xyz = v.s * xyz,
      i = i * v.s,
    )

  infix def dot(v: QuaternionDual): Multivector =
    Multivector(
      s = 0.0,
      w = (v.i * xyz - v.wx * x - v.wy * y - v.wz * z),
      x = 0.0,
      y = 0.0,
      z = 0.0,
      wx = (s * v.wx - v.i * yz),
      wy = (s * v.wy + v.i * xz),
      wz = (s * v.wz - v.i * xy),
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
      wxy = -v.i * z,
      wxz = v.i * y,
      wyz = -v.i * x,
      xyz = 0.0,
      i = s * v.i,
    )

  infix def dot(v: PointIdeal): Multivector =
    Multivector(
      s = 0.0,
      w = (-v.wxy * xy - v.wxz * xz - v.wyz * yz),
      x = 0.0,
      y = 0.0,
      z = 0.0,
      wx = (v.wxy * y + v.wxz * z),
      wy = (v.wyz * z - v.wxy * x),
      wz = (-v.wxz * x - v.wyz * y),
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
      wxy = s * v.wxy,
      wxz = s * v.wxz,
      wyz = s * v.wyz,
      xyz = 0.0,
      i = 0.0,
    )

  infix def dot(v: PointNormalized): Multivector =
    Multivector(
      s = -xyz,
      w = (-i - v.wxy * xy - v.wxz * xz - v.wyz * yz),
      x = -yz,
      y = xz,
      z = -xy,
      wx = (v.wxy * y + v.wxz * z),
      wy = (v.wyz * z - v.wxy * x),
      wz = (-v.wxz * x - v.wyz * y),
      xy = z,
      xz = -y,
      yz = x,
      wxy = s * v.wxy,
      wxz = s * v.wxz,
      wyz = s * v.wyz,
      xyz = s,
      i = 0.0,
    )

  infix def dot(v: PlaneIdeal): Multivector =
    Multivector(
      s = (v.x * x + v.y * y + v.z * z),
      w = (v.x * wx + v.y * wy + v.z * wz),
      x = (s * v.x + v.y * xy + v.z * xz),
      y = (s * v.y + v.z * yz - v.x * xy),
      z = (s * v.z - v.x * xz - v.y * yz),
      wx = (v.y * wxy + v.z * wxz),
      wy = (v.z * wyz - v.x * wxy),
      wz = (-v.x * wxz - v.y * wyz),
      xy = v.z * xyz,
      xz = -v.y * xyz,
      yz = v.x * xyz,
      wxy = i * v.z,
      wxz = -i * v.y,
      wyz = i * v.x,
      xyz = 0.0,
      i = 0.0,
    )

  infix def dot(v: BivectorBulk): Multivector =
    Multivector(
      s = (-v.xy * xy - v.xz * xz - v.yz * yz),
      w = (-v.xy * wxy - v.xz * wxz - v.yz * wyz),
      x = (-v.xy * y - v.xz * z - v.yz * xyz),
      y = (v.xy * x + v.xz * xyz - v.yz * z),
      z = (v.xz * x + v.yz * y - v.xy * xyz),
      wx = -i * v.yz,
      wy = i * v.xz,
      wz = -i * v.xy,
      xy = s * v.xy,
      xz = s * v.xz,
      yz = s * v.yz,
      wxy = 0.0,
      wxz = 0.0,
      wyz = 0.0,
      xyz = 0.0,
      i = 0.0,
    )

  infix def dot(v: BivectorWeight): Multivector =
    Multivector(
      s = 0.0,
      w = (-v.wx * x - v.wy * y - v.wz * z),
      x = 0.0,
      y = 0.0,
      z = 0.0,
      wx = s * v.wx,
      wy = s * v.wy,
      wz = s * v.wz,
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
      wxy = 0.0,
      wxz = 0.0,
      wyz = 0.0,
      xyz = 0.0,
      i = 0.0,
    )

  infix def dot(v: PseudoScalar): Multivector =
    Multivector(
      s = 0.0,
      w = v.i * xyz,
      x = 0.0,
      y = 0.0,
      z = 0.0,
      wx = -v.i * yz,
      wy = v.i * xz,
      wz = -v.i * xy,
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
      wxy = -v.i * z,
      wxz = v.i * y,
      wyz = -v.i * x,
      xyz = 0.0,
      i = s * v.i,
    )

  infix def dot(v: PointCenter.type): Multivector =
    Multivector(
      s = -xyz,
      w = -i,
      x = -yz,
      y = xz,
      z = -xy,
      wx = 0.0,
      wy = 0.0,
      wz = 0.0,
      xy = z,
      xz = -y,
      yz = x,
      wxy = 0.0,
      wxz = 0.0,
      wyz = 0.0,
      xyz = s,
      i = 0.0,
    )

  infix def wedge(v: Multivector): Multivector =
    Multivector(
      s = s * v.s,
      w = (s * v.w + v.s * w),
      x = (s * v.x + v.s * x),
      y = (s * v.y + v.s * y),
      z = (s * v.z + v.s * z),
      wx = (s * v.wx + v.s * wx + v.x * w - v.w * x),
      wy = (s * v.wy + v.s * wy + v.y * w - v.w * y),
      wz = (s * v.wz + v.s * wz + v.z * w - v.w * z),
      xy = (s * v.xy + v.s * xy + v.y * x - v.x * y),
      xz = (s * v.xz + v.s * xz + v.z * x - v.x * z),
      yz = (s * v.yz + v.s * yz + v.z * y - v.y * z),
      wxy = (s * v.wxy + v.s * wxy + v.w * xy + v.wx * y + v.xy * w + v.y * wx - v.wy * x - v.x * wy),
      wxz = (s * v.wxz + v.s * wxz + v.w * xz + v.wx * z + v.xz * w + v.z * wx - v.wz * x - v.x * wz),
      wyz = (s * v.wyz + v.s * wyz + v.w * yz + v.wy * z + v.yz * w + v.z * wy - v.wz * y - v.y * wz),
      xyz = (s * v.xyz + v.s * xyz + v.x * yz + v.xy * z + v.yz * x + v.z * xy - v.xz * y - v.y * xz),
      i = (i * v.s + s * v.i + v.wx * yz + v.wxz * y + v.wz * xy + v.x * wyz + v.xy * wz + v.xyz * w + v.yz * wx + v.z * wxy - v.w * xyz - v.wxy * z - v.wy * xz - v.wyz * x - v.xz * wy - v.y * wxz),
    )

  inline infix def ^(v: Multivector): Multivector = wedge(v)

  infix def wedge(v: Motor): Multivector =
    Multivector(
      s = s * v.s,
      w = v.s * w,
      x = v.s * x,
      y = v.s * y,
      z = v.s * z,
      wx = (s * v.wx + v.s * wx),
      wy = (s * v.wy + v.s * wy),
      wz = (s * v.wz + v.s * wz),
      xy = (s * v.xy + v.s * xy),
      xz = (s * v.xz + v.s * xz),
      yz = (s * v.yz + v.s * yz),
      wxy = (v.s * wxy + v.wx * y + v.xy * w - v.wy * x),
      wxz = (v.s * wxz + v.wx * z + v.xz * w - v.wz * x),
      wyz = (v.s * wyz + v.wy * z + v.yz * w - v.wz * y),
      xyz = (v.s * xyz + v.xy * z + v.yz * x - v.xz * y),
      i = (i * v.s + s * v.i + v.wx * yz + v.wz * xy + v.xy * wz + v.yz * wx - v.wy * xz - v.xz * wy),
    )

  inline infix def ^(v: Motor): Multivector = wedge(v)

  infix def wedge(v: Plane): Multivector =
    Multivector(
      s = 0.0,
      w = s * v.w,
      x = s * v.x,
      y = s * v.y,
      z = s * v.z,
      wx = (v.x * w - v.w * x),
      wy = (v.y * w - v.w * y),
      wz = (v.z * w - v.w * z),
      xy = (v.y * x - v.x * y),
      xz = (v.z * x - v.x * z),
      yz = (v.z * y - v.y * z),
      wxy = (v.w * xy + v.y * wx - v.x * wy),
      wxz = (v.w * xz + v.z * wx - v.x * wz),
      wyz = (v.w * yz + v.z * wy - v.y * wz),
      xyz = (v.x * yz + v.z * xy - v.y * xz),
      i = (v.x * wyz + v.z * wxy - v.w * xyz - v.y * wxz),
    )

  inline infix def ^(v: Plane): Multivector = wedge(v)

  infix def wedge(v: Bivector): Multivector =
    Multivector(
      s = 0.0,
      w = 0.0,
      x = 0.0,
      y = 0.0,
      z = 0.0,
      wx = s * v.wx,
      wy = s * v.wy,
      wz = s * v.wz,
      xy = s * v.xy,
      xz = s * v.xz,
      yz = s * v.yz,
      wxy = (v.wx * y + v.xy * w - v.wy * x),
      wxz = (v.wx * z + v.xz * w - v.wz * x),
      wyz = (v.wy * z + v.yz * w - v.wz * y),
      xyz = (v.xy * z + v.yz * x - v.xz * y),
      i = (v.wx * yz + v.wz * xy + v.xy * wz + v.yz * wx - v.wy * xz - v.xz * wy),
    )

  inline infix def ^(v: Bivector): Multivector = wedge(v)

  infix def wedge(v: Point): Multivector =
    Multivector(
      s = 0.0,
      w = 0.0,
      x = 0.0,
      y = 0.0,
      z = 0.0,
      wx = 0.0,
      wy = 0.0,
      wz = 0.0,
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
      wxy = s * v.wxy,
      wxz = s * v.wxz,
      wyz = s * v.wyz,
      xyz = s * v.xyz,
      i = (v.wxz * y + v.xyz * w - v.wxy * z - v.wyz * x),
    )

  inline infix def ^(v: Point): Multivector = wedge(v)

  infix def wedge(v: Quaternion): Multivector =
    Multivector(
      s = s * v.s,
      w = v.s * w,
      x = v.s * x,
      y = v.s * y,
      z = v.s * z,
      wx = v.s * wx,
      wy = v.s * wy,
      wz = v.s * wz,
      xy = (s * v.xy + v.s * xy),
      xz = (s * v.xz + v.s * xz),
      yz = (s * v.yz + v.s * yz),
      wxy = (v.s * wxy + v.xy * w),
      wxz = (v.s * wxz + v.xz * w),
      wyz = (v.s * wyz + v.yz * w),
      xyz = (v.s * xyz + v.xy * z + v.yz * x - v.xz * y),
      i = (i * v.s + v.xy * wz + v.yz * wx - v.xz * wy),
    )

  inline infix def ^(v: Quaternion): Multivector = wedge(v)

  infix def wedge(v: QuaternionDual): Multivector =
    Multivector(
      s = 0.0,
      w = 0.0,
      x = 0.0,
      y = 0.0,
      z = 0.0,
      wx = s * v.wx,
      wy = s * v.wy,
      wz = s * v.wz,
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
      wxy = (v.wx * y - v.wy * x),
      wxz = (v.wx * z - v.wz * x),
      wyz = (v.wy * z - v.wz * y),
      xyz = 0.0,
      i = (s * v.i + v.wx * yz + v.wz * xy - v.wy * xz),
    )

  inline infix def ^(v: QuaternionDual): Multivector = wedge(v)

  infix def wedge(v: PointIdeal): Multivector =
    Multivector(
      s = 0.0,
      w = 0.0,
      x = 0.0,
      y = 0.0,
      z = 0.0,
      wx = 0.0,
      wy = 0.0,
      wz = 0.0,
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
      wxy = s * v.wxy,
      wxz = s * v.wxz,
      wyz = s * v.wyz,
      xyz = 0.0,
      i = (v.wxz * y - v.wxy * z - v.wyz * x),
    )

  inline infix def ^(v: PointIdeal): Multivector = wedge(v)

  infix def wedge(v: PointNormalized): Multivector =
    Multivector(
      s = 0.0,
      w = 0.0,
      x = 0.0,
      y = 0.0,
      z = 0.0,
      wx = 0.0,
      wy = 0.0,
      wz = 0.0,
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
      wxy = s * v.wxy,
      wxz = s * v.wxz,
      wyz = s * v.wyz,
      xyz = s,
      i = (w + v.wxz * y - v.wxy * z - v.wyz * x),
    )

  inline infix def ^(v: PointNormalized): Multivector = wedge(v)

  infix def wedge(v: PlaneIdeal): Multivector =
    Multivector(
      s = 0.0,
      w = 0.0,
      x = s * v.x,
      y = s * v.y,
      z = s * v.z,
      wx = v.x * w,
      wy = v.y * w,
      wz = v.z * w,
      xy = (v.y * x - v.x * y),
      xz = (v.z * x - v.x * z),
      yz = (v.z * y - v.y * z),
      wxy = (v.y * wx - v.x * wy),
      wxz = (v.z * wx - v.x * wz),
      wyz = (v.z * wy - v.y * wz),
      xyz = (v.x * yz + v.z * xy - v.y * xz),
      i = (v.x * wyz + v.z * wxy - v.y * wxz),
    )

  inline infix def ^(v: PlaneIdeal): Multivector = wedge(v)

  infix def wedge(v: BivectorBulk): Multivector =
    Multivector(
      s = 0.0,
      w = 0.0,
      x = 0.0,
      y = 0.0,
      z = 0.0,
      wx = 0.0,
      wy = 0.0,
      wz = 0.0,
      xy = s * v.xy,
      xz = s * v.xz,
      yz = s * v.yz,
      wxy = v.xy * w,
      wxz = v.xz * w,
      wyz = v.yz * w,
      xyz = (v.xy * z + v.yz * x - v.xz * y),
      i = (v.xy * wz + v.yz * wx - v.xz * wy),
    )

  inline infix def ^(v: BivectorBulk): Multivector = wedge(v)

  infix def wedge(v: BivectorWeight): Multivector =
    Multivector(
      s = 0.0,
      w = 0.0,
      x = 0.0,
      y = 0.0,
      z = 0.0,
      wx = s * v.wx,
      wy = s * v.wy,
      wz = s * v.wz,
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
      wxy = (v.wx * y - v.wy * x),
      wxz = (v.wx * z - v.wz * x),
      wyz = (v.wy * z - v.wz * y),
      xyz = 0.0,
      i = (v.wx * yz + v.wz * xy - v.wy * xz),
    )

  inline infix def ^(v: BivectorWeight): Multivector = wedge(v)

  infix def wedge(v: PseudoScalar): PseudoScalar =
    PseudoScalar(
      i = s * v.i,
    )

  inline infix def ^(v: PseudoScalar): PseudoScalar = wedge(v)

  infix def wedge(v: PointCenter.type): Multivector =
    Multivector(
      s = 0.0,
      w = 0.0,
      x = 0.0,
      y = 0.0,
      z = 0.0,
      wx = 0.0,
      wy = 0.0,
      wz = 0.0,
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
      wxy = 0.0,
      wxz = 0.0,
      wyz = 0.0,
      xyz = s,
      i = w,
    )

  inline infix def ^(v: PointCenter.type): Multivector = wedge(v)

  infix def sandwich(v: Multivector): Multivector =
    Multivector(
      s = (s * s * v.s + v.s * x * x + v.s * xy * xy + v.s * xyz * xyz + v.s * xz * xz + v.s * y * y + v.s * yz * yz + v.s * z * z - 2.0 * v.x * xy * y - 2.0 * v.x * xz * z - 2.0 * v.y * xyz * xz - 2.0 * v.y * yz * z + 2.0 * s * v.x * x + 2.0 * s * v.y * y + 2.0 * s * v.z * z + 2.0 * v.x * xyz * yz + 2.0 * v.y * x * xy + 2.0 * v.z * x * xz + 2.0 * v.z * xy * xyz + 2.0 * v.z * y * yz),
      w = (s * s * v.w + v.w * xy * xy + v.w * xz * xz + v.w * yz * yz - 2.0 * i * v.y * xz - 2.0 * v.i * x * yz - 2.0 * v.i * xy * z - 2.0 * v.x * wxy * y - 2.0 * v.x * wxz * z - 2.0 * v.x * wy * xy - 2.0 * v.x * wz * xz - 2.0 * v.y * wxz * xyz - 2.0 * v.y * wyz * z - 2.0 * v.y * wz * yz - v.w * x * x - v.w * xyz * xyz - v.w * y * y - v.w * z * z + 2.0 * i * v.s * xyz + 2.0 * i * v.x * yz + 2.0 * i * v.z * xy + 2.0 * s * v.i * xyz + 2.0 * s * v.s * w + 2.0 * s * v.x * wx + 2.0 * s * v.y * wy + 2.0 * s * v.z * wz + 2.0 * v.i * xz * y + 2.0 * v.s * wx * x + 2.0 * v.s * wxy * xy + 2.0 * v.s * wxz * xz + 2.0 * v.s * wy * y + 2.0 * v.s * wyz * yz + 2.0 * v.s * wz * z + 2.0 * v.x * w * x + 2.0 * v.x * wyz * xyz + 2.0 * v.y * w * y + 2.0 * v.y * wx * xy + 2.0 * v.y * wxy * x + 2.0 * v.z * w * z + 2.0 * v.z * wx * xz + 2.0 * v.z * wxy * xyz + 2.0 * v.z * wxz * x + 2.0 * v.z * wy * yz + 2.0 * v.z * wyz * y),
      x = (s * s * v.x + v.x * x * x + v.x * xyz * xyz + v.x * yz * yz - 2.0 * v.y * xyz * z - 2.0 * v.y * xz * yz - v.x * xy * xy - v.x * xz * xz - v.x * y * y - v.x * z * z + 2.0 * s * v.s * x + 2.0 * s * v.y * xy + 2.0 * s * v.z * xz + 2.0 * v.s * xy * y + 2.0 * v.s * xyz * yz + 2.0 * v.s * xz * z + 2.0 * v.y * x * y + 2.0 * v.z * x * z + 2.0 * v.z * xy * yz + 2.0 * v.z * xyz * y),
      y = (s * s * v.y + v.y * xyz * xyz + v.y * xz * xz + v.y * y * y - 2.0 * s * v.x * xy - 2.0 * v.s * x * xy - 2.0 * v.s * xyz * xz - 2.0 * v.x * xz * yz - 2.0 * v.z * x * xyz - 2.0 * v.z * xy * xz - v.y * x * x - v.y * xy * xy - v.y * yz * yz - v.y * z * z + 2.0 * s * v.s * y + 2.0 * s * v.z * yz + 2.0 * v.s * yz * z + 2.0 * v.x * x * y + 2.0 * v.x * xyz * z + 2.0 * v.z * y * z),
      z = (s * s * v.z + v.z * xy * xy + v.z * xyz * xyz + v.z * z * z - 2.0 * s * v.x * xz - 2.0 * s * v.y * yz - 2.0 * v.s * x * xz - 2.0 * v.s * y * yz - 2.0 * v.x * xyz * y - 2.0 * v.y * xy * xz - v.z * x * x - v.z * xz * xz - v.z * y * y - v.z * yz * yz + 2.0 * s * v.s * z + 2.0 * v.s * xy * xyz + 2.0 * v.x * x * z + 2.0 * v.x * xy * yz + 2.0 * v.y * x * xyz + 2.0 * v.y * y * z),
      wx = (s * s * v.wx + v.wx * y * y + v.wx * yz * yz + v.wx * z * z - 2.0 * i * s * v.yz - 2.0 * i * v.xy * xz - 2.0 * i * v.xyz * x - 2.0 * s * v.xy * wy - 2.0 * s * v.xyz * wyz - 2.0 * s * v.xz * wz - 2.0 * v.wxy * x * xy - 2.0 * v.wxy * yz * z - 2.0 * v.wxz * x * xz - 2.0 * v.wxz * xy * xyz - 2.0 * v.wy * x * y - 2.0 * v.wy * xz * yz - 2.0 * v.wyz * x * yz - 2.0 * v.wyz * xz * y - 2.0 * v.wz * x * z - 2.0 * v.wz * xyz * y - 2.0 * v.xy * wxy * x - 2.0 * v.xy * wyz * z - 2.0 * v.xyz * wxy * xz - 2.0 * v.xyz * wy * z - 2.0 * v.xz * wxy * xyz - 2.0 * v.xz * wxz * x - 2.0 * v.xz * wy * yz - 2.0 * v.yz * wxz * y - 2.0 * v.yz * wyz * x - 2.0 * v.yz * wz * xy - v.wx * x * x - v.wx * xy * xy - v.wx * xyz * xyz - v.wx * xz * xz + 2.0 * i * v.xz * xy + 2.0 * s * v.wxy * y + 2.0 * s * v.wxz * z + 2.0 * s * v.wy * xy + 2.0 * s * v.wyz * xyz + 2.0 * s * v.wz * xz + 2.0 * v.wxy * xyz * xz + 2.0 * v.wxz * y * yz + 2.0 * v.wy * xyz * z + 2.0 * v.wyz * xy * z + 2.0 * v.wz * xy * yz + 2.0 * v.xy * w * y + 2.0 * v.xy * wx * xy + 2.0 * v.xy * wxz * xyz + 2.0 * v.xy * wz * yz + 2.0 * v.xyz * w * yz + 2.0 * v.xyz * wx * xyz + 2.0 * v.xyz * wxz * xy + 2.0 * v.xyz * wz * y + 2.0 * v.xz * w * z + 2.0 * v.xz * wx * xz + 2.0 * v.xz * wyz * y + 2.0 * v.yz * w * xyz + 2.0 * v.yz * wx * yz + 2.0 * v.yz * wxy * z + 2.0 * v.yz * wy * xz),
      wy = (s * s * v.wy + v.wy * x * x + v.wy * xz * xz + v.wy * z * z - 2.0 * i * v.xy * yz - 2.0 * i * v.xyz * y - 2.0 * s * v.wx * xy - 2.0 * s * v.wxy * x - 2.0 * s * v.wxz * xyz - 2.0 * s * v.yz * wz - 2.0 * v.wx * x * y - 2.0 * v.wx * xyz * z - 2.0 * v.wx * xz * yz - 2.0 * v.wxy * xy * y - 2.0 * v.wxz * x * yz - 2.0 * v.wxz * xy * z - 2.0 * v.wxz * xz * y - 2.0 * v.wyz * xy * xyz - 2.0 * v.wyz * y * yz - 2.0 * v.wz * xy * xz - 2.0 * v.wz * y * z - 2.0 * v.xy * w * x - 2.0 * v.xy * wxy * y - 2.0 * v.xy * wz * xz - 2.0 * v.xyz * w * xz - 2.0 * v.xyz * wxy * yz - 2.0 * v.xyz * wz * x - 2.0 * v.xz * w * xyz - 2.0 * v.xz * wxy * z - 2.0 * v.xz * wxz * y - 2.0 * v.xz * wyz * x - 2.0 * v.yz * wx * xz - 2.0 * v.yz * wxy * xyz - 2.0 * v.yz * wyz * y - v.wy * xy * xy - v.wy * xyz * xyz - v.wy * y * y - v.wy * yz * yz + 2.0 * i * s * v.xz + 2.0 * i * v.yz * xy + 2.0 * s * v.wyz * z + 2.0 * s * v.wz * yz + 2.0 * s * v.xy * wx + 2.0 * s * v.xyz * wxz + 2.0 * v.wxy * xyz * yz + 2.0 * v.wxy * xz * z + 2.0 * v.wyz * x * xz + 2.0 * v.wz * x * xyz + 2.0 * v.xy * wxz * z + 2.0 * v.xy * wy * xy + 2.0 * v.xy * wyz * xyz + 2.0 * v.xyz * wx * z + 2.0 * v.xyz * wy * xyz + 2.0 * v.xyz * wyz * xy + 2.0 * v.xz * wx * yz + 2.0 * v.xz * wy * xz + 2.0 * v.xz * wz * xy + 2.0 * v.yz * w * z + 2.0 * v.yz * wxz * x + 2.0 * v.yz * wy * yz),
      wz = (s * s * v.wz + v.wz * x * x + v.wz * xy * xy + v.wz * y * y - 2.0 * i * s * v.xy - 2.0 * i * v.xyz * z - 2.0 * i * v.xz * yz - 2.0 * s * v.wx * xz - 2.0 * s * v.wxz * x - 2.0 * s * v.wy * yz - 2.0 * s * v.wyz * y - 2.0 * s * v.xyz * wxy - 2.0 * v.wx * x * z - 2.0 * v.wxy * xy * z - 2.0 * v.wxy * xz * y - 2.0 * v.wxz * xz * z - 2.0 * v.wy * x * xyz - 2.0 * v.wy * xy * xz - 2.0 * v.wy * y * z - 2.0 * v.wyz * x * xy - 2.0 * v.wyz * xyz * xz - 2.0 * v.wyz * yz * z - 2.0 * v.xy * wx * yz - 2.0 * v.xy * wxy * z - 2.0 * v.xy * wxz * y - 2.0 * v.xyz * wx * y - 2.0 * v.xyz * wxz * yz - 2.0 * v.xz * w * x - 2.0 * v.xz * wxz * z - 2.0 * v.xz * wy * xy - 2.0 * v.yz * w * y - 2.0 * v.yz * wxy * x - 2.0 * v.yz * wxz * xyz - 2.0 * v.yz * wyz * z - v.wz * xyz * xyz - v.wz * xz * xz - v.wz * yz * yz - v.wz * z * z + 2.0 * i * v.yz * xz + 2.0 * s * v.wxy * xyz + 2.0 * s * v.xz * wx + 2.0 * s * v.yz * wy + 2.0 * v.wx * xy * yz + 2.0 * v.wx * xyz * y + 2.0 * v.wxy * x * yz + 2.0 * v.wxz * xy * y + 2.0 * v.wxz * xyz * yz + 2.0 * v.xy * w * xyz + 2.0 * v.xy * wy * xz + 2.0 * v.xy * wyz * x + 2.0 * v.xy * wz * xy + 2.0 * v.xyz * w * xy + 2.0 * v.xyz * wy * x + 2.0 * v.xyz * wyz * xz + 2.0 * v.xyz * wz * xyz + 2.0 * v.xz * wxy * y + 2.0 * v.xz * wyz * xyz + 2.0 * v.xz * wz * xz + 2.0 * v.yz * wx * xy + 2.0 * v.yz * wz * yz),
      xy = (s * s * v.xy + v.xy * xy * xy + v.xy * xyz * xyz + v.xy * z * z - 2.0 * s * v.yz * xz - 2.0 * v.xyz * x * xz - 2.0 * v.xyz * y * yz - 2.0 * v.xz * x * xyz - 2.0 * v.xz * y * z - 2.0 * v.yz * xyz * y - v.xy * x * x - v.xy * xz * xz - v.xy * y * y - v.xy * yz * yz + 2.0 * s * v.xyz * z + 2.0 * s * v.xz * yz + 2.0 * v.xyz * xy * xyz + 2.0 * v.xz * xy * xz + 2.0 * v.yz * x * z + 2.0 * v.yz * xy * yz),
      xz = (s * s * v.xz + v.xz * xyz * xyz + v.xz * xz * xz + v.xz * y * y - 2.0 * s * v.xy * yz - 2.0 * s * v.xyz * y - 2.0 * v.xy * y * z - 2.0 * v.xyz * yz * z - 2.0 * v.yz * x * y - 2.0 * v.yz * xyz * z - v.xz * x * x - v.xz * xy * xy - v.xz * yz * yz - v.xz * z * z + 2.0 * s * v.yz * xy + 2.0 * v.xy * x * xyz + 2.0 * v.xy * xy * xz + 2.0 * v.xyz * x * xy + 2.0 * v.xyz * xyz * xz + 2.0 * v.yz * xz * yz),
      yz = (s * s * v.yz + v.yz * x * x + v.yz * xyz * xyz + v.yz * yz * yz - 2.0 * s * v.xz * xy - 2.0 * v.xz * x * y - v.yz * xy * xy - v.yz * xz * xz - v.yz * y * y - v.yz * z * z + 2.0 * s * v.xy * xz + 2.0 * s * v.xyz * x + 2.0 * v.xy * x * z + 2.0 * v.xy * xy * yz + 2.0 * v.xy * xyz * y + 2.0 * v.xyz * xy * y + 2.0 * v.xyz * xyz * yz + 2.0 * v.xyz * xz * z + 2.0 * v.xz * xyz * z + 2.0 * v.xz * xz * yz),
      wxy = (s * s * v.wxy + v.wxy * x * x + v.wxy * xy * xy + v.wxy * y * y - 2.0 * i * v.xz * x - 2.0 * i * v.yz * y - 2.0 * s * v.wy * x - 2.0 * s * v.wyz * xz - 2.0 * s * v.wz * xyz - 2.0 * s * v.yz * wxz - 2.0 * v.wy * xz * z - 2.0 * v.wyz * x * z - 2.0 * v.wz * x * yz - 2.0 * v.xy * wx * x - 2.0 * v.xy * wxz * xz - 2.0 * v.xy * wy * y - 2.0 * v.xy * wyz * yz - 2.0 * v.xyz * wx * xz - 2.0 * v.xyz * wxz * x - 2.0 * v.xyz * wy * yz - 2.0 * v.xyz * wyz * y - 2.0 * v.xz * wx * xyz - 2.0 * v.xz * wy * z - 2.0 * v.xz * wz * y - 2.0 * v.yz * w * xz - 2.0 * v.yz * wy * xyz - v.wxy * xyz * xyz - v.wxy * xz * xz - v.wxy * yz * yz - v.wxy * z * z + 2.0 * i * v.xy * xyz + 2.0 * i * v.xyz * xy + 2.0 * s * v.wx * y + 2.0 * s * v.wxz * yz + 2.0 * s * v.xy * w + 2.0 * s * v.xyz * wz + 2.0 * s * v.xz * wyz + 2.0 * v.wx * x * xy + 2.0 * v.wx * xyz * xz + 2.0 * v.wx * yz * z + 2.0 * v.wxz * x * xyz + 2.0 * v.wxz * xy * xz + 2.0 * v.wxz * y * z + 2.0 * v.wy * xy * y + 2.0 * v.wy * xyz * yz + 2.0 * v.wyz * xy * yz + 2.0 * v.wyz * xyz * y + 2.0 * v.wz * xy * z + 2.0 * v.wz * xz * y + 2.0 * v.xy * wxy * xy + 2.0 * v.xy * wz * z + 2.0 * v.xyz * w * z + 2.0 * v.xyz * wxy * xyz + 2.0 * v.xz * w * yz + 2.0 * v.xz * wxy * xz + 2.0 * v.xz * wxz * xy + 2.0 * v.yz * wx * z + 2.0 * v.yz * wxy * yz + 2.0 * v.yz * wyz * xy + 2.0 * v.yz * wz * x),
      wxz = (s * s * v.wxz + v.wxz * x * x + v.wxz * xz * xz + v.wxz * z * z - 2.0 * i * v.yz * z - 2.0 * s * v.wxy * yz - 2.0 * s * v.wz * x - 2.0 * s * v.xy * wyz - 2.0 * s * v.xyz * wy - 2.0 * v.wx * xy * xyz - 2.0 * v.wx * y * yz - 2.0 * v.wxy * x * xyz - 2.0 * v.wz * xy * y - 2.0 * v.xy * w * yz - 2.0 * v.xy * wy * z - 2.0 * v.xy * wz * y - 2.0 * v.xyz * w * y - 2.0 * v.xyz * wyz * z - 2.0 * v.xyz * wz * yz - 2.0 * v.xz * wx * x - 2.0 * v.xz * wxy * xy - 2.0 * v.xz * wyz * yz - 2.0 * v.xz * wz * z - 2.0 * v.yz * wx * y - 2.0 * v.yz * wy * x - 2.0 * v.yz * wz * xyz - v.wxz * xy * xy - v.wxz * xyz * xyz - v.wxz * y * y - v.wxz * yz * yz + 2.0 * i * v.xy * x + 2.0 * i * v.xyz * xz + 2.0 * i * v.xz * xyz + 2.0 * s * v.wx * z + 2.0 * s * v.wy * xyz + 2.0 * s * v.wyz * xy + 2.0 * s * v.xz * w + 2.0 * s * v.yz * wxy + 2.0 * v.wx * x * xz + 2.0 * v.wxy * xy * xz + 2.0 * v.wxy * y * z + 2.0 * v.wy * x * yz + 2.0 * v.wy * xy * z + 2.0 * v.wy * xz * y + 2.0 * v.wyz * x * y + 2.0 * v.wyz * xyz * z + 2.0 * v.wyz * xz * yz + 2.0 * v.wz * xyz * yz + 2.0 * v.wz * xz * z + 2.0 * v.xy * wx * xyz + 2.0 * v.xy * wxy * xz + 2.0 * v.xy * wxz * xy + 2.0 * v.xyz * wx * xy + 2.0 * v.xyz * wxy * x + 2.0 * v.xyz * wxz * xyz + 2.0 * v.xz * wxz * xz + 2.0 * v.xz * wy * y + 2.0 * v.yz * w * xy + 2.0 * v.yz * wxz * yz + 2.0 * v.yz * wyz * xz),
      wyz = (s * s * v.wyz + v.wyz * y * y + v.wyz * yz * yz + v.wyz * z * z - 2.0 * s * v.wx * xyz - 2.0 * s * v.wxz * xy - 2.0 * s * v.wz * y - 2.0 * s * v.xz * wxy - 2.0 * v.wx * xy * z - 2.0 * v.wxy * x * z - 2.0 * v.wxy * xyz * y - 2.0 * v.wxz * xyz * z - 2.0 * v.wy * x * xz - 2.0 * v.wy * xy * xyz - 2.0 * v.wz * xyz * xz - 2.0 * v.xz * w * xy - 2.0 * v.xz * wx * y - 2.0 * v.xz * wy * x - 2.0 * v.yz * wxy * xy - 2.0 * v.yz * wxz * xz - 2.0 * v.yz * wy * y - 2.0 * v.yz * wz * z - v.wyz * x * x - v.wyz * xy * xy - v.wyz * xyz * xyz - v.wyz * xz * xz + 2.0 * i * v.xy * y + 2.0 * i * v.xyz * yz + 2.0 * i * v.xz * z + 2.0 * i * v.yz * xyz + 2.0 * s * v.wxy * xz + 2.0 * s * v.wy * z + 2.0 * s * v.xy * wxz + 2.0 * s * v.xyz * wx + 2.0 * s * v.yz * w + 2.0 * v.wx * x * yz + 2.0 * v.wx * xz * y + 2.0 * v.wxy * xy * yz + 2.0 * v.wxz * x * y + 2.0 * v.wxz * xz * yz + 2.0 * v.wy * y * yz + 2.0 * v.wz * x * xy + 2.0 * v.wz * yz * z + 2.0 * v.xy * w * xz + 2.0 * v.xy * wx * z + 2.0 * v.xy * wxy * yz + 2.0 * v.xy * wy * xyz + 2.0 * v.xy * wyz * xy + 2.0 * v.xy * wz * x + 2.0 * v.xyz * w * x + 2.0 * v.xyz * wxy * y + 2.0 * v.xyz * wxz * z + 2.0 * v.xyz * wy * xy + 2.0 * v.xyz * wyz * xyz + 2.0 * v.xyz * wz * xz + 2.0 * v.xz * wxz * yz + 2.0 * v.xz * wyz * xz + 2.0 * v.xz * wz * xyz + 2.0 * v.yz * wx * x + 2.0 * v.yz * wyz * yz),
      xyz = (s * s * v.xyz + v.xyz * x * x + v.xyz * xy * xy + v.xyz * xyz * xyz + v.xyz * xz * xz + v.xyz * y * y + v.xyz * yz * yz + v.xyz * z * z - 2.0 * s * v.xz * y - 2.0 * v.xz * x * xy - 2.0 * v.yz * xy * y - 2.0 * v.yz * xz * z + 2.0 * s * v.xy * z + 2.0 * s * v.yz * x + 2.0 * v.xy * x * xz + 2.0 * v.xy * xy * xyz + 2.0 * v.xy * y * yz + 2.0 * v.xz * xyz * xz + 2.0 * v.xz * yz * z + 2.0 * v.yz * xyz * yz),
      i = (s * s * v.i + v.i * xy * xy + v.i * xz * xz + v.i * yz * yz - 2.0 * s * v.w * xyz - 2.0 * s * v.y * wxz - 2.0 * v.s * w * xyz - 2.0 * v.s * wx * yz - 2.0 * v.s * wxz * y - 2.0 * v.s * wz * xy - 2.0 * v.w * xz * y - 2.0 * v.x * w * yz - 2.0 * v.x * wx * xyz - 2.0 * v.x * wxy * xz - 2.0 * v.x * wy * z - 2.0 * v.y * wxy * yz - 2.0 * v.y * wy * xyz - 2.0 * v.y * wz * x - 2.0 * v.z * w * xy - 2.0 * v.z * wx * y - 2.0 * v.z * wxz * yz - 2.0 * v.z * wz * xyz - v.i * x * x - v.i * xyz * xyz - v.i * y * y - v.i * z * z + 2.0 * i * s * v.s + 2.0 * i * v.x * x + 2.0 * i * v.y * y + 2.0 * i * v.z * z + 2.0 * s * v.x * wyz + 2.0 * s * v.z * wxy + 2.0 * v.s * wxy * z + 2.0 * v.s * wy * xz + 2.0 * v.s * wyz * x + 2.0 * v.w * x * yz + 2.0 * v.w * xy * z + 2.0 * v.x * wxz * xy + 2.0 * v.x * wz * y + 2.0 * v.y * w * xz + 2.0 * v.y * wx * z + 2.0 * v.y * wyz * xy + 2.0 * v.z * wy * x + 2.0 * v.z * wyz * xz),
    )

  infix def sandwich(v: Motor): Multivector =
    Multivector(
      s = (s * s * v.s + v.s * x * x + v.s * xy * xy + v.s * xyz * xyz + v.s * xz * xz + v.s * y * y + v.s * yz * yz + v.s * z * z),
      w = (-2.0 * v.i * x * yz - 2.0 * v.i * xy * z + 2.0 * i * v.s * xyz + 2.0 * s * v.i * xyz + 2.0 * s * v.s * w + 2.0 * v.i * xz * y + 2.0 * v.s * wx * x + 2.0 * v.s * wxy * xy + 2.0 * v.s * wxz * xz + 2.0 * v.s * wy * y + 2.0 * v.s * wyz * yz + 2.0 * v.s * wz * z),
      x = (2.0 * s * v.s * x + 2.0 * v.s * xy * y + 2.0 * v.s * xyz * yz + 2.0 * v.s * xz * z),
      y = (-2.0 * v.s * x * xy - 2.0 * v.s * xyz * xz + 2.0 * s * v.s * y + 2.0 * v.s * yz * z),
      z = (-2.0 * v.s * x * xz - 2.0 * v.s * y * yz + 2.0 * s * v.s * z + 2.0 * v.s * xy * xyz),
      wx = (s * s * v.wx + v.wx * y * y + v.wx * yz * yz + v.wx * z * z - 2.0 * i * s * v.yz - 2.0 * i * v.xy * xz - 2.0 * s * v.xy * wy - 2.0 * s * v.xz * wz - 2.0 * v.wy * x * y - 2.0 * v.wy * xz * yz - 2.0 * v.wz * x * z - 2.0 * v.wz * xyz * y - 2.0 * v.xy * wxy * x - 2.0 * v.xy * wyz * z - 2.0 * v.xz * wxy * xyz - 2.0 * v.xz * wxz * x - 2.0 * v.xz * wy * yz - 2.0 * v.yz * wxz * y - 2.0 * v.yz * wyz * x - 2.0 * v.yz * wz * xy - v.wx * x * x - v.wx * xy * xy - v.wx * xyz * xyz - v.wx * xz * xz + 2.0 * i * v.xz * xy + 2.0 * s * v.wy * xy + 2.0 * s * v.wz * xz + 2.0 * v.wy * xyz * z + 2.0 * v.wz * xy * yz + 2.0 * v.xy * w * y + 2.0 * v.xy * wx * xy + 2.0 * v.xy * wxz * xyz + 2.0 * v.xy * wz * yz + 2.0 * v.xz * w * z + 2.0 * v.xz * wx * xz + 2.0 * v.xz * wyz * y + 2.0 * v.yz * w * xyz + 2.0 * v.yz * wx * yz + 2.0 * v.yz * wxy * z + 2.0 * v.yz * wy * xz),
      wy = (s * s * v.wy + v.wy * x * x + v.wy * xz * xz + v.wy * z * z - 2.0 * i * v.xy * yz - 2.0 * s * v.wx * xy - 2.0 * s * v.yz * wz - 2.0 * v.wx * x * y - 2.0 * v.wx * xyz * z - 2.0 * v.wx * xz * yz - 2.0 * v.wz * xy * xz - 2.0 * v.wz * y * z - 2.0 * v.xy * w * x - 2.0 * v.xy * wxy * y - 2.0 * v.xy * wz * xz - 2.0 * v.xz * w * xyz - 2.0 * v.xz * wxy * z - 2.0 * v.xz * wxz * y - 2.0 * v.xz * wyz * x - 2.0 * v.yz * wx * xz - 2.0 * v.yz * wxy * xyz - 2.0 * v.yz * wyz * y - v.wy * xy * xy - v.wy * xyz * xyz - v.wy * y * y - v.wy * yz * yz + 2.0 * i * s * v.xz + 2.0 * i * v.yz * xy + 2.0 * s * v.wz * yz + 2.0 * s * v.xy * wx + 2.0 * v.wz * x * xyz + 2.0 * v.xy * wxz * z + 2.0 * v.xy * wy * xy + 2.0 * v.xy * wyz * xyz + 2.0 * v.xz * wx * yz + 2.0 * v.xz * wy * xz + 2.0 * v.xz * wz * xy + 2.0 * v.yz * w * z + 2.0 * v.yz * wxz * x + 2.0 * v.yz * wy * yz),
      wz = (s * s * v.wz + v.wz * x * x + v.wz * xy * xy + v.wz * y * y - 2.0 * i * s * v.xy - 2.0 * i * v.xz * yz - 2.0 * s * v.wx * xz - 2.0 * s * v.wy * yz - 2.0 * v.wx * x * z - 2.0 * v.wy * x * xyz - 2.0 * v.wy * xy * xz - 2.0 * v.wy * y * z - 2.0 * v.xy * wx * yz - 2.0 * v.xy * wxy * z - 2.0 * v.xy * wxz * y - 2.0 * v.xz * w * x - 2.0 * v.xz * wxz * z - 2.0 * v.xz * wy * xy - 2.0 * v.yz * w * y - 2.0 * v.yz * wxy * x - 2.0 * v.yz * wxz * xyz - 2.0 * v.yz * wyz * z - v.wz * xyz * xyz - v.wz * xz * xz - v.wz * yz * yz - v.wz * z * z + 2.0 * i * v.yz * xz + 2.0 * s * v.xz * wx + 2.0 * s * v.yz * wy + 2.0 * v.wx * xy * yz + 2.0 * v.wx * xyz * y + 2.0 * v.xy * w * xyz + 2.0 * v.xy * wy * xz + 2.0 * v.xy * wyz * x + 2.0 * v.xy * wz * xy + 2.0 * v.xz * wxy * y + 2.0 * v.xz * wyz * xyz + 2.0 * v.xz * wz * xz + 2.0 * v.yz * wx * xy + 2.0 * v.yz * wz * yz),
      xy = (s * s * v.xy + v.xy * xy * xy + v.xy * xyz * xyz + v.xy * z * z - 2.0 * s * v.yz * xz - 2.0 * v.xz * x * xyz - 2.0 * v.xz * y * z - 2.0 * v.yz * xyz * y - v.xy * x * x - v.xy * xz * xz - v.xy * y * y - v.xy * yz * yz + 2.0 * s * v.xz * yz + 2.0 * v.xz * xy * xz + 2.0 * v.yz * x * z + 2.0 * v.yz * xy * yz),
      xz = (s * s * v.xz + v.xz * xyz * xyz + v.xz * xz * xz + v.xz * y * y - 2.0 * s * v.xy * yz - 2.0 * v.xy * y * z - 2.0 * v.yz * x * y - 2.0 * v.yz * xyz * z - v.xz * x * x - v.xz * xy * xy - v.xz * yz * yz - v.xz * z * z + 2.0 * s * v.yz * xy + 2.0 * v.xy * x * xyz + 2.0 * v.xy * xy * xz + 2.0 * v.yz * xz * yz),
      yz = (s * s * v.yz + v.yz * x * x + v.yz * xyz * xyz + v.yz * yz * yz - 2.0 * s * v.xz * xy - 2.0 * v.xz * x * y - v.yz * xy * xy - v.yz * xz * xz - v.yz * y * y - v.yz * z * z + 2.0 * s * v.xy * xz + 2.0 * v.xy * x * z + 2.0 * v.xy * xy * yz + 2.0 * v.xy * xyz * y + 2.0 * v.xz * xyz * z + 2.0 * v.xz * xz * yz),
      wxy = (-2.0 * i * v.xz * x - 2.0 * i * v.yz * y - 2.0 * s * v.wy * x - 2.0 * s * v.wz * xyz - 2.0 * s * v.yz * wxz - 2.0 * v.wy * xz * z - 2.0 * v.wz * x * yz - 2.0 * v.xy * wx * x - 2.0 * v.xy * wxz * xz - 2.0 * v.xy * wy * y - 2.0 * v.xy * wyz * yz - 2.0 * v.xz * wx * xyz - 2.0 * v.xz * wy * z - 2.0 * v.xz * wz * y - 2.0 * v.yz * w * xz - 2.0 * v.yz * wy * xyz + 2.0 * i * v.xy * xyz + 2.0 * s * v.wx * y + 2.0 * s * v.xy * w + 2.0 * s * v.xz * wyz + 2.0 * v.wx * x * xy + 2.0 * v.wx * xyz * xz + 2.0 * v.wx * yz * z + 2.0 * v.wy * xy * y + 2.0 * v.wy * xyz * yz + 2.0 * v.wz * xy * z + 2.0 * v.wz * xz * y + 2.0 * v.xy * wxy * xy + 2.0 * v.xy * wz * z + 2.0 * v.xz * w * yz + 2.0 * v.xz * wxy * xz + 2.0 * v.xz * wxz * xy + 2.0 * v.yz * wx * z + 2.0 * v.yz * wxy * yz + 2.0 * v.yz * wyz * xy + 2.0 * v.yz * wz * x),
      wxz = (-2.0 * i * v.yz * z - 2.0 * s * v.wz * x - 2.0 * s * v.xy * wyz - 2.0 * v.wx * xy * xyz - 2.0 * v.wx * y * yz - 2.0 * v.wz * xy * y - 2.0 * v.xy * w * yz - 2.0 * v.xy * wy * z - 2.0 * v.xy * wz * y - 2.0 * v.xz * wx * x - 2.0 * v.xz * wxy * xy - 2.0 * v.xz * wyz * yz - 2.0 * v.xz * wz * z - 2.0 * v.yz * wx * y - 2.0 * v.yz * wy * x - 2.0 * v.yz * wz * xyz + 2.0 * i * v.xy * x + 2.0 * i * v.xz * xyz + 2.0 * s * v.wx * z + 2.0 * s * v.wy * xyz + 2.0 * s * v.xz * w + 2.0 * s * v.yz * wxy + 2.0 * v.wx * x * xz + 2.0 * v.wy * x * yz + 2.0 * v.wy * xy * z + 2.0 * v.wy * xz * y + 2.0 * v.wz * xyz * yz + 2.0 * v.wz * xz * z + 2.0 * v.xy * wx * xyz + 2.0 * v.xy * wxy * xz + 2.0 * v.xy * wxz * xy + 2.0 * v.xz * wxz * xz + 2.0 * v.xz * wy * y + 2.0 * v.yz * w * xy + 2.0 * v.yz * wxz * yz + 2.0 * v.yz * wyz * xz),
      wyz = (-2.0 * s * v.wx * xyz - 2.0 * s * v.wz * y - 2.0 * s * v.xz * wxy - 2.0 * v.wx * xy * z - 2.0 * v.wy * x * xz - 2.0 * v.wy * xy * xyz - 2.0 * v.wz * xyz * xz - 2.0 * v.xz * w * xy - 2.0 * v.xz * wx * y - 2.0 * v.xz * wy * x - 2.0 * v.yz * wxy * xy - 2.0 * v.yz * wxz * xz - 2.0 * v.yz * wy * y - 2.0 * v.yz * wz * z + 2.0 * i * v.xy * y + 2.0 * i * v.xz * z + 2.0 * i * v.yz * xyz + 2.0 * s * v.wy * z + 2.0 * s * v.xy * wxz + 2.0 * s * v.yz * w + 2.0 * v.wx * x * yz + 2.0 * v.wx * xz * y + 2.0 * v.wy * y * yz + 2.0 * v.wz * x * xy + 2.0 * v.wz * yz * z + 2.0 * v.xy * w * xz + 2.0 * v.xy * wx * z + 2.0 * v.xy * wxy * yz + 2.0 * v.xy * wy * xyz + 2.0 * v.xy * wyz * xy + 2.0 * v.xy * wz * x + 2.0 * v.xz * wxz * yz + 2.0 * v.xz * wyz * xz + 2.0 * v.xz * wz * xyz + 2.0 * v.yz * wx * x + 2.0 * v.yz * wyz * yz),
      xyz = (-2.0 * s * v.xz * y - 2.0 * v.xz * x * xy - 2.0 * v.yz * xy * y - 2.0 * v.yz * xz * z + 2.0 * s * v.xy * z + 2.0 * s * v.yz * x + 2.0 * v.xy * x * xz + 2.0 * v.xy * xy * xyz + 2.0 * v.xy * y * yz + 2.0 * v.xz * xyz * xz + 2.0 * v.xz * yz * z + 2.0 * v.yz * xyz * yz),
      i = (s * s * v.i + v.i * xy * xy + v.i * xz * xz + v.i * yz * yz - 2.0 * v.s * w * xyz - 2.0 * v.s * wx * yz - 2.0 * v.s * wxz * y - 2.0 * v.s * wz * xy - v.i * x * x - v.i * xyz * xyz - v.i * y * y - v.i * z * z + 2.0 * i * s * v.s + 2.0 * v.s * wxy * z + 2.0 * v.s * wy * xz + 2.0 * v.s * wyz * x),
    )

  infix def sandwich(v: Plane): Multivector =
    Multivector(
      s = (-2.0 * v.x * xy * y - 2.0 * v.x * xz * z - 2.0 * v.y * xyz * xz - 2.0 * v.y * yz * z + 2.0 * s * v.x * x + 2.0 * s * v.y * y + 2.0 * s * v.z * z + 2.0 * v.x * xyz * yz + 2.0 * v.y * x * xy + 2.0 * v.z * x * xz + 2.0 * v.z * xy * xyz + 2.0 * v.z * y * yz),
      w = (s * s * v.w + v.w * xy * xy + v.w * xz * xz + v.w * yz * yz - 2.0 * i * v.y * xz - 2.0 * v.x * wxy * y - 2.0 * v.x * wxz * z - 2.0 * v.x * wy * xy - 2.0 * v.x * wz * xz - 2.0 * v.y * wxz * xyz - 2.0 * v.y * wyz * z - 2.0 * v.y * wz * yz - v.w * x * x - v.w * xyz * xyz - v.w * y * y - v.w * z * z + 2.0 * i * v.x * yz + 2.0 * i * v.z * xy + 2.0 * s * v.x * wx + 2.0 * s * v.y * wy + 2.0 * s * v.z * wz + 2.0 * v.x * w * x + 2.0 * v.x * wyz * xyz + 2.0 * v.y * w * y + 2.0 * v.y * wx * xy + 2.0 * v.y * wxy * x + 2.0 * v.z * w * z + 2.0 * v.z * wx * xz + 2.0 * v.z * wxy * xyz + 2.0 * v.z * wxz * x + 2.0 * v.z * wy * yz + 2.0 * v.z * wyz * y),
      x = (s * s * v.x + v.x * x * x + v.x * xyz * xyz + v.x * yz * yz - 2.0 * v.y * xyz * z - 2.0 * v.y * xz * yz - v.x * xy * xy - v.x * xz * xz - v.x * y * y - v.x * z * z + 2.0 * s * v.y * xy + 2.0 * s * v.z * xz + 2.0 * v.y * x * y + 2.0 * v.z * x * z + 2.0 * v.z * xy * yz + 2.0 * v.z * xyz * y),
      y = (s * s * v.y + v.y * xyz * xyz + v.y * xz * xz + v.y * y * y - 2.0 * s * v.x * xy - 2.0 * v.x * xz * yz - 2.0 * v.z * x * xyz - 2.0 * v.z * xy * xz - v.y * x * x - v.y * xy * xy - v.y * yz * yz - v.y * z * z + 2.0 * s * v.z * yz + 2.0 * v.x * x * y + 2.0 * v.x * xyz * z + 2.0 * v.z * y * z),
      z = (s * s * v.z + v.z * xy * xy + v.z * xyz * xyz + v.z * z * z - 2.0 * s * v.x * xz - 2.0 * s * v.y * yz - 2.0 * v.x * xyz * y - 2.0 * v.y * xy * xz - v.z * x * x - v.z * xz * xz - v.z * y * y - v.z * yz * yz + 2.0 * v.x * x * z + 2.0 * v.x * xy * yz + 2.0 * v.y * x * xyz + 2.0 * v.y * y * z),
      wx = 0.0,
      wy = 0.0,
      wz = 0.0,
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
      wxy = 0.0,
      wxz = 0.0,
      wyz = 0.0,
      xyz = 0.0,
      i = (-2.0 * s * v.w * xyz - 2.0 * s * v.y * wxz - 2.0 * v.w * xz * y - 2.0 * v.x * w * yz - 2.0 * v.x * wx * xyz - 2.0 * v.x * wxy * xz - 2.0 * v.x * wy * z - 2.0 * v.y * wxy * yz - 2.0 * v.y * wy * xyz - 2.0 * v.y * wz * x - 2.0 * v.z * w * xy - 2.0 * v.z * wx * y - 2.0 * v.z * wxz * yz - 2.0 * v.z * wz * xyz + 2.0 * i * v.x * x + 2.0 * i * v.y * y + 2.0 * i * v.z * z + 2.0 * s * v.x * wyz + 2.0 * s * v.z * wxy + 2.0 * v.w * x * yz + 2.0 * v.w * xy * z + 2.0 * v.x * wxz * xy + 2.0 * v.x * wz * y + 2.0 * v.y * w * xz + 2.0 * v.y * wx * z + 2.0 * v.y * wyz * xy + 2.0 * v.z * wy * x + 2.0 * v.z * wyz * xz),
    )

  infix def sandwich(v: Bivector): Multivector =
    Multivector(
      s = 0.0,
      w = 0.0,
      x = 0.0,
      y = 0.0,
      z = 0.0,
      wx = (s * s * v.wx + v.wx * y * y + v.wx * yz * yz + v.wx * z * z - 2.0 * i * s * v.yz - 2.0 * i * v.xy * xz - 2.0 * s * v.xy * wy - 2.0 * s * v.xz * wz - 2.0 * v.wy * x * y - 2.0 * v.wy * xz * yz - 2.0 * v.wz * x * z - 2.0 * v.wz * xyz * y - 2.0 * v.xy * wxy * x - 2.0 * v.xy * wyz * z - 2.0 * v.xz * wxy * xyz - 2.0 * v.xz * wxz * x - 2.0 * v.xz * wy * yz - 2.0 * v.yz * wxz * y - 2.0 * v.yz * wyz * x - 2.0 * v.yz * wz * xy - v.wx * x * x - v.wx * xy * xy - v.wx * xyz * xyz - v.wx * xz * xz + 2.0 * i * v.xz * xy + 2.0 * s * v.wy * xy + 2.0 * s * v.wz * xz + 2.0 * v.wy * xyz * z + 2.0 * v.wz * xy * yz + 2.0 * v.xy * w * y + 2.0 * v.xy * wx * xy + 2.0 * v.xy * wxz * xyz + 2.0 * v.xy * wz * yz + 2.0 * v.xz * w * z + 2.0 * v.xz * wx * xz + 2.0 * v.xz * wyz * y + 2.0 * v.yz * w * xyz + 2.0 * v.yz * wx * yz + 2.0 * v.yz * wxy * z + 2.0 * v.yz * wy * xz),
      wy = (s * s * v.wy + v.wy * x * x + v.wy * xz * xz + v.wy * z * z - 2.0 * i * v.xy * yz - 2.0 * s * v.wx * xy - 2.0 * s * v.yz * wz - 2.0 * v.wx * x * y - 2.0 * v.wx * xyz * z - 2.0 * v.wx * xz * yz - 2.0 * v.wz * xy * xz - 2.0 * v.wz * y * z - 2.0 * v.xy * w * x - 2.0 * v.xy * wxy * y - 2.0 * v.xy * wz * xz - 2.0 * v.xz * w * xyz - 2.0 * v.xz * wxy * z - 2.0 * v.xz * wxz * y - 2.0 * v.xz * wyz * x - 2.0 * v.yz * wx * xz - 2.0 * v.yz * wxy * xyz - 2.0 * v.yz * wyz * y - v.wy * xy * xy - v.wy * xyz * xyz - v.wy * y * y - v.wy * yz * yz + 2.0 * i * s * v.xz + 2.0 * i * v.yz * xy + 2.0 * s * v.wz * yz + 2.0 * s * v.xy * wx + 2.0 * v.wz * x * xyz + 2.0 * v.xy * wxz * z + 2.0 * v.xy * wy * xy + 2.0 * v.xy * wyz * xyz + 2.0 * v.xz * wx * yz + 2.0 * v.xz * wy * xz + 2.0 * v.xz * wz * xy + 2.0 * v.yz * w * z + 2.0 * v.yz * wxz * x + 2.0 * v.yz * wy * yz),
      wz = (s * s * v.wz + v.wz * x * x + v.wz * xy * xy + v.wz * y * y - 2.0 * i * s * v.xy - 2.0 * i * v.xz * yz - 2.0 * s * v.wx * xz - 2.0 * s * v.wy * yz - 2.0 * v.wx * x * z - 2.0 * v.wy * x * xyz - 2.0 * v.wy * xy * xz - 2.0 * v.wy * y * z - 2.0 * v.xy * wx * yz - 2.0 * v.xy * wxy * z - 2.0 * v.xy * wxz * y - 2.0 * v.xz * w * x - 2.0 * v.xz * wxz * z - 2.0 * v.xz * wy * xy - 2.0 * v.yz * w * y - 2.0 * v.yz * wxy * x - 2.0 * v.yz * wxz * xyz - 2.0 * v.yz * wyz * z - v.wz * xyz * xyz - v.wz * xz * xz - v.wz * yz * yz - v.wz * z * z + 2.0 * i * v.yz * xz + 2.0 * s * v.xz * wx + 2.0 * s * v.yz * wy + 2.0 * v.wx * xy * yz + 2.0 * v.wx * xyz * y + 2.0 * v.xy * w * xyz + 2.0 * v.xy * wy * xz + 2.0 * v.xy * wyz * x + 2.0 * v.xy * wz * xy + 2.0 * v.xz * wxy * y + 2.0 * v.xz * wyz * xyz + 2.0 * v.xz * wz * xz + 2.0 * v.yz * wx * xy + 2.0 * v.yz * wz * yz),
      xy = (s * s * v.xy + v.xy * xy * xy + v.xy * xyz * xyz + v.xy * z * z - 2.0 * s * v.yz * xz - 2.0 * v.xz * x * xyz - 2.0 * v.xz * y * z - 2.0 * v.yz * xyz * y - v.xy * x * x - v.xy * xz * xz - v.xy * y * y - v.xy * yz * yz + 2.0 * s * v.xz * yz + 2.0 * v.xz * xy * xz + 2.0 * v.yz * x * z + 2.0 * v.yz * xy * yz),
      xz = (s * s * v.xz + v.xz * xyz * xyz + v.xz * xz * xz + v.xz * y * y - 2.0 * s * v.xy * yz - 2.0 * v.xy * y * z - 2.0 * v.yz * x * y - 2.0 * v.yz * xyz * z - v.xz * x * x - v.xz * xy * xy - v.xz * yz * yz - v.xz * z * z + 2.0 * s * v.yz * xy + 2.0 * v.xy * x * xyz + 2.0 * v.xy * xy * xz + 2.0 * v.yz * xz * yz),
      yz = (s * s * v.yz + v.yz * x * x + v.yz * xyz * xyz + v.yz * yz * yz - 2.0 * s * v.xz * xy - 2.0 * v.xz * x * y - v.yz * xy * xy - v.yz * xz * xz - v.yz * y * y - v.yz * z * z + 2.0 * s * v.xy * xz + 2.0 * v.xy * x * z + 2.0 * v.xy * xy * yz + 2.0 * v.xy * xyz * y + 2.0 * v.xz * xyz * z + 2.0 * v.xz * xz * yz),
      wxy = (-2.0 * i * v.xz * x - 2.0 * i * v.yz * y - 2.0 * s * v.wy * x - 2.0 * s * v.wz * xyz - 2.0 * s * v.yz * wxz - 2.0 * v.wy * xz * z - 2.0 * v.wz * x * yz - 2.0 * v.xy * wx * x - 2.0 * v.xy * wxz * xz - 2.0 * v.xy * wy * y - 2.0 * v.xy * wyz * yz - 2.0 * v.xz * wx * xyz - 2.0 * v.xz * wy * z - 2.0 * v.xz * wz * y - 2.0 * v.yz * w * xz - 2.0 * v.yz * wy * xyz + 2.0 * i * v.xy * xyz + 2.0 * s * v.wx * y + 2.0 * s * v.xy * w + 2.0 * s * v.xz * wyz + 2.0 * v.wx * x * xy + 2.0 * v.wx * xyz * xz + 2.0 * v.wx * yz * z + 2.0 * v.wy * xy * y + 2.0 * v.wy * xyz * yz + 2.0 * v.wz * xy * z + 2.0 * v.wz * xz * y + 2.0 * v.xy * wxy * xy + 2.0 * v.xy * wz * z + 2.0 * v.xz * w * yz + 2.0 * v.xz * wxy * xz + 2.0 * v.xz * wxz * xy + 2.0 * v.yz * wx * z + 2.0 * v.yz * wxy * yz + 2.0 * v.yz * wyz * xy + 2.0 * v.yz * wz * x),
      wxz = (-2.0 * i * v.yz * z - 2.0 * s * v.wz * x - 2.0 * s * v.xy * wyz - 2.0 * v.wx * xy * xyz - 2.0 * v.wx * y * yz - 2.0 * v.wz * xy * y - 2.0 * v.xy * w * yz - 2.0 * v.xy * wy * z - 2.0 * v.xy * wz * y - 2.0 * v.xz * wx * x - 2.0 * v.xz * wxy * xy - 2.0 * v.xz * wyz * yz - 2.0 * v.xz * wz * z - 2.0 * v.yz * wx * y - 2.0 * v.yz * wy * x - 2.0 * v.yz * wz * xyz + 2.0 * i * v.xy * x + 2.0 * i * v.xz * xyz + 2.0 * s * v.wx * z + 2.0 * s * v.wy * xyz + 2.0 * s * v.xz * w + 2.0 * s * v.yz * wxy + 2.0 * v.wx * x * xz + 2.0 * v.wy * x * yz + 2.0 * v.wy * xy * z + 2.0 * v.wy * xz * y + 2.0 * v.wz * xyz * yz + 2.0 * v.wz * xz * z + 2.0 * v.xy * wx * xyz + 2.0 * v.xy * wxy * xz + 2.0 * v.xy * wxz * xy + 2.0 * v.xz * wxz * xz + 2.0 * v.xz * wy * y + 2.0 * v.yz * w * xy + 2.0 * v.yz * wxz * yz + 2.0 * v.yz * wyz * xz),
      wyz = (-2.0 * s * v.wx * xyz - 2.0 * s * v.wz * y - 2.0 * s * v.xz * wxy - 2.0 * v.wx * xy * z - 2.0 * v.wy * x * xz - 2.0 * v.wy * xy * xyz - 2.0 * v.wz * xyz * xz - 2.0 * v.xz * w * xy - 2.0 * v.xz * wx * y - 2.0 * v.xz * wy * x - 2.0 * v.yz * wxy * xy - 2.0 * v.yz * wxz * xz - 2.0 * v.yz * wy * y - 2.0 * v.yz * wz * z + 2.0 * i * v.xy * y + 2.0 * i * v.xz * z + 2.0 * i * v.yz * xyz + 2.0 * s * v.wy * z + 2.0 * s * v.xy * wxz + 2.0 * s * v.yz * w + 2.0 * v.wx * x * yz + 2.0 * v.wx * xz * y + 2.0 * v.wy * y * yz + 2.0 * v.wz * x * xy + 2.0 * v.wz * yz * z + 2.0 * v.xy * w * xz + 2.0 * v.xy * wx * z + 2.0 * v.xy * wxy * yz + 2.0 * v.xy * wy * xyz + 2.0 * v.xy * wyz * xy + 2.0 * v.xy * wz * x + 2.0 * v.xz * wxz * yz + 2.0 * v.xz * wyz * xz + 2.0 * v.xz * wz * xyz + 2.0 * v.yz * wx * x + 2.0 * v.yz * wyz * yz),
      xyz = (-2.0 * s * v.xz * y - 2.0 * v.xz * x * xy - 2.0 * v.yz * xy * y - 2.0 * v.yz * xz * z + 2.0 * s * v.xy * z + 2.0 * s * v.yz * x + 2.0 * v.xy * x * xz + 2.0 * v.xy * xy * xyz + 2.0 * v.xy * y * yz + 2.0 * v.xz * xyz * xz + 2.0 * v.xz * yz * z + 2.0 * v.yz * xyz * yz),
      i = 0.0,
    )

  infix def sandwich(v: Point): Multivector =
    Multivector(
      s = 0.0,
      w = 0.0,
      x = 0.0,
      y = 0.0,
      z = 0.0,
      wx = (-2.0 * i * v.xyz * x - 2.0 * s * v.xyz * wyz - 2.0 * v.wxy * x * xy - 2.0 * v.wxy * yz * z - 2.0 * v.wxz * x * xz - 2.0 * v.wxz * xy * xyz - 2.0 * v.wyz * x * yz - 2.0 * v.wyz * xz * y - 2.0 * v.xyz * wxy * xz - 2.0 * v.xyz * wy * z + 2.0 * s * v.wxy * y + 2.0 * s * v.wxz * z + 2.0 * s * v.wyz * xyz + 2.0 * v.wxy * xyz * xz + 2.0 * v.wxz * y * yz + 2.0 * v.wyz * xy * z + 2.0 * v.xyz * w * yz + 2.0 * v.xyz * wx * xyz + 2.0 * v.xyz * wxz * xy + 2.0 * v.xyz * wz * y),
      wy = (-2.0 * i * v.xyz * y - 2.0 * s * v.wxy * x - 2.0 * s * v.wxz * xyz - 2.0 * v.wxy * xy * y - 2.0 * v.wxz * x * yz - 2.0 * v.wxz * xy * z - 2.0 * v.wxz * xz * y - 2.0 * v.wyz * xy * xyz - 2.0 * v.wyz * y * yz - 2.0 * v.xyz * w * xz - 2.0 * v.xyz * wxy * yz - 2.0 * v.xyz * wz * x + 2.0 * s * v.wyz * z + 2.0 * s * v.xyz * wxz + 2.0 * v.wxy * xyz * yz + 2.0 * v.wxy * xz * z + 2.0 * v.wyz * x * xz + 2.0 * v.xyz * wx * z + 2.0 * v.xyz * wy * xyz + 2.0 * v.xyz * wyz * xy),
      wz = (-2.0 * i * v.xyz * z - 2.0 * s * v.wxz * x - 2.0 * s * v.wyz * y - 2.0 * s * v.xyz * wxy - 2.0 * v.wxy * xy * z - 2.0 * v.wxy * xz * y - 2.0 * v.wxz * xz * z - 2.0 * v.wyz * x * xy - 2.0 * v.wyz * xyz * xz - 2.0 * v.wyz * yz * z - 2.0 * v.xyz * wx * y - 2.0 * v.xyz * wxz * yz + 2.0 * s * v.wxy * xyz + 2.0 * v.wxy * x * yz + 2.0 * v.wxz * xy * y + 2.0 * v.wxz * xyz * yz + 2.0 * v.xyz * w * xy + 2.0 * v.xyz * wy * x + 2.0 * v.xyz * wyz * xz + 2.0 * v.xyz * wz * xyz),
      xy = (-2.0 * v.xyz * x * xz - 2.0 * v.xyz * y * yz + 2.0 * s * v.xyz * z + 2.0 * v.xyz * xy * xyz),
      xz = (-2.0 * s * v.xyz * y - 2.0 * v.xyz * yz * z + 2.0 * v.xyz * x * xy + 2.0 * v.xyz * xyz * xz),
      yz = (2.0 * s * v.xyz * x + 2.0 * v.xyz * xy * y + 2.0 * v.xyz * xyz * yz + 2.0 * v.xyz * xz * z),
      wxy = (s * s * v.wxy + v.wxy * x * x + v.wxy * xy * xy + v.wxy * y * y - 2.0 * s * v.wyz * xz - 2.0 * v.wyz * x * z - 2.0 * v.xyz * wx * xz - 2.0 * v.xyz * wxz * x - 2.0 * v.xyz * wy * yz - 2.0 * v.xyz * wyz * y - v.wxy * xyz * xyz - v.wxy * xz * xz - v.wxy * yz * yz - v.wxy * z * z + 2.0 * i * v.xyz * xy + 2.0 * s * v.wxz * yz + 2.0 * s * v.xyz * wz + 2.0 * v.wxz * x * xyz + 2.0 * v.wxz * xy * xz + 2.0 * v.wxz * y * z + 2.0 * v.wyz * xy * yz + 2.0 * v.wyz * xyz * y + 2.0 * v.xyz * w * z + 2.0 * v.xyz * wxy * xyz),
      wxz = (s * s * v.wxz + v.wxz * x * x + v.wxz * xz * xz + v.wxz * z * z - 2.0 * s * v.wxy * yz - 2.0 * s * v.xyz * wy - 2.0 * v.wxy * x * xyz - 2.0 * v.xyz * w * y - 2.0 * v.xyz * wyz * z - 2.0 * v.xyz * wz * yz - v.wxz * xy * xy - v.wxz * xyz * xyz - v.wxz * y * y - v.wxz * yz * yz + 2.0 * i * v.xyz * xz + 2.0 * s * v.wyz * xy + 2.0 * v.wxy * xy * xz + 2.0 * v.wxy * y * z + 2.0 * v.wyz * x * y + 2.0 * v.wyz * xyz * z + 2.0 * v.wyz * xz * yz + 2.0 * v.xyz * wx * xy + 2.0 * v.xyz * wxy * x + 2.0 * v.xyz * wxz * xyz),
      wyz = (s * s * v.wyz + v.wyz * y * y + v.wyz * yz * yz + v.wyz * z * z - 2.0 * s * v.wxz * xy - 2.0 * v.wxy * x * z - 2.0 * v.wxy * xyz * y - 2.0 * v.wxz * xyz * z - v.wyz * x * x - v.wyz * xy * xy - v.wyz * xyz * xyz - v.wyz * xz * xz + 2.0 * i * v.xyz * yz + 2.0 * s * v.wxy * xz + 2.0 * s * v.xyz * wx + 2.0 * v.wxy * xy * yz + 2.0 * v.wxz * x * y + 2.0 * v.wxz * xz * yz + 2.0 * v.xyz * w * x + 2.0 * v.xyz * wxy * y + 2.0 * v.xyz * wxz * z + 2.0 * v.xyz * wy * xy + 2.0 * v.xyz * wyz * xyz + 2.0 * v.xyz * wz * xz),
      xyz = (s * s * v.xyz + v.xyz * x * x + v.xyz * xy * xy + v.xyz * xyz * xyz + v.xyz * xz * xz + v.xyz * y * y + v.xyz * yz * yz + v.xyz * z * z),
      i = 0.0,
    )

  infix def sandwich(v: Quaternion): Multivector =
    Multivector(
      s = (s * s * v.s + v.s * x * x + v.s * xy * xy + v.s * xyz * xyz + v.s * xz * xz + v.s * y * y + v.s * yz * yz + v.s * z * z),
      w = (2.0 * i * v.s * xyz + 2.0 * s * v.s * w + 2.0 * v.s * wx * x + 2.0 * v.s * wxy * xy + 2.0 * v.s * wxz * xz + 2.0 * v.s * wy * y + 2.0 * v.s * wyz * yz + 2.0 * v.s * wz * z),
      x = (2.0 * s * v.s * x + 2.0 * v.s * xy * y + 2.0 * v.s * xyz * yz + 2.0 * v.s * xz * z),
      y = (-2.0 * v.s * x * xy - 2.0 * v.s * xyz * xz + 2.0 * s * v.s * y + 2.0 * v.s * yz * z),
      z = (-2.0 * v.s * x * xz - 2.0 * v.s * y * yz + 2.0 * s * v.s * z + 2.0 * v.s * xy * xyz),
      wx = (-2.0 * i * s * v.yz - 2.0 * i * v.xy * xz - 2.0 * s * v.xy * wy - 2.0 * s * v.xz * wz - 2.0 * v.xy * wxy * x - 2.0 * v.xy * wyz * z - 2.0 * v.xz * wxy * xyz - 2.0 * v.xz * wxz * x - 2.0 * v.xz * wy * yz - 2.0 * v.yz * wxz * y - 2.0 * v.yz * wyz * x - 2.0 * v.yz * wz * xy + 2.0 * i * v.xz * xy + 2.0 * v.xy * w * y + 2.0 * v.xy * wx * xy + 2.0 * v.xy * wxz * xyz + 2.0 * v.xy * wz * yz + 2.0 * v.xz * w * z + 2.0 * v.xz * wx * xz + 2.0 * v.xz * wyz * y + 2.0 * v.yz * w * xyz + 2.0 * v.yz * wx * yz + 2.0 * v.yz * wxy * z + 2.0 * v.yz * wy * xz),
      wy = (-2.0 * i * v.xy * yz - 2.0 * s * v.yz * wz - 2.0 * v.xy * w * x - 2.0 * v.xy * wxy * y - 2.0 * v.xy * wz * xz - 2.0 * v.xz * w * xyz - 2.0 * v.xz * wxy * z - 2.0 * v.xz * wxz * y - 2.0 * v.xz * wyz * x - 2.0 * v.yz * wx * xz - 2.0 * v.yz * wxy * xyz - 2.0 * v.yz * wyz * y + 2.0 * i * s * v.xz + 2.0 * i * v.yz * xy + 2.0 * s * v.xy * wx + 2.0 * v.xy * wxz * z + 2.0 * v.xy * wy * xy + 2.0 * v.xy * wyz * xyz + 2.0 * v.xz * wx * yz + 2.0 * v.xz * wy * xz + 2.0 * v.xz * wz * xy + 2.0 * v.yz * w * z + 2.0 * v.yz * wxz * x + 2.0 * v.yz * wy * yz),
      wz = (-2.0 * i * s * v.xy - 2.0 * i * v.xz * yz - 2.0 * v.xy * wx * yz - 2.0 * v.xy * wxy * z - 2.0 * v.xy * wxz * y - 2.0 * v.xz * w * x - 2.0 * v.xz * wxz * z - 2.0 * v.xz * wy * xy - 2.0 * v.yz * w * y - 2.0 * v.yz * wxy * x - 2.0 * v.yz * wxz * xyz - 2.0 * v.yz * wyz * z + 2.0 * i * v.yz * xz + 2.0 * s * v.xz * wx + 2.0 * s * v.yz * wy + 2.0 * v.xy * w * xyz + 2.0 * v.xy * wy * xz + 2.0 * v.xy * wyz * x + 2.0 * v.xy * wz * xy + 2.0 * v.xz * wxy * y + 2.0 * v.xz * wyz * xyz + 2.0 * v.xz * wz * xz + 2.0 * v.yz * wx * xy + 2.0 * v.yz * wz * yz),
      xy = (s * s * v.xy + v.xy * xy * xy + v.xy * xyz * xyz + v.xy * z * z - 2.0 * s * v.yz * xz - 2.0 * v.xz * x * xyz - 2.0 * v.xz * y * z - 2.0 * v.yz * xyz * y - v.xy * x * x - v.xy * xz * xz - v.xy * y * y - v.xy * yz * yz + 2.0 * s * v.xz * yz + 2.0 * v.xz * xy * xz + 2.0 * v.yz * x * z + 2.0 * v.yz * xy * yz),
      xz = (s * s * v.xz + v.xz * xyz * xyz + v.xz * xz * xz + v.xz * y * y - 2.0 * s * v.xy * yz - 2.0 * v.xy * y * z - 2.0 * v.yz * x * y - 2.0 * v.yz * xyz * z - v.xz * x * x - v.xz * xy * xy - v.xz * yz * yz - v.xz * z * z + 2.0 * s * v.yz * xy + 2.0 * v.xy * x * xyz + 2.0 * v.xy * xy * xz + 2.0 * v.yz * xz * yz),
      yz = (s * s * v.yz + v.yz * x * x + v.yz * xyz * xyz + v.yz * yz * yz - 2.0 * s * v.xz * xy - 2.0 * v.xz * x * y - v.yz * xy * xy - v.yz * xz * xz - v.yz * y * y - v.yz * z * z + 2.0 * s * v.xy * xz + 2.0 * v.xy * x * z + 2.0 * v.xy * xy * yz + 2.0 * v.xy * xyz * y + 2.0 * v.xz * xyz * z + 2.0 * v.xz * xz * yz),
      wxy = (-2.0 * i * v.xz * x - 2.0 * i * v.yz * y - 2.0 * s * v.yz * wxz - 2.0 * v.xy * wx * x - 2.0 * v.xy * wxz * xz - 2.0 * v.xy * wy * y - 2.0 * v.xy * wyz * yz - 2.0 * v.xz * wx * xyz - 2.0 * v.xz * wy * z - 2.0 * v.xz * wz * y - 2.0 * v.yz * w * xz - 2.0 * v.yz * wy * xyz + 2.0 * i * v.xy * xyz + 2.0 * s * v.xy * w + 2.0 * s * v.xz * wyz + 2.0 * v.xy * wxy * xy + 2.0 * v.xy * wz * z + 2.0 * v.xz * w * yz + 2.0 * v.xz * wxy * xz + 2.0 * v.xz * wxz * xy + 2.0 * v.yz * wx * z + 2.0 * v.yz * wxy * yz + 2.0 * v.yz * wyz * xy + 2.0 * v.yz * wz * x),
      wxz = (-2.0 * i * v.yz * z - 2.0 * s * v.xy * wyz - 2.0 * v.xy * w * yz - 2.0 * v.xy * wy * z - 2.0 * v.xy * wz * y - 2.0 * v.xz * wx * x - 2.0 * v.xz * wxy * xy - 2.0 * v.xz * wyz * yz - 2.0 * v.xz * wz * z - 2.0 * v.yz * wx * y - 2.0 * v.yz * wy * x - 2.0 * v.yz * wz * xyz + 2.0 * i * v.xy * x + 2.0 * i * v.xz * xyz + 2.0 * s * v.xz * w + 2.0 * s * v.yz * wxy + 2.0 * v.xy * wx * xyz + 2.0 * v.xy * wxy * xz + 2.0 * v.xy * wxz * xy + 2.0 * v.xz * wxz * xz + 2.0 * v.xz * wy * y + 2.0 * v.yz * w * xy + 2.0 * v.yz * wxz * yz + 2.0 * v.yz * wyz * xz),
      wyz = (-2.0 * s * v.xz * wxy - 2.0 * v.xz * w * xy - 2.0 * v.xz * wx * y - 2.0 * v.xz * wy * x - 2.0 * v.yz * wxy * xy - 2.0 * v.yz * wxz * xz - 2.0 * v.yz * wy * y - 2.0 * v.yz * wz * z + 2.0 * i * v.xy * y + 2.0 * i * v.xz * z + 2.0 * i * v.yz * xyz + 2.0 * s * v.xy * wxz + 2.0 * s * v.yz * w + 2.0 * v.xy * w * xz + 2.0 * v.xy * wx * z + 2.0 * v.xy * wxy * yz + 2.0 * v.xy * wy * xyz + 2.0 * v.xy * wyz * xy + 2.0 * v.xy * wz * x + 2.0 * v.xz * wxz * yz + 2.0 * v.xz * wyz * xz + 2.0 * v.xz * wz * xyz + 2.0 * v.yz * wx * x + 2.0 * v.yz * wyz * yz),
      xyz = (-2.0 * s * v.xz * y - 2.0 * v.xz * x * xy - 2.0 * v.yz * xy * y - 2.0 * v.yz * xz * z + 2.0 * s * v.xy * z + 2.0 * s * v.yz * x + 2.0 * v.xy * x * xz + 2.0 * v.xy * xy * xyz + 2.0 * v.xy * y * yz + 2.0 * v.xz * xyz * xz + 2.0 * v.xz * yz * z + 2.0 * v.yz * xyz * yz),
      i = (-2.0 * v.s * w * xyz - 2.0 * v.s * wx * yz - 2.0 * v.s * wxz * y - 2.0 * v.s * wz * xy + 2.0 * i * s * v.s + 2.0 * v.s * wxy * z + 2.0 * v.s * wy * xz + 2.0 * v.s * wyz * x),
    )

  infix def sandwich(v: QuaternionDual): Multivector =
    Multivector(
      s = 0.0,
      w = (-2.0 * v.i * x * yz - 2.0 * v.i * xy * z + 2.0 * s * v.i * xyz + 2.0 * v.i * xz * y),
      x = 0.0,
      y = 0.0,
      z = 0.0,
      wx = (s * s * v.wx + v.wx * y * y + v.wx * yz * yz + v.wx * z * z - 2.0 * v.wy * x * y - 2.0 * v.wy * xz * yz - 2.0 * v.wz * x * z - 2.0 * v.wz * xyz * y - v.wx * x * x - v.wx * xy * xy - v.wx * xyz * xyz - v.wx * xz * xz + 2.0 * s * v.wy * xy + 2.0 * s * v.wz * xz + 2.0 * v.wy * xyz * z + 2.0 * v.wz * xy * yz),
      wy = (s * s * v.wy + v.wy * x * x + v.wy * xz * xz + v.wy * z * z - 2.0 * s * v.wx * xy - 2.0 * v.wx * x * y - 2.0 * v.wx * xyz * z - 2.0 * v.wx * xz * yz - 2.0 * v.wz * xy * xz - 2.0 * v.wz * y * z - v.wy * xy * xy - v.wy * xyz * xyz - v.wy * y * y - v.wy * yz * yz + 2.0 * s * v.wz * yz + 2.0 * v.wz * x * xyz),
      wz = (s * s * v.wz + v.wz * x * x + v.wz * xy * xy + v.wz * y * y - 2.0 * s * v.wx * xz - 2.0 * s * v.wy * yz - 2.0 * v.wx * x * z - 2.0 * v.wy * x * xyz - 2.0 * v.wy * xy * xz - 2.0 * v.wy * y * z - v.wz * xyz * xyz - v.wz * xz * xz - v.wz * yz * yz - v.wz * z * z + 2.0 * v.wx * xy * yz + 2.0 * v.wx * xyz * y),
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
      wxy = (-2.0 * s * v.wy * x - 2.0 * s * v.wz * xyz - 2.0 * v.wy * xz * z - 2.0 * v.wz * x * yz + 2.0 * s * v.wx * y + 2.0 * v.wx * x * xy + 2.0 * v.wx * xyz * xz + 2.0 * v.wx * yz * z + 2.0 * v.wy * xy * y + 2.0 * v.wy * xyz * yz + 2.0 * v.wz * xy * z + 2.0 * v.wz * xz * y),
      wxz = (-2.0 * s * v.wz * x - 2.0 * v.wx * xy * xyz - 2.0 * v.wx * y * yz - 2.0 * v.wz * xy * y + 2.0 * s * v.wx * z + 2.0 * s * v.wy * xyz + 2.0 * v.wx * x * xz + 2.0 * v.wy * x * yz + 2.0 * v.wy * xy * z + 2.0 * v.wy * xz * y + 2.0 * v.wz * xyz * yz + 2.0 * v.wz * xz * z),
      wyz = (-2.0 * s * v.wx * xyz - 2.0 * s * v.wz * y - 2.0 * v.wx * xy * z - 2.0 * v.wy * x * xz - 2.0 * v.wy * xy * xyz - 2.0 * v.wz * xyz * xz + 2.0 * s * v.wy * z + 2.0 * v.wx * x * yz + 2.0 * v.wx * xz * y + 2.0 * v.wy * y * yz + 2.0 * v.wz * x * xy + 2.0 * v.wz * yz * z),
      xyz = 0.0,
      i = (s * s * v.i + v.i * xy * xy + v.i * xz * xz + v.i * yz * yz - v.i * x * x - v.i * xyz * xyz - v.i * y * y - v.i * z * z),
    )

  infix def sandwich(v: PointIdeal): Multivector =
    Multivector(
      s = 0.0,
      w = 0.0,
      x = 0.0,
      y = 0.0,
      z = 0.0,
      wx = (-2.0 * v.wxy * x * xy - 2.0 * v.wxy * yz * z - 2.0 * v.wxz * x * xz - 2.0 * v.wxz * xy * xyz - 2.0 * v.wyz * x * yz - 2.0 * v.wyz * xz * y + 2.0 * s * v.wxy * y + 2.0 * s * v.wxz * z + 2.0 * s * v.wyz * xyz + 2.0 * v.wxy * xyz * xz + 2.0 * v.wxz * y * yz + 2.0 * v.wyz * xy * z),
      wy = (-2.0 * s * v.wxy * x - 2.0 * s * v.wxz * xyz - 2.0 * v.wxy * xy * y - 2.0 * v.wxz * x * yz - 2.0 * v.wxz * xy * z - 2.0 * v.wxz * xz * y - 2.0 * v.wyz * xy * xyz - 2.0 * v.wyz * y * yz + 2.0 * s * v.wyz * z + 2.0 * v.wxy * xyz * yz + 2.0 * v.wxy * xz * z + 2.0 * v.wyz * x * xz),
      wz = (-2.0 * s * v.wxz * x - 2.0 * s * v.wyz * y - 2.0 * v.wxy * xy * z - 2.0 * v.wxy * xz * y - 2.0 * v.wxz * xz * z - 2.0 * v.wyz * x * xy - 2.0 * v.wyz * xyz * xz - 2.0 * v.wyz * yz * z + 2.0 * s * v.wxy * xyz + 2.0 * v.wxy * x * yz + 2.0 * v.wxz * xy * y + 2.0 * v.wxz * xyz * yz),
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
      wxy = (s * s * v.wxy + v.wxy * x * x + v.wxy * xy * xy + v.wxy * y * y - 2.0 * s * v.wyz * xz - 2.0 * v.wyz * x * z - v.wxy * xyz * xyz - v.wxy * xz * xz - v.wxy * yz * yz - v.wxy * z * z + 2.0 * s * v.wxz * yz + 2.0 * v.wxz * x * xyz + 2.0 * v.wxz * xy * xz + 2.0 * v.wxz * y * z + 2.0 * v.wyz * xy * yz + 2.0 * v.wyz * xyz * y),
      wxz = (s * s * v.wxz + v.wxz * x * x + v.wxz * xz * xz + v.wxz * z * z - 2.0 * s * v.wxy * yz - 2.0 * v.wxy * x * xyz - v.wxz * xy * xy - v.wxz * xyz * xyz - v.wxz * y * y - v.wxz * yz * yz + 2.0 * s * v.wyz * xy + 2.0 * v.wxy * xy * xz + 2.0 * v.wxy * y * z + 2.0 * v.wyz * x * y + 2.0 * v.wyz * xyz * z + 2.0 * v.wyz * xz * yz),
      wyz = (s * s * v.wyz + v.wyz * y * y + v.wyz * yz * yz + v.wyz * z * z - 2.0 * s * v.wxz * xy - 2.0 * v.wxy * x * z - 2.0 * v.wxy * xyz * y - 2.0 * v.wxz * xyz * z - v.wyz * x * x - v.wyz * xy * xy - v.wyz * xyz * xyz - v.wyz * xz * xz + 2.0 * s * v.wxy * xz + 2.0 * v.wxy * xy * yz + 2.0 * v.wxz * x * y + 2.0 * v.wxz * xz * yz),
      xyz = 0.0,
      i = 0.0,
    )

  infix def sandwich(v: PointNormalized): Multivector =
    Multivector(
      s = 0.0,
      w = 0.0,
      x = 0.0,
      y = 0.0,
      z = 0.0,
      wx = (-2.0 * i * x - 2.0 * s * wyz - 2.0 * wxy * xz - 2.0 * wy * z + 2.0 * w * yz + 2.0 * wx * xyz + 2.0 * wxz * xy + 2.0 * wz * y - 2.0 * v.wxy * x * xy - 2.0 * v.wxy * yz * z - 2.0 * v.wxz * x * xz - 2.0 * v.wxz * xy * xyz - 2.0 * v.wyz * x * yz - 2.0 * v.wyz * xz * y + 2.0 * s * v.wxy * y + 2.0 * s * v.wxz * z + 2.0 * s * v.wyz * xyz + 2.0 * v.wxy * xyz * xz + 2.0 * v.wxz * y * yz + 2.0 * v.wyz * xy * z),
      wy = (-2.0 * i * y - 2.0 * w * xz - 2.0 * wxy * yz - 2.0 * wz * x + 2.0 * s * wxz + 2.0 * wx * z + 2.0 * wy * xyz + 2.0 * wyz * xy - 2.0 * s * v.wxy * x - 2.0 * s * v.wxz * xyz - 2.0 * v.wxy * xy * y - 2.0 * v.wxz * x * yz - 2.0 * v.wxz * xy * z - 2.0 * v.wxz * xz * y - 2.0 * v.wyz * xy * xyz - 2.0 * v.wyz * y * yz + 2.0 * s * v.wyz * z + 2.0 * v.wxy * xyz * yz + 2.0 * v.wxy * xz * z + 2.0 * v.wyz * x * xz),
      wz = (-2.0 * i * z - 2.0 * s * wxy - 2.0 * wx * y - 2.0 * wxz * yz + 2.0 * w * xy + 2.0 * wy * x + 2.0 * wyz * xz + 2.0 * wz * xyz - 2.0 * s * v.wxz * x - 2.0 * s * v.wyz * y - 2.0 * v.wxy * xy * z - 2.0 * v.wxy * xz * y - 2.0 * v.wxz * xz * z - 2.0 * v.wyz * x * xy - 2.0 * v.wyz * xyz * xz - 2.0 * v.wyz * yz * z + 2.0 * s * v.wxy * xyz + 2.0 * v.wxy * x * yz + 2.0 * v.wxz * xy * y + 2.0 * v.wxz * xyz * yz),
      xy = (-2.0 * x * xz - 2.0 * y * yz + 2.0 * s * z + 2.0 * xy * xyz),
      xz = (-2.0 * s * y - 2.0 * yz * z + 2.0 * x * xy + 2.0 * xyz * xz),
      yz = (2.0 * s * x + 2.0 * xy * y + 2.0 * xyz * yz + 2.0 * xz * z),
      wxy = (-2.0 * wx * xz - 2.0 * wxz * x - 2.0 * wy * yz - 2.0 * wyz * y + 2.0 * i * xy + 2.0 * s * wz + 2.0 * w * z + 2.0 * wxy * xyz + s * s * v.wxy + v.wxy * x * x + v.wxy * xy * xy + v.wxy * y * y - 2.0 * s * v.wyz * xz - 2.0 * v.wyz * x * z - v.wxy * xyz * xyz - v.wxy * xz * xz - v.wxy * yz * yz - v.wxy * z * z + 2.0 * s * v.wxz * yz + 2.0 * v.wxz * x * xyz + 2.0 * v.wxz * xy * xz + 2.0 * v.wxz * y * z + 2.0 * v.wyz * xy * yz + 2.0 * v.wyz * xyz * y),
      wxz = (-2.0 * s * wy - 2.0 * w * y - 2.0 * wyz * z - 2.0 * wz * yz + 2.0 * i * xz + 2.0 * wx * xy + 2.0 * wxy * x + 2.0 * wxz * xyz + s * s * v.wxz + v.wxz * x * x + v.wxz * xz * xz + v.wxz * z * z - 2.0 * s * v.wxy * yz - 2.0 * v.wxy * x * xyz - v.wxz * xy * xy - v.wxz * xyz * xyz - v.wxz * y * y - v.wxz * yz * yz + 2.0 * s * v.wyz * xy + 2.0 * v.wxy * xy * xz + 2.0 * v.wxy * y * z + 2.0 * v.wyz * x * y + 2.0 * v.wyz * xyz * z + 2.0 * v.wyz * xz * yz),
      wyz = (2.0 * i * yz + 2.0 * s * wx + 2.0 * w * x + 2.0 * wxy * y + 2.0 * wxz * z + 2.0 * wy * xy + 2.0 * wyz * xyz + 2.0 * wz * xz + s * s * v.wyz + v.wyz * y * y + v.wyz * yz * yz + v.wyz * z * z - 2.0 * s * v.wxz * xy - 2.0 * v.wxy * x * z - 2.0 * v.wxy * xyz * y - 2.0 * v.wxz * xyz * z - v.wyz * x * x - v.wyz * xy * xy - v.wyz * xyz * xyz - v.wyz * xz * xz + 2.0 * s * v.wxy * xz + 2.0 * v.wxy * xy * yz + 2.0 * v.wxz * x * y + 2.0 * v.wxz * xz * yz),
      xyz = (s * s + x * x + xy * xy + xyz * xyz + xz * xz + y * y + yz * yz + z * z),
      i = 0.0,
    )

  infix def sandwich(v: PlaneIdeal): Multivector =
    Multivector(
      s = (-2.0 * v.x * xy * y - 2.0 * v.x * xz * z - 2.0 * v.y * xyz * xz - 2.0 * v.y * yz * z + 2.0 * s * v.x * x + 2.0 * s * v.y * y + 2.0 * s * v.z * z + 2.0 * v.x * xyz * yz + 2.0 * v.y * x * xy + 2.0 * v.z * x * xz + 2.0 * v.z * xy * xyz + 2.0 * v.z * y * yz),
      w = (-2.0 * i * v.y * xz - 2.0 * v.x * wxy * y - 2.0 * v.x * wxz * z - 2.0 * v.x * wy * xy - 2.0 * v.x * wz * xz - 2.0 * v.y * wxz * xyz - 2.0 * v.y * wyz * z - 2.0 * v.y * wz * yz + 2.0 * i * v.x * yz + 2.0 * i * v.z * xy + 2.0 * s * v.x * wx + 2.0 * s * v.y * wy + 2.0 * s * v.z * wz + 2.0 * v.x * w * x + 2.0 * v.x * wyz * xyz + 2.0 * v.y * w * y + 2.0 * v.y * wx * xy + 2.0 * v.y * wxy * x + 2.0 * v.z * w * z + 2.0 * v.z * wx * xz + 2.0 * v.z * wxy * xyz + 2.0 * v.z * wxz * x + 2.0 * v.z * wy * yz + 2.0 * v.z * wyz * y),
      x = (s * s * v.x + v.x * x * x + v.x * xyz * xyz + v.x * yz * yz - 2.0 * v.y * xyz * z - 2.0 * v.y * xz * yz - v.x * xy * xy - v.x * xz * xz - v.x * y * y - v.x * z * z + 2.0 * s * v.y * xy + 2.0 * s * v.z * xz + 2.0 * v.y * x * y + 2.0 * v.z * x * z + 2.0 * v.z * xy * yz + 2.0 * v.z * xyz * y),
      y = (s * s * v.y + v.y * xyz * xyz + v.y * xz * xz + v.y * y * y - 2.0 * s * v.x * xy - 2.0 * v.x * xz * yz - 2.0 * v.z * x * xyz - 2.0 * v.z * xy * xz - v.y * x * x - v.y * xy * xy - v.y * yz * yz - v.y * z * z + 2.0 * s * v.z * yz + 2.0 * v.x * x * y + 2.0 * v.x * xyz * z + 2.0 * v.z * y * z),
      z = (s * s * v.z + v.z * xy * xy + v.z * xyz * xyz + v.z * z * z - 2.0 * s * v.x * xz - 2.0 * s * v.y * yz - 2.0 * v.x * xyz * y - 2.0 * v.y * xy * xz - v.z * x * x - v.z * xz * xz - v.z * y * y - v.z * yz * yz + 2.0 * v.x * x * z + 2.0 * v.x * xy * yz + 2.0 * v.y * x * xyz + 2.0 * v.y * y * z),
      wx = 0.0,
      wy = 0.0,
      wz = 0.0,
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
      wxy = 0.0,
      wxz = 0.0,
      wyz = 0.0,
      xyz = 0.0,
      i = (-2.0 * s * v.y * wxz - 2.0 * v.x * w * yz - 2.0 * v.x * wx * xyz - 2.0 * v.x * wxy * xz - 2.0 * v.x * wy * z - 2.0 * v.y * wxy * yz - 2.0 * v.y * wy * xyz - 2.0 * v.y * wz * x - 2.0 * v.z * w * xy - 2.0 * v.z * wx * y - 2.0 * v.z * wxz * yz - 2.0 * v.z * wz * xyz + 2.0 * i * v.x * x + 2.0 * i * v.y * y + 2.0 * i * v.z * z + 2.0 * s * v.x * wyz + 2.0 * s * v.z * wxy + 2.0 * v.x * wxz * xy + 2.0 * v.x * wz * y + 2.0 * v.y * w * xz + 2.0 * v.y * wx * z + 2.0 * v.y * wyz * xy + 2.0 * v.z * wy * x + 2.0 * v.z * wyz * xz),
    )

  infix def sandwich(v: BivectorBulk): Multivector =
    Multivector(
      s = 0.0,
      w = 0.0,
      x = 0.0,
      y = 0.0,
      z = 0.0,
      wx = (-2.0 * i * s * v.yz - 2.0 * i * v.xy * xz - 2.0 * s * v.xy * wy - 2.0 * s * v.xz * wz - 2.0 * v.xy * wxy * x - 2.0 * v.xy * wyz * z - 2.0 * v.xz * wxy * xyz - 2.0 * v.xz * wxz * x - 2.0 * v.xz * wy * yz - 2.0 * v.yz * wxz * y - 2.0 * v.yz * wyz * x - 2.0 * v.yz * wz * xy + 2.0 * i * v.xz * xy + 2.0 * v.xy * w * y + 2.0 * v.xy * wx * xy + 2.0 * v.xy * wxz * xyz + 2.0 * v.xy * wz * yz + 2.0 * v.xz * w * z + 2.0 * v.xz * wx * xz + 2.0 * v.xz * wyz * y + 2.0 * v.yz * w * xyz + 2.0 * v.yz * wx * yz + 2.0 * v.yz * wxy * z + 2.0 * v.yz * wy * xz),
      wy = (-2.0 * i * v.xy * yz - 2.0 * s * v.yz * wz - 2.0 * v.xy * w * x - 2.0 * v.xy * wxy * y - 2.0 * v.xy * wz * xz - 2.0 * v.xz * w * xyz - 2.0 * v.xz * wxy * z - 2.0 * v.xz * wxz * y - 2.0 * v.xz * wyz * x - 2.0 * v.yz * wx * xz - 2.0 * v.yz * wxy * xyz - 2.0 * v.yz * wyz * y + 2.0 * i * s * v.xz + 2.0 * i * v.yz * xy + 2.0 * s * v.xy * wx + 2.0 * v.xy * wxz * z + 2.0 * v.xy * wy * xy + 2.0 * v.xy * wyz * xyz + 2.0 * v.xz * wx * yz + 2.0 * v.xz * wy * xz + 2.0 * v.xz * wz * xy + 2.0 * v.yz * w * z + 2.0 * v.yz * wxz * x + 2.0 * v.yz * wy * yz),
      wz = (-2.0 * i * s * v.xy - 2.0 * i * v.xz * yz - 2.0 * v.xy * wx * yz - 2.0 * v.xy * wxy * z - 2.0 * v.xy * wxz * y - 2.0 * v.xz * w * x - 2.0 * v.xz * wxz * z - 2.0 * v.xz * wy * xy - 2.0 * v.yz * w * y - 2.0 * v.yz * wxy * x - 2.0 * v.yz * wxz * xyz - 2.0 * v.yz * wyz * z + 2.0 * i * v.yz * xz + 2.0 * s * v.xz * wx + 2.0 * s * v.yz * wy + 2.0 * v.xy * w * xyz + 2.0 * v.xy * wy * xz + 2.0 * v.xy * wyz * x + 2.0 * v.xy * wz * xy + 2.0 * v.xz * wxy * y + 2.0 * v.xz * wyz * xyz + 2.0 * v.xz * wz * xz + 2.0 * v.yz * wx * xy + 2.0 * v.yz * wz * yz),
      xy = (s * s * v.xy + v.xy * xy * xy + v.xy * xyz * xyz + v.xy * z * z - 2.0 * s * v.yz * xz - 2.0 * v.xz * x * xyz - 2.0 * v.xz * y * z - 2.0 * v.yz * xyz * y - v.xy * x * x - v.xy * xz * xz - v.xy * y * y - v.xy * yz * yz + 2.0 * s * v.xz * yz + 2.0 * v.xz * xy * xz + 2.0 * v.yz * x * z + 2.0 * v.yz * xy * yz),
      xz = (s * s * v.xz + v.xz * xyz * xyz + v.xz * xz * xz + v.xz * y * y - 2.0 * s * v.xy * yz - 2.0 * v.xy * y * z - 2.0 * v.yz * x * y - 2.0 * v.yz * xyz * z - v.xz * x * x - v.xz * xy * xy - v.xz * yz * yz - v.xz * z * z + 2.0 * s * v.yz * xy + 2.0 * v.xy * x * xyz + 2.0 * v.xy * xy * xz + 2.0 * v.yz * xz * yz),
      yz = (s * s * v.yz + v.yz * x * x + v.yz * xyz * xyz + v.yz * yz * yz - 2.0 * s * v.xz * xy - 2.0 * v.xz * x * y - v.yz * xy * xy - v.yz * xz * xz - v.yz * y * y - v.yz * z * z + 2.0 * s * v.xy * xz + 2.0 * v.xy * x * z + 2.0 * v.xy * xy * yz + 2.0 * v.xy * xyz * y + 2.0 * v.xz * xyz * z + 2.0 * v.xz * xz * yz),
      wxy = (-2.0 * i * v.xz * x - 2.0 * i * v.yz * y - 2.0 * s * v.yz * wxz - 2.0 * v.xy * wx * x - 2.0 * v.xy * wxz * xz - 2.0 * v.xy * wy * y - 2.0 * v.xy * wyz * yz - 2.0 * v.xz * wx * xyz - 2.0 * v.xz * wy * z - 2.0 * v.xz * wz * y - 2.0 * v.yz * w * xz - 2.0 * v.yz * wy * xyz + 2.0 * i * v.xy * xyz + 2.0 * s * v.xy * w + 2.0 * s * v.xz * wyz + 2.0 * v.xy * wxy * xy + 2.0 * v.xy * wz * z + 2.0 * v.xz * w * yz + 2.0 * v.xz * wxy * xz + 2.0 * v.xz * wxz * xy + 2.0 * v.yz * wx * z + 2.0 * v.yz * wxy * yz + 2.0 * v.yz * wyz * xy + 2.0 * v.yz * wz * x),
      wxz = (-2.0 * i * v.yz * z - 2.0 * s * v.xy * wyz - 2.0 * v.xy * w * yz - 2.0 * v.xy * wy * z - 2.0 * v.xy * wz * y - 2.0 * v.xz * wx * x - 2.0 * v.xz * wxy * xy - 2.0 * v.xz * wyz * yz - 2.0 * v.xz * wz * z - 2.0 * v.yz * wx * y - 2.0 * v.yz * wy * x - 2.0 * v.yz * wz * xyz + 2.0 * i * v.xy * x + 2.0 * i * v.xz * xyz + 2.0 * s * v.xz * w + 2.0 * s * v.yz * wxy + 2.0 * v.xy * wx * xyz + 2.0 * v.xy * wxy * xz + 2.0 * v.xy * wxz * xy + 2.0 * v.xz * wxz * xz + 2.0 * v.xz * wy * y + 2.0 * v.yz * w * xy + 2.0 * v.yz * wxz * yz + 2.0 * v.yz * wyz * xz),
      wyz = (-2.0 * s * v.xz * wxy - 2.0 * v.xz * w * xy - 2.0 * v.xz * wx * y - 2.0 * v.xz * wy * x - 2.0 * v.yz * wxy * xy - 2.0 * v.yz * wxz * xz - 2.0 * v.yz * wy * y - 2.0 * v.yz * wz * z + 2.0 * i * v.xy * y + 2.0 * i * v.xz * z + 2.0 * i * v.yz * xyz + 2.0 * s * v.xy * wxz + 2.0 * s * v.yz * w + 2.0 * v.xy * w * xz + 2.0 * v.xy * wx * z + 2.0 * v.xy * wxy * yz + 2.0 * v.xy * wy * xyz + 2.0 * v.xy * wyz * xy + 2.0 * v.xy * wz * x + 2.0 * v.xz * wxz * yz + 2.0 * v.xz * wyz * xz + 2.0 * v.xz * wz * xyz + 2.0 * v.yz * wx * x + 2.0 * v.yz * wyz * yz),
      xyz = (-2.0 * s * v.xz * y - 2.0 * v.xz * x * xy - 2.0 * v.yz * xy * y - 2.0 * v.yz * xz * z + 2.0 * s * v.xy * z + 2.0 * s * v.yz * x + 2.0 * v.xy * x * xz + 2.0 * v.xy * xy * xyz + 2.0 * v.xy * y * yz + 2.0 * v.xz * xyz * xz + 2.0 * v.xz * yz * z + 2.0 * v.yz * xyz * yz),
      i = 0.0,
    )

  infix def sandwich(v: BivectorWeight): Multivector =
    Multivector(
      s = 0.0,
      w = 0.0,
      x = 0.0,
      y = 0.0,
      z = 0.0,
      wx = (s * s * v.wx + v.wx * y * y + v.wx * yz * yz + v.wx * z * z - 2.0 * v.wy * x * y - 2.0 * v.wy * xz * yz - 2.0 * v.wz * x * z - 2.0 * v.wz * xyz * y - v.wx * x * x - v.wx * xy * xy - v.wx * xyz * xyz - v.wx * xz * xz + 2.0 * s * v.wy * xy + 2.0 * s * v.wz * xz + 2.0 * v.wy * xyz * z + 2.0 * v.wz * xy * yz),
      wy = (s * s * v.wy + v.wy * x * x + v.wy * xz * xz + v.wy * z * z - 2.0 * s * v.wx * xy - 2.0 * v.wx * x * y - 2.0 * v.wx * xyz * z - 2.0 * v.wx * xz * yz - 2.0 * v.wz * xy * xz - 2.0 * v.wz * y * z - v.wy * xy * xy - v.wy * xyz * xyz - v.wy * y * y - v.wy * yz * yz + 2.0 * s * v.wz * yz + 2.0 * v.wz * x * xyz),
      wz = (s * s * v.wz + v.wz * x * x + v.wz * xy * xy + v.wz * y * y - 2.0 * s * v.wx * xz - 2.0 * s * v.wy * yz - 2.0 * v.wx * x * z - 2.0 * v.wy * x * xyz - 2.0 * v.wy * xy * xz - 2.0 * v.wy * y * z - v.wz * xyz * xyz - v.wz * xz * xz - v.wz * yz * yz - v.wz * z * z + 2.0 * v.wx * xy * yz + 2.0 * v.wx * xyz * y),
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
      wxy = (-2.0 * s * v.wy * x - 2.0 * s * v.wz * xyz - 2.0 * v.wy * xz * z - 2.0 * v.wz * x * yz + 2.0 * s * v.wx * y + 2.0 * v.wx * x * xy + 2.0 * v.wx * xyz * xz + 2.0 * v.wx * yz * z + 2.0 * v.wy * xy * y + 2.0 * v.wy * xyz * yz + 2.0 * v.wz * xy * z + 2.0 * v.wz * xz * y),
      wxz = (-2.0 * s * v.wz * x - 2.0 * v.wx * xy * xyz - 2.0 * v.wx * y * yz - 2.0 * v.wz * xy * y + 2.0 * s * v.wx * z + 2.0 * s * v.wy * xyz + 2.0 * v.wx * x * xz + 2.0 * v.wy * x * yz + 2.0 * v.wy * xy * z + 2.0 * v.wy * xz * y + 2.0 * v.wz * xyz * yz + 2.0 * v.wz * xz * z),
      wyz = (-2.0 * s * v.wx * xyz - 2.0 * s * v.wz * y - 2.0 * v.wx * xy * z - 2.0 * v.wy * x * xz - 2.0 * v.wy * xy * xyz - 2.0 * v.wz * xyz * xz + 2.0 * s * v.wy * z + 2.0 * v.wx * x * yz + 2.0 * v.wx * xz * y + 2.0 * v.wy * y * yz + 2.0 * v.wz * x * xy + 2.0 * v.wz * yz * z),
      xyz = 0.0,
      i = 0.0,
    )

  infix def sandwich(v: PseudoScalar): Multivector =
    Multivector(
      s = 0.0,
      w = (-2.0 * v.i * x * yz - 2.0 * v.i * xy * z + 2.0 * s * v.i * xyz + 2.0 * v.i * xz * y),
      x = 0.0,
      y = 0.0,
      z = 0.0,
      wx = 0.0,
      wy = 0.0,
      wz = 0.0,
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
      wxy = 0.0,
      wxz = 0.0,
      wyz = 0.0,
      xyz = 0.0,
      i = (s * s * v.i + v.i * xy * xy + v.i * xz * xz + v.i * yz * yz - v.i * x * x - v.i * xyz * xyz - v.i * y * y - v.i * z * z),
    )

  infix def sandwich(v: PointCenter.type): Multivector =
    Multivector(
      s = 0.0,
      w = 0.0,
      x = 0.0,
      y = 0.0,
      z = 0.0,
      wx = (-2.0 * i * x - 2.0 * s * wyz - 2.0 * wxy * xz - 2.0 * wy * z + 2.0 * w * yz + 2.0 * wx * xyz + 2.0 * wxz * xy + 2.0 * wz * y),
      wy = (-2.0 * i * y - 2.0 * w * xz - 2.0 * wxy * yz - 2.0 * wz * x + 2.0 * s * wxz + 2.0 * wx * z + 2.0 * wy * xyz + 2.0 * wyz * xy),
      wz = (-2.0 * i * z - 2.0 * s * wxy - 2.0 * wx * y - 2.0 * wxz * yz + 2.0 * w * xy + 2.0 * wy * x + 2.0 * wyz * xz + 2.0 * wz * xyz),
      xy = (-2.0 * x * xz - 2.0 * y * yz + 2.0 * s * z + 2.0 * xy * xyz),
      xz = (-2.0 * s * y - 2.0 * yz * z + 2.0 * x * xy + 2.0 * xyz * xz),
      yz = (2.0 * s * x + 2.0 * xy * y + 2.0 * xyz * yz + 2.0 * xz * z),
      wxy = (-2.0 * wx * xz - 2.0 * wxz * x - 2.0 * wy * yz - 2.0 * wyz * y + 2.0 * i * xy + 2.0 * s * wz + 2.0 * w * z + 2.0 * wxy * xyz),
      wxz = (-2.0 * s * wy - 2.0 * w * y - 2.0 * wyz * z - 2.0 * wz * yz + 2.0 * i * xz + 2.0 * wx * xy + 2.0 * wxy * x + 2.0 * wxz * xyz),
      wyz = (2.0 * i * yz + 2.0 * s * wx + 2.0 * w * x + 2.0 * wxy * y + 2.0 * wxz * z + 2.0 * wy * xy + 2.0 * wyz * xyz + 2.0 * wz * xz),
      xyz = (s * s + x * x + xy * xy + xyz * xyz + xz * xz + y * y + yz * yz + z * z),
      i = 0.0,
    )

  infix def reverseSandwich(v: Multivector): Multivector =
    Multivector(
      s = (s * s * v.s + v.s * x * x + v.s * xy * xy + v.s * xyz * xyz + v.s * xz * xz + v.s * y * y + v.s * yz * yz + v.s * z * z - 2.0 * v.y * x * xy - 2.0 * v.y * xyz * xz - 2.0 * v.z * x * xz - 2.0 * v.z * y * yz + 2.0 * s * v.x * x + 2.0 * s * v.y * y + 2.0 * s * v.z * z + 2.0 * v.x * xy * y + 2.0 * v.x * xyz * yz + 2.0 * v.x * xz * z + 2.0 * v.y * yz * z + 2.0 * v.z * xy * xyz),
      w = (s * s * v.w + v.w * xy * xy + v.w * xz * xz + v.w * yz * yz - 2.0 * i * v.s * xyz - 2.0 * i * v.x * yz - 2.0 * i * v.z * xy - 2.0 * s * v.i * xyz - 2.0 * s * v.x * wx - 2.0 * s * v.y * wy - 2.0 * s * v.z * wz - 2.0 * v.i * xz * y - 2.0 * v.s * wx * x - 2.0 * v.s * wy * y - 2.0 * v.s * wz * z - 2.0 * v.x * wy * xy - 2.0 * v.x * wz * xz - 2.0 * v.y * wxy * x - 2.0 * v.y * wxz * xyz - 2.0 * v.y * wz * yz - 2.0 * v.z * wxz * x - 2.0 * v.z * wyz * y - v.w * x * x - v.w * xyz * xyz - v.w * y * y - v.w * z * z + 2.0 * i * v.y * xz + 2.0 * s * v.s * w + 2.0 * v.i * x * yz + 2.0 * v.i * xy * z + 2.0 * v.s * wxy * xy + 2.0 * v.s * wxz * xz + 2.0 * v.s * wyz * yz + 2.0 * v.x * w * x + 2.0 * v.x * wxy * y + 2.0 * v.x * wxz * z + 2.0 * v.x * wyz * xyz + 2.0 * v.y * w * y + 2.0 * v.y * wx * xy + 2.0 * v.y * wyz * z + 2.0 * v.z * w * z + 2.0 * v.z * wx * xz + 2.0 * v.z * wxy * xyz + 2.0 * v.z * wy * yz),
      x = (s * s * v.x + v.x * x * x + v.x * xyz * xyz + v.x * yz * yz - 2.0 * s * v.y * xy - 2.0 * s * v.z * xz - 2.0 * v.s * xy * y - 2.0 * v.s * xz * z - 2.0 * v.y * xz * yz - 2.0 * v.z * xyz * y - v.x * xy * xy - v.x * xz * xz - v.x * y * y - v.x * z * z + 2.0 * s * v.s * x + 2.0 * v.s * xyz * yz + 2.0 * v.y * x * y + 2.0 * v.y * xyz * z + 2.0 * v.z * x * z + 2.0 * v.z * xy * yz),
      y = (s * s * v.y + v.y * xyz * xyz + v.y * xz * xz + v.y * y * y - 2.0 * s * v.z * yz - 2.0 * v.s * xyz * xz - 2.0 * v.s * yz * z - 2.0 * v.x * xyz * z - 2.0 * v.x * xz * yz - 2.0 * v.z * xy * xz - v.y * x * x - v.y * xy * xy - v.y * yz * yz - v.y * z * z + 2.0 * s * v.s * y + 2.0 * s * v.x * xy + 2.0 * v.s * x * xy + 2.0 * v.x * x * y + 2.0 * v.z * x * xyz + 2.0 * v.z * y * z),
      z = (s * s * v.z + v.z * xy * xy + v.z * xyz * xyz + v.z * z * z - 2.0 * v.y * x * xyz - 2.0 * v.y * xy * xz - v.z * x * x - v.z * xz * xz - v.z * y * y - v.z * yz * yz + 2.0 * s * v.s * z + 2.0 * s * v.x * xz + 2.0 * s * v.y * yz + 2.0 * v.s * x * xz + 2.0 * v.s * xy * xyz + 2.0 * v.s * y * yz + 2.0 * v.x * x * z + 2.0 * v.x * xy * yz + 2.0 * v.x * xyz * y + 2.0 * v.y * y * z),
      wx = (s * s * v.wx + v.wx * y * y + v.wx * yz * yz + v.wx * z * z - 2.0 * i * s * v.yz - 2.0 * i * v.xyz * x - 2.0 * i * v.xz * xy - 2.0 * s * v.wy * xy - 2.0 * s * v.wyz * xyz - 2.0 * s * v.wz * xz - 2.0 * v.wxz * xy * xyz - 2.0 * v.wxz * y * yz - 2.0 * v.wy * x * y - 2.0 * v.wy * xyz * z - 2.0 * v.wy * xz * yz - 2.0 * v.wyz * xy * z - 2.0 * v.wz * x * z - 2.0 * v.xyz * w * yz - 2.0 * v.xyz * wxy * xz - 2.0 * v.xyz * wz * y - 2.0 * v.xz * wxy * xyz - 2.0 * v.xz * wy * yz - 2.0 * v.xz * wyz * y - 2.0 * v.yz * w * xyz - 2.0 * v.yz * wxy * z - 2.0 * v.yz * wz * xy - v.wx * x * x - v.wx * xy * xy - v.wx * xyz * xyz - v.wx * xz * xz + 2.0 * i * v.xy * xz + 2.0 * s * v.wxy * y + 2.0 * s * v.wxz * z + 2.0 * s * v.xy * wy + 2.0 * s * v.xyz * wyz + 2.0 * s * v.xz * wz + 2.0 * v.wxy * x * xy + 2.0 * v.wxy * xyz * xz + 2.0 * v.wxy * yz * z + 2.0 * v.wxz * x * xz + 2.0 * v.wyz * x * yz + 2.0 * v.wyz * xz * y + 2.0 * v.wz * xy * yz + 2.0 * v.wz * xyz * y + 2.0 * v.xy * w * y + 2.0 * v.xy * wx * xy + 2.0 * v.xy * wxy * x + 2.0 * v.xy * wxz * xyz + 2.0 * v.xy * wyz * z + 2.0 * v.xy * wz * yz + 2.0 * v.xyz * wx * xyz + 2.0 * v.xyz * wxz * xy + 2.0 * v.xyz * wy * z + 2.0 * v.xz * w * z + 2.0 * v.xz * wx * xz + 2.0 * v.xz * wxz * x + 2.0 * v.yz * wx * yz + 2.0 * v.yz * wxz * y + 2.0 * v.yz * wy * xz + 2.0 * v.yz * wyz * x),
      wy = (s * s * v.wy + v.wy * x * x + v.wy * xz * xz + v.wy * z * z - 2.0 * i * v.xyz * y - 2.0 * i * v.yz * xy - 2.0 * s * v.wxy * x - 2.0 * s * v.wz * yz - 2.0 * s * v.xy * wx - 2.0 * s * v.xyz * wxz - 2.0 * v.wx * x * y - 2.0 * v.wx * xz * yz - 2.0 * v.wxy * xz * z - 2.0 * v.wyz * x * xz - 2.0 * v.wyz * xy * xyz - 2.0 * v.wz * x * xyz - 2.0 * v.wz * xy * xz - 2.0 * v.wz * y * z - 2.0 * v.xy * w * x - 2.0 * v.xy * wxz * z - 2.0 * v.xy * wz * xz - 2.0 * v.xyz * wx * z - 2.0 * v.xyz * wxy * yz - 2.0 * v.yz * wx * xz - 2.0 * v.yz * wxy * xyz - 2.0 * v.yz * wxz * x - v.wy * xy * xy - v.wy * xyz * xyz - v.wy * y * y - v.wy * yz * yz + 2.0 * i * s * v.xz + 2.0 * i * v.xy * yz + 2.0 * s * v.wx * xy + 2.0 * s * v.wxz * xyz + 2.0 * s * v.wyz * z + 2.0 * s * v.yz * wz + 2.0 * v.wx * xyz * z + 2.0 * v.wxy * xy * y + 2.0 * v.wxy * xyz * yz + 2.0 * v.wxz * x * yz + 2.0 * v.wxz * xy * z + 2.0 * v.wxz * xz * y + 2.0 * v.wyz * y * yz + 2.0 * v.xy * wxy * y + 2.0 * v.xy * wy * xy + 2.0 * v.xy * wyz * xyz + 2.0 * v.xyz * w * xz + 2.0 * v.xyz * wy * xyz + 2.0 * v.xyz * wyz * xy + 2.0 * v.xyz * wz * x + 2.0 * v.xz * w * xyz + 2.0 * v.xz * wx * yz + 2.0 * v.xz * wxy * z + 2.0 * v.xz * wxz * y + 2.0 * v.xz * wy * xz + 2.0 * v.xz * wyz * x + 2.0 * v.xz * wz * xy + 2.0 * v.yz * w * z + 2.0 * v.yz * wy * yz + 2.0 * v.yz * wyz * y),
      wz = (s * s * v.wz + v.wz * x * x + v.wz * xy * xy + v.wz * y * y - 2.0 * i * s * v.xy - 2.0 * i * v.xyz * z - 2.0 * i * v.yz * xz - 2.0 * s * v.wxy * xyz - 2.0 * s * v.wxz * x - 2.0 * s * v.wyz * y - 2.0 * s * v.xz * wx - 2.0 * s * v.yz * wy - 2.0 * v.wx * x * z - 2.0 * v.wx * xyz * y - 2.0 * v.wxy * x * yz - 2.0 * v.wxz * xy * y - 2.0 * v.wy * xy * xz - 2.0 * v.wy * y * z - 2.0 * v.wyz * xyz * xz - 2.0 * v.xy * w * xyz - 2.0 * v.xy * wx * yz - 2.0 * v.xy * wyz * x - 2.0 * v.xyz * w * xy - 2.0 * v.xyz * wxz * yz - 2.0 * v.xyz * wy * x - 2.0 * v.xz * w * x - 2.0 * v.xz * wxy * y - 2.0 * v.xz * wy * xy - 2.0 * v.yz * w * y - 2.0 * v.yz * wxz * xyz - v.wz * xyz * xyz - v.wz * xz * xz - v.wz * yz * yz - v.wz * z * z + 2.0 * i * v.xz * yz + 2.0 * s * v.wx * xz + 2.0 * s * v.wy * yz + 2.0 * s * v.xyz * wxy + 2.0 * v.wx * xy * yz + 2.0 * v.wxy * xy * z + 2.0 * v.wxy * xz * y + 2.0 * v.wxz * xyz * yz + 2.0 * v.wxz * xz * z + 2.0 * v.wy * x * xyz + 2.0 * v.wyz * x * xy + 2.0 * v.wyz * yz * z + 2.0 * v.xy * wxy * z + 2.0 * v.xy * wxz * y + 2.0 * v.xy * wy * xz + 2.0 * v.xy * wz * xy + 2.0 * v.xyz * wx * y + 2.0 * v.xyz * wyz * xz + 2.0 * v.xyz * wz * xyz + 2.0 * v.xz * wxz * z + 2.0 * v.xz * wyz * xyz + 2.0 * v.xz * wz * xz + 2.0 * v.yz * wx * xy + 2.0 * v.yz * wxy * x + 2.0 * v.yz * wyz * z + 2.0 * v.yz * wz * yz),
      xy = (s * s * v.xy + v.xy * xy * xy + v.xy * xyz * xyz + v.xy * z * z - 2.0 * s * v.xz * yz - 2.0 * v.xz * y * z - v.xy * x * x - v.xy * xz * xz - v.xy * y * y - v.xy * yz * yz + 2.0 * s * v.xyz * z + 2.0 * s * v.yz * xz + 2.0 * v.xyz * x * xz + 2.0 * v.xyz * xy * xyz + 2.0 * v.xyz * y * yz + 2.0 * v.xz * x * xyz + 2.0 * v.xz * xy * xz + 2.0 * v.yz * x * z + 2.0 * v.yz * xy * yz + 2.0 * v.yz * xyz * y),
      xz = (s * s * v.xz + v.xz * xyz * xyz + v.xz * xz * xz + v.xz * y * y - 2.0 * s * v.xyz * y - 2.0 * s * v.yz * xy - 2.0 * v.xy * x * xyz - 2.0 * v.xy * y * z - 2.0 * v.xyz * x * xy - 2.0 * v.yz * x * y - v.xz * x * x - v.xz * xy * xy - v.xz * yz * yz - v.xz * z * z + 2.0 * s * v.xy * yz + 2.0 * v.xy * xy * xz + 2.0 * v.xyz * xyz * xz + 2.0 * v.xyz * yz * z + 2.0 * v.yz * xyz * z + 2.0 * v.yz * xz * yz),
      yz = (s * s * v.yz + v.yz * x * x + v.yz * xyz * xyz + v.yz * yz * yz - 2.0 * s * v.xy * xz - 2.0 * v.xy * xyz * y - 2.0 * v.xyz * xy * y - 2.0 * v.xyz * xz * z - 2.0 * v.xz * x * y - 2.0 * v.xz * xyz * z - v.yz * xy * xy - v.yz * xz * xz - v.yz * y * y - v.yz * z * z + 2.0 * s * v.xyz * x + 2.0 * s * v.xz * xy + 2.0 * v.xy * x * z + 2.0 * v.xy * xy * yz + 2.0 * v.xyz * xyz * yz + 2.0 * v.xz * xz * yz),
      wxy = (s * s * v.wxy + v.wxy * x * x + v.wxy * xy * xy + v.wxy * y * y - 2.0 * i * v.xy * xyz - 2.0 * i * v.xyz * xy - 2.0 * i * v.xz * x - 2.0 * i * v.yz * y - 2.0 * s * v.wxz * yz - 2.0 * s * v.wy * x - 2.0 * s * v.xyz * wz - 2.0 * s * v.xz * wyz - 2.0 * v.wx * x * xy - 2.0 * v.wx * yz * z - 2.0 * v.wxz * x * xyz - 2.0 * v.wy * xy * y - 2.0 * v.wyz * x * z - 2.0 * v.wyz * xyz * y - 2.0 * v.wz * xy * z - 2.0 * v.wz * xz * y - 2.0 * v.xy * wxz * xz - 2.0 * v.xy * wyz * yz - 2.0 * v.xy * wz * z - 2.0 * v.xyz * wx * xz - 2.0 * v.xyz * wy * yz - 2.0 * v.xz * w * yz - 2.0 * v.xz * wx * xyz - 2.0 * v.yz * wx * z - 2.0 * v.yz * wy * xyz - 2.0 * v.yz * wz * x - v.wxy * xyz * xyz - v.wxy * xz * xz - v.wxy * yz * yz - v.wxy * z * z + 2.0 * s * v.wx * y + 2.0 * s * v.wyz * xz + 2.0 * s * v.wz * xyz + 2.0 * s * v.xy * w + 2.0 * s * v.yz * wxz + 2.0 * v.wx * xyz * xz + 2.0 * v.wxz * xy * xz + 2.0 * v.wxz * y * z + 2.0 * v.wy * xyz * yz + 2.0 * v.wy * xz * z + 2.0 * v.wyz * xy * yz + 2.0 * v.wz * x * yz + 2.0 * v.xy * wx * x + 2.0 * v.xy * wxy * xy + 2.0 * v.xy * wy * y + 2.0 * v.xyz * w * z + 2.0 * v.xyz * wxy * xyz + 2.0 * v.xyz * wxz * x + 2.0 * v.xyz * wyz * y + 2.0 * v.xz * wxy * xz + 2.0 * v.xz * wxz * xy + 2.0 * v.xz * wy * z + 2.0 * v.xz * wz * y + 2.0 * v.yz * w * xz + 2.0 * v.yz * wxy * yz + 2.0 * v.yz * wyz * xy),
      wxz = (s * s * v.wxz + v.wxz * x * x + v.wxz * xz * xz + v.wxz * z * z - 2.0 * i * v.xyz * xz - 2.0 * i * v.xz * xyz - 2.0 * i * v.yz * z - 2.0 * s * v.wy * xyz - 2.0 * s * v.wyz * xy - 2.0 * s * v.wz * x - 2.0 * s * v.yz * wxy - 2.0 * v.wx * x * xz - 2.0 * v.wx * xy * xyz - 2.0 * v.wy * x * yz - 2.0 * v.wy * xy * z - 2.0 * v.wy * xz * y - 2.0 * v.wyz * xyz * z - 2.0 * v.wz * xz * z - 2.0 * v.xyz * w * y - 2.0 * v.xyz * wxy * x - 2.0 * v.xyz * wz * yz - 2.0 * v.xz * wxy * xy - 2.0 * v.xz * wy * y - 2.0 * v.xz * wyz * yz - 2.0 * v.yz * w * xy - 2.0 * v.yz * wz * xyz - v.wxz * xy * xy - v.wxz * xyz * xyz - v.wxz * y * y - v.wxz * yz * yz + 2.0 * i * v.xy * x + 2.0 * s * v.wx * z + 2.0 * s * v.wxy * yz + 2.0 * s * v.xy * wyz + 2.0 * s * v.xyz * wy + 2.0 * s * v.xz * w + 2.0 * v.wx * y * yz + 2.0 * v.wxy * x * xyz + 2.0 * v.wxy * xy * xz + 2.0 * v.wxy * y * z + 2.0 * v.wyz * x * y + 2.0 * v.wyz * xz * yz + 2.0 * v.wz * xy * y + 2.0 * v.wz * xyz * yz + 2.0 * v.xy * w * yz + 2.0 * v.xy * wx * xyz + 2.0 * v.xy * wxy * xz + 2.0 * v.xy * wxz * xy + 2.0 * v.xy * wy * z + 2.0 * v.xy * wz * y + 2.0 * v.xyz * wx * xy + 2.0 * v.xyz * wxz * xyz + 2.0 * v.xyz * wyz * z + 2.0 * v.xz * wx * x + 2.0 * v.xz * wxz * xz + 2.0 * v.xz * wz * z + 2.0 * v.yz * wx * y + 2.0 * v.yz * wxz * yz + 2.0 * v.yz * wy * x + 2.0 * v.yz * wyz * xz),
      wyz = (s * s * v.wyz + v.wyz * y * y + v.wyz * yz * yz + v.wyz * z * z - 2.0 * i * v.xyz * yz - 2.0 * i * v.yz * xyz - 2.0 * s * v.wxy * xz - 2.0 * s * v.wz * y - 2.0 * s * v.xy * wxz - 2.0 * s * v.xyz * wx - 2.0 * v.wx * x * yz - 2.0 * v.wx * xz * y - 2.0 * v.wxy * x * z - 2.0 * v.wy * xy * xyz - 2.0 * v.wy * y * yz - 2.0 * v.wz * x * xy - 2.0 * v.wz * xyz * xz - 2.0 * v.wz * yz * z - 2.0 * v.xy * w * xz - 2.0 * v.xy * wx * z - 2.0 * v.xy * wz * x - 2.0 * v.xyz * wxy * y - 2.0 * v.xyz * wxz * z - 2.0 * v.yz * wx * x - 2.0 * v.yz * wxy * xy - 2.0 * v.yz * wxz * xz - v.wyz * x * x - v.wyz * xy * xy - v.wyz * xyz * xyz - v.wyz * xz * xz + 2.0 * i * v.xy * y + 2.0 * i * v.xz * z + 2.0 * s * v.wx * xyz + 2.0 * s * v.wxz * xy + 2.0 * s * v.wy * z + 2.0 * s * v.xz * wxy + 2.0 * s * v.yz * w + 2.0 * v.wx * xy * z + 2.0 * v.wxy * xy * yz + 2.0 * v.wxy * xyz * y + 2.0 * v.wxz * x * y + 2.0 * v.wxz * xyz * z + 2.0 * v.wxz * xz * yz + 2.0 * v.wy * x * xz + 2.0 * v.xy * wxy * yz + 2.0 * v.xy * wy * xyz + 2.0 * v.xy * wyz * xy + 2.0 * v.xyz * w * x + 2.0 * v.xyz * wy * xy + 2.0 * v.xyz * wyz * xyz + 2.0 * v.xyz * wz * xz + 2.0 * v.xz * w * xy + 2.0 * v.xz * wx * y + 2.0 * v.xz * wxz * yz + 2.0 * v.xz * wy * x + 2.0 * v.xz * wyz * xz + 2.0 * v.xz * wz * xyz + 2.0 * v.yz * wy * y + 2.0 * v.yz * wyz * yz + 2.0 * v.yz * wz * z),
      xyz = (s * s * v.xyz + v.xyz * x * x + v.xyz * xy * xy + v.xyz * xyz * xyz + v.xyz * xz * xz + v.xyz * y * y + v.xyz * yz * yz + v.xyz * z * z - 2.0 * s * v.xz * y - 2.0 * v.xy * x * xz - 2.0 * v.xy * y * yz - 2.0 * v.xz * yz * z + 2.0 * s * v.xy * z + 2.0 * s * v.yz * x + 2.0 * v.xy * xy * xyz + 2.0 * v.xz * x * xy + 2.0 * v.xz * xyz * xz + 2.0 * v.yz * xy * y + 2.0 * v.yz * xyz * yz + 2.0 * v.yz * xz * z),
      i = (s * s * v.i + v.i * xy * xy + v.i * xz * xz + v.i * yz * yz - 2.0 * s * v.x * wyz - 2.0 * s * v.z * wxy - 2.0 * v.s * wx * yz - 2.0 * v.s * wxy * z - 2.0 * v.s * wyz * x - 2.0 * v.s * wz * xy - 2.0 * v.w * x * yz - 2.0 * v.w * xy * z - 2.0 * v.x * wx * xyz - 2.0 * v.x * wxy * xz - 2.0 * v.x * wz * y - 2.0 * v.y * w * xz - 2.0 * v.y * wx * z - 2.0 * v.y * wxy * yz - 2.0 * v.y * wy * xyz - 2.0 * v.z * wxz * yz - 2.0 * v.z * wy * x - 2.0 * v.z * wz * xyz - v.i * x * x - v.i * xyz * xyz - v.i * y * y - v.i * z * z + 2.0 * i * s * v.s + 2.0 * i * v.x * x + 2.0 * i * v.y * y + 2.0 * i * v.z * z + 2.0 * s * v.w * xyz + 2.0 * s * v.y * wxz + 2.0 * v.s * w * xyz + 2.0 * v.s * wxz * y + 2.0 * v.s * wy * xz + 2.0 * v.w * xz * y + 2.0 * v.x * w * yz + 2.0 * v.x * wxz * xy + 2.0 * v.x * wy * z + 2.0 * v.y * wyz * xy + 2.0 * v.y * wz * x + 2.0 * v.z * w * xy + 2.0 * v.z * wx * y + 2.0 * v.z * wyz * xz),
    )

  infix def reverseSandwich(v: Motor): Multivector =
    Multivector(
      s = (s * s * v.s + v.s * x * x + v.s * xy * xy + v.s * xyz * xyz + v.s * xz * xz + v.s * y * y + v.s * yz * yz + v.s * z * z),
      w = (-2.0 * i * v.s * xyz - 2.0 * s * v.i * xyz - 2.0 * v.i * xz * y - 2.0 * v.s * wx * x - 2.0 * v.s * wy * y - 2.0 * v.s * wz * z + 2.0 * s * v.s * w + 2.0 * v.i * x * yz + 2.0 * v.i * xy * z + 2.0 * v.s * wxy * xy + 2.0 * v.s * wxz * xz + 2.0 * v.s * wyz * yz),
      x = (-2.0 * v.s * xy * y - 2.0 * v.s * xz * z + 2.0 * s * v.s * x + 2.0 * v.s * xyz * yz),
      y = (-2.0 * v.s * xyz * xz - 2.0 * v.s * yz * z + 2.0 * s * v.s * y + 2.0 * v.s * x * xy),
      z = (2.0 * s * v.s * z + 2.0 * v.s * x * xz + 2.0 * v.s * xy * xyz + 2.0 * v.s * y * yz),
      wx = (s * s * v.wx + v.wx * y * y + v.wx * yz * yz + v.wx * z * z - 2.0 * i * s * v.yz - 2.0 * i * v.xz * xy - 2.0 * s * v.wy * xy - 2.0 * s * v.wz * xz - 2.0 * v.wy * x * y - 2.0 * v.wy * xyz * z - 2.0 * v.wy * xz * yz - 2.0 * v.wz * x * z - 2.0 * v.xz * wxy * xyz - 2.0 * v.xz * wy * yz - 2.0 * v.xz * wyz * y - 2.0 * v.yz * w * xyz - 2.0 * v.yz * wxy * z - 2.0 * v.yz * wz * xy - v.wx * x * x - v.wx * xy * xy - v.wx * xyz * xyz - v.wx * xz * xz + 2.0 * i * v.xy * xz + 2.0 * s * v.xy * wy + 2.0 * s * v.xz * wz + 2.0 * v.wz * xy * yz + 2.0 * v.wz * xyz * y + 2.0 * v.xy * w * y + 2.0 * v.xy * wx * xy + 2.0 * v.xy * wxy * x + 2.0 * v.xy * wxz * xyz + 2.0 * v.xy * wyz * z + 2.0 * v.xy * wz * yz + 2.0 * v.xz * w * z + 2.0 * v.xz * wx * xz + 2.0 * v.xz * wxz * x + 2.0 * v.yz * wx * yz + 2.0 * v.yz * wxz * y + 2.0 * v.yz * wy * xz + 2.0 * v.yz * wyz * x),
      wy = (s * s * v.wy + v.wy * x * x + v.wy * xz * xz + v.wy * z * z - 2.0 * i * v.yz * xy - 2.0 * s * v.wz * yz - 2.0 * s * v.xy * wx - 2.0 * v.wx * x * y - 2.0 * v.wx * xz * yz - 2.0 * v.wz * x * xyz - 2.0 * v.wz * xy * xz - 2.0 * v.wz * y * z - 2.0 * v.xy * w * x - 2.0 * v.xy * wxz * z - 2.0 * v.xy * wz * xz - 2.0 * v.yz * wx * xz - 2.0 * v.yz * wxy * xyz - 2.0 * v.yz * wxz * x - v.wy * xy * xy - v.wy * xyz * xyz - v.wy * y * y - v.wy * yz * yz + 2.0 * i * s * v.xz + 2.0 * i * v.xy * yz + 2.0 * s * v.wx * xy + 2.0 * s * v.yz * wz + 2.0 * v.wx * xyz * z + 2.0 * v.xy * wxy * y + 2.0 * v.xy * wy * xy + 2.0 * v.xy * wyz * xyz + 2.0 * v.xz * w * xyz + 2.0 * v.xz * wx * yz + 2.0 * v.xz * wxy * z + 2.0 * v.xz * wxz * y + 2.0 * v.xz * wy * xz + 2.0 * v.xz * wyz * x + 2.0 * v.xz * wz * xy + 2.0 * v.yz * w * z + 2.0 * v.yz * wy * yz + 2.0 * v.yz * wyz * y),
      wz = (s * s * v.wz + v.wz * x * x + v.wz * xy * xy + v.wz * y * y - 2.0 * i * s * v.xy - 2.0 * i * v.yz * xz - 2.0 * s * v.xz * wx - 2.0 * s * v.yz * wy - 2.0 * v.wx * x * z - 2.0 * v.wx * xyz * y - 2.0 * v.wy * xy * xz - 2.0 * v.wy * y * z - 2.0 * v.xy * w * xyz - 2.0 * v.xy * wx * yz - 2.0 * v.xy * wyz * x - 2.0 * v.xz * w * x - 2.0 * v.xz * wxy * y - 2.0 * v.xz * wy * xy - 2.0 * v.yz * w * y - 2.0 * v.yz * wxz * xyz - v.wz * xyz * xyz - v.wz * xz * xz - v.wz * yz * yz - v.wz * z * z + 2.0 * i * v.xz * yz + 2.0 * s * v.wx * xz + 2.0 * s * v.wy * yz + 2.0 * v.wx * xy * yz + 2.0 * v.wy * x * xyz + 2.0 * v.xy * wxy * z + 2.0 * v.xy * wxz * y + 2.0 * v.xy * wy * xz + 2.0 * v.xy * wz * xy + 2.0 * v.xz * wxz * z + 2.0 * v.xz * wyz * xyz + 2.0 * v.xz * wz * xz + 2.0 * v.yz * wx * xy + 2.0 * v.yz * wxy * x + 2.0 * v.yz * wyz * z + 2.0 * v.yz * wz * yz),
      xy = (s * s * v.xy + v.xy * xy * xy + v.xy * xyz * xyz + v.xy * z * z - 2.0 * s * v.xz * yz - 2.0 * v.xz * y * z - v.xy * x * x - v.xy * xz * xz - v.xy * y * y - v.xy * yz * yz + 2.0 * s * v.yz * xz + 2.0 * v.xz * x * xyz + 2.0 * v.xz * xy * xz + 2.0 * v.yz * x * z + 2.0 * v.yz * xy * yz + 2.0 * v.yz * xyz * y),
      xz = (s * s * v.xz + v.xz * xyz * xyz + v.xz * xz * xz + v.xz * y * y - 2.0 * s * v.yz * xy - 2.0 * v.xy * x * xyz - 2.0 * v.xy * y * z - 2.0 * v.yz * x * y - v.xz * x * x - v.xz * xy * xy - v.xz * yz * yz - v.xz * z * z + 2.0 * s * v.xy * yz + 2.0 * v.xy * xy * xz + 2.0 * v.yz * xyz * z + 2.0 * v.yz * xz * yz),
      yz = (s * s * v.yz + v.yz * x * x + v.yz * xyz * xyz + v.yz * yz * yz - 2.0 * s * v.xy * xz - 2.0 * v.xy * xyz * y - 2.0 * v.xz * x * y - 2.0 * v.xz * xyz * z - v.yz * xy * xy - v.yz * xz * xz - v.yz * y * y - v.yz * z * z + 2.0 * s * v.xz * xy + 2.0 * v.xy * x * z + 2.0 * v.xy * xy * yz + 2.0 * v.xz * xz * yz),
      wxy = (-2.0 * i * v.xy * xyz - 2.0 * i * v.xz * x - 2.0 * i * v.yz * y - 2.0 * s * v.wy * x - 2.0 * s * v.xz * wyz - 2.0 * v.wx * x * xy - 2.0 * v.wx * yz * z - 2.0 * v.wy * xy * y - 2.0 * v.wz * xy * z - 2.0 * v.wz * xz * y - 2.0 * v.xy * wxz * xz - 2.0 * v.xy * wyz * yz - 2.0 * v.xy * wz * z - 2.0 * v.xz * w * yz - 2.0 * v.xz * wx * xyz - 2.0 * v.yz * wx * z - 2.0 * v.yz * wy * xyz - 2.0 * v.yz * wz * x + 2.0 * s * v.wx * y + 2.0 * s * v.wz * xyz + 2.0 * s * v.xy * w + 2.0 * s * v.yz * wxz + 2.0 * v.wx * xyz * xz + 2.0 * v.wy * xyz * yz + 2.0 * v.wy * xz * z + 2.0 * v.wz * x * yz + 2.0 * v.xy * wx * x + 2.0 * v.xy * wxy * xy + 2.0 * v.xy * wy * y + 2.0 * v.xz * wxy * xz + 2.0 * v.xz * wxz * xy + 2.0 * v.xz * wy * z + 2.0 * v.xz * wz * y + 2.0 * v.yz * w * xz + 2.0 * v.yz * wxy * yz + 2.0 * v.yz * wyz * xy),
      wxz = (-2.0 * i * v.xz * xyz - 2.0 * i * v.yz * z - 2.0 * s * v.wy * xyz - 2.0 * s * v.wz * x - 2.0 * s * v.yz * wxy - 2.0 * v.wx * x * xz - 2.0 * v.wx * xy * xyz - 2.0 * v.wy * x * yz - 2.0 * v.wy * xy * z - 2.0 * v.wy * xz * y - 2.0 * v.wz * xz * z - 2.0 * v.xz * wxy * xy - 2.0 * v.xz * wy * y - 2.0 * v.xz * wyz * yz - 2.0 * v.yz * w * xy - 2.0 * v.yz * wz * xyz + 2.0 * i * v.xy * x + 2.0 * s * v.wx * z + 2.0 * s * v.xy * wyz + 2.0 * s * v.xz * w + 2.0 * v.wx * y * yz + 2.0 * v.wz * xy * y + 2.0 * v.wz * xyz * yz + 2.0 * v.xy * w * yz + 2.0 * v.xy * wx * xyz + 2.0 * v.xy * wxy * xz + 2.0 * v.xy * wxz * xy + 2.0 * v.xy * wy * z + 2.0 * v.xy * wz * y + 2.0 * v.xz * wx * x + 2.0 * v.xz * wxz * xz + 2.0 * v.xz * wz * z + 2.0 * v.yz * wx * y + 2.0 * v.yz * wxz * yz + 2.0 * v.yz * wy * x + 2.0 * v.yz * wyz * xz),
      wyz = (-2.0 * i * v.yz * xyz - 2.0 * s * v.wz * y - 2.0 * s * v.xy * wxz - 2.0 * v.wx * x * yz - 2.0 * v.wx * xz * y - 2.0 * v.wy * xy * xyz - 2.0 * v.wy * y * yz - 2.0 * v.wz * x * xy - 2.0 * v.wz * xyz * xz - 2.0 * v.wz * yz * z - 2.0 * v.xy * w * xz - 2.0 * v.xy * wx * z - 2.0 * v.xy * wz * x - 2.0 * v.yz * wx * x - 2.0 * v.yz * wxy * xy - 2.0 * v.yz * wxz * xz + 2.0 * i * v.xy * y + 2.0 * i * v.xz * z + 2.0 * s * v.wx * xyz + 2.0 * s * v.wy * z + 2.0 * s * v.xz * wxy + 2.0 * s * v.yz * w + 2.0 * v.wx * xy * z + 2.0 * v.wy * x * xz + 2.0 * v.xy * wxy * yz + 2.0 * v.xy * wy * xyz + 2.0 * v.xy * wyz * xy + 2.0 * v.xz * w * xy + 2.0 * v.xz * wx * y + 2.0 * v.xz * wxz * yz + 2.0 * v.xz * wy * x + 2.0 * v.xz * wyz * xz + 2.0 * v.xz * wz * xyz + 2.0 * v.yz * wy * y + 2.0 * v.yz * wyz * yz + 2.0 * v.yz * wz * z),
      xyz = (-2.0 * s * v.xz * y - 2.0 * v.xy * x * xz - 2.0 * v.xy * y * yz - 2.0 * v.xz * yz * z + 2.0 * s * v.xy * z + 2.0 * s * v.yz * x + 2.0 * v.xy * xy * xyz + 2.0 * v.xz * x * xy + 2.0 * v.xz * xyz * xz + 2.0 * v.yz * xy * y + 2.0 * v.yz * xyz * yz + 2.0 * v.yz * xz * z),
      i = (s * s * v.i + v.i * xy * xy + v.i * xz * xz + v.i * yz * yz - 2.0 * v.s * wx * yz - 2.0 * v.s * wxy * z - 2.0 * v.s * wyz * x - 2.0 * v.s * wz * xy - v.i * x * x - v.i * xyz * xyz - v.i * y * y - v.i * z * z + 2.0 * i * s * v.s + 2.0 * v.s * w * xyz + 2.0 * v.s * wxz * y + 2.0 * v.s * wy * xz),
    )

  infix def reverseSandwich(v: Plane): Multivector =
    Multivector(
      s = (-2.0 * v.y * x * xy - 2.0 * v.y * xyz * xz - 2.0 * v.z * x * xz - 2.0 * v.z * y * yz + 2.0 * s * v.x * x + 2.0 * s * v.y * y + 2.0 * s * v.z * z + 2.0 * v.x * xy * y + 2.0 * v.x * xyz * yz + 2.0 * v.x * xz * z + 2.0 * v.y * yz * z + 2.0 * v.z * xy * xyz),
      w = (s * s * v.w + v.w * xy * xy + v.w * xz * xz + v.w * yz * yz - 2.0 * i * v.x * yz - 2.0 * i * v.z * xy - 2.0 * s * v.x * wx - 2.0 * s * v.y * wy - 2.0 * s * v.z * wz - 2.0 * v.x * wy * xy - 2.0 * v.x * wz * xz - 2.0 * v.y * wxy * x - 2.0 * v.y * wxz * xyz - 2.0 * v.y * wz * yz - 2.0 * v.z * wxz * x - 2.0 * v.z * wyz * y - v.w * x * x - v.w * xyz * xyz - v.w * y * y - v.w * z * z + 2.0 * i * v.y * xz + 2.0 * v.x * w * x + 2.0 * v.x * wxy * y + 2.0 * v.x * wxz * z + 2.0 * v.x * wyz * xyz + 2.0 * v.y * w * y + 2.0 * v.y * wx * xy + 2.0 * v.y * wyz * z + 2.0 * v.z * w * z + 2.0 * v.z * wx * xz + 2.0 * v.z * wxy * xyz + 2.0 * v.z * wy * yz),
      x = (s * s * v.x + v.x * x * x + v.x * xyz * xyz + v.x * yz * yz - 2.0 * s * v.y * xy - 2.0 * s * v.z * xz - 2.0 * v.y * xz * yz - 2.0 * v.z * xyz * y - v.x * xy * xy - v.x * xz * xz - v.x * y * y - v.x * z * z + 2.0 * v.y * x * y + 2.0 * v.y * xyz * z + 2.0 * v.z * x * z + 2.0 * v.z * xy * yz),
      y = (s * s * v.y + v.y * xyz * xyz + v.y * xz * xz + v.y * y * y - 2.0 * s * v.z * yz - 2.0 * v.x * xyz * z - 2.0 * v.x * xz * yz - 2.0 * v.z * xy * xz - v.y * x * x - v.y * xy * xy - v.y * yz * yz - v.y * z * z + 2.0 * s * v.x * xy + 2.0 * v.x * x * y + 2.0 * v.z * x * xyz + 2.0 * v.z * y * z),
      z = (s * s * v.z + v.z * xy * xy + v.z * xyz * xyz + v.z * z * z - 2.0 * v.y * x * xyz - 2.0 * v.y * xy * xz - v.z * x * x - v.z * xz * xz - v.z * y * y - v.z * yz * yz + 2.0 * s * v.x * xz + 2.0 * s * v.y * yz + 2.0 * v.x * x * z + 2.0 * v.x * xy * yz + 2.0 * v.x * xyz * y + 2.0 * v.y * y * z),
      wx = 0.0,
      wy = 0.0,
      wz = 0.0,
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
      wxy = 0.0,
      wxz = 0.0,
      wyz = 0.0,
      xyz = 0.0,
      i = (-2.0 * s * v.x * wyz - 2.0 * s * v.z * wxy - 2.0 * v.w * x * yz - 2.0 * v.w * xy * z - 2.0 * v.x * wx * xyz - 2.0 * v.x * wxy * xz - 2.0 * v.x * wz * y - 2.0 * v.y * w * xz - 2.0 * v.y * wx * z - 2.0 * v.y * wxy * yz - 2.0 * v.y * wy * xyz - 2.0 * v.z * wxz * yz - 2.0 * v.z * wy * x - 2.0 * v.z * wz * xyz + 2.0 * i * v.x * x + 2.0 * i * v.y * y + 2.0 * i * v.z * z + 2.0 * s * v.w * xyz + 2.0 * s * v.y * wxz + 2.0 * v.w * xz * y + 2.0 * v.x * w * yz + 2.0 * v.x * wxz * xy + 2.0 * v.x * wy * z + 2.0 * v.y * wyz * xy + 2.0 * v.y * wz * x + 2.0 * v.z * w * xy + 2.0 * v.z * wx * y + 2.0 * v.z * wyz * xz),
    )

  infix def reverseSandwich(v: Bivector): Multivector =
    Multivector(
      s = 0.0,
      w = 0.0,
      x = 0.0,
      y = 0.0,
      z = 0.0,
      wx = (s * s * v.wx + v.wx * y * y + v.wx * yz * yz + v.wx * z * z - 2.0 * i * s * v.yz - 2.0 * i * v.xz * xy - 2.0 * s * v.wy * xy - 2.0 * s * v.wz * xz - 2.0 * v.wy * x * y - 2.0 * v.wy * xyz * z - 2.0 * v.wy * xz * yz - 2.0 * v.wz * x * z - 2.0 * v.xz * wxy * xyz - 2.0 * v.xz * wy * yz - 2.0 * v.xz * wyz * y - 2.0 * v.yz * w * xyz - 2.0 * v.yz * wxy * z - 2.0 * v.yz * wz * xy - v.wx * x * x - v.wx * xy * xy - v.wx * xyz * xyz - v.wx * xz * xz + 2.0 * i * v.xy * xz + 2.0 * s * v.xy * wy + 2.0 * s * v.xz * wz + 2.0 * v.wz * xy * yz + 2.0 * v.wz * xyz * y + 2.0 * v.xy * w * y + 2.0 * v.xy * wx * xy + 2.0 * v.xy * wxy * x + 2.0 * v.xy * wxz * xyz + 2.0 * v.xy * wyz * z + 2.0 * v.xy * wz * yz + 2.0 * v.xz * w * z + 2.0 * v.xz * wx * xz + 2.0 * v.xz * wxz * x + 2.0 * v.yz * wx * yz + 2.0 * v.yz * wxz * y + 2.0 * v.yz * wy * xz + 2.0 * v.yz * wyz * x),
      wy = (s * s * v.wy + v.wy * x * x + v.wy * xz * xz + v.wy * z * z - 2.0 * i * v.yz * xy - 2.0 * s * v.wz * yz - 2.0 * s * v.xy * wx - 2.0 * v.wx * x * y - 2.0 * v.wx * xz * yz - 2.0 * v.wz * x * xyz - 2.0 * v.wz * xy * xz - 2.0 * v.wz * y * z - 2.0 * v.xy * w * x - 2.0 * v.xy * wxz * z - 2.0 * v.xy * wz * xz - 2.0 * v.yz * wx * xz - 2.0 * v.yz * wxy * xyz - 2.0 * v.yz * wxz * x - v.wy * xy * xy - v.wy * xyz * xyz - v.wy * y * y - v.wy * yz * yz + 2.0 * i * s * v.xz + 2.0 * i * v.xy * yz + 2.0 * s * v.wx * xy + 2.0 * s * v.yz * wz + 2.0 * v.wx * xyz * z + 2.0 * v.xy * wxy * y + 2.0 * v.xy * wy * xy + 2.0 * v.xy * wyz * xyz + 2.0 * v.xz * w * xyz + 2.0 * v.xz * wx * yz + 2.0 * v.xz * wxy * z + 2.0 * v.xz * wxz * y + 2.0 * v.xz * wy * xz + 2.0 * v.xz * wyz * x + 2.0 * v.xz * wz * xy + 2.0 * v.yz * w * z + 2.0 * v.yz * wy * yz + 2.0 * v.yz * wyz * y),
      wz = (s * s * v.wz + v.wz * x * x + v.wz * xy * xy + v.wz * y * y - 2.0 * i * s * v.xy - 2.0 * i * v.yz * xz - 2.0 * s * v.xz * wx - 2.0 * s * v.yz * wy - 2.0 * v.wx * x * z - 2.0 * v.wx * xyz * y - 2.0 * v.wy * xy * xz - 2.0 * v.wy * y * z - 2.0 * v.xy * w * xyz - 2.0 * v.xy * wx * yz - 2.0 * v.xy * wyz * x - 2.0 * v.xz * w * x - 2.0 * v.xz * wxy * y - 2.0 * v.xz * wy * xy - 2.0 * v.yz * w * y - 2.0 * v.yz * wxz * xyz - v.wz * xyz * xyz - v.wz * xz * xz - v.wz * yz * yz - v.wz * z * z + 2.0 * i * v.xz * yz + 2.0 * s * v.wx * xz + 2.0 * s * v.wy * yz + 2.0 * v.wx * xy * yz + 2.0 * v.wy * x * xyz + 2.0 * v.xy * wxy * z + 2.0 * v.xy * wxz * y + 2.0 * v.xy * wy * xz + 2.0 * v.xy * wz * xy + 2.0 * v.xz * wxz * z + 2.0 * v.xz * wyz * xyz + 2.0 * v.xz * wz * xz + 2.0 * v.yz * wx * xy + 2.0 * v.yz * wxy * x + 2.0 * v.yz * wyz * z + 2.0 * v.yz * wz * yz),
      xy = (s * s * v.xy + v.xy * xy * xy + v.xy * xyz * xyz + v.xy * z * z - 2.0 * s * v.xz * yz - 2.0 * v.xz * y * z - v.xy * x * x - v.xy * xz * xz - v.xy * y * y - v.xy * yz * yz + 2.0 * s * v.yz * xz + 2.0 * v.xz * x * xyz + 2.0 * v.xz * xy * xz + 2.0 * v.yz * x * z + 2.0 * v.yz * xy * yz + 2.0 * v.yz * xyz * y),
      xz = (s * s * v.xz + v.xz * xyz * xyz + v.xz * xz * xz + v.xz * y * y - 2.0 * s * v.yz * xy - 2.0 * v.xy * x * xyz - 2.0 * v.xy * y * z - 2.0 * v.yz * x * y - v.xz * x * x - v.xz * xy * xy - v.xz * yz * yz - v.xz * z * z + 2.0 * s * v.xy * yz + 2.0 * v.xy * xy * xz + 2.0 * v.yz * xyz * z + 2.0 * v.yz * xz * yz),
      yz = (s * s * v.yz + v.yz * x * x + v.yz * xyz * xyz + v.yz * yz * yz - 2.0 * s * v.xy * xz - 2.0 * v.xy * xyz * y - 2.0 * v.xz * x * y - 2.0 * v.xz * xyz * z - v.yz * xy * xy - v.yz * xz * xz - v.yz * y * y - v.yz * z * z + 2.0 * s * v.xz * xy + 2.0 * v.xy * x * z + 2.0 * v.xy * xy * yz + 2.0 * v.xz * xz * yz),
      wxy = (-2.0 * i * v.xy * xyz - 2.0 * i * v.xz * x - 2.0 * i * v.yz * y - 2.0 * s * v.wy * x - 2.0 * s * v.xz * wyz - 2.0 * v.wx * x * xy - 2.0 * v.wx * yz * z - 2.0 * v.wy * xy * y - 2.0 * v.wz * xy * z - 2.0 * v.wz * xz * y - 2.0 * v.xy * wxz * xz - 2.0 * v.xy * wyz * yz - 2.0 * v.xy * wz * z - 2.0 * v.xz * w * yz - 2.0 * v.xz * wx * xyz - 2.0 * v.yz * wx * z - 2.0 * v.yz * wy * xyz - 2.0 * v.yz * wz * x + 2.0 * s * v.wx * y + 2.0 * s * v.wz * xyz + 2.0 * s * v.xy * w + 2.0 * s * v.yz * wxz + 2.0 * v.wx * xyz * xz + 2.0 * v.wy * xyz * yz + 2.0 * v.wy * xz * z + 2.0 * v.wz * x * yz + 2.0 * v.xy * wx * x + 2.0 * v.xy * wxy * xy + 2.0 * v.xy * wy * y + 2.0 * v.xz * wxy * xz + 2.0 * v.xz * wxz * xy + 2.0 * v.xz * wy * z + 2.0 * v.xz * wz * y + 2.0 * v.yz * w * xz + 2.0 * v.yz * wxy * yz + 2.0 * v.yz * wyz * xy),
      wxz = (-2.0 * i * v.xz * xyz - 2.0 * i * v.yz * z - 2.0 * s * v.wy * xyz - 2.0 * s * v.wz * x - 2.0 * s * v.yz * wxy - 2.0 * v.wx * x * xz - 2.0 * v.wx * xy * xyz - 2.0 * v.wy * x * yz - 2.0 * v.wy * xy * z - 2.0 * v.wy * xz * y - 2.0 * v.wz * xz * z - 2.0 * v.xz * wxy * xy - 2.0 * v.xz * wy * y - 2.0 * v.xz * wyz * yz - 2.0 * v.yz * w * xy - 2.0 * v.yz * wz * xyz + 2.0 * i * v.xy * x + 2.0 * s * v.wx * z + 2.0 * s * v.xy * wyz + 2.0 * s * v.xz * w + 2.0 * v.wx * y * yz + 2.0 * v.wz * xy * y + 2.0 * v.wz * xyz * yz + 2.0 * v.xy * w * yz + 2.0 * v.xy * wx * xyz + 2.0 * v.xy * wxy * xz + 2.0 * v.xy * wxz * xy + 2.0 * v.xy * wy * z + 2.0 * v.xy * wz * y + 2.0 * v.xz * wx * x + 2.0 * v.xz * wxz * xz + 2.0 * v.xz * wz * z + 2.0 * v.yz * wx * y + 2.0 * v.yz * wxz * yz + 2.0 * v.yz * wy * x + 2.0 * v.yz * wyz * xz),
      wyz = (-2.0 * i * v.yz * xyz - 2.0 * s * v.wz * y - 2.0 * s * v.xy * wxz - 2.0 * v.wx * x * yz - 2.0 * v.wx * xz * y - 2.0 * v.wy * xy * xyz - 2.0 * v.wy * y * yz - 2.0 * v.wz * x * xy - 2.0 * v.wz * xyz * xz - 2.0 * v.wz * yz * z - 2.0 * v.xy * w * xz - 2.0 * v.xy * wx * z - 2.0 * v.xy * wz * x - 2.0 * v.yz * wx * x - 2.0 * v.yz * wxy * xy - 2.0 * v.yz * wxz * xz + 2.0 * i * v.xy * y + 2.0 * i * v.xz * z + 2.0 * s * v.wx * xyz + 2.0 * s * v.wy * z + 2.0 * s * v.xz * wxy + 2.0 * s * v.yz * w + 2.0 * v.wx * xy * z + 2.0 * v.wy * x * xz + 2.0 * v.xy * wxy * yz + 2.0 * v.xy * wy * xyz + 2.0 * v.xy * wyz * xy + 2.0 * v.xz * w * xy + 2.0 * v.xz * wx * y + 2.0 * v.xz * wxz * yz + 2.0 * v.xz * wy * x + 2.0 * v.xz * wyz * xz + 2.0 * v.xz * wz * xyz + 2.0 * v.yz * wy * y + 2.0 * v.yz * wyz * yz + 2.0 * v.yz * wz * z),
      xyz = (-2.0 * s * v.xz * y - 2.0 * v.xy * x * xz - 2.0 * v.xy * y * yz - 2.0 * v.xz * yz * z + 2.0 * s * v.xy * z + 2.0 * s * v.yz * x + 2.0 * v.xy * xy * xyz + 2.0 * v.xz * x * xy + 2.0 * v.xz * xyz * xz + 2.0 * v.yz * xy * y + 2.0 * v.yz * xyz * yz + 2.0 * v.yz * xz * z),
      i = 0.0,
    )

  infix def reverseSandwich(v: Point): Multivector =
    Multivector(
      s = 0.0,
      w = 0.0,
      x = 0.0,
      y = 0.0,
      z = 0.0,
      wx = (-2.0 * i * v.xyz * x - 2.0 * s * v.wyz * xyz - 2.0 * v.wxz * xy * xyz - 2.0 * v.wxz * y * yz - 2.0 * v.wyz * xy * z - 2.0 * v.xyz * w * yz - 2.0 * v.xyz * wxy * xz - 2.0 * v.xyz * wz * y + 2.0 * s * v.wxy * y + 2.0 * s * v.wxz * z + 2.0 * s * v.xyz * wyz + 2.0 * v.wxy * x * xy + 2.0 * v.wxy * xyz * xz + 2.0 * v.wxy * yz * z + 2.0 * v.wxz * x * xz + 2.0 * v.wyz * x * yz + 2.0 * v.wyz * xz * y + 2.0 * v.xyz * wx * xyz + 2.0 * v.xyz * wxz * xy + 2.0 * v.xyz * wy * z),
      wy = (-2.0 * i * v.xyz * y - 2.0 * s * v.wxy * x - 2.0 * s * v.xyz * wxz - 2.0 * v.wxy * xz * z - 2.0 * v.wyz * x * xz - 2.0 * v.wyz * xy * xyz - 2.0 * v.xyz * wx * z - 2.0 * v.xyz * wxy * yz + 2.0 * s * v.wxz * xyz + 2.0 * s * v.wyz * z + 2.0 * v.wxy * xy * y + 2.0 * v.wxy * xyz * yz + 2.0 * v.wxz * x * yz + 2.0 * v.wxz * xy * z + 2.0 * v.wxz * xz * y + 2.0 * v.wyz * y * yz + 2.0 * v.xyz * w * xz + 2.0 * v.xyz * wy * xyz + 2.0 * v.xyz * wyz * xy + 2.0 * v.xyz * wz * x),
      wz = (-2.0 * i * v.xyz * z - 2.0 * s * v.wxy * xyz - 2.0 * s * v.wxz * x - 2.0 * s * v.wyz * y - 2.0 * v.wxy * x * yz - 2.0 * v.wxz * xy * y - 2.0 * v.wyz * xyz * xz - 2.0 * v.xyz * w * xy - 2.0 * v.xyz * wxz * yz - 2.0 * v.xyz * wy * x + 2.0 * s * v.xyz * wxy + 2.0 * v.wxy * xy * z + 2.0 * v.wxy * xz * y + 2.0 * v.wxz * xyz * yz + 2.0 * v.wxz * xz * z + 2.0 * v.wyz * x * xy + 2.0 * v.wyz * yz * z + 2.0 * v.xyz * wx * y + 2.0 * v.xyz * wyz * xz + 2.0 * v.xyz * wz * xyz),
      xy = (2.0 * s * v.xyz * z + 2.0 * v.xyz * x * xz + 2.0 * v.xyz * xy * xyz + 2.0 * v.xyz * y * yz),
      xz = (-2.0 * s * v.xyz * y - 2.0 * v.xyz * x * xy + 2.0 * v.xyz * xyz * xz + 2.0 * v.xyz * yz * z),
      yz = (-2.0 * v.xyz * xy * y - 2.0 * v.xyz * xz * z + 2.0 * s * v.xyz * x + 2.0 * v.xyz * xyz * yz),
      wxy = (s * s * v.wxy + v.wxy * x * x + v.wxy * xy * xy + v.wxy * y * y - 2.0 * i * v.xyz * xy - 2.0 * s * v.wxz * yz - 2.0 * s * v.xyz * wz - 2.0 * v.wxz * x * xyz - 2.0 * v.wyz * x * z - 2.0 * v.wyz * xyz * y - 2.0 * v.xyz * wx * xz - 2.0 * v.xyz * wy * yz - v.wxy * xyz * xyz - v.wxy * xz * xz - v.wxy * yz * yz - v.wxy * z * z + 2.0 * s * v.wyz * xz + 2.0 * v.wxz * xy * xz + 2.0 * v.wxz * y * z + 2.0 * v.wyz * xy * yz + 2.0 * v.xyz * w * z + 2.0 * v.xyz * wxy * xyz + 2.0 * v.xyz * wxz * x + 2.0 * v.xyz * wyz * y),
      wxz = (s * s * v.wxz + v.wxz * x * x + v.wxz * xz * xz + v.wxz * z * z - 2.0 * i * v.xyz * xz - 2.0 * s * v.wyz * xy - 2.0 * v.wyz * xyz * z - 2.0 * v.xyz * w * y - 2.0 * v.xyz * wxy * x - 2.0 * v.xyz * wz * yz - v.wxz * xy * xy - v.wxz * xyz * xyz - v.wxz * y * y - v.wxz * yz * yz + 2.0 * s * v.wxy * yz + 2.0 * s * v.xyz * wy + 2.0 * v.wxy * x * xyz + 2.0 * v.wxy * xy * xz + 2.0 * v.wxy * y * z + 2.0 * v.wyz * x * y + 2.0 * v.wyz * xz * yz + 2.0 * v.xyz * wx * xy + 2.0 * v.xyz * wxz * xyz + 2.0 * v.xyz * wyz * z),
      wyz = (s * s * v.wyz + v.wyz * y * y + v.wyz * yz * yz + v.wyz * z * z - 2.0 * i * v.xyz * yz - 2.0 * s * v.wxy * xz - 2.0 * s * v.xyz * wx - 2.0 * v.wxy * x * z - 2.0 * v.xyz * wxy * y - 2.0 * v.xyz * wxz * z - v.wyz * x * x - v.wyz * xy * xy - v.wyz * xyz * xyz - v.wyz * xz * xz + 2.0 * s * v.wxz * xy + 2.0 * v.wxy * xy * yz + 2.0 * v.wxy * xyz * y + 2.0 * v.wxz * x * y + 2.0 * v.wxz * xyz * z + 2.0 * v.wxz * xz * yz + 2.0 * v.xyz * w * x + 2.0 * v.xyz * wy * xy + 2.0 * v.xyz * wyz * xyz + 2.0 * v.xyz * wz * xz),
      xyz = (s * s * v.xyz + v.xyz * x * x + v.xyz * xy * xy + v.xyz * xyz * xyz + v.xyz * xz * xz + v.xyz * y * y + v.xyz * yz * yz + v.xyz * z * z),
      i = 0.0,
    )

  infix def reverseSandwich(v: Quaternion): Multivector =
    Multivector(
      s = (s * s * v.s + v.s * x * x + v.s * xy * xy + v.s * xyz * xyz + v.s * xz * xz + v.s * y * y + v.s * yz * yz + v.s * z * z),
      w = (-2.0 * i * v.s * xyz - 2.0 * v.s * wx * x - 2.0 * v.s * wy * y - 2.0 * v.s * wz * z + 2.0 * s * v.s * w + 2.0 * v.s * wxy * xy + 2.0 * v.s * wxz * xz + 2.0 * v.s * wyz * yz),
      x = (-2.0 * v.s * xy * y - 2.0 * v.s * xz * z + 2.0 * s * v.s * x + 2.0 * v.s * xyz * yz),
      y = (-2.0 * v.s * xyz * xz - 2.0 * v.s * yz * z + 2.0 * s * v.s * y + 2.0 * v.s * x * xy),
      z = (2.0 * s * v.s * z + 2.0 * v.s * x * xz + 2.0 * v.s * xy * xyz + 2.0 * v.s * y * yz),
      wx = (-2.0 * i * s * v.yz - 2.0 * i * v.xz * xy - 2.0 * v.xz * wxy * xyz - 2.0 * v.xz * wy * yz - 2.0 * v.xz * wyz * y - 2.0 * v.yz * w * xyz - 2.0 * v.yz * wxy * z - 2.0 * v.yz * wz * xy + 2.0 * i * v.xy * xz + 2.0 * s * v.xy * wy + 2.0 * s * v.xz * wz + 2.0 * v.xy * w * y + 2.0 * v.xy * wx * xy + 2.0 * v.xy * wxy * x + 2.0 * v.xy * wxz * xyz + 2.0 * v.xy * wyz * z + 2.0 * v.xy * wz * yz + 2.0 * v.xz * w * z + 2.0 * v.xz * wx * xz + 2.0 * v.xz * wxz * x + 2.0 * v.yz * wx * yz + 2.0 * v.yz * wxz * y + 2.0 * v.yz * wy * xz + 2.0 * v.yz * wyz * x),
      wy = (-2.0 * i * v.yz * xy - 2.0 * s * v.xy * wx - 2.0 * v.xy * w * x - 2.0 * v.xy * wxz * z - 2.0 * v.xy * wz * xz - 2.0 * v.yz * wx * xz - 2.0 * v.yz * wxy * xyz - 2.0 * v.yz * wxz * x + 2.0 * i * s * v.xz + 2.0 * i * v.xy * yz + 2.0 * s * v.yz * wz + 2.0 * v.xy * wxy * y + 2.0 * v.xy * wy * xy + 2.0 * v.xy * wyz * xyz + 2.0 * v.xz * w * xyz + 2.0 * v.xz * wx * yz + 2.0 * v.xz * wxy * z + 2.0 * v.xz * wxz * y + 2.0 * v.xz * wy * xz + 2.0 * v.xz * wyz * x + 2.0 * v.xz * wz * xy + 2.0 * v.yz * w * z + 2.0 * v.yz * wy * yz + 2.0 * v.yz * wyz * y),
      wz = (-2.0 * i * s * v.xy - 2.0 * i * v.yz * xz - 2.0 * s * v.xz * wx - 2.0 * s * v.yz * wy - 2.0 * v.xy * w * xyz - 2.0 * v.xy * wx * yz - 2.0 * v.xy * wyz * x - 2.0 * v.xz * w * x - 2.0 * v.xz * wxy * y - 2.0 * v.xz * wy * xy - 2.0 * v.yz * w * y - 2.0 * v.yz * wxz * xyz + 2.0 * i * v.xz * yz + 2.0 * v.xy * wxy * z + 2.0 * v.xy * wxz * y + 2.0 * v.xy * wy * xz + 2.0 * v.xy * wz * xy + 2.0 * v.xz * wxz * z + 2.0 * v.xz * wyz * xyz + 2.0 * v.xz * wz * xz + 2.0 * v.yz * wx * xy + 2.0 * v.yz * wxy * x + 2.0 * v.yz * wyz * z + 2.0 * v.yz * wz * yz),
      xy = (s * s * v.xy + v.xy * xy * xy + v.xy * xyz * xyz + v.xy * z * z - 2.0 * s * v.xz * yz - 2.0 * v.xz * y * z - v.xy * x * x - v.xy * xz * xz - v.xy * y * y - v.xy * yz * yz + 2.0 * s * v.yz * xz + 2.0 * v.xz * x * xyz + 2.0 * v.xz * xy * xz + 2.0 * v.yz * x * z + 2.0 * v.yz * xy * yz + 2.0 * v.yz * xyz * y),
      xz = (s * s * v.xz + v.xz * xyz * xyz + v.xz * xz * xz + v.xz * y * y - 2.0 * s * v.yz * xy - 2.0 * v.xy * x * xyz - 2.0 * v.xy * y * z - 2.0 * v.yz * x * y - v.xz * x * x - v.xz * xy * xy - v.xz * yz * yz - v.xz * z * z + 2.0 * s * v.xy * yz + 2.0 * v.xy * xy * xz + 2.0 * v.yz * xyz * z + 2.0 * v.yz * xz * yz),
      yz = (s * s * v.yz + v.yz * x * x + v.yz * xyz * xyz + v.yz * yz * yz - 2.0 * s * v.xy * xz - 2.0 * v.xy * xyz * y - 2.0 * v.xz * x * y - 2.0 * v.xz * xyz * z - v.yz * xy * xy - v.yz * xz * xz - v.yz * y * y - v.yz * z * z + 2.0 * s * v.xz * xy + 2.0 * v.xy * x * z + 2.0 * v.xy * xy * yz + 2.0 * v.xz * xz * yz),
      wxy = (-2.0 * i * v.xy * xyz - 2.0 * i * v.xz * x - 2.0 * i * v.yz * y - 2.0 * s * v.xz * wyz - 2.0 * v.xy * wxz * xz - 2.0 * v.xy * wyz * yz - 2.0 * v.xy * wz * z - 2.0 * v.xz * w * yz - 2.0 * v.xz * wx * xyz - 2.0 * v.yz * wx * z - 2.0 * v.yz * wy * xyz - 2.0 * v.yz * wz * x + 2.0 * s * v.xy * w + 2.0 * s * v.yz * wxz + 2.0 * v.xy * wx * x + 2.0 * v.xy * wxy * xy + 2.0 * v.xy * wy * y + 2.0 * v.xz * wxy * xz + 2.0 * v.xz * wxz * xy + 2.0 * v.xz * wy * z + 2.0 * v.xz * wz * y + 2.0 * v.yz * w * xz + 2.0 * v.yz * wxy * yz + 2.0 * v.yz * wyz * xy),
      wxz = (-2.0 * i * v.xz * xyz - 2.0 * i * v.yz * z - 2.0 * s * v.yz * wxy - 2.0 * v.xz * wxy * xy - 2.0 * v.xz * wy * y - 2.0 * v.xz * wyz * yz - 2.0 * v.yz * w * xy - 2.0 * v.yz * wz * xyz + 2.0 * i * v.xy * x + 2.0 * s * v.xy * wyz + 2.0 * s * v.xz * w + 2.0 * v.xy * w * yz + 2.0 * v.xy * wx * xyz + 2.0 * v.xy * wxy * xz + 2.0 * v.xy * wxz * xy + 2.0 * v.xy * wy * z + 2.0 * v.xy * wz * y + 2.0 * v.xz * wx * x + 2.0 * v.xz * wxz * xz + 2.0 * v.xz * wz * z + 2.0 * v.yz * wx * y + 2.0 * v.yz * wxz * yz + 2.0 * v.yz * wy * x + 2.0 * v.yz * wyz * xz),
      wyz = (-2.0 * i * v.yz * xyz - 2.0 * s * v.xy * wxz - 2.0 * v.xy * w * xz - 2.0 * v.xy * wx * z - 2.0 * v.xy * wz * x - 2.0 * v.yz * wx * x - 2.0 * v.yz * wxy * xy - 2.0 * v.yz * wxz * xz + 2.0 * i * v.xy * y + 2.0 * i * v.xz * z + 2.0 * s * v.xz * wxy + 2.0 * s * v.yz * w + 2.0 * v.xy * wxy * yz + 2.0 * v.xy * wy * xyz + 2.0 * v.xy * wyz * xy + 2.0 * v.xz * w * xy + 2.0 * v.xz * wx * y + 2.0 * v.xz * wxz * yz + 2.0 * v.xz * wy * x + 2.0 * v.xz * wyz * xz + 2.0 * v.xz * wz * xyz + 2.0 * v.yz * wy * y + 2.0 * v.yz * wyz * yz + 2.0 * v.yz * wz * z),
      xyz = (-2.0 * s * v.xz * y - 2.0 * v.xy * x * xz - 2.0 * v.xy * y * yz - 2.0 * v.xz * yz * z + 2.0 * s * v.xy * z + 2.0 * s * v.yz * x + 2.0 * v.xy * xy * xyz + 2.0 * v.xz * x * xy + 2.0 * v.xz * xyz * xz + 2.0 * v.yz * xy * y + 2.0 * v.yz * xyz * yz + 2.0 * v.yz * xz * z),
      i = (-2.0 * v.s * wx * yz - 2.0 * v.s * wxy * z - 2.0 * v.s * wyz * x - 2.0 * v.s * wz * xy + 2.0 * i * s * v.s + 2.0 * v.s * w * xyz + 2.0 * v.s * wxz * y + 2.0 * v.s * wy * xz),
    )

  infix def reverseSandwich(v: QuaternionDual): Multivector =
    Multivector(
      s = 0.0,
      w = (-2.0 * s * v.i * xyz - 2.0 * v.i * xz * y + 2.0 * v.i * x * yz + 2.0 * v.i * xy * z),
      x = 0.0,
      y = 0.0,
      z = 0.0,
      wx = (s * s * v.wx + v.wx * y * y + v.wx * yz * yz + v.wx * z * z - 2.0 * s * v.wy * xy - 2.0 * s * v.wz * xz - 2.0 * v.wy * x * y - 2.0 * v.wy * xyz * z - 2.0 * v.wy * xz * yz - 2.0 * v.wz * x * z - v.wx * x * x - v.wx * xy * xy - v.wx * xyz * xyz - v.wx * xz * xz + 2.0 * v.wz * xy * yz + 2.0 * v.wz * xyz * y),
      wy = (s * s * v.wy + v.wy * x * x + v.wy * xz * xz + v.wy * z * z - 2.0 * s * v.wz * yz - 2.0 * v.wx * x * y - 2.0 * v.wx * xz * yz - 2.0 * v.wz * x * xyz - 2.0 * v.wz * xy * xz - 2.0 * v.wz * y * z - v.wy * xy * xy - v.wy * xyz * xyz - v.wy * y * y - v.wy * yz * yz + 2.0 * s * v.wx * xy + 2.0 * v.wx * xyz * z),
      wz = (s * s * v.wz + v.wz * x * x + v.wz * xy * xy + v.wz * y * y - 2.0 * v.wx * x * z - 2.0 * v.wx * xyz * y - 2.0 * v.wy * xy * xz - 2.0 * v.wy * y * z - v.wz * xyz * xyz - v.wz * xz * xz - v.wz * yz * yz - v.wz * z * z + 2.0 * s * v.wx * xz + 2.0 * s * v.wy * yz + 2.0 * v.wx * xy * yz + 2.0 * v.wy * x * xyz),
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
      wxy = (-2.0 * s * v.wy * x - 2.0 * v.wx * x * xy - 2.0 * v.wx * yz * z - 2.0 * v.wy * xy * y - 2.0 * v.wz * xy * z - 2.0 * v.wz * xz * y + 2.0 * s * v.wx * y + 2.0 * s * v.wz * xyz + 2.0 * v.wx * xyz * xz + 2.0 * v.wy * xyz * yz + 2.0 * v.wy * xz * z + 2.0 * v.wz * x * yz),
      wxz = (-2.0 * s * v.wy * xyz - 2.0 * s * v.wz * x - 2.0 * v.wx * x * xz - 2.0 * v.wx * xy * xyz - 2.0 * v.wy * x * yz - 2.0 * v.wy * xy * z - 2.0 * v.wy * xz * y - 2.0 * v.wz * xz * z + 2.0 * s * v.wx * z + 2.0 * v.wx * y * yz + 2.0 * v.wz * xy * y + 2.0 * v.wz * xyz * yz),
      wyz = (-2.0 * s * v.wz * y - 2.0 * v.wx * x * yz - 2.0 * v.wx * xz * y - 2.0 * v.wy * xy * xyz - 2.0 * v.wy * y * yz - 2.0 * v.wz * x * xy - 2.0 * v.wz * xyz * xz - 2.0 * v.wz * yz * z + 2.0 * s * v.wx * xyz + 2.0 * s * v.wy * z + 2.0 * v.wx * xy * z + 2.0 * v.wy * x * xz),
      xyz = 0.0,
      i = (s * s * v.i + v.i * xy * xy + v.i * xz * xz + v.i * yz * yz - v.i * x * x - v.i * xyz * xyz - v.i * y * y - v.i * z * z),
    )

  infix def reverseSandwich(v: PointIdeal): Multivector =
    Multivector(
      s = 0.0,
      w = 0.0,
      x = 0.0,
      y = 0.0,
      z = 0.0,
      wx = (-2.0 * s * v.wyz * xyz - 2.0 * v.wxz * xy * xyz - 2.0 * v.wxz * y * yz - 2.0 * v.wyz * xy * z + 2.0 * s * v.wxy * y + 2.0 * s * v.wxz * z + 2.0 * v.wxy * x * xy + 2.0 * v.wxy * xyz * xz + 2.0 * v.wxy * yz * z + 2.0 * v.wxz * x * xz + 2.0 * v.wyz * x * yz + 2.0 * v.wyz * xz * y),
      wy = (-2.0 * s * v.wxy * x - 2.0 * v.wxy * xz * z - 2.0 * v.wyz * x * xz - 2.0 * v.wyz * xy * xyz + 2.0 * s * v.wxz * xyz + 2.0 * s * v.wyz * z + 2.0 * v.wxy * xy * y + 2.0 * v.wxy * xyz * yz + 2.0 * v.wxz * x * yz + 2.0 * v.wxz * xy * z + 2.0 * v.wxz * xz * y + 2.0 * v.wyz * y * yz),
      wz = (-2.0 * s * v.wxy * xyz - 2.0 * s * v.wxz * x - 2.0 * s * v.wyz * y - 2.0 * v.wxy * x * yz - 2.0 * v.wxz * xy * y - 2.0 * v.wyz * xyz * xz + 2.0 * v.wxy * xy * z + 2.0 * v.wxy * xz * y + 2.0 * v.wxz * xyz * yz + 2.0 * v.wxz * xz * z + 2.0 * v.wyz * x * xy + 2.0 * v.wyz * yz * z),
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
      wxy = (s * s * v.wxy + v.wxy * x * x + v.wxy * xy * xy + v.wxy * y * y - 2.0 * s * v.wxz * yz - 2.0 * v.wxz * x * xyz - 2.0 * v.wyz * x * z - 2.0 * v.wyz * xyz * y - v.wxy * xyz * xyz - v.wxy * xz * xz - v.wxy * yz * yz - v.wxy * z * z + 2.0 * s * v.wyz * xz + 2.0 * v.wxz * xy * xz + 2.0 * v.wxz * y * z + 2.0 * v.wyz * xy * yz),
      wxz = (s * s * v.wxz + v.wxz * x * x + v.wxz * xz * xz + v.wxz * z * z - 2.0 * s * v.wyz * xy - 2.0 * v.wyz * xyz * z - v.wxz * xy * xy - v.wxz * xyz * xyz - v.wxz * y * y - v.wxz * yz * yz + 2.0 * s * v.wxy * yz + 2.0 * v.wxy * x * xyz + 2.0 * v.wxy * xy * xz + 2.0 * v.wxy * y * z + 2.0 * v.wyz * x * y + 2.0 * v.wyz * xz * yz),
      wyz = (s * s * v.wyz + v.wyz * y * y + v.wyz * yz * yz + v.wyz * z * z - 2.0 * s * v.wxy * xz - 2.0 * v.wxy * x * z - v.wyz * x * x - v.wyz * xy * xy - v.wyz * xyz * xyz - v.wyz * xz * xz + 2.0 * s * v.wxz * xy + 2.0 * v.wxy * xy * yz + 2.0 * v.wxy * xyz * y + 2.0 * v.wxz * x * y + 2.0 * v.wxz * xyz * z + 2.0 * v.wxz * xz * yz),
      xyz = 0.0,
      i = 0.0,
    )

  infix def reverseSandwich(v: PointNormalized): Multivector =
    Multivector(
      s = 0.0,
      w = 0.0,
      x = 0.0,
      y = 0.0,
      z = 0.0,
      wx = (-2.0 * i * x - 2.0 * w * yz - 2.0 * wxy * xz - 2.0 * wz * y + 2.0 * s * wyz + 2.0 * wx * xyz + 2.0 * wxz * xy + 2.0 * wy * z - 2.0 * s * v.wyz * xyz - 2.0 * v.wxz * xy * xyz - 2.0 * v.wxz * y * yz - 2.0 * v.wyz * xy * z + 2.0 * s * v.wxy * y + 2.0 * s * v.wxz * z + 2.0 * v.wxy * x * xy + 2.0 * v.wxy * xyz * xz + 2.0 * v.wxy * yz * z + 2.0 * v.wxz * x * xz + 2.0 * v.wyz * x * yz + 2.0 * v.wyz * xz * y),
      wy = (-2.0 * i * y - 2.0 * s * wxz - 2.0 * wx * z - 2.0 * wxy * yz + 2.0 * w * xz + 2.0 * wy * xyz + 2.0 * wyz * xy + 2.0 * wz * x - 2.0 * s * v.wxy * x - 2.0 * v.wxy * xz * z - 2.0 * v.wyz * x * xz - 2.0 * v.wyz * xy * xyz + 2.0 * s * v.wxz * xyz + 2.0 * s * v.wyz * z + 2.0 * v.wxy * xy * y + 2.0 * v.wxy * xyz * yz + 2.0 * v.wxz * x * yz + 2.0 * v.wxz * xy * z + 2.0 * v.wxz * xz * y + 2.0 * v.wyz * y * yz),
      wz = (-2.0 * i * z - 2.0 * w * xy - 2.0 * wxz * yz - 2.0 * wy * x + 2.0 * s * wxy + 2.0 * wx * y + 2.0 * wyz * xz + 2.0 * wz * xyz - 2.0 * s * v.wxy * xyz - 2.0 * s * v.wxz * x - 2.0 * s * v.wyz * y - 2.0 * v.wxy * x * yz - 2.0 * v.wxz * xy * y - 2.0 * v.wyz * xyz * xz + 2.0 * v.wxy * xy * z + 2.0 * v.wxy * xz * y + 2.0 * v.wxz * xyz * yz + 2.0 * v.wxz * xz * z + 2.0 * v.wyz * x * xy + 2.0 * v.wyz * yz * z),
      xy = (2.0 * s * z + 2.0 * x * xz + 2.0 * xy * xyz + 2.0 * y * yz),
      xz = (-2.0 * s * y - 2.0 * x * xy + 2.0 * xyz * xz + 2.0 * yz * z),
      yz = (-2.0 * xy * y - 2.0 * xz * z + 2.0 * s * x + 2.0 * xyz * yz),
      wxy = (-2.0 * i * xy - 2.0 * s * wz - 2.0 * wx * xz - 2.0 * wy * yz + 2.0 * w * z + 2.0 * wxy * xyz + 2.0 * wxz * x + 2.0 * wyz * y + s * s * v.wxy + v.wxy * x * x + v.wxy * xy * xy + v.wxy * y * y - 2.0 * s * v.wxz * yz - 2.0 * v.wxz * x * xyz - 2.0 * v.wyz * x * z - 2.0 * v.wyz * xyz * y - v.wxy * xyz * xyz - v.wxy * xz * xz - v.wxy * yz * yz - v.wxy * z * z + 2.0 * s * v.wyz * xz + 2.0 * v.wxz * xy * xz + 2.0 * v.wxz * y * z + 2.0 * v.wyz * xy * yz),
      wxz = (-2.0 * i * xz - 2.0 * w * y - 2.0 * wxy * x - 2.0 * wz * yz + 2.0 * s * wy + 2.0 * wx * xy + 2.0 * wxz * xyz + 2.0 * wyz * z + s * s * v.wxz + v.wxz * x * x + v.wxz * xz * xz + v.wxz * z * z - 2.0 * s * v.wyz * xy - 2.0 * v.wyz * xyz * z - v.wxz * xy * xy - v.wxz * xyz * xyz - v.wxz * y * y - v.wxz * yz * yz + 2.0 * s * v.wxy * yz + 2.0 * v.wxy * x * xyz + 2.0 * v.wxy * xy * xz + 2.0 * v.wxy * y * z + 2.0 * v.wyz * x * y + 2.0 * v.wyz * xz * yz),
      wyz = (-2.0 * i * yz - 2.0 * s * wx - 2.0 * wxy * y - 2.0 * wxz * z + 2.0 * w * x + 2.0 * wy * xy + 2.0 * wyz * xyz + 2.0 * wz * xz + s * s * v.wyz + v.wyz * y * y + v.wyz * yz * yz + v.wyz * z * z - 2.0 * s * v.wxy * xz - 2.0 * v.wxy * x * z - v.wyz * x * x - v.wyz * xy * xy - v.wyz * xyz * xyz - v.wyz * xz * xz + 2.0 * s * v.wxz * xy + 2.0 * v.wxy * xy * yz + 2.0 * v.wxy * xyz * y + 2.0 * v.wxz * x * y + 2.0 * v.wxz * xyz * z + 2.0 * v.wxz * xz * yz),
      xyz = (s * s + x * x + xy * xy + xyz * xyz + xz * xz + y * y + yz * yz + z * z),
      i = 0.0,
    )

  infix def reverseSandwich(v: PlaneIdeal): Multivector =
    Multivector(
      s = (-2.0 * v.y * x * xy - 2.0 * v.y * xyz * xz - 2.0 * v.z * x * xz - 2.0 * v.z * y * yz + 2.0 * s * v.x * x + 2.0 * s * v.y * y + 2.0 * s * v.z * z + 2.0 * v.x * xy * y + 2.0 * v.x * xyz * yz + 2.0 * v.x * xz * z + 2.0 * v.y * yz * z + 2.0 * v.z * xy * xyz),
      w = (-2.0 * i * v.x * yz - 2.0 * i * v.z * xy - 2.0 * s * v.x * wx - 2.0 * s * v.y * wy - 2.0 * s * v.z * wz - 2.0 * v.x * wy * xy - 2.0 * v.x * wz * xz - 2.0 * v.y * wxy * x - 2.0 * v.y * wxz * xyz - 2.0 * v.y * wz * yz - 2.0 * v.z * wxz * x - 2.0 * v.z * wyz * y + 2.0 * i * v.y * xz + 2.0 * v.x * w * x + 2.0 * v.x * wxy * y + 2.0 * v.x * wxz * z + 2.0 * v.x * wyz * xyz + 2.0 * v.y * w * y + 2.0 * v.y * wx * xy + 2.0 * v.y * wyz * z + 2.0 * v.z * w * z + 2.0 * v.z * wx * xz + 2.0 * v.z * wxy * xyz + 2.0 * v.z * wy * yz),
      x = (s * s * v.x + v.x * x * x + v.x * xyz * xyz + v.x * yz * yz - 2.0 * s * v.y * xy - 2.0 * s * v.z * xz - 2.0 * v.y * xz * yz - 2.0 * v.z * xyz * y - v.x * xy * xy - v.x * xz * xz - v.x * y * y - v.x * z * z + 2.0 * v.y * x * y + 2.0 * v.y * xyz * z + 2.0 * v.z * x * z + 2.0 * v.z * xy * yz),
      y = (s * s * v.y + v.y * xyz * xyz + v.y * xz * xz + v.y * y * y - 2.0 * s * v.z * yz - 2.0 * v.x * xyz * z - 2.0 * v.x * xz * yz - 2.0 * v.z * xy * xz - v.y * x * x - v.y * xy * xy - v.y * yz * yz - v.y * z * z + 2.0 * s * v.x * xy + 2.0 * v.x * x * y + 2.0 * v.z * x * xyz + 2.0 * v.z * y * z),
      z = (s * s * v.z + v.z * xy * xy + v.z * xyz * xyz + v.z * z * z - 2.0 * v.y * x * xyz - 2.0 * v.y * xy * xz - v.z * x * x - v.z * xz * xz - v.z * y * y - v.z * yz * yz + 2.0 * s * v.x * xz + 2.0 * s * v.y * yz + 2.0 * v.x * x * z + 2.0 * v.x * xy * yz + 2.0 * v.x * xyz * y + 2.0 * v.y * y * z),
      wx = 0.0,
      wy = 0.0,
      wz = 0.0,
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
      wxy = 0.0,
      wxz = 0.0,
      wyz = 0.0,
      xyz = 0.0,
      i = (-2.0 * s * v.x * wyz - 2.0 * s * v.z * wxy - 2.0 * v.x * wx * xyz - 2.0 * v.x * wxy * xz - 2.0 * v.x * wz * y - 2.0 * v.y * w * xz - 2.0 * v.y * wx * z - 2.0 * v.y * wxy * yz - 2.0 * v.y * wy * xyz - 2.0 * v.z * wxz * yz - 2.0 * v.z * wy * x - 2.0 * v.z * wz * xyz + 2.0 * i * v.x * x + 2.0 * i * v.y * y + 2.0 * i * v.z * z + 2.0 * s * v.y * wxz + 2.0 * v.x * w * yz + 2.0 * v.x * wxz * xy + 2.0 * v.x * wy * z + 2.0 * v.y * wyz * xy + 2.0 * v.y * wz * x + 2.0 * v.z * w * xy + 2.0 * v.z * wx * y + 2.0 * v.z * wyz * xz),
    )

  infix def reverseSandwich(v: BivectorBulk): Multivector =
    Multivector(
      s = 0.0,
      w = 0.0,
      x = 0.0,
      y = 0.0,
      z = 0.0,
      wx = (-2.0 * i * s * v.yz - 2.0 * i * v.xz * xy - 2.0 * v.xz * wxy * xyz - 2.0 * v.xz * wy * yz - 2.0 * v.xz * wyz * y - 2.0 * v.yz * w * xyz - 2.0 * v.yz * wxy * z - 2.0 * v.yz * wz * xy + 2.0 * i * v.xy * xz + 2.0 * s * v.xy * wy + 2.0 * s * v.xz * wz + 2.0 * v.xy * w * y + 2.0 * v.xy * wx * xy + 2.0 * v.xy * wxy * x + 2.0 * v.xy * wxz * xyz + 2.0 * v.xy * wyz * z + 2.0 * v.xy * wz * yz + 2.0 * v.xz * w * z + 2.0 * v.xz * wx * xz + 2.0 * v.xz * wxz * x + 2.0 * v.yz * wx * yz + 2.0 * v.yz * wxz * y + 2.0 * v.yz * wy * xz + 2.0 * v.yz * wyz * x),
      wy = (-2.0 * i * v.yz * xy - 2.0 * s * v.xy * wx - 2.0 * v.xy * w * x - 2.0 * v.xy * wxz * z - 2.0 * v.xy * wz * xz - 2.0 * v.yz * wx * xz - 2.0 * v.yz * wxy * xyz - 2.0 * v.yz * wxz * x + 2.0 * i * s * v.xz + 2.0 * i * v.xy * yz + 2.0 * s * v.yz * wz + 2.0 * v.xy * wxy * y + 2.0 * v.xy * wy * xy + 2.0 * v.xy * wyz * xyz + 2.0 * v.xz * w * xyz + 2.0 * v.xz * wx * yz + 2.0 * v.xz * wxy * z + 2.0 * v.xz * wxz * y + 2.0 * v.xz * wy * xz + 2.0 * v.xz * wyz * x + 2.0 * v.xz * wz * xy + 2.0 * v.yz * w * z + 2.0 * v.yz * wy * yz + 2.0 * v.yz * wyz * y),
      wz = (-2.0 * i * s * v.xy - 2.0 * i * v.yz * xz - 2.0 * s * v.xz * wx - 2.0 * s * v.yz * wy - 2.0 * v.xy * w * xyz - 2.0 * v.xy * wx * yz - 2.0 * v.xy * wyz * x - 2.0 * v.xz * w * x - 2.0 * v.xz * wxy * y - 2.0 * v.xz * wy * xy - 2.0 * v.yz * w * y - 2.0 * v.yz * wxz * xyz + 2.0 * i * v.xz * yz + 2.0 * v.xy * wxy * z + 2.0 * v.xy * wxz * y + 2.0 * v.xy * wy * xz + 2.0 * v.xy * wz * xy + 2.0 * v.xz * wxz * z + 2.0 * v.xz * wyz * xyz + 2.0 * v.xz * wz * xz + 2.0 * v.yz * wx * xy + 2.0 * v.yz * wxy * x + 2.0 * v.yz * wyz * z + 2.0 * v.yz * wz * yz),
      xy = (s * s * v.xy + v.xy * xy * xy + v.xy * xyz * xyz + v.xy * z * z - 2.0 * s * v.xz * yz - 2.0 * v.xz * y * z - v.xy * x * x - v.xy * xz * xz - v.xy * y * y - v.xy * yz * yz + 2.0 * s * v.yz * xz + 2.0 * v.xz * x * xyz + 2.0 * v.xz * xy * xz + 2.0 * v.yz * x * z + 2.0 * v.yz * xy * yz + 2.0 * v.yz * xyz * y),
      xz = (s * s * v.xz + v.xz * xyz * xyz + v.xz * xz * xz + v.xz * y * y - 2.0 * s * v.yz * xy - 2.0 * v.xy * x * xyz - 2.0 * v.xy * y * z - 2.0 * v.yz * x * y - v.xz * x * x - v.xz * xy * xy - v.xz * yz * yz - v.xz * z * z + 2.0 * s * v.xy * yz + 2.0 * v.xy * xy * xz + 2.0 * v.yz * xyz * z + 2.0 * v.yz * xz * yz),
      yz = (s * s * v.yz + v.yz * x * x + v.yz * xyz * xyz + v.yz * yz * yz - 2.0 * s * v.xy * xz - 2.0 * v.xy * xyz * y - 2.0 * v.xz * x * y - 2.0 * v.xz * xyz * z - v.yz * xy * xy - v.yz * xz * xz - v.yz * y * y - v.yz * z * z + 2.0 * s * v.xz * xy + 2.0 * v.xy * x * z + 2.0 * v.xy * xy * yz + 2.0 * v.xz * xz * yz),
      wxy = (-2.0 * i * v.xy * xyz - 2.0 * i * v.xz * x - 2.0 * i * v.yz * y - 2.0 * s * v.xz * wyz - 2.0 * v.xy * wxz * xz - 2.0 * v.xy * wyz * yz - 2.0 * v.xy * wz * z - 2.0 * v.xz * w * yz - 2.0 * v.xz * wx * xyz - 2.0 * v.yz * wx * z - 2.0 * v.yz * wy * xyz - 2.0 * v.yz * wz * x + 2.0 * s * v.xy * w + 2.0 * s * v.yz * wxz + 2.0 * v.xy * wx * x + 2.0 * v.xy * wxy * xy + 2.0 * v.xy * wy * y + 2.0 * v.xz * wxy * xz + 2.0 * v.xz * wxz * xy + 2.0 * v.xz * wy * z + 2.0 * v.xz * wz * y + 2.0 * v.yz * w * xz + 2.0 * v.yz * wxy * yz + 2.0 * v.yz * wyz * xy),
      wxz = (-2.0 * i * v.xz * xyz - 2.0 * i * v.yz * z - 2.0 * s * v.yz * wxy - 2.0 * v.xz * wxy * xy - 2.0 * v.xz * wy * y - 2.0 * v.xz * wyz * yz - 2.0 * v.yz * w * xy - 2.0 * v.yz * wz * xyz + 2.0 * i * v.xy * x + 2.0 * s * v.xy * wyz + 2.0 * s * v.xz * w + 2.0 * v.xy * w * yz + 2.0 * v.xy * wx * xyz + 2.0 * v.xy * wxy * xz + 2.0 * v.xy * wxz * xy + 2.0 * v.xy * wy * z + 2.0 * v.xy * wz * y + 2.0 * v.xz * wx * x + 2.0 * v.xz * wxz * xz + 2.0 * v.xz * wz * z + 2.0 * v.yz * wx * y + 2.0 * v.yz * wxz * yz + 2.0 * v.yz * wy * x + 2.0 * v.yz * wyz * xz),
      wyz = (-2.0 * i * v.yz * xyz - 2.0 * s * v.xy * wxz - 2.0 * v.xy * w * xz - 2.0 * v.xy * wx * z - 2.0 * v.xy * wz * x - 2.0 * v.yz * wx * x - 2.0 * v.yz * wxy * xy - 2.0 * v.yz * wxz * xz + 2.0 * i * v.xy * y + 2.0 * i * v.xz * z + 2.0 * s * v.xz * wxy + 2.0 * s * v.yz * w + 2.0 * v.xy * wxy * yz + 2.0 * v.xy * wy * xyz + 2.0 * v.xy * wyz * xy + 2.0 * v.xz * w * xy + 2.0 * v.xz * wx * y + 2.0 * v.xz * wxz * yz + 2.0 * v.xz * wy * x + 2.0 * v.xz * wyz * xz + 2.0 * v.xz * wz * xyz + 2.0 * v.yz * wy * y + 2.0 * v.yz * wyz * yz + 2.0 * v.yz * wz * z),
      xyz = (-2.0 * s * v.xz * y - 2.0 * v.xy * x * xz - 2.0 * v.xy * y * yz - 2.0 * v.xz * yz * z + 2.0 * s * v.xy * z + 2.0 * s * v.yz * x + 2.0 * v.xy * xy * xyz + 2.0 * v.xz * x * xy + 2.0 * v.xz * xyz * xz + 2.0 * v.yz * xy * y + 2.0 * v.yz * xyz * yz + 2.0 * v.yz * xz * z),
      i = 0.0,
    )

  infix def reverseSandwich(v: BivectorWeight): Multivector =
    Multivector(
      s = 0.0,
      w = 0.0,
      x = 0.0,
      y = 0.0,
      z = 0.0,
      wx = (s * s * v.wx + v.wx * y * y + v.wx * yz * yz + v.wx * z * z - 2.0 * s * v.wy * xy - 2.0 * s * v.wz * xz - 2.0 * v.wy * x * y - 2.0 * v.wy * xyz * z - 2.0 * v.wy * xz * yz - 2.0 * v.wz * x * z - v.wx * x * x - v.wx * xy * xy - v.wx * xyz * xyz - v.wx * xz * xz + 2.0 * v.wz * xy * yz + 2.0 * v.wz * xyz * y),
      wy = (s * s * v.wy + v.wy * x * x + v.wy * xz * xz + v.wy * z * z - 2.0 * s * v.wz * yz - 2.0 * v.wx * x * y - 2.0 * v.wx * xz * yz - 2.0 * v.wz * x * xyz - 2.0 * v.wz * xy * xz - 2.0 * v.wz * y * z - v.wy * xy * xy - v.wy * xyz * xyz - v.wy * y * y - v.wy * yz * yz + 2.0 * s * v.wx * xy + 2.0 * v.wx * xyz * z),
      wz = (s * s * v.wz + v.wz * x * x + v.wz * xy * xy + v.wz * y * y - 2.0 * v.wx * x * z - 2.0 * v.wx * xyz * y - 2.0 * v.wy * xy * xz - 2.0 * v.wy * y * z - v.wz * xyz * xyz - v.wz * xz * xz - v.wz * yz * yz - v.wz * z * z + 2.0 * s * v.wx * xz + 2.0 * s * v.wy * yz + 2.0 * v.wx * xy * yz + 2.0 * v.wy * x * xyz),
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
      wxy = (-2.0 * s * v.wy * x - 2.0 * v.wx * x * xy - 2.0 * v.wx * yz * z - 2.0 * v.wy * xy * y - 2.0 * v.wz * xy * z - 2.0 * v.wz * xz * y + 2.0 * s * v.wx * y + 2.0 * s * v.wz * xyz + 2.0 * v.wx * xyz * xz + 2.0 * v.wy * xyz * yz + 2.0 * v.wy * xz * z + 2.0 * v.wz * x * yz),
      wxz = (-2.0 * s * v.wy * xyz - 2.0 * s * v.wz * x - 2.0 * v.wx * x * xz - 2.0 * v.wx * xy * xyz - 2.0 * v.wy * x * yz - 2.0 * v.wy * xy * z - 2.0 * v.wy * xz * y - 2.0 * v.wz * xz * z + 2.0 * s * v.wx * z + 2.0 * v.wx * y * yz + 2.0 * v.wz * xy * y + 2.0 * v.wz * xyz * yz),
      wyz = (-2.0 * s * v.wz * y - 2.0 * v.wx * x * yz - 2.0 * v.wx * xz * y - 2.0 * v.wy * xy * xyz - 2.0 * v.wy * y * yz - 2.0 * v.wz * x * xy - 2.0 * v.wz * xyz * xz - 2.0 * v.wz * yz * z + 2.0 * s * v.wx * xyz + 2.0 * s * v.wy * z + 2.0 * v.wx * xy * z + 2.0 * v.wy * x * xz),
      xyz = 0.0,
      i = 0.0,
    )

  infix def reverseSandwich(v: PseudoScalar): Multivector =
    Multivector(
      s = 0.0,
      w = (-2.0 * s * v.i * xyz - 2.0 * v.i * xz * y + 2.0 * v.i * x * yz + 2.0 * v.i * xy * z),
      x = 0.0,
      y = 0.0,
      z = 0.0,
      wx = 0.0,
      wy = 0.0,
      wz = 0.0,
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
      wxy = 0.0,
      wxz = 0.0,
      wyz = 0.0,
      xyz = 0.0,
      i = (s * s * v.i + v.i * xy * xy + v.i * xz * xz + v.i * yz * yz - v.i * x * x - v.i * xyz * xyz - v.i * y * y - v.i * z * z),
    )

  infix def reverseSandwich(v: PointCenter.type): Multivector =
    Multivector(
      s = 0.0,
      w = 0.0,
      x = 0.0,
      y = 0.0,
      z = 0.0,
      wx = (-2.0 * i * x - 2.0 * w * yz - 2.0 * wxy * xz - 2.0 * wz * y + 2.0 * s * wyz + 2.0 * wx * xyz + 2.0 * wxz * xy + 2.0 * wy * z),
      wy = (-2.0 * i * y - 2.0 * s * wxz - 2.0 * wx * z - 2.0 * wxy * yz + 2.0 * w * xz + 2.0 * wy * xyz + 2.0 * wyz * xy + 2.0 * wz * x),
      wz = (-2.0 * i * z - 2.0 * w * xy - 2.0 * wxz * yz - 2.0 * wy * x + 2.0 * s * wxy + 2.0 * wx * y + 2.0 * wyz * xz + 2.0 * wz * xyz),
      xy = (2.0 * s * z + 2.0 * x * xz + 2.0 * xy * xyz + 2.0 * y * yz),
      xz = (-2.0 * s * y - 2.0 * x * xy + 2.0 * xyz * xz + 2.0 * yz * z),
      yz = (-2.0 * xy * y - 2.0 * xz * z + 2.0 * s * x + 2.0 * xyz * yz),
      wxy = (-2.0 * i * xy - 2.0 * s * wz - 2.0 * wx * xz - 2.0 * wy * yz + 2.0 * w * z + 2.0 * wxy * xyz + 2.0 * wxz * x + 2.0 * wyz * y),
      wxz = (-2.0 * i * xz - 2.0 * w * y - 2.0 * wxy * x - 2.0 * wz * yz + 2.0 * s * wy + 2.0 * wx * xy + 2.0 * wxz * xyz + 2.0 * wyz * z),
      wyz = (-2.0 * i * yz - 2.0 * s * wx - 2.0 * wxy * y - 2.0 * wxz * z + 2.0 * w * x + 2.0 * wy * xy + 2.0 * wyz * xyz + 2.0 * wz * xz),
      xyz = (s * s + x * x + xy * xy + xyz * xyz + xz * xz + y * y + yz * yz + z * z),
      i = 0.0,
    )

  infix def cross(v: Multivector): Multivector =
    Multivector(
      s = 0.0,
      w = (v.i * xyz + v.x * wx + v.y * wy + v.z * wz - i * v.xyz - v.wx * x - v.wy * y - v.wz * z),
      x = (v.y * xy + v.z * xz - v.xy * y - v.xz * z),
      y = (v.xy * x + v.z * yz - v.x * xy - v.yz * z),
      z = (v.xz * x + v.yz * y - v.x * xz - v.y * yz),
      wx = (v.wy * xy + v.wyz * xyz + v.wz * xz + v.x * w - v.w * x - v.xy * wy - v.xyz * wyz - v.xz * wz),
      wy = (v.wz * yz + v.xy * wx + v.xyz * wxz + v.y * w - v.w * y - v.wx * xy - v.wxz * xyz - v.yz * wz),
      wz = (v.wxy * xyz + v.xz * wx + v.yz * wy + v.z * w - v.w * z - v.wx * xz - v.wy * yz - v.xyz * wxy),
      xy = (v.xz * yz + v.y * x - v.x * y - v.yz * xz),
      xz = (v.yz * xy + v.z * x - v.x * z - v.xy * yz),
      yz = (v.xy * xz + v.z * y - v.xz * xy - v.y * z),
      wxy = (i * v.z + v.wxz * yz + v.xyz * wz + v.xz * wyz - v.i * z - v.wyz * xz - v.wz * xyz - v.yz * wxz),
      wxz = (v.i * y + v.wy * xyz + v.wyz * xy + v.yz * wxy - i * v.y - v.wxy * yz - v.xy * wyz - v.xyz * wy),
      wyz = (i * v.x + v.wxy * xz + v.xy * wxz + v.xyz * wx - v.i * x - v.wx * xyz - v.wxz * xy - v.xz * wxy),
      xyz = 0.0,
      i = (v.wxz * y + v.x * wyz + v.xyz * w + v.z * wxy - v.w * xyz - v.wxy * z - v.wyz * x - v.y * wxz),
    )

  infix def cross(v: Motor): Multivector =
    Multivector(
      s = 0.0,
      w = (v.i * xyz - v.wx * x - v.wy * y - v.wz * z),
      x = (-v.xy * y - v.xz * z),
      y = (v.xy * x - v.yz * z),
      z = (v.xz * x + v.yz * y),
      wx = (v.wy * xy + v.wz * xz - v.xy * wy - v.xz * wz),
      wy = (v.wz * yz + v.xy * wx - v.wx * xy - v.yz * wz),
      wz = (v.xz * wx + v.yz * wy - v.wx * xz - v.wy * yz),
      xy = (v.xz * yz - v.yz * xz),
      xz = (v.yz * xy - v.xy * yz),
      yz = (v.xy * xz - v.xz * xy),
      wxy = (v.xz * wyz - v.i * z - v.wz * xyz - v.yz * wxz),
      wxz = (v.i * y + v.wy * xyz + v.yz * wxy - v.xy * wyz),
      wyz = (v.xy * wxz - v.i * x - v.wx * xyz - v.xz * wxy),
      xyz = 0.0,
      i = 0.0,
    )

  infix def cross(v: Plane): Multivector =
    Multivector(
      s = 0.0,
      w = (v.x * wx + v.y * wy + v.z * wz),
      x = (v.y * xy + v.z * xz),
      y = (v.z * yz - v.x * xy),
      z = (-v.x * xz - v.y * yz),
      wx = (v.x * w - v.w * x),
      wy = (v.y * w - v.w * y),
      wz = (v.z * w - v.w * z),
      xy = (v.y * x - v.x * y),
      xz = (v.z * x - v.x * z),
      yz = (v.z * y - v.y * z),
      wxy = i * v.z,
      wxz = -i * v.y,
      wyz = i * v.x,
      xyz = 0.0,
      i = (v.x * wyz + v.z * wxy - v.w * xyz - v.y * wxz),
    )

  infix def cross(v: Bivector): Multivector =
    Multivector(
      s = 0.0,
      w = (-v.wx * x - v.wy * y - v.wz * z),
      x = (-v.xy * y - v.xz * z),
      y = (v.xy * x - v.yz * z),
      z = (v.xz * x + v.yz * y),
      wx = (v.wy * xy + v.wz * xz - v.xy * wy - v.xz * wz),
      wy = (v.wz * yz + v.xy * wx - v.wx * xy - v.yz * wz),
      wz = (v.xz * wx + v.yz * wy - v.wx * xz - v.wy * yz),
      xy = (v.xz * yz - v.yz * xz),
      xz = (v.yz * xy - v.xy * yz),
      yz = (v.xy * xz - v.xz * xy),
      wxy = (v.xz * wyz - v.wz * xyz - v.yz * wxz),
      wxz = (v.wy * xyz + v.yz * wxy - v.xy * wyz),
      wyz = (v.xy * wxz - v.wx * xyz - v.xz * wxy),
      xyz = 0.0,
      i = 0.0,
    )

  infix def cross(v: Point): Multivector =
    Multivector(
      s = 0.0,
      w = -i * v.xyz,
      x = 0.0,
      y = 0.0,
      z = 0.0,
      wx = (v.wyz * xyz - v.xyz * wyz),
      wy = (v.xyz * wxz - v.wxz * xyz),
      wz = (v.wxy * xyz - v.xyz * wxy),
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
      wxy = (v.wxz * yz + v.xyz * wz - v.wyz * xz),
      wxz = (v.wyz * xy - v.wxy * yz - v.xyz * wy),
      wyz = (v.wxy * xz + v.xyz * wx - v.wxz * xy),
      xyz = 0.0,
      i = (v.wxz * y + v.xyz * w - v.wxy * z - v.wyz * x),
    )

  infix def cross(v: Quaternion): Multivector =
    Multivector(
      s = 0.0,
      w = 0.0,
      x = (-v.xy * y - v.xz * z),
      y = (v.xy * x - v.yz * z),
      z = (v.xz * x + v.yz * y),
      wx = (-v.xy * wy - v.xz * wz),
      wy = (v.xy * wx - v.yz * wz),
      wz = (v.xz * wx + v.yz * wy),
      xy = (v.xz * yz - v.yz * xz),
      xz = (v.yz * xy - v.xy * yz),
      yz = (v.xy * xz - v.xz * xy),
      wxy = (v.xz * wyz - v.yz * wxz),
      wxz = (v.yz * wxy - v.xy * wyz),
      wyz = (v.xy * wxz - v.xz * wxy),
      xyz = 0.0,
      i = 0.0,
    )

  infix def cross(v: QuaternionDual): Multivector =
    Multivector(
      s = 0.0,
      w = (v.i * xyz - v.wx * x - v.wy * y - v.wz * z),
      x = 0.0,
      y = 0.0,
      z = 0.0,
      wx = (v.wy * xy + v.wz * xz),
      wy = (v.wz * yz - v.wx * xy),
      wz = (-v.wx * xz - v.wy * yz),
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
      wxy = (-v.i * z - v.wz * xyz),
      wxz = (v.i * y + v.wy * xyz),
      wyz = (-v.i * x - v.wx * xyz),
      xyz = 0.0,
      i = 0.0,
    )

  infix def cross(v: PointIdeal): Multivector =
    Multivector(
      s = 0.0,
      w = 0.0,
      x = 0.0,
      y = 0.0,
      z = 0.0,
      wx = v.wyz * xyz,
      wy = -v.wxz * xyz,
      wz = v.wxy * xyz,
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
      wxy = (v.wxz * yz - v.wyz * xz),
      wxz = (v.wyz * xy - v.wxy * yz),
      wyz = (v.wxy * xz - v.wxz * xy),
      xyz = 0.0,
      i = (v.wxz * y - v.wxy * z - v.wyz * x),
    )

  infix def cross(v: PointNormalized): Multivector =
    Multivector(
      s = 0.0,
      w = -i,
      x = 0.0,
      y = 0.0,
      z = 0.0,
      wx = (-wyz + v.wyz * xyz),
      wy = (wxz - v.wxz * xyz),
      wz = (-wxy + v.wxy * xyz),
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
      wxy = (wz + v.wxz * yz - v.wyz * xz),
      wxz = (-wy + v.wyz * xy - v.wxy * yz),
      wyz = (wx + v.wxy * xz - v.wxz * xy),
      xyz = 0.0,
      i = (w + v.wxz * y - v.wxy * z - v.wyz * x),
    )

  infix def cross(v: PlaneIdeal): Multivector =
    Multivector(
      s = 0.0,
      w = (v.x * wx + v.y * wy + v.z * wz),
      x = (v.y * xy + v.z * xz),
      y = (v.z * yz - v.x * xy),
      z = (-v.x * xz - v.y * yz),
      wx = v.x * w,
      wy = v.y * w,
      wz = v.z * w,
      xy = (v.y * x - v.x * y),
      xz = (v.z * x - v.x * z),
      yz = (v.z * y - v.y * z),
      wxy = i * v.z,
      wxz = -i * v.y,
      wyz = i * v.x,
      xyz = 0.0,
      i = (v.x * wyz + v.z * wxy - v.y * wxz),
    )

  infix def cross(v: BivectorBulk): Multivector =
    Multivector(
      s = 0.0,
      w = 0.0,
      x = (-v.xy * y - v.xz * z),
      y = (v.xy * x - v.yz * z),
      z = (v.xz * x + v.yz * y),
      wx = (-v.xy * wy - v.xz * wz),
      wy = (v.xy * wx - v.yz * wz),
      wz = (v.xz * wx + v.yz * wy),
      xy = (v.xz * yz - v.yz * xz),
      xz = (v.yz * xy - v.xy * yz),
      yz = (v.xy * xz - v.xz * xy),
      wxy = (v.xz * wyz - v.yz * wxz),
      wxz = (v.yz * wxy - v.xy * wyz),
      wyz = (v.xy * wxz - v.xz * wxy),
      xyz = 0.0,
      i = 0.0,
    )

  infix def cross(v: BivectorWeight): Multivector =
    Multivector(
      s = 0.0,
      w = (-v.wx * x - v.wy * y - v.wz * z),
      x = 0.0,
      y = 0.0,
      z = 0.0,
      wx = (v.wy * xy + v.wz * xz),
      wy = (v.wz * yz - v.wx * xy),
      wz = (-v.wx * xz - v.wy * yz),
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
      wxy = -v.wz * xyz,
      wxz = v.wy * xyz,
      wyz = -v.wx * xyz,
      xyz = 0.0,
      i = 0.0,
    )

  infix def cross(v: PseudoScalar): Multivector =
    Multivector(
      s = 0.0,
      w = v.i * xyz,
      x = 0.0,
      y = 0.0,
      z = 0.0,
      wx = 0.0,
      wy = 0.0,
      wz = 0.0,
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
      wxy = -v.i * z,
      wxz = v.i * y,
      wyz = -v.i * x,
      xyz = 0.0,
      i = 0.0,
    )

  infix def cross(v: PointCenter.type): Multivector =
    Multivector(
      s = 0.0,
      w = -i,
      x = 0.0,
      y = 0.0,
      z = 0.0,
      wx = -wyz,
      wy = wxz,
      wz = -wxy,
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
      wxy = wz,
      wxz = -wy,
      wyz = wx,
      xyz = 0.0,
      i = w,
    )

  infix def antiGeometric(v: Multivector): Multivector =
    Multivector(
      s = (i * v.s + s * v.i + v.w * xyz + v.wx * yz + v.wxy * z + v.wyz * x + v.wz * xy + v.xy * wz + v.y * wxz + v.yz * wx - v.wxz * y - v.wy * xz - v.x * wyz - v.xyz * w - v.xz * wy - v.z * wxy),
      w = (i * v.w + v.i * w + v.wxz * wy + v.wy * wxz - v.wx * wyz - v.wxy * wz - v.wyz * wx - v.wz * wxy),
      x = (i * v.x + s * v.wyz + v.i * x + v.wxz * xy + v.wy * z + v.xy * wxz + v.y * wz + v.yz * w - v.s * wyz - v.w * yz - v.wx * xyz - v.wxy * xz - v.wz * y - v.xyz * wx - v.xz * wxy - v.z * wy),
      y = (i * v.y + v.i * y + v.s * wxz + v.w * xz + v.wyz * xy + v.wz * x + v.xy * wyz + v.z * wx - s * v.wxz - v.wx * z - v.wxy * yz - v.wy * xyz - v.x * wz - v.xyz * wy - v.xz * w - v.yz * wxy),
      z = (i * v.z + s * v.wxy + v.i * z + v.wx * y + v.wyz * xz + v.x * wy + v.xy * w + v.xz * wyz - v.s * wxy - v.w * xy - v.wxz * yz - v.wy * x - v.wz * xyz - v.xyz * wz - v.y * wx - v.yz * wxz),
      wx = (i * v.wx + v.i * wx + v.wxz * wxy + v.wy * wz - v.w * wyz - v.wxy * wxz - v.wyz * w - v.wz * wy),
      wy = (i * v.wy + v.i * wy + v.w * wxz + v.wxz * w + v.wyz * wxy + v.wz * wx - v.wx * wz - v.wxy * wyz),
      wz = (i * v.wz + v.i * wz + v.wx * wy + v.wyz * wxz - v.w * wxy - v.wxy * w - v.wxz * wyz - v.wy * wx),
      xy = (i * v.xy + v.i * xy + v.w * z + v.wxz * x + v.wyz * y + v.x * wxz + v.xyz * wxy + v.xz * wx + v.y * wyz + v.yz * wy - s * v.wz - v.s * wz - v.wx * xz - v.wxy * xyz - v.wy * yz - v.z * w),
      xz = (i * v.xz + s * v.wy + v.i * xz + v.s * wy + v.wx * xy + v.wyz * z + v.xyz * wxz + v.y * w + v.yz * wz + v.z * wyz - v.w * y - v.wxy * x - v.wxz * xyz - v.wz * yz - v.x * wxy - v.xy * wx),
      yz = (i * v.yz + v.i * yz + v.w * x + v.wy * xy + v.wz * xz + v.xyz * wyz - s * v.wx - v.s * wx - v.wxy * y - v.wxz * z - v.wyz * xyz - v.x * w - v.xy * wy - v.xz * wz - v.y * wxy - v.z * wxz),
      wxy = (i * v.wxy + v.i * wxy + v.w * wz + v.wxz * wx + v.wyz * wy + v.wz * w - v.wx * wxz - v.wy * wyz),
      wxz = (i * v.wxz + v.i * wxz + v.wx * wxy + v.wyz * wz - v.w * wy - v.wxy * wx - v.wy * w - v.wz * wyz),
      wyz = (i * v.wyz + v.i * wyz + v.w * wx + v.wx * w + v.wy * wxy + v.wz * wxz - v.wxy * wy - v.wxz * wz),
      xyz = (i * v.xyz + v.i * xyz + v.s * w + v.wx * x + v.wy * y + v.wz * z + v.x * wx + v.xy * wxy + v.xz * wxz + v.y * wy + v.yz * wyz + v.z * wz - s * v.w - v.wxy * xy - v.wxz * xz - v.wyz * yz),
      i = (i * v.i + v.wxy * wxy + v.wxz * wxz + v.wyz * wyz - v.w * w - v.wx * wx - v.wy * wy - v.wz * wz),
    )

  infix def antiGeometric(v: Motor): Multivector =
    Multivector(
      s = (i * v.s + s * v.i + v.wx * yz + v.wz * xy + v.xy * wz + v.yz * wx - v.wy * xz - v.xz * wy),
      w = (v.i * w + v.wy * wxz - v.wx * wyz - v.wz * wxy),
      x = (v.i * x + v.wy * z + v.xy * wxz + v.yz * w - v.s * wyz - v.wx * xyz - v.wz * y - v.xz * wxy),
      y = (v.i * y + v.s * wxz + v.wz * x + v.xy * wyz - v.wx * z - v.wy * xyz - v.xz * w - v.yz * wxy),
      z = (v.i * z + v.wx * y + v.xy * w + v.xz * wyz - v.s * wxy - v.wy * x - v.wz * xyz - v.yz * wxz),
      wx = (i * v.wx + v.i * wx + v.wy * wz - v.wz * wy),
      wy = (i * v.wy + v.i * wy + v.wz * wx - v.wx * wz),
      wz = (i * v.wz + v.i * wz + v.wx * wy - v.wy * wx),
      xy = (i * v.xy + v.i * xy + v.xz * wx + v.yz * wy - s * v.wz - v.s * wz - v.wx * xz - v.wy * yz),
      xz = (i * v.xz + s * v.wy + v.i * xz + v.s * wy + v.wx * xy + v.yz * wz - v.wz * yz - v.xy * wx),
      yz = (i * v.yz + v.i * yz + v.wy * xy + v.wz * xz - s * v.wx - v.s * wx - v.xy * wy - v.xz * wz),
      wxy = (v.i * wxy + v.wz * w - v.wx * wxz - v.wy * wyz),
      wxz = (v.i * wxz + v.wx * wxy - v.wy * w - v.wz * wyz),
      wyz = (v.i * wyz + v.wx * w + v.wy * wxy + v.wz * wxz),
      xyz = (v.i * xyz + v.s * w + v.wx * x + v.wy * y + v.wz * z + v.xy * wxy + v.xz * wxz + v.yz * wyz),
      i = (i * v.i - v.wx * wx - v.wy * wy - v.wz * wz),
    )

  infix def antiGeometric(v: Plane): Multivector =
    Multivector(
      s = (v.w * xyz + v.y * wxz - v.x * wyz - v.z * wxy),
      w = i * v.w,
      x = (i * v.x + v.y * wz - v.w * yz - v.z * wy),
      y = (i * v.y + v.w * xz + v.z * wx - v.x * wz),
      z = (i * v.z + v.x * wy - v.w * xy - v.y * wx),
      wx = -v.w * wyz,
      wy = v.w * wxz,
      wz = -v.w * wxy,
      xy = (v.w * z + v.x * wxz + v.y * wyz - v.z * w),
      xz = (v.y * w + v.z * wyz - v.w * y - v.x * wxy),
      yz = (v.w * x - v.x * w - v.y * wxy - v.z * wxz),
      wxy = v.w * wz,
      wxz = -v.w * wy,
      wyz = v.w * wx,
      xyz = (v.x * wx + v.y * wy + v.z * wz - s * v.w),
      i = -v.w * w,
    )

  infix def antiGeometric(v: Bivector): Multivector =
    Multivector(
      s = (v.wx * yz + v.wz * xy + v.xy * wz + v.yz * wx - v.wy * xz - v.xz * wy),
      w = (v.wy * wxz - v.wx * wyz - v.wz * wxy),
      x = (v.wy * z + v.xy * wxz + v.yz * w - v.wx * xyz - v.wz * y - v.xz * wxy),
      y = (v.wz * x + v.xy * wyz - v.wx * z - v.wy * xyz - v.xz * w - v.yz * wxy),
      z = (v.wx * y + v.xy * w + v.xz * wyz - v.wy * x - v.wz * xyz - v.yz * wxz),
      wx = (i * v.wx + v.wy * wz - v.wz * wy),
      wy = (i * v.wy + v.wz * wx - v.wx * wz),
      wz = (i * v.wz + v.wx * wy - v.wy * wx),
      xy = (i * v.xy + v.xz * wx + v.yz * wy - s * v.wz - v.wx * xz - v.wy * yz),
      xz = (i * v.xz + s * v.wy + v.wx * xy + v.yz * wz - v.wz * yz - v.xy * wx),
      yz = (i * v.yz + v.wy * xy + v.wz * xz - s * v.wx - v.xy * wy - v.xz * wz),
      wxy = (v.wz * w - v.wx * wxz - v.wy * wyz),
      wxz = (v.wx * wxy - v.wy * w - v.wz * wyz),
      wyz = (v.wx * w + v.wy * wxy + v.wz * wxz),
      xyz = (v.wx * x + v.wy * y + v.wz * z + v.xy * wxy + v.xz * wxz + v.yz * wyz),
      i = (-v.wx * wx - v.wy * wy - v.wz * wz),
    )

  infix def antiGeometric(v: Point): Multivector =
    Multivector(
      s = (v.wxy * z + v.wyz * x - v.wxz * y - v.xyz * w),
      w = (v.wxz * wy - v.wxy * wz - v.wyz * wx),
      x = (s * v.wyz + v.wxz * xy - v.wxy * xz - v.xyz * wx),
      y = (v.wyz * xy - s * v.wxz - v.wxy * yz - v.xyz * wy),
      z = (s * v.wxy + v.wyz * xz - v.wxz * yz - v.xyz * wz),
      wx = (v.wxz * wxy - v.wxy * wxz - v.wyz * w),
      wy = (v.wxz * w + v.wyz * wxy - v.wxy * wyz),
      wz = (v.wyz * wxz - v.wxy * w - v.wxz * wyz),
      xy = (v.wxz * x + v.wyz * y + v.xyz * wxy - v.wxy * xyz),
      xz = (v.wyz * z + v.xyz * wxz - v.wxy * x - v.wxz * xyz),
      yz = (v.xyz * wyz - v.wxy * y - v.wxz * z - v.wyz * xyz),
      wxy = (i * v.wxy + v.wxz * wx + v.wyz * wy),
      wxz = (i * v.wxz + v.wyz * wz - v.wxy * wx),
      wyz = (i * v.wyz - v.wxy * wy - v.wxz * wz),
      xyz = (i * v.xyz - v.wxy * xy - v.wxz * xz - v.wyz * yz),
      i = (v.wxy * wxy + v.wxz * wxz + v.wyz * wyz),
    )

  infix def antiGeometric(v: Quaternion): Multivector =
    Multivector(
      s = (i * v.s + v.xy * wz + v.yz * wx - v.xz * wy),
      w = 0.0,
      x = (v.xy * wxz + v.yz * w - v.s * wyz - v.xz * wxy),
      y = (v.s * wxz + v.xy * wyz - v.xz * w - v.yz * wxy),
      z = (v.xy * w + v.xz * wyz - v.s * wxy - v.yz * wxz),
      wx = 0.0,
      wy = 0.0,
      wz = 0.0,
      xy = (i * v.xy + v.xz * wx + v.yz * wy - v.s * wz),
      xz = (i * v.xz + v.s * wy + v.yz * wz - v.xy * wx),
      yz = (i * v.yz - v.s * wx - v.xy * wy - v.xz * wz),
      wxy = 0.0,
      wxz = 0.0,
      wyz = 0.0,
      xyz = (v.s * w + v.xy * wxy + v.xz * wxz + v.yz * wyz),
      i = 0.0,
    )

  infix def antiGeometric(v: QuaternionDual): Multivector =
    Multivector(
      s = (s * v.i + v.wx * yz + v.wz * xy - v.wy * xz),
      w = (v.i * w + v.wy * wxz - v.wx * wyz - v.wz * wxy),
      x = (v.i * x + v.wy * z - v.wx * xyz - v.wz * y),
      y = (v.i * y + v.wz * x - v.wx * z - v.wy * xyz),
      z = (v.i * z + v.wx * y - v.wy * x - v.wz * xyz),
      wx = (i * v.wx + v.i * wx + v.wy * wz - v.wz * wy),
      wy = (i * v.wy + v.i * wy + v.wz * wx - v.wx * wz),
      wz = (i * v.wz + v.i * wz + v.wx * wy - v.wy * wx),
      xy = (v.i * xy - s * v.wz - v.wx * xz - v.wy * yz),
      xz = (s * v.wy + v.i * xz + v.wx * xy - v.wz * yz),
      yz = (v.i * yz + v.wy * xy + v.wz * xz - s * v.wx),
      wxy = (v.i * wxy + v.wz * w - v.wx * wxz - v.wy * wyz),
      wxz = (v.i * wxz + v.wx * wxy - v.wy * w - v.wz * wyz),
      wyz = (v.i * wyz + v.wx * w + v.wy * wxy + v.wz * wxz),
      xyz = (v.i * xyz + v.wx * x + v.wy * y + v.wz * z),
      i = (i * v.i - v.wx * wx - v.wy * wy - v.wz * wz),
    )

  infix def antiGeometric(v: PointIdeal): Multivector =
    Multivector(
      s = (v.wxy * z + v.wyz * x - v.wxz * y),
      w = (v.wxz * wy - v.wxy * wz - v.wyz * wx),
      x = (s * v.wyz + v.wxz * xy - v.wxy * xz),
      y = (v.wyz * xy - s * v.wxz - v.wxy * yz),
      z = (s * v.wxy + v.wyz * xz - v.wxz * yz),
      wx = (v.wxz * wxy - v.wxy * wxz - v.wyz * w),
      wy = (v.wxz * w + v.wyz * wxy - v.wxy * wyz),
      wz = (v.wyz * wxz - v.wxy * w - v.wxz * wyz),
      xy = (v.wxz * x + v.wyz * y - v.wxy * xyz),
      xz = (v.wyz * z - v.wxy * x - v.wxz * xyz),
      yz = (-v.wxy * y - v.wxz * z - v.wyz * xyz),
      wxy = (i * v.wxy + v.wxz * wx + v.wyz * wy),
      wxz = (i * v.wxz + v.wyz * wz - v.wxy * wx),
      wyz = (i * v.wyz - v.wxy * wy - v.wxz * wz),
      xyz = (-v.wxy * xy - v.wxz * xz - v.wyz * yz),
      i = (v.wxy * wxy + v.wxz * wxz + v.wyz * wyz),
    )

  infix def antiGeometric(v: PointNormalized): Multivector =
    Multivector(
      s = (-w + v.wxy * z + v.wyz * x - v.wxz * y),
      w = (v.wxz * wy - v.wxy * wz - v.wyz * wx),
      x = (-wx + s * v.wyz + v.wxz * xy - v.wxy * xz),
      y = (-wy + v.wyz * xy - s * v.wxz - v.wxy * yz),
      z = (-wz + s * v.wxy + v.wyz * xz - v.wxz * yz),
      wx = (v.wxz * wxy - v.wxy * wxz - v.wyz * w),
      wy = (v.wxz * w + v.wyz * wxy - v.wxy * wyz),
      wz = (v.wyz * wxz - v.wxy * w - v.wxz * wyz),
      xy = (wxy + v.wxz * x + v.wyz * y - v.wxy * xyz),
      xz = (wxz + v.wyz * z - v.wxy * x - v.wxz * xyz),
      yz = (wyz - v.wxy * y - v.wxz * z - v.wyz * xyz),
      wxy = (i * v.wxy + v.wxz * wx + v.wyz * wy),
      wxz = (i * v.wxz + v.wyz * wz - v.wxy * wx),
      wyz = (i * v.wyz - v.wxy * wy - v.wxz * wz),
      xyz = (i - v.wxy * xy - v.wxz * xz - v.wyz * yz),
      i = (v.wxy * wxy + v.wxz * wxz + v.wyz * wyz),
    )

  infix def antiGeometric(v: PlaneIdeal): Multivector =
    Multivector(
      s = (v.y * wxz - v.x * wyz - v.z * wxy),
      w = 0.0,
      x = (i * v.x + v.y * wz - v.z * wy),
      y = (i * v.y + v.z * wx - v.x * wz),
      z = (i * v.z + v.x * wy - v.y * wx),
      wx = 0.0,
      wy = 0.0,
      wz = 0.0,
      xy = (v.x * wxz + v.y * wyz - v.z * w),
      xz = (v.y * w + v.z * wyz - v.x * wxy),
      yz = (-v.x * w - v.y * wxy - v.z * wxz),
      wxy = 0.0,
      wxz = 0.0,
      wyz = 0.0,
      xyz = (v.x * wx + v.y * wy + v.z * wz),
      i = 0.0,
    )

  infix def antiGeometric(v: BivectorBulk): Multivector =
    Multivector(
      s = (v.xy * wz + v.yz * wx - v.xz * wy),
      w = 0.0,
      x = (v.xy * wxz + v.yz * w - v.xz * wxy),
      y = (v.xy * wyz - v.xz * w - v.yz * wxy),
      z = (v.xy * w + v.xz * wyz - v.yz * wxz),
      wx = 0.0,
      wy = 0.0,
      wz = 0.0,
      xy = (i * v.xy + v.xz * wx + v.yz * wy),
      xz = (i * v.xz + v.yz * wz - v.xy * wx),
      yz = (i * v.yz - v.xy * wy - v.xz * wz),
      wxy = 0.0,
      wxz = 0.0,
      wyz = 0.0,
      xyz = (v.xy * wxy + v.xz * wxz + v.yz * wyz),
      i = 0.0,
    )

  infix def antiGeometric(v: BivectorWeight): Multivector =
    Multivector(
      s = (v.wx * yz + v.wz * xy - v.wy * xz),
      w = (v.wy * wxz - v.wx * wyz - v.wz * wxy),
      x = (v.wy * z - v.wx * xyz - v.wz * y),
      y = (v.wz * x - v.wx * z - v.wy * xyz),
      z = (v.wx * y - v.wy * x - v.wz * xyz),
      wx = (i * v.wx + v.wy * wz - v.wz * wy),
      wy = (i * v.wy + v.wz * wx - v.wx * wz),
      wz = (i * v.wz + v.wx * wy - v.wy * wx),
      xy = (-s * v.wz - v.wx * xz - v.wy * yz),
      xz = (s * v.wy + v.wx * xy - v.wz * yz),
      yz = (v.wy * xy + v.wz * xz - s * v.wx),
      wxy = (v.wz * w - v.wx * wxz - v.wy * wyz),
      wxz = (v.wx * wxy - v.wy * w - v.wz * wyz),
      wyz = (v.wx * w + v.wy * wxy + v.wz * wxz),
      xyz = (v.wx * x + v.wy * y + v.wz * z),
      i = (-v.wx * wx - v.wy * wy - v.wz * wz),
    )

  infix def antiGeometric(v: PseudoScalar): Multivector =
    Multivector(
      s = s * v.i,
      w = v.i * w,
      x = v.i * x,
      y = v.i * y,
      z = v.i * z,
      wx = v.i * wx,
      wy = v.i * wy,
      wz = v.i * wz,
      xy = v.i * xy,
      xz = v.i * xz,
      yz = v.i * yz,
      wxy = v.i * wxy,
      wxz = v.i * wxz,
      wyz = v.i * wyz,
      xyz = v.i * xyz,
      i = i * v.i,
    )

  infix def antiGeometric(v: PointCenter.type): Multivector =
    Multivector(
      s = -w,
      w = 0.0,
      x = -wx,
      y = -wy,
      z = -wz,
      wx = 0.0,
      wy = 0.0,
      wz = 0.0,
      xy = wxy,
      xz = wxz,
      yz = wyz,
      wxy = 0.0,
      wxz = 0.0,
      wyz = 0.0,
      xyz = i,
      i = 0.0,
    )

  infix def antiDot(v: Multivector): Multivector =
    Multivector(
      s = (i * v.s + s * v.i),
      w = (i * v.w + v.i * w),
      x = (i * v.x + s * v.wyz + v.i * x - v.s * wyz),
      y = (i * v.y + v.i * y + v.s * wxz - s * v.wxz),
      z = (i * v.z + s * v.wxy + v.i * z - v.s * wxy),
      wx = (i * v.wx + v.i * wx - v.w * wyz - v.wyz * w),
      wy = (i * v.wy + v.i * wy + v.w * wxz + v.wxz * w),
      wz = (i * v.wz + v.i * wz - v.w * wxy - v.wxy * w),
      xy = (i * v.xy + v.i * xy + v.wxz * x + v.wyz * y + v.x * wxz + v.y * wyz - s * v.wz - v.s * wz),
      xz = (i * v.xz + s * v.wy + v.i * xz + v.s * wy + v.wyz * z + v.z * wyz - v.wxy * x - v.x * wxy),
      yz = (i * v.yz + v.i * yz - s * v.wx - v.s * wx - v.wxy * y - v.wxz * z - v.y * wxy - v.z * wxz),
      wxy = (i * v.wxy + v.i * wxy + v.w * wz + v.wxz * wx + v.wyz * wy + v.wz * w - v.wx * wxz - v.wy * wyz),
      wxz = (i * v.wxz + v.i * wxz + v.wx * wxy + v.wyz * wz - v.w * wy - v.wxy * wx - v.wy * w - v.wz * wyz),
      wyz = (i * v.wyz + v.i * wyz + v.w * wx + v.wx * w + v.wy * wxy + v.wz * wxz - v.wxy * wy - v.wxz * wz),
      xyz = (i * v.xyz + v.i * xyz + v.s * w + v.wx * x + v.wy * y + v.wz * z + v.x * wx + v.xy * wxy + v.xz * wxz + v.y * wy + v.yz * wyz + v.z * wz - s * v.w - v.wxy * xy - v.wxz * xz - v.wyz * yz),
      i = (i * v.i + v.wxy * wxy + v.wxz * wxz + v.wyz * wyz - v.w * w - v.wx * wx - v.wy * wy - v.wz * wz),
    )

  infix def antiDot(v: Motor): Multivector =
    Multivector(
      s = (i * v.s + s * v.i),
      w = v.i * w,
      x = (v.i * x - v.s * wyz),
      y = (v.i * y + v.s * wxz),
      z = (v.i * z - v.s * wxy),
      wx = (i * v.wx + v.i * wx),
      wy = (i * v.wy + v.i * wy),
      wz = (i * v.wz + v.i * wz),
      xy = (i * v.xy + v.i * xy - s * v.wz - v.s * wz),
      xz = (i * v.xz + s * v.wy + v.i * xz + v.s * wy),
      yz = (i * v.yz + v.i * yz - s * v.wx - v.s * wx),
      wxy = (v.i * wxy + v.wz * w - v.wx * wxz - v.wy * wyz),
      wxz = (v.i * wxz + v.wx * wxy - v.wy * w - v.wz * wyz),
      wyz = (v.i * wyz + v.wx * w + v.wy * wxy + v.wz * wxz),
      xyz = (v.i * xyz + v.s * w + v.wx * x + v.wy * y + v.wz * z + v.xy * wxy + v.xz * wxz + v.yz * wyz),
      i = (i * v.i - v.wx * wx - v.wy * wy - v.wz * wz),
    )

  infix def antiDot(v: Plane): Multivector =
    Multivector(
      s = 0.0,
      w = i * v.w,
      x = i * v.x,
      y = i * v.y,
      z = i * v.z,
      wx = -v.w * wyz,
      wy = v.w * wxz,
      wz = -v.w * wxy,
      xy = (v.x * wxz + v.y * wyz),
      xz = (v.z * wyz - v.x * wxy),
      yz = (-v.y * wxy - v.z * wxz),
      wxy = v.w * wz,
      wxz = -v.w * wy,
      wyz = v.w * wx,
      xyz = (v.x * wx + v.y * wy + v.z * wz - s * v.w),
      i = -v.w * w,
    )

  infix def antiDot(v: Bivector): Multivector =
    Multivector(
      s = 0.0,
      w = 0.0,
      x = 0.0,
      y = 0.0,
      z = 0.0,
      wx = i * v.wx,
      wy = i * v.wy,
      wz = i * v.wz,
      xy = (i * v.xy - s * v.wz),
      xz = (i * v.xz + s * v.wy),
      yz = (i * v.yz - s * v.wx),
      wxy = (v.wz * w - v.wx * wxz - v.wy * wyz),
      wxz = (v.wx * wxy - v.wy * w - v.wz * wyz),
      wyz = (v.wx * w + v.wy * wxy + v.wz * wxz),
      xyz = (v.wx * x + v.wy * y + v.wz * z + v.xy * wxy + v.xz * wxz + v.yz * wyz),
      i = (-v.wx * wx - v.wy * wy - v.wz * wz),
    )

  infix def antiDot(v: Point): Multivector =
    Multivector(
      s = 0.0,
      w = 0.0,
      x = s * v.wyz,
      y = -s * v.wxz,
      z = s * v.wxy,
      wx = -v.wyz * w,
      wy = v.wxz * w,
      wz = -v.wxy * w,
      xy = (v.wxz * x + v.wyz * y),
      xz = (v.wyz * z - v.wxy * x),
      yz = (-v.wxy * y - v.wxz * z),
      wxy = (i * v.wxy + v.wxz * wx + v.wyz * wy),
      wxz = (i * v.wxz + v.wyz * wz - v.wxy * wx),
      wyz = (i * v.wyz - v.wxy * wy - v.wxz * wz),
      xyz = (i * v.xyz - v.wxy * xy - v.wxz * xz - v.wyz * yz),
      i = (v.wxy * wxy + v.wxz * wxz + v.wyz * wyz),
    )

  infix def antiDot(v: Quaternion): Multivector =
    Multivector(
      s = i * v.s,
      w = 0.0,
      x = -v.s * wyz,
      y = v.s * wxz,
      z = -v.s * wxy,
      wx = 0.0,
      wy = 0.0,
      wz = 0.0,
      xy = (i * v.xy - v.s * wz),
      xz = (i * v.xz + v.s * wy),
      yz = (i * v.yz - v.s * wx),
      wxy = 0.0,
      wxz = 0.0,
      wyz = 0.0,
      xyz = (v.s * w + v.xy * wxy + v.xz * wxz + v.yz * wyz),
      i = 0.0,
    )

  infix def antiDot(v: QuaternionDual): Multivector =
    Multivector(
      s = s * v.i,
      w = v.i * w,
      x = v.i * x,
      y = v.i * y,
      z = v.i * z,
      wx = (i * v.wx + v.i * wx),
      wy = (i * v.wy + v.i * wy),
      wz = (i * v.wz + v.i * wz),
      xy = (v.i * xy - s * v.wz),
      xz = (s * v.wy + v.i * xz),
      yz = (v.i * yz - s * v.wx),
      wxy = (v.i * wxy + v.wz * w - v.wx * wxz - v.wy * wyz),
      wxz = (v.i * wxz + v.wx * wxy - v.wy * w - v.wz * wyz),
      wyz = (v.i * wyz + v.wx * w + v.wy * wxy + v.wz * wxz),
      xyz = (v.i * xyz + v.wx * x + v.wy * y + v.wz * z),
      i = (i * v.i - v.wx * wx - v.wy * wy - v.wz * wz),
    )

  infix def antiDot(v: PointIdeal): Multivector =
    Multivector(
      s = 0.0,
      w = 0.0,
      x = s * v.wyz,
      y = -s * v.wxz,
      z = s * v.wxy,
      wx = -v.wyz * w,
      wy = v.wxz * w,
      wz = -v.wxy * w,
      xy = (v.wxz * x + v.wyz * y),
      xz = (v.wyz * z - v.wxy * x),
      yz = (-v.wxy * y - v.wxz * z),
      wxy = (i * v.wxy + v.wxz * wx + v.wyz * wy),
      wxz = (i * v.wxz + v.wyz * wz - v.wxy * wx),
      wyz = (i * v.wyz - v.wxy * wy - v.wxz * wz),
      xyz = (-v.wxy * xy - v.wxz * xz - v.wyz * yz),
      i = (v.wxy * wxy + v.wxz * wxz + v.wyz * wyz),
    )

  infix def antiDot(v: PointNormalized): Multivector =
    Multivector(
      s = 0.0,
      w = 0.0,
      x = s * v.wyz,
      y = -s * v.wxz,
      z = s * v.wxy,
      wx = -v.wyz * w,
      wy = v.wxz * w,
      wz = -v.wxy * w,
      xy = (v.wxz * x + v.wyz * y),
      xz = (v.wyz * z - v.wxy * x),
      yz = (-v.wxy * y - v.wxz * z),
      wxy = (i * v.wxy + v.wxz * wx + v.wyz * wy),
      wxz = (i * v.wxz + v.wyz * wz - v.wxy * wx),
      wyz = (i * v.wyz - v.wxy * wy - v.wxz * wz),
      xyz = (i - v.wxy * xy - v.wxz * xz - v.wyz * yz),
      i = (v.wxy * wxy + v.wxz * wxz + v.wyz * wyz),
    )

  infix def antiDot(v: PlaneIdeal): Multivector =
    Multivector(
      s = 0.0,
      w = 0.0,
      x = i * v.x,
      y = i * v.y,
      z = i * v.z,
      wx = 0.0,
      wy = 0.0,
      wz = 0.0,
      xy = (v.x * wxz + v.y * wyz),
      xz = (v.z * wyz - v.x * wxy),
      yz = (-v.y * wxy - v.z * wxz),
      wxy = 0.0,
      wxz = 0.0,
      wyz = 0.0,
      xyz = (v.x * wx + v.y * wy + v.z * wz),
      i = 0.0,
    )

  infix def antiDot(v: BivectorBulk): Multivector =
    Multivector(
      s = 0.0,
      w = 0.0,
      x = 0.0,
      y = 0.0,
      z = 0.0,
      wx = 0.0,
      wy = 0.0,
      wz = 0.0,
      xy = i * v.xy,
      xz = i * v.xz,
      yz = i * v.yz,
      wxy = 0.0,
      wxz = 0.0,
      wyz = 0.0,
      xyz = (v.xy * wxy + v.xz * wxz + v.yz * wyz),
      i = 0.0,
    )

  infix def antiDot(v: BivectorWeight): Multivector =
    Multivector(
      s = 0.0,
      w = 0.0,
      x = 0.0,
      y = 0.0,
      z = 0.0,
      wx = i * v.wx,
      wy = i * v.wy,
      wz = i * v.wz,
      xy = -s * v.wz,
      xz = s * v.wy,
      yz = -s * v.wx,
      wxy = (v.wz * w - v.wx * wxz - v.wy * wyz),
      wxz = (v.wx * wxy - v.wy * w - v.wz * wyz),
      wyz = (v.wx * w + v.wy * wxy + v.wz * wxz),
      xyz = (v.wx * x + v.wy * y + v.wz * z),
      i = (-v.wx * wx - v.wy * wy - v.wz * wz),
    )

  infix def antiDot(v: PseudoScalar): Multivector =
    Multivector(
      s = s * v.i,
      w = v.i * w,
      x = v.i * x,
      y = v.i * y,
      z = v.i * z,
      wx = v.i * wx,
      wy = v.i * wy,
      wz = v.i * wz,
      xy = v.i * xy,
      xz = v.i * xz,
      yz = v.i * yz,
      wxy = v.i * wxy,
      wxz = v.i * wxz,
      wyz = v.i * wyz,
      xyz = v.i * xyz,
      i = i * v.i,
    )

  infix def antiDot(v: PointCenter.type): Point =
    Point(
      wxy = 0.0,
      wxz = 0.0,
      wyz = 0.0,
      xyz = i,
    )

  infix def antiWedge(v: Multivector): Multivector =
    Multivector(
      s = (i * v.s + s * v.i + v.w * xyz + v.wx * yz + v.wxy * z + v.wyz * x + v.wz * xy + v.xy * wz + v.y * wxz + v.yz * wx - v.wxz * y - v.wy * xz - v.x * wyz - v.xyz * w - v.xz * wy - v.z * wxy),
      w = (i * v.w + v.i * w + v.wxz * wy + v.wy * wxz - v.wx * wyz - v.wxy * wz - v.wyz * wx - v.wz * wxy),
      x = (i * v.x + v.i * x + v.wxz * xy + v.xy * wxz - v.wx * xyz - v.wxy * xz - v.xyz * wx - v.xz * wxy),
      y = (i * v.y + v.i * y + v.wyz * xy + v.xy * wyz - v.wxy * yz - v.wy * xyz - v.xyz * wy - v.yz * wxy),
      z = (i * v.z + v.i * z + v.wyz * xz + v.xz * wyz - v.wxz * yz - v.wz * xyz - v.xyz * wz - v.yz * wxz),
      wx = (i * v.wx + v.i * wx + v.wxz * wxy - v.wxy * wxz),
      wy = (i * v.wy + v.i * wy + v.wyz * wxy - v.wxy * wyz),
      wz = (i * v.wz + v.i * wz + v.wyz * wxz - v.wxz * wyz),
      xy = (i * v.xy + v.i * xy + v.xyz * wxy - v.wxy * xyz),
      xz = (i * v.xz + v.i * xz + v.xyz * wxz - v.wxz * xyz),
      yz = (i * v.yz + v.i * yz + v.xyz * wyz - v.wyz * xyz),
      wxy = (i * v.wxy + v.i * wxy),
      wxz = (i * v.wxz + v.i * wxz),
      wyz = (i * v.wyz + v.i * wyz),
      xyz = (i * v.xyz + v.i * xyz),
      i = i * v.i,
    )

  inline infix def v(v: Multivector): Multivector = antiWedge(v)

  infix def antiWedge(v: Motor): Multivector =
    Multivector(
      s = (i * v.s + s * v.i + v.wx * yz + v.wz * xy + v.xy * wz + v.yz * wx - v.wy * xz - v.xz * wy),
      w = (v.i * w + v.wy * wxz - v.wx * wyz - v.wz * wxy),
      x = (v.i * x + v.xy * wxz - v.wx * xyz - v.xz * wxy),
      y = (v.i * y + v.xy * wyz - v.wy * xyz - v.yz * wxy),
      z = (v.i * z + v.xz * wyz - v.wz * xyz - v.yz * wxz),
      wx = (i * v.wx + v.i * wx),
      wy = (i * v.wy + v.i * wy),
      wz = (i * v.wz + v.i * wz),
      xy = (i * v.xy + v.i * xy),
      xz = (i * v.xz + v.i * xz),
      yz = (i * v.yz + v.i * yz),
      wxy = v.i * wxy,
      wxz = v.i * wxz,
      wyz = v.i * wyz,
      xyz = v.i * xyz,
      i = i * v.i,
    )

  inline infix def v(v: Motor): Multivector = antiWedge(v)

  infix def antiWedge(v: Plane): Multivector =
    Multivector(
      s = (v.w * xyz + v.y * wxz - v.x * wyz - v.z * wxy),
      w = i * v.w,
      x = i * v.x,
      y = i * v.y,
      z = i * v.z,
      wx = 0.0,
      wy = 0.0,
      wz = 0.0,
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
      wxy = 0.0,
      wxz = 0.0,
      wyz = 0.0,
      xyz = 0.0,
      i = 0.0,
    )

  inline infix def v(v: Plane): Multivector = antiWedge(v)

  infix def antiWedge(v: Bivector): Multivector =
    Multivector(
      s = (v.wx * yz + v.wz * xy + v.xy * wz + v.yz * wx - v.wy * xz - v.xz * wy),
      w = (v.wy * wxz - v.wx * wyz - v.wz * wxy),
      x = (v.xy * wxz - v.wx * xyz - v.xz * wxy),
      y = (v.xy * wyz - v.wy * xyz - v.yz * wxy),
      z = (v.xz * wyz - v.wz * xyz - v.yz * wxz),
      wx = i * v.wx,
      wy = i * v.wy,
      wz = i * v.wz,
      xy = i * v.xy,
      xz = i * v.xz,
      yz = i * v.yz,
      wxy = 0.0,
      wxz = 0.0,
      wyz = 0.0,
      xyz = 0.0,
      i = 0.0,
    )

  inline infix def v(v: Bivector): Multivector = antiWedge(v)

  infix def antiWedge(v: Point): Multivector =
    Multivector(
      s = (v.wxy * z + v.wyz * x - v.wxz * y - v.xyz * w),
      w = (v.wxz * wy - v.wxy * wz - v.wyz * wx),
      x = (v.wxz * xy - v.wxy * xz - v.xyz * wx),
      y = (v.wyz * xy - v.wxy * yz - v.xyz * wy),
      z = (v.wyz * xz - v.wxz * yz - v.xyz * wz),
      wx = (v.wxz * wxy - v.wxy * wxz),
      wy = (v.wyz * wxy - v.wxy * wyz),
      wz = (v.wyz * wxz - v.wxz * wyz),
      xy = (v.xyz * wxy - v.wxy * xyz),
      xz = (v.xyz * wxz - v.wxz * xyz),
      yz = (v.xyz * wyz - v.wyz * xyz),
      wxy = i * v.wxy,
      wxz = i * v.wxz,
      wyz = i * v.wyz,
      xyz = i * v.xyz,
      i = 0.0,
    )

  inline infix def v(v: Point): Multivector = antiWedge(v)

  infix def antiWedge(v: Quaternion): Multivector =
    Multivector(
      s = (i * v.s + v.xy * wz + v.yz * wx - v.xz * wy),
      w = 0.0,
      x = (v.xy * wxz - v.xz * wxy),
      y = (v.xy * wyz - v.yz * wxy),
      z = (v.xz * wyz - v.yz * wxz),
      wx = 0.0,
      wy = 0.0,
      wz = 0.0,
      xy = i * v.xy,
      xz = i * v.xz,
      yz = i * v.yz,
      wxy = 0.0,
      wxz = 0.0,
      wyz = 0.0,
      xyz = 0.0,
      i = 0.0,
    )

  inline infix def v(v: Quaternion): Multivector = antiWedge(v)

  infix def antiWedge(v: QuaternionDual): Multivector =
    Multivector(
      s = (s * v.i + v.wx * yz + v.wz * xy - v.wy * xz),
      w = (v.i * w + v.wy * wxz - v.wx * wyz - v.wz * wxy),
      x = (v.i * x - v.wx * xyz),
      y = (v.i * y - v.wy * xyz),
      z = (v.i * z - v.wz * xyz),
      wx = (i * v.wx + v.i * wx),
      wy = (i * v.wy + v.i * wy),
      wz = (i * v.wz + v.i * wz),
      xy = v.i * xy,
      xz = v.i * xz,
      yz = v.i * yz,
      wxy = v.i * wxy,
      wxz = v.i * wxz,
      wyz = v.i * wyz,
      xyz = v.i * xyz,
      i = i * v.i,
    )

  inline infix def v(v: QuaternionDual): Multivector = antiWedge(v)

  infix def antiWedge(v: PointIdeal): Multivector =
    Multivector(
      s = (v.wxy * z + v.wyz * x - v.wxz * y),
      w = (v.wxz * wy - v.wxy * wz - v.wyz * wx),
      x = (v.wxz * xy - v.wxy * xz),
      y = (v.wyz * xy - v.wxy * yz),
      z = (v.wyz * xz - v.wxz * yz),
      wx = (v.wxz * wxy - v.wxy * wxz),
      wy = (v.wyz * wxy - v.wxy * wyz),
      wz = (v.wyz * wxz - v.wxz * wyz),
      xy = -v.wxy * xyz,
      xz = -v.wxz * xyz,
      yz = -v.wyz * xyz,
      wxy = i * v.wxy,
      wxz = i * v.wxz,
      wyz = i * v.wyz,
      xyz = 0.0,
      i = 0.0,
    )

  inline infix def v(v: PointIdeal): Multivector = antiWedge(v)

  infix def antiWedge(v: PointNormalized): Multivector =
    Multivector(
      s = (-w + v.wxy * z + v.wyz * x - v.wxz * y),
      w = (v.wxz * wy - v.wxy * wz - v.wyz * wx),
      x = (-wx + v.wxz * xy - v.wxy * xz),
      y = (-wy + v.wyz * xy - v.wxy * yz),
      z = (-wz + v.wyz * xz - v.wxz * yz),
      wx = (v.wxz * wxy - v.wxy * wxz),
      wy = (v.wyz * wxy - v.wxy * wyz),
      wz = (v.wyz * wxz - v.wxz * wyz),
      xy = (wxy - v.wxy * xyz),
      xz = (wxz - v.wxz * xyz),
      yz = (wyz - v.wyz * xyz),
      wxy = i * v.wxy,
      wxz = i * v.wxz,
      wyz = i * v.wyz,
      xyz = i,
      i = 0.0,
    )

  inline infix def v(v: PointNormalized): Multivector = antiWedge(v)

  infix def antiWedge(v: PlaneIdeal): Multivector =
    Multivector(
      s = (v.y * wxz - v.x * wyz - v.z * wxy),
      w = 0.0,
      x = i * v.x,
      y = i * v.y,
      z = i * v.z,
      wx = 0.0,
      wy = 0.0,
      wz = 0.0,
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
      wxy = 0.0,
      wxz = 0.0,
      wyz = 0.0,
      xyz = 0.0,
      i = 0.0,
    )

  inline infix def v(v: PlaneIdeal): Multivector = antiWedge(v)

  infix def antiWedge(v: BivectorBulk): Multivector =
    Multivector(
      s = (v.xy * wz + v.yz * wx - v.xz * wy),
      w = 0.0,
      x = (v.xy * wxz - v.xz * wxy),
      y = (v.xy * wyz - v.yz * wxy),
      z = (v.xz * wyz - v.yz * wxz),
      wx = 0.0,
      wy = 0.0,
      wz = 0.0,
      xy = i * v.xy,
      xz = i * v.xz,
      yz = i * v.yz,
      wxy = 0.0,
      wxz = 0.0,
      wyz = 0.0,
      xyz = 0.0,
      i = 0.0,
    )

  inline infix def v(v: BivectorBulk): Multivector = antiWedge(v)

  infix def antiWedge(v: BivectorWeight): Multivector =
    Multivector(
      s = (v.wx * yz + v.wz * xy - v.wy * xz),
      w = (v.wy * wxz - v.wx * wyz - v.wz * wxy),
      x = -v.wx * xyz,
      y = -v.wy * xyz,
      z = -v.wz * xyz,
      wx = i * v.wx,
      wy = i * v.wy,
      wz = i * v.wz,
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
      wxy = 0.0,
      wxz = 0.0,
      wyz = 0.0,
      xyz = 0.0,
      i = 0.0,
    )

  inline infix def v(v: BivectorWeight): Multivector = antiWedge(v)

  infix def antiWedge(v: PseudoScalar): Multivector =
    Multivector(
      s = s * v.i,
      w = v.i * w,
      x = v.i * x,
      y = v.i * y,
      z = v.i * z,
      wx = v.i * wx,
      wy = v.i * wy,
      wz = v.i * wz,
      xy = v.i * xy,
      xz = v.i * xz,
      yz = v.i * yz,
      wxy = v.i * wxy,
      wxz = v.i * wxz,
      wyz = v.i * wyz,
      xyz = v.i * xyz,
      i = i * v.i,
    )

  inline infix def v(v: PseudoScalar): Multivector = antiWedge(v)

  infix def antiWedge(v: PointCenter.type): Multivector =
    Multivector(
      s = -w,
      w = 0.0,
      x = -wx,
      y = -wy,
      z = -wz,
      wx = 0.0,
      wy = 0.0,
      wz = 0.0,
      xy = wxy,
      xz = wxz,
      yz = wyz,
      wxy = 0.0,
      wxz = 0.0,
      wyz = 0.0,
      xyz = i,
      i = 0.0,
    )

  inline infix def v(v: PointCenter.type): Multivector = antiWedge(v)