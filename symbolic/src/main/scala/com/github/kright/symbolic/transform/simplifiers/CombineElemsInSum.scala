package com.github.kright.symbolic.transform.simplifiers

import com.github.kright.symbolic.Symbolic.Func
import com.github.kright.symbolic.SymbolicStr
import com.github.kright.symbolic.transform.simplifiers.CombineElemsInSum.trySimplify


class CombineElemsInSum(sortArgs: ArgsSorter) extends SymbolicStrTransformDepthFirst({
  case Func("+", elems) => trySimplify(elems, sortArgs)
  case _ => None
})

object CombineElemsInSum:
  private def trySimplify(elems: Seq[SymbolicStr], sortArgs: ArgsSorter): Option[SymbolicStr] =
    require(elems.size >= 2)

    val normalizedElems: Seq[NormalizedForm] = elems.map {
      case Func("*", args) => {
        require(args.size >= 2)
        NormalizedForm(args, sortArgs)
      }
      case SymbolicStr.Number(value) => NormalizedForm(value)
      case other => NormalizedForm(Seq(other), sortArgs)
    }

    val combined: Seq[SymbolicStr] = normalizedElems.zipWithIndex
      .groupBy { (form, i) => form.otherSortedArgs }
      .toSeq
      .map { (args, lst) =>
        val (first, minI) = lst.head
        val mult = lst.map((norm, _) => norm.multiplier).sum
        (first.copy(multiplier = mult), minI)
      }.sortBy((_, minI) => minI)
      .map((form, _) => form.toProductOrSymbol)

    combined match
      case _ if combined.size == elems.size => None
      case Seq() => ???
      case Seq(singleElement) => Option(singleElement)
      case manyElements => Option(Func("+", manyElements))


private case class NormalizedForm(multiplier: Double,
                                  otherSortedArgs: Seq[SymbolicStr],
                                  otherOriginalArgs: Seq[SymbolicStr]):
  def toProductOrSymbol: SymbolicStr =
    if (multiplier == 0.0) return SymbolicStr.zero

    val allArgs: Seq[SymbolicStr] =
      if (multiplier == 1.0) otherOriginalArgs
      else Seq(SymbolicStr(multiplier)) ++ otherOriginalArgs

    allArgs match
      case Seq() => SymbolicStr.one
      case Seq(oneArg) => oneArg
      case manyArgs => Func("*", manyArgs)


object NormalizedForm:
  def apply(multiplier: Double): NormalizedForm =
    NormalizedForm(multiplier, Seq(), Seq())

  def apply(productElements: Seq[SymbolicStr], sortArgs: ArgsSorter): NormalizedForm =
    val (numbers, otherOriginalArgs) = productElements.partitionMap {
      case SymbolicStr.Number(v) => Left(v)
      case other => Right(other)
    }

    NormalizedForm(
      multiplier = numbers.product,
      otherSortedArgs = otherOriginalArgs.map(sortArgs.transform).sorted(using sortArgs.ordering),
      otherOriginalArgs = otherOriginalArgs
    )
