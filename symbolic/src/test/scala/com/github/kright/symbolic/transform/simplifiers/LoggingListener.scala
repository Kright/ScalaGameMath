package com.github.kright.symbolic.transform.simplifiers

import com.github.kright.symbolic.SymbolicStr
import com.github.kright.symbolic.transform.{PartialTransform, PartialTransformListener}

import scala.util.{Failure, Success, Try}

class LoggingListener extends PartialTransformListener[SymbolicStr]:
  val log = StringBuilder()

  override def apply(partialTransform: PartialTransform[SymbolicStr],
                     argument: SymbolicStr,
                     result: Try[Option[SymbolicStr]]): Unit =
    def append(msg: String): Unit =
      log.append(s"${partialTransform.getClass.getSimpleName}: $msg\n")

    result match
      case Failure(exception) => append(s"ERROR ${exception}")
      case Success(Some(resultExpr)) => append(s"${argument} => ${resultExpr}")
      case Success(None) =>
