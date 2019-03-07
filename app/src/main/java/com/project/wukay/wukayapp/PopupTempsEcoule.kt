package com.project.wukay.wukayapp

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.DisplayMetrics
import android.view.Gravity
import android.view.WindowManager
import kotlinx.android.synthetic.main.activity_pop_up_animal_find.*
import kotlinx.android.synthetic.main.activity_popup_temps_ecoule.*

class PopupTempsEcoule : AppCompatActivity() {

    companion object {

        private const val HEIGHT = 1000
        private const val WIDTH = 1000
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_popup_temps_ecoule)

        val intent = intent

        boutonSortir.setOnClickListener {
            finish()
        }

        var metrics = DisplayMetrics()

        windowManager.defaultDisplay.getMetrics(metrics)

        metrics.widthPixels
        metrics.heightPixels


        window.setLayout(metrics.widthPixels, metrics.heightPixels)

        var params: WindowManager.LayoutParams = window.attributes

        params.gravity = Gravity.CENTER
        params.x = 0
        params.y = -230

        window.attributes = params
    }
}