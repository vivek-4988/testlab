package com.vivek.unitinstrutesting.utils

class Utils {

    fun isPalindrome(input: String): Boolean {
        if (input.isEmpty()){
            return true
        }
//        if (input.length==1){
//            return false
//        }

        var i = 0
        var j = input.length - 1
        val result = true

        while (i < j) {
            if (input[i] != input[j]) {
                return false
            }
            i++
            j--
        }

        return result
    }
}