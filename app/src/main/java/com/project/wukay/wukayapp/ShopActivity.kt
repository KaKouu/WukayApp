package com.project.wukay.wukayapp

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
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



        prefs = Prefs(this)
        val purchases : Array<Boolean> = arrayOf(true,true)




        var carrots = prefs!!.nbCarrots
        nbCarrot.text = carrots.toString()




        val whiteRabbit = Skin(R.drawable.skin_lapinou_blanc, 5, prefs!!.shopPurchased0)
        val yellowRabbit = Skin(R.drawable.skin_lapinou,0, true)
        val test2Rabbit = Skin(R.drawable.skin_lapinou_test2,100,prefs!!.shopPurchased2)
        val test3Rabbit = Skin(R.drawable.skin_lapinou_test3,250,prefs!!.shopPurchased3)



        //initialisation purchases and button
        if(whiteRabbit.isPurchase){
            btPrice0.text = "m'utiliser ?"
        }
        if(yellowRabbit.isPurchase){
            btPrice1.text= "m'utiliser ?"
        }
        if(test2Rabbit.isPurchase){
            btPrice2.text= "m'utiliser ?"
        }
        if(test3Rabbit.isPurchase){
            btPrice3.text= "m'utiliser ?"
        }

        //whiteRabbit
        btPrice0.setOnClickListener {
            if(whiteRabbit.isPurchase){
                prefs!!.skinName = whiteRabbit.file

                btPrice0.text = "selectionné"

                if(yellowRabbit.isPurchase){
                    btPrice1.text= "m'utiliser ?"
                }
                if(test2Rabbit.isPurchase){
                    btPrice2.text= "m'utiliser ?"
                }
                if(test3Rabbit.isPurchase){
                    btPrice3.text= "m'utiliser ?"
                }



            }else {
                if(carrots-whiteRabbit.price<0){
                    //pas assez de carrotes
                    //TODO
                }else {
                    //actions
                    carrots -= whiteRabbit.price
                    whiteRabbit.isPurchase=true

                    //affichages
                    btPrice0.text = "m'utiliser ?"
                    nbCarrot.text = carrots.toString()
                    price0.visibility = View.INVISIBLE
                    imageCarrot0.visibility = View.INVISIBLE


                    //sauvegardes
                    prefs!!.nbCarrots = carrots
                    prefs!!.skinName = whiteRabbit.file
                    prefs!!.shopPurchased0= whiteRabbit.isPurchase

                }
            }




        }

        //skin de base
        btPrice1.setOnClickListener {
            prefs!!.skinName = yellowRabbit.file

            btPrice1.text = "selectionné"

            if(whiteRabbit.isPurchase){
                btPrice0.text= "m'utiliser ?"
            }
            if(test2Rabbit.isPurchase){
                btPrice2.text= "m'utiliser ?"
            }
            if(test3Rabbit.isPurchase){
                btPrice3.text= "m'utiliser ?"
            }
            }

        //testRabbit 2
        btPrice2.setOnClickListener {
            if(test2Rabbit.isPurchase){
                prefs!!.skinName = test2Rabbit.file

                btPrice2.text = "selectionné"

                if(whiteRabbit.isPurchase){
                    btPrice0.text= "m'utiliser ?"
                }
                if(yellowRabbit.isPurchase){
                    btPrice1.text= "m'utiliser ?"
                }
                if(test3Rabbit.isPurchase){
                    btPrice3.text= "m'utiliser ?"
                }
            }else {
                if(carrots-test2Rabbit.price<0){
                    //pas assez de carrotes
                    //TODO
                }else {
                    //actions
                    carrots -= test2Rabbit.price
                    test2Rabbit.isPurchase=true

                    //affichages
                    btPrice2.text = "m'utiliser ?"
                    nbCarrot.text = carrots.toString()
                    price2.visibility = View.INVISIBLE
                    imageCarrot2.visibility = View.INVISIBLE


                    //sauvegardes
                    prefs!!.nbCarrots = carrots
                    prefs!!.skinName = test2Rabbit.file
                    prefs!!.shopPurchased2= test2Rabbit.isPurchase

                }
            }




        }

        //testRabbit 3
        btPrice3.setOnClickListener {
            if(test3Rabbit.isPurchase){
                prefs!!.skinName = test3Rabbit.file

                btPrice3.text = "selectionné"

                if(whiteRabbit.isPurchase){
                    btPrice0.text= "m'utiliser ?"
                }
                if(yellowRabbit.isPurchase){
                    btPrice1.text= "m'utiliser ?"
                }
                if(test2Rabbit.isPurchase){
                    btPrice2.text= "m'utiliser ?"
                }
            }else {
                if(carrots-test3Rabbit.price<0){
                    //pas assez de carrotes
                    //TODO
                }else {
                    //actions
                    carrots -= test3Rabbit.price
                    test3Rabbit.isPurchase=true

                    //affichages
                    btPrice3.text = "m'utiliser ?"
                    nbCarrot.text = carrots.toString()
                    price3.visibility = View.INVISIBLE
                    imageCarrot3.visibility = View.INVISIBLE


                    //sauvegardes
                    prefs!!.nbCarrots = carrots
                    prefs!!.skinName = test3Rabbit.file
                    prefs!!.shopPurchased3= test3Rabbit.isPurchase

                }
            }




        }







        retour.setOnClickListener {
            val previousPage = Intent(this@ShopActivity, LevelsActivity::class.java)
            startActivity(previousPage)
        }

    }
}
