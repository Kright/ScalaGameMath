package com.github.kright.pga3d.codegen

import com.github.kright.ga.MultiVector
import com.github.kright.symbolic.Sym

case class MultivectorUnaryOp(name: String,
                              op: MultiVector[Sym] => MultiVector[Sym]):
  def apply(v: MultiVector[Sym]): MultiVector[Sym] = op(v)
