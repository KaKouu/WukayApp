package com.project.wukay.wukayapp

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Vibrator
import android.view.MotionEvent
import android.view.View
import android.widget.ImageView
import kotlinx.android.synthetic.main.activity_hard_what_is_this.*
import kotlinx.android.synthetic.main.activity_what_is_this.*
import java.lang.Thread.sleep
import java.util.*

class WhatIsThisAnimalActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        // mise en place du layout
        super.onCreate(savedInstanceState)

        //déclaration des variables
        val difficulty = intent.getStringExtra("difficulty") //renvaiera la difficulté choisit precedement
        val nextAnimal = Intent(this@WhatIsThisAnimalActivity, VictoryActivity::class.java)
        nextAnimal.putExtra("difficulty", difficulty)

        var numberCarrotsWon=10

        val vibratorService = getSystemService(Context.VIBRATOR_SERVICE) as Vibrator

        if (difficulty == "easy"){
            setContentView(R.layout.activity_what_is_this)
        }else
        {
            setContentView(R.layout.activity_hard_what_is_this)
        }

        //selon le niveau de difficulté
        if(difficulty=="easy") {

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

                //if(m.x >= startButton.x && m.x < startButton.x + startButton.width && m.y >= startButton.y && m.y < startButton.y + startButton.height){

                /*animalAnwser1.x = 0f
                animalAnwser1.y = 1300f
                animalAnwser2.x = 300f
                animalAnwser2.y = 1100f
                animalAnwser3.x = 700f
                animalAnwser3.y = 1300f
                resultat.setText("")*/

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
                            nameAnimal.setText(arrayNameAnimal[6])
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

                                ////SILHOUETTE
                                sleep(3000)
                                tabOfChoice.set(0, choiceOfSilhouette)
                                tabOfChoice.set(1, 10)
                                tabOfChoice.set(2, 10)

                                choiceOfSilhouette = randomizeImage(tabOfChoice, arrayAnswerAnimal, animalPic)
                                //animalAns.visibility = View.INVISIBLE
                                //animalPic.visibility = View.VISIBLE

                                ////AWNSER
                                choice1 = randomizeImage(tabOfChoice, arrayAnimal, animalAnwser1)
                                tabOfChoice.set(0, choice1)

                                choice2 = randomizeImage(tabOfChoice, arrayAnimal, animalAnwser2)
                                tabOfChoice.set(1, choice2)

                                choice3 = randomizeImage(tabOfChoice, arrayAnimal, animalAnwser3)
                                tabOfChoice.set(2, choice3)

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
                            nameAnimal.setText(arrayNameAnimal[6])
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
                                tabOfChoice.set(0, choiceOfSilhouette)
                                tabOfChoice.set(1, 10)
                                tabOfChoice.set(2, 10)

                                choiceOfSilhouette = randomizeImage(tabOfChoice, arrayAnswerAnimal, animalPic)
                                //animalAns.visibility = View.INVISIBLE
                                //animalPic.visibility = View.VISIBLE

                                ////AWNSER
                                choice1 = randomizeImage(tabOfChoice, arrayAnimal, animalAnwser1)
                                tabOfChoice.set(0, choice1)


                                choice2 = randomizeImage(tabOfChoice, arrayAnimal, animalAnwser2)
                                tabOfChoice.set(1, choice2)

                                choice3 = randomizeImage(tabOfChoice, arrayAnimal, animalAnwser3)
                                tabOfChoice.set(2, choice3)

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
                            nameAnimal.setText(arrayNameAnimal[6])
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
                                tabOfChoice.set(0, choiceOfSilhouette)
                                tabOfChoice.set(1, 10)
                                tabOfChoice.set(2, 10)

                                choiceOfSilhouette = randomizeImage(tabOfChoice, arrayAnswerAnimal, animalPic)
                                //animalAns.visibility = View.INVISIBLE
                                //animalPic.visibility = View.VISIBLE

                                ////AWNSER
                                choice1 = randomizeImage(tabOfChoice, arrayAnimal, animalAnwser1)
                                tabOfChoice.set(0, choice1)


                                choice2 = randomizeImage(tabOfChoice, arrayAnimal, animalAnwser2)
                                tabOfChoice.set(1, choice2)

                                choice3 = randomizeImage(tabOfChoice, arrayAnimal, animalAnwser3)
                                tabOfChoice.set(2, choice3)

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


        }else{

            //CODE DE LA PARTIE DIFFICILE
            var numberWin=0

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

            val arrayOfQuestion=arrayOf(
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

            description.setText("")
            var nombreDeReponsesPossibles=3
            var memoAnimauxChoisi=IntArray(nombreDeReponsesPossibles)
            var reponse =-1
            var rand = Random()
            var ouMettreLaReponse=0

            reponse =rand.nextInt(arrayOfAnimalsPicture.size)
            ouMettreLaReponse=rand.nextInt(nombreDeReponsesPossibles)

            question.setText("j'aboie et j'ai un pelage blanc")

                curseur2.visibility = View.INVISIBLE
                minijeu(
                    arrayOfQuestion,
                    reponse,
                    nombreDeReponsesPossibles,
                    memoAnimauxChoisi,
                    rand,
                    arrayOfAnimalsPicture,
                    ouMettreLaReponse
                )
                answer1.setOnClickListener {
                    if (memoAnimauxChoisi.get(0) == reponse) {

                        numberWin += 1
                        if (numberWin == 3) {
                            var numberCarrotsWonText = numberCarrotsWon.toString()
                            nextAnimal.putExtra("numberCarrotsWonText", numberCarrotsWonText)
                            startActivity(nextAnimal)


                        } else {
                            reponse = rand.nextInt(arrayOfAnimalsPicture.size - 1)
                            ouMettreLaReponse = rand.nextInt(nombreDeReponsesPossibles)


                            minijeu(
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
                        description.setText("Essaye encore !")
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


                            minijeu(
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
                        description.setText("Essaye encore !")
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


                            minijeu(
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
                        description.setText("Essaye encore !")
                        vibratorService.vibrate(100)
                        if (numberCarrotsWon > 1) {
                            numberCarrotsWon -= 1
                        }
                    }
                }
                startButton2.visibility = View.INVISIBLE




        }

    }

    private fun minijeu(
        arrayOfQuestion: Array<String>,
        reponse: Int,
        nombreDeReponsesPossibles: Int,
        memoAnimauxChoisi: IntArray,
        rand: Random,
        arrayOfAnimalsPicture: Array<Int>,
        ouMettreLaReponse: Int
    ) {
        question.setText(arrayOfQuestion[reponse])
        description.setText("")
        var i = 0;

        while (i < nombreDeReponsesPossibles) {
            System.out.print(i)
            memoAnimauxChoisi.set(i, -1)
            i++
        }

        var j = 0
        while (j < memoAnimauxChoisi.size) {

            var temp = rand.nextInt(arrayOfAnimalsPicture.size)

            while (memoAnimauxChoisi.contains(temp) || temp == reponse) {
                temp = rand.nextInt(arrayOfAnimalsPicture.size)
            }

            memoAnimauxChoisi.set(j, temp)
            j++
        }
        memoAnimauxChoisi.set(ouMettreLaReponse, reponse)

        answer1.setImageResource(arrayOfAnimalsPicture[memoAnimauxChoisi[0]])
        answer2.setImageResource(arrayOfAnimalsPicture[memoAnimauxChoisi[1]])
        answer3.setImageResource(arrayOfAnimalsPicture[memoAnimauxChoisi[2]])
    }


    private fun isTheCorrectAnswer(indexOfAnswer: Int, arrayIndexOfPicturesPutedAsAnswer: IntArray, index: Int):Boolean  {
        return indexOfAnswer == arrayIndexOfPicturesPutedAsAnswer.get(index)
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
