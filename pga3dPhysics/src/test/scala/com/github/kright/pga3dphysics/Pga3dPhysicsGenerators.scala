package com.github.kright.pga3dphysics

import com.github.kright.math.VectorMathGenerators
import com.github.kright.pga3d.{Pga3dGenerators, Pga3dTranslator}
import org.scalacheck.Gen

object Pga3dPhysicsGenerators:
  def inertiaLocal(minMass: Double, maxMass: Double, minR: Double, maxR: Double): Gen[Pga3dInertiaLocal] =
    for {
      mass <- VectorMathGenerators.doubleInRange(minMass, maxMass)
      rx <- VectorMathGenerators.doubleInRange(minR, maxR)
      ry <- VectorMathGenerators.doubleInRange(minR, maxR)
      rz <- VectorMathGenerators.doubleInRange(minR, maxR)
    } yield Pga3dInertiaLocal.cube(mass, rx, ry, rz)

  val summableInertiaProbes = Seq(
    Pga3dInertiaSummable(1, 0, 0, 0, 0, 0, 0, 0, 0, 0),
    Pga3dInertiaSummable(0, 1, 0, 0, 0, 0, 0, 0, 0, 0),
    Pga3dInertiaSummable(0, 0, 1, 0, 0, 0, 0, 0, 0, 0),
    Pga3dInertiaSummable(0, 0, 0, 1, 0, 0, 0, 0, 0, 0),
    Pga3dInertiaSummable(0, 0, 0, 0, 1, 0, 0, 0, 0, 0),
    Pga3dInertiaSummable(0, 0, 0, 0, 0, 1, 0, 0, 0, 0),
    Pga3dInertiaSummable(0, 0, 0, 0, 0, 0, 1, 0, 0, 0),
    Pga3dInertiaSummable(0, 0, 0, 0, 0, 0, 0, 1, 0, 0),
    Pga3dInertiaSummable(0, 0, 0, 0, 0, 0, 0, 0, 1, 0),
    Pga3dInertiaSummable(0, 0, 0, 0, 0, 0, 0, 0, 0, 1),
  )

  val inertiaGen: Gen[Pga3dInertia] = for {
    inertiaLocal <- inertiaLocal(0.1, 10.0, 0.1, 10.0)
    q <- Pga3dGenerators.normalizedQuaternions
    shift <- Pga3dGenerators.vectors
    motor = Pga3dTranslator.addVector(shift).geometric(q)
  } yield Pga3dInertia(motor, inertiaLocal)