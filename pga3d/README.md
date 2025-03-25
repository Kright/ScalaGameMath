## Plane-based geometric algebra for 3d

Contains generated code for special cases: planes, quaternions, points, etc.
They behave exactly like multivectors, but where a lot of fields are zeros and computations are much simpler.
In addition, this provides more type-safety, so sum of two Pga3dVector is a Pga3dVector.

For example, point class contains only three fields and quaternion has only four. So rotation of point by quaternion is
efficient as usual code in math libraries.

### Plane:

* Pga3dPlane: plane, 4 fields.
* Pga3dPlaneIdeal: plane passing through the center of coordinates, 3 fields. Dual to Pga3dVector

### Point:

* Pga3dPoint: Point in space. Stored as dual representation with human-friendly fields x, y, z and fixed w=1.
* Pga3dPointCenter: singleton object, center of coordinates.
* Pga3dVector: difference between points. Consist of x, y, z and fixed w=0. Pga3dTranslator moved points, but not
  vectors.
* Pga3dTrivector: general case with four fields (x, y, z, w).

There is name collision, Pga3dVector is a 3-vector (and a Pga3dTrivector), but I decided to give it a human-friendly
name. In plane-based algebra 1-vector is a plane. Usually Pga3dTrivector is rarely needed, Pga3dPoint and Pga3dVector
are better suit for common cases.

### Line

In addition, it represents velocity and force.

* Pga3dBivector: 6 fields (xy, xz, yz, xw, yw, zw)
* Pga3dBivectorBulk - bivector with only 3 fields (xy, xz, yz).
* Pga3dBivectorWeight - bivector with only 3 fields (xw, yw, zw).

### Movement

* Pga3dQuaternion: represents rotation, 4 fields (scalar, xy, xz, yz). It is the exponent of Pga3dBivectorBulk
* Pga3dTranslator: represents linear movement, 3 fields (wx, wy, wz). It is the exponent of Pga3dBivectorWeight
* Pga3dMotor: combination of rotation and linear movement. Has 8 fields (scalar, all bivector fields and pseudoscalar),
  exponent of Pga3dBivector

### Other classes:

* Pga3dMultivector: class with all 16 fields for a general case
* Pga3dPseudoScalar: class with one field. Library has no scalar class and uses just Double instead.
* Pga3dMatrix: object with some utility code
