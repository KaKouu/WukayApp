package com.project.wukay.wukayapp

import com.project.wukay.wukayapp.metier.FeedAnimalsModel
import org.junit.Assert
import org.junit.Test

class FeedAnimalsTest {

    @Test
    fun array_of_food_should_be_0() {
        var test = FeedAnimalsModel()
        test.beginGame()
        Assert.assertEquals(0, test.getBoardOfFood().get(0))
        Assert.assertEquals(0, test.getBoardOfFood().get(1))
        Assert.assertEquals(0, test.getBoardOfFood().get(2))
    }

    @Test
    fun bord_of_animals_should_be_inferior_1() {
        var test = FeedAnimalsModel()
        test.beginGame()
        Assert.assertEquals(-1, test.getBoardOfAnimals().get(0))
        Assert.assertEquals(-1, test.getBoardOfAnimals().get(1))
        Assert.assertEquals(-1, test.getBoardOfAnimals().get(2))
    }

    @Test
    fun bord_of_position_should_be_inferior_1() {
        var test = FeedAnimalsModel()
        test.beginGame()
        Assert.assertEquals(-1, test.getBoardOfPosition().get(0))
        Assert.assertEquals(-1, test.getBoardOfPosition().get(1))
        Assert.assertEquals(-1, test.getBoardOfPosition().get(2))
    }

    @Test
    fun is_true_when_3_good_answer() {
        var test = FeedAnimalsModel()
        test.animalWasFeed(0)
        test.animalWasFeed(1)
        test.animalWasFeed(2)
        test.isWin()
        Assert.assertTrue(test.isWin())
    }

    @Test
    fun is_false_when_not_3_good_answer() {
        var test = FeedAnimalsModel()
        test.animalWasFeed(0)
        test.animalWasFeed(1)
        test.isWin()
        Assert.assertFalse(test.isWin())
    }
}