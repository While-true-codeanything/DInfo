package com.example.dinfo.DtClassesAndOth

import MainCurrencyResponse
import MainNewsResponse
import com.example.dinfo.HolidayResponse.Holidays
import com.example.example.MainWeatherResponse

class AllAppData {
    companion object {
        var GeoPositionLoaded: Boolean = false
        var WeatherLoaded: Boolean = false
        var NewsLoaded: Boolean = false
        var CurrenciesLoaded: Boolean = false
        var HolidayLoaded: Boolean = false
        lateinit var latitude:String
        lateinit var longitude:String
        lateinit var GeoPosition: String
        lateinit var WeatherItem: MainWeatherResponse
        lateinit var News: MainNewsResponse
        lateinit var CurrenciesBase: MainCurrencyResponse
        lateinit var Holidays: List<Holidays>
        fun isAllData(): Boolean =
            GeoPositionLoaded and WeatherLoaded and NewsLoaded and CurrenciesLoaded and HolidayLoaded
    }
}