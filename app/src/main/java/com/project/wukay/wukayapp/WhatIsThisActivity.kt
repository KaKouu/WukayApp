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

        var tabTampon = IntArray(3)

        val animalArray = arrayOf( R.drawable.cochon_silhouette,R.drawable.vache_silhouette, R.drawable.girafe_silhouette )

        val anwserAnimal1 = arrayOf( R.drawable.cochon,R.drawable.vache, R.drawable.girafe)
        val anwserAnimal2 = arrayOf( R.drawable.cochon,R.drawable.vache, R.drawable.girafe)
        val anwserAnimal3 = arrayOf( R.drawable.cochon,R.drawable.vache, R.drawable.girafe)



        startButton.setOnClickListener {


            resultat.setText("___________")

            ////SILHOUETTE
            tabTampon.set(0,tampon)
            tabTampon.set(1,10)
            tabTampon.set(2,10)


            tampon = randomizeImage(tabTampon, animalArray, animalPic )




            System.out.println("random silhouette")
            System.out.println(tabTampon.get(0))
            System.out.println(tabTampon.get(1))


            ////AWNSER
            tampon1 = randomizeImage(tabTampon, anwserAnimal1, animalAnwser1 )
            tabTampon.set(0,tampon1)


            tampon2 = randomizeImage(tabTampon, anwserAnimal2, animalAnwser2 )
            tabTampon.set(1,tampon2)

            tampon3 = randomizeImage(tabTampon, anwserAnimal3, animalAnwser3 )
            tabTampon.set(2,tampon3)


        }

        animalAnwser1.setOnClickListener{
            compareImage(tampon, tabTampon, 0)
        }

        animalAnwser2.setOnClickListener{
            compareImage(tampon, tabTampon, 1)
        }

        animalAnwser3.setOnClickListener{
            compareImage(tampon, tabTampon, 2)
        }

    }




    private fun compareImage(tampon: Int, tabTampon: IntArray, n: Int) {
        if (tampon == tabTampon.get(n)) {

            resultat.setText("BRAVO")
        } else {
            resultat.setText("RECOMMENCE")
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
