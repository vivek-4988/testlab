package com.vivek.weatherapp.main.model

data class WeatherForecast(
    val uID: Int,
    val date: String,
    val wind: Wind,
    val networkWeatherDescription: List<NetworkWeatherDescription>,

    val networkWeatherCondition: NetworkWeatherCondition
)
