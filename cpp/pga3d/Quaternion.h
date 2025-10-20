#pragma once

#include <type_traits>
#include "types_forward.h"

// This code is generated, see com.github.kright.pga3d.codegen.cpp.CppCodeGen

namespace pga3d {
    struct Quaternion {
        double s = 0.0;
        double xy = 0.0;
        double xz = 0.0;
        double yz = 0.0;

        static constexpr int componentsCount = 4;

        [[nodiscard]] static constexpr Quaternion id() noexcept { return {.s = 1.0}; }

        [[nodiscard]] static inline Quaternion rotation(const Vector& from, const Vector& to) noexcept;
        [[nodiscard]] static inline Quaternion rotation(const PlaneIdeal& from, const PlaneIdeal& to) noexcept;

        [[nodiscard]] inline BivectorBulk log() const noexcept;

        [[nodiscard]] constexpr Motor dual() const noexcept;

        [[nodiscard]] constexpr Quaternion bulk() const noexcept;

        [[nodiscard]] constexpr Quaternion reverse() const noexcept;

        [[nodiscard]] constexpr Quaternion antiReverse() const noexcept;

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
        [[nodiscard]] constexpr Motor geometric(const PseudoScalar& b) const noexcept;
        [[nodiscard]] constexpr Multivector geometric(const PointCenter& b) const noexcept;

        [[nodiscard]] constexpr Motor wedge(const Motor& b) const noexcept;
        [[nodiscard]] constexpr Multivector wedge(const Plane& b) const noexcept;
        [[nodiscard]] constexpr Motor wedge(const Bivector& b) const noexcept;
        [[nodiscard]] constexpr ProjectivePoint wedge(const ProjectivePoint& b) const noexcept;
        [[nodiscard]] constexpr Quaternion wedge(const Quaternion& b) const noexcept;
        [[nodiscard]] constexpr Motor wedge(const Translator& b) const noexcept;
        [[nodiscard]] constexpr Vector wedge(const Vector& b) const noexcept;
        [[nodiscard]] constexpr ProjectivePoint wedge(const Point& b) const noexcept;
        [[nodiscard]] constexpr Multivector wedge(const PlaneIdeal& b) const noexcept;
        [[nodiscard]] constexpr BivectorBulk wedge(const BivectorBulk& b) const noexcept;
        [[nodiscard]] constexpr Motor wedge(const BivectorWeight& b) const noexcept;
        [[nodiscard]] constexpr PseudoScalar wedge(const PseudoScalar& b) const noexcept;
        [[nodiscard]] constexpr ProjectivePoint wedge(const PointCenter& b) const noexcept;

        [[nodiscard]] constexpr Motor dot(const Motor& b) const noexcept;
        [[nodiscard]] constexpr Plane dot(const Plane& b) const noexcept;
        [[nodiscard]] constexpr Motor dot(const Bivector& b) const noexcept;
        [[nodiscard]] constexpr Multivector dot(const ProjectivePoint& b) const noexcept;
        [[nodiscard]] constexpr Quaternion dot(const Quaternion& b) const noexcept;
        [[nodiscard]] constexpr Motor dot(const Translator& b) const noexcept;
        [[nodiscard]] constexpr Multivector dot(const Vector& b) const noexcept;
        [[nodiscard]] constexpr Multivector dot(const Point& b) const noexcept;
        [[nodiscard]] constexpr PlaneIdeal dot(const PlaneIdeal& b) const noexcept;
        [[nodiscard]] constexpr Quaternion dot(const BivectorBulk& b) const noexcept;
        [[nodiscard]] constexpr BivectorWeight dot(const BivectorWeight& b) const noexcept;
        [[nodiscard]] constexpr Motor dot(const PseudoScalar& b) const noexcept;
        [[nodiscard]] constexpr Multivector dot(const PointCenter& b) const noexcept;

        [[nodiscard]] constexpr Quaternion antiGeometric(const Motor& b) const noexcept;
        [[nodiscard]] constexpr Multivector antiGeometric(const Plane& b) const noexcept;
        [[nodiscard]] constexpr Quaternion antiGeometric(const Bivector& b) const noexcept;
        [[nodiscard]] constexpr Multivector antiGeometric(const ProjectivePoint& b) const noexcept;
        [[nodiscard]] constexpr Quaternion antiGeometric(const Translator& b) const noexcept;
        [[nodiscard]] constexpr Multivector antiGeometric(const Vector& b) const noexcept;
        [[nodiscard]] constexpr Multivector antiGeometric(const Point& b) const noexcept;
        [[nodiscard]] constexpr Quaternion antiGeometric(const BivectorWeight& b) const noexcept;
        [[nodiscard]] constexpr Quaternion antiGeometric(const PseudoScalar& b) const noexcept;

        [[nodiscard]] constexpr Quaternion antiWedge(const Motor& b) const noexcept;
        [[nodiscard]] constexpr double antiWedge(const Bivector& b) const noexcept;
        [[nodiscard]] constexpr PlaneIdeal antiWedge(const ProjectivePoint& b) const noexcept;
        [[nodiscard]] constexpr double antiWedge(const Translator& b) const noexcept;
        [[nodiscard]] constexpr PlaneIdeal antiWedge(const Vector& b) const noexcept;
        [[nodiscard]] constexpr PlaneIdeal antiWedge(const Point& b) const noexcept;
        [[nodiscard]] constexpr double antiWedge(const BivectorWeight& b) const noexcept;
        [[nodiscard]] constexpr Quaternion antiWedge(const PseudoScalar& b) const noexcept;

