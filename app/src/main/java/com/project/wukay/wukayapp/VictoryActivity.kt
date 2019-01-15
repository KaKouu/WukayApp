package com.project.wukay.wukayapp

import java.util.*
import kotlin.concurrent.schedule
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.KeyEvent
import android.view.MotionEvent
import android.view.View
import com.project.wukay.wukayapp.util.Prefs
import kotlinx.android.synthetic.main.activity_hide_animals.*
import kotlinx.android.synthetic.main.activity_victory.*

class VictoryActivity : AppCompatActivity() {

    private var prefs: Prefs? = null

    override fun onKeyDown(keyCode: Int, event: KeyEvent): Boolean {
        return if (keyCode == KeyEvent.KEYCODE_BACK) {
            false
        } else super.onKeyDown(keyCode, event)
    }

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_victory)

        //var nbCarrots =(1..10).shuffled().first()
        val numberCarrotsWonText=intent.getStringExtra("numberCarrotsWonText")
        var numberCarrotsWonValue=numberCarrotsWonText.toInt()
        var nbCarrots=numberCarrotsWonValue
        carrotTxt.text="+$nbCarrots"

        prefs = Prefs(this)
        var skinName=prefs!!.skinName
        imageLapinou.setImageResource(skinName)


        val difficulty = intent.getStringExtra("difficulty")

        Timer().schedule(1000) {
            val next = Intent( this@VictoryActivity, LevelsActivity::class.java)
            next.putExtra("difficulty",difficulty)
            next.putExtra("carotsWon",nbCarrots)
            next.putExtra("isLastActivityIsAGame",true)

            startActivity(next)
        }
    }
}