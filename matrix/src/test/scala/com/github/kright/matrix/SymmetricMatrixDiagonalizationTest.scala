package com.github.kright.matrix

import org.scalatest.funsuite.AnyFunSuiteLike
import org.scalatestplus.scalacheck.ScalaCheckPropertyChecks

class SymmetricMatrixDiagonalizationTest extends AnyFunSuiteLike with ScalaCheckPropertyChecks:

  private def dist(a: Matrix, b: Matrix): Double =
    (a - b).elements.map(v => v * 2).sum

  test("test matrix 2x2 diagonalization ") {
    val matrixSize = 2
    val rotationsMixed = 1

    forAll(MatrixGenerators.rotatedDiagonal(matrixSize, rotationsMixed, 0.01, 1.0)) { input =>
      val (diagonal, eigenvectors) = Matrix.symmetricMatrixToDiagonalAndEigenvectors(input)
      val recreated = eigenvectors * diagonal * eigenvectors.transposed()
      assert(dist(input, recreated) < 1e-14)
    }
  }

  test("test matrix 4x4 diagonalization") {
    val matrixSize = 4
    val rotationsMixed = 6

    forAll(MatrixGenerators.rotatedDiagonal(matrixSize, rotationsMixed, 0.01, 1.0)) { input =>
      val (diagonal, eigenvectors) = Matrix.symmetricMatrixToDiagonalAndEigenvectors(input)
      val recreated = eigenvectors * diagonal * eigenvectors.transposed()
      assert(dist(input, recreated) < 1e-14)
    }

    forAll(MatrixGenerators.rotatedDiagonal(matrixSize, rotationsMixed, 0.01, 1.0)) { input =>
      val (diagonal, eigenvectors) = Matrix.symmetricMatrixToDiagonalAndEigenvectors(input)
      val recreated = eigenvectors * diagonal * eigenvectors.transposed()
      assert(dist(input, recreated) < 1e-14)
    }
  }

  test("matrix multiplication is associative") {
    val size = 4
    forAll(
      MatrixGenerators.matrixUniform1(size, size),
      MatrixGenerators.matrixUniform1(size, size),
      MatrixGenerators.matrixUniform1(size, size),
    ) { (a, b, c) =>
      val r1 = (a * b) * c
      val r2 = a * (b * c)
      assert(dist(r1, r2) < 1e-14)
    }
  }
