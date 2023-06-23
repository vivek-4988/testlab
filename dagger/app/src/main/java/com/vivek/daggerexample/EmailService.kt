package com.vivek.daggerexample

import android.util.Log
import com.vivek.daggerexample.Constants.TAG
import javax.inject.Inject
import javax.inject.Singleton


interface NotificationService{
    fun send(to:String,from:String,body:String)
}
@ApplicationScope
class EmailService @Inject constructor():NotificationService{

    override fun send(to: String, from: String, body: String) {
        Log.d(TAG, "emailSend: ")
    }
}

class MessageService(retry:Int):NotificationService{
    override fun send(to: String, from: String, body: String) {
        Log.d(TAG, "msg sent: "+return)
    }

}
