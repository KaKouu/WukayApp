package com.project.wukay.wukayapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.DisplayMetrics
import android.view.Gravity
import android.view.WindowManager.LayoutParams
import com.project.wukay.wukayapp.util.Prefs
import kotlinx.android.synthetic.main.activity_life_pop.*

class WinPopActivity : AppCompatActivity() {

    private var prefs: Prefs? = null
    companion object {
        private const val HEIGHT = 600
        private const val WIDTH = 1000


    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_win_pop)

        val intent = intent

        prefs = Prefs(this)

        prefs!!.nbCarrots+=20

        closeButton.setOnClickListener {
            finish()
        }

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
