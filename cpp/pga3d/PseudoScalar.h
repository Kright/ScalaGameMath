#pragma once

#include <type_traits>
#include "types_forward.h"

// This code is generated, see com.github.kright.pga3d.codegen.cpp.CppCodeGen

namespace pga3d {
    struct PseudoScalar {
        double i = 0.0;

        static constexpr int componentsCount = 1;

        [[nodiscard]] constexpr double dual() const noexcept;

        [[nodiscard]] constexpr Multivector toMultivector() const noexcept;
        [[nodiscard]] constexpr Motor toMotor() const noexcept;
    };

    static_assert(std::is_trivially_copyable_v<PseudoScalar>);
    static_assert(sizeof(PseudoScalar) == 8 * 1, "ProjectivePoint must be exactly 8 bytes");
}