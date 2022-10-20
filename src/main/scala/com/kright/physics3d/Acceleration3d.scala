package com.kright.physics3d

import com.kright.math.Vector3d

class Acceleration3d(val linear: Vector3d,
                     val angular: Vector3d) extends LinearWithAngular[Acceleration3d] :
  
  def this() = this(Vector3d(), Vector3d())

  override protected def makeNew(newLinear: Vector3d, newAngular: Vector3d): Acceleration3d =
    Acceleration3d(newLinear, newAngular)
