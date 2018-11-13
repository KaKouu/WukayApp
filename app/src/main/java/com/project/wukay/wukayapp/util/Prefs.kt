package com.project.wukay.wukayapp.util


import android.content.Context
import android.content.SharedPreferences

class Prefs(context : Context) {

    val PREFS_FILENAME = "com.project.wukay.myapplication"
    val NB_LIFE = "nb_lapin"
    val NB_SECONDS = "nb_seconds"
    val NB_CARROTS = "nb_carrots"

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

}