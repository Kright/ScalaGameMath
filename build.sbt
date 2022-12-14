ThisBuild / version := "0.2.7-SNAPSHOT"

ThisBuild / scalaVersion := "3.2.1"

ThisBuild / licenses := List(License.MIT)
ThisBuild / startYear := Some(2022)

scalacOptions ++= Seq(
  "-Yexplicit-nulls",
  "-Werror"
)

lazy val root = (project in file("."))
  .settings(
    name := "scalaGameMath",
    libraryDependencies += "org.scalatest" %% "scalatest" % "3.2.14" % "test",
    libraryDependencies += "org.scalatestplus" %% "scalacheck-1-17" % "3.2.14.0" % "test"
  )
