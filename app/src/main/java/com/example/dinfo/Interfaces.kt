package com.example.dinfo

import com.example.example.MainGeoResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

class Interfaces {
    interface CurrencyService {
        @GET("https ://api.exchangeratesapi.io/latest")
        fun data(): Call<String> // Здесь будет класс ответа
    }
    interface WeatherService {
        @GET("https://api.met.no/weatherapi/locationforecast/2.0/compact?lat={lat}&lon={lon}")
        fun getWeather(
            @Path("lat") lat: Double,
            @Path("lon") lon: Double
        ): Call<String>// Здесь будет класс ответа
    }
    interface GeoService {
        @GET("/1.x/?apikey=0e48661b-a37c-40d2-b35a-de0b3aeef557&format=json")
        fun getLocation(
            @Query("geocode") data: String
        ): Call<MainGeoResponse>
    }
}