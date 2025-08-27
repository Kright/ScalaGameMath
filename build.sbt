ThisBuild / version := "0.7.5-SNAPSHOT"

ThisBuild / scalaVersion := "3.7.2"

ThisBuild / licenses := List(License.MIT)
ThisBuild / startYear := Some(2022)

scalacOptions ++= Seq(
  "-Yexplicit-nulls",
  "-language:strictEquality",
  "-Werror",
)

lazy val explicitNulls =
  scalacOptions += "-Yexplicit-nulls"

lazy val wError =
  scalacOptions += "-Werror"

lazy val strictEquality =
  scalacOptions += "-language:strictEquality"

lazy val scalatestSettings =
  libraryDependencies ++= Seq(
    "org.scalatest" %% "scalatest" % "3.2.19" % "test",
    "org.scalatestplus" %% "scalacheck-1-18" % "3.2.19.0" % "test"
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
    util.jvm, util.js,
    vector.jvm, vector.js,
    ga,
    matrix.jvm, matrix.js,
    pga3d.jvm, pga3d.js,
    pga3dgeom.jvm, pga3dgeom.js,
    pga3dphysics.jvm, pga3dphysics.js,
  )

lazy val util = crossProject(JSPlatform, JVMPlatform)
  .withoutSuffixFor(JVMPlatform)
  .in(file("util"))
  .settings(scalatestSettings, explicitNulls, wError, strictEquality)

lazy val vector = crossProject(JSPlatform, JVMPlatform)
  .withoutSuffixFor(JVMPlatform)
  .in(file("vector"))
  .settings(scalatestSettings)
  .dependsOn(util)

lazy val math = (project in file("math"))
  .settings(scalatestSettings)
  .dependsOn(vector.jvm % "compile->compile;test->test")
  .dependsOn(util.jvm % "compile->compile;test->test")

lazy val matrix = crossProject(JSPlatform, JVMPlatform)
  .withoutSuffixFor(JVMPlatform)
  .in(file("matrix"))
  .settings(explicitNulls, wError)
  .settings(
    resolvers += "jitpack" at "https://jitpack.io",
    libraryDependencies += "com.github.kright.ArrayView" %% "arrayview" % "0.1.6",
  )
  .settings(scalatestSettings)
  .dependsOn(util)

lazy val symbolic = (project in file("symbolic"))
  .settings(scalatestSettings)

lazy val ga = (project in file("ga"))
  .settings(scalatestSettings)
  .dependsOn(
    util.jvm,
    symbolic % "test",
    vector.jvm % "compile->compile;test->test",
    solvers % "test",
  )

lazy val solvers = (project in file("solvers"))
  .settings(scalatestSettings)

lazy val physics3d = (project in file("physics3d"))
  .settings(scalatestSettings)
  .dependsOn(
    math % "compile->compile;test->test",
    solvers,
  )

lazy val pga3dCodeGen = (project in file("pga3dCodeGen"))
  .settings(scalatestSettings)
  .dependsOn(
    ga,
    symbolic,
  )

lazy val pga3d = crossProject(JSPlatform, JVMPlatform)
  .withoutSuffixFor(JVMPlatform)
  .in(file("pga3d"))
  .settings(scalatestSettings, explicitNulls, wError)
  .dependsOn(
    matrix,
    util % "test",
  )

lazy val pga3dgeom = crossProject(JSPlatform, JVMPlatform)
  .withoutSuffixFor(JVMPlatform)
  .in(file("pga3dgeom"))
  .settings(scalatestSettings, explicitNulls, wError)
  .dependsOn(
    pga3d % "compile->compile;test->test",
    matrix,
  )

lazy val pga3dphysics = crossProject(JSPlatform, JVMPlatform)
  .withoutSuffixFor(JVMPlatform)
  .in(file("pga3dphysics"))
  .settings(scalatestSettings, explicitNulls, wError)
  .dependsOn(
    pga3d % "compile->compile;test->test",
    matrix,
  )
