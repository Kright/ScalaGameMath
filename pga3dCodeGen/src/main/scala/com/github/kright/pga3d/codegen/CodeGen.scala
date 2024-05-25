package com.github.kright.pga3d.codegen

class CodeGen:
  private var pad: Int = 0
  private val code = StringBuilder()

  def block(addCode: => Unit): Unit = {
    pad += 2
    addCode
    pad -= 2
  }

  def apply(lines: String*): Unit = {
    val prefix = " ".repeat(pad)
    for (line <- lines;
         l <- line.split("\n")) {
      code.append(prefix).append(l).append("\n")
    }
  }

  override def toString: String =
    code.toString().split("\n").map(s => if (s.isBlank) "" else s).mkString("\n")
