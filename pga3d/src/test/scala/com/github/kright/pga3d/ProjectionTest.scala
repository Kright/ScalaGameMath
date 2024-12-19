package com.github.kright.pga3d

import org.scalatest.funsuite.AnyFunSuiteLike

class ProjectionTest extends AnyFunSuiteLike:
  private def x: Pga3dVector = Pga3dVector.fromDual(1, 0, 0)

  private def y: Pga3dVector = Pga3dVector.fromDual(0, 1, 0)

  private def z: Pga3dVector = Pga3dVector.fromDual(0, 0, 1)

  test("project point onto line") {
    val px: Double = 1.0
    val py: Double = 2.0
    val pz: Double = 3.0

    val p = Pga3dPointNormalized.fromDual(px, py, pz).toPoint

    val center = Pga3dPointNormalized.fromDual(10.0, 20.0, 30.0).toPoint

    val cx = center v x
    val cy = center v y
    val cz = center v z

    assert(p.projectOntoLine(cx) == Pga3dPoint.fromDual(px, center.dualY, center.dualZ, w = 1.0))
    assert(p.projectOntoLine(cy) == Pga3dPoint.fromDual(center.dualX, py, center.dualZ, w = 1.0))
    assert(p.projectOntoLine(cz) == Pga3dPoint.fromDual(center.dualX, center.dualY, pz, w = 1.0))

    assert(p.projectOntoLine(center v x).dualW == 1.0)
    assert(p.projectOntoLine(center v -x).dualW == 1.0)
  }

  test("project point onto plane") {
    val px: Double = 1.0
    val py: Double = 2.0
    val pz: Double = 3.0

    val p = Pga3dPointNormalized.fromDual(px, py, pz).toPoint

    val center = Pga3dPointNormalized.fromDual(10.0, 20.0, 30.0).toPoint

    val cxy = center v x v y
    val cxz = center v x v z
    val cyz = center v y v z

    assert(p.projectOntoPlane(cxy) == Pga3dPoint.fromDual(px, py, center.dualZ, w = 1.0))
    assert(p.projectOntoPlane(cxz) == Pga3dPoint.fromDual(px, center.dualY, pz, w = 1.0))
    assert(p.projectOntoPlane(cyz) == Pga3dPoint.fromDual(center.dualX, py, pz, w = 1.0))

    assert(p.projectOntoPlane(center v x v y).dualW == 1.0)
    assert(p.projectOntoPlane(center v x v -y).dualW == 1.0)
  }

  test("project line onto plane") {
    val px: Double = 1.0
    val py: Double = 2.0
    val pz: Double = 3.0

    val p = Pga3dPointNormalized.fromDual(px, py, pz).toPoint

    val center = Pga3dPointNormalized.fromDual(10.0, 20.0, 30.0).toPoint

    val cxy = center v x v y
    val cxz = center v x v z
    val cyz = center v y v z

    val p1 = p
    val p2 = p1 + x + y + z

    for (plane <- Seq(cxy, cxz, cyz)) {
      val line = p1 v p2
      val projectedLine = line.projectOntoPlane(plane)
      val lineOnProjectedPoints = p1.projectOntoPlane(plane) v p2.projectOntoPlane(plane)

      assert((lineOnProjectedPoints - projectedLine).norm < 1e-10)
    }
  }
