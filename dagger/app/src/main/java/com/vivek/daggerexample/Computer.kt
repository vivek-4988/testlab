package com.vivek.daggerexample

import android.util.Log
import javax.inject.Inject


//@Inject is equal to val com = Computer()

class Computer @Inject  constructor(){

    fun getComputer(): Unit {
        Log.d("main", "getComputer: ")
    }

}


