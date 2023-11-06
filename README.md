# Scala game math

## How to add in sbt:
```
resolvers += "jitpack" at "https://jitpack.io"
...
libraryDependencies += "com.github.Kright" % "ScalaGameMath" % "0.2.7"
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

val q = Quaternion() // assign reference
q := Quaternion()    // assign by value (w, x, y, z)
val q2 = q * q       // new object created, reference assigned to q2
q *= q2              // q := q * q2, inplace, no objects created
q *> q2              // q2 := q * q2, inplace, no objects created
```

Library provides [swizzle operators](https://en.wikipedia.org/wiki/Swizzling_(computer_graphics)):
```scala
import com.kright.math.{Vector3d, Vector4d}

val v = Vector4d(1, 2, 3, 4)
v.yx = v.xy
// v == (2, 1, 3, 4)
v.xy = v.yx
// v == (1, 2, 3, 4)
v = Vector3d(1, 2, 3).xyzz
// v == (1, 2, 3, 3)
```

Library doesn't have any external dependencies.

### How to change this library and try changes locally in other project

Change lib code, publish to local ivy repo:

```bash
sbt publicLocal
```

In my case "~/.ivy2/local/scalagamemath/scalagamemath_3/0.2.8-SNAPSHOT"

After that in other project add local library. In my case it was:

```scala
libraryDependencies += "scalagamemath" % "scalagamemath_3" % "0.2.8-SNAPSHOT"
```

May be you will need to remove cached lib of jitpack, it will be placed in path like "~
/.cache/coursier/v1/https/jitpack.io/com/github/Kright/ScalaGameMath/master-SNAPSHOT".
