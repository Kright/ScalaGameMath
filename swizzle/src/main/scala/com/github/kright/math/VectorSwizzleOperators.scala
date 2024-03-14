package com.github.kright.math

/*
@main
def generateCode(): Unit = {
  def getOrderedCombinationsWithRepetitions(fields: List[Char], count: Int): List[List[Char]] = {
    var result: List[List[Char]] = List(List())
    for (i <- 1 to count) {
      result = result.flatMap(lst => fields.map(field => field +: lst))
    }
    result.map(_.reverse)
  }

  def getOrderedCombinationsWithoutRepetitions(fields: List[Char], count: Int): List[List[Char]] = {
    var result: List[List[Char]] = List(List())
    for (i <- 1 to count) {
      result = result.flatMap(lst => fields.filterNot(lst.contains(_)).map(field => field +: lst))
    }
    result.map(_.reverse)
  }

  def generateExt(vecD: Int): String = {
    val vecFields: List[Char] = "xyzw".toList.take(vecD)

    val getters = Seq(2, 3, 4)
      .flatMap(getOrderedCombinationsWithRepetitions(vecFields, _))
      .map { lst =>
        val vecType = s"Vector${lst.size}d"
        s"def ${lst.mkString("")}: ${vecType} = ${vecType}(${lst.map(f => s"v.$f").mkString(", ")})"
      }

    val setters = Seq(2, 3, 4)
      .flatMap(getOrderedCombinationsWithoutRepetitions(vecFields, _))
      .map { lst =>
        val setVecType = s"IVector${lst.size}d"
        val dstToSrc: List[(Char, Char)] = lst.zip("xyzw")
        val fieldsToVariables = dstToSrc.map((d, s) => s"val $s = s.$s").mkString("; ")
        val setFields = dstToSrc.map((d, s) => s"v.$d = $s").mkString("; ")
        s"def ${lst.mkString("")}_=(s: $setVecType): Unit = { $fieldsToVariables; $setFields }"
      }

    s"""extension(v: IVector${vecD}d)
       |  ${getters.mkString("\n|  ")}
       |
       |extension(v: Vector${vecD}d)
       |  ${setters.mkString("\n|  ")}
       |""".stripMargin
  }

  println(Seq(2, 3, 4).map(generateExt).mkString("\n"))
}
*/

extension (v: IVector2d)
  def xx: Vector2d = Vector2d(v.x, v.x)
  def xy: Vector2d = Vector2d(v.x, v.y)
  def yx: Vector2d = Vector2d(v.y, v.x)
  def yy: Vector2d = Vector2d(v.y, v.y)
  def xxx: Vector3d = Vector3d(v.x, v.x, v.x)
  def xxy: Vector3d = Vector3d(v.x, v.x, v.y)
  def xyx: Vector3d = Vector3d(v.x, v.y, v.x)
  def xyy: Vector3d = Vector3d(v.x, v.y, v.y)
  def yxx: Vector3d = Vector3d(v.y, v.x, v.x)
  def yxy: Vector3d = Vector3d(v.y, v.x, v.y)
  def yyx: Vector3d = Vector3d(v.y, v.y, v.x)
  def yyy: Vector3d = Vector3d(v.y, v.y, v.y)
  def xxxx: Vector4d = Vector4d(v.x, v.x, v.x, v.x)
  def xxxy: Vector4d = Vector4d(v.x, v.x, v.x, v.y)
  def xxyx: Vector4d = Vector4d(v.x, v.x, v.y, v.x)
  def xxyy: Vector4d = Vector4d(v.x, v.x, v.y, v.y)
  def xyxx: Vector4d = Vector4d(v.x, v.y, v.x, v.x)
  def xyxy: Vector4d = Vector4d(v.x, v.y, v.x, v.y)
  def xyyx: Vector4d = Vector4d(v.x, v.y, v.y, v.x)
  def xyyy: Vector4d = Vector4d(v.x, v.y, v.y, v.y)
  def yxxx: Vector4d = Vector4d(v.y, v.x, v.x, v.x)
  def yxxy: Vector4d = Vector4d(v.y, v.x, v.x, v.y)
  def yxyx: Vector4d = Vector4d(v.y, v.x, v.y, v.x)
  def yxyy: Vector4d = Vector4d(v.y, v.x, v.y, v.y)
  def yyxx: Vector4d = Vector4d(v.y, v.y, v.x, v.x)
  def yyxy: Vector4d = Vector4d(v.y, v.y, v.x, v.y)
  def yyyx: Vector4d = Vector4d(v.y, v.y, v.y, v.x)
  def yyyy: Vector4d = Vector4d(v.y, v.y, v.y, v.y)

extension (v: Vector2d)
  def xy_=(s: IVector2d): Unit = {
    val x = s.x;
    val y = s.y; v.x = x; v.y = y
  }
  def yx_=(s: IVector2d): Unit = {
    val x = s.x;
    val y = s.y; v.y = x; v.x = y
  }

