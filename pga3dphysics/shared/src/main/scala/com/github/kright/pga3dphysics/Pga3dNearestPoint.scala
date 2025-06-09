package com.github.kright.pga3dphysics

import com.github.kright.pga3d.Pga3dPoint

final class Pga3dNearestPoint(val origin: Pga3dPoint,
                              var nearestPoint: Pga3dPoint | Null = null):
  var distSquare: Double =
    if (nearestPoint == null) Double.PositiveInfinity
    else (origin - nearestPoint).normSquare

  def distance: Double =
    Math.sqrt(distSquare)

  def update(newPoint: Pga3dPoint): Unit =
    val distSquare2 = (newPoint - origin).normSquare
    if (distSquare2 < distSquare) {
      distSquare = distSquare2
      nearestPoint = newPoint
    }
