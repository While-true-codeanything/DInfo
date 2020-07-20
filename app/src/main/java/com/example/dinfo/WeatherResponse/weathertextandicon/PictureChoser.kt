package com.example.dinfo.WeatherResponse.weathertextandicon

import com.example.dinfo.R

class PictureChoser {
    fun GetIconAndText(code: String): WTextAndIcon {
        return when (code) {
            "clearsky_day" -> {
                WTextAndIcon("Чистое небо", R.drawable.clearsky_day)
            }
            "clearsky_night" -> {
                WTextAndIcon("Чистое небо", R.drawable.clearsky_night)
            }
            "clearsky_polartwilight" -> {
                WTextAndIcon("Чистое небо", R.drawable.clearsky_polartwilight)
            }
            "cloudy" -> {
                WTextAndIcon("Облачно", R.drawable.cloudy)
            }
            "fair_day" -> {
                WTextAndIcon("Слабая обласность", R.drawable.fair_day)
            }
            "fair_night" -> {
                WTextAndIcon("Слабая обласность", R.drawable.fair_night)
            }
            "fair_polartwilight" -> {
                WTextAndIcon("Слабая обласность", R.drawable.fair_polartwilight)
            }
            "fog" -> {
                WTextAndIcon("Туман", R.drawable.fog)
            }
            "heavyrain" -> {
                WTextAndIcon("Сильный дождь", R.drawable.heavyrain)
            }
            "heavyrainandthunder" -> {
                WTextAndIcon("Сильный дождь с грозой", R.drawable.heavyrainandthunder)
            }
            "heavyrainshowers_day" -> {
                WTextAndIcon("Сильный дождь", R.drawable.heavyrainshowers_day)
            }
            "heavyrainshowers_night" -> {
                WTextAndIcon("Сильный дождь", R.drawable.heavyrainshowers_night)
            }
            "heavyrainshowers_polartwilight" -> {
                WTextAndIcon("Сильный дождь", R.drawable.heavyrainshowers_polartwilight)
            }
            "heavyrainshowersandthunder_day" -> {
                WTextAndIcon("Сильный дождь с грозой", R.drawable.heavyrainshowersandthunder_day)
            }
            "heavyrainshowersandthunder_night" -> {
                WTextAndIcon("Сильный дождь с грозой", R.drawable.heavyrainshowersandthunder_night)
            }
            "heavyrainshowersandthunder_polartwilight" -> {
                WTextAndIcon("Сильный дождь с грозой", R.drawable.heavyrainshowersandthunder_polartwilight)
            }
            "heavysleet" -> {
                WTextAndIcon("Мокрый снег с дождем", R.drawable.heavysleet)
            }
            "heavysleetandthunder" -> {
                WTextAndIcon("Мокрый снег с грозой", R.drawable.heavysleetandthunder)
            }
            "heavysleetshowers_day" -> {
                WTextAndIcon("Мокрый снег с дождем", R.drawable.heavysleetshowers_day)
            }
            "heavysleetshowers_night" -> {
                WTextAndIcon("Мокрый снег с дождем", R.drawable.heavysleetshowers_night)
            }
            "heavysleetshowers_polartwilight" -> {
                WTextAndIcon("Мокрый снег с дождем", R.drawable.heavysleetshowers_polartwilight)
            }
            "heavysleetshowersandthunder_day" -> {
                WTextAndIcon("Мокрый снег с грозой", R.drawable.heavysleetshowersandthunder_day)
            }
            "heavysleetshowersandthunder_night" -> {
                WTextAndIcon("Мокрый снег с грозой", R.drawable.heavysleetshowersandthunder_night)
            }
            "heavysleetshowersandthunder_polartwilight" -> {
                WTextAndIcon("Мокрый снег с грозой", R.drawable.heavysleetshowersandthunder_polartwilight)
            }
            "heavysnow" -> {
                WTextAndIcon("Снег", R.drawable.heavysnow)
            }
            "heavysnowandthunder" -> {
                WTextAndIcon("Снег с грозой", R.drawable.heavysnowandthunder)
            }
            "heavysnowshowers_day" -> {
                WTextAndIcon("Снег", R.drawable.heavysnowshowers_day)
            }
            "heavysnowshowers_night" -> {
                WTextAndIcon("Снег", R.drawable.heavysnowshowers_night)
            }
            "heavysnowshowers_polartwilight" -> {
                WTextAndIcon("Снег", R.drawable.heavysnowshowers_polartwilight)
            }
            "heavysnowshowersandthunder_day" -> {
                WTextAndIcon("Снег с грозой", R.drawable.heavysnowshowersandthunder_day)
            }
            "heavysnowshowersandthunder_night" -> {
                WTextAndIcon("Снег с грозой", R.drawable.heavysnowshowersandthunder_night)
            }
            "heavysnowshowersandthunder_polartwilight" -> {
                WTextAndIcon("Снег с грозой", R.drawable.heavysnowshowersandthunder_polartwilight)
            }
            "lightrain" -> {
                WTextAndIcon("Легкий дождь", R.drawable.lightrain)
            }
            "lightrainandthunder" -> {
                WTextAndIcon("Легкий дождь с грозой", R.drawable.lightrainandthunder)
            }
            "lightrainshowers_day" -> {
                WTextAndIcon("Легкий дождь", R.drawable.lightrainshowers_day)
            }
            "lightrainshowers_night" -> {
                WTextAndIcon("Легкий дождь", R.drawable.lightrainshowers_night)
            }
            "lightrainshowers_polartwilight" -> {
                WTextAndIcon("Легкий дождь", R.drawable.lightrainshowers_polartwilight)
            }
            "lightrainshowersandthunder_day" -> {
                WTextAndIcon("Легкий дождь с грозой", R.drawable.lightrainshowersandthunder_day)
            }
            "lightrainshowersandthunder_night" -> {
                WTextAndIcon("Легкий дождь с грозой", R.drawable.lightrainshowersandthunder_night)
            }
            "lightrainshowersandthunder_polartwilight" -> {
                WTextAndIcon("Легкий дождь с грозой", R.drawable.lightrainshowersandthunder_polartwilight)
            }
            else -> WTextAndIcon(code, R.drawable.weatherblank)
        }

    }
}