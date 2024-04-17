package com.github.kright.ga

import org.scalacheck.Gen

object GAGenerator:
  def allGASeq: IndexedSeq[GA] =
    IndexedSeq(GA.ga2, GA.ga3, GA.ga4, GA.pga2, GA.pga3)

  def allBasises: Gen[GA] =
    Gen.oneOf(allGASeq)

  def forAnyGA(body: GA ?=> Unit): Unit =
    for (basis <- allGASeq) {
      basis.use {
        body
      }
    }

  extension (ga: GA)
    def basisBladesGen: Gen[BasisBlade] =
      Gen.oneOf(ga.blades)

    def basisMultivectorsGen: Gen[MultiVector[Double]] =
      basisBladesGen.map(MultiVector(ga, _))

    def multivectorsGen: Gen[MultiVector[Double]] =
      Gen.containerOfN[Seq, Double](ga.signature.bladesCount, Gen.double).map { values =>
        require(values.length == ga.signature.bladesCount)
        MultiVector(ga.blades.zip(values))(using ga)
      }

    def bladesGen(order: Int): Gen[MultiVector[Double]] =
      multivectorsGen.map(_.filter((b, v) => b.grade == order))
