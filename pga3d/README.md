## Plane-based geometric algebra for 3d

Contains generated code for special cases: planes, quaternions, points, etc.
They behave exactly like multivectors, but where a lot of fields are zeros and computations are much simpler.
In addition, this provides more type-safety, so sum of two Pga3dVector is a Pga3dVector.

For example, point class contains only three fields and quaternion has only four. So rotation of point by quaternion is
efficient as usual code in math libraries.

### Plane:

* [**Pga3dPlane**](src/main/scala/com/github/kright/pga3d/Pga3dBivector.scala): plane, 4 fields.
* [**Pga3dPlaneIdeal**](src/main/scala/com/github/kright/pga3d/Pga3dPlaneIdeal.scala): plane passing through the center of coordinates, 3 fields. Dual to Pga3dVector

```scala
val plane = Pga3dPlane(a, b, c, d)  // ax + by + cz + d = 0
val idealPlane = Pga3dPlaneIdeal(a, b, c)  // ax + by + cz = 0
val point = Pga3dPoint(x, y, z)

// Projecting a point onto a plane
val projectedPoint = point.projectOntoPlane(plane)

// Mirroring by a plane
val mirroredPoint = plane.sandwich(point)
```

### Point:

* [**Pga3dPoint**](src/main/scala/com/github/kright/pga3d/Pga3dPoint.scala): Point in space. Stored as dual representation with human-friendly fields x, y, z and fixed w=1.
* [**Pga3dPointCenter**](src/main/scala/com/github/kright/pga3d/Pga3dPointCenter.scala): singleton object, center of coordinates.
* [**Pga3dVector**](src/main/scala/com/github/kright/pga3d/Pga3dVector.scala): difference between points. Consist of x, y, z and fixed w=0. Pga3dTranslator moved points, but not
  vectors.
* [**Pga3dTrivector**](src/main/scala/com/github/kright/pga3d/Pga3dTrivector.scala): general case with four fields (x, y, z, w).

There is name collision, Pga3dVector is a 3-vector (and a Pga3dTrivector), but I decided to give it a human-friendly
name. In plane-based algebra 1-vector is a plane. Usually Pga3dTrivector is rarely needed, Pga3dPoint and Pga3dVector
are better suit for common cases.

```scala
// Creating a point
val point1 = Pga3dPoint(x, y, z)
val point2 = Pga3dPoint(x2, y2, z2)

// difference between points is a vector
val vector = point1 - point2

// sum of vector and point is a point
val point3 = vector * 2 + point1
```

### Line

In addition, it represents velocity and force.

* [**Pga3dBivector**](src/main/scala/com/github/kright/pga3d/Pga3dBivector.scala): 6 fields (xy, xz, yz, xw, yw, zw)
* [**Pga3dBivectorBulk**](src/main/scala/com/github/kright/pga3d/Pga3dBivectorBulk.scala) - bivector with only 3 fields (xy, xz, yz).
* [**Pga3dBivectorWeight**](src/main/scala/com/github/kright/pga3d/Pga3dBivectorWeight.scala) - bivector with only 3 fields (xw, yw, zw).

```scala
// Creating a bivector
val bivector = Pga3dBivector(xy, xz, yz, xw, yw, zw)

// Getting bulk and weight components of a bivector
val bulkComponent = bivector.bulk
val weightComponent = bivector.weight

// creating line as intersection of two planes
val line0 = plane1 ^ plane2

// Creating a line from two points
val line1 = point1 v point2

// Creating a line from a point and a vector
val line2 = point v vector

// Splitting a bivector into a line and shift
val (line, shift) = bivector.split()
```

### Movement

* [**Pga3dQuaternion**](src/main/scala/com/github/kright/pga3d/Pga3dQuaternion.scala): represents rotation, 4 fields (scalar, xy, xz, yz). It is the exponent of Pga3dBivectorBulk
* [**Pga3dTranslator**](src/main/scala/com/github/kright/pga3d/Pga3dTranslator.scala): represents linear movement, 3 fields (wx, wy, wz). It is the exponent of Pga3dBivectorWeight
* [**Pga3dMotor**](src/main/scala/com/github/kright/pga3d/Pga3dMotor.scala): combination of rotation and linear movement. Has 8 fields (scalar, all bivector fields and pseudoscalar),
  exponent of Pga3dBivector

To move everything with this classes, you need to call `motor.sandwich(obj)`

```scala
// Creating a quaternion for rotation between two vectors
val from = Pga3dVector(1, 2, 3)
val to = Pga3dVector(3, 4, 5)
val quaternion = Pga3dQuaternion.rotation(from, to)

// Making quaternion as a geometric product of two planes 
// The rotation axis is a meet line of planes, the rotation angle is double angle between planes)
val quaternion2 = plane1 geometric plane2

// Applying rotation to anything using the sandwich product (could rotate point, line, plane, quatenrion, etc.)
val rotatedPoint = quaternion.sandwich(point)

// Inverse of rotation
val inverseRotation = quaterion.reverse

// Apply inverse of rotation in quaternion
val restoredPoint = quaternion.reverseSandwich(point)
val restoredPoint2 = quaternion.reverse.sandwich(point)

// Creating a translator to add a vector
val vector = Pga3dVector(1, 2, 3)
val translator = Pga3dTranslator.addVector(vector)

// Applying translation to a point
val translatedPoint = translator.sandwich(point)
// This is equivalent to:
val translatedPoint = point + vector

// Creating a motor by combining a translator and a quaternion
val motor = translator.geometric(quaternion)

// Applying a motor to a point (combined rotation and translation)
val transformedPoint = motor.sandwich(point)

// Computing the exponential of a bivector (results in a motor)
val motor = bivector.exp()

// Computing the logarithm of a motor (results back in a bivector)
val bivector = motor.log()
```

### Other classes:

* [**Pga3dMultivector**](src/main/scala/com/github/kright/pga3d/Pga3dMultivector.scala): class with all 16 fields for a general case
* [**Pga3dPseudoScalar**](src/main/scala/com/github/kright/pga3d/Pga3dPseudoScalar.scala): class with one field. Library has no scalar class and uses just Double instead.
* [**Pga3dMatrix**](src/main/scala/com/github/kright/pga3d/Pga3dMatrix.scala): object with some utility code

```scala
// Creating a general multivector
val multivector = Pga3dMultivector(
  s = 1.0,  // scalar
  e1 = 2.0, e2 = 3.0, e3 = 4.0, e0 = 5.0,  // 1-vectors
  e12 = 6.0, e13 = 7.0, e23 = 8.0, e01 = 9.0, e02 = 10.0, e03 = 11.0,  // bivectors
  e123 = 12.0, e012 = 13.0, e013 = 14.0, e023 = 15.0,  // trivectors
  e0123 = 16.0  // pseudoscalar
)

// Converting specialized classes to multivector
val multivectorFromPoint = point.toMultivector
val multivectorFromQuaternion = quaternion.toMultivector

// Creating a pseudoscalar
val pseudoscalar = Pga3dPseudoScalar(value)
```