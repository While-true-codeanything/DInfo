package com.example.dinfo

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.example.Timeseries
import kotlinx.android.synthetic.main.location_item.view.*
import kotlinx.android.synthetic.main.weather_item.view.*
import java.text.SimpleDateFormat
import java.util.*

class MainAdapter :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    var position2 = -1

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        position2++
        return when (position2) {
            0 -> {
                GeoHolder(
                    LayoutInflater.from(parent.context).inflate(
                        R.layout.location_item,
                        parent,
                        false
                    )
                )
            }
            1 -> {
                WeatherHolder(
                    LayoutInflater.from(parent.context).inflate(
                        R.layout.weather_item,
                        parent,
                        false
                    )
                )
            }
            else -> {
                GeoHolder(
                    LayoutInflater.from(parent.context)
                        .inflate(R.layout.weather_item, parent, false)//пока не нужно
                )
            }
        }
    }

    override fun getItemCount(): Int = 2

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (position == 0) {
            val holder = holder as GeoHolder
            holder.text.text=AllAppData.GeoPosition
        }
        if (position == 1) {
            var curWeatherData: Timeseries? =null
            val sdf = SimpleDateFormat("dd hh")
            val currentDate = sdf.format(Date())
            for(i in 0..AllAppData.WeatherItem.properties.timeseries.size-1){
                val dtime:String= AllAppData.WeatherItem.properties.timeseries[i].time.split("T")[0].split("-")[2]+" "+AllAppData.WeatherItem.properties.timeseries[i].time.split("T")[1].split(":")[0]
                if(dtime == currentDate) curWeatherData= AllAppData.WeatherItem.properties.timeseries[i]
            }
            val holder = holder as WeatherHolder
            holder.Temperature.text=  curWeatherData!!.data.instant.details.airTemperature.toString()+"°, "+curWeatherData.data.next1Hours.summary.symbolCode
            holder.Humidity.text=holder.Humidity.text.toString().plus(" "+curWeatherData!!.data.instant.details.relativeHumidity+AllAppData.WeatherItem.properties.meta.units.relativeHumidity)
            holder.Speed.text=holder.Speed.text.toString().plus(" "+curWeatherData!!.data.instant.details.windSpeed+AllAppData.WeatherItem.properties.meta.units.windSpeed)
        }
    }


    inner class GeoHolder(root: View) :
        RecyclerView.ViewHolder(root) {
        val text = root.geotext
    }
    inner class WeatherHolder(root: View) :
        RecyclerView.ViewHolder(root) {
        val Temperature = root.Temperature
        val Humidity = root.humidity
        val Speed = root.windspeed
    }
}