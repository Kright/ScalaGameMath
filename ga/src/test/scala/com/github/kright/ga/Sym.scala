package com.github.kright.ga

import com.github.kright.math.Sign
import com.github.kright.symbolic.SymbolicStr.given
import com.github.kright.symbolic.transform.PartialTransform
import com.github.kright.symbolic.transform.simplifiers.SymbolicStrSimplifier
import com.github.kright.symbolic.{SymbolicStr, SymbolicToPrettyString}

import scala.math.Numeric.Implicits.infixNumericOps

case class Sym(symbol: SymbolicStr):
  override def toString: String = SymbolicToPrettyString(symbol)

object Sym:
  val simplifier: PartialTransform[SymbolicStr] = SymbolicStrSimplifier.simplify(64).combine(SymbolicStrSimplifier.sortArgs())
  val zero: Sym = Sym(0.0)
  val one: Sym = Sym(1.0)

  def apply(symbol: SymbolicStr): Sym =
    new Sym(Sym.simplifier.transform(symbol))

  def apply(name: String): Sym =
    Sym(SymbolicStr(name))

  def apply(value: Double): Sym =
    Sym(SymbolicStr(value))


  def multiVector(baseName: String)(using ga: GA): MultiVector[Sym] =
    new MultiVector[Sym](ga, ga.blades.map(b => b -> Sym(s"${baseName}.${ga.representation(b)}")).toMap)

  def point(baseName: String)(using ga: PGA): MultiVector[Sym] =
    MultiVector[Sym](
      ga.generators.map { g =>
        val blade = BasisBlade(g, ga.signature)
        val symbol = if (g.squareSign == Sign.Zero) {
          Sym(1.0)
        } else {
          Sym(s"${baseName}.${ga.representation(g)}")
        }
        blade -> symbol
      }
    ).dual

  def planeX(d: Sym = Sym.zero)(using ga: PGA3): MultiVector[Sym] =
    PGA3.plane(
      Sym.one,
      Sym.zero,
      Sym.zero,
      d,
    )

  def plane(baseName: String)(using ga: PGA3): MultiVector[Sym] =
    PGA3.plane(
      Sym(s"${baseName}.nx"),
      Sym(s"${baseName}.ny"),
      Sym(s"${baseName}.nz"),
      Sym(s"${baseName}.d"),
    )

  given Numeric[Sym] with
    override def plus(x: Sym, y: Sym): Sym = Sym(x.symbol + y.symbol)

    override def minus(x: Sym, y: Sym): Sym = Sym(x.symbol - y.symbol)

    override def times(x: Sym, y: Sym): Sym = Sym(x.symbol * y.symbol)

    override def negate(x: Sym): Sym = Sym(-x.symbol)

    override def fromInt(x: Int): Sym = Sym(SymbolicStr(x))

    override def parseString(str: String): Option[Sym] = summon[Numeric[SymbolicStr]].parseString(str).map(Sym(_))

    override def toInt(x: Sym): Int = ???

    override def toLong(x: Sym): Long = ???

    override def toFloat(x: Sym): Float = ???

    override def toDouble(x: Sym): Double = ???

    override def compare(x: Sym, y: Sym): Int = ???
