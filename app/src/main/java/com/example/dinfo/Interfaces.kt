package com.example.dinfo

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
        fun getArtilcles(
            @Path("lat") lat: Int,
            @Path("lon") lon: Int
        ): Call<String>// Здесь будет класс ответа
    }
    interface GeoService {
        @GET("https://geocode-maps.yandex.ru/1.x/?apikey=0e48661b-a37c-40d2-b35a-de0b3aeef557&format=json&geocode={lat},{lon}")
        fun getArtilcles(
            @Path("lat") lat: Int,
            @Path("lon") lon: Int
        ): Call<String>// Здесь будет класс ответа
    }
}