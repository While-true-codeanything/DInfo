package com.example.dinfo.Fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioGroup
import androidx.fragment.app.Fragment
import com.example.dinfo.*
import com.example.dinfo.WeatherResponse.weathertextandicon.PictureChoser
import com.example.example.Timeseries
import kotlinx.android.synthetic.main.settings_page.*
import kotlinx.android.synthetic.main.weather_page.*
import kotlinx.android.synthetic.main.weather_page.view.*
import java.text.SimpleDateFormat
import java.util.*

class WeatherFragment  : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.weather_page, container, false)
    }

    override fun onStart() {
        super.onStart()
        var curWeatherData: Timeseries? = null
        val sdf = SimpleDateFormat("dd HH")
        val currentDate = sdf.format(Date())
        val weatherlist=ArrayList<Timeseries>()
        for (i in 0..AllAppData.WeatherItem.properties.timeseries.size - 1) {
            val dtime: String =
                AllAppData.WeatherItem.properties.timeseries[i].time.split("T")[0].split("-")[2] + " " + AllAppData.WeatherItem.properties.timeseries[i].time.split(
                    "T"
                )[1].split(":")[0]
            if ((dtime.split(" ")[0].toInt()== currentDate.split(" ")[0].toInt())&& (dtime.split(" ")[1].toInt()>= currentDate.split(" ")[1].toInt())) weatherlist.add(AllAppData.WeatherItem.properties.timeseries[i])
        }
        this.activity!!.weather_rec.adapter=WeatherAdapter(weatherlist)
    }

}
