#pragma once

#include <type_traits>
#include "types_forward.h"

// This code is generated, see com.github.kright.pga3d.codegen.cpp.CppCodeGen

namespace pga3d {
    struct Quaternion {
        double s = 0.0;
        double xy = 0.0;
        double xz = 0.0;
        double yz = 0.0;

        static constexpr int componentsCount = 4;

        [[nodiscard]] static constexpr Quaternion id() noexcept { return {.s = 1.0}; }

        [[nodiscard]] constexpr Motor dual() const noexcept;

        [[nodiscard]] constexpr Quaternion bulk() const noexcept;

        [[nodiscard]] constexpr Quaternion reverse() const noexcept;

        [[nodiscard]] constexpr Quaternion antiReverse() const noexcept;

        [[nodiscard]] constexpr Multivector toMultivector() const noexcept;
        [[nodiscard]] constexpr Motor toMotor() const noexcept;
        [[nodiscard]] constexpr Bivector toBivectorUnsafe() const noexcept;
        [[nodiscard]] constexpr BivectorBulk toBivectorBulkUnsafe() const noexcept;
    };

    static_assert(std::is_trivially_copyable_v<Quaternion>);
    static_assert(sizeof(Quaternion) == 8 * 4, "ProjectivePoint must be exactly 32 bytes");
}