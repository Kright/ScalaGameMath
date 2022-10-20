ThisBuild / version := "0.2.0-SNAPSHOT"

ThisBuild / scalaVersion := "3.2.0"

ThisBuild / licenses := List(License.MIT)
ThisBuild / startYear := Some(2022)

lazy val root = (project in file("."))
  .settings(
    name := "scalaGameMath",
    libraryDependencies += "org.scalatest" %% "scalatest" % "3.2.14" % "test",
    libraryDependencies += "org.scalatestplus" %% "scalacheck-1-17" % "3.2.14.0" % "test"
  )
