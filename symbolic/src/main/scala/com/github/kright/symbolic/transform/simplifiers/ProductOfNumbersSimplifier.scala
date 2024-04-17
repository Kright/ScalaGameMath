package com.github.kright.symbolic.transform.simplifiers

import com.github.kright.symbolic.Symbolic.Func
import com.github.kright.symbolic.SymbolicStr.Number
import com.github.kright.symbolic.transform.simplifiers.ProductOfNumbersSimplifier.trySimplify
import com.github.kright.symbolic.{Symbolic, SymbolicStr}

class ProductOfNumbersSimplifier extends SymbolicStrTransformDepthFirst({
  case Symbolic.Func("*", elems) => trySimplify(elems)
  case _ => None
})

object ProductOfNumbersSimplifier:
  private def trySimplify(elems: Seq[SymbolicStr]): Option[SymbolicStr] = {
    require(elems.size >= 2)

    val (numbers, others) = elems.partitionMap {
      case Number(v) => Left(v)
      case other => Right(other)
    }

    if (numbers.isEmpty) return None

    val product = numbers.product

    if (product == 0.0) return Option(SymbolicStr.zero)

    if (others.isEmpty) {
      // numbers size at least 2
      return Option(Number(product))
    }

    if (numbers.size == 1) {
      return
        if (numbers.head == 1.0) Option(makeProductOrSimplify(others.toSeq))
        else None
    }

    // numbers.size >= 2

    Option {
      if (product != 1.0)
        makeProductOrSimplify(Seq(SymbolicStr(product)) ++ others)
      else {
        makeProductOrSimplify(others.toSeq)
      }
    }
  }

  private def makeProductOrSimplify(elems: Seq[SymbolicStr]): SymbolicStr =
    require(elems.nonEmpty)
    if (elems.size == 1) return elems.head
    Func("*", elems)