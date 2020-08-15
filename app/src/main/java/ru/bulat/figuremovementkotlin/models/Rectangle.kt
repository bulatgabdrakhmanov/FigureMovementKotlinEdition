package ru.bulat.figuremovementkotlin.models

import android.graphics.Canvas
import android.graphics.Color

open class Rectangle(position: Point, private val width: Float, private val height: Float)
    : Figure(position) {

    init {
        paint.color = Color.MAGENTA
    }

    override fun calculateArea(): Float {
        return height * width
    }

    override fun draw(canvas: Canvas) {
        canvas.drawRect(
            position.x - width.toFloat() / 2,
            position.y - height.toFloat() / 2,
            position.x + width.toFloat() / 2,
            position.y + height.toFloat() / 2,
            paint
        )
    }
}