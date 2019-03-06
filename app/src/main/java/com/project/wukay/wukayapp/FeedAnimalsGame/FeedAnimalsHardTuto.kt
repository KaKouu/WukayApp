package com.project.wukay.wukayapp.FeedAnimalsGame

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.support.v7.app.AppCompatActivity
import android.util.DisplayMetrics
import android.view.KeyEvent
import android.view.View
import android.view.animation.TranslateAnimation
import com.project.wukay.wukayapp.R
import com.project.wukay.wukayapp.util.Prefs
import kotlinx.android.synthetic.main.activity_feed_animals_easy_tuto.*
import kotlinx.android.synthetic.main.activity_feed_animals_hard_tuto.*

class FeedAnimalsHardTuto : AppCompatActivity() {
    private var prefs: Prefs? = null
    override fun onKeyDown(keyCode: Int, event: KeyEvent): Boolean {
        return if (keyCode == KeyEvent.KEYCODE_BACK) {
            false
        } else super.onKeyDown(keyCode, event)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_feed_animals_hard_tuto)

        prefs = Prefs(this)

        //difficulty
        val intent = intent
        val difficulty = intent.getStringExtra("difficulty")
        var nbCarrots = intent.getIntExtra("carotsWon",0)

        val displayMetrics = DisplayMetrics()
        windowManager.defaultDisplay.getMetrics(displayMetrics)
        val heightScreen = displayMetrics.heightPixels
        val widthScreen = displayMetrics.widthPixels


        cocheFeedHard.visibility = View.INVISIBLE

        val animation = TranslateAnimation(0f, 0f, 0f, -heightScreen*3/25.toFloat())
        animation.duration = 2000
        curseurFeedHard.startAnimation(animation)
        animation.fillAfter = true

        val handler1 = Handler()
        handler1.postDelayed({
            val animation2 = TranslateAnimation(0f, -widthScreen*1/2.toFloat(), -heightScreen*3/25.toFloat(), -heightScreen*3/25.toFloat())
            animation2.duration = 4000
            val animation2bis = TranslateAnimation(0f, -widthScreen*1/2.toFloat(), 0f, 0f)
            animation2bis.duration = 4000
            herbeFood.startAnimation(animation2bis)
            curseurFeedHard.startAnimation(animation2)
            animation2.fillAfter = true
            animation2bis.fillAfter = true
        }, 2200)

        val handler2 = Handler()
        handler2.postDelayed({
            val animation3 = TranslateAnimation(-widthScreen*1/2.toFloat(), widthScreen*1/100.toFloat(), -heightScreen*3/25.toFloat(), -heightScreen*3/25.toFloat())
            animation3.duration = 2000
            curseurFeedHard.startAnimation(animation3)
            animation3.fillAfter = true
        }, 6000)


        val handler3 = Handler()
        handler3.postDelayed({
            val animation4 = TranslateAnimation(widthScreen*1/100.toFloat(), -widthScreen*3/10.toFloat(), -heightScreen*3/25.toFloat(), -heightScreen*3/25.toFloat())
            animation4.duration = 2000
            val animation4bis = TranslateAnimation(0f, -widthScreen*3/10.toFloat(), 0f, 0f)
            animation4bis.duration = 2000
            food1.startAnimation(animation4bis)
            curseurFeedHard.startAnimation(animation4)
            animation4.fillAfter = true
            animation4bis.fillAfter = true
        }, 8000)

        val handler4 = Handler()
        handler4.postDelayed({
            val animation5 = TranslateAnimation(-widthScreen*3/10.toFloat(), -widthScreen*3/10.toFloat(), -heightScreen*3/25.toFloat(), -heightScreen*1/2.toFloat())
            animation5.duration = 4000
            val animation5bis = TranslateAnimation(-widthScreen*3/10.toFloat(), -widthScreen*3/10.toFloat(), 0f, -heightScreen*2/5.toFloat())
            animation5bis.duration = 4000
            food1.startAnimation(animation5bis)
            curseurFeedHard.startAnimation(animation5)
            animation5.fillAfter = true
            animation5bis.fillAfter = true
        }, 10000)

        val handler = Handler()
        handler.postDelayed({
            cocheFeedHard.visibility = View.VISIBLE
        }, 15000)

        startButtonFeedHard.setOnClickListener {
            val nextGame = Intent(this@FeedAnimalsHardTuto, FeedAnimalsControler::class.java)
            nextGame.putExtra("difficulty", difficulty)
            nextGame.putExtra("carotsWon",nbCarrots)
            startActivity(nextGame)
        }
    }
}