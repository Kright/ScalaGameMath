#include <iostream>
#include <chrono>

#include "pga3d/pga3d.h"
#include "pga3dphysics/pga3dphysics.h"



class PhysicsSystem {
public:
    double dt = 0.01;
    double time = 0.0;
    std::vector<pga3d::PhysicsBody> bodies;
    pga3d::PhysicsSolverRK4 solver;

    pga3d::GravitySystem gravity;
    pga3d::SpringSystem springs;

    void doStep() {
        solver.doStepRk4(bodies, dt, [&](double _) {
            gravity.addForques(bodies);
            springs.addForques();
        });

        time += dt;

        springs.afterStep();
    }

    [[nodiscard]] constexpr double getKineticEnergy() const {
        double sum = 0.0;
        for (const auto &body: bodies) {
            sum += body.kineticEnergy();
        }
        return sum;
    }
};


int main() {
    for (int i = 0; i < 10; ++i) {
        PhysicsSystem system;

        for (double shift: {0.0, 1e-2, 1e-1, 1.0, 1e1, 1e2, 1e3, 1e4, 1e5, 1e6}) {
            const pga3d::Motor motor = pga3d::Motor::addVector({shift, shift, shift});

            system.bodies.push_back(pga3d::PhysicsBody{
                .inertia = pga3d::InertiaMovedLocal{
                    .localToGlobal = motor.reversed(),
                    .localInertia = pga3d::InertiaLocal(1.0, 3.0, 2.0, 1.0),
                },
                .state = pga3d::BodyState{
                    .motor = motor,
                    .localB = motor.reversed().sandwich(pga3d::Bivector{0, 0, 0, 1.0, 1.0, -1.0}),
                },
            });
        }

        for (int body_no = 0; body_no < system.bodies.size(); ++body_no) {
            for (int j = 0; j < 3; ++j) {
                system.springs.springs.push_back(pga3d::Spring{
                    .config = pga3d::SpringConfig{
                        .velocityFriction = {.linearK = 2.0, .quadraticK = 1.0, .maxForce = 1000.0},
                        .positionFriction = {.stiffness = {.linearK = 2.0, .maxDelta = 0.001}, .boundPosition = 0.0},
                        .k = 2.0, .targetR = 2.0, .noPush = false, .noPull = false,
                    },
                    .first = {.body = &system.bodies[body_no], .localPoint = {0.0, 0.0, 0.0}},
                    .second = {.body = &system.bodies[body_no], .localPoint = {0.0, 0.0, 1.0}},
                });
                // dummy spring connects еру body to itself
            }
        }

        // system.gravity.gravity = pga3d::Vector{0.0, -9.81, 0.0};

        const double initialEnergy = system.getKineticEnergy();

        constexpr int stepsCount = 2000;
        auto start = std::chrono::high_resolution_clock::now();

        for (int j = 0; j < stepsCount; ++j) {
            system.doStep();
        }

        auto end = std::chrono::high_resolution_clock::now();
        auto duration = std::chrono::duration_cast<std::chrono::nanoseconds>(end - start);

        std::cout << duration.count() << " ns for " << stepsCount << " steps, dE = " << system.getKineticEnergy() - initialEnergy << ", " << duration.count() / stepsCount << " ns per step" << std::endl;
    }

    const pga3d::Motor motor = pga3d::Translator::addVector({1.0, 2.0, 3.0}).geometric(pga3d::Quaternion::rotation(pga3d::Vector{0, 0, 1}, pga3d::Vector{1, 1, 0.0}));
    const auto linear = pga3d::LinearOperator<pga3d::ProjectivePoint>::create([&](const pga3d::ProjectivePoint& p){ return motor.sandwich(p); });

    std::cout << linear << std::endl;
    std::cout << pga3d::linearOperatorForSandwichForProjectivePoint(motor) << std::endl;

    return 0;
}
