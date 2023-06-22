package com.vivek.daggerexample

import android.util.Log
import com.vivek.daggerexample.Constants.TAG
import javax.inject.Inject

class UserRegisterationService @Inject constructor(val userRepository: UserRepository,val emailService: EmailService) {

    fun register(email:String, password:String){
        Log.d(TAG, "register: ")
        userRepository.saveUesr()
        emailService.emailSend()

    }
}