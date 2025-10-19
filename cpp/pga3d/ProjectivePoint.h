#pragma once

#include <type_traits>
#include "types_forward.h"

// This code is generated, see com.github.kright.pga3d.codegen.cpp.CppCodeGen

namespace pga3d {
    struct ProjectivePoint {
        double x = 0.0;
        double y = 0.0;
        double z = 0.0;
        double w = 0.0;

        static constexpr int componentsCount = 4;

        [[nodiscard]] constexpr double wyz() const noexcept { return -x; }
        [[nodiscard]] constexpr double wxz() const noexcept { return y; }
        [[nodiscard]] constexpr double wxy() const noexcept { return -z; }
        [[nodiscard]] constexpr double xyz() const noexcept { return w; }

        [[nodiscard]] static constexpr ProjectivePoint blade3(double wxy = 0.0, double wxz = 0.0, double wyz = 0.0, double xyz = 0.0) noexcept { return {.x = -wyz, .y = wxz, .z = -wxy, .w = xyz}; }

        [[nodiscard]] constexpr Plane dual() const noexcept;

        [[nodiscard]] constexpr Vector weight() const noexcept;

        [[nodiscard]] constexpr ProjectivePoint bulk() const noexcept;

        [[nodiscard]] constexpr ProjectivePoint reverse() const noexcept;

        [[nodiscard]] constexpr ProjectivePoint antiReverse() const noexcept;

        [[nodiscard]] constexpr Multivector toMultivector() const noexcept;
        [[nodiscard]] constexpr Vector toVectorUnsafe() const noexcept;
        [[nodiscard]] constexpr Point toPointUnsafe() const noexcept;
        [[nodiscard]] constexpr Point toPoint() const noexcept;

        [[nodiscard]] constexpr double normSquare() const noexcept;
        [[nodiscard]] double norm() const noexcept;
        [[nodiscard]] ProjectivePoint normalizedByNorm() const noexcept;
        [[nodiscard]] constexpr double bulkNormSquare() const noexcept;
        [[nodiscard]] double bulkNorm() const noexcept;
        [[nodiscard]] ProjectivePoint normalizedByBulk() const noexcept;
        [[nodiscard]] constexpr double weightNormSquare() const noexcept;
        [[nodiscard]] double weightNorm() const noexcept;
        [[nodiscard]] ProjectivePoint normalizedByWeight() const noexcept;
    };

    static_assert(std::is_trivially_copyable_v<ProjectivePoint>);
    static_assert(sizeof(ProjectivePoint) == 8 * 4, "ProjectivePoint must be exactly 32 bytes");
}