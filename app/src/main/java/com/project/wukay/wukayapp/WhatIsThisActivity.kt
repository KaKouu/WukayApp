package com.project.wukay.wukayapp

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Vibrator
import android.view.View
import android.view.animation.TranslateAnimation
import android.widget.ImageView
import kotlinx.android.synthetic.main.activity_hard_what_is_this.*
import kotlinx.android.synthetic.main.activity_what_is_this.*
import java.util.*
import kotlin.concurrent.schedule

class WhatIsThisActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        // mise en place du layout
        super.onCreate(savedInstanceState)


        //déclaration des variables
        val difficulty = intent.getStringExtra("difficulty") //renvaiera la difficulté choisit precedement
        val nextAnimal = Intent(this@WhatIsThisActivity, VictoryActivity::class.java)
        nextAnimal.putExtra("difficulty", difficulty)
        var numberWin=0
        val vibratorService = getSystemService(Context.VIBRATOR_SERVICE) as Vibrator

        if (difficulty == "easy"){
            setContentView(R.layout.activity_what_is_this)
        }else
        {
            setContentView(R.layout.activity_hard_what_is_this)
        }

        //selon le niveau de difficulté
        if(difficulty=="easy") {


            //var tableauTampon : Array<Int> = arrayOf(0,0,0,0)
            var tampon = 0
            var tampon1 = 0
            var tampon2 = 0
            var tampon3 = 0

            var tableau = IntArray(4);
            tableau.set(0,0)
            tableau.set(1,0)
            tableau.set(2,0)
            tableau.set(3,0)

            var tabTampon = IntArray(3)

            val animalArray = arrayOf(
                R.drawable.animaux_cochon_silhouette,
                R.drawable.animaux_vache_silhouette,
                R.drawable.animaux_girafe_silhouette
            )

            val answerAnimal = arrayOf(
                R.drawable.animaux_cochon,
                R.drawable.animaux_vache,
                R.drawable.animaux_girafe
            )
           
            animalAnwser2.startAnimation(TranslateAnimation(0f, 0f, 0f, -975f).apply {
                setFillAfter(true)
                duration = 5000
            })

            startButton.setOnClickListener {

                System.out.println(numberWin)



                    resultat.setText("")
                    tampon = randomizeImage(tabTampon, animalArray, animalPic)
                    ////SILHOUETTE
                    tabTampon.set(0, tampon)
                    tabTampon.set(1, 10)
                    tabTampon.set(2, 10)




                    ////AWNSER
                    tampon1 = randomizeImage(tabTampon, answerAnimal, animalAnwser1)
                    tabTampon.set(0, tampon1)


                    tampon2 = randomizeImage(tabTampon, answerAnimal, animalAnwser2)
                    tabTampon.set(1, tampon2)

                    tampon3 = randomizeImage(tabTampon, answerAnimal, animalAnwser3)
                    tabTampon.set(2, tampon3)

                    startButton.visibility = View.INVISIBLE
                    arrow.visibility = View.INVISIBLE


            }


            animalAnwser1.setOnClickListener {

                //condition si le joueur donne la bonne réponse
                if( isTheCorrectAnswer(tampon,tabTampon,0)){

                    //incrementation du nombre d'animal trouvé
                    resultat.text=""
                    numberWin+=1
                    System.out.println("NOMBRE WIN : " + numberWin)

                    //fin du mini jeux
                    if(numberWin==3){
                        startActivity(nextAnimal)

                     //prochain animal à deviner
                    }else{

                        ////SILHOUETTE
                        tabTampon.set(0, tampon)
                        tabTampon.set(1, 10)
                        tabTampon.set(2, 10)

                        tampon = randomizeImage(tabTampon, animalArray, animalPic)


                        ////AWNSER
                        tampon1 = randomizeImage(tabTampon, answerAnimal, animalAnwser1)
                        tabTampon.set(0, tampon1)


                        tampon2 = randomizeImage(tabTampon, answerAnimal, animalAnwser2)
                        tabTampon.set(1, tampon2)

                        tampon3 = randomizeImage(tabTampon, answerAnimal, animalAnwser3)
                        tabTampon.set(2, tampon3)

                    }

                }else{
                    //vibration de defaite +texte
                    vibratorService.vibrate(100)
                    resultat.text="Essaye encore !"
                }

            }

            animalAnwser2.setOnClickListener {
                //condition si le joueur donne la bonne réponse
                if( isTheCorrectAnswer(tampon,tabTampon,1)){

                    //incrementation du nombre d'animal trouvé
                    resultat.text=""
                    numberWin+=1
                    System.out.println("NOMBRE WIN : " + numberWin)

                    //fin du mini jeux
                    if(numberWin==3){
                        startActivity(nextAnimal)

                        //prochain animal à deviner
                    }else{
                        ////SILHOUETTE
                        tabTampon.set(0, tampon)
                        tabTampon.set(1, 10)
                        tabTampon.set(2, 10)

                        tampon = randomizeImage(tabTampon, animalArray, animalPic)


                        ////AWNSER
                        tampon1 = randomizeImage(tabTampon, answerAnimal, animalAnwser1)
                        tabTampon.set(0, tampon1)


                        tampon2 = randomizeImage(tabTampon, answerAnimal, animalAnwser2)
                        tabTampon.set(1, tampon2)

                        tampon3 = randomizeImage(tabTampon, answerAnimal, animalAnwser3)
                        tabTampon.set(2, tampon3)

                    }

                }else{
                    //vibration de defaite
                    vibratorService.vibrate(100)

                    resultat.text="Essaye encore !"
                }

            }

            animalAnwser3.setOnClickListener {
                //condition si le joueur donne la bonne réponse
                if( isTheCorrectAnswer(tampon,tabTampon,2)){

                    //incrementation du nombre d'animal trouvé
                    resultat.text=""
                    numberWin+=1
                    System.out.println("NOMBRE WIN : " + numberWin)

                    //fin du mini jeux
                    if(numberWin==3){
                        startActivity(nextAnimal)

                        //prochain animal à deviner
                    }else{
                        ////SILHOUETTE
                        tabTampon.set(0, tampon)
                        tabTampon.set(1, 10)
                        tabTampon.set(2, 10)

                        tampon = randomizeImage(tabTampon, animalArray, animalPic)


                        ////AWNSER
                        tampon1 = randomizeImage(tabTampon, answerAnimal, animalAnwser1)
                        tabTampon.set(0, tampon1)


                        tampon2 = randomizeImage(tabTampon, answerAnimal, animalAnwser2)
                        tabTampon.set(1, tampon2)

                        tampon3 = randomizeImage(tabTampon, answerAnimal, animalAnwser3)
                        tabTampon.set(2, tampon3)

                    }

                }else{
                    //vibration de defaite
                    vibratorService.vibrate(100)

                    resultat.text="Essaye encore !"
                }

            }


        }else{

            //CODE DE LA PARTIE DIFFICILE

            var numberOfWin=0;

            val arrayOfAnimalsPicture = arrayOf(
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

            val arrayOfQuestion=arrayOf(
                "Je suis rose, je me roule dans la boue et j'ai une queue en tire bouchon",
                "Je fais du lait et j'ai des tâches noires et blanches",
                "J'ai un long cou et je vis dans la savane",
                "Je suis le mari de la chèbre et j'ai des cornes",
                "Je ronronne quand un me caresse",
                "J'ai des pinces et je vis sur la plage",
                "J'ai de grandes dents et je vis sur la glace",
                "Je suis noir et blanc et je mange des bambous",
                "Je fais la roue avec ma queue",
                "Je vis sur la glace et je glisse sur mon ventre",
                "Je ponds des oeufs et je picore le grain",
                "J'ai des giffes et je vis dans la savane",
                "Je suis rayé de noir et de blanc",
                "Je suis le roi de la savane et j'ai une belle crinière"
            )
           description.setText("")
            var nombreDeReponsesPossibles=3
            var memoAnimauxChoisi=IntArray(nombreDeReponsesPossibles)
            var reponse =-1
            var rand = Random()
            var ouMettreLaReponse=0

            reponse =rand.nextInt(arrayOfAnimalsPicture.size)
            ouMettreLaReponse=rand.nextInt(nombreDeReponsesPossibles)


            minijeu(
                arrayOfQuestion,
                reponse,
                nombreDeReponsesPossibles,
                memoAnimauxChoisi,
                rand,
                arrayOfAnimalsPicture,
                ouMettreLaReponse
            )


            answer1.setOnClickListener{
                if(memoAnimauxChoisi.get(0)==reponse){

                    numberWin+=1
                    if(numberWin==3){
                        startActivity(nextAnimal)
                    }else{
                        reponse =rand.nextInt(arrayOfAnimalsPicture.size-1)
                        ouMettreLaReponse=rand.nextInt(nombreDeReponsesPossibles)


                        minijeu(
                            arrayOfQuestion,
                            reponse,
                            nombreDeReponsesPossibles,
                            memoAnimauxChoisi,
                            rand,
                            arrayOfAnimalsPicture,
                            ouMettreLaReponse
                        )
                    }

                }else{
                    description.setText("Essaye encore !")
                    vibratorService.vibrate(100)
                }

            }
            answer2.setOnClickListener{
                if(memoAnimauxChoisi.get(1)==reponse){

                    numberWin+=1
                    if(numberWin==3){
                        startActivity(nextAnimal)
                    }else{
                        reponse =rand.nextInt(arrayOfAnimalsPicture.size-1)
                        ouMettreLaReponse=rand.nextInt(nombreDeReponsesPossibles)


                        minijeu(
                            arrayOfQuestion,
                            reponse,
                            nombreDeReponsesPossibles,
                            memoAnimauxChoisi,
                            rand,
                            arrayOfAnimalsPicture,
                            ouMettreLaReponse
                        )
                    }
                }else{
                    description.setText("Essaye encore !")
                    vibratorService.vibrate(100)
                }
            }
            answer3.setOnClickListener{
                if(memoAnimauxChoisi.get(2)==reponse){

                    numberWin+=1
                    if(numberWin==3){
                        startActivity(nextAnimal)
                    }else{
                        reponse =rand.nextInt(arrayOfAnimalsPicture.size-1)
                        ouMettreLaReponse=rand.nextInt(nombreDeReponsesPossibles)


                        minijeu(
                            arrayOfQuestion,
                            reponse,
                            nombreDeReponsesPossibles,
                            memoAnimauxChoisi,
                            rand,
                            arrayOfAnimalsPicture,
                            ouMettreLaReponse
                        )
                    }
                }else{
                    description.setText("Essaye encore !")
                    vibratorService.vibrate(100)
                }
            }



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


    public fun isTheCorrectAnswer(indexOfAnswer: Int, arrayIndexOfPicturesPutedAsAnswer: IntArray, index: Int):Boolean  {
        return indexOfAnswer == arrayIndexOfPicturesPutedAsAnswer.get(index)
    }


    private fun randomizeImage(arrayIndexOfAnswerPicture: IntArray, arrayOfPictures: Array<Int>, view: ImageView): Int  {
        var rand = Random()
        var indexOfAnimalPicture = rand.nextInt(3)

        //don't chose an index which has been already chosen
        while (arrayIndexOfAnswerPicture.contains(indexOfAnimalPicture) ) {
            indexOfAnimalPicture = rand.nextInt(3)

        }

        //change the picture passed in parameters by one of the arrayOfPictures
        view.setImageResource(arrayOfPictures[indexOfAnimalPicture])
        return indexOfAnimalPicture

    }

    private fun giveRandomPicture(arrayOfAnimalsPicture : Array<Int>):IntArray{
        var arrayAnswer = IntArray(4)
        var rand = Random()
        arrayAnswer.set(0,rand.nextInt(arrayOfAnimalsPicture.size))
        arrayAnswer.set(1,arrayAnswer.get(0))
        arrayAnswer.set(2,randomWithNotTheParameters(arrayAnswer.get(0),arrayOfAnimalsPicture.size))
        arrayAnswer.set(3,randomWithNotTheParameters(arrayAnswer.get(0),arrayOfAnimalsPicture.size))

        return arrayAnswer

    }

    private fun randomWithNotTheParameters(n : Int, bound : Int):Int{
        var rand = Random()
        var result=rand.nextInt(bound)

        while(result==n) {
            result = rand.nextInt(bound)
        }
        return result;
    }




}
