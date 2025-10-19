#pragma once

#include <type_traits>
#include "types_forward.h"

// This code is generated, see com.github.kright.pga3d.codegen.cpp.CppCodeGen

namespace pga3d {
    struct BivectorBulk {
        double xy = 0.0;
        double xz = 0.0;
        double yz = 0.0;

        static constexpr int componentsCount = 3;

        [[nodiscard]] constexpr BivectorWeight dual() const noexcept;

        [[nodiscard]] constexpr BivectorBulk bulk() const noexcept;

        [[nodiscard]] constexpr Multivector toMultivector() const noexcept;
        [[nodiscard]] constexpr Motor toMotor() const noexcept;
        [[nodiscard]] constexpr Bivector toBivector() const noexcept;
        [[nodiscard]] constexpr Quaternion toQuaternion() const noexcept;
    };

    static_assert(std::is_trivially_copyable_v<BivectorBulk>);
    static_assert(sizeof(BivectorBulk) == 8 * 3, "ProjectivePoint must be exactly 24 bytes");
}