package com.github.kright.pga3d.codegen.cpp

import com.github.kright.ga.{MultiVector, PGA3}
import com.github.kright.math.Sign
import com.github.kright.pga3d.codegen.common.{MultivectorField, MultivectorSubClass}
import com.github.kright.symbolic.Sym

import scala.math.Numeric.Implicits.infixNumericOps
import scala.util.Try
import scala.util.chaining.scalaUtilChainingOps

class CppSubclass(name: String,
                  variableFields: Seq[MultivectorField],
                  constantFields: Seq[(MultivectorField, Double)] = Seq(),
                  shouldBeGenerated: Boolean = true)(using pga3: PGA3) extends MultivectorSubClass(name, variableFields, constantFields, shouldBeGenerated) {

  val self: MultiVector[Sym] =
    require(this != CppSubclasses.scalar)
    MultiVector[Sym](
      variableFields.map(f => f.basisBlade -> Sym(f.name).pipe(e => if (f.sign == Sign.Positive) e else -e)).toMap ++
        constantFields.map((f, v) => f.basisBlade -> Sym(v).pipe(e => if (f.sign == Sign.Positive) e else -e))
    )

  def makeSymbolic(instanceName: String): MultiVector[Sym] =
    require(this != CppSubclasses.scalar)
    MultiVector[Sym](
      variableFields.map(f => f.basisBlade -> Sym(s"${instanceName}.${f.name}").pipe(e => if (f.sign == Sign.Positive) e else -e)).toMap ++
        constantFields.map((f, v) => f.basisBlade -> Sym(v).pipe(e => if (f.sign == Sign.Positive) e else -e))
    )

  def makeBracesInit(v: MultiVector[Sym]): String =
    val groupedResult = v.mapValues(_.groupMultipliers())

    if (this == CppSubclasses.scalar) {
      val expr = groupedResult.get(variableFields.head.basisBlade).getOrElse(Sym.zero)
      return expr.toString
    }

    this.variableFields.map { f =>
      val expr: Sym = groupedResult.get(f.basisBlade).getOrElse(Sym.zero)

      var exprString: String =
        if (f.sign == Sign.Positive) {
          expr.toString
        } else {
          // todo fix exception
          Try((-expr).toString).getOrElse(s"-$expr")
        }

      if (exprString.startsWith("--")) {
        exprString = exprString.drop(2)
      }

      s".${f.name} = ${exprString}"
    }.mkString("{", ", ", "}")
}