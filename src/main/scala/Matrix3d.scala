package com.kright.math

import MathUtils.swap
import MathUtils.loop

import scala.annotation.static

/**
 * indices in array:
 *   0 1 2
 *   3 4 5
 *   6 7 8
 */
final class Matrix3d(val elements: Array[Double]):
  def this() = this(new Array[Double](9))

  inline def apply(y: Int, x: Int): Double = elements(x + y * 3)
  inline def update(y: Int, x: Int, value: Double): Unit = elements(x + y * 3) = value

  def copy(): Matrix3d =
    new Matrix3d(elements.clone())

  def setIdentity(): Matrix3d =
    this := (
      1.0, 0.0, 0.0,
      0.0, 1.0, 0.0,
      0.0, 0.0, 1.0
    )


  def *(v: IVector3d): Vector3d =
    Matrix3d.multiply(this, v, Vector3d())

  def *>(v: Vector3d): Vector3d =
    Matrix3d.multiply(this, v, v)

  def *(v: IVector2d): Vector2d =
    Matrix3d.multiply(this, v, 1.0, Vector2d())

  def *>(v: Vector2d): Vector2d =
    Matrix3d.multiply(this, v, 1.0, v)

  def rotate(v: IVector2d): Vector2d =
    Matrix3d.multiply(this, v, 0.0, Vector2d())

  def rotateInplace(v: Vector2d): Vector2d =
    Matrix3d.multiply(this, v, 0.0, v)


  def *(right: Matrix3d): Matrix3d =
    Matrix3d.multiply(this, right, new Matrix3d())

  def *=(right: Matrix3d): Matrix3d =
    Matrix3d.multiply(this, right, result = this)

  def *>(right: Matrix3d): Matrix3d =
    Matrix3d.multiply(this, right, result = right)

  def *=(v: Double): Matrix3d =
    Matrix3d.multiply(this, v, result = this)

  def *(v: Double): Matrix3d =
    Matrix3d.multiply(this, v, new Matrix3d())

  def +=(m: Matrix3d): Matrix3d =
    Matrix3d.add(this, m, result = this)

  def +(m: Matrix3d): Matrix3d =
    Matrix3d.add(this, m, result = new Matrix3d())

  def -=(m: Matrix3d): Matrix3d =
    Matrix3d.sub(this, m, result = this)

  def -(m: Matrix3d): Matrix3d =
    Matrix3d.sub(this, m, result = new Matrix3d())

  def madd(m: Matrix3d, v: Double): Matrix3d =
    Matrix3d.multiplyAdd(this, m, v, this)

  def det(): Double =
    val f = elements
    Matrix3d.determinant(f(0), f(1), f(2), f(3), f(4), f(5), f(6), f(7), f(8))

  def transpose(): Matrix3d =
    elements.swap(1, 3)
    elements.swap(2, 6)
    elements.swap(5, 7)
    this

  def transposed(): Matrix3d =
    copy().transpose()

  def invert(): Matrix3d =
    Matrix3d.invertMatrix(this, result = this)

  def inverted(): Matrix3d =
    Matrix3d.invertMatrix(this, result = new Matrix3d())

  def setRow(row: Int, v: IVector3d): Matrix3d =
    val pos = row * 3
    elements(pos) = v.x
    elements(pos + 1) = v.y
    elements(pos + 2) = v.z
    this

  def setRows(r0: IVector3d, r1: IVector3d, r2: IVector3d): Matrix3d =
    setRow(0, r0)
    setRow(1, r1)
    setRow(2, r2)

  def setColumn(column: Int, v: IVector3d): Matrix3d =
    elements(column) = v.x
    elements(column + 3) = v.y
    elements(column + 6) = v.z
    this

  def setColumns(c0: IVector3d, c1: IVector3d, c2: IVector3d): Matrix3d =
    setColumn(0, c0)
    setColumn(1, c1)
    setColumn(2, c2)

  def :=(m: Matrix3d): Matrix3d =
    System.arraycopy(m.elements, 0, elements, 0, 9)
    this

  def :=(m: Matrix2d): Matrix3d =
    this := (
      m.m00, m.m01, 0.0,
      m.m10, m.m11, 0.0,
        0.0,   0.0, 1.0
    )

  def :=(q: Quaternion): Matrix3d =
    this := (
      q.rotM00, q.rotM01, q.rotM02,
      q.rotM10, q.rotM11, q.rotM12,
      q.rotM20, q.rotM21, q.rotM22,
    )

  def :=(a00: Double, a01: Double, a02: Double,
         a10: Double, a11: Double, a12: Double,
         a20: Double, a21: Double, a22: Double): Matrix3d =
    val e = elements
    e(0) = a00; e(1) = a01; e(2) = a02
    e(3) = a10; e(4) = a11; e(5) = a12
    e(6) = a20; e(7) = a21; e(8) = a22
    this

  def set2dRotation(radians: Double): Matrix3d =
    val sin = Math.sin(radians)
    val cos = Math.cos(radians)
    this := (
       cos,-sin, 0.0,
       sin, cos, 0.0,
       0.0, 0.0, 1.0,
    )
    
  def set2dTranslation(shift: Vector2d): Matrix3d =
    this := (
      1.0, 0.0, shift.x,
      0.0, 1.0, shift.y,
      0.0, 0.0, 1.0
    )

  def setScale(s: Vector2d): Matrix3d =
    this := (
      s.x, 0.0, 0.0,
      0.0, s.y, 0.0,
      0.0, 0.0, 1.0,
    )

  def setScale(s: Vector3d): Matrix3d =
    this := (
      s.x, 0.0, 0.0,
      0.0, s.y, 0.0,
      0.0, 0.0, s.z,
    )

  def isEquals(other: Matrix3d, eps: Double = 0.000001): Boolean =
    val el1 = elements
    val el2 = other.elements
    MathUtils.loop(9) { i =>
      if (Math.abs(el1(i) - el2(i)) > eps) {
        return false
      }
    }
    true

  override def toString: String = 
    s"Matrix3d(${elements.mkString(", ")})"


