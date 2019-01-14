package com.project.wukay.wukayapp.metier

import java.util.*

class HideAnimalsMetier {
    private var numberVictory =0;
    private var difficulty = ""
    private var numberAnimalsToFind=3;
    private var numberCaseOfPlacementX = 3
    private var numberCaseOfPlacementY = 3
    private var placementX = IntArray(numberCaseOfPlacementX)
    private var placementY = IntArray(numberCaseOfPlacementY)

    private var ArrayAnswer = IntArray(numberAnimalsToFind)

   public fun initialisationGame(){
       var i=0
       while(i<numberAnimalsToFind){
           ArrayAnswer.set(i,0)
           i++
       }
   }



    public fun getNuberVictory(): Int{
        return numberVictory
    }
    public fun upNumberVictory(){
        numberVictory=numberVictory+1
    }
    public fun getPlacementX(): IntArray{
        return placementX
    }
    public fun getPlacementY(): IntArray{
        return placementY
    }

    public fun isWin(): Boolean{
       var isWin = true
        var i=0
        while(i<numberAnimalsToFind){
            if(ArrayAnswer[i]==0){
                isWin=false
            }
            i++
        }
        return isWin
    }

    public fun findElement(numberOfAnswerClick: Int){
        ArrayAnswer.set(numberOfAnswerClick,1)
    }
    public fun placementRandomInArray(){
        var random = Random()
        var tamponX=-1
        var tamponY = -1
        var i=0

        while(i<numberAnimalsToFind){
            tamponX = random.nextInt(numberCaseOfPlacementX)
            tamponY = random.nextInt(numberCaseOfPlacementY)

            var j=0
            while(j<i){
                while(placementX[j] ==tamponX && placementY[j]==tamponY){
                    tamponX = random.nextInt(numberCaseOfPlacementX)
                    tamponY = random.nextInt(numberCaseOfPlacementY)
                    j=0
                }
                j++
            }

            placementX[i]=tamponX
            placementY[i]=tamponY
            i++
        }




    }
}