package com.project.wukay.wukayapp.whatIsThisAnimal

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.Vibrator
import android.support.v7.app.AppCompatActivity
import android.view.KeyEvent
import com.project.wukay.wukayapp.R
import com.project.wukay.wukayapp.VictoryActivity
import kotlinx.android.synthetic.main.activity_hard_what_is_this.*
import java.util.*

class WhatIsThisAnimalHardActivity: AppCompatActivity()  {

    override fun onKeyDown(keyCode: Int, event: KeyEvent): Boolean {
        return if (keyCode == KeyEvent.KEYCODE_BACK) {
            false
        } else super.onKeyDown(keyCode, event)
    }


    override fun onCreate(savedInstanceState: Bundle?) {

        // mise en place du layout
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hard_what_is_this)

        //déclaration des variables
        val difficulty = intent.getStringExtra("difficulty") //renvaiera la difficulté choisit precedement
        val nextAnimal = Intent(this@WhatIsThisAnimalHardActivity, VictoryActivity::class.java)
        nextAnimal.putExtra("difficulty", difficulty)



        var numberCarrotsWon=10

        val vibratorService = getSystemService(Context.VIBRATOR_SERVICE) as Vibrator


        //CODE DE LA PARTIE DIFFICILE
        var numberWin = 0

        val arrayOfAnimalsPicture = arrayOf(
            R.drawable.animaux_cochon,
            R.drawable.animaux_vache,
            R.drawable.animaux_girafe,
            R.drawable.animaux_bouc,
            R.drawable.animaux_chat,
            R.drawable.animaux_crabe,
            R.drawable.animaux_morse,
            R.drawable.animaux_panda,
            R.drawable.animaux_paon,
            R.drawable.animaux_pingouin,
            R.drawable.animaux_poule,
            R.drawable.animaux_tigre,
            R.drawable.animaux_zebre,
            R.drawable.animaux_lion
        )

        val arrayOfQuestion = arrayOf(
            "Je suis rose, je me roule dans la boue et j'ai une queue en tire bouchon",
            "Je fais du lait et j'ai des tâches noires et blanches",
            "J'ai un long cou et je vis dans la savane",
            "Je suis le mari de la chèvre et j'ai des cornes",
            "Je ronronne quand on me caresse",
            "J'ai des pinces et je vis sur la plage",
            "J'ai de grandes dents et je vis sur la glace",
            "Je suis noir et blanc et je mange des bambous",
            "Je fais la roue avec ma queue",
            "Je vis sur la glace et je glisse sur mon ventre",
            "Je ponds des oeufs et je picore le grain",
            "J'ai des griffes et je vis dans la savane",
            "Je suis rayé de noir et de blanc",
            "Je suis le roi de la savane et j'ai une belle crinière"
        )

        description.text = ""
        var nombreDeReponsesPossibles = 3
        var memoAnimauxChoisi = IntArray(nombreDeReponsesPossibles)
        var reponse: Int
        var rand = Random()
        var ouMettreLaReponse: Int

        reponse = rand.nextInt(arrayOfAnimalsPicture.size)
        ouMettreLaReponse = rand.nextInt(nombreDeReponsesPossibles)

        game(
            arrayOfQuestion,
            reponse,
            nombreDeReponsesPossibles,
            memoAnimauxChoisi,
            rand,
            arrayOfAnimalsPicture,
            ouMettreLaReponse
        )

        answer1.setOnClickListener {
            if (memoAnimauxChoisi[0] == reponse) {

                numberWin += 1
                if (numberWin == 3) {
                    var numberCarrotsWonText = numberCarrotsWon.toString()
                    nextAnimal.putExtra("numberCarrotsWonText", numberCarrotsWonText)
                    startActivity(nextAnimal)


                } else {
                    reponse = rand.nextInt(arrayOfAnimalsPicture.size - 1)
                    ouMettreLaReponse = rand.nextInt(nombreDeReponsesPossibles)


                    game(
                        arrayOfQuestion,
                        reponse,
                        nombreDeReponsesPossibles,
                        memoAnimauxChoisi,
                        rand,
                        arrayOfAnimalsPicture,
                        ouMettreLaReponse
                    )
                }

            } else {
                description.text = "Essaye encore !"
                vibratorService.vibrate(100)
                if (numberCarrotsWon > 1) {
                    numberCarrotsWon -= 1
                }
            }

        }
        answer2.setOnClickListener {
            if (memoAnimauxChoisi.get(1) == reponse) {

                numberWin += 1
                if (numberWin == 3) {
                    var numberCarrotsWonText = numberCarrotsWon.toString()
                    nextAnimal.putExtra("numberCarrotsWonText", numberCarrotsWonText)
                    startActivity(nextAnimal)
                } else {
                    reponse = rand.nextInt(arrayOfAnimalsPicture.size - 1)
                    ouMettreLaReponse = rand.nextInt(nombreDeReponsesPossibles)


                    game(
                        arrayOfQuestion,
                        reponse,
                        nombreDeReponsesPossibles,
                        memoAnimauxChoisi,
                        rand,
                        arrayOfAnimalsPicture,
                        ouMettreLaReponse
                    )
                }
            } else {
                description.text = "Essaye encore !"
                vibratorService.vibrate(100)
                if (numberCarrotsWon > 1) {
                    numberCarrotsWon -= 1
                }
            }
        }
        answer3.setOnClickListener {
            if (memoAnimauxChoisi.get(2) == reponse) {

                numberWin += 1
                if (numberWin == 3) {
                    var numberCarrotsWonText = numberCarrotsWon.toString()
                    nextAnimal.putExtra("numberCarrotsWonText", numberCarrotsWonText)
                    startActivity(nextAnimal)

                } else {
                    reponse = rand.nextInt(arrayOfAnimalsPicture.size - 1)
                    ouMettreLaReponse = rand.nextInt(nombreDeReponsesPossibles)


                    game(
                        arrayOfQuestion,
                        reponse,
                        nombreDeReponsesPossibles,
                        memoAnimauxChoisi,
                        rand,
                        arrayOfAnimalsPicture,
                        ouMettreLaReponse
                    )
                }
            } else {
                description.text = "Essaye encore !"
                vibratorService.vibrate(100)
                if (numberCarrotsWon > 1) {
                    numberCarrotsWon -= 1
                }
            }
        }

    }


    private fun game(
        arrayOfQuestion: Array<String>,
        reponse: Int,
        nombreDeReponsesPossibles: Int,
        memoAnimauxChoisi: IntArray,
        rand: Random,
        arrayOfAnimalsPicture: Array<Int>,
        ouMettreLaReponse: Int
    ) {
        question.text = arrayOfQuestion[reponse]
        description.text = ""
        var i = 0

        while (i < nombreDeReponsesPossibles) {
            System.out.print(i)
            memoAnimauxChoisi[i] = -1
            i++
        }

        var j = 0
        while (j < memoAnimauxChoisi.size) {

            var temp = rand.nextInt(arrayOfAnimalsPicture.size)

            while (memoAnimauxChoisi.contains(temp) || temp == reponse) {
                temp = rand.nextInt(arrayOfAnimalsPicture.size)
            }

            memoAnimauxChoisi[j] = temp
            j++
        }
        memoAnimauxChoisi[ouMettreLaReponse] = reponse

        answer1.setImageResource(arrayOfAnimalsPicture[memoAnimauxChoisi[0]])
        answer2.setImageResource(arrayOfAnimalsPicture[memoAnimauxChoisi[1]])
        answer3.setImageResource(arrayOfAnimalsPicture[memoAnimauxChoisi[2]])
    }


}