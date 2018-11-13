package com.project.wukay.wukayapp

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.project.wukay.wukayapp.util.Prefs

import kotlinx.android.synthetic.main.activity_levels.*

class LevelsActivity : AppCompatActivity() {

    private var prefs: Prefs? = null




    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_levels)

        prefs = Prefs(this)

        val intent = intent
        val difficulty = intent.getStringExtra("difficulty")


        imageRetour.setOnClickListener{
            val previousPage = Intent(this@LevelsActivity, HomeActivity::class.java)
            startActivity(previousPage)
        }


        playButton.setOnClickListener {

            val nextGame = Intent(this@LevelsActivity, WhatIsThisActivity::class.java)
            nextGame.putExtra("difficulty", difficulty)
            startActivity(nextGame)
        }




        // counter of carots
        var carrots=prefs!!.nbLapin

        var testNbCarrotsGagnePrecedement=intent.getIntExtra("carotsWon",0)
        carrots+=testNbCarrotsGagnePrecedement





// Enregistrer les donnés
        prefs!!.nbCarrots=carrots
        numberCarrots.text = carrots.toString()

        testCarrotes.setOnClickListener {
            var nb = (1..3).shuffled().first()
            carrots=carrots+nb
            numberCarrots.setText(carrots.toString())
        }


    }


}
