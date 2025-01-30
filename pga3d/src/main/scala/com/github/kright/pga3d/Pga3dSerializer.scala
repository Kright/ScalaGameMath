package com.github.kright.pga3d

/** this code is generated, see com.github.kright.pga3d.codegen.CodeGenClass */
case object Pga3dSerializer:

  def loadMultivector(arr: Array[Double], offset: Int): Pga3dMultivector =
    Pga3dMultivector(
      s = arr(offset + 0),
      w = arr(offset + 1),
      x = arr(offset + 2),
      y = arr(offset + 3),
      z = arr(offset + 4),
      wx = arr(offset + 5),
      wy = arr(offset + 6),
      wz = arr(offset + 7),
      xy = arr(offset + 8),
      xz = arr(offset + 9),
      yz = arr(offset + 10),
      wxy = arr(offset + 11),
      wxz = arr(offset + 12),
      wyz = arr(offset + 13),
      xyz = arr(offset + 14),
      i = arr(offset + 15),
    )

  def store(v: Pga3dMultivector, arr: Array[Double], offset: Int): Unit =
    arr(offset + 0) = v.s
    arr(offset + 1) = v.w
    arr(offset + 2) = v.x
    arr(offset + 3) = v.y
    arr(offset + 4) = v.z
    arr(offset + 5) = v.wx
    arr(offset + 6) = v.wy
    arr(offset + 7) = v.wz
    arr(offset + 8) = v.xy
    arr(offset + 9) = v.xz
    arr(offset + 10) = v.yz
    arr(offset + 11) = v.wxy
    arr(offset + 12) = v.wxz
    arr(offset + 13) = v.wyz
    arr(offset + 14) = v.xyz
    arr(offset + 15) = v.i

  def loadMotor(arr: Array[Double], offset: Int): Pga3dMotor =
    Pga3dMotor(
      s = arr(offset + 0),
      wx = arr(offset + 1),
      wy = arr(offset + 2),
      wz = arr(offset + 3),
      xy = arr(offset + 4),
      xz = arr(offset + 5),
      yz = arr(offset + 6),
      i = arr(offset + 7),
    )

  def store(v: Pga3dMotor, arr: Array[Double], offset: Int): Unit =
    arr(offset + 0) = v.s
    arr(offset + 1) = v.wx
    arr(offset + 2) = v.wy
    arr(offset + 3) = v.wz
    arr(offset + 4) = v.xy
    arr(offset + 5) = v.xz
    arr(offset + 6) = v.yz
    arr(offset + 7) = v.i

  def loadPlane(arr: Array[Double], offset: Int): Pga3dPlane =
    Pga3dPlane(
      x = arr(offset + 0),
      y = arr(offset + 1),
      z = arr(offset + 2),
      w = arr(offset + 3),
    )

  def store(v: Pga3dPlane, arr: Array[Double], offset: Int): Unit =
    arr(offset + 0) = v.x
    arr(offset + 1) = v.y
    arr(offset + 2) = v.z
    arr(offset + 3) = v.w

  def loadBivector(arr: Array[Double], offset: Int): Pga3dBivector =
    Pga3dBivector(
      wx = arr(offset + 0),
      wy = arr(offset + 1),
      wz = arr(offset + 2),
      xy = arr(offset + 3),
      xz = arr(offset + 4),
      yz = arr(offset + 5),
    )

  def store(v: Pga3dBivector, arr: Array[Double], offset: Int): Unit =
    arr(offset + 0) = v.wx
    arr(offset + 1) = v.wy
    arr(offset + 2) = v.wz
    arr(offset + 3) = v.xy
    arr(offset + 4) = v.xz
    arr(offset + 5) = v.yz

  def loadTrivector(arr: Array[Double], offset: Int): Pga3dTrivector =
    Pga3dTrivector(
      x = arr(offset + 0),
      y = arr(offset + 1),
      z = arr(offset + 2),
      w = arr(offset + 3),
    )

  def store(v: Pga3dTrivector, arr: Array[Double], offset: Int): Unit =
    arr(offset + 0) = v.x
    arr(offset + 1) = v.y
    arr(offset + 2) = v.z
    arr(offset + 3) = v.w

  def loadQuaternion(arr: Array[Double], offset: Int): Pga3dQuaternion =
    Pga3dQuaternion(
      s = arr(offset + 0),
      xy = arr(offset + 1),
      xz = arr(offset + 2),
      yz = arr(offset + 3),
    )

  def store(v: Pga3dQuaternion, arr: Array[Double], offset: Int): Unit =
    arr(offset + 0) = v.s
    arr(offset + 1) = v.xy
    arr(offset + 2) = v.xz
    arr(offset + 3) = v.yz

  def loadTranslator(arr: Array[Double], offset: Int): Pga3dTranslator =
    Pga3dTranslator(
      wx = arr(offset + 0),
      wy = arr(offset + 1),
      wz = arr(offset + 2),
    )

  def store(v: Pga3dTranslator, arr: Array[Double], offset: Int): Unit =
    arr(offset + 0) = v.wx
    arr(offset + 1) = v.wy
    arr(offset + 2) = v.wz

  def loadVector(arr: Array[Double], offset: Int): Pga3dVector =
    Pga3dVector(
      x = arr(offset + 0),
      y = arr(offset + 1),
      z = arr(offset + 2),
    )

  def store(v: Pga3dVector, arr: Array[Double], offset: Int): Unit =
    arr(offset + 0) = v.x
    arr(offset + 1) = v.y
    arr(offset + 2) = v.z

  def loadPoint(arr: Array[Double], offset: Int): Pga3dPoint =
    Pga3dPoint(
      x = arr(offset + 0),
      y = arr(offset + 1),
      z = arr(offset + 2),
    )

  def store(v: Pga3dPoint, arr: Array[Double], offset: Int): Unit =
    arr(offset + 0) = v.x
    arr(offset + 1) = v.y
    arr(offset + 2) = v.z

  def loadPlaneIdeal(arr: Array[Double], offset: Int): Pga3dPlaneIdeal =
    Pga3dPlaneIdeal(
      x = arr(offset + 0),
      y = arr(offset + 1),
      z = arr(offset + 2),
    )

  def store(v: Pga3dPlaneIdeal, arr: Array[Double], offset: Int): Unit =
    arr(offset + 0) = v.x
    arr(offset + 1) = v.y
    arr(offset + 2) = v.z

  def loadBivectorBulk(arr: Array[Double], offset: Int): Pga3dBivectorBulk =
    Pga3dBivectorBulk(
      xy = arr(offset + 0),
      xz = arr(offset + 1),
      yz = arr(offset + 2),
    )

  def store(v: Pga3dBivectorBulk, arr: Array[Double], offset: Int): Unit =
    arr(offset + 0) = v.xy
    arr(offset + 1) = v.xz
    arr(offset + 2) = v.yz

  def loadBivectorWeight(arr: Array[Double], offset: Int): Pga3dBivectorWeight =
    Pga3dBivectorWeight(
      wx = arr(offset + 0),
      wy = arr(offset + 1),
      wz = arr(offset + 2),
    )

  def store(v: Pga3dBivectorWeight, arr: Array[Double], offset: Int): Unit =
    arr(offset + 0) = v.wx
    arr(offset + 1) = v.wy
    arr(offset + 2) = v.wz

  def loadPseudoScalar(arr: Array[Double], offset: Int): Pga3dPseudoScalar =
    Pga3dPseudoScalar(
      i = arr(offset + 0),
    )

  def store(v: Pga3dPseudoScalar, arr: Array[Double], offset: Int): Unit =
    arr(offset + 0) = v.i

  def loadInertia(arr: Array[Double], offset: Int): Pga3dInertia =
    Pga3dInertia(
      mass = arr(offset + 0),
      mryz = arr(offset + 1),
      mrxz = arr(offset + 2),
      mrxy = arr(offset + 3),
    )

  def store(v: Pga3dInertia, arr: Array[Double], offset: Int): Unit =
    arr(offset + 0) = v.mass
    arr(offset + 1) = v.mryz
    arr(offset + 2) = v.mrxz
    arr(offset + 3) = v.mrxy