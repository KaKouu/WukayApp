package com.project.wukay.wukayapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import kotlinx.android.synthetic.main.activity_what_is_this.*
import java.util.*

class WhatIsThisActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_what_is_this)

        var tampon = 0
        var tampon1 = 0
        var tampon2 = 0
        var tampon3 = 0




        val animalArray = arrayOf( R.drawable.cochon,R.drawable.vache, R.drawable.girafe)

        val anwserAnimal1 = arrayOf( R.drawable.cochon,R.drawable.vache, R.drawable.girafe)
        val anwserAnimal2 = arrayOf( R.drawable.cochon,R.drawable.vache, R.drawable.girafe)
        val anwserAnimal3 = arrayOf( R.drawable.cochon,R.drawable.vache, R.drawable.girafe)



        startButton.setOnClickListener {

            ////SILHOUETTE

            tampon = randomizeImage(tampon, animalArray, animalPic )


            ////AWNSER
            tampon1 = randomizeImage(tampon1, anwserAnimal1, animalAnwser1 )
            tampon2 = randomizeImage(tampon2, anwserAnimal2, animalAnwser2 )
            tampon3 = randomizeImage(tampon3, anwserAnimal3, animalAnwser3 )


        }



    }

    private fun randomizeImage(tampon: Int, animalArray: Array<Int>, view: ImageView): Int  {
        var tampon4 = tampon
        var r = Random()

        var n = r.nextInt(3)


        while (tampon4 == n) {
            n = r.nextInt(3)

        }

        view.setImageResource(animalArray[n])

        tampon4 = n

        return tampon4

    }


}
