package com.project.wukay.wukayapp

import java.util.*
import kotlin.concurrent.schedule
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.KeyEvent
import android.view.MotionEvent
import android.view.View
import com.project.wukay.wukayapp.FeedAnimalsGame.FeedAnimalsControler
import com.project.wukay.wukayapp.FeedAnimalsGame.FeedAnimalsEasyTuto
import com.project.wukay.wukayapp.FeedAnimalsGame.FeedAnimalsHardControler
import com.project.wukay.wukayapp.FeedAnimalsGame.FeedAnimalsHardTuto
import com.project.wukay.wukayapp.util.Prefs
import com.project.wukay.wukayapp.whatIsThisAnimal.WhatIsThisAnimalActivity
import com.project.wukay.wukayapp.whatIsThisAnimal.WhatIsThisAnimalHardActivity
import com.project.wukay.wukayapp.whatIsThisAnimal.WhatIsThisAnimalHardTutoActivity
import com.project.wukay.wukayapp.whatIsThisAnimal.WhatIsThisAnimalTutoActivity
import kotlinx.android.synthetic.main.activity_hide_animals_hard.*
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

        //skin
        var skinName=prefs!!.skinName
        imageLapinou.setImageResource(skinName)

        //life
        var nbLife = prefs!!.nbLife

        //miniGame
        var randomGameTempo = prefs!!.num_mini_jeu
        var randomGame = Random().nextInt(3)

        val difficulty = intent.getStringExtra("difficulty")

        var etatTuto = true

        replayBt.setOnClickListener {
            if (nbLife <= 0) {

            }
            else {
                while(randomGameTempo==randomGame){
                    randomGame = Random().nextInt(3)
                }
                if (etatTuto) {
                    when (randomGame) {
                        0 -> {
                            if(difficulty=="easy"){
                                val nextGame = Intent(this@VictoryActivity, WhatIsThisAnimalTutoActivity::class.java)
                                nextGame.putExtra("difficulty", difficulty)
                                startActivity(nextGame)
                            }else{
                                val nextGame = Intent(this@VictoryActivity, WhatIsThisAnimalHardTutoActivity::class.java)
                                nextGame.putExtra("difficulty", difficulty)
                                startActivity(nextGame)

                            }

                        }
                        1 -> {
                            if (difficulty == "easy") {
                                val nextGame = Intent(this@VictoryActivity, HideAnimalsEasyTuto::class.java)
                                nextGame.putExtra("difficulty", difficulty)
                                startActivity(nextGame)
                            }
                            else {
                                val nextGame = Intent(this@VictoryActivity, HideAnimalsHardTuto::class.java)
                                nextGame.putExtra("difficulty", difficulty)
                                startActivity(nextGame)
                            }

                        }
                        2-> {
                            if (difficulty == "easy") {
                                val nextGame = Intent(this@VictoryActivity, FeedAnimalsEasyTuto::class.java)
                                nextGame.putExtra("difficulty", difficulty)
                                startActivity(nextGame)
                            }
                            else {
                                val nextGame = Intent(this@VictoryActivity, FeedAnimalsHardTuto::class.java)
                                nextGame.putExtra("difficulty", difficulty)
                                startActivity(nextGame)
                            }

                        }
                    }
                }
                else {
                    when (randomGame) {
                        0 -> {
                            if(difficulty=="easy"){
                                val nextGame = Intent(this@VictoryActivity, WhatIsThisAnimalActivity::class.java)
                                nextGame.putExtra("difficulty", difficulty)
                                startActivity(nextGame)
                            }else{
                                val nextGame = Intent(this@VictoryActivity, WhatIsThisAnimalHardActivity::class.java)
                                nextGame.putExtra("difficulty", difficulty)
                                startActivity(nextGame)

                            }

                        }
                        1 -> {
                            if (difficulty == "easy") {
                                val nextGame = Intent(this@VictoryActivity, HideAnimalsEasy::class.java)
                                nextGame.putExtra("difficulty", difficulty)
                                startActivity(nextGame)
                            }
                            else {
                                val nextGame = Intent(this@VictoryActivity, HideAnimals::class.java)
                                nextGame.putExtra("difficulty", difficulty)
                                startActivity(nextGame)
                            }

                        }
                        2-> {
                            if (difficulty == "easy") {
                                val nextGame = Intent(this@VictoryActivity, FeedAnimalsControler::class.java)
                                nextGame.putExtra("difficulty", difficulty)
                                startActivity(nextGame)
                            }
                            else {
                                val nextGame = Intent(this@VictoryActivity, FeedAnimalsHardControler::class.java)
                                nextGame.putExtra("difficulty", difficulty)
                                startActivity(nextGame)
                            }

                        }
                    }
                }


            }
            prefs!!.num_mini_jeu=randomGame
        }

        levelsBt.setOnClickListener {
            val next = Intent( this@VictoryActivity, VictoryActivity::class.java)
            next.putExtra("difficulty",difficulty)
            next.putExtra("carotsWon",nbCarrots)
            next.putExtra("isLastActivityIsAGame",true)
            startActivity(next)
        }




    }
}