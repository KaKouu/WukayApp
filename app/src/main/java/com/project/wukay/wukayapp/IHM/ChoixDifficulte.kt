package com.project.wukay.wukayapp.IHM

import android.app.Activity
import com.project.wukay.wukayapp.Controler
import com.project.wukay.wukayapp.R
import kotlinx.android.synthetic.main.activity_difficulty.*


class ChoixDifficulte(var controler: Controler): Activity() {

    public fun choixDifficulte(controler: Controler){
        controler.app.setContentView(R.layout.activity_difficulty)

        easyPic.setOnClickListener{
            controler.partie.difficulte="easy"
        }

        hardPic.setOnClickListener{
            controler.partie.difficulte="dificult"
        }
    }


}