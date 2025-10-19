#pragma once

#include <type_traits>
#include "types_forward.h"

// This code is generated, see com.github.kright.pga3d.codegen.cpp.CppCodeGen

namespace pga3d {
    struct Translator {
        double wx = 0.0;
        double wy = 0.0;
        double wz = 0.0;

        static constexpr int componentsCount = 3;

        [[nodiscard]] constexpr double s() const noexcept { return 1.0; }

        [[nodiscard]] constexpr Motor dual() const noexcept;

        [[nodiscard]] constexpr BivectorWeight weight() const noexcept;

        [[nodiscard]] constexpr double bulk() const noexcept;

        [[nodiscard]] constexpr Translator reverse() const noexcept;

        [[nodiscard]] constexpr Translator antiReverse() const noexcept;

        [[nodiscard]] constexpr Motor geometric(const Motor& b) const noexcept;
        [[nodiscard]] constexpr Multivector geometric(const Plane& b) const noexcept;
        [[nodiscard]] constexpr Motor geometric(const Bivector& b) const noexcept;
        [[nodiscard]] constexpr ProjectivePoint geometric(const ProjectivePoint& b) const noexcept;
        [[nodiscard]] constexpr Motor geometric(const Quaternion& b) const noexcept;
        [[nodiscard]] constexpr Translator geometric(const Translator& b) const noexcept;
        [[nodiscard]] constexpr Vector geometric(const Vector& b) const noexcept;
        [[nodiscard]] constexpr Point geometric(const Point& b) const noexcept;
        [[nodiscard]] constexpr Multivector geometric(const PlaneIdeal& b) const noexcept;
        [[nodiscard]] constexpr Motor geometric(const BivectorBulk& b) const noexcept;
        [[nodiscard]] constexpr BivectorWeight geometric(const BivectorWeight& b) const noexcept;
        [[nodiscard]] constexpr PseudoScalar geometric(const PseudoScalar& b) const noexcept;
        [[nodiscard]] constexpr Point geometric(const PointCenter& b) const noexcept;

        [[nodiscard]] constexpr Multivector toMultivector() const noexcept;
        [[nodiscard]] constexpr Motor toMotor() const noexcept;
        [[nodiscard]] constexpr Bivector toBivectorUnsafe() const noexcept;
        [[nodiscard]] constexpr Quaternion toQuaternionUnsafe() const noexcept;
        [[nodiscard]] constexpr BivectorWeight toBivectorWeightUnsafe() const noexcept;

        [[nodiscard]] constexpr double normSquare() const noexcept;
        [[nodiscard]] double norm() const noexcept;
        [[nodiscard]] Motor normalizedByNorm() const noexcept;
        [[nodiscard]] constexpr double bulkNormSquare() const noexcept;
        [[nodiscard]] double bulkNorm() const noexcept;
        [[nodiscard]] Motor normalizedByBulk() const noexcept;
        [[nodiscard]] constexpr double weightNormSquare() const noexcept;
        [[nodiscard]] double weightNorm() const noexcept;
        [[nodiscard]] Motor normalizedByWeight() const noexcept;
    };

    static_assert(std::is_trivially_copyable_v<Translator>);
    static_assert(sizeof(Translator) == 8 * 3, "ProjectivePoint must be exactly 24 bytes");
}