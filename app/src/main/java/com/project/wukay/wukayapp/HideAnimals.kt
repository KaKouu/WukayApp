package com.project.wukay.wukayapp

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.os.Vibrator
import android.view.KeyEvent
import android.view.MotionEvent
import android.view.View
import android.widget.TextView
import com.project.wukay.wukayapp.metier.HideAnimalsMetier
import com.project.wukay.wukayapp.util.Aleatoire
import com.project.wukay.wukayapp.util.PrefsTimer
import kotlinx.android.synthetic.main.activity_hide_animals_easy.*
import kotlinx.android.synthetic.main.activity_hide_animals_hard.*
import java.util.*

class HideAnimals : AppCompatActivity() {
    var hideAnimalsHardMetier = HideAnimalsMetier()
    var aleatoire = Aleatoire()
    var random = Random()
    var positionX = FloatArray(3)
    var positionY = FloatArray(3)
    var difficulty = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        hideAnimalsHardMetier.initialisationJeu()
        // mise en place du layout
        super.onCreate(savedInstanceState)


        //déclaration des variables
        difficulty = intent.getStringExtra("difficulty") //renvaiera la difficulté choisit precedement


        val vibratorService = getSystemService(Context.VIBRATOR_SERVICE) as Vibrator



        positionX[0] = 0.0f
        positionX[1] = 400f
        positionX[2] = 700f

        positionY[0] = 0f
        positionY[1] = 400f
        positionY[2] = 800f

        val listOfAnimalsPictureQuestion = arrayOf(
            R.drawable.animaux_cochon_silhouette,
            R.drawable.animaux_vache_silhouette,
            R.drawable.animaux_girafe_silhouette,
            R.drawable.animaux_bouc_silhouette,
            R.drawable.animaux_chat_silhouette,
            R.drawable.animaux_crabe_silhouette,
            R.drawable.animaux_morse_silhouette,
            R.drawable.animaux_panda_silhouette,
            R.drawable.animaux_paon_silhouette,
            R.drawable.animaux_pingouin_silhouette,
            R.drawable.animaux_poule_silhouette,
            R.drawable.animaux_tigre_silhouette,
            R.drawable.animaux_zebre_silhouette,
            R.drawable.animaux_lion_silhouette
        )

        val listOfAnimalsPicture = arrayOf(
            R.drawable.animaux_cochon,
            R.drawable.animaux_vache,
            R.drawable.animaux_girafe,
            R.drawable.animaux_bouc,
            R.drawable.animaux_chat,
            R.drawable.animaux_crabe,
            R.drawable.animaux_morse,
            R.drawable.animaux_panda,
            R.drawable.animaux_paon,
            R.drawable.animaux_pingouin,
            R.drawable.animaux_poule,
            R.drawable.animaux_tigre,
            R.drawable.animaux_zebre,
            R.drawable.animaux_lion
        )
        setContentView(R.layout.activity_hide_animals_hard)
        myLayoutHard.setOnTouchListener { _: View, m: MotionEvent ->
            handleTouch(m)
            true
        }


        val nombreAnimauxAchercher = 4;
        var tableauEntierAleatoireDifferent: IntArray
        System.out.println("PASSEPAS")
        tableauEntierAleatoireDifferent = aleatoire.chiffreAleatoireDifferentEntreDeuxBornes(
            listOfAnimalsPictureQuestion.size,
            nombreAnimauxAchercher
        )
        System.out.println("PASSE")
        animalToFind3Hard.setImageResource(listOfAnimalsPictureQuestion[tableauEntierAleatoireDifferent[0]])
        animalToFind2Hard.setImageResource(listOfAnimalsPictureQuestion[tableauEntierAleatoireDifferent[1]])
        animalToFind1Hard.setImageResource(listOfAnimalsPictureQuestion[tableauEntierAleatoireDifferent[2]])


        answer3HideHard.setImageResource(listOfAnimalsPicture[tableauEntierAleatoireDifferent[0]])
        answer2HideHard.setImageResource(listOfAnimalsPicture[tableauEntierAleatoireDifferent[1]])
        answer1HideHard.setImageResource(listOfAnimalsPicture[tableauEntierAleatoireDifferent[2]])
        piege.setImageResource(listOfAnimalsPicture[tableauEntierAleatoireDifferent[3]])
        hideAnimalsHardMetier.placementAleatoireDansTableau()


        System.out.println("PLACEMENT" + positionX[hideAnimalsHardMetier.getPlacementX()[0]])


        answer1HideHard.x = positionX[hideAnimalsHardMetier.getPlacementX()[0]]
        answer2HideHard.x = positionX[hideAnimalsHardMetier.getPlacementX()[1]]
        answer3HideHard.x = positionX[hideAnimalsHardMetier.getPlacementX()[2]]
        piege.x = positionX[hideAnimalsHardMetier.getPlacementX()[3]]

