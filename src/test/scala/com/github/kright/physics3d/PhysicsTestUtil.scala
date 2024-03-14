package com.github.kright.physics3d

def assertBalancedForces(addForces: (Force3d, Force3d) => Unit): Unit =
  val force1 = Force3d()
  val force2 = Force3d()
  addForces(force1, force2)
  assert(force1.linear.isEquals(-force2.linear))
