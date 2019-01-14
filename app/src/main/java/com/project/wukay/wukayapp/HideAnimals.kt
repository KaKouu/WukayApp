package com.project.wukay.wukayapp

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Vibrator
import android.view.MotionEvent
import android.view.View
import android.view.animation.TranslateAnimation
import android.widget.ImageView
import com.project.wukay.wukayapp.R.layout.activity_hide_animals
import com.project.wukay.wukayapp.metier.HideAnimalsMetier
import com.project.wukay.wukayapp.util.Aleatoire
import kotlinx.android.synthetic.main.activity_hard_what_is_this.*
import kotlinx.android.synthetic.main.activity_hide_animals.*
import kotlinx.android.synthetic.main.activity_what_is_this.*
import java.util.*
import kotlin.concurrent.schedule

class HideAnimals : AppCompatActivity() {
    var hideAnimalsMetier = HideAnimalsMetier()
    var aleatoire = Aleatoire()
    var positionX=FloatArray(3)
    var positionY=FloatArray(3)


    override fun onCreate(savedInstanceState: Bundle?) {
        hideAnimalsMetier.initialisationJeu()
        // mise en place du layout
        super.onCreate(savedInstanceState)


        //déclaration des variables
        val difficulty = intent.getStringExtra("difficulty") //renvaiera la difficulté choisit precedement



        val vibratorService = getSystemService(Context.VIBRATOR_SERVICE) as Vibrator

        if (difficulty == "easy"){

            positionX.set(0,0.0f)
            positionX.set(1,400f)
            positionX.set(2,700f)

            positionY.set(0,0f)
            positionY.set(1,400f)
            positionY.set(2,800f)

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
            setContentView(R.layout.activity_hide_animals)
            myLayout.setOnTouchListener { v: View, m: MotionEvent ->
                handleTouch(m)
                true
            }


            val nombreAnimauxAchercher =3;
            var tableauEntierAleatoireDifferent:IntArray
            System.out.println("PASSEPAS")
            tableauEntierAleatoireDifferent = aleatoire.chiffreAleatoireDifferentEntreDeuxBornes(listOfAnimalsPictureQuestion.size,nombreAnimauxAchercher)
            System.out.println("PASSE")
            animalToFind3.setImageResource(listOfAnimalsPictureQuestion[tableauEntierAleatoireDifferent.get(0)])
            animalToFind2.setImageResource(listOfAnimalsPictureQuestion[tableauEntierAleatoireDifferent.get(1)])
            animalToFind1.setImageResource(listOfAnimalsPictureQuestion[tableauEntierAleatoireDifferent.get(2)])

            answer3Hide.setImageResource(listOfAnimalsPicture[tableauEntierAleatoireDifferent.get(0)])
            answer2Hide.setImageResource(listOfAnimalsPicture[tableauEntierAleatoireDifferent.get(1)])
            answer1Hide.setImageResource(listOfAnimalsPicture[tableauEntierAleatoireDifferent.get(2)])
            hideAnimalsMetier.placementAleatoireDansTableau()


            System.out.println("PLACEMENT"+positionX[hideAnimalsMetier.getPlacementX()[0]])


            answer1Hide.x=positionX[hideAnimalsMetier.getPlacementX()[0]]
            answer2Hide.x=positionX[hideAnimalsMetier.getPlacementX()[1]]
            answer3Hide.x=positionX[hideAnimalsMetier.getPlacementX()[2]]

            answer1Hide.y=positionY[hideAnimalsMetier.getPlacementY()[0]]
            answer2Hide.y=positionY[hideAnimalsMetier.getPlacementY()[1]]
            answer3Hide.y=positionY[hideAnimalsMetier.getPlacementY()[2]]
            hideAnimalsMetier.placementAleatoireDansTableau()
            hideAnimalsMetier.placementAleatoireDecorDansTableau()

            var random=Random()
            herbe.x=positionX[hideAnimalsMetier.getDecorPlacementX()[0]]
            arbre.x=positionX[hideAnimalsMetier.getDecorPlacementX()[1]]
            rocher.x=positionX[hideAnimalsMetier.getDecorPlacementX()[2]]

            herbe.y=positionY[hideAnimalsMetier.getDecorPlacementY()[0]]
            arbre.y=positionY[hideAnimalsMetier.getDecorPlacementY()[1]]
            rocher.y=positionY[hideAnimalsMetier.getDecorPlacementY()[2]]



        }else
        {
            setContentView(R.layout.activity_hide_animals)
        }



    }
    private fun handleTouch(m: MotionEvent){
        if(m.action == MotionEvent.ACTION_MOVE) {

             if (m.x >= herbe.x && m.x < herbe.x + herbe.width && m.y >= herbe.y && m.y < herbe.y + herbe.height) {

                 herbe.x = m.x - herbe.width / 2
                 herbe.y = m.y - herbe.height / 2


            }
            if (m.x >= arbre.x && m.x < arbre.x + herbe.width && m.y >= arbre.y && m.y < arbre.y + arbre.height) {

                arbre.x = m.x - arbre.width / 2
                arbre.y = m.y - arbre.height / 2


            }
            if (m.x >= rocher.x && m.x < rocher.x + rocher.width && m.y >= rocher.y && m.y < rocher.y + rocher.height) {

                rocher.x = m.x - rocher.width / 2
                rocher.y = m.y - rocher.height / 2


            }

        }
        if(m.action == MotionEvent.ACTION_DOWN){
            if (m.x >= answer1Hide.x && m.x < answer1Hide.x + herbe.width && m.y >= answer1Hide.y && m.y < answer1Hide.y + answer1Hide.height) {
                if(answer1Hide.x >= herbe.x && answer1Hide.x + answer1Hide.width < herbe.x + herbe.width && answer1Hide.y >= herbe.y && answer1Hide.y + answer1Hide.height< herbe.y + herbe.height){
                    //ne fait rien
                }else{
                    if(answer1Hide.x >= arbre.x && answer1Hide.x + answer1Hide.width < arbre.x + arbre.width && answer1Hide.y >= arbre.y && answer1Hide.y + answer1Hide.height< arbre.y + arbre.height){
                        //ne fait rien
                    }else{
                        if(answer1Hide.x >= rocher.x && answer1Hide.x + answer1Hide.width < rocher.x + rocher.width && answer1Hide.y >= rocher.y && answer1Hide.y + answer1Hide.height< rocher.y + rocher.height){
                            // ne fait rien
                        }else{
                            hideAnimalsMetier.trouveElem(0)
                            animalToFind1.visibility=View.INVISIBLE
                            answer1Hide.visibility=View.INVISIBLE
                            if(hideAnimalsMetier.isWin()){
                                val nextAnimal = Intent(this@HideAnimals, VictoryActivity::class.java)
                                nextAnimal.putExtra("difficulty", intent.getStringExtra("difficulty"))
                                var numberCarrotsWonText = 1.toString()
                                nextAnimal.putExtra("numberCarrotsWonText", numberCarrotsWonText)
                                startActivity(nextAnimal)
                            }
                        }
                    }

                }

            }
            if (m.x >= answer3Hide.x && m.x < answer3Hide.x + herbe.width && m.y >= answer3Hide.y && m.y < answer3Hide.y + answer3Hide.height) {
                if(answer3Hide.x >= herbe.x && answer3Hide.x + answer3Hide.width < herbe.x + herbe.width && answer3Hide.y >= herbe.y && answer3Hide.y + answer3Hide.height< herbe.y + herbe.height){
                    //ne fait rien
                }else{
                    if(answer3Hide.x >= arbre.x && answer3Hide.x + answer3Hide.width < arbre.x + arbre.width && answer3Hide.y >= arbre.y && answer3Hide.y + answer3Hide.height< arbre.y + arbre.height){
                        //ne fait rien
                    }else{
                        if(answer3Hide.x >= rocher.x && answer3Hide.x + answer3Hide.width < rocher.x + rocher.width && answer3Hide.y >= rocher.y && answer3Hide.y + answer3Hide.height< rocher.y + rocher.height){
                            // ne fait rien
                        }else{
                            hideAnimalsMetier.trouveElem(2)
                            animalToFind3.visibility=View.INVISIBLE
                            answer3Hide.visibility=View.INVISIBLE
                            if(hideAnimalsMetier.isWin()){
                                val nextAnimal = Intent(this@HideAnimals, VictoryActivity::class.java)
                                nextAnimal.putExtra("difficulty", intent.getStringExtra("difficulty"))
                                var numberCarrotsWonText = 1.toString()
                                nextAnimal.putExtra("numberCarrotsWonText", numberCarrotsWonText)
                                startActivity(nextAnimal)
                            }
                        }
                    }

                }

            }
            if (m.x >= answer2Hide.x && m.x < answer2Hide.x + herbe.width && m.y >= answer2Hide.y && m.y < answer2Hide.y + answer2Hide.height) {
                if(answer2Hide.x >= herbe.x && answer2Hide.x + answer2Hide.width < herbe.x + herbe.width && answer2Hide.y >= herbe.y && answer2Hide.y + answer2Hide.height< herbe.y + herbe.height){
                    //ne fait rien
                }else{
                    if(answer2Hide.x >= arbre.x && answer2Hide.x + answer2Hide.width < arbre.x + arbre.width && answer2Hide.y >= arbre.y && answer2Hide.y + answer2Hide.height< arbre.y + arbre.height){
                        //ne fait rien
                    }else{
                        if(answer2Hide.x >= rocher.x && answer2Hide.x + answer2Hide.width < rocher.x + rocher.width && answer2Hide.y >= rocher.y && answer2Hide.y + answer2Hide.height< rocher.y + rocher.height){
                            // ne fait rien
                        }else{
                            hideAnimalsMetier.trouveElem(1)
                            animalToFind2.visibility=View.INVISIBLE
                            answer2Hide.visibility=View.INVISIBLE
                            if(hideAnimalsMetier.isWin()){
                                val nextAnimal = Intent(this@HideAnimals, VictoryActivity::class.java)
                                nextAnimal.putExtra("difficulty", intent.getStringExtra("difficulty"))
                                var numberCarrotsWonText = 1.toString()
                                nextAnimal.putExtra("numberCarrotsWonText", numberCarrotsWonText)
                                startActivity(nextAnimal)
                            }
                        }
                    }

                }

            }


        }
    }



}
