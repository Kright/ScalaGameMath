#pragma once

#include <type_traits>
#include "types_forward.h"

// This code is generated, see com.github.kright.pga3d.codegen.cpp.CppCodeGen

namespace pga3d {
    struct Vector {
        double x = 0.0;
        double y = 0.0;
        double z = 0.0;

        static constexpr int componentsCount = 3;

        [[nodiscard]] constexpr double wyz() const noexcept { return -x; }
        [[nodiscard]] constexpr double wxz() const noexcept { return y; }
        [[nodiscard]] constexpr double wxy() const noexcept { return -z; }

        [[nodiscard]] static constexpr Vector blade3(double wxy = 0.0, double wxz = 0.0, double wyz = 0.0) noexcept { return {.x = -wyz, .y = wxz, .z = -wxy}; }

        [[nodiscard]] constexpr PlaneIdeal dual() const noexcept;

        [[nodiscard]] constexpr Vector weight() const noexcept;

        [[nodiscard]] constexpr Vector reverse() const noexcept;

        [[nodiscard]] constexpr Vector antiReverse() const noexcept;

        [[nodiscard]] constexpr Multivector geometric(const Motor& b) const noexcept;
        [[nodiscard]] constexpr Motor geometric(const Plane& b) const noexcept;
        [[nodiscard]] constexpr Multivector geometric(const Bivector& b) const noexcept;
        [[nodiscard]] constexpr BivectorWeight geometric(const ProjectivePoint& b) const noexcept;
        [[nodiscard]] constexpr Multivector geometric(const Quaternion& b) const noexcept;
        [[nodiscard]] constexpr Vector geometric(const Translator& b) const noexcept;
        [[nodiscard]] constexpr BivectorWeight geometric(const Point& b) const noexcept;
        [[nodiscard]] constexpr Motor geometric(const PlaneIdeal& b) const noexcept;
        [[nodiscard]] constexpr Multivector geometric(const BivectorBulk& b) const noexcept;
        [[nodiscard]] constexpr BivectorWeight geometric(const PointCenter& b) const noexcept;

        [[nodiscard]] constexpr Multivector dot(const Motor& b) const noexcept;
        [[nodiscard]] constexpr BivectorWeight dot(const Plane& b) const noexcept;
        [[nodiscard]] constexpr Plane dot(const Bivector& b) const noexcept;
        [[nodiscard]] constexpr Multivector dot(const Quaternion& b) const noexcept;
        [[nodiscard]] constexpr Vector dot(const Translator& b) const noexcept;
        [[nodiscard]] constexpr BivectorWeight dot(const PlaneIdeal& b) const noexcept;
        [[nodiscard]] constexpr Plane dot(const BivectorBulk& b) const noexcept;

        [[nodiscard]] constexpr Multivector toMultivector() const noexcept;
        [[nodiscard]] constexpr ProjectivePoint toProjectivePoint() const noexcept;
        [[nodiscard]] constexpr Point toPointUnsafe() const noexcept;

        [[nodiscard]] constexpr Vector madd(const Vector& other, double mult) const noexcept;

        [[nodiscard]] constexpr double normSquare() const noexcept;
        [[nodiscard]] double norm() const noexcept;
        [[nodiscard]] Vector normalizedByNorm() const noexcept;
        [[nodiscard]] constexpr double weightNormSquare() const noexcept;
        [[nodiscard]] double weightNorm() const noexcept;
        [[nodiscard]] Vector normalizedByWeight() const noexcept;
    };

    static_assert(std::is_trivially_copyable_v<Vector>);
    static_assert(sizeof(Vector) == 8 * 3, "ProjectivePoint must be exactly 24 bytes");
}