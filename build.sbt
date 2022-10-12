ThisBuild / version := "0.1.0"

ThisBuild / scalaVersion := "3.2.0"

ThisBuild / licenses := List(License.MIT)
ThisBuild / startYear := Some(2022)

lazy val root = (project in file("."))
  .settings(
    name := "scalaGameMath",
    idePackagePrefix := Some("com.kright.math"),
    libraryDependencies += "org.scalatest" %% "scalatest" % "3.2.14" % "test",
    libraryDependencies += "org.scalatestplus" %% "scalacheck-1-17" % "3.2.14.0" % "test"
  )
