ThisBuild / version := "0.3.1-SNAPSHOT"

ThisBuild / scalaVersion := "3.3.1"

ThisBuild / licenses := List(License.MIT)
ThisBuild / startYear := Some(2022)

scalacOptions ++= Seq(
  "-Yexplicit-nulls",
  "-Werror"
)

lazy val root = (project in file("."))
  .settings(
    name := "scalaGameMath",
    libraryDependencies += "org.scalatest" %% "scalatest" % "3.2.17" % "test",
    libraryDependencies += "org.scalatestplus" %% "scalacheck-1-17" % "3.2.17.0" % "test",
    packageSrc / publishArtifact := true,
  )
