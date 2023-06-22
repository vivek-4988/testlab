package com.vivek.mvvmexample.api


import com.vivek.mvvmexample.BuildConfig
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetroFitHelper {

    val retrofit = Retrofit.Builder()
        .baseUrl(BuildConfig.API_END_POINT)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val api = retrofit.create(QuoteService::class.java)


}