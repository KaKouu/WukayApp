package com.project.wukay.wukayapp

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.project.wukay.wukayapp.util.Prefs
import kotlinx.android.synthetic.main.activity_in_app_bill.*

class InAppBilling : AppCompatActivity() {
    private var nbCarrot=0
    private var difficulte=""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_in_app_bill)

        var prefs = Prefs(this)
        val difficulty = intent.getStringExtra("difficulty")
        nbCarrot=prefs!!.nbCarrots
        button2.setOnClickListener {

            val next = Intent( this@InAppBilling, LevelsActivity::class.java)
            next.putExtra("difficulty",difficulty)
            next.putExtra("carotsWon",100)
            next.putExtra("isLastActivityIsAGame",false)

            startActivity(next)
        }
        button3.setOnClickListener {

            val next = Intent( this@InAppBilling, LevelsActivity::class.java)
            next.putExtra("difficulty",difficulty)
            next.putExtra("carotsWon",500)
            next.putExtra("isLastActivityIsAGame",false)

            startActivity(next)
        }

    }


}