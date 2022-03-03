package com.vivek.weatherapp.main.model

import com.google.gson.annotations.SerializedName
import com.vivek.weatherapp.main.model.NetworkWeatherCondition
import com.vivek.weatherapp.main.model.NetworkWeatherDescription
import com.vivek.weatherapp.main.model.Wind

data class NetworkWeatherForecast(

    val id: Int,

    @SerializedName("dt_txt")
    val date: String,

    val wind: Wind,

    @SerializedName("weather")
    val networkWeatherDescription: List<NetworkWeatherDescription>,

    @SerializedName("main")
    val networkWeatherCondition: NetworkWeatherCondition
)
