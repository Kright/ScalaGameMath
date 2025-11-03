// Copyright (c) 2025 Igor Slobodskov
// SPDX-License-Identifier: MIT

#pragma once

#include "pga3d/Point.h"
#include "pga3d/Vector.h"
#include "pga3d/Bivector.h"
#include "pga3d/opsArithmetic.h"
#include "pga3d/opsAntiWedge.h"

namespace pga3dphysics {
    using pga3d::Point;
    using pga3d::Vector;
    using pga3d::Bivector;

    struct Cylinder {
        Point a = {};
        Point b = {};
        double r = {0.0};

        [[nodiscard]] constexpr Point center() const noexcept {
            return Point::mid(a, b);
        }

        [[nodiscard]] constexpr Vector ab() const noexcept {
            return b - a;
        }

        [[nodiscard]] constexpr Bivector line() const noexcept {
            return a.antiWedge(b);
        }
    };
}
