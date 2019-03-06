package com.project.wukay.wukayapp.FeedAnimalsGame

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Vibrator
import android.util.DisplayMetrics
import android.view.KeyEvent
import android.view.MotionEvent
import android.view.View
import com.project.wukay.wukayapp.R
import com.project.wukay.wukayapp.VictoryActivity
import com.project.wukay.wukayapp.metier.FeedAnimalsHardModel
import com.project.wukay.wukayapp.metier.HideAnimalsMetier
import com.project.wukay.wukayapp.util.Aleatoire
import kotlinx.android.synthetic.main.activity_feed_hard_animals.*
import java.util.*

class FeedAnimalsHardControler : AppCompatActivity() {
    var feedAnimalsHard = FeedAnimalsHardModel()
    var aleatoire = Aleatoire()
    var random=Random()
    var positionX=FloatArray(3)
    var positionY=FloatArray(3)
    var difficulty=""
    val nombreAnimauxAchercher =3

    val listOfAnimals = arrayOf(
        R.drawable.animaux_panier_cochon,
        R.drawable.animaux_panier_vache,
        R.drawable.animaux_panier_girafe,
        R.drawable.animaux_panier_bouc,
        R.drawable.animaux_panier_chat,
        R.drawable.animaux_panier_crabe,
        R.drawable.animaux_panier_morse,
        R.drawable.animaux_panier_panda,
        R.drawable.animaux_panier_paon,
        R.drawable.animaux_panier_pingouin,
        R.drawable.animaux_panier_poule,
        R.drawable.animaux_panier_tigre,
        R.drawable.animaux_panier_zebre,
        R.drawable.animaux_panier_lion
    )
    var tableauEntierAleatoireDifferent = aleatoire.chiffreAleatoireDifferentEntreDeuxBornes(listOfAnimals.size,nombreAnimauxAchercher)

