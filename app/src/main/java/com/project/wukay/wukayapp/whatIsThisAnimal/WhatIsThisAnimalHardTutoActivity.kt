package com.project.wukay.wukayapp.whatIsThisAnimal

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.KeyEvent
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

        prefs = Prefs(this)

        //difficulty
        val intent = intent
        val difficulty = intent.getStringExtra("difficulty")


        startButtonTut.setOnClickListener {
            val nextGame = Intent(this@WhatIsThisAnimalHardTutoActivity, WhatIsThisAnimalHardActivity::class.java)
            nextGame.putExtra("difficulty", difficulty)
            startActivity(nextGame)
        }
    }
}