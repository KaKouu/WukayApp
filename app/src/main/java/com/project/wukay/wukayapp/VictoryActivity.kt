package com.project.wukay.wukayapp

import java.util.*
import kotlin.concurrent.schedule
import android.content.Intent
import android.os.Bundle
import android.os.Handler
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
import kotlinx.android.synthetic.main.activity_levels.*
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
        val nbCarrotForThisGame=intent.getIntExtra("nbCarrotForThisGame",0)
        val numberCarrotsWonText=intent.getStringExtra("numberCarrotsWonText")
        var numberCarrotsWonValue=numberCarrotsWonText.toInt()
        var nbCarrots=numberCarrotsWonValue
        carrotTxt.text="+$nbCarrotForThisGame"

        val lifeConso=intent.getIntExtra("numberLifeConso",0)
        shapeLife2.visibility = View.INVISIBLE
        heart2.visibility = View.INVISIBLE
        numberOfLife2.visibility = View.INVISIBLE
        prefs = Prefs(this)

        //skin
        var skinName=prefs!!.skinName
        imageLapinou.setImageResource(skinName)

        //life
        var nbLife = prefs!!.nbLife
        if (nbLife == 0) {
            prefs!!.nbLife=0
        }
        else {
            prefs!!.nbLife-=1
        }


        //miniGame
        var randomGameTempo = prefs!!.num_mini_jeu
        var randomGame = Random().nextInt(3)

        //levels


        prefs!!.actualLevel+=1
        System.out.println("NIVEAU : "+ prefs!!.actualLevel)

        val difficulty = intent.getStringExtra("difficulty")

        var etatTuto=prefs!!.etatTutoActiver

        replayBt.setOnClickListener {
            if (nbLife == 0) {
                shapeLife2.visibility = View.VISIBLE
                heart2.visibility = View.VISIBLE
                numberOfLife2.visibility = View.VISIBLE
                val handler = Handler()
                handler.postDelayed({
                    shapeLife2.visibility = View.INVISIBLE
                    heart2.visibility = View.INVISIBLE
                    numberOfLife2.visibility = View.INVISIBLE
                }, 2000)
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
                                nextGame.putExtra("carotsWon",nbCarrots)
                                nextGame.putExtra("nblifeConso",lifeConso)
                                startActivity(nextGame)
                            }else{
                                val nextGame = Intent(this@VictoryActivity, WhatIsThisAnimalHardTutoActivity::class.java)
                                nextGame.putExtra("difficulty", difficulty)
                                nextGame.putExtra("carotsWon",nbCarrots)
                                nextGame.putExtra("nblifeConso",lifeConso)
                                startActivity(nextGame)

                            }

                        }
                        1 -> {
                            if (difficulty == "easy") {
                                val nextGame = Intent(this@VictoryActivity, HideAnimalsEasyTuto::class.java)
                                nextGame.putExtra("difficulty", difficulty)
                                nextGame.putExtra("carotsWon",nbCarrots)
                                nextGame.putExtra("nblifeConso",lifeConso)
                                startActivity(nextGame)
                            }
                            else {
                                val nextGame = Intent(this@VictoryActivity, HideAnimalsHardTuto::class.java)
                                nextGame.putExtra("difficulty", difficulty)
                                nextGame.putExtra("carotsWon",nbCarrots)
                                nextGame.putExtra("nblifeConso",lifeConso)
                                startActivity(nextGame)
                            }

                        }
                        2-> {
                            if (difficulty == "easy") {
                                val nextGame = Intent(this@VictoryActivity, FeedAnimalsEasyTuto::class.java)
                                nextGame.putExtra("difficulty", difficulty)
                                nextGame.putExtra("carotsWon",nbCarrots)
                                nextGame.putExtra("nblifeConso",lifeConso)
                                startActivity(nextGame)
                            }
                            else {
                                val nextGame = Intent(this@VictoryActivity, FeedAnimalsHardTuto::class.java)
                                nextGame.putExtra("difficulty", difficulty)
                                nextGame.putExtra("carotsWon",nbCarrots)
                                nextGame.putExtra("nblifeConso",lifeConso)
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
                                nextGame.putExtra("carotsWon",nbCarrots)
                                nextGame.putExtra("nblifeConso",lifeConso)
                                startActivity(nextGame)
                            }else{
                                val nextGame = Intent(this@VictoryActivity, WhatIsThisAnimalHardActivity::class.java)
                                nextGame.putExtra("difficulty", difficulty)
                                nextGame.putExtra("carotsWon",nbCarrots)
                                nextGame.putExtra("nblifeConso",lifeConso)
                                startActivity(nextGame)

                            }

                        }
                        1 -> {
                            if (difficulty == "easy") {
                                val nextGame = Intent(this@VictoryActivity, HideAnimalsEasy::class.java)
                                nextGame.putExtra("difficulty", difficulty)
                                nextGame.putExtra("carotsWon",nbCarrots)
                                nextGame.putExtra("nblifeConso",lifeConso)
                                startActivity(nextGame)
                            }
                            else {
                                val nextGame = Intent(this@VictoryActivity, HideAnimals::class.java)
                                nextGame.putExtra("difficulty", difficulty)
                                nextGame.putExtra("carotsWon",nbCarrots)
                                nextGame.putExtra("nblifeConso",lifeConso)
                                startActivity(nextGame)
                            }

                        }
                        2-> {
                            if (difficulty == "easy") {
                                val nextGame = Intent(this@VictoryActivity, FeedAnimalsControler::class.java)
                                nextGame.putExtra("difficulty", difficulty)
                                nextGame.putExtra("carotsWon",nbCarrots)
                                nextGame.putExtra("nblifeConso",lifeConso)
                                startActivity(nextGame)
                            }
                            else {
                                val nextGame = Intent(this@VictoryActivity, FeedAnimalsHardControler::class.java)
                                nextGame.putExtra("difficulty", difficulty)
                                nextGame.putExtra("carotsWon",nbCarrots)
                                nextGame.putExtra("nblifeConso",lifeConso)
                                startActivity(nextGame)
                            }

                        }
                    }
                }


            }
            prefs!!.num_mini_jeu=randomGame
        }

        levelsBt.setOnClickListener {
            val next = Intent( this@VictoryActivity, LevelsActivity::class.java)
            next.putExtra("difficulty",difficulty)
            next.putExtra("carotsWon",nbCarrots)
            next.putExtra("nblifeConso",lifeConso)
            next.putExtra("isLastActivityIsAGame",true)
            startActivity(next)
        }




    }
}