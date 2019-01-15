package com.project.wukay.wukayapp

import com.project.wukay.wukayapp.metier.HideAnimalsMetier
import org.junit.Assert
import org.junit.Test

class HideAnimalsTest {

    @Test
    fun return_true_is_win_if_we_find_3_animals() {
        var test = HideAnimalsMetier()
        test.trouveElem(0)
        test.trouveElem(1)
        test.trouveElem(2)
        test.isWin()
        Assert.assertTrue(test.isWin())
    }

    @Test
    fun return_false_is_we_dont_find_3_animals() {
        var test = HideAnimalsMetier()
        test.trouveElem(0)
        test.isWin()
        Assert.assertFalse(test.isWin())
    }

    @Test
    fun ArrayAnswer_should_be_0() {
        var test = HideAnimalsMetier()
        test.initialisationJeu()
        Assert.assertEquals(0,test.getTableauReponse().get(0))
        Assert.assertEquals(0,test.getTableauReponse().get(1))
        Assert.assertEquals(0,test.getTableauReponse().get(2))
    }

    @Test
    fun ArrayAnswer_should_be_1_Elem_Find(){
        var test = HideAnimalsMetier()
        test.initialisationJeu()
        test.trouveElem(0)
        Assert.assertEquals(1,test.getTableauReponse().get(0))
        test.trouveElem(2)
        Assert.assertEquals(1,test.getTableauReponse().get(2))

    }

}