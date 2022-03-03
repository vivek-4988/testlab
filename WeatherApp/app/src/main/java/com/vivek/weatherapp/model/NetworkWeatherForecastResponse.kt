package com.vivek.weatherapp.main.model

import com.google.gson.annotations.SerializedName
import com.vivek.weatherapp.main.model.City
import com.vivek.weatherapp.main.model.NetworkWeatherForecast

data class NetworkWeatherForecastResponse(

    @SerializedName("list")
    val weathers: List<NetworkWeatherForecast>,

    val city: City
)
