package com.zinka.blackbuck.projectweather.models

data class LocationWeatherItem(
    val city: String,
    val humidity: String,
    val temparature: String,
    val weatherCondition: String,
    val windDirection: String,
    val windSpeed: String
)