extension (v: IVector3d)
  def xx: Vector2d = Vector2d(v.x, v.x)
  def xy: Vector2d = Vector2d(v.x, v.y)
  def xz: Vector2d = Vector2d(v.x, v.z)
  def yx: Vector2d = Vector2d(v.y, v.x)
  def yy: Vector2d = Vector2d(v.y, v.y)
  def yz: Vector2d = Vector2d(v.y, v.z)
  def zx: Vector2d = Vector2d(v.z, v.x)
  def zy: Vector2d = Vector2d(v.z, v.y)
  def zz: Vector2d = Vector2d(v.z, v.z)
  def xxx: Vector3d = Vector3d(v.x, v.x, v.x)
  def xxy: Vector3d = Vector3d(v.x, v.x, v.y)
  def xxz: Vector3d = Vector3d(v.x, v.x, v.z)
  def xyx: Vector3d = Vector3d(v.x, v.y, v.x)
  def xyy: Vector3d = Vector3d(v.x, v.y, v.y)
  def xyz: Vector3d = Vector3d(v.x, v.y, v.z)
  def xzx: Vector3d = Vector3d(v.x, v.z, v.x)
  def xzy: Vector3d = Vector3d(v.x, v.z, v.y)
  def xzz: Vector3d = Vector3d(v.x, v.z, v.z)
  def yxx: Vector3d = Vector3d(v.y, v.x, v.x)
  def yxy: Vector3d = Vector3d(v.y, v.x, v.y)
  def yxz: Vector3d = Vector3d(v.y, v.x, v.z)
  def yyx: Vector3d = Vector3d(v.y, v.y, v.x)
  def yyy: Vector3d = Vector3d(v.y, v.y, v.y)
  def yyz: Vector3d = Vector3d(v.y, v.y, v.z)
  def yzx: Vector3d = Vector3d(v.y, v.z, v.x)
  def yzy: Vector3d = Vector3d(v.y, v.z, v.y)
  def yzz: Vector3d = Vector3d(v.y, v.z, v.z)
  def zxx: Vector3d = Vector3d(v.z, v.x, v.x)
  def zxy: Vector3d = Vector3d(v.z, v.x, v.y)
  def zxz: Vector3d = Vector3d(v.z, v.x, v.z)
  def zyx: Vector3d = Vector3d(v.z, v.y, v.x)
  def zyy: Vector3d = Vector3d(v.z, v.y, v.y)
  def zyz: Vector3d = Vector3d(v.z, v.y, v.z)
  def zzx: Vector3d = Vector3d(v.z, v.z, v.x)
  def zzy: Vector3d = Vector3d(v.z, v.z, v.y)
  def zzz: Vector3d = Vector3d(v.z, v.z, v.z)
  def xxxx: Vector4d = Vector4d(v.x, v.x, v.x, v.x)
  def xxxy: Vector4d = Vector4d(v.x, v.x, v.x, v.y)
  def xxxz: Vector4d = Vector4d(v.x, v.x, v.x, v.z)
  def xxyx: Vector4d = Vector4d(v.x, v.x, v.y, v.x)
  def xxyy: Vector4d = Vector4d(v.x, v.x, v.y, v.y)
  def xxyz: Vector4d = Vector4d(v.x, v.x, v.y, v.z)
  def xxzx: Vector4d = Vector4d(v.x, v.x, v.z, v.x)
  def xxzy: Vector4d = Vector4d(v.x, v.x, v.z, v.y)
  def xxzz: Vector4d = Vector4d(v.x, v.x, v.z, v.z)
  def xyxx: Vector4d = Vector4d(v.x, v.y, v.x, v.x)
  def xyxy: Vector4d = Vector4d(v.x, v.y, v.x, v.y)
  def xyxz: Vector4d = Vector4d(v.x, v.y, v.x, v.z)
  def xyyx: Vector4d = Vector4d(v.x, v.y, v.y, v.x)
  def xyyy: Vector4d = Vector4d(v.x, v.y, v.y, v.y)
  def xyyz: Vector4d = Vector4d(v.x, v.y, v.y, v.z)
  def xyzx: Vector4d = Vector4d(v.x, v.y, v.z, v.x)
  def xyzy: Vector4d = Vector4d(v.x, v.y, v.z, v.y)
  def xyzz: Vector4d = Vector4d(v.x, v.y, v.z, v.z)
  def xzxx: Vector4d = Vector4d(v.x, v.z, v.x, v.x)
  def xzxy: Vector4d = Vector4d(v.x, v.z, v.x, v.y)
  def xzxz: Vector4d = Vector4d(v.x, v.z, v.x, v.z)
  def xzyx: Vector4d = Vector4d(v.x, v.z, v.y, v.x)
  def xzyy: Vector4d = Vector4d(v.x, v.z, v.y, v.y)
  def xzyz: Vector4d = Vector4d(v.x, v.z, v.y, v.z)
  def xzzx: Vector4d = Vector4d(v.x, v.z, v.z, v.x)
  def xzzy: Vector4d = Vector4d(v.x, v.z, v.z, v.y)
  def xzzz: Vector4d = Vector4d(v.x, v.z, v.z, v.z)
  def yxxx: Vector4d = Vector4d(v.y, v.x, v.x, v.x)
  def yxxy: Vector4d = Vector4d(v.y, v.x, v.x, v.y)
  def yxxz: Vector4d = Vector4d(v.y, v.x, v.x, v.z)
  def yxyx: Vector4d = Vector4d(v.y, v.x, v.y, v.x)
  def yxyy: Vector4d = Vector4d(v.y, v.x, v.y, v.y)
  def yxyz: Vector4d = Vector4d(v.y, v.x, v.y, v.z)
  def yxzx: Vector4d = Vector4d(v.y, v.x, v.z, v.x)
  def yxzy: Vector4d = Vector4d(v.y, v.x, v.z, v.y)
  def yxzz: Vector4d = Vector4d(v.y, v.x, v.z, v.z)
  def yyxx: Vector4d = Vector4d(v.y, v.y, v.x, v.x)
  def yyxy: Vector4d = Vector4d(v.y, v.y, v.x, v.y)
  def yyxz: Vector4d = Vector4d(v.y, v.y, v.x, v.z)
  def yyyx: Vector4d = Vector4d(v.y, v.y, v.y, v.x)
  def yyyy: Vector4d = Vector4d(v.y, v.y, v.y, v.y)
  def yyyz: Vector4d = Vector4d(v.y, v.y, v.y, v.z)
  def yyzx: Vector4d = Vector4d(v.y, v.y, v.z, v.x)
  def yyzy: Vector4d = Vector4d(v.y, v.y, v.z, v.y)
  def yyzz: Vector4d = Vector4d(v.y, v.y, v.z, v.z)
  def yzxx: Vector4d = Vector4d(v.y, v.z, v.x, v.x)
  def yzxy: Vector4d = Vector4d(v.y, v.z, v.x, v.y)
  def yzxz: Vector4d = Vector4d(v.y, v.z, v.x, v.z)
  def yzyx: Vector4d = Vector4d(v.y, v.z, v.y, v.x)
  def yzyy: Vector4d = Vector4d(v.y, v.z, v.y, v.y)
  def yzyz: Vector4d = Vector4d(v.y, v.z, v.y, v.z)
  def yzzx: Vector4d = Vector4d(v.y, v.z, v.z, v.x)
  def yzzy: Vector4d = Vector4d(v.y, v.z, v.z, v.y)
  def yzzz: Vector4d = Vector4d(v.y, v.z, v.z, v.z)
  def zxxx: Vector4d = Vector4d(v.z, v.x, v.x, v.x)
  def zxxy: Vector4d = Vector4d(v.z, v.x, v.x, v.y)
  def zxxz: Vector4d = Vector4d(v.z, v.x, v.x, v.z)
  def zxyx: Vector4d = Vector4d(v.z, v.x, v.y, v.x)
  def zxyy: Vector4d = Vector4d(v.z, v.x, v.y, v.y)
  def zxyz: Vector4d = Vector4d(v.z, v.x, v.y, v.z)
  def zxzx: Vector4d = Vector4d(v.z, v.x, v.z, v.x)
  def zxzy: Vector4d = Vector4d(v.z, v.x, v.z, v.y)
  def zxzz: Vector4d = Vector4d(v.z, v.x, v.z, v.z)
  def zyxx: Vector4d = Vector4d(v.z, v.y, v.x, v.x)
  def zyxy: Vector4d = Vector4d(v.z, v.y, v.x, v.y)
  def zyxz: Vector4d = Vector4d(v.z, v.y, v.x, v.z)
  def zyyx: Vector4d = Vector4d(v.z, v.y, v.y, v.x)
  def zyyy: Vector4d = Vector4d(v.z, v.y, v.y, v.y)
  def zyyz: Vector4d = Vector4d(v.z, v.y, v.y, v.z)
  def zyzx: Vector4d = Vector4d(v.z, v.y, v.z, v.x)
  def zyzy: Vector4d = Vector4d(v.z, v.y, v.z, v.y)
  def zyzz: Vector4d = Vector4d(v.z, v.y, v.z, v.z)
  def zzxx: Vector4d = Vector4d(v.z, v.z, v.x, v.x)
  def zzxy: Vector4d = Vector4d(v.z, v.z, v.x, v.y)
  def zzxz: Vector4d = Vector4d(v.z, v.z, v.x, v.z)
  def zzyx: Vector4d = Vector4d(v.z, v.z, v.y, v.x)
  def zzyy: Vector4d = Vector4d(v.z, v.z, v.y, v.y)
  def zzyz: Vector4d = Vector4d(v.z, v.z, v.y, v.z)
  def zzzx: Vector4d = Vector4d(v.z, v.z, v.z, v.x)
  def zzzy: Vector4d = Vector4d(v.z, v.z, v.z, v.y)
  def zzzz: Vector4d = Vector4d(v.z, v.z, v.z, v.z)

