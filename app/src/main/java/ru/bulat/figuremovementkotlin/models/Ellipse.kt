package ru.bulat.figuremovementkotlin.models

import android.graphics.Canvas
import android.graphics.Color
import ru.bulat.figuremovementkotlin.interfaces.ColorChangeable
import kotlin.math.PI

open class Ellipse(position: Point, private val radiusX: Float, private val radiusY: Float)
    : Figure(position), ColorChangeable {

    init {
        paint.color = Color.BLUE
    }

    override fun calculateArea(): Float {
        return (PI * radiusX * radiusY).toFloat()
    }

    override fun draw(canvas: Canvas) {
        canvas.drawOval(
            position.x - radiusX,
            position.y - radiusY,
            position.x + radiusX,
            position.y + radiusY,
            paint
        )
    }

    override fun changeColor(color: Int) {
        paint.color = color
    }
}