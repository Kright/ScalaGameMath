// Copyright (c) 2025 Igor Slobodskov
// SPDX-License-Identifier: MIT

#pragma once

#include "pga3d/Point.h"
#include "pga3d/Vector.h"
#include "PhysicsBody.h"


namespace pga3d {
    struct BodyPoint {
        PhysicsBody* body = nullptr;
        Point localPoint = {};

        [[nodiscard]] constexpr Point getGlobalPos() const noexcept {
            return body->localPosToGlobal(localPoint);
        }

        [[nodiscard]] constexpr Vector getGlobalPosVelocity() const noexcept {
            return body->getGlobalVelocityForLocalPos(localPoint);
        }
    };
}