object Matrix3d:
  inline def apply(): Matrix3d = new Matrix3d()

  @static def multiply(left: Matrix3d, right: Matrix3d, result: Matrix3d): Matrix3d =
    inline def f(y: Int, x: Int) = left(y, 0) * right(0, x) + left(y, 1) * right(1, x) + left(y, 2) * right(2, x)
    result := (
      f(0, 0), f(0, 1), f(0, 2),
      f(1, 0), f(1, 1), f(1, 2),
      f(2, 0), f(2, 1), f(2, 2),
    )

  @static def multiply(a: Matrix3d, m: Double, result: Matrix3d): Matrix3d =
    loop(9) { i =>
      result.elements(i) = a.elements(i) * m
    }
    result

  @static def multiply(a: Matrix3d, v: IVector3d, result: Vector3d): Vector3d =
    val e = a.elements
    result := (
      e(0) * v.x + e(1) * v.y + e(2) * v.z,
      e(3) * v.x + e(4) * v.y + e(5) * v.z,
      e(6) * v.x + e(7) * v.y + e(8) * v.z,
    )

  @static def multiply(a: Matrix3d, v: IVector2d, z: Double, result: Vector2d): Vector2d =
    val e = a.elements
    result := (
      e(0) * v.x + e(1) * v.y + e(2) * z,
      e(3) * v.x + e(4) * v.y + e(5) * z,
    )

  private inline def elementWiseOperation(left: Matrix3d, right: Matrix3d, result: Matrix3d)(inline op: (Double, Double) => Double): Matrix3d =
    loop(9) { i =>
      result.elements(i) = op(left.elements(i), right.elements(i))
    }
    result

  @static def add(a: Matrix3d, b: Matrix3d, result: Matrix3d): Matrix3d =
    elementWiseOperation(a, b, result) { _ + _ }

  @static def sub(a: Matrix3d, b: Matrix3d, result: Matrix3d): Matrix3d =
    elementWiseOperation(a, b, result) { _ + _ }

  @static def multiplyAdd(a: Matrix3d, b: Matrix3d, v: Double, result: Matrix3d): Matrix3d =
    elementWiseOperation(a, b, result) { (left, right) => left + right * v }

  inline def determinant(a00: Double, a01: Double, a02: Double,
                         a10: Double, a11: Double, a12: Double,
                         a20: Double, a21: Double, a22: Double): Double =
    a00 * (a11 * a22 - a21 * a12) +
      a01 * (a12 * a20 - a10 * a22) +
      a02 * (a10 * a21 - a11 * a20)

  @static def invertMatrix(a: Matrix3d, result: Matrix3d): Matrix3d =
    val det = a.det() // this may be 0.0, check if necessary
    val d = 1.0 / det
    val arr = a.elements
    inline def f(x: Int, y: Int) = arr(y * 3 + x)

    result := (
      d * (f(1, 1) * f(2, 2) - f(2, 1) * f(1, 2)),
      d * (f(2, 0) * f(1, 2) - f(1, 0) * f(2, 2)),
      d * (f(1, 0) * f(2, 1) - f(2, 0) * f(1, 1)),

      d * (f(2, 1) * f(0, 2) - f(0, 1) * f(2, 2)),
      d * (f(0, 0) * f(2, 2) - f(2, 0) * f(0, 2)),
      d * (f(2, 0) * f(0, 1) - f(0, 0) * f(2, 1)),

      d * (f(0, 1) * f(1, 2) - f(1, 1) * f(0, 2)),
      d * (f(1, 0) * f(0, 2) - f(0, 0) * f(1, 2)),
      d * (f(0, 0) * f(1, 1) - f(1, 0) * f(0, 1)),
    )
