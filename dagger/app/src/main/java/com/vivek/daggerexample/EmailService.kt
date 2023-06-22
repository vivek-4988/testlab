package com.vivek.daggerexample

import android.util.Log
import com.vivek.daggerexample.Constants.TAG
import javax.inject.Inject


interface NotificationService{
    fun send(to:String,from:String,body:String)
}

class EmailService @Inject constructor():NotificationService{

    override fun send(to: String, from: String, body: String) {
        Log.d(TAG, "emailSend: ")
    }
}

class MessageService:NotificationService{
    override fun send(to: String, from: String, body: String) {

    }

}
