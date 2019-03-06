package com.project.wukay.wukayapp.whatIsThisAnimal

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.DisplayMetrics
import android.view.KeyEvent
import android.view.animation.TranslateAnimation
import com.project.wukay.wukayapp.R
import com.project.wukay.wukayapp.util.Prefs
import kotlinx.android.synthetic.main.activity_what_is_this_animal_tuto.*

class WhatIsThisAnimalTutoActivity : AppCompatActivity() {


    private var prefs: Prefs? = null

    override fun onKeyDown(keyCode: Int, event: KeyEvent): Boolean {
        return if (keyCode == KeyEvent.KEYCODE_BACK) {
            false
        } else super.onKeyDown(keyCode, event)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_what_is_this_animal_tuto)

        prefs = Prefs(this)

        //difficulty
        val intent = intent
        val difficulty = intent.getStringExtra("difficulty")
        var nbCarrots = intent.getIntExtra("carotsWon",0)

        val displayMetrics = DisplayMetrics()
        windowManager.defaultDisplay.getMetrics(displayMetrics)
        val heightScreen = displayMetrics.heightPixels
        val widthScreen = displayMetrics.widthPixels

        val animation = TranslateAnimation(0f, 0f, 0f, -heightScreen*47/100.toFloat())
        animation.duration = 5000
        tutAnimal2.startAnimation(animation)
        tutCurseur.startAnimation(animation)
        animation.fillAfter = true

        startButton.setOnClickListener {
            animation.cancel()
            animation.fillAfter = false

            val nextGame = Intent(this@WhatIsThisAnimalTutoActivity, WhatIsThisAnimalActivity::class.java)
            nextGame.putExtra("difficulty", difficulty)
            nextGame.putExtra("carotsWon",nbCarrots)
            startActivity(nextGame)
        }
    }
}
