package com.vivek.daggerexample

import dagger.Component

@Component(modules = [UserRepositoryModule::class,NotificationServiceModule::class])
interface UserRegisterationComponent {
/*

    fun getUserRegService():UserRegisterationService

    fun getEmailService():EmailService

    fun getUserRepo():UserRepository
*/
    fun injectAll(mainActivity: MainActivity)

}