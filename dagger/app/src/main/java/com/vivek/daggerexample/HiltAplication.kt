package com.vivek.daggerexample

import android.app.Application
import com.vivek.daggerexample.interfaces.AppModule
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class HiltAplication : Application() {

    val main = AppModule.main

}