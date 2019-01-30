package com.project.wukay.wukayapp.FeedAnimalsGame

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.support.v7.app.AppCompatActivity
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

        cocheFeedHard.visibility = View.INVISIBLE

        val animation = TranslateAnimation(0f, 0f, 0f, -275f)
        animation.duration = 2000
        curseurFeedHard.startAnimation(animation)
        animation.fillAfter = true

        val handler1 = Handler()
        handler1.postDelayed({
            val animation2 = TranslateAnimation(0f, -550f, -275f, -275f)
            animation2.duration = 3500
            val animation2bis = TranslateAnimation(0f, -500f, 0f, 0f)
            animation2bis.duration = 4000
            herbeFood.startAnimation(animation2bis)
            curseurFeedHard.startAnimation(animation2)
            animation2.fillAfter = true
            animation2bis.fillAfter = true
        }, 2200)

        val handler2 = Handler()
        handler2.postDelayed({
            val animation3 = TranslateAnimation(-550f, 1f, -275f, -275f)
            animation3.duration = 2000
            curseurFeedHard.startAnimation(animation3)
            animation3.fillAfter = true
        }, 6000)


        val handler3 = Handler()
        handler3.postDelayed({
            val animation4 = TranslateAnimation(1f, -300f, -275f, -275f)
            animation4.duration = 4500
            val animation4bis = TranslateAnimation(0f, -250f, 0f, 0f)
            animation4bis.duration = 5000
            food1.startAnimation(animation4bis)
            curseurFeedHard.startAnimation(animation4)
            animation4.fillAfter = true
            animation4bis.fillAfter = true
        }, 9000)

        val handler4 = Handler()
        handler4.postDelayed({
            val animation5 = TranslateAnimation(-300f, -300f, -275f, -1050f)
            animation5.duration = 4000
            val animation5bis = TranslateAnimation(-250f, -250f, 0f, -750f)
            animation5bis.duration = 4000
            food1.startAnimation(animation5bis)
            curseurFeedHard.startAnimation(animation5)
            animation5.fillAfter = true
            animation5bis.fillAfter = true
        }, 11000)

        val handler = Handler()
        handler.postDelayed({
            cocheFeedHard.visibility = View.VISIBLE
        }, 15000)

        startButtonFeedHard.setOnClickListener {
            val nextGame = Intent(this@FeedAnimalsHardTuto, FeedAnimalsControler::class.java)
            nextGame.putExtra("difficulty", difficulty)
            startActivity(nextGame)
        }
    }
}