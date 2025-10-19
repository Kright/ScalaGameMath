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

        [[nodiscard]] constexpr PointCenter bulk() const noexcept;

        [[nodiscard]] constexpr ProjectivePoint reverse() const noexcept;

        [[nodiscard]] constexpr PointCenter antiReverse() const noexcept;

        [[nodiscard]] constexpr Multivector geometric(const Motor& b) const noexcept;
        [[nodiscard]] constexpr Motor geometric(const Plane& b) const noexcept;
        [[nodiscard]] constexpr Multivector geometric(const Bivector& b) const noexcept;
        [[nodiscard]] constexpr Motor geometric(const ProjectivePoint& b) const noexcept;
        [[nodiscard]] constexpr Multivector geometric(const Quaternion& b) const noexcept;
        [[nodiscard]] constexpr Point geometric(const Translator& b) const noexcept;
        [[nodiscard]] constexpr BivectorWeight geometric(const Vector& b) const noexcept;
        [[nodiscard]] constexpr Motor geometric(const Point& b) const noexcept;
        [[nodiscard]] constexpr BivectorBulk geometric(const PlaneIdeal& b) const noexcept;
        [[nodiscard]] constexpr PlaneIdeal geometric(const BivectorBulk& b) const noexcept;
        [[nodiscard]] constexpr Vector geometric(const BivectorWeight& b) const noexcept;
        [[nodiscard]] constexpr Plane geometric(const PseudoScalar& b) const noexcept;
        [[nodiscard]] constexpr double geometric(const PointCenter& b) const noexcept;

        [[nodiscard]] constexpr Multivector dot(const Motor& b) const noexcept;
        [[nodiscard]] constexpr BivectorBulk dot(const Plane& b) const noexcept;
        [[nodiscard]] constexpr PlaneIdeal dot(const Bivector& b) const noexcept;
        [[nodiscard]] constexpr double dot(const ProjectivePoint& b) const noexcept;
        [[nodiscard]] constexpr Multivector dot(const Quaternion& b) const noexcept;
        [[nodiscard]] constexpr PointCenter dot(const Translator& b) const noexcept;
        [[nodiscard]] constexpr double dot(const Point& b) const noexcept;
        [[nodiscard]] constexpr BivectorBulk dot(const PlaneIdeal& b) const noexcept;
        [[nodiscard]] constexpr PlaneIdeal dot(const BivectorBulk& b) const noexcept;
        [[nodiscard]] constexpr Plane dot(const PseudoScalar& b) const noexcept;
        [[nodiscard]] constexpr double dot(const PointCenter& b) const noexcept;

        [[nodiscard]] constexpr Multivector toMultivector() const noexcept;
        [[nodiscard]] constexpr ProjectivePoint toProjectivePoint() const noexcept;
        [[nodiscard]] constexpr Vector toVectorUnsafe() const noexcept;
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

    static_assert(std::is_trivially_copyable_v<PointCenter>);
}