# Scala game math

## How to add in sbt:

```
resolvers += "jitpack" at "https://jitpack.io"
...
libraryDependencies += "com.github.Kright" % "ScalaGameMath" % "0.7.1"
```

Or for separate modules

```
libraryDependencies += Seq(
  "com.github.Kright.ScalaGameMath" %% "math" % "0.7.1",
  "com.github.Kright.ScalaGameMath" %% "physics3d" % "0.7.1",
)
```

for latest version:

```
libraryDependencies += "com.github.Kright" % "ScalaGameMath" % "master-SNAPSHOT"
```

Or for Gradle:

```
repositories {
    maven { url "https://jitpack.io" }
}

dependencies {
  implementation 'com.github.Kright.ScalaGameMath:pga3d_3:v0.7.1'
  implementation 'com.github.Kright.ScalaGameMath:util_3:v0.7.1'
  implementation 'com.github.Kright.ScalaGameMath:matrix_3:v0.7.1'
  implementation 'com.github.Kright.ScalaGameMath:pga3dphysics_3:v0.7.1'
}
```

For other variants see [https://jitpack.io/#Kright/ScalaGameMath](https://jitpack.io/#Kright/ScalaGameMath).

## Modules

Initially, it was repo for simple math with matrices and vectors. I implemented physics for 3d on top of that math. During my development, I figured out that plane-based geometric algebra is a fantastic way to describe physics
equations. So there a lot of quite experimental, but very promising code with geometric algebra, which includes math and physics
too.

### Simple modules:

* **vector**: Vector2d, Vector3d, Vector4d
* **math**:
    * Quaternion
    * Matrix: 2x2, 3x3, 4x4
    * Euler angles: yaw Z, pitch Y, roll X
* **physics3d**: Rigid body physics
    * Transform3d (position and orientation)
    * Inertia3d (mass and tensor of angular mass)
    * Force3d, Impulse3d, Velocity3d, Acceleration3d (combined linear and angular)
    * Joint3d with Spring3d, AngularSpring3d, Friction, AngularFriction3d, OrientationSpring3d
    * BodySystem for handling a system of bodies with joints between them
* **solvers**: helper for solving differential equations with Euler or Runge-Kutta methods

### Advanced modules with geometric algebra:

* **symbolic**: simple implementation for AST like `(1.0 + ("y" * "x"))`
* **ga**: experimental support for geometric algebra (GA) and plane-based geometric algebra (PGA).
  See [https://bivector.net](https://bivector.net) for more details. Suitable for any dimensions
* [**pga3d README**](pga3d/README.md): efficient library for 3d PGA with generated code and some common cases—Pga3dPlane, Pga3dPoint,
  Pga3dQuaternion, Pga3dBivector, etc.
  There is a huge number of similar methods (for each pair of classes for each type of multiplication). Because of
  generated methods for each case it's possible to know at compile time that, for example, dot product of two bivectors
  is a scalar or geometric product of two planes is a motor.
* **pga3dCodeGen**: hand-made code generator for pga3d module. It does operations in symbolic form, and searches the
  most narrow subclass of multivector for the result.
* [**pga3dPhysics README**](pga3dPhysics/README.md): some helper classes for implementing physics engine - body inertia, physics solvers, etc. Under active development now.

Vectors treated as columns. For quaternions and matrices, multiplication order is math-like, for example:

```scala
(matrixA * matrixB) * vec === matrixA * (matrixB * vec)
(quaternionA * quaternionB) * vec === quaternionA * (quaternionB * vec)
```

Support conversions between rotation matrix, quaternions and Euler angles.

Unfortunately, JVM doesn't support lightweight structs, so there are a bunch of helper operators:

```scala 
import com.github.kright.math.Quaternion

val q = Quaternion() // assign reference
q := Quaternion()    // assign by value (w, x, y, z)
val q2 = q * q       // new object created, reference assigned to q2
q *= q2              // q := q * q2, inplace, no objects created
q *> q2              // q2 := q * q2, inplace, no objects created
```

### Physics

I prefer code correctness and simplicity over computational efficiency.

For example, BodySystem allocates a lot of temporary objects.
So this class could be used as example or as reference implementation for bug-fixing.
Maybe for some specific case with a lot of objects, you will need your own implementation.

### PGA

I'm inspired by https://bivector.net/PGADYN.html
I rewrote physics equations in PGA, it looks like PGA is a better way of describing physics.

### Tests

```bash
sbt test
```

I use scalaCheck and property-based approach. It goes well with checking math properties such as addition or
multiplication associativity, zero and id elements, morphisms between quaternions and corresponding matrices or euler
angles.
For physics, it's ok to check that total energy and impulse are constant in body systems without friction.

### How to change this library and try changes locally in other project

Change lib code, publish to local ivy repo:

```bash
sbt publishLocal
```

Or to local maven:

```bash
sbt publishM2
```

In my case "~/.ivy2/local/scalagamemath/scalagamemath_3/0.7.0-SNAPSHOT" and
"~/.m2/repository/scalagamemath/scalagamemath_3/0.7.0-SNAPSHOT"

After that, add the local library to another project. In my case, it was for sbt:

```scala
libraryDependencies += "scalagamemath" %% "scalagamemath" % "0.7.1-SNAPSHOT"
```

And for Gradle:

```groovy
implementation "pga3d:pga3d_3:0.7.1-SNAPSHOT"
```

Maybe you will need to remove cached lib of jitpack, it will be placed in path like "~
/.cache/coursier/v1/https/jitpack.io/com/github/Kright/ScalaGameMath/master-SNAPSHOT".
