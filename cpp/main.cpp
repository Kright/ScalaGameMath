#include <iostream>
#include <chrono>
#include "pga3d/pga3d.h"
#include "pga3dphysics/pga3dphysics.h"

using pga3dphysics::PhysicsSolverRK4;

namespace {
    constexpr double getKineticEnergy(const std::vector<pga3dphysics::PhysicsBody>& bodies) {
        double sum = 0.0;
        for (const auto &body: bodies) {
            sum += body.getKineticEnergy();
        }
        return sum;
    }
}


int main() {
    for (int i = 0; i < 10; ++i) {
        PhysicsSolverRK4 solver;
        std::vector<pga3dphysics::PhysicsBody> bodies;

        for (double shift: {0.0, 1e-2, 1e-1, 1.0, 1e1, 1e2, 1e3, 1e4, 1e5, 1e6}) {
            const pga3d::Motor motor = pga3d::Motor::addVector({shift, shift, shift});

            bodies.push_back(pga3dphysics::PhysicsBody{
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

        const double initialEnergy = getKineticEnergy(bodies);

        constexpr int stepsCount = 1000;
        constexpr double dt = 0.01;
        auto start = std::chrono::high_resolution_clock::now();

        for (int step = 0; step < stepsCount; ++step) {
             solver.doStepRk4(bodies, dt, [](double _) {
            });
        }

        auto end = std::chrono::high_resolution_clock::now();
        auto duration = std::chrono::duration_cast<std::chrono::nanoseconds>(end - start);

        std::cout <<  duration.count() << " ns for " << stepsCount << " steps, dE = " << getKineticEnergy(bodies) - initialEnergy << std::endl;
    }

    return 0;
}