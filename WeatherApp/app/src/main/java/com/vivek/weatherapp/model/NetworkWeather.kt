package com.vivek.weatherapp.main.model

import com.google.gson.annotations.SerializedName


data class NetworkWeather(

    val uId: Int,

    @SerializedName("id")
    val cityId: Int,

    val name: String,

    val wind: Wind,

    @SerializedName("weather")
    val networkWeatherDescriptions: List<NetworkWeatherDescription>,

    @SerializedName("main")
    val networkWeatherCondition: NetworkWeatherCondition
)
