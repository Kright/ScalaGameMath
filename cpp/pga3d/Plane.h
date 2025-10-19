#pragma once

#include <type_traits>
#include "types_forward.h"

// This code is generated, see com.github.kright.pga3d.codegen.cpp.CppCodeGen

namespace pga3d {
    struct Plane {
        double x = 0.0;
        double y = 0.0;
        double z = 0.0;
        double w = 0.0;

        static constexpr int componentsCount = 4;

        [[nodiscard]] constexpr ProjectivePoint dual() const noexcept;

        [[nodiscard]] constexpr Plane weight() const noexcept;

        [[nodiscard]] constexpr PlaneIdeal bulk() const noexcept;

        [[nodiscard]] constexpr Plane reverse() const noexcept;

        [[nodiscard]] constexpr Plane antiReverse() const noexcept;

        [[nodiscard]] constexpr Multivector toMultivector() const noexcept;
        [[nodiscard]] constexpr PlaneIdeal toPlaneIdealUnsafe() const noexcept;

        [[nodiscard]] constexpr double normSquare() const noexcept;
        [[nodiscard]] double norm() const noexcept;
        [[nodiscard]] Plane normalizedByNorm() const noexcept;
        [[nodiscard]] constexpr double bulkNormSquare() const noexcept;
        [[nodiscard]] double bulkNorm() const noexcept;
        [[nodiscard]] Plane normalizedByBulk() const noexcept;
        [[nodiscard]] constexpr double weightNormSquare() const noexcept;
        [[nodiscard]] double weightNorm() const noexcept;
        [[nodiscard]] Plane normalizedByWeight() const noexcept;
    };

    static_assert(std::is_trivially_copyable_v<Plane>);
    static_assert(sizeof(Plane) == 8 * 4, "ProjectivePoint must be exactly 32 bytes");
}