package com.zinka.blackbuck.projectweather

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.zinka.blackbuck.projectweather.databinding.CityWeatherActivityBinding
import com.zinka.blackbuck.projectweather.utils.Constants

class CityWeatherActivity: AppCompatActivity() {

    lateinit var binding: CityWeatherActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = CityWeatherActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val changeLocationBtn: Button = binding.button2;
        changeLocationBtn.setOnClickListener {
            val intent = Intent(this, SelectLocationActivity::class.java);
            startActivity(intent);
        }
        binding.cityname.text = intent.getStringExtra(Constants.CITY)
        binding.temperature.text = intent.getStringExtra(Constants.TEMPERATURE)
        binding.humidity.text = intent.getStringExtra(Constants.HUMIDITY)
        binding.windSpeed.text = intent.getStringExtra(Constants.WINDSPEED)
        binding.windDirection.text = intent.getStringExtra(Constants.WINDDIRECTION)
        binding.condition.text = intent.getStringExtra(Constants.CONDITION)
    }
}