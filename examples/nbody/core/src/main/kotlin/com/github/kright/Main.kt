package com.github.kright

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.glutils.ShapeRenderer
import ktx.app.KtxGame
import ktx.app.KtxScreen
import ktx.app.clearScreen
import ktx.assets.disposeSafely
import ktx.graphics.use


class Main : KtxGame<KtxScreen>() {
    override fun create() {
        addScreen(FirstScreen())
        setScreen<FirstScreen>()
    }
}

class FirstScreen : KtxScreen {
    val shapeRenderer: ShapeRenderer = ShapeRenderer()
    val bodySystem = BodySystem(50, 500.0)
    val step = 0.001

    var t = 0.0
    var systemT = 0.0

    override fun render(delta: Float) {
        clearScreen(red = 0f, green = 0f, blue = 0f)

        t += delta.toDouble().coerceAtMost(0.016)

        while (systemT < t) {
            systemT += step
            bodySystem.step(step)

        }

        val w = Gdx.app.graphics.width
        val h = Gdx.app.graphics.height

        shapeRenderer.use(ShapeRenderer.ShapeType.Filled) { shapeRenderer ->
            shapeRenderer.color = com.badlogic.gdx.graphics.Color.WHITE
            for (pos in bodySystem.positions()) {
                shapeRenderer.circle(w / 2f + pos.x().toFloat(), h / 2f + pos.y().toFloat(), 2f)
            }
        }
    }

    override fun dispose() {
        shapeRenderer.disposeSafely()
    }
}
