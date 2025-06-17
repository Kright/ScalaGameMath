# PGA3D Geometry Module

## Features

### Geometric Primitives
- **Axis-Aligned Bounding Box (AABB)**: Fast collision detection and spatial partitioning
- **Triangles**: 3D triangle representation with various geometric operations
- **Edges**: Line segments in 3D space with intersection testing

### Geometric Algorithms
- **Digital Differential Analyzer (DDA)**: Efficient ray traversal through a grid
- **Nearest Point Calculations**: Find the nearest point on geometric primitives
- **Intersection Testing**: Detect intersections between various geometric primitives

## Key Classes

### `Pga3dAABB`
Represents an Axis-Aligned Bounding Box in 3D space.
```scala
// Create an AABB from points
val aabb = Pga3dAABB(min, max)

// Create an AABB from a triangle
val triangleAabb = Pga3dAABB(triangle)

// Check if an AABB contains a point
val contains = aabb.contains(point)

// Check for intersection with another AABB
val intersects = aabb.intersects(otherAabb)

// Expand an AABB
val expanded = aabb.expand(amount)
```

### `Pga3dTriangle`
Represents a triangle in 3D space.
```scala
// Create a triangle from three points
val triangle = Pga3dTriangle(a, b, c)

// Get the plane of the triangle
val plane = triangle.plane

// Calculate the area of the triangle
val area = triangle.area

// Find the nearest point on the triangle to a given point
val nearest = triangle.getNearestPoint(point)

// Check for intersection with an edge
val intersects = triangle.intersects(edge, eps)
```

### `Pga3dEdge`
Represents an edge (line segment) in 3D space.
```scala
// Create an edge from two points
val edge = Pga3dEdge(a, b)

// Get the center of the edge
val center = edge.center

// Find the nearest point on the edge to a given point
val nearest = edge.getNearestPoint(point)
```

### `Pga3dDigitalDifferentialAnalyzer`
Implements a Digital Differential Analyzer algorithm for 3D ray traversal through a grid.
```scala
// Create a DDA from an origin and direction
val dda = new Pga3dDigitalDifferentialAnalyzer(origin, direction)

// Step through the grid
dda.doStep()

// Access the current cell coordinates
val (x, y, z) = (dda.x, dda.y, dda.z)
```