package com.project.wukay.wukayapp.metier

import java.util.*

class HideAnimalsMetier {
    private var nombreVictoire =0;
    private var difficulte = ""
    private var nombreAnimauxATrouver=3;
    private var nombreDeCaseDePlacementX = 3
    private var nombreDeCaseDePlacementY = 3

    private var nombreDeDecor=3
    private var placementX = IntArray(nombreDeCaseDePlacementX)
    private var placementY = IntArray(nombreDeCaseDePlacementY)

    private var decorPlacementX = IntArray(nombreDeCaseDePlacementX)
    private var decorPlacementY = IntArray(nombreDeCaseDePlacementY)

    private var tableauReponse = IntArray(nombreAnimauxATrouver)

   public fun initialisationJeu(){
       var i=0
       while(i<nombreAnimauxATrouver){
           tableauReponse.set(i,0)
           i++
       }
   }



    public fun getNombreVictoire(): Int{
        return nombreVictoire
    }
    public fun upNombreVictoire(){
        nombreVictoire=nombreVictoire+1
    }
    public fun getPlacementX(): IntArray{
        return placementX
    }
    public fun getPlacementY(): IntArray{
        return placementY
    }
    public fun getDecorPlacementX(): IntArray{
        return decorPlacementX
    }
    public fun getDecorPlacementY(): IntArray{
        return decorPlacementY
    }

    public fun isWin(): Boolean{
       var estGagne = true
        var i=0
        while(i<nombreAnimauxATrouver){
            if(tableauReponse[i]==0){
                estGagne=false
            }
            i++
        }
        return estGagne
    }

    public fun trouveElem(numeroDeLaReponseClique: Int){
        tableauReponse.set(numeroDeLaReponseClique,1)
    }
    public fun placementAleatoireDansTableau(){
        var aleatoire = Random()
        var tamponX=-1
        var tamponY = -1
        var i=0

        while(i<nombreAnimauxATrouver){
            tamponX = aleatoire.nextInt(nombreDeCaseDePlacementX)
            tamponY = aleatoire.nextInt(nombreDeCaseDePlacementY)

            var j=0
            while(j<i){
                while(placementX[j] ==tamponX && placementY[j]==tamponY){
                    tamponX = aleatoire.nextInt(nombreDeCaseDePlacementX)
                    tamponY = aleatoire.nextInt(nombreDeCaseDePlacementY)
                    j=0
                }
                j++
            }

            placementX[i]=tamponX
            placementY[i]=tamponY
            i++
        }




    }
    public fun placementAleatoireDecorDansTableau(){
        var aleatoire = Random()
        var tamponX=-1
        var tamponY = -1
        var i=0

        while(i<nombreDeDecor){
            tamponX = aleatoire.nextInt(nombreDeCaseDePlacementX)
            tamponY = aleatoire.nextInt(nombreDeCaseDePlacementY)

            var j=0
            while(j<i){
                while(decorPlacementX[j] ==tamponX && decorPlacementY[j]==tamponY){
                    tamponX = aleatoire.nextInt(nombreDeCaseDePlacementX)
                    tamponY = aleatoire.nextInt(nombreDeCaseDePlacementY)
                    j=0
                }
                j++
            }

            decorPlacementX[i]=tamponX
            decorPlacementY[i]=tamponY
            i++
        }




    }
}