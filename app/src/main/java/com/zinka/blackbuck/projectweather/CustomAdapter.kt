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


class CustomAdapter() : RecyclerView.Adapter<CustomAdapter.ViewHolder>() {

    private var locationList : LocationWeather ?=null

    val arraylist = arrayListOf<String>("Bangalore","Hyderabad")


    fun setlocationlist(locationlist:LocationWeather?){
      this.locationList=locationList
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView= LayoutInflater.from(parent.context).inflate(R.layout.city_cardview_activity,parent,false)
        return  ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.cityName.text= locationList?.get(position)?.city
//        holder.cityName.text=arraylist[position].toString()
        Log.d("Success holder",holder.cityName.text.toString())
    }

    override fun getItemCount(): Int {
        if(locationList == null) return 0
        else return locationList?.size!!
//        return  arraylist.size

    }

    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        var cityName : TextView = itemView.findViewById(R.id.city)
    }
}
