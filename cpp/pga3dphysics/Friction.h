// Copyright (c) 2025 Igor Slobodskov
// SPDX-License-Identifier: MIT

#pragma once

#include <algorithm>

#include "pga3d/Vector.h"
#include "Forque.h"

namespace pga3dphysics {
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


    struct PositionFriction {
        double linearK = 0.0;
        double maxDelta = 0.0;
        double boundPosition = 0.0;

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

        [[nodiscard]] constexpr double operator()(const double position) const noexcept {
            return std::clamp(boundPosition - position, -maxDelta, maxDelta) * linearK;
        }

        constexpr void correctBoundPosition(const double position) noexcept {
            boundPosition = std::clamp(boundPosition, position - maxDelta, position + maxDelta);
        }

        [[nodiscard]] constexpr static PositionFriction create(const double maxForce, const double maxDetla) noexcept {
            return {
                .linearK = maxForce / maxDetla,
                .maxDelta = maxDetla,
                .boundPosition = 0.0
            };
        }
    };
}

