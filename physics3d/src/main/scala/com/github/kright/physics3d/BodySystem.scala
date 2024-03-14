package com.github.kright.physics3d

import com.github.kright.math.DifferentialSolvers

import scala.collection.mutable.ArrayBuffer

/**
 * Reference implementation of system of bodies with joints between them.
 * It is simple, but not efficient.
 *
 * If you want to add gravitation or constraints, you could override methods [[getDerivative]] and [[nextState]]
 */
class BodySystem[Joint <: Joint3d]:
  type State = ArrayBuffer[State3d]
  type Derivative = ArrayBuffer[State3d]

  val masses: ArrayBuffer[Inertia3d] = ArrayBuffer()
  val joints: ArrayBuffer[(Joint, Int, Int)] = ArrayBuffer()
  val states: State = ArrayBuffer()
  var time: Double = 0.0

  /**
   * @return index of added body
   */
  def addBody(mass: Inertia3d, state: State3d): Int =
    masses += mass
    states += state
    masses.size - 1

  def addJoint(joint: Joint, firstBodyIndex: Int, secondBodyIndex: Int): Unit =
    joints += ((joint, firstBodyIndex, secondBodyIndex))

  def copy(): BodySystem[Joint] =
    val result = new BodySystem[Joint]()
    result.masses.addAll(masses)
    result.joints.addAll(joints)
    result.states.addAll(states.map(_.copy()))
    result.time = time
    result

  def calculateStats(): StatsAccumulator =
    StatsAccumulator { acc =>
      for ((m, s) <- masses.zip(states)) {
        acc.add(m, s)
      }
    }

  def getPotentialEnergy(): Double =
    joints.view.map { (joint, i, j) =>
      joint.getPotentialEnergy(states(i), states(j))
    }.sum

  protected def setState(newState: State): Unit =
    for (i <- states.indices) {
      states(i) := newState(i)
    }

  def doStepEuler2(dt: Double): Unit =
    val newState = DifferentialSolvers.euler2[ArrayBuffer[State3d], ArrayBuffer[State3d]](
      initial = states,
      time = time,
      dt = dt,
      getDerivative = getDerivative,
      nextState = nextState,
      newZeroDerivative = () => newZeroDerivative(),
      madd = madd
    )
    setState(newState)
    time += dt

  def doStepRK2(dt: Double): Unit =
    val newState = DifferentialSolvers.rungeKutta2[ArrayBuffer[State3d], ArrayBuffer[State3d]](
      initial = states,
      time = time,
      dt = dt,
      getDerivative = getDerivative,
      nextState = nextState,
    )
    setState(newState)
    time += dt

  def doStepRK4(dt: Double): Unit =
    val newState = DifferentialSolvers.rungeKutta4[ArrayBuffer[State3d], ArrayBuffer[State3d]](
      initial = states,
      time = time,
      dt = dt,
      getDerivative = getDerivative,
      nextState = nextState,
      newZeroDerivative = () => newZeroDerivative(),
      madd = madd,
    )
    setState(newState)
    time += dt

  def doStepRK4v2(dt: Double): Unit =
    val (k1, k2, k3, k4) = DifferentialSolvers.rungeKutta4K[ArrayBuffer[State3d], ArrayBuffer[State3d]](
      initial = states,
      time = time,
      dt = dt,
      getDerivative = getDerivative,
      nextState = nextState,
    )

    madd(states, k1, dt / 6.0)
    madd(states, k2, dt * (2.0 / 6.0))
    madd(states, k3, dt * (2.0 / 6.0))
    madd(states, k4, dt / 6.0)

    for (s <- states) {
      s.normalize()
    }
    time += dt

  def getDerivative(currentState: State, time: Double): Derivative =
    val forces = currentState.map(s => Force3d())
    for ((joint, i, j) <- joints) {
      joint.addForces(currentState(i), currentState(j), forces(i), forces(j))
    }
    currentState.zipWithIndex.map { (s, i) =>
      State3dDerivative(s, masses(i), forces(i))
    }

  def nextState(state: State, derivative: ArrayBuffer[State3d], dt: Double): ArrayBuffer[State3d] =
    state.zip(derivative).map { (s, d) =>
      s.copy().madd(d, dt).normalize()
    }

  def newZeroDerivative(): Derivative =
    states.map(_ => State3dDerivative())

  def madd(accum: Derivative, added: Derivative, multiplier: Double): Unit =
    for (i <- accum.indices) {
      accum(i).madd(added(i), multiplier)
    }
