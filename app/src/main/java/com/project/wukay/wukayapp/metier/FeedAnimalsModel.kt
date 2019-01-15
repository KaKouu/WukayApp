package com.project.wukay.wukayapp.metier

import java.util.*

class FeedAnimalsModel {
    private var numberOfAnimals = 3
    private var numberOfFood = 3
    private var numberOfAnimalPictures = 10


    private var boardOfIsEaten = IntArray(numberOfFood)
    private var boardOfElements = IntArray(numberOfAnimals)

    public fun getBoardOfFood():IntArray{
        return boardOfIsEaten

    }
    public fun getBoardOfAnimals():IntArray{
        return boardOfElements
    }

    public fun beginGame(){
        var i =0
        while(i<numberOfAnimals){
            boardOfIsEaten.set(i,0)
            boardOfElements.set(i,-1)
            i++
        }
    }
    public fun generateAnimalsAndFood(){
        var aleatoire = Random()
        var tamponX= -1

        var i=0

        while(i<numberOfAnimals){

            tamponX = aleatoire.nextInt(numberOfAnimalPictures)
            boardOfElements.set(i,tamponX)

            while(boardOfElements.contains(tamponX)){
                tamponX = aleatoire.nextInt(numberOfAnimalPictures)

            }
            boardOfElements.set(i,tamponX)


            i++
        }



    }
    public fun animalCanEatThisFood(indexAnimal:Int,indexFood:Int): Boolean{
        if(indexAnimal==indexFood){
            return true
        }else {
            return false
        }
    }
    public fun animalWasFeed(indexAnimal: Int){
        boardOfIsEaten.set(indexAnimal,1)
    }
    public fun isWin():Boolean{
        var isWin=true;
        var i=0
        while(i<numberOfAnimals){
            if(boardOfIsEaten[i]==0){
                isWin=false
            }
            i++
        }
        return isWin
    }


}