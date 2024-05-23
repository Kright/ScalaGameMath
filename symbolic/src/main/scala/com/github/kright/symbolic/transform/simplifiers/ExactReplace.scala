package com.github.kright.symbolic.transform.simplifiers

import com.github.kright.symbolic.SymbolicStr


class ExactReplace(val value: SymbolicStr,
                   val replacement: SymbolicStr) extends SymbolicStrTransformDepthFirst({ expr =>
  if (expr == value) Option(replacement)
  else None
})
  
  