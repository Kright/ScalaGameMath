// Copyright (c) 2025 Igor Slobodskov
// SPDX-License-Identifier: MIT

#pragma once

#include "Point.h"
#include "ProjectivePoint.h"

namespace pga3dphysics {
    using pga3d::Point;
    using pga3d::ProjectivePoint;

    struct InertiaSummable {
        double ww = 0.0;
        double wx = 0.0;
        double wy = 0.0;
        double wz = 0.0;
        double xx = 0.0;
        double yy = 0.0;
        double zz = 0.0;
        double xy = 0.0;
        double yz = 0.0;
        double xz = 0.0;

        [[nodiscard]] constexpr double mass() const noexcept {
            return ww;
        }

        [[nodiscard]] constexpr Point centerOfMass() const noexcept {
            const double inv = 1.0 / mass();
            return {.x = wx * inv, .y = wy * inv, .z = wz * inv};
        }

        [[nodiscard]] constexpr ProjectivePoint centerOfMassProjective() const noexcept {
            return {.x = wx , .y= wy , .z = wz, .w= ww};
        }

        [[nodiscard]] constexpr double normSquare() const noexcept {
            return ww * ww + wx * wx + wy * wy + wz * wz + xx * xx + yy * yy + zz * zz + xy * xy + yz * yz + xz * xz;
        }

        [[nodiscard]] static constexpr InertiaSummable point(const Point& p, double mass) noexcept {
            // inertia of a mass in a point = symmetricProduct(p.toProjectivePoint, p * mass)
            return {
                .ww = mass,
                .wx = p.x * mass,
                .wy = p.y * mass,
                .wz = p.z * mass,
                .xx = p.x * p.x * mass,
                .yy = p.y * p.y * mass,
                .zz = p.z * p.z * mass,
                .xy = p.x * p.y * mass,
                .yz = p.y * p.z * mass,
                .xz = p.x * p.z * mass,
            };
        }
    };

    [[nodiscard]] constexpr InertiaSummable operator+(const InertiaSummable& a, const InertiaSummable& b) noexcept {
        return {
            .ww = a.ww + b.ww,
            .wx = a.wx + b.wx,
            .wy = a.wy + b.wy,
            .wz = a.wz + b.wz,
            .xx = a.xx + b.xx,
            .yy = a.yy + b.yy,
            .zz = a.zz + b.zz,
            .xy = a.xy + b.xy,
            .yz = a.yz + b.yz,
            .xz = a.xz + b.xz
        };
    }

    [[nodiscard]] constexpr InertiaSummable& operator+=(InertiaSummable& a, const InertiaSummable& b) noexcept {
        a = a + b;
        return a;
    }

    [[nodiscard]] constexpr InertiaSummable operator-(const InertiaSummable& a, const InertiaSummable& b) noexcept {
        return {
            .ww = a.ww - b.ww,
            .wx = a.wx - b.wx,
            .wy = a.wy - b.wy,
            .wz = a.wz - b.wz,
            .xx = a.xx - b.xx,
            .yy = a.yy - b.yy,
            .zz = a.zz - b.zz,
            .xy = a.xy - b.xy,
            .yz = a.yz - b.yz,
            .xz = a.xz - b.xz
        };
    }

    [[nodiscard]] constexpr InertiaSummable& operator-=(InertiaSummable& a, const InertiaSummable& b) noexcept {
        a = a - b;
        return a;
    }

    [[nodiscard]] constexpr InertiaSummable operator*(const InertiaSummable& a, double mult) noexcept {
        return {
            .ww = a.ww * mult,
            .wx = a.wx * mult,
            .wy = a.wy * mult,
            .wz = a.wz * mult,
            .xx = a.xx * mult,
            .yy = a.yy * mult,
            .zz = a.zz * mult,
            .xy = a.xy * mult,
            .yz = a.yz * mult,
            .xz = a.xz * mult
        };
    }

    [[nodiscard]] constexpr InertiaSummable operator*(double mult, const InertiaSummable& a) noexcept {
        return a * mult;
    }

    [[nodiscard]] constexpr InertiaSummable& operator*=(InertiaSummable& a, double mult) noexcept {
        a = a * mult;
        return a;
    }
}
