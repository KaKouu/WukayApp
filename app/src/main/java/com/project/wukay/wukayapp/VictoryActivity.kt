package com.project.wukay.wukayapp

import java.util.*
import kotlin.concurrent.schedule
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.MotionEvent
import android.view.View
import com.project.wukay.wukayapp.util.Prefs
import kotlinx.android.synthetic.main.activity_hide_animals.*
import kotlinx.android.synthetic.main.activity_victory.*

class VictoryActivity : AppCompatActivity() {

    private var prefs: Prefs? = null
    private val after = Intent( this@VictoryActivity, LevelsActivity::class.java)

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_victory)

        //var nbCarrots =(1..10).shuffled().first()
        val numberCarrotsWonText=intent.getStringExtra("numberCarrotsWonText")
        var numberCarrotsWonValue=numberCarrotsWonText.toInt()
        var nbCarrots=numberCarrotsWonValue
        carrotTxt.text="+$nbCarrots"
        after.putExtra("difficulty",difficulty)
        after.putExtra("carotsWon",nbCarrots)
        after.putExtra("isLastActivityIsAGame",true)

        prefs = Prefs(this)
        var skinName=prefs!!.skinName
        imageLapinou.setImageResource(skinName)



        layoutVictory.setOnTouchListener { v: View, m: MotionEvent ->
            handleTouch(m)
            true
        }

    }
    val difficulty = intent.getStringExtra("difficulty")
    private fun handleTouch(m: MotionEvent){
        startActivity(after)
    }
}