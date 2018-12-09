package com.project.wukay.wukayapp

import java.util.*
import kotlin.concurrent.schedule
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.project.wukay.wukayapp.util.Prefs
import kotlinx.android.synthetic.main.activity_victory.*

class VictoryActivity : AppCompatActivity() {

    private var prefs: Prefs? = null


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_victory)

        var nbCarrots =(1..10).shuffled().first()
        carrotTxt.text="+$nbCarrots"

        prefs = Prefs(this)
        var skinName=prefs!!.skinName
        imageLapinou.setImageResource(skinName)


        val difficulty = intent.getStringExtra("difficulty")

        Timer().schedule(5000) {
            val next = Intent( this@VictoryActivity, LevelsActivity::class.java)
            next.putExtra("difficulty",difficulty)
            next.putExtra("carotsWon",nbCarrots)
            next.putExtra("isLastActivityIsAGame",true)



            startActivity(next)
        }
    }
}