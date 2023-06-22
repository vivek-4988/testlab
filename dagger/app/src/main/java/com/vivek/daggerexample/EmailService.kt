package com.vivek.daggerexample

import android.util.Log
import com.vivek.daggerexample.Constants.TAG
import javax.inject.Inject

class EmailService @Inject constructor(){

    fun emailSend(){
        Log.d(TAG, "emailSend: ")
    }
}