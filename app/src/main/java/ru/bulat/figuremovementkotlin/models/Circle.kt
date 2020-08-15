package ru.bulat.figuremovementkotlin.models

import android.graphics.Canvas
import android.graphics.Color
import kotlin.math.PI

open class Circle(position: Point, private val radius: Float) : Figure(position) {
    init {
        paint.color = Color.RED
    }

    final override fun calculateArea(): Float {
        return (PI * radius * radius).toFloat();
    }

    override fun draw(canvas: Canvas) {
        canvas.drawCircle(
            position.x,
            position.y,
            radius,
            paint
        )
    }

}