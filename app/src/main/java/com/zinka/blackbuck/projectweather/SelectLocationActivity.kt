package com.zinka.blackbuck.projectweather

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

        initRecyclerView()
        initViewModel()

    }
    private fun initRecyclerView(){
        val recyclerview = findViewById<RecyclerView>(R.id.recyclerview)
        recyclerview.layoutManager = LinearLayoutManager(this)
        recyclerAdapter= CustomAdapter()
        recyclerview.adapter=recyclerAdapter

    }
    private fun initViewModel(){
        val viewModel = ViewModelProvider(this).get(RestViewModel::class.java)
        viewModel.getLocationWeatherMutableLiveData().observe(this, Observer {
                if(it!=null){
                    recyclerAdapter.setlocationlist(it)
                    recyclerAdapter.notifyDataSetChanged()
                    Log.d("Success",it.toString())
                }
            else{
                Toast.makeText(this,"Error in Fetching Locations",Toast.LENGTH_SHORT).show()
                }
        })
        viewModel.makeAPICall()

    }
}
