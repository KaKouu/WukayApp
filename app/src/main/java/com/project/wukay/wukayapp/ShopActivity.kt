package com.project.wukay.wukayapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.project.wukay.wukayapp.util.Prefs
import com.project.wukay.wukayapp.util.Skin

import kotlinx.android.synthetic.main.activity_shop.*

class ShopActivity : AppCompatActivity() {

    private var prefs: Prefs? = null


    enum class ItemPurchased{
        YES,NO
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shop)

        val whiteRabbit = Skin(R.drawable.skin_lapinou_blanc,5)
        val yellowRabbit = Skin(R.drawable.skin_lapinou,0)



        var carrots = prefs!!.nbCarrots
        nbCarrot.text = carrots.toString()



        btPrice0.setOnClickListener {



            if(whiteRabbit.isPurchase){



            }else {

                if(carrots-whiteRabbit.price<0){
                    //pas assez de carrotes
                    //TODO

                }else {


                    carrots -= carrots - whiteRabbit.price
                    prefs!!.nbCarrots = carrots


                    prefs!!.skinName = whiteRabbit.file
                    nbCarrot.text = carrots.toString()
                    System.out.println("SAVE SKIN :" + prefs!!.skinName)
                    whiteRabbit.savePurchase(true)
                    btPrice0.text = "►"
                }
            }




        }
    }
}
