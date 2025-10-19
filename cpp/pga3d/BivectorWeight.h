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

        [[nodiscard]] constexpr Multivector toMultivector() const noexcept;
        [[nodiscard]] constexpr Motor toMotor() const noexcept;
        [[nodiscard]] constexpr Bivector toBivector() const noexcept;
        [[nodiscard]] constexpr Translator toTranslatorUnsafe() const noexcept;

        [[nodiscard]] constexpr double normSquare() const noexcept;
        [[nodiscard]] double norm() const noexcept;
        [[nodiscard]] BivectorWeight normalizedByNorm() const noexcept;
        [[nodiscard]] constexpr double weightNormSquare() const noexcept;
        [[nodiscard]] double weightNorm() const noexcept;
        [[nodiscard]] BivectorWeight normalizedByWeight() const noexcept;
    };

    static_assert(std::is_trivially_copyable_v<BivectorWeight>);
    static_assert(sizeof(BivectorWeight) == 8 * 3, "ProjectivePoint must be exactly 24 bytes");
}