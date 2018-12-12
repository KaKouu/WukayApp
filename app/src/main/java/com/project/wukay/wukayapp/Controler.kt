package com.project.wukay.wukayapp

import android.support.v7.app.AppCompatActivity
import com.project.wukay.wukayapp.metier.Partie

class Controler(var app : AppCompatActivity,var partie: Partie) {

    public fun choixDifficulte(app: AppCompatActivity,partie :Partie){

        app.setContentView(R.layout.activity_difficulty)

    }



}