#pragma once
#include <vector>
#include <span>

#include "PhysicsBody.h"
#include "BodyState.h"

namespace pga3dphysics {
     class PhysicsSolverRK4 {
     private:
          std::vector<BodyState> initialStates;
          std::vector<BodyState> d1;
          std::vector<BodyState> d2;
          std::vector<BodyState> d3;
          std::vector<BodyState> d4;

          void updateSizes(size_t newSize) {
               initialStates.resize(newSize);
               d1.resize(newSize);
               d2.resize(newSize);
               d3.resize(newSize);
               d4.resize(newSize);
          }

          void resetForqueAccumulators(std::span<PhysicsBody>& dynamicBodies) {
               for (PhysicsBody &body: dynamicBodies) {
                    body.resetForqueAccum();
               }
          }

          void computeDerivativeInto(std::vector<BodyState> &result, const std::span<PhysicsBody>& dynamicBodies) {
               const size_t size = dynamicBodies.size();
               for (size_t pos = 0; pos < size; ++pos) {
                    result[pos] = dynamicBodies[pos].stateDerivative();
               }
          }

          void setFinalState(std::span<PhysicsBody>& dynamicBodies, const double dt) {
               const size_t size = dynamicBodies.size();
               for (size_t pos = 0; pos < size; ++pos) {
                    const BodyState dState =
                         d1[pos] * (dt * (1.0 / 6.0))
                        + d2[pos] * (dt * (1.0 / 3.0))
                        + d3[pos] * (dt * (1.0 / 3.0))
                        + d4[pos] * (dt * (1.0 / 6.0));

                    dynamicBodies[pos].state = (initialStates[pos] + dState).renormalized();
               }
          }

          void setNewState(std::span<PhysicsBody>& dynamicBodies, const double dt, const std::vector<BodyState> &derivative) {
               const size_t size = dynamicBodies.size();
               for (size_t pos = 0; pos < size; ++pos) {
                    dynamicBodies[pos].state = initialStates[pos].madd(derivative[pos], dt).renormalized();
               }
          }

          void setInitialState(const std::span<PhysicsBody>& dynamicBodies) {
               const size_t size = dynamicBodies.size();
               for (size_t pos = 0; pos < size; ++pos) {
                    initialStates[pos] = dynamicBodies[pos].state;
               }
          }

     public:
          void doStepRk4(std::span<PhysicsBody> dynamicBodies, const double dt, auto addForquesToBodies) {
               updateSizes(dynamicBodies.size());
               setInitialState(dynamicBodies);

               resetForqueAccumulators(dynamicBodies);
               addForquesToBodies(0.0);
               computeDerivativeInto(d1, dynamicBodies);
               
               setNewState(dynamicBodies, 0.5 * dt, d1);
               resetForqueAccumulators(dynamicBodies);
               addForquesToBodies(0.5);
               computeDerivativeInto(d2, dynamicBodies);

               setNewState(dynamicBodies, 0.5 * dt, d2);
               resetForqueAccumulators(dynamicBodies);
               addForquesToBodies(0.5);
               computeDerivativeInto(d3, dynamicBodies);

               setNewState(dynamicBodies, dt, d3);
               resetForqueAccumulators(dynamicBodies);
               addForquesToBodies(1.0);
               computeDerivativeInto(d4, dynamicBodies);

               setFinalState(dynamicBodies, dt);
          }
     };
}