extension (v: Vector3d)
  def xy_=(s: IVector2d): Unit = {
    val x = s.x;
    val y = s.y; v.x = x; v.y = y
  }
  def xz_=(s: IVector2d): Unit = {
    val x = s.x;
    val y = s.y; v.x = x; v.z = y
  }
  def yx_=(s: IVector2d): Unit = {
    val x = s.x;
    val y = s.y; v.y = x; v.x = y
  }
  def yz_=(s: IVector2d): Unit = {
    val x = s.x;
    val y = s.y; v.y = x; v.z = y
  }
  def zx_=(s: IVector2d): Unit = {
    val x = s.x;
    val y = s.y; v.z = x; v.x = y
  }
  def zy_=(s: IVector2d): Unit = {
    val x = s.x;
    val y = s.y; v.z = x; v.y = y
  }
  def xyz_=(s: IVector3d): Unit = {
    val x = s.x;
    val y = s.y;
    val z = s.z; v.x = x; v.y = y; v.z = z
  }
  def xzy_=(s: IVector3d): Unit = {
    val x = s.x;
    val y = s.y;
    val z = s.z; v.x = x; v.z = y; v.y = z
  }
  def yxz_=(s: IVector3d): Unit = {
    val x = s.x;
    val y = s.y;
    val z = s.z; v.y = x; v.x = y; v.z = z
  }
  def yzx_=(s: IVector3d): Unit = {
    val x = s.x;
    val y = s.y;
    val z = s.z; v.y = x; v.z = y; v.x = z
  }
  def zxy_=(s: IVector3d): Unit = {
    val x = s.x;
    val y = s.y;
    val z = s.z; v.z = x; v.x = y; v.y = z
  }
  def zyx_=(s: IVector3d): Unit = {
    val x = s.x;
    val y = s.y;
    val z = s.z; v.z = x; v.y = y; v.x = z
  }

