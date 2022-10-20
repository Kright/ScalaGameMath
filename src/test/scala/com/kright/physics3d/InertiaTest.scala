package com.kright.physics3d

import com.kright.math.VectorMathGenerators
import com.kright.math.VectorMathGenerators.*
import com.kright.physics3d.PhysicsGenerator.inertiaMoment
import org.scalatest.funsuite.AnyFunSuite
import org.scalatestplus.scalacheck.ScalaCheckPropertyChecks

class InertiaTest extends AnyFunSuite with ScalaCheckPropertyChecks :
  test("localI to globalI conversion") {
    forAll(inertiaMoment, normalizedQuaternions, vectors3InCube) { (I, rot, rotVelocity) =>
      val inertia = Inertia3d(1.0, I)

      val localRotVelocity = rot.conjugated() * rotVelocity

      val L1 = rot * (inertia.localI * localRotVelocity)
      val L2 = inertia.getGlobalI(rot) * rotVelocity
      val L3 = inertia.getL(rot, rotVelocity)

      assert(L1.isEquals(L2))
      assert(L1.isEquals(L3))
    }
  }

  test("energy and impulse are constant during rotation") {
    forAll(inertiaMoment,
      vectors3InCube, normalizedQuaternions,
      vectors3InCube, vectors3InCube) { (I, pos, rot, linearVelocity, angularVelocity) =>

      val body = Inertia3d(1.0, I)
      val t = Transform3d(pos, rot)
      val v = Velocity3d(linearVelocity, angularVelocity * 0.1)
      val initialImpulse = body.getImpulse(t, v)
      val initialE = body.getEnergy(t, v)

      for (_ <- 0 until 100) {
        val dt = 0.01
        updateFreeBody(body, t, v, dt)
        val currentImpulse = body.getImpulse(t, v)
        val currentE = body.getEnergy(t, v)

        assert(Math.abs(currentE - initialE) < 0.001)
        assert(currentImpulse.linear.distance(initialImpulse.linear) < 0.001)
        assert(currentImpulse.angular.distance(initialImpulse.angular) < 0.001)
      }
    }
  }

  /**
   * improved Euler method, two-stage
   * https://en.wikipedia.org/wiki/Heun%27s_method
   */
  private def updateFreeBody(body: Inertia3d, t: Transform3d, v: Velocity3d, dt: Double): Unit =
    val zeroForce = Force3d()
    val acc = body.getAcceleration(t, v, zeroForce)
    val nextT = t.copy().update(v, dt)
    val nextV = v.copy().update(acc, dt)

    val acc2 = body.getAcceleration(nextT, nextV, zeroForce)
    t.update(v + nextV, 0.5 * dt)
    v.update(acc + acc2, 0.5 * dt)
