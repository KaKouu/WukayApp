package com.project.wukay.wukayapp

import java.util.*
import kotlin.concurrent.schedule
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_victory.*

class VictoryActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_victory)

        var nbCarrots =(1..10).shuffled().first()
        carrotTxt.text="+$nbCarrots"


        val difficulty = intent.getStringExtra("difficulty")

        Timer().schedule(5000) {
            val next = Intent( this@VictoryActivity, LevelsActivity::class.java)
            next.putExtra("difficulty",difficulty)
            next.putExtra("carotsWon",nbCarrots)



            startActivity(next)
        }
    }
}