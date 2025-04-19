### Physics

I prefer code correctness and simplicity over computational efficiency.

For example, BodySystem allocates a lot of temporary objects.
So this class could be used as an example or as a reference implementation for bug-fixing.
Maybe for some specific case with a lot of objects, you will need your own implementation.

Some classes:

* Transform3d (position and orientation)
* Inertia3d (mass and tensor of angular mass)
* Force3d, Impulse3d, Velocity3d, Acceleration3d (combined linear and angular)
* Joint3d with Spring3d, AngularSpring3d, Friction, AngularFriction3d, OrientationSpring3d
* BodySystem for handling a system of bodies with joints between them
