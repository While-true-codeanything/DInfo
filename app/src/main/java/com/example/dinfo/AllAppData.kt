package com.example.dinfo

import MainCurrencyResponse
import MainNewsResponse
import com.example.example.MainWeatherResponse
import java.util.*
import kotlin.collections.ArrayList

class AllAppData {
    companion object{
        var GeoPositionLoaded:Boolean=false
        var WeatherLoaded:Boolean=false
        var NewsLoaded:Boolean=false
        var CurrenciesLoaded:Boolean=false
        lateinit var GeoPosition:String
        lateinit var WeatherItem:MainWeatherResponse
        lateinit var News:MainNewsResponse
        lateinit var CurrenciesBase:MainCurrencyResponse
        fun isAllData():Boolean = GeoPositionLoaded and WeatherLoaded and NewsLoaded and CurrenciesLoaded
    }
}