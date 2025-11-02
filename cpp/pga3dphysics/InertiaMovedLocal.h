// Copyright (c) 2025 Igor Slobodskov
// SPDX-License-Identifier: MIT

#pragma once

#include "pga3d/Motor.h"
#include "pga3d/opsReverseSandwich.h"
#include "pga3d/opsSandwich.h"

#include "InertiaLocal.h"

namespace pga3dphysics {
    using pga3d::Motor;
    using pga3d::Bivector;
    using pga3d::Point;

    struct InertiaMovedLocal {
        Motor localToGlobal;
        InertiaLocal localInertia;

        [[nodiscard]] constexpr double mass() const noexcept {
            return localInertia.mass;
        }

        [[nodiscard]] constexpr Point centerOfMassPoint() const noexcept {
            return localToGlobal.sandwich(pga3d::PointCenter{}).toPointUnsafe();
        }

        [[nodiscard]] constexpr Bivector operator ()(const Bivector& globalB) const noexcept {
            const Bivector localB = localToGlobal.reverseSandwich(globalB);
            const Bivector localI = localInertia(localB);
            return localToGlobal.sandwich(localI);
        }

        [[nodiscard]] constexpr Bivector invert(const Bivector& globalI) const noexcept {
            const Bivector localI = localToGlobal.reverseSandwich(globalI);
            const Bivector localB = localInertia.invert(localI);
            return localToGlobal.sandwich(localB);
        }

        [[nodiscard]] constexpr Bivector getLocalAcceleration(const Bivector &globalB,
                                                              const Bivector &globalForque) const noexcept {
            const Bivector localB = localToGlobal.reverseSandwich(globalB);
            const Bivector localF = localToGlobal.reverseSandwich(globalForque);
            return localInertia.getAcceleration(localB, localF);
        }

        [[nodiscard]] constexpr Bivector getAcceleration(const Bivector &globalB,
                                                         const Bivector &globalForque) const noexcept {
            const Bivector localA = getLocalAcceleration(globalB, globalForque);
            return localToGlobal.sandwich(localA);
        }
    };
}
