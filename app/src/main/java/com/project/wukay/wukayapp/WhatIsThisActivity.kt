package com.project.wukay.wukayapp

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Vibrator
import android.view.View
import android.widget.ImageView
import kotlinx.android.synthetic.main.activity_hard_what_is_this.*
import kotlinx.android.synthetic.main.activity_what_is_this.*
import java.util.*

class WhatIsThisActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        // mise en place du layout
        super.onCreate(savedInstanceState)


        //déclaration des variables
        val difficulty = intent.getStringExtra("difficulty") //renvaiera la difficulté choisit precedement
        val nextAnimal = Intent(this@WhatIsThisActivity, VictoryActivity::class.java)
        nextAnimal.putExtra("difficulty", difficulty)
        val vibratorService = getSystemService(Context.VIBRATOR_SERVICE) as Vibrator
        if (difficulty == "easy"){
            setContentView(R.layout.activity_what_is_this)
        }else
        {
            setContentView(R.layout.activity_hard_what_is_this)
        }

        //selon le niveau de difficulté
        if(difficulty=="easy") {

            var numberWin=0
            //var tableauTampon : Array<Int> = arrayOf(0,0,0,0)
            var tampon = 0
            var tampon1 = 0
            var tampon2 = 0
            var tampon3 = 0

            var tableau = IntArray(4);
            tableau.set(0,0)
            tableau.set(1,0)
            tableau.set(2,0)
            tableau.set(3,0)

            var tabTampon = IntArray(3)

            val animalArray = arrayOf(
                R.drawable.animaux_cochon_silhouette,
                R.drawable.animaux_vache_silhouette,
                R.drawable.animaux_girafe_silhouette
            )

            val answerAnimal = arrayOf(
                R.drawable.animaux_cochon,
                R.drawable.animaux_vache,
                R.drawable.animaux_girafe
            )


            startButton.setOnClickListener {

                System.out.println(numberWin)



                    resultat.setText("___________")
                    tampon = randomizeImage(tabTampon, animalArray, animalPic)
                    ////SILHOUETTE
                    tabTampon.set(0, tampon)
                    tabTampon.set(1, 10)
                    tabTampon.set(2, 10)




                    ////AWNSER
                    tampon1 = randomizeImage(tabTampon, answerAnimal, animalAnwser1)
                    tabTampon.set(0, tampon1)


                    tampon2 = randomizeImage(tabTampon, answerAnimal, animalAnwser2)
                    tabTampon.set(1, tampon2)

                    tampon3 = randomizeImage(tabTampon, answerAnimal, animalAnwser3)
                    tabTampon.set(2, tampon3)

                    startButton.visibility = View.INVISIBLE


            }


            animalAnwser1.setOnClickListener {

                //condition si le joueur donne la bonne réponse
                if( isTheCorrectAnswer(tampon,tabTampon,0)){

                    //incrementation du nombre d'animal trouvé
                    resultat.text=""
                    numberWin+=1
                    System.out.println("NOMBRE WIN : " + numberWin)

                    //fin du mini jeux
                    if(numberWin==3){
                        startActivity(nextAnimal)

                     //prochain animal à deviner
                    }else{

                        ////SILHOUETTE
                        tabTampon.set(0, tampon)
                        tabTampon.set(1, 10)
                        tabTampon.set(2, 10)

                        tampon = randomizeImage(tabTampon, animalArray, animalPic)


                        ////AWNSER
                        tampon1 = randomizeImage(tabTampon, answerAnimal, animalAnwser1)
                        tabTampon.set(0, tampon1)


                        tampon2 = randomizeImage(tabTampon, answerAnimal, animalAnwser2)
                        tabTampon.set(1, tampon2)

                        tampon3 = randomizeImage(tabTampon, answerAnimal, animalAnwser3)
                        tabTampon.set(2, tampon3)

                    }

                }else{
                    //vibration de defaite +texte
                    vibratorService.vibrate(100)
                    resultat.text="recommence"
                }

            }

            animalAnwser2.setOnClickListener {
                //condition si le joueur donne la bonne réponse
                if( isTheCorrectAnswer(tampon,tabTampon,1)){

                    //incrementation du nombre d'animal trouvé
                    resultat.text=""
                    numberWin+=1
                    System.out.println("NOMBRE WIN : " + numberWin)

                    //fin du mini jeux
                    if(numberWin==3){
                        startActivity(nextAnimal)

                        //prochain animal à deviner
                    }else{
                        ////SILHOUETTE
                        tabTampon.set(0, tampon)
                        tabTampon.set(1, 10)
                        tabTampon.set(2, 10)

                        tampon = randomizeImage(tabTampon, animalArray, animalPic)


                        ////AWNSER
                        tampon1 = randomizeImage(tabTampon, answerAnimal, animalAnwser1)
                        tabTampon.set(0, tampon1)


                        tampon2 = randomizeImage(tabTampon, answerAnimal, animalAnwser2)
                        tabTampon.set(1, tampon2)

                        tampon3 = randomizeImage(tabTampon, answerAnimal, animalAnwser3)
                        tabTampon.set(2, tampon3)

                    }

                }else{
                    //vibration de defaite
                    vibratorService.vibrate(100)

                    resultat.text="recommence"
                }

            }

            animalAnwser3.setOnClickListener {
                //condition si le joueur donne la bonne réponse
                if( isTheCorrectAnswer(tampon,tabTampon,2)){

                    //incrementation du nombre d'animal trouvé
                    resultat.text=""
                    numberWin+=1
                    System.out.println("NOMBRE WIN : " + numberWin)

                    //fin du mini jeux
                    if(numberWin==3){
                        startActivity(nextAnimal)

                        //prochain animal à deviner
                    }else{
                        ////SILHOUETTE
                        tabTampon.set(0, tampon)
                        tabTampon.set(1, 10)
                        tabTampon.set(2, 10)

                        tampon = randomizeImage(tabTampon, animalArray, animalPic)


                        ////AWNSER
                        tampon1 = randomizeImage(tabTampon, answerAnimal, animalAnwser1)
                        tabTampon.set(0, tampon1)


                        tampon2 = randomizeImage(tabTampon, answerAnimal, animalAnwser2)
                        tabTampon.set(1, tampon2)

                        tampon3 = randomizeImage(tabTampon, answerAnimal, animalAnwser3)
                        tabTampon.set(2, tampon3)

                    }

                }else{
                    //vibration de defaite
                    vibratorService.vibrate(100)

                    resultat.text="recommence"
                }

            }


        }else{

            //CODE DE LA PARTIE DIFFICILE


           description.setText("J'ai 4 pattes")
            answer1.setOnClickListener{
                description.setText("gagné")
            }
            answer2.setOnClickListener{
                description.setText("perdu")
            }
















        }

    }


    public fun isTheCorrectAnswer(indexOfAnswer: Int, arrayIndexOfPicturesPutedAsAnswer: IntArray, index: Int):Boolean  {
        return indexOfAnswer == arrayIndexOfPicturesPutedAsAnswer.get(index)
    }


    private fun randomizeImage(arrayIndexOfAnswerPicture: IntArray, arrayOfPictures: Array<Int>, view: ImageView): Int  {
        var rand = Random()
        var indexOfAnimalPicture = rand.nextInt(3)

        //don't chose an index which has been already chosen
        while (arrayIndexOfAnswerPicture.contains(indexOfAnimalPicture) ) {
            indexOfAnimalPicture = rand.nextInt(3)

        }

        //change the picture passed in parameters by one of the arrayOfPictures
        view.setImageResource(arrayOfPictures[indexOfAnimalPicture])
        return indexOfAnimalPicture

    }




}
