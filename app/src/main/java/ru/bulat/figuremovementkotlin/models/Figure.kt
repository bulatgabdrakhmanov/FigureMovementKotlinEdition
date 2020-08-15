package ru.bulat.figuremovementkotlin.models

import android.graphics.Canvas
import android.graphics.Paint

abstract class Figure(var position: Point) {
    protected val paint: Paint = Paint()

    public fun moveTo(dx: Float, dy: Float) {
        this.position = Point(
            this.position.x + dx,
            this.position.y + dy
        )
    }

    abstract fun calculateArea(): Float

    abstract fun draw(canvas: Canvas)
}