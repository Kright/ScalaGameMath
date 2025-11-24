// Copyright (c) 2025 Igor Slobodskov
// SPDX-License-Identifier: MIT

#pragma once

#include "pga3d/opsAntiWedge.h"
#include "BodyLine.h"
#include "BodyPoint.h"


namespace pga3d {
    struct SpringToLineConfig {
        double k = 0.0;

        void addForque(const BodyLine &bodyLine, const BodyPoint &bodyPoint) const noexcept {
            const Bivector line = bodyLine.globalLine();
            const Point pos2 = bodyPoint.globalPos();

            const Point posOnLine = pos2.projectOntoLine(line).toPoint();
            const Bivector forque = Forque::force(posOnLine, pos2) * k;

            bodyLine.body->addGlobalForquePaired(forque, *bodyPoint.body);
        }
    };

    struct SpringToLine {
        SpringToLineConfig config;
        BodyLine line;
        BodyPoint point;

        void addForque() const noexcept {
            config.addForque(line, point);
        }
    };
}
