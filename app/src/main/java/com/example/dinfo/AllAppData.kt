package com.example.dinfo

import com.example.example.MainWeatherResponse

class AllAppData {
    companion object{
        var GeoPositionLoaded:Boolean=false
        var WeatherLoaded:Boolean=false
        lateinit var GeoPosition:String
        lateinit var WeatherItem:MainWeatherResponse
        fun isAllData():Boolean = GeoPositionLoaded and WeatherLoaded
    }
}