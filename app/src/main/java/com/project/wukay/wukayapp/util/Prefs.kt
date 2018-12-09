package com.project.wukay.wukayapp.util


import android.content.Context
import android.content.SharedPreferences
import com.project.wukay.wukayapp.R

class Prefs(context : Context) {

    val PREFS_FILENAME = "com.project.wukay.wukayapp"
    val NB_LIFE = "nb_lapin"
    val NB_SECONDS = "nb_seconds"
    val NB_CARROTS = "nb_carrots"
    val ACTUAL_SKIN_NAME = "skinName"

    val prefs: SharedPreferences = context.getSharedPreferences(PREFS_FILENAME, 0)


    var nbLife : Int

        get() = prefs.getInt(NB_LIFE, 0)
        set(value) = prefs.edit().putInt(NB_LIFE, value).apply()

    var nbCarrots : Int

        get() = prefs.getInt(NB_CARROTS, 0)
        set(value) = prefs.edit().putInt(NB_CARROTS, value).apply()

    var lastSeconds : Long
        get() = prefs.getLong(NB_SECONDS,0)
        set(value) = prefs.edit().putLong(NB_SECONDS,value).apply()

    var skinName : Int

        get() = prefs.getInt(ACTUAL_SKIN_NAME, R.drawable.skin_lapinou)
        set(value) = prefs.edit().putInt(ACTUAL_SKIN_NAME, value).apply()
}