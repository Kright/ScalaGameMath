#pragma once

#include <type_traits>
#include "types_forward.h"

// This code is generated, see com.github.kright.pga3d.codegen.cpp.CppCodeGen

namespace pga3d {
    struct Motor {
        double s = 0.0;
        double wx = 0.0;
        double wy = 0.0;
        double wz = 0.0;
        double xy = 0.0;
        double xz = 0.0;
        double yz = 0.0;
        double i = 0.0;

        static constexpr int componentsCount = 8;

        [[nodiscard]] static constexpr Motor id() noexcept { return {.s = 1.0}; }
        [[nodiscard]] static constexpr Motor addVector(const Vector& v) noexcept;

        [[nodiscard]] inline Bivector log() const noexcept;

        [[nodiscard]] constexpr Motor dual() const noexcept;

        [[nodiscard]] constexpr Motor weight() const noexcept;

        [[nodiscard]] constexpr Quaternion bulk() const noexcept;

        [[nodiscard]] constexpr Motor reverse() const noexcept;

        [[nodiscard]] constexpr Motor antiReverse() const noexcept;

        [[nodiscard]] constexpr Motor geometric(const Motor& b) const noexcept;
        [[nodiscard]] constexpr Multivector geometric(const Plane& b) const noexcept;
        [[nodiscard]] constexpr Motor geometric(const Bivector& b) const noexcept;
        [[nodiscard]] constexpr Multivector geometric(const ProjectivePoint& b) const noexcept;
        [[nodiscard]] constexpr Motor geometric(const Quaternion& b) const noexcept;
        [[nodiscard]] constexpr Motor geometric(const Translator& b) const noexcept;
        [[nodiscard]] constexpr Multivector geometric(const Vector& b) const noexcept;
        [[nodiscard]] constexpr Multivector geometric(const Point& b) const noexcept;
        [[nodiscard]] constexpr Multivector geometric(const PlaneIdeal& b) const noexcept;
        [[nodiscard]] constexpr Motor geometric(const BivectorBulk& b) const noexcept;
        [[nodiscard]] constexpr Motor geometric(const BivectorWeight& b) const noexcept;
        [[nodiscard]] constexpr Motor geometric(const PseudoScalar& b) const noexcept;
        [[nodiscard]] constexpr Multivector geometric(const PointCenter& b) const noexcept;

        [[nodiscard]] constexpr Motor wedge(const Motor& b) const noexcept;
        [[nodiscard]] constexpr Multivector wedge(const Plane& b) const noexcept;
        [[nodiscard]] constexpr Motor wedge(const Bivector& b) const noexcept;
        [[nodiscard]] constexpr ProjectivePoint wedge(const ProjectivePoint& b) const noexcept;
        [[nodiscard]] constexpr Motor wedge(const Quaternion& b) const noexcept;
        [[nodiscard]] constexpr Motor wedge(const Translator& b) const noexcept;
        [[nodiscard]] constexpr Vector wedge(const Vector& b) const noexcept;
        [[nodiscard]] constexpr ProjectivePoint wedge(const Point& b) const noexcept;
        [[nodiscard]] constexpr Multivector wedge(const PlaneIdeal& b) const noexcept;
        [[nodiscard]] constexpr Motor wedge(const BivectorBulk& b) const noexcept;
        [[nodiscard]] constexpr Motor wedge(const BivectorWeight& b) const noexcept;
        [[nodiscard]] constexpr PseudoScalar wedge(const PseudoScalar& b) const noexcept;
        [[nodiscard]] constexpr ProjectivePoint wedge(const PointCenter& b) const noexcept;

        [[nodiscard]] constexpr Motor dot(const Motor& b) const noexcept;
        [[nodiscard]] constexpr Multivector dot(const Plane& b) const noexcept;
        [[nodiscard]] constexpr Motor dot(const Bivector& b) const noexcept;
        [[nodiscard]] constexpr Multivector dot(const ProjectivePoint& b) const noexcept;
        [[nodiscard]] constexpr Motor dot(const Quaternion& b) const noexcept;
        [[nodiscard]] constexpr Motor dot(const Translator& b) const noexcept;
        [[nodiscard]] constexpr Multivector dot(const Vector& b) const noexcept;
        [[nodiscard]] constexpr Multivector dot(const Point& b) const noexcept;
        [[nodiscard]] constexpr Multivector dot(const PlaneIdeal& b) const noexcept;
        [[nodiscard]] constexpr Motor dot(const BivectorBulk& b) const noexcept;
        [[nodiscard]] constexpr BivectorWeight dot(const BivectorWeight& b) const noexcept;
        [[nodiscard]] constexpr Motor dot(const PseudoScalar& b) const noexcept;
        [[nodiscard]] constexpr Multivector dot(const PointCenter& b) const noexcept;

