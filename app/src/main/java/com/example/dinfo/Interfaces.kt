package com.example.dinfo

import MainCurrencyResponse
import MainNewsResponse
import com.example.example.MainGeoResponse
import com.example.example.MainWeatherResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

class Interfaces {

    interface CurrencyService {
        @GET("https ://api.exchangeratesapi.io/latest")
        fun data(): Call<String> // Здесь будет класс ответа
    }

    interface WeatherService {
        @Headers("User-Agent: DInfo/1.1")
        @GET("/weatherapi/locationforecast/2.0/compact?")
        fun getWeather(
            @Query("lat") lat: String,
            @Query("lon") lon: String
        ): Call<MainWeatherResponse>
    }

    interface GeoService {
        @GET("/1.x/?apikey=0e48661b-a37c-40d2-b35a-de0b3aeef557&format=json")
        fun getLocation(
            @Query("geocode") data: String
        ): Call<MainGeoResponse>
    }

    interface NewsService {
        @GET("/v2/top-headlines?apiKey=ccbb3cf822804182accd4dc5ed9c6e3d&format=json")
        fun getNews(
            @Query("country") data: String
        ): Call<MainNewsResponse>
    }

    interface CurrenciesService {
        @GET("/latest")
        fun getCurrencies(
            @Query("base") data: String
        ): Call<MainCurrencyResponse>
    }
}