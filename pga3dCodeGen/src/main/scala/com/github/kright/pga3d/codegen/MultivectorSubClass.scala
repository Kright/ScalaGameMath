package com.github.kright.pga3d.codegen

import com.github.kright.ga.*
import com.github.kright.math.Sign
import com.github.kright.pga3d.codegen.MultivectorSubClass.*
import com.github.kright.symbolic.Sym
import com.github.kright.symbolic.transform.simplifiers.ReplaceSumOrProduct

import scala.math.Numeric.Implicits.infixNumericOps

case class MultivectorSubClass(name: String,
                               variableFields: Seq[MultivectorField],
                               constantFields: Seq[(MultivectorField, Double)] = Seq(),
                               shouldBeGenerated: Boolean = true) extends CodeGenClass:
  private val fieldBlades: Set[BasisBlade] = {
    val variables = variableFields.map(_.basisBlade).toSet
    val constants = constantFields.map(_._1.basisBlade).toSet
    require(variables.size == variableFields.size)
    require(constants.size == constantFields.size)
    require(variables.intersect(constants).isEmpty)
    variables ++ constants
  }

  override def isObject: Boolean = variableFields.isEmpty

  def makeSymbolic(instanceName: String)(using ga: GA): MultiVector[Sym] =
    if (name == "Double") {
      MultiVector.scalar(Sym(instanceName))
    } else {
      MultiVector[Sym](
        variableFields.map(f => f.basisBlade -> Sym(s"${instanceName}.${f.name}")).toMap ++
          constantFields.map((f, v) => f.basisBlade -> Sym(v))
      )
    }

  def makeSymbolicThis(using ga: GA): MultiVector[Sym] =
    if (name == "Double") {
      MultiVector.scalar(Sym("this"))
    } else {
      MultiVector[Sym](
        variableFields.map(f => f.basisBlade -> Sym(f.name)).toMap ++
          constantFields.map((f, v) => f.basisBlade -> Sym(v))
      )
    }

  def isMatching(vec: MultiVector[Sym]): Boolean = {
    vec.values.forall { (blade, value) => value == Sym.zero || fieldBlades.contains(blade) } &&
      constantFields.forall { (f, v) =>
        vec.get(f.basisBlade) match
          case Some(sym) => sym == Sym(v)
          case None if v == 0.0 => true
          case _ => false
      }
  }

  def makeConstructor(code: CodeGen, result: MultiVector[Sym]): Unit =
    val groupedResult = result.mapValues(_.groupMultipliers())
    if (name == "Double") {
      val expr = groupedResult.get(variableFields.head.basisBlade).getOrElse(Sym.zero)
      code(expr.toString)
    } else if (variableFields.nonEmpty) {
      code(name + "(")
      code.block {
        for (f <- variableFields) {
          val expr = groupedResult.get(f.basisBlade).getOrElse(Sym.zero)
          code(s"${f.name} = ${expr},")
          //          code(s"${f.name} = /* ${expr.size} */ ${expr},")
        }
      }
      code(")")
    } else {
      code(s"${name}")
    }

  override def generateCode(): String =
    generateCode(unaryOperations, binaryOperations)(using MultivectorSubClass.pga3)

  private def generateCode(unaryOps: Seq[MultivectorUnaryOp],
                           binaryOps: Seq[MultivectorBinaryOp])(using ga: PGA3): String = {
    val code = CodeGen()
    val self = makeSymbolicThis

    if (isObject) {
      code(s"case object ${name}:")
    } else {
      code(s"case class ${name}(")
      code.block {
        for (f <- variableFields) {
          code(s"${f.name}: Double = 0.0,")
        }
      }
      code(s"):")
    }

    code.block {
      for ((f, v) <- constantFields) {
        code(s"inline val ${f.name} = ${v}")
      }

      if (name.contains("Point") || this == vector) {
        makeSymbolicThis.dual.values.foreach { (b, sym) =>
          val fName = s"dual${ga.representation(b).toUpperCase}"
          code("", s"inline def $fName: Double = ${sym}")
        }
      }

      for (unaryOp <- unaryOps) {
        val result = unaryOp(self)
        val resultCls = findMatchingClass(result)

        if (resultCls != zeroCls) {
          code("")
          code(s"def ${unaryOp.name}: ${resultCls.typeName} =")
          code.block {
            if (result == self) {
              code("this")
            } else resultCls.makeConstructor(code, result)
          }
        }
      }

      for ((normName, normVecName) <- Seq(
        ("bulkNorm", "normalizedByBulk"),
        ("weightNorm", "normalizedByWeight"),
        ("norm", "normalizedByNorm")
      )) {
        if (code.toString.contains(s"${normName}Square")) {
          code("", s"def $normName: Double =")
          code.block {
            code(s"Math.sqrt(${normName}Square)")
          }

          code("", s"def $normVecName =")
          code.block {
            code(s"this / $normName")
          }
        }
      }

      {
        val v = Sym("v")
        val result = self * v
        val resultCls = findMatchingClass(result)
        code("", s"def *(v: Double): ${resultCls.typeName} =")
        code.block {
          resultCls.makeConstructor(code, result)
        }
        code("", s"inline def /(v: Double): ${resultCls.typeName} =")
        code.block {
          code("this * (1.0 / v)")
        }
      }

      {
        def makeMethod(result: MultiVector[Sym], firstLine: String): Unit = {
          val resultCls = findMatchingClass(result)

          if (resultCls != zeroCls) {
            code("", firstLine + s": ${resultCls.typeName} =")
            code.block {
              resultCls.makeConstructor(code, result)
            }
          }
        }

        val points = Set(point, pointNormalized, vector)
        val bivectors = Set(bivector, bivectorBulk, bivectorWeight)
        if (points.contains(this)) {
          for (pClass <- points) {
            val v = pClass.makeSymbolic("v")
            makeMethod(self + v, s"def +(v: ${pClass.typeName})")
            makeMethod(self - v, s"def -(v: ${pClass.typeName})")
            makeMethod(self + v * Sym("mult"), s"def madd(v: ${pClass.typeName}, mult: Double)")
          }
        } else if (bivectors.contains(this)) {
          for (pClass <- bivectors) {
            val v = pClass.makeSymbolic("v")
            makeMethod(self + v, s"def +(v: ${pClass.typeName})")
            makeMethod(self - v, s"def -(v: ${pClass.typeName})")
            makeMethod(self + v * Sym("mult"), s"def madd(v: ${pClass.typeName}, mult: Double)")
          }
        } else {
          val v = makeSymbolic("v")
          makeMethod(self + v, s"def +(v: ${typeName})")
          makeMethod(self - v, s"def -(v: ${typeName})")
          makeMethod(self + v * Sym("mult"), s"def madd(v: ${typeName}, mult: Double)")
        }

        makeMethod(self.multiplyElementwise(makeSymbolic("v")), s"def multiplyElementwise(v: ${typeName})")
      }

      defExpForBivector(code)
      defLogForMotor(code)
      defBivectorSplit(code)

      for (target <- pgaClasses) {
        if (target != this && target.isMatching(self)) {
          code("", s"def to${target.typeName.capitalize}: ${target.typeName} =")
          code.block {
            target.makeConstructor(code, self)
          }
        }
      }

      for (binaryOp <- binaryOps) {
        for (rightCls <- pgaClasses if (rightCls != zeroCls) && (rightCls != scalar)) {
          val self = makeSymbolicThis
          val v = rightCls.makeSymbolic("v")
          val result = binaryOp(self, v)
          val resultCls = findMatchingClass(result)
          if (resultCls != zeroCls) {
            code("", s"infix def ${binaryOp.name}(v: ${rightCls.typeName}): ${resultCls.typeName} =")
            code.block {
              binaryOp.name match
                case "sandwich" | "reverseSandwich" => makeOptimized(self, result, resultCls, code)
                case _ => resultCls.makeConstructor(code, result)
            }

            for (opName <- binaryOp.names.tail) {
              code("")
              code(s"inline infix def ${opName}(v: ${rightCls.typeName}): ${resultCls.typeName} = ${binaryOp.name}(v)")
            }
          }
        }
      }
    }

    val points = Set(point, pointNormalized, vector)
    if (points.contains(this)) {
      code(s"\n\nobject ${typeName}:")
      code.block {
        if (this == point) {
          val v = MultiVector("x" -> Sym("x"), "y" -> Sym("y"), "z" -> Sym("z"), "w" -> Sym("w"))
          code(s"def fromDual(x: Double, y: Double, z: Double, w: Double): ${typeName} =")
          code.block {
            makeConstructor(code, v.dual)
          }
        }
        else {
          val v = MultiVector("x" -> Sym("x"), "y" -> Sym("y"), "z" -> Sym("z"))
          code(s"def fromDual(x: Double, y: Double, z: Double): ${typeName} =")
          code.block {
            makeConstructor(code, v.dual)
          }
        }
      }
    }

    code.toString
  }

  private def makeOptimized(self: MultiVector[Sym], result: MultiVector[Sym], resultCls: MultivectorSubClass, code: CodeGen): Unit = {
    val simplifications: Seq[(Sym, Sym)] =
      (for ((fx, i) <- variableFields.zipWithIndex;
            (fy, j) <- variableFields.zipWithIndex if i <= j)
      yield Sym(s"${fx.name}M${fy.name}") -> self(fx.basisBlade) * self(fy.basisBlade))

    var rr = result
    for ((simple, expr) <- simplifications) {
      val replacer = ReplaceSumOrProduct(expr.symbol, simple.symbol)
      val newRR = rr.mapValues(v => v.map(replacer))

      if ((getSize(newRR) + 1 < getSize(rr))) {
        rr = newRR
        code(s"val ${simple.toString} = ${expr.toString}")
      }
    }

    resultCls.makeConstructor(code, rr.mapValues(_.map(Sym.argsSorter)))
  }

  private def defExpForBivector(code: CodeGen)(using ga: GA): Unit = {
    if (this == MultivectorSubClass.bivector) {
      {
        val self = makeSymbolicThis
        val IBdiv2 = self.bulk ^ self.weight
        val aIBettaDiv2 = self.geometric(IBdiv2)
        val result = MultiVector.scalar(Sym("cos")) + (self + IBdiv2) * Sym("sinDivLen") + aIBettaDiv2 * Sym("sinMinusCosDivLen2")

        code("", "def exp(): Motor =")
        code.block {
          code(
            "val len = bulkNorm",
            "val cos = Math.cos(len)",
            "",
            "val sinDivLen = if (len > 1e-5) {",
            "  Math.sin(len) / len",
            "} else 1.0 - (len * len) / 6.0",
            "",
            "val sinMinusCosDivLen2 = if (len > 1e-5) {",
            "  (sinDivLen - cos) / (len * len)",
            "} else (1.0 / 3.0) * (1.0 + 0.8 * len * len)",
            "",
          )
          motor.makeConstructor(code, result)
        }
      }

      {
        val self = makeSymbolicThis * Sym("t")
        val IBdiv2 = self.bulk ^ self.weight
        val aIBettaDiv2 = self.geometric(IBdiv2)
        val result = MultiVector.scalar(Sym("cos")) + (self + IBdiv2) * Sym("sinDivLen") + aIBettaDiv2 * Sym("sinMinusCosDivLen2")

        code("", "def exp(t: Double): Motor =")
        code.block {
          code(
            "val len = bulkNorm * Math.abs(t)",
            "val cos = Math.cos(len)",
            "",
            "val sinDivLen = if (len > 1e-5) {",
            "  Math.sin(len) / len",
            "} else 1.0 - (len * len) / 6.0",
            "",
            "val sinMinusCosDivLen2 = if (len > 1e-5) {",
            "  (sinDivLen - cos) / (len * len)",
            "} else (1.0 / 3.0) * (1.0 + 0.8 * len * len)",
            "",
          )
          motor.makeConstructor(code, result)
        }
      }
    }
    if (this == MultivectorSubClass.bivectorBulk) {
      {
        val self = makeSymbolicThis
        val IBdiv2 = self.bulk ^ self.weight
        val aIBettaDiv2 = self.geometric(IBdiv2)
        val result = MultiVector.scalar(Sym("cos")) + (self + IBdiv2) * Sym("sinDivLen") + aIBettaDiv2 * Sym("sinMinusCosDivLen2")

        code("", s"def exp(): ${quaternion.typeName} =")
        code.block {
          code(
            "val len = bulkNorm",
            "val cos = Math.cos(len)",
            "",
            "val sinDivLen = if (len > 1e-5) {",
            "  Math.sin(len) / len",
            "} else 1.0 - (len * len) / 6.0",
            "",
          )
          quaternion.makeConstructor(code, result)
        }
      }

      {
        val self = makeSymbolicThis * Sym("t")
        val IBdiv2 = self.bulk ^ self.weight
        val aIBettaDiv2 = self.geometric(IBdiv2)
        val result = MultiVector.scalar(Sym("cos")) + (self + IBdiv2) * Sym("sinDivLen") + aIBettaDiv2 * Sym("sinMinusCosDivLen2")

        code("", s"def exp(t: Double): ${quaternion.typeName} =")
        code.block {
          code(
            "val len = bulkNorm * Math.abs(t)",
            "val cos = Math.cos(len)",
            "",
            "val sinDivLen = if (len > 1e-5) {",
            "  Math.sin(len) / len",
            "} else 1.0 - (len * len) / 6.0",
            "",
          )
          quaternion.makeConstructor(code, result)
        }
      }
    }
    if (this == MultivectorSubClass.bivectorWeight) {
      {
        val result = MultiVector.scalar(Sym(1.0)) + makeSymbolicThis
        code("", s"def exp(): ${translator.typeName} =")
        code.block {
          translator.makeConstructor(code, result)
        }
      }

      {
        val result = MultiVector.scalar(Sym(1.0)) + makeSymbolicThis * Sym("t")
        code("", s"def exp(t: Double): ${translator.typeName} =")
        code.block {
          translator.makeConstructor(code, result)
        }
      }
    }
  }

  private def defLogForMotor(code: CodeGen)(using ga: GA): Unit = {
    if (this == MultivectorSubClass.motor) {
      val vb = makeSymbolicThis.grade(2)
      val result = vb * Sym("b") + vb.bulk.dual * Sym("c")

      code("", s"def log(): ${bivector.typeName} =")
      code.block {
        code(
          s"""val scalar = s
             |val lenXYZ = Math.sqrt(xy * xy + xz * xz + yz * yz)
             |val angle = Math.atan2(lenXYZ, scalar)
             |
             |val a = 1.0 / (1.0 - scalar * scalar) // 1 / sin^2
             |
             |val b = if (Math.abs(angle) > 1e-5) { // angle / sin(angle)
             |  angle * Math.sqrt(a)
             |} else {
             |  1.0 + angle * angle / 6.0
             |}
             |
             |val c = if (Math.abs(angle) > 1e-5) {
             |  a * i * (1.0 - scalar * b)
             |} else {
             |  (1.0 + angle * angle / 2.0) * i / 3.0
             |}
             |""".stripMargin, "")
        bivector.makeConstructor(code, result)
      }
    }
    if (this == MultivectorSubClass.translator) {
      code("", s"def log(): ${bivectorWeight.typeName} =")
      code.block {
        bivectorWeight.makeConstructor(code, makeSymbolicThis.weight)
      }
    }
    if (this == MultivectorSubClass.quaternion) {
      val vb = makeSymbolicThis.grade(2)
      val result = vb * Sym("b")

      code("", s"def log(): ${bivectorBulk.typeName} =")
      code.block {
        code(
          s"""val scalar = s
             |val lenXYZ = Math.sqrt(xy * xy + xz * xz + yz * yz)
             |val angle = Math.atan2(lenXYZ, scalar)
             |
             |val a = 1.0 / (1.0 - scalar * scalar) // 1 / sin^2
             |
             |val b = if (Math.abs(angle) > 1e-5) { // angle / sin(angle)
             |  angle * Math.sqrt(a)
             |} else {
             |  1.0 + angle * angle / 6.0
             |}
             |""".stripMargin, "")
        bivectorBulk.makeConstructor(code, result)
      }
    }
  }

  private def defBivectorSplit(code: CodeGen)(using ga: GA): Unit = {
    if (this == bivector) {
      code("\ndef split(): (Bivector, BivectorWeight) =")
      code.block {
        val self = makeSymbolicThis

        code(
          s"""val div = bulkNormSquare
             |if (div < 1e-100) {
             |  return (Bivector(0.0, 0.0, 0.0, xy, xz, yz), BivectorWeight(wx, wy, wz))
             |}
             |
             |// val shiftAlongLine = this.geometric((this ^ this.reverse) / div / 2.0)
             |// pseudoScalar = this ^ this.reverse
             |
             |val pseudoScalar = ${(self ^ self.reverse).pseudoScalar * Sym(0.5)} / div
             |val shiftAlongLine = """.stripMargin
        )
        code.block {
          bivectorWeight.makeConstructor(code, self.geometric(MultiVector("i" -> Sym("pseudoScalar"))))
        }
        code(s"val line = this - shiftAlongLine")
        code("(line, shiftAlongLine)")
      }
    }
  }

  private def getSize(a: MultiVector[Sym]): Int =
    a.values.map((b, s) => s.size).sum

