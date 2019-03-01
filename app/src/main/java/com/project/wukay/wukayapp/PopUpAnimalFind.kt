package com.project.wukay.wukayapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.DisplayMetrics
import android.view.Gravity
import android.view.WindowManager
import kotlinx.android.synthetic.main.activity_life_pop.*
import kotlinx.android.synthetic.main.activity_pop_up_animal_find.*

class PopUpAnimalFind : AppCompatActivity() {

    companion object {

        private const val HEIGHT = 1000
        private const val WIDTH = 1000
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pop_up_animal_find)

        val intent = intent
        val animalImage = intent.getIntExtra("animalFind",R.drawable.animaux_cochon)
        val animalName = intent.getStringExtra("animalNameFind")



        animalFind.setImageResource(animalImage)
        nameAnimalFind.text = animalName

        closeButton2.setOnClickListener {
            finish()
        }

        var metrics = DisplayMetrics()

        windowManager.defaultDisplay.getMetrics(metrics)

        metrics.widthPixels
        metrics.heightPixels


        window.setLayout(metrics.widthPixels*2/3, metrics.heightPixels*2/3)

        var params: WindowManager.LayoutParams = window.attributes

        params.gravity = Gravity.CENTER
        params.x = 0
        params.y = -230

        window.attributes = params
    }
}
