#pragma once

#include <type_traits>
#include "types_forward.h"

// This code is generated, see com.github.kright.pga3d.codegen.cpp.CppCodeGen

namespace pga3d {
    struct Plane {
        double x = 0.0;
        double y = 0.0;
        double z = 0.0;
        double w = 0.0;

        static constexpr int componentsCount = 4;

        [[nodiscard]] constexpr ProjectivePoint dual() const noexcept;

        [[nodiscard]] constexpr Plane weight() const noexcept;

        [[nodiscard]] constexpr PlaneIdeal bulk() const noexcept;

        [[nodiscard]] constexpr Plane reverse() const noexcept;

        [[nodiscard]] constexpr Plane antiReverse() const noexcept;

        [[nodiscard]] constexpr Multivector geometric(const Motor& b) const noexcept;
        [[nodiscard]] constexpr Motor geometric(const Plane& b) const noexcept;
        [[nodiscard]] constexpr Multivector geometric(const Bivector& b) const noexcept;
        [[nodiscard]] constexpr Motor geometric(const ProjectivePoint& b) const noexcept;
        [[nodiscard]] constexpr Multivector geometric(const Quaternion& b) const noexcept;
        [[nodiscard]] constexpr Multivector geometric(const Translator& b) const noexcept;
        [[nodiscard]] constexpr Motor geometric(const Vector& b) const noexcept;
        [[nodiscard]] constexpr Motor geometric(const Point& b) const noexcept;
        [[nodiscard]] constexpr Motor geometric(const PlaneIdeal& b) const noexcept;
        [[nodiscard]] constexpr Multivector geometric(const BivectorBulk& b) const noexcept;
        [[nodiscard]] constexpr Multivector geometric(const BivectorWeight& b) const noexcept;
        [[nodiscard]] constexpr Vector geometric(const PseudoScalar& b) const noexcept;
        [[nodiscard]] constexpr Motor geometric(const PointCenter& b) const noexcept;

        [[nodiscard]] constexpr Multivector wedge(const Motor& b) const noexcept;
        [[nodiscard]] constexpr Bivector wedge(const Plane& b) const noexcept;
        [[nodiscard]] constexpr ProjectivePoint wedge(const Bivector& b) const noexcept;
        [[nodiscard]] constexpr PseudoScalar wedge(const ProjectivePoint& b) const noexcept;
        [[nodiscard]] constexpr Multivector wedge(const Quaternion& b) const noexcept;
        [[nodiscard]] constexpr Multivector wedge(const Translator& b) const noexcept;
        [[nodiscard]] constexpr PseudoScalar wedge(const Vector& b) const noexcept;
        [[nodiscard]] constexpr PseudoScalar wedge(const Point& b) const noexcept;
        [[nodiscard]] constexpr Bivector wedge(const PlaneIdeal& b) const noexcept;
        [[nodiscard]] constexpr ProjectivePoint wedge(const BivectorBulk& b) const noexcept;
        [[nodiscard]] constexpr Vector wedge(const BivectorWeight& b) const noexcept;
        [[nodiscard]] constexpr PseudoScalar wedge(const PointCenter& b) const noexcept;

        [[nodiscard]] constexpr Multivector dot(const Motor& b) const noexcept;
        [[nodiscard]] constexpr double dot(const Plane& b) const noexcept;
        [[nodiscard]] constexpr Plane dot(const Bivector& b) const noexcept;
        [[nodiscard]] constexpr Bivector dot(const ProjectivePoint& b) const noexcept;
        [[nodiscard]] constexpr Plane dot(const Quaternion& b) const noexcept;
        [[nodiscard]] constexpr Plane dot(const Translator& b) const noexcept;
        [[nodiscard]] constexpr BivectorWeight dot(const Vector& b) const noexcept;
        [[nodiscard]] constexpr Bivector dot(const Point& b) const noexcept;
        [[nodiscard]] constexpr double dot(const PlaneIdeal& b) const noexcept;
        [[nodiscard]] constexpr PlaneIdeal dot(const BivectorBulk& b) const noexcept;
        [[nodiscard]] constexpr Plane dot(const BivectorWeight& b) const noexcept;
        [[nodiscard]] constexpr Vector dot(const PseudoScalar& b) const noexcept;
        [[nodiscard]] constexpr BivectorBulk dot(const PointCenter& b) const noexcept;

