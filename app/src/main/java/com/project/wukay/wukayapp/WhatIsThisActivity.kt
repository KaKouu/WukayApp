package com.project.wukay.wukayapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_what_is_this.*
import java.util.*

class WhatIsThisActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_what_is_this)

        var tampon = 0




        val animalArray = arrayOf( R.drawable.cochon,R.drawable.vache, R.drawable.girafe)



        startButton.setOnClickListener {

                var r = Random()

                var n = r.nextInt(3)


            while( tampon == n){
                    n = r.nextInt(3)

                }

            animalPic.setImageResource(animalArray[n])

            tampon = n







        }

    }
}
