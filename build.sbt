ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "3.1.3"

ThisBuild / licenses := List(License.MIT)
ThisBuild / startYear := Some(2022)

lazy val root = (project in file("."))
  .settings(
    name := "scalaGameMath",
    idePackagePrefix := Some("com.kright.math")
  )
