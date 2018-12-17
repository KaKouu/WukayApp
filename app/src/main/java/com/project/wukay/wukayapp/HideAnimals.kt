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
import kotlinx.android.synthetic.main.activity_hard_what_is_this.*
import kotlinx.android.synthetic.main.activity_hide_animals.*
import kotlinx.android.synthetic.main.activity_what_is_this.*
import java.util.*
import kotlin.concurrent.schedule

class HideAnimals : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        // mise en place du layout
        super.onCreate(savedInstanceState)


        //déclaration des variables
        val difficulty = intent.getStringExtra("difficulty") //renvaiera la difficulté choisit precedement
        val nextAnimal = Intent(this@HideAnimals, VictoryActivity::class.java)
        nextAnimal.putExtra("difficulty", difficulty)
        var numberWin=0

        val vibratorService = getSystemService(Context.VIBRATOR_SERVICE) as Vibrator

        if (difficulty == "easy"){

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

            animalToFind3.setImageResource(listOfAnimalsPictureQuestion[1])
            animalToFind2.setImageResource(listOfAnimalsPictureQuestion[1])
            animalToFind1.setImageResource(listOfAnimalsPictureQuestion[1])

            answer3Hide.setImageResource(listOfAnimalsPicture[1])
            answer2Hide.setImageResource(listOfAnimalsPicture[1])
            answer1Hide.setImageResource(listOfAnimalsPicture[1])

        }else
        {
            setContentView(R.layout.activity_hide_animals)
        }

        //selon le niveau de difficulté
        if(difficulty=="easy") {
            var decouvert=false;
    /*
            answer1Hide.setOnClickListener {

                    System.out.println("answer1 est cliqué")


            }
            answer2Hide.setOnClickListener {
                System.out.println("answer2 est cliqué")
            }
            answer3Hide.setOnClickListener {
                System.out.println("answer3 est cliqué")
            }*/

        }else {

        }

    }
    private fun minijeu(
        arrayOfQuestion: Array<String>,
        reponse: Int,
        nombreDeReponsesPossibles: Int,
        memoAnimauxChoisi: IntArray,
        rand: Random,
        arrayOfAnimalsPicture: Array<Int>,
        ouMettreLaReponse: Int
    ) {
        question.setText(arrayOfQuestion[reponse])
        description.setText("")
        var i = 0;

        while (i < nombreDeReponsesPossibles) {
            System.out.print(i)
            memoAnimauxChoisi.set(i, -1)
            i++
        }

        var j = 0
        while (j < memoAnimauxChoisi.size) {

            var temp = rand.nextInt(arrayOfAnimalsPicture.size)

            while (memoAnimauxChoisi.contains(temp) || temp == reponse) {
                temp = rand.nextInt(arrayOfAnimalsPicture.size)
            }

            memoAnimauxChoisi.set(j, temp)
            j++
        }
        memoAnimauxChoisi.set(ouMettreLaReponse, reponse)

        answer1.setImageResource(arrayOfAnimalsPicture[memoAnimauxChoisi.get(0)])
        answer2.setImageResource(arrayOfAnimalsPicture[memoAnimauxChoisi.get(1)])
        answer3.setImageResource(arrayOfAnimalsPicture[memoAnimauxChoisi.get(2)])
    }
    private fun handleTouch(m: MotionEvent){
        if(m.action == MotionEvent.ACTION_MOVE) {

             if (m.x >= herbe.x && m.x < herbe.x + herbe.width && m.y >= herbe.y && m.y < herbe.y + herbe.height) {

                 herbe.x = m.x - herbe.width / 2
                 herbe.y = m.y - herbe.height / 2
            }

        }
        if(m.action == MotionEvent.ACTION_DOWN){
            if (m.x >= answer1Hide.x && m.x < answer1Hide.x + herbe.width && m.y >= answer1Hide.y && m.y < answer1Hide.y + answer1Hide.height) {
                if(answer1Hide.x >= herbe.x && answer1Hide.x + answer1Hide.width < herbe.x + herbe.width && answer1Hide.y >= herbe.y && answer1Hide.y + answer1Hide.height< herbe.y + herbe.height){
                }else{
                    infos.setText("trouvé1")
                }

            }
            if (m.x >= answer3Hide.x && m.x < answer3Hide.x + herbe.width && m.y >= answer3Hide.y && m.y < answer3Hide.y + answer3Hide.height) {
                if(answer3Hide.x >= herbe.x && answer3Hide.x + answer3Hide.width < herbe.x + herbe.width && answer3Hide.y >= herbe.y && answer3Hide.y + answer3Hide.height< herbe.y + herbe.height){
                }else{
                    infos.setText("trouvé3")
                }

            }
            if (m.x >= answer2Hide.x && m.x < answer2Hide.x + herbe.width && m.y >= answer2Hide.y && m.y < answer2Hide.y + answer2Hide.height) {
                if(answer2Hide.x >= herbe.x && answer2Hide.x + answer2Hide.width < herbe.x + herbe.width && answer2Hide.y >= herbe.y && answer2Hide.y + answer2Hide.height< herbe.y + herbe.height){
                }else{
                    infos.setText("trouvé2")
                }

            }


        }
    }



}
