package com.project.wukay.wukayapp.whatIsThisAnimal

import android.content.Context
import android.content.Intent
import android.media.MediaPlayer
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Vibrator
import android.util.DisplayMetrics
import android.view.KeyEvent
import android.view.MotionEvent
import android.view.View
import android.widget.ImageView
import com.project.wukay.wukayapp.IHM.DifficultyActivity
import com.project.wukay.wukayapp.PopUpAnimalFind
import com.project.wukay.wukayapp.R
import com.project.wukay.wukayapp.VictoryActivity
import kotlinx.android.synthetic.main.activity_what_is_this.*
import java.util.*

class WhatIsThisAnimalActivity : AppCompatActivity() {
    var random= Random()
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


        val displayMetrics = DisplayMetrics()
        windowManager.defaultDisplay.getMetrics(displayMetrics)
        val heightScreen = displayMetrics.heightPixels
        val widthScreen = displayMetrics.widthPixels
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


            WhatIsThisActivity.setOnTouchListener { v: View,motionEvent: MotionEvent ->
                if(motionEvent.action == MotionEvent.ACTION_MOVE){

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

                    if(isFingerOnPicture(motionEvent,animalAnwser1)) {
                        makeThePictureFollowTheFinger(motionEvent,animalAnwser1)
                    }
                    else{
                        if(isFingerOnPicture(motionEvent,animalAnwser2)) {
                            makeThePictureFollowTheFinger(motionEvent,animalAnwser2)
                        }
                        else{
                            if(isFingerOnPicture(motionEvent,animalAnwser3)) {
                                makeThePictureFollowTheFinger(motionEvent,animalAnwser3)
                            }
                        }
                    }

                    val hitAnimal1 = (animalPic.x - animalAnwser1.x) * (animalPic.x - animalAnwser1.x) + (animalPic.y - animalAnwser1.y) * (animalPic.y - animalAnwser1.y)
                    if(hitAnimal1 > (animalPic.width/12  + animalAnwser1.width/12 ) * (animalPic.width/12  + animalAnwser1.width/12 )) {

                    }
                    else{

                        if (isTheCorrectAnswer(choiceOfSilhouette, tabOfChoice, 0)) {

                            animalAnwser1.x = 0f
                            animalAnwser1.y = (heightScreen*2/3).toFloat()
                            animalAnwser2.x = (widthScreen*1/3).toFloat()
                            animalAnwser2.y = (heightScreen*2/3).toFloat()
                            animalAnwser3.x = (widthScreen*2/3).toFloat()
                            animalAnwser3.y = (heightScreen*2/3).toFloat()
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
                                var beforeLife=intent.getIntExtra("nbLifeConso",0)
                                var nbLifeForThisGame=1
                                var numberLifeConso=beforeLife+nbLifeForThisGame
                                var beforeCarrots = intent.getIntExtra("carotsWon",0)
                                var nbCarrotForThisGame = 1 + random.nextInt(10 - 1)
                                var numberCarrotsWonText=((nbCarrotForThisGame) + beforeCarrots).toString()
                                nextAnimal.putExtra("numberCarrotsWonText", numberCarrotsWonText)
                                nextAnimal.putExtra("nbCarrotForThisGame", nbCarrotForThisGame)
                                nextAnimal.putExtra("numberLifeConso", numberLifeConso)
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
                            animalAnwser1.y = (heightScreen*2/3).toFloat()
                            resultat.text = "Essaye encore !"
                        }

                    }

                    val hitAnimal2 = (animalPic.x - animalAnwser2.x) * (animalPic.x - animalAnwser2.x) + (animalPic.y - animalAnwser2.y) * (animalPic.y - animalAnwser2.y)
                    if(hitAnimal2 > (animalPic.width/12 + animalAnwser2.width/12) * (animalPic.width/12 + animalAnwser2.width/12)) {

                    }
                    else{

                        if (isTheCorrectAnswer(choiceOfSilhouette, tabOfChoice, 1)) {

                            animalAnwser1.x = 0f
                            animalAnwser1.y = (heightScreen*2/3).toFloat()
                            animalAnwser2.x = (widthScreen*1/3).toFloat()
                            animalAnwser2.y = (heightScreen*2/3).toFloat()
                            animalAnwser3.x = (widthScreen*2/3).toFloat()
                            animalAnwser3.y = (heightScreen*2/3).toFloat()
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
                                var beforeLife=intent.getIntExtra("nbLifeConso",0)
                                var nbLifeForThisGame=1
                                var numberLifeConso=beforeLife+nbLifeForThisGame
                                var beforeCarrots = intent.getIntExtra("carotsWon",0)
                                var nbCarrotForThisGame = 1 + random.nextInt(10 - 1)
                                var numberCarrotsWonText=((nbCarrotForThisGame) + beforeCarrots).toString()
                                nextAnimal.putExtra("numberCarrotsWonText", numberCarrotsWonText)
                                nextAnimal.putExtra("nbCarrotForThisGame", nbCarrotForThisGame)
                                nextAnimal.putExtra("numberLifeConso", numberLifeConso)
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
                            animalAnwser2.x =(widthScreen*1/3).toFloat()
                            animalAnwser2.y = (heightScreen*2/3).toFloat()
                            resultat.text = "Essaye encore !"
                        }
                    }
                    val hitAnimal3 = (animalPic.x - animalAnwser3.x) * (animalPic.x - animalAnwser3.x) + (animalPic.y - animalAnwser3.y) * (animalPic.y - animalAnwser3.y)
                    if((hitAnimal3 > (animalPic.width/12  + animalAnwser3.width/12 ) * (animalPic.width/12  + animalAnwser3.width/12 ))) {

                    }
                    else{
                        if (isTheCorrectAnswer(choiceOfSilhouette, tabOfChoice, 2)) {

                            animalAnwser1.x = 0f
                            animalAnwser1.y = (heightScreen*2/3).toFloat()
                            animalAnwser2.x = (widthScreen*1/3).toFloat()
                            animalAnwser2.y = (heightScreen*2/3).toFloat()
                            animalAnwser3.x = (widthScreen*2/3).toFloat()
                            animalAnwser3.y = (heightScreen*2/3).toFloat()
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
                                var beforeLife=intent.getIntExtra("nbLifeConso",0)
                                var nbLifeForThisGame=1
                                var numberLifeConso=beforeLife+nbLifeForThisGame
                                var beforeCarrots = intent.getIntExtra("carotsWon",0)
                                var nbCarrotForThisGame = 1 + random.nextInt(10 - 1)
                                var numberCarrotsWonText=((nbCarrotForThisGame) + beforeCarrots).toString()
                                nextAnimal.putExtra("numberCarrotsWonText", numberCarrotsWonText)
                                nextAnimal.putExtra("nbCarrotForThisGame", nbCarrotForThisGame)
                                nextAnimal.putExtra("numberLifeConso", numberLifeConso)
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
                            animalAnwser3.x = (widthScreen*2/3).toFloat()
                            animalAnwser3.y = (heightScreen*2/3).toFloat()
                            resultat.text = "Essaye encore !"
                        }
                    }
                }

                true
            }

    }

    private fun makeThePictureFollowTheFinger(motionEvent: MotionEvent,idImageView:ImageView) {
        idImageView.x = motionEvent.x - idImageView.width / 2
        idImageView.y = motionEvent.y - idImageView.height / 2
    }

    private fun isFingerOnPicture(motionEvent: MotionEvent, idImageView: ImageView): Boolean {
        return motionEvent.x >= idImageView.x && motionEvent.x < idImageView.x + idImageView.width && motionEvent.y >= idImageView.y && motionEvent.y < idImageView.y + idImageView.height
    }

    private fun isTheCorrectAnswer(indexOfAnswer: Int, arrayIndexOfPicturesPutedAsAnswer: IntArray, index: Int)=
         indexOfAnswer == arrayIndexOfPicturesPutedAsAnswer[index]


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
