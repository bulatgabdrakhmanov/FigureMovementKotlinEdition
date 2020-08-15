package ru.bulat.figuremovementkotlin.models

import android.graphics.Canvas
import android.graphics.Color
import ru.bulat.figuremovementkotlin.interfaces.ColorChangeable

open class Square(position: Point, private val width: Float)
    : Figure(position), ColorChangeable {

    init {
        paint.color = Color.GREEN
    }

    override fun calculateArea(): Float {
        return width * width
    }

    override fun draw(canvas: Canvas) {
        canvas.drawRect(
            position.x - width / 2,
            position.y - width / 2,
            position.x + width / 2,
            position.y + width / 2,
            paint
        )
    }

    override fun changeColor(color: Int) {
        paint.color = color
    }
}