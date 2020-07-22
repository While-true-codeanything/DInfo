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
                WTextAndIcon("Слабая облачность", R.drawable.fair_day)
            }
            "fair_night" -> {
                WTextAndIcon("Слабая облачность", R.drawable.fair_night)
            }
            "fair_polartwilight" -> {
                WTextAndIcon("Слабая облачность", R.drawable.fair_polartwilight)
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
                WTextAndIcon(
                    "Мокрый снег с грозой",
                    R.drawable.heavysleetshowersandthunder_polartwilight
                )
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
                WTextAndIcon(
                    "Легкий дождь с грозой",
                    R.drawable.lightrainshowersandthunder_polartwilight
                )
            }
            "lightsleet" -> {
                WTextAndIcon("Легкий мокрый снег", R.drawable.lightsleet)
            }
            "lightsleetandthunder" -> {
                WTextAndIcon("Легкий мокрый снег с грозой", R.drawable.lightsleetandthunder)
            }
            "lightsleetshowers_day" -> {
                WTextAndIcon("Легкий мокрый снег", R.drawable.lightsleetshowers_day)
            }
            "lightsleetshowers_night" -> {
                WTextAndIcon("Легкий мокрый снег", R.drawable.lightsleetshowers_night)
            }
            "lightsleetshowers_polartwilight" -> {
                WTextAndIcon("Легкий мокрый снег", R.drawable.lightsleetshowers_polartwilight)
            }
            "lightsnow" -> {
                WTextAndIcon("Легкий снег", R.drawable.lightsnow)
            }
            "lightsnowandthunder" -> {
                WTextAndIcon("Легкий снег с грозой", R.drawable.lightsnowandthunder)
            }
            "lightsnowshowers_day" -> {
                WTextAndIcon("Легкий снег", R.drawable.lightsnowshowers_day)
            }
            "lightsnowshowers_night" -> {
                WTextAndIcon("Легкий снег", R.drawable.lightsnowshowers_night)
            }
            "lightsnowshowers_polartwilight" -> {
                WTextAndIcon("Легкий снег", R.drawable.lightsnowshowers_polartwilight)
            }
            "lightssleetshowersandthunder_day" -> {
                WTextAndIcon(
                    "Легкий мокрый снег с грозой",
                    R.drawable.lightssleetshowersandthunder_day
                )
            }
            "lightssleetshowersandthunder_night" -> {
                WTextAndIcon(
                    "Легкий мокрый снег с грозой",
                    R.drawable.lightssleetshowersandthunder_night
                )
            }
            "lightssleetshowersandthunder_polartwilight" -> {
                WTextAndIcon(
                    "Легкий мокрый снег с грозой",
                    R.drawable.lightssleetshowersandthunder_polartwilight
                )
            }
            "lightssnowshowersandthunder_day" -> {
                WTextAndIcon("Легкий снег с грозой", R.drawable.lightssnowshowersandthunder_day)
            }
            "lightssnowshowersandthunder_night" -> {
                WTextAndIcon("Легкий снег с грозой", R.drawable.lightssnowshowersandthunder_night)
            }
            "lightssnowshowersandthunder_polartwilight" -> {
                WTextAndIcon(
                    "Легкий снег с грозой",
                    R.drawable.lightssnowshowersandthunder_polartwilight
                )
            }
            "partlycloudy_day" -> {
                WTextAndIcon("Облачно", R.drawable.partlycloudy_day)
            }
            "partlycloudy_night" -> {
                WTextAndIcon("Облачно", R.drawable.partlycloudy_night)
            }
            "partlycloudy_polartwilight" -> {
                WTextAndIcon("Облачно", R.drawable.partlycloudy_polartwilight)
            }
            "rain" -> {
                WTextAndIcon("Дождь", R.drawable.rain)
            }
            "rainandthunder" -> {
                WTextAndIcon("Дождь с грозой", R.drawable.rainandthunder)
            }
            "rainshowers_day" -> {
                WTextAndIcon("Дождь", R.drawable.rainshowers_day)
            }
            "rainshowers_night" -> {
                WTextAndIcon("Дождь", R.drawable.rainshowers_night)
            }
            "rainshowers_polartwilight" -> {
                WTextAndIcon("Дождь", R.drawable.rainshowers_polartwilight)
            }
            "rainshowersandthunder_day" -> {
                WTextAndIcon("Дождь с грозой", R.drawable.rainshowersandthunder_day)
            }
            "rainshowersandthunder_night" -> {
                WTextAndIcon("Дождь с грозой", R.drawable.rainshowersandthunder_night)
            }
            "rainshowersandthunder_polartwilight" -> {
                WTextAndIcon("Дождь с грозой", R.drawable.rainshowersandthunder_polartwilight)
            }
            "sleet" -> {
                WTextAndIcon("Дождь со снегом", R.drawable.sleet)
            }
            "sleetandthunder" -> {
                WTextAndIcon("Дождь со снегом и грозой", R.drawable.sleetandthunder)
            }
            "sleetshowers_day" -> {
                WTextAndIcon("Дождь со снегом", R.drawable.sleetshowers_day)
            }
            "sleetshowers_night" -> {
                WTextAndIcon("Дождь со снегом", R.drawable.sleetshowers_night)
            }
            "sleetshowers_polartwilight" -> {
                WTextAndIcon("Дождь со снегом", R.drawable.sleetshowers_polartwilight)
            }
            "sleetshowersandthunder_day" -> {
                WTextAndIcon("Дождь со снегом и грозой", R.drawable.sleetshowersandthunder_day)
            }
            "sleetshowersandthunder_night" -> {
                WTextAndIcon("Дождь со снегом и грозой", R.drawable.sleetshowersandthunder_night)
            }
            "sleetshowersandthunder_polartwilight" -> {
                WTextAndIcon(
                    "Дождь со снегом и грозой",
                    R.drawable.sleetshowersandthunder_polartwilight
                )
            }
            "snow" -> {
                WTextAndIcon("Снег", R.drawable.snow)
            }
            "snowandthunder" -> {
                WTextAndIcon("Снег с грозой", R.drawable.snowandthunder)
            }
            "snowshowers_day" -> {
                WTextAndIcon("Снег", R.drawable.snowshowers_day)
            }
            "snowshowers_night" -> {
                WTextAndIcon("Снег", R.drawable.snowshowers_night)
            }
            "snowshowers_polartwilight" -> {
                WTextAndIcon("Снег", R.drawable.snowshowers_polartwilight)
            }
            "snowshowersandthunder_day" -> {
                WTextAndIcon("Снег с грозой", R.drawable.snowshowersandthunder_day)
            }
            "snowshowersandthunder_night" -> {
                WTextAndIcon("Снег с грозой", R.drawable.snowshowersandthunder_night)
            }
            "snowshowersandthunder_polartwilight" -> {
                WTextAndIcon("Снег с грозой", R.drawable.snowshowersandthunder_polartwilight)
            }
            else -> WTextAndIcon(code, R.drawable.weatherblank)
        }

    }
}