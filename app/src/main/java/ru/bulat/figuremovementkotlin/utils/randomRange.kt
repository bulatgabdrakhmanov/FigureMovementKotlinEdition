package ru.bulat.figuremovementkotlin.utils

fun getRandomFromRange(left: Float, right: Float): Float {
    val min: Float = left.coerceAtMost(right)
    val max: Float = left.coerceAtLeast(right)

    return min + Math.random().toFloat() * (max - min)
}