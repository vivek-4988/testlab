package com.vivek.retrofitcoroutine.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetroHelper {

    val baseUrl = "https://quotable.io/"

    public fun getInstance(): Retrofit {
        return Retrofit.Builder().baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}