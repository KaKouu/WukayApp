package com.project.wukay.wukayapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.DisplayMetrics
import android.view.Gravity
import android.view.WindowManager.LayoutParams
import kotlinx.android.synthetic.main.activity_life_pop.*

class LifePopActivity : AppCompatActivity() {

    companion object {
        private const val HEIGHT = 600
        private const val WIDTH = 1000


    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_life_pop)

        val intent = intent

        var nbLife = intent.getStringExtra("nbLifeToShow")
        System.out.print("NBLIFE POPUP = $nbLife")


        closeButton.setOnClickListener {
            finish()
        }

        lifeWonTxt.text= "+$nbLife"

        var metrics = DisplayMetrics()

        windowManager.defaultDisplay.getMetrics(metrics)

        metrics.widthPixels
        metrics.heightPixels

        window.setLayout(WIDTH, HEIGHT)

        var params: LayoutParams = window.attributes

        params.gravity =Gravity.CENTER
        params.x = 0
        params.y = -20

        window.attributes = params




    }
}
