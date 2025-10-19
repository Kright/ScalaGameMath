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

        [[nodiscard]] constexpr Motor geometric(const Motor& b) const noexcept;
        [[nodiscard]] constexpr Multivector geometric(const Plane& b) const noexcept;
        [[nodiscard]] constexpr Motor geometric(const Bivector& b) const noexcept;
        [[nodiscard]] constexpr ProjectivePoint geometric(const ProjectivePoint& b) const noexcept;
        [[nodiscard]] constexpr Motor geometric(const Quaternion& b) const noexcept;
        [[nodiscard]] constexpr Translator geometric(const Translator& b) const noexcept;
        [[nodiscard]] constexpr Vector geometric(const Vector& b) const noexcept;
        [[nodiscard]] constexpr Point geometric(const Point& b) const noexcept;
        [[nodiscard]] constexpr Multivector geometric(const PlaneIdeal& b) const noexcept;
        [[nodiscard]] constexpr Motor geometric(const BivectorBulk& b) const noexcept;
        [[nodiscard]] constexpr BivectorWeight geometric(const BivectorWeight& b) const noexcept;
        [[nodiscard]] constexpr PseudoScalar geometric(const PseudoScalar& b) const noexcept;
        [[nodiscard]] constexpr Point geometric(const PointCenter& b) const noexcept;

        [[nodiscard]] constexpr Motor wedge(const Motor& b) const noexcept;
        [[nodiscard]] constexpr Multivector wedge(const Plane& b) const noexcept;
        [[nodiscard]] constexpr Motor wedge(const Bivector& b) const noexcept;
        [[nodiscard]] constexpr ProjectivePoint wedge(const ProjectivePoint& b) const noexcept;
        [[nodiscard]] constexpr Motor wedge(const Quaternion& b) const noexcept;
        [[nodiscard]] constexpr Translator wedge(const Translator& b) const noexcept;
        [[nodiscard]] constexpr Vector wedge(const Vector& b) const noexcept;
        [[nodiscard]] constexpr Point wedge(const Point& b) const noexcept;
        [[nodiscard]] constexpr Multivector wedge(const PlaneIdeal& b) const noexcept;
        [[nodiscard]] constexpr Motor wedge(const BivectorBulk& b) const noexcept;
        [[nodiscard]] constexpr BivectorWeight wedge(const BivectorWeight& b) const noexcept;
        [[nodiscard]] constexpr PseudoScalar wedge(const PseudoScalar& b) const noexcept;
        [[nodiscard]] constexpr PointCenter wedge(const PointCenter& b) const noexcept;

        [[nodiscard]] constexpr Motor dot(const Motor& b) const noexcept;
        [[nodiscard]] constexpr Plane dot(const Plane& b) const noexcept;
        [[nodiscard]] constexpr Bivector dot(const Bivector& b) const noexcept;
        [[nodiscard]] constexpr ProjectivePoint dot(const ProjectivePoint& b) const noexcept;
        [[nodiscard]] constexpr Motor dot(const Quaternion& b) const noexcept;
        [[nodiscard]] constexpr Translator dot(const Translator& b) const noexcept;
        [[nodiscard]] constexpr Vector dot(const Vector& b) const noexcept;
        [[nodiscard]] constexpr Point dot(const Point& b) const noexcept;
        [[nodiscard]] constexpr Plane dot(const PlaneIdeal& b) const noexcept;
        [[nodiscard]] constexpr BivectorBulk dot(const BivectorBulk& b) const noexcept;
        [[nodiscard]] constexpr BivectorWeight dot(const BivectorWeight& b) const noexcept;
        [[nodiscard]] constexpr PseudoScalar dot(const PseudoScalar& b) const noexcept;
        [[nodiscard]] constexpr PointCenter dot(const PointCenter& b) const noexcept;

        [[nodiscard]] constexpr Motor antiGeometric(const Motor& b) const noexcept;
        [[nodiscard]] constexpr Multivector antiGeometric(const Plane& b) const noexcept;
        [[nodiscard]] constexpr Motor antiGeometric(const Bivector& b) const noexcept;
        [[nodiscard]] constexpr Multivector antiGeometric(const ProjectivePoint& b) const noexcept;
        [[nodiscard]] constexpr Quaternion antiGeometric(const Quaternion& b) const noexcept;
        [[nodiscard]] constexpr Motor antiGeometric(const Translator& b) const noexcept;
        [[nodiscard]] constexpr Multivector antiGeometric(const Vector& b) const noexcept;
        [[nodiscard]] constexpr Multivector antiGeometric(const Point& b) const noexcept;
        [[nodiscard]] constexpr Multivector antiGeometric(const PlaneIdeal& b) const noexcept;
        [[nodiscard]] constexpr Quaternion antiGeometric(const BivectorBulk& b) const noexcept;
        [[nodiscard]] constexpr Motor antiGeometric(const BivectorWeight& b) const noexcept;
        [[nodiscard]] constexpr Motor antiGeometric(const PseudoScalar& b) const noexcept;
        [[nodiscard]] constexpr PlaneIdeal antiGeometric(const PointCenter& b) const noexcept;

        [[nodiscard]] constexpr Motor antiWedge(const Motor& b) const noexcept;
        [[nodiscard]] constexpr double antiWedge(const Bivector& b) const noexcept;
        [[nodiscard]] constexpr Plane antiWedge(const ProjectivePoint& b) const noexcept;
        [[nodiscard]] constexpr double antiWedge(const Quaternion& b) const noexcept;
        [[nodiscard]] constexpr Plane antiWedge(const Vector& b) const noexcept;
        [[nodiscard]] constexpr Plane antiWedge(const Point& b) const noexcept;
        [[nodiscard]] constexpr double antiWedge(const BivectorBulk& b) const noexcept;
        [[nodiscard]] constexpr Motor antiWedge(const PseudoScalar& b) const noexcept;
        [[nodiscard]] constexpr PlaneIdeal antiWedge(const PointCenter& b) const noexcept;

        [[nodiscard]] constexpr Motor antiDot(const Motor& b) const noexcept;
        [[nodiscard]] constexpr ProjectivePoint antiDot(const Plane& b) const noexcept;
        [[nodiscard]] constexpr Motor antiDot(const Bivector& b) const noexcept;
        [[nodiscard]] constexpr Multivector antiDot(const ProjectivePoint& b) const noexcept;
        [[nodiscard]] constexpr BivectorBulk antiDot(const Quaternion& b) const noexcept;
        [[nodiscard]] constexpr Motor antiDot(const Translator& b) const noexcept;
        [[nodiscard]] constexpr Multivector antiDot(const Vector& b) const noexcept;
        [[nodiscard]] constexpr Multivector antiDot(const Point& b) const noexcept;
        [[nodiscard]] constexpr ProjectivePoint antiDot(const PlaneIdeal& b) const noexcept;
        [[nodiscard]] constexpr Motor antiDot(const BivectorWeight& b) const noexcept;
        [[nodiscard]] constexpr Motor antiDot(const PseudoScalar& b) const noexcept;

        [[nodiscard]] constexpr Multivector toMultivector() const noexcept;
        [[nodiscard]] constexpr Motor toMotor() const noexcept;
        [[nodiscard]] constexpr Bivector toBivectorUnsafe() const noexcept;
        [[nodiscard]] constexpr Quaternion toQuaternionUnsafe() const noexcept;
        [[nodiscard]] constexpr BivectorWeight toBivectorWeightUnsafe() const noexcept;

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

    static_assert(std::is_trivially_copyable_v<Translator>);
    static_assert(sizeof(Translator) == 8 * 3, "ProjectivePoint must be exactly 24 bytes");
}