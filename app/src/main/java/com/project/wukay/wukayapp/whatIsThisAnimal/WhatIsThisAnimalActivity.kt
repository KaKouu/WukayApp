package com.project.wukay.wukayapp.whatIsThisAnimal

import android.content.Context
import android.content.Intent
import android.media.MediaPlayer
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Vibrator
import android.view.KeyEvent
import android.view.MotionEvent
import android.view.View
import android.widget.ImageView
import com.project.wukay.wukayapp.IHM.DifficultyActivity
import com.project.wukay.wukayapp.LifePopActivity
import com.project.wukay.wukayapp.PopUpAnimalFind
import com.project.wukay.wukayapp.R
import com.project.wukay.wukayapp.VictoryActivity
import kotlinx.android.synthetic.main.activity_hard_what_is_this.*
import kotlinx.android.synthetic.main.activity_levels.*
import kotlinx.android.synthetic.main.activity_what_is_this.*
import java.lang.Thread.sleep
import java.util.*

class WhatIsThisAnimalActivity : AppCompatActivity() {

    override fun onKeyDown(keyCode: Int, event: KeyEvent): Boolean {
        return if (keyCode == KeyEvent.KEYCODE_BACK) {
            false
        } else super.onKeyDown(keyCode, event)
    }

    override fun onCreate(savedInstanceState: Bundle?) {

        // mise en place du layout
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_what_is_this)

        //déclaration des variables
        val difficulty = intent.getStringExtra("difficulty") //renvaiera la difficulté choisit precedement
        val nextAnimal = Intent(this@WhatIsThisAnimalActivity, VictoryActivity::class.java)
        nextAnimal.putExtra("difficulty", difficulty)

        var numberCarrotsWon=10

        val vibratorService = getSystemService(Context.VIBRATOR_SERVICE) as Vibrator

        buttonBack.setOnClickListener{
            val previousPage = Intent(this@WhatIsThisAnimalActivity, DifficultyActivity::class.java)
            startActivity(previousPage)
        }

        //selon le niveau de difficulté
            val startAnimalAnswer = arrayOf(
                R.drawable.animaux_cochon_silhouette,
                R.drawable.animaux_vache_silhouette,
                R.drawable.animaux_lion_silhouette,
                R.drawable.animaux_ane_silhouette,
                R.drawable.animaux_bouc_silhouette,
                R.drawable.animaux_chat_silhouette,
                R.drawable.animaux_ecureil_silhouette,
                R.drawable.animaux_tigre_silhouette,
                R.drawable.animaux_elephant_silhouette,
                R.drawable.animaux_chien_silhouette
            )

            val startAnimal = arrayOf(
                R.drawable.animaux_cochon,
                R.drawable.animaux_vache,
                R.drawable.animaux_lion,
                R.drawable.animaux_ane,
                R.drawable.animaux_bouc,
                R.drawable.animaux_chat,
                R.drawable.animaux_ecureil,
                R.drawable.animaux_tigre,
                R.drawable.animaux_elephant,
                R.drawable.animaux_chien
            )

            val arrayNameAnimal=arrayOf(
                "Le cochon",
                "La vache",
                "Le lion",
                "L'âne",
                "Le bouc",
                "Le chat",
                "L'écureuil",
                "Le tigre",
                "L'éléphant",
                "Le chien"
            )

           val arrayMusicAnimal=arrayOf(
               R.raw.sound_cochon,
               R.raw.sound_vache,
               R.raw.sound_lion,
               R.raw.sound_ane,
               R.raw.sound_bouc,
               R.raw.sound_cat,
               R.raw.sound_ecureuil,
               R.raw.sound_tigre,
               R.raw.sound_elephant,
               R.raw.sound_chien
           )

            var choiceOfSilhouette: Int
            var choice1: Int
            var choice2: Int
            var choice3: Int

            var tableau = IntArray(4)
            tableau[0] = 0
            tableau[1] = 0
            tableau[2] = 0
            tableau[3] = 0

            var tabOfChoice = IntArray(3)

            var rand = Random()
            var index = rand.nextInt(startAnimalAnswer.size)
            var index1 = rand.nextInt(startAnimalAnswer.size)
            var index2 = rand.nextInt(startAnimalAnswer.size)

