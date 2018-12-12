package com.project.wukay.wukayapp.util

class Skin(var file : Int, var price : Int) {

    private var prefs: Prefs? = null


    var isPurchase = prefs!!.isPurchased



    fun savePurchase(boolean: Boolean){
        prefs!!.isPurchased=boolean
    }


}