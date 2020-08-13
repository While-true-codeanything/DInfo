package com.example.dinfo.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.dinfo.DtClassesAndOth.AllAppData
import com.example.dinfo.R
import com.example.dinfo.WeatherResponse.weathertextandicon.PictureChoser
import com.example.example.Timeseries
import kotlinx.android.synthetic.main.news_header.view.*
import kotlinx.android.synthetic.main.weather_item.view.*

class WeatherAdapter(var Weatherlist: ArrayList<Timeseries>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder =
        WeatherHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.weatherandhead,
                parent,
                false
            )
        )

    override fun getItemCount(): Int = Weatherlist.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val holder = holder as WeatherHolder
        PictureChoser().GetIconAndText(Weatherlist[position].data.next1Hours.summary.symbolCode).Wtext
        holder.Temperature.text =
            Weatherlist[position].data.instant.details.airTemperature.toString() + "°, " + PictureChoser().GetIconAndText(
                Weatherlist[position].data.next1Hours.summary.symbolCode
            ).Wtext
        holder.Humidity.text = "Относительная влажность: "
            .plus(" " + Weatherlist[position].data.instant.details.relativeHumidity + AllAppData.WeatherItem.properties.meta.units.relativeHumidity)
        holder.Speed.text = "Скорость ветра:"
            .plus(" " + Weatherlist[position].data.instant.details.windSpeed + AllAppData.WeatherItem.properties.meta.units.windSpeed)
        holder.ico.setImageResource(PictureChoser().GetIconAndText(Weatherlist[position].data.next1Hours.summary.symbolCode).PicRes)
        holder.txt.text = Weatherlist[position].time.split("T")[1].replace("Z", "")
    }

    inner class WeatherHolder(root: View) :
        RecyclerView.ViewHolder(root) {
        val Temperature = root.Temperature
        val Humidity = root.humidity
        val Speed = root.windspeed
        val ico = root.weathericon
        val txt = root.headinfo
    }
}