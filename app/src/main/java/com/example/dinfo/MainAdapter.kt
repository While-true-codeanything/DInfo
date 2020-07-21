package com.example.dinfo

import android.content.Intent
import android.net.Uri
import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView
import com.example.dinfo.WeatherResponse.weathertextandicon.PictureChoser
import com.example.example.Timeseries
import kotlinx.android.synthetic.main.currency_item.view.*
import kotlinx.android.synthetic.main.date_item.view.*
import kotlinx.android.synthetic.main.location_item.view.*
import kotlinx.android.synthetic.main.news_item.view.*
import kotlinx.android.synthetic.main.weather_item.view.*
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.util.*

class MainAdapter(var Main: MainActivity) :

    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    var position2 = -1

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        position2++
        return when (position2) {
            0 -> {
                DateHolder(
                    LayoutInflater.from(parent.context).inflate(
                        R.layout.date_item,
                        parent,
                        false
                    )
                )
            }
            1 -> {
                GeoHolder(
                    LayoutInflater.from(parent.context).inflate(
                        R.layout.location_item,
                        parent,
                        false
                    )
                )
            }
            2 -> {
                WeatherHolder(
                    LayoutInflater.from(parent.context).inflate(
                        R.layout.weather_item,
                        parent,
                        false
                    )
                )
            }
            3 -> {
                WeatherHolder(
                    LayoutInflater.from(parent.context).inflate(
                        R.layout.news_header,
                        parent,
                        false
                    )
                )
            }
            9 -> {
                WeatherHolder(
                    LayoutInflater.from(parent.context).inflate(
                        R.layout.currency_header,
                        parent,
                        false
                    )
                )
            }
            else -> {
                if (position2 < 9) {
                    NewsHolder(
                        LayoutInflater.from(parent.context).inflate(
                            R.layout.news_item,
                            parent,
                            false
                        )
                    )
                } else {
                    CurrenciesHolder(
                        LayoutInflater.from(parent.context).inflate(
                            R.layout.currency_item,
                            parent,
                            false
                        )
                    )

                }
            }
        }
    }

    override fun getItemCount(): Int = 12

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (position == 0) {
            val dwad = LocalDate.now()
            val holder = holder as DateHolder
            val d = weekday.values().get(dwad.dayOfWeek.value)
            holder.date.text = dwad.toString() + ", " + d.name
        }
        if (position == 1) {
            val holder = holder as GeoHolder
            holder.text.text = AllAppData.GeoPosition
        }
        if (position == 2) {
            var curWeatherData: Timeseries? = null
            val sdf = SimpleDateFormat("dd HH")
            val currentDate = sdf.format(Date())
            for (i in 0..AllAppData.WeatherItem.properties.timeseries.size - 1) {
                val dtime: String =
                    AllAppData.WeatherItem.properties.timeseries[i].time.split("T")[0].split("-")[2] + " " + AllAppData.WeatherItem.properties.timeseries[i].time.split(
                        "T"
                    )[1].split(":")[0]
                if (dtime == currentDate) curWeatherData =
                    AllAppData.WeatherItem.properties.timeseries[i]
            }
            val holder = holder as WeatherHolder
            PictureChoser().GetIconAndText(curWeatherData!!.data.next1Hours.summary.symbolCode).Wtext
            holder.Temperature.text =
                curWeatherData!!.data.instant.details.airTemperature.toString() + "°, " + PictureChoser().GetIconAndText(
                    curWeatherData.data.next1Hours.summary.symbolCode
                ).Wtext
            holder.Humidity.text = holder.Humidity.text.toString()
                .plus(" " + curWeatherData!!.data.instant.details.relativeHumidity + AllAppData.WeatherItem.properties.meta.units.relativeHumidity)
            holder.Speed.text = holder.Speed.text.toString()
                .plus(" " + curWeatherData!!.data.instant.details.windSpeed + AllAppData.WeatherItem.properties.meta.units.windSpeed)
            holder.ico.setImageResource(PictureChoser().GetIconAndText(curWeatherData.data.next1Hours.summary.symbolCode).PicRes)
        }
        if (position > 3 && position < 9) {
            val holder = holder as NewsHolder
            holder.date.text = AllAppData.News.articles[position - 4].title
            holder.date.setOnClickListener {
                Main.startActivity(
                    Intent(
                        Intent.ACTION_VIEW,
                        Uri.parse(AllAppData.News.articles[position - 4].url)
                    )
                )
            }
        }
        if (position > 9) {
            val holder = holder as CurrenciesHolder
            holder.info.text =
                "Курс " + AllAppData.CurrenciesBase.base + " к " + AllAppData.CurrenciesBase.rates.GetBase()[position - 10].name
            holder.data.text =
                AllAppData.CurrenciesBase.rates.GetBase()[position - 10].Course.toString()
        }
    }

    inner class DateHolder(root: View) :
        RecyclerView.ViewHolder(root) {
        val date = root.date
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
        val ico = root.weathericon
    }

    inner class NewsHolder(root: View) :
        RecyclerView.ViewHolder(root) {
        val date = root.NewsInfo
    }

    inner class CurrenciesHolder(root: View) :
        RecyclerView.ViewHolder(root) {
        val info = root.curinfo
        val data = root.curdata
    }
}