    override fun onKeyDown(keyCode: Int, event: KeyEvent): Boolean {
        return if (keyCode == KeyEvent.KEYCODE_BACK) {
            false
        } else super.onKeyDown(keyCode, event)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        feedAnimalsHard.initialisationJeu()
        // mise en place du layout
        super.onCreate(savedInstanceState)


        //déclaration des variables
        difficulty = intent.getStringExtra("difficulty") //renvaiera la difficulté choisit precedement



        val vibratorService = getSystemService(Context.VIBRATOR_SERVICE) as Vibrator



        val displayMetrics = DisplayMetrics()
        windowManager.defaultDisplay.getMetrics(displayMetrics)
        val heightScreen = displayMetrics.heightPixels
        val widthScreen = displayMetrics.widthPixels

        positionX.set(0,0f)
        positionX.set(1,(widthScreen/4).toFloat())
        positionX.set(2,(widthScreen*2/4).toFloat())


        positionY.set(0,0f)
        positionY.set(1,(heightScreen/4).toFloat())
        positionY.set(2,(heightScreen*2/4).toFloat())

        val listOfAnimals = arrayOf(
            R.drawable.animaux_panier_cochon,
            R.drawable.animaux_panier_vache,
            R.drawable.animaux_panier_girafe,
            R.drawable.animaux_panier_bouc,
            R.drawable.animaux_panier_chat,
            R.drawable.animaux_panier_crabe,
            R.drawable.animaux_panier_morse,
            R.drawable.animaux_panier_panda,
            R.drawable.animaux_panier_paon,
            R.drawable.animaux_panier_pingouin,
            R.drawable.animaux_panier_poule,
            R.drawable.animaux_panier_tigre,
            R.drawable.animaux_panier_zebre,
            R.drawable.animaux_panier_lion
        )

        val listOfFood = arrayOf(
            R.drawable.food_mais,
            R.drawable.food_herbe,
            R.drawable.food_feuille,
            R.drawable.food_herbe,
            R.drawable.food_souris,
            R.drawable.food_poisson,
            R.drawable.food_crevette,
            R.drawable.food_bambou,
            R.drawable.food_graine,
            R.drawable.food_poisson,
            R.drawable.food_graine,
            R.drawable.food_viande,
            R.drawable.food_feuille,
            R.drawable.food_viande
        )



        setContentView(R.layout.activity_feed_hard_animals)
        myLayoutFood.setOnTouchListener { v: View, m: MotionEvent ->
            handleTouch(m)
            true
        }




        System.out.println("PASSEPAS")

        System.out.println("PASSE")
        animalFood3.setImageResource(listOfAnimals[tableauEntierAleatoireDifferent.get(0)])
        animalFood2.setImageResource(listOfAnimals[tableauEntierAleatoireDifferent.get(1)])
        animalFood1.setImageResource(listOfAnimals[tableauEntierAleatoireDifferent.get(2)])

        food3Hide.setImageResource(listOfFood[tableauEntierAleatoireDifferent.get(0)])
        food2Hide.setImageResource(listOfFood[tableauEntierAleatoireDifferent.get(1)])
        food1Hide.setImageResource(listOfFood[tableauEntierAleatoireDifferent.get(2)])
        feedAnimalsHard.placementAleatoireDansTableau()


        System.out.println("PLACEMENT"+positionX[feedAnimalsHard.getPlacementX()[0]])


        food1Hide.x=positionX[feedAnimalsHard.getPlacementX()[0]]
        food2Hide.x=positionX[feedAnimalsHard.getPlacementX()[1]]
        food3Hide.x=positionX[feedAnimalsHard.getPlacementX()[2]]

        food1Hide.y=positionY[feedAnimalsHard.getPlacementY()[0]]
        food2Hide.y=positionY[feedAnimalsHard.getPlacementY()[1]]
        food3Hide.y=positionY[feedAnimalsHard.getPlacementY()[2]]
        feedAnimalsHard.placementAleatoireDansTableau()
        feedAnimalsHard.placementAleatoireDecorDansTableau()

        var random=Random()
        herbeFood.x=positionX[feedAnimalsHard.getDecorPlacementX()[0]]
        arbreFood.x=positionX[feedAnimalsHard.getDecorPlacementX()[1]]
        rocherFood.x=positionX[feedAnimalsHard.getDecorPlacementX()[2]]

        herbeFood.y=positionY[feedAnimalsHard.getDecorPlacementY()[0]]
        arbreFood.y=positionY[feedAnimalsHard.getDecorPlacementY()[1]]
        rocherFood.y=positionY[feedAnimalsHard.getDecorPlacementY()[2]]





    }

