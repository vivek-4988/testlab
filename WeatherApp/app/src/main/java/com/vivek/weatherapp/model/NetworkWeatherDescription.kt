package com.vivek.weatherapp.main.model

import java.io.Serializable

data class NetworkWeatherDescription(
    val id: Long,
    val main: String?,
    val description: String?,
    val icon: String?
) : Serializable