        [[nodiscard]] constexpr Quaternion antiDot(const Motor& b) const noexcept;
        [[nodiscard]] constexpr ProjectivePoint antiDot(const Plane& b) const noexcept;
        [[nodiscard]] constexpr BivectorBulk antiDot(const Bivector& b) const noexcept;
        [[nodiscard]] constexpr Multivector antiDot(const ProjectivePoint& b) const noexcept;
        [[nodiscard]] constexpr BivectorBulk antiDot(const Translator& b) const noexcept;
        [[nodiscard]] constexpr Multivector antiDot(const Vector& b) const noexcept;
        [[nodiscard]] constexpr Multivector antiDot(const Point& b) const noexcept;
        [[nodiscard]] constexpr BivectorBulk antiDot(const BivectorWeight& b) const noexcept;
        [[nodiscard]] constexpr Quaternion antiDot(const PseudoScalar& b) const noexcept;

        [[nodiscard]] constexpr Motor sandwich(const Motor& b) const noexcept;
        [[nodiscard]] constexpr Plane sandwich(const Plane& b) const noexcept;
        [[nodiscard]] constexpr Bivector sandwich(const Bivector& b) const noexcept;
        [[nodiscard]] constexpr ProjectivePoint sandwich(const ProjectivePoint& b) const noexcept;
        [[nodiscard]] constexpr Quaternion sandwich(const Quaternion& b) const noexcept;
        [[nodiscard]] constexpr Motor sandwich(const Translator& b) const noexcept;
        [[nodiscard]] constexpr Vector sandwich(const Vector& b) const noexcept;
        [[nodiscard]] constexpr ProjectivePoint sandwich(const Point& b) const noexcept;
        [[nodiscard]] constexpr PlaneIdeal sandwich(const PlaneIdeal& b) const noexcept;
        [[nodiscard]] constexpr BivectorBulk sandwich(const BivectorBulk& b) const noexcept;
        [[nodiscard]] constexpr BivectorWeight sandwich(const BivectorWeight& b) const noexcept;
        [[nodiscard]] constexpr PseudoScalar sandwich(const PseudoScalar& b) const noexcept;
        [[nodiscard]] constexpr ProjectivePoint sandwich(const PointCenter& b) const noexcept;

        [[nodiscard]] constexpr Motor reverseSandwich(const Motor& b) const noexcept;
        [[nodiscard]] constexpr Plane reverseSandwich(const Plane& b) const noexcept;
        [[nodiscard]] constexpr Bivector reverseSandwich(const Bivector& b) const noexcept;
        [[nodiscard]] constexpr ProjectivePoint reverseSandwich(const ProjectivePoint& b) const noexcept;
        [[nodiscard]] constexpr Quaternion reverseSandwich(const Quaternion& b) const noexcept;
        [[nodiscard]] constexpr Motor reverseSandwich(const Translator& b) const noexcept;
        [[nodiscard]] constexpr Vector reverseSandwich(const Vector& b) const noexcept;
        [[nodiscard]] constexpr ProjectivePoint reverseSandwich(const Point& b) const noexcept;
        [[nodiscard]] constexpr PlaneIdeal reverseSandwich(const PlaneIdeal& b) const noexcept;
        [[nodiscard]] constexpr BivectorBulk reverseSandwich(const BivectorBulk& b) const noexcept;
        [[nodiscard]] constexpr BivectorWeight reverseSandwich(const BivectorWeight& b) const noexcept;
        [[nodiscard]] constexpr PseudoScalar reverseSandwich(const PseudoScalar& b) const noexcept;
        [[nodiscard]] constexpr ProjectivePoint reverseSandwich(const PointCenter& b) const noexcept;

        [[nodiscard]] constexpr Bivector cross(const Motor& b) const noexcept;
        [[nodiscard]] constexpr PlaneIdeal cross(const Plane& b) const noexcept;
        [[nodiscard]] constexpr Bivector cross(const Bivector& b) const noexcept;
        [[nodiscard]] constexpr Vector cross(const ProjectivePoint& b) const noexcept;
        [[nodiscard]] constexpr BivectorBulk cross(const Quaternion& b) const noexcept;
        [[nodiscard]] constexpr BivectorWeight cross(const Translator& b) const noexcept;
        [[nodiscard]] constexpr Vector cross(const Vector& b) const noexcept;
        [[nodiscard]] constexpr Vector cross(const Point& b) const noexcept;
        [[nodiscard]] constexpr PlaneIdeal cross(const PlaneIdeal& b) const noexcept;
        [[nodiscard]] constexpr BivectorBulk cross(const BivectorBulk& b) const noexcept;
        [[nodiscard]] constexpr BivectorWeight cross(const BivectorWeight& b) const noexcept;

        [[nodiscard]] constexpr Multivector toMultivector() const noexcept;
        [[nodiscard]] constexpr Motor toMotor() const noexcept;
        [[nodiscard]] constexpr Bivector toBivectorUnsafe() const noexcept;
        [[nodiscard]] constexpr BivectorBulk toBivectorBulkUnsafe() const noexcept;

        [[nodiscard]] constexpr Quaternion madd(const Quaternion& other, double mult) const noexcept;

        [[nodiscard]] constexpr double normSquare() const noexcept;
        [[nodiscard]] inline double norm() const noexcept;
        [[nodiscard]] inline Quaternion normalizedByNorm() const noexcept;
        [[nodiscard]] constexpr double bulkNormSquare() const noexcept;
        [[nodiscard]] inline double bulkNorm() const noexcept;
        [[nodiscard]] inline Quaternion normalizedByBulk() const noexcept;
    };

    static_assert(std::is_trivially_copyable_v<Quaternion>);
    static_assert(sizeof(Quaternion) == 8 * Quaternion::componentsCount, "Quaternion must be exactly 32 bytes");
}