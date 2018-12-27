package com.project.wukay.wukayapp

import com.project.wukay.wukayapp.metier.HideAnimalsMetier
import org.junit.Assert
import org.junit.Test

class HideAnimalsTest {
    @Test
    fun should_return_0_if_we_just_created_the_class(){
        var test = HideAnimalsMetier()


        Assert.assertEquals(0,test.getNombreVictoire())

    }
    @Test
    fun should_return_1_if_we_creat_the_class_and_call_the_method_up(){
        var test = HideAnimalsMetier()
        test.upNombreVictoire()

        Assert.assertEquals(1,test.getNombreVictoire())

    }
    @Test
    fun should_return_true_if_we_creat_the_class_and_call_the_method_up_3_times(){
        var test = HideAnimalsMetier()
        test.upNombreVictoire()
        test.upNombreVictoire()
        test.upNombreVictoire()

        Assert.assertTrue(test.isWin())

    }
    @Test
    fun should_return_true_if_we_creat_the_class_and_call_the_method_up_3_timese(){
        var test = HideAnimalsMetier()
        test.initialisationJeu()
        test.placementAleatoireDansTableau()

        var i=0
        var j=0

        while(i<test.getPlacementX().size){
            System.out.println(test.getPlacementX()[i])
            i++
        }
        while(j<test.getPlacementY().size){
            System.out.println(test.getPlacementY()[j])
            j++
        }

        Assert.assertTrue(test.isWin())

    }

}