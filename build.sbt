ThisBuild / version := "0.7.4-SNAPSHOT"

ThisBuild / scalaVersion := "3.6.4"

ThisBuild / licenses := List(License.MIT)
ThisBuild / startYear := Some(2022)

scalacOptions ++= Seq(
  "-Yexplicit-nulls",
  "-language:strictEquality",
  "-Werror",
)

lazy val scalatestSettings = Seq(
  libraryDependencies += "org.scalatest" %% "scalatest" % "3.2.19" % "test",
  libraryDependencies += "org.scalatestplus" %% "scalacheck-1-18" % "3.2.19.0" % "test",
)

lazy val root = (project in file("."))
  .settings(
    name := "scalaGameMath",
    packageSrc / publishArtifact := true,
  ).aggregate(
    math,
    physics3d,
    solvers,
    symbolic,
    util.jvm,
    vector,
    ga,
    matrix.jvm,
    pga3d,
    pga3dPhysics,
  )

lazy val util = crossProject(JSPlatform, JVMPlatform)
  .withoutSuffixFor(JVMPlatform)
  .in(file("util"))
  .settings(scalatestSettings *)

lazy val vector = (project in file("vector"))
  .settings(scalatestSettings *).dependsOn(util.jvm)

lazy val math = (project in file("math"))
  .settings(scalatestSettings *)
  .dependsOn(vector % "compile->compile;test->test")
  .dependsOn(util.jvm % "compile->compile;test->test")

lazy val matrix = crossProject(JSPlatform, JVMPlatform)
  .withoutSuffixFor(JVMPlatform)
  .in(file("matrix"))
  .settings(scalatestSettings *)
  .dependsOn(util)

lazy val symbolic = (project in file("symbolic"))
  .settings(scalatestSettings *)

lazy val ga = (project in file("ga"))
  .settings(scalatestSettings *)
  .dependsOn(
    util.jvm,
    symbolic % "test",
    vector % "compile->compile;test->test",
    solvers % "test",
  )

lazy val solvers = (project in file("solvers"))

lazy val physics3d = (project in file("physics3d"))
  .settings(scalatestSettings *)
  .dependsOn(
    math % "compile->compile;test->test",
    solvers,
  )

lazy val pga3dCodeGen = (project in file("pga3dCodeGen"))
  .settings(scalatestSettings *)
  .dependsOn(
    ga,
    symbolic,
  )

lazy val pga3d = (project in file("pga3d"))
  .settings(scalatestSettings *)
  .dependsOn(
    matrix.jvm,
    util.jvm % "test",
    vector % "test->test",
  )

lazy val pga3dPhysics = (project in file("pga3dPhysics"))
  .settings(scalatestSettings *)
  .dependsOn(
    pga3d % "compile->compile;test->test",
    matrix.jvm,
    vector % "test->test",
    solvers % "test",
  )
