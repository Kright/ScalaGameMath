#pragma once

#include <type_traits>
#include "types_forward.h"

// This code is generated, see com.github.kright.pga3d.codegen.cpp.CppCodeGen

namespace pga3d {
    struct PlaneIdeal {
        double x = 0.0;
        double y = 0.0;
        double z = 0.0;

        static constexpr int componentsCount = 3;

        [[nodiscard]] constexpr Vector dual() const noexcept;

        [[nodiscard]] constexpr PlaneIdeal bulk() const noexcept;

        [[nodiscard]] constexpr PlaneIdeal reverse() const noexcept;

        [[nodiscard]] constexpr PlaneIdeal antiReverse() const noexcept;

        [[nodiscard]] constexpr Multivector geometric(const Motor& b) const noexcept;
        [[nodiscard]] constexpr Motor geometric(const Plane& b) const noexcept;
        [[nodiscard]] constexpr Multivector geometric(const Bivector& b) const noexcept;
        [[nodiscard]] constexpr Motor geometric(const ProjectivePoint& b) const noexcept;
        [[nodiscard]] constexpr Multivector geometric(const Quaternion& b) const noexcept;
        [[nodiscard]] constexpr Multivector geometric(const Translator& b) const noexcept;
        [[nodiscard]] constexpr Motor geometric(const Vector& b) const noexcept;
        [[nodiscard]] constexpr Motor geometric(const Point& b) const noexcept;
        [[nodiscard]] constexpr Quaternion geometric(const PlaneIdeal& b) const noexcept;
        [[nodiscard]] constexpr Multivector geometric(const BivectorBulk& b) const noexcept;
        [[nodiscard]] constexpr Multivector geometric(const BivectorWeight& b) const noexcept;
        [[nodiscard]] constexpr Vector geometric(const PseudoScalar& b) const noexcept;
        [[nodiscard]] constexpr BivectorBulk geometric(const PointCenter& b) const noexcept;

        [[nodiscard]] constexpr Multivector toMultivector() const noexcept;
        [[nodiscard]] constexpr Plane toPlane() const noexcept;

        [[nodiscard]] constexpr PlaneIdeal madd(const PlaneIdeal& other, double mult) const noexcept;

        [[nodiscard]] constexpr double normSquare() const noexcept;
        [[nodiscard]] double norm() const noexcept;
        [[nodiscard]] PlaneIdeal normalizedByNorm() const noexcept;
        [[nodiscard]] constexpr double bulkNormSquare() const noexcept;
        [[nodiscard]] double bulkNorm() const noexcept;
        [[nodiscard]] PlaneIdeal normalizedByBulk() const noexcept;
    };

    static_assert(std::is_trivially_copyable_v<PlaneIdeal>);
    static_assert(sizeof(PlaneIdeal) == 8 * 3, "ProjectivePoint must be exactly 24 bytes");
}