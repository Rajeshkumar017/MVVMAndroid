package com.zinka.blackbuck.projectweather

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.zinka.blackbuck.projectweather.models.LocationWeather
import com.zinka.blackbuck.projectweather.network.RestViewModel

class SelectLocationActivity : AppCompatActivity() {
    lateinit var recyclerAdapter:CustomAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.select_location_activity)

        initViewModel()
    }

    private fun initViewModel(){
        val viewModel = ViewModelProvider(this).get(RestViewModel::class.java)
        viewModel.getLocationWeatherMutableLiveData().observe(this, Observer {
                if(it!=null){
                    recyclerAdapter = CustomAdapter(it) {
                        val intent = Intent(this@SelectLocationActivity, CityWeatherActivity::class.java)
                        intent.putExtra("City", it.city)
                        intent.putExtra("Temperature", it.temparature)
                        intent.putExtra("Humidity", it.humidity)
                        intent.putExtra("WindSpeed", it.windSpeed)
                        intent.putExtra("WindDirection", it.windDirection)
                        intent.putExtra("Condition", it.weatherCondition)
                        startActivity(intent)
                    }
                    recyclerAdapter.notifyDataSetChanged()
                    val recyclerview = findViewById<RecyclerView>(R.id.recyclerview)
                    recyclerview.layoutManager = LinearLayoutManager(this)
                    recyclerview.adapter=recyclerAdapter
                    Log.d("Success",it.toString())
                }
            else{
                Toast.makeText(this,"Error in Fetching Locations",Toast.LENGTH_SHORT).show()
                }
        })
        viewModel.makeAPICall()
    }
}
