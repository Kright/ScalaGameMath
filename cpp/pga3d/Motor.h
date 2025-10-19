#pragma once

#include <type_traits>
#include "types_forward.h"

// This code is generated, see com.github.kright.pga3d.codegen.cpp.CppCodeGen

namespace pga3d {
    struct Motor {
        double s = 0.0;
        double wx = 0.0;
        double wy = 0.0;
        double wz = 0.0;
        double xy = 0.0;
        double xz = 0.0;
        double yz = 0.0;
        double i = 0.0;

        static constexpr int componentsCount = 8;

        [[nodiscard]] static constexpr Motor id() noexcept { return {.s = 1.0}; }

        [[nodiscard]] constexpr Motor dual() const noexcept;

        [[nodiscard]] constexpr Motor weight() const noexcept;

        [[nodiscard]] constexpr Quaternion bulk() const noexcept;

        [[nodiscard]] constexpr Motor reverse() const noexcept;

        [[nodiscard]] constexpr Motor antiReverse() const noexcept;

        [[nodiscard]] constexpr Motor geometric(const Motor& b) const noexcept;
        [[nodiscard]] constexpr Multivector geometric(const Plane& b) const noexcept;
        [[nodiscard]] constexpr Motor geometric(const Bivector& b) const noexcept;
        [[nodiscard]] constexpr Multivector geometric(const ProjectivePoint& b) const noexcept;
        [[nodiscard]] constexpr Motor geometric(const Quaternion& b) const noexcept;
        [[nodiscard]] constexpr Motor geometric(const Translator& b) const noexcept;
        [[nodiscard]] constexpr Multivector geometric(const Vector& b) const noexcept;
        [[nodiscard]] constexpr Multivector geometric(const Point& b) const noexcept;
        [[nodiscard]] constexpr Multivector geometric(const PlaneIdeal& b) const noexcept;
        [[nodiscard]] constexpr Motor geometric(const BivectorBulk& b) const noexcept;
        [[nodiscard]] constexpr Motor geometric(const BivectorWeight& b) const noexcept;
        [[nodiscard]] constexpr Motor geometric(const PseudoScalar& b) const noexcept;
        [[nodiscard]] constexpr Multivector geometric(const PointCenter& b) const noexcept;

        [[nodiscard]] constexpr Motor dot(const Motor& b) const noexcept;
        [[nodiscard]] constexpr Multivector dot(const Plane& b) const noexcept;
        [[nodiscard]] constexpr Motor dot(const Bivector& b) const noexcept;
        [[nodiscard]] constexpr Multivector dot(const ProjectivePoint& b) const noexcept;
        [[nodiscard]] constexpr Motor dot(const Quaternion& b) const noexcept;
        [[nodiscard]] constexpr Motor dot(const Translator& b) const noexcept;
        [[nodiscard]] constexpr Multivector dot(const Vector& b) const noexcept;
        [[nodiscard]] constexpr Multivector dot(const Point& b) const noexcept;
        [[nodiscard]] constexpr Multivector dot(const PlaneIdeal& b) const noexcept;
        [[nodiscard]] constexpr Motor dot(const BivectorBulk& b) const noexcept;
        [[nodiscard]] constexpr BivectorWeight dot(const BivectorWeight& b) const noexcept;
        [[nodiscard]] constexpr Motor dot(const PseudoScalar& b) const noexcept;
        [[nodiscard]] constexpr Multivector dot(const PointCenter& b) const noexcept;

        [[nodiscard]] constexpr Multivector toMultivector() const noexcept;
        [[nodiscard]] constexpr Bivector toBivectorUnsafe() const noexcept;
        [[nodiscard]] constexpr Quaternion toQuaternionUnsafe() const noexcept;
        [[nodiscard]] constexpr Translator toTranslatorUnsafe() const noexcept;
        [[nodiscard]] constexpr BivectorBulk toBivectorBulkUnsafe() const noexcept;
        [[nodiscard]] constexpr BivectorWeight toBivectorWeightUnsafe() const noexcept;

        [[nodiscard]] constexpr Motor madd(const Motor& other, double mult) const noexcept;

        [[nodiscard]] constexpr double normSquare() const noexcept;
        [[nodiscard]] double norm() const noexcept;
        [[nodiscard]] Motor normalizedByNorm() const noexcept;
        [[nodiscard]] constexpr double bulkNormSquare() const noexcept;
        [[nodiscard]] double bulkNorm() const noexcept;
        [[nodiscard]] Motor normalizedByBulk() const noexcept;
        [[nodiscard]] constexpr double weightNormSquare() const noexcept;
        [[nodiscard]] double weightNorm() const noexcept;
        [[nodiscard]] Motor normalizedByWeight() const noexcept;
    };

    static_assert(std::is_trivially_copyable_v<Motor>);
    static_assert(sizeof(Motor) == 8 * 8, "ProjectivePoint must be exactly 64 bytes");
}