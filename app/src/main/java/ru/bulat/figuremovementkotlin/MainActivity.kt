package ru.bulat.figuremovementkotlin

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val figureMovementView: FigureMovementView = FigureMovementView(this)
        setContentView(figureMovementView)

        figureMovementView.setOnClickListener { figureMovementView.changeColors() }

        Handler(Looper.getMainLooper()).postDelayed(object : Runnable {
            override fun run() {
                figureMovementView.invalidate()
                Handler(Looper.getMainLooper()).postDelayed(this, 10)
            }
        }, 10)
    }
}