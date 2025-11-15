// Copyright (c) 2025 Igor Slobodskov
// SPDX-License-Identifier: MIT

#pragma once

#include "pga3d/Bivector.h"

namespace pga3d {
    struct InertiaLocal {
        double mass = 0.0;
        double mryz = 0.0;
        double mrxz = 0.0;
        double mrxy = 0.0;

        [[nodiscard]] constexpr Bivector operator()(const Bivector& velocity) const noexcept {
            return Bivector {
              .wx = velocity.yz * mryz,
              .wy = -velocity.xz * mrxz,
              .wz = velocity.xy * mrxy,
              .xy = velocity.wz * mass,
              .xz = -velocity.wy * mass,
              .yz = velocity.wx * mass,
            };
        }

        [[nodiscard]] constexpr Bivector invert(const Bivector& localInertia) const noexcept {
            const double massInv = 1.0 / mass;

            return Bivector {
              .wx = localInertia.yz * massInv,
              .wy = -localInertia.xz * massInv,
              .wz = localInertia.xy * massInv,
              .xy = localInertia.wz / mrxy,
              .xz = -localInertia.wy / mrxz,
              .yz = localInertia.wx / mryz,
            };
        }

        /** invert(localB.cross(apply(localB)) + localForque) */
        [[nodiscard]] constexpr Bivector getAcceleration(const Bivector& localB, const Bivector& localForque) const noexcept {
            return Bivector {
              .wx = localForque.yz / mass + localB.wy * localB.xy + localB.wz * localB.xz,
              .wy = -localForque.xz / mass + localB.wz * localB.yz - localB.wx * localB.xy,
              .wz = localForque.xy / mass - localB.wx * localB.xz - localB.wy * localB.yz,
              .xy = (localForque.wz + localB.xz * localB.yz * (mrxz - mryz)) / mrxy,
              .xz = (-localForque.wy + localB.xy * localB.yz * (mryz - mrxy)) / mrxz,
              .yz = (localForque.wx + localB.xy * localB.xz * (mrxy - mrxz)) / mryz,
            };
        }

        [[nodiscard]] constexpr double getKineticEnergy(const Bivector& velocity) const noexcept {
            return velocity.antiWedge(operator()(velocity)) * 0.5;
        }
    };
}
