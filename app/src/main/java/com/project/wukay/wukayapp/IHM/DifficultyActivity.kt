package com.project.wukay.wukayapp.IHM

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.project.wukay.wukayapp.LevelsActivity
import com.project.wukay.wukayapp.R
import kotlinx.android.synthetic.main.activity_difficulty.*


class DifficultyActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_difficulty)
        val next = Intent(this@DifficultyActivity, LevelsActivity::class.java)
        var difficulty = ""

        easyPic.setOnClickListener{
            difficulty="easy"
            next.putExtra("difficulty", difficulty)
            startActivity(next)
        }

        hardPic.setOnClickListener{
            difficulty="hard"

            next.putExtra("difficulty", difficulty)

            startActivity(next)
        }


    }
}
