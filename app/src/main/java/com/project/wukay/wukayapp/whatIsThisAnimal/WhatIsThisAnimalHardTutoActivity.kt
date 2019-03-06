package com.project.wukay.wukayapp.whatIsThisAnimal

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.DisplayMetrics
import android.view.KeyEvent
import android.view.View
import android.view.animation.TranslateAnimation
import com.project.wukay.wukayapp.R
import com.project.wukay.wukayapp.util.Prefs
import kotlinx.android.synthetic.main.activity_what_is_this_tuto_hard.*



class WhatIsThisAnimalHardTutoActivity : AppCompatActivity() {


    override fun onKeyDown(keyCode: Int, event: KeyEvent): Boolean {
        return if (keyCode == KeyEvent.KEYCODE_BACK) {
            false
        } else super.onKeyDown(keyCode, event)
    }

    private var prefs: Prefs? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_what_is_this_tuto_hard)

        val displayMetrics = DisplayMetrics()
        windowManager.defaultDisplay.getMetrics(displayMetrics)
        val heightScreen = displayMetrics.heightPixels
        val widthScreen = displayMetrics.widthPixels

        prefs = Prefs(this)

        //difficulty
        val intent = intent
        val difficulty = intent.getStringExtra("difficulty")
        var nbCarrots = intent.getIntExtra("carotsWon",0)

        coche.visibility = View.INVISIBLE
        val animation = TranslateAnimation(0f, 0f, 0f, heightScreen*1/3.toFloat())
        animation.duration = 4000
        curseur.startAnimation(animation)
        animation.fillAfter = true

        val handler = Handler()
        handler.postDelayed({
            coche.visibility = View.VISIBLE
        }, 4100)


        startButtonTut.setOnClickListener {
            val nextGame = Intent(this@WhatIsThisAnimalHardTutoActivity, WhatIsThisAnimalHardActivity::class.java)
            nextGame.putExtra("difficulty", difficulty)
            nextGame.putExtra("carotsWon",nbCarrots)
            startActivity(nextGame)
        }
    }
}
