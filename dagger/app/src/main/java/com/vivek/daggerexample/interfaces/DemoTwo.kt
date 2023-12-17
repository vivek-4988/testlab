package com.vivek.daggerexample.interfaces

import android.util.Log
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Inject
import javax.inject.Singleton

interface DemoTwo {
    fun demoTwo()
}



class DemoTwoImplement @Inject constructor():DemoTwo{
    override fun demoTwo() {
        Log.d("interface", "demoTwo: ")
    }
}

class MainTwo @Inject constructor(private val demoTwoImplement: DemoTwoImplement){

    fun mainTwo(){
        demoTwoImplement.demoTwo()
    }
}

@Module
@InstallIn(SingletonComponent::class)
object AppModuleTwo{

    @Provides
    @Singleton
    fun providesDemo():DemoTwo = DemoTwoImplement()

}