        answer1HideHard.y = positionY[hideAnimalsHardMetier.getPlacementY()[0]]
        answer2HideHard.y = positionY[hideAnimalsHardMetier.getPlacementY()[1]]
        answer3HideHard.y = positionY[hideAnimalsHardMetier.getPlacementY()[2]]
        piege.y = positionY[hideAnimalsHardMetier.getPlacementY()[3]]

        hideAnimalsHardMetier.placementAleatoireDansTableau()
        hideAnimalsHardMetier.placementAleatoireDecorDansTableau()

        var random = Random()
        herbeHard.x = positionX[hideAnimalsHardMetier.getDecorPlacementX()[0]]
        arbreHard.x = positionX[hideAnimalsHardMetier.getDecorPlacementX()[1]]
        rocherHard.x = positionX[hideAnimalsHardMetier.getDecorPlacementX()[2]]

        herbeHard.y = positionY[hideAnimalsHardMetier.getDecorPlacementY()[0]]
        arbreHard.y = positionY[hideAnimalsHardMetier.getDecorPlacementY()[1]]
        rocherHard.y = positionY[hideAnimalsHardMetier.getDecorPlacementY()[2]]

        val timer = MyCounter(10000, 1000)
        timer.start()

    }

    inner class MyCounter(millisInFuture: Long, countDownInterval: Long) : CountDownTimer(millisInFuture, countDownInterval) {


        override fun onFinish() {
            val next = Intent(this@HideAnimals, LevelsActivity::class.java)
            next.putExtra("difficulty", difficulty)

            next.putExtra("isLastActivityIsAGame", false)

            startActivity(next)


        }

        override fun onTick(millisUntilFinished: Long) {
            progressBar.progress = ((millisUntilFinished / 100).toInt())


        }
    }





    private fun handleTouch(m: MotionEvent) {
            if (m.action == MotionEvent.ACTION_MOVE) {

                if (m.x >= herbeHard.x && m.x < herbeHard.x + herbeHard.width && m.y >= herbeHard.y && m.y < herbeHard.y + herbeHard.height) {

                    herbeHard.x = m.x - herbeHard.width / 2
                    herbeHard.y = m.y - herbeHard.height / 2


                } else {
                    if (m.x >= arbreHard.x && m.x < arbreHard.x + herbeHard.width && m.y >= arbreHard.y && m.y < arbreHard.y + arbreHard.height) {

                        arbreHard.x = m.x - arbreHard.width / 2
                        arbreHard.y = m.y - arbreHard.height / 2


                    } else {
                        if (m.x >= rocherHard.x && m.x < rocherHard.x + rocherHard.width && m.y >= rocherHard.y && m.y < rocherHard.y + rocherHard.height) {

                            rocherHard.x = m.x - rocherHard.width / 2
                            rocherHard.y = m.y - rocherHard.height / 2


                        }
                    }
                }
            }

            if (m.action == MotionEvent.ACTION_DOWN) {
                if (m.x >= answer1HideHard.x && m.x < answer1HideHard.x + answer1HideHard.width && m.y >= answer1HideHard.y && m.y < answer1HideHard.y + answer1HideHard.height) {
                    if (answer1HideHard.x >= herbeHard.x && answer1HideHard.x + answer1HideHard.width < herbeHard.x + herbeHard.width && answer1HideHard.y >= herbeHard.y && answer1HideHard.y + answer1HideHard.height < herbeHard.y + herbeHard.height) {
                        //ne fait rien
                    } else {
                        if (answer1HideHard.x >= arbreHard.x && answer1HideHard.x + answer1HideHard.width < arbreHard.x + arbreHard.width && answer1HideHard.y >= arbreHard.y && answer1HideHard.y + answer1HideHard.height < arbreHard.y + arbreHard.height) {
                            //ne fait rien
                        } else {
                            if (answer1HideHard.x >= rocherHard.x && answer1HideHard.x + answer1HideHard.width < rocherHard.x + rocherHard.width && answer1HideHard.y >= rocherHard.y && answer1HideHard.y + answer1HideHard.height < rocherHard.y + rocherHard.height) {
                                // ne fait rien
                            } else {
                                hideAnimalsHardMetier.trouveElem(0)
                                animalToFind1Hard.visibility = View.INVISIBLE
                                answer1HideHard.visibility = View.INVISIBLE
                                if (hideAnimalsHardMetier.isWin()) {

                                    val nextAnimal = Intent(this@HideAnimals, VictoryActivity::class.java)
                                    nextAnimal.putExtra("difficulty", intent.getStringExtra("difficulty"))
                                    var numberCarrotsWonText = random.nextInt(10).toString()
                                    nextAnimal.putExtra("numberCarrotsWonText", numberCarrotsWonText)
                                    startActivity(nextAnimal)
                                }
                            }
                        }

                    }

                }
                if (m.x >= answer3HideHard.x && m.x < answer3HideHard.x + answer3HideHard.width && m.y >= answer3HideHard.y && m.y < answer3HideHard.y + answer3HideHard.height) {
                    if (answer3HideHard.x >= herbeHard.x && answer3HideHard.x + answer3HideHard.width < herbeHard.x + herbeHard.width && answer3HideHard.y >= herbeHard.y && answer3HideHard.y + answer3HideHard.height < herbeHard.y + herbeHard.height) {
                        //ne fait rien
                    } else {
                        if (answer3HideHard.x >= arbreHard.x && answer3HideHard.x + answer3HideHard.width < arbreHard.x + arbreHard.width && answer3HideHard.y >= arbreHard.y && answer3HideHard.y + answer3HideHard.height < arbreHard.y + arbreHard.height) {
                            //ne fait rien
                        } else {
                            if (answer3HideHard.x >= rocherHard.x && answer3HideHard.x + answer3HideHard.width < rocherHard.x + rocherHard.width && answer3HideHard.y >= rocherHard.y && answer3HideHard.y + answer3HideHard.height < rocherHard.y + rocherHard.height) {
                                // ne fait rien
                            } else {
                                hideAnimalsHardMetier.trouveElem(2)
                                animalToFind3Hard.visibility = View.INVISIBLE
                                answer3HideHard.visibility = View.INVISIBLE
                                if (hideAnimalsHardMetier.isWin()) {

                                    val nextAnimal = Intent(this@HideAnimals, VictoryActivity::class.java)
                                    nextAnimal.putExtra("difficulty", intent.getStringExtra("difficulty"))
                                    var numberCarrotsWonText = random.nextInt(10).toString()
                                    nextAnimal.putExtra("numberCarrotsWonText", numberCarrotsWonText)
                                    startActivity(nextAnimal)
                                }
                            }
                        }

                    }

                }
                if (m.x >= answer2HideHard.x && m.x < answer2HideHard.x + answer2HideHard.width && m.y >= answer2HideHard.y && m.y < answer2HideHard.y + answer2HideHard.height) {
                    if (answer2HideHard.x >= herbeHard.x && answer2HideHard.x + answer2HideHard.width < herbeHard.x + herbeHard.width && answer2HideHard.y >= herbeHard.y && answer2HideHard.y + answer2HideHard.height < herbeHard.y + herbeHard.height) {
                        //ne fait rien
                    } else {
                        if (answer2HideHard.x >= arbreHard.x && answer2HideHard.x + answer2HideHard.width < arbreHard.x + arbreHard.width && answer2HideHard.y >= arbreHard.y && answer2HideHard.y + answer2HideHard.height < arbreHard.y + arbreHard.height) {
                            //ne fait rien
                        } else {
                            if (answer2HideHard.x >= rocherHard.x && answer2HideHard.x + answer2HideHard.width < rocherHard.x + rocherHard.width && answer2HideHard.y >= rocherHard.y && answer2HideHard.y + answer2HideHard.height < rocherHard.y + rocherHard.height) {
                                // ne fait rien
                            } else {
                                hideAnimalsHardMetier.trouveElem(1)
                                animalToFind2Hard.visibility = View.INVISIBLE
                                answer2HideHard.visibility = View.INVISIBLE
                                if (hideAnimalsHardMetier.isWin()) {

                                    val nextAnimal = Intent(this@HideAnimals, VictoryActivity::class.java)
                                    nextAnimal.putExtra("difficulty", intent.getStringExtra("difficulty"))
                                    var numberCarrotsWonText = random.nextInt(10).toString()
                                    nextAnimal.putExtra("numberCarrotsWonText", numberCarrotsWonText)
                                    startActivity(nextAnimal)
                                }
                            }
                        }

                    }

                }
                if (m.x >= piege.x && m.x < piege.x + piege.width && m.y >= piege.y && m.y < piege.y + piege.height) {
                    if (piege.x >= herbeHard.x && piege.x + piege.width < herbeHard.x + herbeHard.width && piege.y >= herbeHard.y && piege.y + piege.height < herbeHard.y + herbeHard.height) {
                        //ne fait rien
                    } else {
                        if (piege.x >= arbreHard.x && piege.x + piege.width < arbreHard.x + arbreHard.width && piege.y >= arbreHard.y && piege.y + piege.height < arbreHard.y + arbreHard.height) {
                            //ne fait rien
                        } else {
                            if (piege.x >= rocherHard.x && piege.x + piege.width < rocherHard.x + rocherHard.width && piege.y >= rocherHard.y && piege.y + piege.height < rocherHard.y + rocherHard.height) {
                                // ne fait rien
                            } else {
                                hideAnimalsHardMetier.trouveElem(3)

                                infos.setText("Perdu ! ")


                                val next = Intent( this@HideAnimals, LevelsActivity::class.java)
                                next.putExtra("difficulty",difficulty)
                                next.putExtra("carotsWon",0)
                                next.putExtra("isLastActivityIsAGame",true)
                                startActivity(next)

                            }
                        }

                    }

                }

            }
    }
}