package com.github.kright.math

import scala.annotation.targetName

trait IEqualsWithEps[T]:
  def isEquals(other: T, eps: Double): Boolean

  @targetName("isEquals")
  def ===(other: T)(using eps: EqualityEps): Boolean =
    isEquals(other, eps.value)
