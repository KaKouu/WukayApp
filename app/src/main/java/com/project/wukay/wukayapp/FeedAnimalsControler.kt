package com.project.wukay.wukayapp

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.MotionEvent
import android.view.View
import com.project.wukay.wukayapp.R
import com.project.wukay.wukayapp.metier.FeedAnimalsModel
import kotlinx.android.synthetic.main.activity_feed_animals.*
import kotlinx.android.synthetic.main.activity_hide_animals.*
import java.util.*

class FeedAnimalsControler : AppCompatActivity() {
    private var feedAnimalsModel = FeedAnimalsModel()
    private var random= Random()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_feed_animals)
        feedAnimalsModel.beginGame()

        feedAnimalLayout.setOnTouchListener { v: View, m: MotionEvent ->
            handleTouch(m)
            true
        }

        val listOfAnimals = arrayOf(
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

        val listOfFood = arrayOf(
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
        feedAnimalsModel.generateAnimalsAndFood()
        animalFeed1.setImageResource(listOfAnimals[feedAnimalsModel.getBoardOfAnimals()[0]])
        animalFeed2.setImageResource(listOfAnimals[feedAnimalsModel.getBoardOfAnimals()[1]])
        animalFeed3.setImageResource(listOfAnimals[feedAnimalsModel.getBoardOfAnimals()[2]])

        food1.setImageResource(listOfFood[feedAnimalsModel.getBoardOfAnimals()[0]])
        food2.setImageResource(listOfFood[feedAnimalsModel.getBoardOfAnimals()[1]])
        food3.setImageResource(listOfFood[feedAnimalsModel.getBoardOfAnimals()[2]])
    }
    private fun handleTouch(m: MotionEvent){
        if(m.action == MotionEvent.ACTION_MOVE) {
            if (m.x >= food1.x && m.x < food1.x + food1.width && m.y >= food1.y && m.y < food1.y + food1.height) {
               if( food1.x >= bucket1.x-bucket1.width/3 && food1.x + food1.width < bucket1.x + bucket1.width+ bucket1.width/3
                   && food1.y >= bucket1.y-bucket1.height/3 && food1.y + food1.height< bucket1.y + bucket1.height+bucket1.height/3){

                   food1.setImageDrawable(null);
                   feedAnimalsModel.getBoardOfFood().set(0,1)
                   if(feedAnimalsModel.isWin()){
                       val nextAnimal = Intent(this@FeedAnimalsControler, VictoryActivity::class.java)
                       nextAnimal.putExtra("difficulty", intent.getStringExtra("difficulty"))
                       var numberCarrotsWonText = random.nextInt(10).toString()
                       nextAnimal.putExtra("numberCarrotsWonText", numberCarrotsWonText)
                       startActivity(nextAnimal)
                   }
               }
                food1.x = m.x - food1.width / 2
                food1.y = m.y - food1.height / 2


            }else{
                if (m.x >= food2.x && m.x < food2.x + food2.width && m.y >= food2.y && m.y < food2.y + food2.height) {
                    if( food2.x >= bucket2.x-bucket2.width/3 && food2.x + food2.width < bucket2.x + bucket2.width+ bucket2.width/3
                        && food2.y >= bucket2.y-bucket2.height/3 && food2.y + food1.height< bucket2.y + bucket2.height+bucket2.height/3){

                        food2.setImageDrawable(null);
                        feedAnimalsModel.getBoardOfFood().set(1,1)
                        if(feedAnimalsModel.isWin()){
                            val nextAnimal = Intent(this@FeedAnimalsControler, VictoryActivity::class.java)
                            nextAnimal.putExtra("difficulty", intent.getStringExtra("difficulty"))
                            var numberCarrotsWonText = random.nextInt(10).toString()
                            nextAnimal.putExtra("numberCarrotsWonText", numberCarrotsWonText)
                            startActivity(nextAnimal)
                        }
                    }
                    food2.x = m.x - food2.width / 2
                    food2.y = m.y - food2.height / 2


                }else{
                    if (m.x >= food3.x && m.x < food3.x + food3.width && m.y >= food3.y && m.y < food3.y + food3.height) {
                        if( food3.x >= bucket3.x-bucket3.width/3 && food3.x + food3.width < bucket3.x + bucket3.width+ bucket3.width/3
                            && food3.y >= bucket3.y-bucket3.height/3 && food3.y + food3.height< bucket3.y + bucket3.height+bucket3.height/3){

                            food3.setImageDrawable(null);
                            feedAnimalsModel.getBoardOfFood().set(2,1)
                            if(feedAnimalsModel.isWin()){
                                val nextAnimal = Intent(this@FeedAnimalsControler, VictoryActivity::class.java)
                                nextAnimal.putExtra("difficulty", intent.getStringExtra("difficulty"))
                                var numberCarrotsWonText = random.nextInt(10).toString()
                                nextAnimal.putExtra("numberCarrotsWonText", numberCarrotsWonText)
                                startActivity(nextAnimal)
                            }

                        }
                        food3.x = m.x - food3.width /2
                        food3.y = m.y - food3.height / 2


                    }
                }
            }



        }
    }
}