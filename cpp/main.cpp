#include <iostream>
#include <chrono>

#include "Friction.h"
#include "pga3d/pga3d.h"
#include "pga3dphysics/pga3dphysics.h"

using pga3dphysics::PhysicsSolverRK4;


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
    pga3dphysics::VelocityFriction velocityFriction{};
    pga3dphysics::PositionFriction positionFriction{};
};

struct Spring {
    BodyPoint first;
    BodyPoint second;
    SpringConfig config;

    void addForque(pga3dphysics::PhysicsBody &firstBody, pga3dphysics::PhysicsBody &secondBody) const noexcept {
        const pga3d::Point pos1 = first.getGlobalPos(firstBody);
        const pga3d::Point pos2 = second.getGlobalPos(secondBody);
        const pga3d::Vector dPos = pos2 - pos1;
        const double r2 = dPos.normSquare();
        if (r2 <= config.targetR * config.targetR) {
            if (config.noPush) return;
        } else {
            if (config.noPull) return;
        }

        const double r = std::sqrt(r2);

        double frictionForce = 0.0;
        if (!config.velocityFriction.isZero()) {
            const pga3d::Vector velocity1 = first.getGlobalPosVelocity(firstBody);
            const pga3d::Vector velocity2 = second.getGlobalPosVelocity(secondBody);
            const pga3d::Vector dv = velocity2 - velocity1;
            const double sign = dPos.antiDot(dv).i;
            frictionForce += config.velocityFriction(sign * dv.norm());
        }
        frictionForce += config.positionFriction(r);

        const double mult = (config.k * (r - config.targetR) - frictionForce) / (r + 1e-100);
        const pga3d::Bivector forque = pos1.antiWedge(dPos) * mult;

        firstBody.addGlobalForquePaired(forque, secondBody);
    }

    void afterStep(const pga3dphysics::PhysicsBody& firstBody, const pga3dphysics::PhysicsBody& secondBody) noexcept {
        const pga3d::Point pos1 = first.getGlobalPos(firstBody);
        const pga3d::Point pos2 = second.getGlobalPos(secondBody);
        const pga3d::Vector dPos = pos2 - pos1;
        const double r = dPos.normSquare();
        config.positionFriction.correctBoundPosition(r);
    }
};



struct GravitySystem {
    pga3d::Vector gravity{};

    void addForques(std::vector<pga3dphysics::PhysicsBody>& bodies) const noexcept {
        if (gravity != pga3d::Vector{}) {
            for (auto &body: bodies) {
                body.addGlobalForque(pga3dphysics::Forque::force(body.globalCenter(), body.inertia.mass() * gravity));
            }
        }
    }
};


struct SpringSystem {
    std::vector<Spring> springs;

    void addForques(std::vector<pga3dphysics::PhysicsBody>& bodies) const noexcept {
        for (const Spring &spring: springs) {
            spring.addForque(bodies[spring.first.id.value], bodies[spring.second.id.value]);
        }
    }

    void afterStep(const std::vector<pga3dphysics::PhysicsBody>& bodies) {
        for (Spring &spring: springs) {
            spring.afterStep(bodies[spring.first.id.value], bodies[spring.second.id.value]);
        }
    }
};


class PhysicsSystem {
public:
    double dt = 0.01;
    double time = 0.0;
    std::vector<pga3dphysics::PhysicsBody> bodies;
    PhysicsSolverRK4 solver;

    GravitySystem gravity;
    SpringSystem springs;

    void doStep() {
        solver.doStepRk4(bodies, dt, [&](double _) {
            gravity.addForques(bodies);
            springs.addForques(bodies);
        });

        time += dt;

        springs.afterStep(bodies);
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

            system.bodies.push_back(pga3dphysics::PhysicsBody{
                .inertia = pga3dphysics::InertiaMovedLocal{
                    .localToGlobal = motor.reversed(),
                    .localInertia = pga3dphysics::InertiaLocal(1.0, 3.0, 2.0, 1.0),
                },
                .state = pga3dphysics::BodyState{
                    .motor = motor,
                    .localB = motor.reversed().sandwich(pga3d::Bivector{0, 0, 0, 1.0, 1.0, -1.0}),
                },
            });
        }

        for (int body_no = 0; body_no < system.bodies.size(); ++body_no) {
            for (int j = 0; j < 3; ++j) {
                // dummy spring connects body to itself
                system.springs.springs.push_back(Spring{
                    .first = {.id = {body_no}, .localPoint = {0.0, 0.0, 0.0}},
                    .second = {.id = {body_no}, .localPoint = {0.0, 0.0, 1.0}},
                    .config = SpringConfig{
                        .k = 2.0, .targetR = 2.0, .noPush = false, .noPull = false,
                        .velocityFriction = {.linearK = 2.0, .quadraticK = 1.0, .maxForce = 1000.0},
                        .positionFriction = {.linearK = 2.0, .maxDelta = 0.001, .boundPosition = 0.0},
                    },
                });
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
    const auto linear = pga3dphysics::LinearOperator<pga3d::ProjectivePoint>::create([&](const pga3d::ProjectivePoint& p){ return motor.sandwich(p); });

    std::cout << linear << std::endl;
    std::cout << pga3dphysics::linearOperatorForSandwichForProjectivePoint(motor) << std::endl;

    return 0;
}
