package com.zinka.blackbuck.projectweather.network

import com.zinka.blackbuck.projectweather.models.LocationWeather
import retrofit2.Response
import retrofit2.http.GET


interface RestService {

    @GET("https://spring-weather-app.herokuapp.com/all")
    suspend fun getLocationsWeather(): Response<LocationWeather>
}