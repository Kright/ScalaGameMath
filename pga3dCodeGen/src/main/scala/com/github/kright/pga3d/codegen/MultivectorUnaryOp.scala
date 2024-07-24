package com.github.kright.pga3d.codegen

import com.github.kright.ga.MultiVector
import com.github.kright.symbolic.Sym

case class MultivectorUnaryOp(f: (MultivectorSubClass, MultiVector[Sym]) => Option[String]):
  def apply(cls: MultivectorSubClass, v: MultiVector[Sym]): Option[String] = f(cls, v)
