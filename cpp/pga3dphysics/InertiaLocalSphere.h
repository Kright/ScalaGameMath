// Copyright (c) 2025 Igor Slobodskov
// SPDX-License-Identifier: MIT

#pragma once

#include "pga3d/Bivector.h"

namespace pga3dphysics {
    using pga3d::Bivector;

    /**
     * Fully symmetrical tensor of inertia (for example, for cube or sphere).
     * It has no precession, and computations are simpler and faster
     *
     * @param mass - mass
     * @param mr2  - square of effective radius multiplied by mass
     */
    struct InertiaLocalSphere {
        double mass = 0.0;
        double mr2 = 0.0;

        [[nodiscard]] constexpr Bivector operator()(const Bivector& velocity) const noexcept {
            return Bivector {
                .wx = velocity.yz * mr2,
                .wy = -velocity.xz * mr2,
                .wz = velocity.xy * mr2,
                .xy = velocity.wz * mass,
                .xz = -velocity.wy * mass,
                .yz = velocity.wx * mass,
              };
        }

        [[nodiscard]] constexpr Bivector invert(const Bivector& localInertia) const noexcept {
            const double massInv = 1.0 / mass;
            const double mr2Inv = 1.0 / mr2;

            return Bivector {
                .wx = localInertia.yz * massInv,
                .wy = -localInertia.xz * massInv,
                .wz = localInertia.xy * massInv,
                .xy = localInertia.wz * mr2Inv,
                .xz = -localInertia.wy * mr2Inv,
                .yz = localInertia.wx * mr2Inv,
            };
        }

        /** invert(localB.cross(apply(localB)) + localForque) */
        [[nodiscard]] constexpr Bivector getAcceleration(const Bivector& localB, const Bivector& localForque) const noexcept {
            const double massInv = 1.0 / mass;
            const double mr2Inv = 1.0 / mr2;

            return {
                .wx = localForque.yz * massInv + localB.wy * localB.xy + localB.wz * localB.xz,
                .wy = -localForque.xz * massInv + localB.wz * localB.yz - localB.wx * localB.xy,
                .wz = localForque.xy * massInv - localB.wx * localB.xz - localB.wy * localB.yz,
                .xy = localForque.wz * mr2Inv,
                .xz = -localForque.wy * mr2Inv,
                .yz = localForque.wx * mr2Inv,
            };
        }

        [[nodiscard]] constexpr double getKineticEnergy(const Bivector& velocity) const noexcept {
            return velocity.antiWedge(operator()(velocity)) * 0.5;
        }
    };
}