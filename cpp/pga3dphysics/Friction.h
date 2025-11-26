// Copyright (c) 2025 Igor Slobodskov
// SPDX-License-Identifier: MIT

#pragma once

#include <algorithm>

#include "BodyPoint.h"
#include "pga3d/Vector.h"
#include "Sphere.h"
#include "Forque.h"

namespace pga3d {
    struct VelocityFriction {
        double linearK = 0.0;
        double quadraticK = 0.0;
        double maxForce = 0.0;

        [[nodiscard]] constexpr bool isZero() const noexcept {
            return maxForce == 0.0;
        }

        [[nodiscard]] constexpr double operator()(double velocity) const noexcept {
            const double sign = velocity > 0.0 ? 1.0 : -1.0;
            const double f = velocity * ( -linearK - velocity * quadraticK * sign);
            return std::clamp(f, -maxForce, maxForce);
        }

        [[nodiscard]] Vector operator()(const Vector& velocity) const noexcept {
            const Vector f = velocity * (-linearK - quadraticK * velocity.norm());
            return f.clamp(
                {-maxForce, -maxForce, -maxForce},
                {maxForce, maxForce, maxForce}
            );
        }

        [[nodiscard]] constexpr static VelocityFriction linear(const double k, const double maxForce) noexcept {
            return {k, 0.0, maxForce};
        }

        [[nodiscard]] constexpr static VelocityFriction quadratic(const double k2, const double maxForce) noexcept {
            return {0.0, k2, maxForce};
        }

        [[nodiscard]] constexpr static VelocityFriction constant(const double maxForce, const double minVelocity) noexcept {
            return {maxForce / minVelocity, 0.0, maxForce};
        }
    };


    struct PositionFrictionStiffness {
        double linearK = 0.0;
        double maxDelta = 0.0;

        [[nodiscard]] constexpr double getMaxForce() const noexcept {
            return maxDelta * linearK;
        }

        constexpr void setMaxForce(const double maxForce, const double newMaxDelta) noexcept {
            linearK = maxForce / newMaxDelta;
            maxDelta = newMaxDelta;
        }

        [[nodiscard]] constexpr bool isZero() const noexcept {
            return linearK == 0.0;
        }

        [[nodiscard]] constexpr static PositionFrictionStiffness create(const double maxForce, const double maxDetla) noexcept {
            return {
                .linearK = maxForce / maxDetla,
                .maxDelta = maxDetla,
            };
        }
    };


    struct Position1dFriction {
        PositionFrictionStiffness stiffness;
        double boundPosition = 0.0;

        [[nodiscard]] constexpr double getMaxForce() const noexcept {
            return stiffness.getMaxForce();
        }

        constexpr void setMaxForce(const double maxForce, const double newMaxDelta) noexcept {
            stiffness.setMaxForce(maxForce, newMaxDelta);
        }

        [[nodiscard]] constexpr bool isZero() const noexcept {
            return stiffness.isZero();
        }

        [[nodiscard]] constexpr double operator()(const double position) const noexcept {
            return std::clamp(boundPosition - position, -stiffness.maxDelta, stiffness.maxDelta) * stiffness.linearK;
        }

        constexpr void correctBoundPosition(const double position) noexcept {
            boundPosition = std::clamp(boundPosition, position - stiffness.maxDelta, position + stiffness.maxDelta);
        }

        [[nodiscard]] constexpr static Position1dFriction create(const double maxForce, const double maxDelta) noexcept {
            return {
                .stiffness = PositionFrictionStiffness::create(maxForce, maxDelta),
                .boundPosition = 0.0
            };
        }
    };


    struct Position3dFriction {
        PositionFrictionStiffness stiffness;
        Point boundPosition = {}; // in local coords
        [[nodiscard]] constexpr double getMaxForce() const noexcept {
            return stiffness.getMaxForce();
        }

        constexpr void setMaxForce(const double maxForce, const double newMaxDelta) noexcept {
            stiffness.setMaxForce(maxForce, newMaxDelta);
        }

        [[nodiscard]] constexpr bool isZero() const noexcept {
            return stiffness.isZero();
        }

        constexpr void correctBoundPosition(const Point& position) noexcept {
            boundPosition = Sphere{position, stiffness.maxDelta}.clamp(boundPosition);
        }

        [[nodiscard]] constexpr static Position3dFriction create(const double maxForce, const double maxDelta) noexcept {
            return {
                .stiffness = PositionFrictionStiffness::create(maxForce, maxDelta),
                .boundPosition = {}
            };
        }

        [[nodiscard]] static Bivector getForque(const PositionFrictionStiffness& stiffness,
                                                const Point& newPosition,
                                                const Point& globalBoundPosition) noexcept {
            const Vector targetShift = Sphere{newPosition, stiffness.maxDelta}.clampDR(globalBoundPosition);
            return Forque::force(newPosition, targetShift * stiffness.linearK);
        }
    };


    struct Point3dFriction {
        Position3dFriction positionFriction = {};
        VelocityFriction velocityFriction = {};
        BodyPoint first = {};
        PhysicsBody* second = nullptr;

        [[nodiscard]] Bivector getForque() const {
            const Point firstPos = first.globalPos();
            const Point secondPos = second->localPosToGlobal(positionFriction.boundPosition);

            const Vector firstVelocity = first.globalPosVelocity();
            const Vector secondVelocity = second->globalVelocityForLocalPos(positionFriction.boundPosition);

            return
                Position3dFriction::getForque(positionFriction.stiffness, firstPos, secondPos) +
                Forque::force(firstPos, velocityFriction(firstVelocity - secondVelocity));
        }

        void addForque() const {
            first.body->addGlobalForquePaired(getForque(), *second);
        }

        void afterStep() {
            const Point firstPointInSecond = second->globalPosToLocal(first.globalPos());
            positionFriction.correctBoundPosition(firstPointInSecond);
        }
    };
}
