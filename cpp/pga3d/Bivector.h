#pragma once

#include <type_traits>
#include "types_forward.h"

// This code is generated, see com.github.kright.pga3d.codegen.cpp.CppCodeGen

namespace pga3d {
    struct Bivector {
        double wx = 0.0;
        double wy = 0.0;
        double wz = 0.0;
        double xy = 0.0;
        double xz = 0.0;
        double yz = 0.0;

        static constexpr int componentsCount = 6;

        [[nodiscard]] constexpr Bivector dual() const noexcept;

        [[nodiscard]] constexpr BivectorWeight weight() const noexcept;

        [[nodiscard]] constexpr BivectorBulk bulk() const noexcept;

        [[nodiscard]] constexpr Bivector reverse() const noexcept;

        [[nodiscard]] constexpr Bivector antiReverse() const noexcept;

        [[nodiscard]] constexpr Multivector toMultivector() const noexcept;
        [[nodiscard]] constexpr Motor toMotor() const noexcept;
        [[nodiscard]] constexpr Quaternion toQuaternionUnsafe() const noexcept;
        [[nodiscard]] constexpr Translator toTranslatorUnsafe() const noexcept;
        [[nodiscard]] constexpr BivectorBulk toBivectorBulkUnsafe() const noexcept;
        [[nodiscard]] constexpr BivectorWeight toBivectorWeightUnsafe() const noexcept;

        [[nodiscard]] constexpr double normSquare() const noexcept;
        [[nodiscard]] double norm() const noexcept;
        [[nodiscard]] Bivector normalizedByNorm() const noexcept;
    };

    static_assert(std::is_trivially_copyable_v<Bivector>);
    static_assert(sizeof(Bivector) == 8 * 6, "ProjectivePoint must be exactly 48 bytes");
}