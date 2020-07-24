package com.example.dinfo.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.dinfo.Activities.MainActivity
import com.example.dinfo.DtClassesAndOth.AllAppData
import com.example.dinfo.DtClassesAndOth.CurrencydateItem
import com.example.dinfo.DtClassesAndOth.MemoryAccesser
import com.example.dinfo.DtClassesAndOth.weekday
import com.example.dinfo.Fragments.WebFragment
import com.example.dinfo.Notifications.NotificationObject
import com.example.dinfo.R
import com.example.dinfo.WeatherResponse.weathertextandicon.PictureChoser
import com.example.example.Timeseries
import kotlinx.android.synthetic.main.currency_item.view.*
import kotlinx.android.synthetic.main.date_item.view.*
import kotlinx.android.synthetic.main.holiday_item.view.*
import kotlinx.android.synthetic.main.location_item.view.*
import kotlinx.android.synthetic.main.news_item.view.*
import kotlinx.android.synthetic.main.notifications_item.view.*
import kotlinx.android.synthetic.main.weather_item.view.*
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

class MainAdapter(var Main: MainActivity) :

    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    var CurData: ArrayList<CurrencydateItem>
    var ColNot: Int
    var NotData: ArrayList<NotificationObject>
    var HolidayCount: Int

    init {
        val a = MemoryAccesser(Main)
        ColNot = a.getSettings(MemoryAccesser.NewsNum).toInt()
        CurData = a.getCur()
        val k = a.getNotifications()
        NotData = ArrayList()
        for (i in 0..k.size - 1) {
            if (Calendar.getInstance()[Calendar.DAY_OF_MONTH].toString() + " " + (Calendar.getInstance()[Calendar.MONTH] + 1).toString() + " " + Calendar.getInstance()[Calendar.YEAR].toString() == k[i].dateon) {
                NotData.add(k[i])
            }
            if ((Calendar.getInstance()[Calendar.DAY_OF_MONTH] > k[i].dateon.split(" ")[0].toInt() && (Calendar.getInstance()[Calendar.MONTH] + 1) + 1 == k[i].dateon.split(
                    " "
                )[2].toInt() && Calendar.getInstance()[Calendar.YEAR] == k[i].dateon.split(" ")[2].toInt()) || ((Calendar.getInstance()[Calendar.MONTH] + 1) > k[i].dateon.split(
                    " "
                )[1].toInt() && Calendar.getInstance()[Calendar.YEAR] == k[i].dateon.split(" ")[2].toInt()) || Calendar.getInstance()[Calendar.YEAR] > k[i].dateon.split(
                    " "
                )[2].toInt()
            ) k.removeAt(i)
        }
        a.setNotifications(k)
        HolidayCount = 1
        if (!AllAppData.Holidays.isEmpty()) HolidayCount += (AllAppData.Holidays.size - 1)
    }

    override fun getItemViewType(position: Int): Int {
        if (position == 0) return 0
        if (position == 1) return 1
        if (position == 2) return 2
        if (position == 3) return 3
        if (position > 3 && position < 4 + ColNot) return 4
        if (position == 4 + ColNot) return 5
        if (position > 4 + ColNot && position < 5 + ColNot + CurData.size) return 6
        if (position == 5 + ColNot + CurData.size) return 7
        if (position > 5 + ColNot + CurData.size && position < 6 + ColNot + CurData.size + NotData.size) return 8
        if (position >= 6 + ColNot + CurData.size + NotData.size) return 9
        return 99
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
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
            4 -> {
                NewsHolder(
                    LayoutInflater.from(parent.context).inflate(
                        R.layout.news_item,
                        parent,
                        false
                    )
                )
            }
            5 -> {
                WeatherHolder(
                    LayoutInflater.from(parent.context).inflate(
                        R.layout.currency_header,
                        parent,
                        false
                    )
                )
            }
            6 -> {
                CurrenciesHolder(
                    LayoutInflater.from(parent.context).inflate(
                        R.layout.currency_item,
                        parent,
                        false
                    )
                )
            }
            7 -> {
                WeatherHolder(
                    LayoutInflater.from(parent.context).inflate(
                        R.layout.notification_header,
                        parent,
                        false
                    )
                )
            }
            8 -> {
                NotificationHolder(
                    LayoutInflater.from(parent.context).inflate(
                        R.layout.notifications_item,
                        parent,
                        false
                    )
                )
            }
            9 -> {
                HolidayHolder(
                    LayoutInflater.from(parent.context).inflate(
                        R.layout.holiday_item,
                        parent,
                        false
                    )
                )
            }
            else -> {
                CurrenciesHolder(
                    LayoutInflater.from(parent.context).inflate(
                        R.layout.currency_header,
                        parent,
                        false
                    )
                )

            }
        }
    }

    override fun getItemCount(): Int = 6 + ColNot + CurData.size + NotData.size + HolidayCount


    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (position == 0) {
            val dwad =
                Calendar.getInstance()[Calendar.DAY_OF_MONTH].toString() + " " + (Calendar.getInstance()[Calendar.MONTH] + 1).toString() + " " + Calendar.getInstance()[Calendar.YEAR].toString()
            val holder = holder as DateHolder
            var k = Calendar.getInstance()[Calendar.DAY_OF_WEEK]
            if (k != 0) k -= 1
            val d = weekday.values().get(k)
            holder.date.text = dwad + ", " + d.name
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
                curWeatherData.data.instant.details.airTemperature.toString() + "°, " + PictureChoser().GetIconAndText(
                    curWeatherData.data.next1Hours.summary.symbolCode
                ).Wtext
            holder.Humidity.text = "Относительная влажность:"
                .plus(" " + curWeatherData.data.instant.details.relativeHumidity + AllAppData.WeatherItem.properties.meta.units.relativeHumidity)
            holder.Speed.text = "Скорость ветра:"
                .plus(" " + curWeatherData.data.instant.details.windSpeed + AllAppData.WeatherItem.properties.meta.units.windSpeed)
            holder.ico.setImageResource(PictureChoser().GetIconAndText(curWeatherData.data.next1Hours.summary.symbolCode).PicRes)
        }
        if (position > 3 && position < 4 + ColNot) {
            val holder = holder as NewsHolder
            holder.date.text = AllAppData.News.articles[position - 4].title
            holder.date.setOnClickListener {
                Main.loadFragment(WebFragment(AllAppData.News.articles[position - 4].url))
            }
        }
        if (position > 4 + ColNot && position < 5 + ColNot + CurData.size) {
            val holder = holder as CurrenciesHolder
            holder.info.text =
                "Курс " + CurData[position - (5 + ColNot)].frm + " к " + CurData[position - (5 + ColNot)].to
            var a = Main.resources.getStringArray(R.array.cur)
            var fr: Double = 1.0
            var to: Double = 1.0
            for (i in 0..a.size - 1) {
                if (a[i] == CurData[position - (5 + ColNot)].frm) {
                    if (i == a.size - 1) fr = 1.0
                    else fr = AllAppData.CurrenciesBase.rates.GetBase()[i].Course
                }
                if (a[i] == CurData[position - (5 + ColNot)].to) {
                    if (i == a.size - 1) to = 1.0
                    else to = AllAppData.CurrenciesBase.rates.GetBase()[i].Course
                }
            }
            holder.data.text =
                String.format("%.2f", ((1 / fr) / (1 / to)))
        }
        if (position > 5 + ColNot + CurData.size && position < 6 + ColNot + CurData.size + NotData.size) {
            val holder = holder as NotificationHolder
            holder.body.text = NotData[position - (6 + ColNot + CurData.size)].body
            holder.head.text = NotData[position - (6 + ColNot + CurData.size)].head
            holder.fromdt.text =
                "Дата добавления: " + NotData[position - (6 + ColNot + CurData.size)].datefrom
        }
        if (position >= 6 + ColNot + CurData.size + NotData.size) {
            val holder = holder as HolidayHolder
            if (!AllAppData.Holidays.isEmpty()) {
                val txt =
                    "Сегодня " + AllAppData.Holidays[position - (6 + ColNot + CurData.size + NotData.size)].name
                holder.hol.text = txt
            }
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

    inner class NotificationHolder(root: View) :
        RecyclerView.ViewHolder(root) {
        val head = root.nthead
        val body = root.ntbody
        val fromdt = root.fromdt
    }

    inner class HolidayHolder(root: View) :
        RecyclerView.ViewHolder(root) {
        val hol = root.holitem
    }
}