package com.github.kright.pga3d.codegen.ops

import com.github.kright.ga.PGA3
import com.github.kright.pga3d.codegen.{GeneratedCode, MultivectorSubClass, MultivectorUnaryOp}

object DefMotorToQuaternionAndTranslator {
  def apply()(using pga3: PGA3): MultivectorUnaryOp = MultivectorUnaryOp { (cls, v) =>
    GeneratedCode { code =>

      val self = cls.self
      
      if (cls == MultivectorSubClass.motor) {
        
        val quaternionTypeName = MultivectorSubClass.quaternion.typeName
        val translatorTypeName = MultivectorSubClass.translator.typeName
        
        code(
          s"""
             |/** motor has to be normalized */
             |def toQuaternionAndTranslator: ($quaternionTypeName, $translatorTypeName) = {
             |  val q = this.toQuaternionUnsafe
             |  val t = q.reverse.geometric(this)
             |  (q, t.toTranslatorUnsafe)
             |}
             |  
             |/** motor has to be normalized */
             |def toTranslatorAndQuaternion: ($translatorTypeName, $quaternionTypeName) = {
             |  val q = this.toQuaternionUnsafe
             |  val t = this.geometric(q.reverse)
             |  (t.toTranslatorUnsafe, q)
             |}""".stripMargin)
      }
    }
  }

}
