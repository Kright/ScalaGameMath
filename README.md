# Scala game math

## How to add in sbt:
```
resolvers += "jitpack" at "https://jitpack.io"
...
libraryDependencies += "com.github.Kright" % "ScalaGameMath" % "master-SNAPSHOT"
```
For other variants see [https://jitpack.io/](https://jitpack.io/).

## Features:

* Vector2d, Vector3d
* Quaternions
* each of this classes has view (for example, IVector2d), interaction with view cannot change object

Not implemented yet:
* Matrices: 2x2, 3x3, 4x4


Library doesn't have any external dependencies.