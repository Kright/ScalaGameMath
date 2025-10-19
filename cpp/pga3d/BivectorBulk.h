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

        [[nodiscard]] constexpr BivectorBulk reverse() const noexcept;

        [[nodiscard]] constexpr BivectorBulk antiReverse() const noexcept;

        [[nodiscard]] constexpr Motor geometric(const Motor& b) const noexcept;
        [[nodiscard]] constexpr Multivector geometric(const Plane& b) const noexcept;
        [[nodiscard]] constexpr Motor geometric(const Bivector& b) const noexcept;
        [[nodiscard]] constexpr Multivector geometric(const ProjectivePoint& b) const noexcept;
        [[nodiscard]] constexpr Quaternion geometric(const Quaternion& b) const noexcept;
        [[nodiscard]] constexpr Motor geometric(const Translator& b) const noexcept;
        [[nodiscard]] constexpr Multivector geometric(const Vector& b) const noexcept;
        [[nodiscard]] constexpr Multivector geometric(const Point& b) const noexcept;
        [[nodiscard]] constexpr Multivector geometric(const PlaneIdeal& b) const noexcept;
        [[nodiscard]] constexpr Quaternion geometric(const BivectorBulk& b) const noexcept;
        [[nodiscard]] constexpr Motor geometric(const BivectorWeight& b) const noexcept;
        [[nodiscard]] constexpr BivectorWeight geometric(const PseudoScalar& b) const noexcept;
        [[nodiscard]] constexpr PlaneIdeal geometric(const PointCenter& b) const noexcept;

        [[nodiscard]] constexpr Motor dot(const Motor& b) const noexcept;
        [[nodiscard]] constexpr PlaneIdeal dot(const Plane& b) const noexcept;
        [[nodiscard]] constexpr double dot(const Bivector& b) const noexcept;
        [[nodiscard]] constexpr Plane dot(const ProjectivePoint& b) const noexcept;
        [[nodiscard]] constexpr Quaternion dot(const Quaternion& b) const noexcept;
        [[nodiscard]] constexpr BivectorBulk dot(const Translator& b) const noexcept;
        [[nodiscard]] constexpr Plane dot(const Vector& b) const noexcept;
        [[nodiscard]] constexpr Plane dot(const Point& b) const noexcept;
        [[nodiscard]] constexpr PlaneIdeal dot(const PlaneIdeal& b) const noexcept;
        [[nodiscard]] constexpr double dot(const BivectorBulk& b) const noexcept;
        [[nodiscard]] constexpr BivectorWeight dot(const PseudoScalar& b) const noexcept;
        [[nodiscard]] constexpr PlaneIdeal dot(const PointCenter& b) const noexcept;

        [[nodiscard]] constexpr Multivector toMultivector() const noexcept;
        [[nodiscard]] constexpr Motor toMotor() const noexcept;
        [[nodiscard]] constexpr Bivector toBivector() const noexcept;
        [[nodiscard]] constexpr Quaternion toQuaternion() const noexcept;

        [[nodiscard]] constexpr BivectorBulk madd(const BivectorBulk& other, double mult) const noexcept;

        [[nodiscard]] constexpr double normSquare() const noexcept;
        [[nodiscard]] double norm() const noexcept;
        [[nodiscard]] BivectorBulk normalizedByNorm() const noexcept;
        [[nodiscard]] constexpr double bulkNormSquare() const noexcept;
        [[nodiscard]] double bulkNorm() const noexcept;
        [[nodiscard]] BivectorBulk normalizedByBulk() const noexcept;
    };

    static_assert(std::is_trivially_copyable_v<BivectorBulk>);
    static_assert(sizeof(BivectorBulk) == 8 * 3, "ProjectivePoint must be exactly 24 bytes");
}