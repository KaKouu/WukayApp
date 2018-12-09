package com.project.wukay.wukayapp

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.TextView
import com.project.wukay.wukayapp.util.Prefs
import com.project.wukay.wukayapp.util.PrefsTimer

import kotlinx.android.synthetic.main.activity_levels.*
import kotlinx.android.synthetic.main.activity_life_pop.*
import java.util.*




class LevelsActivity : AppCompatActivity() {


    companion object {
        private const val SECONDS_FOR_ONE_LIFE = 5L
    }


    private var prefs: Prefs? = null

    enum class TimerState{
        Stopped,Running,Paused
    }

    private lateinit var  timer: CountDownTimer
    private var timerLengthSecond =0L
    private var timerState = TimerState.Stopped


    private var secondsRemaining =SECONDS_FOR_ONE_LIFE


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_levels)


        prefs = Prefs(this)

        val intent = intent
        val difficulty = intent.getStringExtra("difficulty")

        prefs = Prefs(this)
        var skinName=prefs!!.skinName
        lapinouSkin.setImageResource(skinName)


        var nbLife=prefs!!.nbLife

        var lastSeconds=prefs!!.lastSeconds
        var test: Calendar = Calendar.getInstance()
        var actualSeconds = test.timeInMillis

        System.out.println("LAST = " + lastSeconds.toString())
        System.out.println(actualSeconds.toString())
        //compare les deux dates
        var difference = (actualSeconds-lastSeconds) /1000


       System.out.println("DIFFERENCE = "+difference.toString())

        //si la difference est superieur au temps qu'il faut pour récuperer une vie alors on ajoute des vies
        if(difference>=5 && nbLife<10){

            var nbLifeToAdd = difference/5



            //condition pour l'affichage dans la popUp
            var nbLifeToShow =0


            System.out.println("VIE A AJOUTER = " + nbLifeToAdd.toString())

            while(nbLifeToAdd>0 && nbLife<10){
                nbLife+=1
                nbLifeToAdd-=1
                nbLifeToShow+=1
            }

            val popIntent = Intent(applicationContext,LifePopActivity::class.java)
            popIntent.putExtra("nbLifeToShow","$nbLifeToShow")
            startActivity(popIntent)

        }


        //si l'on vient de finir un mini jeux

        val isLastActivityIsAGame = intent.getBooleanExtra("isLastActivityIsAGame",false)
        if(isLastActivityIsAGame){
            nbLife-=1
        }


        setTxtLife(lifeText,nbLife)


        if(nbLife<10){
            startTimer(lifeText,nbLife)
            timerState=TimerState.Running
        }




        //// counter of carrots ///
        var carrots=prefs!!.nbCarrots

        var testNbCarrotsGagnePrecedement=intent.getIntExtra("carotsWon",0)
        carrots+=testNbCarrotsGagnePrecedement





        ////BUTTONS////
        testCarrotes.setOnClickListener {
            var nb = (1..3).shuffled().first()
            carrots+=nb
            numberCarrots.setText(carrots.toString())

            prefs!!.nbCarrots=carrots
        }

        testLife.setOnClickListener {

            nbLife=4
            setTxtLife(lifeText,nbLife)
            if(nbLife<10){
                startTimer(lifeText,nbLife)
                timerState=TimerState.Running
            }



        }

        imageRetour.setOnClickListener{
            val previousPage = Intent(this@LevelsActivity, DifficultyActivity::class.java)
            startActivity(previousPage)
        }

        playButton.setOnClickListener {

            val nextGame = Intent(this@LevelsActivity, WhatIsThisActivity::class.java)
            nextGame.putExtra("difficulty", difficulty)
            startActivity(nextGame)
        }

        testSkin.setOnClickListener {

            skinName= R.drawable.animaux_ane
            prefs!!.skinName=skinName
            System.out.println("SAVE SKIN :" + skinName)
        }

        testSkin2.setOnClickListener {

            skinName= R.drawable.skin_lapinou
            prefs!!.skinName=skinName
            System.out.println("SAVE SKIN :" + skinName)
        }

        //// DATA SAVING ///
        prefs!!.nbCarrots=carrots
        prefs!!.skinName=skinName
        System.out.println("SAVE SKIN :" + skinName)
        numberCarrots.text = carrots.toString()

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
