package com.github.kright.pga3d.codegen

import com.github.kright.ga.*
import com.github.kright.math.Sign
import com.github.kright.pga3d.codegen.MultivectorSubClass.*
import com.github.kright.pga3d.codegen.ops.*
import com.github.kright.symbolic.Sym
import com.github.kright.symbolic.transform.simplifiers.ReplaceSumOrProduct

import scala.math.Numeric.Implicits.infixNumericOps

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

  def makeSymbolic(instanceName: String): MultiVector[Sym] =
    if (name == "Double") {
      MultiVector.scalar(Sym(instanceName))
    } else {
      MultiVector[Sym](
        variableFields.map(f => f.basisBlade -> Sym(s"${instanceName}.${f.name}")).toMap ++
          constantFields.map((f, v) => f.basisBlade -> Sym(v))
      )
    }

  val self: MultiVector[Sym] =
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
        val expr = groupedResult.get(f.basisBlade).getOrElse(Sym.zero)
        code(s"${f.name} = ${expr},")
      }
    }
    code(")")
    code.toString


  override def generateCode(): String =
    generateCode(unaryOperations, binaryOperations)

  private def generateCode(unaryOps: Seq[MultivectorUnaryOp],
                           binaryOps: Seq[MultivectorBinaryOp]): String = {
    val code = CodeGen()

    if (isObject) {
      code(s"case object ${name}:")
    } else {
      require(variableFields.nonEmpty)

      val start = s"case class ${name}("
      val pad = " ".repeat(start.length)

      code(variableFields
        .map(f => s"${f.name}: Double = 0.0")
        .zipWithIndex
        .map((s, i) => if (i == 0) s else pad + s)
        .mkString(start, ",\n", "):"))
    }

    code.block {
      for ((f, v) <- constantFields) {
        code(s"inline val ${f.name} = ${v}")
      }

      if (name.contains("Point") || this == vector) {
        self.dual.values.foreach { (b, sym) =>
          val fName = s"dual${ga.representation(b).toUpperCase}"
          code("")
          code(s"inline def $fName: Double = ${sym}")
        }
      }

      for (unaryOp <- unaryOps) {
        unaryOp(this, self).foreach { lines =>
          code(lines)
        }
      }

      for (binaryOp <- binaryOps) {
        for (rightCls <- pgaClasses if (rightCls != zeroCls) && (rightCls != scalar)) {
          val v = rightCls.makeSymbolic("v")
          val result = binaryOp(self, v)
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

    val points = Set(point, pointNormalized, vector)
    if (points.contains(this)) {
      code(s"\n\nobject ${typeName}:")
      code.block {
        if (this == point) {
          val v = MultiVector("x" -> Sym("x"), "y" -> Sym("y"), "z" -> Sym("z"), "w" -> Sym("w"))
          code(s"def fromDual(x: Double, y: Double, z: Double, w: Double): ${typeName} =")
          code.block {
            code(makeConstructor(v.dual))
          }
        }
        else {
          val v = MultiVector("x" -> Sym("x"), "y" -> Sym("y"), "z" -> Sym("z"))
          code(s"def fromDual(x: Double, y: Double, z: Double): ${typeName} =")
          code.block {
            code(makeConstructor(v.dual))
          }
        }
      }
    }

    if (this == translator) {
      code(s"\n\nobject ${typeName}:")
      code.block {
        code(s"def addVector(v: ${vector.typeName}): ${typeName} =")
        code.block {
          val v = vector.makeSymbolic("v")
          val mult = MultiVector("w" -> Sym(-0.5))
          code(makeConstructor(mult.geometric(v.dual)))
        }
      }
    }

    code.toString
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
    MultivectorUnaryOp((cls, v) => GeneratedValue(cls, "dual", pga3.operations.dual(v))),
    MultivectorUnaryOp((cls, v) => GeneratedValue(cls, "weight", pga3.operations.weight(v))),
    MultivectorUnaryOp((cls, v) => GeneratedValue(cls, "bulk", pga3.operations.bulk(v))),
    MultivectorUnaryOp((cls, s) => GeneratedValue(cls, "unary_- ", -s)),
    MultivectorUnaryOp((cls, v) => GeneratedValue(cls, "reverse", pga3.operations.reverse(v))),
    MultivectorUnaryOp((cls, v) => GeneratedValue(cls, "antiReverse", pga3.operations.antiReverse(v))),
    DefNorm("bulkNormSquare", "bulkNorm", "normalizedByBulk", s => s.geometric(s.reverse).grade(0)),
    DefNorm("weightNormSquare", "weightNorm", "normalizedByWeight", s => s.dual.geometric(s.dual.reverse).grade(0)),
    DefNorm("normSquare", "norm", "normalizedByNorm", s => s.geometric(s.reverse).grade(0) + s.dual.geometric(s.dual.reverse).grade(0)),
    DefMultiplyToScalar(),
    DefDivideByScalar(),
    DefPlusMinusMadd(),
    DefExpForBivector(),
    DefLogForMotor(),
    DefBivectorSplit(),
    DefConvertTo(),
    DefProjection(),
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
