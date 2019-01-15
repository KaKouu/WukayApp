package com.project.wukay.wukayapp

import android.support.v7.app.AppCompatActivity
import com.project.wukay.wukayapp.IHM.ChoixDifficulte
import com.project.wukay.wukayapp.metier.Partie

class Controler(var app : AppCompatActivity,var partie: Partie) {

    public fun choixDifficulte(){
        var choix = ChoixDifficulte(this)
        choix.choixDifficulte()
    }



}