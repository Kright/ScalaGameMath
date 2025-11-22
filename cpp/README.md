### Code structure

I use C++ 20 because of Unreal Engine 5 limitations.
Library is header-only.

File "pga3d/types.h" includes all definitions without complex implementations.
Each operation is placed in its own header, so if you don't need it, you can exclude it from compilation. Unfortunately, `deducing this` feature is in C++ 23 only, so geometric operations have to be declared inside struct bodies.

* **pga3d:** same as pga3d for scala for geometric algebra. It contains generated code for multivector and it's subclasses (planes, lines, points, quaternions, etc.).
* **pga3dphysics:** the code on top of pga3d for physics (inertia, force, acceleration, friction, etc.)
* **fused** all the code, fused into one header (pga3d for math only and pga3dphysics with both physics and math)

Implementation should work in the same way as in Scala and have the same methods, but may have some differences because of different language features.

Example code is in [main.cpp](main.cpp)
