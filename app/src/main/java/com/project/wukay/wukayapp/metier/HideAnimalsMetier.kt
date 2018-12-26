package com.project.wukay.wukayapp.metier

class HideAnimalsMetier {
    private var nombreVictoire =0;
    private var difficulte = ""
    private var nombreAnimauxATrouver=3;

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
}