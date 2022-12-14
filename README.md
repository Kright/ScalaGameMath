# Scala game math

## How to add in sbt:
```
resolvers += "jitpack" at "https://jitpack.io"
...
libraryDependencies += "com.github.Kright" % "ScalaGameMath" % "0.2.6"
```
for latest version:
```
libraryDependencies += "com.github.Kright" % "ScalaGameMath" % "master-SNAPSHOT"
```

For other variants see [https://jitpack.io/#Kright/ScalaGameMath](https://jitpack.io/#Kright/ScalaGameMath).

## Features:

* Math:
  * Vector2d, Vector3d, Vector4d
  * Quaternion
  * Matrix: 2x2, 3x3, 4x4
  * Euler angles: yaw Z, pitch Y, roll X
* Rigid body physics:
  * Transform3d (position and orientation)
  * Inertia3d (mass and tensor of angular mass)
  * Force3d, Impulse3d, Velocity3d, Acceleration3d (combined linear and angular)

Vectors treated as columns. For quaternions and matrices multiplication order is math-like, for example:
```scala
(matrixA * matrixB) * vec === matrixA * (matrixB * vec)
(quaternionA * quaternionB) * vec === quaternionA * (quaternionB * vec)
```

Support conversions between rotation matrix, quaternions and euler angles.

Unfortunately JVM doesn't support lightweight structs, so there are a bunch of helper operators:
```scala 
import com.kright.math.Quaternion

val q = Quaternion() // assing reference
q := Quaternion()    // assign by value (w, x, y, z)
val q2 = q * q       // new object created, reference assigned to q2
q *= q2              // q := q * q2, inplace, no objects created
q *> q2              // q2 := q * q2, inplace, no objects created
```

Library doesn't have any external dependencies.