package com.project.wukay.wukayapp

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.os.Handler
import android.support.v4.content.ContextCompat
import android.util.DisplayMetrics
import android.view.KeyEvent
import android.view.View
import android.view.animation.RotateAnimation
import android.view.animation.TranslateAnimation

import android.widget.TextView
import com.project.wukay.wukayapp.FeedAnimalsGame.FeedAnimalsControler
import com.project.wukay.wukayapp.IHM.DifficultyActivity
import com.project.wukay.wukayapp.util.Prefs
import com.project.wukay.wukayapp.util.PrefsTimer

import kotlinx.android.synthetic.main.activity_levels.*
import java.util.*
import com.project.wukay.wukayapp.FeedAnimalsGame.FeedAnimalsEasyTuto
import com.project.wukay.wukayapp.FeedAnimalsGame.FeedAnimalsHardControler
import com.project.wukay.wukayapp.FeedAnimalsGame.FeedAnimalsHardTuto
import com.project.wukay.wukayapp.whatIsThisAnimal.WhatIsThisAnimalActivity
import com.project.wukay.wukayapp.whatIsThisAnimal.WhatIsThisAnimalHardActivity
import com.project.wukay.wukayapp.whatIsThisAnimal.WhatIsThisAnimalHardTutoActivity
import com.project.wukay.wukayapp.whatIsThisAnimal.WhatIsThisAnimalTutoActivity
import kotlinx.android.synthetic.main.activity_feed_animals_easy_tuto.*


class LevelsActivity : AppCompatActivity() {


    companion object {
        private const val SECONDS_FOR_ONE_LIFE = 1500L
    }

    private var prefs: Prefs? = null

    enum class TimerState{
        Stopped,Running,Paused
    }

    private lateinit var  timer: CountDownTimer
    private var timerLengthSecond =0L
    private var timerState = TimerState.Stopped

    private var secondsRemaining =SECONDS_FOR_ONE_LIFE




