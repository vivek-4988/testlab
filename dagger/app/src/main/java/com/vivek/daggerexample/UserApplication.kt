package com.vivek.daggerexample

import android.app.Application

class UserApplication :Application() {

    lateinit var userRegisterationComponent: UserRegisterationComponent

    override fun onCreate() {
        super.onCreate()
        userRegisterationComponent =DaggerUserRegisterationComponent.builder()
            .notificationServiceModule(NotificationServiceModule(3))
            .build();
    }

}