    private fun handleTouch(m: MotionEvent){
        //if(difficulty=="hard"){
        val listAnswer = arrayOf(
            R.drawable.animaux_nourriture_cochon,
            R.drawable.animaux_nourriture_vache,
            R.drawable.animaux_nourriture_girafe,
            R.drawable.animaux_nourriture_bouc,
            R.drawable.animaux_nourriture_chat,
            R.drawable.animaux_nourriture_crabe,
            R.drawable.animaux_nourriture_morse,
            R.drawable.animaux_nourriture_panda,
            R.drawable.animaux_nourriture_paon,
            R.drawable.animaux_nourriture_pingouin,
            R.drawable.animaux_nourriture_poule,
            R.drawable.animaux_nourriture_tigre,
            R.drawable.animaux_nourriture_zebre,
            R.drawable.animaux_nourriture_lion
        )

            if(m.action == MotionEvent.ACTION_MOVE) {

                if (m.x >= herbeFood.x && m.x < herbeFood.x + herbeFood.width && m.y >= herbeFood.y && m.y < herbeFood.y + herbeFood.height) {

                    herbeFood.x = m.x - herbeFood.width / 2
                    herbeFood.y = m.y - herbeFood.height / 2


                } else {
                    if (m.x >= arbreFood.x && m.x < arbreFood.x + herbeFood.width && m.y >= arbreFood.y && m.y < arbreFood.y + arbreFood.height) {

                        arbreFood.x = m.x - arbreFood.width / 2
                        arbreFood.y = m.y - arbreFood.height / 2


                    } else {
                        if (m.x >= rocherFood.x && m.x < rocherFood.x + rocherFood.width && m.y >= rocherFood.y && m.y < rocherFood.y + rocherFood.height) {

                            rocherFood.x = m.x - rocherFood.width / 2
                            rocherFood.y = m.y - rocherFood.height / 2


                        }else{
                            if (m.x >= food1Hide.x && m.x < food1Hide.x + food1Hide.width && m.y >= food1Hide.y && m.y < food1Hide.y + food1Hide.height) {
                                if (food1Hide.x >= herbeFood.x && food1Hide.x + food1Hide.width < herbeFood.x + herbeFood.width && food1Hide.y >= herbeFood.y && food1Hide.y + food1Hide.height < herbeFood.y + herbeFood.height) {
                                    //ne fait rien
                                } else {
                                    if (food1Hide.x >= arbreFood.x && food1Hide.x + food1Hide.width < arbreFood.x + arbreFood.width && food1Hide.y >= arbreFood.y && food1Hide.y + food1Hide.height < arbreFood.y + arbreFood.height) {
                                        //ne fait rien
                                    } else {
                                        if (food1Hide.x >= rocherFood.x && food1Hide.x + food1Hide.width < rocherFood.x + rocherFood.width && food1Hide.y >= rocherFood.y && food1Hide.y + food1Hide.height < rocherFood.y + rocherFood.height) {
                                            // ne fait rien
                                        } else {
                                            if (food1Hide.x >= animalFood1.x - animalFood1.width / 3 && food1Hide.x + food1Hide.width < animalFood1.x + animalFood1.width + animalFood1.width / 3
                                                && food1Hide.y >= animalFood1.y - animalFood1.height / 3 && food1Hide.y + food1Hide.height < animalFood1.y + animalFood1.height + animalFood1.height / 3
                                            ) {
                                                feedAnimalsHard.trouveElem(0)
                                                animalFood1.setImageResource(listAnswer[tableauEntierAleatoireDifferent.get(2)])
                                                food1Hide.y = -500f
                                                if (feedAnimalsHard.isWin()) {
                                                    val nextAnimal =
                                                        Intent(this@FeedAnimalsHardControler, VictoryActivity::class.java)
                                                    nextAnimal.putExtra("difficulty", intent.getStringExtra("difficulty"))
                                                    var beforeCarrots = intent.getIntExtra("carotsWon",0)
                                                    var nbCarrotForThisGame = 1 + random.nextInt(10 - 1)
                                                    var numberCarrotsWonText=((nbCarrotForThisGame) + beforeCarrots).toString()
                                                    nextAnimal.putExtra("numberCarrotsWonText", numberCarrotsWonText)
                                                    nextAnimal.putExtra("nbCarrotForThisGame", nbCarrotForThisGame)
                                                    startActivity(nextAnimal)
                                                }
                                            } else {
                                                food1Hide.x = m.x - food1Hide.width / 2
                                                food1Hide.y = m.y - food1Hide.height / 2
                                            }
                                        }
                                    }

                                }

                            }else{
                                if (m.x >= food2Hide.x && m.x < food2Hide.x + food2Hide.width && m.y >= food2Hide.y && m.y < food2Hide.y + food2Hide.height) {
                                    if (food2Hide.x >= herbeFood.x && food2Hide.x + food2Hide.width < herbeFood.x + herbeFood.width && food2Hide.y >= herbeFood.y && food2Hide.y + food2Hide.height < herbeFood.y + herbeFood.height) {
                                        //ne fait rien
                                    } else {
                                        if (food2Hide.x >= arbreFood.x && food2Hide.x + food2Hide.width < arbreFood.x + arbreFood.width && food2Hide.y >= arbreFood.y && food2Hide.y + food2Hide.height < arbreFood.y + arbreFood.height) {
                                            //ne fait rien
                                        } else {
                                            if (food2Hide.x >= rocherFood.x && food2Hide.x + food2Hide.width < rocherFood.x + rocherFood.width && food2Hide.y >= rocherFood.y && food2Hide.y + food2Hide.height < rocherFood.y + rocherFood.height) {
                                                // ne fait rien
                                            } else {
                                                if (food2Hide.x >= animalFood2.x - animalFood2.width / 3 && food2Hide.x + food2Hide.width < animalFood2.x + animalFood2.width + animalFood2.width / 3
                                                    && food2Hide.y >= animalFood2.y - animalFood2.height / 3 && food2Hide.y + food2Hide.height < animalFood2.y + animalFood2.height + animalFood2.height / 3
                                                ) {
                                                    feedAnimalsHard.trouveElem(1)
                                                    animalFood2.setImageResource(listAnswer[tableauEntierAleatoireDifferent.get(1)])
                                                    food2Hide.y = -500f
                                                    if (feedAnimalsHard.isWin()) {
                                                        val nextAnimal =
                                                            Intent(this@FeedAnimalsHardControler, VictoryActivity::class.java)
                                                        nextAnimal.putExtra("difficulty", intent.getStringExtra("difficulty"))
                                                        var beforeCarrots = intent.getIntExtra("carotsWon",0)
                                                        var nbCarrotForThisGame = 1 + random.nextInt(10 - 1)
                                                        var numberCarrotsWonText=((nbCarrotForThisGame) + beforeCarrots).toString()
                                                        nextAnimal.putExtra("numberCarrotsWonText", numberCarrotsWonText)
                                                        nextAnimal.putExtra("nbCarrotForThisGame", nbCarrotForThisGame)
                                                        startActivity(nextAnimal)
                                                    }
                                                } else {
                                                    food2Hide.x = m.x - food2Hide.width / 2
                                                    food2Hide.y = m.y - food2Hide.height / 2
                                                }
                                            }
                                        }

                                    }

                                }else{
                                    if (m.x >= food3Hide.x && m.x < food3Hide.x + food3Hide.width && m.y >= food3Hide.y && m.y < food3Hide.y + food3Hide.height) {
                                        if (food3Hide.x >= herbeFood.x && food3Hide.x + food3Hide.width < herbeFood.x + herbeFood.width && food3Hide.y >= herbeFood.y && food3Hide.y + food3Hide.height < herbeFood.y + herbeFood.height) {
                                            //ne fait rien
                                        } else {
                                            if (food3Hide.x >= arbreFood.x && food3Hide.x + food3Hide.width < arbreFood.x + arbreFood.width && food3Hide.y >= arbreFood.y && food3Hide.y + food3Hide.height < arbreFood.y + arbreFood.height) {
                                                //ne fait rien
                                            } else {
                                                if (food3Hide.x >= rocherFood.x && food3Hide.x + food3Hide.width < rocherFood.x + rocherFood.width && food3Hide.y >= rocherFood.y && food3Hide.y + food3Hide.height < rocherFood.y + rocherFood.height) {
                                                    // ne fait rien
                                                } else {
                                                    if (food3Hide.x >= animalFood3.x - animalFood3.width / 3 && food3Hide.x + food3Hide.width < animalFood3.x + animalFood3.width + animalFood3.width / 3
                                                        && food3Hide.y >= animalFood3.y - animalFood3.height / 3 && food3Hide.y + food3Hide.height < animalFood3.y + animalFood3.height + animalFood3.height / 3)
                                                    {
                                                        feedAnimalsHard.trouveElem(2)
                                                        animalFood3.setImageResource(listAnswer[tableauEntierAleatoireDifferent.get(0)])
                                                        food3Hide.y = -500f
                                                        if (feedAnimalsHard.isWin()) {
                                                            val nextAnimal =
                                                                Intent(this@FeedAnimalsHardControler, VictoryActivity::class.java)
                                                            nextAnimal.putExtra("difficulty", intent.getStringExtra("difficulty"))
                                                            var beforeCarrots = intent.getIntExtra("carotsWon",0)
                                                            var nbCarrotForThisGame = 1 + random.nextInt(10 - 1)
                                                            var numberCarrotsWonText=((nbCarrotForThisGame) + beforeCarrots).toString()
                                                            nextAnimal.putExtra("numberCarrotsWonText", numberCarrotsWonText)
                                                            nextAnimal.putExtra("nbCarrotForThisGame", nbCarrotForThisGame)
                                                            startActivity(nextAnimal)
                                                        }
                                                    } else {
                                                        food3Hide.x = m.x - food3Hide.width / 2
                                                        food3Hide.y = m.y - food3Hide.height / 2
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
    }



}
