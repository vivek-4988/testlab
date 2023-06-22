package com.vivek.daggerexample

import android.util.Log
import com.vivek.daggerexample.Constants.TAG
import javax.inject.Inject


class UserRepository @Inject constructor() {

    fun saveUesr(){
        Log.d(TAG, "saveUesr: ")
    }

}