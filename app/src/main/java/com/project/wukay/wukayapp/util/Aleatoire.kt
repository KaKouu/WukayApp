package com.project.wukay.wukayapp.util

import java.util.*

class Aleatoire {
    private var aleatoire : Random = Random()

    public fun chiffreAleatoireDifferentEntreDeuxBornes(borneSuperieure : Int, nombreDeNombre : Int): IntArray{
        var resultat = IntArray(nombreDeNombre)
        var i=0
        var tampon : Int
        while(i<nombreDeNombre){
            resultat.set(i,-1)
            i++
        }

        i=0
        while(i<nombreDeNombre){
            tampon=aleatoire.nextInt(borneSuperieure)
            while(resultat.contains(tampon)){
                tampon=aleatoire.nextInt(borneSuperieure)
            }
            resultat.set(i,tampon)
            i++
        }


        return resultat
    }
}