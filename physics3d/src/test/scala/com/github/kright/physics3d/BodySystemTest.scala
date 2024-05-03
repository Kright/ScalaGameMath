package com.github.kright.physics3d

import com.github.kright.math.VectorMathGenerators.*
import com.github.kright.physics3d.PhysicsGenerators.*
import org.scalacheck.Gen
import org.scalatest.funsuite.AnyFunSuite
import org.scalatestplus.scalacheck.ScalaCheckPropertyChecks

import scala.language.implicitConversions
import scala.util.chaining.*

type BodySystemT = BodySystem[Joint3d]

class BodySystemTest extends AnyFunSuite with ScalaCheckPropertyChecks:
  private def simulate(bodySystem: BodySystemT, doStep: BodySystemT => Unit): LazyList[SystemStats] =
    SystemStats(bodySystem) #:: simulate(bodySystem.copy().tap(b => doStep(b)), doStep)

  private def getMaxError(states: Iterable[SystemStats]): SystemInvariantErr =
    val first = states.head
    val errors = states.map(s => first.compareTo(s))
    SystemInvariantErr.max(errors)

  private def assertInvariantsAreConstant(solver: PhysicsSolver,
                                          states: Iterable[SystemStats],
                                          maxAllowedError: SystemInvariantErr): Unit =

    val maxError = getMaxError(states)
    maxError.assertFitsInto(maxAllowedError,
      s"""
         |solver ${solver}
         |actual max error ${maxError}
         |max allowed error = ${maxAllowedError}
         |initial state = ${states.head}
         |last state = ${states.last}""".stripMargin)

  test("one free body preserve stats") {
    val dt = 0.001

    forAll(solvers, bodySystems(bodiesCount = 1)) { (solver, systemFactory) =>
      val system = systemFactory()
      assert(system.masses.size == 1)
      assert(system.joints.isEmpty)
      assert(system.states.size == 1)

      val maxError = solver.order match
        case 2 => 1e-4
        case 4 => 1e-8

      val stats = simulate(system, solver.doStep(_, dt)).take(1000)
      assertInvariantsAreConstant(solver, stats, new SystemInvariantErr(maxError))
    }
  }

  test("many free bodies preserve stats") {
    val dt = 0.001

    forAll(solvers, bodySystems(bodiesCount = 10), MinSuccessful(100)) { (solver, systemFactory) =>
      val system = systemFactory()
      assert(system.masses.size == 10)
      assert(system.joints.isEmpty)
      assert(system.states.size == 10)

      val maxError = solver.order match
        case 2 => 1e-4
        case 4 => 1e-8

      val stats = simulate(system, solver.doStep(_, dt)).take(1000)
      assertInvariantsAreConstant(solver, stats, new SystemInvariantErr(maxError))
    }
  }

  test("three bodies with springs") {
    val dt = 0.001

    forAll(solvers, bodySystems(bodiesCount = 3), spring3dNoFriction, spring3dNoFriction, spring3dNoFriction) { (solver, systemFactory, s1, s2, s3) =>
      val system = systemFactory()
      system.addJoint(s1, 0, 1)
      system.addJoint(s2, 0, 2)
      system.addJoint(s3, 1, 1)

      val maxError = solver.order match
        case 2 => 1e-4
        case 4 => 1e-8

      val stats = simulate(system, solver.doStep(_, dt)).take(1000)
      assertInvariantsAreConstant(solver, stats, new SystemInvariantErr(maxError))
    }
  }

  test("two bodies with angle spring 1 to 2") {
    val dt = 0.001

    forAll(solvers, bodySystems(bodiesCount = 2), transforms, transforms, Gen.double.map(_ + 0.1)) { (solver, systemFactory, t1, t2, k1) =>
      val spring = AngularSpring3d(t1, t2, k1, 0.0)
      val system = systemFactory()
      system.addJoint(spring, 0, 1)

      val maxError = solver.order match
        case 2 => 1e-4
        case 4 => 1e-8

      val stats = simulate(system, solver.doStep(_, dt)).take(100)
      assertInvariantsAreConstant(solver, stats, new SystemInvariantErr(maxError))
    }
  }

  test("two bodies with angle spring 2 to 1") {
    val dt = 0.001

    forAll(solvers, bodySystems(bodiesCount = 2), transforms, transforms, Gen.double.map(_ + 0.1)) { (solver, systemFactory, t1, t2, k2) =>
      val system = systemFactory()
      val spring = AngularSpring3d(t1, t2, 0.0, k2)
      system.addJoint(spring, 0, 1)

      val maxError = solver.order match
        case 2 => 1e-4
        case 4 => 1e-8

      val stats = simulate(system, solver.doStep(_, dt)).take(100)
      assertInvariantsAreConstant(solver, stats, new SystemInvariantErr(maxError))
    }
  }


private class SystemStats(val accumulator: StatsAccumulator,
                          val potentialEnergy: Double,
                          val t: Double):

  def this(bodySystem: BodySystem[Joint3d]) =
    this(bodySystem.calculateStats(), bodySystem.getPotentialEnergy(), bodySystem.time)

  def totalEnergy: Double =
    accumulator.kineticEnergy + potentialEnergy

  override def toString: String =
    s"""totalEnergy = ${totalEnergy}, kineticEnergy = ${accumulator.kineticEnergy}, potentialEnergy = ${potentialEnergy}
       |impulse = ${accumulator.impulse}
       |center = ${accumulator.center}""".stripMargin

  def compareTo(other: SystemStats): SystemInvariantErr =
    val expectedOtherPos = accumulator.center + accumulator.centerVelocity * (other.t - t)

    SystemInvariantErr(
      totalEnergy = math.abs(totalEnergy - other.totalEnergy),
      linearImpulse = accumulator.linearImpulse.distance(other.accumulator.linearImpulse),
      angularImpulse = accumulator.angularImpulse.distance(other.accumulator.angularImpulse),
      centerOfMassPos = other.accumulator.center.distance(expectedOtherPos)
    )


private case class SystemInvariantErr(totalEnergy: Double,
                                      linearImpulse: Double,
                                      angularImpulse: Double,
                                      centerOfMassPos: Double):

  def this(eps: Double) = this(eps, eps, eps, eps)

  def assertFitsInto(maxErr: SystemInvariantErr, msg: => String): Unit =
    assert(totalEnergy < maxErr.totalEnergy, msg)
    assert(linearImpulse < maxErr.linearImpulse, msg)
    assert(angularImpulse < maxErr.angularImpulse, msg)
    assert(centerOfMassPos < maxErr.centerOfMassPos, msg)

  override def toString: String =
    s"""SystemInvariantErr(
       |  totalEnergy = $totalEnergy
       |  linearImpulse = $linearImpulse
       |  angularImpulse = $angularImpulse
       |  centerOfMassPos = $centerOfMassPos
       |)""".stripMargin

private object SystemInvariantErr:
  def max(iterable: Iterable[SystemInvariantErr]): SystemInvariantErr =
    SystemInvariantErr(
      totalEnergy = iterable.map(_.totalEnergy).max,
      linearImpulse = iterable.map(_.linearImpulse).max,
      angularImpulse = iterable.map(_.angularImpulse).max,
      centerOfMassPos = iterable.map(_.centerOfMassPos).max,
    )
