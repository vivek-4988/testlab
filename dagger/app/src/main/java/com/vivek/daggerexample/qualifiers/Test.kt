package com.vivek.daggerexample.qualifiers

import android.util.Log
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Inject
import javax.inject.Qualifier
import javax.inject.Singleton

class Test @Inject constructor(@fname var fname:String,
                               @lname var lname:String){

    fun getNames(){
        Log.d("qualifiers", "getNames: $fname $lname")
    }
}

@Module
@InstallIn(SingletonComponent::class)
object Modules{

    @Provides
    @fname
    fun providefName() = "vivek"

    @Provides
    @lname
    fun providelName() = "shah"
}


@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class fname

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class lname