object MultivectorSubClass:
  private def representationConfig = GARepresentationConfig(
    Signature.pga3,
    generatorNames = "wxyz",
    namePrefix = "",
    overrideScalar = Option("s"),
    overridePseudoScalar = Option("i"),
  )

  given pga3: PGA3 = PGA3(representationConfig)

  private val genW = pga3.generators.find(_.squareSign == Sign.Zero).get

  private val orderedFields = pga3.blades.map(b => MultivectorField(pga3.representation(b), b))

  private val fields = orderedFields.map(f => f.name -> f).toMap

  val multivector = MultivectorSubClass("Multivector", orderedFields)

  val motor = MultivectorSubClass("Motor", orderedFields.filter(b => Seq(0, 2, 4).contains(b.basisBlade.grade)))

  val scalar = MultivectorSubClass("Double", orderedFields.take(1), shouldBeGenerated = false)
  val plane = MultivectorSubClass("Plane", orderedFields.filter(_.basisBlade.grade == 1))
  val bivector = MultivectorSubClass("Bivector", orderedFields.filter(_.basisBlade.grade == 2))
  val point = MultivectorSubClass("Point", orderedFields.filter(_.basisBlade.grade == 3))
  val pseudoScalar = MultivectorSubClass("PseudoScalar", orderedFields.takeRight(1))

  val quaternion = MultivectorSubClass("Quaternion", motor.variableFields.filter(f => !f.basisBlade.contains(genW)))
  //  val quaternionDual = MultivectorSubClass("QuaternionDual", motor.variableFields.filter(f => f.basisBlade.contains(genW)))
  val translator = MultivectorSubClass("Translator", motor.variableFields.filter(f => f.basisBlade.grade == 2 && f.basisBlade.contains(genW)), Seq(scalar.variableFields.head -> 1.0))

  val vector = MultivectorSubClass("Vector", point.variableFields.filter(f => f.basisBlade.contains(genW)))
  val planeIdeal = MultivectorSubClass("PlaneIdeal", plane.variableFields.filter(f => !f.basisBlade.contains(genW)))
  val pointNormalized = {
    val (weight, bulk) = point.variableFields.partition(_.basisBlade.contains(genW))
    MultivectorSubClass("PointNormalized", weight, bulk.map(f => (f, 1.0)))
  }

  val bivectorWeight = MultivectorSubClass("BivectorWeight", bivector.variableFields.filter(f => f.basisBlade.contains(genW)))
  val bivectorBulk = MultivectorSubClass("BivectorBulk", bivector.variableFields.filter(f => !f.basisBlade.contains(genW)))

  val pointCenter = MultivectorSubClass("PointCenter", Seq(), point.variableFields.map(f => (f, (if (f.basisBlade.contains(genW)) 0.0 else 1.0))))
  val zeroCls = MultivectorSubClass("Zero", Seq(), shouldBeGenerated = false)

  val pgaClasses = Seq(
    multivector, // all
    motor, // blade 0 + 2 + 4

    plane, // blade 1
    bivector, // blade 2
    point, // blade 3

    quaternion,
    //    quaternionDual,
    translator,

    vector,
    pointNormalized,
    planeIdeal,

    bivectorBulk,
    bivectorWeight,

    scalar, // blade 0
    pseudoScalar, // blade 4

    pointCenter,
    zeroCls, // no fields
  )

  def findMatchingClass(v: MultiVector[Sym]): MultivectorSubClass =
    pgaClasses.reverseIterator.find(_.isMatching(v)).get

  val unaryOperations = Seq(
    MultivectorUnaryOp("dual", pga3.operations.dual(_)),
    MultivectorUnaryOp("weight", pga3.operations.weight(_)),
    MultivectorUnaryOp("bulk", pga3.operations.bulk(_)),
    MultivectorUnaryOp("reverse", pga3.operations.reverse(_)),
    MultivectorUnaryOp("antiReverse", pga3.operations.antiReverse(_)),
    MultivectorUnaryOp("unary_- ", s => -s),
    MultivectorUnaryOp("bulkNormSquare", s => s.geometric(s.reverse).grade(0)),
    MultivectorUnaryOp("weightNormSquare", s => s.dual.geometric(s.dual.reverse).grade(0)),
    MultivectorUnaryOp("normSquare", s => s.geometric(s.reverse).grade(0) + s.dual.geometric(s.dual.reverse).grade(0)),
  )

  val binaryOperations = Seq(
    MultivectorBinaryOp(Seq("geometric"), pga3.operations.multiplication.geometric(_, _)),
    MultivectorBinaryOp(Seq("dot"), pga3.operations.multiplication.dot(_, _)),
    MultivectorBinaryOp(Seq("wedge", "^"), pga3.operations.multiplication.wedge(_, _)),

    MultivectorBinaryOp(Seq("antiGeometric"), pga3.operations.anti.geometric(_, _)),
    MultivectorBinaryOp(Seq("antiDot"), pga3.operations.anti.dot(_, _)),
    MultivectorBinaryOp(Seq("antiWedge", "v"), pga3.operations.anti.wedge(_, _)),

    MultivectorBinaryOp(Seq("sandwich"), (a, b) => a.sandwich(b)),
    MultivectorBinaryOp(Seq("reverseSandwich"), (a, b) => a.reverse.sandwich(b)),
    MultivectorBinaryOp(Seq("cross"), (a, b) => a.crossX2(b) * Sym(0.5)),
  )
