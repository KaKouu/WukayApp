package com.project.wukay.wukayapp.whatIsThisAnimal

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
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


        val animation = TranslateAnimation(0f, 0f, 0f, -800f)
        animation.duration = 5000
        tutAnimal2.startAnimation(animation)
        tutCurseur.startAnimation(animation)
        animation.fillAfter = true

        startButton.setOnClickListener {
            animation.cancel()
            animation.fillAfter = false

            val nextGame = Intent(this@WhatIsThisAnimalTutoActivity, WhatIsThisAnimalActivity::class.java)
            nextGame.putExtra("difficulty", difficulty)
            startActivity(nextGame)
        }
    }
}
