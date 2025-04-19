The vector module provides implementations for 2D, 3D, and 4D vectors.

mutable classes:
* Vector2d, Vector3d, Vector4d
* Views without mutating methods: IVector2d, IVector3d, IVector4d

## Examples


### Basic Operations

```scala
import com.github.kright.math.Vector3d

val a = Vector3d(1.0, 2.0, 3.0)
val immutableView: IVector3d = Vector3d(4.0, 5.0, 6.0)

val sum = a + immutableView
```

### In-Place Operations

For performance-critical code, you can use in-place operations that modify the vector instead of creating a new one:

```scala
import com.github.kright.math.Vector3d

val v = Vector3d(1.0, 2.0, 3.0)

// In-place addition
v += Vector3d(1.0, 1.0, 1.0)

// In-place normalization
v.normalize() 

// Direct assignment
v := Vector3d(1.0, 0.0, 0.0)  // v is now Vector3d(1.0, 0.0, 0.0)
v :=(1.0, 0.0, 0.0) // the same
```