extension (v: IVector4d)
  def xx: Vector2d = Vector2d(v.x, v.x)
  def xy: Vector2d = Vector2d(v.x, v.y)
  def xz: Vector2d = Vector2d(v.x, v.z)
  def xw: Vector2d = Vector2d(v.x, v.w)
  def yx: Vector2d = Vector2d(v.y, v.x)
  def yy: Vector2d = Vector2d(v.y, v.y)
  def yz: Vector2d = Vector2d(v.y, v.z)
  def yw: Vector2d = Vector2d(v.y, v.w)
  def zx: Vector2d = Vector2d(v.z, v.x)
  def zy: Vector2d = Vector2d(v.z, v.y)
  def zz: Vector2d = Vector2d(v.z, v.z)
  def zw: Vector2d = Vector2d(v.z, v.w)
  def wx: Vector2d = Vector2d(v.w, v.x)
  def wy: Vector2d = Vector2d(v.w, v.y)
  def wz: Vector2d = Vector2d(v.w, v.z)
  def ww: Vector2d = Vector2d(v.w, v.w)
  def xxx: Vector3d = Vector3d(v.x, v.x, v.x)
  def xxy: Vector3d = Vector3d(v.x, v.x, v.y)
  def xxz: Vector3d = Vector3d(v.x, v.x, v.z)
  def xxw: Vector3d = Vector3d(v.x, v.x, v.w)
  def xyx: Vector3d = Vector3d(v.x, v.y, v.x)
  def xyy: Vector3d = Vector3d(v.x, v.y, v.y)
  def xyz: Vector3d = Vector3d(v.x, v.y, v.z)
  def xyw: Vector3d = Vector3d(v.x, v.y, v.w)
  def xzx: Vector3d = Vector3d(v.x, v.z, v.x)
  def xzy: Vector3d = Vector3d(v.x, v.z, v.y)
  def xzz: Vector3d = Vector3d(v.x, v.z, v.z)
  def xzw: Vector3d = Vector3d(v.x, v.z, v.w)
  def xwx: Vector3d = Vector3d(v.x, v.w, v.x)
  def xwy: Vector3d = Vector3d(v.x, v.w, v.y)
  def xwz: Vector3d = Vector3d(v.x, v.w, v.z)
  def xww: Vector3d = Vector3d(v.x, v.w, v.w)
  def yxx: Vector3d = Vector3d(v.y, v.x, v.x)
  def yxy: Vector3d = Vector3d(v.y, v.x, v.y)
  def yxz: Vector3d = Vector3d(v.y, v.x, v.z)
  def yxw: Vector3d = Vector3d(v.y, v.x, v.w)
  def yyx: Vector3d = Vector3d(v.y, v.y, v.x)
  def yyy: Vector3d = Vector3d(v.y, v.y, v.y)
  def yyz: Vector3d = Vector3d(v.y, v.y, v.z)
  def yyw: Vector3d = Vector3d(v.y, v.y, v.w)
  def yzx: Vector3d = Vector3d(v.y, v.z, v.x)
  def yzy: Vector3d = Vector3d(v.y, v.z, v.y)
  def yzz: Vector3d = Vector3d(v.y, v.z, v.z)
  def yzw: Vector3d = Vector3d(v.y, v.z, v.w)
  def ywx: Vector3d = Vector3d(v.y, v.w, v.x)
  def ywy: Vector3d = Vector3d(v.y, v.w, v.y)
  def ywz: Vector3d = Vector3d(v.y, v.w, v.z)
  def yww: Vector3d = Vector3d(v.y, v.w, v.w)
  def zxx: Vector3d = Vector3d(v.z, v.x, v.x)
  def zxy: Vector3d = Vector3d(v.z, v.x, v.y)
  def zxz: Vector3d = Vector3d(v.z, v.x, v.z)
  def zxw: Vector3d = Vector3d(v.z, v.x, v.w)
  def zyx: Vector3d = Vector3d(v.z, v.y, v.x)
  def zyy: Vector3d = Vector3d(v.z, v.y, v.y)
  def zyz: Vector3d = Vector3d(v.z, v.y, v.z)
  def zyw: Vector3d = Vector3d(v.z, v.y, v.w)
  def zzx: Vector3d = Vector3d(v.z, v.z, v.x)
  def zzy: Vector3d = Vector3d(v.z, v.z, v.y)
  def zzz: Vector3d = Vector3d(v.z, v.z, v.z)
  def zzw: Vector3d = Vector3d(v.z, v.z, v.w)
  def zwx: Vector3d = Vector3d(v.z, v.w, v.x)
  def zwy: Vector3d = Vector3d(v.z, v.w, v.y)
  def zwz: Vector3d = Vector3d(v.z, v.w, v.z)
  def zww: Vector3d = Vector3d(v.z, v.w, v.w)
  def wxx: Vector3d = Vector3d(v.w, v.x, v.x)
  def wxy: Vector3d = Vector3d(v.w, v.x, v.y)
  def wxz: Vector3d = Vector3d(v.w, v.x, v.z)
  def wxw: Vector3d = Vector3d(v.w, v.x, v.w)
  def wyx: Vector3d = Vector3d(v.w, v.y, v.x)
  def wyy: Vector3d = Vector3d(v.w, v.y, v.y)
  def wyz: Vector3d = Vector3d(v.w, v.y, v.z)
  def wyw: Vector3d = Vector3d(v.w, v.y, v.w)
  def wzx: Vector3d = Vector3d(v.w, v.z, v.x)
  def wzy: Vector3d = Vector3d(v.w, v.z, v.y)
  def wzz: Vector3d = Vector3d(v.w, v.z, v.z)
  def wzw: Vector3d = Vector3d(v.w, v.z, v.w)
  def wwx: Vector3d = Vector3d(v.w, v.w, v.x)
  def wwy: Vector3d = Vector3d(v.w, v.w, v.y)
  def wwz: Vector3d = Vector3d(v.w, v.w, v.z)
  def www: Vector3d = Vector3d(v.w, v.w, v.w)
  def xxxx: Vector4d = Vector4d(v.x, v.x, v.x, v.x)
  def xxxy: Vector4d = Vector4d(v.x, v.x, v.x, v.y)
  def xxxz: Vector4d = Vector4d(v.x, v.x, v.x, v.z)
  def xxxw: Vector4d = Vector4d(v.x, v.x, v.x, v.w)
  def xxyx: Vector4d = Vector4d(v.x, v.x, v.y, v.x)
  def xxyy: Vector4d = Vector4d(v.x, v.x, v.y, v.y)
  def xxyz: Vector4d = Vector4d(v.x, v.x, v.y, v.z)
  def xxyw: Vector4d = Vector4d(v.x, v.x, v.y, v.w)
  def xxzx: Vector4d = Vector4d(v.x, v.x, v.z, v.x)
  def xxzy: Vector4d = Vector4d(v.x, v.x, v.z, v.y)
  def xxzz: Vector4d = Vector4d(v.x, v.x, v.z, v.z)
  def xxzw: Vector4d = Vector4d(v.x, v.x, v.z, v.w)
  def xxwx: Vector4d = Vector4d(v.x, v.x, v.w, v.x)
  def xxwy: Vector4d = Vector4d(v.x, v.x, v.w, v.y)
  def xxwz: Vector4d = Vector4d(v.x, v.x, v.w, v.z)
  def xxww: Vector4d = Vector4d(v.x, v.x, v.w, v.w)
  def xyxx: Vector4d = Vector4d(v.x, v.y, v.x, v.x)
  def xyxy: Vector4d = Vector4d(v.x, v.y, v.x, v.y)
  def xyxz: Vector4d = Vector4d(v.x, v.y, v.x, v.z)
  def xyxw: Vector4d = Vector4d(v.x, v.y, v.x, v.w)
  def xyyx: Vector4d = Vector4d(v.x, v.y, v.y, v.x)
  def xyyy: Vector4d = Vector4d(v.x, v.y, v.y, v.y)
  def xyyz: Vector4d = Vector4d(v.x, v.y, v.y, v.z)
  def xyyw: Vector4d = Vector4d(v.x, v.y, v.y, v.w)
  def xyzx: Vector4d = Vector4d(v.x, v.y, v.z, v.x)
  def xyzy: Vector4d = Vector4d(v.x, v.y, v.z, v.y)
  def xyzz: Vector4d = Vector4d(v.x, v.y, v.z, v.z)
  def xyzw: Vector4d = Vector4d(v.x, v.y, v.z, v.w)
  def xywx: Vector4d = Vector4d(v.x, v.y, v.w, v.x)
  def xywy: Vector4d = Vector4d(v.x, v.y, v.w, v.y)
  def xywz: Vector4d = Vector4d(v.x, v.y, v.w, v.z)
  def xyww: Vector4d = Vector4d(v.x, v.y, v.w, v.w)
  def xzxx: Vector4d = Vector4d(v.x, v.z, v.x, v.x)
  def xzxy: Vector4d = Vector4d(v.x, v.z, v.x, v.y)
  def xzxz: Vector4d = Vector4d(v.x, v.z, v.x, v.z)
  def xzxw: Vector4d = Vector4d(v.x, v.z, v.x, v.w)
  def xzyx: Vector4d = Vector4d(v.x, v.z, v.y, v.x)
  def xzyy: Vector4d = Vector4d(v.x, v.z, v.y, v.y)
  def xzyz: Vector4d = Vector4d(v.x, v.z, v.y, v.z)
  def xzyw: Vector4d = Vector4d(v.x, v.z, v.y, v.w)
  def xzzx: Vector4d = Vector4d(v.x, v.z, v.z, v.x)
  def xzzy: Vector4d = Vector4d(v.x, v.z, v.z, v.y)
  def xzzz: Vector4d = Vector4d(v.x, v.z, v.z, v.z)
  def xzzw: Vector4d = Vector4d(v.x, v.z, v.z, v.w)
  def xzwx: Vector4d = Vector4d(v.x, v.z, v.w, v.x)
  def xzwy: Vector4d = Vector4d(v.x, v.z, v.w, v.y)
  def xzwz: Vector4d = Vector4d(v.x, v.z, v.w, v.z)
  def xzww: Vector4d = Vector4d(v.x, v.z, v.w, v.w)
  def xwxx: Vector4d = Vector4d(v.x, v.w, v.x, v.x)
  def xwxy: Vector4d = Vector4d(v.x, v.w, v.x, v.y)
  def xwxz: Vector4d = Vector4d(v.x, v.w, v.x, v.z)
  def xwxw: Vector4d = Vector4d(v.x, v.w, v.x, v.w)
  def xwyx: Vector4d = Vector4d(v.x, v.w, v.y, v.x)
  def xwyy: Vector4d = Vector4d(v.x, v.w, v.y, v.y)
  def xwyz: Vector4d = Vector4d(v.x, v.w, v.y, v.z)
  def xwyw: Vector4d = Vector4d(v.x, v.w, v.y, v.w)
  def xwzx: Vector4d = Vector4d(v.x, v.w, v.z, v.x)
  def xwzy: Vector4d = Vector4d(v.x, v.w, v.z, v.y)
  def xwzz: Vector4d = Vector4d(v.x, v.w, v.z, v.z)
  def xwzw: Vector4d = Vector4d(v.x, v.w, v.z, v.w)
  def xwwx: Vector4d = Vector4d(v.x, v.w, v.w, v.x)
  def xwwy: Vector4d = Vector4d(v.x, v.w, v.w, v.y)
  def xwwz: Vector4d = Vector4d(v.x, v.w, v.w, v.z)
  def xwww: Vector4d = Vector4d(v.x, v.w, v.w, v.w)
  def yxxx: Vector4d = Vector4d(v.y, v.x, v.x, v.x)
  def yxxy: Vector4d = Vector4d(v.y, v.x, v.x, v.y)
  def yxxz: Vector4d = Vector4d(v.y, v.x, v.x, v.z)
  def yxxw: Vector4d = Vector4d(v.y, v.x, v.x, v.w)
  def yxyx: Vector4d = Vector4d(v.y, v.x, v.y, v.x)
  def yxyy: Vector4d = Vector4d(v.y, v.x, v.y, v.y)
  def yxyz: Vector4d = Vector4d(v.y, v.x, v.y, v.z)
  def yxyw: Vector4d = Vector4d(v.y, v.x, v.y, v.w)
  def yxzx: Vector4d = Vector4d(v.y, v.x, v.z, v.x)
  def yxzy: Vector4d = Vector4d(v.y, v.x, v.z, v.y)
  def yxzz: Vector4d = Vector4d(v.y, v.x, v.z, v.z)
  def yxzw: Vector4d = Vector4d(v.y, v.x, v.z, v.w)
  def yxwx: Vector4d = Vector4d(v.y, v.x, v.w, v.x)
  def yxwy: Vector4d = Vector4d(v.y, v.x, v.w, v.y)
  def yxwz: Vector4d = Vector4d(v.y, v.x, v.w, v.z)
  def yxww: Vector4d = Vector4d(v.y, v.x, v.w, v.w)
  def yyxx: Vector4d = Vector4d(v.y, v.y, v.x, v.x)
  def yyxy: Vector4d = Vector4d(v.y, v.y, v.x, v.y)
  def yyxz: Vector4d = Vector4d(v.y, v.y, v.x, v.z)
  def yyxw: Vector4d = Vector4d(v.y, v.y, v.x, v.w)
  def yyyx: Vector4d = Vector4d(v.y, v.y, v.y, v.x)
  def yyyy: Vector4d = Vector4d(v.y, v.y, v.y, v.y)
  def yyyz: Vector4d = Vector4d(v.y, v.y, v.y, v.z)
  def yyyw: Vector4d = Vector4d(v.y, v.y, v.y, v.w)
  def yyzx: Vector4d = Vector4d(v.y, v.y, v.z, v.x)
  def yyzy: Vector4d = Vector4d(v.y, v.y, v.z, v.y)
  def yyzz: Vector4d = Vector4d(v.y, v.y, v.z, v.z)
  def yyzw: Vector4d = Vector4d(v.y, v.y, v.z, v.w)
  def yywx: Vector4d = Vector4d(v.y, v.y, v.w, v.x)
  def yywy: Vector4d = Vector4d(v.y, v.y, v.w, v.y)
  def yywz: Vector4d = Vector4d(v.y, v.y, v.w, v.z)
  def yyww: Vector4d = Vector4d(v.y, v.y, v.w, v.w)
  def yzxx: Vector4d = Vector4d(v.y, v.z, v.x, v.x)
  def yzxy: Vector4d = Vector4d(v.y, v.z, v.x, v.y)
  def yzxz: Vector4d = Vector4d(v.y, v.z, v.x, v.z)
  def yzxw: Vector4d = Vector4d(v.y, v.z, v.x, v.w)
  def yzyx: Vector4d = Vector4d(v.y, v.z, v.y, v.x)
  def yzyy: Vector4d = Vector4d(v.y, v.z, v.y, v.y)
  def yzyz: Vector4d = Vector4d(v.y, v.z, v.y, v.z)
  def yzyw: Vector4d = Vector4d(v.y, v.z, v.y, v.w)
  def yzzx: Vector4d = Vector4d(v.y, v.z, v.z, v.x)
  def yzzy: Vector4d = Vector4d(v.y, v.z, v.z, v.y)
  def yzzz: Vector4d = Vector4d(v.y, v.z, v.z, v.z)
  def yzzw: Vector4d = Vector4d(v.y, v.z, v.z, v.w)
  def yzwx: Vector4d = Vector4d(v.y, v.z, v.w, v.x)
  def yzwy: Vector4d = Vector4d(v.y, v.z, v.w, v.y)
  def yzwz: Vector4d = Vector4d(v.y, v.z, v.w, v.z)
  def yzww: Vector4d = Vector4d(v.y, v.z, v.w, v.w)
  def ywxx: Vector4d = Vector4d(v.y, v.w, v.x, v.x)
  def ywxy: Vector4d = Vector4d(v.y, v.w, v.x, v.y)
  def ywxz: Vector4d = Vector4d(v.y, v.w, v.x, v.z)
  def ywxw: Vector4d = Vector4d(v.y, v.w, v.x, v.w)
  def ywyx: Vector4d = Vector4d(v.y, v.w, v.y, v.x)
  def ywyy: Vector4d = Vector4d(v.y, v.w, v.y, v.y)
  def ywyz: Vector4d = Vector4d(v.y, v.w, v.y, v.z)
  def ywyw: Vector4d = Vector4d(v.y, v.w, v.y, v.w)
  def ywzx: Vector4d = Vector4d(v.y, v.w, v.z, v.x)
  def ywzy: Vector4d = Vector4d(v.y, v.w, v.z, v.y)
  def ywzz: Vector4d = Vector4d(v.y, v.w, v.z, v.z)
  def ywzw: Vector4d = Vector4d(v.y, v.w, v.z, v.w)
  def ywwx: Vector4d = Vector4d(v.y, v.w, v.w, v.x)
  def ywwy: Vector4d = Vector4d(v.y, v.w, v.w, v.y)
  def ywwz: Vector4d = Vector4d(v.y, v.w, v.w, v.z)
  def ywww: Vector4d = Vector4d(v.y, v.w, v.w, v.w)
  def zxxx: Vector4d = Vector4d(v.z, v.x, v.x, v.x)
  def zxxy: Vector4d = Vector4d(v.z, v.x, v.x, v.y)
  def zxxz: Vector4d = Vector4d(v.z, v.x, v.x, v.z)
  def zxxw: Vector4d = Vector4d(v.z, v.x, v.x, v.w)
  def zxyx: Vector4d = Vector4d(v.z, v.x, v.y, v.x)
  def zxyy: Vector4d = Vector4d(v.z, v.x, v.y, v.y)
  def zxyz: Vector4d = Vector4d(v.z, v.x, v.y, v.z)
  def zxyw: Vector4d = Vector4d(v.z, v.x, v.y, v.w)
  def zxzx: Vector4d = Vector4d(v.z, v.x, v.z, v.x)
  def zxzy: Vector4d = Vector4d(v.z, v.x, v.z, v.y)
  def zxzz: Vector4d = Vector4d(v.z, v.x, v.z, v.z)
  def zxzw: Vector4d = Vector4d(v.z, v.x, v.z, v.w)
  def zxwx: Vector4d = Vector4d(v.z, v.x, v.w, v.x)
  def zxwy: Vector4d = Vector4d(v.z, v.x, v.w, v.y)
  def zxwz: Vector4d = Vector4d(v.z, v.x, v.w, v.z)
  def zxww: Vector4d = Vector4d(v.z, v.x, v.w, v.w)
  def zyxx: Vector4d = Vector4d(v.z, v.y, v.x, v.x)
  def zyxy: Vector4d = Vector4d(v.z, v.y, v.x, v.y)
  def zyxz: Vector4d = Vector4d(v.z, v.y, v.x, v.z)
  def zyxw: Vector4d = Vector4d(v.z, v.y, v.x, v.w)
  def zyyx: Vector4d = Vector4d(v.z, v.y, v.y, v.x)
  def zyyy: Vector4d = Vector4d(v.z, v.y, v.y, v.y)
  def zyyz: Vector4d = Vector4d(v.z, v.y, v.y, v.z)
  def zyyw: Vector4d = Vector4d(v.z, v.y, v.y, v.w)
  def zyzx: Vector4d = Vector4d(v.z, v.y, v.z, v.x)
  def zyzy: Vector4d = Vector4d(v.z, v.y, v.z, v.y)
  def zyzz: Vector4d = Vector4d(v.z, v.y, v.z, v.z)
  def zyzw: Vector4d = Vector4d(v.z, v.y, v.z, v.w)
  def zywx: Vector4d = Vector4d(v.z, v.y, v.w, v.x)
  def zywy: Vector4d = Vector4d(v.z, v.y, v.w, v.y)
  def zywz: Vector4d = Vector4d(v.z, v.y, v.w, v.z)
  def zyww: Vector4d = Vector4d(v.z, v.y, v.w, v.w)
  def zzxx: Vector4d = Vector4d(v.z, v.z, v.x, v.x)
  def zzxy: Vector4d = Vector4d(v.z, v.z, v.x, v.y)
  def zzxz: Vector4d = Vector4d(v.z, v.z, v.x, v.z)
  def zzxw: Vector4d = Vector4d(v.z, v.z, v.x, v.w)
  def zzyx: Vector4d = Vector4d(v.z, v.z, v.y, v.x)
  def zzyy: Vector4d = Vector4d(v.z, v.z, v.y, v.y)
  def zzyz: Vector4d = Vector4d(v.z, v.z, v.y, v.z)
  def zzyw: Vector4d = Vector4d(v.z, v.z, v.y, v.w)
  def zzzx: Vector4d = Vector4d(v.z, v.z, v.z, v.x)
  def zzzy: Vector4d = Vector4d(v.z, v.z, v.z, v.y)
  def zzzz: Vector4d = Vector4d(v.z, v.z, v.z, v.z)
  def zzzw: Vector4d = Vector4d(v.z, v.z, v.z, v.w)
  def zzwx: Vector4d = Vector4d(v.z, v.z, v.w, v.x)
  def zzwy: Vector4d = Vector4d(v.z, v.z, v.w, v.y)
  def zzwz: Vector4d = Vector4d(v.z, v.z, v.w, v.z)
  def zzww: Vector4d = Vector4d(v.z, v.z, v.w, v.w)
  def zwxx: Vector4d = Vector4d(v.z, v.w, v.x, v.x)
  def zwxy: Vector4d = Vector4d(v.z, v.w, v.x, v.y)
  def zwxz: Vector4d = Vector4d(v.z, v.w, v.x, v.z)
  def zwxw: Vector4d = Vector4d(v.z, v.w, v.x, v.w)
  def zwyx: Vector4d = Vector4d(v.z, v.w, v.y, v.x)
  def zwyy: Vector4d = Vector4d(v.z, v.w, v.y, v.y)
  def zwyz: Vector4d = Vector4d(v.z, v.w, v.y, v.z)
  def zwyw: Vector4d = Vector4d(v.z, v.w, v.y, v.w)
  def zwzx: Vector4d = Vector4d(v.z, v.w, v.z, v.x)
  def zwzy: Vector4d = Vector4d(v.z, v.w, v.z, v.y)
  def zwzz: Vector4d = Vector4d(v.z, v.w, v.z, v.z)
  def zwzw: Vector4d = Vector4d(v.z, v.w, v.z, v.w)
  def zwwx: Vector4d = Vector4d(v.z, v.w, v.w, v.x)
  def zwwy: Vector4d = Vector4d(v.z, v.w, v.w, v.y)
  def zwwz: Vector4d = Vector4d(v.z, v.w, v.w, v.z)
  def zwww: Vector4d = Vector4d(v.z, v.w, v.w, v.w)
  def wxxx: Vector4d = Vector4d(v.w, v.x, v.x, v.x)
  def wxxy: Vector4d = Vector4d(v.w, v.x, v.x, v.y)
  def wxxz: Vector4d = Vector4d(v.w, v.x, v.x, v.z)
  def wxxw: Vector4d = Vector4d(v.w, v.x, v.x, v.w)
  def wxyx: Vector4d = Vector4d(v.w, v.x, v.y, v.x)
  def wxyy: Vector4d = Vector4d(v.w, v.x, v.y, v.y)
  def wxyz: Vector4d = Vector4d(v.w, v.x, v.y, v.z)
  def wxyw: Vector4d = Vector4d(v.w, v.x, v.y, v.w)
  def wxzx: Vector4d = Vector4d(v.w, v.x, v.z, v.x)
  def wxzy: Vector4d = Vector4d(v.w, v.x, v.z, v.y)
  def wxzz: Vector4d = Vector4d(v.w, v.x, v.z, v.z)
  def wxzw: Vector4d = Vector4d(v.w, v.x, v.z, v.w)
  def wxwx: Vector4d = Vector4d(v.w, v.x, v.w, v.x)
  def wxwy: Vector4d = Vector4d(v.w, v.x, v.w, v.y)
  def wxwz: Vector4d = Vector4d(v.w, v.x, v.w, v.z)
  def wxww: Vector4d = Vector4d(v.w, v.x, v.w, v.w)
  def wyxx: Vector4d = Vector4d(v.w, v.y, v.x, v.x)
  def wyxy: Vector4d = Vector4d(v.w, v.y, v.x, v.y)
  def wyxz: Vector4d = Vector4d(v.w, v.y, v.x, v.z)
  def wyxw: Vector4d = Vector4d(v.w, v.y, v.x, v.w)
  def wyyx: Vector4d = Vector4d(v.w, v.y, v.y, v.x)
  def wyyy: Vector4d = Vector4d(v.w, v.y, v.y, v.y)
  def wyyz: Vector4d = Vector4d(v.w, v.y, v.y, v.z)
  def wyyw: Vector4d = Vector4d(v.w, v.y, v.y, v.w)
  def wyzx: Vector4d = Vector4d(v.w, v.y, v.z, v.x)
  def wyzy: Vector4d = Vector4d(v.w, v.y, v.z, v.y)
  def wyzz: Vector4d = Vector4d(v.w, v.y, v.z, v.z)
  def wyzw: Vector4d = Vector4d(v.w, v.y, v.z, v.w)
  def wywx: Vector4d = Vector4d(v.w, v.y, v.w, v.x)
  def wywy: Vector4d = Vector4d(v.w, v.y, v.w, v.y)
  def wywz: Vector4d = Vector4d(v.w, v.y, v.w, v.z)
  def wyww: Vector4d = Vector4d(v.w, v.y, v.w, v.w)
  def wzxx: Vector4d = Vector4d(v.w, v.z, v.x, v.x)
  def wzxy: Vector4d = Vector4d(v.w, v.z, v.x, v.y)
  def wzxz: Vector4d = Vector4d(v.w, v.z, v.x, v.z)
  def wzxw: Vector4d = Vector4d(v.w, v.z, v.x, v.w)
  def wzyx: Vector4d = Vector4d(v.w, v.z, v.y, v.x)
  def wzyy: Vector4d = Vector4d(v.w, v.z, v.y, v.y)
  def wzyz: Vector4d = Vector4d(v.w, v.z, v.y, v.z)
  def wzyw: Vector4d = Vector4d(v.w, v.z, v.y, v.w)
  def wzzx: Vector4d = Vector4d(v.w, v.z, v.z, v.x)
  def wzzy: Vector4d = Vector4d(v.w, v.z, v.z, v.y)
  def wzzz: Vector4d = Vector4d(v.w, v.z, v.z, v.z)
  def wzzw: Vector4d = Vector4d(v.w, v.z, v.z, v.w)
  def wzwx: Vector4d = Vector4d(v.w, v.z, v.w, v.x)
  def wzwy: Vector4d = Vector4d(v.w, v.z, v.w, v.y)
  def wzwz: Vector4d = Vector4d(v.w, v.z, v.w, v.z)
  def wzww: Vector4d = Vector4d(v.w, v.z, v.w, v.w)
  def wwxx: Vector4d = Vector4d(v.w, v.w, v.x, v.x)
  def wwxy: Vector4d = Vector4d(v.w, v.w, v.x, v.y)
  def wwxz: Vector4d = Vector4d(v.w, v.w, v.x, v.z)
  def wwxw: Vector4d = Vector4d(v.w, v.w, v.x, v.w)
  def wwyx: Vector4d = Vector4d(v.w, v.w, v.y, v.x)
  def wwyy: Vector4d = Vector4d(v.w, v.w, v.y, v.y)
  def wwyz: Vector4d = Vector4d(v.w, v.w, v.y, v.z)
  def wwyw: Vector4d = Vector4d(v.w, v.w, v.y, v.w)
  def wwzx: Vector4d = Vector4d(v.w, v.w, v.z, v.x)
  def wwzy: Vector4d = Vector4d(v.w, v.w, v.z, v.y)
  def wwzz: Vector4d = Vector4d(v.w, v.w, v.z, v.z)
  def wwzw: Vector4d = Vector4d(v.w, v.w, v.z, v.w)
  def wwwx: Vector4d = Vector4d(v.w, v.w, v.w, v.x)
  def wwwy: Vector4d = Vector4d(v.w, v.w, v.w, v.y)
  def wwwz: Vector4d = Vector4d(v.w, v.w, v.w, v.z)
  def wwww: Vector4d = Vector4d(v.w, v.w, v.w, v.w)

