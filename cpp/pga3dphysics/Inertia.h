// Copyright (c) 2025 Igor Slobodskov
// SPDX-License-Identifier: MIT

#pragma once

//
// Helper formulas for inertia construction
//
namespace pga3d::inertia {
    [[nodiscard]] static constexpr double diskInPlane(const double r, const double innerR = 0.0) noexcept {
        return 0.5 * (r * r + innerR * innerR);
    }

    [[nodiscard]] static constexpr double diskXX(const double r, const double innerR = 0.0) noexcept {
        return 0.25 * (r * r + innerR * innerR);
    }

    [[nodiscard]] static constexpr double rodAlongAxis(const double length) noexcept {
        return length * length / 12;
    }
}
