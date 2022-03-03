package com.vivek.weatherapp.repo

import com.vivek.weatherapp.model.LocationModel
import com.vivek.weatherapp.model.NetworkWeather
import com.vivek.weatherapp.model.NetworkWeatherForecast


interface WeatherRemoteDataSource {
    suspend fun getWeather(location: LocationModel): Result<NetworkWeather>

    suspend fun getWeatherForecast(cityId: Int): Result<List<NetworkWeatherForecast>>

    suspend fun getSearchWeather(query: String): Result<NetworkWeather>
}