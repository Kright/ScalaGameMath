#pragma once

#include <type_traits>
#include "types_forward.h"

// This code is generated, see com.github.kright.pga3d.codegen.cpp.CppCodeGen

namespace pga3d {
    struct Point {
        double x = 0.0;
        double y = 0.0;
        double z = 0.0;

        static constexpr int componentsCount = 3;

        [[nodiscard]] constexpr double w() const noexcept { return 1.0; }

        [[nodiscard]] constexpr double wyz() const noexcept { return -x; }
        [[nodiscard]] constexpr double wxz() const noexcept { return y; }
        [[nodiscard]] constexpr double wxy() const noexcept { return -z; }
        [[nodiscard]] constexpr double xyz() const noexcept { return 1.0; }

        [[nodiscard]] static constexpr Point blade3(double wxy = 0.0, double wxz = 0.0, double wyz = 0.0) noexcept { return {.x = -wyz, .y = wxz, .z = -wxy}; }

        [[nodiscard]] constexpr Plane dual() const noexcept;

        [[nodiscard]] constexpr Vector weight() const noexcept;

        [[nodiscard]] constexpr PointCenter bulk() const noexcept;

        [[nodiscard]] constexpr ProjectivePoint reverse() const noexcept;

        [[nodiscard]] constexpr Point antiReverse() const noexcept;

        [[nodiscard]] constexpr Multivector geometric(const Motor& b) const noexcept;
        [[nodiscard]] constexpr Motor geometric(const Plane& b) const noexcept;
        [[nodiscard]] constexpr Multivector geometric(const Bivector& b) const noexcept;
        [[nodiscard]] constexpr Motor geometric(const ProjectivePoint& b) const noexcept;
        [[nodiscard]] constexpr Multivector geometric(const Quaternion& b) const noexcept;
        [[nodiscard]] constexpr Point geometric(const Translator& b) const noexcept;
        [[nodiscard]] constexpr BivectorWeight geometric(const Vector& b) const noexcept;
        [[nodiscard]] constexpr Motor geometric(const Point& b) const noexcept;
        [[nodiscard]] constexpr Motor geometric(const PlaneIdeal& b) const noexcept;
        [[nodiscard]] constexpr Multivector geometric(const BivectorBulk& b) const noexcept;
        [[nodiscard]] constexpr Vector geometric(const BivectorWeight& b) const noexcept;
        [[nodiscard]] constexpr Plane geometric(const PseudoScalar& b) const noexcept;
        [[nodiscard]] constexpr Motor geometric(const PointCenter& b) const noexcept;

        [[nodiscard]] constexpr ProjectivePoint wedge(const Motor& b) const noexcept;
        [[nodiscard]] constexpr PseudoScalar wedge(const Plane& b) const noexcept;
        [[nodiscard]] constexpr ProjectivePoint wedge(const Quaternion& b) const noexcept;
        [[nodiscard]] constexpr Point wedge(const Translator& b) const noexcept;
        [[nodiscard]] constexpr PseudoScalar wedge(const PlaneIdeal& b) const noexcept;

        [[nodiscard]] constexpr Multivector dot(const Motor& b) const noexcept;
        [[nodiscard]] constexpr Bivector dot(const Plane& b) const noexcept;
        [[nodiscard]] constexpr Plane dot(const Bivector& b) const noexcept;
        [[nodiscard]] constexpr double dot(const ProjectivePoint& b) const noexcept;
        [[nodiscard]] constexpr Multivector dot(const Quaternion& b) const noexcept;
        [[nodiscard]] constexpr Point dot(const Translator& b) const noexcept;
        [[nodiscard]] constexpr double dot(const Point& b) const noexcept;
        [[nodiscard]] constexpr Bivector dot(const PlaneIdeal& b) const noexcept;
        [[nodiscard]] constexpr Plane dot(const BivectorBulk& b) const noexcept;
        [[nodiscard]] constexpr Plane dot(const PseudoScalar& b) const noexcept;
        [[nodiscard]] constexpr double dot(const PointCenter& b) const noexcept;

