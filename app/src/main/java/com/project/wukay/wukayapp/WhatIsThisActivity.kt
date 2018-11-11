package com.project.wukay.wukayapp

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Vibrator
import android.widget.ImageView
import kotlinx.android.synthetic.main.activity_what_is_this.*
import java.util.*

class WhatIsThisActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_what_is_this)

        var numberWin=0
        val intent = intent

        val difficulty = intent.getStringExtra("difficulty")

        if(difficulty=="easy") {


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

            val anwserAnimal = arrayOf(R.drawable.animaux_cochon, R.drawable.animaux_vache, R.drawable.animaux_girafe)




            startButton.setOnClickListener {

                if(numberWin==3){
                    val changement = Intent(this@WhatIsThisActivity, LevelsActivity::class.java)
                    changement.putExtra("carotsWon",(1..3).shuffled().first())
                    startActivity(changement);
                }else{
                    resultat.setText("___________")

                    ////SILHOUETTE
                    tabTampon.set(0, tampon)
                    tabTampon.set(1, 10)
                    tabTampon.set(2, 10)

                    tampon = randomizeImage(tabTampon, animalArray, animalPic)


                    ////AWNSER
                    tampon1 = randomizeImage(tabTampon, anwserAnimal, animalAnwser1)
                    tabTampon.set(0, tampon1)


                    tampon2 = randomizeImage(tabTampon, anwserAnimal, animalAnwser2)
                    tabTampon.set(1, tampon2)

                    tampon3 = randomizeImage(tabTampon, anwserAnimal, animalAnwser3)
                    tabTampon.set(2, tampon3)
                }




            }

            animalAnwser1.setOnClickListener {
                numberWin=numberWin+compareImage(tampon, tabTampon, 0 )
            }

            animalAnwser2.setOnClickListener {
                numberWin=numberWin+compareImage(tampon, tabTampon, 1)
            }

            animalAnwser3.setOnClickListener {
                numberWin=numberWin+ compareImage(tampon, tabTampon, 2)
            }


        }else{



            //CODE DE LA PARTIE DIFFICILE
        }

    }





    private fun compareImage(tampon: Int, tabTampon: IntArray, n: Int):Int {
        if (tampon == tabTampon.get(n)) {

            resultat.text = " BRAVO"


            val vibratorService = getSystemService(Context.VIBRATOR_SERVICE) as Vibrator
            vibratorService.vibrate(100)

            return 1

        } else {
            resultat.text = " RECOMMENCE"
            return 0
        }
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
