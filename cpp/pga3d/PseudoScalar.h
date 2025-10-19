#pragma once

#include <type_traits>
#include "types_forward.h"

// This code is generated, see com.github.kright.pga3d.codegen.cpp.CppCodeGen

namespace pga3d {
    struct PseudoScalar {
        double i = 0.0;

        static constexpr int componentsCount = 1;

        [[nodiscard]] constexpr double dual() const noexcept;

        [[nodiscard]] constexpr PseudoScalar weight() const noexcept;

        [[nodiscard]] constexpr PseudoScalar reverse() const noexcept;

        [[nodiscard]] constexpr PseudoScalar antiReverse() const noexcept;

        [[nodiscard]] constexpr Motor geometric(const Motor& b) const noexcept;
        [[nodiscard]] constexpr Vector geometric(const Plane& b) const noexcept;
        [[nodiscard]] constexpr BivectorWeight geometric(const Bivector& b) const noexcept;
        [[nodiscard]] constexpr Plane geometric(const ProjectivePoint& b) const noexcept;
        [[nodiscard]] constexpr Motor geometric(const Quaternion& b) const noexcept;
        [[nodiscard]] constexpr PseudoScalar geometric(const Translator& b) const noexcept;
        [[nodiscard]] constexpr Plane geometric(const Point& b) const noexcept;
        [[nodiscard]] constexpr Vector geometric(const PlaneIdeal& b) const noexcept;
        [[nodiscard]] constexpr BivectorWeight geometric(const BivectorBulk& b) const noexcept;
        [[nodiscard]] constexpr Plane geometric(const PointCenter& b) const noexcept;

        [[nodiscard]] constexpr PseudoScalar wedge(const Motor& b) const noexcept;
        [[nodiscard]] constexpr PseudoScalar wedge(const Quaternion& b) const noexcept;
        [[nodiscard]] constexpr PseudoScalar wedge(const Translator& b) const noexcept;

        [[nodiscard]] constexpr Motor dot(const Motor& b) const noexcept;
        [[nodiscard]] constexpr Vector dot(const Plane& b) const noexcept;
        [[nodiscard]] constexpr BivectorWeight dot(const Bivector& b) const noexcept;
        [[nodiscard]] constexpr Plane dot(const ProjectivePoint& b) const noexcept;
        [[nodiscard]] constexpr Motor dot(const Quaternion& b) const noexcept;
        [[nodiscard]] constexpr PseudoScalar dot(const Translator& b) const noexcept;
        [[nodiscard]] constexpr Plane dot(const Point& b) const noexcept;
        [[nodiscard]] constexpr Vector dot(const PlaneIdeal& b) const noexcept;
        [[nodiscard]] constexpr BivectorWeight dot(const BivectorBulk& b) const noexcept;
        [[nodiscard]] constexpr Plane dot(const PointCenter& b) const noexcept;

        [[nodiscard]] constexpr Motor antiGeometric(const Motor& b) const noexcept;
        [[nodiscard]] constexpr Plane antiGeometric(const Plane& b) const noexcept;
        [[nodiscard]] constexpr Bivector antiGeometric(const Bivector& b) const noexcept;
        [[nodiscard]] constexpr ProjectivePoint antiGeometric(const ProjectivePoint& b) const noexcept;
        [[nodiscard]] constexpr Quaternion antiGeometric(const Quaternion& b) const noexcept;
        [[nodiscard]] constexpr Motor antiGeometric(const Translator& b) const noexcept;
        [[nodiscard]] constexpr Vector antiGeometric(const Vector& b) const noexcept;
        [[nodiscard]] constexpr ProjectivePoint antiGeometric(const Point& b) const noexcept;
        [[nodiscard]] constexpr PlaneIdeal antiGeometric(const PlaneIdeal& b) const noexcept;
        [[nodiscard]] constexpr BivectorBulk antiGeometric(const BivectorBulk& b) const noexcept;
        [[nodiscard]] constexpr BivectorWeight antiGeometric(const BivectorWeight& b) const noexcept;
        [[nodiscard]] constexpr PseudoScalar antiGeometric(const PseudoScalar& b) const noexcept;
        [[nodiscard]] constexpr ProjectivePoint antiGeometric(const PointCenter& b) const noexcept;

