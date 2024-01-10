package com.vivek.unitinstrutesting.utils

import org.junit.After
import org.junit.Assert.*
import org.junit.Before

import org.junit.Test

class UtilsTest {

   lateinit var utils : Utils

    @Before
    fun setUp(){
        println("before test")
        utils = Utils()
    }

    @After
    fun teadDown(){
        println("after test")
    }

    @Test
    fun isPalindrome() {
        //arange
        //act
        //assert

        //hello , then ""
        val result = utils.isPalindrome("hello")
        //assert
        assertEquals(false,result)

    }

    @Test
    fun isPalindrome_should_true() {
        //arange
        //act
        //assert
        //try level , then "a"
        val result = utils.isPalindrome("level")
        //assert
        assertEquals(true,result)

    }
}