package com.project.wukay.wukayapp

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)




        startButton.setOnClickListener{
            val start = Intent(this@HomeActivity, DifficultyActivity::class.java)
            startActivity(start);
        }
    }

}