        [[nodiscard]] constexpr Multivector antiGeometric(const Motor& b) const noexcept;
        [[nodiscard]] constexpr Motor antiGeometric(const Plane& b) const noexcept;
        [[nodiscard]] constexpr Multivector antiGeometric(const Bivector& b) const noexcept;
        [[nodiscard]] constexpr Motor antiGeometric(const ProjectivePoint& b) const noexcept;
        [[nodiscard]] constexpr Multivector antiGeometric(const Quaternion& b) const noexcept;
        [[nodiscard]] constexpr Multivector antiGeometric(const Translator& b) const noexcept;
        [[nodiscard]] constexpr Motor antiGeometric(const Vector& b) const noexcept;
        [[nodiscard]] constexpr Motor antiGeometric(const Point& b) const noexcept;
        [[nodiscard]] constexpr BivectorBulk antiGeometric(const PlaneIdeal& b) const noexcept;
        [[nodiscard]] constexpr PlaneIdeal antiGeometric(const BivectorBulk& b) const noexcept;
        [[nodiscard]] constexpr Multivector antiGeometric(const BivectorWeight& b) const noexcept;
        [[nodiscard]] constexpr Plane antiGeometric(const PseudoScalar& b) const noexcept;
        [[nodiscard]] constexpr double antiGeometric(const PointCenter& b) const noexcept;

        [[nodiscard]] constexpr Plane antiWedge(const Motor& b) const noexcept;
        [[nodiscard]] constexpr double antiWedge(const ProjectivePoint& b) const noexcept;
        [[nodiscard]] constexpr double antiWedge(const Vector& b) const noexcept;
        [[nodiscard]] constexpr double antiWedge(const Point& b) const noexcept;
        [[nodiscard]] constexpr Plane antiWedge(const PseudoScalar& b) const noexcept;
        [[nodiscard]] constexpr double antiWedge(const PointCenter& b) const noexcept;

        [[nodiscard]] constexpr Multivector antiDot(const Motor& b) const noexcept;
        [[nodiscard]] constexpr PseudoScalar antiDot(const Plane& b) const noexcept;
        [[nodiscard]] constexpr ProjectivePoint antiDot(const Bivector& b) const noexcept;
        [[nodiscard]] constexpr Bivector antiDot(const ProjectivePoint& b) const noexcept;
        [[nodiscard]] constexpr ProjectivePoint antiDot(const Quaternion& b) const noexcept;
        [[nodiscard]] constexpr ProjectivePoint antiDot(const Translator& b) const noexcept;
        [[nodiscard]] constexpr Bivector antiDot(const Vector& b) const noexcept;
        [[nodiscard]] constexpr Bivector antiDot(const Point& b) const noexcept;
        [[nodiscard]] constexpr ProjectivePoint antiDot(const BivectorWeight& b) const noexcept;
        [[nodiscard]] constexpr Plane antiDot(const PseudoScalar& b) const noexcept;

        [[nodiscard]] constexpr Multivector toMultivector() const noexcept;
        [[nodiscard]] constexpr PlaneIdeal toPlaneIdealUnsafe() const noexcept;

        [[nodiscard]] constexpr Plane madd(const Plane& other, double mult) const noexcept;

        [[nodiscard]] constexpr double normSquare() const noexcept;
        [[nodiscard]] double norm() const noexcept;
        [[nodiscard]] Plane normalizedByNorm() const noexcept;
        [[nodiscard]] constexpr double bulkNormSquare() const noexcept;
        [[nodiscard]] double bulkNorm() const noexcept;
        [[nodiscard]] Plane normalizedByBulk() const noexcept;
        [[nodiscard]] constexpr double weightNormSquare() const noexcept;
        [[nodiscard]] double weightNorm() const noexcept;
        [[nodiscard]] Plane normalizedByWeight() const noexcept;
    };

    static_assert(std::is_trivially_copyable_v<Plane>);
    static_assert(sizeof(Plane) == 8 * 4, "ProjectivePoint must be exactly 32 bytes");
}