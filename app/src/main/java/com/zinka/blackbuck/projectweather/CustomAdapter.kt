package com.zinka.blackbuck.projectweather

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.zinka.blackbuck.projectweather.databinding.CityCardviewActivityBinding
import com.zinka.blackbuck.projectweather.models.LocationWeather
import com.zinka.blackbuck.projectweather.models.LocationWeatherItem


class CustomAdapter(private val allLocationslist : LocationWeather, private val onClickCallback :  (LocationWeatherItem) -> Unit) : RecyclerView.Adapter<CustomAdapter.ViewHolder>() {

    class ViewHolder(private val binding: CityCardviewActivityBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(get: LocationWeatherItem) {
            binding.city.text = get.city
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = CityCardviewActivityBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(allLocationslist[position])
        holder.itemView.setOnClickListener { v ->
            onClickCallback.invoke(allLocationslist[position])
        }
//        Log.d("Success holder",holder.cityName.text.toString())
    }

    override fun getItemCount(): Int {
        return allLocationslist.size
    }
}
