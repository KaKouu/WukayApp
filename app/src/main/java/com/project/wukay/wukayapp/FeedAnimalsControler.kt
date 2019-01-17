package com.project.wukay.wukayapp

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.MotionEvent
import android.view.View
import com.project.wukay.wukayapp.metier.FeedAnimalsModel
import kotlinx.android.synthetic.main.activity_feed_animals.*
import java.util.*

class FeedAnimalsControler : AppCompatActivity() {
    private var feedAnimalsModel = FeedAnimalsModel()
    private var random= Random()
    private var position = FloatArray(3)



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_feed_animals)
        feedAnimalsModel.beginGame()
        position.set(0,0f)
        position.set(1,350f)
        position.set(2,680f)
        feedAnimalLayout.setOnTouchListener { v: View, m: MotionEvent ->
            handleTouch(m)
            true
        }

        val listOfAnimals = arrayOf(
            R.drawable.animaux_cochon,
            R.drawable.animaux_vache,
            R.drawable.animaux_girafe,
            R.drawable.animaux_bouc,
            R.drawable.animaux_chat,
            R.drawable.animaux_pirahna,
            R.drawable.animaux_morse,
            R.drawable.animaux_panda,
            R.drawable.animaux_paon,
            R.drawable.animaux_pingouin,
            R.drawable.animaux_poule,
            R.drawable.animaux_tigre,
            R.drawable.animaux_zebre,
            R.drawable.animaux_lion
        )

        val listOfFood = arrayOf(
            R.drawable.food_mais,
            R.drawable.icon_herbe,
            R.drawable.icon_feuille,
            R.drawable.icon_herbe,
            R.drawable.food_souris,
            R.drawable.food_poisson,
            R.drawable.food_crevette,
            R.drawable.food_bambou,
            R.drawable.food_graine,
            R.drawable.food_poisson,
            R.drawable.food_graine,
            R.drawable.food_viande,
            R.drawable.icon_feuille,
            R.drawable.food_viande
        )
        feedAnimalsModel.generateAnimalsAndFood()
        animalFeed1.setImageResource(listOfAnimals[feedAnimalsModel.getBoardOfAnimals()[0]])
        animalAnwser2.setImageResource(listOfAnimals[feedAnimalsModel.getBoardOfAnimals()[1]])
        animalFeed3.setImageResource(listOfAnimals[feedAnimalsModel.getBoardOfAnimals()[2]])

        food1.setImageResource(listOfFood[feedAnimalsModel.getBoardOfAnimals()[0]])
        food2.setImageResource(listOfFood[feedAnimalsModel.getBoardOfAnimals()[1]])
        food3.setImageResource(listOfFood[feedAnimalsModel.getBoardOfAnimals()[2]])

        bucket1.x=position[feedAnimalsModel.getBoardOfPosition().get(0)]
        bucket2.x=position[feedAnimalsModel.getBoardOfPosition().get(1)]
        bucket3.x=position[feedAnimalsModel.getBoardOfPosition().get(2)]
        animalFeed1.x=position[feedAnimalsModel.getBoardOfPosition().get(0)]
        animalAnwser2.x=position[feedAnimalsModel.getBoardOfPosition().get(1)]
        animalFeed3.x=position[feedAnimalsModel.getBoardOfPosition().get(2)]


    }
    private fun handleTouch(m: MotionEvent){
        if(m.action == MotionEvent.ACTION_MOVE) {
            if (m.x >= food1.x && m.x < food1.x + food1.width && m.y >= food1.y && m.y < food1.y + food1.height) {
               if( food1.x >= bucket1.x-bucket1.width/3 && food1.x + food1.width < bucket1.x + bucket1.width+ bucket1.width/3
                   && food1.y >= bucket1.y-bucket1.height/3 && food1.y + food1.height< bucket1.y + bucket1.height+bucket1.height/3){

                   //food1.setImageDrawable(null);
                   food1.x=-500f
                   food1.y=-500f
                   feedAnimalsModel.animalWasFeed(0)
                   if(feedAnimalsModel.isWin()){
                       val nextAnimal = Intent(this@FeedAnimalsControler, VictoryActivity::class.java)
                       nextAnimal.putExtra("difficulty", intent.getStringExtra("difficulty"))
                       var numberCarrotsWonText = random.nextInt(10).toString()
                       nextAnimal.putExtra("numberCarrotsWonText", numberCarrotsWonText)
                       startActivity(nextAnimal)
                   }
               }else{
                   food1.x = m.x - food1.width / 2
                   food1.y = m.y - food1.height / 2
               }



            }else{
                if (m.x >= food2.x && m.x < food2.x + food2.width && m.y >= food2.y && m.y < food2.y + food2.height) {
                    if( food2.x >= bucket2.x-bucket2.width/3 && food2.x + food2.width < bucket2.x + bucket2.width+ bucket2.width/3
                        && food2.y >= bucket2.y-bucket2.height/3 && food2.y + food1.height< bucket2.y + bucket2.height+bucket2.height/3){

                        food2.x=-500f
                        food2.y=-500f
                        feedAnimalsModel.animalWasFeed(1)
                        if(feedAnimalsModel.isWin()){
                            val nextAnimal = Intent(this@FeedAnimalsControler, VictoryActivity::class.java)
                            nextAnimal.putExtra("difficulty", intent.getStringExtra("difficulty"))
                            var numberCarrotsWonText = random.nextInt(10).toString()
                            nextAnimal.putExtra("numberCarrotsWonText", numberCarrotsWonText)
                            startActivity(nextAnimal)
                        }
                    }else{
                        food2.x = m.x - food2.width / 2
                        food2.y = m.y - food2.height / 2
                    }



                }else{
                    if (m.x >= food3.x && m.x < food3.x + food3.width && m.y >= food3.y && m.y < food3.y + food3.height) {
                        if( food3.x >= bucket3.x-bucket3.width/3 && food3.x + food3.width < bucket3.x + bucket3.width+ bucket3.width/3
                            && food3.y >= bucket3.y-bucket3.height/3 && food3.y + food3.height< bucket3.y + bucket3.height+bucket3.height/3){

                            food3.x=-500f
                            food3.y=-500f
                            feedAnimalsModel.animalWasFeed(2)
                            if(feedAnimalsModel.isWin()){
                                val nextAnimal = Intent(this@FeedAnimalsControler, VictoryActivity::class.java)
                                nextAnimal.putExtra("difficulty", intent.getStringExtra("difficulty"))
                                var numberCarrotsWonText = random.nextInt(10).toString()
                                nextAnimal.putExtra("numberCarrotsWonText", numberCarrotsWonText)
                                startActivity(nextAnimal)
                            }

                        }else{
                            food3.x = m.x - food3.width /2
                            food3.y = m.y - food3.height / 2
                        }



                    }
                }
            }
        }
    }
}