        [[nodiscard]] constexpr Motor antiWedge(const Motor& b) const noexcept;
        [[nodiscard]] constexpr Plane antiWedge(const Plane& b) const noexcept;
        [[nodiscard]] constexpr Bivector antiWedge(const Bivector& b) const noexcept;
        [[nodiscard]] constexpr ProjectivePoint antiWedge(const ProjectivePoint& b) const noexcept;
        [[nodiscard]] constexpr Quaternion antiWedge(const Quaternion& b) const noexcept;
        [[nodiscard]] constexpr Motor antiWedge(const Translator& b) const noexcept;
        [[nodiscard]] constexpr Vector antiWedge(const Vector& b) const noexcept;
        [[nodiscard]] constexpr ProjectivePoint antiWedge(const Point& b) const noexcept;
        [[nodiscard]] constexpr PlaneIdeal antiWedge(const PlaneIdeal& b) const noexcept;
        [[nodiscard]] constexpr BivectorBulk antiWedge(const BivectorBulk& b) const noexcept;
        [[nodiscard]] constexpr BivectorWeight antiWedge(const BivectorWeight& b) const noexcept;
        [[nodiscard]] constexpr PseudoScalar antiWedge(const PseudoScalar& b) const noexcept;
        [[nodiscard]] constexpr ProjectivePoint antiWedge(const PointCenter& b) const noexcept;

        [[nodiscard]] constexpr Motor antiDot(const Motor& b) const noexcept;
        [[nodiscard]] constexpr Plane antiDot(const Plane& b) const noexcept;
        [[nodiscard]] constexpr Bivector antiDot(const Bivector& b) const noexcept;
        [[nodiscard]] constexpr ProjectivePoint antiDot(const ProjectivePoint& b) const noexcept;
        [[nodiscard]] constexpr Quaternion antiDot(const Quaternion& b) const noexcept;
        [[nodiscard]] constexpr Motor antiDot(const Translator& b) const noexcept;
        [[nodiscard]] constexpr Vector antiDot(const Vector& b) const noexcept;
        [[nodiscard]] constexpr ProjectivePoint antiDot(const Point& b) const noexcept;
        [[nodiscard]] constexpr PlaneIdeal antiDot(const PlaneIdeal& b) const noexcept;
        [[nodiscard]] constexpr BivectorBulk antiDot(const BivectorBulk& b) const noexcept;
        [[nodiscard]] constexpr BivectorWeight antiDot(const BivectorWeight& b) const noexcept;
        [[nodiscard]] constexpr PseudoScalar antiDot(const PseudoScalar& b) const noexcept;
        [[nodiscard]] constexpr ProjectivePoint antiDot(const PointCenter& b) const noexcept;

        [[nodiscard]] constexpr Vector cross(const Plane& b) const noexcept;
        [[nodiscard]] constexpr Plane cross(const ProjectivePoint& b) const noexcept;
        [[nodiscard]] constexpr Plane cross(const Point& b) const noexcept;
        [[nodiscard]] constexpr Vector cross(const PlaneIdeal& b) const noexcept;
        [[nodiscard]] constexpr Plane cross(const PointCenter& b) const noexcept;

        [[nodiscard]] constexpr Multivector toMultivector() const noexcept;
        [[nodiscard]] constexpr Motor toMotor() const noexcept;

        [[nodiscard]] constexpr PseudoScalar madd(const PseudoScalar& other, double mult) const noexcept;

        [[nodiscard]] constexpr double normSquare() const noexcept;
        [[nodiscard]] double norm() const noexcept;
        [[nodiscard]] PseudoScalar normalizedByNorm() const noexcept;
        [[nodiscard]] constexpr double weightNormSquare() const noexcept;
        [[nodiscard]] double weightNorm() const noexcept;
        [[nodiscard]] PseudoScalar normalizedByWeight() const noexcept;
    };

    static_assert(std::is_trivially_copyable_v<PseudoScalar>);
    static_assert(sizeof(PseudoScalar) == 8 * 1, "ProjectivePoint must be exactly 8 bytes");
}