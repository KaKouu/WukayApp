package com.project.wukay.wukayapp.whatIsThisAnimal

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Vibrator
import android.view.MotionEvent
import android.view.View
import android.widget.ImageView
import com.project.wukay.wukayapp.R
import com.project.wukay.wukayapp.VictoryActivity
import kotlinx.android.synthetic.main.activity_hard_what_is_this.*
import kotlinx.android.synthetic.main.activity_what_is_this.*
import java.lang.Thread.sleep
import java.util.*

class WhatIsThisAnimalActivity : AppCompatActivity() {

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



        //selon le niveau de difficulté
            val startAnimalAnswer = arrayOf(
                R.drawable.animaux_cochon_silhouette,
                R.drawable.animaux_vache_silhouette,
                R.drawable.animaux_girafe_silhouette,
                R.drawable.animaux_ane_silhouette,
                R.drawable.animaux_bouc_silhouette,
                R.drawable.animaux_chat_silhouette,
                R.drawable.animaux_ecureil_silhouette,
                R.drawable.animaux_lama_silhouette,
                R.drawable.animaux_elephant_silhouette,
                R.drawable.animaux_chien_silhouette
            )

            val startAnimal = arrayOf(
                R.drawable.animaux_cochon,
                R.drawable.animaux_vache,
                R.drawable.animaux_girafe,
                R.drawable.animaux_ane,
                R.drawable.animaux_bouc,
                R.drawable.animaux_chat,
                R.drawable.animaux_ecureil,
                R.drawable.animaux_lama,
                R.drawable.animaux_elephant,
                R.drawable.animaux_chien
            )

