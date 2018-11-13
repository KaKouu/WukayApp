package com.project.wukay.wukayapp

import java.util.*
import kotlin.concurrent.schedule
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity

class Victory : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.victory)

        Timer().schedule(10000) {
            val next = Intent( this@Victory, LevelsActivity::class.java)
            next.putExtra("carotsWon",(1..10).shuffled().first())
            startActivity(next)
        }
    }
}