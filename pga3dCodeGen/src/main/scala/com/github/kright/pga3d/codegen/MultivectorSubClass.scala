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
                               shouldBeGenerated: Boolean = true):
  private val fieldBlades: Set[BasisBlade] = {
    val variables = variableFields.map(_.basisBlade).toSet
    val constants = constantFields.map(_._1.basisBlade).toSet
    require(variables.size == variableFields.size)
    require(constants.size == constantFields.size)
    require(variables.intersect(constants).isEmpty)
    variables ++ constants
  }

  def isObject: Boolean = variableFields.isEmpty

  def typeName: String =
    if (isObject) s"${name}.type"
    else name

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

  private def makeConstructor(code: CodeGen, result: MultiVector[Sym]): Unit =
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

  def generateCode(unaryOps: Seq[MultivectorUnaryOp],
                   binaryOps: Seq[MultivectorBinaryOp])(using ga: PGA3): String = {
    val code = CodeGen()

    code(s"package com.github.kright.pga3d", "")
    code("/** this code is generated, see com.github.kright.pga3d.codegen.MultivectorSubClass */")

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

      if (name.contains("Point")) {
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
          code(s"def ${unaryOp.name}${if (unaryOp.name.endsWith("_")) " " else ""}: ${resultCls.typeName} =")
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

        val v = makeSymbolic("v")
        makeMethod(self + v, s"def +(v: ${typeName})")
        makeMethod(self - v, s"def -(v: ${typeName})")
        makeMethod(self + v * Sym("mult"), s"def madd(v: ${typeName}, mult: Double)")
        makeMethod(self.multiplyElementwise(v), s"def multiplyElementwise(v: ${typeName})")
      }

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
  val quaternionDual = MultivectorSubClass("QuaternionDual", motor.variableFields.filter(f => f.basisBlade.contains(genW)))

  val pointIdeal = MultivectorSubClass("PointIdeal", point.variableFields.filter(f => f.basisBlade.contains(genW)))
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
    quaternionDual,

    pointIdeal,
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
    MultivectorUnaryOp("unary_", s => -s),
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
