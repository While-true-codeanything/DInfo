package com.example.dinfo

import MainNewsResponse
import com.example.example.MainWeatherResponse

class AllAppData {
    companion object{
        var GeoPositionLoaded:Boolean=false
        var WeatherLoaded:Boolean=false
        var NewsLoaded:Boolean=false
        lateinit var GeoPosition:String
        lateinit var WeatherItem:MainWeatherResponse
        lateinit var News:MainNewsResponse
        fun isAllData():Boolean = GeoPositionLoaded and WeatherLoaded and NewsLoaded
    }
}