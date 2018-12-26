package com.project.wukay.wukayapp

import android.content.Intent
import android.media.MediaPlayer
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.project.wukay.wukayapp.IHM.ChoixDifficulte
import com.project.wukay.wukayapp.IHM.DifficultyActivity
import com.project.wukay.wukayapp.metier.Partie
import com.project.wukay.wukayapp.util.Prefs
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {

    private var prefs: Prefs? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var controler= Controler(this, Partie("null"))
        setContentView(R.layout.activity_home)

        val music  = MediaPlayer.create(this, R.raw.sound_birds)

        prefs = Prefs(this)
        var skinName = prefs!!.skinName



        imageLapinou.setImageResource(skinName)



        music.start()


        startButton.setOnClickListener{

            val start = Intent(this@HomeActivity, DifficultyActivity::class.java)
            startActivity(start)
            music.stop()

            //prefs!!.skinName=R.drawable.skin_lapinou
            prefs!!.skinName=skinName
            //System.out.println(R.drawable.skin_lapinou)
            System.out.println("SAVE SKIN :" + skinName)



            System.out.println(controler.partie.difficulte)

        }
    }

}
