package com.zinka.blackbuck.projectweather

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.zinka.blackbuck.projectweather.models.LocationWeather
import com.zinka.blackbuck.projectweather.models.LocationWeatherItem


class CustomAdapter(val allLocationslist : LocationWeather, val onClickCallback :  (LocationWeatherItem) -> Unit) : RecyclerView.Adapter<CustomAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView= LayoutInflater.from(parent.context).inflate(R.layout.city_cardview_activity,parent,false)
        return  ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.cityName.text= allLocationslist[position].city
        holder.itemView.setOnClickListener { v ->
            onClickCallback.invoke(allLocationslist[position])
        }
        Log.d("Success holder",holder.cityName.text.toString())
    }

    override fun getItemCount(): Int {
        if(allLocationslist == null) return 0
        else return allLocationslist?.size!!
    }

    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        var cityName : TextView = itemView.findViewById(R.id.city)
    }
}
