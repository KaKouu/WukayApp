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
    val ACTUAL_LEVEL = "actualLevel"
    val VOLUME="volume"
    val NUMERO_MINI_JEU="num_mini_jeu"
    val ETAT_TUTO = "etatTutoActiver"
    val NB_POP_LEVEL="nbPopLevel"
    val INT_BACKGROUND="intBackground"

    val SHOP_PURCHASES0 ="shop_PURCHASES0"
    val SHOP_PURCHASES2 ="shop_PURCHASES2"
    val SHOP_PURCHASES3 ="shop_PURCHASES3"
    val SHOP_PURCHASES4 ="shop_PURCHASES4"
    val SHOP_PURCHASES5 ="shop_PURCHASES5"
    val SHOP_PURCHASES6 ="shop_PURCHASES6"


    val prefs: SharedPreferences = context.getSharedPreferences(PREFS_FILENAME, 0)


    var nbLife : Int

        get() = prefs.getInt(NB_LIFE, 0)
        set(value) = prefs.edit().putInt(NB_LIFE, value).apply()

    var nbPopLevel : Int

        get() = prefs.getInt(NB_POP_LEVEL, 0)
        set(value) = prefs.edit().putInt(NB_POP_LEVEL, value).apply()

    var intBackground : Int

        get() = prefs.getInt(INT_BACKGROUND, 0)
        set(value) = prefs.edit().putInt(INT_BACKGROUND, value).apply()

    var nbCarrots : Int

        get() = prefs.getInt(NB_CARROTS, 0)
        set(value) = prefs.edit().putInt(NB_CARROTS, value).apply()

    var lastSeconds : Long
        get() = prefs.getLong(NB_SECONDS,0)
        set(value) = prefs.edit().putLong(NB_SECONDS,value).apply()

    var skinName : Int

        get() = prefs.getInt(ACTUAL_SKIN_NAME, R.drawable.skin_lapinou)
        set(value) = prefs.edit().putInt(ACTUAL_SKIN_NAME, value).apply()

    var shopPurchased0 : Boolean

        get() = prefs.getBoolean(SHOP_PURCHASES0,false)
        set(value) = prefs.edit().putBoolean(SHOP_PURCHASES0, value).apply()

    var shopPurchased2 : Boolean

        get() = prefs.getBoolean(SHOP_PURCHASES2,false)
        set(value) = prefs.edit().putBoolean(SHOP_PURCHASES2, value).apply()

    var shopPurchased3 : Boolean

        get() = prefs.getBoolean(SHOP_PURCHASES3,false)
        set(value) = prefs.edit().putBoolean(SHOP_PURCHASES3, value).apply()

    var shopPurchased4 : Boolean

        get() = prefs.getBoolean(SHOP_PURCHASES4,false)
        set(value) = prefs.edit().putBoolean(SHOP_PURCHASES4, value).apply()

    var shopPurchased5 : Boolean

        get() = prefs.getBoolean(SHOP_PURCHASES5,false)
        set(value) = prefs.edit().putBoolean(SHOP_PURCHASES5, value).apply()

    var shopPurchased6 : Boolean

        get() = prefs.getBoolean(SHOP_PURCHASES6,false)
        set(value) = prefs.edit().putBoolean(SHOP_PURCHASES6, value).apply()

    var actualLevel : Int

        get() = prefs.getInt(ACTUAL_LEVEL, 0)
        set(value) = prefs.edit().putInt(ACTUAL_LEVEL, value).apply()

    var volume : Int

        get() = prefs.getInt(VOLUME,0)
        set(value) = prefs.edit().putInt(VOLUME,value).apply()

    var num_mini_jeu : Int

        get() = prefs.getInt(NUMERO_MINI_JEU, 0)
        set(value) = prefs.edit().putInt(NUMERO_MINI_JEU, value).apply()

    var etatTutoActiver : Boolean

        get() = prefs.getBoolean(ETAT_TUTO,true)
        set(value) = prefs.edit().putBoolean(ETAT_TUTO, value).apply()

}