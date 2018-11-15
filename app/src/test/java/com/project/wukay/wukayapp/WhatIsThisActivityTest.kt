package com.project.wukay.wukayapp

import org.junit.Test

import org.junit.Assert.*

class WhatIsThisActivityTest {
    @Test
    fun should_return_true_if_we_put_right_answer_in_the_method_is_the_correct_answer(){
        var test = WhatIsThisActivity()

        var tab= IntArray(3)
        tab.set(0, 0)
        tab.set(1, 10)
        tab.set(2, 10)

        assertTrue(test.isTheCorrectAnswer(0,tab,0))

    }
}
