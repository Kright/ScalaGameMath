# Scala game math

## How to add in sbt:
```
resolvers += "jitpack" at "https://jitpack.io"
...
libraryDependencies += "com.github.Kright" % "ScalaGameMath" % "0.1.0"
```
for latest version:
```
libraryDependencies += "com.github.Kright" % "ScalaGameMath" % "master-SNAPSHOT"
```

For other variants see [https://jitpack.io/](https://jitpack.io/).

## Features:

* Vector2d, Vector3d, Vector4d
* Quaternion
* Matrix: 2x2, 3x3, 4x4
* Euler angles: yaw Z, pitch Y, roll X 

Vectors treated as columns. For quaternions and matrices multiplication order is math-like, for example:
```
(matrixA * matrixB) * vec === matrixA * (matrixB * vec)
(quaternionA * quaternionB) * vec === quaternionA * (quaternionB * vec)
```

Support conversions between rotation matrix, quaternions and euler angles.

Unfortunately JVM doesn't support lightweight structs, so there are a bunch of helper operators:
```scala 
val q = Quaternion() // assing reference
q := Quaternion()    // assign by value (w, x, y, z)
val q2 = q * q       // new object created, reference assigned to q2
q *= q2              // q := q * q2, inplace, no objects created
q *> q2              // q2 := q * q2, inplace, no objects created
```

Library doesn't have any external dependencies.