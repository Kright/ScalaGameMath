package com.github.kright.pga3d.codegen

import com.github.kright.ga.{BasisBlade, BasisBladeWithSign}

case class MultivectorField(name: String,
                            basisBladeWithSign: BasisBladeWithSign):
  def basisBlade: BasisBlade = basisBladeWithSign.basisBlade