            while(index == index1 || index == index2 || index1 == index2) {
                index = rand.nextInt(startAnimalAnswer.size)
                index1 = rand.nextInt(startAnimalAnswer.size)
                index2 = rand.nextInt(startAnimalAnswer.size)
            }

            val arrayAnimal = arrayOf(
                startAnimal[index],
                startAnimal[index1],
                startAnimal[index2]
            )

            val arrayAnswerAnimal = arrayOf(
                startAnimalAnswer[index],
                startAnimalAnswer[index1],
                startAnimalAnswer[index2]
            )

            val arrayNameChoose = arrayOf(
                arrayNameAnimal[index],
                arrayNameAnimal[index1],
                arrayNameAnimal[index2]
            )

            val arrayMusicChoose = arrayOf(
                arrayMusicAnimal[index],
                arrayMusicAnimal[index1],
                arrayMusicAnimal[index2]
            )

            var numberWin=0



                ////SILHOUETTE
            choiceOfSilhouette = randomizeImage(tabOfChoice, arrayAnswerAnimal, animalPic)

            tabOfChoice[0] = choiceOfSilhouette
            tabOfChoice[1] = 10
            tabOfChoice[2] = 10

                ////ANSWER
            choice1 = randomizeImage(tabOfChoice, arrayAnimal, animalAnwser1)
            tabOfChoice[0] = choice1

            choice2 = randomizeImage(tabOfChoice, arrayAnimal, animalAnwser2)
            tabOfChoice[1] = choice2

            choice3 = randomizeImage(tabOfChoice, arrayAnimal, animalAnwser3)
            tabOfChoice[2] = choice3


