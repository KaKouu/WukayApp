package com.project.wukay.wukayapp.whatIsThisAnimal

import android.content.Context
import android.content.Intent
import android.media.MediaPlayer
import android.os.Bundle
import android.os.Vibrator
import android.support.v7.app.AppCompatActivity
import android.view.KeyEvent
import com.project.wukay.wukayapp.IHM.DifficultyActivity
import com.project.wukay.wukayapp.PopUpAnimalFind
import com.project.wukay.wukayapp.R
import com.project.wukay.wukayapp.VictoryActivity
import kotlinx.android.synthetic.main.activity_hard_what_is_this.*
import kotlinx.android.synthetic.main.activity_what_is_this.*
import java.util.*

class WhatIsThisAnimalHardActivity: AppCompatActivity()  {
    var random = Random()
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



        val vibratorService = getSystemService(Context.VIBRATOR_SERVICE) as Vibrator

        buttonBack2.setOnClickListener{
            val previousPage = Intent(this@WhatIsThisAnimalHardActivity, DifficultyActivity::class.java)
            startActivity(previousPage)
        }

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
        val arrayNameAnimal=arrayOf(
            "Le cochon",
            "La vache",
            "La girafe",
            "Le bouc",
            "Le chat",
            "Le crabe",
            "Le morse",
            "Le panda",
            "Le paon",
            "Le pingouin",
            "La poule",
            "Le tigre",
            "Le zèbre",
            "Le lion"
        )
        val arrayMusicAnimal=arrayOf(
            R.raw.sound_cochon,
            R.raw.sound_vache,
            R.raw.sound_girafe,
            R.raw.sound_bouc,
            R.raw.sound_cat,
            R.raw.sound_crabe,
            R.raw.sound_morse,
            R.raw.sound_panda,
            R.raw.sound_paon,
            R.raw.sound_pinguoin,
            R.raw.sound_poule,
            R.raw.sound_tigre,
            R.raw.sound_zebre,
            R.raw.sound_lion
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

        if(numberWin==0){
            scoreImageHard.setImageResource(R.drawable.tete_lapinou_score_0)
        }else{
            if(numberWin==1){
                scoreImageHard.setImageResource(R.drawable.tete_lapinou_score_1)
            }else{
                if(numberWin==2){
                    scoreImageHard.setImageResource(R.drawable.tete_lapinou_score_2)
                }else{
                    if(numberWin==3){
                        scoreImageHard.setImageResource(R.drawable.tete_lapinou_score_3)

                    }
                }
            }
        }

        answer1.setOnClickListener {
            if (memoAnimauxChoisi[0] == reponse) {

                numberWin += 1
                val popIntent = Intent(applicationContext, PopUpAnimalFind::class.java)
                popIntent.putExtra("animalFind",arrayOfAnimalsPicture[reponse])
                popIntent.putExtra("animalNameFind",arrayNameAnimal[reponse])

               val music = MediaPlayer.create(this,arrayMusicAnimal[reponse])
                startActivity(popIntent)
               music.start()
                if (numberWin == 3) {
                    var beforeCarrots = intent.getIntExtra("carotsWon",0)
                    var nbCarrotForThisGame = 1 + random.nextInt(10 - 1)
                    var numberCarrotsWonText=((nbCarrotForThisGame) + beforeCarrots).toString()
                    nextAnimal.putExtra("numberCarrotsWonText", numberCarrotsWonText)
                    nextAnimal.putExtra("nbCarrotForThisGame", nbCarrotForThisGame)
                    startActivity(nextAnimal)
                    startActivity(popIntent)


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
            }

        }
        answer2.setOnClickListener {
            if (memoAnimauxChoisi.get(1) == reponse) {

                numberWin += 1

                val popIntent = Intent(applicationContext, PopUpAnimalFind::class.java)
                popIntent.putExtra("animalFind",arrayOfAnimalsPicture[reponse])
                popIntent.putExtra("animalNameFind",arrayNameAnimal[reponse])
                val music = MediaPlayer.create(this,arrayMusicAnimal[reponse])

                startActivity(popIntent)
                music.start()

                if (numberWin == 3) {

                    var beforeCarrots = intent.getIntExtra("carotsWon",0)
                    var nbCarrotForThisGame = 1 + random.nextInt(10 - 1)
                    var numberCarrotsWonText=((nbCarrotForThisGame) + beforeCarrots).toString()
                    nextAnimal.putExtra("numberCarrotsWonText", numberCarrotsWonText)
                    nextAnimal.putExtra("nbCarrotForThisGame", nbCarrotForThisGame)
                    startActivity(nextAnimal)
                    startActivity(popIntent)
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
            }
        }
        answer3.setOnClickListener {
            if (memoAnimauxChoisi.get(2) == reponse) {

                numberWin += 1
                val popIntent = Intent(applicationContext, PopUpAnimalFind::class.java)
                popIntent.putExtra("animalFind",arrayOfAnimalsPicture[reponse])
                popIntent.putExtra("animalNameFind",arrayNameAnimal[reponse])
                val music = MediaPlayer.create(this,arrayMusicAnimal[reponse])
                startActivity(popIntent)
                music.start()
                if (numberWin == 3) {
                    var beforeCarrots = intent.getIntExtra("carotsWon",0)
                    var nbCarrotForThisGame = 1 + random.nextInt(10 - 1)
                    var numberCarrotsWonText=((nbCarrotForThisGame) + beforeCarrots).toString()
                    nextAnimal.putExtra("numberCarrotsWonText", numberCarrotsWonText)
                    nextAnimal.putExtra("nbCarrotForThisGame", nbCarrotForThisGame)
                    startActivity(nextAnimal)
                    startActivity(popIntent)

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