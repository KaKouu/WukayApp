package com.project.wukay.wukayapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.project.wukay.wukayapp.util.Prefs
import com.project.wukay.wukayapp.util.Skin

import kotlinx.android.synthetic.main.activity_shop.*

class ShopActivity : AppCompatActivity() {

    private var prefs: Prefs? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shop)

        val whiteRabbit = Skin(R.drawable.skin_lapinou_blanc,5)
        val yellowRabbit = Skin(R.drawable.skin_lapinou,0)


        prefs = Prefs(this)
        var carrots = prefs!!.nbCarrots
        nbCarrot.text = carrots.toString()



        btPrice0.setOnClickListener {

            prefs!!.nbCarrots= (prefs!!.nbCarrots)-whiteRabbit.price
            carrots = prefs!!.nbCarrots


            prefs!!.skinName = whiteRabbit.file
            nbCarrot.text = carrots.toString()
            System.out.println("SAVE SKIN :" + prefs!!.skinName )




        }
    }
}
