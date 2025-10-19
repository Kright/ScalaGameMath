#pragma once

#include <type_traits>
#include "types_forward.h"

// This code is generated, see com.github.kright.pga3d.codegen.cpp.CppCodeGen

namespace pga3d {
    struct Bivector {
        double wx = 0.0;
        double wy = 0.0;
        double wz = 0.0;
        double xy = 0.0;
        double xz = 0.0;
        double yz = 0.0;

        static constexpr int componentsCount = 6;

        [[nodiscard]] constexpr Bivector dual() const noexcept;

        [[nodiscard]] constexpr BivectorWeight weight() const noexcept;

        [[nodiscard]] constexpr BivectorBulk bulk() const noexcept;

        [[nodiscard]] constexpr Bivector reverse() const noexcept;

        [[nodiscard]] constexpr Bivector antiReverse() const noexcept;

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
        [[nodiscard]] constexpr BivectorWeight geometric(const PseudoScalar& b) const noexcept;
        [[nodiscard]] constexpr Multivector geometric(const PointCenter& b) const noexcept;

        [[nodiscard]] constexpr Motor wedge(const Motor& b) const noexcept;
        [[nodiscard]] constexpr ProjectivePoint wedge(const Plane& b) const noexcept;
        [[nodiscard]] constexpr PseudoScalar wedge(const Bivector& b) const noexcept;
        [[nodiscard]] constexpr Motor wedge(const Quaternion& b) const noexcept;
        [[nodiscard]] constexpr Motor wedge(const Translator& b) const noexcept;
        [[nodiscard]] constexpr ProjectivePoint wedge(const PlaneIdeal& b) const noexcept;
        [[nodiscard]] constexpr PseudoScalar wedge(const BivectorBulk& b) const noexcept;
        [[nodiscard]] constexpr PseudoScalar wedge(const BivectorWeight& b) const noexcept;

        [[nodiscard]] constexpr Motor dot(const Motor& b) const noexcept;
        [[nodiscard]] constexpr Plane dot(const Plane& b) const noexcept;
        [[nodiscard]] constexpr double dot(const Bivector& b) const noexcept;
        [[nodiscard]] constexpr Plane dot(const ProjectivePoint& b) const noexcept;
        [[nodiscard]] constexpr Motor dot(const Quaternion& b) const noexcept;
        [[nodiscard]] constexpr Bivector dot(const Translator& b) const noexcept;
        [[nodiscard]] constexpr Plane dot(const Vector& b) const noexcept;
        [[nodiscard]] constexpr Plane dot(const Point& b) const noexcept;
        [[nodiscard]] constexpr Plane dot(const PlaneIdeal& b) const noexcept;
        [[nodiscard]] constexpr double dot(const BivectorBulk& b) const noexcept;
        [[nodiscard]] constexpr BivectorWeight dot(const PseudoScalar& b) const noexcept;
        [[nodiscard]] constexpr PlaneIdeal dot(const PointCenter& b) const noexcept;

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
        [[nodiscard]] constexpr Bivector antiGeometric(const PseudoScalar& b) const noexcept;
        [[nodiscard]] constexpr PlaneIdeal antiGeometric(const PointCenter& b) const noexcept;

        [[nodiscard]] constexpr Motor antiWedge(const Motor& b) const noexcept;
        [[nodiscard]] constexpr double antiWedge(const Bivector& b) const noexcept;
        [[nodiscard]] constexpr Plane antiWedge(const ProjectivePoint& b) const noexcept;
        [[nodiscard]] constexpr double antiWedge(const Quaternion& b) const noexcept;
        [[nodiscard]] constexpr double antiWedge(const Translator& b) const noexcept;
        [[nodiscard]] constexpr Plane antiWedge(const Vector& b) const noexcept;
        [[nodiscard]] constexpr Plane antiWedge(const Point& b) const noexcept;
        [[nodiscard]] constexpr double antiWedge(const BivectorBulk& b) const noexcept;
        [[nodiscard]] constexpr double antiWedge(const BivectorWeight& b) const noexcept;
        [[nodiscard]] constexpr Bivector antiWedge(const PseudoScalar& b) const noexcept;
        [[nodiscard]] constexpr PlaneIdeal antiWedge(const PointCenter& b) const noexcept;

        [[nodiscard]] constexpr Motor antiDot(const Motor& b) const noexcept;
        [[nodiscard]] constexpr ProjectivePoint antiDot(const Plane& b) const noexcept;
        [[nodiscard]] constexpr PseudoScalar antiDot(const Bivector& b) const noexcept;
        [[nodiscard]] constexpr ProjectivePoint antiDot(const ProjectivePoint& b) const noexcept;
        [[nodiscard]] constexpr BivectorBulk antiDot(const Quaternion& b) const noexcept;
        [[nodiscard]] constexpr Motor antiDot(const Translator& b) const noexcept;
        [[nodiscard]] constexpr ProjectivePoint antiDot(const Vector& b) const noexcept;
        [[nodiscard]] constexpr ProjectivePoint antiDot(const Point& b) const noexcept;
        [[nodiscard]] constexpr ProjectivePoint antiDot(const PlaneIdeal& b) const noexcept;
        [[nodiscard]] constexpr PseudoScalar antiDot(const BivectorWeight& b) const noexcept;
        [[nodiscard]] constexpr Bivector antiDot(const PseudoScalar& b) const noexcept;

        [[nodiscard]] constexpr Multivector toMultivector() const noexcept;
        [[nodiscard]] constexpr Motor toMotor() const noexcept;
        [[nodiscard]] constexpr Quaternion toQuaternionUnsafe() const noexcept;
        [[nodiscard]] constexpr Translator toTranslatorUnsafe() const noexcept;
        [[nodiscard]] constexpr BivectorBulk toBivectorBulkUnsafe() const noexcept;
        [[nodiscard]] constexpr BivectorWeight toBivectorWeightUnsafe() const noexcept;

        [[nodiscard]] constexpr Bivector madd(const Bivector& other, double mult) const noexcept;

        [[nodiscard]] constexpr double normSquare() const noexcept;
        [[nodiscard]] double norm() const noexcept;
        [[nodiscard]] Bivector normalizedByNorm() const noexcept;
        [[nodiscard]] constexpr double bulkNormSquare() const noexcept;
        [[nodiscard]] double bulkNorm() const noexcept;
        [[nodiscard]] Bivector normalizedByBulk() const noexcept;
        [[nodiscard]] constexpr double weightNormSquare() const noexcept;
        [[nodiscard]] double weightNorm() const noexcept;
        [[nodiscard]] Bivector normalizedByWeight() const noexcept;
    };

    static_assert(std::is_trivially_copyable_v<Bivector>);
    static_assert(sizeof(Bivector) == 8 * 6, "ProjectivePoint must be exactly 48 bytes");
}