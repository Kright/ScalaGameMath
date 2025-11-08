// Copyright (c) 2025 Igor Slobodskov
// SPDX-License-Identifier: MIT

#pragma once
#include "pga3d/Point.h"
#include "pga3d/Vector.h"
#include "pga3d/opsArithmetic.h"

namespace pga3dphysics {
    using pga3d::Point;
    using pga3d::Vector;

    struct AABB {
        Point min = {};
        Point max = {};

        [[nodiscard]] constexpr Vector size() const noexcept {
            return max - min;
        }

        [[nodiscard]] constexpr Vector halfSize() const noexcept {
            return size() * 0.5;
        }

        [[nodiscard]] constexpr double volume() const noexcept {
            const Vector s = size();
            return s.x * s.y * s.z;
        }

        [[nodiscard]] constexpr double surfaceArea() const noexcept {
            const Vector s = size();
            return 2.0 * (s.x * s.y + s.x * s.z + s.y * s.z);
        }

        [[nodiscard]] constexpr Point center() const noexcept {
            return Point::mid(min, max);
        }

        [[nodiscard]] constexpr Point clamp(const Point& point) const noexcept {
            return point.clamp(min, max);
        }

        [[nodiscard]] inline double distanceTo(const Point& point) const noexcept {
            const Point clamped = clamp(point);
            return clamped.distanceTo(point);
        }

        [[nodiscard]] constexpr bool contains(const Point& point) const noexcept {
            return point.x >= min.x && point.x <= max.x &&
                   point.y >= min.y && point.y <= max.y &&
                   point.z >= min.z && point.z <= max.z;
        }

        [[nodiscard]] constexpr bool contains(const AABB& aabb) const noexcept {
            return contains(aabb.min) && contains(aabb.max);
        }

        [[nodiscard]] constexpr AABB expanded(const Vector& eps) const noexcept {
            return {
                .min = min - eps,
                .max = max + eps
            };
        }

        [[nodiscard]] constexpr AABB expanded(const double eps) const noexcept {
            return expanded(Vector{eps, eps, eps});
        }

        constexpr void expand(const Vector& eps) noexcept {
            *this = expanded(eps);
        }

        constexpr void expand(const double eps) noexcept {
            *this = expanded(eps);
        }

        [[nodiscard]] constexpr AABB merged(const AABB& other) const noexcept {
            return {
                .min = min.min(other.min),
                .max = max.max(other.max),
            };
        }

        [[nodiscard]] constexpr AABB merged(const Point& p) const noexcept {
            return {
                .min = min.min(p),
                .max = max.max(p),
            };
        }

        constexpr void merge(const AABB& other) noexcept {
            *this = merged(other);
        }

        constexpr void merge(const Point& p) noexcept {
            *this = merged(p);
        }
    };
}
