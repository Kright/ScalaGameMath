package com.github.kright.pga3d.codegen.cpp.binops

import com.github.kright.pga3d.codegen.common.FileWriterTask
import com.github.kright.pga3d.codegen.cpp.{CppCodeGen, CppSubclass, CppSubclasses, Pga3dCodeGenCpp}

class QuaternionConstructorGenerator extends BinOpCodeGen {

  override def structCode(cls: CppSubclass): String = {
    val code = new CppCodeGen()

    if (CppSubclasses.quaternion == cls) {
      code(s"[[nodiscard]] static inline ${cls.name} rotation(const ${CppSubclasses.vector.name}& from, const ${CppSubclasses.vector.name}& to) noexcept;")
      code(s"[[nodiscard]] static inline ${cls.name} rotation(const ${CppSubclasses.planeIdeal.name}& from, const ${CppSubclasses.planeIdeal.name}& to) noexcept;")
    }

    code.toString
  }

  override def generateBinopCode(codeGen: Pga3dCodeGenCpp): FileWriterTask = {
    val code = new CppCodeGen()

    code.pragmaOnce()
    code("#include <cmath>")
    code("#include \"ops_norm.h\"")
    code("#include \"ops_arithmetic.h\"")
    code("")
    code.generatedBy(getClass.getName)

    val cls = CppSubclasses.quaternion

    code.namespace(codeGen.namespace) {
      code(
        s"""[[nodiscard]] inline ${cls.name} ${cls.name}::rotation(const ${CppSubclasses.vector.name}& from, const ${CppSubclasses.vector.name}& to) noexcept {
           |    return rotation(from.dual(), to.dual());
           |}""".stripMargin)
      code("")

      code(
        s"""[[nodiscard]] inline ${cls.name} ${cls.name}::rotation(const ${CppSubclasses.planeIdeal.name}& from, const ${CppSubclasses.planeIdeal.name}& to) noexcept {
           |    const double norm = std::sqrt(from.normSquare() * to.normSquare());
           |    const Quaternion q2a = to.geometric(from) / norm;
           |    const double dot = q2a.s;
           |
           |    if (dot > -1.0 + 1e-6) {
           |        const double newCos = std::sqrt((1.0 + dot) / 2);
           |        const double newSinDivSin2 = 0.5 / newCos;
           |        return Quaternion(newCos, q2a.xy * newSinDivSin2, q2a.xz * newSinDivSin2, q2a.yz * newSinDivSin2);
           |    }
           |
           |    const double sin2a = std::sqrt(q2a.xy * q2a.xy + q2a.xz * q2a.xz + q2a.yz * q2a.yz);
           |
           |    if (sin2a > 1e-8) {
           |        const double angle2 = std::atan2(sin2a, q2a.s);
           |        const double propAngle = angle2 * 0.5;
           |        const double mult = std::sin(propAngle) / sin2a;
           |        return Quaternion(std::cos(propAngle), q2a.xy * mult, q2a.xz * mult, q2a.yz * mult).normalizedByNorm();
           |    }
           |
           |    // choose any axis
           |    const PlaneIdeal orthogonalPlane =
           |        (std::abs(from.x) > std::abs(from.z)) ? PlaneIdeal{-from.y, from.x, 0} : PlaneIdeal{0, -from.z, from.y};
           |
           |    return Quaternion(0, orthogonalPlane.z, -orthogonalPlane.y, orthogonalPlane.x).normalizedByNorm();
           |}""".stripMargin)
    }

    FileWriterTask(codeGen.directory.resolve("ops_Quaternion.h"), code.toString)
  }
}
