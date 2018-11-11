package com.project.wukay.wukayapp

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Vibrator
import android.view.View
import android.widget.ImageView
import kotlinx.android.synthetic.main.activity_what_is_this.*
import java.util.*

class WhatIsThisActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_what_is_this)


        val difficulty = intent.getStringExtra("difficulty")

        //renvaiera la difficulté choisit precedement
        val nextAnimal = Intent(this@WhatIsThisActivity, LevelsActivity::class.java)
        nextAnimal.putExtra("difficulty",difficulty)

        val vibratorService = getSystemService(Context.VIBRATOR_SERVICE) as Vibrator

        System.out.println(difficulty)


        if(difficulty=="easy") {

            var numberWin=0
            var tampon = 0
            var tampon1 = 0
            var tampon2 = 0
            var tampon3 = 0

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

                if(numberWin==3){
                    val nextAnimal = Intent(this@WhatIsThisActivity, LevelsActivity::class.java)
                    nextAnimal.putExtra("carotsWon",(1..10).shuffled().first())
                    nextAnimal.putExtra("difficulty","easy")
                    startActivity(nextAnimal)

                }else{

                    resultat.setText("___________")

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

                    startButton.visibility = View.INVISIBLE
                }
            }


            animalAnwser1.setOnClickListener {

                //condition si le joueur donne la bonne réponse
                if( isTheCorrectAnswer(tampon,tabTampon,0)){

                    //incrementation du nombre d'animal trouvé
                    resultat.text=""
                    numberWin+=1

                    //fin du mini jeux
                    if(numberWin==3){
                        nextAnimal.putExtra("carotsWon",(1..10).shuffled().first())
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

                    //fin du mini jeux
                    if(numberWin==3){
                        nextAnimal.putExtra("carotsWon",(1..10).shuffled().first())
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

                    //fin du mini jeux
                    if(numberWin==3){
                        nextAnimal.putExtra("carotsWon",(1..10).shuffled().first())
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
        }
        resultat.setText(difficulty)
    }



    //data class Result(var win: Int, var succeed: Boolean)

    private fun isTheCorrectAnswer(tampon: Int, tabTampon: IntArray, n: Int):Boolean  {
        return tampon == tabTampon.get(n)
    }

    private fun randomizeImage(tampon: IntArray, animalArray: Array<Int>, view: ImageView): Int  {
        var tampon4 = tampon
        var r = Random()

        var n = r.nextInt(3)


        while (tampon4.contains(n) ) {
            n = r.nextInt(3)

        }

        view.setImageResource(animalArray[n])

        var tamponNext = n

        return tamponNext

    }




}
