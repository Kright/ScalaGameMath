#pragma once

#include "pga3d/Motor.h"
#include "pga3d/Bivector.h"
#include "pga3d/opsArithmetic.h"
#include "pga3d/opsWedge.h"
#include "pga3d/opsAntiWedge.h"
#include "pga3d/opsSandwich.h"
#include "InertiaMovedLocal.h"
#include "BodyState.h"


namespace pga3dphysics {
    using pga3d::Bivector;

    struct PhysicsBody {
        InertiaMovedLocal inertia;
        BodyState state;
        Bivector globalForqueAccumulator = {};

        [[nodiscard]] constexpr Bivector getGlobalForque() const noexcept {
            return globalForqueAccumulator;
        }

        [[nodiscard]] constexpr Bivector getLocalForque() const noexcept {
            return state.motor.reverseSandwich(getGlobalForque());
        }

        constexpr void resetForqueAccum() noexcept {
            globalForqueAccumulator = {};
        }

        constexpr void addGlobalForque(const Bivector& globalForque) noexcept {
            globalForqueAccumulator += globalForque;
        }

        /** Otherwise it's too easy to forget adding paired force */
        constexpr void addGlobalForquePaired(const Bivector &globalForque, PhysicsBody &other) noexcept {
            globalForqueAccumulator += globalForque;
            other.globalForqueAccumulator -= globalForque;
        }

        [[nodiscard]] constexpr BodyState getStateDerivative() const noexcept {
            return BodyState{
                .motor = state.motor.geometric(state.localB) * -0.5,
                .localB = inertia.getAcceleration(state.localB, getLocalForque())
            };
        }

        [[nodiscard]] constexpr double getKineticEnergy() const noexcept {
            return state.localB.antiWedge(inertia(state.localB)) * 0.5;
        }

        [[nodiscard]] constexpr Bivector getL() const noexcept {
            return state.motor.sandwich(inertia(state.localB));
        }
    };
}