            val arrayNameAnimal=arrayOf(
                "Le cochon",
                "La vache",
                "La girafe",
                "L'âne",
                "Le bouc",
                "Le chat",
                "L'ecureil",
                "Le lama",
                "L'éléphant",
                "Le chien"
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

            animalAns.visibility = View.INVISIBLE
            nameAnimal.visibility = View.INVISIBLE


            WhatIsThisActivity.setOnTouchListener { v: View,m: MotionEvent ->
                if(m.action == MotionEvent.ACTION_MOVE){

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
                    if(hitAnimal1 > (animalPic.width/2 + animalAnwser1.width/2) * (animalPic.width/2 + animalAnwser1.width/2)) {

                    }
                    else{

                        var numberCarrotsWon1 = numberCarrotsWon
                        if (isTheCorrectAnswer(choiceOfSilhouette, tabOfChoice, 0)) {
                            animalAns.setImageResource(startAnimal[6])
                            nameAnimal.text = arrayNameAnimal[6]
                            animalPic.visibility = View.INVISIBLE
                            animalAns.visibility = View.VISIBLE
                            nameAnimal.visibility = View.VISIBLE
                            animalAnwser1.x = 0f
                            animalAnwser1.y = 1300f
                            animalAnwser2.x = 300f
                            animalAnwser2.y = 1100f
                            animalAnwser3.x = 700f
                            animalAnwser3.y = 1300f
                            //incrementation du nombre d'animal trouvé
                            resultat.text = ""
                            numberWin += 1
                            //fin du mini jeux
                            if (numberWin == 3) {
                                var numberCarrotsWonText = numberCarrotsWon1.toString()
                                nextAnimal.putExtra("numberCarrotsWonText", numberCarrotsWonText)
                                startActivity(nextAnimal)

                                //prochain animal à deviner
                            } else {

                                ////SILHOUETTE
                                sleep(3000)
                                tabOfChoice[0] = choiceOfSilhouette
                                tabOfChoice[1] = 10
                                tabOfChoice[2] = 10

                                choiceOfSilhouette = randomizeImage(tabOfChoice, arrayAnswerAnimal, animalPic)
                                //animalAns.visibility = View.INVISIBLE
                                //animalPic.visibility = View.VISIBLE

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
                            resultat.text = "Essaye encore !"
                            if (numberCarrotsWon1 > 1) {
                                numberCarrotsWon1 -= 1
                            }
                        }

                    }
                    val hitAnimal2 = (animalPic.x - animalAnwser2.x) * (animalPic.x - animalAnwser2.x) + (animalPic.y - animalAnwser2.y) * (animalPic.y - animalAnwser2.y)
                    if(hitAnimal2 > (animalPic.width/2 + animalAnwser2.width/2) * (animalPic.width/2 + animalAnwser2.width/2)) {

                    }
                    else{

                        var numberCarrotsWon1 = numberCarrotsWon
                        if (isTheCorrectAnswer(choiceOfSilhouette, tabOfChoice, 1)) {
                            animalAns.setImageResource(startAnimal[6])
                            nameAnimal.text = arrayNameAnimal[6]
                            animalPic.visibility = View.INVISIBLE
                            animalAns.visibility = View.VISIBLE
                            nameAnimal.visibility = View.VISIBLE
                            animalAnwser1.x = 0f
                            animalAnwser1.y = 1300f
                            animalAnwser2.x = 300f
                            animalAnwser2.y = 1100f
                            animalAnwser3.x = 700f
                            animalAnwser3.y = 1300f
                            //incrementation du nombre d'animal trouvé
                            resultat.text = ""
                            numberWin += 1
                            System.out.println("NOMBRE WIN : " + numberWin)

                            //fin du mini jeux
                            if (numberWin == 3) {
                                var numberCarrotsWonText = numberCarrotsWon1.toString()
                                nextAnimal.putExtra("numberCarrotsWonText", numberCarrotsWonText)
                                startActivity(nextAnimal)

                                //prochain animal à deviner
                            } else {
                                sleep(3000)
                                ////SILHOUETTE
                                tabOfChoice[0] = choiceOfSilhouette
                                tabOfChoice[1] = 10
                                tabOfChoice[2] = 10

                                choiceOfSilhouette = randomizeImage(tabOfChoice, arrayAnswerAnimal, animalPic)
                                //animalAns.visibility = View.INVISIBLE
                                //animalPic.visibility = View.VISIBLE

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
                            resultat.text = "Essaye encore !"
                            if (numberCarrotsWon1 > 1) {
                                numberCarrotsWon1 -= 1
                            }
                        }
                    }
                    val hitAnimal3 = (animalPic.x - animalAnwser3.x) * (animalPic.x - animalAnwser3.x) + (animalPic.y - animalAnwser3.y) * (animalPic.y - animalAnwser3.y)
                    if((hitAnimal3 > (animalPic.width/2 + animalAnwser3.width/2) * (animalPic.width/2 + animalAnwser3.width/2))) {

                    }
                    else{
                        var numberCarrotsWon1 = numberCarrotsWon
                        if (isTheCorrectAnswer(choiceOfSilhouette, tabOfChoice, 2)) {
                            animalAns.setImageResource(startAnimal[6])
                            nameAnimal.text = arrayNameAnimal[6]
                            animalPic.visibility = View.INVISIBLE
                            animalAns.visibility = View.VISIBLE
                            nameAnimal.visibility = View.VISIBLE
                            animalAnwser1.x = 0f
                            animalAnwser1.y = 1300f
                            animalAnwser2.x = 300f
                            animalAnwser2.y = 1100f
                            animalAnwser3.x = 700f
                            animalAnwser3.y = 1300f
                            //incrementation du nombre d'animal trouvé
                            resultat.text = ""
                            numberWin += 1
                            System.out.println("NOMBRE WIN : " + numberWin)

                            //fin du mini jeux
                            if (numberWin == 3) {
                                var numberCarrotsWonText = numberCarrotsWon1.toString()
                                nextAnimal.putExtra("numberCarrotsWonText", numberCarrotsWonText)
                                startActivity(nextAnimal)

                                //prochain animal à deviner
                            } else {
                                sleep(3000)
                                ////SILHOUETTE
                                tabOfChoice[0] = choiceOfSilhouette
                                tabOfChoice[1] = 10
                                tabOfChoice[2] = 10

                                choiceOfSilhouette = randomizeImage(tabOfChoice, arrayAnswerAnimal, animalPic)
                                //animalAns.visibility = View.INVISIBLE
                                //animalPic.visibility = View.VISIBLE

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
