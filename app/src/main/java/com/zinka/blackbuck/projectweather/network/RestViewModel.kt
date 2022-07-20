package com.zinka.blackbuck.projectweather.network

import android.provider.SyncStateContract
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.zinka.blackbuck.projectweather.models.LocationWeather
import kotlinx.coroutines.launch

class RestViewModel : ViewModel() {

    private val restRepository = RestRepository()

    private val locationWeatherMutableLiveData = MutableLiveData<LocationWeather>()
    fun getLocationWeatherMutableLiveData(): LiveData<LocationWeather> = locationWeatherMutableLiveData

    fun makeAPICall() = viewModelScope.launch{

        val response = restRepository.getLocationsWeather()

        if (response.isSuccessful) {
            locationWeatherMutableLiveData.postValue(response.body())
            Log.d("data",getLocationWeatherMutableLiveData().toString())
        } else {
            locationWeatherMutableLiveData.postValue(null)
        }
    }


}