Vectors treated as columns. For quaternions and matrices, multiplication order is math-like, for example:

```scala
(matrixA * matrixB) * vec === matrixA * (matrixB * vec)
(quaternionA * quaternionB) * vec === quaternionA * (quaternionB * vec)
```

Support conversions between rotation matrix, quaternions, and Euler angles.

Unfortunately, JVM doesn't support lightweight structs, so there are a bunch of helper operators:

```scala 
import com.github.kright.math.Quaternion

val q = Quaternion() // assign reference
q := Quaternion()    // assign by value (w, x, y, z)
val q2 = q * q       // new object created, reference assigned to q2
q *= q2              // q := q * q2, inplace, no objects created
q *> q2              // q2 := q * q2, inplace, no objects created
```