package com.vivek.daggerexample

import android.util.Log
import javax.inject.Inject


//@Inject is equal to val com = Computer()

class Computer @Inject  constructor(var ram:RAM,var hd:HardDisk){

    fun getComputer(): Unit {
        ram.getRam()
        hd.getHardDisk()
        Log.d("main", "getComputer: ")
    }

}

class RAM @Inject  constructor(){

    fun getRam(): Unit {
        Log.d("main", "getRam: ")
    }

}

class HardDisk @Inject  constructor(){

    fun getHardDisk(): Unit {
        Log.d("main", "getHardDisk: ")
    }

}
