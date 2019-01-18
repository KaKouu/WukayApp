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

class FeedAnimalsEasyTuto : AppCompatActivity() {
    private var prefs: Prefs? = null
    override fun onKeyDown(keyCode: Int, event: KeyEvent): Boolean {
        return if (keyCode == KeyEvent.KEYCODE_BACK) {
            false
        } else super.onKeyDown(keyCode, event)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_feed_animals_easy_tuto)

        prefs = Prefs(this)

        //difficulty
        val intent = intent
        val difficulty = intent.getStringExtra("difficulty")

        cocheFeed.visibility = View.INVISIBLE

        val animation = TranslateAnimation(0f, 0f, 0f, 300f)
        animation.duration = 2000
        curseurFeed.startAnimation(animation)
        animation.fillAfter = true

        val handler1 = Handler()
        handler1.postDelayed({
            val animation2 = TranslateAnimation(0f, 0f, 0f, -500f)
            animation2.duration = 2000
            val animation3 = TranslateAnimation(0f, 0f, 300f, -500f)
            animation2.duration = 2000
            viandeFeed.startAnimation(animation2)
            curseurFeed.startAnimation(animation3)
            animation2.fillAfter = true
            animation3.fillAfter = true
        }, 2200)


        val handler = Handler()
        handler.postDelayed({
            cocheFeed.visibility = View.VISIBLE
        }, 4500)

        startButtonFeed.setOnClickListener {
            val nextGame = Intent(this@FeedAnimalsEasyTuto, FeedAnimalsControler::class.java)
            nextGame.putExtra("difficulty", difficulty)
            startActivity(nextGame)
        }
    }
}