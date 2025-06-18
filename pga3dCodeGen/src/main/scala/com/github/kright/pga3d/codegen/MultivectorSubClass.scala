package com.github.kright.pga3d.codegen

import com.github.kright.ga.*
import com.github.kright.math.Sign
import com.github.kright.pga3d.codegen.MultivectorSubClass.*
import com.github.kright.pga3d.codegen.ops.*
import com.github.kright.symbolic.Sym
import com.github.kright.symbolic.transform.simplifiers.ReplaceSumOrProduct

import scala.math.Numeric.Implicits.infixNumericOps
import scala.util.Try
import scala.util.chaining.scalaUtilChainingOps

case class MultivectorSubClass(name: String,
                               variableFields: Seq[MultivectorField],
                               constantFields: Seq[(MultivectorField, Double)] = Seq(),
                               shouldBeGenerated: Boolean = true)(using pga3: PGA3) extends CodeGenClass:
  private val fieldBlades: Set[BasisBlade] = {
    val variables = variableFields.map(_.basisBlade).toSet
    val constants = constantFields.map(_._1.basisBlade).toSet
    require(variables.size == variableFields.size)
    require(constants.size == constantFields.size)
    require(variables.intersect(constants).isEmpty)
    variables ++ constants
  }

  override def isObject: Boolean = variableFields.isEmpty

  override def generateImports(): String =
    """import scala.annotation.targetName
      |""".stripMargin

  def makeSymbolic(instanceName: String): MultiVector[Sym] =
    if (name == "Double") {
      MultiVector.scalar(Sym(instanceName))
    } else {
      MultiVector[Sym](
        variableFields.map(f => f.basisBlade -> Sym(s"${instanceName}.${f.name}").pipe(e => if (f.sign == Sign.Positive) e else -e)).toMap ++
          constantFields.map((f, v) => f.basisBlade -> Sym(v).pipe(e => if (f.sign == Sign.Positive) e else -e))
      )
    }

  val self: MultiVector[Sym] =
    if (name == "Double") {
      MultiVector.scalar(Sym("this"))
    } else {
      MultiVector[Sym](
        variableFields.map(f => f.basisBlade -> Sym(f.name).pipe(e => if (f.sign == Sign.Positive) e else -e)).toMap ++
          constantFields.map((f, v) => f.basisBlade -> Sym(v).pipe(e => if (f.sign == Sign.Positive) e else -e))
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

  def makeConstructor(value: MultiVector[Sym]): String =
    val groupedResult = value.mapValues(_.groupMultipliers())
    if (name == "Double") {
      val expr = groupedResult.get(variableFields.head.basisBlade).getOrElse(Sym.zero)
      return expr.toString
    }
    if (isObject) {
      return name
    }

    val code = CodeGen()
    code(name + "(")
    code.block {
      for (f <- variableFields) {
        val expr: Sym = groupedResult.get(f.basisBlade).getOrElse(Sym.zero)

        var exprString: String =
          if (f.sign == Sign.Positive) {
            expr.toString
          } else {
            // todo fix exception
            Try((-expr).toString).getOrElse(s"-$expr")
          }

        if (exprString.startsWith("--")) {
          exprString = exprString.drop(2)
        }

        code(s"${f.name} = ${exprString},")
      }
    }
    code(")")
    code.toString


  override def generateCode(): String =
    generateCode(unaryOperations, binaryOperations)

  private def addVariablesComponentsCountAsConst(code: CodeGen): Unit = {
    code("")
    code(s"inline val componentsCount = ${variableFields.size}")
  }

  private def generateCode(unaryOps: Seq[MultivectorUnaryOp],
                           binaryOps: Seq[MultivectorBinaryOp]): String = {
    val code = CodeGen()

    if (isObject) {
      code(s"object ${name}:")
    } else {
      require(variableFields.nonEmpty)

      val start = s"final case class ${name}("
      val pad = " ".repeat(start.length)

      code(variableFields
        .map(f => s"${f.name}: Double = 0.0")
        .zipWithIndex
        .map((s, i) => if (i == 0) s else pad + s)
        .mkString(start, ",\n", ") derives CanEqual:"))
    }

    code.block {
      if (isObject) {
        addVariablesComponentsCountAsConst(code)
      }

      for ((f, v) <- constantFields) {
        code(s"inline val ${f.name} = ${v}")
      }

      if (Seq(vector, trivector, point, pointCenter).contains(this)) {
        self.values.foreach { (b, sym) =>
          val fName = s"${ga.representation(b)}"
          code("")
          code(s"inline def $fName: Double = ${sym}")
        }
      }

      generateToStringMethod(code)

      for (unaryOp <- unaryOps) {
        unaryOp(this, self).foreach { lines =>
          code(lines)
        }
      }

      for (binaryOp <- binaryOps) {
        for (rightCls <- pgaClasses
             if (rightCls != zeroCls)
               && (rightCls != scalar)
               && ((this == MultivectorSubClass.multivector) == (rightCls == MultivectorSubClass.multivector))) {
          val v = rightCls.makeSymbolic("v")
          binaryOp(self, v) match {
            case None => ()
            case Some(result) => {
              val resultCls = findMatchingClass(result)
              if (resultCls != zeroCls) {
                code(s"\ninfix def ${binaryOp.name}(v: ${rightCls.typeName}): ${resultCls.typeName} =")

                code.block {
                  if (resultCls == this && result == self) {
                    code("this")
                  } else if (resultCls == this && result == -self) {
                    code("-this")
                  } else if (resultCls == rightCls && result == v) {
                    code("v")
                  } else if (resultCls == rightCls && result == -v) {
                    code("-v")
                  } else {
                    binaryOp.name match
                      case "sandwich" | "reverseSandwich" => code(makeConstructorOptimized(result, resultCls))
                      case _ => code(resultCls.makeConstructor(result))
                  }
                }

                for (opName <- binaryOp.names.tail) {
                  code(s"\ninline infix def ${opName}(v: ${rightCls.typeName}): ${resultCls.typeName} = ${binaryOp.name}(v)")
                }
              }
            }
          }
        }
      }
    }

    if (!isObject) {
      code(s"\n\nobject ${typeName}:")
      code.block {
        addVariablesComponentsCountAsConst(code)

        if (this != point && this != quaternion && this != translator) {
          generateZeroObjectMethods(code)
        }

        generateMethodsIfAnyPoint(code)

        if (this == translator) {
          generateObjectMethodsForTranslator(code)
        }

        if (this == quaternion) {
          generateObjectMethodsForQuaternion(code)
        }

        if (this == motor) {
          generateObjectMethodsForMotor(code)
        }
      }
    }

    code.toString
  }

  private def generateObjectMethodsForTranslator(code: CodeGen): Unit = {
    code(
      s"""
         |val id: ${typeName} = ${typeName}(0.0, 0.0, 0.0)""".stripMargin)
    code("")
    code(s"def addVector(v: ${vector.typeName}): ${typeName} =")
    code.block {
      val v = vector.makeSymbolic("v")
      val mult = MultiVector("w" -> Sym(-0.5))
      code(makeConstructor(mult.geometric(v.dual)))
    }
  }

  private def generateToStringMethod(code: CodeGen): Unit = {
    if (variableFields.nonEmpty) {
      code(
        s"""
           |override def toString: String =
           |  s"${name}(${variableFields.map(f => s"${f.name} = ${"$" + f.name}").mkString(", ")})"""".stripMargin)
      return
    }

    if (this == pointCenter) {
      code(
        s"""
           |override def toString: String =
           |  "${name}"""".stripMargin)
      return
    }

    assert(false, "unknown class")
  }

  private def generateMethodsIfAnyPoint(code: CodeGen): Unit = {
    val points = Set(trivector, point, vector)
    if (!points.contains(this)) return

    if (this == point) {
      code(
        s"""
           |val center: ${point.typeName} =
           |  ${point.typeName}(0.0, 0.0, 0.0)""".stripMargin)
    }

    code("")
    if (this == trivector) {
      val v = MultiVector("wxy" -> Sym("wxy"), "wxz" -> Sym("wxz"), "wyz" -> Sym("wyz"), "xyz" -> Sym("xyz"))
      code(s"def blade3(wxy: Double, wxz: Double, wyz: Double, xyz: Double): ${typeName} =")
      code.block {
        code(makeConstructor(v))
      }
    }
    else {
      val v = MultiVector("wxy" -> Sym("wxy"), "wxz" -> Sym("wxz"), "wyz" -> Sym("wyz"))
      code(s"def blade3(wxy: Double, wxz: Double, wyz: Double): ${typeName} =")
      code.block {
        code(makeConstructor(v))
      }
    }

    code("")
    code(s"def interpolate(a: ${this.typeName}, b: ${this.typeName}, t: Double): ${this.typeName} =")
    code.block {
      if (this == trivector || this == vector) {
        code("a * (1.0 - t) + b * t")
      } else {
        code("(a.toVectorUnsafe * (1.0 - t) + b.toVectorUnsafe * t).toPointUnsafe")
      }
    }

    if (this == point) {
      code("")
      code(s"def mid(a: ${point.typeName}, b: ${point.typeName}): ${point.typeName} =")
      code.block {
        code(
          s"""${point.typeName}(
             |  x = (a.x + b.x) * 0.5,
             |  y = (a.y + b.y) * 0.5,
             |  z = (a.z + b.z) * 0.5,
             |)""".stripMargin)
      }

      code("")
      code(s"def mid(a: ${point.typeName}, b: ${point.typeName}, c: ${point.typeName}): ${point.typeName} =")
      code.block {
        code(
          s"""val m = 1.0 / 3.0
             |${point.typeName}(
             |  x = (a.x + b.x + c.x) * m,
             |  y = (a.y + b.y + c.y) * m,
             |  z = (a.z + b.z + c.z) * m,
             |)""".stripMargin)
      }
    }
  }

  private def generateObjectMethodsForMotor(code: CodeGen): Unit = {
    code(
      s"""
         |val id: ${typeName} = ${typeName}(1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0)
         |
         |def addVector(v: ${vector.typeName}): ${typeName} = ${translator.name}.addVector(v).toMotor""".stripMargin)
  }

  private def generateObjectMethodsForQuaternion(code: CodeGen): Unit = {
    code(
      s"""
         |val id: ${typeName} = ${typeName}(1.0, 0.0, 0.0, 0.0)
         |
         |def rotation(from: ${planeIdeal.name}, to: ${planeIdeal.name}): ${quaternion.name} = {
         |  val norm = Math.sqrt(from.normSquare * to.normSquare)
         |  val q2a = to.geometric(from) / norm
         |  val dot = q2a.s
         |
         |  if (dot > -1.0 + 1e-6) {
         |    val newCos = Math.sqrt((1.0 + dot) / 2)
         |    val newSinDivSin2 = 0.5 / newCos
         |    return ${quaternion.name}(newCos, q2a.xy * newSinDivSin2, q2a.xz * newSinDivSin2, q2a.yz * newSinDivSin2)
         |  }
         |
         |  val sin2a = Math.sqrt(q2a.xy * q2a.xy + q2a.xz * q2a.xz + q2a.yz * q2a.yz)
         |
         |  if (sin2a > 1e-8) {
         |    val angle2 = Math.atan2(sin2a, q2a.s)
         |    val propAngle = angle2 * 0.5
         |    val mult = Math.sin(propAngle) / sin2a
         |    return ${quaternion.name}(Math.cos(propAngle), q2a.xy * mult, q2a.xz * mult, q2a.yz * mult).normalizedByNorm
         |  }
         |
         |  // choose any axis
         |  val orthogonalPlane =
         |    if (Math.abs(from.x) > Math.abs(from.z)) ${planeIdeal.name}(-from.y, from.x, 0)
         |    else ${planeIdeal.name}(0, -from.z, from.y)
         |
         |  ${quaternion.name}(0, orthogonalPlane.z, -orthogonalPlane.y, orthogonalPlane.x).normalizedByNorm
         |}
         |
         |def rotation(from: ${vector.name}, to: ${vector.name}): ${quaternion.name} =
         |  rotation(from.dual, to.dual)
         |""".stripMargin)
  }

  private def generateZeroObjectMethods(code: CodeGen): Unit = {
    code("")
    code(s"val zero: ${typeName} = ${typeName}(${variableFields.map(_ => "0.0").mkString(", ")})")
  }

  def makeConstructorOptimized(result: MultiVector[Sym], resultCls: MultivectorSubClass): String = {
    val code = CodeGen()

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

    code(resultCls.makeConstructor(rr.mapValues(_.map(Sym.argsSorter))))
    code.toString
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

  private val orderedFields = pga3.blades.map(b => MultivectorField(pga3.representation(b), BasisBladeWithSign(b)))
  private val orderedDualFields = orderedFields.zip(orderedFields.reverse).map { (n, r) =>
    val sign: Sign = Sign(MultiVector[Int](n.basisBlade).dual(r.basisBlade))
    MultivectorField(r.name, BasisBladeWithSign(n.basisBlade, sign))
  }

  private val fields = orderedFields.map(f => f.name -> f).toMap

  val multivector = MultivectorSubClass("Pga3dMultivector", orderedFields)

  val motor = MultivectorSubClass("Pga3dMotor", orderedFields.filter(b => Seq(0, 2, 4).contains(b.basisBlade.grade)))

  val scalar = MultivectorSubClass("Double", orderedFields.take(1), shouldBeGenerated = false)
  val plane = MultivectorSubClass("Pga3dPlane", orderedFields.filter(_.basisBlade.grade == 1).tail :+ orderedFields.filter(_.basisBlade.grade == 1).head)
  val bivector = MultivectorSubClass("Pga3dBivector", orderedFields.filter(_.basisBlade.grade == 2))
  val trivector = MultivectorSubClass("Pga3dTrivector", orderedDualFields.filter(_.basisBlade.grade == 3).take(3).reverse ++ orderedDualFields.filter(_.basisBlade.grade == 3).drop(3))
  val pseudoScalar = MultivectorSubClass("Pga3dPseudoScalar", orderedFields.takeRight(1))

  val quaternion = MultivectorSubClass("Pga3dQuaternion", motor.variableFields.filter(f => !f.basisBlade.contains(genW)))
  //  val quaternionDual = MultivectorSubClass("QuaternionDual", motor.variableFields.filter(f => f.basisBlade.contains(genW)))
  val translator = MultivectorSubClass("Pga3dTranslator", motor.variableFields.filter(f => f.basisBlade.grade == 2 && f.basisBlade.contains(genW)), Seq(scalar.variableFields.head -> 1.0))

  val vector = MultivectorSubClass("Pga3dVector", trivector.variableFields.filter(f => f.basisBlade.contains(genW)))
  val planeIdeal = MultivectorSubClass("Pga3dPlaneIdeal", plane.variableFields.filter(f => !f.basisBlade.contains(genW)))
  val point = {
    val (weight, bulk) = trivector.variableFields.partition(_.basisBlade.contains(genW))
    MultivectorSubClass("Pga3dPoint", weight, bulk.map(f => (f, 1.0)))
  }

  val bivectorWeight = MultivectorSubClass("Pga3dBivectorWeight", bivector.variableFields.filter(f => f.basisBlade.contains(genW)))
  val bivectorBulk = MultivectorSubClass("Pga3dBivectorBulk", bivector.variableFields.filter(f => !f.basisBlade.contains(genW)))

  val pointCenter = MultivectorSubClass("Pga3dPointCenter", Seq(), trivector.variableFields.map(f => (f, (if (f.basisBlade.contains(genW)) 0.0 else 1.0))))
  val zeroCls = MultivectorSubClass("Pga3dZero", Seq(), shouldBeGenerated = false)

  val pgaClasses = Seq(
    multivector, // all
    motor, // blade 0 + 2 + 4

    plane, // blade 1
    bivector, // blade 2
    trivector, // blade 3

    quaternion,
    //    quaternionDual,
    translator,

    vector,
    point,
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
    MultivectorUnaryOp((cls, v) => GeneratedValue(cls, "dual", pga3.operations.dual(v))),
    MultivectorUnaryOp((cls, v) => GeneratedValue(cls, "weight", pga3.operations.weight(v))),
    MultivectorUnaryOp((cls, v) => GeneratedValue(cls, "bulk", pga3.operations.bulk(v))),
    MultivectorUnaryOp((cls, s) => GeneratedValue(cls, "unary_- ", -s, "unaryMinus")),
    MultivectorUnaryOp((cls, v) => GeneratedValue(cls, "reverse", pga3.operations.reverse(v))),
    MultivectorUnaryOp((cls, v) => GeneratedValue(cls, "antiReverse", pga3.operations.antiReverse(v))),
    DefRenormalizedForMotor(),
    DefMotorToQuaternionAndTranslator(),
    DefNorm("bulkNormSquare", "bulkNorm", "normalizedByBulk", s => s.geometric(s.reverse).grade(0)),
    DefNorm("weightNormSquare", "weightNorm", "normalizedByWeight", s => s.dual.geometric(s.dual.reverse).grade(0)),
    DefNorm("normSquare", "norm", "normalizedByNorm", s => s.geometric(s.reverse).grade(0) + s.dual.geometric(s.dual.reverse).grade(0)),
    DefMultiplyToScalar(),
    DefDivideByScalar(),
    DefMinMaxForPointOrVector(),
    DefPlusMinusMadd(),
    DefExpForBivector(),
    DefLogForMotor(),
    DefBivectorSplit(),
    DefConvertTo(),
    DefProjection(),
    DefMotorAndQuaternionAxices(),
    DefQuaternionProjectToRotationInPlane(),
  )

  val binaryOperations = Seq(
    MultivectorBinaryOp(Seq("geometric"), pga3.operations.multiplication.geometric(_, _)),
    MultivectorBinaryOp(Seq("dot"), pga3.operations.multiplication.dot(_, _)),
    MultivectorBinaryOp(Seq("wedge", "^"), pga3.operations.multiplication.wedge(_, _)),

    MultivectorBinaryOp(Seq("antiGeometric"), pga3.operations.anti.geometric(_, _)),
    MultivectorBinaryOp(Seq("antiDot"), pga3.operations.anti.dot(_, _)),
    MultivectorBinaryOp.option(Seq("antiDotI"), (a, b) => Option(pga3.operations.anti.dot(a, b).dual).filter(findMatchingClass(_) == scalar)),
    MultivectorBinaryOp(Seq("antiWedge", "v"), pga3.operations.anti.wedge(_, _)),

    MultivectorBinaryOp(Seq("sandwich"), (a, b) => a.sandwich(b)),
    MultivectorBinaryOp(Seq("reverseSandwich"), (a, b) => a.reverse.sandwich(b)),
    MultivectorBinaryOp(Seq("cross"), (a, b) => a.crossX2(b) * Sym(0.5)),
  )