        [[nodiscard]] constexpr Multivector antiGeometric(const Motor& b) const noexcept;
        [[nodiscard]] constexpr Motor antiGeometric(const Plane& b) const noexcept;
        [[nodiscard]] constexpr Multivector antiGeometric(const Bivector& b) const noexcept;
        [[nodiscard]] constexpr Motor antiGeometric(const ProjectivePoint& b) const noexcept;
        [[nodiscard]] constexpr Multivector antiGeometric(const Quaternion& b) const noexcept;
        [[nodiscard]] constexpr Multivector antiGeometric(const Translator& b) const noexcept;
        [[nodiscard]] constexpr Motor antiGeometric(const Vector& b) const noexcept;
        [[nodiscard]] constexpr Motor antiGeometric(const Point& b) const noexcept;
        [[nodiscard]] constexpr Quaternion antiGeometric(const PlaneIdeal& b) const noexcept;
        [[nodiscard]] constexpr Multivector antiGeometric(const BivectorBulk& b) const noexcept;
        [[nodiscard]] constexpr Multivector antiGeometric(const BivectorWeight& b) const noexcept;
        [[nodiscard]] constexpr ProjectivePoint antiGeometric(const PseudoScalar& b) const noexcept;
        [[nodiscard]] constexpr BivectorBulk antiGeometric(const PointCenter& b) const noexcept;

        [[nodiscard]] constexpr Multivector antiWedge(const Motor& b) const noexcept;
        [[nodiscard]] constexpr double antiWedge(const Plane& b) const noexcept;
        [[nodiscard]] constexpr Plane antiWedge(const Bivector& b) const noexcept;
        [[nodiscard]] constexpr Bivector antiWedge(const ProjectivePoint& b) const noexcept;
        [[nodiscard]] constexpr PlaneIdeal antiWedge(const Quaternion& b) const noexcept;
        [[nodiscard]] constexpr Plane antiWedge(const Translator& b) const noexcept;
        [[nodiscard]] constexpr Bivector antiWedge(const Vector& b) const noexcept;
        [[nodiscard]] constexpr Bivector antiWedge(const Point& b) const noexcept;
        [[nodiscard]] constexpr double antiWedge(const PlaneIdeal& b) const noexcept;
        [[nodiscard]] constexpr PlaneIdeal antiWedge(const BivectorBulk& b) const noexcept;
        [[nodiscard]] constexpr Plane antiWedge(const BivectorWeight& b) const noexcept;
        [[nodiscard]] constexpr ProjectivePoint antiWedge(const PseudoScalar& b) const noexcept;
        [[nodiscard]] constexpr BivectorBulk antiWedge(const PointCenter& b) const noexcept;

        [[nodiscard]] constexpr Multivector antiDot(const Motor& b) const noexcept;
        [[nodiscard]] constexpr Bivector antiDot(const Plane& b) const noexcept;
        [[nodiscard]] constexpr ProjectivePoint antiDot(const Bivector& b) const noexcept;
        [[nodiscard]] constexpr PseudoScalar antiDot(const ProjectivePoint& b) const noexcept;
        [[nodiscard]] constexpr Multivector antiDot(const Quaternion& b) const noexcept;
        [[nodiscard]] constexpr Multivector antiDot(const Translator& b) const noexcept;
        [[nodiscard]] constexpr PseudoScalar antiDot(const Vector& b) const noexcept;
        [[nodiscard]] constexpr PseudoScalar antiDot(const Point& b) const noexcept;
        [[nodiscard]] constexpr BivectorBulk antiDot(const PlaneIdeal& b) const noexcept;
        [[nodiscard]] constexpr ProjectivePoint antiDot(const BivectorBulk& b) const noexcept;
        [[nodiscard]] constexpr Vector antiDot(const BivectorWeight& b) const noexcept;
        [[nodiscard]] constexpr ProjectivePoint antiDot(const PseudoScalar& b) const noexcept;

        [[nodiscard]] constexpr Multivector toMultivector() const noexcept;
        [[nodiscard]] constexpr ProjectivePoint toProjectivePoint() const noexcept;
        [[nodiscard]] constexpr Vector toVectorUnsafe() const noexcept;

        [[nodiscard]] constexpr Point madd(const Vector& other, double mult) const noexcept;

        [[nodiscard]] constexpr double normSquare() const noexcept;
        [[nodiscard]] double norm() const noexcept;
        [[nodiscard]] ProjectivePoint normalizedByNorm() const noexcept;
        [[nodiscard]] constexpr double bulkNormSquare() const noexcept;
        [[nodiscard]] double bulkNorm() const noexcept;
        [[nodiscard]] ProjectivePoint normalizedByBulk() const noexcept;
        [[nodiscard]] constexpr double weightNormSquare() const noexcept;
        [[nodiscard]] double weightNorm() const noexcept;
        [[nodiscard]] ProjectivePoint normalizedByWeight() const noexcept;
    };

    static_assert(std::is_trivially_copyable_v<Point>);
    static_assert(sizeof(Point) == 8 * 3, "ProjectivePoint must be exactly 24 bytes");
}