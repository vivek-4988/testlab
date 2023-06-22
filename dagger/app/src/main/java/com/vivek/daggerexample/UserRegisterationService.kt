package com.vivek.daggerexample

import android.util.Log
import com.vivek.daggerexample.Constants.TAG
import javax.inject.Inject
import javax.inject.Named

class UserRegisterationService @Inject constructor(
    val userRepository: UserRepository,
//    val emailService: EmailService
    @Named("msg") val notificationService: NotificationService
    ) {

    fun register(email:String, password:String){
        Log.d(TAG, "register: ")
        userRepository.saveUer(email, password)
        //emailService.emailSend()
        notificationService.send(email,"test@hotmail.com","my msg")
    }
}