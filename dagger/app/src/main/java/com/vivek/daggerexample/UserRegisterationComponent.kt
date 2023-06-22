package com.vivek.daggerexample

import dagger.Component

@Component
interface UserRegisterationComponent {

    fun getUserRegService():UserRegisterationService

    fun getEmailService():EmailService

    fun getUserRepo():UserRepository

}