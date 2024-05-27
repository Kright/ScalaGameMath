package com.github.kright.pga3d

/** this code is generated, see com.github.kright.pga3d.codegen.CodeGenClass */
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

  def unary_- : Multivector =
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

  infix def geometric(v: Translator): Multivector =
    Multivector(
      s = s,
      w = (w - v.wx * x - v.wy * y - v.wz * z),
      x = x,
      y = y,
      z = z,
      wx = (wx + s * v.wx + v.wy * xy + v.wz * xz),
      wy = (wy + s * v.wy + v.wz * yz - v.wx * xy),
      wz = (wz + s * v.wz - v.wx * xz - v.wy * yz),
      xy = xy,
      xz = xz,
      yz = yz,
      wxy = (wxy + v.wx * y - v.wy * x - v.wz * xyz),
      wxz = (wxz + v.wx * z + v.wy * xyz - v.wz * x),
      wyz = (wyz + v.wy * z - v.wx * xyz - v.wz * y),
      xyz = xyz,
      i = (i + v.wx * yz + v.wz * xy - v.wy * xz),
    )

  infix def geometric(v: Vector): Multivector =
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

  infix def dot(v: Translator): Multivector =
    Multivector(
      s = s,
      w = (w - v.wx * x - v.wy * y - v.wz * z),
      x = x,
      y = y,
      z = z,
      wx = (wx + s * v.wx),
      wy = (wy + s * v.wy),
      wz = (wz + s * v.wz),
      xy = xy,
      xz = xz,
      yz = yz,
      wxy = wxy,
      wxz = wxz,
      wyz = wyz,
      xyz = xyz,
      i = i,
    )

  infix def dot(v: Vector): Multivector =
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

  infix def wedge(v: Translator): Multivector =
    Multivector(
      s = s,
      w = w,
      x = x,
      y = y,
      z = z,
      wx = (wx + s * v.wx),
      wy = (wy + s * v.wy),
      wz = (wz + s * v.wz),
      xy = xy,
      xz = xz,
      yz = yz,
      wxy = (wxy + v.wx * y - v.wy * x),
      wxz = (wxz + v.wx * z - v.wz * x),
      wyz = (wyz + v.wy * z - v.wz * y),
      xyz = xyz,
      i = (i + v.wx * yz + v.wz * xy - v.wy * xz),
    )

  inline infix def ^(v: Translator): Multivector = wedge(v)

  infix def wedge(v: Vector): Multivector =
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

  inline infix def ^(v: Vector): Multivector = wedge(v)

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

  infix def antiGeometric(v: Translator): Multivector =
    Multivector(
      s = (i + v.wx * yz + v.wz * xy - v.wy * xz),
      w = (v.wy * wxz - v.wx * wyz - v.wz * wxy),
      x = (-wyz + v.wy * z - v.wx * xyz - v.wz * y),
      y = (wxz + v.wz * x - v.wx * z - v.wy * xyz),
      z = (-wxy + v.wx * y - v.wy * x - v.wz * xyz),
      wx = (i * v.wx + v.wy * wz - v.wz * wy),
      wy = (i * v.wy + v.wz * wx - v.wx * wz),
      wz = (i * v.wz + v.wx * wy - v.wy * wx),
      xy = (-wz - s * v.wz - v.wx * xz - v.wy * yz),
      xz = (wy + s * v.wy + v.wx * xy - v.wz * yz),
      yz = (-wx + v.wy * xy + v.wz * xz - s * v.wx),
      wxy = (v.wz * w - v.wx * wxz - v.wy * wyz),
      wxz = (v.wx * wxy - v.wy * w - v.wz * wyz),
      wyz = (v.wx * w + v.wy * wxy + v.wz * wxz),
      xyz = (w + v.wx * x + v.wy * y + v.wz * z),
      i = (-v.wx * wx - v.wy * wy - v.wz * wz),
    )

  infix def antiGeometric(v: Vector): Multivector =
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

  infix def antiDot(v: Translator): Multivector =
    Multivector(
      s = i,
      w = 0.0,
      x = -wyz,
      y = wxz,
      z = -wxy,
      wx = i * v.wx,
      wy = i * v.wy,
      wz = i * v.wz,
      xy = (-wz - s * v.wz),
      xz = (wy + s * v.wy),
      yz = (-wx - s * v.wx),
      wxy = (v.wz * w - v.wx * wxz - v.wy * wyz),
      wxz = (v.wx * wxy - v.wy * w - v.wz * wyz),
      wyz = (v.wx * w + v.wy * wxy + v.wz * wxz),
      xyz = (w + v.wx * x + v.wy * y + v.wz * z),
      i = (-v.wx * wx - v.wy * wy - v.wz * wz),
    )

  infix def antiDot(v: Vector): Multivector =
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

  infix def antiWedge(v: Translator): Multivector =
    Multivector(
      s = (i + v.wx * yz + v.wz * xy - v.wy * xz),
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

  inline infix def v(v: Translator): Multivector = antiWedge(v)

  infix def antiWedge(v: Vector): Multivector =
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

  inline infix def v(v: Vector): Multivector = antiWedge(v)

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
      s = (2.0 * (v.x * (sMx + yzMxyz - yMxy - zMxz) + v.y * (sMy + xMxy - xzMxyz - zMyz) + v.z * (sMz + xMxz + xyMxyz + yMyz)) + v.s * (sMs + xMx + xyMxy + xyzMxyz + xzMxz + yMy + yzMyz + zMz)),
      w = (2.0 * (v.i * (sMxyz + yMxz - xMyz - zMxy) + v.s * (sMw + xMwx + xyMwxy + xyzMi + xzMwxz + yMwy + yzMwyz + zMwz) + v.x * (sMwx + wMx + wyzMxyz + yzMi - wyMxy - wzMxz - yMwxy - zMwxz) + v.y * (sMwy + wMy + wxMxy + xMwxy - wxzMxyz - wzMyz - xzMi - zMwyz) + v.z * (sMwz + wMz + wxMxz + wxyMxyz + wyMyz + xMwxz + xyMi + yMwyz)) + v.w * (sMs + xyMxy + xzMxz + yzMyz - xMx - xyzMxyz - yMy - zMz)),
      x = (2.0 * (v.s * (sMx + yMxy + yzMxyz + zMxz) + v.y * (sMxy + xMy - xzMyz - zMxyz) + v.z * (sMxz + xMz + xyMyz + yMxyz)) + v.x * (sMs + xMx + xyzMxyz + yzMyz - xyMxy - xzMxz - yMy - zMz)),
      y = (2.0 * (v.s * (sMy + zMyz - xMxy - xzMxyz) + v.x * (xMy + zMxyz - sMxy - xzMyz) + v.z * (sMyz + yMz - xMxyz - xyMxz)) + v.y * (sMs + xyzMxyz + xzMxz + yMy - xMx - xyMxy - yzMyz - zMz)),
      z = (2.0 * (v.s * (sMz + xyMxyz - xMxz - yMyz) + v.x * (xMz + xyMyz - sMxz - yMxyz) + v.y * (xMxyz + yMz - sMyz - xyMxz)) + v.z * (sMs + xyMxy + xyzMxyz + zMz - xMx - xzMxz - yMy - yzMyz)),
      wx = (2.0 * (v.wxy * (sMy + xzMxyz - xMxy - zMyz) + v.wxz * (sMz + yMyz - xMxz - xyMxyz) + v.wy * (sMxy + zMxyz - xMy - xzMyz) + v.wyz * (sMxyz + zMxy - xMyz - yMxz) + v.wz * (sMxz + xyMyz - xMz - yMxyz) + v.xy * (wMy + wxMxy + wxzMxyz + wzMyz - sMwy - xMwxy - xzMi - zMwyz) + v.xyz * (wMyz + wxMxyz + xyMwxz + yMwz - sMwyz - xMi - xzMwxy - zMwy) + v.xz * (wMz + wxMxz + xyMi + yMwyz - sMwz - wxyMxyz - wyMyz - xMwxz) + v.yz * (wMxyz + wxMyz + wyMxz + zMwxy - sMi - wzMxy - xMwyz - yMwxz)) + v.wx * (sMs + yMy + yzMyz + zMz - xMx - xyMxy - xyzMxyz - xzMxz)),
      wy = (2.0 * (v.wx * (-sMxy - xMy - xzMyz - zMxyz) + v.wxy * (yzMxyz + zMxz - sMx - yMxy) + v.wxz * (-sMxyz - xMyz - yMxz - zMxy) + v.wyz * (sMz + xMxz - xyMxyz - yMyz) + v.wz * (sMyz + xMxyz - xyMxz - yMz) + v.xy * (sMwx + wyMxy + wyzMxyz + zMwxz - wMx - wzMxz - yMwxy - yzMi) + v.xyz * (sMwxz + wyMxyz + xyMwyz + zMwx - wMxz - xMwz - yMi - yzMwxy) + v.xz * (sMi + wxMyz + wyMxz + wzMxy - wMxyz - xMwyz - yMwxz - zMwxy) + v.yz * (wMz + wyMyz + xMwxz + xyMi - sMwz - wxMxz - wxyMxyz - yMwyz)) + v.wy * (sMs + xMx + xzMxz + zMz - xyMxy - xyzMxyz - yMy - yzMyz)),
      wz = (2.0 * (v.wx * (xyMyz + yMxyz - sMxz - xMz) + v.wxy * (sMxyz + xMyz - yMxz - zMxy) + v.wxz * (yMxy + yzMxyz - sMx - zMxz) + v.wy * (-sMyz - xMxyz - xyMxz - yMz) + v.wyz * (-sMy - xMxy - xzMxyz - zMyz) + v.xy * (wMxyz + wyMxz + wzMxy + xMwyz - sMi - wxMyz - yMwxz - zMwxy) + v.xyz * (wMxy + wzMxyz + xMwy + xzMwyz - sMwxy - yMwx - yzMwxz - zMi) + v.xz * (sMwx + wyzMxyz + wzMxz + yMwxy - wMx - wyMxy - yzMi - zMwxz) + v.yz * (sMwy + wxMxy + wzMyz + xzMi - wMy - wxzMxyz - xMwxy - zMwyz)) + v.wz * (sMs + xMx + xyMxy + yMy - xyzMxyz - xzMxz - yzMyz - zMz)),
      xy = (2.0 * (v.xyz * (sMz + xyMxyz - xMxz - yMyz) + v.xz * (sMyz + xyMxz - xMxyz - yMz) + v.yz * (xMz + xyMyz - sMxz - yMxyz)) + v.xy * (sMs + xyMxy + xyzMxyz + zMz - xMx - xzMxz - yMy - yzMyz)),
      xz = (2.0 * (v.xy * (xMxyz + xyMxz - sMyz - yMz) + v.xyz * (xMxy + xzMxyz - sMy - zMyz) + v.yz * (sMxy + xzMyz - xMy - zMxyz)) + v.xz * (sMs + xyzMxyz + xzMxz + yMy - xMx - xyMxy - yzMyz - zMz)),
      yz = (2.0 * (v.xy * (sMxz + xMz + xyMyz + yMxyz) + v.xyz * (sMx + yMxy + yzMxyz + zMxz) + v.xz * (xzMyz + zMxyz - sMxy - xMy)) + v.yz * (sMs + xMx + xyzMxyz + yzMyz - xyMxy - xzMxz - yMy - zMz)),
      wxy = (2.0 * (v.wx * (sMy + xMxy + xzMxyz + zMyz) + v.wxz * (sMyz + xMxyz + xyMxz + yMz) + v.wy * (yMxy + yzMxyz - sMx - zMxz) + v.wyz * (xyMyz + yMxyz - sMxz - xMz) + v.wz * (yMxz + zMxy - sMxyz - xMyz) + v.xy * (sMw + xyMwxy + xyzMi + zMwz - xMwx - xzMwxz - yMwy - yzMwyz) + v.xyz * (sMwz + wMz + wxyMxyz + xyMi - wxMxz - wyMyz - xMwxz - yMwyz) + v.xz * (sMwyz + wMyz + xyMwxz + xzMwxy - wxMxyz - xMi - yMwz - zMwy) + v.yz * (xMwz + xyMwyz + yzMwxy + zMwx - sMwxz - wMxz - wyMxyz - yMi)) + v.wxy * (sMs + xMx + xyMxy + yMy - xyzMxyz - xzMxz - yzMyz - zMz)),
      wxz = (2.0 * (v.wx * (sMz + xMxz - xyMxyz - yMyz) + v.wxy * (xyMxz + yMz - sMyz - xMxyz) + v.wy * (sMxyz + xMyz + yMxz + zMxy) + v.wyz * (sMxy + xMy + xzMyz + zMxyz) + v.wz * (yzMxyz + zMxz - sMx - yMxy) + v.xy * (wxMxyz + xMi + xyMwxz + xzMwxy - sMwyz - wMyz - yMwz - zMwy) + v.xyz * (wxMxy + wxzMxyz + xMwxy + xzMi - sMwy - wMy - wzMyz - zMwyz) + v.xz * (sMw + xyzMi + xzMwxz + yMwy - xMwx - xyMwxy - yzMwyz - zMwz) + v.yz * (sMwxy + wMxy + xzMwyz + yzMwxz - wzMxyz - xMwy - yMwx - zMi)) + v.wxz * (sMs + xMx + xzMxz + zMz - xyMxy - xyzMxyz - yMy - yzMyz)),
      wyz = (2.0 * (v.wx * (xMyz + yMxz - sMxyz - zMxy) + v.wxy * (sMxz + xyMyz - xMz - yMxyz) + v.wxz * (xMy + xzMyz - sMxy - zMxyz) + v.wy * (sMz + yMyz - xMxz - xyMxyz) + v.wz * (xMxy + zMyz - sMy - xzMxyz) + v.xy * (sMwxz + wMxz + wyMxyz + xMwz + xyMwyz + yMi + yzMwxy + zMwx) + v.xyz * (sMwx + wMx + wyMxy + wyzMxyz + wzMxz + yMwxy + yzMi + zMwxz) + v.xz * (wzMxyz + xzMwyz + yzMwxz + zMi - sMwxy - wMxy - xMwy - yMwx) + v.yz * (sMw + xMwx + xyzMi + yzMwyz - xyMwxy - xzMwxz - yMwy - zMwz)) + v.wyz * (sMs + yMy + yzMyz + zMz - xMx - xyMxy - xyzMxyz - xzMxz)),
      xyz = (2.0 * (v.xy * (sMz + xMxz + xyMxyz + yMyz) + v.xz * (xzMxyz + zMyz - sMy - xMxy) + v.yz * (sMx + yzMxyz - yMxy - zMxz)) + v.xyz * (sMs + xMx + xyMxy + xyzMxyz + xzMxz + yMy + yzMyz + zMz)),
      i = (2.0 * (v.s * (sMi + wyMxz + xMwyz + zMwxy - wMxyz - wxMyz - wzMxy - yMwxz) + v.w * (xMyz + zMxy - sMxyz - yMxz) + v.x * (sMwyz + xMi + xyMwxz + yMwz - wMyz - wxMxyz - xzMwxy - zMwy) + v.y * (wMxz + xyMwyz + yMi + zMwx - sMwxz - wyMxyz - xMwz - yzMwxy) + v.z * (sMwxy + xMwy + xzMwyz + zMi - wMxy - wzMxyz - yMwx - yzMwxz)) + v.i * (sMs + xyMxy + xzMxz + yzMyz - xMx - xyzMxyz - yMy - zMz)),
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
      w = 2.0 * (v.i * (sMxyz + yMxz - xMyz - zMxy) + v.s * (sMw + xMwx + xyMwxy + xyzMi + xzMwxz + yMwy + yzMwyz + zMwz)),
      x = 2.0 * v.s * (sMx + yMxy + yzMxyz + zMxz),
      y = 2.0 * v.s * (sMy + zMyz - xMxy - xzMxyz),
      z = 2.0 * v.s * (sMz + xyMxyz - xMxz - yMyz),
      wx = (2.0 * (v.wy * (sMxy + zMxyz - xMy - xzMyz) + v.wz * (sMxz + xyMyz - xMz - yMxyz) + v.xy * (wMy + wxMxy + wxzMxyz + wzMyz - sMwy - xMwxy - xzMi - zMwyz) + v.xz * (wMz + wxMxz + xyMi + yMwyz - sMwz - wxyMxyz - wyMyz - xMwxz) + v.yz * (wMxyz + wxMyz + wyMxz + zMwxy - sMi - wzMxy - xMwyz - yMwxz)) + v.wx * (sMs + yMy + yzMyz + zMz - xMx - xyMxy - xyzMxyz - xzMxz)),
      wy = (2.0 * (v.wx * (-sMxy - xMy - xzMyz - zMxyz) + v.wz * (sMyz + xMxyz - xyMxz - yMz) + v.xy * (sMwx + wyMxy + wyzMxyz + zMwxz - wMx - wzMxz - yMwxy - yzMi) + v.xz * (sMi + wxMyz + wyMxz + wzMxy - wMxyz - xMwyz - yMwxz - zMwxy) + v.yz * (wMz + wyMyz + xMwxz + xyMi - sMwz - wxMxz - wxyMxyz - yMwyz)) + v.wy * (sMs + xMx + xzMxz + zMz - xyMxy - xyzMxyz - yMy - yzMyz)),
      wz = (2.0 * (v.wx * (xyMyz + yMxyz - sMxz - xMz) + v.wy * (-sMyz - xMxyz - xyMxz - yMz) + v.xy * (wMxyz + wyMxz + wzMxy + xMwyz - sMi - wxMyz - yMwxz - zMwxy) + v.xz * (sMwx + wyzMxyz + wzMxz + yMwxy - wMx - wyMxy - yzMi - zMwxz) + v.yz * (sMwy + wxMxy + wzMyz + xzMi - wMy - wxzMxyz - xMwxy - zMwyz)) + v.wz * (sMs + xMx + xyMxy + yMy - xyzMxyz - xzMxz - yzMyz - zMz)),
      xy = (2.0 * (v.xz * (sMyz + xyMxz - xMxyz - yMz) + v.yz * (xMz + xyMyz - sMxz - yMxyz)) + v.xy * (sMs + xyMxy + xyzMxyz + zMz - xMx - xzMxz - yMy - yzMyz)),
      xz = (2.0 * (v.xy * (xMxyz + xyMxz - sMyz - yMz) + v.yz * (sMxy + xzMyz - xMy - zMxyz)) + v.xz * (sMs + xyzMxyz + xzMxz + yMy - xMx - xyMxy - yzMyz - zMz)),
      yz = (2.0 * (v.xy * (sMxz + xMz + xyMyz + yMxyz) + v.xz * (xzMyz + zMxyz - sMxy - xMy)) + v.yz * (sMs + xMx + xyzMxyz + yzMyz - xyMxy - xzMxz - yMy - zMz)),
      wxy = 2.0 * (v.wx * (sMy + xMxy + xzMxyz + zMyz) + v.wy * (yMxy + yzMxyz - sMx - zMxz) + v.wz * (yMxz + zMxy - sMxyz - xMyz) + v.xy * (sMw + xyMwxy + xyzMi + zMwz - xMwx - xzMwxz - yMwy - yzMwyz) + v.xz * (sMwyz + wMyz + xyMwxz + xzMwxy - wxMxyz - xMi - yMwz - zMwy) + v.yz * (xMwz + xyMwyz + yzMwxy + zMwx - sMwxz - wMxz - wyMxyz - yMi)),
      wxz = 2.0 * (v.wx * (sMz + xMxz - xyMxyz - yMyz) + v.wy * (sMxyz + xMyz + yMxz + zMxy) + v.wz * (yzMxyz + zMxz - sMx - yMxy) + v.xy * (wxMxyz + xMi + xyMwxz + xzMwxy - sMwyz - wMyz - yMwz - zMwy) + v.xz * (sMw + xyzMi + xzMwxz + yMwy - xMwx - xyMwxy - yzMwyz - zMwz) + v.yz * (sMwxy + wMxy + xzMwyz + yzMwxz - wzMxyz - xMwy - yMwx - zMi)),
      wyz = 2.0 * (v.wx * (xMyz + yMxz - sMxyz - zMxy) + v.wy * (sMz + yMyz - xMxz - xyMxyz) + v.wz * (xMxy + zMyz - sMy - xzMxyz) + v.xy * (sMwxz + wMxz + wyMxyz + xMwz + xyMwyz + yMi + yzMwxy + zMwx) + v.xz * (wzMxyz + xzMwyz + yzMwxz + zMi - sMwxy - wMxy - xMwy - yMwx) + v.yz * (sMw + xMwx + xyzMi + yzMwyz - xyMwxy - xzMwxz - yMwy - zMwz)),
      xyz = 2.0 * (v.xy * (sMz + xMxz + xyMxyz + yMyz) + v.xz * (xzMxyz + zMyz - sMy - xMxy) + v.yz * (sMx + yzMxyz - yMxy - zMxz)),
      i = (v.i * (sMs + xyMxy + xzMxz + yzMyz - xMx - xyzMxyz - yMy - zMz) + 2.0 * v.s * (sMi + wyMxz + xMwyz + zMwxy - wMxyz - wxMyz - wzMxy - yMwxz)),
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
      s = 2.0 * (v.x * (s * x + xyz * yz - xy * y - xz * z) + v.y * (s * y + x * xy - xyz * xz - yz * z) + v.z * (s * z + x * xz + xy * xyz + y * yz)),
      w = (2.0 * (v.x * (i * yz + s * wx + w * x + wyz * xyz - wxy * y - wxz * z - wy * xy - wz * xz) + v.y * (s * wy + w * y + wx * xy + wxy * x - i * xz - wxz * xyz - wyz * z - wz * yz) + v.z * (i * xy + s * wz + w * z + wx * xz + wxy * xyz + wxz * x + wy * yz + wyz * y)) + v.w * (sMs + xyMxy + xzMxz + yzMyz - xMx - xyzMxyz - yMy - zMz)),
      x = (2.0 * (v.y * (sMxy + xMy - xzMyz - zMxyz) + v.z * (sMxz + xMz + xyMyz + yMxyz)) + v.x * (sMs + xMx + xyzMxyz + yzMyz - xyMxy - xzMxz - yMy - zMz)),
      y = (2.0 * (v.x * (xMy + zMxyz - sMxy - xzMyz) + v.z * (sMyz + yMz - xMxyz - xyMxz)) + v.y * (sMs + xyzMxyz + xzMxz + yMy - xMx - xyMxy - yzMyz - zMz)),
      z = (2.0 * (v.x * (xMz + xyMyz - sMxz - yMxyz) + v.y * (xMxyz + yMz - sMyz - xyMxz)) + v.z * (sMs + xyMxy + xyzMxyz + zMz - xMx - xzMxz - yMy - yzMyz)),
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
      i = 2.0 * (v.w * (x * yz + xy * z - s * xyz - xz * y) + v.x * (i * x + s * wyz + wxz * xy + wz * y - w * yz - wx * xyz - wxy * xz - wy * z) + v.y * (i * y + w * xz + wx * z + wyz * xy - s * wxz - wxy * yz - wy * xyz - wz * x) + v.z * (i * z + s * wxy + wy * x + wyz * xz - w * xy - wx * y - wxz * yz - wz * xyz)),
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
      wx = (2.0 * (v.wy * (sMxy + zMxyz - xMy - xzMyz) + v.wz * (sMxz + xyMyz - xMz - yMxyz) + v.xy * (wMy + wxMxy + wxzMxyz + wzMyz - sMwy - xMwxy - xzMi - zMwyz) + v.xz * (wMz + wxMxz + xyMi + yMwyz - sMwz - wxyMxyz - wyMyz - xMwxz) + v.yz * (wMxyz + wxMyz + wyMxz + zMwxy - sMi - wzMxy - xMwyz - yMwxz)) + v.wx * (sMs + yMy + yzMyz + zMz - xMx - xyMxy - xyzMxyz - xzMxz)),
      wy = (2.0 * (v.wx * (-sMxy - xMy - xzMyz - zMxyz) + v.wz * (sMyz + xMxyz - xyMxz - yMz) + v.xy * (sMwx + wyMxy + wyzMxyz + zMwxz - wMx - wzMxz - yMwxy - yzMi) + v.xz * (sMi + wxMyz + wyMxz + wzMxy - wMxyz - xMwyz - yMwxz - zMwxy) + v.yz * (wMz + wyMyz + xMwxz + xyMi - sMwz - wxMxz - wxyMxyz - yMwyz)) + v.wy * (sMs + xMx + xzMxz + zMz - xyMxy - xyzMxyz - yMy - yzMyz)),
      wz = (2.0 * (v.wx * (xyMyz + yMxyz - sMxz - xMz) + v.wy * (-sMyz - xMxyz - xyMxz - yMz) + v.xy * (wMxyz + wyMxz + wzMxy + xMwyz - sMi - wxMyz - yMwxz - zMwxy) + v.xz * (sMwx + wyzMxyz + wzMxz + yMwxy - wMx - wyMxy - yzMi - zMwxz) + v.yz * (sMwy + wxMxy + wzMyz + xzMi - wMy - wxzMxyz - xMwxy - zMwyz)) + v.wz * (sMs + xMx + xyMxy + yMy - xyzMxyz - xzMxz - yzMyz - zMz)),
      xy = (2.0 * (v.xz * (sMyz + xyMxz - xMxyz - yMz) + v.yz * (xMz + xyMyz - sMxz - yMxyz)) + v.xy * (sMs + xyMxy + xyzMxyz + zMz - xMx - xzMxz - yMy - yzMyz)),
      xz = (2.0 * (v.xy * (xMxyz + xyMxz - sMyz - yMz) + v.yz * (sMxy + xzMyz - xMy - zMxyz)) + v.xz * (sMs + xyzMxyz + xzMxz + yMy - xMx - xyMxy - yzMyz - zMz)),
      yz = (2.0 * (v.xy * (sMxz + xMz + xyMyz + yMxyz) + v.xz * (xzMyz + zMxyz - sMxy - xMy)) + v.yz * (sMs + xMx + xyzMxyz + yzMyz - xyMxy - xzMxz - yMy - zMz)),
      wxy = 2.0 * (v.wx * (sMy + xMxy + xzMxyz + zMyz) + v.wy * (yMxy + yzMxyz - sMx - zMxz) + v.wz * (yMxz + zMxy - sMxyz - xMyz) + v.xy * (sMw + xyMwxy + xyzMi + zMwz - xMwx - xzMwxz - yMwy - yzMwyz) + v.xz * (sMwyz + wMyz + xyMwxz + xzMwxy - wxMxyz - xMi - yMwz - zMwy) + v.yz * (xMwz + xyMwyz + yzMwxy + zMwx - sMwxz - wMxz - wyMxyz - yMi)),
      wxz = 2.0 * (v.wx * (sMz + xMxz - xyMxyz - yMyz) + v.wy * (sMxyz + xMyz + yMxz + zMxy) + v.wz * (yzMxyz + zMxz - sMx - yMxy) + v.xy * (wxMxyz + xMi + xyMwxz + xzMwxy - sMwyz - wMyz - yMwz - zMwy) + v.xz * (sMw + xyzMi + xzMwxz + yMwy - xMwx - xyMwxy - yzMwyz - zMwz) + v.yz * (sMwxy + wMxy + xzMwyz + yzMwxz - wzMxyz - xMwy - yMwx - zMi)),
      wyz = 2.0 * (v.wx * (xMyz + yMxz - sMxyz - zMxy) + v.wy * (sMz + yMyz - xMxz - xyMxyz) + v.wz * (xMxy + zMyz - sMy - xzMxyz) + v.xy * (sMwxz + wMxz + wyMxyz + xMwz + xyMwyz + yMi + yzMwxy + zMwx) + v.xz * (wzMxyz + xzMwyz + yzMwxz + zMi - sMwxy - wMxy - xMwy - yMwx) + v.yz * (sMw + xMwx + xyzMi + yzMwyz - xyMwxy - xzMwxz - yMwy - zMwz)),
      xyz = 2.0 * (v.xy * (sMz + xMxz + xyMxyz + yMyz) + v.xz * (xzMxyz + zMyz - sMy - xMxy) + v.yz * (sMx + yzMxyz - yMxy - zMxz)),
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
      wx = 2.0 * (v.wxy * (sMy + xzMxyz - xMxy - zMyz) + v.wxz * (sMz + yMyz - xMxz - xyMxyz) + v.wyz * (sMxyz + zMxy - xMyz - yMxz) + v.xyz * (w * yz + wx * xyz + wxz * xy + wz * y - i * x - s * wyz - wxy * xz - wy * z)),
      wy = 2.0 * (v.wxy * (yzMxyz + zMxz - sMx - yMxy) + v.wxz * (-sMxyz - xMyz - yMxz - zMxy) + v.wyz * (sMz + xMxz - xyMxyz - yMyz) + v.xyz * (s * wxz + wx * z + wy * xyz + wyz * xy - i * y - w * xz - wxy * yz - wz * x)),
      wz = 2.0 * (v.wxy * (sMxyz + xMyz - yMxz - zMxy) + v.wxz * (yMxy + yzMxyz - sMx - zMxz) + v.wyz * (-sMy - xMxy - xzMxyz - zMyz) + v.xyz * (w * xy + wy * x + wyz * xz + wz * xyz - i * z - s * wxy - wx * y - wxz * yz)),
      xy = 2.0 * v.xyz * (sMz + xyMxyz - xMxz - yMyz),
      xz = 2.0 * v.xyz * (xMxy + xzMxyz - sMy - zMyz),
      yz = 2.0 * v.xyz * (sMx + yMxy + yzMxyz + zMxz),
      wxy = (2.0 * (v.wxz * (sMyz + xMxyz + xyMxz + yMz) + v.wyz * (xyMyz + yMxyz - sMxz - xMz) + v.xyz * (i * xy + s * wz + w * z + wxy * xyz - wx * xz - wxz * x - wy * yz - wyz * y)) + v.wxy * (sMs + xMx + xyMxy + yMy - xyzMxyz - xzMxz - yzMyz - zMz)),
      wxz = (2.0 * (v.wxy * (xyMxz + yMz - sMyz - xMxyz) + v.wyz * (sMxy + xMy + xzMyz + zMxyz) + v.xyz * (i * xz + wx * xy + wxy * x + wxz * xyz - s * wy - w * y - wyz * z - wz * yz)) + v.wxz * (sMs + xMx + xzMxz + zMz - xyMxy - xyzMxyz - yMy - yzMyz)),
      wyz = (2.0 * (v.wxy * (sMxz + xyMyz - xMz - yMxyz) + v.wxz * (xMy + xzMyz - sMxy - zMxyz) + v.xyz * (i * yz + s * wx + w * x + wxy * y + wxz * z + wy * xy + wyz * xyz + wz * xz)) + v.wyz * (sMs + yMy + yzMyz + zMz - xMx - xyMxy - xyzMxyz - xzMxz)),
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
      y = 2.0 * v.s * (sMy + zMyz - xMxy - xzMxyz),
      z = 2.0 * v.s * (sMz + xyMxyz - xMxz - yMyz),
      wx = 2.0 * (v.xy * (wMy + wxMxy + wxzMxyz + wzMyz - sMwy - xMwxy - xzMi - zMwyz) + v.xz * (wMz + wxMxz + xyMi + yMwyz - sMwz - wxyMxyz - wyMyz - xMwxz) + v.yz * (wMxyz + wxMyz + wyMxz + zMwxy - sMi - wzMxy - xMwyz - yMwxz)),
      wy = 2.0 * (v.xy * (sMwx + wyMxy + wyzMxyz + zMwxz - wMx - wzMxz - yMwxy - yzMi) + v.xz * (sMi + wxMyz + wyMxz + wzMxy - wMxyz - xMwyz - yMwxz - zMwxy) + v.yz * (wMz + wyMyz + xMwxz + xyMi - sMwz - wxMxz - wxyMxyz - yMwyz)),
      wz = 2.0 * (v.xy * (wMxyz + wyMxz + wzMxy + xMwyz - sMi - wxMyz - yMwxz - zMwxy) + v.xz * (sMwx + wyzMxyz + wzMxz + yMwxy - wMx - wyMxy - yzMi - zMwxz) + v.yz * (sMwy + wxMxy + wzMyz + xzMi - wMy - wxzMxyz - xMwxy - zMwyz)),
      xy = (2.0 * (v.xz * (sMyz + xyMxz - xMxyz - yMz) + v.yz * (xMz + xyMyz - sMxz - yMxyz)) + v.xy * (sMs + xyMxy + xyzMxyz + zMz - xMx - xzMxz - yMy - yzMyz)),
      xz = (2.0 * (v.xy * (xMxyz + xyMxz - sMyz - yMz) + v.yz * (sMxy + xzMyz - xMy - zMxyz)) + v.xz * (sMs + xyzMxyz + xzMxz + yMy - xMx - xyMxy - yzMyz - zMz)),
      yz = (2.0 * (v.xy * (sMxz + xMz + xyMyz + yMxyz) + v.xz * (xzMyz + zMxyz - sMxy - xMy)) + v.yz * (sMs + xMx + xyzMxyz + yzMyz - xyMxy - xzMxz - yMy - zMz)),
      wxy = 2.0 * (v.xy * (sMw + xyMwxy + xyzMi + zMwz - xMwx - xzMwxz - yMwy - yzMwyz) + v.xz * (sMwyz + wMyz + xyMwxz + xzMwxy - wxMxyz - xMi - yMwz - zMwy) + v.yz * (xMwz + xyMwyz + yzMwxy + zMwx - sMwxz - wMxz - wyMxyz - yMi)),
      wxz = 2.0 * (v.xy * (wxMxyz + xMi + xyMwxz + xzMwxy - sMwyz - wMyz - yMwz - zMwy) + v.xz * (sMw + xyzMi + xzMwxz + yMwy - xMwx - xyMwxy - yzMwyz - zMwz) + v.yz * (sMwxy + wMxy + xzMwyz + yzMwxz - wzMxyz - xMwy - yMwx - zMi)),
      wyz = 2.0 * (v.xy * (sMwxz + wMxz + wyMxyz + xMwz + xyMwyz + yMi + yzMwxy + zMwx) + v.xz * (wzMxyz + xzMwyz + yzMwxz + zMi - sMwxy - wMxy - xMwy - yMwx) + v.yz * (sMw + xMwx + xyzMi + yzMwyz - xyMwxy - xzMwxz - yMwy - zMwz)),
      xyz = 2.0 * (v.xy * (sMz + xMxz + xyMxyz + yMyz) + v.xz * (xzMxyz + zMyz - sMy - xMxy) + v.yz * (sMx + yzMxyz - yMxy - zMxz)),
      i = 2.0 * v.s * (sMi + wyMxz + xMwyz + zMwxy - wMxyz - wxMyz - wzMxy - yMwxz),
    )

  infix def sandwich(v: Translator): Multivector =
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
      s = (sMs + xMx + xyMxy + xyzMxyz + xzMxz + yMy + yzMyz + zMz),
      w = 2.0 * (i * xyz + s * w + wx * x + wxy * xy + wxz * xz + wy * y + wyz * yz + wz * z),
      x = 2.0 * (sMx + yMxy + yzMxyz + zMxz),
      y = 2.0 * (sMy + zMyz - xMxy - xzMxyz),
      z = 2.0 * (sMz + xyMxyz - xMxz - yMyz),
      wx = (2.0 * (v.wy * (sMxy + zMxyz - xMy - xzMyz) + v.wz * (sMxz + xyMyz - xMz - yMxyz)) + v.wx * (sMs + yMy + yzMyz + zMz - xMx - xyMxy - xyzMxyz - xzMxz)),
      wy = (2.0 * (v.wx * (-sMxy - xMy - xzMyz - zMxyz) + v.wz * (sMyz + xMxyz - xyMxz - yMz)) + v.wy * (sMs + xMx + xzMxz + zMz - xyMxy - xyzMxyz - yMy - yzMyz)),
      wz = (2.0 * (v.wx * (xyMyz + yMxyz - sMxz - xMz) + v.wy * (-sMyz - xMxyz - xyMxz - yMz)) + v.wz * (sMs + xMx + xyMxy + yMy - xyzMxyz - xzMxz - yzMyz - zMz)),
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
      wxy = 2.0 * (v.wx * (sMy + xMxy + xzMxyz + zMyz) + v.wy * (yMxy + yzMxyz - sMx - zMxz) + v.wz * (yMxz + zMxy - sMxyz - xMyz)),
      wxz = 2.0 * (v.wx * (sMz + xMxz - xyMxyz - yMyz) + v.wy * (sMxyz + xMyz + yMxz + zMxy) + v.wz * (yzMxyz + zMxz - sMx - yMxy)),
      wyz = 2.0 * (v.wx * (xMyz + yMxz - sMxyz - zMxy) + v.wy * (sMz + yMyz - xMxz - xyMxyz) + v.wz * (xMxy + zMyz - sMy - xzMxyz)),
      xyz = 0.0,
      i = 2.0 * (i * s + wxy * z + wy * xz + wyz * x - w * xyz - wx * yz - wxz * y - wz * xy),
    )

  infix def sandwich(v: Vector): Multivector =
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
      wx = 2.0 * (v.wxy * (sMy + xzMxyz - xMxy - zMyz) + v.wxz * (sMz + yMyz - xMxz - xyMxyz) + v.wyz * (sMxyz + zMxy - xMyz - yMxz)),
      wy = 2.0 * (v.wxy * (yzMxyz + zMxz - sMx - yMxy) + v.wxz * (-sMxyz - xMyz - yMxz - zMxy) + v.wyz * (sMz + xMxz - xyMxyz - yMyz)),
      wz = 2.0 * (v.wxy * (sMxyz + xMyz - yMxz - zMxy) + v.wxz * (yMxy + yzMxyz - sMx - zMxz) + v.wyz * (-sMy - xMxy - xzMxyz - zMyz)),
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
      wxy = (2.0 * (v.wxz * (sMyz + xMxyz + xyMxz + yMz) + v.wyz * (xyMyz + yMxyz - sMxz - xMz)) + v.wxy * (sMs + xMx + xyMxy + yMy - xyzMxyz - xzMxz - yzMyz - zMz)),
      wxz = (2.0 * (v.wxy * (xyMxz + yMz - sMyz - xMxyz) + v.wyz * (sMxy + xMy + xzMyz + zMxyz)) + v.wxz * (sMs + xMx + xzMxz + zMz - xyMxy - xyzMxyz - yMy - yzMyz)),
      wyz = (2.0 * (v.wxy * (sMxz + xyMyz - xMz - yMxyz) + v.wxz * (xMy + xzMyz - sMxy - zMxyz)) + v.wyz * (sMs + yMy + yzMyz + zMz - xMx - xyMxy - xyzMxyz - xzMxz)),
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
      wx = 2.0 * (v.wxy * (sMy + xzMxyz - xMxy - zMyz) + v.wxz * (sMz + yMyz - xMxz - xyMxyz) + v.wyz * (sMxyz + zMxy - xMyz - yMxz) + w * yz + wx * xyz + wxz * xy + wz * y - i * x - s * wyz - wxy * xz - wy * z),
      wy = 2.0 * (s * wxz + v.wxy * (yzMxyz + zMxz - sMx - yMxy) + v.wxz * (-sMxyz - xMyz - yMxz - zMxy) + v.wyz * (sMz + xMxz - xyMxyz - yMyz) + wx * z + wy * xyz + wyz * xy - i * y - w * xz - wxy * yz - wz * x),
      wz = 2.0 * (v.wxy * (sMxyz + xMyz - yMxz - zMxy) + v.wxz * (yMxy + yzMxyz - sMx - zMxz) + v.wyz * (-sMy - xMxy - xzMxyz - zMyz) + w * xy + wy * x + wyz * xz + wz * xyz - i * z - s * wxy - wx * y - wxz * yz),
      xy = 2.0 * (sMz + xyMxyz - xMxz - yMyz),
      xz = 2.0 * (xMxy + xzMxyz - sMy - zMyz),
      yz = 2.0 * (sMx + yMxy + yzMxyz + zMxz),
      wxy = (2.0 * (i * xy + s * wz + v.wxz * (sMyz + xMxyz + xyMxz + yMz) + v.wyz * (xyMyz + yMxyz - sMxz - xMz) + w * z + wxy * xyz - wx * xz - wxz * x - wy * yz - wyz * y) + v.wxy * (sMs + xMx + xyMxy + yMy - xyzMxyz - xzMxz - yzMyz - zMz)),
      wxz = (2.0 * (i * xz + v.wxy * (xyMxz + yMz - sMyz - xMxyz) + v.wyz * (sMxy + xMy + xzMyz + zMxyz) + wx * xy + wxy * x + wxz * xyz - s * wy - w * y - wyz * z - wz * yz) + v.wxz * (sMs + xMx + xzMxz + zMz - xyMxy - xyzMxyz - yMy - yzMyz)),
      wyz = (2.0 * (i * yz + s * wx + v.wxy * (sMxz + xyMyz - xMz - yMxyz) + v.wxz * (xMy + xzMyz - sMxy - zMxyz) + w * x + wxy * y + wxz * z + wy * xy + wyz * xyz + wz * xz) + v.wyz * (sMs + yMy + yzMyz + zMz - xMx - xyMxy - xyzMxyz - xzMxz)),
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
      s = 2.0 * (v.x * (s * x + xyz * yz - xy * y - xz * z) + v.y * (s * y + x * xy - xyz * xz - yz * z) + v.z * (s * z + x * xz + xy * xyz + y * yz)),
      w = 2.0 * (v.x * (i * yz + s * wx + w * x + wyz * xyz - wxy * y - wxz * z - wy * xy - wz * xz) + v.y * (s * wy + w * y + wx * xy + wxy * x - i * xz - wxz * xyz - wyz * z - wz * yz) + v.z * (i * xy + s * wz + w * z + wx * xz + wxy * xyz + wxz * x + wy * yz + wyz * y)),
      x = (2.0 * (v.y * (sMxy + xMy - xzMyz - zMxyz) + v.z * (sMxz + xMz + xyMyz + yMxyz)) + v.x * (sMs + xMx + xyzMxyz + yzMyz - xyMxy - xzMxz - yMy - zMz)),
      y = (2.0 * (v.x * (xMy + zMxyz - sMxy - xzMyz) + v.z * (sMyz + yMz - xMxyz - xyMxz)) + v.y * (sMs + xyzMxyz + xzMxz + yMy - xMx - xyMxy - yzMyz - zMz)),
      z = (2.0 * (v.x * (xMz + xyMyz - sMxz - yMxyz) + v.y * (xMxyz + yMz - sMyz - xyMxz)) + v.z * (sMs + xyMxy + xyzMxyz + zMz - xMx - xzMxz - yMy - yzMyz)),
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
      i = 2.0 * (v.x * (i * x + s * wyz + wxz * xy + wz * y - w * yz - wx * xyz - wxy * xz - wy * z) + v.y * (i * y + w * xz + wx * z + wyz * xy - s * wxz - wxy * yz - wy * xyz - wz * x) + v.z * (i * z + s * wxy + wy * x + wyz * xz - w * xy - wx * y - wxz * yz - wz * xyz)),
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
      wx = 2.0 * (v.xy * (wMy + wxMxy + wxzMxyz + wzMyz - sMwy - xMwxy - xzMi - zMwyz) + v.xz * (wMz + wxMxz + xyMi + yMwyz - sMwz - wxyMxyz - wyMyz - xMwxz) + v.yz * (wMxyz + wxMyz + wyMxz + zMwxy - sMi - wzMxy - xMwyz - yMwxz)),
      wy = 2.0 * (v.xy * (sMwx + wyMxy + wyzMxyz + zMwxz - wMx - wzMxz - yMwxy - yzMi) + v.xz * (sMi + wxMyz + wyMxz + wzMxy - wMxyz - xMwyz - yMwxz - zMwxy) + v.yz * (wMz + wyMyz + xMwxz + xyMi - sMwz - wxMxz - wxyMxyz - yMwyz)),
      wz = 2.0 * (v.xy * (wMxyz + wyMxz + wzMxy + xMwyz - sMi - wxMyz - yMwxz - zMwxy) + v.xz * (sMwx + wyzMxyz + wzMxz + yMwxy - wMx - wyMxy - yzMi - zMwxz) + v.yz * (sMwy + wxMxy + wzMyz + xzMi - wMy - wxzMxyz - xMwxy - zMwyz)),
      xy = (2.0 * (v.xz * (sMyz + xyMxz - xMxyz - yMz) + v.yz * (xMz + xyMyz - sMxz - yMxyz)) + v.xy * (sMs + xyMxy + xyzMxyz + zMz - xMx - xzMxz - yMy - yzMyz)),
      xz = (2.0 * (v.xy * (xMxyz + xyMxz - sMyz - yMz) + v.yz * (sMxy + xzMyz - xMy - zMxyz)) + v.xz * (sMs + xyzMxyz + xzMxz + yMy - xMx - xyMxy - yzMyz - zMz)),
      yz = (2.0 * (v.xy * (sMxz + xMz + xyMyz + yMxyz) + v.xz * (xzMyz + zMxyz - sMxy - xMy)) + v.yz * (sMs + xMx + xyzMxyz + yzMyz - xyMxy - xzMxz - yMy - zMz)),
      wxy = 2.0 * (v.xy * (sMw + xyMwxy + xyzMi + zMwz - xMwx - xzMwxz - yMwy - yzMwyz) + v.xz * (sMwyz + wMyz + xyMwxz + xzMwxy - wxMxyz - xMi - yMwz - zMwy) + v.yz * (xMwz + xyMwyz + yzMwxy + zMwx - sMwxz - wMxz - wyMxyz - yMi)),
      wxz = 2.0 * (v.xy * (wxMxyz + xMi + xyMwxz + xzMwxy - sMwyz - wMyz - yMwz - zMwy) + v.xz * (sMw + xyzMi + xzMwxz + yMwy - xMwx - xyMwxy - yzMwyz - zMwz) + v.yz * (sMwxy + wMxy + xzMwyz + yzMwxz - wzMxyz - xMwy - yMwx - zMi)),
      wyz = 2.0 * (v.xy * (sMwxz + wMxz + wyMxyz + xMwz + xyMwyz + yMi + yzMwxy + zMwx) + v.xz * (wzMxyz + xzMwyz + yzMwxz + zMi - sMwxy - wMxy - xMwy - yMwx) + v.yz * (sMw + xMwx + xyzMi + yzMwyz - xyMwxy - xzMwxz - yMwy - zMwz)),
      xyz = 2.0 * (v.xy * (s * z + x * xz + xy * xyz + y * yz) + v.xz * (xyz * xz + yz * z - s * y - x * xy) + v.yz * (s * x + xyz * yz - xy * y - xz * z)),
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
      wx = (2.0 * (v.wy * (sMxy + zMxyz - xMy - xzMyz) + v.wz * (sMxz + xyMyz - xMz - yMxyz)) + v.wx * (sMs + yMy + yzMyz + zMz - xMx - xyMxy - xyzMxyz - xzMxz)),
      wy = (2.0 * (v.wx * (-sMxy - xMy - xzMyz - zMxyz) + v.wz * (sMyz + xMxyz - xyMxz - yMz)) + v.wy * (sMs + xMx + xzMxz + zMz - xyMxy - xyzMxyz - yMy - yzMyz)),
      wz = (2.0 * (v.wx * (xyMyz + yMxyz - sMxz - xMz) + v.wy * (-sMyz - xMxyz - xyMxz - yMz)) + v.wz * (sMs + xMx + xyMxy + yMy - xyzMxyz - xzMxz - yzMyz - zMz)),
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
      wxy = 2.0 * (v.wx * (sMy + xMxy + xzMxyz + zMyz) + v.wy * (yMxy + yzMxyz - sMx - zMxz) + v.wz * (yMxz + zMxy - sMxyz - xMyz)),
      wxz = 2.0 * (v.wx * (sMz + xMxz - xyMxyz - yMyz) + v.wy * (sMxyz + xMyz + yMxz + zMxy) + v.wz * (yzMxyz + zMxz - sMx - yMxy)),
      wyz = 2.0 * (v.wx * (xMyz + yMxz - sMxyz - zMxy) + v.wy * (sMz + yMyz - xMxz - xyMxyz) + v.wz * (xMxy + zMyz - sMy - xzMxyz)),
      xyz = 0.0,
      i = 0.0,
    )

  infix def sandwich(v: PseudoScalar): Multivector =
    Multivector(
      s = 0.0,
      w = 2.0 * v.i * (s * xyz + xz * y - x * yz - xy * z),
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
      wx = 2.0 * (w * yz + wx * xyz + wxz * xy + wz * y - i * x - s * wyz - wxy * xz - wy * z),
      wy = 2.0 * (s * wxz + wx * z + wy * xyz + wyz * xy - i * y - w * xz - wxy * yz - wz * x),
      wz = 2.0 * (w * xy + wy * x + wyz * xz + wz * xyz - i * z - s * wxy - wx * y - wxz * yz),
      xy = 2.0 * (s * z + xy * xyz - x * xz - y * yz),
      xz = 2.0 * (x * xy + xyz * xz - s * y - yz * z),
      yz = 2.0 * (s * x + xy * y + xyz * yz + xz * z),
      wxy = 2.0 * (i * xy + s * wz + w * z + wxy * xyz - wx * xz - wxz * x - wy * yz - wyz * y),
      wxz = 2.0 * (i * xz + wx * xy + wxy * x + wxz * xyz - s * wy - w * y - wyz * z - wz * yz),
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
      s = (2.0 * (v.x * (sMx + yMxy + yzMxyz + zMxz) + v.y * (sMy + zMyz - xMxy - xzMxyz) + v.z * (sMz + xyMxyz - xMxz - yMyz)) + v.s * (sMs + xMx + xyMxy + xyzMxyz + xzMxz + yMy + yzMyz + zMz)),
      w = (2.0 * (v.i * (xMyz + zMxy - sMxyz - yMxz) + v.s * (sMw + xyMwxy + xzMwxz + yzMwyz - xMwx - xyzMi - yMwy - zMwz) + v.x * (wMx + wyzMxyz + yMwxy + zMwxz - sMwx - wyMxy - wzMxz - yzMi) + v.y * (wMy + wxMxy + xzMi + zMwyz - sMwy - wxzMxyz - wzMyz - xMwxy) + v.z * (wMz + wxMxz + wxyMxyz + wyMyz - sMwz - xMwxz - xyMi - yMwyz)) + v.w * (sMs + xyMxy + xzMxz + yzMyz - xMx - xyzMxyz - yMy - zMz)),
      x = (2.0 * (v.s * (sMx + yzMxyz - yMxy - zMxz) + v.y * (xMy + zMxyz - sMxy - xzMyz) + v.z * (xMz + xyMyz - sMxz - yMxyz)) + v.x * (sMs + xMx + xyzMxyz + yzMyz - xyMxy - xzMxz - yMy - zMz)),
      y = (2.0 * (v.s * (sMy + xMxy - xzMxyz - zMyz) + v.x * (sMxy + xMy - xzMyz - zMxyz) + v.z * (xMxyz + yMz - sMyz - xyMxz)) + v.y * (sMs + xyzMxyz + xzMxz + yMy - xMx - xyMxy - yzMyz - zMz)),
      z = (2.0 * (v.s * (sMz + xMxz + xyMxyz + yMyz) + v.x * (sMxz + xMz + xyMyz + yMxyz) + v.y * (sMyz + yMz - xMxyz - xyMxz)) + v.z * (sMs + xyMxy + xyzMxyz + zMz - xMx - xzMxz - yMy - yzMyz)),
      wx = (2.0 * (v.wxy * (sMy + xMxy + xzMxyz + zMyz) + v.wxz * (sMz + xMxz - xyMxyz - yMyz) + v.wy * (-sMxy - xMy - xzMyz - zMxyz) + v.wyz * (xMyz + yMxz - sMxyz - zMxy) + v.wz * (xyMyz + yMxyz - sMxz - xMz) + v.xy * (sMwy + wMy + wxMxy + wxzMxyz + wzMyz + xMwxy + xzMi + zMwyz) + v.xyz * (sMwyz + wxMxyz + xyMwxz + zMwy - wMyz - xMi - xzMwxy - yMwz) + v.xz * (sMwz + wMz + wxMxz + xMwxz - wxyMxyz - wyMyz - xyMi - yMwyz) + v.yz * (wxMyz + wyMxz + xMwyz + yMwxz - sMi - wMxyz - wzMxy - zMwxy)) + v.wx * (sMs + yMy + yzMyz + zMz - xMx - xyMxy - xyzMxyz - xzMxz)),
      wy = (2.0 * (v.wx * (sMxy + zMxyz - xMy - xzMyz) + v.wxy * (yMxy + yzMxyz - sMx - zMxz) + v.wxz * (sMxyz + xMyz + yMxz + zMxy) + v.wyz * (sMz + yMyz - xMxz - xyMxyz) + v.wz * (-sMyz - xMxyz - xyMxz - yMz) + v.xy * (wyMxy + wyzMxyz + yMwxy + yzMi - sMwx - wMx - wzMxz - zMwxz) + v.xyz * (wMxz + wyMxyz + xMwz + xyMwyz - sMwxz - yMi - yzMwxy - zMwx) + v.xz * (sMi + wMxyz + wxMyz + wyMxz + wzMxy + xMwyz + yMwxz + zMwxy) + v.yz * (sMwz + wMz + wyMyz + yMwyz - wxMxz - wxyMxyz - xMwxz - xyMi)) + v.wy * (sMs + xMx + xzMxz + zMz - xyMxy - xyzMxyz - yMy - yzMyz)),
      wz = (2.0 * (v.wx * (sMxz + xyMyz - xMz - yMxyz) + v.wxy * (yMxz + zMxy - sMxyz - xMyz) + v.wxz * (yzMxyz + zMxz - sMx - yMxy) + v.wy * (sMyz + xMxyz - xyMxz - yMz) + v.wyz * (xMxy + zMyz - sMy - xzMxyz) + v.xy * (wyMxz + wzMxy + yMwxz + zMwxy - sMi - wMxyz - wxMyz - xMwyz) + v.xyz * (sMwxy + wzMxyz + xzMwyz + yMwx - wMxy - xMwy - yzMwxz - zMi) + v.xz * (wyzMxyz + wzMxz + yzMi + zMwxz - sMwx - wMx - wyMxy - yMwxy) + v.yz * (wxMxy + wzMyz + xMwxy + zMwyz - sMwy - wMy - wxzMxyz - xzMi)) + v.wz * (sMs + xMx + xyMxy + yMy - xyzMxyz - xzMxz - yzMyz - zMz)),
      xy = (2.0 * (v.xyz * (sMz + xMxz + xyMxyz + yMyz) + v.xz * (xMxyz + xyMxz - sMyz - yMz) + v.yz * (sMxz + xMz + xyMyz + yMxyz)) + v.xy * (sMs + xyMxy + xyzMxyz + zMz - xMx - xzMxz - yMy - yzMyz)),
      xz = (2.0 * (v.xy * (sMyz + xyMxz - xMxyz - yMz) + v.xyz * (xzMxyz + zMyz - sMy - xMxy) + v.yz * (xzMyz + zMxyz - sMxy - xMy)) + v.xz * (sMs + xyzMxyz + xzMxz + yMy - xMx - xyMxy - yzMyz - zMz)),
      yz = (2.0 * (v.xy * (xMz + xyMyz - sMxz - yMxyz) + v.xyz * (sMx + yzMxyz - yMxy - zMxz) + v.xz * (sMxy + xzMyz - xMy - zMxyz)) + v.yz * (sMs + xMx + xyzMxyz + yzMyz - xyMxy - xzMxz - yMy - zMz)),
      wxy = (2.0 * (v.wx * (sMy + xzMxyz - xMxy - zMyz) + v.wxz * (xyMxz + yMz - sMyz - xMxyz) + v.wy * (yzMxyz + zMxz - sMx - yMxy) + v.wyz * (sMxz + xyMyz - xMz - yMxyz) + v.wz * (sMxyz + xMyz - yMxz - zMxy) + v.xy * (sMw + xMwx + xyMwxy + yMwy - xyzMi - xzMwxz - yzMwyz - zMwz) + v.xyz * (wMz + wxyMxyz + xMwxz + yMwyz - sMwz - wxMxz - wyMyz - xyMi) + v.xz * (xyMwxz + xzMwxy + yMwz + zMwy - sMwyz - wMyz - wxMxyz - xMi) + v.yz * (sMwxz + wMxz + xyMwyz + yzMwxy - wyMxyz - xMwz - yMi - zMwx)) + v.wxy * (sMs + xMx + xyMxy + yMy - xyzMxyz - xzMxz - yzMyz - zMz)),
      wxz = (2.0 * (v.wx * (sMz + yMyz - xMxz - xyMxyz) + v.wxy * (sMyz + xMxyz + xyMxz + yMz) + v.wy * (-sMxyz - xMyz - yMxz - zMxy) + v.wyz * (xMy + xzMyz - sMxy - zMxyz) + v.wz * (yMxy + yzMxyz - sMx - zMxz) + v.xy * (sMwyz + wMyz + wxMxyz + xMi + xyMwxz + xzMwxy + yMwz + zMwy) + v.xyz * (sMwy + wxMxy + wxzMxyz + zMwyz - wMy - wzMyz - xMwxy - xzMi) + v.xz * (sMw + xMwx + xzMwxz + zMwz - xyMwxy - xyzMi - yMwy - yzMwyz) + v.yz * (xMwy + xzMwyz + yMwx + yzMwxz - sMwxy - wMxy - wzMxyz - zMi)) + v.wxz * (sMs + xMx + xzMxz + zMz - xyMxy - xyzMxyz - yMy - yzMyz)),
      wyz = (2.0 * (v.wx * (sMxyz + zMxy - xMyz - yMxz) + v.wxy * (xyMyz + yMxyz - sMxz - xMz) + v.wxz * (sMxy + xMy + xzMyz + zMxyz) + v.wy * (sMz + xMxz - xyMxyz - yMyz) + v.wz * (-sMy - xMxy - xzMxyz - zMyz) + v.xy * (wyMxyz + xyMwyz + yMi + yzMwxy - sMwxz - wMxz - xMwz - zMwx) + v.xyz * (wMx + wyMxy + wyzMxyz + wzMxz - sMwx - yMwxy - yzMi - zMwxz) + v.xz * (sMwxy + wMxy + wzMxyz + xMwy + xzMwyz + yMwx + yzMwxz + zMi) + v.yz * (sMw + yMwy + yzMwyz + zMwz - xMwx - xyMwxy - xyzMi - xzMwxz)) + v.wyz * (sMs + yMy + yzMyz + zMz - xMx - xyMxy - xyzMxyz - xzMxz)),
      xyz = (2.0 * (v.xy * (sMz + xyMxyz - xMxz - yMyz) + v.xz * (xMxy + xzMxyz - sMy - zMyz) + v.yz * (sMx + yMxy + yzMxyz + zMxz)) + v.xyz * (sMs + xMx + xyMxy + xyzMxyz + xzMxz + yMy + yzMyz + zMz)),
      i = (2.0 * (v.s * (sMi + wMxyz + wyMxz + yMwxz - wxMyz - wzMxy - xMwyz - zMwxy) + v.w * (sMxyz + yMxz - xMyz - zMxy) + v.x * (wMyz + xMi + xyMwxz + zMwy - sMwyz - wxMxyz - xzMwxy - yMwz) + v.y * (sMwxz + xMwz + xyMwyz + yMi - wMxz - wyMxyz - yzMwxy - zMwx) + v.z * (wMxy + xzMwyz + yMwx + zMi - sMwxy - wzMxyz - xMwy - yzMwxz)) + v.i * (sMs + xyMxy + xzMxz + yzMyz - xMx - xyzMxyz - yMy - zMz)),
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
      w = 2.0 * (v.i * (xMyz + zMxy - sMxyz - yMxz) + v.s * (sMw + xyMwxy + xzMwxz + yzMwyz - xMwx - xyzMi - yMwy - zMwz)),
      x = 2.0 * v.s * (sMx + yzMxyz - yMxy - zMxz),
      y = 2.0 * v.s * (sMy + xMxy - xzMxyz - zMyz),
      z = 2.0 * v.s * (sMz + xMxz + xyMxyz + yMyz),
      wx = (2.0 * (v.wy * (-sMxy - xMy - xzMyz - zMxyz) + v.wz * (xyMyz + yMxyz - sMxz - xMz) + v.xy * (sMwy + wMy + wxMxy + wxzMxyz + wzMyz + xMwxy + xzMi + zMwyz) + v.xz * (sMwz + wMz + wxMxz + xMwxz - wxyMxyz - wyMyz - xyMi - yMwyz) + v.yz * (wxMyz + wyMxz + xMwyz + yMwxz - sMi - wMxyz - wzMxy - zMwxy)) + v.wx * (sMs + yMy + yzMyz + zMz - xMx - xyMxy - xyzMxyz - xzMxz)),
      wy = (2.0 * (v.wx * (sMxy + zMxyz - xMy - xzMyz) + v.wz * (-sMyz - xMxyz - xyMxz - yMz) + v.xy * (wyMxy + wyzMxyz + yMwxy + yzMi - sMwx - wMx - wzMxz - zMwxz) + v.xz * (sMi + wMxyz + wxMyz + wyMxz + wzMxy + xMwyz + yMwxz + zMwxy) + v.yz * (sMwz + wMz + wyMyz + yMwyz - wxMxz - wxyMxyz - xMwxz - xyMi)) + v.wy * (sMs + xMx + xzMxz + zMz - xyMxy - xyzMxyz - yMy - yzMyz)),
      wz = (2.0 * (v.wx * (sMxz + xyMyz - xMz - yMxyz) + v.wy * (sMyz + xMxyz - xyMxz - yMz) + v.xy * (wyMxz + wzMxy + yMwxz + zMwxy - sMi - wMxyz - wxMyz - xMwyz) + v.xz * (wyzMxyz + wzMxz + yzMi + zMwxz - sMwx - wMx - wyMxy - yMwxy) + v.yz * (wxMxy + wzMyz + xMwxy + zMwyz - sMwy - wMy - wxzMxyz - xzMi)) + v.wz * (sMs + xMx + xyMxy + yMy - xyzMxyz - xzMxz - yzMyz - zMz)),
      xy = (2.0 * (v.xz * (xMxyz + xyMxz - sMyz - yMz) + v.yz * (sMxz + xMz + xyMyz + yMxyz)) + v.xy * (sMs + xyMxy + xyzMxyz + zMz - xMx - xzMxz - yMy - yzMyz)),
      xz = (2.0 * (v.xy * (sMyz + xyMxz - xMxyz - yMz) + v.yz * (xzMyz + zMxyz - sMxy - xMy)) + v.xz * (sMs + xyzMxyz + xzMxz + yMy - xMx - xyMxy - yzMyz - zMz)),
      yz = (2.0 * (v.xy * (xMz + xyMyz - sMxz - yMxyz) + v.xz * (sMxy + xzMyz - xMy - zMxyz)) + v.yz * (sMs + xMx + xyzMxyz + yzMyz - xyMxy - xzMxz - yMy - zMz)),
      wxy = 2.0 * (v.wx * (sMy + xzMxyz - xMxy - zMyz) + v.wy * (yzMxyz + zMxz - sMx - yMxy) + v.wz * (sMxyz + xMyz - yMxz - zMxy) + v.xy * (sMw + xMwx + xyMwxy + yMwy - xyzMi - xzMwxz - yzMwyz - zMwz) + v.xz * (xyMwxz + xzMwxy + yMwz + zMwy - sMwyz - wMyz - wxMxyz - xMi) + v.yz * (sMwxz + wMxz + xyMwyz + yzMwxy - wyMxyz - xMwz - yMi - zMwx)),
      wxz = 2.0 * (v.wx * (sMz + yMyz - xMxz - xyMxyz) + v.wy * (-sMxyz - xMyz - yMxz - zMxy) + v.wz * (yMxy + yzMxyz - sMx - zMxz) + v.xy * (sMwyz + wMyz + wxMxyz + xMi + xyMwxz + xzMwxy + yMwz + zMwy) + v.xz * (sMw + xMwx + xzMwxz + zMwz - xyMwxy - xyzMi - yMwy - yzMwyz) + v.yz * (xMwy + xzMwyz + yMwx + yzMwxz - sMwxy - wMxy - wzMxyz - zMi)),
      wyz = 2.0 * (v.wx * (sMxyz + zMxy - xMyz - yMxz) + v.wy * (sMz + xMxz - xyMxyz - yMyz) + v.wz * (-sMy - xMxy - xzMxyz - zMyz) + v.xy * (wyMxyz + xyMwyz + yMi + yzMwxy - sMwxz - wMxz - xMwz - zMwx) + v.xz * (sMwxy + wMxy + wzMxyz + xMwy + xzMwyz + yMwx + yzMwxz + zMi) + v.yz * (sMw + yMwy + yzMwyz + zMwz - xMwx - xyMwxy - xyzMi - xzMwxz)),
      xyz = 2.0 * (v.xy * (sMz + xyMxyz - xMxz - yMyz) + v.xz * (xMxy + xzMxyz - sMy - zMyz) + v.yz * (sMx + yMxy + yzMxyz + zMxz)),
      i = (v.i * (sMs + xyMxy + xzMxz + yzMyz - xMx - xyzMxyz - yMy - zMz) + 2.0 * v.s * (sMi + wMxyz + wyMxz + yMwxz - wxMyz - wzMxy - xMwyz - zMwxy)),
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
      s = 2.0 * (v.x * (s * x + xy * y + xyz * yz + xz * z) + v.y * (s * y + yz * z - x * xy - xyz * xz) + v.z * (s * z + xy * xyz - x * xz - y * yz)),
      w = (2.0 * (v.x * (w * x + wxy * y + wxz * z + wyz * xyz - i * yz - s * wx - wy * xy - wz * xz) + v.y * (i * xz + w * y + wx * xy + wyz * z - s * wy - wxy * x - wxz * xyz - wz * yz) + v.z * (w * z + wx * xz + wxy * xyz + wy * yz - i * xy - s * wz - wxz * x - wyz * y)) + v.w * (sMs + xyMxy + xzMxz + yzMyz - xMx - xyzMxyz - yMy - zMz)),
      x = (2.0 * (v.y * (xMy + zMxyz - sMxy - xzMyz) + v.z * (xMz + xyMyz - sMxz - yMxyz)) + v.x * (sMs + xMx + xyzMxyz + yzMyz - xyMxy - xzMxz - yMy - zMz)),
      y = (2.0 * (v.x * (sMxy + xMy - xzMyz - zMxyz) + v.z * (xMxyz + yMz - sMyz - xyMxz)) + v.y * (sMs + xyzMxyz + xzMxz + yMy - xMx - xyMxy - yzMyz - zMz)),
      z = (2.0 * (v.x * (sMxz + xMz + xyMyz + yMxyz) + v.y * (sMyz + yMz - xMxyz - xyMxz)) + v.z * (sMs + xyMxy + xyzMxyz + zMz - xMx - xzMxz - yMy - yzMyz)),
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
      i = 2.0 * (v.w * (s * xyz + xz * y - x * yz - xy * z) + v.x * (i * x + w * yz + wxz * xy + wy * z - s * wyz - wx * xyz - wxy * xz - wz * y) + v.y * (i * y + s * wxz + wyz * xy + wz * x - w * xz - wx * z - wxy * yz - wy * xyz) + v.z * (i * z + w * xy + wx * y + wyz * xz - s * wxy - wxz * yz - wy * x - wz * xyz)),
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
      wx = (2.0 * (v.wy * (-sMxy - xMy - xzMyz - zMxyz) + v.wz * (xyMyz + yMxyz - sMxz - xMz) + v.xy * (sMwy + wMy + wxMxy + wxzMxyz + wzMyz + xMwxy + xzMi + zMwyz) + v.xz * (sMwz + wMz + wxMxz + xMwxz - wxyMxyz - wyMyz - xyMi - yMwyz) + v.yz * (wxMyz + wyMxz + xMwyz + yMwxz - sMi - wMxyz - wzMxy - zMwxy)) + v.wx * (sMs + yMy + yzMyz + zMz - xMx - xyMxy - xyzMxyz - xzMxz)),
      wy = (2.0 * (v.wx * (sMxy + zMxyz - xMy - xzMyz) + v.wz * (-sMyz - xMxyz - xyMxz - yMz) + v.xy * (wyMxy + wyzMxyz + yMwxy + yzMi - sMwx - wMx - wzMxz - zMwxz) + v.xz * (sMi + wMxyz + wxMyz + wyMxz + wzMxy + xMwyz + yMwxz + zMwxy) + v.yz * (sMwz + wMz + wyMyz + yMwyz - wxMxz - wxyMxyz - xMwxz - xyMi)) + v.wy * (sMs + xMx + xzMxz + zMz - xyMxy - xyzMxyz - yMy - yzMyz)),
      wz = (2.0 * (v.wx * (sMxz + xyMyz - xMz - yMxyz) + v.wy * (sMyz + xMxyz - xyMxz - yMz) + v.xy * (wyMxz + wzMxy + yMwxz + zMwxy - sMi - wMxyz - wxMyz - xMwyz) + v.xz * (wyzMxyz + wzMxz + yzMi + zMwxz - sMwx - wMx - wyMxy - yMwxy) + v.yz * (wxMxy + wzMyz + xMwxy + zMwyz - sMwy - wMy - wxzMxyz - xzMi)) + v.wz * (sMs + xMx + xyMxy + yMy - xyzMxyz - xzMxz - yzMyz - zMz)),
      xy = (2.0 * (v.xz * (xMxyz + xyMxz - sMyz - yMz) + v.yz * (sMxz + xMz + xyMyz + yMxyz)) + v.xy * (sMs + xyMxy + xyzMxyz + zMz - xMx - xzMxz - yMy - yzMyz)),
      xz = (2.0 * (v.xy * (sMyz + xyMxz - xMxyz - yMz) + v.yz * (xzMyz + zMxyz - sMxy - xMy)) + v.xz * (sMs + xyzMxyz + xzMxz + yMy - xMx - xyMxy - yzMyz - zMz)),
      yz = (2.0 * (v.xy * (xMz + xyMyz - sMxz - yMxyz) + v.xz * (sMxy + xzMyz - xMy - zMxyz)) + v.yz * (sMs + xMx + xyzMxyz + yzMyz - xyMxy - xzMxz - yMy - zMz)),
      wxy = 2.0 * (v.wx * (sMy + xzMxyz - xMxy - zMyz) + v.wy * (yzMxyz + zMxz - sMx - yMxy) + v.wz * (sMxyz + xMyz - yMxz - zMxy) + v.xy * (sMw + xMwx + xyMwxy + yMwy - xyzMi - xzMwxz - yzMwyz - zMwz) + v.xz * (xyMwxz + xzMwxy + yMwz + zMwy - sMwyz - wMyz - wxMxyz - xMi) + v.yz * (sMwxz + wMxz + xyMwyz + yzMwxy - wyMxyz - xMwz - yMi - zMwx)),
      wxz = 2.0 * (v.wx * (sMz + yMyz - xMxz - xyMxyz) + v.wy * (-sMxyz - xMyz - yMxz - zMxy) + v.wz * (yMxy + yzMxyz - sMx - zMxz) + v.xy * (sMwyz + wMyz + wxMxyz + xMi + xyMwxz + xzMwxy + yMwz + zMwy) + v.xz * (sMw + xMwx + xzMwxz + zMwz - xyMwxy - xyzMi - yMwy - yzMwyz) + v.yz * (xMwy + xzMwyz + yMwx + yzMwxz - sMwxy - wMxy - wzMxyz - zMi)),
      wyz = 2.0 * (v.wx * (sMxyz + zMxy - xMyz - yMxz) + v.wy * (sMz + xMxz - xyMxyz - yMyz) + v.wz * (-sMy - xMxy - xzMxyz - zMyz) + v.xy * (wyMxyz + xyMwyz + yMi + yzMwxy - sMwxz - wMxz - xMwz - zMwx) + v.xz * (sMwxy + wMxy + wzMxyz + xMwy + xzMwyz + yMwx + yzMwxz + zMi) + v.yz * (sMw + yMwy + yzMwyz + zMwz - xMwx - xyMwxy - xyzMi - xzMwxz)),
      xyz = 2.0 * (v.xy * (sMz + xyMxyz - xMxz - yMyz) + v.xz * (xMxy + xzMxyz - sMy - zMyz) + v.yz * (sMx + yMxy + yzMxyz + zMxz)),
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
      wx = 2.0 * (v.wxy * (sMy + xMxy + xzMxyz + zMyz) + v.wxz * (sMz + xMxz - xyMxyz - yMyz) + v.wyz * (xMyz + yMxz - sMxyz - zMxy) + v.xyz * (s * wyz + wx * xyz + wxz * xy + wy * z - i * x - w * yz - wxy * xz - wz * y)),
      wy = 2.0 * (v.wxy * (yMxy + yzMxyz - sMx - zMxz) + v.wxz * (sMxyz + xMyz + yMxz + zMxy) + v.wyz * (sMz + yMyz - xMxz - xyMxyz) + v.xyz * (w * xz + wy * xyz + wyz * xy + wz * x - i * y - s * wxz - wx * z - wxy * yz)),
      wz = 2.0 * (v.wxy * (yMxz + zMxy - sMxyz - xMyz) + v.wxz * (yzMxyz + zMxz - sMx - yMxy) + v.wyz * (xMxy + zMyz - sMy - xzMxyz) + v.xyz * (s * wxy + wx * y + wyz * xz + wz * xyz - i * z - w * xy - wxz * yz - wy * x)),
      xy = 2.0 * v.xyz * (sMz + xMxz + xyMxyz + yMyz),
      xz = 2.0 * v.xyz * (xzMxyz + zMyz - sMy - xMxy),
      yz = 2.0 * v.xyz * (sMx + yzMxyz - yMxy - zMxz),
      wxy = (2.0 * (v.wxz * (xyMxz + yMz - sMyz - xMxyz) + v.wyz * (sMxz + xyMyz - xMz - yMxyz) + v.xyz * (w * z + wxy * xyz + wxz * x + wyz * y - i * xy - s * wz - wx * xz - wy * yz)) + v.wxy * (sMs + xMx + xyMxy + yMy - xyzMxyz - xzMxz - yzMyz - zMz)),
      wxz = (2.0 * (v.wxy * (sMyz + xMxyz + xyMxz + yMz) + v.wyz * (xMy + xzMyz - sMxy - zMxyz) + v.xyz * (s * wy + wx * xy + wxz * xyz + wyz * z - i * xz - w * y - wxy * x - wz * yz)) + v.wxz * (sMs + xMx + xzMxz + zMz - xyMxy - xyzMxyz - yMy - yzMyz)),
      wyz = (2.0 * (v.wxy * (xyMyz + yMxyz - sMxz - xMz) + v.wxz * (sMxy + xMy + xzMyz + zMxyz) + v.xyz * (w * x + wy * xy + wyz * xyz + wz * xz - i * yz - s * wx - wxy * y - wxz * z)) + v.wyz * (sMs + yMy + yzMyz + zMz - xMx - xyMxy - xyzMxyz - xzMxz)),
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
      w = 2.0 * v.s * (sMw + xyMwxy + xzMwxz + yzMwyz - xMwx - xyzMi - yMwy - zMwz),
      x = 2.0 * v.s * (sMx + yzMxyz - yMxy - zMxz),
      y = 2.0 * v.s * (sMy + xMxy - xzMxyz - zMyz),
      z = 2.0 * v.s * (sMz + xMxz + xyMxyz + yMyz),
      wx = 2.0 * (v.xy * (sMwy + wMy + wxMxy + wxzMxyz + wzMyz + xMwxy + xzMi + zMwyz) + v.xz * (sMwz + wMz + wxMxz + xMwxz - wxyMxyz - wyMyz - xyMi - yMwyz) + v.yz * (wxMyz + wyMxz + xMwyz + yMwxz - sMi - wMxyz - wzMxy - zMwxy)),
      wy = 2.0 * (v.xy * (wyMxy + wyzMxyz + yMwxy + yzMi - sMwx - wMx - wzMxz - zMwxz) + v.xz * (sMi + wMxyz + wxMyz + wyMxz + wzMxy + xMwyz + yMwxz + zMwxy) + v.yz * (sMwz + wMz + wyMyz + yMwyz - wxMxz - wxyMxyz - xMwxz - xyMi)),
      wz = 2.0 * (v.xy * (wyMxz + wzMxy + yMwxz + zMwxy - sMi - wMxyz - wxMyz - xMwyz) + v.xz * (wyzMxyz + wzMxz + yzMi + zMwxz - sMwx - wMx - wyMxy - yMwxy) + v.yz * (wxMxy + wzMyz + xMwxy + zMwyz - sMwy - wMy - wxzMxyz - xzMi)),
      xy = (2.0 * (v.xz * (xMxyz + xyMxz - sMyz - yMz) + v.yz * (sMxz + xMz + xyMyz + yMxyz)) + v.xy * (sMs + xyMxy + xyzMxyz + zMz - xMx - xzMxz - yMy - yzMyz)),
      xz = (2.0 * (v.xy * (sMyz + xyMxz - xMxyz - yMz) + v.yz * (xzMyz + zMxyz - sMxy - xMy)) + v.xz * (sMs + xyzMxyz + xzMxz + yMy - xMx - xyMxy - yzMyz - zMz)),
      yz = (2.0 * (v.xy * (xMz + xyMyz - sMxz - yMxyz) + v.xz * (sMxy + xzMyz - xMy - zMxyz)) + v.yz * (sMs + xMx + xyzMxyz + yzMyz - xyMxy - xzMxz - yMy - zMz)),
      wxy = 2.0 * (v.xy * (sMw + xMwx + xyMwxy + yMwy - xyzMi - xzMwxz - yzMwyz - zMwz) + v.xz * (xyMwxz + xzMwxy + yMwz + zMwy - sMwyz - wMyz - wxMxyz - xMi) + v.yz * (sMwxz + wMxz + xyMwyz + yzMwxy - wyMxyz - xMwz - yMi - zMwx)),
      wxz = 2.0 * (v.xy * (sMwyz + wMyz + wxMxyz + xMi + xyMwxz + xzMwxy + yMwz + zMwy) + v.xz * (sMw + xMwx + xzMwxz + zMwz - xyMwxy - xyzMi - yMwy - yzMwyz) + v.yz * (xMwy + xzMwyz + yMwx + yzMwxz - sMwxy - wMxy - wzMxyz - zMi)),
      wyz = 2.0 * (v.xy * (wyMxyz + xyMwyz + yMi + yzMwxy - sMwxz - wMxz - xMwz - zMwx) + v.xz * (sMwxy + wMxy + wzMxyz + xMwy + xzMwyz + yMwx + yzMwxz + zMi) + v.yz * (sMw + yMwy + yzMwyz + zMwz - xMwx - xyMwxy - xyzMi - xzMwxz)),
      xyz = 2.0 * (v.xy * (sMz + xyMxyz - xMxz - yMyz) + v.xz * (xMxy + xzMxyz - sMy - zMyz) + v.yz * (sMx + yMxy + yzMxyz + zMxz)),
      i = 2.0 * v.s * (sMi + wMxyz + wyMxz + yMwxz - wxMyz - wzMxy - xMwyz - zMwxy),
    )

  infix def reverseSandwich(v: Translator): Multivector =
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
      s = (sMs + xMx + xyMxy + xyzMxyz + xzMxz + yMy + yzMyz + zMz),
      w = 2.0 * (s * w + wxy * xy + wxz * xz + wyz * yz - i * xyz - wx * x - wy * y - wz * z),
      x = 2.0 * (sMx + yzMxyz - yMxy - zMxz),
      y = 2.0 * (sMy + xMxy - xzMxyz - zMyz),
      z = 2.0 * (sMz + xMxz + xyMxyz + yMyz),
      wx = (2.0 * (v.wy * (-sMxy - xMy - xzMyz - zMxyz) + v.wz * (xyMyz + yMxyz - sMxz - xMz)) + v.wx * (sMs + yMy + yzMyz + zMz - xMx - xyMxy - xyzMxyz - xzMxz)),
      wy = (2.0 * (v.wx * (sMxy + zMxyz - xMy - xzMyz) + v.wz * (-sMyz - xMxyz - xyMxz - yMz)) + v.wy * (sMs + xMx + xzMxz + zMz - xyMxy - xyzMxyz - yMy - yzMyz)),
      wz = (2.0 * (v.wx * (sMxz + xyMyz - xMz - yMxyz) + v.wy * (sMyz + xMxyz - xyMxz - yMz)) + v.wz * (sMs + xMx + xyMxy + yMy - xyzMxyz - xzMxz - yzMyz - zMz)),
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
      wxy = 2.0 * (v.wx * (sMy + xzMxyz - xMxy - zMyz) + v.wy * (yzMxyz + zMxz - sMx - yMxy) + v.wz * (sMxyz + xMyz - yMxz - zMxy)),
      wxz = 2.0 * (v.wx * (sMz + yMyz - xMxz - xyMxyz) + v.wy * (-sMxyz - xMyz - yMxz - zMxy) + v.wz * (yMxy + yzMxyz - sMx - zMxz)),
      wyz = 2.0 * (v.wx * (sMxyz + zMxy - xMyz - yMxz) + v.wy * (sMz + xMxz - xyMxyz - yMyz) + v.wz * (-sMy - xMxy - xzMxyz - zMyz)),
      xyz = 0.0,
      i = 2.0 * (i * s + w * xyz + wxz * y + wy * xz - wx * yz - wxy * z - wyz * x - wz * xy),
    )

  infix def reverseSandwich(v: Vector): Multivector =
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
      wx = 2.0 * (v.wxy * (sMy + xMxy + xzMxyz + zMyz) + v.wxz * (sMz + xMxz - xyMxyz - yMyz) + v.wyz * (xMyz + yMxz - sMxyz - zMxy)),
      wy = 2.0 * (v.wxy * (yMxy + yzMxyz - sMx - zMxz) + v.wxz * (sMxyz + xMyz + yMxz + zMxy) + v.wyz * (sMz + yMyz - xMxz - xyMxyz)),
      wz = 2.0 * (v.wxy * (yMxz + zMxy - sMxyz - xMyz) + v.wxz * (yzMxyz + zMxz - sMx - yMxy) + v.wyz * (xMxy + zMyz - sMy - xzMxyz)),
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
      wxy = (2.0 * (v.wxz * (xyMxz + yMz - sMyz - xMxyz) + v.wyz * (sMxz + xyMyz - xMz - yMxyz)) + v.wxy * (sMs + xMx + xyMxy + yMy - xyzMxyz - xzMxz - yzMyz - zMz)),
      wxz = (2.0 * (v.wxy * (sMyz + xMxyz + xyMxz + yMz) + v.wyz * (xMy + xzMyz - sMxy - zMxyz)) + v.wxz * (sMs + xMx + xzMxz + zMz - xyMxy - xyzMxyz - yMy - yzMyz)),
      wyz = (2.0 * (v.wxy * (xyMyz + yMxyz - sMxz - xMz) + v.wxz * (sMxy + xMy + xzMyz + zMxyz)) + v.wyz * (sMs + yMy + yzMyz + zMz - xMx - xyMxy - xyzMxyz - xzMxz)),
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
      wx = 2.0 * (s * wyz + v.wxy * (sMy + xMxy + xzMxyz + zMyz) + v.wxz * (sMz + xMxz - xyMxyz - yMyz) + v.wyz * (xMyz + yMxz - sMxyz - zMxy) + wx * xyz + wxz * xy + wy * z - i * x - w * yz - wxy * xz - wz * y),
      wy = 2.0 * (v.wxy * (yMxy + yzMxyz - sMx - zMxz) + v.wxz * (sMxyz + xMyz + yMxz + zMxy) + v.wyz * (sMz + yMyz - xMxz - xyMxyz) + w * xz + wy * xyz + wyz * xy + wz * x - i * y - s * wxz - wx * z - wxy * yz),
      wz = 2.0 * (s * wxy + v.wxy * (yMxz + zMxy - sMxyz - xMyz) + v.wxz * (yzMxyz + zMxz - sMx - yMxy) + v.wyz * (xMxy + zMyz - sMy - xzMxyz) + wx * y + wyz * xz + wz * xyz - i * z - w * xy - wxz * yz - wy * x),
      xy = 2.0 * (sMz + xMxz + xyMxyz + yMyz),
      xz = 2.0 * (xzMxyz + zMyz - sMy - xMxy),
      yz = 2.0 * (sMx + yzMxyz - yMxy - zMxz),
      wxy = (2.0 * (v.wxz * (xyMxz + yMz - sMyz - xMxyz) + v.wyz * (sMxz + xyMyz - xMz - yMxyz) + w * z + wxy * xyz + wxz * x + wyz * y - i * xy - s * wz - wx * xz - wy * yz) + v.wxy * (sMs + xMx + xyMxy + yMy - xyzMxyz - xzMxz - yzMyz - zMz)),
      wxz = (2.0 * (s * wy + v.wxy * (sMyz + xMxyz + xyMxz + yMz) + v.wyz * (xMy + xzMyz - sMxy - zMxyz) + wx * xy + wxz * xyz + wyz * z - i * xz - w * y - wxy * x - wz * yz) + v.wxz * (sMs + xMx + xzMxz + zMz - xyMxy - xyzMxyz - yMy - yzMyz)),
      wyz = (2.0 * (v.wxy * (xyMyz + yMxyz - sMxz - xMz) + v.wxz * (sMxy + xMy + xzMyz + zMxyz) + w * x + wy * xy + wyz * xyz + wz * xz - i * yz - s * wx - wxy * y - wxz * z) + v.wyz * (sMs + yMy + yzMyz + zMz - xMx - xyMxy - xyzMxyz - xzMxz)),
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
      s = 2.0 * (v.x * (s * x + xy * y + xyz * yz + xz * z) + v.y * (s * y + yz * z - x * xy - xyz * xz) + v.z * (s * z + xy * xyz - x * xz - y * yz)),
      w = 2.0 * (v.x * (w * x + wxy * y + wxz * z + wyz * xyz - i * yz - s * wx - wy * xy - wz * xz) + v.y * (i * xz + w * y + wx * xy + wyz * z - s * wy - wxy * x - wxz * xyz - wz * yz) + v.z * (w * z + wx * xz + wxy * xyz + wy * yz - i * xy - s * wz - wxz * x - wyz * y)),
      x = (2.0 * (v.y * (xMy + zMxyz - sMxy - xzMyz) + v.z * (xMz + xyMyz - sMxz - yMxyz)) + v.x * (sMs + xMx + xyzMxyz + yzMyz - xyMxy - xzMxz - yMy - zMz)),
      y = (2.0 * (v.x * (sMxy + xMy - xzMyz - zMxyz) + v.z * (xMxyz + yMz - sMyz - xyMxz)) + v.y * (sMs + xyzMxyz + xzMxz + yMy - xMx - xyMxy - yzMyz - zMz)),
      z = (2.0 * (v.x * (sMxz + xMz + xyMyz + yMxyz) + v.y * (sMyz + yMz - xMxyz - xyMxz)) + v.z * (sMs + xyMxy + xyzMxyz + zMz - xMx - xzMxz - yMy - yzMyz)),
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
      i = 2.0 * (v.x * (i * x + w * yz + wxz * xy + wy * z - s * wyz - wx * xyz - wxy * xz - wz * y) + v.y * (i * y + s * wxz + wyz * xy + wz * x - w * xz - wx * z - wxy * yz - wy * xyz) + v.z * (i * z + w * xy + wx * y + wyz * xz - s * wxy - wxz * yz - wy * x - wz * xyz)),
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
      wx = 2.0 * (v.xy * (sMwy + wMy + wxMxy + wxzMxyz + wzMyz + xMwxy + xzMi + zMwyz) + v.xz * (sMwz + wMz + wxMxz + xMwxz - wxyMxyz - wyMyz - xyMi - yMwyz) + v.yz * (wxMyz + wyMxz + xMwyz + yMwxz - sMi - wMxyz - wzMxy - zMwxy)),
      wy = 2.0 * (v.xy * (wyMxy + wyzMxyz + yMwxy + yzMi - sMwx - wMx - wzMxz - zMwxz) + v.xz * (sMi + wMxyz + wxMyz + wyMxz + wzMxy + xMwyz + yMwxz + zMwxy) + v.yz * (sMwz + wMz + wyMyz + yMwyz - wxMxz - wxyMxyz - xMwxz - xyMi)),
      wz = 2.0 * (v.xy * (wyMxz + wzMxy + yMwxz + zMwxy - sMi - wMxyz - wxMyz - xMwyz) + v.xz * (wyzMxyz + wzMxz + yzMi + zMwxz - sMwx - wMx - wyMxy - yMwxy) + v.yz * (wxMxy + wzMyz + xMwxy + zMwyz - sMwy - wMy - wxzMxyz - xzMi)),
      xy = (2.0 * (v.xz * (xMxyz + xyMxz - sMyz - yMz) + v.yz * (sMxz + xMz + xyMyz + yMxyz)) + v.xy * (sMs + xyMxy + xyzMxyz + zMz - xMx - xzMxz - yMy - yzMyz)),
      xz = (2.0 * (v.xy * (sMyz + xyMxz - xMxyz - yMz) + v.yz * (xzMyz + zMxyz - sMxy - xMy)) + v.xz * (sMs + xyzMxyz + xzMxz + yMy - xMx - xyMxy - yzMyz - zMz)),
      yz = (2.0 * (v.xy * (xMz + xyMyz - sMxz - yMxyz) + v.xz * (sMxy + xzMyz - xMy - zMxyz)) + v.yz * (sMs + xMx + xyzMxyz + yzMyz - xyMxy - xzMxz - yMy - zMz)),
      wxy = 2.0 * (v.xy * (sMw + xMwx + xyMwxy + yMwy - xyzMi - xzMwxz - yzMwyz - zMwz) + v.xz * (xyMwxz + xzMwxy + yMwz + zMwy - sMwyz - wMyz - wxMxyz - xMi) + v.yz * (sMwxz + wMxz + xyMwyz + yzMwxy - wyMxyz - xMwz - yMi - zMwx)),
      wxz = 2.0 * (v.xy * (sMwyz + wMyz + wxMxyz + xMi + xyMwxz + xzMwxy + yMwz + zMwy) + v.xz * (sMw + xMwx + xzMwxz + zMwz - xyMwxy - xyzMi - yMwy - yzMwyz) + v.yz * (xMwy + xzMwyz + yMwx + yzMwxz - sMwxy - wMxy - wzMxyz - zMi)),
      wyz = 2.0 * (v.xy * (wyMxyz + xyMwyz + yMi + yzMwxy - sMwxz - wMxz - xMwz - zMwx) + v.xz * (sMwxy + wMxy + wzMxyz + xMwy + xzMwyz + yMwx + yzMwxz + zMi) + v.yz * (sMw + yMwy + yzMwyz + zMwz - xMwx - xyMwxy - xyzMi - xzMwxz)),
      xyz = 2.0 * (v.xy * (s * z + xy * xyz - x * xz - y * yz) + v.xz * (x * xy + xyz * xz - s * y - yz * z) + v.yz * (s * x + xy * y + xyz * yz + xz * z)),
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
      wx = (2.0 * (v.wy * (-sMxy - xMy - xzMyz - zMxyz) + v.wz * (xyMyz + yMxyz - sMxz - xMz)) + v.wx * (sMs + yMy + yzMyz + zMz - xMx - xyMxy - xyzMxyz - xzMxz)),
      wy = (2.0 * (v.wx * (sMxy + zMxyz - xMy - xzMyz) + v.wz * (-sMyz - xMxyz - xyMxz - yMz)) + v.wy * (sMs + xMx + xzMxz + zMz - xyMxy - xyzMxyz - yMy - yzMyz)),
      wz = (2.0 * (v.wx * (sMxz + xyMyz - xMz - yMxyz) + v.wy * (sMyz + xMxyz - xyMxz - yMz)) + v.wz * (sMs + xMx + xyMxy + yMy - xyzMxyz - xzMxz - yzMyz - zMz)),
      xy = 0.0,
      xz = 0.0,
      yz = 0.0,
      wxy = 2.0 * (v.wx * (sMy + xzMxyz - xMxy - zMyz) + v.wy * (yzMxyz + zMxz - sMx - yMxy) + v.wz * (sMxyz + xMyz - yMxz - zMxy)),
      wxz = 2.0 * (v.wx * (sMz + yMyz - xMxz - xyMxyz) + v.wy * (-sMxyz - xMyz - yMxz - zMxy) + v.wz * (yMxy + yzMxyz - sMx - zMxz)),
      wyz = 2.0 * (v.wx * (sMxyz + zMxy - xMyz - yMxz) + v.wy * (sMz + xMxz - xyMxyz - yMyz) + v.wz * (-sMy - xMxy - xzMxyz - zMyz)),
      xyz = 0.0,
      i = 0.0,
    )

  infix def reverseSandwich(v: PseudoScalar): Multivector =
    Multivector(
      s = 0.0,
      w = 2.0 * v.i * (x * yz + xy * z - s * xyz - xz * y),
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
      wx = 2.0 * (s * wyz + wx * xyz + wxz * xy + wy * z - i * x - w * yz - wxy * xz - wz * y),
      wy = 2.0 * (w * xz + wy * xyz + wyz * xy + wz * x - i * y - s * wxz - wx * z - wxy * yz),
      wz = 2.0 * (s * wxy + wx * y + wyz * xz + wz * xyz - i * z - w * xy - wxz * yz - wy * x),
      xy = 2.0 * (s * z + x * xz + xy * xyz + y * yz),
      xz = 2.0 * (xyz * xz + yz * z - s * y - x * xy),
      yz = 2.0 * (s * x + xyz * yz - xy * y - xz * z),
      wxy = 2.0 * (w * z + wxy * xyz + wxz * x + wyz * y - i * xy - s * wz - wx * xz - wy * yz),
      wxz = 2.0 * (s * wy + wx * xy + wxz * xyz + wyz * z - i * xz - w * y - wxy * x - wz * yz),
      wyz = 2.0 * (w * x + wy * xy + wyz * xyz + wz * xz - i * yz - s * wx - wxy * y - wxz * z),
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

  infix def cross(v: Translator): Multivector =
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

  infix def cross(v: Vector): Multivector =
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