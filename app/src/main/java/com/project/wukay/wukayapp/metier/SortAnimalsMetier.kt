package com.project.wukay.wukayapp.metier

import java.util.*

class SortAnimalsMetier {
    private var numberOfAnimalsToFind = 5
    private var numberOfAnimalPictures = 10
    private var numberOfDecor = 3
    private var boardOfHisHome = IntArray(numberOfDecor)
    private var boardOfElements = IntArray(numberOfAnimalsToFind)

    public fun getBoardOfHisHome() : IntArray{
        return boardOfHisHome
    }

    public fun getBoardOfAnimals() : IntArray{
        return boardOfElements
    }


    public fun beginGame(){
        var i =0
        while(i<numberOfAnimalsToFind){
            boardOfHisHome.set(i,0)
            boardOfElements.set(i,-1)
            i++
        }
    }

    public fun generateAnimalsAndDecor(){
        var aleatoire = Random()
        var tamponX= -1
        var tamponY= -1

        var i=0

        while(i<numberOfAnimalsToFind){

            tamponX = aleatoire.nextInt(numberOfAnimalPictures)
            tamponY = aleatoire.nextInt(numberOfAnimalsToFind)

            while(boardOfElements.contains(tamponX)){
                tamponX = aleatoire.nextInt(numberOfAnimalPictures)
            }
            boardOfElements.set(i,tamponX)
        }
    }

    public fun animalsInHisHome(indexAnimal : Int) {
        boardOfHisHome.set(indexAnimal,1)
    }

    public fun isWin():Boolean{
        var isWin=true;
        var i=0
        while(i<numberOfAnimalsToFind){
            if(boardOfHisHome[i]==0){
                isWin=false
            }
            i++
        }
        return isWin
    }

}