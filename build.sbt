ThisBuild / version := "0.3.1"

ThisBuild / scalaVersion := "3.4.0"

ThisBuild / licenses := List(License.MIT)
ThisBuild / startYear := Some(2022)

scalacOptions ++= Seq(
  "-Yexplicit-nulls",
  "-Werror"
)

lazy val scalatestSettings = Seq(
  libraryDependencies += "org.scalatest" %% "scalatest" % "3.2.17" % "test",
  libraryDependencies += "org.scalatestplus" %% "scalacheck-1-17" % "3.2.17.0" % "test",
)

lazy val root = (project in file("."))
  .settings(
    name := "scalaGameMath",
    packageSrc / publishArtifact := true,
  ).aggregate(math, swizzle, solvers, physics3d)

lazy val math = (project in file("math")).settings(
  scalatestSettings,
)

lazy val swizzle = (project in file("swizzle")).settings(
  scalatestSettings,
).dependsOn(math)

lazy val solvers = (project in file("solvers"))

lazy val physics3d = (project in file("physics3d")).settings(
  scalatestSettings
).dependsOn(
  math % "compile->compile;test->test",
  swizzle,
  solvers,
)
