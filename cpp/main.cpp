#include <iostream>
#include <chrono>

#include "Friction.h"
#include "pga3d/pga3d.h"
#include "pga3dphysics/pga3dphysics.h"

using pga3dphysics::PhysicsSolverRK4;

namespace {

}


template<class T>
struct Id {
    int value = 0;
};


struct BodyPoint {
    Id<pga3dphysics::PhysicsBody> id{};
    pga3d::Point localPoint;

    [[nodiscard]] constexpr pga3d::Point getGlobalPos(const pga3dphysics::PhysicsBody& body) const noexcept {
        return body.localPosToGlobal(localPoint);
    }

    [[nodiscard]] constexpr pga3d::Vector getGlobalPosVelocity(const pga3dphysics::PhysicsBody& body) const noexcept {
        return body.getGlobalVelocityForLocalPos(localPoint);
    }
};


struct SpringConfig {
    double k = 0.0;
    double targetR = 0.0;
    bool noPush = false;
    bool noPull = false;
    pga3dphysics::Friction friction;
};

struct Spring {
    BodyPoint first;
    BodyPoint second;
    SpringConfig config;

    void addForque(pga3dphysics::PhysicsBody& firstBody, pga3dphysics::PhysicsBody& secondBody) const noexcept {
        const pga3d::Point pos1 = first.getGlobalPos(firstBody);
        const pga3d::Point pos2 = second.getGlobalPos(secondBody);
        const pga3d::Vector dPos = pos2 - pos1;
        const double r2 = dPos.normSquare();
        if (r2 <= config.targetR * config.targetR) {
            if (config.noPush) return;
        } else {
            if (config.noPull) return;
        }

        double frictionForce = 0.0;
        const double r = std::sqrt(r2);
        if (!config.friction.isZero()) {
            const pga3d::Vector velocity1 = first.getGlobalPosVelocity(firstBody);
            const pga3d::Vector velocity2 = second.getGlobalPosVelocity(secondBody);
            const pga3d::Vector dv = velocity2 - velocity1;
            const double sign = dPos.antiDot(dv).i;
            frictionForce = config.friction(sign * dv.norm());
        }

        const double mult = (config.k * (r - config.targetR) - frictionForce) / (r + 1e-100);
        const pga3d::Bivector forque = pos1.antiWedge(dPos) * mult;

        firstBody.addGlobalForquePaired(forque, secondBody);
    }
};


class PhysicsSystem {
public:
    double dt = 0.01;
    double time = 0.0;
    std::vector<pga3dphysics::PhysicsBody> bodies;
    std::vector<Spring> springs;
    pga3d::Vector gravity{};
    PhysicsSolverRK4 solver;

    void doStep() {
        solver.doStepRk4(bodies, dt, [&](double _) {
            if (gravity != pga3d::Vector{}) {
                for (auto &body: bodies) {
                    body.addGlobalForque(pga3dphysics::Forque::force( body.getGlobalCenter(), body.inertia.mass() * gravity));
                }
            }

            for (const Spring &spring: springs) {
                spring.addForque(bodies[spring.first.id.value], bodies[spring.second.id.value]);
            }
        });

        time += dt;
    }

    [[nodiscard]] constexpr double getKineticEnergy() const  {
        double sum = 0.0;
        for (const auto &body: bodies) {
            sum += body.getKineticEnergy();
        }
        return sum;
    }
};


int main() {
    for (int i = 0; i < 10; ++i) {
        PhysicsSystem system;

        for (double shift: {0.0, 1e-2, 1e-1, 1.0, 1e1, 1e2, 1e3, 1e4, 1e5, 1e6}) {
            const pga3d::Motor motor = pga3d::Motor::addVector({shift, shift, shift});

            system.bodies.push_back(pga3dphysics::PhysicsBody{
                .inertia = pga3dphysics::InertiaMovedLocal{
                    .localToGlobal = motor.reverse(),
                    .localInertia = pga3dphysics::InertiaLocal(1.0, 3.0, 2.0, 1.0),
                },
                .state = pga3dphysics::BodyState{
                    .motor = motor,
                    .localB = motor.reverseSandwich(pga3d::Bivector{0, 0, 0, 1.0, 1.0, -1.0}),
                },
            });
        }

        const double initialEnergy = system.getKineticEnergy();

        constexpr int stepsCount = 1000;
        auto start = std::chrono::high_resolution_clock::now();

        for (int j = 0; j < stepsCount; ++j) {
            system.doStep();
        }

        auto end = std::chrono::high_resolution_clock::now();
        auto duration = std::chrono::duration_cast<std::chrono::nanoseconds>(end - start);

        std::cout <<  duration.count() << " ns for " << stepsCount << " steps, dE = " << system.getKineticEnergy() - initialEnergy << std::endl;
    }

    return 0;
}