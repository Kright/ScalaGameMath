ThisBuild / version := "0.4.3"

ThisBuild / scalaVersion := "3.4.0"

ThisBuild / licenses := List(License.MIT)
ThisBuild / startYear := Some(2022)

scalacOptions ++= Seq(
  "-Yexplicit-nulls",
  "-language:strictEquality",
  "-Werror",
)

lazy val scalatestSettings = Seq(
  libraryDependencies += "org.scalatest" %% "scalatest" % "3.2.18" % "test",
  libraryDependencies += "org.scalatestplus" %% "scalacheck-1-17" % "3.2.18.0" % "test",
)

lazy val root = (project in file("."))
  .settings(
    name := "scalaGameMath",
    packageSrc / publishArtifact := true,
  ).aggregate(
    ga,
    math,
    physics3d,
    solvers,
    swizzle,
    symbolic,
    util,
    vector,
  )

lazy val util = (project in file("util")).settings(
  scalatestSettings
)

lazy val vector = (project in file("vector")).settings(
  scalatestSettings
).dependsOn(util)

lazy val math = (project in file("math")).settings(
  scalatestSettings,
).dependsOn(vector % "compile->compile;test->test")

lazy val symbolic = (project in file("symbolic")).settings(
  scalatestSettings,
)

lazy val ga = (project in file("ga")).settings(
  scalatestSettings,
).dependsOn(
  util,
  symbolic % "test",
  vector % "test;test->test"
)

lazy val swizzle = (project in file("swizzle")).settings(
  scalatestSettings,
).dependsOn(vector)

lazy val solvers = (project in file("solvers"))

lazy val physics3d = (project in file("physics3d")).settings(
  scalatestSettings
).dependsOn(
  math % "compile->compile;test->test",
  solvers,
)
