package com.project.wukay.wukayapp.IHM

import android.app.Activity
import android.support.v7.app.AppCompatActivity
import com.project.wukay.wukayapp.Controler
import com.project.wukay.wukayapp.R
import kotlinx.android.synthetic.main.activity_difficulty.*


class ChoixDifficulte(var controler: Controler) : AppCompatActivity() {

    public fun choixDifficulte(){
        controler.app.setContentView(R.layout.activity_difficulty)

        controler.app.txtEasy.setOnClickListener{
            controler.partie.difficulte="easy"
        }

        controler.app.txtHard.setOnClickListener{
            controler.partie.difficulte="dificult"
        }

        controler.app.easyPic.setOnClickListener{
            controler.partie.difficulte="easy"
        }

        controler.app.hardPic.setOnClickListener{
            controler.partie.difficulte="dificult"
        }


    }


}