    override fun onKeyDown(keyCode: Int, event: KeyEvent): Boolean {
        return if (keyCode == KeyEvent.KEYCODE_BACK) {
            false
        } else super.onKeyDown(keyCode, event)
    }

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_levels)

        val vto = levelsScroll.viewTreeObserver
        vto.addOnGlobalLayoutListener { levelsScroll.scrollTo(lapinouSkin.x.toInt(), lapinouSkin.y.toInt()) }


        prefs = Prefs(this)

        shapeLife.visibility = View.INVISIBLE
        heart.visibility = View.INVISIBLE
        numberOfLife.visibility = View.INVISIBLE

        //difficulty
        val intent = intent
        val difficulty = intent.getStringExtra("difficulty")

        val displayMetrics = DisplayMetrics()
        windowManager.defaultDisplay.getMetrics(displayMetrics)
        val heightScreen = displayMetrics.heightPixels
        val widthScreen = displayMetrics.widthPixels

        when(prefs!!.intBackground){
            0 -> {
                background.setBackgroundResource(R.drawable.bg_levels_2)
            }
            1 -> {
                background.setBackgroundResource(R.drawable.bg_levels_sable)
            }
            2 -> {
                background.setBackgroundResource(R.drawable.bg_levels_neige)
            }
        }



        //levels

        var loopLevel = prefs!!.actualLevel
        when (loopLevel % 8) {
            1 -> {

                lapinouSkin.x = widthScreen*30/100F
                lapinouSkin.y = -heightScreen*15/100F
                levelCounter.text = "Niveau : " + loopLevel
            }
            2 -> {
                lapinouSkin.x = -widthScreen*16/100F
                lapinouSkin.y = -heightScreen*33/100F
                levelCounter.text = "Niveau : " + loopLevel
            }
            3 -> {
                lapinouSkin.x = widthScreen*32/100F
                lapinouSkin.y = -heightScreen*45/100F
                levelCounter.text = "Niveau : " + loopLevel
            }
            4 -> {
                lapinouSkin.x = -widthScreen*5/100F
                lapinouSkin.y = -heightScreen*70/100F
                levelCounter.text = "Niveau : " + loopLevel
            }
            5 -> {
                lapinouSkin.x = widthScreen*30/100F
                lapinouSkin.y = -heightScreen*105/100F
                levelCounter.text = "Niveau : " + loopLevel
            }
            6 -> {
                lapinouSkin.x = -widthScreen*16/100F
                lapinouSkin.y = -heightScreen*125/100F
                levelCounter.text = "Niveau : " + loopLevel
            }
            7 -> {
                lapinouSkin.x = widthScreen*30/100F
                lapinouSkin.y = -heightScreen*140/100F
                levelCounter.text = "Niveau : " + loopLevel
            }
            0 -> {
                lapinouSkin.x = -widthScreen*5/100F
                lapinouSkin.y = -heightScreen*155/100F

                levelCounter.text = "Niveau : " + loopLevel

                if(loopLevel/8>prefs!!.nbPopLevel){

                    var randomBackground = Random().nextInt(3)
                    while(randomBackground==prefs!!.intBackground){
                        randomBackground = Random().nextInt(3)
                    }
                    when(randomBackground){
                        0 -> {
                            background.setBackgroundResource(R.drawable.bg_levels_2)
                        }
                        1 -> {
                            background.setBackgroundResource(R.drawable.bg_levels_sable)
                        }
                        2 -> {
                            background.setBackgroundResource(R.drawable.bg_levels_neige)
                        }
                    }

                    prefs!!.intBackground=randomBackground
                    val winPopIntent = Intent(applicationContext,BonusPopActivity::class.java)
                    startActivity(winPopIntent)
                }

            }
            /*0,9,10,11,12,13,14,15,16,17,18,19,20,21,22,323,24,25,26,27,28,29,30-> {
                lapinouSkin.x = 110F
                lapinouSkin.y = 0F
                levelCounter.text = "Niveau : "+loopLevel
                loopLevel=0

            }*/

        }
        if(loopLevel==0){
            lapinouSkin.x = widthScreen*5/100F
            lapinouSkin.y = 0F
        }


        //skin
        var skinName=prefs!!.skinName
        lapinouSkin.setImageResource(skinName)

        //life
        var nbLife=prefs!!.nbLife
        var testNbLife=intent.getIntExtra("lifeWon",0)
        nbLife+=testNbLife

        /*val isLastActivityIsAGame = intent.getBooleanExtra("isLastActivityIsAGame",false)
        val nblifeConsomme = intent.getIntExtra("nblifeConso",0)
        if(isLastActivityIsAGame){
            nbLife=nbLife - nblifeConsomme
        }*/


        var randomGameTempo = prefs!!.num_mini_jeu
        var randomGame = Random().nextInt(3)

        var lastSeconds=prefs!!.lastSeconds
        var test: Calendar = Calendar.getInstance()
        var actualSeconds = test.timeInMillis

        System.out.println("LAST = $lastSeconds")
        System.out.println(actualSeconds.toString())
        //compare les deux dates
        var difference = (actualSeconds-lastSeconds) /1000

        //si la difference est superieur au temps qu'il faut pour récuperer une vie alors on ajoute des vies
        if(difference>= SECONDS_FOR_ONE_LIFE && nbLife<10){

            var nbLifeToAdd = difference/ SECONDS_FOR_ONE_LIFE

            //condition pour l'affichage dans la popUp
            var nbLifeToShow =0

            while(nbLifeToAdd>0 && nbLife<10){
                nbLife+=1
                nbLifeToAdd-=1
                nbLifeToShow+=1
            }

            val popIntent = Intent(applicationContext,LifePopActivity::class.java)
            popIntent.putExtra("nbLifeToShow","$nbLifeToShow")
            startActivity(popIntent)

        }



        //life
        setTxtLife(lifeText,nbLife)
        if(nbLife<10){
            startTimer(lifeText,nbLife)
            timerState=TimerState.Running
        }

        //// counter of carrots ///
        var carrots=prefs!!.nbCarrots
        var testNbCarrotsGagnePrecedement=intent.getIntExtra("carotsWon",0)
        carrots+=testNbCarrotsGagnePrecedement
        var carrotsTempo=0




        ////BUTTONS////

        var etatTuto=prefs!!.etatTutoActiver
        if (etatTuto) {
            buttonTuto.setText("Désactiver")
        }
        else {
            buttonTuto.setText("Activer")
        }

        buttonTuto.setOnClickListener {
            if (etatTuto) {
                etatTuto = false
                buttonTuto.text = "Activer"
                prefs!!.etatTutoActiver = etatTuto
            }
            else {
                etatTuto = true
                buttonTuto.text = "Désactiver"
                prefs!!.etatTutoActiver = etatTuto
            }

        }

        val animation = RotateAnimation(0f,360f,0f,0f)
        animation.duration = 5000;
        shopIcone.startAnimation((animation))

        imageRetour.setOnClickListener{
            val previousPage = Intent(this@LevelsActivity, DifficultyActivity::class.java)
            startActivity(previousPage)
        }
        playButton.setOnClickListener {
            if (nbLife == 0) {
                shapeLife.visibility = View.VISIBLE
                heart.visibility = View.VISIBLE
                numberOfLife.visibility = View.VISIBLE
                val handler = Handler()
                handler.postDelayed({
                    shapeLife.visibility = View.INVISIBLE
                    heart.visibility = View.INVISIBLE
                    numberOfLife.visibility = View.INVISIBLE
                }, 2000)
               /* heart.visibility = View.VISIBLE
                numberOfLife.visibility = View.VISIBLE

                Timer().schedule(1000) {
                    heart.visibility = View.INVISIBLE
                    numberOfLife.visibility = View.INVISIBLE

                }*/
            }
            else {
                while(randomGameTempo==randomGame){
                    randomGame = Random().nextInt(3)
                }
                if (etatTuto) {
                    when (randomGame) {
                        0 -> {
                            if(difficulty=="easy"){
                                val nextGame = Intent(this@LevelsActivity, WhatIsThisAnimalTutoActivity::class.java)
                                nextGame.putExtra("difficulty", difficulty)
                                startActivity(nextGame)
                            }else{
                                val nextGame = Intent(this@LevelsActivity, WhatIsThisAnimalHardTutoActivity::class.java)
                                nextGame.putExtra("difficulty", difficulty)
                                startActivity(nextGame)
                            }
                        }
                        1 -> {
                            if (difficulty == "easy") {
                                val nextGame = Intent(this@LevelsActivity, HideAnimalsEasyTuto::class.java)
                                nextGame.putExtra("difficulty", difficulty)
                                startActivity(nextGame)
                            }
                            else {
                                val nextGame = Intent(this@LevelsActivity, HideAnimalsHardTuto::class.java)
                                nextGame.putExtra("difficulty", difficulty)
                                startActivity(nextGame)
                            }

                        }
                        2-> {
                            if (difficulty == "easy") {
                                val nextGame = Intent(this@LevelsActivity, FeedAnimalsEasyTuto::class.java)
                                nextGame.putExtra("difficulty", difficulty)
                                startActivity(nextGame)
                            }
                            else {
                                val nextGame = Intent(this@LevelsActivity, FeedAnimalsHardTuto::class.java)
                                nextGame.putExtra("difficulty", difficulty)
                                startActivity(nextGame)
                            }

                        }
                    }
                }
                else {
                    when (randomGame) {
                        0 -> {
                            if(difficulty=="easy"){
                                val nextGame = Intent(this@LevelsActivity, WhatIsThisAnimalActivity::class.java)
                                nextGame.putExtra("difficulty", difficulty)
                                startActivity(nextGame)
                            }else{
                                val nextGame = Intent(this@LevelsActivity, WhatIsThisAnimalHardActivity::class.java)
                                nextGame.putExtra("difficulty", difficulty)
                                startActivity(nextGame)

                            }

                        }
                        1 -> {
                            if (difficulty == "easy") {
                                val nextGame = Intent(this@LevelsActivity, HideAnimalsEasy::class.java)
                                nextGame.putExtra("difficulty", difficulty)
                                startActivity(nextGame)
                            }
                            else {
                                val nextGame = Intent(this@LevelsActivity, HideAnimals::class.java)
                                nextGame.putExtra("difficulty", difficulty)
                                startActivity(nextGame)
                            }

                        }
                        2-> {
                            if (difficulty == "easy") {
                                val nextGame = Intent(this@LevelsActivity, FeedAnimalsControler::class.java)
                                nextGame.putExtra("difficulty", difficulty)
                                startActivity(nextGame)
                            }
                            else {
                                val nextGame = Intent(this@LevelsActivity, FeedAnimalsHardControler::class.java)
                                nextGame.putExtra("difficulty", difficulty)
                                startActivity(nextGame)
                            }

                        }
                    }
                }


            }
            prefs!!.num_mini_jeu=randomGame


        }

        lapinouSkin.setOnClickListener {
            if (nbLife <= 0) {
                /* heart.visibility = View.VISIBLE
                 numberOfLife.visibility = View.VISIBLE

                 Timer().schedule(1000) {
                     heart.visibility = View.INVISIBLE
                     numberOfLife.visibility = View.INVISIBLE

                 }*/
            }
            else {
                while(randomGameTempo==randomGame){
                    randomGame = Random().nextInt(3)
                }
                if (etatTuto) {
                    when (randomGame) {
                        0 -> {
                            if(difficulty=="easy"){
                                val nextGame = Intent(this@LevelsActivity, WhatIsThisAnimalTutoActivity::class.java)
                                nextGame.putExtra("difficulty", difficulty)
                                startActivity(nextGame)
                            }else{
                                val nextGame = Intent(this@LevelsActivity, WhatIsThisAnimalHardTutoActivity::class.java)
                                nextGame.putExtra("difficulty", difficulty)
                                startActivity(nextGame)
                            }
                        }
                        1 -> {
                            if (difficulty == "easy") {
                                val nextGame = Intent(this@LevelsActivity, HideAnimalsEasyTuto::class.java)
                                nextGame.putExtra("difficulty", difficulty)
                                startActivity(nextGame)
                            }
                            else {
                                val nextGame = Intent(this@LevelsActivity, HideAnimalsHardTuto::class.java)
                                nextGame.putExtra("difficulty", difficulty)
                                startActivity(nextGame)
                            }

                        }
                        2-> {
                            if (difficulty == "easy") {
                                val nextGame = Intent(this@LevelsActivity, FeedAnimalsEasyTuto::class.java)
                                nextGame.putExtra("difficulty", difficulty)
                                startActivity(nextGame)
                            }
                            else {
                                val nextGame = Intent(this@LevelsActivity, FeedAnimalsHardTuto::class.java)
                                nextGame.putExtra("difficulty", difficulty)
                                startActivity(nextGame)
                            }

                        }
                    }
                }
                else {
                    when (randomGame) {
                        0 -> {
                            if(difficulty=="easy"){
                                val nextGame = Intent(this@LevelsActivity, WhatIsThisAnimalActivity::class.java)
                                nextGame.putExtra("difficulty", difficulty)
                                startActivity(nextGame)
                            }else{
                                val nextGame = Intent(this@LevelsActivity, WhatIsThisAnimalHardActivity::class.java)
                                nextGame.putExtra("difficulty", difficulty)
                                startActivity(nextGame)

                            }

                        }
                        1 -> {
                            if (difficulty == "easy") {
                                val nextGame = Intent(this@LevelsActivity, HideAnimalsEasy::class.java)
                                nextGame.putExtra("difficulty", difficulty)
                                startActivity(nextGame)
                            }
                            else {
                                val nextGame = Intent(this@LevelsActivity, HideAnimals::class.java)
                                nextGame.putExtra("difficulty", difficulty)
                                startActivity(nextGame)
                            }

                        }
                        2-> {
                            if (difficulty == "easy") {
                                val nextGame = Intent(this@LevelsActivity, FeedAnimalsControler::class.java)
                                nextGame.putExtra("difficulty", difficulty)
                                startActivity(nextGame)
                            }
                            else {
                                val nextGame = Intent(this@LevelsActivity, FeedAnimalsHardControler::class.java)
                                nextGame.putExtra("difficulty", difficulty)
                                startActivity(nextGame)
                            }

                        }
                    }
                }


            }
            prefs!!.num_mini_jeu=randomGame


        }

        shopIcone.setOnClickListener {

            val shop = Intent(this@LevelsActivity, ShopActivity::class.java)
            shop.putExtra("difficulty", difficulty)
            startActivity(shop)

        }

        button_settings.setOnClickListener {
            val settings = Intent(this@LevelsActivity, SettingsActivity::class.java)
            settings.putExtra("difficulty",difficulty)
            startActivity(settings)
        }



        //// DATA SAVING ///
        prefs!!.nbCarrots=carrots
        prefs!!.skinName=skinName
        prefs!!.actualLevel=loopLevel


        if(carrots>=1000){
            carrotsTempo=carrots/1000
            numberCarrots.text = carrotsTempo.toString()+" K"
        }else{
            carrotsTempo=carrots
            numberCarrots.text = carrotsTempo.toString()
        }



    }


    ////app////
    override fun onResume() {
        super.onResume()
        initTimer()
    }

    override fun onPause() {
        super.onPause()



            //ACTUAL CALENDAR WHEN THE USER REOPEN THE APP ///
            var actualCalendar: Calendar = Calendar.getInstance()
            var actualSeconds = actualCalendar.timeInMillis

            System.out.println("STOPPED APP")
            System.out.println(actualSeconds)

            saveLastSeconds(actualSeconds)


        PrefsTimer.setPreviousTimerLengthSeconds(timerLengthSecond,this)
        PrefsTimer.setSecondsRemaining(secondsRemaining,this)
        PrefsTimer.setTimerState(timerState,this)
    }



    //////TIMER//////
    private fun initTimer(){
        timerState = PrefsTimer.getTimerState(this)
        if(timerState== TimerState.Stopped){
            setNewTimerLength()
        }else{
            setPreviousTimerLength()
        }
        secondsRemaining = if( timerState== TimerState.Running || timerState == TimerState.Paused){
            PrefsTimer.getSecondsRemaining(this)
        }else{
            timerLengthSecond
        }
        if(timerState==TimerState.Running){
            //startTimer()
        }
    }

    private fun onTimerFinished(txt : TextView, nb: Int){
        timerState= TimerState.Stopped

        System.out.println("fin Timer")
        var nbL = nb +1

        setTxtLife(txt, nbL)

        setNewTimerLength()
        secondsRemaining = timerLengthSecond

        if(nbL<10){
            startTimer(txt,nbL)
        }

    }

    private fun startTimer(txt : TextView, nb: Int){
        System.out.println("Debut timer")
        timerState =TimerState.Running
        timer = object : CountDownTimer(secondsRemaining*1000,1000){
            override fun onFinish() = onTimerFinished(txt,nb)
            override fun onTick(millisUntilFinished: Long) {
                secondsRemaining = millisUntilFinished/1000

            }
        }.start()
    }

    private fun setTxtLife(txt : TextView, nb: Int){
        txt.text="$nb / 10"

        prefs!!.nbLife=nb
        System.out.println("SAVED LIVES")
        System.out.println(nb)

    }

    private fun saveLastSeconds(seconds : Long){
        prefs!!.lastSeconds=seconds
        System.out.println(seconds)

    }

    private fun setNewTimerLength(){
        //val lengthInMinutes = PrefUtil.getTimerLength(this)
        timerLengthSecond = 5L
    }

    private fun setPreviousTimerLength(){
        timerLengthSecond = PrefsTimer.getPreviousTimerLengthSeconds(this)
    }

}
