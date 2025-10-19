package com.github.kright.pga3d.codegen.cpp

import com.github.kright.ga.{BasisBladeWithSign, MultiVector}
import com.github.kright.math.Sign
import com.github.kright.pga3d.codegen.common.{MultivectorField, MultivectorSubClass}
import com.github.kright.symbolic.Sym

object CppSubclasses:
  import Pga3dProvider.pga3

  private val genW = Pga3dProvider.pga3.generators.find(_.squareSign == Sign.Zero).get

  private val orderedFields =  Pga3dProvider.pga3.blades.map(b => MultivectorField(pga3.representation(b), BasisBladeWithSign(b)))
  private val orderedDualFields = orderedFields.zip(orderedFields.reverse).map { (n, r) =>
    val sign: Sign = Sign(MultiVector[Int](n.basisBlade).dual(r.basisBlade))
    MultivectorField(r.name, BasisBladeWithSign(n.basisBlade, sign))
  }

  private val fields = orderedFields.map(f => f.name -> f).toMap

  val multivector = MultivectorSubClass("Multivector", orderedFields)

  val motor = MultivectorSubClass("Motor", orderedFields.filter(b => Seq(0, 2, 4).contains(b.basisBlade.grade)))

  val scalar = MultivectorSubClass("double", orderedFields.take(1), shouldBeGenerated = false)
  val plane = MultivectorSubClass("Plane", orderedFields.filter(_.basisBlade.grade == 1).tail :+ orderedFields.filter(_.basisBlade.grade == 1).head)
  val bivector = MultivectorSubClass("Bivector", orderedFields.filter(_.basisBlade.grade == 2))
  val projectivePoint = MultivectorSubClass("ProjectivePoint", orderedDualFields.filter(_.basisBlade.grade == 3).take(3).reverse ++ orderedDualFields.filter(_.basisBlade.grade == 3).drop(3))
  val pseudoScalar = MultivectorSubClass("PseudoScalar", orderedFields.takeRight(1))

  val quaternion = MultivectorSubClass("Quaternion", motor.variableFields.filter(f => !f.basisBlade.contains(genW)))
  //  val quaternionDual = MultivectorSubClass("QuaternionDual", motor.variableFields.filter(f => f.basisBlade.contains(genW)))
  val translator = MultivectorSubClass("Translator", motor.variableFields.filter(f => f.basisBlade.grade == 2 && f.basisBlade.contains(genW)), Seq(scalar.variableFields.head -> 1.0))

  val vector = MultivectorSubClass("Vector", projectivePoint.variableFields.filter(f => f.basisBlade.contains(genW)))
  val planeIdeal = MultivectorSubClass("PlaneIdeal", plane.variableFields.filter(f => !f.basisBlade.contains(genW)))
  val point: MultivectorSubClass = {
    val (weight, bulk) = projectivePoint.variableFields.partition(_.basisBlade.contains(genW))
    MultivectorSubClass("Point", weight, bulk.map(f => (f, 1.0)))
  }

  val bivectorWeight = MultivectorSubClass("BivectorWeight", bivector.variableFields.filter(f => f.basisBlade.contains(genW)))
  val bivectorBulk = MultivectorSubClass("BivectorBulk", bivector.variableFields.filter(f => !f.basisBlade.contains(genW)))

  val pointCenter = MultivectorSubClass("PointCenter", Seq(), projectivePoint.variableFields.map(f => (f, (if (f.basisBlade.contains(genW)) 0.0 else 1.0))))
  val zeroCls = MultivectorSubClass("Zero", Seq(), shouldBeGenerated = false)

  val pgaClasses = Seq(
    multivector, // all
    motor, // blade 0 + 2 + 4

    plane, // blade 1
    bivector, // blade 2
    projectivePoint, // blade 3

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
