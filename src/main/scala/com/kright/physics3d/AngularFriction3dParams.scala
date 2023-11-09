package com.kright.physics3d

class AngularFriction3dParams(val twistFriction: Friction,
                              val ballJointFriction1: Friction,
                              val ballJointFriction2: Friction)

object AngularFriction3dParams:
  val zero: AngularFriction3dParams =
    AngularFriction3dParams(Friction.zero, Friction.zero, Friction.zero)
