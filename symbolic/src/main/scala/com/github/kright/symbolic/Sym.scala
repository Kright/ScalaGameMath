package com.github.kright.symbolic

import com.github.kright.symbolic.SymbolicStr.{size, symbolicStrNumeric}
import com.github.kright.symbolic.transform.PartialTransform
import com.github.kright.symbolic.transform.simplifiers.{GroupMultipliersInSumOfProducts, ProductFlattener, SymbolicStrSimplifier}

import scala.math.Numeric.Implicits.infixNumericOps

/**
 * Simple, but not customizable implementation for working with SymbolicStr
 */
case class Sym(symbol: SymbolicStr):
  override def toString: String = SymbolicToPrettyString(symbol)

  def size: Int =
    symbol.size

  def map(transform: PartialTransform[SymbolicStr]): Sym =
    transform(symbol).map(new Sym(_)).getOrElse(this)

  def groupMultipliers(): Sym =
    map(Sym.groupMultipliers)



object Sym:
  val argsSorter = SymbolicStrSimplifier.sortArgs()
  val simplifier: PartialTransform[SymbolicStr] = SymbolicStrSimplifier.simplify(64).combine(argsSorter)
  val groupMultipliers: PartialTransform[SymbolicStr] = GroupMultipliersInSumOfProducts().combine(ProductFlattener()).combine(argsSorter)
  val zero: Sym = Sym(0.0)
  val one: Sym = Sym(1.0)

  def apply(symbol: SymbolicStr): Sym =
    new Sym(Sym.simplifier.transform(symbol))

  def apply(name: String): Sym =
    Sym(SymbolicStr(name))

  def apply(value: Double): Sym =
    Sym(SymbolicStr(value))

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

