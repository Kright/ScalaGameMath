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

        [[nodiscard]] constexpr Multivector toMultivector() const noexcept;
        [[nodiscard]] constexpr Plane toPlane() const noexcept;
    };

    static_assert(std::is_trivially_copyable_v<PlaneIdeal>);
    static_assert(sizeof(PlaneIdeal) == 8 * 3, "ProjectivePoint must be exactly 24 bytes");
}