package com.project.wukay.wukayapp

import com.project.wukay.wukayapp.metier.FeedAnimalsModel
import org.junit.Assert
import org.junit.Test

class FeedAnimalsTest {

    @Test
    fun Array_Of_Food_Should_be_0() {
        var test = FeedAnimalsModel()
        test.beginGame()
        Assert.assertEquals(-1,test.getBoardOfFood().get(0))
        Assert.assertEquals(-1,test.getBoardOfFood().get(1))
        Assert.assertEquals(-1,test.getBoardOfFood().get(2))
    }
}