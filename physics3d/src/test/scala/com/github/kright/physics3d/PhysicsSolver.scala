package com.github.kright.physics3d

object PhysicsSolver:
  val euler2: PhysicsSolver = PhysicsSolver("euler2", 2, _.doStepEuler2(_))
  val rk2: PhysicsSolver = PhysicsSolver("RK2", 2, _.doStepRK2(_))
  val rk4: PhysicsSolver = PhysicsSolver("RK4", 4, _.doStepRK4(_))
  val rk4v2: PhysicsSolver = PhysicsSolver("RK4v2", 4, _.doStepRK4v2(_))

  val all: Seq[PhysicsSolver] = Seq(euler2, rk2, rk4, rk4v2)

class PhysicsSolver(val name: String, val order: Int, val doStep: (BodySystemT, Double) => Unit):
  override def toString: String = name
