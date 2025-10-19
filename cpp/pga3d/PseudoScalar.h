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