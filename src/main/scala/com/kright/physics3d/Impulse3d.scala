package com.kright.physics3d

import com.kright.math.Vector3d

class Impulse3d(val linear: Vector3d,
                val angular: Vector3d) extends LinearWithAngular[Impulse3d] :
  def this() = this(Vector3d(), Vector3d())

  override protected def makeNew(newLinear: Vector3d, newAngular: Vector3d): Impulse3d =
    Impulse3d(newLinear, newAngular)
