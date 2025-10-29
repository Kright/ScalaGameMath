#pragma once

#include <algorithm>

#include "Forque.h"
#include "pga3d/Vector.h"
//
// Created by lgor on 10/29/25.
//

namespace pga3dphysics {
    struct Friction {
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

        [[nodiscard]] constexpr static Friction zero() noexcept {
            return {0.0, 0.0, 0.0};
        }

        [[nodiscard]] constexpr static Friction linear(double k, double maxForce) noexcept {
            return {k, 0.0, maxForce};
        }

        [[nodiscard]] constexpr static Friction quadratic(double k2, double maxForce) noexcept {
            return {0.0, k2, maxForce};
        }

        [[nodiscard]] constexpr static Friction constant(double maxForce, double minVelocity) noexcept {
            return {maxForce / minVelocity, 0.0, maxForce};
        }
    };
}

