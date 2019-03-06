package com.project.wukay.wukayapp

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.support.v7.app.AppCompatActivity
import android.util.DisplayMetrics
import android.view.KeyEvent
import android.view.View
import android.view.animation.TranslateAnimation
import com.project.wukay.wukayapp.util.Prefs
import kotlinx.android.synthetic.main.activity_hide_animals_easy_tuto.*
import kotlinx.android.synthetic.main.activity_what_is_this_animal_tuto.*


class HideAnimalsEasyTuto : AppCompatActivity()  {
    private var prefs: Prefs? = null
    override fun onKeyDown(keyCode: Int, event: KeyEvent): Boolean {
        return if (keyCode == KeyEvent.KEYCODE_BACK) {
            false
        } else super.onKeyDown(keyCode, event)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hide_animals_easy_tuto)

        prefs = Prefs(this)

        //difficulty
        val intent = intent
        val difficulty = intent.getStringExtra("difficulty")
        var nbCarrots = intent.getIntExtra("carotsWon",0)
        val displayMetrics = DisplayMetrics()
        windowManager.defaultDisplay.getMetrics(displayMetrics)
        val heightScreen = displayMetrics.heightPixels
        val widthScreen = displayMetrics.widthPixels

        cocheHide.visibility = View.INVISIBLE

        val animation = TranslateAnimation(0f, -widthScreen*23/100.toFloat(), 0f, 0f)
        animation.duration = 2000
        curseurHide.startAnimation(animation)
        animation.fillAfter = true

        val handler = Handler()
        handler.postDelayed({
            cocheHide.visibility = View.VISIBLE
        }, 2100)

        startButtonHide.setOnClickListener {
            val nextGame = Intent(this@HideAnimalsEasyTuto, HideAnimalsEasy::class.java)
            nextGame.putExtra("difficulty", difficulty)
            nextGame.putExtra("carotsWon",nbCarrots)
            startActivity(nextGame)
        }
    }
}