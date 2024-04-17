package com.github.kright.symbolic.transform.simplifiers

import com.github.kright.symbolic.Symbolic
import com.github.kright.symbolic.Symbolic.Func

class ProductFlattener extends SymbolicStrTransformDepthFirst({
  case Func("*", elems) if elems.exists {
    case Func("*", _) => true
    case _ => false
  } => Option {
    Func("*", elems.flatMap {
      case Func("*", elems) => elems
      case other => Seq(other)
    })
  }
  case _ => None
})
