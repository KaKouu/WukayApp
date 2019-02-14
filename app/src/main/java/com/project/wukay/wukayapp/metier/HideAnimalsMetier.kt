package com.project.wukay.wukayapp.metier

import java.util.*

class HideAnimalsMetier {

    private var nombreAnimauxATrouver=4;
    private var nombreDeCaseDePlacementX = 3
    private var nombreDeCaseDePlacementY = 3

    private var nombreDeDecor=3
    private var placementX = IntArray(nombreAnimauxATrouver)
    private var placementY = IntArray(nombreAnimauxATrouver)

    private var decorPlacementX = IntArray(nombreDeCaseDePlacementX)
    private var decorPlacementY = IntArray(nombreDeCaseDePlacementY)

    private var tableauReponse = IntArray(nombreAnimauxATrouver)

    private var tableauOrdreCliquer= IntArray(nombreAnimauxATrouver)


   public fun initialisationJeu(){
       var i=0
       while(i<nombreAnimauxATrouver){
           tableauReponse.set(i,0)

           i++
       }
       tableauOrdreCliquer.set(0,0)
       tableauOrdreCliquer.set(1,1)
       tableauOrdreCliquer.set(2,1)

   }

    public fun getPlacementX(): IntArray{
        return placementX
    }
    public fun getTableauReponse() : IntArray {
        return tableauReponse
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
        while(i<nombreAnimauxATrouver-1){
            if(tableauReponse[i]==0){
                estGagne=false
            }
            i++
        }

        return estGagne
    }

    public fun trouveElem(numeroDeLaReponseClique: Int):Int{
        var res=-1

        if (tableauOrdreCliquer[numeroDeLaReponseClique]==1){
            res= 0

        }else{
            if(numeroDeLaReponseClique<2){
                tableauOrdreCliquer.set(numeroDeLaReponseClique,1)
                tableauOrdreCliquer.set(numeroDeLaReponseClique+1,0)
            }else{
                tableauOrdreCliquer.set(numeroDeLaReponseClique,0)
            }

            tableauReponse.set(numeroDeLaReponseClique,1)
            res= 1
            System.out.println("AHNON")
        }

        return res

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