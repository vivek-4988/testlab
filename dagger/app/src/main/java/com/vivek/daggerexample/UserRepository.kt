package com.vivek.daggerexample

import android.util.Log
import com.vivek.daggerexample.Constants.TAG
import javax.inject.Inject


interface UserRepository{
    fun saveUer(email:String,password:String)
}

class SQlRepository @Inject constructor():UserRepository {
    override fun saveUer(email: String, password: String) {
        Log.d(TAG, "saveUesr: in sql ")
    }

}



class FirebaseRepo : UserRepository{
    override fun saveUer(email: String, password: String) {
        Log.d(TAG, "saveUesr: in firebase")
    }
}