        [[nodiscard]] constexpr Motor antiGeometric(const Motor& b) const noexcept;
        [[nodiscard]] constexpr Multivector antiGeometric(const Plane& b) const noexcept;
        [[nodiscard]] constexpr Motor antiGeometric(const Bivector& b) const noexcept;
        [[nodiscard]] constexpr Multivector antiGeometric(const ProjectivePoint& b) const noexcept;
        [[nodiscard]] constexpr Quaternion antiGeometric(const Quaternion& b) const noexcept;
        [[nodiscard]] constexpr Motor antiGeometric(const Translator& b) const noexcept;
        [[nodiscard]] constexpr Multivector antiGeometric(const Vector& b) const noexcept;
        [[nodiscard]] constexpr Multivector antiGeometric(const Point& b) const noexcept;
        [[nodiscard]] constexpr Multivector antiGeometric(const PlaneIdeal& b) const noexcept;
        [[nodiscard]] constexpr Quaternion antiGeometric(const BivectorBulk& b) const noexcept;
        [[nodiscard]] constexpr Motor antiGeometric(const BivectorWeight& b) const noexcept;
        [[nodiscard]] constexpr Motor antiGeometric(const PseudoScalar& b) const noexcept;
        [[nodiscard]] constexpr Multivector antiGeometric(const PointCenter& b) const noexcept;

        [[nodiscard]] constexpr Motor antiWedge(const Motor& b) const noexcept;
        [[nodiscard]] constexpr Plane antiWedge(const Plane& b) const noexcept;
        [[nodiscard]] constexpr Motor antiWedge(const Bivector& b) const noexcept;
        [[nodiscard]] constexpr Multivector antiWedge(const ProjectivePoint& b) const noexcept;
        [[nodiscard]] constexpr Quaternion antiWedge(const Quaternion& b) const noexcept;
        [[nodiscard]] constexpr Motor antiWedge(const Translator& b) const noexcept;
        [[nodiscard]] constexpr Multivector antiWedge(const Vector& b) const noexcept;
        [[nodiscard]] constexpr Multivector antiWedge(const Point& b) const noexcept;
        [[nodiscard]] constexpr PlaneIdeal antiWedge(const PlaneIdeal& b) const noexcept;
        [[nodiscard]] constexpr Quaternion antiWedge(const BivectorBulk& b) const noexcept;
        [[nodiscard]] constexpr Motor antiWedge(const BivectorWeight& b) const noexcept;
        [[nodiscard]] constexpr Motor antiWedge(const PseudoScalar& b) const noexcept;
        [[nodiscard]] constexpr Multivector antiWedge(const PointCenter& b) const noexcept;

        [[nodiscard]] constexpr Motor antiDot(const Motor& b) const noexcept;
        [[nodiscard]] constexpr Multivector antiDot(const Plane& b) const noexcept;
        [[nodiscard]] constexpr Motor antiDot(const Bivector& b) const noexcept;
        [[nodiscard]] constexpr Multivector antiDot(const ProjectivePoint& b) const noexcept;
        [[nodiscard]] constexpr Quaternion antiDot(const Quaternion& b) const noexcept;
        [[nodiscard]] constexpr Motor antiDot(const Translator& b) const noexcept;
        [[nodiscard]] constexpr Multivector antiDot(const Vector& b) const noexcept;
        [[nodiscard]] constexpr Multivector antiDot(const Point& b) const noexcept;
        [[nodiscard]] constexpr Multivector antiDot(const PlaneIdeal& b) const noexcept;
        [[nodiscard]] constexpr BivectorBulk antiDot(const BivectorBulk& b) const noexcept;
        [[nodiscard]] constexpr Motor antiDot(const BivectorWeight& b) const noexcept;
        [[nodiscard]] constexpr Motor antiDot(const PseudoScalar& b) const noexcept;
        [[nodiscard]] constexpr ProjectivePoint antiDot(const PointCenter& b) const noexcept;

