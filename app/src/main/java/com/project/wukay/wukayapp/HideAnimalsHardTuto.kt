package com.project.wukay.wukayapp

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.support.v7.app.AppCompatActivity
import android.view.KeyEvent
import android.view.View
import android.view.animation.TranslateAnimation
import com.project.wukay.wukayapp.util.Prefs
import kotlinx.android.synthetic.main.activity_hide_animals_easy_tuto.*
import kotlinx.android.synthetic.main.activity_hide_animals_hard_tuto.*
import java.lang.Thread.sleep

class HideAnimalsHardTuto : AppCompatActivity() {
    private var prefs: Prefs? = null
    override fun onKeyDown(keyCode: Int, event: KeyEvent): Boolean {
        return if (keyCode == KeyEvent.KEYCODE_BACK) {
            false
        } else super.onKeyDown(keyCode, event)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hide_animals_hard_tuto)

        prefs = Prefs(this)

        //difficulty
        val intent = intent
        val difficulty = intent.getStringExtra("difficulty")

        cocheHide2.visibility = View.INVISIBLE

        val animation = TranslateAnimation(0f, 250f, 0f, 0f)
        animation.duration = 2000
        curseurHide2.startAnimation(animation)
        animation.fillAfter = true

        val handler1 = Handler()
        handler1.postDelayed({
            val animation2 = TranslateAnimation(250f, -475f, 0f, 0f)
            animation2.duration = 4000
            val animationbis2 = TranslateAnimation(0f, -500f, 0f, 0f)
            animationbis2.duration = 4000
            rocher2.startAnimation(animationbis2)
            curseurHide2.startAnimation(animation2)
            animation2.fillAfter = true
            animationbis2.fillAfter = true
        }, 2200)

        val handler2 = Handler()
        handler2.postDelayed({
            val animation3 = TranslateAnimation(0f, 400f, 0f, 0f)
            animation3.duration = 4000
            curseurHide2.startAnimation(animation3)
            animation3.fillAfter = true
        }, 4400)

        val handler = Handler()
        handler.postDelayed({
            cocheHide2.visibility = View.VISIBLE
        }, 10100)

        startButtonHide2.setOnClickListener {
            val nextGame = Intent(this@HideAnimalsHardTuto, HideAnimals::class.java)
            nextGame.putExtra("difficulty", difficulty)
            startActivity(nextGame)
        }
    }
}