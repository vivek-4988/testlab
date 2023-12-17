package com.vivek.daggerexample.interfaces

import android.util.Log
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Inject
import javax.inject.Singleton

interface DemoOne {
    fun demoOne()
}

class DemoOneImplement @Inject constructor() : DemoOne {
    override fun demoOne() {
        Log.d("interface", "demoOne: ")
    }
}

class MaineOne @Inject constructor(private val demoOne: DemoOne) {

    fun mainOne() {
        demoOne.demoOne()
    }
}


@Module
@InstallIn(SingletonComponent::class)
abstract class AppModule2{

        @Binds
        @Singleton
        abstract fun providesOne(
            demoOneImplement: DemoOneImplement
        ):DemoOne



}