extension (v: Vector4d)
  def xy_=(s: IVector2d): Unit = {
    val x = s.x;
    val y = s.y; v.x = x; v.y = y
  }
  def xz_=(s: IVector2d): Unit = {
    val x = s.x;
    val y = s.y; v.x = x; v.z = y
  }
  def xw_=(s: IVector2d): Unit = {
    val x = s.x;
    val y = s.y; v.x = x; v.w = y
  }
  def yx_=(s: IVector2d): Unit = {
    val x = s.x;
    val y = s.y; v.y = x; v.x = y
  }
  def yz_=(s: IVector2d): Unit = {
    val x = s.x;
    val y = s.y; v.y = x; v.z = y
  }
  def yw_=(s: IVector2d): Unit = {
    val x = s.x;
    val y = s.y; v.y = x; v.w = y
  }
  def zx_=(s: IVector2d): Unit = {
    val x = s.x;
    val y = s.y; v.z = x; v.x = y
  }
  def zy_=(s: IVector2d): Unit = {
    val x = s.x;
    val y = s.y; v.z = x; v.y = y
  }
  def zw_=(s: IVector2d): Unit = {
    val x = s.x;
    val y = s.y; v.z = x; v.w = y
  }
  def wx_=(s: IVector2d): Unit = {
    val x = s.x;
    val y = s.y; v.w = x; v.x = y
  }
  def wy_=(s: IVector2d): Unit = {
    val x = s.x;
    val y = s.y; v.w = x; v.y = y
  }
  def wz_=(s: IVector2d): Unit = {
    val x = s.x;
    val y = s.y; v.w = x; v.z = y
  }
  def xyz_=(s: IVector3d): Unit = {
    val x = s.x;
    val y = s.y;
    val z = s.z; v.x = x; v.y = y; v.z = z
  }
  def xyw_=(s: IVector3d): Unit = {
    val x = s.x;
    val y = s.y;
    val z = s.z; v.x = x; v.y = y; v.w = z
  }
  def xzy_=(s: IVector3d): Unit = {
    val x = s.x;
    val y = s.y;
    val z = s.z; v.x = x; v.z = y; v.y = z
  }
  def xzw_=(s: IVector3d): Unit = {
    val x = s.x;
    val y = s.y;
    val z = s.z; v.x = x; v.z = y; v.w = z
  }
  def xwy_=(s: IVector3d): Unit = {
    val x = s.x;
    val y = s.y;
    val z = s.z; v.x = x; v.w = y; v.y = z
  }
  def xwz_=(s: IVector3d): Unit = {
    val x = s.x;
    val y = s.y;
    val z = s.z; v.x = x; v.w = y; v.z = z
  }
  def yxz_=(s: IVector3d): Unit = {
    val x = s.x;
    val y = s.y;
    val z = s.z; v.y = x; v.x = y; v.z = z
  }
  def yxw_=(s: IVector3d): Unit = {
    val x = s.x;
    val y = s.y;
    val z = s.z; v.y = x; v.x = y; v.w = z
  }
  def yzx_=(s: IVector3d): Unit = {
    val x = s.x;
    val y = s.y;
    val z = s.z; v.y = x; v.z = y; v.x = z
  }
  def yzw_=(s: IVector3d): Unit = {
    val x = s.x;
    val y = s.y;
    val z = s.z; v.y = x; v.z = y; v.w = z
  }
  def ywx_=(s: IVector3d): Unit = {
    val x = s.x;
    val y = s.y;
    val z = s.z; v.y = x; v.w = y; v.x = z
  }
  def ywz_=(s: IVector3d): Unit = {
    val x = s.x;
    val y = s.y;
    val z = s.z; v.y = x; v.w = y; v.z = z
  }
  def zxy_=(s: IVector3d): Unit = {
    val x = s.x;
    val y = s.y;
    val z = s.z; v.z = x; v.x = y; v.y = z
  }
  def zxw_=(s: IVector3d): Unit = {
    val x = s.x;
    val y = s.y;
    val z = s.z; v.z = x; v.x = y; v.w = z
  }
  def zyx_=(s: IVector3d): Unit = {
    val x = s.x;
    val y = s.y;
    val z = s.z; v.z = x; v.y = y; v.x = z
  }
  def zyw_=(s: IVector3d): Unit = {
    val x = s.x;
    val y = s.y;
    val z = s.z; v.z = x; v.y = y; v.w = z
  }
  def zwx_=(s: IVector3d): Unit = {
    val x = s.x;
    val y = s.y;
    val z = s.z; v.z = x; v.w = y; v.x = z
  }
  def zwy_=(s: IVector3d): Unit = {
    val x = s.x;
    val y = s.y;
    val z = s.z; v.z = x; v.w = y; v.y = z
  }
  def wxy_=(s: IVector3d): Unit = {
    val x = s.x;
    val y = s.y;
    val z = s.z; v.w = x; v.x = y; v.y = z
  }
  def wxz_=(s: IVector3d): Unit = {
    val x = s.x;
    val y = s.y;
    val z = s.z; v.w = x; v.x = y; v.z = z
  }
  def wyx_=(s: IVector3d): Unit = {
    val x = s.x;
    val y = s.y;
    val z = s.z; v.w = x; v.y = y; v.x = z
  }
  def wyz_=(s: IVector3d): Unit = {
    val x = s.x;
    val y = s.y;
    val z = s.z; v.w = x; v.y = y; v.z = z
  }
  def wzx_=(s: IVector3d): Unit = {
    val x = s.x;
    val y = s.y;
    val z = s.z; v.w = x; v.z = y; v.x = z
  }
  def wzy_=(s: IVector3d): Unit = {
    val x = s.x;
    val y = s.y;
    val z = s.z; v.w = x; v.z = y; v.y = z
  }
  def xyzw_=(s: IVector4d): Unit = {
    val x = s.x;
    val y = s.y;
    val z = s.z;
    val w = s.w; v.x = x; v.y = y; v.z = z; v.w = w
  }
  def xywz_=(s: IVector4d): Unit = {
    val x = s.x;
    val y = s.y;
    val z = s.z;
    val w = s.w; v.x = x; v.y = y; v.w = z; v.z = w
  }
  def xzyw_=(s: IVector4d): Unit = {
    val x = s.x;
    val y = s.y;
    val z = s.z;
    val w = s.w; v.x = x; v.z = y; v.y = z; v.w = w
  }
  def xzwy_=(s: IVector4d): Unit = {
    val x = s.x;
    val y = s.y;
    val z = s.z;
    val w = s.w; v.x = x; v.z = y; v.w = z; v.y = w
  }
  def xwyz_=(s: IVector4d): Unit = {
    val x = s.x;
    val y = s.y;
    val z = s.z;
    val w = s.w; v.x = x; v.w = y; v.y = z; v.z = w
  }
  def xwzy_=(s: IVector4d): Unit = {
    val x = s.x;
    val y = s.y;
    val z = s.z;
    val w = s.w; v.x = x; v.w = y; v.z = z; v.y = w
  }
  def yxzw_=(s: IVector4d): Unit = {
    val x = s.x;
    val y = s.y;
    val z = s.z;
    val w = s.w; v.y = x; v.x = y; v.z = z; v.w = w
  }
  def yxwz_=(s: IVector4d): Unit = {
    val x = s.x;
    val y = s.y;
    val z = s.z;
    val w = s.w; v.y = x; v.x = y; v.w = z; v.z = w
  }
  def yzxw_=(s: IVector4d): Unit = {
    val x = s.x;
    val y = s.y;
    val z = s.z;
    val w = s.w; v.y = x; v.z = y; v.x = z; v.w = w
  }
  def yzwx_=(s: IVector4d): Unit = {
    val x = s.x;
    val y = s.y;
    val z = s.z;
    val w = s.w; v.y = x; v.z = y; v.w = z; v.x = w
  }
  def ywxz_=(s: IVector4d): Unit = {
    val x = s.x;
    val y = s.y;
    val z = s.z;
    val w = s.w; v.y = x; v.w = y; v.x = z; v.z = w
  }
  def ywzx_=(s: IVector4d): Unit = {
    val x = s.x;
    val y = s.y;
    val z = s.z;
    val w = s.w; v.y = x; v.w = y; v.z = z; v.x = w
  }
  def zxyw_=(s: IVector4d): Unit = {
    val x = s.x;
    val y = s.y;
    val z = s.z;
    val w = s.w; v.z = x; v.x = y; v.y = z; v.w = w
  }
  def zxwy_=(s: IVector4d): Unit = {
    val x = s.x;
    val y = s.y;
    val z = s.z;
    val w = s.w; v.z = x; v.x = y; v.w = z; v.y = w
  }
  def zyxw_=(s: IVector4d): Unit = {
    val x = s.x;
    val y = s.y;
    val z = s.z;
    val w = s.w; v.z = x; v.y = y; v.x = z; v.w = w
  }
  def zywx_=(s: IVector4d): Unit = {
    val x = s.x;
    val y = s.y;
    val z = s.z;
    val w = s.w; v.z = x; v.y = y; v.w = z; v.x = w
  }
  def zwxy_=(s: IVector4d): Unit = {
    val x = s.x;
    val y = s.y;
    val z = s.z;
    val w = s.w; v.z = x; v.w = y; v.x = z; v.y = w
  }
  def zwyx_=(s: IVector4d): Unit = {
    val x = s.x;
    val y = s.y;
    val z = s.z;
    val w = s.w; v.z = x; v.w = y; v.y = z; v.x = w
  }
  def wxyz_=(s: IVector4d): Unit = {
    val x = s.x;
    val y = s.y;
    val z = s.z;
    val w = s.w; v.w = x; v.x = y; v.y = z; v.z = w
  }
  def wxzy_=(s: IVector4d): Unit = {
    val x = s.x;
    val y = s.y;
    val z = s.z;
    val w = s.w; v.w = x; v.x = y; v.z = z; v.y = w
  }
  def wyxz_=(s: IVector4d): Unit = {
    val x = s.x;
    val y = s.y;
    val z = s.z;
    val w = s.w; v.w = x; v.y = y; v.x = z; v.z = w
  }
  def wyzx_=(s: IVector4d): Unit = {
    val x = s.x;
    val y = s.y;
    val z = s.z;
    val w = s.w; v.w = x; v.y = y; v.z = z; v.x = w
  }
  def wzxy_=(s: IVector4d): Unit = {
    val x = s.x;
    val y = s.y;
    val z = s.z;
    val w = s.w; v.w = x; v.z = y; v.x = z; v.y = w
  }
  def wzyx_=(s: IVector4d): Unit = {
    val x = s.x;
    val y = s.y;
    val z = s.z;
    val w = s.w; v.w = x; v.z = y; v.y = z; v.x = w
  }
