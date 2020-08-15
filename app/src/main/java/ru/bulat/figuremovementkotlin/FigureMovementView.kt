package ru.bulat.figuremovementkotlin

import android.content.Context
import android.graphics.Canvas
import android.view.View
import ru.bulat.figuremovementkotlin.interfaces.ColorChangeable
import ru.bulat.figuremovementkotlin.models.*
import ru.bulat.figuremovementkotlin.utils.getRandomFromRange
import kotlin.math.sqrt
import kotlin.reflect.typeOf

class FigureMovementView(context: Context): View(context) {
    private val speed: Int = 5 * 100

    private val figures: MutableList<Figure> = mutableListOf()
    private val figureDirectionState: MutableMap<Figure, Point> = mutableMapOf()

    init {
        for (i in 0..20 ) addFigures()

        for (figure: Figure in figures) {
            val x: Float = getRandomFromRange(-1F, 1F)
            val y: Float = getRandomFromRange(-1F, 1F)
            val k: Float = 2 / sqrt(x*x + y*y)

            figureDirectionState[figure] = Point(k*x, k*y)
        }
    }

    override fun onDraw(canvas: Canvas) {
        for (figure: Figure in figures) {
            figure.draw(canvas)
        }
    }

    override fun invalidate() {
        for (figure in figures) {
            val pos = figure.position

            val currentDirectionState: Point = figureDirectionState[figure] ?: Point(1F, -1F)

            var newDirectionX: Float = currentDirectionState.x
            var newDirectionY: Float = currentDirectionState.y

            if (pos.x <= 0) newDirectionX = Math.abs(newDirectionX)
            if (pos.x >= width) newDirectionX = -Math.abs(newDirectionX)
            if (pos.y <= 0) newDirectionY = Math.abs(newDirectionY)
            if (pos.y >= height) newDirectionY = -Math.abs(newDirectionY)

            figureDirectionState[figure] = Point(newDirectionX, newDirectionY)

            val area: Float = figure.calculateArea() / 100

            figure.moveTo(
                newDirectionX * speed / area,
                newDirectionY * speed / area
            )
        }

        super.invalidate()
    }

    private fun addFigures() {
        figures.add(
            Circle(
                Point(0F, 0F),
                getRandomFromRange(20F, 70F)
            )
        )
        figures.add(
            Ellipse(
                Point(0F, 0F),
                getRandomFromRange(20F, 70F),
                getRandomFromRange(20F, 70F)
            )
        )
        figures.add(
            Rectangle(
                Point(0F, 0F),
                getRandomFromRange(20F, 70F) * 2,
                getRandomFromRange(20F, 70F) * 2
            )
        )
        figures.add(
            Square(
                Point(0F, 0F),
                getRandomFromRange(20F, 70F) * 2
            )
        )
    }

    fun changeColors() {
        for (figure: Figure in figures) {
            if (figure is ColorChangeable) {
                figure.changeColor(-getRandomFromRange(0F, 16777216F).toInt())
            }
        }
    }
}