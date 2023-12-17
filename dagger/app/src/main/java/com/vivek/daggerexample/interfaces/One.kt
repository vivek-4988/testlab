package com.vivek.daggerexample.interfaces

import android.util.Log

interface One {
    fun one()
}

class ImplementOne : One{
    override fun one() {
        Log.d("main", "one calling: ")
    }
}

class Main constructor(private val one:One){

    fun main(){
        one.one()
    }
}


object AppModule{
    val main = Main(ImplementOne())
}