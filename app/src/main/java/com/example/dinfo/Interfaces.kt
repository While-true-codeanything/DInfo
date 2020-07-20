package com.example.dinfo

import com.example.example.MainGeoResponse
import com.example.example.MainWeatherResponse
import retrofit2.Call
import retrofit2.http.*

class Interfaces {
    interface CurrencyService {
        @GET("https ://api.exchangeratesapi.io/latest")
        fun data(): Call<String> // Здесь будет класс ответа
    }
    interface WeatherService {
        @Headers("User-Agent: DInfo/0.5")
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
}