### Code structure

I use C++ 20 because of Unreal Engine 5 limitations.
Library is header-only, no external dependencies.
License is MIT.

* [**pga3d:**](pga3d/README.md) same as pga3d for Scala for geometric algebra. It contains generated code for multivector and its subclasses (planes, lines, points, quaternions, etc.).
* [**pga3dphysics:**](pga3dphysics/README.md) the code on top of pga3d for physics (inertia, force, acceleration, friction, etc.)
* **fused** all the code, fused into one header (pga3d for math only and pga3dphysics with both physics and math)
* **test:** tests with doctest

Implementation should work in the same way as in Scala and have the same methods, but may have some differences because of different language features.

Example code is in [main.cpp](main.cpp)
