package com.project.wukay.wukayapp

import android.media.MediaPlayer
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_settings.*
import android.media.AudioManager
import android.widget.SeekBar
import android.widget.SeekBar.OnSeekBarChangeListener
import android.content.Context
import android.content.Context.AUDIO_SERVICE
import android.content.Context.AUDIO_SERVICE
import android.content.Intent
import com.project.wukay.wukayapp.util.Prefs
import kotlinx.android.synthetic.main.activity_shop.*


class SettingsActivity : AppCompatActivity(){

    private var prefs: Prefs? = null




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)

        prefs = Prefs(this)

        var volumeAppli=prefs!!.volume

        val audioManager: AudioManager = getSystemService(Context.AUDIO_SERVICE) as AudioManager

        val barVolume = findViewById(R.id.volumeBar) as SeekBar
        barVolume.setMax(audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC))
        barVolume.setProgress(audioManager.getStreamVolume(AudioManager.STREAM_MUSIC))

        audioManager.setStreamVolume(AudioManager.STREAM_MUSIC,
            volumeAppli, 0)


        barVolume.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {

            override fun onProgressChanged(seekBar: SeekBar, progress: Int, b: Boolean) {
                volumeAppli=progress
                audioManager.setStreamVolume(AudioManager.STREAM_MUSIC,
                    volumeAppli, 0)
                prefs!!.volume=volumeAppli
            }

            override fun onStartTrackingTouch(seekBar: SeekBar) {
            }

            override fun onStopTrackingTouch(seekBar: SeekBar) {
            }
        })

        val music  = MediaPlayer.create(this, R.raw.sound_birds)

        testSon.setOnClickListener{
            music.start()
        }

        flecheRetour.setOnClickListener {
            val previousPage = Intent(this@SettingsActivity, LevelsActivity::class.java)
            startActivity(previousPage)
        }

        switch_vibration.setOnCheckedChangeListener { buttonView, isChecked ->
            textVibration.text=""+isChecked
        }

        //DATA SAVING
        prefs!!.volume=volumeAppli
    }


}

