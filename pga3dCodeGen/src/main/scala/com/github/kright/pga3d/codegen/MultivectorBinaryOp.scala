package com.github.kright.pga3d.codegen

import com.github.kright.ga.MultiVector
import com.github.kright.symbolic.Sym

case class MultivectorBinaryOp(names: Seq[String],
                               op: (MultiVector[Sym], MultiVector[Sym]) => MultiVector[Sym]):
  require(names.nonEmpty)

  def apply(a: MultiVector[Sym], b: MultiVector[Sym]): MultiVector[Sym] = op(a, b)

  def name: String = names.head
