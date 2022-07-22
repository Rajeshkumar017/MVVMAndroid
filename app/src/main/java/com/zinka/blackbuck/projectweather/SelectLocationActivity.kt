package com.zinka.blackbuck.projectweather

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.zinka.blackbuck.projectweather.databinding.SelectLocationActivityBinding
import com.zinka.blackbuck.projectweather.network.RestViewModel
import com.zinka.blackbuck.projectweather.utils.Constants

class SelectLocationActivity : AppCompatActivity() {

    private lateinit var recyclerAdapter:CustomAdapter
    private lateinit var binding: SelectLocationActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = SelectLocationActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initRecyclerView()
        initViewModel()
    }

    private fun initRecyclerView() {
        binding.recyclerview.layoutManager = LinearLayoutManager(this)
//        binding.recyclerview.adapter = CustomAdapter()
    }

    private fun initViewModel() {
        val viewModel = ViewModelProvider(this).get(RestViewModel::class.java)
        viewModel.getLocationWeatherMutableLiveData().observe(this, Observer {
            if (it != null) {
                recyclerAdapter = CustomAdapter(it) {
                    val intent =
                        Intent(this@SelectLocationActivity, CityWeatherActivity::class.java)
                    intent.putExtra(Constants.CITY, it.city)
                    intent.putExtra(Constants.TEMPERATURE, it.temparature)
                    intent.putExtra(Constants.HUMIDITY, it.humidity)
                    intent.putExtra(Constants.WINDSPEED, it.windSpeed)
                    intent.putExtra(Constants.WINDDIRECTION, it.windDirection)
                    intent.putExtra(Constants.CONDITION, it.weatherCondition)
                    startActivity(intent)
                }
                recyclerAdapter.notifyDataSetChanged()
                binding.recyclerview.adapter = recyclerAdapter
                Log.d("Success", it.toString())
            } else {
                Toast.makeText(this, "Error in Fetching Locations", Toast.LENGTH_SHORT).show()
            }
        })
        viewModel.makeAPICall()
    }
}
