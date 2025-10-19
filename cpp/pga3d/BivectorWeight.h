#pragma once

#include <type_traits>
#include "types_forward.h"

// This code is generated, see com.github.kright.pga3d.codegen.cpp.CppCodeGen

namespace pga3d {
    struct BivectorWeight {
        double wx = 0.0;
        double wy = 0.0;
        double wz = 0.0;

        static constexpr int componentsCount = 3;

        [[nodiscard]] constexpr BivectorBulk dual() const noexcept;

        [[nodiscard]] constexpr BivectorWeight weight() const noexcept;

        [[nodiscard]] constexpr BivectorWeight reverse() const noexcept;

        [[nodiscard]] constexpr BivectorWeight antiReverse() const noexcept;

        [[nodiscard]] constexpr Motor geometric(const Motor& b) const noexcept;
        [[nodiscard]] constexpr Multivector geometric(const Plane& b) const noexcept;
        [[nodiscard]] constexpr Motor geometric(const Bivector& b) const noexcept;
        [[nodiscard]] constexpr Vector geometric(const ProjectivePoint& b) const noexcept;
        [[nodiscard]] constexpr Motor geometric(const Quaternion& b) const noexcept;
        [[nodiscard]] constexpr BivectorWeight geometric(const Translator& b) const noexcept;
        [[nodiscard]] constexpr Vector geometric(const Point& b) const noexcept;
        [[nodiscard]] constexpr Multivector geometric(const PlaneIdeal& b) const noexcept;
        [[nodiscard]] constexpr Motor geometric(const BivectorBulk& b) const noexcept;
        [[nodiscard]] constexpr Vector geometric(const PointCenter& b) const noexcept;

        [[nodiscard]] constexpr Motor wedge(const Motor& b) const noexcept;
        [[nodiscard]] constexpr Vector wedge(const Plane& b) const noexcept;
        [[nodiscard]] constexpr PseudoScalar wedge(const Bivector& b) const noexcept;
        [[nodiscard]] constexpr Motor wedge(const Quaternion& b) const noexcept;
        [[nodiscard]] constexpr BivectorWeight wedge(const Translator& b) const noexcept;
        [[nodiscard]] constexpr Vector wedge(const PlaneIdeal& b) const noexcept;
        [[nodiscard]] constexpr PseudoScalar wedge(const BivectorBulk& b) const noexcept;

        [[nodiscard]] constexpr BivectorWeight dot(const Motor& b) const noexcept;
        [[nodiscard]] constexpr Plane dot(const Plane& b) const noexcept;
        [[nodiscard]] constexpr BivectorWeight dot(const Quaternion& b) const noexcept;
        [[nodiscard]] constexpr BivectorWeight dot(const Translator& b) const noexcept;
        [[nodiscard]] constexpr Plane dot(const PlaneIdeal& b) const noexcept;

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
        [[nodiscard]] constexpr BivectorWeight antiGeometric(const PseudoScalar& b) const noexcept;
        [[nodiscard]] constexpr PlaneIdeal antiGeometric(const PointCenter& b) const noexcept;

        [[nodiscard]] constexpr Motor antiWedge(const Motor& b) const noexcept;
        [[nodiscard]] constexpr double antiWedge(const Bivector& b) const noexcept;
        [[nodiscard]] constexpr Plane antiWedge(const ProjectivePoint& b) const noexcept;
        [[nodiscard]] constexpr double antiWedge(const Quaternion& b) const noexcept;
        [[nodiscard]] constexpr Plane antiWedge(const Vector& b) const noexcept;
        [[nodiscard]] constexpr Plane antiWedge(const Point& b) const noexcept;
        [[nodiscard]] constexpr double antiWedge(const BivectorBulk& b) const noexcept;
        [[nodiscard]] constexpr BivectorWeight antiWedge(const PseudoScalar& b) const noexcept;
        [[nodiscard]] constexpr PlaneIdeal antiWedge(const PointCenter& b) const noexcept;

        [[nodiscard]] constexpr Motor antiDot(const Motor& b) const noexcept;
        [[nodiscard]] constexpr ProjectivePoint antiDot(const Plane& b) const noexcept;
        [[nodiscard]] constexpr PseudoScalar antiDot(const Bivector& b) const noexcept;
        [[nodiscard]] constexpr Vector antiDot(const ProjectivePoint& b) const noexcept;
        [[nodiscard]] constexpr BivectorBulk antiDot(const Quaternion& b) const noexcept;
        [[nodiscard]] constexpr Motor antiDot(const Translator& b) const noexcept;
        [[nodiscard]] constexpr Vector antiDot(const Vector& b) const noexcept;
        [[nodiscard]] constexpr Vector antiDot(const Point& b) const noexcept;
        [[nodiscard]] constexpr ProjectivePoint antiDot(const PlaneIdeal& b) const noexcept;
        [[nodiscard]] constexpr PseudoScalar antiDot(const BivectorWeight& b) const noexcept;
        [[nodiscard]] constexpr BivectorWeight antiDot(const PseudoScalar& b) const noexcept;

        [[nodiscard]] constexpr BivectorWeight cross(const Motor& b) const noexcept;
        [[nodiscard]] constexpr Plane cross(const Plane& b) const noexcept;
        [[nodiscard]] constexpr BivectorWeight cross(const Bivector& b) const noexcept;
        [[nodiscard]] constexpr Vector cross(const ProjectivePoint& b) const noexcept;
        [[nodiscard]] constexpr BivectorWeight cross(const Quaternion& b) const noexcept;
        [[nodiscard]] constexpr Vector cross(const Point& b) const noexcept;
        [[nodiscard]] constexpr Plane cross(const PlaneIdeal& b) const noexcept;
        [[nodiscard]] constexpr BivectorWeight cross(const BivectorBulk& b) const noexcept;
        [[nodiscard]] constexpr Vector cross(const PointCenter& b) const noexcept;

        [[nodiscard]] constexpr Multivector toMultivector() const noexcept;
        [[nodiscard]] constexpr Motor toMotor() const noexcept;
        [[nodiscard]] constexpr Bivector toBivector() const noexcept;
        [[nodiscard]] constexpr Translator toTranslatorUnsafe() const noexcept;

        [[nodiscard]] constexpr BivectorWeight madd(const BivectorWeight& other, double mult) const noexcept;

        [[nodiscard]] constexpr double normSquare() const noexcept;
        [[nodiscard]] inline double norm() const noexcept;
        [[nodiscard]] inline BivectorWeight normalizedByNorm() const noexcept;
        [[nodiscard]] constexpr double weightNormSquare() const noexcept;
        [[nodiscard]] inline double weightNorm() const noexcept;
        [[nodiscard]] inline BivectorWeight normalizedByWeight() const noexcept;
    };

    static_assert(std::is_trivially_copyable_v<BivectorWeight>);
    static_assert(sizeof(BivectorWeight) == 8 * 3, "ProjectivePoint must be exactly 24 bytes");
}