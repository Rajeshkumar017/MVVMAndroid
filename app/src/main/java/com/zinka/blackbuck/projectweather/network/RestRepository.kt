package com.zinka.blackbuck.projectweather.network



class RestRepository () {

    private val restService = RestHelper.getRetrofit().create(RestService::class.java)

    suspend fun getLocationsWeather() = restService.getLocationsWeather()
}