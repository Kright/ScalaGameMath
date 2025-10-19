#pragma once

#include <type_traits>
#include "types_forward.h"

// This code is generated, see com.github.kright.pga3d.codegen.cpp.CppCodeGen

namespace pga3d {
    struct PointCenter {

        static constexpr int componentsCount = 0;

        [[nodiscard]] constexpr double x() const noexcept { return 0.0; }
        [[nodiscard]] constexpr double y() const noexcept { return 0.0; }
        [[nodiscard]] constexpr double z() const noexcept { return 0.0; }
        [[nodiscard]] constexpr double w() const noexcept { return 1.0; }

        [[nodiscard]] constexpr double wyz() const noexcept { return 0.0; }
        [[nodiscard]] constexpr double wxz() const noexcept { return 0.0; }
        [[nodiscard]] constexpr double wxy() const noexcept { return 0.0; }
        [[nodiscard]] constexpr double xyz() const noexcept { return 1.0; }

        [[nodiscard]] constexpr Plane dual() const noexcept;

        [[nodiscard]] constexpr Multivector toMultivector() const noexcept;
        [[nodiscard]] constexpr ProjectivePoint toProjectivePoint() const noexcept;
        [[nodiscard]] constexpr Vector toVectorUnsafe() const noexcept;
        [[nodiscard]] constexpr Point toPoint() const noexcept;
    };

    static_assert(std::is_trivially_copyable_v<PointCenter>);
}