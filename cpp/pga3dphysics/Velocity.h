// Copyright (c) 2025 Igor Slobodskov
// SPDX-License-Identifier: MIT

#pragma once

#include "pga3d/Point.h"
#include "pga3d/Vector.h"
#include "pga3d/Bivector.h"
#include "pga3d/BivectorWeight.h"
#include "pga3d/BivectorBulk.h"
#include "pga3d/opsArithmetic.h"

namespace pga3dphysics {
    using pga3d::Vector;
    using pga3d::Point;
    using pga3d::Bivector;
    using pga3d::BivectorWeight;
    using pga3d::BivectorBulk;

    class Velocity {
        [[nodiscard]] static constexpr BivectorWeight linear(const Vector& v) noexcept {
            return {.wx = v.x, .wy = v.y, .wz = v.z};
        }

        [[nodiscard]] static constexpr BivectorBulk angular(double xy, double xz, double yz) noexcept {
            return {.xy = xy, .xz = xz, .yz = yz};
        }

        [[nodiscard]] static constexpr Bivector angular(const BivectorBulk& w, const Point& rotationCenter) noexcept {
            return w - linear(pointLinearVelocity(rotationCenter, w));
        }

        [[nodiscard]] static constexpr Vector pointLinearVelocity(const Point& point, const Bivector& velocity) noexcept {
            return point.cross(velocity);
        }

        [[nodiscard]] static constexpr Vector pointLinearVelocity(const Point& point, const BivectorWeight& velocity) noexcept {
            return point.cross(velocity);
        }

        [[nodiscard]] static constexpr Vector pointLinearVelocity(const Point& point, const BivectorBulk& velocity) noexcept {
            return point.cross(velocity);
        }
    };
}