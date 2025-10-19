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