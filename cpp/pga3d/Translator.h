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

        [[nodiscard]] constexpr Multivector toMultivector() const noexcept;
        [[nodiscard]] constexpr Motor toMotor() const noexcept;
        [[nodiscard]] constexpr Bivector toBivectorUnsafe() const noexcept;
        [[nodiscard]] constexpr Quaternion toQuaternionUnsafe() const noexcept;
        [[nodiscard]] constexpr BivectorWeight toBivectorWeightUnsafe() const noexcept;
    };

    static_assert(std::is_trivially_copyable_v<Translator>);
    static_assert(sizeof(Translator) == 8 * 3, "ProjectivePoint must be exactly 24 bytes");
}