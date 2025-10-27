#pragma once

#include <cmath>

#include "pga3d/Bivector.h"
#include "pga3d/BivectorWeight.h"
#include "pga3d/Point.h"
#include "pga3d/Vector.h"
#include "pga3d/opsArithmetic.h"
#include "pga3d/opsAntiWedge.h"


namespace pga3dphysics {
    using pga3d::Vector;
    using pga3d::Point;
    using pga3d::Bivector;
    using pga3d::BivectorWeight;

    struct Forque {
        [[nodiscard]] static constexpr Bivector force(const Point& point, const Vector& force) noexcept{
            return point.antiWedge(force);
        }

        [[nodiscard]] static constexpr Bivector torque(const Vector &torque) noexcept {
            return Bivector{.wx = torque.x, .wy = torque.y, .wz = torque.z, .xy = 0.0, .xz = 0.0, .yz = 0.0};
        }

        [[nodiscard]] static constexpr Vector getLinearForce(const Bivector &forque) noexcept {
            const Bivector fd = forque.dual();
            return {.x = fd.wx, .y = fd.wy, .z = fd.wz};
        }

        [[nodiscard]] static constexpr Point getCenter(const Bivector &forque) noexcept {
            const Vector v = getLinearForce(forque);
            const double vNormSquare = v.normSquare();

            if (vNormSquare > 1e-100) {
                const Vector w{.x = forque.wx, .y = forque.wy, .z = forque.wz};
                const BivectorWeight result = (v.dual().cross(w.dual())).dual() / vNormSquare;
                return Point{result.wx, result.wy, result.wz};
            } else {
                // pure torque
                return Point{0.0, 0.0, 0.0};
            }
        }

        [[nodiscard]] static constexpr Vector getTorqueAroundCenter(const Bivector &forque) noexcept {
            const Vector v = getLinearForce(forque);
            const double vNormSquare = v.normSquare();
            if (vNormSquare > 1e-100) {
                const double inv = 1.0 / std::sqrt(vNormSquare);
                return {.x = forque.wx * v.x * inv, .y = forque.wy * v.y * inv, .z = forque.wz * v.z * inv};
            } else {
                return {.x = forque.wx, .y = forque.wy, .z = forque.wz};
            }
        }

        [[nodiscard]] static constexpr Bivector spring(const Point &current, const Point &another, double k, double springLength) noexcept {
            const Vector dir = another - current;
            const double dirDist = dir.norm();
            return force(current, dir * (k * (dirDist - springLength) / (dirDist + 1e-100)));
        }
    };
}
