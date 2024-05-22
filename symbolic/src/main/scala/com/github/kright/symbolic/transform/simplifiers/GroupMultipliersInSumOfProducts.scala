package com.github.kright.symbolic.transform.simplifiers

import com.github.kright.symbolic.Symbolic.Func
import com.github.kright.symbolic.transform.PartialTransform
import com.github.kright.symbolic.{Symbolic, SymbolicStr}


class GroupMultipliersInSumOfProducts extends PartialTransform[SymbolicStr]:
  override def apply(value: SymbolicStr): Option[SymbolicStr] =
    value match
      case Func("+", elems) =>
        val elemsAsProducts = elems.collect {
          case f@Func("*", p) => f
        }
        if (elemsAsProducts.size < elems.size) {
          None
        } else {
          val commonElements = elemsAsProducts.map(_.args.toSet).reduce(_ intersect _).filter(_ != SymbolicStr.minusOne)
          if (commonElements.isEmpty) {
            None
          } else {
            val sum = Func("+", elemsAsProducts.map { f =>
              val others: Seq[SymbolicStr] = f.args.filter(a => !commonElements.contains(a))
              others.size match
                case 0 => SymbolicStr.one
                case 1 => others.head
                case _ => f.copy(args = others)
            })

            Option(Func("*", commonElements.toSeq :+ sum))
          }
        }

      case _ => None