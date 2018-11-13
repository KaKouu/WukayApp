package com.project.wukay.wukayapp

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.TextView
import com.project.wukay.wukayapp.util.Prefs

import kotlinx.android.synthetic.main.activity_levels.*
import java.util.*

class LevelsActivity : AppCompatActivity() {

    private var prefs: Prefs? = null

    enum class TimerState{
        Stopped,Running,Paused
    }

    private lateinit var  timer: CountDownTimer
    private var timerLengthSecond =0L
    private var timerState = TimerState.Stopped
    private var secondsRemaining =5L




    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_levels)

        prefs = Prefs(this)

        val intent = intent
        val difficulty = intent.getStringExtra("difficulty")


        imageRetour.setOnClickListener{
            val previousPage = Intent(this@LevelsActivity, HomeActivity::class.java)
            startActivity(previousPage)
        }


        playButton.setOnClickListener {

            val nextGame = Intent(this@LevelsActivity, WhatIsThisActivity::class.java)
            nextGame.putExtra("difficulty", difficulty)
            startActivity(nextGame)
        }




        // counter of carots
        var carrots=prefs!!.nbLapin

        var testNbCarrotsGagnePrecedement=intent.getIntExtra("carotsWon",0)
        carrots+=testNbCarrotsGagnePrecedement





        // Enregistrer les donnés
        prefs!!.nbCarrots=carrots
        numberCarrots.text = carrots.toString()

        testCarrotes.setOnClickListener {
            var nb = (1..3).shuffled().first()
            carrots=carrots+nb
            numberCarrots.setText(carrots.toString())
        }


    }






    override fun onResume() {
        super.onResume()
        initTimer()
    }

    override fun onPause() {
        super.onPause()
        if(timerState== TimerState.Running){
            timer.cancel()
            var actualCalendar: Calendar = Calendar.getInstance()
            var actualSeconds = actualCalendar.timeInMillis

            saveLastSeconds(actualSeconds)
        }

        PrefUtil.setPreviousTimerLengthSeconds(timerLengthSecond,this)
        PrefUtil.setSecondsRemaining(secondsRemaining,this)
        PrefUtil.setTimerState(timerState,this)
    }


    private fun initTimer(){
        timerState = PrefUtil.getTimerState(this)
        if(timerState== TimerState.Stopped){
            setNewTimerLength()
        }else{
            setPreviousTimerLength()
        }
        secondsRemaining = if( timerState== TimerState.Running || timerState == TimerState.Paused){
            PrefUtil.getSecondsRemaining(this)
        }else{
            timerLengthSecond
        }
        if(timerState==TimerState.Running){
            //startTimer()
        }
        updateLifeCount()
    }


    private fun onTimerFinished(txt : TextView, nb: Int){
        timerState= TimerState.Stopped

        System.out.println("fin Timer")
        var nbL = nb +1

        setTxtLapin(txt, nbL)

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
                updateLifeCount()
            }
        }.start()
    }

    private fun setTxtLapin(txt : TextView, nb: Int){
        txt.text="$nb / 10"

        prefs!!.nbLapin=nb

    }

    private fun saveLastSeconds(seconds : Long){
        prefs!!.lastSeconds=seconds
    }


    private fun setNewTimerLength(){
        //val lengthInMinutes = PrefUtil.getTimerLength(this)
        timerLengthSecond = 5L
    }


    private fun setPreviousTimerLength(){
        timerLengthSecond = PrefUtil.getPreviousTimerLengthSeconds(this)
    }


}
