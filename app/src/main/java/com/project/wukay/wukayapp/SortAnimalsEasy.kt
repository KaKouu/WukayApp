package com.project.wukay.wukayapp

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.KeyEvent
import android.view.MotionEvent
import android.view.View
import com.project.wukay.wukayapp.metier.SortAnimalsMetier
import kotlinx.android.synthetic.main.activity_feed_animals.*

class SortAnimalsEasy : AppCompatActivity() {
    private var sortAnimalsMetier = SortAnimalsMetier()

    override fun onKeyDown(keyCode: Int, event: KeyEvent): Boolean {
        return if (keyCode == KeyEvent.KEYCODE_BACK) {
            false
        } else super.onKeyDown(keyCode, event)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_feed_animals)
        sortAnimalsMetier.beginGame()

        val listOfAnimals = arrayOf(
            R.drawable.animaux_cochon,
            R.drawable.animaux_vache,
            R.drawable.animaux_girafe,
            R.drawable.animaux_bouc,
            R.drawable.animaux_chat,
            R.drawable.animaux_pirahna,
            R.drawable.animaux_morse,
            R.drawable.animaux_panda,
            R.drawable.animaux_paon,
            R.drawable.animaux_pingouin,
            R.drawable.animaux_poule,
            R.drawable.animaux_tigre,
            R.drawable.animaux_zebre,
            R.drawable.animaux_lion
        )

        val listOfDecor = arrayOf(
            R.drawable.fond_lac,
            R.drawable.fond_lac,
            R.drawable.fond_lac,
            R.drawable.coche,
            R.drawable.feux_artifice,
            R.drawable.coche,
            R.drawable.feux_artifice,
            R.drawable.feux_artifice,
            R.drawable.coche,
            R.drawable.feux_artifice,
            R.drawable.feux_artifice,
            R.drawable.fond_lac,
            R.drawable.fond_lac,
            R.drawable.fond_lac
        )
        sortAnimalsMetier.generateAnimalsAndDecor()

    }

}