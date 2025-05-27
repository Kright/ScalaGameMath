ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "3.7.0"

resolvers += "jitpack" at "https://jitpack.io"

lazy val root = (project in file("."))
  .settings(
    name := "rotationDemo",
    libraryDependencies += "com.badlogicgames.gdx" % "gdx" % "1.13.5",
    libraryDependencies += "com.badlogicgames.gdx" % "gdx-backend-lwjgl3" % "1.13.5",
    libraryDependencies += "com.badlogicgames.gdx" % "gdx-platform" % "1.13.5" classifier "natives-desktop",
    libraryDependencies += "com.github.Kright.ScalaGameMath" %% "pga3d" % "0.7.3",
    libraryDependencies += "com.github.Kright.ScalaGameMath" %% "pga3dphysics" % "0.7.3",
    libraryDependencies += "com.github.Kright.ScalaGameMath" %% "util" % "0.7.3",
  )
