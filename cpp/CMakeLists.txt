cmake_minimum_required(VERSION 4.0)
project(cpp)

set(CMAKE_CXX_STANDARD 20)

include_directories(.)
include_directories(pga3d)

add_executable(cpp
        main.cpp
        pga3d/Bivector.h
        pga3d/BivectorBulk.h
        pga3d/BivectorWeight.h
        pga3d/Motor.h
        pga3d/Multivector.h
        pga3d/Plane.h
        pga3d/PlaneIdeal.h
        pga3d/Point.h
        pga3d/PointCenter.h
        pga3d/ProjectivePoint.h
        pga3d/PseudoScalar.h
        pga3d/Quaternion.h
        pga3d/Translator.h
        pga3d/types.h
        pga3d/typesForward.h
        pga3d/Vector.h
)
