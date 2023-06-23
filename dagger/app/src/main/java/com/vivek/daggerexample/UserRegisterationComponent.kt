package com.vivek.daggerexample

import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@ApplicationScope
@Component(modules = [UserRepositoryModule::class,NotificationServiceModule::class])
interface UserRegisterationComponent {
/*

    fun getUserRegService():UserRegisterationService

    fun getEmailService():EmailService

    fun getUserRepo():UserRepository
*/
    fun injectAll(mainActivity: MainActivity)

}