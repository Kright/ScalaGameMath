// Copyright (c) 2025 Igor Slobodskov
// SPDX-License-Identifier: MIT

#pragma once
#include "PhysicsBody.h"

namespace pga3d {
    struct BodyLine {
        PhysicsBody* body = nullptr;
        Bivector localLine = {};

        [[nodiscard]] constexpr Bivector globalLine() const {
            return body->state.motor.sandwich(localLine);
        }
    };
}
