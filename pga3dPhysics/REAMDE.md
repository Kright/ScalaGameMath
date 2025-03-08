## Module with physics engine

Reference implementation, I prefer simple and correct code. But I profiled the code and eliminated some bottlenecks, it is quite efficient now.

Classes Pga3dMatrixForPoints and Pga3dBivectorMutable are made for performance reasons.

example of usage:

```
val dynamicBodies: ArrayBuffer[PhysicsBody] = 
  ArrayBuffer(
    PhysicsBody.motionless(Pga3dInertiaLocal.cube(mass = 2.0, 1,1,1), Pga3dMotor.id),
    ...
  )

def addGravity() = {
  val g: Pga3dVector = Pga3dVector(0, -9.8, 0)  // y axis down

  for(body <- dynamicBodies) {
    body.addGlobalForque(body.globalCenterOfMass v (g * body.inertia.mass))
  }
}

val timeStep = 0.001

for (step <- 0 until stepsCount) {
  time += timeStep

  PhysicsSolverRK4.step(dynamicBodies, timeStep, addForquesToBodies = { (dtInsideStep) =>
    addGravity()
    addSomeOtherForques()
  })
}  
```

Actually, for Runge-Kutta method of fourth grade, function addForquesToBodies is called four times.
