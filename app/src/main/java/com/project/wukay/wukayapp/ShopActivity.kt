package com.project.wukay.wukayapp

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.KeyEvent
import android.view.View
import com.project.wukay.wukayapp.util.Prefs
import com.project.wukay.wukayapp.util.Skin
import kotlinx.android.synthetic.main.activity_shop.*

class ShopActivity : AppCompatActivity() {

    private var prefs: Prefs? = null

    override fun onKeyDown(keyCode: Int, event: KeyEvent): Boolean {
        return if (keyCode == KeyEvent.KEYCODE_BACK) {
            false
        } else super.onKeyDown(keyCode, event)
    }
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shop)

        prefs = Prefs(this)

        val intent = intent
        val difficulty = intent.getStringExtra("difficulty")

        var carrots = prefs!!.nbCarrots
        nbCarrot.text = carrots.toString()

        val whiteRabbit = Skin(R.drawable.skin_lapinou_blanc, 50, prefs!!.shopPurchased0)
        val yellowRabbit = Skin(R.drawable.skin_lapinou,0, true)
        val girlRabbit = Skin(R.drawable.skin_lapinou_fille,100,prefs!!.shopPurchased2)
        val cowBoyRabbit = Skin(R.drawable.skin_cowboy,200,prefs!!.shopPurchased3)
        val docRabbit = Skin(R.drawable.skin_docteur,250,prefs!!.shopPurchased4)
        val princessRabbit = Skin(R.drawable.skin_lapin_princesse,400,prefs!!.shopPurchased5)
        val spacemanRabbit = Skin(R.drawable.skin_lapin_spaceman,500,prefs!!.shopPurchased6)


        //initialisation purchases and button
        if(whiteRabbit.isPurchase){
            btPrice0.text = "m'utiliser ?"
            price0.visibility=View.INVISIBLE
            imageCarrot0.visibility=View.INVISIBLE
        }
        if(yellowRabbit.isPurchase){
            btPrice1.text= "m'utiliser ?"

        }
        if(girlRabbit.isPurchase){
            btPrice2.text= "m'utiliser ?"
            price2.visibility=View.INVISIBLE
            imageCarrot2.visibility=View.INVISIBLE
        }
        if(cowBoyRabbit.isPurchase){
            btPrice3.text= "m'utiliser ?"
            price3.visibility=View.INVISIBLE
            imageCarrot3.visibility=View.INVISIBLE
        }
        if(docRabbit.isPurchase){
            btPrice4.text= "m'utiliser ?"
            price4.visibility=View.INVISIBLE
            imageCarrot4.visibility=View.INVISIBLE
        }
        if(princessRabbit.isPurchase){
            btPrice5.text= "m'utiliser ?"
            price5.visibility=View.INVISIBLE
            imageCarrot5.visibility=View.INVISIBLE
        }
        if(spacemanRabbit.isPurchase){
            btPrice6.text= "m'utiliser ?"
            price6.visibility=View.INVISIBLE
            imageCarrot6.visibility=View.INVISIBLE
        }

        //whiteRabbit
        if(whiteRabbit.isPurchase==false){
            if(carrots-whiteRabbit.price<0){
                btPrice0.setBackgroundResource(R.drawable.rounded_button_grey)
                img0.setImageResource(R.drawable.skin_lapinou_blanc_gris)
            }else{
                btPrice0.setBackgroundResource(R.drawable.rounded_button)
                img0.setImageResource(R.drawable.skin_lapinou_blanc)
            }
        }

        //girl rabbit
        if(girlRabbit.isPurchase==false){
            if(carrots-girlRabbit.price<0){
                btPrice2.setBackgroundResource(R.drawable.rounded_button_grey)
                img2.setImageResource(R.drawable.skin_lapinou_fille_gris)
            }else{
                btPrice2.setBackgroundResource(R.drawable.rounded_button)
                img2.setImageResource(R.drawable.skin_lapinou_fille)
            }
        }

        //cowboy rabbit
        if(cowBoyRabbit.isPurchase==false){
            if(carrots-cowBoyRabbit.price<0){
                btPrice3.setBackgroundResource(R.drawable.rounded_button_grey)
                img3.setImageResource(R.drawable.skin_cowboy_gris)
            }else{
                btPrice3.setBackgroundResource(R.drawable.rounded_button)
                img3.setImageResource(R.drawable.skin_cowboy)
            }
        }

        //doc rabbit
        if(docRabbit.isPurchase==false){
            if(carrots-docRabbit.price<0){
                btPrice4.setBackgroundResource(R.drawable.rounded_button_grey)
                img4.setImageResource(R.drawable.skin_docteur_gris)
            }else{
                btPrice4.setBackgroundResource(R.drawable.rounded_button)
                img4.setImageResource(R.drawable.skin_docteur)
            }
        }

        //princess rabbit
        if(princessRabbit.isPurchase==false){
            if(carrots-princessRabbit.price<0){
                btPrice5.setBackgroundResource(R.drawable.rounded_button_grey)
                img5.setImageResource(R.drawable.skin_lapin_princesse_gris)
            }else{
                img5.setImageResource(R.drawable.skin_lapin_princesse)
            }
        }

        //spaceman rabbit
        if(spacemanRabbit.isPurchase==false){
            if(carrots-spacemanRabbit.price<0){
                btPrice6.setBackgroundResource(R.drawable.rounded_button_grey)
                img6.setImageResource(R.drawable.skin_lapin_spaceman_gris)
            }else{
                btPrice6.setBackgroundResource(R.drawable.rounded_button)
                img6.setImageResource(R.drawable.skin_lapin_spaceman)
            }
        }

        btPrice0.setOnClickListener {
            if(whiteRabbit.isPurchase){
                prefs!!.skinName = whiteRabbit.file

                btPrice0.text = "selectionné"
                btPrice0.setBackgroundResource(R.drawable.life_pop_background)

                if(yellowRabbit.isPurchase){
                    btPrice1.text= "m'utiliser ?"
                    btPrice1.setBackgroundResource(R.drawable.rounded_button)
                }
                if(girlRabbit.isPurchase){
                    btPrice2.text= "m'utiliser ?"
                    btPrice2.setBackgroundResource(R.drawable.rounded_button)
                }
                if(cowBoyRabbit.isPurchase){
                    btPrice3.text= "m'utiliser ?"
                    btPrice3.setBackgroundResource(R.drawable.rounded_button)
                }
                if(docRabbit.isPurchase){
                    btPrice4.text= "m'utiliser ?"
                    btPrice4.setBackgroundResource(R.drawable.rounded_button)
                }
                if(princessRabbit.isPurchase){
                    btPrice5.text= "m'utiliser ?"
                    btPrice5.setBackgroundResource(R.drawable.rounded_button)
                }
                if(spacemanRabbit.isPurchase){
                    btPrice6.text= "m'utiliser ?"
                    btPrice6.setBackgroundResource(R.drawable.rounded_button)
                }


            }else {
                if(carrots-whiteRabbit.price<0){

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


                    //girl rabbit
                    if(girlRabbit.isPurchase==false){
                        if(carrots-girlRabbit.price<0){
                            btPrice2.setBackgroundResource(R.drawable.rounded_button_grey)
                            img2.setImageResource(R.drawable.skin_lapinou_fille_gris)
                        }else{
                            btPrice2.setBackgroundResource(R.drawable.rounded_button)
                            img2.setImageResource(R.drawable.skin_lapinou_fille)
                        }
                    }

                    //cowboy rabbit
                    if(cowBoyRabbit.isPurchase==false){
                        if(carrots-cowBoyRabbit.price<0){
                            btPrice3.setBackgroundResource(R.drawable.rounded_button_grey)
                            img3.setImageResource(R.drawable.skin_cowboy_gris)
                        }else{
                            btPrice3.setBackgroundResource(R.drawable.rounded_button)
                            img3.setImageResource(R.drawable.skin_cowboy)
                        }
                    }

                    //doc rabbit
                    if(docRabbit.isPurchase==false){
                        if(carrots-docRabbit.price<0){
                            btPrice4.setBackgroundResource(R.drawable.rounded_button_grey)
                            img4.setImageResource(R.drawable.skin_docteur_gris)
                        }else{
                            btPrice4.setBackgroundResource(R.drawable.rounded_button)
                            img4.setImageResource(R.drawable.skin_docteur)
                        }
                    }

                    //princess rabbit
                    if(princessRabbit.isPurchase==false){
                        if(carrots-princessRabbit.price<0){
                            btPrice5.setBackgroundResource(R.drawable.rounded_button_grey)
                            img5.setImageResource(R.drawable.skin_lapin_princesse_gris)
                        }else{
                            img5.setImageResource(R.drawable.skin_lapin_princesse)
                        }
                    }

                    //spaceman rabbit
                    if(spacemanRabbit.isPurchase==false){
                        if(carrots-spacemanRabbit.price<0){
                            btPrice6.setBackgroundResource(R.drawable.rounded_button_grey)
                            img6.setImageResource(R.drawable.skin_lapin_spaceman_gris)
                        }else{
                            btPrice6.setBackgroundResource(R.drawable.rounded_button)
                            img6.setImageResource(R.drawable.skin_lapin_spaceman)
                        }
                    }
                }
            }




        }

        //skin de base
        btPrice1.setOnClickListener {
            prefs!!.skinName = yellowRabbit.file

            btPrice1.text = "selectionné"
            btPrice1.setBackgroundResource(R.drawable.life_pop_background)

            if(whiteRabbit.isPurchase){
                btPrice0.text= "m'utiliser ?"
                btPrice0.setBackgroundResource(R.drawable.rounded_button)
            }
            if(girlRabbit.isPurchase){
                btPrice2.text= "m'utiliser ?"
                btPrice2.setBackgroundResource(R.drawable.rounded_button)
            }
            if(cowBoyRabbit.isPurchase){
                btPrice3.text= "m'utiliser ?"
                btPrice3.setBackgroundResource(R.drawable.rounded_button)
            }
            if(docRabbit.isPurchase){
                btPrice4.text= "m'utiliser ?"
                btPrice4.setBackgroundResource(R.drawable.rounded_button)
            }
            if(princessRabbit.isPurchase){
                btPrice5.text= "m'utiliser ?"
                btPrice5.setBackgroundResource(R.drawable.rounded_button)
            }
            if(spacemanRabbit.isPurchase){
                btPrice6.text= "m'utiliser ?"
                btPrice6.setBackgroundResource(R.drawable.rounded_button)
            }
            }

        //girlRabbit
        btPrice2.setOnClickListener {
            if(girlRabbit.isPurchase){
                prefs!!.skinName = girlRabbit.file

                btPrice2.text = "selectionné"
                btPrice2.setBackgroundResource(R.drawable.life_pop_background)

                if(whiteRabbit.isPurchase){
                    btPrice0.text= "m'utiliser ?"
                    btPrice0.setBackgroundResource(R.drawable.rounded_button)
                }
                if(yellowRabbit.isPurchase){
                    btPrice1.text= "m'utiliser ?"
                    btPrice1.setBackgroundResource(R.drawable.rounded_button)
                }
                if(cowBoyRabbit.isPurchase){
                    btPrice3.text= "m'utiliser ?"
                    btPrice3.setBackgroundResource(R.drawable.rounded_button)
                }
                if(docRabbit.isPurchase){
                    btPrice4.text= "m'utiliser ?"
                    btPrice4.setBackgroundResource(R.drawable.rounded_button)
                }
                if(princessRabbit.isPurchase){
                    btPrice5.text= "m'utiliser ?"
                    btPrice5.setBackgroundResource(R.drawable.rounded_button)
                }
                if(spacemanRabbit.isPurchase){
                    btPrice6.text= "m'utiliser ?"
                    btPrice6.setBackgroundResource(R.drawable.rounded_button)
                }
            }else {
                if(carrots-girlRabbit.price<0){
                    //pas assez de carrotes
                    //TODO
                }else {
                    //actions
                    carrots -= girlRabbit.price
                    girlRabbit.isPurchase=true

                    //affichages
                    btPrice2.text = "m'utiliser ?"
                    nbCarrot.text = carrots.toString()
                    price2.visibility = View.INVISIBLE
                    imageCarrot2.visibility = View.INVISIBLE


                    //sauvegardes
                    prefs!!.nbCarrots = carrots
                    prefs!!.skinName = girlRabbit.file
                    prefs!!.shopPurchased2= girlRabbit.isPurchase

                    //whiteRabbit
                    if(whiteRabbit.isPurchase==false){
                        if(carrots-whiteRabbit.price<0){
                            btPrice0.setBackgroundResource(R.drawable.rounded_button_grey)
                            img0.setImageResource(R.drawable.skin_lapinou_blanc_gris)
                        }else{
                            btPrice0.setBackgroundResource(R.drawable.rounded_button)
                            img0.setImageResource(R.drawable.skin_lapinou_blanc)
                        }
                    }

                    //cowboy rabbit
                    if(cowBoyRabbit.isPurchase==false){
                        if(carrots-cowBoyRabbit.price<0){
                            btPrice3.setBackgroundResource(R.drawable.rounded_button_grey)
                            img3.setImageResource(R.drawable.skin_cowboy_gris)
                        }else{
                            btPrice3.setBackgroundResource(R.drawable.rounded_button)
                            img3.setImageResource(R.drawable.skin_cowboy)
                        }
                    }

                    //doc rabbit
                    if(docRabbit.isPurchase==false){
                        if(carrots-docRabbit.price<0){
                            btPrice4.setBackgroundResource(R.drawable.rounded_button_grey)
                            img4.setImageResource(R.drawable.skin_docteur_gris)
                        }else{
                            btPrice4.setBackgroundResource(R.drawable.rounded_button)
                            img4.setImageResource(R.drawable.skin_docteur)
                        }
                    }

                    //princess rabbit
                    if(princessRabbit.isPurchase==false){
                        if(carrots-princessRabbit.price<0){
                            btPrice5.setBackgroundResource(R.drawable.rounded_button_grey)
                            img5.setImageResource(R.drawable.skin_lapin_princesse_gris)
                        }else{
                            img5.setImageResource(R.drawable.skin_lapin_princesse)
                        }
                    }

                    //spaceman rabbit
                    if(spacemanRabbit.isPurchase==false){
                        if(carrots-spacemanRabbit.price<0){
                            btPrice6.setBackgroundResource(R.drawable.rounded_button_grey)
                            img6.setImageResource(R.drawable.skin_lapin_spaceman_gris)
                        }else{
                            btPrice6.setBackgroundResource(R.drawable.rounded_button)
                            img6.setImageResource(R.drawable.skin_lapin_spaceman)
                        }
                    }

                }
            }




        }

        //cowBoyRabbit
        btPrice3.setOnClickListener {
            if(cowBoyRabbit.isPurchase){
                prefs!!.skinName = cowBoyRabbit.file

                btPrice3.text = "selectionné"
                btPrice3.setBackgroundResource(R.drawable.life_pop_background)

                if(whiteRabbit.isPurchase){
                    btPrice0.text= "m'utiliser ?"
                    btPrice0.setBackgroundResource(R.drawable.rounded_button)
                }
                if(yellowRabbit.isPurchase){
                    btPrice1.text= "m'utiliser ?"
                    btPrice1.setBackgroundResource(R.drawable.rounded_button)
                }
                if(girlRabbit.isPurchase){
                    btPrice2.text= "m'utiliser ?"
                    btPrice2.setBackgroundResource(R.drawable.rounded_button)
                }
                if(docRabbit.isPurchase){
                    btPrice4.text= "m'utiliser ?"
                    btPrice4.setBackgroundResource(R.drawable.rounded_button)
                }
                if(princessRabbit.isPurchase){
                    btPrice5.text= "m'utiliser ?"
                    btPrice5.setBackgroundResource(R.drawable.rounded_button)
                }
                if(spacemanRabbit.isPurchase){
                    btPrice6.text= "m'utiliser ?"
                    btPrice6.setBackgroundResource(R.drawable.rounded_button)
                }
            }else {
                if(carrots-cowBoyRabbit.price<0){
                    //pas assez de carrotes
                    //TODO
                }else {
                    //actions
                    carrots -= cowBoyRabbit.price
                    cowBoyRabbit.isPurchase=true

                    //affichages
                    btPrice3.text = "m'utiliser ?"
                    nbCarrot.text = carrots.toString()
                    price3.visibility = View.INVISIBLE
                    imageCarrot3.visibility = View.INVISIBLE


                    //sauvegardes
                    prefs!!.nbCarrots = carrots
                    prefs!!.skinName = cowBoyRabbit.file
                    prefs!!.shopPurchased3= cowBoyRabbit.isPurchase

                    //whiteRabbit
                    if(whiteRabbit.isPurchase==false){
                        if(carrots-whiteRabbit.price<0){
                            btPrice0.setBackgroundResource(R.drawable.rounded_button_grey)
                            img0.setImageResource(R.drawable.skin_lapinou_blanc_gris)
                        }else{
                            btPrice0.setBackgroundResource(R.drawable.rounded_button)
                            img0.setImageResource(R.drawable.skin_lapinou_blanc)
                        }
                    }

                    //girl rabbit
                    if(girlRabbit.isPurchase==false){
                        if(carrots-girlRabbit.price<0){
                            btPrice2.setBackgroundResource(R.drawable.rounded_button_grey)
                            img2.setImageResource(R.drawable.skin_lapinou_fille_gris)
                        }else{
                            btPrice2.setBackgroundResource(R.drawable.rounded_button)
                            img2.setImageResource(R.drawable.skin_lapinou_fille)
                        }
                    }

                    //doc rabbit
                    if(docRabbit.isPurchase==false){
                        if(carrots-docRabbit.price<0){
                            btPrice4.setBackgroundResource(R.drawable.rounded_button_grey)
                            img4.setImageResource(R.drawable.skin_docteur_gris)
                        }else{
                            btPrice4.setBackgroundResource(R.drawable.rounded_button)
                            img4.setImageResource(R.drawable.skin_docteur)
                        }
                    }

                    //princess rabbit
                    if(princessRabbit.isPurchase==false){
                        if(carrots-princessRabbit.price<0){
                            btPrice5.setBackgroundResource(R.drawable.rounded_button_grey)
                            img5.setImageResource(R.drawable.skin_lapin_princesse_gris)
                        }else{
                            img5.setImageResource(R.drawable.skin_lapin_princesse)
                        }
                    }

                    //spaceman rabbit
                    if(spacemanRabbit.isPurchase==false){
                        if(carrots-spacemanRabbit.price<0){
                            btPrice6.setBackgroundResource(R.drawable.rounded_button_grey)
                            img6.setImageResource(R.drawable.skin_lapin_spaceman_gris)
                        }else{
                            btPrice6.setBackgroundResource(R.drawable.rounded_button)
                            img6.setImageResource(R.drawable.skin_lapin_spaceman)
                        }
                    }
                }
            }




        }

        //docRabbit
        btPrice4.setOnClickListener {
            if(docRabbit.isPurchase){
                prefs!!.skinName = docRabbit.file

                btPrice4.text = "selectionné"
                btPrice4.setBackgroundResource(R.drawable.life_pop_background)

                if(whiteRabbit.isPurchase){
                    btPrice0.text= "m'utiliser ?"
                    btPrice0.setBackgroundResource(R.drawable.rounded_button)
                }
                if(yellowRabbit.isPurchase){
                    btPrice1.text= "m'utiliser ?"
                    btPrice1.setBackgroundResource(R.drawable.rounded_button)
                }
                if(girlRabbit.isPurchase){
                    btPrice2.text= "m'utiliser ?"
                    btPrice2.setBackgroundResource(R.drawable.rounded_button)
                }
                if(cowBoyRabbit.isPurchase){
                    btPrice3.text= "m'utiliser ?"
                    btPrice3.setBackgroundResource(R.drawable.rounded_button)
                }
                if(princessRabbit.isPurchase){
                    btPrice5.text= "m'utiliser ?"
                    btPrice5.setBackgroundResource(R.drawable.rounded_button)
                }
                if(spacemanRabbit.isPurchase){
                    btPrice6.text= "m'utiliser ?"
                    btPrice6.setBackgroundResource(R.drawable.rounded_button)
                }
            }else {
                if(carrots-docRabbit.price<0){
                    //pas assez de carrotes
                    //TODO
                }else {
                    //actions
                    carrots -= docRabbit.price
                    docRabbit.isPurchase=true

                    //affichages
                    btPrice4.text = "m'utiliser ?"
                    nbCarrot.text = carrots.toString()
                    price4.visibility = View.INVISIBLE
                    imageCarrot4.visibility = View.INVISIBLE


                    //sauvegardes
                    prefs!!.nbCarrots = carrots
                    prefs!!.skinName = docRabbit.file
                    prefs!!.shopPurchased4= docRabbit.isPurchase

                    //whiteRabbit
                    if(whiteRabbit.isPurchase==false){
                        if(carrots-whiteRabbit.price<0){
                            btPrice0.setBackgroundResource(R.drawable.rounded_button_grey)
                            img0.setImageResource(R.drawable.skin_lapinou_blanc_gris)
                        }else{
                            btPrice0.setBackgroundResource(R.drawable.rounded_button)
                            img0.setImageResource(R.drawable.skin_lapinou_blanc)
                        }
                    }

                    //girl rabbit
                    if(girlRabbit.isPurchase==false){
                        if(carrots-girlRabbit.price<0){
                            btPrice2.setBackgroundResource(R.drawable.rounded_button_grey)
                            img2.setImageResource(R.drawable.skin_lapinou_fille_gris)
                        }else{
                            btPrice2.setBackgroundResource(R.drawable.rounded_button)
                            img2.setImageResource(R.drawable.skin_lapinou_fille)
                        }
                    }

                    //cowboy rabbit
                    if(cowBoyRabbit.isPurchase==false){
                        if(carrots-cowBoyRabbit.price<0){
                            btPrice3.setBackgroundResource(R.drawable.rounded_button_grey)
                            img3.setImageResource(R.drawable.skin_cowboy_gris)
                        }else{
                            btPrice3.setBackgroundResource(R.drawable.rounded_button)
                            img3.setImageResource(R.drawable.skin_cowboy)
                        }
                    }

                    //princess rabbit
                    if(princessRabbit.isPurchase==false){
                        if(carrots-princessRabbit.price<0){
                            btPrice5.setBackgroundResource(R.drawable.rounded_button_grey)
                            img5.setImageResource(R.drawable.skin_lapin_princesse_gris)
                        }else{
                            img5.setImageResource(R.drawable.skin_lapin_princesse)
                        }
                    }

                    //spaceman rabbit
                    if(spacemanRabbit.isPurchase==false){
                        if(carrots-spacemanRabbit.price<0){
                            btPrice6.setBackgroundResource(R.drawable.rounded_button_grey)
                            img6.setImageResource(R.drawable.skin_lapin_spaceman_gris)
                        }else{
                            btPrice6.setBackgroundResource(R.drawable.rounded_button)
                            img6.setImageResource(R.drawable.skin_lapin_spaceman)
                        }
                    }
                }
            }




        }

        //princessRabbit
        btPrice5.setOnClickListener {
            if(princessRabbit.isPurchase){
                prefs!!.skinName = princessRabbit.file

                btPrice5.text = "selectionné"
                btPrice5.setBackgroundResource(R.drawable.life_pop_background)


                if(whiteRabbit.isPurchase){
                    btPrice0.text= "m'utiliser ?"
                    btPrice0.setBackgroundResource(R.drawable.rounded_button)
                }
                if(yellowRabbit.isPurchase){
                    btPrice1.text= "m'utiliser ?"
                    btPrice1.setBackgroundResource(R.drawable.rounded_button)
                }
                if(girlRabbit.isPurchase){
                    btPrice2.text= "m'utiliser ?"
                    btPrice2.setBackgroundResource(R.drawable.rounded_button)
                }
                if(cowBoyRabbit.isPurchase){
                    btPrice3.text= "m'utiliser ?"
                    btPrice3.setBackgroundResource(R.drawable.rounded_button)
                }
                if(docRabbit.isPurchase){
                    btPrice4.text= "m'utiliser ?"
                    btPrice4.setBackgroundResource(R.drawable.rounded_button)
                }
                if(spacemanRabbit.isPurchase){
                    btPrice6.text= "m'utiliser ?"
                    btPrice6.setBackgroundResource(R.drawable.rounded_button)
                }


            }else {
                if(carrots-princessRabbit.price<0){
                    //pas assez de carrotes
                    //TODO
                }else {
                    //actions
                    carrots -= princessRabbit.price
                    princessRabbit.isPurchase=true

                    //affichages
                    btPrice5.text = "m'utiliser ?"
                    nbCarrot.text = carrots.toString()
                    price5.visibility = View.INVISIBLE
                    imageCarrot5.visibility = View.INVISIBLE


                    //sauvegardes
                    prefs!!.nbCarrots = carrots
                    prefs!!.skinName = princessRabbit.file
                    prefs!!.shopPurchased5= princessRabbit.isPurchase

                    //whiteRabbit
                    if(whiteRabbit.isPurchase==false){
                        if(carrots-whiteRabbit.price<0){
                            btPrice0.setBackgroundResource(R.drawable.rounded_button_grey)
                            img0.setImageResource(R.drawable.skin_lapinou_blanc_gris)
                        }else{
                            btPrice0.setBackgroundResource(R.drawable.rounded_button)
                            img0.setImageResource(R.drawable.skin_lapinou_blanc)
                        }
                    }

                    //girl rabbit
                    if(girlRabbit.isPurchase==false){
                        if(carrots-girlRabbit.price<0){
                            btPrice2.setBackgroundResource(R.drawable.rounded_button_grey)
                            img2.setImageResource(R.drawable.skin_lapinou_fille_gris)
                        }else{
                            btPrice2.setBackgroundResource(R.drawable.rounded_button)
                            img2.setImageResource(R.drawable.skin_lapinou_fille)
                        }
                    }

                    //cowboy rabbit
                    if(cowBoyRabbit.isPurchase==false){
                        if(carrots-cowBoyRabbit.price<0){
                            btPrice3.setBackgroundResource(R.drawable.rounded_button_grey)
                            img3.setImageResource(R.drawable.skin_cowboy_gris)
                        }else{
                            btPrice3.setBackgroundResource(R.drawable.rounded_button)
                            img3.setImageResource(R.drawable.skin_cowboy)
                        }
                    }

                    //doc rabbit
                    if(docRabbit.isPurchase==false){
                        if(carrots-docRabbit.price<0){
                            btPrice4.setBackgroundResource(R.drawable.rounded_button_grey)
                            img4.setImageResource(R.drawable.skin_docteur_gris)
                        }else{
                            btPrice4.setBackgroundResource(R.drawable.rounded_button)
                            img4.setImageResource(R.drawable.skin_docteur)
                        }
                    }

                    //spaceman rabbit
                    if(spacemanRabbit.isPurchase==false){
                        if(carrots-spacemanRabbit.price<0){
                            btPrice6.setBackgroundResource(R.drawable.rounded_button_grey)
                            img6.setImageResource(R.drawable.skin_lapin_spaceman_gris)
                        }else{
                            btPrice6.setBackgroundResource(R.drawable.rounded_button)
                            img6.setImageResource(R.drawable.skin_lapin_spaceman)
                        }
                    }
                }
            }




        }

        //princessRabbit
        btPrice6.setOnClickListener {
            if(spacemanRabbit.isPurchase){
                prefs!!.skinName = spacemanRabbit.file

                btPrice6.text = "selectionné"
                btPrice6.setBackgroundResource(R.drawable.life_pop_background)

                if(whiteRabbit.isPurchase){
                    btPrice0.text= "m'utiliser ?"
                    btPrice0.setBackgroundResource(R.drawable.rounded_button)
                }
                if(yellowRabbit.isPurchase){
                    btPrice1.text= "m'utiliser ?"
                    btPrice1.setBackgroundResource(R.drawable.rounded_button)
                }
                if(girlRabbit.isPurchase){
                    btPrice2.text= "m'utiliser ?"
                    btPrice2.setBackgroundResource(R.drawable.rounded_button)
                }
                if(cowBoyRabbit.isPurchase){
                    btPrice3.text= "m'utiliser ?"
                    btPrice3.setBackgroundResource(R.drawable.rounded_button)
                }
                if(docRabbit.isPurchase){
                    btPrice4.text= "m'utiliser ?"
                    btPrice4.setBackgroundResource(R.drawable.rounded_button)
                }
                if(princessRabbit.isPurchase){
                    btPrice5.text= "m'utiliser ?"
                    btPrice5.setBackgroundResource(R.drawable.rounded_button)
                }

            }else {
                if(carrots-spacemanRabbit.price<0){
                    //pas assez de carrotes
                    //TODO
                }else {
                    //actions
                    carrots -= spacemanRabbit.price
                    spacemanRabbit.isPurchase=true

                    //affichages
                    btPrice6.text = "m'utiliser ?"
                    nbCarrot.text = carrots.toString()
                    price6.visibility = View.INVISIBLE
                    imageCarrot6.visibility = View.INVISIBLE


                    //sauvegardes
                    prefs!!.nbCarrots = carrots
                    prefs!!.skinName = spacemanRabbit.file
                    prefs!!.shopPurchased6= spacemanRabbit.isPurchase

                    //whiteRabbit
                    if(whiteRabbit.isPurchase==false){
                        if(carrots-whiteRabbit.price<0){
                            btPrice0.setBackgroundResource(R.drawable.rounded_button_grey)
                            img0.setImageResource(R.drawable.skin_lapinou_blanc_gris)
                        }else{
                            btPrice0.setBackgroundResource(R.drawable.rounded_button)
                            img0.setImageResource(R.drawable.skin_lapinou_blanc)
                        }
                    }

                    //girl rabbit
                    if(girlRabbit.isPurchase==false){
                        if(carrots-girlRabbit.price<0){
                            btPrice2.setBackgroundResource(R.drawable.rounded_button_grey)
                            img2.setImageResource(R.drawable.skin_lapinou_fille_gris)
                        }else{
                            btPrice2.setBackgroundResource(R.drawable.rounded_button)
                            img2.setImageResource(R.drawable.skin_lapinou_fille)
                        }
                    }

                    //cowboy rabbit
                    if(cowBoyRabbit.isPurchase==false){
                        if(carrots-cowBoyRabbit.price<0){
                            btPrice3.setBackgroundResource(R.drawable.rounded_button_grey)
                            img3.setImageResource(R.drawable.skin_cowboy_gris)
                        }else{
                            btPrice3.setBackgroundResource(R.drawable.rounded_button)
                            img3.setImageResource(R.drawable.skin_cowboy)
                        }
                    }

                    //doc rabbit
                    if(docRabbit.isPurchase==false){
                        if(carrots-docRabbit.price<0){
                            btPrice4.setBackgroundResource(R.drawable.rounded_button_grey)
                            img4.setImageResource(R.drawable.skin_docteur_gris)
                        }else{
                            btPrice4.setBackgroundResource(R.drawable.rounded_button)
                            img4.setImageResource(R.drawable.skin_docteur)
                        }
                    }

                    //princess rabbit
                    if(princessRabbit.isPurchase==false){
                        if(carrots-princessRabbit.price<0){
                            btPrice5.setBackgroundResource(R.drawable.rounded_button_grey)
                            img5.setImageResource(R.drawable.skin_lapin_princesse_gris)
                        }else{
                            img5.setImageResource(R.drawable.skin_lapin_princesse)
                        }
                    }
                }
            }




        }


        //Button
        retour.setOnClickListener {
            val previousPage = Intent(this@ShopActivity, LevelsActivity::class.java)
            previousPage.putExtra("difficulty",difficulty)
            startActivity(previousPage)
        }

        buttonMoreCarrots.setOnClickListener {
            val difficulty = intent.getStringExtra("difficulty")
            val buy = Intent(this@ShopActivity, InAppBilling::class.java)
            buy.putExtra("difficulty",difficulty)
            startActivity(buy)
        }

    }

    fun getColorWithAlpha(color: Int, ratio: Float): Int {
        var newColor = 0
        val alpha = Math.round(Color.alpha(color) * ratio)
        val r = Color.red(color)
        val g = Color.green(color)
        val b = Color.blue(color)
        newColor = Color.argb(alpha, r, g, b)
        return newColor
    }
}
