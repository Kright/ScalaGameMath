package com.github.kright

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
    private val shapeRenderer: ShapeRenderer = ShapeRenderer()

    var t = 0.0

    override fun render(delta: Float) {
        clearScreen(red = 0f, green = 0f, blue = 0f)

        t += delta.toDouble()

        shapeRenderer.use(ShapeRenderer.ShapeType.Filled) { shapeRenderer ->
            shapeRenderer.color = com.badlogic.gdx.graphics.Color.WHITE
            shapeRenderer.circle(10f + t.toFloat(), 10f, 2f)
        }
    }

    override fun dispose() {
        shapeRenderer.disposeSafely()
    }
}
