package com.example.dinfo

import Json4Kotlin_Base
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

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
        @GET("https://geocode-maps.yandex.ru/1.x/?apikey=0e48661b-a37c-40d2-b35a-de0b3aeef557&format=json&geocode={lat},{lon}")
        fun getLocation(
            @Path("lat") lat: Double,
            @Path("lon") lon: Double
        ): Call<Json4Kotlin_Base>
    }
}