        [[nodiscard]] constexpr Motor sandwich(const Motor& b) const noexcept;
        [[nodiscard]] constexpr Plane sandwich(const Plane& b) const noexcept;
        [[nodiscard]] constexpr Bivector sandwich(const Bivector& b) const noexcept;
        [[nodiscard]] constexpr ProjectivePoint sandwich(const ProjectivePoint& b) const noexcept;
        [[nodiscard]] constexpr Motor sandwich(const Quaternion& b) const noexcept;
        [[nodiscard]] constexpr Motor sandwich(const Translator& b) const noexcept;
        [[nodiscard]] constexpr Vector sandwich(const Vector& b) const noexcept;
        [[nodiscard]] constexpr ProjectivePoint sandwich(const Point& b) const noexcept;
        [[nodiscard]] constexpr Plane sandwich(const PlaneIdeal& b) const noexcept;
        [[nodiscard]] constexpr Bivector sandwich(const BivectorBulk& b) const noexcept;
        [[nodiscard]] constexpr BivectorWeight sandwich(const BivectorWeight& b) const noexcept;
        [[nodiscard]] constexpr PseudoScalar sandwich(const PseudoScalar& b) const noexcept;
        [[nodiscard]] constexpr ProjectivePoint sandwich(const PointCenter& b) const noexcept;

        [[nodiscard]] constexpr Motor reverseSandwich(const Motor& b) const noexcept;
        [[nodiscard]] constexpr Plane reverseSandwich(const Plane& b) const noexcept;
        [[nodiscard]] constexpr Bivector reverseSandwich(const Bivector& b) const noexcept;
        [[nodiscard]] constexpr ProjectivePoint reverseSandwich(const ProjectivePoint& b) const noexcept;
        [[nodiscard]] constexpr Motor reverseSandwich(const Quaternion& b) const noexcept;
        [[nodiscard]] constexpr Motor reverseSandwich(const Translator& b) const noexcept;
        [[nodiscard]] constexpr Vector reverseSandwich(const Vector& b) const noexcept;
        [[nodiscard]] constexpr ProjectivePoint reverseSandwich(const Point& b) const noexcept;
        [[nodiscard]] constexpr Plane reverseSandwich(const PlaneIdeal& b) const noexcept;
        [[nodiscard]] constexpr Bivector reverseSandwich(const BivectorBulk& b) const noexcept;
        [[nodiscard]] constexpr BivectorWeight reverseSandwich(const BivectorWeight& b) const noexcept;
        [[nodiscard]] constexpr PseudoScalar reverseSandwich(const PseudoScalar& b) const noexcept;
        [[nodiscard]] constexpr ProjectivePoint reverseSandwich(const PointCenter& b) const noexcept;

        [[nodiscard]] constexpr Bivector cross(const Motor& b) const noexcept;
        [[nodiscard]] constexpr Multivector cross(const Plane& b) const noexcept;
        [[nodiscard]] constexpr Bivector cross(const Bivector& b) const noexcept;
        [[nodiscard]] constexpr Multivector cross(const ProjectivePoint& b) const noexcept;
        [[nodiscard]] constexpr Bivector cross(const Quaternion& b) const noexcept;
        [[nodiscard]] constexpr BivectorWeight cross(const Translator& b) const noexcept;
        [[nodiscard]] constexpr Vector cross(const Vector& b) const noexcept;
        [[nodiscard]] constexpr Multivector cross(const Point& b) const noexcept;
        [[nodiscard]] constexpr Multivector cross(const PlaneIdeal& b) const noexcept;
        [[nodiscard]] constexpr Bivector cross(const BivectorBulk& b) const noexcept;
        [[nodiscard]] constexpr BivectorWeight cross(const BivectorWeight& b) const noexcept;
        [[nodiscard]] constexpr Multivector cross(const PointCenter& b) const noexcept;

        [[nodiscard]] constexpr Multivector toMultivector() const noexcept;
        [[nodiscard]] constexpr Bivector toBivectorUnsafe() const noexcept;
        [[nodiscard]] constexpr Quaternion toQuaternionUnsafe() const noexcept;
        [[nodiscard]] constexpr Translator toTranslatorUnsafe() const noexcept;
        [[nodiscard]] constexpr BivectorBulk toBivectorBulkUnsafe() const noexcept;
        [[nodiscard]] constexpr BivectorWeight toBivectorWeightUnsafe() const noexcept;

        [[nodiscard]] constexpr Motor madd(const Motor& other, double mult) const noexcept;

        [[nodiscard]] constexpr double normSquare() const noexcept;
        [[nodiscard]] inline double norm() const noexcept;
        [[nodiscard]] inline Motor normalizedByNorm() const noexcept;
        [[nodiscard]] constexpr double bulkNormSquare() const noexcept;
        [[nodiscard]] inline double bulkNorm() const noexcept;
        [[nodiscard]] inline Motor normalizedByBulk() const noexcept;
        [[nodiscard]] constexpr double weightNormSquare() const noexcept;
        [[nodiscard]] inline double weightNorm() const noexcept;
        [[nodiscard]] inline Motor normalizedByWeight() const noexcept;
    };

    static_assert(std::is_trivially_copyable_v<Motor>);
    static_assert(sizeof(Motor) == 8 * Motor::componentsCount, "Motor must be exactly 64 bytes");
}