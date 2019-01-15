package com.project.wukay.wukayapp

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.TranslateAnimation
import com.project.wukay.wukayapp.util.Prefs
import kotlinx.android.synthetic.main.activity_what_is_this_animal_tuto.*

class WhatIsThisAnimalTutoActivity : AppCompatActivity() {


    private var prefs: Prefs? = null

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
            animation.setFillAfter(false)

            val nextGame = Intent(this@WhatIsThisAnimalTutoActivity, com.project.wukay.wukayapp.WhatIsThisAnimalActivity::class.java)
            nextGame.putExtra("difficulty", difficulty)
            startActivity(nextGame)
        }
    }
}
