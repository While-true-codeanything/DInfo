package com.example.dinfo.DtClassesAndOth


import MainCurrencyResponse
import MainNewsResponse
import android.widget.Toast
import com.example.dinfo.Activities.MainActivity
import com.example.dinfo.Fragments.MainPageFragment
import com.example.dinfo.HolidayResponse.MainHolidayResponse
import com.example.example.MainGeoResponse
import com.example.example.MainWeatherResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.*


class DataLoader {
    fun GetLocation(lat: Double, long: Double, ma: MainActivity) {
        val retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://geocode-maps.yandex.ru")
            .build()
        val service: Interfaces.GeoService =
            retrofit.create(Interfaces.GeoService::class.java)
        service.getLocation("$long,$lat").enqueue(object : Callback<MainGeoResponse> {
            override fun onResponse(
                call: Call<MainGeoResponse>,
                response: Response<MainGeoResponse>
            ) {
                AllAppData.GeoPositionLoaded = true
                AllAppData.GeoPosition =
                    response.body()?.response!!.GeoObjectCollection.featureMember[0].GeoObject.description
                if (AllAppData.isAllData()) ma.loadFragment(MainPageFragment())
            }

            override fun onFailure(call: Call<MainGeoResponse?>, t: Throwable?) {
                Toast.makeText(
                    ma, "Ошибка, проверьте подключение к интернету или доступность сервиса!",
                    Toast.LENGTH_LONG
                ).show()
            }
        })
    }

    fun GetWeather(lat: Double, lon: Double, ma: MainActivity) {
        val retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://api.met.no")
            .build()
        val service: Interfaces.WeatherService =
            retrofit.create(Interfaces.WeatherService::class.java)
        service.getWeather(lat.toString(), lon.toString())
            .enqueue(object : Callback<MainWeatherResponse> {
                override fun onResponse(
                    call: Call<MainWeatherResponse>,
                    response: Response<MainWeatherResponse>
                ) {
                    AllAppData.WeatherLoaded = true
                    AllAppData.WeatherItem = response.body()!!
                    if (AllAppData.isAllData()) ma.loadFragment(MainPageFragment())
                }

                override fun onFailure(call: Call<MainWeatherResponse>, t: Throwable) {
                    Toast.makeText(
                        ma, t.message,
                        Toast.LENGTH_LONG
                    ).show()
                }
            })
    }

    fun GetNews(lang: String, ma: MainActivity) {
        val retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://newsapi.org")
            .build()
        val service: Interfaces.NewsService =
            retrofit.create(Interfaces.NewsService::class.java)
        service.getNews(lang)
            .enqueue(object : Callback<MainNewsResponse> {
                override fun onResponse(
                    call: Call<MainNewsResponse>,
                    response: Response<MainNewsResponse>
                ) {
                    AllAppData.NewsLoaded = true
                    AllAppData.News = response.body()!!
                    if (AllAppData.isAllData()) ma.loadFragment(MainPageFragment())
                }

                override fun onFailure(call: Call<MainNewsResponse>, t: Throwable) {
                    Toast.makeText(
                        ma, t.message,
                        Toast.LENGTH_LONG
                    ).show()
                }
            })
    }

    fun GetCurrenccies(lang: String, ma: MainActivity) {
        val retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://api.exchangeratesapi.io")
            .build()
        val service: Interfaces.CurrenciesService =
            retrofit.create(Interfaces.CurrenciesService::class.java)
        service.getCurrencies(lang)
            .enqueue(object : Callback<MainCurrencyResponse> {
                override fun onResponse(
                    call: Call<MainCurrencyResponse>,
                    response: Response<MainCurrencyResponse>
                ) {
                    AllAppData.CurrenciesLoaded = true
                    AllAppData.CurrenciesBase = response.body()!!
                    if (AllAppData.isAllData()) ma.loadFragment(MainPageFragment())
                }

                override fun onFailure(call: Call<MainCurrencyResponse>, t: Throwable) {
                    Toast.makeText(
                        ma, t.message,
                        Toast.LENGTH_LONG
                    ).show()
                }
            })
    }
    fun GetHoliday(ma: MainActivity) {
        val retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://holidayapi.com")
            .build()
        val service: Interfaces.HolidayService =
            retrofit.create(Interfaces.HolidayService::class.java)
        service.getHoliday("ru",Calendar.getInstance()[Calendar.MONTH]+1,Calendar.getInstance()[Calendar.DAY_OF_MONTH])
            .enqueue(object : Callback<MainHolidayResponse> {
                override fun onResponse(
                    call: Call<MainHolidayResponse>,
                    response: Response<MainHolidayResponse>
                ) {
                    AllAppData.HolidayLoaded = true
                    AllAppData.Holidays = response.body()!!.holidays
                    if (AllAppData.isAllData()) ma.loadFragment(MainPageFragment())
                }

                override fun onFailure(call: Call<MainHolidayResponse>, t: Throwable) {
                    Toast.makeText(
                        ma, t.message,
                        Toast.LENGTH_LONG
                    ).show()
                }
            })
    }
}