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

  infix def sandwich(v: Multivector): Multivector =
    val sMs = s * s
    val sMw = s * w
    val sMx = s * x
    val sMy = s * y
    val sMz = s * z
    val sMwx = s * wx
    val sMwy = s * wy
    val sMwz = s * wz
    val sMxy = s * xy
    val sMxz = s * xz
    val sMyz = s * yz
    val sMwxy = s * wxy
    val sMwxz = s * wxz
    val sMwyz = s * wyz
    val sMxyz = s * xyz
    val sMi = i * s
    val wMx = w * x
    val wMy = w * y
    val wMz = w * z
    val wMxy = w * xy
    val wMxz = w * xz
    val wMyz = w * yz
    val wMxyz = w * xyz
    val xMx = x * x
    val xMy = x * y
    val xMz = x * z
    val xMwx = wx * x
    val xMwy = wy * x
    val xMwz = wz * x
    val xMxy = x * xy
    val xMxz = x * xz
    val xMyz = x * yz
    val xMwxy = wxy * x
    val xMwxz = wxz * x
    val xMwyz = wyz * x
    val xMxyz = x * xyz
    val xMi = i * x
    val yMy = y * y
    val yMz = y * z
    val yMwx = wx * y
    val yMwy = wy * y
    val yMwz = wz * y
    val yMxy = xy * y
    val yMxz = xz * y
    val yMyz = y * yz
    val yMwxy = wxy * y
    val yMwxz = wxz * y
    val yMwyz = wyz * y
    val yMxyz = xyz * y
    val yMi = i * y
    val zMz = z * z
    val zMwx = wx * z
    val zMwy = wy * z
    val zMwz = wz * z
    val zMxy = xy * z
    val zMxz = xz * z
    val zMyz = yz * z
    val zMwxy = wxy * z
    val zMwxz = wxz * z
    val zMwyz = wyz * z
    val zMxyz = xyz * z
    val zMi = i * z
    val wxMxy = wx * xy
    val wxMxz = wx * xz
    val wxMyz = wx * yz
    val wxMxyz = wx * xyz
    val wyMxy = wy * xy
    val wyMxz = wy * xz
    val wyMyz = wy * yz
    val wyMxyz = wy * xyz
    val wzMxy = wz * xy
    val wzMxz = wz * xz
    val wzMyz = wz * yz
    val wzMxyz = wz * xyz
    val xyMxy = xy * xy
    val xyMxz = xy * xz
    val xyMyz = xy * yz
    val xyMwxy = wxy * xy
    val xyMwxz = wxz * xy
    val xyMwyz = wyz * xy
    val xyMxyz = xy * xyz
    val xyMi = i * xy
    val xzMxz = xz * xz
    val xzMyz = xz * yz
    val xzMwxy = wxy * xz
    val xzMwxz = wxz * xz
    val xzMwyz = wyz * xz
    val xzMxyz = xyz * xz
    val xzMi = i * xz
    val yzMyz = yz * yz
    val yzMwxy = wxy * yz
    val yzMwxz = wxz * yz
    val yzMwyz = wyz * yz
    val yzMxyz = xyz * yz
    val yzMi = i * yz
    val wxyMxyz = wxy * xyz
    val wxzMxyz = wxz * xyz
    val wyzMxyz = wyz * xyz
    val xyzMxyz = xyz * xyz
    val xyzMi = i * xyz
    Multivector(
      s = (sMs * v.s + v.s * xMx + v.s * xyMxy + v.s * xyzMxyz + v.s * xzMxz + v.s * yMy + v.s * yzMyz + v.s * zMz - 2.0 * v.x * yMxy - 2.0 * v.x * zMxz - 2.0 * v.y * xzMxyz - 2.0 * v.y * zMyz + 2.0 * sMx * v.x + 2.0 * sMy * v.y + 2.0 * sMz * v.z + 2.0 * v.x * yzMxyz + 2.0 * v.y * xMxy + 2.0 * v.z * xMxz + 2.0 * v.z * xyMxyz + 2.0 * v.z * yMyz),
      w = (sMs * v.w + v.w * xyMxy + v.w * xzMxz + v.w * yzMyz - 2.0 * v.i * xMyz - 2.0 * v.i * zMxy - 2.0 * v.x * wyMxy - 2.0 * v.x * wzMxz - 2.0 * v.x * yMwxy - 2.0 * v.x * zMwxz - 2.0 * v.y * wxzMxyz - 2.0 * v.y * wzMyz - 2.0 * v.y * xzMi - 2.0 * v.y * zMwyz - v.w * xMx - v.w * xyzMxyz - v.w * yMy - v.w * zMz + 2.0 * sMw * v.s + 2.0 * sMwx * v.x + 2.0 * sMwy * v.y + 2.0 * sMwz * v.z + 2.0 * sMxyz * v.i + 2.0 * v.i * yMxz + 2.0 * v.s * xMwx + 2.0 * v.s * xyMwxy + 2.0 * v.s * xyzMi + 2.0 * v.s * xzMwxz + 2.0 * v.s * yMwy + 2.0 * v.s * yzMwyz + 2.0 * v.s * zMwz + 2.0 * v.x * wMx + 2.0 * v.x * wyzMxyz + 2.0 * v.x * yzMi + 2.0 * v.y * wMy + 2.0 * v.y * wxMxy + 2.0 * v.y * xMwxy + 2.0 * v.z * wMz + 2.0 * v.z * wxMxz + 2.0 * v.z * wxyMxyz + 2.0 * v.z * wyMyz + 2.0 * v.z * xMwxz + 2.0 * v.z * xyMi + 2.0 * v.z * yMwyz),
      x = (sMs * v.x + v.x * xMx + v.x * xyzMxyz + v.x * yzMyz - 2.0 * v.y * xzMyz - 2.0 * v.y * zMxyz - v.x * xyMxy - v.x * xzMxz - v.x * yMy - v.x * zMz + 2.0 * sMx * v.s + 2.0 * sMxy * v.y + 2.0 * sMxz * v.z + 2.0 * v.s * yMxy + 2.0 * v.s * yzMxyz + 2.0 * v.s * zMxz + 2.0 * v.y * xMy + 2.0 * v.z * xMz + 2.0 * v.z * xyMyz + 2.0 * v.z * yMxyz),
      y = (sMs * v.y + v.y * xyzMxyz + v.y * xzMxz + v.y * yMy - 2.0 * sMxy * v.x - 2.0 * v.s * xMxy - 2.0 * v.s * xzMxyz - 2.0 * v.x * xzMyz - 2.0 * v.z * xMxyz - 2.0 * v.z * xyMxz - v.y * xMx - v.y * xyMxy - v.y * yzMyz - v.y * zMz + 2.0 * sMy * v.s + 2.0 * sMyz * v.z + 2.0 * v.s * zMyz + 2.0 * v.x * xMy + 2.0 * v.x * zMxyz + 2.0 * v.z * yMz),
      z = (sMs * v.z + v.z * xyMxy + v.z * xyzMxyz + v.z * zMz - 2.0 * sMxz * v.x - 2.0 * sMyz * v.y - 2.0 * v.s * xMxz - 2.0 * v.s * yMyz - 2.0 * v.x * yMxyz - 2.0 * v.y * xyMxz - v.z * xMx - v.z * xzMxz - v.z * yMy - v.z * yzMyz + 2.0 * sMz * v.s + 2.0 * v.s * xyMxyz + 2.0 * v.x * xMz + 2.0 * v.x * xyMyz + 2.0 * v.y * xMxyz + 2.0 * v.y * yMz),
      wx = (sMs * v.wx + v.wx * yMy + v.wx * yzMyz + v.wx * zMz - 2.0 * sMi * v.yz - 2.0 * sMwy * v.xy - 2.0 * sMwyz * v.xyz - 2.0 * sMwz * v.xz - 2.0 * v.wxy * xMxy - 2.0 * v.wxy * zMyz - 2.0 * v.wxz * xMxz - 2.0 * v.wxz * xyMxyz - 2.0 * v.wy * xMy - 2.0 * v.wy * xzMyz - 2.0 * v.wyz * xMyz - 2.0 * v.wyz * yMxz - 2.0 * v.wz * xMz - 2.0 * v.wz * yMxyz - 2.0 * v.xy * xMwxy - 2.0 * v.xy * xzMi - 2.0 * v.xy * zMwyz - 2.0 * v.xyz * xMi - 2.0 * v.xyz * xzMwxy - 2.0 * v.xyz * zMwy - 2.0 * v.xz * wxyMxyz - 2.0 * v.xz * wyMyz - 2.0 * v.xz * xMwxz - 2.0 * v.yz * wzMxy - 2.0 * v.yz * xMwyz - 2.0 * v.yz * yMwxz - v.wx * xMx - v.wx * xyMxy - v.wx * xyzMxyz - v.wx * xzMxz + 2.0 * sMxy * v.wy + 2.0 * sMxyz * v.wyz + 2.0 * sMxz * v.wz + 2.0 * sMy * v.wxy + 2.0 * sMz * v.wxz + 2.0 * v.wxy * xzMxyz + 2.0 * v.wxz * yMyz + 2.0 * v.wy * zMxyz + 2.0 * v.wyz * zMxy + 2.0 * v.wz * xyMyz + 2.0 * v.xy * wMy + 2.0 * v.xy * wxMxy + 2.0 * v.xy * wxzMxyz + 2.0 * v.xy * wzMyz + 2.0 * v.xyz * wMyz + 2.0 * v.xyz * wxMxyz + 2.0 * v.xyz * xyMwxz + 2.0 * v.xyz * yMwz + 2.0 * v.xz * wMz + 2.0 * v.xz * wxMxz + 2.0 * v.xz * xyMi + 2.0 * v.xz * yMwyz + 2.0 * v.yz * wMxyz + 2.0 * v.yz * wxMyz + 2.0 * v.yz * wyMxz + 2.0 * v.yz * zMwxy),
      wy = (sMs * v.wy + v.wy * xMx + v.wy * xzMxz + v.wy * zMz - 2.0 * sMwz * v.yz - 2.0 * sMx * v.wxy - 2.0 * sMxy * v.wx - 2.0 * sMxyz * v.wxz - 2.0 * v.wx * xMy - 2.0 * v.wx * xzMyz - 2.0 * v.wx * zMxyz - 2.0 * v.wxy * yMxy - 2.0 * v.wxz * xMyz - 2.0 * v.wxz * yMxz - 2.0 * v.wxz * zMxy - 2.0 * v.wyz * xyMxyz - 2.0 * v.wyz * yMyz - 2.0 * v.wz * xyMxz - 2.0 * v.wz * yMz - 2.0 * v.xy * wMx - 2.0 * v.xy * wzMxz - 2.0 * v.xy * yMwxy - 2.0 * v.xy * yzMi - 2.0 * v.xyz * wMxz - 2.0 * v.xyz * xMwz - 2.0 * v.xyz * yMi - 2.0 * v.xyz * yzMwxy - 2.0 * v.xz * wMxyz - 2.0 * v.xz * xMwyz - 2.0 * v.xz * yMwxz - 2.0 * v.xz * zMwxy - 2.0 * v.yz * wxMxz - 2.0 * v.yz * wxyMxyz - 2.0 * v.yz * yMwyz - v.wy * xyMxy - v.wy * xyzMxyz - v.wy * yMy - v.wy * yzMyz + 2.0 * sMi * v.xz + 2.0 * sMwx * v.xy + 2.0 * sMwxz * v.xyz + 2.0 * sMyz * v.wz + 2.0 * sMz * v.wyz + 2.0 * v.wxy * yzMxyz + 2.0 * v.wxy * zMxz + 2.0 * v.wyz * xMxz + 2.0 * v.wz * xMxyz + 2.0 * v.xy * wyMxy + 2.0 * v.xy * wyzMxyz + 2.0 * v.xy * zMwxz + 2.0 * v.xyz * wyMxyz + 2.0 * v.xyz * xyMwyz + 2.0 * v.xyz * zMwx + 2.0 * v.xz * wxMyz + 2.0 * v.xz * wyMxz + 2.0 * v.xz * wzMxy + 2.0 * v.yz * wMz + 2.0 * v.yz * wyMyz + 2.0 * v.yz * xMwxz + 2.0 * v.yz * xyMi),
      wz = (sMs * v.wz + v.wz * xMx + v.wz * xyMxy + v.wz * yMy - 2.0 * sMi * v.xy - 2.0 * sMwxy * v.xyz - 2.0 * sMx * v.wxz - 2.0 * sMxz * v.wx - 2.0 * sMy * v.wyz - 2.0 * sMyz * v.wy - 2.0 * v.wx * xMz - 2.0 * v.wxy * yMxz - 2.0 * v.wxy * zMxy - 2.0 * v.wxz * zMxz - 2.0 * v.wy * xMxyz - 2.0 * v.wy * xyMxz - 2.0 * v.wy * yMz - 2.0 * v.wyz * xMxy - 2.0 * v.wyz * xzMxyz - 2.0 * v.wyz * zMyz - 2.0 * v.xy * wxMyz - 2.0 * v.xy * yMwxz - 2.0 * v.xy * zMwxy - 2.0 * v.xyz * yMwx - 2.0 * v.xyz * yzMwxz - 2.0 * v.xyz * zMi - 2.0 * v.xz * wMx - 2.0 * v.xz * wyMxy - 2.0 * v.xz * yzMi - 2.0 * v.xz * zMwxz - 2.0 * v.yz * wMy - 2.0 * v.yz * wxzMxyz - 2.0 * v.yz * xMwxy - 2.0 * v.yz * zMwyz - v.wz * xyzMxyz - v.wz * xzMxz - v.wz * yzMyz - v.wz * zMz + 2.0 * sMwx * v.xz + 2.0 * sMwy * v.yz + 2.0 * sMxyz * v.wxy + 2.0 * v.wx * xyMyz + 2.0 * v.wx * yMxyz + 2.0 * v.wxy * xMyz + 2.0 * v.wxz * yMxy + 2.0 * v.wxz * yzMxyz + 2.0 * v.xy * wMxyz + 2.0 * v.xy * wyMxz + 2.0 * v.xy * wzMxy + 2.0 * v.xy * xMwyz + 2.0 * v.xyz * wMxy + 2.0 * v.xyz * wzMxyz + 2.0 * v.xyz * xMwy + 2.0 * v.xyz * xzMwyz + 2.0 * v.xz * wyzMxyz + 2.0 * v.xz * wzMxz + 2.0 * v.xz * yMwxy + 2.0 * v.yz * wxMxy + 2.0 * v.yz * wzMyz + 2.0 * v.yz * xzMi),
      xy = (sMs * v.xy + v.xy * xyMxy + v.xy * xyzMxyz + v.xy * zMz - 2.0 * sMxz * v.yz - 2.0 * v.xyz * xMxz - 2.0 * v.xyz * yMyz - 2.0 * v.xz * xMxyz - 2.0 * v.xz * yMz - 2.0 * v.yz * yMxyz - v.xy * xMx - v.xy * xzMxz - v.xy * yMy - v.xy * yzMyz + 2.0 * sMyz * v.xz + 2.0 * sMz * v.xyz + 2.0 * v.xyz * xyMxyz + 2.0 * v.xz * xyMxz + 2.0 * v.yz * xMz + 2.0 * v.yz * xyMyz),
      xz = (sMs * v.xz + v.xz * xyzMxyz + v.xz * xzMxz + v.xz * yMy - 2.0 * sMy * v.xyz - 2.0 * sMyz * v.xy - 2.0 * v.xy * yMz - 2.0 * v.xyz * zMyz - 2.0 * v.yz * xMy - 2.0 * v.yz * zMxyz - v.xz * xMx - v.xz * xyMxy - v.xz * yzMyz - v.xz * zMz + 2.0 * sMxy * v.yz + 2.0 * v.xy * xMxyz + 2.0 * v.xy * xyMxz + 2.0 * v.xyz * xMxy + 2.0 * v.xyz * xzMxyz + 2.0 * v.yz * xzMyz),
      yz = (sMs * v.yz + v.yz * xMx + v.yz * xyzMxyz + v.yz * yzMyz - 2.0 * sMxy * v.xz - 2.0 * v.xz * xMy - v.yz * xyMxy - v.yz * xzMxz - v.yz * yMy - v.yz * zMz + 2.0 * sMx * v.xyz + 2.0 * sMxz * v.xy + 2.0 * v.xy * xMz + 2.0 * v.xy * xyMyz + 2.0 * v.xy * yMxyz + 2.0 * v.xyz * yMxy + 2.0 * v.xyz * yzMxyz + 2.0 * v.xyz * zMxz + 2.0 * v.xz * xzMyz + 2.0 * v.xz * zMxyz),
      wxy = (sMs * v.wxy + v.wxy * xMx + v.wxy * xyMxy + v.wxy * yMy - 2.0 * sMwxz * v.yz - 2.0 * sMx * v.wy - 2.0 * sMxyz * v.wz - 2.0 * sMxz * v.wyz - 2.0 * v.wy * zMxz - 2.0 * v.wyz * xMz - 2.0 * v.wz * xMyz - 2.0 * v.xy * xMwx - 2.0 * v.xy * xzMwxz - 2.0 * v.xy * yMwy - 2.0 * v.xy * yzMwyz - 2.0 * v.xyz * wxMxz - 2.0 * v.xyz * wyMyz - 2.0 * v.xyz * xMwxz - 2.0 * v.xyz * yMwyz - 2.0 * v.xz * wxMxyz - 2.0 * v.xz * xMi - 2.0 * v.xz * yMwz - 2.0 * v.xz * zMwy - 2.0 * v.yz * wMxz - 2.0 * v.yz * wyMxyz - 2.0 * v.yz * yMi - v.wxy * xyzMxyz - v.wxy * xzMxz - v.wxy * yzMyz - v.wxy * zMz + 2.0 * sMw * v.xy + 2.0 * sMwyz * v.xz + 2.0 * sMwz * v.xyz + 2.0 * sMy * v.wx + 2.0 * sMyz * v.wxz + 2.0 * v.wx * xMxy + 2.0 * v.wx * xzMxyz + 2.0 * v.wx * zMyz + 2.0 * v.wxz * xMxyz + 2.0 * v.wxz * xyMxz + 2.0 * v.wxz * yMz + 2.0 * v.wy * yMxy + 2.0 * v.wy * yzMxyz + 2.0 * v.wyz * xyMyz + 2.0 * v.wyz * yMxyz + 2.0 * v.wz * yMxz + 2.0 * v.wz * zMxy + 2.0 * v.xy * xyMwxy + 2.0 * v.xy * xyzMi + 2.0 * v.xy * zMwz + 2.0 * v.xyz * wMz + 2.0 * v.xyz * wxyMxyz + 2.0 * v.xyz * xyMi + 2.0 * v.xz * wMyz + 2.0 * v.xz * xyMwxz + 2.0 * v.xz * xzMwxy + 2.0 * v.yz * xMwz + 2.0 * v.yz * xyMwyz + 2.0 * v.yz * yzMwxy + 2.0 * v.yz * zMwx),
      wxz = (sMs * v.wxz + v.wxz * xMx + v.wxz * xzMxz + v.wxz * zMz - 2.0 * sMwy * v.xyz - 2.0 * sMwyz * v.xy - 2.0 * sMx * v.wz - 2.0 * sMyz * v.wxy - 2.0 * v.wx * xyMxyz - 2.0 * v.wx * yMyz - 2.0 * v.wxy * xMxyz - 2.0 * v.wz * yMxy - 2.0 * v.xy * wMyz - 2.0 * v.xy * yMwz - 2.0 * v.xy * zMwy - 2.0 * v.xyz * wMy - 2.0 * v.xyz * wzMyz - 2.0 * v.xyz * zMwyz - 2.0 * v.xz * xMwx - 2.0 * v.xz * xyMwxy - 2.0 * v.xz * yzMwyz - 2.0 * v.xz * zMwz - 2.0 * v.yz * wzMxyz - 2.0 * v.yz * xMwy - 2.0 * v.yz * yMwx - 2.0 * v.yz * zMi - v.wxz * xyMxy - v.wxz * xyzMxyz - v.wxz * yMy - v.wxz * yzMyz + 2.0 * sMw * v.xz + 2.0 * sMwxy * v.yz + 2.0 * sMxy * v.wyz + 2.0 * sMxyz * v.wy + 2.0 * sMz * v.wx + 2.0 * v.wx * xMxz + 2.0 * v.wxy * xyMxz + 2.0 * v.wxy * yMz + 2.0 * v.wy * xMyz + 2.0 * v.wy * yMxz + 2.0 * v.wy * zMxy + 2.0 * v.wyz * xMy + 2.0 * v.wyz * xzMyz + 2.0 * v.wyz * zMxyz + 2.0 * v.wz * yzMxyz + 2.0 * v.wz * zMxz + 2.0 * v.xy * wxMxyz + 2.0 * v.xy * xMi + 2.0 * v.xy * xyMwxz + 2.0 * v.xy * xzMwxy + 2.0 * v.xyz * wxMxy + 2.0 * v.xyz * wxzMxyz + 2.0 * v.xyz * xMwxy + 2.0 * v.xyz * xzMi + 2.0 * v.xz * xyzMi + 2.0 * v.xz * xzMwxz + 2.0 * v.xz * yMwy + 2.0 * v.yz * wMxy + 2.0 * v.yz * xzMwyz + 2.0 * v.yz * yzMwxz),
      wyz = (sMs * v.wyz + v.wyz * yMy + v.wyz * yzMyz + v.wyz * zMz - 2.0 * sMwxy * v.xz - 2.0 * sMxy * v.wxz - 2.0 * sMxyz * v.wx - 2.0 * sMy * v.wz - 2.0 * v.wx * zMxy - 2.0 * v.wxy * xMz - 2.0 * v.wxy * yMxyz - 2.0 * v.wxz * zMxyz - 2.0 * v.wy * xMxz - 2.0 * v.wy * xyMxyz - 2.0 * v.wz * xzMxyz - 2.0 * v.xz * wMxy - 2.0 * v.xz * xMwy - 2.0 * v.xz * yMwx - 2.0 * v.yz * xyMwxy - 2.0 * v.yz * xzMwxz - 2.0 * v.yz * yMwy - 2.0 * v.yz * zMwz - v.wyz * xMx - v.wyz * xyMxy - v.wyz * xyzMxyz - v.wyz * xzMxz + 2.0 * sMw * v.yz + 2.0 * sMwx * v.xyz + 2.0 * sMwxz * v.xy + 2.0 * sMxz * v.wxy + 2.0 * sMz * v.wy + 2.0 * v.wx * xMyz + 2.0 * v.wx * yMxz + 2.0 * v.wxy * xyMyz + 2.0 * v.wxz * xMy + 2.0 * v.wxz * xzMyz + 2.0 * v.wy * yMyz + 2.0 * v.wz * xMxy + 2.0 * v.wz * zMyz + 2.0 * v.xy * wMxz + 2.0 * v.xy * wyMxyz + 2.0 * v.xy * xMwz + 2.0 * v.xy * xyMwyz + 2.0 * v.xy * yMi + 2.0 * v.xy * yzMwxy + 2.0 * v.xy * zMwx + 2.0 * v.xyz * wMx + 2.0 * v.xyz * wyMxy + 2.0 * v.xyz * wyzMxyz + 2.0 * v.xyz * wzMxz + 2.0 * v.xyz * yMwxy + 2.0 * v.xyz * yzMi + 2.0 * v.xyz * zMwxz + 2.0 * v.xz * wzMxyz + 2.0 * v.xz * xzMwyz + 2.0 * v.xz * yzMwxz + 2.0 * v.xz * zMi + 2.0 * v.yz * xMwx + 2.0 * v.yz * xyzMi + 2.0 * v.yz * yzMwyz),
      xyz = (sMs * v.xyz + v.xyz * xMx + v.xyz * xyMxy + v.xyz * xyzMxyz + v.xyz * xzMxz + v.xyz * yMy + v.xyz * yzMyz + v.xyz * zMz - 2.0 * sMy * v.xz - 2.0 * v.xz * xMxy - 2.0 * v.yz * yMxy - 2.0 * v.yz * zMxz + 2.0 * sMx * v.yz + 2.0 * sMz * v.xy + 2.0 * v.xy * xMxz + 2.0 * v.xy * xyMxyz + 2.0 * v.xy * yMyz + 2.0 * v.xz * xzMxyz + 2.0 * v.xz * zMyz + 2.0 * v.yz * yzMxyz),
      i = (sMs * v.i + v.i * xyMxy + v.i * xzMxz + v.i * yzMyz - 2.0 * sMwxz * v.y - 2.0 * sMxyz * v.w - 2.0 * v.s * wMxyz - 2.0 * v.s * wxMyz - 2.0 * v.s * wzMxy - 2.0 * v.s * yMwxz - 2.0 * v.w * yMxz - 2.0 * v.x * wMyz - 2.0 * v.x * wxMxyz - 2.0 * v.x * xzMwxy - 2.0 * v.x * zMwy - 2.0 * v.y * wyMxyz - 2.0 * v.y * xMwz - 2.0 * v.y * yzMwxy - 2.0 * v.z * wMxy - 2.0 * v.z * wzMxyz - 2.0 * v.z * yMwx - 2.0 * v.z * yzMwxz - v.i * xMx - v.i * xyzMxyz - v.i * yMy - v.i * zMz + 2.0 * sMi * v.s + 2.0 * sMwxy * v.z + 2.0 * sMwyz * v.x + 2.0 * v.s * wyMxz + 2.0 * v.s * xMwyz + 2.0 * v.s * zMwxy + 2.0 * v.w * xMyz + 2.0 * v.w * zMxy + 2.0 * v.x * xMi + 2.0 * v.x * xyMwxz + 2.0 * v.x * yMwz + 2.0 * v.y * wMxz + 2.0 * v.y * xyMwyz + 2.0 * v.y * yMi + 2.0 * v.y * zMwx + 2.0 * v.z * xMwy + 2.0 * v.z * xzMwyz + 2.0 * v.z * zMi),
    )

  infix def sandwich(v: Motor): Multivector =
    val sMs = s * s
    val sMw = s * w
    val sMx = s * x
    val sMy = s * y
    val sMz = s * z
    val sMwx = s * wx
    val sMwy = s * wy
    val sMwz = s * wz
    val sMxy = s * xy
    val sMxz = s * xz
    val sMyz = s * yz
    val sMwxy = s * wxy
    val sMwxz = s * wxz
    val sMwyz = s * wyz
    val sMxyz = s * xyz
    val sMi = i * s
    val wMx = w * x
    val wMy = w * y
    val wMz = w * z
    val wMxy = w * xy
    val wMxz = w * xz
    val wMyz = w * yz
    val wMxyz = w * xyz
    val xMx = x * x
    val xMy = x * y
    val xMz = x * z
    val xMwx = wx * x
    val xMwy = wy * x
    val xMwz = wz * x
    val xMxy = x * xy
    val xMxz = x * xz
    val xMyz = x * yz
    val xMwxy = wxy * x
    val xMwxz = wxz * x
    val xMwyz = wyz * x
    val xMxyz = x * xyz
    val xMi = i * x
    val yMy = y * y
    val yMz = y * z
    val yMwx = wx * y
    val yMwy = wy * y
    val yMwz = wz * y
    val yMxy = xy * y
    val yMxz = xz * y
    val yMyz = y * yz
    val yMwxy = wxy * y
    val yMwxz = wxz * y
    val yMwyz = wyz * y
    val yMxyz = xyz * y
    val yMi = i * y
    val zMz = z * z
    val zMwx = wx * z
    val zMwy = wy * z
    val zMwz = wz * z
    val zMxy = xy * z
    val zMxz = xz * z
    val zMyz = yz * z
    val zMwxy = wxy * z
    val zMwxz = wxz * z
    val zMwyz = wyz * z
    val zMxyz = xyz * z
    val zMi = i * z
    val wxMxy = wx * xy
    val wxMxz = wx * xz
    val wxMyz = wx * yz
    val wxMxyz = wx * xyz
    val wyMxy = wy * xy
    val wyMxz = wy * xz
    val wyMyz = wy * yz
    val wyMxyz = wy * xyz
    val wzMxy = wz * xy
    val wzMxz = wz * xz
    val wzMyz = wz * yz
    val wzMxyz = wz * xyz
    val xyMxy = xy * xy
    val xyMxz = xy * xz
    val xyMyz = xy * yz
    val xyMwxy = wxy * xy
    val xyMwxz = wxz * xy
    val xyMwyz = wyz * xy
    val xyMxyz = xy * xyz
    val xyMi = i * xy
    val xzMxz = xz * xz
    val xzMyz = xz * yz
    val xzMwxy = wxy * xz
    val xzMwxz = wxz * xz
    val xzMwyz = wyz * xz
    val xzMxyz = xyz * xz
    val xzMi = i * xz
    val yzMyz = yz * yz
    val yzMwxy = wxy * yz
    val yzMwxz = wxz * yz
    val yzMwyz = wyz * yz
    val yzMxyz = xyz * yz
    val yzMi = i * yz
    val wxyMxyz = wxy * xyz
    val wxzMxyz = wxz * xyz
    val wyzMxyz = wyz * xyz
    val xyzMxyz = xyz * xyz
    val xyzMi = i * xyz
    Multivector(
      s = v.s * (sMs + xMx + xyMxy + xyzMxyz + xzMxz + yMy + yzMyz + zMz),
      w = (-2.0 * v.i * xMyz - 2.0 * v.i * zMxy + 2.0 * sMw * v.s + 2.0 * sMxyz * v.i + 2.0 * v.i * yMxz + 2.0 * v.s * xMwx + 2.0 * v.s * xyMwxy + 2.0 * v.s * xyzMi + 2.0 * v.s * xzMwxz + 2.0 * v.s * yMwy + 2.0 * v.s * yzMwyz + 2.0 * v.s * zMwz),
      x = 2.0 * v.s * (sMx + yMxy + yzMxyz + zMxz),
      y = v.s * (-2.0 * xMxy - 2.0 * xzMxyz + 2.0 * sMy + 2.0 * zMyz),
      z = v.s * (-2.0 * xMxz - 2.0 * yMyz + 2.0 * sMz + 2.0 * xyMxyz),
      wx = (sMs * v.wx + v.wx * yMy + v.wx * yzMyz + v.wx * zMz - 2.0 * sMi * v.yz - 2.0 * sMwy * v.xy - 2.0 * sMwz * v.xz - 2.0 * v.wy * xMy - 2.0 * v.wy * xzMyz - 2.0 * v.wz * xMz - 2.0 * v.wz * yMxyz - 2.0 * v.xy * xMwxy - 2.0 * v.xy * xzMi - 2.0 * v.xy * zMwyz - 2.0 * v.xz * wxyMxyz - 2.0 * v.xz * wyMyz - 2.0 * v.xz * xMwxz - 2.0 * v.yz * wzMxy - 2.0 * v.yz * xMwyz - 2.0 * v.yz * yMwxz - v.wx * xMx - v.wx * xyMxy - v.wx * xyzMxyz - v.wx * xzMxz + 2.0 * sMxy * v.wy + 2.0 * sMxz * v.wz + 2.0 * v.wy * zMxyz + 2.0 * v.wz * xyMyz + 2.0 * v.xy * wMy + 2.0 * v.xy * wxMxy + 2.0 * v.xy * wxzMxyz + 2.0 * v.xy * wzMyz + 2.0 * v.xz * wMz + 2.0 * v.xz * wxMxz + 2.0 * v.xz * xyMi + 2.0 * v.xz * yMwyz + 2.0 * v.yz * wMxyz + 2.0 * v.yz * wxMyz + 2.0 * v.yz * wyMxz + 2.0 * v.yz * zMwxy),
      wy = (sMs * v.wy + v.wy * xMx + v.wy * xzMxz + v.wy * zMz - 2.0 * sMwz * v.yz - 2.0 * sMxy * v.wx - 2.0 * v.wx * xMy - 2.0 * v.wx * xzMyz - 2.0 * v.wx * zMxyz - 2.0 * v.wz * xyMxz - 2.0 * v.wz * yMz - 2.0 * v.xy * wMx - 2.0 * v.xy * wzMxz - 2.0 * v.xy * yMwxy - 2.0 * v.xy * yzMi - 2.0 * v.xz * wMxyz - 2.0 * v.xz * xMwyz - 2.0 * v.xz * yMwxz - 2.0 * v.xz * zMwxy - 2.0 * v.yz * wxMxz - 2.0 * v.yz * wxyMxyz - 2.0 * v.yz * yMwyz - v.wy * xyMxy - v.wy * xyzMxyz - v.wy * yMy - v.wy * yzMyz + 2.0 * sMi * v.xz + 2.0 * sMwx * v.xy + 2.0 * sMyz * v.wz + 2.0 * v.wz * xMxyz + 2.0 * v.xy * wyMxy + 2.0 * v.xy * wyzMxyz + 2.0 * v.xy * zMwxz + 2.0 * v.xz * wxMyz + 2.0 * v.xz * wyMxz + 2.0 * v.xz * wzMxy + 2.0 * v.yz * wMz + 2.0 * v.yz * wyMyz + 2.0 * v.yz * xMwxz + 2.0 * v.yz * xyMi),
      wz = (sMs * v.wz + v.wz * xMx + v.wz * xyMxy + v.wz * yMy - 2.0 * sMi * v.xy - 2.0 * sMxz * v.wx - 2.0 * sMyz * v.wy - 2.0 * v.wx * xMz - 2.0 * v.wy * xMxyz - 2.0 * v.wy * xyMxz - 2.0 * v.wy * yMz - 2.0 * v.xy * wxMyz - 2.0 * v.xy * yMwxz - 2.0 * v.xy * zMwxy - 2.0 * v.xz * wMx - 2.0 * v.xz * wyMxy - 2.0 * v.xz * yzMi - 2.0 * v.xz * zMwxz - 2.0 * v.yz * wMy - 2.0 * v.yz * wxzMxyz - 2.0 * v.yz * xMwxy - 2.0 * v.yz * zMwyz - v.wz * xyzMxyz - v.wz * xzMxz - v.wz * yzMyz - v.wz * zMz + 2.0 * sMwx * v.xz + 2.0 * sMwy * v.yz + 2.0 * v.wx * xyMyz + 2.0 * v.wx * yMxyz + 2.0 * v.xy * wMxyz + 2.0 * v.xy * wyMxz + 2.0 * v.xy * wzMxy + 2.0 * v.xy * xMwyz + 2.0 * v.xz * wyzMxyz + 2.0 * v.xz * wzMxz + 2.0 * v.xz * yMwxy + 2.0 * v.yz * wxMxy + 2.0 * v.yz * wzMyz + 2.0 * v.yz * xzMi),
      xy = (sMs * v.xy + v.xy * xyMxy + v.xy * xyzMxyz + v.xy * zMz - 2.0 * sMxz * v.yz - 2.0 * v.xz * xMxyz - 2.0 * v.xz * yMz - 2.0 * v.yz * yMxyz - v.xy * xMx - v.xy * xzMxz - v.xy * yMy - v.xy * yzMyz + 2.0 * sMyz * v.xz + 2.0 * v.xz * xyMxz + 2.0 * v.yz * xMz + 2.0 * v.yz * xyMyz),
      xz = (sMs * v.xz + v.xz * xyzMxyz + v.xz * xzMxz + v.xz * yMy - 2.0 * sMyz * v.xy - 2.0 * v.xy * yMz - 2.0 * v.yz * xMy - 2.0 * v.yz * zMxyz - v.xz * xMx - v.xz * xyMxy - v.xz * yzMyz - v.xz * zMz + 2.0 * sMxy * v.yz + 2.0 * v.xy * xMxyz + 2.0 * v.xy * xyMxz + 2.0 * v.yz * xzMyz),
      yz = (sMs * v.yz + v.yz * xMx + v.yz * xyzMxyz + v.yz * yzMyz - 2.0 * sMxy * v.xz - 2.0 * v.xz * xMy - v.yz * xyMxy - v.yz * xzMxz - v.yz * yMy - v.yz * zMz + 2.0 * sMxz * v.xy + 2.0 * v.xy * xMz + 2.0 * v.xy * xyMyz + 2.0 * v.xy * yMxyz + 2.0 * v.xz * xzMyz + 2.0 * v.xz * zMxyz),
      wxy = (-2.0 * sMwxz * v.yz - 2.0 * sMx * v.wy - 2.0 * sMxyz * v.wz - 2.0 * v.wy * zMxz - 2.0 * v.wz * xMyz - 2.0 * v.xy * xMwx - 2.0 * v.xy * xzMwxz - 2.0 * v.xy * yMwy - 2.0 * v.xy * yzMwyz - 2.0 * v.xz * wxMxyz - 2.0 * v.xz * xMi - 2.0 * v.xz * yMwz - 2.0 * v.xz * zMwy - 2.0 * v.yz * wMxz - 2.0 * v.yz * wyMxyz - 2.0 * v.yz * yMi + 2.0 * sMw * v.xy + 2.0 * sMwyz * v.xz + 2.0 * sMy * v.wx + 2.0 * v.wx * xMxy + 2.0 * v.wx * xzMxyz + 2.0 * v.wx * zMyz + 2.0 * v.wy * yMxy + 2.0 * v.wy * yzMxyz + 2.0 * v.wz * yMxz + 2.0 * v.wz * zMxy + 2.0 * v.xy * xyMwxy + 2.0 * v.xy * xyzMi + 2.0 * v.xy * zMwz + 2.0 * v.xz * wMyz + 2.0 * v.xz * xyMwxz + 2.0 * v.xz * xzMwxy + 2.0 * v.yz * xMwz + 2.0 * v.yz * xyMwyz + 2.0 * v.yz * yzMwxy + 2.0 * v.yz * zMwx),
      wxz = (-2.0 * sMwyz * v.xy - 2.0 * sMx * v.wz - 2.0 * v.wx * xyMxyz - 2.0 * v.wx * yMyz - 2.0 * v.wz * yMxy - 2.0 * v.xy * wMyz - 2.0 * v.xy * yMwz - 2.0 * v.xy * zMwy - 2.0 * v.xz * xMwx - 2.0 * v.xz * xyMwxy - 2.0 * v.xz * yzMwyz - 2.0 * v.xz * zMwz - 2.0 * v.yz * wzMxyz - 2.0 * v.yz * xMwy - 2.0 * v.yz * yMwx - 2.0 * v.yz * zMi + 2.0 * sMw * v.xz + 2.0 * sMwxy * v.yz + 2.0 * sMxyz * v.wy + 2.0 * sMz * v.wx + 2.0 * v.wx * xMxz + 2.0 * v.wy * xMyz + 2.0 * v.wy * yMxz + 2.0 * v.wy * zMxy + 2.0 * v.wz * yzMxyz + 2.0 * v.wz * zMxz + 2.0 * v.xy * wxMxyz + 2.0 * v.xy * xMi + 2.0 * v.xy * xyMwxz + 2.0 * v.xy * xzMwxy + 2.0 * v.xz * xyzMi + 2.0 * v.xz * xzMwxz + 2.0 * v.xz * yMwy + 2.0 * v.yz * wMxy + 2.0 * v.yz * xzMwyz + 2.0 * v.yz * yzMwxz),
      wyz = (-2.0 * sMwxy * v.xz - 2.0 * sMxyz * v.wx - 2.0 * sMy * v.wz - 2.0 * v.wx * zMxy - 2.0 * v.wy * xMxz - 2.0 * v.wy * xyMxyz - 2.0 * v.wz * xzMxyz - 2.0 * v.xz * wMxy - 2.0 * v.xz * xMwy - 2.0 * v.xz * yMwx - 2.0 * v.yz * xyMwxy - 2.0 * v.yz * xzMwxz - 2.0 * v.yz * yMwy - 2.0 * v.yz * zMwz + 2.0 * sMw * v.yz + 2.0 * sMwxz * v.xy + 2.0 * sMz * v.wy + 2.0 * v.wx * xMyz + 2.0 * v.wx * yMxz + 2.0 * v.wy * yMyz + 2.0 * v.wz * xMxy + 2.0 * v.wz * zMyz + 2.0 * v.xy * wMxz + 2.0 * v.xy * wyMxyz + 2.0 * v.xy * xMwz + 2.0 * v.xy * xyMwyz + 2.0 * v.xy * yMi + 2.0 * v.xy * yzMwxy + 2.0 * v.xy * zMwx + 2.0 * v.xz * wzMxyz + 2.0 * v.xz * xzMwyz + 2.0 * v.xz * yzMwxz + 2.0 * v.xz * zMi + 2.0 * v.yz * xMwx + 2.0 * v.yz * xyzMi + 2.0 * v.yz * yzMwyz),
      xyz = (-2.0 * sMy * v.xz - 2.0 * v.xz * xMxy - 2.0 * v.yz * yMxy - 2.0 * v.yz * zMxz + 2.0 * sMx * v.yz + 2.0 * sMz * v.xy + 2.0 * v.xy * xMxz + 2.0 * v.xy * xyMxyz + 2.0 * v.xy * yMyz + 2.0 * v.xz * xzMxyz + 2.0 * v.xz * zMyz + 2.0 * v.yz * yzMxyz),
      i = (sMs * v.i + v.i * xyMxy + v.i * xzMxz + v.i * yzMyz - 2.0 * v.s * wMxyz - 2.0 * v.s * wxMyz - 2.0 * v.s * wzMxy - 2.0 * v.s * yMwxz - v.i * xMx - v.i * xyzMxyz - v.i * yMy - v.i * zMz + 2.0 * sMi * v.s + 2.0 * v.s * wyMxz + 2.0 * v.s * xMwyz + 2.0 * v.s * zMwxy),
    )

  infix def sandwich(v: Plane): Multivector =
    val sMs = s * s
    val sMxy = s * xy
    val sMxz = s * xz
    val sMyz = s * yz
    val xMx = x * x
    val xMy = x * y
    val xMz = x * z
    val xMxyz = x * xyz
    val yMy = y * y
    val yMz = y * z
    val yMxyz = xyz * y
    val zMz = z * z
    val zMxyz = xyz * z
    val xyMxy = xy * xy
    val xyMxz = xy * xz
    val xyMyz = xy * yz
    val xzMxz = xz * xz
    val xzMyz = xz * yz
    val yzMyz = yz * yz
    val xyzMxyz = xyz * xyz
    Multivector(
      s = (-2.0 * v.x * xy * y - 2.0 * v.x * xz * z - 2.0 * v.y * xyz * xz - 2.0 * v.y * yz * z + 2.0 * s * v.x * x + 2.0 * s * v.y * y + 2.0 * s * v.z * z + 2.0 * v.x * xyz * yz + 2.0 * v.y * x * xy + 2.0 * v.z * x * xz + 2.0 * v.z * xy * xyz + 2.0 * v.z * y * yz),
      w = (sMs * v.w + v.w * xyMxy + v.w * xzMxz + v.w * yzMyz - v.w * xMx - v.w * xyzMxyz - v.w * yMy - v.w * zMz - 2.0 * i * v.y * xz - 2.0 * v.x * wxy * y - 2.0 * v.x * wxz * z - 2.0 * v.x * wy * xy - 2.0 * v.x * wz * xz - 2.0 * v.y * wxz * xyz - 2.0 * v.y * wyz * z - 2.0 * v.y * wz * yz + 2.0 * i * v.x * yz + 2.0 * i * v.z * xy + 2.0 * s * v.x * wx + 2.0 * s * v.y * wy + 2.0 * s * v.z * wz + 2.0 * v.x * w * x + 2.0 * v.x * wyz * xyz + 2.0 * v.y * w * y + 2.0 * v.y * wx * xy + 2.0 * v.y * wxy * x + 2.0 * v.z * w * z + 2.0 * v.z * wx * xz + 2.0 * v.z * wxy * xyz + 2.0 * v.z * wxz * x + 2.0 * v.z * wy * yz + 2.0 * v.z * wyz * y),
      x = (sMs * v.x + v.x * xMx + v.x * xyzMxyz + v.x * yzMyz - 2.0 * v.y * xzMyz - 2.0 * v.y * zMxyz - v.x * xyMxy - v.x * xzMxz - v.x * yMy - v.x * zMz + 2.0 * sMxy * v.y + 2.0 * sMxz * v.z + 2.0 * v.y * xMy + 2.0 * v.z * xMz + 2.0 * v.z * xyMyz + 2.0 * v.z * yMxyz),
      y = (sMs * v.y + v.y * xyzMxyz + v.y * xzMxz + v.y * yMy - 2.0 * sMxy * v.x - 2.0 * v.x * xzMyz - 2.0 * v.z * xMxyz - 2.0 * v.z * xyMxz - v.y * xMx - v.y * xyMxy - v.y * yzMyz - v.y * zMz + 2.0 * sMyz * v.z + 2.0 * v.x * xMy + 2.0 * v.x * zMxyz + 2.0 * v.z * yMz),
      z = (sMs * v.z + v.z * xyMxy + v.z * xyzMxyz + v.z * zMz - 2.0 * sMxz * v.x - 2.0 * sMyz * v.y - 2.0 * v.x * yMxyz - 2.0 * v.y * xyMxz - v.z * xMx - v.z * xzMxz - v.z * yMy - v.z * yzMyz + 2.0 * v.x * xMz + 2.0 * v.x * xyMyz + 2.0 * v.y * xMxyz + 2.0 * v.y * yMz),
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
    val sMs = s * s
    val sMw = s * w
    val sMx = s * x
    val sMy = s * y
    val sMz = s * z
    val sMwx = s * wx
    val sMwy = s * wy
    val sMwz = s * wz
    val sMxy = s * xy
    val sMxz = s * xz
    val sMyz = s * yz
    val sMwxy = s * wxy
    val sMwxz = s * wxz
    val sMwyz = s * wyz
    val sMxyz = s * xyz
    val sMi = i * s
    val wMx = w * x
    val wMy = w * y
    val wMz = w * z
    val wMxy = w * xy
    val wMxz = w * xz
    val wMyz = w * yz
    val wMxyz = w * xyz
    val xMx = x * x
    val xMy = x * y
    val xMz = x * z
    val xMwx = wx * x
    val xMwy = wy * x
    val xMwz = wz * x
    val xMxy = x * xy
    val xMxz = x * xz
    val xMyz = x * yz
    val xMwxy = wxy * x
    val xMwxz = wxz * x
    val xMwyz = wyz * x
    val xMxyz = x * xyz
    val xMi = i * x
    val yMy = y * y
    val yMz = y * z
    val yMwx = wx * y
    val yMwy = wy * y
    val yMwz = wz * y
    val yMxy = xy * y
    val yMxz = xz * y
    val yMyz = y * yz
    val yMwxy = wxy * y
    val yMwxz = wxz * y
    val yMwyz = wyz * y
    val yMxyz = xyz * y
    val yMi = i * y
    val zMz = z * z
    val zMwx = wx * z
    val zMwy = wy * z
    val zMwz = wz * z
    val zMxy = xy * z
    val zMxz = xz * z
    val zMyz = yz * z
    val zMwxy = wxy * z
    val zMwxz = wxz * z
    val zMwyz = wyz * z
    val zMxyz = xyz * z
    val zMi = i * z
    val wxMxy = wx * xy
    val wxMxz = wx * xz
    val wxMyz = wx * yz
    val wxMxyz = wx * xyz
    val wyMxy = wy * xy
    val wyMxz = wy * xz
    val wyMyz = wy * yz
    val wyMxyz = wy * xyz
    val wzMxy = wz * xy
    val wzMxz = wz * xz
    val wzMyz = wz * yz
    val wzMxyz = wz * xyz
    val xyMxy = xy * xy
    val xyMxz = xy * xz
    val xyMyz = xy * yz
    val xyMwxy = wxy * xy
    val xyMwxz = wxz * xy
    val xyMwyz = wyz * xy
    val xyMxyz = xy * xyz
    val xyMi = i * xy
    val xzMxz = xz * xz
    val xzMyz = xz * yz
    val xzMwxy = wxy * xz
    val xzMwxz = wxz * xz
    val xzMwyz = wyz * xz
    val xzMxyz = xyz * xz
    val xzMi = i * xz
    val yzMyz = yz * yz
    val yzMwxy = wxy * yz
    val yzMwxz = wxz * yz
    val yzMwyz = wyz * yz
    val yzMxyz = xyz * yz
    val yzMi = i * yz
    val wxyMxyz = wxy * xyz
    val wxzMxyz = wxz * xyz
    val wyzMxyz = wyz * xyz
    val xyzMxyz = xyz * xyz
    val xyzMi = i * xyz
    Multivector(
      s = 0.0,
      w = 0.0,
      x = 0.0,
      y = 0.0,
      z = 0.0,
      wx = (sMs * v.wx + v.wx * yMy + v.wx * yzMyz + v.wx * zMz - 2.0 * sMi * v.yz - 2.0 * sMwy * v.xy - 2.0 * sMwz * v.xz - 2.0 * v.wy * xMy - 2.0 * v.wy * xzMyz - 2.0 * v.wz * xMz - 2.0 * v.wz * yMxyz - 2.0 * v.xy * xMwxy - 2.0 * v.xy * xzMi - 2.0 * v.xy * zMwyz - 2.0 * v.xz * wxyMxyz - 2.0 * v.xz * wyMyz - 2.0 * v.xz * xMwxz - 2.0 * v.yz * wzMxy - 2.0 * v.yz * xMwyz - 2.0 * v.yz * yMwxz - v.wx * xMx - v.wx * xyMxy - v.wx * xyzMxyz - v.wx * xzMxz + 2.0 * sMxy * v.wy + 2.0 * sMxz * v.wz + 2.0 * v.wy * zMxyz + 2.0 * v.wz * xyMyz + 2.0 * v.xy * wMy + 2.0 * v.xy * wxMxy + 2.0 * v.xy * wxzMxyz + 2.0 * v.xy * wzMyz + 2.0 * v.xz * wMz + 2.0 * v.xz * wxMxz + 2.0 * v.xz * xyMi + 2.0 * v.xz * yMwyz + 2.0 * v.yz * wMxyz + 2.0 * v.yz * wxMyz + 2.0 * v.yz * wyMxz + 2.0 * v.yz * zMwxy),
      wy = (sMs * v.wy + v.wy * xMx + v.wy * xzMxz + v.wy * zMz - 2.0 * sMwz * v.yz - 2.0 * sMxy * v.wx - 2.0 * v.wx * xMy - 2.0 * v.wx * xzMyz - 2.0 * v.wx * zMxyz - 2.0 * v.wz * xyMxz - 2.0 * v.wz * yMz - 2.0 * v.xy * wMx - 2.0 * v.xy * wzMxz - 2.0 * v.xy * yMwxy - 2.0 * v.xy * yzMi - 2.0 * v.xz * wMxyz - 2.0 * v.xz * xMwyz - 2.0 * v.xz * yMwxz - 2.0 * v.xz * zMwxy - 2.0 * v.yz * wxMxz - 2.0 * v.yz * wxyMxyz - 2.0 * v.yz * yMwyz - v.wy * xyMxy - v.wy * xyzMxyz - v.wy * yMy - v.wy * yzMyz + 2.0 * sMi * v.xz + 2.0 * sMwx * v.xy + 2.0 * sMyz * v.wz + 2.0 * v.wz * xMxyz + 2.0 * v.xy * wyMxy + 2.0 * v.xy * wyzMxyz + 2.0 * v.xy * zMwxz + 2.0 * v.xz * wxMyz + 2.0 * v.xz * wyMxz + 2.0 * v.xz * wzMxy + 2.0 * v.yz * wMz + 2.0 * v.yz * wyMyz + 2.0 * v.yz * xMwxz + 2.0 * v.yz * xyMi),
      wz = (sMs * v.wz + v.wz * xMx + v.wz * xyMxy + v.wz * yMy - 2.0 * sMi * v.xy - 2.0 * sMxz * v.wx - 2.0 * sMyz * v.wy - 2.0 * v.wx * xMz - 2.0 * v.wy * xMxyz - 2.0 * v.wy * xyMxz - 2.0 * v.wy * yMz - 2.0 * v.xy * wxMyz - 2.0 * v.xy * yMwxz - 2.0 * v.xy * zMwxy - 2.0 * v.xz * wMx - 2.0 * v.xz * wyMxy - 2.0 * v.xz * yzMi - 2.0 * v.xz * zMwxz - 2.0 * v.yz * wMy - 2.0 * v.yz * wxzMxyz - 2.0 * v.yz * xMwxy - 2.0 * v.yz * zMwyz - v.wz * xyzMxyz - v.wz * xzMxz - v.wz * yzMyz - v.wz * zMz + 2.0 * sMwx * v.xz + 2.0 * sMwy * v.yz + 2.0 * v.wx * xyMyz + 2.0 * v.wx * yMxyz + 2.0 * v.xy * wMxyz + 2.0 * v.xy * wyMxz + 2.0 * v.xy * wzMxy + 2.0 * v.xy * xMwyz + 2.0 * v.xz * wyzMxyz + 2.0 * v.xz * wzMxz + 2.0 * v.xz * yMwxy + 2.0 * v.yz * wxMxy + 2.0 * v.yz * wzMyz + 2.0 * v.yz * xzMi),
      xy = (sMs * v.xy + v.xy * xyMxy + v.xy * xyzMxyz + v.xy * zMz - 2.0 * sMxz * v.yz - 2.0 * v.xz * xMxyz - 2.0 * v.xz * yMz - 2.0 * v.yz * yMxyz - v.xy * xMx - v.xy * xzMxz - v.xy * yMy - v.xy * yzMyz + 2.0 * sMyz * v.xz + 2.0 * v.xz * xyMxz + 2.0 * v.yz * xMz + 2.0 * v.yz * xyMyz),
      xz = (sMs * v.xz + v.xz * xyzMxyz + v.xz * xzMxz + v.xz * yMy - 2.0 * sMyz * v.xy - 2.0 * v.xy * yMz - 2.0 * v.yz * xMy - 2.0 * v.yz * zMxyz - v.xz * xMx - v.xz * xyMxy - v.xz * yzMyz - v.xz * zMz + 2.0 * sMxy * v.yz + 2.0 * v.xy * xMxyz + 2.0 * v.xy * xyMxz + 2.0 * v.yz * xzMyz),
      yz = (sMs * v.yz + v.yz * xMx + v.yz * xyzMxyz + v.yz * yzMyz - 2.0 * sMxy * v.xz - 2.0 * v.xz * xMy - v.yz * xyMxy - v.yz * xzMxz - v.yz * yMy - v.yz * zMz + 2.0 * sMxz * v.xy + 2.0 * v.xy * xMz + 2.0 * v.xy * xyMyz + 2.0 * v.xy * yMxyz + 2.0 * v.xz * xzMyz + 2.0 * v.xz * zMxyz),
      wxy = (-2.0 * sMwxz * v.yz - 2.0 * sMx * v.wy - 2.0 * sMxyz * v.wz - 2.0 * v.wy * zMxz - 2.0 * v.wz * xMyz - 2.0 * v.xy * xMwx - 2.0 * v.xy * xzMwxz - 2.0 * v.xy * yMwy - 2.0 * v.xy * yzMwyz - 2.0 * v.xz * wxMxyz - 2.0 * v.xz * xMi - 2.0 * v.xz * yMwz - 2.0 * v.xz * zMwy - 2.0 * v.yz * wMxz - 2.0 * v.yz * wyMxyz - 2.0 * v.yz * yMi + 2.0 * sMw * v.xy + 2.0 * sMwyz * v.xz + 2.0 * sMy * v.wx + 2.0 * v.wx * xMxy + 2.0 * v.wx * xzMxyz + 2.0 * v.wx * zMyz + 2.0 * v.wy * yMxy + 2.0 * v.wy * yzMxyz + 2.0 * v.wz * yMxz + 2.0 * v.wz * zMxy + 2.0 * v.xy * xyMwxy + 2.0 * v.xy * xyzMi + 2.0 * v.xy * zMwz + 2.0 * v.xz * wMyz + 2.0 * v.xz * xyMwxz + 2.0 * v.xz * xzMwxy + 2.0 * v.yz * xMwz + 2.0 * v.yz * xyMwyz + 2.0 * v.yz * yzMwxy + 2.0 * v.yz * zMwx),
      wxz = (-2.0 * sMwyz * v.xy - 2.0 * sMx * v.wz - 2.0 * v.wx * xyMxyz - 2.0 * v.wx * yMyz - 2.0 * v.wz * yMxy - 2.0 * v.xy * wMyz - 2.0 * v.xy * yMwz - 2.0 * v.xy * zMwy - 2.0 * v.xz * xMwx - 2.0 * v.xz * xyMwxy - 2.0 * v.xz * yzMwyz - 2.0 * v.xz * zMwz - 2.0 * v.yz * wzMxyz - 2.0 * v.yz * xMwy - 2.0 * v.yz * yMwx - 2.0 * v.yz * zMi + 2.0 * sMw * v.xz + 2.0 * sMwxy * v.yz + 2.0 * sMxyz * v.wy + 2.0 * sMz * v.wx + 2.0 * v.wx * xMxz + 2.0 * v.wy * xMyz + 2.0 * v.wy * yMxz + 2.0 * v.wy * zMxy + 2.0 * v.wz * yzMxyz + 2.0 * v.wz * zMxz + 2.0 * v.xy * wxMxyz + 2.0 * v.xy * xMi + 2.0 * v.xy * xyMwxz + 2.0 * v.xy * xzMwxy + 2.0 * v.xz * xyzMi + 2.0 * v.xz * xzMwxz + 2.0 * v.xz * yMwy + 2.0 * v.yz * wMxy + 2.0 * v.yz * xzMwyz + 2.0 * v.yz * yzMwxz),
      wyz = (-2.0 * sMwxy * v.xz - 2.0 * sMxyz * v.wx - 2.0 * sMy * v.wz - 2.0 * v.wx * zMxy - 2.0 * v.wy * xMxz - 2.0 * v.wy * xyMxyz - 2.0 * v.wz * xzMxyz - 2.0 * v.xz * wMxy - 2.0 * v.xz * xMwy - 2.0 * v.xz * yMwx - 2.0 * v.yz * xyMwxy - 2.0 * v.yz * xzMwxz - 2.0 * v.yz * yMwy - 2.0 * v.yz * zMwz + 2.0 * sMw * v.yz + 2.0 * sMwxz * v.xy + 2.0 * sMz * v.wy + 2.0 * v.wx * xMyz + 2.0 * v.wx * yMxz + 2.0 * v.wy * yMyz + 2.0 * v.wz * xMxy + 2.0 * v.wz * zMyz + 2.0 * v.xy * wMxz + 2.0 * v.xy * wyMxyz + 2.0 * v.xy * xMwz + 2.0 * v.xy * xyMwyz + 2.0 * v.xy * yMi + 2.0 * v.xy * yzMwxy + 2.0 * v.xy * zMwx + 2.0 * v.xz * wzMxyz + 2.0 * v.xz * xzMwyz + 2.0 * v.xz * yzMwxz + 2.0 * v.xz * zMi + 2.0 * v.yz * xMwx + 2.0 * v.yz * xyzMi + 2.0 * v.yz * yzMwyz),
      xyz = (-2.0 * sMy * v.xz - 2.0 * v.xz * xMxy - 2.0 * v.yz * yMxy - 2.0 * v.yz * zMxz + 2.0 * sMx * v.yz + 2.0 * sMz * v.xy + 2.0 * v.xy * xMxz + 2.0 * v.xy * xyMxyz + 2.0 * v.xy * yMyz + 2.0 * v.xz * xzMxyz + 2.0 * v.xz * zMyz + 2.0 * v.yz * yzMxyz),
      i = 0.0,
    )

  infix def sandwich(v: Point): Multivector =
    val sMs = s * s
    val sMx = s * x
    val sMy = s * y
    val sMz = s * z
    val sMxy = s * xy
    val sMxz = s * xz
    val sMyz = s * yz
    val sMxyz = s * xyz
    val xMx = x * x
    val xMy = x * y
    val xMz = x * z
    val xMxy = x * xy
    val xMxz = x * xz
    val xMyz = x * yz
    val xMxyz = x * xyz
    val yMy = y * y
    val yMz = y * z
    val yMxy = xy * y
    val yMxz = xz * y
    val yMyz = y * yz
    val yMxyz = xyz * y
    val zMz = z * z
    val zMxy = xy * z
    val zMxz = xz * z
    val zMyz = yz * z
    val zMxyz = xyz * z
    val xyMxy = xy * xy
    val xyMxz = xy * xz
    val xyMyz = xy * yz
    val xyMxyz = xy * xyz
    val xzMxz = xz * xz
    val xzMyz = xz * yz
    val xzMxyz = xyz * xz
    val yzMyz = yz * yz
    val yzMxyz = xyz * yz
    val xyzMxyz = xyz * xyz
    Multivector(
      s = 0.0,
      w = 0.0,
      x = 0.0,
      y = 0.0,
      z = 0.0,
      wx = (-2.0 * v.wxy * xMxy - 2.0 * v.wxy * zMyz - 2.0 * v.wxz * xMxz - 2.0 * v.wxz * xyMxyz - 2.0 * v.wyz * xMyz - 2.0 * v.wyz * yMxz + 2.0 * sMxyz * v.wyz + 2.0 * sMy * v.wxy + 2.0 * sMz * v.wxz + 2.0 * v.wxy * xzMxyz + 2.0 * v.wxz * yMyz + 2.0 * v.wyz * zMxy - 2.0 * i * v.xyz * x - 2.0 * s * v.xyz * wyz - 2.0 * v.xyz * wxy * xz - 2.0 * v.xyz * wy * z + 2.0 * v.xyz * w * yz + 2.0 * v.xyz * wx * xyz + 2.0 * v.xyz * wxz * xy + 2.0 * v.xyz * wz * y),
      wy = (-2.0 * sMx * v.wxy - 2.0 * sMxyz * v.wxz - 2.0 * v.wxy * yMxy - 2.0 * v.wxz * xMyz - 2.0 * v.wxz * yMxz - 2.0 * v.wxz * zMxy - 2.0 * v.wyz * xyMxyz - 2.0 * v.wyz * yMyz + 2.0 * sMz * v.wyz + 2.0 * v.wxy * yzMxyz + 2.0 * v.wxy * zMxz + 2.0 * v.wyz * xMxz - 2.0 * i * v.xyz * y - 2.0 * v.xyz * w * xz - 2.0 * v.xyz * wxy * yz - 2.0 * v.xyz * wz * x + 2.0 * s * v.xyz * wxz + 2.0 * v.xyz * wx * z + 2.0 * v.xyz * wy * xyz + 2.0 * v.xyz * wyz * xy),
      wz = (-2.0 * sMx * v.wxz - 2.0 * sMy * v.wyz - 2.0 * v.wxy * yMxz - 2.0 * v.wxy * zMxy - 2.0 * v.wxz * zMxz - 2.0 * v.wyz * xMxy - 2.0 * v.wyz * xzMxyz - 2.0 * v.wyz * zMyz + 2.0 * sMxyz * v.wxy + 2.0 * v.wxy * xMyz + 2.0 * v.wxz * yMxy + 2.0 * v.wxz * yzMxyz - 2.0 * i * v.xyz * z - 2.0 * s * v.xyz * wxy - 2.0 * v.xyz * wx * y - 2.0 * v.xyz * wxz * yz + 2.0 * v.xyz * w * xy + 2.0 * v.xyz * wy * x + 2.0 * v.xyz * wyz * xz + 2.0 * v.xyz * wz * xyz),
      xy = v.xyz * (-2.0 * xMxz - 2.0 * yMyz + 2.0 * sMz + 2.0 * xyMxyz),
      xz = v.xyz * (-2.0 * sMy - 2.0 * zMyz + 2.0 * xMxy + 2.0 * xzMxyz),
      yz = 2.0 * v.xyz * (sMx + yMxy + yzMxyz + zMxz),
      wxy = (sMs * v.wxy + v.wxy * xMx + v.wxy * xyMxy + v.wxy * yMy - 2.0 * sMxz * v.wyz - 2.0 * v.wyz * xMz - v.wxy * xyzMxyz - v.wxy * xzMxz - v.wxy * yzMyz - v.wxy * zMz + 2.0 * sMyz * v.wxz + 2.0 * v.wxz * xMxyz + 2.0 * v.wxz * xyMxz + 2.0 * v.wxz * yMz + 2.0 * v.wyz * xyMyz + 2.0 * v.wyz * yMxyz - 2.0 * v.xyz * wx * xz - 2.0 * v.xyz * wxz * x - 2.0 * v.xyz * wy * yz - 2.0 * v.xyz * wyz * y + 2.0 * i * v.xyz * xy + 2.0 * s * v.xyz * wz + 2.0 * v.xyz * w * z + 2.0 * v.xyz * wxy * xyz),
      wxz = (sMs * v.wxz + v.wxz * xMx + v.wxz * xzMxz + v.wxz * zMz - 2.0 * sMyz * v.wxy - 2.0 * v.wxy * xMxyz - v.wxz * xyMxy - v.wxz * xyzMxyz - v.wxz * yMy - v.wxz * yzMyz + 2.0 * sMxy * v.wyz + 2.0 * v.wxy * xyMxz + 2.0 * v.wxy * yMz + 2.0 * v.wyz * xMy + 2.0 * v.wyz * xzMyz + 2.0 * v.wyz * zMxyz - 2.0 * s * v.xyz * wy - 2.0 * v.xyz * w * y - 2.0 * v.xyz * wyz * z - 2.0 * v.xyz * wz * yz + 2.0 * i * v.xyz * xz + 2.0 * v.xyz * wx * xy + 2.0 * v.xyz * wxy * x + 2.0 * v.xyz * wxz * xyz),
      wyz = (sMs * v.wyz + v.wyz * yMy + v.wyz * yzMyz + v.wyz * zMz - 2.0 * sMxy * v.wxz - 2.0 * v.wxy * xMz - 2.0 * v.wxy * yMxyz - 2.0 * v.wxz * zMxyz - v.wyz * xMx - v.wyz * xyMxy - v.wyz * xyzMxyz - v.wyz * xzMxz + 2.0 * sMxz * v.wxy + 2.0 * v.wxy * xyMyz + 2.0 * v.wxz * xMy + 2.0 * v.wxz * xzMyz + 2.0 * i * v.xyz * yz + 2.0 * s * v.xyz * wx + 2.0 * v.xyz * w * x + 2.0 * v.xyz * wxy * y + 2.0 * v.xyz * wxz * z + 2.0 * v.xyz * wy * xy + 2.0 * v.xyz * wyz * xyz + 2.0 * v.xyz * wz * xz),
      xyz = v.xyz * (sMs + xMx + xyMxy + xyzMxyz + xzMxz + yMy + yzMyz + zMz),
      i = 0.0,
    )

  infix def sandwich(v: Quaternion): Multivector =
    val sMs = s * s
    val sMw = s * w
    val sMx = s * x
    val sMy = s * y
    val sMz = s * z
    val sMwx = s * wx
    val sMwy = s * wy
    val sMwz = s * wz
    val sMxy = s * xy
    val sMxz = s * xz
    val sMyz = s * yz
    val sMwxy = s * wxy
    val sMwxz = s * wxz
    val sMwyz = s * wyz
    val sMi = i * s
    val wMx = w * x
    val wMy = w * y
    val wMz = w * z
    val wMxy = w * xy
    val wMxz = w * xz
    val wMyz = w * yz
    val wMxyz = w * xyz
    val xMx = x * x
    val xMy = x * y
    val xMz = x * z
    val xMwx = wx * x
    val xMwy = wy * x
    val xMwz = wz * x
    val xMxy = x * xy
    val xMxz = x * xz
    val xMwxy = wxy * x
    val xMwxz = wxz * x
    val xMwyz = wyz * x
    val xMxyz = x * xyz
    val xMi = i * x
    val yMy = y * y
    val yMz = y * z
    val yMwx = wx * y
    val yMwy = wy * y
    val yMwz = wz * y
    val yMxy = xy * y
    val yMyz = y * yz
    val yMwxy = wxy * y
    val yMwxz = wxz * y
    val yMwyz = wyz * y
    val yMxyz = xyz * y
    val yMi = i * y
    val zMz = z * z
    val zMwx = wx * z
    val zMwy = wy * z
    val zMwz = wz * z
    val zMxz = xz * z
    val zMyz = yz * z
    val zMwxy = wxy * z
    val zMwxz = wxz * z
    val zMwyz = wyz * z
    val zMxyz = xyz * z
    val zMi = i * z
    val wxMxy = wx * xy
    val wxMxz = wx * xz
    val wxMyz = wx * yz
    val wxMxyz = wx * xyz
    val wyMxy = wy * xy
    val wyMxz = wy * xz
    val wyMyz = wy * yz
    val wyMxyz = wy * xyz
    val wzMxy = wz * xy
    val wzMxz = wz * xz
    val wzMyz = wz * yz
    val wzMxyz = wz * xyz
    val xyMxy = xy * xy
    val xyMxz = xy * xz
    val xyMyz = xy * yz
    val xyMwxy = wxy * xy
    val xyMwxz = wxz * xy
    val xyMwyz = wyz * xy
    val xyMxyz = xy * xyz
    val xyMi = i * xy
    val xzMxz = xz * xz
    val xzMyz = xz * yz
    val xzMwxy = wxy * xz
    val xzMwxz = wxz * xz
    val xzMwyz = wyz * xz
    val xzMxyz = xyz * xz
    val xzMi = i * xz
    val yzMyz = yz * yz
    val yzMwxy = wxy * yz
    val yzMwxz = wxz * yz
    val yzMwyz = wyz * yz
    val yzMxyz = xyz * yz
    val yzMi = i * yz
    val wxyMxyz = wxy * xyz
    val wxzMxyz = wxz * xyz
    val wyzMxyz = wyz * xyz
    val xyzMxyz = xyz * xyz
    val xyzMi = i * xyz
    Multivector(
      s = v.s * (sMs + xMx + xyMxy + xyzMxyz + xzMxz + yMy + yzMyz + zMz),
      w = 2.0 * v.s * (sMw + xMwx + xyMwxy + xyzMi + xzMwxz + yMwy + yzMwyz + zMwz),
      x = 2.0 * v.s * (sMx + yMxy + yzMxyz + zMxz),
      y = v.s * (-2.0 * xMxy - 2.0 * xzMxyz + 2.0 * sMy + 2.0 * zMyz),
      z = v.s * (-2.0 * xMxz - 2.0 * yMyz + 2.0 * sMz + 2.0 * xyMxyz),
      wx = (-2.0 * sMi * v.yz - 2.0 * sMwy * v.xy - 2.0 * sMwz * v.xz - 2.0 * v.xy * xMwxy - 2.0 * v.xy * xzMi - 2.0 * v.xy * zMwyz - 2.0 * v.xz * wxyMxyz - 2.0 * v.xz * wyMyz - 2.0 * v.xz * xMwxz - 2.0 * v.yz * wzMxy - 2.0 * v.yz * xMwyz - 2.0 * v.yz * yMwxz + 2.0 * v.xy * wMy + 2.0 * v.xy * wxMxy + 2.0 * v.xy * wxzMxyz + 2.0 * v.xy * wzMyz + 2.0 * v.xz * wMz + 2.0 * v.xz * wxMxz + 2.0 * v.xz * xyMi + 2.0 * v.xz * yMwyz + 2.0 * v.yz * wMxyz + 2.0 * v.yz * wxMyz + 2.0 * v.yz * wyMxz + 2.0 * v.yz * zMwxy),
      wy = (-2.0 * sMwz * v.yz - 2.0 * v.xy * wMx - 2.0 * v.xy * wzMxz - 2.0 * v.xy * yMwxy - 2.0 * v.xy * yzMi - 2.0 * v.xz * wMxyz - 2.0 * v.xz * xMwyz - 2.0 * v.xz * yMwxz - 2.0 * v.xz * zMwxy - 2.0 * v.yz * wxMxz - 2.0 * v.yz * wxyMxyz - 2.0 * v.yz * yMwyz + 2.0 * sMi * v.xz + 2.0 * sMwx * v.xy + 2.0 * v.xy * wyMxy + 2.0 * v.xy * wyzMxyz + 2.0 * v.xy * zMwxz + 2.0 * v.xz * wxMyz + 2.0 * v.xz * wyMxz + 2.0 * v.xz * wzMxy + 2.0 * v.yz * wMz + 2.0 * v.yz * wyMyz + 2.0 * v.yz * xMwxz + 2.0 * v.yz * xyMi),
      wz = (-2.0 * sMi * v.xy - 2.0 * v.xy * wxMyz - 2.0 * v.xy * yMwxz - 2.0 * v.xy * zMwxy - 2.0 * v.xz * wMx - 2.0 * v.xz * wyMxy - 2.0 * v.xz * yzMi - 2.0 * v.xz * zMwxz - 2.0 * v.yz * wMy - 2.0 * v.yz * wxzMxyz - 2.0 * v.yz * xMwxy - 2.0 * v.yz * zMwyz + 2.0 * sMwx * v.xz + 2.0 * sMwy * v.yz + 2.0 * v.xy * wMxyz + 2.0 * v.xy * wyMxz + 2.0 * v.xy * wzMxy + 2.0 * v.xy * xMwyz + 2.0 * v.xz * wyzMxyz + 2.0 * v.xz * wzMxz + 2.0 * v.xz * yMwxy + 2.0 * v.yz * wxMxy + 2.0 * v.yz * wzMyz + 2.0 * v.yz * xzMi),
      xy = (sMs * v.xy + v.xy * xyMxy + v.xy * xyzMxyz + v.xy * zMz - 2.0 * sMxz * v.yz - 2.0 * v.xz * xMxyz - 2.0 * v.xz * yMz - 2.0 * v.yz * yMxyz - v.xy * xMx - v.xy * xzMxz - v.xy * yMy - v.xy * yzMyz + 2.0 * sMyz * v.xz + 2.0 * v.xz * xyMxz + 2.0 * v.yz * xMz + 2.0 * v.yz * xyMyz),
      xz = (sMs * v.xz + v.xz * xyzMxyz + v.xz * xzMxz + v.xz * yMy - 2.0 * sMyz * v.xy - 2.0 * v.xy * yMz - 2.0 * v.yz * xMy - 2.0 * v.yz * zMxyz - v.xz * xMx - v.xz * xyMxy - v.xz * yzMyz - v.xz * zMz + 2.0 * sMxy * v.yz + 2.0 * v.xy * xMxyz + 2.0 * v.xy * xyMxz + 2.0 * v.yz * xzMyz),
      yz = (sMs * v.yz + v.yz * xMx + v.yz * xyzMxyz + v.yz * yzMyz - 2.0 * sMxy * v.xz - 2.0 * v.xz * xMy - v.yz * xyMxy - v.yz * xzMxz - v.yz * yMy - v.yz * zMz + 2.0 * sMxz * v.xy + 2.0 * v.xy * xMz + 2.0 * v.xy * xyMyz + 2.0 * v.xy * yMxyz + 2.0 * v.xz * xzMyz + 2.0 * v.xz * zMxyz),
      wxy = (-2.0 * sMwxz * v.yz - 2.0 * v.xy * xMwx - 2.0 * v.xy * xzMwxz - 2.0 * v.xy * yMwy - 2.0 * v.xy * yzMwyz - 2.0 * v.xz * wxMxyz - 2.0 * v.xz * xMi - 2.0 * v.xz * yMwz - 2.0 * v.xz * zMwy - 2.0 * v.yz * wMxz - 2.0 * v.yz * wyMxyz - 2.0 * v.yz * yMi + 2.0 * sMw * v.xy + 2.0 * sMwyz * v.xz + 2.0 * v.xy * xyMwxy + 2.0 * v.xy * xyzMi + 2.0 * v.xy * zMwz + 2.0 * v.xz * wMyz + 2.0 * v.xz * xyMwxz + 2.0 * v.xz * xzMwxy + 2.0 * v.yz * xMwz + 2.0 * v.yz * xyMwyz + 2.0 * v.yz * yzMwxy + 2.0 * v.yz * zMwx),
      wxz = (-2.0 * sMwyz * v.xy - 2.0 * v.xy * wMyz - 2.0 * v.xy * yMwz - 2.0 * v.xy * zMwy - 2.0 * v.xz * xMwx - 2.0 * v.xz * xyMwxy - 2.0 * v.xz * yzMwyz - 2.0 * v.xz * zMwz - 2.0 * v.yz * wzMxyz - 2.0 * v.yz * xMwy - 2.0 * v.yz * yMwx - 2.0 * v.yz * zMi + 2.0 * sMw * v.xz + 2.0 * sMwxy * v.yz + 2.0 * v.xy * wxMxyz + 2.0 * v.xy * xMi + 2.0 * v.xy * xyMwxz + 2.0 * v.xy * xzMwxy + 2.0 * v.xz * xyzMi + 2.0 * v.xz * xzMwxz + 2.0 * v.xz * yMwy + 2.0 * v.yz * wMxy + 2.0 * v.yz * xzMwyz + 2.0 * v.yz * yzMwxz),
      wyz = (-2.0 * sMwxy * v.xz - 2.0 * v.xz * wMxy - 2.0 * v.xz * xMwy - 2.0 * v.xz * yMwx - 2.0 * v.yz * xyMwxy - 2.0 * v.yz * xzMwxz - 2.0 * v.yz * yMwy - 2.0 * v.yz * zMwz + 2.0 * sMw * v.yz + 2.0 * sMwxz * v.xy + 2.0 * v.xy * wMxz + 2.0 * v.xy * wyMxyz + 2.0 * v.xy * xMwz + 2.0 * v.xy * xyMwyz + 2.0 * v.xy * yMi + 2.0 * v.xy * yzMwxy + 2.0 * v.xy * zMwx + 2.0 * v.xz * wzMxyz + 2.0 * v.xz * xzMwyz + 2.0 * v.xz * yzMwxz + 2.0 * v.xz * zMi + 2.0 * v.yz * xMwx + 2.0 * v.yz * xyzMi + 2.0 * v.yz * yzMwyz),
      xyz = (-2.0 * sMy * v.xz - 2.0 * v.xz * xMxy - 2.0 * v.yz * yMxy - 2.0 * v.yz * zMxz + 2.0 * sMx * v.yz + 2.0 * sMz * v.xy + 2.0 * v.xy * xMxz + 2.0 * v.xy * xyMxyz + 2.0 * v.xy * yMyz + 2.0 * v.xz * xzMxyz + 2.0 * v.xz * zMyz + 2.0 * v.yz * yzMxyz),
      i = v.s * (-2.0 * wMxyz - 2.0 * wxMyz - 2.0 * wzMxy - 2.0 * yMwxz + 2.0 * sMi + 2.0 * wyMxz + 2.0 * xMwyz + 2.0 * zMwxy),
    )

  infix def sandwich(v: QuaternionDual): Multivector =
    val sMs = s * s
    val sMx = s * x
    val sMy = s * y
    val sMz = s * z
    val sMxy = s * xy
    val sMxz = s * xz
    val sMyz = s * yz
    val sMxyz = s * xyz
    val xMx = x * x
    val xMy = x * y
    val xMz = x * z
    val xMxy = x * xy
    val xMxz = x * xz
    val xMyz = x * yz
    val xMxyz = x * xyz
    val yMy = y * y
    val yMz = y * z
    val yMxy = xy * y
    val yMxz = xz * y
    val yMyz = y * yz
    val yMxyz = xyz * y
    val zMz = z * z
    val zMxy = xy * z
    val zMxz = xz * z
    val zMyz = yz * z
    val zMxyz = xyz * z
    val xyMxy = xy * xy
    val xyMxz = xy * xz
    val xyMyz = xy * yz
    val xyMxyz = xy * xyz
    val xzMxz = xz * xz
    val xzMyz = xz * yz
    val xzMxyz = xyz * xz
    val yzMyz = yz * yz
    val yzMxyz = xyz * yz
    val xyzMxyz = xyz * xyz
    Multivector(
      s = 0.0,
      w = v.i * (-2.0 * xMyz - 2.0 * zMxy + 2.0 * sMxyz + 2.0 * yMxz),
      x = 0.0,
      y = 0.0,
      z = 0.0,
      wx = (sMs * v.wx + v.wx * yMy + v.wx * yzMyz + v.wx * zMz - 2.0 * v.wy * xMy - 2.0 * v.wy * xzMyz - 2.0 * v.wz * xMz - 2.0 * v.wz * yMxyz - v.wx * xMx - v.wx * xyMxy - v.wx * xyzMxyz - v.wx * xzMxz + 2.0 * sMxy * v.wy + 2.0 * sMxz * v.wz + 2.0 * v.wy * zMxyz + 2.0 * v.wz * xyMyz),
      wy = (sMs * v.wy + v.wy * xMx + v.wy * xzMxz + v.wy * zMz - 2.0 * sMxy * v.wx - 2.0 * v.wx * xMy - 2.0 * v.wx * xzMyz - 2.0 * v.wx * zMxyz - 2.0 * v.wz * xyMxz - 2.0 * v.wz * yMz - v.wy * xyMxy - v.wy * xyzMxyz - v.wy * yMy - v.wy * yzMyz + 2.0 * sMyz * v.wz + 2.0 * v.wz * xMxyz),
      wz = (sMs * v.wz + v.wz * xMx + v.wz * xyMxy + v.wz * yMy - 2.0 * sMxz * v.wx - 2.0 * sMyz * v.wy - 2.0 * v.wx * xMz - 2.0 * v.wy * xMxyz - 2.0 * v.wy * xyMxz - 2.0 * v.wy * yMz - v.wz * xyzMxyz - v.wz * xzMxz - v.wz * yzMyz - v.wz * zMz + 2.0 * v.wx * xyMyz + 2.0 * v.wx * yMxyz),
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
      wxy = (-2.0 * sMx * v.wy - 2.0 * sMxyz * v.wz - 2.0 * v.wy * zMxz - 2.0 * v.wz * xMyz + 2.0 * sMy * v.wx + 2.0 * v.wx * xMxy + 2.0 * v.wx * xzMxyz + 2.0 * v.wx * zMyz + 2.0 * v.wy * yMxy + 2.0 * v.wy * yzMxyz + 2.0 * v.wz * yMxz + 2.0 * v.wz * zMxy),
      wxz = (-2.0 * sMx * v.wz - 2.0 * v.wx * xyMxyz - 2.0 * v.wx * yMyz - 2.0 * v.wz * yMxy + 2.0 * sMxyz * v.wy + 2.0 * sMz * v.wx + 2.0 * v.wx * xMxz + 2.0 * v.wy * xMyz + 2.0 * v.wy * yMxz + 2.0 * v.wy * zMxy + 2.0 * v.wz * yzMxyz + 2.0 * v.wz * zMxz),
      wyz = (-2.0 * sMxyz * v.wx - 2.0 * sMy * v.wz - 2.0 * v.wx * zMxy - 2.0 * v.wy * xMxz - 2.0 * v.wy * xyMxyz - 2.0 * v.wz * xzMxyz + 2.0 * sMz * v.wy + 2.0 * v.wx * xMyz + 2.0 * v.wx * yMxz + 2.0 * v.wy * yMyz + 2.0 * v.wz * xMxy + 2.0 * v.wz * zMyz),
      xyz = 0.0,
      i = v.i * (sMs + xyMxy + xzMxz + yzMyz - xMx - xyzMxyz - yMy - zMz),
    )

  infix def sandwich(v: PointIdeal): Multivector =
    val sMs = s * s
    val sMx = s * x
    val sMy = s * y
    val sMz = s * z
    val sMxy = s * xy
    val sMxz = s * xz
    val sMyz = s * yz
    val sMxyz = s * xyz
    val xMx = x * x
    val xMy = x * y
    val xMz = x * z
    val xMxy = x * xy
    val xMxz = x * xz
    val xMyz = x * yz
    val xMxyz = x * xyz
    val yMy = y * y
    val yMz = y * z
    val yMxy = xy * y
    val yMxz = xz * y
    val yMyz = y * yz
    val yMxyz = xyz * y
    val zMz = z * z
    val zMxy = xy * z
    val zMxz = xz * z
    val zMyz = yz * z
    val zMxyz = xyz * z
    val xyMxy = xy * xy
    val xyMxz = xy * xz
    val xyMyz = xy * yz
    val xyMxyz = xy * xyz
    val xzMxz = xz * xz
    val xzMyz = xz * yz
    val xzMxyz = xyz * xz
    val yzMyz = yz * yz
    val yzMxyz = xyz * yz
    val xyzMxyz = xyz * xyz
    Multivector(
      s = 0.0,
      w = 0.0,
      x = 0.0,
      y = 0.0,
      z = 0.0,
      wx = (-2.0 * v.wxy * xMxy - 2.0 * v.wxy * zMyz - 2.0 * v.wxz * xMxz - 2.0 * v.wxz * xyMxyz - 2.0 * v.wyz * xMyz - 2.0 * v.wyz * yMxz + 2.0 * sMxyz * v.wyz + 2.0 * sMy * v.wxy + 2.0 * sMz * v.wxz + 2.0 * v.wxy * xzMxyz + 2.0 * v.wxz * yMyz + 2.0 * v.wyz * zMxy),
      wy = (-2.0 * sMx * v.wxy - 2.0 * sMxyz * v.wxz - 2.0 * v.wxy * yMxy - 2.0 * v.wxz * xMyz - 2.0 * v.wxz * yMxz - 2.0 * v.wxz * zMxy - 2.0 * v.wyz * xyMxyz - 2.0 * v.wyz * yMyz + 2.0 * sMz * v.wyz + 2.0 * v.wxy * yzMxyz + 2.0 * v.wxy * zMxz + 2.0 * v.wyz * xMxz),
      wz = (-2.0 * sMx * v.wxz - 2.0 * sMy * v.wyz - 2.0 * v.wxy * yMxz - 2.0 * v.wxy * zMxy - 2.0 * v.wxz * zMxz - 2.0 * v.wyz * xMxy - 2.0 * v.wyz * xzMxyz - 2.0 * v.wyz * zMyz + 2.0 * sMxyz * v.wxy + 2.0 * v.wxy * xMyz + 2.0 * v.wxz * yMxy + 2.0 * v.wxz * yzMxyz),
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
      wxy = (sMs * v.wxy + v.wxy * xMx + v.wxy * xyMxy + v.wxy * yMy - 2.0 * sMxz * v.wyz - 2.0 * v.wyz * xMz - v.wxy * xyzMxyz - v.wxy * xzMxz - v.wxy * yzMyz - v.wxy * zMz + 2.0 * sMyz * v.wxz + 2.0 * v.wxz * xMxyz + 2.0 * v.wxz * xyMxz + 2.0 * v.wxz * yMz + 2.0 * v.wyz * xyMyz + 2.0 * v.wyz * yMxyz),
      wxz = (sMs * v.wxz + v.wxz * xMx + v.wxz * xzMxz + v.wxz * zMz - 2.0 * sMyz * v.wxy - 2.0 * v.wxy * xMxyz - v.wxz * xyMxy - v.wxz * xyzMxyz - v.wxz * yMy - v.wxz * yzMyz + 2.0 * sMxy * v.wyz + 2.0 * v.wxy * xyMxz + 2.0 * v.wxy * yMz + 2.0 * v.wyz * xMy + 2.0 * v.wyz * xzMyz + 2.0 * v.wyz * zMxyz),
      wyz = (sMs * v.wyz + v.wyz * yMy + v.wyz * yzMyz + v.wyz * zMz - 2.0 * sMxy * v.wxz - 2.0 * v.wxy * xMz - 2.0 * v.wxy * yMxyz - 2.0 * v.wxz * zMxyz - v.wyz * xMx - v.wyz * xyMxy - v.wyz * xyzMxyz - v.wyz * xzMxz + 2.0 * sMxz * v.wxy + 2.0 * v.wxy * xyMyz + 2.0 * v.wxz * xMy + 2.0 * v.wxz * xzMyz),
      xyz = 0.0,
      i = 0.0,
    )

  infix def sandwich(v: PointNormalized): Multivector =
    val sMs = s * s
    val sMx = s * x
    val sMy = s * y
    val sMz = s * z
    val sMxy = s * xy
    val sMxz = s * xz
    val sMyz = s * yz
    val sMxyz = s * xyz
    val xMx = x * x
    val xMy = x * y
    val xMz = x * z
    val xMxy = x * xy
    val xMxz = x * xz
    val xMyz = x * yz
    val xMxyz = x * xyz
    val yMy = y * y
    val yMz = y * z
    val yMxy = xy * y
    val yMxz = xz * y
    val yMyz = y * yz
    val yMxyz = xyz * y
    val zMz = z * z
    val zMxy = xy * z
    val zMxz = xz * z
    val zMyz = yz * z
    val zMxyz = xyz * z
    val xyMxy = xy * xy
    val xyMxz = xy * xz
    val xyMyz = xy * yz
    val xyMxyz = xy * xyz
    val xzMxz = xz * xz
    val xzMyz = xz * yz
    val xzMxyz = xyz * xz
    val yzMyz = yz * yz
    val yzMxyz = xyz * yz
    val xyzMxyz = xyz * xyz
    Multivector(
      s = 0.0,
      w = 0.0,
      x = 0.0,
      y = 0.0,
      z = 0.0,
      wx = (-2.0 * i * x - 2.0 * s * wyz - 2.0 * v.wxy * xMxy - 2.0 * v.wxy * zMyz - 2.0 * v.wxz * xMxz - 2.0 * v.wxz * xyMxyz - 2.0 * v.wyz * xMyz - 2.0 * v.wyz * yMxz - 2.0 * wxy * xz - 2.0 * wy * z + 2.0 * sMxyz * v.wyz + 2.0 * sMy * v.wxy + 2.0 * sMz * v.wxz + 2.0 * v.wxy * xzMxyz + 2.0 * v.wxz * yMyz + 2.0 * v.wyz * zMxy + 2.0 * w * yz + 2.0 * wx * xyz + 2.0 * wxz * xy + 2.0 * wz * y),
      wy = (-2.0 * i * y - 2.0 * sMx * v.wxy - 2.0 * sMxyz * v.wxz - 2.0 * v.wxy * yMxy - 2.0 * v.wxz * xMyz - 2.0 * v.wxz * yMxz - 2.0 * v.wxz * zMxy - 2.0 * v.wyz * xyMxyz - 2.0 * v.wyz * yMyz - 2.0 * w * xz - 2.0 * wxy * yz - 2.0 * wz * x + 2.0 * s * wxz + 2.0 * sMz * v.wyz + 2.0 * v.wxy * yzMxyz + 2.0 * v.wxy * zMxz + 2.0 * v.wyz * xMxz + 2.0 * wx * z + 2.0 * wy * xyz + 2.0 * wyz * xy),
      wz = (-2.0 * i * z - 2.0 * s * wxy - 2.0 * sMx * v.wxz - 2.0 * sMy * v.wyz - 2.0 * v.wxy * yMxz - 2.0 * v.wxy * zMxy - 2.0 * v.wxz * zMxz - 2.0 * v.wyz * xMxy - 2.0 * v.wyz * xzMxyz - 2.0 * v.wyz * zMyz - 2.0 * wx * y - 2.0 * wxz * yz + 2.0 * sMxyz * v.wxy + 2.0 * v.wxy * xMyz + 2.0 * v.wxz * yMxy + 2.0 * v.wxz * yzMxyz + 2.0 * w * xy + 2.0 * wy * x + 2.0 * wyz * xz + 2.0 * wz * xyz),
      xy = (-2.0 * xMxz - 2.0 * yMyz + 2.0 * sMz + 2.0 * xyMxyz),
      xz = (-2.0 * sMy - 2.0 * zMyz + 2.0 * xMxy + 2.0 * xzMxyz),
      yz = 2.0 * (sMx + yMxy + yzMxyz + zMxz),
      wxy = (sMs * v.wxy + v.wxy * xMx + v.wxy * xyMxy + v.wxy * yMy - 2.0 * sMxz * v.wyz - 2.0 * v.wyz * xMz - 2.0 * wx * xz - 2.0 * wxz * x - 2.0 * wy * yz - 2.0 * wyz * y - v.wxy * xyzMxyz - v.wxy * xzMxz - v.wxy * yzMyz - v.wxy * zMz + 2.0 * i * xy + 2.0 * s * wz + 2.0 * sMyz * v.wxz + 2.0 * v.wxz * xMxyz + 2.0 * v.wxz * xyMxz + 2.0 * v.wxz * yMz + 2.0 * v.wyz * xyMyz + 2.0 * v.wyz * yMxyz + 2.0 * w * z + 2.0 * wxy * xyz),
      wxz = (sMs * v.wxz + v.wxz * xMx + v.wxz * xzMxz + v.wxz * zMz - 2.0 * s * wy - 2.0 * sMyz * v.wxy - 2.0 * v.wxy * xMxyz - 2.0 * w * y - 2.0 * wyz * z - 2.0 * wz * yz - v.wxz * xyMxy - v.wxz * xyzMxyz - v.wxz * yMy - v.wxz * yzMyz + 2.0 * i * xz + 2.0 * sMxy * v.wyz + 2.0 * v.wxy * xyMxz + 2.0 * v.wxy * yMz + 2.0 * v.wyz * xMy + 2.0 * v.wyz * xzMyz + 2.0 * v.wyz * zMxyz + 2.0 * wx * xy + 2.0 * wxy * x + 2.0 * wxz * xyz),
      wyz = (sMs * v.wyz + v.wyz * yMy + v.wyz * yzMyz + v.wyz * zMz - 2.0 * sMxy * v.wxz - 2.0 * v.wxy * xMz - 2.0 * v.wxy * yMxyz - 2.0 * v.wxz * zMxyz - v.wyz * xMx - v.wyz * xyMxy - v.wyz * xyzMxyz - v.wyz * xzMxz + 2.0 * i * yz + 2.0 * s * wx + 2.0 * sMxz * v.wxy + 2.0 * v.wxy * xyMyz + 2.0 * v.wxz * xMy + 2.0 * v.wxz * xzMyz + 2.0 * w * x + 2.0 * wxy * y + 2.0 * wxz * z + 2.0 * wy * xy + 2.0 * wyz * xyz + 2.0 * wz * xz),
      xyz = (sMs + xMx + xyMxy + xyzMxyz + xzMxz + yMy + yzMyz + zMz),
      i = 0.0,
    )

  infix def sandwich(v: PlaneIdeal): Multivector =
    val sMs = s * s
    val sMxy = s * xy
    val sMxz = s * xz
    val sMyz = s * yz
    val xMx = x * x
    val xMy = x * y
    val xMz = x * z
    val xMxyz = x * xyz
    val yMy = y * y
    val yMz = y * z
    val yMxyz = xyz * y
    val zMz = z * z
    val zMxyz = xyz * z
    val xyMxy = xy * xy
    val xyMxz = xy * xz
    val xyMyz = xy * yz
    val xzMxz = xz * xz
    val xzMyz = xz * yz
    val yzMyz = yz * yz
    val xyzMxyz = xyz * xyz
    Multivector(
      s = (-2.0 * v.x * xy * y - 2.0 * v.x * xz * z - 2.0 * v.y * xyz * xz - 2.0 * v.y * yz * z + 2.0 * s * v.x * x + 2.0 * s * v.y * y + 2.0 * s * v.z * z + 2.0 * v.x * xyz * yz + 2.0 * v.y * x * xy + 2.0 * v.z * x * xz + 2.0 * v.z * xy * xyz + 2.0 * v.z * y * yz),
      w = (-2.0 * i * v.y * xz - 2.0 * v.x * wxy * y - 2.0 * v.x * wxz * z - 2.0 * v.x * wy * xy - 2.0 * v.x * wz * xz - 2.0 * v.y * wxz * xyz - 2.0 * v.y * wyz * z - 2.0 * v.y * wz * yz + 2.0 * i * v.x * yz + 2.0 * i * v.z * xy + 2.0 * s * v.x * wx + 2.0 * s * v.y * wy + 2.0 * s * v.z * wz + 2.0 * v.x * w * x + 2.0 * v.x * wyz * xyz + 2.0 * v.y * w * y + 2.0 * v.y * wx * xy + 2.0 * v.y * wxy * x + 2.0 * v.z * w * z + 2.0 * v.z * wx * xz + 2.0 * v.z * wxy * xyz + 2.0 * v.z * wxz * x + 2.0 * v.z * wy * yz + 2.0 * v.z * wyz * y),
      x = (sMs * v.x + v.x * xMx + v.x * xyzMxyz + v.x * yzMyz - 2.0 * v.y * xzMyz - 2.0 * v.y * zMxyz - v.x * xyMxy - v.x * xzMxz - v.x * yMy - v.x * zMz + 2.0 * sMxy * v.y + 2.0 * sMxz * v.z + 2.0 * v.y * xMy + 2.0 * v.z * xMz + 2.0 * v.z * xyMyz + 2.0 * v.z * yMxyz),
      y = (sMs * v.y + v.y * xyzMxyz + v.y * xzMxz + v.y * yMy - 2.0 * sMxy * v.x - 2.0 * v.x * xzMyz - 2.0 * v.z * xMxyz - 2.0 * v.z * xyMxz - v.y * xMx - v.y * xyMxy - v.y * yzMyz - v.y * zMz + 2.0 * sMyz * v.z + 2.0 * v.x * xMy + 2.0 * v.x * zMxyz + 2.0 * v.z * yMz),
      z = (sMs * v.z + v.z * xyMxy + v.z * xyzMxyz + v.z * zMz - 2.0 * sMxz * v.x - 2.0 * sMyz * v.y - 2.0 * v.x * yMxyz - 2.0 * v.y * xyMxz - v.z * xMx - v.z * xzMxz - v.z * yMy - v.z * yzMyz + 2.0 * v.x * xMz + 2.0 * v.x * xyMyz + 2.0 * v.y * xMxyz + 2.0 * v.y * yMz),
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
    val sMs = s * s
    val sMw = s * w
    val sMwx = s * wx
    val sMwy = s * wy
    val sMwz = s * wz
    val sMxy = s * xy
    val sMxz = s * xz
    val sMyz = s * yz
    val sMwxy = s * wxy
    val sMwxz = s * wxz
    val sMwyz = s * wyz
    val sMi = i * s
    val wMx = w * x
    val wMy = w * y
    val wMz = w * z
    val wMxy = w * xy
    val wMxz = w * xz
    val wMyz = w * yz
    val wMxyz = w * xyz
    val xMx = x * x
    val xMy = x * y
    val xMz = x * z
    val xMwx = wx * x
    val xMwy = wy * x
    val xMwz = wz * x
    val xMwxy = wxy * x
    val xMwxz = wxz * x
    val xMwyz = wyz * x
    val xMxyz = x * xyz
    val xMi = i * x
    val yMy = y * y
    val yMz = y * z
    val yMwx = wx * y
    val yMwy = wy * y
    val yMwz = wz * y
    val yMwxy = wxy * y
    val yMwxz = wxz * y
    val yMwyz = wyz * y
    val yMxyz = xyz * y
    val yMi = i * y
    val zMz = z * z
    val zMwx = wx * z
    val zMwy = wy * z
    val zMwz = wz * z
    val zMwxy = wxy * z
    val zMwxz = wxz * z
    val zMwyz = wyz * z
    val zMxyz = xyz * z
    val zMi = i * z
    val wxMxy = wx * xy
    val wxMxz = wx * xz
    val wxMyz = wx * yz
    val wxMxyz = wx * xyz
    val wyMxy = wy * xy
    val wyMxz = wy * xz
    val wyMyz = wy * yz
    val wyMxyz = wy * xyz
    val wzMxy = wz * xy
    val wzMxz = wz * xz
    val wzMyz = wz * yz
    val wzMxyz = wz * xyz
    val xyMxy = xy * xy
    val xyMxz = xy * xz
    val xyMyz = xy * yz
    val xyMwxy = wxy * xy
    val xyMwxz = wxz * xy
    val xyMwyz = wyz * xy
    val xyMi = i * xy
    val xzMxz = xz * xz
    val xzMyz = xz * yz
    val xzMwxy = wxy * xz
    val xzMwxz = wxz * xz
    val xzMwyz = wyz * xz
    val xzMi = i * xz
    val yzMyz = yz * yz
    val yzMwxy = wxy * yz
    val yzMwxz = wxz * yz
    val yzMwyz = wyz * yz
    val yzMi = i * yz
    val wxyMxyz = wxy * xyz
    val wxzMxyz = wxz * xyz
    val wyzMxyz = wyz * xyz
    val xyzMxyz = xyz * xyz
    val xyzMi = i * xyz
    Multivector(
      s = 0.0,
      w = 0.0,
      x = 0.0,
      y = 0.0,
      z = 0.0,
      wx = (-2.0 * sMi * v.yz - 2.0 * sMwy * v.xy - 2.0 * sMwz * v.xz - 2.0 * v.xy * xMwxy - 2.0 * v.xy * xzMi - 2.0 * v.xy * zMwyz - 2.0 * v.xz * wxyMxyz - 2.0 * v.xz * wyMyz - 2.0 * v.xz * xMwxz - 2.0 * v.yz * wzMxy - 2.0 * v.yz * xMwyz - 2.0 * v.yz * yMwxz + 2.0 * v.xy * wMy + 2.0 * v.xy * wxMxy + 2.0 * v.xy * wxzMxyz + 2.0 * v.xy * wzMyz + 2.0 * v.xz * wMz + 2.0 * v.xz * wxMxz + 2.0 * v.xz * xyMi + 2.0 * v.xz * yMwyz + 2.0 * v.yz * wMxyz + 2.0 * v.yz * wxMyz + 2.0 * v.yz * wyMxz + 2.0 * v.yz * zMwxy),
      wy = (-2.0 * sMwz * v.yz - 2.0 * v.xy * wMx - 2.0 * v.xy * wzMxz - 2.0 * v.xy * yMwxy - 2.0 * v.xy * yzMi - 2.0 * v.xz * wMxyz - 2.0 * v.xz * xMwyz - 2.0 * v.xz * yMwxz - 2.0 * v.xz * zMwxy - 2.0 * v.yz * wxMxz - 2.0 * v.yz * wxyMxyz - 2.0 * v.yz * yMwyz + 2.0 * sMi * v.xz + 2.0 * sMwx * v.xy + 2.0 * v.xy * wyMxy + 2.0 * v.xy * wyzMxyz + 2.0 * v.xy * zMwxz + 2.0 * v.xz * wxMyz + 2.0 * v.xz * wyMxz + 2.0 * v.xz * wzMxy + 2.0 * v.yz * wMz + 2.0 * v.yz * wyMyz + 2.0 * v.yz * xMwxz + 2.0 * v.yz * xyMi),
      wz = (-2.0 * sMi * v.xy - 2.0 * v.xy * wxMyz - 2.0 * v.xy * yMwxz - 2.0 * v.xy * zMwxy - 2.0 * v.xz * wMx - 2.0 * v.xz * wyMxy - 2.0 * v.xz * yzMi - 2.0 * v.xz * zMwxz - 2.0 * v.yz * wMy - 2.0 * v.yz * wxzMxyz - 2.0 * v.yz * xMwxy - 2.0 * v.yz * zMwyz + 2.0 * sMwx * v.xz + 2.0 * sMwy * v.yz + 2.0 * v.xy * wMxyz + 2.0 * v.xy * wyMxz + 2.0 * v.xy * wzMxy + 2.0 * v.xy * xMwyz + 2.0 * v.xz * wyzMxyz + 2.0 * v.xz * wzMxz + 2.0 * v.xz * yMwxy + 2.0 * v.yz * wxMxy + 2.0 * v.yz * wzMyz + 2.0 * v.yz * xzMi),
      xy = (sMs * v.xy + v.xy * xyMxy + v.xy * xyzMxyz + v.xy * zMz - 2.0 * sMxz * v.yz - 2.0 * v.xz * xMxyz - 2.0 * v.xz * yMz - 2.0 * v.yz * yMxyz - v.xy * xMx - v.xy * xzMxz - v.xy * yMy - v.xy * yzMyz + 2.0 * sMyz * v.xz + 2.0 * v.xz * xyMxz + 2.0 * v.yz * xMz + 2.0 * v.yz * xyMyz),
      xz = (sMs * v.xz + v.xz * xyzMxyz + v.xz * xzMxz + v.xz * yMy - 2.0 * sMyz * v.xy - 2.0 * v.xy * yMz - 2.0 * v.yz * xMy - 2.0 * v.yz * zMxyz - v.xz * xMx - v.xz * xyMxy - v.xz * yzMyz - v.xz * zMz + 2.0 * sMxy * v.yz + 2.0 * v.xy * xMxyz + 2.0 * v.xy * xyMxz + 2.0 * v.yz * xzMyz),
      yz = (sMs * v.yz + v.yz * xMx + v.yz * xyzMxyz + v.yz * yzMyz - 2.0 * sMxy * v.xz - 2.0 * v.xz * xMy - v.yz * xyMxy - v.yz * xzMxz - v.yz * yMy - v.yz * zMz + 2.0 * sMxz * v.xy + 2.0 * v.xy * xMz + 2.0 * v.xy * xyMyz + 2.0 * v.xy * yMxyz + 2.0 * v.xz * xzMyz + 2.0 * v.xz * zMxyz),
      wxy = (-2.0 * sMwxz * v.yz - 2.0 * v.xy * xMwx - 2.0 * v.xy * xzMwxz - 2.0 * v.xy * yMwy - 2.0 * v.xy * yzMwyz - 2.0 * v.xz * wxMxyz - 2.0 * v.xz * xMi - 2.0 * v.xz * yMwz - 2.0 * v.xz * zMwy - 2.0 * v.yz * wMxz - 2.0 * v.yz * wyMxyz - 2.0 * v.yz * yMi + 2.0 * sMw * v.xy + 2.0 * sMwyz * v.xz + 2.0 * v.xy * xyMwxy + 2.0 * v.xy * xyzMi + 2.0 * v.xy * zMwz + 2.0 * v.xz * wMyz + 2.0 * v.xz * xyMwxz + 2.0 * v.xz * xzMwxy + 2.0 * v.yz * xMwz + 2.0 * v.yz * xyMwyz + 2.0 * v.yz * yzMwxy + 2.0 * v.yz * zMwx),
      wxz = (-2.0 * sMwyz * v.xy - 2.0 * v.xy * wMyz - 2.0 * v.xy * yMwz - 2.0 * v.xy * zMwy - 2.0 * v.xz * xMwx - 2.0 * v.xz * xyMwxy - 2.0 * v.xz * yzMwyz - 2.0 * v.xz * zMwz - 2.0 * v.yz * wzMxyz - 2.0 * v.yz * xMwy - 2.0 * v.yz * yMwx - 2.0 * v.yz * zMi + 2.0 * sMw * v.xz + 2.0 * sMwxy * v.yz + 2.0 * v.xy * wxMxyz + 2.0 * v.xy * xMi + 2.0 * v.xy * xyMwxz + 2.0 * v.xy * xzMwxy + 2.0 * v.xz * xyzMi + 2.0 * v.xz * xzMwxz + 2.0 * v.xz * yMwy + 2.0 * v.yz * wMxy + 2.0 * v.yz * xzMwyz + 2.0 * v.yz * yzMwxz),
      wyz = (-2.0 * sMwxy * v.xz - 2.0 * v.xz * wMxy - 2.0 * v.xz * xMwy - 2.0 * v.xz * yMwx - 2.0 * v.yz * xyMwxy - 2.0 * v.yz * xzMwxz - 2.0 * v.yz * yMwy - 2.0 * v.yz * zMwz + 2.0 * sMw * v.yz + 2.0 * sMwxz * v.xy + 2.0 * v.xy * wMxz + 2.0 * v.xy * wyMxyz + 2.0 * v.xy * xMwz + 2.0 * v.xy * xyMwyz + 2.0 * v.xy * yMi + 2.0 * v.xy * yzMwxy + 2.0 * v.xy * zMwx + 2.0 * v.xz * wzMxyz + 2.0 * v.xz * xzMwyz + 2.0 * v.xz * yzMwxz + 2.0 * v.xz * zMi + 2.0 * v.yz * xMwx + 2.0 * v.yz * xyzMi + 2.0 * v.yz * yzMwyz),
      xyz = (-2.0 * s * v.xz * y - 2.0 * v.xz * x * xy - 2.0 * v.yz * xy * y - 2.0 * v.yz * xz * z + 2.0 * s * v.xy * z + 2.0 * s * v.yz * x + 2.0 * v.xy * x * xz + 2.0 * v.xy * xy * xyz + 2.0 * v.xy * y * yz + 2.0 * v.xz * xyz * xz + 2.0 * v.xz * yz * z + 2.0 * v.yz * xyz * yz),
      i = 0.0,
    )

  infix def sandwich(v: BivectorWeight): Multivector =
    val sMs = s * s
    val sMx = s * x
    val sMy = s * y
    val sMz = s * z
    val sMxy = s * xy
    val sMxz = s * xz
    val sMyz = s * yz
    val sMxyz = s * xyz
    val xMx = x * x
    val xMy = x * y
    val xMz = x * z
    val xMxy = x * xy
    val xMxz = x * xz
    val xMyz = x * yz
    val xMxyz = x * xyz
    val yMy = y * y
    val yMz = y * z
    val yMxy = xy * y
    val yMxz = xz * y
    val yMyz = y * yz
    val yMxyz = xyz * y
    val zMz = z * z
    val zMxy = xy * z
    val zMxz = xz * z
    val zMyz = yz * z
    val zMxyz = xyz * z
    val xyMxy = xy * xy
    val xyMxz = xy * xz
    val xyMyz = xy * yz
    val xyMxyz = xy * xyz
    val xzMxz = xz * xz
    val xzMyz = xz * yz
    val xzMxyz = xyz * xz
    val yzMyz = yz * yz
    val yzMxyz = xyz * yz
    val xyzMxyz = xyz * xyz
    Multivector(
      s = 0.0,
      w = 0.0,
      x = 0.0,
      y = 0.0,
      z = 0.0,
      wx = (sMs * v.wx + v.wx * yMy + v.wx * yzMyz + v.wx * zMz - 2.0 * v.wy * xMy - 2.0 * v.wy * xzMyz - 2.0 * v.wz * xMz - 2.0 * v.wz * yMxyz - v.wx * xMx - v.wx * xyMxy - v.wx * xyzMxyz - v.wx * xzMxz + 2.0 * sMxy * v.wy + 2.0 * sMxz * v.wz + 2.0 * v.wy * zMxyz + 2.0 * v.wz * xyMyz),
      wy = (sMs * v.wy + v.wy * xMx + v.wy * xzMxz + v.wy * zMz - 2.0 * sMxy * v.wx - 2.0 * v.wx * xMy - 2.0 * v.wx * xzMyz - 2.0 * v.wx * zMxyz - 2.0 * v.wz * xyMxz - 2.0 * v.wz * yMz - v.wy * xyMxy - v.wy * xyzMxyz - v.wy * yMy - v.wy * yzMyz + 2.0 * sMyz * v.wz + 2.0 * v.wz * xMxyz),
      wz = (sMs * v.wz + v.wz * xMx + v.wz * xyMxy + v.wz * yMy - 2.0 * sMxz * v.wx - 2.0 * sMyz * v.wy - 2.0 * v.wx * xMz - 2.0 * v.wy * xMxyz - 2.0 * v.wy * xyMxz - 2.0 * v.wy * yMz - v.wz * xyzMxyz - v.wz * xzMxz - v.wz * yzMyz - v.wz * zMz + 2.0 * v.wx * xyMyz + 2.0 * v.wx * yMxyz),
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
      wxy = (-2.0 * sMx * v.wy - 2.0 * sMxyz * v.wz - 2.0 * v.wy * zMxz - 2.0 * v.wz * xMyz + 2.0 * sMy * v.wx + 2.0 * v.wx * xMxy + 2.0 * v.wx * xzMxyz + 2.0 * v.wx * zMyz + 2.0 * v.wy * yMxy + 2.0 * v.wy * yzMxyz + 2.0 * v.wz * yMxz + 2.0 * v.wz * zMxy),
      wxz = (-2.0 * sMx * v.wz - 2.0 * v.wx * xyMxyz - 2.0 * v.wx * yMyz - 2.0 * v.wz * yMxy + 2.0 * sMxyz * v.wy + 2.0 * sMz * v.wx + 2.0 * v.wx * xMxz + 2.0 * v.wy * xMyz + 2.0 * v.wy * yMxz + 2.0 * v.wy * zMxy + 2.0 * v.wz * yzMxyz + 2.0 * v.wz * zMxz),
      wyz = (-2.0 * sMxyz * v.wx - 2.0 * sMy * v.wz - 2.0 * v.wx * zMxy - 2.0 * v.wy * xMxz - 2.0 * v.wy * xyMxyz - 2.0 * v.wz * xzMxyz + 2.0 * sMz * v.wy + 2.0 * v.wx * xMyz + 2.0 * v.wx * yMxz + 2.0 * v.wy * yMyz + 2.0 * v.wz * xMxy + 2.0 * v.wz * zMyz),
      xyz = 0.0,
      i = 0.0,
    )

  infix def sandwich(v: PseudoScalar): Multivector =
    Multivector(
      s = 0.0,
      w = v.i * (-2.0 * x * yz - 2.0 * xy * z + 2.0 * s * xyz + 2.0 * xz * y),
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
      i = v.i * (s * s + xy * xy + xz * xz + yz * yz - x * x - xyz * xyz - y * y - z * z),
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
      yz = 2.0 * (s * x + xy * y + xyz * yz + xz * z),
      wxy = (-2.0 * wx * xz - 2.0 * wxz * x - 2.0 * wy * yz - 2.0 * wyz * y + 2.0 * i * xy + 2.0 * s * wz + 2.0 * w * z + 2.0 * wxy * xyz),
      wxz = (-2.0 * s * wy - 2.0 * w * y - 2.0 * wyz * z - 2.0 * wz * yz + 2.0 * i * xz + 2.0 * wx * xy + 2.0 * wxy * x + 2.0 * wxz * xyz),
      wyz = 2.0 * (i * yz + s * wx + w * x + wxy * y + wxz * z + wy * xy + wyz * xyz + wz * xz),
      xyz = (s * s + x * x + xy * xy + xyz * xyz + xz * xz + y * y + yz * yz + z * z),
      i = 0.0,
    )

  infix def reverseSandwich(v: Multivector): Multivector =
    val sMs = s * s
    val sMw = s * w
    val sMx = s * x
    val sMy = s * y
    val sMz = s * z
    val sMwx = s * wx
    val sMwy = s * wy
    val sMwz = s * wz
    val sMxy = s * xy
    val sMxz = s * xz
    val sMyz = s * yz
    val sMwxy = s * wxy
    val sMwxz = s * wxz
    val sMwyz = s * wyz
    val sMxyz = s * xyz
    val sMi = i * s
    val wMx = w * x
    val wMy = w * y
    val wMz = w * z
    val wMxy = w * xy
    val wMxz = w * xz
    val wMyz = w * yz
    val wMxyz = w * xyz
    val xMx = x * x
    val xMy = x * y
    val xMz = x * z
    val xMwx = wx * x
    val xMwy = wy * x
    val xMwz = wz * x
    val xMxy = x * xy
    val xMxz = x * xz
    val xMyz = x * yz
    val xMwxy = wxy * x
    val xMwxz = wxz * x
    val xMwyz = wyz * x
    val xMxyz = x * xyz
    val xMi = i * x
    val yMy = y * y
    val yMz = y * z
    val yMwx = wx * y
    val yMwy = wy * y
    val yMwz = wz * y
    val yMxy = xy * y
    val yMxz = xz * y
    val yMyz = y * yz
    val yMwxy = wxy * y
    val yMwxz = wxz * y
    val yMwyz = wyz * y
    val yMxyz = xyz * y
    val yMi = i * y
    val zMz = z * z
    val zMwx = wx * z
    val zMwy = wy * z
    val zMwz = wz * z
    val zMxy = xy * z
    val zMxz = xz * z
    val zMyz = yz * z
    val zMwxy = wxy * z
    val zMwxz = wxz * z
    val zMwyz = wyz * z
    val zMxyz = xyz * z
    val zMi = i * z
    val wxMxy = wx * xy
    val wxMxz = wx * xz
    val wxMyz = wx * yz
    val wxMxyz = wx * xyz
    val wyMxy = wy * xy
    val wyMxz = wy * xz
    val wyMyz = wy * yz
    val wyMxyz = wy * xyz
    val wzMxy = wz * xy
    val wzMxz = wz * xz
    val wzMyz = wz * yz
    val wzMxyz = wz * xyz
    val xyMxy = xy * xy
    val xyMxz = xy * xz
    val xyMyz = xy * yz
    val xyMwxy = wxy * xy
    val xyMwxz = wxz * xy
    val xyMwyz = wyz * xy
    val xyMxyz = xy * xyz
    val xyMi = i * xy
    val xzMxz = xz * xz
    val xzMyz = xz * yz
    val xzMwxy = wxy * xz
    val xzMwxz = wxz * xz
    val xzMwyz = wyz * xz
    val xzMxyz = xyz * xz
    val xzMi = i * xz
    val yzMyz = yz * yz
    val yzMwxy = wxy * yz
    val yzMwxz = wxz * yz
    val yzMwyz = wyz * yz
    val yzMxyz = xyz * yz
    val yzMi = i * yz
    val wxyMxyz = wxy * xyz
    val wxzMxyz = wxz * xyz
    val wyzMxyz = wyz * xyz
    val xyzMxyz = xyz * xyz
    val xyzMi = i * xyz
    Multivector(
      s = (sMs * v.s + v.s * xMx + v.s * xyMxy + v.s * xyzMxyz + v.s * xzMxz + v.s * yMy + v.s * yzMyz + v.s * zMz - 2.0 * v.y * xMxy - 2.0 * v.y * xzMxyz - 2.0 * v.z * xMxz - 2.0 * v.z * yMyz + 2.0 * sMx * v.x + 2.0 * sMy * v.y + 2.0 * sMz * v.z + 2.0 * v.x * yMxy + 2.0 * v.x * yzMxyz + 2.0 * v.x * zMxz + 2.0 * v.y * zMyz + 2.0 * v.z * xyMxyz),
      w = (sMs * v.w + v.w * xyMxy + v.w * xzMxz + v.w * yzMyz - 2.0 * sMwx * v.x - 2.0 * sMwy * v.y - 2.0 * sMwz * v.z - 2.0 * sMxyz * v.i - 2.0 * v.i * yMxz - 2.0 * v.s * xMwx - 2.0 * v.s * xyzMi - 2.0 * v.s * yMwy - 2.0 * v.s * zMwz - 2.0 * v.x * wyMxy - 2.0 * v.x * wzMxz - 2.0 * v.x * yzMi - 2.0 * v.y * wxzMxyz - 2.0 * v.y * wzMyz - 2.0 * v.y * xMwxy - 2.0 * v.z * xMwxz - 2.0 * v.z * xyMi - 2.0 * v.z * yMwyz - v.w * xMx - v.w * xyzMxyz - v.w * yMy - v.w * zMz + 2.0 * sMw * v.s + 2.0 * v.i * xMyz + 2.0 * v.i * zMxy + 2.0 * v.s * xyMwxy + 2.0 * v.s * xzMwxz + 2.0 * v.s * yzMwyz + 2.0 * v.x * wMx + 2.0 * v.x * wyzMxyz + 2.0 * v.x * yMwxy + 2.0 * v.x * zMwxz + 2.0 * v.y * wMy + 2.0 * v.y * wxMxy + 2.0 * v.y * xzMi + 2.0 * v.y * zMwyz + 2.0 * v.z * wMz + 2.0 * v.z * wxMxz + 2.0 * v.z * wxyMxyz + 2.0 * v.z * wyMyz),
      x = (sMs * v.x + v.x * xMx + v.x * xyzMxyz + v.x * yzMyz - 2.0 * sMxy * v.y - 2.0 * sMxz * v.z - 2.0 * v.s * yMxy - 2.0 * v.s * zMxz - 2.0 * v.y * xzMyz - 2.0 * v.z * yMxyz - v.x * xyMxy - v.x * xzMxz - v.x * yMy - v.x * zMz + 2.0 * sMx * v.s + 2.0 * v.s * yzMxyz + 2.0 * v.y * xMy + 2.0 * v.y * zMxyz + 2.0 * v.z * xMz + 2.0 * v.z * xyMyz),
      y = (sMs * v.y + v.y * xyzMxyz + v.y * xzMxz + v.y * yMy - 2.0 * sMyz * v.z - 2.0 * v.s * xzMxyz - 2.0 * v.s * zMyz - 2.0 * v.x * xzMyz - 2.0 * v.x * zMxyz - 2.0 * v.z * xyMxz - v.y * xMx - v.y * xyMxy - v.y * yzMyz - v.y * zMz + 2.0 * sMxy * v.x + 2.0 * sMy * v.s + 2.0 * v.s * xMxy + 2.0 * v.x * xMy + 2.0 * v.z * xMxyz + 2.0 * v.z * yMz),
      z = (sMs * v.z + v.z * xyMxy + v.z * xyzMxyz + v.z * zMz - 2.0 * v.y * xMxyz - 2.0 * v.y * xyMxz - v.z * xMx - v.z * xzMxz - v.z * yMy - v.z * yzMyz + 2.0 * sMxz * v.x + 2.0 * sMyz * v.y + 2.0 * sMz * v.s + 2.0 * v.s * xMxz + 2.0 * v.s * xyMxyz + 2.0 * v.s * yMyz + 2.0 * v.x * xMz + 2.0 * v.x * xyMyz + 2.0 * v.x * yMxyz + 2.0 * v.y * yMz),
      wx = (sMs * v.wx + v.wx * yMy + v.wx * yzMyz + v.wx * zMz - 2.0 * sMi * v.yz - 2.0 * sMxy * v.wy - 2.0 * sMxyz * v.wyz - 2.0 * sMxz * v.wz - 2.0 * v.wxz * xyMxyz - 2.0 * v.wxz * yMyz - 2.0 * v.wy * xMy - 2.0 * v.wy * xzMyz - 2.0 * v.wy * zMxyz - 2.0 * v.wyz * zMxy - 2.0 * v.wz * xMz - 2.0 * v.xyz * wMyz - 2.0 * v.xyz * xMi - 2.0 * v.xyz * xzMwxy - 2.0 * v.xyz * yMwz - 2.0 * v.xz * wxyMxyz - 2.0 * v.xz * wyMyz - 2.0 * v.xz * xyMi - 2.0 * v.xz * yMwyz - 2.0 * v.yz * wMxyz - 2.0 * v.yz * wzMxy - 2.0 * v.yz * zMwxy - v.wx * xMx - v.wx * xyMxy - v.wx * xyzMxyz - v.wx * xzMxz + 2.0 * sMwy * v.xy + 2.0 * sMwyz * v.xyz + 2.0 * sMwz * v.xz + 2.0 * sMy * v.wxy + 2.0 * sMz * v.wxz + 2.0 * v.wxy * xMxy + 2.0 * v.wxy * xzMxyz + 2.0 * v.wxy * zMyz + 2.0 * v.wxz * xMxz + 2.0 * v.wyz * xMyz + 2.0 * v.wyz * yMxz + 2.0 * v.wz * xyMyz + 2.0 * v.wz * yMxyz + 2.0 * v.xy * wMy + 2.0 * v.xy * wxMxy + 2.0 * v.xy * wxzMxyz + 2.0 * v.xy * wzMyz + 2.0 * v.xy * xMwxy + 2.0 * v.xy * xzMi + 2.0 * v.xy * zMwyz + 2.0 * v.xyz * wxMxyz + 2.0 * v.xyz * xyMwxz + 2.0 * v.xyz * zMwy + 2.0 * v.xz * wMz + 2.0 * v.xz * wxMxz + 2.0 * v.xz * xMwxz + 2.0 * v.yz * wxMyz + 2.0 * v.yz * wyMxz + 2.0 * v.yz * xMwyz + 2.0 * v.yz * yMwxz),
      wy = (sMs * v.wy + v.wy * xMx + v.wy * xzMxz + v.wy * zMz - 2.0 * sMwx * v.xy - 2.0 * sMwxz * v.xyz - 2.0 * sMx * v.wxy - 2.0 * sMyz * v.wz - 2.0 * v.wx * xMy - 2.0 * v.wx * xzMyz - 2.0 * v.wxy * zMxz - 2.0 * v.wyz * xMxz - 2.0 * v.wyz * xyMxyz - 2.0 * v.wz * xMxyz - 2.0 * v.wz * xyMxz - 2.0 * v.wz * yMz - 2.0 * v.xy * wMx - 2.0 * v.xy * wzMxz - 2.0 * v.xy * zMwxz - 2.0 * v.xyz * yMi - 2.0 * v.xyz * yzMwxy - 2.0 * v.xyz * zMwx - 2.0 * v.yz * wxMxz - 2.0 * v.yz * wxyMxyz - 2.0 * v.yz * xMwxz - 2.0 * v.yz * xyMi - v.wy * xyMxy - v.wy * xyzMxyz - v.wy * yMy - v.wy * yzMyz + 2.0 * sMi * v.xz + 2.0 * sMwz * v.yz + 2.0 * sMxy * v.wx + 2.0 * sMxyz * v.wxz + 2.0 * sMz * v.wyz + 2.0 * v.wx * zMxyz + 2.0 * v.wxy * yMxy + 2.0 * v.wxy * yzMxyz + 2.0 * v.wxz * xMyz + 2.0 * v.wxz * yMxz + 2.0 * v.wxz * zMxy + 2.0 * v.wyz * yMyz + 2.0 * v.xy * wyMxy + 2.0 * v.xy * wyzMxyz + 2.0 * v.xy * yMwxy + 2.0 * v.xy * yzMi + 2.0 * v.xyz * wMxz + 2.0 * v.xyz * wyMxyz + 2.0 * v.xyz * xMwz + 2.0 * v.xyz * xyMwyz + 2.0 * v.xz * wMxyz + 2.0 * v.xz * wxMyz + 2.0 * v.xz * wyMxz + 2.0 * v.xz * wzMxy + 2.0 * v.xz * xMwyz + 2.0 * v.xz * yMwxz + 2.0 * v.xz * zMwxy + 2.0 * v.yz * wMz + 2.0 * v.yz * wyMyz + 2.0 * v.yz * yMwyz),
      wz = (sMs * v.wz + v.wz * xMx + v.wz * xyMxy + v.wz * yMy - 2.0 * sMi * v.xy - 2.0 * sMwx * v.xz - 2.0 * sMwy * v.yz - 2.0 * sMx * v.wxz - 2.0 * sMxyz * v.wxy - 2.0 * sMy * v.wyz - 2.0 * v.wx * xMz - 2.0 * v.wx * yMxyz - 2.0 * v.wxy * xMyz - 2.0 * v.wxz * yMxy - 2.0 * v.wy * xyMxz - 2.0 * v.wy * yMz - 2.0 * v.wyz * xzMxyz - 2.0 * v.xy * wMxyz - 2.0 * v.xy * wxMyz - 2.0 * v.xy * xMwyz - 2.0 * v.xyz * wMxy - 2.0 * v.xyz * xMwy - 2.0 * v.xyz * yzMwxz - 2.0 * v.xyz * zMi - 2.0 * v.xz * wMx - 2.0 * v.xz * wyMxy - 2.0 * v.xz * yMwxy - 2.0 * v.yz * wMy - 2.0 * v.yz * wxzMxyz - 2.0 * v.yz * xzMi - v.wz * xyzMxyz - v.wz * xzMxz - v.wz * yzMyz - v.wz * zMz + 2.0 * sMwxy * v.xyz + 2.0 * sMxz * v.wx + 2.0 * sMyz * v.wy + 2.0 * v.wx * xyMyz + 2.0 * v.wxy * yMxz + 2.0 * v.wxy * zMxy + 2.0 * v.wxz * yzMxyz + 2.0 * v.wxz * zMxz + 2.0 * v.wy * xMxyz + 2.0 * v.wyz * xMxy + 2.0 * v.wyz * zMyz + 2.0 * v.xy * wyMxz + 2.0 * v.xy * wzMxy + 2.0 * v.xy * yMwxz + 2.0 * v.xy * zMwxy + 2.0 * v.xyz * wzMxyz + 2.0 * v.xyz * xzMwyz + 2.0 * v.xyz * yMwx + 2.0 * v.xz * wyzMxyz + 2.0 * v.xz * wzMxz + 2.0 * v.xz * yzMi + 2.0 * v.xz * zMwxz + 2.0 * v.yz * wxMxy + 2.0 * v.yz * wzMyz + 2.0 * v.yz * xMwxy + 2.0 * v.yz * zMwyz),
      xy = (sMs * v.xy + v.xy * xyMxy + v.xy * xyzMxyz + v.xy * zMz - 2.0 * sMyz * v.xz - 2.0 * v.xz * yMz - v.xy * xMx - v.xy * xzMxz - v.xy * yMy - v.xy * yzMyz + 2.0 * sMxz * v.yz + 2.0 * sMz * v.xyz + 2.0 * v.xyz * xMxz + 2.0 * v.xyz * xyMxyz + 2.0 * v.xyz * yMyz + 2.0 * v.xz * xMxyz + 2.0 * v.xz * xyMxz + 2.0 * v.yz * xMz + 2.0 * v.yz * xyMyz + 2.0 * v.yz * yMxyz),
      xz = (sMs * v.xz + v.xz * xyzMxyz + v.xz * xzMxz + v.xz * yMy - 2.0 * sMxy * v.yz - 2.0 * sMy * v.xyz - 2.0 * v.xy * xMxyz - 2.0 * v.xy * yMz - 2.0 * v.xyz * xMxy - 2.0 * v.yz * xMy - v.xz * xMx - v.xz * xyMxy - v.xz * yzMyz - v.xz * zMz + 2.0 * sMyz * v.xy + 2.0 * v.xy * xyMxz + 2.0 * v.xyz * xzMxyz + 2.0 * v.xyz * zMyz + 2.0 * v.yz * xzMyz + 2.0 * v.yz * zMxyz),
      yz = (sMs * v.yz + v.yz * xMx + v.yz * xyzMxyz + v.yz * yzMyz - 2.0 * sMxz * v.xy - 2.0 * v.xy * yMxyz - 2.0 * v.xyz * yMxy - 2.0 * v.xyz * zMxz - 2.0 * v.xz * xMy - 2.0 * v.xz * zMxyz - v.yz * xyMxy - v.yz * xzMxz - v.yz * yMy - v.yz * zMz + 2.0 * sMx * v.xyz + 2.0 * sMxy * v.xz + 2.0 * v.xy * xMz + 2.0 * v.xy * xyMyz + 2.0 * v.xyz * yzMxyz + 2.0 * v.xz * xzMyz),
      wxy = (sMs * v.wxy + v.wxy * xMx + v.wxy * xyMxy + v.wxy * yMy - 2.0 * sMwyz * v.xz - 2.0 * sMwz * v.xyz - 2.0 * sMx * v.wy - 2.0 * sMyz * v.wxz - 2.0 * v.wx * xMxy - 2.0 * v.wx * zMyz - 2.0 * v.wxz * xMxyz - 2.0 * v.wy * yMxy - 2.0 * v.wyz * xMz - 2.0 * v.wyz * yMxyz - 2.0 * v.wz * yMxz - 2.0 * v.wz * zMxy - 2.0 * v.xy * xyzMi - 2.0 * v.xy * xzMwxz - 2.0 * v.xy * yzMwyz - 2.0 * v.xy * zMwz - 2.0 * v.xyz * wxMxz - 2.0 * v.xyz * wyMyz - 2.0 * v.xyz * xyMi - 2.0 * v.xz * wMyz - 2.0 * v.xz * wxMxyz - 2.0 * v.xz * xMi - 2.0 * v.yz * wyMxyz - 2.0 * v.yz * xMwz - 2.0 * v.yz * yMi - 2.0 * v.yz * zMwx - v.wxy * xyzMxyz - v.wxy * xzMxz - v.wxy * yzMyz - v.wxy * zMz + 2.0 * sMw * v.xy + 2.0 * sMwxz * v.yz + 2.0 * sMxyz * v.wz + 2.0 * sMxz * v.wyz + 2.0 * sMy * v.wx + 2.0 * v.wx * xzMxyz + 2.0 * v.wxz * xyMxz + 2.0 * v.wxz * yMz + 2.0 * v.wy * yzMxyz + 2.0 * v.wy * zMxz + 2.0 * v.wyz * xyMyz + 2.0 * v.wz * xMyz + 2.0 * v.xy * xMwx + 2.0 * v.xy * xyMwxy + 2.0 * v.xy * yMwy + 2.0 * v.xyz * wMz + 2.0 * v.xyz * wxyMxyz + 2.0 * v.xyz * xMwxz + 2.0 * v.xyz * yMwyz + 2.0 * v.xz * xyMwxz + 2.0 * v.xz * xzMwxy + 2.0 * v.xz * yMwz + 2.0 * v.xz * zMwy + 2.0 * v.yz * wMxz + 2.0 * v.yz * xyMwyz + 2.0 * v.yz * yzMwxy),
      wxz = (sMs * v.wxz + v.wxz * xMx + v.wxz * xzMxz + v.wxz * zMz - 2.0 * sMwxy * v.yz - 2.0 * sMx * v.wz - 2.0 * sMxy * v.wyz - 2.0 * sMxyz * v.wy - 2.0 * v.wx * xMxz - 2.0 * v.wx * xyMxyz - 2.0 * v.wy * xMyz - 2.0 * v.wy * yMxz - 2.0 * v.wy * zMxy - 2.0 * v.wyz * zMxyz - 2.0 * v.wz * zMxz - 2.0 * v.xyz * wMy - 2.0 * v.xyz * wzMyz - 2.0 * v.xyz * xMwxy - 2.0 * v.xyz * xzMi - 2.0 * v.xz * xyMwxy - 2.0 * v.xz * xyzMi - 2.0 * v.xz * yMwy - 2.0 * v.xz * yzMwyz - 2.0 * v.yz * wMxy - 2.0 * v.yz * wzMxyz - 2.0 * v.yz * zMi - v.wxz * xyMxy - v.wxz * xyzMxyz - v.wxz * yMy - v.wxz * yzMyz + 2.0 * sMw * v.xz + 2.0 * sMwy * v.xyz + 2.0 * sMwyz * v.xy + 2.0 * sMyz * v.wxy + 2.0 * sMz * v.wx + 2.0 * v.wx * yMyz + 2.0 * v.wxy * xMxyz + 2.0 * v.wxy * xyMxz + 2.0 * v.wxy * yMz + 2.0 * v.wyz * xMy + 2.0 * v.wyz * xzMyz + 2.0 * v.wz * yMxy + 2.0 * v.wz * yzMxyz + 2.0 * v.xy * wMyz + 2.0 * v.xy * wxMxyz + 2.0 * v.xy * xMi + 2.0 * v.xy * xyMwxz + 2.0 * v.xy * xzMwxy + 2.0 * v.xy * yMwz + 2.0 * v.xy * zMwy + 2.0 * v.xyz * wxMxy + 2.0 * v.xyz * wxzMxyz + 2.0 * v.xyz * zMwyz + 2.0 * v.xz * xMwx + 2.0 * v.xz * xzMwxz + 2.0 * v.xz * zMwz + 2.0 * v.yz * xMwy + 2.0 * v.yz * xzMwyz + 2.0 * v.yz * yMwx + 2.0 * v.yz * yzMwxz),
      wyz = (sMs * v.wyz + v.wyz * yMy + v.wyz * yzMyz + v.wyz * zMz - 2.0 * sMwx * v.xyz - 2.0 * sMwxz * v.xy - 2.0 * sMxz * v.wxy - 2.0 * sMy * v.wz - 2.0 * v.wx * xMyz - 2.0 * v.wx * yMxz - 2.0 * v.wxy * xMz - 2.0 * v.wy * xyMxyz - 2.0 * v.wy * yMyz - 2.0 * v.wz * xMxy - 2.0 * v.wz * xzMxyz - 2.0 * v.wz * zMyz - 2.0 * v.xy * wMxz - 2.0 * v.xy * xMwz - 2.0 * v.xy * zMwx - 2.0 * v.xyz * yMwxy - 2.0 * v.xyz * yzMi - 2.0 * v.xyz * zMwxz - 2.0 * v.yz * xMwx - 2.0 * v.yz * xyMwxy - 2.0 * v.yz * xyzMi - 2.0 * v.yz * xzMwxz - v.wyz * xMx - v.wyz * xyMxy - v.wyz * xyzMxyz - v.wyz * xzMxz + 2.0 * sMw * v.yz + 2.0 * sMwxy * v.xz + 2.0 * sMxy * v.wxz + 2.0 * sMxyz * v.wx + 2.0 * sMz * v.wy + 2.0 * v.wx * zMxy + 2.0 * v.wxy * xyMyz + 2.0 * v.wxy * yMxyz + 2.0 * v.wxz * xMy + 2.0 * v.wxz * xzMyz + 2.0 * v.wxz * zMxyz + 2.0 * v.wy * xMxz + 2.0 * v.xy * wyMxyz + 2.0 * v.xy * xyMwyz + 2.0 * v.xy * yMi + 2.0 * v.xy * yzMwxy + 2.0 * v.xyz * wMx + 2.0 * v.xyz * wyMxy + 2.0 * v.xyz * wyzMxyz + 2.0 * v.xyz * wzMxz + 2.0 * v.xz * wMxy + 2.0 * v.xz * wzMxyz + 2.0 * v.xz * xMwy + 2.0 * v.xz * xzMwyz + 2.0 * v.xz * yMwx + 2.0 * v.xz * yzMwxz + 2.0 * v.xz * zMi + 2.0 * v.yz * yMwy + 2.0 * v.yz * yzMwyz + 2.0 * v.yz * zMwz),
      xyz = (sMs * v.xyz + v.xyz * xMx + v.xyz * xyMxy + v.xyz * xyzMxyz + v.xyz * xzMxz + v.xyz * yMy + v.xyz * yzMyz + v.xyz * zMz - 2.0 * sMy * v.xz - 2.0 * v.xy * xMxz - 2.0 * v.xy * yMyz - 2.0 * v.xz * zMyz + 2.0 * sMx * v.yz + 2.0 * sMz * v.xy + 2.0 * v.xy * xyMxyz + 2.0 * v.xz * xMxy + 2.0 * v.xz * xzMxyz + 2.0 * v.yz * yMxy + 2.0 * v.yz * yzMxyz + 2.0 * v.yz * zMxz),
      i = (sMs * v.i + v.i * xyMxy + v.i * xzMxz + v.i * yzMyz - 2.0 * sMwxy * v.z - 2.0 * sMwyz * v.x - 2.0 * v.s * wxMyz - 2.0 * v.s * wzMxy - 2.0 * v.s * xMwyz - 2.0 * v.s * zMwxy - 2.0 * v.w * xMyz - 2.0 * v.w * zMxy - 2.0 * v.x * wxMxyz - 2.0 * v.x * xzMwxy - 2.0 * v.x * yMwz - 2.0 * v.y * wMxz - 2.0 * v.y * wyMxyz - 2.0 * v.y * yzMwxy - 2.0 * v.y * zMwx - 2.0 * v.z * wzMxyz - 2.0 * v.z * xMwy - 2.0 * v.z * yzMwxz - v.i * xMx - v.i * xyzMxyz - v.i * yMy - v.i * zMz + 2.0 * sMi * v.s + 2.0 * sMwxz * v.y + 2.0 * sMxyz * v.w + 2.0 * v.s * wMxyz + 2.0 * v.s * wyMxz + 2.0 * v.s * yMwxz + 2.0 * v.w * yMxz + 2.0 * v.x * wMyz + 2.0 * v.x * xMi + 2.0 * v.x * xyMwxz + 2.0 * v.x * zMwy + 2.0 * v.y * xMwz + 2.0 * v.y * xyMwyz + 2.0 * v.y * yMi + 2.0 * v.z * wMxy + 2.0 * v.z * xzMwyz + 2.0 * v.z * yMwx + 2.0 * v.z * zMi),
    )

  infix def reverseSandwich(v: Motor): Multivector =
    val sMs = s * s
    val sMw = s * w
    val sMx = s * x
    val sMy = s * y
    val sMz = s * z
    val sMwx = s * wx
    val sMwy = s * wy
    val sMwz = s * wz
    val sMxy = s * xy
    val sMxz = s * xz
    val sMyz = s * yz
    val sMwxy = s * wxy
    val sMwxz = s * wxz
    val sMwyz = s * wyz
    val sMxyz = s * xyz
    val sMi = i * s
    val wMx = w * x
    val wMy = w * y
    val wMz = w * z
    val wMxy = w * xy
    val wMxz = w * xz
    val wMyz = w * yz
    val wMxyz = w * xyz
    val xMx = x * x
    val xMy = x * y
    val xMz = x * z
    val xMwx = wx * x
    val xMwy = wy * x
    val xMwz = wz * x
    val xMxy = x * xy
    val xMxz = x * xz
    val xMyz = x * yz
    val xMwxy = wxy * x
    val xMwxz = wxz * x
    val xMwyz = wyz * x
    val xMxyz = x * xyz
    val xMi = i * x
    val yMy = y * y
    val yMz = y * z
    val yMwx = wx * y
    val yMwy = wy * y
    val yMwz = wz * y
    val yMxy = xy * y
    val yMxz = xz * y
    val yMyz = y * yz
    val yMwxy = wxy * y
    val yMwxz = wxz * y
    val yMwyz = wyz * y
    val yMxyz = xyz * y
    val yMi = i * y
    val zMz = z * z
    val zMwx = wx * z
    val zMwy = wy * z
    val zMwz = wz * z
    val zMxy = xy * z
    val zMxz = xz * z
    val zMyz = yz * z
    val zMwxy = wxy * z
    val zMwxz = wxz * z
    val zMwyz = wyz * z
    val zMxyz = xyz * z
    val zMi = i * z
    val wxMxy = wx * xy
    val wxMxz = wx * xz
    val wxMyz = wx * yz
    val wxMxyz = wx * xyz
    val wyMxy = wy * xy
    val wyMxz = wy * xz
    val wyMyz = wy * yz
    val wyMxyz = wy * xyz
    val wzMxy = wz * xy
    val wzMxz = wz * xz
    val wzMyz = wz * yz
    val wzMxyz = wz * xyz
    val xyMxy = xy * xy
    val xyMxz = xy * xz
    val xyMyz = xy * yz
    val xyMwxy = wxy * xy
    val xyMwxz = wxz * xy
    val xyMwyz = wyz * xy
    val xyMxyz = xy * xyz
    val xyMi = i * xy
    val xzMxz = xz * xz
    val xzMyz = xz * yz
    val xzMwxy = wxy * xz
    val xzMwxz = wxz * xz
    val xzMwyz = wyz * xz
    val xzMxyz = xyz * xz
    val xzMi = i * xz
    val yzMyz = yz * yz
    val yzMwxy = wxy * yz
    val yzMwxz = wxz * yz
    val yzMwyz = wyz * yz
    val yzMxyz = xyz * yz
    val yzMi = i * yz
    val wxyMxyz = wxy * xyz
    val wxzMxyz = wxz * xyz
    val wyzMxyz = wyz * xyz
    val xyzMxyz = xyz * xyz
    val xyzMi = i * xyz
    Multivector(
      s = v.s * (sMs + xMx + xyMxy + xyzMxyz + xzMxz + yMy + yzMyz + zMz),
      w = (-2.0 * sMxyz * v.i - 2.0 * v.i * yMxz - 2.0 * v.s * xMwx - 2.0 * v.s * xyzMi - 2.0 * v.s * yMwy - 2.0 * v.s * zMwz + 2.0 * sMw * v.s + 2.0 * v.i * xMyz + 2.0 * v.i * zMxy + 2.0 * v.s * xyMwxy + 2.0 * v.s * xzMwxz + 2.0 * v.s * yzMwyz),
      x = v.s * (-2.0 * yMxy - 2.0 * zMxz + 2.0 * sMx + 2.0 * yzMxyz),
      y = v.s * (-2.0 * xzMxyz - 2.0 * zMyz + 2.0 * sMy + 2.0 * xMxy),
      z = 2.0 * v.s * (sMz + xMxz + xyMxyz + yMyz),
      wx = (sMs * v.wx + v.wx * yMy + v.wx * yzMyz + v.wx * zMz - 2.0 * sMi * v.yz - 2.0 * sMxy * v.wy - 2.0 * sMxz * v.wz - 2.0 * v.wy * xMy - 2.0 * v.wy * xzMyz - 2.0 * v.wy * zMxyz - 2.0 * v.wz * xMz - 2.0 * v.xz * wxyMxyz - 2.0 * v.xz * wyMyz - 2.0 * v.xz * xyMi - 2.0 * v.xz * yMwyz - 2.0 * v.yz * wMxyz - 2.0 * v.yz * wzMxy - 2.0 * v.yz * zMwxy - v.wx * xMx - v.wx * xyMxy - v.wx * xyzMxyz - v.wx * xzMxz + 2.0 * sMwy * v.xy + 2.0 * sMwz * v.xz + 2.0 * v.wz * xyMyz + 2.0 * v.wz * yMxyz + 2.0 * v.xy * wMy + 2.0 * v.xy * wxMxy + 2.0 * v.xy * wxzMxyz + 2.0 * v.xy * wzMyz + 2.0 * v.xy * xMwxy + 2.0 * v.xy * xzMi + 2.0 * v.xy * zMwyz + 2.0 * v.xz * wMz + 2.0 * v.xz * wxMxz + 2.0 * v.xz * xMwxz + 2.0 * v.yz * wxMyz + 2.0 * v.yz * wyMxz + 2.0 * v.yz * xMwyz + 2.0 * v.yz * yMwxz),
      wy = (sMs * v.wy + v.wy * xMx + v.wy * xzMxz + v.wy * zMz - 2.0 * sMwx * v.xy - 2.0 * sMyz * v.wz - 2.0 * v.wx * xMy - 2.0 * v.wx * xzMyz - 2.0 * v.wz * xMxyz - 2.0 * v.wz * xyMxz - 2.0 * v.wz * yMz - 2.0 * v.xy * wMx - 2.0 * v.xy * wzMxz - 2.0 * v.xy * zMwxz - 2.0 * v.yz * wxMxz - 2.0 * v.yz * wxyMxyz - 2.0 * v.yz * xMwxz - 2.0 * v.yz * xyMi - v.wy * xyMxy - v.wy * xyzMxyz - v.wy * yMy - v.wy * yzMyz + 2.0 * sMi * v.xz + 2.0 * sMwz * v.yz + 2.0 * sMxy * v.wx + 2.0 * v.wx * zMxyz + 2.0 * v.xy * wyMxy + 2.0 * v.xy * wyzMxyz + 2.0 * v.xy * yMwxy + 2.0 * v.xy * yzMi + 2.0 * v.xz * wMxyz + 2.0 * v.xz * wxMyz + 2.0 * v.xz * wyMxz + 2.0 * v.xz * wzMxy + 2.0 * v.xz * xMwyz + 2.0 * v.xz * yMwxz + 2.0 * v.xz * zMwxy + 2.0 * v.yz * wMz + 2.0 * v.yz * wyMyz + 2.0 * v.yz * yMwyz),
      wz = (sMs * v.wz + v.wz * xMx + v.wz * xyMxy + v.wz * yMy - 2.0 * sMi * v.xy - 2.0 * sMwx * v.xz - 2.0 * sMwy * v.yz - 2.0 * v.wx * xMz - 2.0 * v.wx * yMxyz - 2.0 * v.wy * xyMxz - 2.0 * v.wy * yMz - 2.0 * v.xy * wMxyz - 2.0 * v.xy * wxMyz - 2.0 * v.xy * xMwyz - 2.0 * v.xz * wMx - 2.0 * v.xz * wyMxy - 2.0 * v.xz * yMwxy - 2.0 * v.yz * wMy - 2.0 * v.yz * wxzMxyz - 2.0 * v.yz * xzMi - v.wz * xyzMxyz - v.wz * xzMxz - v.wz * yzMyz - v.wz * zMz + 2.0 * sMxz * v.wx + 2.0 * sMyz * v.wy + 2.0 * v.wx * xyMyz + 2.0 * v.wy * xMxyz + 2.0 * v.xy * wyMxz + 2.0 * v.xy * wzMxy + 2.0 * v.xy * yMwxz + 2.0 * v.xy * zMwxy + 2.0 * v.xz * wyzMxyz + 2.0 * v.xz * wzMxz + 2.0 * v.xz * yzMi + 2.0 * v.xz * zMwxz + 2.0 * v.yz * wxMxy + 2.0 * v.yz * wzMyz + 2.0 * v.yz * xMwxy + 2.0 * v.yz * zMwyz),
      xy = (sMs * v.xy + v.xy * xyMxy + v.xy * xyzMxyz + v.xy * zMz - 2.0 * sMyz * v.xz - 2.0 * v.xz * yMz - v.xy * xMx - v.xy * xzMxz - v.xy * yMy - v.xy * yzMyz + 2.0 * sMxz * v.yz + 2.0 * v.xz * xMxyz + 2.0 * v.xz * xyMxz + 2.0 * v.yz * xMz + 2.0 * v.yz * xyMyz + 2.0 * v.yz * yMxyz),
      xz = (sMs * v.xz + v.xz * xyzMxyz + v.xz * xzMxz + v.xz * yMy - 2.0 * sMxy * v.yz - 2.0 * v.xy * xMxyz - 2.0 * v.xy * yMz - 2.0 * v.yz * xMy - v.xz * xMx - v.xz * xyMxy - v.xz * yzMyz - v.xz * zMz + 2.0 * sMyz * v.xy + 2.0 * v.xy * xyMxz + 2.0 * v.yz * xzMyz + 2.0 * v.yz * zMxyz),
      yz = (sMs * v.yz + v.yz * xMx + v.yz * xyzMxyz + v.yz * yzMyz - 2.0 * sMxz * v.xy - 2.0 * v.xy * yMxyz - 2.0 * v.xz * xMy - 2.0 * v.xz * zMxyz - v.yz * xyMxy - v.yz * xzMxz - v.yz * yMy - v.yz * zMz + 2.0 * sMxy * v.xz + 2.0 * v.xy * xMz + 2.0 * v.xy * xyMyz + 2.0 * v.xz * xzMyz),
      wxy = (-2.0 * sMwyz * v.xz - 2.0 * sMx * v.wy - 2.0 * v.wx * xMxy - 2.0 * v.wx * zMyz - 2.0 * v.wy * yMxy - 2.0 * v.wz * yMxz - 2.0 * v.wz * zMxy - 2.0 * v.xy * xyzMi - 2.0 * v.xy * xzMwxz - 2.0 * v.xy * yzMwyz - 2.0 * v.xy * zMwz - 2.0 * v.xz * wMyz - 2.0 * v.xz * wxMxyz - 2.0 * v.xz * xMi - 2.0 * v.yz * wyMxyz - 2.0 * v.yz * xMwz - 2.0 * v.yz * yMi - 2.0 * v.yz * zMwx + 2.0 * sMw * v.xy + 2.0 * sMwxz * v.yz + 2.0 * sMxyz * v.wz + 2.0 * sMy * v.wx + 2.0 * v.wx * xzMxyz + 2.0 * v.wy * yzMxyz + 2.0 * v.wy * zMxz + 2.0 * v.wz * xMyz + 2.0 * v.xy * xMwx + 2.0 * v.xy * xyMwxy + 2.0 * v.xy * yMwy + 2.0 * v.xz * xyMwxz + 2.0 * v.xz * xzMwxy + 2.0 * v.xz * yMwz + 2.0 * v.xz * zMwy + 2.0 * v.yz * wMxz + 2.0 * v.yz * xyMwyz + 2.0 * v.yz * yzMwxy),
      wxz = (-2.0 * sMwxy * v.yz - 2.0 * sMx * v.wz - 2.0 * sMxyz * v.wy - 2.0 * v.wx * xMxz - 2.0 * v.wx * xyMxyz - 2.0 * v.wy * xMyz - 2.0 * v.wy * yMxz - 2.0 * v.wy * zMxy - 2.0 * v.wz * zMxz - 2.0 * v.xz * xyMwxy - 2.0 * v.xz * xyzMi - 2.0 * v.xz * yMwy - 2.0 * v.xz * yzMwyz - 2.0 * v.yz * wMxy - 2.0 * v.yz * wzMxyz - 2.0 * v.yz * zMi + 2.0 * sMw * v.xz + 2.0 * sMwyz * v.xy + 2.0 * sMz * v.wx + 2.0 * v.wx * yMyz + 2.0 * v.wz * yMxy + 2.0 * v.wz * yzMxyz + 2.0 * v.xy * wMyz + 2.0 * v.xy * wxMxyz + 2.0 * v.xy * xMi + 2.0 * v.xy * xyMwxz + 2.0 * v.xy * xzMwxy + 2.0 * v.xy * yMwz + 2.0 * v.xy * zMwy + 2.0 * v.xz * xMwx + 2.0 * v.xz * xzMwxz + 2.0 * v.xz * zMwz + 2.0 * v.yz * xMwy + 2.0 * v.yz * xzMwyz + 2.0 * v.yz * yMwx + 2.0 * v.yz * yzMwxz),
      wyz = (-2.0 * sMwxz * v.xy - 2.0 * sMy * v.wz - 2.0 * v.wx * xMyz - 2.0 * v.wx * yMxz - 2.0 * v.wy * xyMxyz - 2.0 * v.wy * yMyz - 2.0 * v.wz * xMxy - 2.0 * v.wz * xzMxyz - 2.0 * v.wz * zMyz - 2.0 * v.xy * wMxz - 2.0 * v.xy * xMwz - 2.0 * v.xy * zMwx - 2.0 * v.yz * xMwx - 2.0 * v.yz * xyMwxy - 2.0 * v.yz * xyzMi - 2.0 * v.yz * xzMwxz + 2.0 * sMw * v.yz + 2.0 * sMwxy * v.xz + 2.0 * sMxyz * v.wx + 2.0 * sMz * v.wy + 2.0 * v.wx * zMxy + 2.0 * v.wy * xMxz + 2.0 * v.xy * wyMxyz + 2.0 * v.xy * xyMwyz + 2.0 * v.xy * yMi + 2.0 * v.xy * yzMwxy + 2.0 * v.xz * wMxy + 2.0 * v.xz * wzMxyz + 2.0 * v.xz * xMwy + 2.0 * v.xz * xzMwyz + 2.0 * v.xz * yMwx + 2.0 * v.xz * yzMwxz + 2.0 * v.xz * zMi + 2.0 * v.yz * yMwy + 2.0 * v.yz * yzMwyz + 2.0 * v.yz * zMwz),
      xyz = (-2.0 * sMy * v.xz - 2.0 * v.xy * xMxz - 2.0 * v.xy * yMyz - 2.0 * v.xz * zMyz + 2.0 * sMx * v.yz + 2.0 * sMz * v.xy + 2.0 * v.xy * xyMxyz + 2.0 * v.xz * xMxy + 2.0 * v.xz * xzMxyz + 2.0 * v.yz * yMxy + 2.0 * v.yz * yzMxyz + 2.0 * v.yz * zMxz),
      i = (sMs * v.i + v.i * xyMxy + v.i * xzMxz + v.i * yzMyz - 2.0 * v.s * wxMyz - 2.0 * v.s * wzMxy - 2.0 * v.s * xMwyz - 2.0 * v.s * zMwxy - v.i * xMx - v.i * xyzMxyz - v.i * yMy - v.i * zMz + 2.0 * sMi * v.s + 2.0 * v.s * wMxyz + 2.0 * v.s * wyMxz + 2.0 * v.s * yMwxz),
    )

  infix def reverseSandwich(v: Plane): Multivector =
    val sMs = s * s
    val sMxy = s * xy
    val sMxz = s * xz
    val sMyz = s * yz
    val xMx = x * x
    val xMy = x * y
    val xMz = x * z
    val xMxyz = x * xyz
    val yMy = y * y
    val yMz = y * z
    val yMxyz = xyz * y
    val zMz = z * z
    val zMxyz = xyz * z
    val xyMxy = xy * xy
    val xyMxz = xy * xz
    val xyMyz = xy * yz
    val xzMxz = xz * xz
    val xzMyz = xz * yz
    val yzMyz = yz * yz
    val xyzMxyz = xyz * xyz
    Multivector(
      s = (-2.0 * v.y * x * xy - 2.0 * v.y * xyz * xz - 2.0 * v.z * x * xz - 2.0 * v.z * y * yz + 2.0 * s * v.x * x + 2.0 * s * v.y * y + 2.0 * s * v.z * z + 2.0 * v.x * xy * y + 2.0 * v.x * xyz * yz + 2.0 * v.x * xz * z + 2.0 * v.y * yz * z + 2.0 * v.z * xy * xyz),
      w = (sMs * v.w + v.w * xyMxy + v.w * xzMxz + v.w * yzMyz - v.w * xMx - v.w * xyzMxyz - v.w * yMy - v.w * zMz - 2.0 * i * v.x * yz - 2.0 * i * v.z * xy - 2.0 * s * v.x * wx - 2.0 * s * v.y * wy - 2.0 * s * v.z * wz - 2.0 * v.x * wy * xy - 2.0 * v.x * wz * xz - 2.0 * v.y * wxy * x - 2.0 * v.y * wxz * xyz - 2.0 * v.y * wz * yz - 2.0 * v.z * wxz * x - 2.0 * v.z * wyz * y + 2.0 * i * v.y * xz + 2.0 * v.x * w * x + 2.0 * v.x * wxy * y + 2.0 * v.x * wxz * z + 2.0 * v.x * wyz * xyz + 2.0 * v.y * w * y + 2.0 * v.y * wx * xy + 2.0 * v.y * wyz * z + 2.0 * v.z * w * z + 2.0 * v.z * wx * xz + 2.0 * v.z * wxy * xyz + 2.0 * v.z * wy * yz),
      x = (sMs * v.x + v.x * xMx + v.x * xyzMxyz + v.x * yzMyz - 2.0 * sMxy * v.y - 2.0 * sMxz * v.z - 2.0 * v.y * xzMyz - 2.0 * v.z * yMxyz - v.x * xyMxy - v.x * xzMxz - v.x * yMy - v.x * zMz + 2.0 * v.y * xMy + 2.0 * v.y * zMxyz + 2.0 * v.z * xMz + 2.0 * v.z * xyMyz),
      y = (sMs * v.y + v.y * xyzMxyz + v.y * xzMxz + v.y * yMy - 2.0 * sMyz * v.z - 2.0 * v.x * xzMyz - 2.0 * v.x * zMxyz - 2.0 * v.z * xyMxz - v.y * xMx - v.y * xyMxy - v.y * yzMyz - v.y * zMz + 2.0 * sMxy * v.x + 2.0 * v.x * xMy + 2.0 * v.z * xMxyz + 2.0 * v.z * yMz),
      z = (sMs * v.z + v.z * xyMxy + v.z * xyzMxyz + v.z * zMz - 2.0 * v.y * xMxyz - 2.0 * v.y * xyMxz - v.z * xMx - v.z * xzMxz - v.z * yMy - v.z * yzMyz + 2.0 * sMxz * v.x + 2.0 * sMyz * v.y + 2.0 * v.x * xMz + 2.0 * v.x * xyMyz + 2.0 * v.x * yMxyz + 2.0 * v.y * yMz),
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
    val sMs = s * s
    val sMw = s * w
    val sMx = s * x
    val sMy = s * y
    val sMz = s * z
    val sMwx = s * wx
    val sMwy = s * wy
    val sMwz = s * wz
    val sMxy = s * xy
    val sMxz = s * xz
    val sMyz = s * yz
    val sMwxy = s * wxy
    val sMwxz = s * wxz
    val sMwyz = s * wyz
    val sMxyz = s * xyz
    val sMi = i * s
    val wMx = w * x
    val wMy = w * y
    val wMz = w * z
    val wMxy = w * xy
    val wMxz = w * xz
    val wMyz = w * yz
    val wMxyz = w * xyz
    val xMx = x * x
    val xMy = x * y
    val xMz = x * z
    val xMwx = wx * x
    val xMwy = wy * x
    val xMwz = wz * x
    val xMxy = x * xy
    val xMxz = x * xz
    val xMyz = x * yz
    val xMwxy = wxy * x
    val xMwxz = wxz * x
    val xMwyz = wyz * x
    val xMxyz = x * xyz
    val xMi = i * x
    val yMy = y * y
    val yMz = y * z
    val yMwx = wx * y
    val yMwy = wy * y
    val yMwz = wz * y
    val yMxy = xy * y
    val yMxz = xz * y
    val yMyz = y * yz
    val yMwxy = wxy * y
    val yMwxz = wxz * y
    val yMwyz = wyz * y
    val yMxyz = xyz * y
    val yMi = i * y
    val zMz = z * z
    val zMwx = wx * z
    val zMwy = wy * z
    val zMwz = wz * z
    val zMxy = xy * z
    val zMxz = xz * z
    val zMyz = yz * z
    val zMwxy = wxy * z
    val zMwxz = wxz * z
    val zMwyz = wyz * z
    val zMxyz = xyz * z
    val zMi = i * z
    val wxMxy = wx * xy
    val wxMxz = wx * xz
    val wxMyz = wx * yz
    val wxMxyz = wx * xyz
    val wyMxy = wy * xy
    val wyMxz = wy * xz
    val wyMyz = wy * yz
    val wyMxyz = wy * xyz
    val wzMxy = wz * xy
    val wzMxz = wz * xz
    val wzMyz = wz * yz
    val wzMxyz = wz * xyz
    val xyMxy = xy * xy
    val xyMxz = xy * xz
    val xyMyz = xy * yz
    val xyMwxy = wxy * xy
    val xyMwxz = wxz * xy
    val xyMwyz = wyz * xy
    val xyMxyz = xy * xyz
    val xyMi = i * xy
    val xzMxz = xz * xz
    val xzMyz = xz * yz
    val xzMwxy = wxy * xz
    val xzMwxz = wxz * xz
    val xzMwyz = wyz * xz
    val xzMxyz = xyz * xz
    val xzMi = i * xz
    val yzMyz = yz * yz
    val yzMwxy = wxy * yz
    val yzMwxz = wxz * yz
    val yzMwyz = wyz * yz
    val yzMxyz = xyz * yz
    val yzMi = i * yz
    val wxyMxyz = wxy * xyz
    val wxzMxyz = wxz * xyz
    val wyzMxyz = wyz * xyz
    val xyzMxyz = xyz * xyz
    val xyzMi = i * xyz
    Multivector(
      s = 0.0,
      w = 0.0,
      x = 0.0,
      y = 0.0,
      z = 0.0,
      wx = (sMs * v.wx + v.wx * yMy + v.wx * yzMyz + v.wx * zMz - 2.0 * sMi * v.yz - 2.0 * sMxy * v.wy - 2.0 * sMxz * v.wz - 2.0 * v.wy * xMy - 2.0 * v.wy * xzMyz - 2.0 * v.wy * zMxyz - 2.0 * v.wz * xMz - 2.0 * v.xz * wxyMxyz - 2.0 * v.xz * wyMyz - 2.0 * v.xz * xyMi - 2.0 * v.xz * yMwyz - 2.0 * v.yz * wMxyz - 2.0 * v.yz * wzMxy - 2.0 * v.yz * zMwxy - v.wx * xMx - v.wx * xyMxy - v.wx * xyzMxyz - v.wx * xzMxz + 2.0 * sMwy * v.xy + 2.0 * sMwz * v.xz + 2.0 * v.wz * xyMyz + 2.0 * v.wz * yMxyz + 2.0 * v.xy * wMy + 2.0 * v.xy * wxMxy + 2.0 * v.xy * wxzMxyz + 2.0 * v.xy * wzMyz + 2.0 * v.xy * xMwxy + 2.0 * v.xy * xzMi + 2.0 * v.xy * zMwyz + 2.0 * v.xz * wMz + 2.0 * v.xz * wxMxz + 2.0 * v.xz * xMwxz + 2.0 * v.yz * wxMyz + 2.0 * v.yz * wyMxz + 2.0 * v.yz * xMwyz + 2.0 * v.yz * yMwxz),
      wy = (sMs * v.wy + v.wy * xMx + v.wy * xzMxz + v.wy * zMz - 2.0 * sMwx * v.xy - 2.0 * sMyz * v.wz - 2.0 * v.wx * xMy - 2.0 * v.wx * xzMyz - 2.0 * v.wz * xMxyz - 2.0 * v.wz * xyMxz - 2.0 * v.wz * yMz - 2.0 * v.xy * wMx - 2.0 * v.xy * wzMxz - 2.0 * v.xy * zMwxz - 2.0 * v.yz * wxMxz - 2.0 * v.yz * wxyMxyz - 2.0 * v.yz * xMwxz - 2.0 * v.yz * xyMi - v.wy * xyMxy - v.wy * xyzMxyz - v.wy * yMy - v.wy * yzMyz + 2.0 * sMi * v.xz + 2.0 * sMwz * v.yz + 2.0 * sMxy * v.wx + 2.0 * v.wx * zMxyz + 2.0 * v.xy * wyMxy + 2.0 * v.xy * wyzMxyz + 2.0 * v.xy * yMwxy + 2.0 * v.xy * yzMi + 2.0 * v.xz * wMxyz + 2.0 * v.xz * wxMyz + 2.0 * v.xz * wyMxz + 2.0 * v.xz * wzMxy + 2.0 * v.xz * xMwyz + 2.0 * v.xz * yMwxz + 2.0 * v.xz * zMwxy + 2.0 * v.yz * wMz + 2.0 * v.yz * wyMyz + 2.0 * v.yz * yMwyz),
      wz = (sMs * v.wz + v.wz * xMx + v.wz * xyMxy + v.wz * yMy - 2.0 * sMi * v.xy - 2.0 * sMwx * v.xz - 2.0 * sMwy * v.yz - 2.0 * v.wx * xMz - 2.0 * v.wx * yMxyz - 2.0 * v.wy * xyMxz - 2.0 * v.wy * yMz - 2.0 * v.xy * wMxyz - 2.0 * v.xy * wxMyz - 2.0 * v.xy * xMwyz - 2.0 * v.xz * wMx - 2.0 * v.xz * wyMxy - 2.0 * v.xz * yMwxy - 2.0 * v.yz * wMy - 2.0 * v.yz * wxzMxyz - 2.0 * v.yz * xzMi - v.wz * xyzMxyz - v.wz * xzMxz - v.wz * yzMyz - v.wz * zMz + 2.0 * sMxz * v.wx + 2.0 * sMyz * v.wy + 2.0 * v.wx * xyMyz + 2.0 * v.wy * xMxyz + 2.0 * v.xy * wyMxz + 2.0 * v.xy * wzMxy + 2.0 * v.xy * yMwxz + 2.0 * v.xy * zMwxy + 2.0 * v.xz * wyzMxyz + 2.0 * v.xz * wzMxz + 2.0 * v.xz * yzMi + 2.0 * v.xz * zMwxz + 2.0 * v.yz * wxMxy + 2.0 * v.yz * wzMyz + 2.0 * v.yz * xMwxy + 2.0 * v.yz * zMwyz),
      xy = (sMs * v.xy + v.xy * xyMxy + v.xy * xyzMxyz + v.xy * zMz - 2.0 * sMyz * v.xz - 2.0 * v.xz * yMz - v.xy * xMx - v.xy * xzMxz - v.xy * yMy - v.xy * yzMyz + 2.0 * sMxz * v.yz + 2.0 * v.xz * xMxyz + 2.0 * v.xz * xyMxz + 2.0 * v.yz * xMz + 2.0 * v.yz * xyMyz + 2.0 * v.yz * yMxyz),
      xz = (sMs * v.xz + v.xz * xyzMxyz + v.xz * xzMxz + v.xz * yMy - 2.0 * sMxy * v.yz - 2.0 * v.xy * xMxyz - 2.0 * v.xy * yMz - 2.0 * v.yz * xMy - v.xz * xMx - v.xz * xyMxy - v.xz * yzMyz - v.xz * zMz + 2.0 * sMyz * v.xy + 2.0 * v.xy * xyMxz + 2.0 * v.yz * xzMyz + 2.0 * v.yz * zMxyz),
      yz = (sMs * v.yz + v.yz * xMx + v.yz * xyzMxyz + v.yz * yzMyz - 2.0 * sMxz * v.xy - 2.0 * v.xy * yMxyz - 2.0 * v.xz * xMy - 2.0 * v.xz * zMxyz - v.yz * xyMxy - v.yz * xzMxz - v.yz * yMy - v.yz * zMz + 2.0 * sMxy * v.xz + 2.0 * v.xy * xMz + 2.0 * v.xy * xyMyz + 2.0 * v.xz * xzMyz),
      wxy = (-2.0 * sMwyz * v.xz - 2.0 * sMx * v.wy - 2.0 * v.wx * xMxy - 2.0 * v.wx * zMyz - 2.0 * v.wy * yMxy - 2.0 * v.wz * yMxz - 2.0 * v.wz * zMxy - 2.0 * v.xy * xyzMi - 2.0 * v.xy * xzMwxz - 2.0 * v.xy * yzMwyz - 2.0 * v.xy * zMwz - 2.0 * v.xz * wMyz - 2.0 * v.xz * wxMxyz - 2.0 * v.xz * xMi - 2.0 * v.yz * wyMxyz - 2.0 * v.yz * xMwz - 2.0 * v.yz * yMi - 2.0 * v.yz * zMwx + 2.0 * sMw * v.xy + 2.0 * sMwxz * v.yz + 2.0 * sMxyz * v.wz + 2.0 * sMy * v.wx + 2.0 * v.wx * xzMxyz + 2.0 * v.wy * yzMxyz + 2.0 * v.wy * zMxz + 2.0 * v.wz * xMyz + 2.0 * v.xy * xMwx + 2.0 * v.xy * xyMwxy + 2.0 * v.xy * yMwy + 2.0 * v.xz * xyMwxz + 2.0 * v.xz * xzMwxy + 2.0 * v.xz * yMwz + 2.0 * v.xz * zMwy + 2.0 * v.yz * wMxz + 2.0 * v.yz * xyMwyz + 2.0 * v.yz * yzMwxy),
      wxz = (-2.0 * sMwxy * v.yz - 2.0 * sMx * v.wz - 2.0 * sMxyz * v.wy - 2.0 * v.wx * xMxz - 2.0 * v.wx * xyMxyz - 2.0 * v.wy * xMyz - 2.0 * v.wy * yMxz - 2.0 * v.wy * zMxy - 2.0 * v.wz * zMxz - 2.0 * v.xz * xyMwxy - 2.0 * v.xz * xyzMi - 2.0 * v.xz * yMwy - 2.0 * v.xz * yzMwyz - 2.0 * v.yz * wMxy - 2.0 * v.yz * wzMxyz - 2.0 * v.yz * zMi + 2.0 * sMw * v.xz + 2.0 * sMwyz * v.xy + 2.0 * sMz * v.wx + 2.0 * v.wx * yMyz + 2.0 * v.wz * yMxy + 2.0 * v.wz * yzMxyz + 2.0 * v.xy * wMyz + 2.0 * v.xy * wxMxyz + 2.0 * v.xy * xMi + 2.0 * v.xy * xyMwxz + 2.0 * v.xy * xzMwxy + 2.0 * v.xy * yMwz + 2.0 * v.xy * zMwy + 2.0 * v.xz * xMwx + 2.0 * v.xz * xzMwxz + 2.0 * v.xz * zMwz + 2.0 * v.yz * xMwy + 2.0 * v.yz * xzMwyz + 2.0 * v.yz * yMwx + 2.0 * v.yz * yzMwxz),
      wyz = (-2.0 * sMwxz * v.xy - 2.0 * sMy * v.wz - 2.0 * v.wx * xMyz - 2.0 * v.wx * yMxz - 2.0 * v.wy * xyMxyz - 2.0 * v.wy * yMyz - 2.0 * v.wz * xMxy - 2.0 * v.wz * xzMxyz - 2.0 * v.wz * zMyz - 2.0 * v.xy * wMxz - 2.0 * v.xy * xMwz - 2.0 * v.xy * zMwx - 2.0 * v.yz * xMwx - 2.0 * v.yz * xyMwxy - 2.0 * v.yz * xyzMi - 2.0 * v.yz * xzMwxz + 2.0 * sMw * v.yz + 2.0 * sMwxy * v.xz + 2.0 * sMxyz * v.wx + 2.0 * sMz * v.wy + 2.0 * v.wx * zMxy + 2.0 * v.wy * xMxz + 2.0 * v.xy * wyMxyz + 2.0 * v.xy * xyMwyz + 2.0 * v.xy * yMi + 2.0 * v.xy * yzMwxy + 2.0 * v.xz * wMxy + 2.0 * v.xz * wzMxyz + 2.0 * v.xz * xMwy + 2.0 * v.xz * xzMwyz + 2.0 * v.xz * yMwx + 2.0 * v.xz * yzMwxz + 2.0 * v.xz * zMi + 2.0 * v.yz * yMwy + 2.0 * v.yz * yzMwyz + 2.0 * v.yz * zMwz),
      xyz = (-2.0 * sMy * v.xz - 2.0 * v.xy * xMxz - 2.0 * v.xy * yMyz - 2.0 * v.xz * zMyz + 2.0 * sMx * v.yz + 2.0 * sMz * v.xy + 2.0 * v.xy * xyMxyz + 2.0 * v.xz * xMxy + 2.0 * v.xz * xzMxyz + 2.0 * v.yz * yMxy + 2.0 * v.yz * yzMxyz + 2.0 * v.yz * zMxz),
      i = 0.0,
    )

  infix def reverseSandwich(v: Point): Multivector =
    val sMs = s * s
    val sMx = s * x
    val sMy = s * y
    val sMz = s * z
    val sMxy = s * xy
    val sMxz = s * xz
    val sMyz = s * yz
    val sMxyz = s * xyz
    val xMx = x * x
    val xMy = x * y
    val xMz = x * z
    val xMxy = x * xy
    val xMxz = x * xz
    val xMyz = x * yz
    val xMxyz = x * xyz
    val yMy = y * y
    val yMz = y * z
    val yMxy = xy * y
    val yMxz = xz * y
    val yMyz = y * yz
    val yMxyz = xyz * y
    val zMz = z * z
    val zMxy = xy * z
    val zMxz = xz * z
    val zMyz = yz * z
    val zMxyz = xyz * z
    val xyMxy = xy * xy
    val xyMxz = xy * xz
    val xyMyz = xy * yz
    val xyMxyz = xy * xyz
    val xzMxz = xz * xz
    val xzMyz = xz * yz
    val xzMxyz = xyz * xz
    val yzMyz = yz * yz
    val yzMxyz = xyz * yz
    val xyzMxyz = xyz * xyz
    Multivector(
      s = 0.0,
      w = 0.0,
      x = 0.0,
      y = 0.0,
      z = 0.0,
      wx = (-2.0 * sMxyz * v.wyz - 2.0 * v.wxz * xyMxyz - 2.0 * v.wxz * yMyz - 2.0 * v.wyz * zMxy + 2.0 * sMy * v.wxy + 2.0 * sMz * v.wxz + 2.0 * v.wxy * xMxy + 2.0 * v.wxy * xzMxyz + 2.0 * v.wxy * zMyz + 2.0 * v.wxz * xMxz + 2.0 * v.wyz * xMyz + 2.0 * v.wyz * yMxz - 2.0 * i * v.xyz * x - 2.0 * v.xyz * w * yz - 2.0 * v.xyz * wxy * xz - 2.0 * v.xyz * wz * y + 2.0 * s * v.xyz * wyz + 2.0 * v.xyz * wx * xyz + 2.0 * v.xyz * wxz * xy + 2.0 * v.xyz * wy * z),
      wy = (-2.0 * sMx * v.wxy - 2.0 * v.wxy * zMxz - 2.0 * v.wyz * xMxz - 2.0 * v.wyz * xyMxyz + 2.0 * sMxyz * v.wxz + 2.0 * sMz * v.wyz + 2.0 * v.wxy * yMxy + 2.0 * v.wxy * yzMxyz + 2.0 * v.wxz * xMyz + 2.0 * v.wxz * yMxz + 2.0 * v.wxz * zMxy + 2.0 * v.wyz * yMyz - 2.0 * i * v.xyz * y - 2.0 * s * v.xyz * wxz - 2.0 * v.xyz * wx * z - 2.0 * v.xyz * wxy * yz + 2.0 * v.xyz * w * xz + 2.0 * v.xyz * wy * xyz + 2.0 * v.xyz * wyz * xy + 2.0 * v.xyz * wz * x),
      wz = (-2.0 * sMx * v.wxz - 2.0 * sMxyz * v.wxy - 2.0 * sMy * v.wyz - 2.0 * v.wxy * xMyz - 2.0 * v.wxz * yMxy - 2.0 * v.wyz * xzMxyz + 2.0 * v.wxy * yMxz + 2.0 * v.wxy * zMxy + 2.0 * v.wxz * yzMxyz + 2.0 * v.wxz * zMxz + 2.0 * v.wyz * xMxy + 2.0 * v.wyz * zMyz - 2.0 * i * v.xyz * z - 2.0 * v.xyz * w * xy - 2.0 * v.xyz * wxz * yz - 2.0 * v.xyz * wy * x + 2.0 * s * v.xyz * wxy + 2.0 * v.xyz * wx * y + 2.0 * v.xyz * wyz * xz + 2.0 * v.xyz * wz * xyz),
      xy = 2.0 * v.xyz * (sMz + xMxz + xyMxyz + yMyz),
      xz = v.xyz * (-2.0 * sMy - 2.0 * xMxy + 2.0 * xzMxyz + 2.0 * zMyz),
      yz = v.xyz * (-2.0 * yMxy - 2.0 * zMxz + 2.0 * sMx + 2.0 * yzMxyz),
      wxy = (sMs * v.wxy + v.wxy * xMx + v.wxy * xyMxy + v.wxy * yMy - 2.0 * sMyz * v.wxz - 2.0 * v.wxz * xMxyz - 2.0 * v.wyz * xMz - 2.0 * v.wyz * yMxyz - v.wxy * xyzMxyz - v.wxy * xzMxz - v.wxy * yzMyz - v.wxy * zMz + 2.0 * sMxz * v.wyz + 2.0 * v.wxz * xyMxz + 2.0 * v.wxz * yMz + 2.0 * v.wyz * xyMyz - 2.0 * i * v.xyz * xy - 2.0 * s * v.xyz * wz - 2.0 * v.xyz * wx * xz - 2.0 * v.xyz * wy * yz + 2.0 * v.xyz * w * z + 2.0 * v.xyz * wxy * xyz + 2.0 * v.xyz * wxz * x + 2.0 * v.xyz * wyz * y),
      wxz = (sMs * v.wxz + v.wxz * xMx + v.wxz * xzMxz + v.wxz * zMz - 2.0 * sMxy * v.wyz - 2.0 * v.wyz * zMxyz - v.wxz * xyMxy - v.wxz * xyzMxyz - v.wxz * yMy - v.wxz * yzMyz + 2.0 * sMyz * v.wxy + 2.0 * v.wxy * xMxyz + 2.0 * v.wxy * xyMxz + 2.0 * v.wxy * yMz + 2.0 * v.wyz * xMy + 2.0 * v.wyz * xzMyz - 2.0 * i * v.xyz * xz - 2.0 * v.xyz * w * y - 2.0 * v.xyz * wxy * x - 2.0 * v.xyz * wz * yz + 2.0 * s * v.xyz * wy + 2.0 * v.xyz * wx * xy + 2.0 * v.xyz * wxz * xyz + 2.0 * v.xyz * wyz * z),
      wyz = (sMs * v.wyz + v.wyz * yMy + v.wyz * yzMyz + v.wyz * zMz - 2.0 * sMxz * v.wxy - 2.0 * v.wxy * xMz - v.wyz * xMx - v.wyz * xyMxy - v.wyz * xyzMxyz - v.wyz * xzMxz + 2.0 * sMxy * v.wxz + 2.0 * v.wxy * xyMyz + 2.0 * v.wxy * yMxyz + 2.0 * v.wxz * xMy + 2.0 * v.wxz * xzMyz + 2.0 * v.wxz * zMxyz - 2.0 * i * v.xyz * yz - 2.0 * s * v.xyz * wx - 2.0 * v.xyz * wxy * y - 2.0 * v.xyz * wxz * z + 2.0 * v.xyz * w * x + 2.0 * v.xyz * wy * xy + 2.0 * v.xyz * wyz * xyz + 2.0 * v.xyz * wz * xz),
      xyz = v.xyz * (sMs + xMx + xyMxy + xyzMxyz + xzMxz + yMy + yzMyz + zMz),
      i = 0.0,
    )

  infix def reverseSandwich(v: Quaternion): Multivector =
    val sMs = s * s
    val sMw = s * w
    val sMx = s * x
    val sMy = s * y
    val sMz = s * z
    val sMwx = s * wx
    val sMwy = s * wy
    val sMwz = s * wz
    val sMxy = s * xy
    val sMxz = s * xz
    val sMyz = s * yz
    val sMwxy = s * wxy
    val sMwxz = s * wxz
    val sMwyz = s * wyz
    val sMi = i * s
    val wMx = w * x
    val wMy = w * y
    val wMz = w * z
    val wMxy = w * xy
    val wMxz = w * xz
    val wMyz = w * yz
    val wMxyz = w * xyz
    val xMx = x * x
    val xMy = x * y
    val xMz = x * z
    val xMwx = wx * x
    val xMwy = wy * x
    val xMwz = wz * x
    val xMxy = x * xy
    val xMxz = x * xz
    val xMwxy = wxy * x
    val xMwxz = wxz * x
    val xMwyz = wyz * x
    val xMxyz = x * xyz
    val xMi = i * x
    val yMy = y * y
    val yMz = y * z
    val yMwx = wx * y
    val yMwy = wy * y
    val yMwz = wz * y
    val yMxy = xy * y
    val yMyz = y * yz
    val yMwxy = wxy * y
    val yMwxz = wxz * y
    val yMwyz = wyz * y
    val yMxyz = xyz * y
    val yMi = i * y
    val zMz = z * z
    val zMwx = wx * z
    val zMwy = wy * z
    val zMwz = wz * z
    val zMxz = xz * z
    val zMyz = yz * z
    val zMwxy = wxy * z
    val zMwxz = wxz * z
    val zMwyz = wyz * z
    val zMxyz = xyz * z
    val zMi = i * z
    val wxMxy = wx * xy
    val wxMxz = wx * xz
    val wxMyz = wx * yz
    val wxMxyz = wx * xyz
    val wyMxy = wy * xy
    val wyMxz = wy * xz
    val wyMyz = wy * yz
    val wyMxyz = wy * xyz
    val wzMxy = wz * xy
    val wzMxz = wz * xz
    val wzMyz = wz * yz
    val wzMxyz = wz * xyz
    val xyMxy = xy * xy
    val xyMxz = xy * xz
    val xyMyz = xy * yz
    val xyMwxy = wxy * xy
    val xyMwxz = wxz * xy
    val xyMwyz = wyz * xy
    val xyMxyz = xy * xyz
    val xyMi = i * xy
    val xzMxz = xz * xz
    val xzMyz = xz * yz
    val xzMwxy = wxy * xz
    val xzMwxz = wxz * xz
    val xzMwyz = wyz * xz
    val xzMxyz = xyz * xz
    val xzMi = i * xz
    val yzMyz = yz * yz
    val yzMwxy = wxy * yz
    val yzMwxz = wxz * yz
    val yzMwyz = wyz * yz
    val yzMxyz = xyz * yz
    val yzMi = i * yz
    val wxyMxyz = wxy * xyz
    val wxzMxyz = wxz * xyz
    val wyzMxyz = wyz * xyz
    val xyzMxyz = xyz * xyz
    val xyzMi = i * xyz
    Multivector(
      s = v.s * (sMs + xMx + xyMxy + xyzMxyz + xzMxz + yMy + yzMyz + zMz),
      w = v.s * (-2.0 * xMwx - 2.0 * xyzMi - 2.0 * yMwy - 2.0 * zMwz + 2.0 * sMw + 2.0 * xyMwxy + 2.0 * xzMwxz + 2.0 * yzMwyz),
      x = v.s * (-2.0 * yMxy - 2.0 * zMxz + 2.0 * sMx + 2.0 * yzMxyz),
      y = v.s * (-2.0 * xzMxyz - 2.0 * zMyz + 2.0 * sMy + 2.0 * xMxy),
      z = 2.0 * v.s * (sMz + xMxz + xyMxyz + yMyz),
      wx = (-2.0 * sMi * v.yz - 2.0 * v.xz * wxyMxyz - 2.0 * v.xz * wyMyz - 2.0 * v.xz * xyMi - 2.0 * v.xz * yMwyz - 2.0 * v.yz * wMxyz - 2.0 * v.yz * wzMxy - 2.0 * v.yz * zMwxy + 2.0 * sMwy * v.xy + 2.0 * sMwz * v.xz + 2.0 * v.xy * wMy + 2.0 * v.xy * wxMxy + 2.0 * v.xy * wxzMxyz + 2.0 * v.xy * wzMyz + 2.0 * v.xy * xMwxy + 2.0 * v.xy * xzMi + 2.0 * v.xy * zMwyz + 2.0 * v.xz * wMz + 2.0 * v.xz * wxMxz + 2.0 * v.xz * xMwxz + 2.0 * v.yz * wxMyz + 2.0 * v.yz * wyMxz + 2.0 * v.yz * xMwyz + 2.0 * v.yz * yMwxz),
      wy = (-2.0 * sMwx * v.xy - 2.0 * v.xy * wMx - 2.0 * v.xy * wzMxz - 2.0 * v.xy * zMwxz - 2.0 * v.yz * wxMxz - 2.0 * v.yz * wxyMxyz - 2.0 * v.yz * xMwxz - 2.0 * v.yz * xyMi + 2.0 * sMi * v.xz + 2.0 * sMwz * v.yz + 2.0 * v.xy * wyMxy + 2.0 * v.xy * wyzMxyz + 2.0 * v.xy * yMwxy + 2.0 * v.xy * yzMi + 2.0 * v.xz * wMxyz + 2.0 * v.xz * wxMyz + 2.0 * v.xz * wyMxz + 2.0 * v.xz * wzMxy + 2.0 * v.xz * xMwyz + 2.0 * v.xz * yMwxz + 2.0 * v.xz * zMwxy + 2.0 * v.yz * wMz + 2.0 * v.yz * wyMyz + 2.0 * v.yz * yMwyz),
      wz = (-2.0 * sMi * v.xy - 2.0 * sMwx * v.xz - 2.0 * sMwy * v.yz - 2.0 * v.xy * wMxyz - 2.0 * v.xy * wxMyz - 2.0 * v.xy * xMwyz - 2.0 * v.xz * wMx - 2.0 * v.xz * wyMxy - 2.0 * v.xz * yMwxy - 2.0 * v.yz * wMy - 2.0 * v.yz * wxzMxyz - 2.0 * v.yz * xzMi + 2.0 * v.xy * wyMxz + 2.0 * v.xy * wzMxy + 2.0 * v.xy * yMwxz + 2.0 * v.xy * zMwxy + 2.0 * v.xz * wyzMxyz + 2.0 * v.xz * wzMxz + 2.0 * v.xz * yzMi + 2.0 * v.xz * zMwxz + 2.0 * v.yz * wxMxy + 2.0 * v.yz * wzMyz + 2.0 * v.yz * xMwxy + 2.0 * v.yz * zMwyz),
      xy = (sMs * v.xy + v.xy * xyMxy + v.xy * xyzMxyz + v.xy * zMz - 2.0 * sMyz * v.xz - 2.0 * v.xz * yMz - v.xy * xMx - v.xy * xzMxz - v.xy * yMy - v.xy * yzMyz + 2.0 * sMxz * v.yz + 2.0 * v.xz * xMxyz + 2.0 * v.xz * xyMxz + 2.0 * v.yz * xMz + 2.0 * v.yz * xyMyz + 2.0 * v.yz * yMxyz),
      xz = (sMs * v.xz + v.xz * xyzMxyz + v.xz * xzMxz + v.xz * yMy - 2.0 * sMxy * v.yz - 2.0 * v.xy * xMxyz - 2.0 * v.xy * yMz - 2.0 * v.yz * xMy - v.xz * xMx - v.xz * xyMxy - v.xz * yzMyz - v.xz * zMz + 2.0 * sMyz * v.xy + 2.0 * v.xy * xyMxz + 2.0 * v.yz * xzMyz + 2.0 * v.yz * zMxyz),
      yz = (sMs * v.yz + v.yz * xMx + v.yz * xyzMxyz + v.yz * yzMyz - 2.0 * sMxz * v.xy - 2.0 * v.xy * yMxyz - 2.0 * v.xz * xMy - 2.0 * v.xz * zMxyz - v.yz * xyMxy - v.yz * xzMxz - v.yz * yMy - v.yz * zMz + 2.0 * sMxy * v.xz + 2.0 * v.xy * xMz + 2.0 * v.xy * xyMyz + 2.0 * v.xz * xzMyz),
      wxy = (-2.0 * sMwyz * v.xz - 2.0 * v.xy * xyzMi - 2.0 * v.xy * xzMwxz - 2.0 * v.xy * yzMwyz - 2.0 * v.xy * zMwz - 2.0 * v.xz * wMyz - 2.0 * v.xz * wxMxyz - 2.0 * v.xz * xMi - 2.0 * v.yz * wyMxyz - 2.0 * v.yz * xMwz - 2.0 * v.yz * yMi - 2.0 * v.yz * zMwx + 2.0 * sMw * v.xy + 2.0 * sMwxz * v.yz + 2.0 * v.xy * xMwx + 2.0 * v.xy * xyMwxy + 2.0 * v.xy * yMwy + 2.0 * v.xz * xyMwxz + 2.0 * v.xz * xzMwxy + 2.0 * v.xz * yMwz + 2.0 * v.xz * zMwy + 2.0 * v.yz * wMxz + 2.0 * v.yz * xyMwyz + 2.0 * v.yz * yzMwxy),
      wxz = (-2.0 * sMwxy * v.yz - 2.0 * v.xz * xyMwxy - 2.0 * v.xz * xyzMi - 2.0 * v.xz * yMwy - 2.0 * v.xz * yzMwyz - 2.0 * v.yz * wMxy - 2.0 * v.yz * wzMxyz - 2.0 * v.yz * zMi + 2.0 * sMw * v.xz + 2.0 * sMwyz * v.xy + 2.0 * v.xy * wMyz + 2.0 * v.xy * wxMxyz + 2.0 * v.xy * xMi + 2.0 * v.xy * xyMwxz + 2.0 * v.xy * xzMwxy + 2.0 * v.xy * yMwz + 2.0 * v.xy * zMwy + 2.0 * v.xz * xMwx + 2.0 * v.xz * xzMwxz + 2.0 * v.xz * zMwz + 2.0 * v.yz * xMwy + 2.0 * v.yz * xzMwyz + 2.0 * v.yz * yMwx + 2.0 * v.yz * yzMwxz),
      wyz = (-2.0 * sMwxz * v.xy - 2.0 * v.xy * wMxz - 2.0 * v.xy * xMwz - 2.0 * v.xy * zMwx - 2.0 * v.yz * xMwx - 2.0 * v.yz * xyMwxy - 2.0 * v.yz * xyzMi - 2.0 * v.yz * xzMwxz + 2.0 * sMw * v.yz + 2.0 * sMwxy * v.xz + 2.0 * v.xy * wyMxyz + 2.0 * v.xy * xyMwyz + 2.0 * v.xy * yMi + 2.0 * v.xy * yzMwxy + 2.0 * v.xz * wMxy + 2.0 * v.xz * wzMxyz + 2.0 * v.xz * xMwy + 2.0 * v.xz * xzMwyz + 2.0 * v.xz * yMwx + 2.0 * v.xz * yzMwxz + 2.0 * v.xz * zMi + 2.0 * v.yz * yMwy + 2.0 * v.yz * yzMwyz + 2.0 * v.yz * zMwz),
      xyz = (-2.0 * sMy * v.xz - 2.0 * v.xy * xMxz - 2.0 * v.xy * yMyz - 2.0 * v.xz * zMyz + 2.0 * sMx * v.yz + 2.0 * sMz * v.xy + 2.0 * v.xy * xyMxyz + 2.0 * v.xz * xMxy + 2.0 * v.xz * xzMxyz + 2.0 * v.yz * yMxy + 2.0 * v.yz * yzMxyz + 2.0 * v.yz * zMxz),
      i = v.s * (-2.0 * wxMyz - 2.0 * wzMxy - 2.0 * xMwyz - 2.0 * zMwxy + 2.0 * sMi + 2.0 * wMxyz + 2.0 * wyMxz + 2.0 * yMwxz),
    )

  infix def reverseSandwich(v: QuaternionDual): Multivector =
    val sMs = s * s
    val sMx = s * x
    val sMy = s * y
    val sMz = s * z
    val sMxy = s * xy
    val sMxz = s * xz
    val sMyz = s * yz
    val sMxyz = s * xyz
    val xMx = x * x
    val xMy = x * y
    val xMz = x * z
    val xMxy = x * xy
    val xMxz = x * xz
    val xMyz = x * yz
    val xMxyz = x * xyz
    val yMy = y * y
    val yMz = y * z
    val yMxy = xy * y
    val yMxz = xz * y
    val yMyz = y * yz
    val yMxyz = xyz * y
    val zMz = z * z
    val zMxy = xy * z
    val zMxz = xz * z
    val zMyz = yz * z
    val zMxyz = xyz * z
    val xyMxy = xy * xy
    val xyMxz = xy * xz
    val xyMyz = xy * yz
    val xyMxyz = xy * xyz
    val xzMxz = xz * xz
    val xzMyz = xz * yz
    val xzMxyz = xyz * xz
    val yzMyz = yz * yz
    val yzMxyz = xyz * yz
    val xyzMxyz = xyz * xyz
    Multivector(
      s = 0.0,
      w = v.i * (-2.0 * sMxyz - 2.0 * yMxz + 2.0 * xMyz + 2.0 * zMxy),
      x = 0.0,
      y = 0.0,
      z = 0.0,
      wx = (sMs * v.wx + v.wx * yMy + v.wx * yzMyz + v.wx * zMz - 2.0 * sMxy * v.wy - 2.0 * sMxz * v.wz - 2.0 * v.wy * xMy - 2.0 * v.wy * xzMyz - 2.0 * v.wy * zMxyz - 2.0 * v.wz * xMz - v.wx * xMx - v.wx * xyMxy - v.wx * xyzMxyz - v.wx * xzMxz + 2.0 * v.wz * xyMyz + 2.0 * v.wz * yMxyz),
      wy = (sMs * v.wy + v.wy * xMx + v.wy * xzMxz + v.wy * zMz - 2.0 * sMyz * v.wz - 2.0 * v.wx * xMy - 2.0 * v.wx * xzMyz - 2.0 * v.wz * xMxyz - 2.0 * v.wz * xyMxz - 2.0 * v.wz * yMz - v.wy * xyMxy - v.wy * xyzMxyz - v.wy * yMy - v.wy * yzMyz + 2.0 * sMxy * v.wx + 2.0 * v.wx * zMxyz),
      wz = (sMs * v.wz + v.wz * xMx + v.wz * xyMxy + v.wz * yMy - 2.0 * v.wx * xMz - 2.0 * v.wx * yMxyz - 2.0 * v.wy * xyMxz - 2.0 * v.wy * yMz - v.wz * xyzMxyz - v.wz * xzMxz - v.wz * yzMyz - v.wz * zMz + 2.0 * sMxz * v.wx + 2.0 * sMyz * v.wy + 2.0 * v.wx * xyMyz + 2.0 * v.wy * xMxyz),
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
      wxy = (-2.0 * sMx * v.wy - 2.0 * v.wx * xMxy - 2.0 * v.wx * zMyz - 2.0 * v.wy * yMxy - 2.0 * v.wz * yMxz - 2.0 * v.wz * zMxy + 2.0 * sMxyz * v.wz + 2.0 * sMy * v.wx + 2.0 * v.wx * xzMxyz + 2.0 * v.wy * yzMxyz + 2.0 * v.wy * zMxz + 2.0 * v.wz * xMyz),
      wxz = (-2.0 * sMx * v.wz - 2.0 * sMxyz * v.wy - 2.0 * v.wx * xMxz - 2.0 * v.wx * xyMxyz - 2.0 * v.wy * xMyz - 2.0 * v.wy * yMxz - 2.0 * v.wy * zMxy - 2.0 * v.wz * zMxz + 2.0 * sMz * v.wx + 2.0 * v.wx * yMyz + 2.0 * v.wz * yMxy + 2.0 * v.wz * yzMxyz),
      wyz = (-2.0 * sMy * v.wz - 2.0 * v.wx * xMyz - 2.0 * v.wx * yMxz - 2.0 * v.wy * xyMxyz - 2.0 * v.wy * yMyz - 2.0 * v.wz * xMxy - 2.0 * v.wz * xzMxyz - 2.0 * v.wz * zMyz + 2.0 * sMxyz * v.wx + 2.0 * sMz * v.wy + 2.0 * v.wx * zMxy + 2.0 * v.wy * xMxz),
      xyz = 0.0,
      i = v.i * (sMs + xyMxy + xzMxz + yzMyz - xMx - xyzMxyz - yMy - zMz),
    )

  infix def reverseSandwich(v: PointIdeal): Multivector =
    val sMs = s * s
    val sMx = s * x
    val sMy = s * y
    val sMz = s * z
    val sMxy = s * xy
    val sMxz = s * xz
    val sMyz = s * yz
    val sMxyz = s * xyz
    val xMx = x * x
    val xMy = x * y
    val xMz = x * z
    val xMxy = x * xy
    val xMxz = x * xz
    val xMyz = x * yz
    val xMxyz = x * xyz
    val yMy = y * y
    val yMz = y * z
    val yMxy = xy * y
    val yMxz = xz * y
    val yMyz = y * yz
    val yMxyz = xyz * y
    val zMz = z * z
    val zMxy = xy * z
    val zMxz = xz * z
    val zMyz = yz * z
    val zMxyz = xyz * z
    val xyMxy = xy * xy
    val xyMxz = xy * xz
    val xyMyz = xy * yz
    val xyMxyz = xy * xyz
    val xzMxz = xz * xz
    val xzMyz = xz * yz
    val xzMxyz = xyz * xz
    val yzMyz = yz * yz
    val yzMxyz = xyz * yz
    val xyzMxyz = xyz * xyz
    Multivector(
      s = 0.0,
      w = 0.0,
      x = 0.0,
      y = 0.0,
      z = 0.0,
      wx = (-2.0 * sMxyz * v.wyz - 2.0 * v.wxz * xyMxyz - 2.0 * v.wxz * yMyz - 2.0 * v.wyz * zMxy + 2.0 * sMy * v.wxy + 2.0 * sMz * v.wxz + 2.0 * v.wxy * xMxy + 2.0 * v.wxy * xzMxyz + 2.0 * v.wxy * zMyz + 2.0 * v.wxz * xMxz + 2.0 * v.wyz * xMyz + 2.0 * v.wyz * yMxz),
      wy = (-2.0 * sMx * v.wxy - 2.0 * v.wxy * zMxz - 2.0 * v.wyz * xMxz - 2.0 * v.wyz * xyMxyz + 2.0 * sMxyz * v.wxz + 2.0 * sMz * v.wyz + 2.0 * v.wxy * yMxy + 2.0 * v.wxy * yzMxyz + 2.0 * v.wxz * xMyz + 2.0 * v.wxz * yMxz + 2.0 * v.wxz * zMxy + 2.0 * v.wyz * yMyz),
      wz = (-2.0 * sMx * v.wxz - 2.0 * sMxyz * v.wxy - 2.0 * sMy * v.wyz - 2.0 * v.wxy * xMyz - 2.0 * v.wxz * yMxy - 2.0 * v.wyz * xzMxyz + 2.0 * v.wxy * yMxz + 2.0 * v.wxy * zMxy + 2.0 * v.wxz * yzMxyz + 2.0 * v.wxz * zMxz + 2.0 * v.wyz * xMxy + 2.0 * v.wyz * zMyz),
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
      wxy = (sMs * v.wxy + v.wxy * xMx + v.wxy * xyMxy + v.wxy * yMy - 2.0 * sMyz * v.wxz - 2.0 * v.wxz * xMxyz - 2.0 * v.wyz * xMz - 2.0 * v.wyz * yMxyz - v.wxy * xyzMxyz - v.wxy * xzMxz - v.wxy * yzMyz - v.wxy * zMz + 2.0 * sMxz * v.wyz + 2.0 * v.wxz * xyMxz + 2.0 * v.wxz * yMz + 2.0 * v.wyz * xyMyz),
      wxz = (sMs * v.wxz + v.wxz * xMx + v.wxz * xzMxz + v.wxz * zMz - 2.0 * sMxy * v.wyz - 2.0 * v.wyz * zMxyz - v.wxz * xyMxy - v.wxz * xyzMxyz - v.wxz * yMy - v.wxz * yzMyz + 2.0 * sMyz * v.wxy + 2.0 * v.wxy * xMxyz + 2.0 * v.wxy * xyMxz + 2.0 * v.wxy * yMz + 2.0 * v.wyz * xMy + 2.0 * v.wyz * xzMyz),
      wyz = (sMs * v.wyz + v.wyz * yMy + v.wyz * yzMyz + v.wyz * zMz - 2.0 * sMxz * v.wxy - 2.0 * v.wxy * xMz - v.wyz * xMx - v.wyz * xyMxy - v.wyz * xyzMxyz - v.wyz * xzMxz + 2.0 * sMxy * v.wxz + 2.0 * v.wxy * xyMyz + 2.0 * v.wxy * yMxyz + 2.0 * v.wxz * xMy + 2.0 * v.wxz * xzMyz + 2.0 * v.wxz * zMxyz),
      xyz = 0.0,
      i = 0.0,
    )

  infix def reverseSandwich(v: PointNormalized): Multivector =
    val sMs = s * s
    val sMx = s * x
    val sMy = s * y
    val sMz = s * z
    val sMxy = s * xy
    val sMxz = s * xz
    val sMyz = s * yz
    val sMxyz = s * xyz
    val xMx = x * x
    val xMy = x * y
    val xMz = x * z
    val xMxy = x * xy
    val xMxz = x * xz
    val xMyz = x * yz
    val xMxyz = x * xyz
    val yMy = y * y
    val yMz = y * z
    val yMxy = xy * y
    val yMxz = xz * y
    val yMyz = y * yz
    val yMxyz = xyz * y
    val zMz = z * z
    val zMxy = xy * z
    val zMxz = xz * z
    val zMyz = yz * z
    val zMxyz = xyz * z
    val xyMxy = xy * xy
    val xyMxz = xy * xz
    val xyMyz = xy * yz
    val xyMxyz = xy * xyz
    val xzMxz = xz * xz
    val xzMyz = xz * yz
    val xzMxyz = xyz * xz
    val yzMyz = yz * yz
    val yzMxyz = xyz * yz
    val xyzMxyz = xyz * xyz
    Multivector(
      s = 0.0,
      w = 0.0,
      x = 0.0,
      y = 0.0,
      z = 0.0,
      wx = (-2.0 * i * x - 2.0 * sMxyz * v.wyz - 2.0 * v.wxz * xyMxyz - 2.0 * v.wxz * yMyz - 2.0 * v.wyz * zMxy - 2.0 * w * yz - 2.0 * wxy * xz - 2.0 * wz * y + 2.0 * s * wyz + 2.0 * sMy * v.wxy + 2.0 * sMz * v.wxz + 2.0 * v.wxy * xMxy + 2.0 * v.wxy * xzMxyz + 2.0 * v.wxy * zMyz + 2.0 * v.wxz * xMxz + 2.0 * v.wyz * xMyz + 2.0 * v.wyz * yMxz + 2.0 * wx * xyz + 2.0 * wxz * xy + 2.0 * wy * z),
      wy = (-2.0 * i * y - 2.0 * s * wxz - 2.0 * sMx * v.wxy - 2.0 * v.wxy * zMxz - 2.0 * v.wyz * xMxz - 2.0 * v.wyz * xyMxyz - 2.0 * wx * z - 2.0 * wxy * yz + 2.0 * sMxyz * v.wxz + 2.0 * sMz * v.wyz + 2.0 * v.wxy * yMxy + 2.0 * v.wxy * yzMxyz + 2.0 * v.wxz * xMyz + 2.0 * v.wxz * yMxz + 2.0 * v.wxz * zMxy + 2.0 * v.wyz * yMyz + 2.0 * w * xz + 2.0 * wy * xyz + 2.0 * wyz * xy + 2.0 * wz * x),
      wz = (-2.0 * i * z - 2.0 * sMx * v.wxz - 2.0 * sMxyz * v.wxy - 2.0 * sMy * v.wyz - 2.0 * v.wxy * xMyz - 2.0 * v.wxz * yMxy - 2.0 * v.wyz * xzMxyz - 2.0 * w * xy - 2.0 * wxz * yz - 2.0 * wy * x + 2.0 * s * wxy + 2.0 * v.wxy * yMxz + 2.0 * v.wxy * zMxy + 2.0 * v.wxz * yzMxyz + 2.0 * v.wxz * zMxz + 2.0 * v.wyz * xMxy + 2.0 * v.wyz * zMyz + 2.0 * wx * y + 2.0 * wyz * xz + 2.0 * wz * xyz),
      xy = 2.0 * (sMz + xMxz + xyMxyz + yMyz),
      xz = (-2.0 * sMy - 2.0 * xMxy + 2.0 * xzMxyz + 2.0 * zMyz),
      yz = (-2.0 * yMxy - 2.0 * zMxz + 2.0 * sMx + 2.0 * yzMxyz),
      wxy = (sMs * v.wxy + v.wxy * xMx + v.wxy * xyMxy + v.wxy * yMy - 2.0 * i * xy - 2.0 * s * wz - 2.0 * sMyz * v.wxz - 2.0 * v.wxz * xMxyz - 2.0 * v.wyz * xMz - 2.0 * v.wyz * yMxyz - 2.0 * wx * xz - 2.0 * wy * yz - v.wxy * xyzMxyz - v.wxy * xzMxz - v.wxy * yzMyz - v.wxy * zMz + 2.0 * sMxz * v.wyz + 2.0 * v.wxz * xyMxz + 2.0 * v.wxz * yMz + 2.0 * v.wyz * xyMyz + 2.0 * w * z + 2.0 * wxy * xyz + 2.0 * wxz * x + 2.0 * wyz * y),
      wxz = (sMs * v.wxz + v.wxz * xMx + v.wxz * xzMxz + v.wxz * zMz - 2.0 * i * xz - 2.0 * sMxy * v.wyz - 2.0 * v.wyz * zMxyz - 2.0 * w * y - 2.0 * wxy * x - 2.0 * wz * yz - v.wxz * xyMxy - v.wxz * xyzMxyz - v.wxz * yMy - v.wxz * yzMyz + 2.0 * s * wy + 2.0 * sMyz * v.wxy + 2.0 * v.wxy * xMxyz + 2.0 * v.wxy * xyMxz + 2.0 * v.wxy * yMz + 2.0 * v.wyz * xMy + 2.0 * v.wyz * xzMyz + 2.0 * wx * xy + 2.0 * wxz * xyz + 2.0 * wyz * z),
      wyz = (sMs * v.wyz + v.wyz * yMy + v.wyz * yzMyz + v.wyz * zMz - 2.0 * i * yz - 2.0 * s * wx - 2.0 * sMxz * v.wxy - 2.0 * v.wxy * xMz - 2.0 * wxy * y - 2.0 * wxz * z - v.wyz * xMx - v.wyz * xyMxy - v.wyz * xyzMxyz - v.wyz * xzMxz + 2.0 * sMxy * v.wxz + 2.0 * v.wxy * xyMyz + 2.0 * v.wxy * yMxyz + 2.0 * v.wxz * xMy + 2.0 * v.wxz * xzMyz + 2.0 * v.wxz * zMxyz + 2.0 * w * x + 2.0 * wy * xy + 2.0 * wyz * xyz + 2.0 * wz * xz),
      xyz = (sMs + xMx + xyMxy + xyzMxyz + xzMxz + yMy + yzMyz + zMz),
      i = 0.0,
    )

  infix def reverseSandwich(v: PlaneIdeal): Multivector =
    val sMs = s * s
    val sMxy = s * xy
    val sMxz = s * xz
    val sMyz = s * yz
    val xMx = x * x
    val xMy = x * y
    val xMz = x * z
    val xMxyz = x * xyz
    val yMy = y * y
    val yMz = y * z
    val yMxyz = xyz * y
    val zMz = z * z
    val zMxyz = xyz * z
    val xyMxy = xy * xy
    val xyMxz = xy * xz
    val xyMyz = xy * yz
    val xzMxz = xz * xz
    val xzMyz = xz * yz
    val yzMyz = yz * yz
    val xyzMxyz = xyz * xyz
    Multivector(
      s = (-2.0 * v.y * x * xy - 2.0 * v.y * xyz * xz - 2.0 * v.z * x * xz - 2.0 * v.z * y * yz + 2.0 * s * v.x * x + 2.0 * s * v.y * y + 2.0 * s * v.z * z + 2.0 * v.x * xy * y + 2.0 * v.x * xyz * yz + 2.0 * v.x * xz * z + 2.0 * v.y * yz * z + 2.0 * v.z * xy * xyz),
      w = (-2.0 * i * v.x * yz - 2.0 * i * v.z * xy - 2.0 * s * v.x * wx - 2.0 * s * v.y * wy - 2.0 * s * v.z * wz - 2.0 * v.x * wy * xy - 2.0 * v.x * wz * xz - 2.0 * v.y * wxy * x - 2.0 * v.y * wxz * xyz - 2.0 * v.y * wz * yz - 2.0 * v.z * wxz * x - 2.0 * v.z * wyz * y + 2.0 * i * v.y * xz + 2.0 * v.x * w * x + 2.0 * v.x * wxy * y + 2.0 * v.x * wxz * z + 2.0 * v.x * wyz * xyz + 2.0 * v.y * w * y + 2.0 * v.y * wx * xy + 2.0 * v.y * wyz * z + 2.0 * v.z * w * z + 2.0 * v.z * wx * xz + 2.0 * v.z * wxy * xyz + 2.0 * v.z * wy * yz),
      x = (sMs * v.x + v.x * xMx + v.x * xyzMxyz + v.x * yzMyz - 2.0 * sMxy * v.y - 2.0 * sMxz * v.z - 2.0 * v.y * xzMyz - 2.0 * v.z * yMxyz - v.x * xyMxy - v.x * xzMxz - v.x * yMy - v.x * zMz + 2.0 * v.y * xMy + 2.0 * v.y * zMxyz + 2.0 * v.z * xMz + 2.0 * v.z * xyMyz),
      y = (sMs * v.y + v.y * xyzMxyz + v.y * xzMxz + v.y * yMy - 2.0 * sMyz * v.z - 2.0 * v.x * xzMyz - 2.0 * v.x * zMxyz - 2.0 * v.z * xyMxz - v.y * xMx - v.y * xyMxy - v.y * yzMyz - v.y * zMz + 2.0 * sMxy * v.x + 2.0 * v.x * xMy + 2.0 * v.z * xMxyz + 2.0 * v.z * yMz),
      z = (sMs * v.z + v.z * xyMxy + v.z * xyzMxyz + v.z * zMz - 2.0 * v.y * xMxyz - 2.0 * v.y * xyMxz - v.z * xMx - v.z * xzMxz - v.z * yMy - v.z * yzMyz + 2.0 * sMxz * v.x + 2.0 * sMyz * v.y + 2.0 * v.x * xMz + 2.0 * v.x * xyMyz + 2.0 * v.x * yMxyz + 2.0 * v.y * yMz),
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
    val sMs = s * s
    val sMw = s * w
    val sMwx = s * wx
    val sMwy = s * wy
    val sMwz = s * wz
    val sMxy = s * xy
    val sMxz = s * xz
    val sMyz = s * yz
    val sMwxy = s * wxy
    val sMwxz = s * wxz
    val sMwyz = s * wyz
    val sMi = i * s
    val wMx = w * x
    val wMy = w * y
    val wMz = w * z
    val wMxy = w * xy
    val wMxz = w * xz
    val wMyz = w * yz
    val wMxyz = w * xyz
    val xMx = x * x
    val xMy = x * y
    val xMz = x * z
    val xMwx = wx * x
    val xMwy = wy * x
    val xMwz = wz * x
    val xMwxy = wxy * x
    val xMwxz = wxz * x
    val xMwyz = wyz * x
    val xMxyz = x * xyz
    val xMi = i * x
    val yMy = y * y
    val yMz = y * z
    val yMwx = wx * y
    val yMwy = wy * y
    val yMwz = wz * y
    val yMwxy = wxy * y
    val yMwxz = wxz * y
    val yMwyz = wyz * y
    val yMxyz = xyz * y
    val yMi = i * y
    val zMz = z * z
    val zMwx = wx * z
    val zMwy = wy * z
    val zMwz = wz * z
    val zMwxy = wxy * z
    val zMwxz = wxz * z
    val zMwyz = wyz * z
    val zMxyz = xyz * z
    val zMi = i * z
    val wxMxy = wx * xy
    val wxMxz = wx * xz
    val wxMyz = wx * yz
    val wxMxyz = wx * xyz
    val wyMxy = wy * xy
    val wyMxz = wy * xz
    val wyMyz = wy * yz
    val wyMxyz = wy * xyz
    val wzMxy = wz * xy
    val wzMxz = wz * xz
    val wzMyz = wz * yz
    val wzMxyz = wz * xyz
    val xyMxy = xy * xy
    val xyMxz = xy * xz
    val xyMyz = xy * yz
    val xyMwxy = wxy * xy
    val xyMwxz = wxz * xy
    val xyMwyz = wyz * xy
    val xyMi = i * xy
    val xzMxz = xz * xz
    val xzMyz = xz * yz
    val xzMwxy = wxy * xz
    val xzMwxz = wxz * xz
    val xzMwyz = wyz * xz
    val xzMi = i * xz
    val yzMyz = yz * yz
    val yzMwxy = wxy * yz
    val yzMwxz = wxz * yz
    val yzMwyz = wyz * yz
    val yzMi = i * yz
    val wxyMxyz = wxy * xyz
    val wxzMxyz = wxz * xyz
    val wyzMxyz = wyz * xyz
    val xyzMxyz = xyz * xyz
    val xyzMi = i * xyz
    Multivector(
      s = 0.0,
      w = 0.0,
      x = 0.0,
      y = 0.0,
      z = 0.0,
      wx = (-2.0 * sMi * v.yz - 2.0 * v.xz * wxyMxyz - 2.0 * v.xz * wyMyz - 2.0 * v.xz * xyMi - 2.0 * v.xz * yMwyz - 2.0 * v.yz * wMxyz - 2.0 * v.yz * wzMxy - 2.0 * v.yz * zMwxy + 2.0 * sMwy * v.xy + 2.0 * sMwz * v.xz + 2.0 * v.xy * wMy + 2.0 * v.xy * wxMxy + 2.0 * v.xy * wxzMxyz + 2.0 * v.xy * wzMyz + 2.0 * v.xy * xMwxy + 2.0 * v.xy * xzMi + 2.0 * v.xy * zMwyz + 2.0 * v.xz * wMz + 2.0 * v.xz * wxMxz + 2.0 * v.xz * xMwxz + 2.0 * v.yz * wxMyz + 2.0 * v.yz * wyMxz + 2.0 * v.yz * xMwyz + 2.0 * v.yz * yMwxz),
      wy = (-2.0 * sMwx * v.xy - 2.0 * v.xy * wMx - 2.0 * v.xy * wzMxz - 2.0 * v.xy * zMwxz - 2.0 * v.yz * wxMxz - 2.0 * v.yz * wxyMxyz - 2.0 * v.yz * xMwxz - 2.0 * v.yz * xyMi + 2.0 * sMi * v.xz + 2.0 * sMwz * v.yz + 2.0 * v.xy * wyMxy + 2.0 * v.xy * wyzMxyz + 2.0 * v.xy * yMwxy + 2.0 * v.xy * yzMi + 2.0 * v.xz * wMxyz + 2.0 * v.xz * wxMyz + 2.0 * v.xz * wyMxz + 2.0 * v.xz * wzMxy + 2.0 * v.xz * xMwyz + 2.0 * v.xz * yMwxz + 2.0 * v.xz * zMwxy + 2.0 * v.yz * wMz + 2.0 * v.yz * wyMyz + 2.0 * v.yz * yMwyz),
      wz = (-2.0 * sMi * v.xy - 2.0 * sMwx * v.xz - 2.0 * sMwy * v.yz - 2.0 * v.xy * wMxyz - 2.0 * v.xy * wxMyz - 2.0 * v.xy * xMwyz - 2.0 * v.xz * wMx - 2.0 * v.xz * wyMxy - 2.0 * v.xz * yMwxy - 2.0 * v.yz * wMy - 2.0 * v.yz * wxzMxyz - 2.0 * v.yz * xzMi + 2.0 * v.xy * wyMxz + 2.0 * v.xy * wzMxy + 2.0 * v.xy * yMwxz + 2.0 * v.xy * zMwxy + 2.0 * v.xz * wyzMxyz + 2.0 * v.xz * wzMxz + 2.0 * v.xz * yzMi + 2.0 * v.xz * zMwxz + 2.0 * v.yz * wxMxy + 2.0 * v.yz * wzMyz + 2.0 * v.yz * xMwxy + 2.0 * v.yz * zMwyz),
      xy = (sMs * v.xy + v.xy * xyMxy + v.xy * xyzMxyz + v.xy * zMz - 2.0 * sMyz * v.xz - 2.0 * v.xz * yMz - v.xy * xMx - v.xy * xzMxz - v.xy * yMy - v.xy * yzMyz + 2.0 * sMxz * v.yz + 2.0 * v.xz * xMxyz + 2.0 * v.xz * xyMxz + 2.0 * v.yz * xMz + 2.0 * v.yz * xyMyz + 2.0 * v.yz * yMxyz),
      xz = (sMs * v.xz + v.xz * xyzMxyz + v.xz * xzMxz + v.xz * yMy - 2.0 * sMxy * v.yz - 2.0 * v.xy * xMxyz - 2.0 * v.xy * yMz - 2.0 * v.yz * xMy - v.xz * xMx - v.xz * xyMxy - v.xz * yzMyz - v.xz * zMz + 2.0 * sMyz * v.xy + 2.0 * v.xy * xyMxz + 2.0 * v.yz * xzMyz + 2.0 * v.yz * zMxyz),
      yz = (sMs * v.yz + v.yz * xMx + v.yz * xyzMxyz + v.yz * yzMyz - 2.0 * sMxz * v.xy - 2.0 * v.xy * yMxyz - 2.0 * v.xz * xMy - 2.0 * v.xz * zMxyz - v.yz * xyMxy - v.yz * xzMxz - v.yz * yMy - v.yz * zMz + 2.0 * sMxy * v.xz + 2.0 * v.xy * xMz + 2.0 * v.xy * xyMyz + 2.0 * v.xz * xzMyz),
      wxy = (-2.0 * sMwyz * v.xz - 2.0 * v.xy * xyzMi - 2.0 * v.xy * xzMwxz - 2.0 * v.xy * yzMwyz - 2.0 * v.xy * zMwz - 2.0 * v.xz * wMyz - 2.0 * v.xz * wxMxyz - 2.0 * v.xz * xMi - 2.0 * v.yz * wyMxyz - 2.0 * v.yz * xMwz - 2.0 * v.yz * yMi - 2.0 * v.yz * zMwx + 2.0 * sMw * v.xy + 2.0 * sMwxz * v.yz + 2.0 * v.xy * xMwx + 2.0 * v.xy * xyMwxy + 2.0 * v.xy * yMwy + 2.0 * v.xz * xyMwxz + 2.0 * v.xz * xzMwxy + 2.0 * v.xz * yMwz + 2.0 * v.xz * zMwy + 2.0 * v.yz * wMxz + 2.0 * v.yz * xyMwyz + 2.0 * v.yz * yzMwxy),
      wxz = (-2.0 * sMwxy * v.yz - 2.0 * v.xz * xyMwxy - 2.0 * v.xz * xyzMi - 2.0 * v.xz * yMwy - 2.0 * v.xz * yzMwyz - 2.0 * v.yz * wMxy - 2.0 * v.yz * wzMxyz - 2.0 * v.yz * zMi + 2.0 * sMw * v.xz + 2.0 * sMwyz * v.xy + 2.0 * v.xy * wMyz + 2.0 * v.xy * wxMxyz + 2.0 * v.xy * xMi + 2.0 * v.xy * xyMwxz + 2.0 * v.xy * xzMwxy + 2.0 * v.xy * yMwz + 2.0 * v.xy * zMwy + 2.0 * v.xz * xMwx + 2.0 * v.xz * xzMwxz + 2.0 * v.xz * zMwz + 2.0 * v.yz * xMwy + 2.0 * v.yz * xzMwyz + 2.0 * v.yz * yMwx + 2.0 * v.yz * yzMwxz),
      wyz = (-2.0 * sMwxz * v.xy - 2.0 * v.xy * wMxz - 2.0 * v.xy * xMwz - 2.0 * v.xy * zMwx - 2.0 * v.yz * xMwx - 2.0 * v.yz * xyMwxy - 2.0 * v.yz * xyzMi - 2.0 * v.yz * xzMwxz + 2.0 * sMw * v.yz + 2.0 * sMwxy * v.xz + 2.0 * v.xy * wyMxyz + 2.0 * v.xy * xyMwyz + 2.0 * v.xy * yMi + 2.0 * v.xy * yzMwxy + 2.0 * v.xz * wMxy + 2.0 * v.xz * wzMxyz + 2.0 * v.xz * xMwy + 2.0 * v.xz * xzMwyz + 2.0 * v.xz * yMwx + 2.0 * v.xz * yzMwxz + 2.0 * v.xz * zMi + 2.0 * v.yz * yMwy + 2.0 * v.yz * yzMwyz + 2.0 * v.yz * zMwz),
      xyz = (-2.0 * s * v.xz * y - 2.0 * v.xy * x * xz - 2.0 * v.xy * y * yz - 2.0 * v.xz * yz * z + 2.0 * s * v.xy * z + 2.0 * s * v.yz * x + 2.0 * v.xy * xy * xyz + 2.0 * v.xz * x * xy + 2.0 * v.xz * xyz * xz + 2.0 * v.yz * xy * y + 2.0 * v.yz * xyz * yz + 2.0 * v.yz * xz * z),
      i = 0.0,
    )

  infix def reverseSandwich(v: BivectorWeight): Multivector =
    val sMs = s * s
    val sMx = s * x
    val sMy = s * y
    val sMz = s * z
    val sMxy = s * xy
    val sMxz = s * xz
    val sMyz = s * yz
    val sMxyz = s * xyz
    val xMx = x * x
    val xMy = x * y
    val xMz = x * z
    val xMxy = x * xy
    val xMxz = x * xz
    val xMyz = x * yz
    val xMxyz = x * xyz
    val yMy = y * y
    val yMz = y * z
    val yMxy = xy * y
    val yMxz = xz * y
    val yMyz = y * yz
    val yMxyz = xyz * y
    val zMz = z * z
    val zMxy = xy * z
    val zMxz = xz * z
    val zMyz = yz * z
    val zMxyz = xyz * z
    val xyMxy = xy * xy
    val xyMxz = xy * xz
    val xyMyz = xy * yz
    val xyMxyz = xy * xyz
    val xzMxz = xz * xz
    val xzMyz = xz * yz
    val xzMxyz = xyz * xz
    val yzMyz = yz * yz
    val yzMxyz = xyz * yz
    val xyzMxyz = xyz * xyz
    Multivector(
      s = 0.0,
      w = 0.0,
      x = 0.0,
      y = 0.0,
      z = 0.0,
      wx = (sMs * v.wx + v.wx * yMy + v.wx * yzMyz + v.wx * zMz - 2.0 * sMxy * v.wy - 2.0 * sMxz * v.wz - 2.0 * v.wy * xMy - 2.0 * v.wy * xzMyz - 2.0 * v.wy * zMxyz - 2.0 * v.wz * xMz - v.wx * xMx - v.wx * xyMxy - v.wx * xyzMxyz - v.wx * xzMxz + 2.0 * v.wz * xyMyz + 2.0 * v.wz * yMxyz),
      wy = (sMs * v.wy + v.wy * xMx + v.wy * xzMxz + v.wy * zMz - 2.0 * sMyz * v.wz - 2.0 * v.wx * xMy - 2.0 * v.wx * xzMyz - 2.0 * v.wz * xMxyz - 2.0 * v.wz * xyMxz - 2.0 * v.wz * yMz - v.wy * xyMxy - v.wy * xyzMxyz - v.wy * yMy - v.wy * yzMyz + 2.0 * sMxy * v.wx + 2.0 * v.wx * zMxyz),
      wz = (sMs * v.wz + v.wz * xMx + v.wz * xyMxy + v.wz * yMy - 2.0 * v.wx * xMz - 2.0 * v.wx * yMxyz - 2.0 * v.wy * xyMxz - 2.0 * v.wy * yMz - v.wz * xyzMxyz - v.wz * xzMxz - v.wz * yzMyz - v.wz * zMz + 2.0 * sMxz * v.wx + 2.0 * sMyz * v.wy + 2.0 * v.wx * xyMyz + 2.0 * v.wy * xMxyz),
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
      wxy = (-2.0 * sMx * v.wy - 2.0 * v.wx * xMxy - 2.0 * v.wx * zMyz - 2.0 * v.wy * yMxy - 2.0 * v.wz * yMxz - 2.0 * v.wz * zMxy + 2.0 * sMxyz * v.wz + 2.0 * sMy * v.wx + 2.0 * v.wx * xzMxyz + 2.0 * v.wy * yzMxyz + 2.0 * v.wy * zMxz + 2.0 * v.wz * xMyz),
      wxz = (-2.0 * sMx * v.wz - 2.0 * sMxyz * v.wy - 2.0 * v.wx * xMxz - 2.0 * v.wx * xyMxyz - 2.0 * v.wy * xMyz - 2.0 * v.wy * yMxz - 2.0 * v.wy * zMxy - 2.0 * v.wz * zMxz + 2.0 * sMz * v.wx + 2.0 * v.wx * yMyz + 2.0 * v.wz * yMxy + 2.0 * v.wz * yzMxyz),
      wyz = (-2.0 * sMy * v.wz - 2.0 * v.wx * xMyz - 2.0 * v.wx * yMxz - 2.0 * v.wy * xyMxyz - 2.0 * v.wy * yMyz - 2.0 * v.wz * xMxy - 2.0 * v.wz * xzMxyz - 2.0 * v.wz * zMyz + 2.0 * sMxyz * v.wx + 2.0 * sMz * v.wy + 2.0 * v.wx * zMxy + 2.0 * v.wy * xMxz),
      xyz = 0.0,
      i = 0.0,
    )

  infix def reverseSandwich(v: PseudoScalar): Multivector =
    Multivector(
      s = 0.0,
      w = v.i * (-2.0 * s * xyz - 2.0 * xz * y + 2.0 * x * yz + 2.0 * xy * z),
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
      i = v.i * (s * s + xy * xy + xz * xz + yz * yz - x * x - xyz * xyz - y * y - z * z),
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
      xy = 2.0 * (s * z + x * xz + xy * xyz + y * yz),
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