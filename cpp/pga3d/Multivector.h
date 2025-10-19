#pragma once

#include <type_traits>
#include "types_forward.h"

// This code is generated, see com.github.kright.pga3d.codegen.cpp.CppCodeGen

namespace pga3d {
    struct Multivector {
        double s = 0.0;
        double w = 0.0;
        double x = 0.0;
        double y = 0.0;
        double z = 0.0;
        double wx = 0.0;
        double wy = 0.0;
        double wz = 0.0;
        double xy = 0.0;
        double xz = 0.0;
        double yz = 0.0;
        double wxy = 0.0;
        double wxz = 0.0;
        double wyz = 0.0;
        double xyz = 0.0;
        double i = 0.0;

        static constexpr int componentsCount = 16;

        [[nodiscard]] constexpr Multivector dual() const noexcept;

        [[nodiscard]] constexpr Multivector weight() const noexcept;

        [[nodiscard]] constexpr Multivector bulk() const noexcept;

        [[nodiscard]] constexpr Motor toMotorUnsafe() const noexcept;
        [[nodiscard]] constexpr Plane toPlaneUnsafe() const noexcept;
        [[nodiscard]] constexpr Bivector toBivectorUnsafe() const noexcept;
        [[nodiscard]] constexpr ProjectivePoint toProjectivePointUnsafe() const noexcept;
        [[nodiscard]] constexpr Quaternion toQuaternionUnsafe() const noexcept;
        [[nodiscard]] constexpr Translator toTranslatorUnsafe() const noexcept;
        [[nodiscard]] constexpr Vector toVectorUnsafe() const noexcept;
        [[nodiscard]] constexpr Point toPointUnsafe() const noexcept;
        [[nodiscard]] constexpr PlaneIdeal toPlaneIdealUnsafe() const noexcept;
        [[nodiscard]] constexpr BivectorBulk toBivectorBulkUnsafe() const noexcept;
        [[nodiscard]] constexpr BivectorWeight toBivectorWeightUnsafe() const noexcept;
    };

    static_assert(std::is_trivially_copyable_v<Multivector>);
    static_assert(sizeof(Multivector) == 8 * 16, "ProjectivePoint must be exactly 128 bytes");
}