            WhatIsThisActivity.setOnTouchListener { v: View,m: MotionEvent ->
                if(m.action == MotionEvent.ACTION_MOVE){

                    /*if(numberWin==0){

                    }else{
                        if(numberWin==1){
                            scoreImage.setImageResource(R.drawable.tete_lapinou_score_1)
                        }else{
                            if(numberWin==2){
                                scoreImage.setImageResource(R.drawable.tete_lapinou_score_2)
                            }
                        }
                    }*/

                    if(m.x >= animalAnwser1.x && m.x < animalAnwser1.x + animalAnwser1.width && m.y >= animalAnwser1.y && m.y < animalAnwser1.y + animalAnwser1.height ) {
                        animalAnwser1.x = m.x - animalAnwser1.width / 2
                        animalAnwser1.y = m.y - animalAnwser1.height / 2
                    }
                    else{
                        if(m.x >= animalAnwser2.x && m.x < animalAnwser2.x + animalAnwser2.width && m.y >= animalAnwser2.y && m.y < animalAnwser2.y + animalAnwser2.height) {
                            animalAnwser2.x = m.x - animalAnwser2.width/2
                            animalAnwser2.y = m.y - animalAnwser2.height/2
                        }
                        else{
                            if(m.x >= animalAnwser3.x && m.x < animalAnwser3.x + animalAnwser3.width && m.y >= animalAnwser3.y && m.y < animalAnwser3.y + animalAnwser1.height) {
                                animalAnwser3.x = m.x - animalAnwser3.width/2
                                animalAnwser3.y = m.y - animalAnwser3.height/2
                            }
                        }
                    }

                    val hitAnimal1 = (animalPic.x - animalAnwser1.x) * (animalPic.x - animalAnwser1.x) + (animalPic.y - animalAnwser1.y) * (animalPic.y - animalAnwser1.y)
                    if(hitAnimal1 > (animalPic.width/12  + animalAnwser1.width/12 ) * (animalPic.width/12  + animalAnwser1.width/12 )) {

                    }
                    else{

                        var numberCarrotsWon1 = numberCarrotsWon
                        if (isTheCorrectAnswer(choiceOfSilhouette, tabOfChoice, 0)) {

                            animalAnwser1.x = 0f
                            animalAnwser1.y = 1300f
                            animalAnwser2.x = 300f
                            animalAnwser2.y = 1100f
                            animalAnwser3.x = 700f
                            animalAnwser3.y = 1300f
                            //incrementation du nombre d'animal trouvé
                            resultat.text = ""
                            numberWin += 1


                            val popIntent = Intent(applicationContext, PopUpAnimalFind::class.java)
                            popIntent.putExtra("animalFind",arrayAnimal[choiceOfSilhouette])
                            popIntent.putExtra("animalNameFind",arrayNameChoose[choiceOfSilhouette])

                            val music = MediaPlayer.create(this,arrayMusicChoose[choiceOfSilhouette])

                            startActivity(popIntent)
                            music.start()

                            //fin du mini jeux
                            if (numberWin == 3) {
                                //scoreImage.setImageResource(R.drawable.tete_lapinou_score_3)
                                //sleep(5000)
                                var numberCarrotsWonText = numberCarrotsWon1.toString()
                                nextAnimal.putExtra("numberCarrotsWonText", numberCarrotsWonText)
                                startActivity(nextAnimal)
                                startActivity(popIntent)

                                //prochain animal à deviner
                            } else {

                                ////SILHOUETTE
                                tabOfChoice[0] = choiceOfSilhouette
                                tabOfChoice[1] = 10
                                tabOfChoice[2] = 10

                                choiceOfSilhouette = randomizeImage(tabOfChoice, arrayAnswerAnimal, animalPic)

                                ////AWNSER
                                choice1 = randomizeImage(tabOfChoice, arrayAnimal, animalAnwser1)
                                tabOfChoice[0] = choice1

                                choice2 = randomizeImage(tabOfChoice, arrayAnimal, animalAnwser2)
                                tabOfChoice[1] = choice2

                                choice3 = randomizeImage(tabOfChoice, arrayAnimal, animalAnwser3)
                                tabOfChoice[2] = choice3

                            }

                        } else {
                            //vibration de defaite +texte

                            vibratorService.vibrate(100)
                            animalAnwser1.x = 0f
                            animalAnwser1.y = 1300f
                            resultat.text = "Essaye encore !"
                            if (numberCarrotsWon1 > 1) {
                                numberCarrotsWon1 -= 1
                            }
                        }

                    }

                    val hitAnimal2 = (animalPic.x - animalAnwser2.x) * (animalPic.x - animalAnwser2.x) + (animalPic.y - animalAnwser2.y) * (animalPic.y - animalAnwser2.y)
                    if(hitAnimal2 > (animalPic.width/12 + animalAnwser2.width/12) * (animalPic.width/12 + animalAnwser2.width/12)) {

                    }
                    else{

                        var numberCarrotsWon1 = numberCarrotsWon
                        if (isTheCorrectAnswer(choiceOfSilhouette, tabOfChoice, 1)) {

                            animalAnwser1.x = 0f
                            animalAnwser1.y = 1300f
                            animalAnwser2.x = 300f
                            animalAnwser2.y = 1100f
                            animalAnwser3.x = 700f
                            animalAnwser3.y = 1300f
                            //incrementation du nombre d'animal trouvé
                            resultat.text = ""
                            numberWin += 1


                            val popIntent = Intent(applicationContext, PopUpAnimalFind::class.java)
                            popIntent.putExtra("animalFind",arrayAnimal[choiceOfSilhouette])
                            popIntent.putExtra("animalNameFind",arrayNameChoose[choiceOfSilhouette])
                            val music = MediaPlayer.create(this,arrayMusicChoose[choiceOfSilhouette])
                            startActivity(popIntent)
                            music.start()

                            //fin du mini jeux
                            if (numberWin == 3) {
                               // scoreImage.setImageResource(R.drawable.tete_lapinou_score_3)
                                //sleep(5000)
                                var numberCarrotsWonText = numberCarrotsWon1.toString()
                                nextAnimal.putExtra("numberCarrotsWonText", numberCarrotsWonText)
                                startActivity(nextAnimal)
                                startActivity(popIntent)

                                //prochain animal à deviner
                            } else {
                                ////SILHOUETTE
                                tabOfChoice[0] = choiceOfSilhouette
                                tabOfChoice[1] = 10
                                tabOfChoice[2] = 10

                                choiceOfSilhouette = randomizeImage(tabOfChoice, arrayAnswerAnimal, animalPic)

                                ////AWNSER
                                choice1 = randomizeImage(tabOfChoice, arrayAnimal, animalAnwser1)
                                tabOfChoice[0] = choice1


                                choice2 = randomizeImage(tabOfChoice, arrayAnimal, animalAnwser2)
                                tabOfChoice[1] = choice2

                                choice3 = randomizeImage(tabOfChoice, arrayAnimal, animalAnwser3)
                                tabOfChoice[2] = choice3

                            }

                        } else {
                            //vibration de defaite +texte
                            vibratorService.vibrate(100)
                            animalAnwser2.x = 300f
                            animalAnwser2.y = 1100f
                            resultat.text = "Essaye encore !"
                            if (numberCarrotsWon1 > 1) {
                                numberCarrotsWon1 -= 1
                            }
                        }
                    }
                    val hitAnimal3 = (animalPic.x - animalAnwser3.x) * (animalPic.x - animalAnwser3.x) + (animalPic.y - animalAnwser3.y) * (animalPic.y - animalAnwser3.y)
                    if((hitAnimal3 > (animalPic.width/12  + animalAnwser3.width/12 ) * (animalPic.width/12  + animalAnwser3.width/12 ))) {

                    }
                    else{
                        var numberCarrotsWon1 = numberCarrotsWon
                        if (isTheCorrectAnswer(choiceOfSilhouette, tabOfChoice, 2)) {

                            animalAnwser1.x = 0f
                            animalAnwser1.y = 1300f
                            animalAnwser2.x = 300f
                            animalAnwser2.y = 1100f
                            animalAnwser3.x = 700f
                            animalAnwser3.y = 1300f
                            //incrementation du nombre d'animal trouvé
                            resultat.text = ""
                            numberWin += 1


                            val popIntent = Intent(applicationContext, PopUpAnimalFind::class.java)
                            popIntent.putExtra("animalFind",arrayAnimal[choiceOfSilhouette])
                            popIntent.putExtra("animalNameFind",arrayNameChoose[choiceOfSilhouette])

                            val music = MediaPlayer.create(this,arrayMusicChoose[choiceOfSilhouette])

                            startActivity(popIntent)
                            music.start()

                            //fin du mini jeux
                            if (numberWin == 3) {
                                //scoreImage.setImageResource(R.drawable.tete_lapinou_score_3)
                                //sleep(5000)
                                var numberCarrotsWonText = numberCarrotsWon1.toString()
                                nextAnimal.putExtra("numberCarrotsWonText", numberCarrotsWonText)
                                startActivity(nextAnimal)
                                startActivity(popIntent)
                                //prochain animal à deviner
                            } else {
                                ////SILHOUETTE
                                tabOfChoice[0] = choiceOfSilhouette
                                tabOfChoice[1] = 10
                                tabOfChoice[2] = 10

                                choiceOfSilhouette = randomizeImage(tabOfChoice, arrayAnswerAnimal, animalPic)

                                ////AWNSER
                                choice1 = randomizeImage(tabOfChoice, arrayAnimal, animalAnwser1)
                                tabOfChoice[0] = choice1


                                choice2 = randomizeImage(tabOfChoice, arrayAnimal, animalAnwser2)
                                tabOfChoice[1] = choice2

                                choice3 = randomizeImage(tabOfChoice, arrayAnimal, animalAnwser3)
                                tabOfChoice[2] = choice3

                            }

                        }

                        else {
                            //vibration de defaite +texte
                            vibratorService.vibrate(100)
                            animalAnwser3.x = 700f
                            animalAnwser3.y = 1300f
                            resultat.text = "Essaye encore !"
                            if (numberCarrotsWon1 > 1) {
                                numberCarrotsWon1 -= 1
                            }
                        }
                    }
                }

                true
            }

    }

    private fun isTheCorrectAnswer(indexOfAnswer: Int, arrayIndexOfPicturesPutedAsAnswer: IntArray, index: Int):Boolean  {
        return indexOfAnswer == arrayIndexOfPicturesPutedAsAnswer[index]
    }

    private fun randomizeImage(arrayIndexOfAnswerPicture: IntArray, arrayOfPictures: Array<Int>, view: ImageView): Int {
        var rand = Random()
        var indexOfAnimalPicture = rand.nextInt(3)

        //don't chose an index which has been already chosen
        while (arrayIndexOfAnswerPicture.contains(indexOfAnimalPicture)) {
            indexOfAnimalPicture = rand.nextInt(3)

        }

        //change the picture passed in parameters by one of the arrayOfPictures
        view.setImageResource(arrayOfPictures[indexOfAnimalPicture])
        return indexOfAnimalPicture

    }

}
