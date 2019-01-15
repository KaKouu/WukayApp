package com.project.wukay.wukayapp.metier

import com.project.wukay.wukayapp.util.Aleatoire
import java.util.*

class FeedAnimalsModel {
    private var numberOfAnimals = 3
    private var numberOfFood = 3
    private var numberOfAnimalPictures = 10


    private var boardOfFood = IntArray(numberOfAnimals)
    private var boardOfAnimals = IntArray(numberOfFood)

    public fun getBoardOfFood():IntArray{
        return boardOfFood
    }
    public fun getBoardOfAnimals():IntArray{
        return boardOfAnimals
    }

    public fun beginGame(){
        var i =0
        while(i<numberOfAnimals){
            boardOfFood.set(i,-1)
            boardOfAnimals.set(i,-1)
        }
    }
    public fun generateAnimalsAndFood(){
        var aleatoire = Random()
        var tamponX= -1
        var tamponY = -1
        var i=0

        while(i<numberOfAnimals){

            tamponX = aleatoire.nextInt(numberOfAnimalPictures)
            tamponY = aleatoire.nextInt(numberOfAnimalPictures)

            while(boardOfAnimals.contains(tamponX)){
                tamponX = aleatoire.nextInt(numberOfAnimalPictures)
            }
            while(boardOfFood.contains(tamponY)){
                tamponY = aleatoire.nextInt(numberOfAnimalPictures)
            }


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
        boardOfAnimals.set(indexAnimal,1)
    }
    public fun isWin():Boolean{
        var isWin=true;
        var i=0
        while(i<numberOfAnimals){
            if(boardOfAnimals[i]==0){
                isWin=false
            }
        }
        return isWin
    }


}